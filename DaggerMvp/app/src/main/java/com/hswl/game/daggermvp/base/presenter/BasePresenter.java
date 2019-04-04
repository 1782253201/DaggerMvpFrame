package com.hswl.game.daggermvp.base.presenter;

import com.hswl.game.daggermvp.base.IView.IView;
import com.hswl.game.daggermvp.http.manage.DataManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<T extends IView> implements IPresenter<T>  {
    protected T mView;

    @Inject
    public DataManager mDataManager;

    private CompositeDisposable compositeDisposable;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    @Override
    public void reload() {

    }


/*    @Override
    public void setLoginStatus(boolean loginStatus) {
        mDataManager.setLoginStatus(loginStatus);
    }*/

/*    @Override
    public boolean getLoginStatus() {
        return mDataManager.getLoginStatus();
    }*/

/*    @Override
    public String getLoginAccount() {
        return mDataManager.getLoginAccount();
    }*/

    /*@Override
    public void setLoginAccount(String account) {
        mDataManager.setLoginAccount(account);
    }*/

    protected void addSubscribe(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

}
