package com.shellhacks.genedubackend.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonUtil {

    private static final Gson gson = new Gson();
    private static final JsonParser jsonParser = new JsonParser();

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
        return gson.fromJson(jsonObject, classOfT);
    }

}

