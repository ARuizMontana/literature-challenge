package com.aruizmontana.literatura.data.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.annotations.EverythingIsNonNull;

import java.io.IOException;

public class HeaderInterceptor implements Interceptor {

    @Override
    @EverythingIsNonNull
    public Response intercept(Chain chain) throws IOException {
        Request auth = chain.request().newBuilder()
                .addHeader("Content-Type", "application/json" )
                .addHeader("Accept", "application/json")
                .build();
        return chain.proceed(auth);
    }

}
