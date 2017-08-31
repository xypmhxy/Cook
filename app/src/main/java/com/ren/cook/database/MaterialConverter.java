package com.ren.cook.database;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ren.cook.bean.Material;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;

/**
 * Created by Administrator on 2017/8/22
 */

public class MaterialConverter implements PropertyConverter<List<Material>, String> {

    @Override
    public List<Material> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        } else {
            Gson gson = new Gson();
            return gson.fromJson(databaseValue, new TypeToken<List<Material>>(){}.getType());

        }
    }

    @Override
    public String convertToDatabaseValue(List<Material> entityProperty) {
        if (entityProperty == null) {
            return null;
        } else {
            Gson gson=new Gson();
            return gson.toJson(entityProperty);
        }
    }
}
