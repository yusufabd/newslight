package uz.androidclub.newslight;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import uz.androidclub.newslight.presenter.vo.Article;

/**
 * Created by yusufabd on 4/26/2017.
 */

public interface MainView {
    void showSourceMenu(ArrayAdapter<String> adapter);
    void showArticleList(List<Article> list);
    void showError(String error);
    void showActivityLoading();
    void hideActivityLoading();

    Context getViewContext();
}
