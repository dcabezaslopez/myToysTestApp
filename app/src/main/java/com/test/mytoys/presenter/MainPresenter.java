package com.test.mytoys.presenter;

import com.test.mytoys.view.CustomNavigationDrawerAdapter;

/**
 * Created by david on 8/9/16.
 */
public interface MainPresenter {

    void fetchServerData();

    void onNavigationDrawerItemClicked(CustomNavigationDrawerAdapter adapter, int position);

    void onDestroy();
}
