package uz.androidclub.newslight;

import android.view.View;

/**
 * Created by yusufabd on 4/26/2017.
 */

public class AppConstants {
    public static final String NEWS_API_KEY = "dcb737fbf09c4bd6ba5c128be1e443e9";

    public static final String SORT_BY_LATEST = "latest";
    public static final String SORT_BY_POPULAR = "popular";
    public static final String SORT_BY_TOP = "top";

    public static final String CATEGORY_BUSINESS = "business";
    public static final String CATEGORY_ENTERTAINMENT = "entertainment";
    public static final String CATEGORY_GAMING = "gaming";
    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_MUSIC = "music";
    public static final String CATEGORY_POLITICS = "politics";
    public static final String CATEGORY_SCIENCE_NATURE = "science-and-nature";
    public static final String CATEGORY_SPORT = "sport";
    public static final String CATEGORY_TECHNOLOGY = "technology";

    public static final String COUNTRY_AUSTRIA = "au";
    public static final String COUNTRY_GERMANY = "de";
    public static final String COUNTRY_BRITAIN = "gb";
    public static final String COUNTRY_INDIA = "in";
    public static final String COUNTRY_ITALY = "it";
    public static final String COUNTRY_USA = "us";


    @SuppressWarnings("UncheckedException")
    View $(View root, int resId){
        return root.findViewById(resId);
    }
}
