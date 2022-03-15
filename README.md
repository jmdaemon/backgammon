# Backgammon

Backgammon is a board game where the objective of the game
is to bear off all your pieces off the board before the other player does.

There are twenty four narrow triangles called points on a board.
The board is separated into two quadrants called the Outer and Home boards.

Each player has 15 checkers.

- 2 on the outermost or 24th point
- 5 on the 13th point
- 3 on on the 8th point
- 5 on the 6th point

Players move in one direction, either clockwise or counter clockwise for the opponent around the board.
Both players roll dice to determine who plays first.
The player with the higher roll goes first.

Players roll dice which correspond to how far they are able to move
their pieces on the board (i.e a roll of 5 and 4 allows a player to move
a piece 5 up and a different piece 4 up or a single piece 9 points up on the board).

## Requirements

- Gradle
- JUnit Jupiter
- Java 17

## Building From Source

To build the project from source run:
``` bash
gradle compileJava
```

To run the main project application type:
``` bash
gradle run
```

To run the unit tests:
``` bash
gradle test
```

## Editor Integration

### Eclipse

To configure this project in Eclipse:
1. Create a fork of the project on GitHub
2. Copy the remote url of the fork
3. Add the project in Eclipse (Import -> Git -> Projects from Git (with smart import) -> Clone URI)
4. Paste the url of your remote fork and fill in the necessary details.

You should now be able to build the project by clicking Run or by using the F9 shortcut.

To add JUnit 5 (Junit Jupiter) to the class path in Eclipse:
1. Click on the root project folder
2. Navigate to -> Properties -> Java Build Path -> Libraries
3. Click on Classpath
4. Click Add Library... -> JUnit -> Set JUnit library version to JUnit 5 -> Finish

If the `test` task is not shown for gradle in the run configurations, you can make it by:
1. Click on Run -> Run Configurations -> Gradle Test -> Add
2. Change the taskname from `task` to `test`
3. Set the Working Directory to the current project root directory

You should now be able to run the unit tests.

### IntelliJ IDEA

To configure this project in IntelliJ IDEA:

1. Create a fork of the project on GitHub
2. Copy the remote url of the fork
3. Click on Get from VCS
4. Paste the url of the remote fork
IntelliJ should now be able to detect the project dependencies and automatically install and build the project.

To configure unit tests in IntelliJ IDEA:

1. Click on Configurations -> Edit Configurations
2. Click on the '+' sign (Add New Configuration) -> Gradle
3. Give the task an appropriate name (TestApp)
4. Write `test` under `Run` in the Tasks and arguments textbox.

You should be able to run the unit tests configured with Gradle.
