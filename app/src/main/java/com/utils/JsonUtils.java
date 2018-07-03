package com.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghua 2018 07/02
 */

public class JsonUtils {
    /**
     * 将Json数据解析成相应的映射对象
     */

    private static Gson gson = null;

    public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
        if (gson == null) {
            gson = new Gson();
        }
        return gson.fromJson(jsonData, type);
    }

    /**
     * 将jsonArray parse成List
     *
     * @param jsonData TYPE:String - jsonString
     * @param type     TYPE:class- model
     * @param <T>      目标类型
     */
    public static <T> List<T> getListFromJsonArray(String jsonData, Class<T> type) {
        List<T> result = new ArrayList<>();

        try {
            Gson gson = new Gson();
            JsonArray array = new JsonParser().parse(jsonData).getAsJsonArray();
            for (JsonElement jsonElement : array) {
                result.add(gson.fromJson(jsonElement, type));
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

        return result;
    }

    static <T> List<T> getJsonArrayToModel(String jsonData, Class<T> t) {
        List<T> list = new ArrayList<>();
        try {
            JSONArray json = new JSONArray(jsonData);
            for (int i = 0; i < json.length(); i++) {
                list.add(parseJsonWithGson(json.get(i).toString(), t));
            }
            return list;
        } catch (Exception e) {
            Log.e("getJsonArrayToModel", "error");
            e.printStackTrace();
        }
        return null;
    }
}
