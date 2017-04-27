package uz.androidclub.newslight.presenter.mappers;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import uz.androidclub.newslight.presenter.vo.Article;
import uz.androidclub.newslight.retro.response.models.ArticleDTO;

/**
 * Created by yusufabd on 4/26/2017.
 */

public class ArticleMapper implements Func1<List<ArticleDTO>, List<Article>> {
    @Override
    public List<Article> call(List<ArticleDTO> articleDTOs) {
        if (articleDTOs == null)
            return null;

        return Observable.from(articleDTOs)
                .map(a -> new Article(a.getAuthor(), a.getTitle(), a.getUrl(), a.getUrlToImage()))
                .toList()
                .toBlocking()
                .first();
    }
}
