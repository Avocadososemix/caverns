/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySpacePartition;

import java.util.ArrayList;

/**
 * Contains all the Room-objects that are used to split a level when using binary
 * space partitioning.
 * 
 * @author lkaranko
 */
public class Rooms {
    
    ArrayList<Room> roomlist;

    public Rooms() {
        roomlist= new ArrayList<>();
    }

    public ArrayList<Room> getRoomlist() {
        return roomlist;
    }

    public void setRoomlist(ArrayList<Room> roomlist) {
        this.roomlist = roomlist;
    }
    
    public void addRoom(Room room) {
        roomlist.add(room);
    }
    
    public void clearRoomList() {
        roomlist.clear();
    }
    
}
