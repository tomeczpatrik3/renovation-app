package com.pattomecz.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void calculateSurface1() {
        Room room = new Room(1, 2, 3);
        assertEquals(22, room.calculateSurface(), "Unexpected surface");
    }

    @Test
    void calculateSurface2() {
        Room room = new Room(1, 1, 5);
        assertEquals(22, room.calculateSurface(), "Unexpected surface");
    }

    @Test
    void calculateSmallestArea1() {
        Room room = new Room(1, 2, 3);
        assertEquals(2, room.calculateSmallestArea(), "Unexpected smallest are");
    }

    @Test
    void calculateSmallestArea2() {
        Room room = new Room(1, 1, 5);
        assertEquals(1, room.calculateSmallestArea(), "Unexpected smallest are");
    }

    @Test
    void isCubeWithANonCubicRoom() {
        Room room = new Room(1, 2, 3);
        assertFalse(room.isCubicRoom(), "The room is not supposed to be a cube");
    }

    @Test
    void isCubeWithACubicRoom() {
        Room room = new Room(2, 2, 2);
        assertTrue(room.isCubicRoom(), "The room is supposed to be a cube");
    }
}