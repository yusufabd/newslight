package uz.androidclub.newslight.presenter;

import android.os.Bundle;

import uz.androidclub.newslight.presenter.vo.Source;

/**
 * Created by yusufabd on 4/25/2017.
 */

public interface MainPresenter {
    void onCreate(Bundle bundle);
    void onSaveInstance(Bundle bundle);
    void onCategorySelect(int position);
    void onLanguageSelect(boolean isDe);
    void onSourceSelect(int position);
    void onLoadArticleList(Source src);
    void onLoadSourceList(String lang, String cat);
}