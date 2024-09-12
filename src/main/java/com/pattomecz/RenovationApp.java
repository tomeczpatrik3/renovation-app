package com.pattomecz;

import com.pattomecz.model.Room;
import com.pattomecz.utils.RoomUtils;
import com.pattomecz.utils.WallpaperUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

public class RenovationApp {

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Please specify the input file name with extension.");
        }
        Collection<Room> rooms = readRoomsFromFile(args[0]);

        System.out.println("Square feet of wallpapers to be ordered: " + WallpaperUtils.calculateWallpaperRequired(rooms));
        System.out.println("Rooms with cubic shape: " + RoomUtils.getCubicRoomsInDescOrder(rooms));
        System.out.println("Recurring rooms: " + RoomUtils.findRecurringRooms(rooms));
    }

    /**
     * Read the room definitions from a file and map them to objects
     * @param fileName The file to read (relative path, located inside the 'resources' folder)
     * @return A collections of rooms
     */
    private static Collection<Room> readRoomsFromFile(String fileName) {
        try (
                FileReader fileReader = new FileReader("src/main/resources/" + fileName);
                BufferedReader reader = new BufferedReader(fileReader)
        ) {
            return reader.lines()
                    .map(line -> {
                        String[] dimensions = line.split("x");
                        return new Room(
                                Integer.parseInt(dimensions[0]),
                                Integer.parseInt(dimensions[1]),
                                Integer.parseInt(dimensions[2])
                        );
                    })
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Unable to find file", e);
        }
    }

}
