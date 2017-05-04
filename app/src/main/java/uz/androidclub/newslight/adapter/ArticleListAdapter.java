package uz.androidclub.newslight.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import uz.androidclub.newslight.R;
import uz.androidclub.newslight.presenter.vo.Article;

/**
 * Created by yusufabd on 4/28/2017.
 */

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ViewHolder>{

    private List<Article> mList;
    private Context mCtx;

    public ArticleListAdapter(List<Article> mList) {
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mCtx = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Article item = mList.get(position);
        holder.mTitle.setText(item.getTitle());
        holder.mAuthor.setText(item.getAuthor());
        Glide.with(mCtx)
                .load(item.getImageUrl())
                .centerCrop()
                .into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImage;
        private TextView mAuthor, mTitle;

        ViewHolder(View itemView) {
            super(itemView);
            mImage = (ImageView)$(itemView, R.id.article_image);
            mAuthor = (TextView)$(itemView, R.id.article_author);
            mTitle = (TextView)$(itemView, R.id.article_title);
        }
    }

    @SuppressWarnings("UncheckedException")
    View $(View root, int resId){
        return root.findViewById(resId);
    }
}
