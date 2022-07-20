package com.example.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PrettyJsonUtil {

    public static String getPretty(Object object) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(object);
    }
}
