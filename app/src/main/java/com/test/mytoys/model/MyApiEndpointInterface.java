package com.test.mytoys.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by david on 9/9/16.
 */
public interface MyApiEndpointInterface {

    @Headers("x-api-key: hz7JPdKK069Ui1TRxxd1k8BQcocSVDkj219DVzzD")
    @GET("/api/navigation")
    Call<RequestObject> getNavigationEntries();

}
