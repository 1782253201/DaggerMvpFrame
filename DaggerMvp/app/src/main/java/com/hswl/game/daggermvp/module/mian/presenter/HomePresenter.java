package com.hswl.game.daggermvp.module.mian.presenter;

import com.hswl.game.daggermvp.R;
import com.hswl.game.daggermvp.app.MyApplication;
import com.hswl.game.daggermvp.base.presenter.BasePresenter;
import com.hswl.game.daggermvp.http.BaseResponse;
import com.hswl.game.daggermvp.http.rx.BaseObserver;
import com.hswl.game.daggermvp.module.mian.bean.Homebean;
import com.hswl.game.daggermvp.module.mian.contract.HomeContract;
import com.hswl.game.daggermvp.utils.RxUtils;
import com.orhanobut.logger.Logger;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.ResourceObserver;

public class HomePresenter extends BasePresenter<HomeContract.View>  implements HomeContract.Presenter{
       @Inject
       HomePresenter(){}

    @Override
    public void getHomeList() {
        addSubscribe(mDataManager.getHomeList()
                .compose(RxUtils.SchedulerTransformer())
                .filter(homelist -> mView != null)
                .subscribeWith(new ResourceObserver<Homebean>() {
                                   @Override
                                   public void onNext(Homebean homebean) {
                                           mView.showMsg(homebean.getNextPageUrl());
                                   }

                                   @Override
                                   public void onError(Throwable e) {
                                       Logger.d(e.getMessage());
                                   }

                                   @Override
                                   public void onComplete() {

                                   }
                               }));



                    /*    new BaseObserver<Homebean>(mView,
                   "失败",
                        true) {
                    @Override
                    public void onSuccess(Homebean articleListData) {
                        mView.showMsg(articleListData.getNextPageUrl());
                    }
                }));*/
    }
}
