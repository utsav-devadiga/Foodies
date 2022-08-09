package com.food.foodies.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.food.foodies.databinding.FragmentHomeBinding;
import com.food.foodies.repository.RestaurantsViewModel;

import com.food.foodies.responseclasses.RestaurantsResponse;
import com.food.foodies.ui.adapters.RestaurantAdapter;
import com.food.foodies.utils.LogTags;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    View view;
    RestaurantsViewModel restaurantsViewModel;

    //adapter
    RestaurantAdapter adapter;

    //list
    List<RestaurantsResponse.Business> businessList = new ArrayList<RestaurantsResponse.Business>();

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("PARAM_1", param1);
        args.putString("PARAM_2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        view = binding.getRoot();

        //setting the slider to max
        binding.slider.setValue(40000);

        //setting the place edit text
        binding.placeEditText.setText("NYC");

        //initializing the view-model for the fragment lifecycle but with the activity scope.
        restaurantsViewModel = new ViewModelProvider(requireActivity()).get(RestaurantsViewModel.class);

        getRestaurants();

        restaurantsViewModel.getLoadingState().observe(getViewLifecycleOwner(), loading -> {
            if (loading) {
                showLoading();
            } else {
                hideLoading();
            }
        });

        //slider
        binding.slider.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {

            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slider) {
                //get the location
                String location = binding.placeEditText.getText().toString().trim().isEmpty() ? "NYC" : binding.placeEditText.getText().toString().trim();
                //here we respond to users radius
                restaurantsViewModel.getRestaurants(location, Math.round(slider.getValue()));

                if (binding.placeEditText.getText().toString().trim().isEmpty()) {
                    binding.placeEditText.setText("NYC");
                }
            }
        });

        //place text
      /*  binding.placeEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    //no location
                } else {
                    restaurantsViewModel.getRestaurants(charSequence.toString(), Math.round(binding.slider.getValue()));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        }); */ //removed for api bad behaviour

        return view;
    }

    private void hideLoading() {
        //loading
        binding.loadingAnimation.pauseAnimation();
        binding.loadingLayout.setVisibility(View.GONE);

        //recyclerview
        binding.restaurantCycle.setVisibility(View.VISIBLE);
    }

    private void showLoading() {
        //loading
        binding.loadingAnimation.playAnimation();
        binding.loadingLayout.setVisibility(View.VISIBLE);

        //recyclerview
        binding.restaurantCycle.setVisibility(View.GONE);
    }

    private void getRestaurants() {
        restaurantsViewModel.getRestaurantData().observe(getViewLifecycleOwner(), response -> {
            if (response != null) {
                if (response.getBusinesses() != null) {
                    adapter = new RestaurantAdapter(response.getBusinesses(), requireContext());
                    binding.restaurantCycle.setAdapter(adapter);
                } else {
                    Log.d(LogTags.HOME_FRAGMENT, "getRestaurants: business list is null");
                    //we did not get any result
                }
            } else {
                //we did not get any response
                Log.d(LogTags.HOME_FRAGMENT, "getRestaurants: response is null");
            }
        });
    }
}