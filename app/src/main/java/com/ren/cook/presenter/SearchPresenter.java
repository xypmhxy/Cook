package com.ren.cook.presenter;

import android.util.Log;

import com.android.volley.VolleyError;
import com.ren.cook.bean.DetailResult;
import com.ren.cook.http.VolleyInterface;
import com.ren.cook.model.SearchModelImp;
import com.ren.cook.view.ISearchView;

/**
 * Created by Administrator on 2017/8/30
 */

public class SearchPresenter {
    private SearchModelImp model;
    private ISearchView view;
    public SearchPresenter(ISearchView view){
        model=new SearchModelImp();
        this.view=view;
    }
    public void search(String text){
        model.search(text, new VolleyInterface<DetailResult>(DetailResult.class) {
            @Override
            public void onMySuccess(DetailResult result) {
                view.searchResult(result.getResult().getResult().getList());
            }

            @Override
            public void onMyError(VolleyError error) {
                Log.d("rq","");
            }
        });
    }
}
