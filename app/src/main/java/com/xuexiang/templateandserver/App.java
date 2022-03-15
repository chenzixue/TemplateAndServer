/*
 * Copyright (C) 2019 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.xuexiang.templateandserver;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.multidex.MultiDex;

import com.xuexiang.server.model.DaoMaster;
import com.xuexiang.server.model.DaoSession;
import com.xuexiang.templateandserver.utils.sdkinit.XBasicLibInit;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * @author xuexiang
 * @since 2018/11/7 下午1:12
 */
public class App extends Application {

    public static DaoSession mSession;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //解决4.x运行崩溃的问题
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initLibs();
        initDatabase();
    }

    /**
     * 初始化数据库
     */
    private void initDatabase() {

        QueryBuilder.LOG_SQL = isDebug();
        QueryBuilder.LOG_VALUES = isDebug();

        // 1、获取需要连接的数据库
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "app.db");
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        // 2、创建数据库连接
        DaoMaster daoMaster = new DaoMaster(db);
        // 3、创建数据库会话
        mSession = daoMaster.newSession();
    }

    /**
     * 初始化基础库
     */
    private void initLibs() {
        XBasicLibInit.init(this);
    }


    /**
     * @return 当前app是否是调试开发模式
     */
    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    // 供外接使用
    public static DaoSession getDaoSession() {
        return mSession;
    }


}
