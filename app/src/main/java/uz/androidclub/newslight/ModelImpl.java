package uz.androidclub.newslight;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import uz.androidclub.newslight.retro.RetroClient;
import uz.androidclub.newslight.retro.RetroMethods;
import uz.androidclub.newslight.retro.response.ArticleResponse;
import uz.androidclub.newslight.retro.response.SourceResponse;
import uz.androidclub.newslight.retro.response.models.ArticleDTO;
import uz.androidclub.newslight.retro.response.models.SourceDTO;

/**
 * Created by yusufabd on 4/28/2017.
 */

public class ModelImpl implements Model{

    private RetroMethods mApiService;

    public ModelImpl() {
        mApiService = RetroClient.getRetrofit().create(RetroMethods.class);
    }

    @Override
    public Observable<List<SourceDTO>> getSourceList(String category, String language) {
        return mApiService.getSourceList(category, language)
                .map(SourceResponse::getSourceDTOs);
    }

    @Override
    public Observable<List<ArticleDTO>> getArticleList(String source) {
        return mApiService.getArticleList(source, AppConstants.SORT_BY_LATEST, AppConstants.NEWS_API_KEY)
                .map(ArticleResponse::getArticleDTOs);
    }
}