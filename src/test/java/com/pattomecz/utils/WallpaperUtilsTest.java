package com.pattomecz.utils;

import com.pattomecz.model.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class WallpaperUtilsTest {

    @Test
    void calculateWallpaperRequiredForEmptyRooms() {
        assertEquals(0L, WallpaperUtils.calculateWallpaperRequired(Collections.emptyList()));
    }

    @Test
    void calculateWallpaperRequiredForASingleRoom() {
        Room room = new Room(1, 2, 3);
        assertEquals(24L, WallpaperUtils.calculateWallpaperRequired(Collections.singletonList(room)));
    }

    @Test
    void calculateWallpaperRequiredForMultipleRooms() {
        assertEquals(24L + 23L, WallpaperUtils.calculateWallpaperRequired(Arrays.asList(
                new Room(1, 2, 3),
                new Room(1, 1, 5)
        )));
    }
}