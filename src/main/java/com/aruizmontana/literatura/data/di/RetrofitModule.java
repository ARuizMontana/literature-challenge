package com.aruizmontana.literatura.data.di;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Service
public class RetrofitModule {

    @Bean
    public Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://gutendex.com/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
