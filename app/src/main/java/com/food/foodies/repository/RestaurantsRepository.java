package com.food.foodies.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.food.foodies.responseclasses.RestaurantsResponse;
import com.food.foodies.retrofit.RetrofitClient;
import com.food.foodies.utils.LogTags;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * this class has the
 * business logic for
 * fetching Restaurants
 **/

public class RestaurantsRepository {
    private final MutableLiveData<RestaurantsResponse> restaurantLiveData;
    public final MutableLiveData<Boolean> loadingState;
    public final MutableLiveData<Boolean> errorState;
    Application application;

    public RestaurantsRepository(Application application) {
        this.restaurantLiveData = new MutableLiveData<>();
        this.loadingState = new MutableLiveData<>(true);
        this.errorState = new MutableLiveData<>();
        this.application = application;
    }


    /**
     * this function  has the business logic for calling
     * and parsing the @Restaurant-response
     **/
    public void getRestaurants(String location, int radius) {
        //restaurant call
        Observable<RestaurantsResponse> restaurantObservable = RetrofitClient.getInstance()
                .getCoverageApi()
                .getRestaurants("restaurants", location, radius, "distance", 15);

        CompositeDisposable compositeDisposable = new CompositeDisposable();

        compositeDisposable.add(restaurantObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(result -> result)
                .subscribe(this::handleResults, this::handleError));
    }

    //here we parse the restaurant response
    private void handleResults(RestaurantsResponse response) {
        if (response != null && response.getBusinesses().size() != 0) {
            try {
                restaurantLiveData.setValue(response);
            } catch (Exception e) {
                Log.e(LogTags.RETROFIT_CALL, "handleResults ERROR: ", e);
            }

        } else {
            restaurantLiveData.setValue(response);
            errorState.setValue(false);
            loadingState.setValue(false);
            Log.e(LogTags.RETROFIT_CALL, "handleResults: No ResultFound");
        }
    }

    //here we are handling the errors
    private void handleError(Throwable t) {
        restaurantLiveData.setValue(null);
        Log.e(LogTags.RETROFIT_CALL, "ERROR IN FETCHING API RESPONSE. Try again", t);
        Toast.makeText(application, "Something went wrong! \nReason: " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
    }

    //getter for restaurant data
    public LiveData<RestaurantsResponse> getRestaurantData() {
        return restaurantLiveData;
    }

}
