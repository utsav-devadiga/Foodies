package com.food.foodies.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.food.foodies.R;
import com.food.foodies.databinding.ActivityHomeBinding;
import com.food.foodies.repository.RestaurantsViewModel;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
    View view;
    //view-model for restaurants
    RestaurantsViewModel restaurantsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);

        //initialising the view-model for further use
        restaurantsViewModel = new ViewModelProvider(this).get(RestaurantsViewModel.class);


        //getting the location and passing the city inside the function
        //since the YELP API does not provide any results for india,
        //we can use a static city name
        //here we can state radius so for first instance we can use the max radius .i.e 40000
        /** we will observe the data in {@link HomeFragment } */
        restaurantsViewModel.getRestaurants("NYC", 40000);
    }
}