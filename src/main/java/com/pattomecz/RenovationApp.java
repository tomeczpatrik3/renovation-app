package com.pattomecz;

import com.pattomecz.model.Room;
import com.pattomecz.utils.FileUtils;
import com.pattomecz.utils.RoomUtils;
import com.pattomecz.utils.WallpaperUtils;

import java.util.Collection;

public class RenovationApp {

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Please specify the input file name with extension.");
        }
        Collection<Room> rooms = FileUtils.readRoomsFromFile(args[0]);

        System.out.println("Square feet of wallpapers to be ordered: " + WallpaperUtils.calculateWallpaperRequired(rooms));
        System.out.println("Rooms with cubic shape: " + RoomUtils.getCubicRoomsInDescOrder(rooms));
        System.out.println("Recurring rooms: " + RoomUtils.findRecurringRooms(rooms));
    }

}
