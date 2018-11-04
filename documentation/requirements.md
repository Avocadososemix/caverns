# Requirements

The program will need randomly generated caverns, with impassable and passable tiles, which create a layout that can be traversed by a player character controlled by the player. The caverns will be represented by ascii characters which denote the terrain type of different parts of the caverns.  

### Challenges

The problem that we face is how to generate random caverns that are pleasing to traverse for a player character, and have some variance in their layout. The player may not move through tiles which are unpathable. In the generated caverns, there should always be a path for the player to progress through to new areas of the caverns.  
  
The Player character is moved using key-strokes, which will require a listener to be built into the GUI of the program. Player keystrokes are translated into directional (NSWE) movement on the cavern map.

### Algorithms & Time and Space Complexity

In order to to create random caverns/dungeons, the program will use the following algorithms:  
* **Drunken walk** - to create randomly sprawling geometry  
* **Binary space** partitioning (BSP tree)- to create rooms  


The time and memory requirements from these algorithms should constrained in a way not make using the program cumbersome. It is hard to specify any Big-O notation that would be specific to these algorithms before they are implemented.


### Map Data Storage

This program will not necessarily store any data long term in databases, as all maps will be generated randomly on a need to have basis.


### Links

[Binary Space Partition on Wikipedia](https://en.wikipedia.org/wiki/Binary_space_partitioning)  
[BSP use in roguelikes](http://www.roguebasin.com/index.php?title=Basic_BSP_Dungeon_generation)  

[Drunked Walk on Wikipedia](https://en.wikipedia.org/wiki/Random_walk)  
[Drunked Walk](http://www.roguebasin.com/index.php?title=Random_Walk_Cave_Generation)

