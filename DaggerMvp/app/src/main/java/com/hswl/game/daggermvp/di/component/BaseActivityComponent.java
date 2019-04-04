package com.hswl.game.daggermvp.di.component;

import com.hswl.game.daggermvp.base.activity.BaseActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;


@Subcomponent(modules = {AndroidInjectionModule.class})
public interface BaseActivityComponent extends AndroidInjector<BaseActivity> {
    /**
     * 每一个继承于BaseActivity的Activity都继承于同一个子组件
     */
    @Subcomponent.Builder
    abstract class BaseBuilder extends AndroidInjector.Builder<BaseActivity>{

    }

}
