# Week 6

Work continues on rooms this week. Most of my meagre time used on the  has been spent on researching proper implementation of the BSP. I've added a Rooms-class to replace an ArrayList<Room> that I would have otherwise employed in the project.  

## Binary Space Partitioning Algorithm Trouble

After a lot of trial and error with the Rooms-class I just could not make it work, and decided to place a hopefully temporary ArrayList to save my rooms.  I understand what I'm supposed to do, but I can't just implement this algorithm. The Room system which saved rectangular shapes which would later be added to the level as rooms had to be scrapped since I didn't really understand how to progress from it into something that I could use.  

Now I'm attempting to write the bsp-algorithm using method which cuts the level with lines, and after I've added enough lines with BSP, I should be able to add a single room between every resulting space between the lines.  

At the moment I'm trying to write the workings of all BSP-methods as pseudocode on paper to better understand what I'm supposed to do. At least it seems I won't be needing the ArrayList.  

What I have planned in pseudocode at the moment is a general recursive method which receives the X- and Y-sizes of the levelmap, and then generates a similar sized boolean truthmap, which contains a boolean for each tile if it is a pathable tile or not, as well as two classes which are used to cut the boolean matrix, an ancillary class that is supposed to add small corridors between the resulting future rooms, and a very primitive idea how to generate the actual rooms inside the binary space partitioned level.  

If it seems that I can't finish this before the demonstration by myself, I am going to resort to seeing how people have actually implemented this algorithm in roguelikes before just to get started. I kinda started the project wishing to reinvent the algorithms by myself by reading about them, since my project doesn't really use any complex sorting or pathfinding algorithms.  

Unfortunately, eventhough I've spent around 10 hours on the project this week, I really haven't focused on any other features besides this now, since completing BSP was so central to the project.

## Next Week

1. Get BSP fixed by any means.
2. Fix documentation.
