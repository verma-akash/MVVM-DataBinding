package com.morty.rick.rickmorty.data.models;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * Created by Akash Verma on 08/11/18.
 */
public class DataTypeConverter {

    private static Gson gson = new Gson();
    @TypeConverter
    public static List<Character> stringToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Character>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String ListToString(List<Character> someObjects) {
        return gson.toJson(someObjects);
    }
}
