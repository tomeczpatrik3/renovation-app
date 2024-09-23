package com.pattomecz.validation;

public class RoomValidator {

    public static boolean isValid(String dimension) {
        return dimension != null && !dimension.isEmpty() && dimension.split("x").length == 3;
    }

}
