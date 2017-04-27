package uz.androidclub.newslight.retro;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yusufabd on 4/25/2017.
 */

public class RetroClient {

    private static Retrofit mRetrofit = null;
    private static final String mBaseUrl = "https://newsapi.org/v1/";

    public static Retrofit getRetrofit(){
        if (mRetrofit == null)
            mRetrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return mRetrofit;
    }
}
