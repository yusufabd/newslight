package uz.androidclub.newslight;

import java.util.List;

import rx.Observable;
import uz.androidclub.newslight.retro.response.models.ArticleDTO;
import uz.androidclub.newslight.retro.response.models.SourceDTO;

/**
 * Created by yusufabd on 4/27/2017.
 */

public interface Model {
    Observable<List<SourceDTO>> getSourceList(String category, String language);
    Observable<List<ArticleDTO>> getArticleList(String source);
}
