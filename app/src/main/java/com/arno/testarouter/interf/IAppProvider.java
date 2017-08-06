package com.arno.testarouter.interf;

import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by Arno on 2017/8/2.
 */

public interface IAppProvider extends IProvider {
    String APP_SERVICE_1 = "/app/service/1";
    String APP_SERVICE_2 = "/app/service/2";

    String APP_SPLASH_PATH = "/app/acti/splash";
    String APP_SPLASH_SERVICE = "/app/service/splash";

    String APP_BUTTON_PATH = "/app/acti/button";
    String APP_BUTTON_SERVICE = "/app/service/button";

    String APP_BTN_PATH = "/app/acti/btn";
    String APP_BTN_SERVICE = "/app/service/btn";

    String APP_INTERCEPTOR_PATH = "/app/acti/intercuptor";
    String APP_INTERCEPTOR_SERVICE = "/app/service/intercuptor";

    String APP_INVALID_PATH = "/app/invalid";
    String APP_LOGIN_PATH = "/app/acti/login";

    void Toast(Context context,String msg);

}
