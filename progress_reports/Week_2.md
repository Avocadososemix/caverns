# Week 2

The week started with massive problems, I had never really made a gradle-project of my own, and could not figure out how to make the packages and gradle.build file work as I wanted. What should have been a relatively simple thing turned into a big time sink.

After the initial troubles had passed, programming could start in earnest. Initially a quick mock-up of the final map data-structure was made using a Level-object, which had embedded tile object for each tile available on the map. Tiles are represented using ascii characters. Different tiles can be given different properties. A fast and dirty way to look at the prelimanary version of the map was added as well.

Improved printing out map. Presenting characters on map has been difficult, ran into some trouble with arrays, which was fixed in the end. The program can now show the map as well as print the characer on the map.

So far, this week around 10-11 hours were spent on the program.


## Problem with adding tests

Hardly any of the current classses are in any way final. Sadly, I ran out of time to create tests for the map printing, which is the most finished feature in the program. I wish I had spent more time on the project this week, but work, sickness and other coursework have limited the time that I've been able to spend on this.

## Javadoc

Most of the methods that were not getters or setters have received javadocs. For some reason, netbeans has trouble when clicking the `show javadoc` option when selecting a method with a javadoc. This needs to be looked into later.


## Goals for Next Week

1. Refine the map, add a proper swing/javafx-interface for it.
2. Add character movement
3. Add random cavern generation
4. Add tests to the project
