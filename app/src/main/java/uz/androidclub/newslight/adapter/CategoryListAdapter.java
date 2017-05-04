package uz.androidclub.newslight.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import uz.androidclub.newslight.R;
import uz.androidclub.newslight.presenter.vo.Category;

/**
 * Created by yusufabd on 5/2/2017.
 */

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.VH>{

    private List<Category> mList;

    public CategoryListAdapter(List<Category> mList) {
        this.mList = mList;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false));
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        Category c = mList.get(position);
        holder.icon.setImageResource(c.getIcon());
        holder.title.setText(c.getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class VH extends ViewHolder{
        ImageView icon;
        TextView title;
        public VH(View itemView) {
            super(itemView);
            icon = (ImageView)$(itemView, R.id.category_icon);
            title = (TextView) $(itemView, R.id.category_text);
        }
    }

    @SuppressWarnings("UncheckedException")
    View $(View root, int resId){
        return root.findViewById(resId);
    }
}
