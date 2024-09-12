package com.pattomecz.model;

public record Room (
        int length,
        int width,
        int height
) {
    /**
     * Calculate the surface of the room
     * @return The surface
     */
    public int calculateSurface() {
        return (2 * length * width) + (2 * width * height) + (2 * height * length);
    }

    /**
     * Calculate the smallest area in the room
     * @return The smallest area
     */
    public int calculateSmallestArea() {
        return Math.min(length * width, Math.min(width * height, height * length));
    }

    /**
     * Check whether the room is a cube
     * @return Is cube or not
     */
    public boolean isCubicRoom() {
        return (length == width) && (length == height);
    }
}
