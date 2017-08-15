package com.kuanggang.androidcustomview.widget.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kuanggang.androidcustomview.Constants;
import com.kuanggang.androidcustomview.R;
import com.kuanggang.androidcustomview.function.BrowserActivity;
import com.kuanggang.androidcustomview.model.type.HomeDataEnum;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author KG on 2017/8/15.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_main_list, null);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        HomeDataEnum entity = HomeDataEnum.values()[position];
        holder.tvTitle.setText(entity.title);
        holder.tvDesc.setText(entity.desc);
        holder.rlRoot.setOnClickListener(v -> {
            Context context = holder.rlRoot.getContext();
            Intent intent = new Intent(context, BrowserActivity.class);
            intent.putExtra(Constants.URL_KEY, entity);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return HomeDataEnum.values().length;
    }

    static class MainViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.rl_root)
        RelativeLayout rlRoot;

        MainViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
