package com.hswl.game.daggermvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.hswl.game.daggermvp.base.activity.BaseActivity;
import com.hswl.game.daggermvp.module.constan.Constans;
import com.hswl.game.daggermvp.module.mian.bean.TabEntity;
import com.hswl.game.daggermvp.module.mian.contract.MainContract;
import com.hswl.game.daggermvp.module.mian.presenter.MainPresenter;
import com.hswl.game.daggermvp.module.mian.ui.HomeFragment;

import java.util.ArrayList;

import butterknife.BindView;


public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {


    @BindView(R.id.status_bar_view)
    View statusBarView;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fragment_group)
    FrameLayout fragmentGroup;
    @BindView(R.id.tl_1)
    CommonTabLayout tl1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private int mCurrentFgIndex = 0;
    private int mLastFgIndex = -1;

    private String[] mTitles = {"每日精选", "发现", "热门", "我的"};
    // 未被选中的图标
    private int[] mIconUnSelectIds = {R.mipmap.ic_home_normal, R.mipmap.ic_discovery_normal, R.mipmap.ic_hot_normal, R.mipmap.ic_mine_normal};
    // 被选中的图标
    private int[] mIconSelectIds = {R.mipmap.ic_home_selected, R.mipmap.ic_discovery_selected, R.mipmap.ic_hot_selected, R.mipmap.ic_mine_selected};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private HomeFragment homeFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mCurrentFgIndex = savedInstanceState.getInt(Constans.CURRENT_FRAGMENT_KEY);
        }
        super.onCreate(savedInstanceState);
    }

    //保存fragment状态
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(Constans.CURRENT_FRAGMENT_KEY, mCurrentFgIndex);
    }


    @Override
    protected void initToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            toolbarTitle.setText(R.string.home_pager);
        }
    }

    @Override
    protected void initView() {
        showFragment(mCurrentFgIndex);
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnSelectIds[i]));
        }
        tl1.setTabData(mTabEntities);

    }

    @Override
    protected void initEventAndData() {
    }


    private void showFragment(int index) {
        mCurrentFgIndex = index;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        mLastFgIndex = index;
        switch (index) {
            case Constans.TYPE_HOME_PAGER:
                toolbarTitle.setText(getString(R.string.home_pager));
                if (homeFragment == null) {
                    homeFragment = HomeFragment.newInstance();
                    transaction.add(R.id.fragment_group, homeFragment);
                }
                transaction.show(homeFragment);
                break;
            case Constans.TYPE_KNOWLEDGE:
                break;
            case Constans.TYPE_NAVIGATION:
                toolbarTitle.setText(getString(R.string.home_hot));

                break;
            case Constans.TYPE_WX_ARTICLE:
                toolbarTitle.setText(getString(R.string.home_mine));

                break;
            default:

                break;
        }
        transaction.commit();
    }


    private void hideFragment(FragmentTransaction transaction) {
        switch (mLastFgIndex) {
            case Constans.TYPE_HOME_PAGER:
                if (homeFragment != null) {
                    transaction.hide(homeFragment);
                }
                break;
            case Constans.TYPE_KNOWLEDGE:

                break;
            case Constans.TYPE_NAVIGATION:

                break;
            case Constans.TYPE_WX_ARTICLE:

                break;
            default:
                break;
        }
    }


    public void showMessage(int position, int num) {
        tl1.showMsg(position, num);
        tl1.setMsgMargin(position, 1, 3);
    }
}
