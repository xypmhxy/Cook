package com.ren.cook.bean;

import com.ren.cook.database.StringConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;
import java.util.Set;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/08/21 0021
 */
@Entity
public class FoodDataResult {

    @Id(autoincrement = false)
    private long classid;

    private String name;
    @Convert(columnType = String.class, converter = StringConverter.class)
    private List<Food> list ;

    private String parentid;


    @Generated(hash = 33162848)
    public FoodDataResult(long classid, String name, List<Food> list,
            String parentid) {
        this.classid = classid;
        this.name = name;
        this.list = list;
        this.parentid = parentid;
    }
    @Generated(hash = 1455532503)
    public FoodDataResult() {
    }


    public void setClassid(long classid){
        this.classid = classid;
    }
    public long getClassid(){
        return this.classid;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setList(List<Food> list){
        this.list = list;
    }
    public List<Food> getList(){
        return this.list;
    }
    public void setParentid(String parentid){
        this.parentid = parentid;
    }
    public String getParentid(){
        return this.parentid;
    }
}
