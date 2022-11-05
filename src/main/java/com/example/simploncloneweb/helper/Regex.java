package com.example.simploncloneweb.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static boolean checkRegex(String regex, String text)
    {
        Pattern pt = Pattern.compile(regex);
        Matcher mt = pt.matcher(text);
        return mt.matches();
    }
}