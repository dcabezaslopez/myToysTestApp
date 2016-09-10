package com.test.mytoys.model;

import android.os.Handler;

import com.test.mytoys.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by david on 8/9/16.
 */
public class DataProviderImpl implements DataProvider {

    @Override
    public void getData(final OnDataFetchedListener listener) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_REQUEST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyApiEndpointInterface myApiEndpointInterface = retrofit.create(MyApiEndpointInterface.class);
        Call<RequestObject> call = myApiEndpointInterface.getNavigationEntries();

        call.enqueue(new Callback<RequestObject>() {
            @Override
            public void onResponse(Call<RequestObject> call, final Response<RequestObject> response) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        listener.onSuccess(response.body().getNavigationEntries());

                    }
                }, 2000);

            }

            @Override
            public void onFailure(Call<RequestObject> call, Throwable t) {

            }
        });

    }
}
