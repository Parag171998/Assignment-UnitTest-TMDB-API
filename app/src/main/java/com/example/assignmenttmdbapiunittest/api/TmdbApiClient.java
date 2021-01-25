package com.example.assignmenttmdbapiunittest.api;

import com.example.assignmenttmdbapiunittest.api.interfaces.MovieInterface;
import com.example.assignmenttmdbapiunittest.util.ApplicationConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TmdbApiClient {

    private Retrofit retrofit;
    private boolean isDebug;
    private HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

   /* public void setIsDebug(boolean isDebug) {
        this.isDebug = isDebug;
        if (retrofit != null) {
            httpLoggingInterceptor.
                    setLevel(isDebug ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        }
    }*/

    private OkHttpClient okHttpClient() {

        return new OkHttpClient.Builder()
                .addInterceptor(new AuthInterceptor())
                .connectTimeout(ApplicationConstants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(ApplicationConstants.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(ApplicationConstants.READ_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    private Retrofit.Builder newRestAdapterBuilder() {
        return new Retrofit.Builder();
    }

    private Retrofit getRestAdapter() {

        Retrofit.Builder builder = null;
        if (retrofit == null) {

            //Create a new instance of the Rest Adapter class
            builder = newRestAdapterBuilder();

            builder.baseUrl(ApplicationConstants.END_POINT);
            builder.client(okHttpClient());
            builder.addConverterFactory(GsonConverterFactory.create());
        }

     /*   if (isDebug) {
            if (builder != null) {
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            }
        }*/
        if (builder != null) {
            retrofit = builder.build();
        }
        return retrofit;
    }

    public MovieInterface movieInterface() {
        return getRestAdapter().create(MovieInterface.class);
    }

}
