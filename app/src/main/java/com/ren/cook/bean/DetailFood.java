package com.ren.cook.bean;

import com.ren.cook.database.MaterialConverter;
import com.ren.cook.database.ProcessConverter;
import com.ren.cook.database.StringConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

import static android.R.attr.rating;

/**
 * Created by Administrator on 2017/8/23
 */
@Entity
public class DetailFood implements Serializable{
    private long classid;
    @Convert(columnType = String.class, converter = ProcessConverter.class)
    private List<Process> process ;

    private String preparetime;
    @Convert(columnType = String.class, converter = MaterialConverter.class)
    private List<Material> material ;

    private String name;
    @Id(autoincrement = false)
    private long id;

    private float rating;

    private String pic;

    private String tag;

    private String peoplenum;

    private String content;

    private String cookingtime;

    @Generated(hash = 1002493402)
    public DetailFood(long classid, List<Process> process, String preparetime,
            List<Material> material, String name, long id, float rating,
            String pic, String tag, String peoplenum, String content,
            String cookingtime) {
        this.classid = classid;
        this.process = process;
        this.preparetime = preparetime;
        this.material = material;
        this.name = name;
        this.id = id;
        this.rating = rating;
        this.pic = pic;
        this.tag = tag;
        this.peoplenum = peoplenum;
        this.content = content;
        this.cookingtime = cookingtime;
    }
    @Generated(hash = 1342496064)
    public DetailFood() {
    }

    public void setClassid(long classid){
        this.classid = classid;
    }
    public long getClassid(){
        return this.classid;
    }
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    public void setProcess(List<Process> process){
        this.process = process;
    }
    public List<Process> getProcess(){
        return this.process;
    }
    public void setPreparetime(String preparetime){
        this.preparetime = preparetime;
    }
    public String getPreparetime(){
        return this.preparetime;
    }
    public void setMaterial(List<Material> material){
        this.material = material;
    }
    public List<Material> getMaterial(){
        return this.material;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return this.id;
    }
    public void setPic(String pic){
        this.pic = pic;
    }
    public String getPic(){
        return this.pic;
    }
    public void setTag(String tag){
        this.tag = tag;
    }
    public String getTag(){
        return this.tag;
    }
    public void setPeoplenum(String peoplenum){
        this.peoplenum = peoplenum;
    }
    public String getPeoplenum(){
        return this.peoplenum;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
    public void setCookingtime(String cookingtime){
        this.cookingtime = cookingtime;
    }
    public String getCookingtime(){
        return this.cookingtime;
    }
}
