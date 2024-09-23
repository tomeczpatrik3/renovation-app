package com.pattomecz.utils;

import com.pattomecz.factory.RoomFactory;
import com.pattomecz.model.Room;
import com.pattomecz.validation.RoomValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

public class FileUtils {

    /**
     * Read the room definitions from a file and map them to objects
     * @param filePath The file to read
     * @return A collections of rooms
     */
    public static Collection<Room> readRoomsFromFile(String filePath) {
        try (
                FileReader fileReader = new FileReader(filePath);
                BufferedReader reader = new BufferedReader(fileReader)
        ) {
            return reader.lines()
                    .filter(RoomValidator::isValid)
                    .map(RoomFactory::create)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Unable to find file", e);
        }
    }
}
