package BinarySpacePartition;

import GameLogic.Tile;
import GameLogic.Coordinates;
import GameLogic.Level;
import java.util.ArrayList;
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
    private int BSP_MinSplit, BSP_MaxSplit;
    private Level level;
    private Room[] dugRooms;

    public BinarySpacePartition(Level level, int timesSplit) {
        this.level = level;
        this.timesSplit = timesSplit;
        this.BSP_MinSplit = 30;
        this.BSP_MaxSplit = 70;
    }

    public void generateBSP() {
        splitLevel();

    }

    public ArrayList<Room[]> splitLevel() {
        //A list is generated for mapRegions and the whole level is added as a room object.
        ArrayList<Room> regions = new ArrayList<>();
        ArrayList<Room[]> regionsPairs = new ArrayList<>();
        regions.add(new Room(new Coordinates(0, 0), new Coordinates(level.getSizeX(), level.getSizeY())));
        ArrayList<Room> tempList = regions;
        //Map space is divided
        for (int i = 0; i < timesSplit; i++) {
            //tempList is cleared
            tempList = new ArrayList<>();
            //Selecting last regin in RegionList
            for (Room region : regions) {
                //initializing new Rooms
                Room region1, region2;
                //Choose split size randomly
                int split = (int) ThreadLocalRandom.current().nextInt(BSP_MinSplit, BSP_MaxSplit + 1);
                //If the split number is odd, split vertically
                if ((split % 2) != 2) {
                    int splitValue = levelWidth * split;
                    region1 = new Room(region.getTopLeftCorner(), new Coordinates(splitValue, region.getHeigth()));
                    region2 = new Room(new Coordinates(region1.x0() + region1.getWidth(), region.y0()),
                            new Coordinates(region.getWidth() - splitValue, region.getHeigth()));
                } else {
                    //split horizontally
                    int splitValue = levelHeigth * split;
                    region1 = new Room(region.getTopLeftCorner(), new Coordinates(region.getWidth(), splitValue));
                    region2 = new Room(new Coordinates(region.x0(), region1.y0() + region1.getHeigth()),
                            new Coordinates(region.getWidth(), region.getHeigth() - splitValue));
                }
                tempList.add(region1);
                tempList.add(region2);
                Room[] pair = new Room[]{region1, region2};
                regionsPairs.add(pair);
            }
        }
        digRooms(tempList);
        regions.addAll(tempList);
        return regionsPairs;
    }

    public void digRooms(ArrayList<Room> rooms) {
        rooms.forEach((room) -> {
            level.fillSectionWithRooms(room.dig());
        });
    }

//        int regionsNumber = 1;
//        for (Room room : rooms) {
//            int roomsSize = regionsNumber;
//            int neededRegions = rooms.size()/roomsSize;
//            
//            ArrayList<Room> tempList = new ArrayList<>();
//            
//            for (int i = 0; i < roomsSize; i++) {
//                int 
//            }
//        }
//    }
}
