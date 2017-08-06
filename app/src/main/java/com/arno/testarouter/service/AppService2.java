package com.arno.testarouter.service;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.arno.testarouter.interf.IAppProvider;
import com.arno.testarouter.util.L;

/**
 * Created by Arno on 2017/8/4.
 */

@Route(path = IAppProvider.APP_SERVICE_2)
public class AppService2 implements IAppProvider {

    @Override
    public void Toast(Context context, String msg) {
        L.d("AppService2 = Toast");
        Toast.makeText(context, "[AppService2]:"+msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {
        L.d("AppService2 - init");
    }
}
