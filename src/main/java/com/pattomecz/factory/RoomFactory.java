package com.pattomecz.factory;

import com.pattomecz.model.Room;

public class RoomFactory {

    private static final String DELIMITER = "x";

    /**
     * Create a room from the dimensions of a string
     * @param dimension The dimensions separated by 'x'
     * @return The room
     */
    public static Room create(final String dimension) {
        String[] dimensions = dimension.split(DELIMITER);
        return new Room(
                Integer.parseInt(dimensions[0]),
                Integer.parseInt(dimensions[1]),
                Integer.parseInt(dimensions[2])
        );
    }

}
