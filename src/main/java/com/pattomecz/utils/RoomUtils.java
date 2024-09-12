package com.pattomecz.utils;

import com.pattomecz.model.Room;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RoomUtils {

    /**
     * Get the cubic rooms in descending order by their surface
     * @param rooms The collections of rooms
     * @return The cubic rooms in descending order
     */
    public static Collection<Room> getCubicRoomsInDescOrder(Collection<Room> rooms) {
        return rooms.stream()
                .filter(Room::isCubicRoom)
                .sorted((room1, room2) -> Math.toIntExact(WallpaperUtils.calculateWallpaperRequired(room2) - WallpaperUtils.calculateWallpaperRequired(room1)))
                .collect(Collectors.toList());
    }

    /**
     * Find the recurring rooms in the collections
     * @param rooms The rooms
     * @return The recurring rooms
     */
    public static Collection<Room> findRecurringRooms(Collection<Room> rooms) {
        Set<Room> recurringRooms = new HashSet<>();
        Set<Room> roomsProcessed = new HashSet<>();

        for (final Room room : rooms) {
            if (!roomsProcessed.add(room)) {
                recurringRooms.add(room);
            }
        }

        return recurringRooms;
    }

}
