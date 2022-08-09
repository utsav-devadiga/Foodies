package com.food.foodies.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.food.foodies.databinding.ItemRestaurantBinding;
import com.food.foodies.responseclasses.RestaurantsResponse;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<RestaurantsResponse.Business> businessList;
    Context context;

    public RestaurantAdapter(List<RestaurantsResponse.Business> businessList, Context context) {
        this.businessList = businessList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRestaurantBinding binding = ItemRestaurantBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RestaurantViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return (businessList != null ? businessList.size() : 0);
    }

    public static class RestaurantViewHolder extends RecyclerView.ViewHolder {
        ItemRestaurantBinding binding;

        public RestaurantViewHolder(ItemRestaurantBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
