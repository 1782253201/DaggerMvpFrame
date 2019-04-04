package com.hswl.game.daggermvp.di.component;



import com.hswl.game.daggermvp.app.MyApplication;
import com.hswl.game.daggermvp.di.module.AbstractAllAcitivityModules;
import com.hswl.game.daggermvp.di.module.AbstractAllFragmentModule;
import com.hswl.game.daggermvp.di.module.AppModule;
import com.hswl.game.daggermvp.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AbstractAllAcitivityModules.class,
        AbstractAllFragmentModule.class,
        AppModule.class,
        HttpModule.class
})
public interface AppComponent {
    void inject(MyApplication application);
}
