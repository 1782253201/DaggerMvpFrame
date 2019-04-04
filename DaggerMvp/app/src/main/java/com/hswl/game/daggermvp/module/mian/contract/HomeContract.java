package com.hswl.game.daggermvp.module.mian.contract;

import com.hswl.game.daggermvp.base.IView.IView;
import com.hswl.game.daggermvp.base.presenter.IPresenter;

public interface HomeContract {

    interface View extends IView {
       void showMsg(String s);
    }
    interface Presenter extends IPresenter<View> {
          void getHomeList();
    }

}
