package com.ren.cook.utils;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

import com.ren.cook.R;

/**
 * Created by Administrator on 2017/8/23.
 */

public class MyActionProvider extends ActionProvider {
    public MyActionProvider(Context context)
    {
        super(context);
    }

    @Override
    public View onCreateActionView()
    {
        return null;
    }

    @Override
    public void onPrepareSubMenu(SubMenu subMenu)
    {
        subMenu.clear();

        subMenu.add("sub item 1")
                .setIcon(R.mipmap.ic_launcher)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        return true;
                    }
                });
        subMenu.add("sub item 2")
                .setIcon(R.mipmap.ic_launcher)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        return true;
                    }
                });
    }

    @Override
    public boolean hasSubMenu()
    {
        return true;
    }
}
