package uz.androidclub.newslight;

import uz.androidclub.newslight.presenter.MainPresenter;
import uz.androidclub.newslight.retro.RetroMethods;


/**
 * Created by yusufabd on 4/25/2017.
 */

public class MainPresenterImpl implements MainPresenter {

    private RetroMethods mService;
    private MainView mView;

    @Override
    public void loadArticleList(String src) {
        mService.getArticleList(src, "latest", "")
                .subscribe(
                        s -> mView.showArticleList(s.getArticleDTOs()),
                        s -> mView.showError(s.getLocalizedMessage())
                );
    }

    @Override
    public void loadSourceList(String lang, String cat) {

    }
}
