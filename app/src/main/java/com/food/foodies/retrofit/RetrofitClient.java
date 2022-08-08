package com.food.foodies.retrofit;

import android.util.Log;

import com.food.foodies.utils.AppServerConstants;
import com.food.foodies.utils.LogTags;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance;
    ApiClient apiClient;


    public RetrofitClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request originalRequest = chain.request();

                    Request.Builder builder = originalRequest.newBuilder()
                            .addHeader("Content-Type", "application/json")
                            .header("Authorization", "Bearer " + AppServerConstants.API_KEY);

                    Request newRequest = builder.build();
                    Log.d(LogTags.RETROFIT_CALL, "RetrofitClient: ");
                    return chain.proceed(newRequest);
                }).build();

        ///retrofit object
        Retrofit retrofit = new Retrofit.Builder().baseUrl(AppServerConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        apiClient = retrofit.create(ApiClient.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public ApiClient getCoverageApi() {
        return apiClient;
    }
}
