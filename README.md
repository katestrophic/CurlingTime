# Curling Time
------------------------

## General Overview
### Description
- An offline timekeeping program for competitive curling that can display
  clocks and record in-game events (timeouts, coach interactions, notes)
- having a more intuitive UI for timekeepers
- creating comprehensive record (JSON) of events for archive
- access to players, teams, coaches, and officials

### Project Environmental Architecture
Document the current state of the file and folder organization and purpose

This project uses a single Java module (katestrophic.curlingtime) where the
internal structure is enforced via packages rather than multiple Java modules

### Documentation Conventions
- File trees: are displayed with text
- File trees: use these components: `│ `, `├── `, `└── `
- files: `.` followed by file type (__.md)
- folders: name of folder followed by `/` (___/)
- indents are 4-spaces long
------------------------



## Feature States
### Gameplay States
| Game Actions  |
|---------------|
| Pre-Game      |
| During End    |
| During Turn   |
| During Shot   |
| Between Ends  |
| Game Finished |

| Time States |
|-------------|
| Running     |
| Stopped     |
| Paused      |
| Timeout     |
| Interaction |

Other Actions:
- extra end: add an end and set timer or add time depending on settings
- timeout: stop timer and start a timeout timer, limited number of timeouts, time is noted, custom length of timeout
- coach interaction: timer keeps running but interaction is flagged, time is noted, limited number of interactions
- official timeout: timer is paused until manually resolved, time is noted, timekeeper is prompted to write a note to document the reason
- note: create a note at the current timestamp
- warning: create a team warning by official, note
- owed time: display to teams an amount of owed time until resolved (time owed is made up), a countdown timer giving a team time owed

### Database Model (Entities)
- User: login/account (admin, coach, player, viewer)
- Player: real person who plays (may or may not be a user, position, club)
- Team: team info and roster
- Game: a match between two teams
- Club: a curling club (province, city, country)
- Spiel: a curling tournament
------------------------



## Project Development Plan
### Stage 0: Project Foundation
**Goal**: establish the project's core structure and development plan

### Stage 1: Setup Page
**Goal**: establish the setup page and functionality

### Stage 2: Timer Environment Setup
**Goal**: create the supporting functionality

### Stage 3: Timer Interface For Timekeeper
**Goal**: UI within the Features/UI layer

### Stage 4: Clock Display For Players
**Goal**: display to a secondary display and update timer with respect to timekeeper actions

### Stage 5: Event Recorder
**Goal**: integrate the event logging functionality



## Project Functionality
### Gameplay timekeeper workflow
1. launch app
2. load default game config
3. setup game ui
4. user customizes parameters and clicks submit
5. opens timekeeper dashboard
    - can edit settings
    - can edit teams, players, etc.
6. game starts
7. curling timekeeping
    - can also add and edit clocks
    - can edit game settings in a different view
    - on timekeeper's side it displays a history of events at the bottom
8. game finish
9. prompts timekeeper to enter name, signature, and logs date
10. on submit, it creates a JSON game file that is displayed
11. click edit to edit or save to commit it

### Feature functions:
- Launcher: entry point, calls Application.launch()
- Loader: loads resources, managers, default settings
- CurlingTimeApplication

- app: application loader, entry, and orchestration
- core: core logic engine
- features: UI functionality
- factories: create entities from data
- adaptors: read/write external data sources
- managers: resource management
- builders: build configurations
- utils: general helpers and validators
- entities: data models


## Project Architecture
### Top-Level Hierarchy
```
CurlingTime/
├── .gitignore
├── build.gradle.kts
├── settings.gradle.kts
├── README.md
│
└── src/
    ├── main/
    │   ├── java/                                  <- Project Source
    │   │   ├── module-info.java
    │   │   └── katestrophic/                      <- "group"
    │   │       └── curlingtime/                   <- Project Packages
    │   └── resources/katestrophic/curlingtime/    <- Project Resources
    │       ├── values/                            <- *.properties files
    │       └── views/                             <- All .fxml files
    └── test/                                      <- Test Folder
        ├── tjava/
        └── tresources/
```

### Project Package Hierarchy
```
curlingtime/
├── Launcher.java                                     < entry point
│
├── app/
│   ├── CurlingTimeApp.java                           < application
│   └── Loader.java                                   < interface
│
├── 
│   ├──
│   └──
│
├──
│
└──
```

### Resource Folder Hierarchy
```
curlingtime/
├── values/                                        <- *.properties files
└── views/                                         <- *.fxml files
    ├── clockdisplay.fxml
    ├── dashboard.fxml
    ├── settings.fxml
    └── setup.fxml
