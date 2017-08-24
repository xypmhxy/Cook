package com.ren.cook.database;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ren.cook.bean.Food;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/8/22
 */

public class StringConverter implements PropertyConverter<List<Food>, String> {

    @Override
    public List<Food> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        } else {
            Gson gson = new Gson();
            return gson.fromJson(databaseValue, new TypeToken<List<Food>>(){}.getType());

        }
    }

    @Override
    public String convertToDatabaseValue(List<Food> entityProperty) {
        if (entityProperty == null) {
            return null;
        } else {
            Gson gson=new Gson();
            return gson.toJson(entityProperty);
        }
    }
}
