package com.food.foodies.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.food.foodies.databinding.FragmentHomeBinding;
import com.food.foodies.repository.RestaurantsViewModel;

import com.food.foodies.responseclasses.RestaurantsResponse;
import com.food.foodies.ui.adapters.RestaurantAdapter;
import com.food.foodies.utils.LogTags;

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

        return view;
    }

    private void hideLoading() {
        //loading
        binding.loadingAnimation.pauseAnimation();
        binding.loadingAnimation.setVisibility(View.GONE);

        //recyclerview
        binding.restaurantCycle.setVisibility(View.VISIBLE);
    }

    private void showLoading() {
        //loading
        binding.loadingAnimation.playAnimation();
        binding.loadingAnimation.setVisibility(View.VISIBLE);

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