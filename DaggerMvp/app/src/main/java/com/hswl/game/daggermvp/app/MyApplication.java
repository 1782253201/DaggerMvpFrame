package com.hswl.game.daggermvp.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.hswl.game.daggermvp.di.component.DaggerAppComponent;
import com.hswl.game.daggermvp.di.module.AppModule;
import com.hswl.game.daggermvp.di.module.HttpModule;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MyApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mAndroidInjector;
    }

    private static Context context;
    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .httpModule(new HttpModule())
                .build().inject(this);
        refWatcher = setupLeakCanary();
    }
    private RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    public static Context getContext() {
        return context;
    }

}
