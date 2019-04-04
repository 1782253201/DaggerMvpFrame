
package com.hswl.game.daggermvp.base.presenter;

import com.hswl.game.daggermvp.base.IView.IView;

public interface IPresenter<T extends IView> {

    /**
     * attachView
     *
     * @param view view
     */
    void attachView(T view);
    /**
     * detachView
     */
    void detachView();

    void reload();

    /**
     * Set login status
     *
     * @param loginStatus login status
     */
//    void setLoginStatus(boolean loginStatus);

    /**
     * Get login status
     *
     * @return if is login status
     */
//    boolean getLoginStatus();

    /**
     * Get login account
     *
     * @return login account
     */
//    String getLoginAccount();

    /**
     * Set login status
     *
     * @param account account
     */
//    void setLoginAccount(String account);

}
