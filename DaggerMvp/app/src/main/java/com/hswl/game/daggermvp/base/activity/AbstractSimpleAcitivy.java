package com.hswl.game.daggermvp.base.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gyf.barlibrary.ImmersionBar;
import com.hswl.game.daggermvp.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

public abstract class AbstractSimpleAcitivy extends SupportActivity {
    private Unbinder unBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ImmersionBar.with(this)
                .statusBarColor(R.color.colorPrimary)
                .fitsSystemWindows(true)
                .keyboardEnable(true)
                .init();
        unBinder = ButterKnife.bind(this);
        onViewCreated();
        initToolbar();
        initView();
        initEventAndData();
    }

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy(); //必须调用该方法，防止内存泄漏
        if (unBinder != null && unBinder != Unbinder.EMPTY) {
            unBinder.unbind();
            unBinder = null;
        }
    }

    protected abstract void onViewCreated();

    /**
     * 初始化ToolBar
     */
    protected abstract void initToolbar();

    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();


}
