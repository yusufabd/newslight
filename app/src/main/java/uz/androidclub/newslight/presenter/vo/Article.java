package uz.androidclub.newslight.presenter.vo;

/**
 * Created by yusufabd on 4/26/2017.
 */

public class Article {

    private String author, title, url, imageUrl;

    public Article(String author, String title, String url, String imageUrl) {
        this.author = author;
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
