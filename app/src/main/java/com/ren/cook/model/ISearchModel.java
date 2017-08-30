package com.ren.cook.model;

import com.ren.cook.bean.DetailResult;
import com.ren.cook.http.VolleyInterface;

/**
 * Created by Administrator on 2017/8/30
 */

public interface ISearchModel {
    void search(String text,VolleyInterface<DetailResult> volleyInterface);
}
