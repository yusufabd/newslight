package uz.androidclub.newslight.presenter.vo;

/**
 * Created by yusufabd on 5/2/2017.
 */

public class Category {

    private String name;
    private String id;
    private int icon;

    public Category(String name, String id, int icon) {
        this.name = name;
        this.id = id;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}