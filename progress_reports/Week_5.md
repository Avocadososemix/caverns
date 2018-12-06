# Week 5

I started this week by fixing the mess that last weeks left for me. I had reached a state where everything worked, but was implemented at a threadbares level, so the last few hours were spent moving all the program logic to work now inside the working GUI. Then the addition of some optimization, removal of unnecessary code and imports. New javadoc where it was necessary. Testing the currently working GUI, and adding a feature for the GUI to show messages to the user concerning his/her actions on the level.  

The next logical step would be to add the binary space partitioning algorithm to the program and implement its use on map generation.

At this point I also added Travis Continuous Integration Testing, and a link to the project Travis to the main READ.ME.

## Binary Space Partitioning algorithm

Binary Space Partitioning (BSP), an algorithm that has been used in games since the first DOOM, finds it's place in several games related projects. So far, I've had a lot of trouble implementing binary space partitioning, eventhough progress is steady, I still have to make the function recursive. Hopefully integrating the function to the rest of the program is trivial after completing the algorithm. Most of the week I haven't been able to push my work, in order to keep the version on git functional. I should have moved what I was working on to a new branch on github.  

[BSP on wikipedia](https://en.wikipedia.org/wiki/Binary_space_partitioning)  

The BSP-algorithm needs to take the whole map, and make an intelligent horizontal or vertical cut in the level, creating two pieces of the level which together make the whole map. After the cut, a new cut is made to both halves in a direction perpendicular to the first cut that separated both pieces of the level from each other. This process in then repeated until we have created a lattice of different sized *boxes* that are all just parts of the larger original map.  

After this, inside our smaller boxes we create rooms that occupy part of the fragments made by the BSP-algorithm. These will generally be rectangles that fit inside our level fragments. Afterwards corridors need to be created to join our new rooms to the caverns and other rooms. Ideally the rooms can be found along the caverns after some tweaking.

## Goals for Next Week

1. Finally finish the BSP-algorithm
2. Write tests for everything
3. Polish code
4. Implement changes from issues
