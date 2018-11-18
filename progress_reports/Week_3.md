# Week 3

This week started with adding player movement to the build. The biggest problem encountered was with the Scanner-method that is included in the JDK-8, as it didn't work with gradle without adding a line to the build.gradle file. Later I implemented walls and other obstacles blocking player movement. These tasks took a few hours of work on seperate days. I also spent some time thinking on how to get rid of the arraylists that I employ in the project currently.

One of the core algorithms that build the randomly generated level was also added. The random walk (also known as the drunken walk) algorithm is used to create an erratic pattern that criss-crosses the level map. Certains constraints were also added to the algorithm. It will use the proportional size of the level to choose its walking direction instead of selecting it purely randomly. This way caverns will use more of the space provided to them on the map. Running the algorithm several times on the same map will generate more exits. In the future, I will refine the algorithm more.

## even more javadoc

I've gone through all the javadoc in the project, and updated all the non-setter/getter methods to have this.

## problems with adding tests again

I've had a lot of trouble with adding tests through gradle. I've tried to implement junit 5 with the new version of gradle, but something is always broken. I will have to consult someone more experienced to fix my gradle file.

## The random walk algorithm

After reading about the random walk algorithm on wikipedia, I implemented a version of the algorithm that suits my needs. It will have to be refined more, but the current implementation works well. The next map generation algorithm to be added is the binary space partitioning algorithm. I hope to make both algorithms work side-by-side to generate room structures in the caverns.

## Goals for Next Week

1. Fix my build.gradle file so I can add tests
2. Fit the current program logic in a JPanel
3. Implement the binary space partitioning algorithm for more interesting caverns/dungeons.
4. If I can fit the program in a JPanel, add map scrolling.
