package com.hswl.game.daggermvp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.hswl.game.daggermvp.app.MyApplication;

public class CommonUtils {

    //判断有没有网
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) MyApplication.getContext().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

    public static void hideKeyBoard(Context context, View view) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) context.getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
