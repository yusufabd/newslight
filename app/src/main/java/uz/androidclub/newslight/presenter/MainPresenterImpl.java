package uz.androidclub.newslight.presenter;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import uz.androidclub.newslight.AppConstants;
import uz.androidclub.newslight.AppPreferences;
import uz.androidclub.newslight.MainView;
import uz.androidclub.newslight.R;
import uz.androidclub.newslight.models.ModelImpl;
import uz.androidclub.newslight.presenter.mappers.ArticleMapper;
import uz.androidclub.newslight.presenter.mappers.SourceMapper;
import uz.androidclub.newslight.presenter.mappers.SourceStringMapper;
import uz.androidclub.newslight.presenter.vo.Article;
import uz.androidclub.newslight.presenter.vo.Category;
import uz.androidclub.newslight.presenter.vo.Source;
import uz.androidclub.newslight.retro.response.models.ArticleDTO;
import uz.androidclub.newslight.retro.response.models.SourceDTO;


/**
 * Created by yusufabd on 4/25/2017.
 */

public class MainPresenterImpl extends AppConstants implements MainPresenter {

    private static final String EXTRA_STATE_ARTICLES = "extra_articles";
    private MainView mView;
    private ModelImpl mModel;
    private List<SourceDTO> mSources;
    private List<Article> mArticles;
    private List<Category> mCats;
    private AppPreferences mPref;
    private String mlang;

    public MainPresenterImpl(MainView mView) {
        this.mView = mView;
        mModel = new ModelImpl();
        mPref = new AppPreferences(mView.getViewContext());
        mlang = mPref.getLang() ? DE : ENG;
        mCats = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(Bundle bundle) {
        mView.showActivityLoading();
//        if (bundle != null)
//            mArticles = (List<Article>)bundle.getSerializable(EXTRA_STATE_ARTICLES);
//
//        if (mArticles != null && !mArticles.isEmpty()) {
//            mView.showArticleList(mArticles);
//            return;
//        }

        inflateDrawer();
        onCategorySelect(0);
    }

    @Override
    public void onSaveInstance(Bundle bundle) {
        if (mArticles != null && !mArticles.isEmpty())
            bundle.putSerializable(EXTRA_STATE_ARTICLES, new ArrayList(mArticles));
    }

    @Override
    public void onCategorySelect(int position) {
        onLoadSourceList(mCats.get(position).getId(), mlang);
    }

    @Override
    public void onLanguageSelect(boolean isDe) {
        mPref.setLang(isDe);

        mlang = mPref.getLang() ? DE : ENG;
        onCreate(null);
    }

    @Override
    public void onSourceSelect(int position) {
        onLoadArticleList(new SourceMapper().call(mSources).get(position));
    }

    @Override
    public void onLoadArticleList(Source src) {
        mModel.getArticleList(src.getId(), src.getSort()).subscribe(new Subscriber<List<ArticleDTO>>() {
            @Override
            public void onCompleted() {
                hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                hideLoading();
                mView.showError(e.getMessage());
            }

            @Override
            public void onNext(List<ArticleDTO> articleDTOs) {
                mArticles = new ArticleMapper().call(articleDTOs);
                mView.showArticleList(mArticles);
            }
        });
    }

    @Override
    public void onLoadSourceList(String cat, String lang) {
        showLoading();
        mModel.getSourceList(cat, lang)
            .subscribe(new Subscriber<List<SourceDTO>>() {
                @Override
                public void onCompleted() {
                    onLoadArticleList(new SourceMapper().call(mSources).get(0));
                }

                @Override
                public void onError(Throwable e) {
                    hideLoading();
                    mView.showError(e.getMessage());
                }

                @Override
                public void onNext(List<SourceDTO> sourceDTOs) {
                    mSources = sourceDTOs;
                    mView.showSourceMenu(new SourceStringMapper().call(mSources));
                }
            });
    }

    void hideLoading(){
        mView.hideActivityLoading();
    }

    void showLoading(){
        mView.showActivityLoading();
    }

    void inflateDrawer(){
        if (!mPref.getLang()) {
            mCats.clear();
            mCats.add(new Category("business", CATEGORY_BUSINESS, R.drawable.ic_trending_up_red_400_24dp));
            mCats.add(new Category("entertainment", CATEGORY_ENTERTAINMENT, R.drawable.ic_ondemand_video_red_400_24dp));
            mCats.add(new Category("gaming", CATEGORY_GAMING, R.drawable.ic_gamepad_red_400_24dp));
            mCats.add(new Category("general", CATEGORY_GENERAL, R.drawable.ic_remove_red_eye_red_400_24dp));
            mCats.add(new Category("music", CATEGORY_MUSIC, R.drawable.ic_audiotrack_red_400_24dp));
            mCats.add(new Category("politics", CATEGORY_POLITICS, R.drawable.ic_event_note_red_400_24dp));
            mCats.add(new Category("science and nature", CATEGORY_SCIENCE_NATURE, R.drawable.ic_ondemand_video_red_400_24dp));
            mCats.add(new Category("sport", CATEGORY_SPORT, R.drawable.ic_directions_bike_red_400_24dp));
            mCats.add(new Category("technology", CATEGORY_TECHNOLOGY, R.drawable.ic_memory_red_400_24dp));
        }else {
            mCats.clear();
            mCats.add(new Category("geschäft", CATEGORY_BUSINESS, R.drawable.ic_trending_up_red_400_24dp));
            mCats.add(new Category("general", CATEGORY_GENERAL, R.drawable.ic_remove_red_eye_red_400_24dp));
            mCats.add(new Category("technologie", CATEGORY_TECHNOLOGY, R.drawable.ic_memory_red_400_24dp));
        }

        mView.buildDrawer(mCats);
    }
}
