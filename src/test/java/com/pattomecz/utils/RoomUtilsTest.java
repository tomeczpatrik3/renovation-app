package com.pattomecz.utils;

import com.pattomecz.model.Room;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class RoomUtilsTest {

    @Test
    void getCubicRoomsInDescOrderForEmptyRooms() {
        Collection<Room> rooms = new ArrayList<>();
        assertIterableEquals(rooms, RoomUtils.getCubicRoomsInDescOrder(rooms));
    }

    @Test
    void getCubicRoomsInDescOrderForMultipleCubicRooms() {
        Collection<Room> rooms = Arrays.asList(
                new Room(1, 1, 1),
                new Room(2, 2, 2),
                new Room(3, 3, 3)
        );

        Collection<Room> expectedResult = Arrays.asList(
                new Room(3, 3, 3),
                new Room(2, 2, 2),
                new Room(1, 1, 1)
        );

        assertIterableEquals(expectedResult, RoomUtils.getCubicRoomsInDescOrder(rooms));
    }

    @Test
    void getCubicRoomsInDescOrderForMultipleRooms() {
        Collection<Room> rooms = Arrays.asList(
                new Room(1, 2, 3),
                new Room(2, 2, 2),
                new Room(3, 3, 3),
                new Room(2, 3, 4),
                new Room(5, 5, 5),
                new Room(1, 7, 8),
                new Room(1, 1, 1),
                new Room(1, 1, 1)
        );

        Collection<Room> expectedResult = Arrays.asList(
                new Room(5, 5, 5),
                new Room(3, 3, 3),
                new Room(2, 2, 2),
                new Room(1, 1, 1),
                new Room(1, 1, 1)
        );

        assertIterableEquals(expectedResult, RoomUtils.getCubicRoomsInDescOrder(rooms));
    }

    @Test
    void findRecurringRoomsForEmptyRooms() {
        Collection<Room> rooms = new ArrayList<>();
        assertIterableEquals(Collections.emptySet(), RoomUtils.findRecurringRooms(rooms));
    }

    @Test
    void findRecurringRoomsForMultipleRooms() {
        Collection<Room> rooms = Arrays.asList(
                new Room(1, 1, 1),
                new Room(2, 2, 2),
                new Room(3, 3, 3),
                new Room(2, 2, 2),
                new Room(1, 1, 1),
                new Room(4, 4, 4),
                new Room(1, 1, 1)
        );

        Collection<Room> expectedResult = Set.of(
                new Room(1, 1, 1),
                new Room(2, 2, 2)
        );
        assertEquals(expectedResult, RoomUtils.findRecurringRooms(rooms));
    }
}