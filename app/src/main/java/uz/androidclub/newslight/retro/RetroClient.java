package uz.androidclub.newslight.retro;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yusufabd on 4/25/2017.
 */

public class RetroClient {

    private static Retrofit mRetrofit = null;
    private static final String mBaseUrl = "https://newsapi.org/v1/";

    public static Retrofit getRetrofit(){
        if (mRetrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();

            mRetrofit = new Retrofit.Builder()
                    .baseUrl(mBaseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }

        return mRetrofit;
    }

    public static RetroMethods getService(){
        return getRetrofit().create(RetroMethods.class);
    }
}
