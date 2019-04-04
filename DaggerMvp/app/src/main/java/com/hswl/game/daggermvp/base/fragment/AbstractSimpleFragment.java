/*
 *     (C) Copyright 2019, ForgetSky.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.hswl.game.daggermvp.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hswl.game.daggermvp.app.MyApplication;
import com.squareup.leakcanary.RefWatcher;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;


public abstract class AbstractSimpleFragment extends SupportFragment {
    private Unbinder unBinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unBinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        if (isUseEventBus() && !EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        super.onAttach(context);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unBinder != null && unBinder != Unbinder.EMPTY) {
            unBinder.unbind();
            unBinder = null;
        }
    }

    public boolean isUseEventBus() {
        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = MyApplication.getRefWatcher(_mActivity);
        refWatcher.watch(this);
        if (isUseEventBus() && EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initEventAndData();
    }

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 有些初始化必须在onCreateView中，例如setAdapter,
     * 否则，会弹出 No adapter attached; skipping layout
     */
    protected abstract void initView();



    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();

}
