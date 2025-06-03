# 🐍 RetroSnake FX

A modern implementation of the classic Snake game built with JavaFX, featuring customizable gameplay settings, special food types, and a persistent high score system. Developed as part of the Graphical User Interface (GUI) course at PJATK.

![java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![javafx](https://img.shields.io/badge/JavaFX-007396?style=for-the-badge&logo=java&logoColor=white)
![maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

![Game Demo](game_play.gif)

## 🎮 Game Features

### Core Gameplay

- **Classic Snake mechanics** with smooth movement and controls
- **Dynamic scoring system** - Score multiplier based on time elapsed
- **Customizable difficulty**:
    - Adjustable map size
    - Variable snake speed
- **Special food types**:
    - 🟢 **Green Apple** - Increases snake length
    - 🔴 **Red Apple** - Decreases snake length (minimum length maintained)

### User Interface

- **Sleek retro design** with custom graphics
- **Real-time statistics** - Timer and score display
- **Intuitive menu system** with hover effects
- **Responsive controls** - Keyboard-based gameplay

## 🎯 Controls

|Key|Action|
|---|---|
|⬆️⬇️⬅️➡️|Move snake|
|**R**|Restart current game|
|**Shift + R**|Return to main menu|

## 🚀 Getting Started

### Prerequisites

- Java 21 or higher
- Apache Maven

### Installation

1. Clone the repository:

bash

```bash
git clone https://github.com/yourusername/retro-snake-fx.git
cd retro-snake-fx
```

2. Build the project:

bash

```bash
mvn clean install
```

3. Run the game:

bash

```bash
mvn javafx:run
```

## 🏗️ Architecture

The project follows the **MVC (Model-View-Controller)** pattern:

### Model

- `Engine.java` - Core game logic and state management
- `Snake.java` - Snake entity with movement mechanics
- `Food.java` - Food generation and type management
- `Settings.java` - Game configuration

### View

- `ViewFactory.java` - Window management and styling
- FXML layouts for each screen
- Custom CSS stylesheets
- Game assets (snake, food, UI elements)

### Controller

- `BaseController.java` - Abstract controller base
- `GameWindowController.java` - Game screen logic
- `MainMenuController.java` - Menu navigation
- `NewGameController.java` - Game configuration
- `HighScoresController.java` - Leaderboard display

## 📊 High Score System

- **Persistent storage** - Scores saved to `highscore.txt`
- **Smart ranking algorithm**:
    
    ```
    Score = (Food Points × Time Factor) + Board Size Bonus
    ```
    
- **Automatic leaderboard** - Sorted by highest score
- **Name entry** - Players can save their achievements

## 🎨 Technical Implementation

### Key Technologies

- **JavaFX 21** - Modern UI framework
- **FXML** - Declarative UI layouts
- **CSS Styling** - Custom game aesthetics
- **Maven** - Dependency management

### Design Patterns

- **MVC Architecture** - Clean separation of concerns
- **Factory Pattern** - Window creation and management
- **Observer Pattern** - Game state updates

### Performance Features

- **Separate timer thread** - Non-blocking UI
- **Efficient rendering** - Canvas-based game board
- **Optimized collision detection**

## 📁 Project Structure

```
RetroSnake_FX/
├── src/main/java/pl/nevader/
│   ├── controller/       # Game controllers
│   ├── model/           # Game logic
│   ├── view/            # UI management
│   └── Launcher.java    # Application entry
├── src/main/resources/
│   └── view/
│       ├── assets/      # Images and graphics
│       ├── css/         # Stylesheets
│       └── *.fxml       # UI layouts
├── highscore.txt        # Score persistence
└── pom.xml             # Maven configuration
```

## 🧪 Testing Features

The game includes comprehensive testing scenarios:

- Boundary collision detection
- Self-collision handling
- Food spawning validation
- Score calculation accuracy
- High score persistence

## 📚 Academic Context

This project was developed as part of the Graphical User Interface (GUI) course at the Polish-Japanese Academy of Information Technology (PJATK) during the 2022/2023 academic year.

### Learning Objectives

- JavaFX application development
- MVC architectural pattern
- Event-driven programming
- Multi-threading in GUI applications
- File I/O for data persistence

### Project Requirements Met

- ✅ Snake movement and control mechanics
- ✅ Food generation and consumption
- ✅ Timer implementation in separate thread
- ✅ Customizable board size with validation
- ✅ Scalable game window with scroll bars
- ✅ Player name entry and score saving
- ✅ Persistent high score storage
- ✅ MVC pattern implementation
- ✅ Exception handling

## 🤝 Contributing

This is an academic project. Feel free to fork and learn from the implementation, but please create your own version if you're working on a similar assignment.

## ⚠️ Disclaimer

Built without WYSIWYG tools (Scene Builder, Window Builder) as per academic requirements. All UI elements are hand-coded.

## 📄 License

This project is part of academic coursework. Please refer to your institution's academic integrity policies.

## 👤 Author

**Krzysztof Przybysz**  
Student ID: s24825  
Course: Graphical User Interface (GUI)

---

_Note: This implementation meets all project requirements including special food types, time-based scoring, and proper MVC architecture._
