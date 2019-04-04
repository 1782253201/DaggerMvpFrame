
package com.hswl.game.daggermvp.di.module;


import com.hswl.game.daggermvp.app.MyApplication;
import com.hswl.game.daggermvp.http.HttpHelper;
import com.hswl.game.daggermvp.http.HttpHelperImpl;
import com.hswl.game.daggermvp.http.manage.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    MyApplication provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(HttpHelperImpl httpHelperImpl) {
        return httpHelperImpl;
    }



    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper) {
        return new DataManager(httpHelper);
    }


}
