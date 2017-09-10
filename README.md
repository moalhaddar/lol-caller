# lol-caller
DISCLAIMER:
//this project is a personal-spaghetti code that i never intended to put it as a public project//

LoL-Caller is a Java project that is used to call lanes while in-game chat in league of legends.
The reason behind this project is to make sure that you get the specific lane you want to play in blind games.

Requirements to use:
Java run-time enviroment 7 or higher.
at least 500 MB of ram (the project has memory leak that i don't know how to fix).
a good processing power during calling lane.
Seriously, use this project only if your system is capable of handling it, otherwise it will just lag.

How to use:
1. Download the .jar file in the repo
2. Open the jar file
3. Open league of legends and create a game (join a lobby)
4. You will see the chat box at the bottom left where you can chat with people who are in the same room
5. Before queueing in, go the lol caller and make sure that you can see league client in the background
6. Press set location button in the program and the cursor will change to crosshair
7. Now you will need to make 3 clicks at your league client, 2 of them is to define an area to read the  text from, the last
click will be where the text box (the place where you type in) is.
look at the picture (clicks.png) at the repo to know where to click the first,second and the third time.
8. Once you finish the clicks you will need to select a lane from the radio buttons (top,jungle,etc..)
9. Select how many times you want to write the lane you want
10. press Call !!
11. queue in and enjoy your game.


How does it work ?
the user chooses the location where the chatbox will be. when calling, the program will create a new thread
that keeps reading all the strings from the chatbox using sikuli lib OCR capabilities until it finds a sub string "joined the lobby"
once it does, then the mouse will move the place where the textbox is and it will write the lane.
