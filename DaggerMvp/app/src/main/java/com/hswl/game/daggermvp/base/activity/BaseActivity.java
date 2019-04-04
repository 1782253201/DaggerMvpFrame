package com.hswl.game.daggermvp.base.activity;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

import com.classic.common.MultipleStatusView;
import com.hswl.game.daggermvp.R;
import com.hswl.game.daggermvp.base.IView.IView;
import com.hswl.game.daggermvp.base.presenter.IPresenter;
import com.hswl.game.daggermvp.utils.CommonUtils;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public abstract class BaseActivity<T extends IPresenter> extends AbstractSimpleAcitivy implements HasSupportFragmentInjector,IView {
    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentDispatchingAndroidInjector;
    @Inject
    protected T mPresenter;

    public Context mContext;//上下文对象

    private MultipleStatusView mMultipleStatusView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (isUseEventBus() && !EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        super.onCreate(savedInstanceState);
        mContext=this;
        AndroidInjection.inject((Activity) mContext);
    }

    public boolean isUseEventBus() {
        return false;
    }

    @Override
    protected void onViewCreated() {
//        ViewGroup mNormalView = findViewById(R.id.normal_view);
//        if (mNormalView != null) {
//            mNormalView.setVisibility(View.GONE);
//        }
//        mMultipleStatusView = findViewById(R.id.custom_multiple_status_view);
        if (mMultipleStatusView != null) {
            mMultipleStatusView.setOnClickListener(v -> mPresenter.reload());
        }

        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        if (isUseEventBus() && EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        hideLoading();
        super.onDestroy();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentDispatchingAndroidInjector;
    }

    @Override
    public void onBackPressedSupport() {
        CommonUtils.hideKeyBoard(this, this.getWindow().getDecorView().getRootView());
        super.onBackPressedSupport();
    }

    @Override
    public void showErrorMsg(String errorMsg) {

    }

    @Override
    public void showLoading() {
        if (mMultipleStatusView == null) return;
        mMultipleStatusView.showLoading();
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void showError() {
        if (mMultipleStatusView == null) return;
        mMultipleStatusView.showError();
    }

    @Override
    public void showNoNetwork() {
        if (mMultipleStatusView == null) return;
        mMultipleStatusView.showNoNetwork();
    }

    @Override
    public void showEmpty() {
        if (mMultipleStatusView == null) return;
        mMultipleStatusView.showEmpty();
    }

    @Override
    public void showContent() {
        if (mMultipleStatusView == null) return;
        mMultipleStatusView.showContent();
    }

    @Override
    public void handleLoginSuccess() {
    }

    @Override
    public void handleLogoutSuccess() {
    }

}
