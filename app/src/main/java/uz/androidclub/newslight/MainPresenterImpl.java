package uz.androidclub.newslight;

import android.content.Context;

import uz.androidclub.newslight.presenter.MainPresenter;
import uz.androidclub.newslight.presenter.mappers.ArticleMapper;
import uz.androidclub.newslight.retro.RetroClient;
import uz.androidclub.newslight.retro.RetroMethods;


/**
 * Created by yusufabd on 4/25/2017.
 */

public class MainPresenterImpl implements MainPresenter {

    private RetroMethods mService;
    private MainView mView;
    private Context mCtx;

    public MainPresenterImpl(MainView mView) {
        this.mView = mView;
        this.mCtx = mView.getViewContext();
        mService = RetroClient.getRetrofit().create(RetroMethods.class);
    }

    @Override
    public void loadArticleList(String src) {
        mService.getArticleList(src, "latest", "")
                .subscribe(
                        s -> mView.showArticleList(new ArticleMapper().call(s.getArticleDTOs())),
                        s -> mView.showError(s.getLocalizedMessage())
                );
    }

    @Override
    public void loadSourceList(String lang, String cat) {
        mService.getSourceList(lang, cat);
    }
}
