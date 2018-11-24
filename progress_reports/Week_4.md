# Week 4

This week started with writing the tests that were sorely lacking from my project. I had attempted to use a newer version of jUnit and gradle, that were not cooperating, so I reverted my build.gradle file to an earlier version where I had yet to tamper with it excessively.  

After the tests were done, it was time to start writing the User window for the project. I decided to use JavaFx instead of Swing which I am more familiar with to learn this newer way make GUIs in java. After a grueling task, I could test things in the GUI, it just needed some polish. I began converting my screen printing method into a scrollable format so I could better place the screen inside the GUI main window. Another cause of trouble was the automatic kerning of the text in javafx labels, but luckily it was possible to change the font in the GUIController into a monospaced font. This meant that the symbols presented in the main screen would all use the same amount of space, allowing us to align our level properly and predictably inside the screen window.  

In the end, I used too much time to figure out how to create a GUI using javafx and fxml. I should have taken the shortcut, and used the built in Netbeans swing scene builder, which I was familiar with to prototype the program fast. The UI is not the most important piece of this software, but I gave it an amount of attention that should have been spent writing the binary space partitioning algorithm and iplementing it in map generation.

## Swing experiments

After spending easily over 5 hours on separate days figuring out how to create an UI with javafx, I am soon going to push making the UI work into next weeks sprint. These experiments started with me trying to code the javafx GUI traditionally by hand. After repeated failure, I decided to use the easy route, which is using a javafx scene builder. Netbeans supports one, but unfortunately my version of netbeans (Netbeans with TMC 1.1.12) doesn't from the get go. Attempting to remedy this without reinstalling Netbeans proved difficult, as the scene builder needed to be built from source code for this linux version, in which I didn't succeed at. Then I downloaded the open-source Gluon Scene Builder, to create my .fxml pages for me. After fiddling with this, I realized that I will still have to write a controller that is not the .fxml file, since the controller elements are not included in the .fxml file. After examining several examples online, I am still not able to load the scene with the FXMLLoader method that is used to load the javafx page. For some reason even after donwloading and examining other projects which employ javafx I still keep getting errors. Finally I realized what had been my problem the whole time, I had not placed my GUI.fxml in the resources class, which is required by the FXMLLoader getResource-method. 

## JUnit tests

Spent a long time writing my neglected jUnit tests. This was a great learning experience which I should have focused on earlier. Learning that I can create new input streams for print methods was a good experience, as well using it in a constructive way. Altogether, writing tests took the better part of a long afternoon.

## Goals for Next Week

1. Fix all the features that I was able to "half-implement'
2. Write tests/better javadocs for all the new features and methods.
3. Implement the binary space partitioning algorithm for more interesting caverns/dungeons.
4. Improve GUI, improve code generally

