package com.food.foodies.retrofit;

import com.food.foodies.responseclasses.RestaurantsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {

    @GET("/search")
    Observable<RestaurantsResponse> getRestaurants(@Query("term") String term,
                                                   @Query("location") String location,
                                                   @Query("radius") int radius,
                                                   @Query("sort_by") String sort_by,
                                                   @Query("limit") int limit);

}
