package com.example.assignmenttmdbapiunittest.api;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    public AuthInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url().newBuilder()
                .addQueryParameter("api_key", "d1e4cbca53b54455dc97b8b10135ac0d")
                .build();
        request = request.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
