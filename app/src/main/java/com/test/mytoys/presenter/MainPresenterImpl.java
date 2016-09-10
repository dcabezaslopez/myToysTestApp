package com.test.mytoys.presenter;

import com.test.mytoys.model.Child;
import com.test.mytoys.model.DataProvider;
import com.test.mytoys.model.DataProviderImpl;
import com.test.mytoys.model.NavigationEntry;
import com.test.mytoys.view.CustomNavigationDrawerAdapter;
import com.test.mytoys.view.MainView;

import java.util.List;

/**
 * Created by david on 8/9/16.
 */
public class MainPresenterImpl implements MainPresenter, DataProvider.OnDataFetchedListener {

    private MainView mMainView;
    private DataProvider mDataProvider;

    public MainPresenterImpl(MainView mainView) {
        this.mMainView = mainView;
        this.mDataProvider = new DataProviderImpl();
    }

    @Override
    public void fetchServerData() {

        if (mMainView != null) {
            mMainView.showProgress();
        }

        mDataProvider.getData(this);
    }

    @Override
    public void onNavigationDrawerItemClicked(CustomNavigationDrawerAdapter adapter, int position) {

        Object object = adapter.getItem(position);

        if (object instanceof Child) {

            Child child = (Child) adapter.getItem(position);

            if (child.getType().equalsIgnoreCase("node")) {
                convertObjectsListToNavigationDrawerList((List<NavigationEntry>) adapter.getItem(position));
            } else {
                mMainView.loadUrl(child.getUrl());
            }

        }

    }

    @Override
    public void onDestroy() {
        mMainView = null;
    }

    @Override
    public void onSuccess(List<NavigationEntry> data) {

        if (mMainView != null) {
            mMainView.hideProgress();
        }

        convertObjectsListToNavigationDrawerList(data);

    }

    private void convertObjectsListToNavigationDrawerList(List<NavigationEntry> data) {

        if (data == null) {
            return;
        }

        CustomNavigationDrawerAdapter adapter = new CustomNavigationDrawerAdapter(mMainView.getContext());

        for (int i = 0; i < data.size(); i++) {

            NavigationEntry actualObject = data.get(i);

            if (actualObject.getType().equalsIgnoreCase("section")) {

                adapter.addSectionHeaderItem(actualObject);

                for (int j = 0; j < actualObject.getChildren().size(); j++) {

                    Child currentObject = actualObject.getChildren().get(j);

                    adapter.addItem(currentObject);

                }
            }

        }

        mMainView.fillDrawerData(adapter);

    }
}
