package com.arno.testarouter.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.arno.testarouter.interf.IAppProvider;
import com.arno.testarouter.util.L;

/**
 * Created by Arno on 2017/8/2.
 */

@Route(path = "/xxx/xxx")
public class DegradeServiceImpl implements DegradeService {
    @Override
    public void onLost(Context context, final Postcard postcard) {
        L.w(DegradeServiceImpl.class.getName() + " onLost-path="+postcard.getPath());
        if (IAppProvider.APP_INTERCEPTOR_PATH.equals(postcard.getPath())) {

        }
    }

    @Override
    public void init(Context context) {
        L.w(DegradeServiceImpl.class.getName() + " has init.");
    }
}
