# 🎮 Minecraft Reverse Shell Plugin (Educational) 🚨

## 🌟 Overview
This **Minecraft plugin** is a **learning tool** 📚 designed to show why you should **never** install random plugins from untrusted sources! 😱 It demonstrates a malicious behavior by:
- 📂 Creating its own folder in the server's `plugins` directory.
- 📥 Downloading a reverse shell executable (`Reverse_Shell.jar`) from [ivan-sincek/java-reverse-tcp](https://github.com/ivan-sincek/java-reverse-tcp/), created by [ivan-sincek](https://github.com/ivan-sincek).
- 🔗 Using the downloaded JAR to establish a reverse shell to a hardcoded IP and port, giving access to:
  - 🖥️ **Windows**: Spawns a `cmd.exe` shell.
  - 🐧 **Linux**: Spawns a `sh` shell.

> **⚠️ WARNING**: This is a **proof-of-concept** for **educational use only**. **DO NOT** use this on any server you don’t own or have explicit permission to test. Misuse could violate laws, terms of service, or ethical guidelines! 🚫

## 🎯 Purpose
This project is here to **teach** Minecraft server admins, developers, and players about the **dangers** of unverified plugins. 🕵️‍♂️ Malicious plugins can hack your server, steal data, or cause chaos! 😈 Use this in a **safe, controlled environment** to learn how to spot and stop bad plugins.

## ✨ Features
- 📂 Creates a custom folder in the `plugins` directory to store downloaded files.
- 🌐 Downloads `Reverse_Shell.jar` from [ivan-sincek/java-reverse-tcp](https://github.com/ivan-sincek/java-reverse-tcp/).
- 🔗 Uses the downloaded JAR to establish a reverse shell to a hardcoded IP and port.
- 🛠️ Detects the server’s OS and launches the appropriate shell (`cmd.exe` or `sh`).
- 📦 Lightweight and easy-to-analyze code for learning.

## 🚀 How to Use
Follow these steps to safely test the plugin in a **controlled environment**:

1. **Clone the Repo** 📂:
   ```bash
   git clone https://github.com/ShorterKing/Minecraft-Server-RCE-Plugin.git
   ```
2. **Build the Plugin** 🔨:
   - Set up a Java environment with Minecraft server dependencies (e.g., Spigot/Paper API).
   - Compile using Maven or Gradle. 🛠️
3. **Set Up a Safe Test Environment** 🧪:
   - Use a **sandboxed** or **virtualized** server (e.g., Docker, VM) to avoid risks.
   - Edit the plugin’s source code to set the IP (e.g., `127.0.0.1`) and port (e.g., `4444`) to a listener you control.
   - Start a listener with:
     ```bash
     nc -lvnp 4444
     ```
4. **Deploy the Plugin** 📥:
   - Drop the compiled `.jar` into your test server’s `plugins` folder.
   - Start the server. The plugin will:
     - Create a folder (e.g., `plugins/ReverseShellPlugin/`) to store files.
     - Download `Reverse_Shell.jar` from the specified GitHub URL.
     - Use the downloaded JAR to connect to your listener, spawning a shell. 🎉
5. **Learn and Analyze** 📖:
   - Study the code to see how the folder creation, download, and reverse shell work.
   - Use this to practice detecting malicious plugins. 🕵️‍♀️

## 🛑 Security Warning
- 🚨 **DO NOT** run this plugin on a live server or any system you don’t fully control.
- 🙅‍♂️ **DO NOT** share the compiled plugin unless the recipient understands its risks.
- 🔒 Only use this in a **safe, isolated environment** for learning purposes.
- ⚠️ The plugin downloads external code (`Reverse_Shell.jar`), which is a common tactic used by malicious plugins. **Always audit plugins** for suspicious behavior like file downloads or network connections!

## 🧑‍💻 Example Test Setup
1. Start a listener on your machine:
   ```bash
   nc -lvnp 4444
   ```
2. Update the plugin’s IP and port to match your listener (e.g., `127.0.0.1:4444`).
3. Build and deploy the plugin on a **test** Minecraft server.
4. When the server starts, the plugin will:
   - Create a folder in `plugins/`.
   - Download `Reverse_Shell.jar` from the GitHub URL.
   - Connect to your listener, spawning a shell. 🖥️

## 🙌 Credits
- A huge **thank you** to [ivan-sincek](https://github.com/ivan-sincek) for creating the `Reverse_Shell.jar` used in this project, available at [ivan-sincek/java-reverse-tcp](https://github.com/ivan-sincek/java-reverse-tcp). Their work made this educational demonstration possible! 🌟

## 🤝 Contributing
This is an **educational project**, but if you have ideas to make the documentation or learning experience better, we’d love to hear them! 💡
1. Fork the repo. 🍴
2. Submit a pull request with your changes. 📬
3. Keep contributions focused on **education** and avoid adding harmful features.

## ⚖️ Disclaimer
This plugin is for **educational use only**. The author is not responsible for any misuse, damage, or legal issues caused by this plugin. Always get **permission** before testing security tools! 🔐

## 📜 License
Licensed under the MIT License. See the [LICENSE](LICENSE) file for details. 📄

## 💬 Stay Safe!
Protect your Minecraft server by **vetting all plugins** and learning from projects like this. Happy learning, and stay secure! 🛡️
