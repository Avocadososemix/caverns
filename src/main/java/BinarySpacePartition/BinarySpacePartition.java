package BinarySpacePartition;

import GameLogic.Tile;
import GameLogic.Coordinates;
import GameLogic.Level;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lkaranko
 */
public class BinarySpacePartition {

    private int levelWidth, levelHeigth;
    private final int timesSplit;
    private final int BSP_MinSplit, BSP_MaxSplit;
    private Level level;
    private Room[] dugRooms;

    public BinarySpacePartition(int timesSplit) {
        this.level = level;
        this.timesSplit = timesSplit;
        this.BSP_MinSplit = 30;
        this.BSP_MaxSplit = 70;
    }

    /**
     * This method initializes the process of applying binary space partitioning
     * to the level.
     * @param level
     * @return 
     */
    public Level generateBSP(Level level) {
        this.level = level;
        levelHeigth = level.getSizeY();
        levelWidth = level.getSizeX();
        ArrayList<Room[]> pair = splitLevel();
        //level.printLevel();
        connectRooms(pair);
        System.out.println("....;....;....;....;....;....;");
        return level;
    }

    /**
     * A level is partitioned into smaller and smaller pieces that will all
     * contains rooms. The
     *
     * @return
     */
    public ArrayList<Room[]> splitLevel() {
        System.out.println("Beginning BSP");
        //A list is generated for mapRegions and the whole level is added as a room object.
//        PriorityQueue regionQueue = new PriorityQueue();
//        regionQueue.add(new Room(new Coordinates(0, 0), new Coordinates(level.getSizeX(), level.getSizeY())));
        ArrayList<Room> regions = new ArrayList<>();
        ArrayList<Room[]> regionsPairs = new ArrayList<>();
        Room entireLevel = new Room(new Coordinates(0, 0), new Coordinates(level.getSizeX(), level.getSizeY()));
        System.out.print("Level info: ");
        entireLevel.printInfo();
        regions.add(entireLevel);
        ArrayList<Room> tempList = regions;
        //Map space is divided
        for (int i = 0; i < timesSplit; i++) {
            System.out.println("Generation #" + i + "**********************************");
            //tempList is cleared
            tempList = new ArrayList<>();
            //Selecting last regin in RegionList
            for (Room region : regions) {
                System.out.print(regions.size() + " regions. Region being handled: ");
                region.printInfo();
                //initializing new Rooms
                Room region1, region2;
                //Choose split size randomly
                int split = (int) ThreadLocalRandom.current().nextInt(BSP_MinSplit, BSP_MaxSplit + 1);
                //System.out.println("Split value is " + split);
                //If the split number is odd, split vertically
                if ((i % 2) != 0) {
                    int splitValue = (int) ((region.getWidth() * split) / 100.0);
                    System.out.println("Vertical split ratio is " + splitValue);
                    region1 = new Room(region.getTopLeftCorner(), new Coordinates(splitValue-1, region.getHeigth()));
                    region1.printInfo();
                    region2 = new Room(new Coordinates(region1.x0() + region1.getWidth()+1, region.y0()),
                            new Coordinates(region.getWidth(), region.getHeigth()));
                    region2.printInfo();
                } else {
                    //split horizontally
                    int splitValue = (int) ((region.getHeigth() * split) / 100.0);
                    System.out.println("Horizontal split ratio is " + splitValue);
                    region1 = new Room(region.getTopLeftCorner(), new Coordinates(region.getWidth(), splitValue-1));
                    region1.printInfo();
                    region2 = new Room(new Coordinates(region.x0(), region1.y0() + region1.getHeigth()+1),
                            new Coordinates(region.getWidth(), region.getHeigth()));
                    region2.printInfo();
                }
                tempList.add(region1);
                tempList.add(region2);
                Room[] pair = new Room[]{region1, region2};
                regionsPairs.add(pair);
            }
            System.out.println("regions added " + tempList);
            regions.clear();
            regions.addAll(tempList);
        }
        digRooms(tempList);
        return regionsPairs;
    }

    public void digRooms(ArrayList<Room> rooms) {
        System.out.println("Digging " + rooms.size() + " rooms");
        System.out.println(rooms);
        rooms.forEach((room) -> {
            level.fillSectionWithRooms(room.dig());
            System.out.println("Digging " + room.dig());
                    System.out.println("....;....;....;....;....;....;");
                    level.printLevel();
        });
    }

    public void connectRooms(ArrayList<Room[]> roomPairs) {
        System.out.println("Connecting rooms");
        level.connectRooms(roomPairs);
    }
}
