# Design Document

## General Design

The caverns-map generator has been built with the MVC-model in mind, and thus the program logic has been divided into several parts with different purposes. At this very moment the program file layout is in slight flux, as the GUI was only recently added in working condition to the program.  

The caverns-map generator consists of the classes  
* Main
* Level
* Character
* Coordinates
* Tile  

as well as the GUI controller class GUIController and the GUI.fxml-file, which contains xml instructions on how to build the javafx layout of the program. These are the View and Controller parts of the program.

---

The Main-class contains the logic that starts the program.  

Character contains positional information about the player character, but this class could be extended to allow the creation of other characters on the map.  

Coordinates is an object-oriented solution to saving locations of objects, such as characters. It provides an easy way to give or return both X and Y coordinates of an object from any method.  

Tile contains information about a map tile on the level. It can contain the name of the tile, as well as what symbol represents the tile and if the tile can be passes through by characters.  

The Level class contains most of the logic that happens on the level, relating to movement, printing the level, and polling different level elements for data.  

All of the above will be integrated to the controller to allow GUI integration of the program logic.
