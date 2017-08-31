package com.ren.cook.presenter;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.VolleyError;
import com.ren.cook.bean.DetailResult;
import com.ren.cook.http.VolleyInterface;
import com.ren.cook.model.SearchModelImp;
import com.ren.cook.view.ISearchView;

import static com.ren.cook.R.id.progressbar;

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
    public void search(int num,ProgressBar progressBar, String text){
        if (progressBar!=null)
            progressBar.setVisibility(View.VISIBLE);
        model.search(num,text, new VolleyInterface<DetailResult>(DetailResult.class) {
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
