package com.arno.testarouter.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.arno.testarouter.util.L;



/**
 * Created by Arno on 2017/8/2.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ARouter.openDebug();
        ARouter.openLog();

        ARouter.init(this);
        L.i("Arouter init");
    }
}
