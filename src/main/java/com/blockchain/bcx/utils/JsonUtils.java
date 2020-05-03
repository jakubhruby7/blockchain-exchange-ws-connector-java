package com.blockchain.bcx.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.blockchain.bcx.model.events.Event;

public class JsonUtils {
    private static final Gson gson = new Gson();

    public static boolean isJsonValid(String json) {
        try {
            gson.fromJson(json, Object.class);
            return true;
        } catch (JsonSyntaxException e) {
            return false;
        }
    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static JsonObject fromJson(String json) {
        return gson.fromJson(json, JsonObject.class);
    }

    public static <T extends Event> Event fromJson(JsonObject json, Class<T> tClass) {
        return gson.fromJson(json, tClass);
    }
}
