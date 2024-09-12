package com.pattomecz.utils;

import com.pattomecz.model.Room;

import java.util.Collection;

public class WallpaperUtils {

    /**
     * Calculate the wallpaper required to cover a collections of rooms
     * @param rooms The collection of rooms
     * @return The wallpaper required
     */
    public static long calculateWallpaperRequired(final Collection<Room> rooms) {
        return rooms.stream()
                .map(WallpaperUtils::calculateWallpaperRequired)
                .reduce(0L, Long::sum);
    }

    /**
     * Calculate the wallpaper required to cover a specific room
     * @param room The room
     * @return The wallpaper required
     */
    public static long calculateWallpaperRequired(final Room room) {
        return room.calculateSurface() + room.calculateSmallestArea();
    }

}
