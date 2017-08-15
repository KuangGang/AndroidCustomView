package com.kuanggang.androidcustomview.function;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.kuanggang.androidcustomview.R;
import com.kuanggang.androidcustomview.base.BaseActivity;
import com.kuanggang.androidcustomview.utils.TextUtil;
import com.kuanggang.androidcustomview.widget.adapter.MainAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    @BindView(R.id.rv_content)
    RecyclerView rvContent;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
        initActionBar(toolbar);
    }

    private void init() {
        TextUtil.setFakeBoldText(tvTitle);

        rvContent.setLayoutManager(new LinearLayoutManager(this));
        rvContent.setAdapter(new MainAdapter());
    }
}
