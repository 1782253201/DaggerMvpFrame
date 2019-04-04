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

package com.hswl.game.daggermvp.http.manage;


import com.hswl.game.daggermvp.http.BaseResponse;
import com.hswl.game.daggermvp.http.HttpHelper;
import com.hswl.game.daggermvp.module.mian.bean.Homebean;

import java.util.List;

import io.reactivex.Observable;


public class DataManager implements HttpHelper {
    private HttpHelper mHttpHelper;


    public DataManager(HttpHelper httpHelper) {
        mHttpHelper = httpHelper;
    }

    @Override
    public Observable<Homebean> getHomeList() {
        return mHttpHelper.getHomeList();
    }

/*    @Override
    public Observable<BaseResponse<ArticleListData>> getArticleList(int pageNum) {
        return mHttpHelper.getArticleList(pageNum);
    }*/



}
