package uz.androidclub.newslight.models;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uz.androidclub.newslight.AppConstants;
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
        mApiService = RetroClient.getService();
    }

    @Override
    public Observable<List<SourceDTO>> getSourceList(String category, String language) {
        return mApiService
                .getSourceList(category, language)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(SourceResponse::getSourceDTOs);
    }

    @Override
    public Observable<List<ArticleDTO>> getArticleList(String source, List<String> sort) {
        String sorting = AppConstants.SORT_BY_LATEST;

        if (!sort.contains(AppConstants.SORT_BY_LATEST))
            sorting = sort.get(0);

        return mApiService
                .getArticleList(source, sorting, AppConstants.NEWS_API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(ArticleResponse::getArticleDTOs);
    }
}