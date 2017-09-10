# lol-caller

![image](https://user-images.githubusercontent.com/12420351/30251103-2cf7be72-9662-11e7-8cfc-dc99ff2637a8.png)

LoL-Caller is a Java project that is used to call lanes while in-game chat in league of legends.
The reason behind this project is to make sure that you get the specific lane you want to play in blind games.


## Requirements
* [Java runtime environment 7 or higher.](http://www.oracle.com/technetwork/java/javase/downloads/java-se-jre-7-download-432155.html)
* at least 500 MB of ram (the project has memory leak that i don't know how to fix).
* a good processing power during calling lane.


## Installation
First, make sure you have [Java runtime environment 7 or higher.](http://www.oracle.com/technetwork/java/javase/downloads/java-se-jre-7-download-432155.html) installed in your system. Then  Download the .jar file in the releases.

## Usage

1. Open the jar file
2. Open league of legends and create a game (join a lobby)
3. You will see the chat box at the bottom left where you can chat with people who are in the same room
4. Before queueing in, go the lol caller and make sure that you can see league client in the background
5. Press set location button in the program and the cursor will change to crosshair
6. Now you will need to make 3 clicks at your league client, 2 of them is to define an area to read the text from, the last
click will be where the text box (the place where you type in) is.
![clicks](https://user-images.githubusercontent.com/12420351/30251082-c448a6fc-9661-11e7-988a-09554a440c22.png)
7. Once you finish the clicks you will need to select a lane from the radio buttons (top,jungle,etc..)
8. Select how many times you want to write the lane you want
9. press Call !!
10. queue in and enjoy your game.


### How does it work ?
The user chooses the location where the chatbox will be. when calling, the program will create a new thread
that keeps reading all the strings from the chatbox using **sikuli** lib OCR capabilities until it finds a sub string "joined the lobby"
once it does, then the mouse will move the place where the textbox is and it will write the lane.

### Disclaimer:
This project is a personal-spaghetti code that I never intended to put it as a public project. 
