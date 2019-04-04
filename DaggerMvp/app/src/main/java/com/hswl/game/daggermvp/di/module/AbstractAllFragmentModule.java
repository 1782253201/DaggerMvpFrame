package com.hswl.game.daggermvp.di.module;


import com.hswl.game.daggermvp.di.component.BaseFragmentComponent;
import com.hswl.game.daggermvp.module.mian.ui.HomeFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = BaseFragmentComponent.class)
public abstract class AbstractAllFragmentModule {
    @ContributesAndroidInjector(modules = HomeFragmentModule.class)
    abstract HomeFragment homeFragment();


}
