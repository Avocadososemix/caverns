# Week 3

This week started with adding player movement to the build. The biggest problem encountered was with the Scanner-method that is included in the JDK-8, as it didn't work with gradle without adding a line to the build.gradle file. Later I implemented walls and other obstacles blocking player movement. These tasks took around 2 hours of work on seperate days. I also spent some time thinking on how to get rid of the arraylists that I employ in the project currently.

One of the core algorithms that build the randomly generated level was also added. The random walk (also known as the drunken walk) algorithm is used to create an erratic pattern that criss-crosses the level map. Certains constraints were also added to the algorithm. It will use the proportional size of the level to choose its walking direction instead of selecting it purely randomly. This way caverns will use more of the space provided to them on the map. Running the algorithm several times on the same map will generate more exits.

In the future, I will refine the algorithm.
