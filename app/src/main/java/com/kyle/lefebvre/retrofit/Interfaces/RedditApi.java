package com.kyle.lefebvre.retrofit.Interfaces;

import com.kyle.lefebvre.retrofit.model.Feed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by kyle on 8/29/2017.
 */

public interface RedditApi {

    String BASE_URL = "https://www.reddit.com/";


    @Headers("Content-Type: application/json")
    @GET(".json")
    Call<Feed> getData();

}
