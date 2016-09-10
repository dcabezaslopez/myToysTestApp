package com.test.mytoys.view;

import android.content.Context;

/**
 * Created by david on 8/9/16.
 */
public interface MainView {

    Context getContext();

    void showProgress();

    void hideProgress();

    void fillDrawerData(CustomNavigationDrawerAdapter adapter);

    void loadUrl(String url);

}
