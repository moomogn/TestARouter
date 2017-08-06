package com.arno.testarouter;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.arno.testarouter.interf.IAppProvider;
import com.arno.testarouter.util.L;


@Route(path = IAppProvider.APP_SPLASH_PATH)
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        L.i("SplashActivity onCreate");

        Handler handler = new Handler(getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ARouter.getInstance().build(IAppProvider.APP_BUTTON_PATH).navigation();
            }
        },1*1000);

    }
}
