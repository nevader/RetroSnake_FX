# SnakeFX 🐍

A modern implementation of the classic Snake game built with JavaFX, featuring a sleek UI, multiple game modes, and persistent high scores.

![Game Demo](./screenshots/gameplay.gif)
*(You'll need to replace this with your actual GIF path if you create one, e.g., in a `screenshots` folder)*

## ✨ Features

- **Classic Snake Gameplay** with smooth controls and animations
- **Customizable Settings**
    - Adjustable map size
    - Variable snake speed
- **Special Food Types**
    - 🟢 Size-up food (increases snake length)
    - 🔴 Size-down food (decreases snake length)
- **High Score System** with persistent storage (`highscore.txt`)
- **Real-time Statistics**
    - Timer display
    - Dynamic score calculation based on time and food collected
- **Intuitive UI** with custom graphics and hover effects
- **Keyboard Controls** for quick navigation and game actions

## 📸 Screenshots

*(Create a `screenshots` folder in your repository and add your game images. Update paths accordingly.)*

<table>
  <tr>
    <td><img src="./screenshots/main-menu.png" alt="Main Menu" width="400"/></td>
    <td><img src="./screenshots/gameplay.png" alt="Gameplay" width="400"/></td>
  </tr>
  <tr>
    <td><img src="./screenshots/game-over.png" alt="Game Over" width="400"/></td>
    <td><img src="./screenshots/high-scores.png" alt="High Scores" width="400"/></td>
  </tr>
</table>

## 🎮 Controls

| Key         | Action             |
| ----------- | ------------------ |
| ⬆️⬇️⬅️➡️     | Move snake         |
| R           | Restart current game |
| Shift + R   | Return to main menu|

## 🚀 Getting Started

### Prerequisites

- Java 21 or higher (as specified in your `pom.xml`)
- Apache Maven

### Installation & Running

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/yourusername/SnakeFX.git](https://github.com/yourusername/SnakeFX.git)
    ```
    *(Replace `yourusername/SnakeFX.git` with your actual GitHub repository URL)*
2.  **Navigate to the project directory:**
    ```bash
    cd SnakeFX
    ```
3.  **Build the project:**
    Maven will compile the code and download necessary dependencies.
    ```bash
    mvn clean install
    ```
4.  **Run the game:**
    Use the JavaFX Maven plugin.
    ```bash
    mvn javafx:run
    ```
    The main class is `pl.s24825.Launcher`.

    Alternatively, after building with `mvn clean package` (if your `pom.xml` is configured to build an executable JAR):
    ```bash
    java -jar target/Snake_FX-1.0-SNAPSHOT.jar
    ```
    *(Note: The default `javafx-maven-plugin` configuration doesn't create a runnable fat JAR by default for JavaFX 11+ modular applications without additional configuration like using the `maven-shade-plugin` or `jlink`.)*

## 🛠️ Built With

- **JavaFX 21:** UI framework
- **Maven:** Dependency management and build tool
- **FXML:** For defining UI layouts
- **CSS:** For styling the UI

## 📁 Project Structure

A brief overview of the project structure:


Snake_FX/
├── pom.xml               # Maven Project Object Model
├── highscore.txt         # Stores high scores (created at runtime in project root)
└── src/
└── main/
├── java/pl/s24825/
│   ├── controller/     # Contains controller classes for FXML files
│   ├── model/          # Contains game logic (Engine.java, Snake.java, Food.java)
│   ├── view/           # Contains ViewFactory.java and Styles.java enum
│   ├── Launcher.java   # Main application entry point
│   └── Settings.java   # Handles game settings (size, speed)
└── resources/
└── view/
├── assets/     # Game graphics (images for snake, food, UI elements)
├── css/        # CSS stylesheets (Big.css, Medium.css, Small.css)
└── *.fxml      # FXML layout files (MainMenu.fxml, GameWindow.fxml, etc.)


## 🎯 Game Features Explained

### Dynamic Scoring
- Score increases based on the value of the food eaten.
- The score for each food item is multiplied by a factor related to the time passed (e.g., `totalScore += (fruitScore * timePassed/1000)`).

### Food Types
- **Green Apple (Size-Up Food) 🟢:** Increases the snake's length.
- **Red Apple (Size-Down Food) 🔴:** Decreases the snake's length (minimum length is maintained).

### High Score System
- Scores are saved automatically when submitted after a game.
- Persistent storage in `highscore.txt` located in the project's root directory.
- A leaderboard displays top players and their scores, sorted with the highest score first.
- If no high scores exist, sample data is populated and saved.

### 🔧 Configuration
Default game settings can be modified via the "New Game" screen:
- **Map Size:** Default is 12x12, customizable by the player.
- **Snake Speed:** Default is 120ms update interval, customizable by the player.

## 🤝 Contributing

Contributions are welcome! Feel free to fork this project, make improvements, and submit pull requests. If you encounter any bugs or have ideas for new features, please open an issue on GitHub.

## 📝 License

This project is licensed under the **MIT License**. See the `LICENSE` file for details.

*(You'll need to create a `LICENSE` file in your repository with the MIT License text if you choose this license.)*

## 👨‍💻 Author

- **[Your Name]**
- GitHub: [@yourusername](https://github.com/yourusername)

*(Replace with your actual name and GitHub profile URL)*

## 🙏 Acknowledgments

- Inspired by the classic Nokia Snake game.
- Built as a learning project to practice Java, JavaFX, and Maven.

---
⭐ If you find this project interesting or helpful, please consider giving it a star on GitHub!
