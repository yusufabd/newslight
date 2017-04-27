package uz.androidclub.newslight;

import java.util.List;

import uz.androidclub.newslight.retro.response.models.ArticleDTO;

/**
 * Created by yusufabd on 4/26/2017.
 */

public interface MainView {
    void showArticleList(List<ArticleDTO> list);
    void showError(String error);
}
