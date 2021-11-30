package ru.diasoft.springHW.util;

public class StringShellUtil {

    private StringShellUtil(){}

    public static String stringNameNormalFormat(String name){
        return name.replace('#', ' ');
    }
}
