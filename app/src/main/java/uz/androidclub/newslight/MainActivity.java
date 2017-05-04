package uz.androidclub.newslight;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.List;

import uz.androidclub.newslight.adapter.ArticleListAdapter;
import uz.androidclub.newslight.adapter.CategoryListAdapter;
import uz.androidclub.newslight.presenter.MainPresenterImpl;
import uz.androidclub.newslight.presenter.vo.Article;
import uz.androidclub.newslight.presenter.vo.Category;

public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemSelectedListener,
        CompoundButton.OnCheckedChangeListener, ItemClickSupport.OnItemClickListener{

    private MainPresenterImpl presenter;
    private AppPreferences pref;

    @SuppressWarnings("UncheckedException")
    View $(int resId){
        return findViewById(resId);
    }

    private ConstraintLayout constraintParent;
    private Toolbar toolbar;
    private Spinner spinner;
    private Switch aSwitch;
    private ProgressBar progressBar;
    private RecyclerView recyclerArticles, recyclerCategories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenterImpl(this);
        pref = new AppPreferences(this);
        constraintParent = (ConstraintLayout) $(R.id.constraint_parent);
        toolbar = (Toolbar) $(R.id.toolbar);
        spinner = (Spinner) $(R.id.spinner_sources);
        aSwitch = (Switch) $(R.id.switchLang);
        aSwitch.setChecked(pref.getLang());
        aSwitch.setOnCheckedChangeListener(this);
        progressBar = (ProgressBar) $(R.id.progress_bar);
        recyclerCategories = (RecyclerView) $(R.id.recycler_categories);
        recyclerCategories.setLayoutManager(new LinearLayoutManager(this));
        recyclerArticles = (RecyclerView) $(R.id.recycler_articles);
        recyclerArticles.setLayoutManager(new LinearLayoutManager(this));
        setSupportActionBar(toolbar);
        setTitle("");

        presenter.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstance(outState);
    }

    @Override
    public void buildDrawer(List<Category> list) {
        CategoryListAdapter adapter = new CategoryListAdapter(list);
        recyclerCategories.setAdapter(adapter);
        recyclerCategories.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        ItemClickSupport.addTo(recyclerCategories).setOnItemClickListener(this);
    }

    @Override
    public void showSourceMenu(List<String> list) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void showArticleList(List<Article> list) {
        ArticleListAdapter articleListAdapter = new ArticleListAdapter(list);
        recyclerArticles.setAdapter(articleListAdapter);
    }

    @Override
    public void showError(String error) {
        Log.e("log_tag", "Error: " + error);
        Snackbar.make(constraintParent, error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showActivityLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideActivityLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public Context getViewContext() {
        return this;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        presenter.onSourceSelect(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        presenter.onLanguageSelect(isChecked);
    }

    @Override
    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
        presenter.onCategorySelect(position);
    }
}
