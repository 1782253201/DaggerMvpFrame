package com.hswl.game.daggermvp.module.mian.ui;

import com.hswl.game.daggermvp.R;
import com.hswl.game.daggermvp.base.fragment.BaseFragment;
import com.hswl.game.daggermvp.module.mian.contract.HomeContract;
import com.hswl.game.daggermvp.module.mian.presenter.HomePresenter;
import com.orhanobut.logger.Logger;

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View {

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }


    @Override
    protected void initView() {
               mPresenter.getHomeList();
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void showMsg(String s) {
        Logger.d(s);
    }
}
