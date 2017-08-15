package com.kuanggang.androidcustomview.function;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuanggang.androidcustomview.Constants;
import com.kuanggang.androidcustomview.R;
import com.kuanggang.androidcustomview.base.BaseActivity;
import com.kuanggang.androidcustomview.model.type.HomeDataEnum;
import com.kuanggang.androidcustomview.utils.TextUtil;
import com.kuanggang.androidcustomview.utils.ToastUtil;
import com.kuanggang.androidcustomview.widget.customview.WebViewLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author KG on 2017/7/5.
 */

public class BrowserActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_close)
    ImageView ivClose;
    @BindView(R.id.webViewLayout)
    WebViewLayout webViewLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        ButterKnife.bind(this);
        TextUtil.setFakeBoldText(tvTitle);

        initActionBar(toolbar);
        initListener();
        loadUrl();
    }

    private void initListener() {
        ivClose.setOnClickListener(this);
    }

    private void loadUrl() {
        HomeDataEnum entity = (HomeDataEnum) getIntent().getSerializableExtra(Constants.URL_KEY);
        if (entity == null) {
            ToastUtil.show(this, R.string.error_date);
            return;
        }
        tvTitle.setText(entity.title);
        webViewLayout.loadUrl(entity.url);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_close:
                finish();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (webViewLayout == null) return;
        webViewLayout.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (webViewLayout == null) return;
        webViewLayout.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webViewLayout == null) return;
        webViewLayout.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webViewLayout.goBack()) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
