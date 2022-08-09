package com.food.foodies.repository;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.food.foodies.responseclasses.RestaurantsResponse;

/**
 * view-model for
 * restaurant data fetch
 */
public class RestaurantsViewModel extends AndroidViewModel {
    RestaurantsRepository restaurantsRepository;

    public RestaurantsViewModel(@NonNull Application application) {
        super(application);
        restaurantsRepository = new RestaurantsRepository(application);
    }


    public void getRestaurants(String location, int radius) {
        restaurantsRepository.getRestaurants(location, radius);
    }

    public LiveData<RestaurantsResponse> getRestaurantData() {
        return restaurantsRepository.getRestaurantData();
    }

    public LiveData<Boolean> getLoadingState() {
        return restaurantsRepository.getLoadingState();
    }
}
