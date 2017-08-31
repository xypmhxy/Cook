package com.ren.cook.database;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ren.cook.bean.Process;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;

/**
 * Created by Administrator on 2017/8/22
 */

public class ProcessConverter implements PropertyConverter<List<Process>, String> {

    @Override
    public List<Process> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        } else {
            Gson gson = new Gson();
            return gson.fromJson(databaseValue, new TypeToken<List<Process>>(){}.getType());

        }
    }

    @Override
    public String convertToDatabaseValue(List<Process> entityProperty) {
        if (entityProperty == null) {
            return null;
        } else {
            Gson gson=new Gson();
            return gson.toJson(entityProperty);
        }
    }
}
