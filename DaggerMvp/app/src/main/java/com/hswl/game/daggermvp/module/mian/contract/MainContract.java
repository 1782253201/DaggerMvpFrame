package com.hswl.game.daggermvp.module.mian.contract;

import com.hswl.game.daggermvp.base.IView.IView;
import com.hswl.game.daggermvp.base.presenter.IPresenter;

public interface MainContract {
    interface View extends IView {

    }
    interface Presenter extends IPresenter<MainContract.View> {

    }
}
