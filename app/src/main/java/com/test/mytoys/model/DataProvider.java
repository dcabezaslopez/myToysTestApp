package com.test.mytoys.model;

import java.util.List;

/**
 * Created by david on 8/9/16.
 */
public interface DataProvider {

    interface OnDataFetchedListener {

        void onSuccess(List<NavigationEntry> data);

    }

    void getData(OnDataFetchedListener listener);

}
