package com.kuanggang.androidcustomview;

import android.app.Application;

import com.kuanggang.androidcustomview.model.type.PageSizeEnum;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * @author KG on 2017/6/5.
 */

public class AppApplication extends Application {

    public static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        Logger.init("AndroidCustomView").logLevel(BuildConfig.isDebug ? LogLevel.FULL : LogLevel.NONE);
    }
}
