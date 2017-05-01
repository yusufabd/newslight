package uz.androidclub.newslight;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.List;

import uz.androidclub.newslight.adapter.ArticleListAdapter;
import uz.androidclub.newslight.presenter.vo.Article;

public class MainActivity extends AppCompatActivity implements MainView{
    MainPresenterImpl presenter;
    ArticleListAdapter articleListAdapter;

    @SuppressWarnings("UncheckedException")
    View $(int resId){
        return findViewById(resId);
    }

    Toolbar toolbar;
    Spinner spinner;
    Switch aSwitch;
    RecyclerView recyclerArticles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) $(R.id.toolbar);
        spinner = (Spinner) $(R.id.spinner_sources);
        aSwitch = (Switch) $(R.id.switchLang);
        recyclerArticles = (RecyclerView) $(R.id.recycler_articles);
        recyclerArticles.setLayoutManager(new LinearLayoutManager(this));
        setSupportActionBar(toolbar);
        setTitle("");

        presenter = new MainPresenterImpl(this);
    }

    @Override
    public void showSourceMenu(ArrayAdapter<String> adapter) {
        spinner.setAdapter(adapter);
    }

    @Override
    public void showArticleList(List<Article> list) {
        articleListAdapter = new ArticleListAdapter(list);
        recyclerArticles.setAdapter(articleListAdapter);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showActivityLoading() {

    }

    @Override
    public void hideActivityLoading() {

    }

    @Override
    public Context getViewContext() {
        return this;
    }
}
