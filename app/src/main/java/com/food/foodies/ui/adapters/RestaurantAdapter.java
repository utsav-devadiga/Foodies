package com.food.foodies.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.food.foodies.databinding.ItemRestaurantBinding;
import com.food.foodies.responseclasses.RestaurantsResponse;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {
    List<RestaurantsResponse.Business> businessList;
    Context context;

    public RestaurantAdapter(List<RestaurantsResponse.Business> businessList, Context context) {
        this.businessList = businessList;
        this.context = context;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRestaurantBinding binding = ItemRestaurantBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RestaurantViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        RestaurantsResponse.Business business = businessList.get(position);
        //set the name
        holder.binding.itemRestaurantName.setText(business.getName());

        //set the image
        Glide.with(context)
                .load(business.getImageUrl())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.binding.itemRestaurantImage);

        //set the ratings
        holder.binding.itemRestaurantRatings.setText(String.valueOf(business.getRating()));

        //set the address
        StringBuilder address = new StringBuilder();
        for (String stringAddress : business.getLocation().getDisplayAddress()
        ) {
            address.append(" ").append(stringAddress);
        }
        holder.binding.itemRestaurantAddress.setText(address);
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
