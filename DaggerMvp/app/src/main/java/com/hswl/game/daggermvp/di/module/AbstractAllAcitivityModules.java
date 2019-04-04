package com.hswl.game.daggermvp.di.module;


import com.hswl.game.daggermvp.MainActivity;
import com.hswl.game.daggermvp.di.component.BaseActivityComponent;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = {BaseActivityComponent.class})
public abstract class AbstractAllAcitivityModules {
    @ContributesAndroidInjector(modules = MainAcitivityModule.class)
    abstract MainActivity contributesMainActivityInjector();



}
