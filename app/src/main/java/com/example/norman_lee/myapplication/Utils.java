package com.example.norman_lee.myapplication;

public class Utils {

    //Java does not require throws for Unchecked Exceptions
    //Good practice to write it in nevertheless
    static boolean checkValidString(String in)
            throws NumberFormatException, IllegalArgumentException{

        Double d = Double.valueOf(in);
        if( d < 0) throw new IllegalArgumentException(
                "Negative value not allowed");
        return true;
    }
}
