package uz.androidclub.newslight.retro;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import uz.androidclub.newslight.retro.response.ArticleResponse;
import uz.androidclub.newslight.retro.response.SourceResponse;

/**
 * Created by yusufabd on 4/25/2017.
 */

public interface RetroMethods {

    @GET("sources")
    Observable<SourceResponse> getSourceList(
            @Query("category") String cat,
            @Query("language") String lang
    );

    @GET("articles")
    Observable<ArticleResponse> getArticleList(
            @Query("source") String src,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String apiKey
    );

}