package uz.androidclub.newslight;

import android.content.Context;
import java.util.List;

import uz.androidclub.newslight.presenter.vo.Article;
import uz.androidclub.newslight.presenter.vo.Category;

/**
 * Created by yusufabd on 4/26/2017.
 */

public interface MainView {
    void buildDrawer(List<Category> list);
    void showSourceMenu(List<String> strings);
    void showArticleList(List<Article> list);
    void showError(String error);
    void showActivityLoading();
    void hideActivityLoading();

    Context getViewContext();
}
