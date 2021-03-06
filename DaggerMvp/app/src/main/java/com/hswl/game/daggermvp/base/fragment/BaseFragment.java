package com.hswl.game.daggermvp.base.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.classic.common.MultipleStatusView;
import com.hswl.game.daggermvp.R;
import com.hswl.game.daggermvp.base.IView.IView;
import com.hswl.game.daggermvp.base.presenter.IPresenter;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment<T extends IPresenter> extends AbstractSimpleFragment implements IView {
    @Inject
    protected T mPresenter;
    private MultipleStatusView mMultipleStatusView;

    @Override
    public void onAttach(Activity activity) {
        AndroidSupportInjection.inject(this);
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onAttach(activity);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
/*        ViewGroup mNormalView = view.findViewById(R.id.normal_view);
        if (mNormalView != null) {
            mNormalView.setVisibility(View.GONE);
        }
        mMultipleStatusView = view.findViewById(R.id.custom_multiple_status_view);
        if (mMultipleStatusView != null) {
            mMultipleStatusView.setOnClickListener(v -> mPresenter.reload());
        }*/

    }


    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        hideLoading();
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresenter != null) {
            mPresenter = null;
        }
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
