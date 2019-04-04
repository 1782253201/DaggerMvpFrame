package com.hswl.game.daggermvp.module.mian.presenter;

import com.hswl.game.daggermvp.base.presenter.BasePresenter;

import com.hswl.game.daggermvp.module.mian.contract.MainContract;

import javax.inject.Inject;


public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
         @Inject
    MainPresenter(){}

}
