package uz.androidclub.newslight;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by yusufabd on 5/2/2017.
 */

public class AppPreferences extends AppConstants{

    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;

    public AppPreferences(Context context) {
        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        mEditor = mPref.edit();
    }

    public void setLang(boolean lang){
        mEditor.putBoolean(PREF_KEY_LANG, lang);
        mEditor.apply();
    }

    public boolean getLang(){
        return mPref.getBoolean(PREF_KEY_LANG, false);
    }
}
