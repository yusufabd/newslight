package uz.androidclub.newslight.presenter.vo;

import java.util.List;

/**
 * Created by yusufabd on 4/26/2017.
 */

public class Source {

    private String id, name;
    private List<String> sort;

    public Source(String id, String name, List<String> sort) {
        this.id = id;
        this.name = name;
        this.sort = sort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSort() {
        return sort;
    }

    public void setSort(List<String> sort) {
        this.sort = sort;
    }
}
