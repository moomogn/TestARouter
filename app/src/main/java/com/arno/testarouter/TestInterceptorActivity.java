package com.arno.testarouter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.arno.testarouter.interf.IAppProvider;

/**
 * Route 注解中的 extras 值可以在路由跳转的 postcard 中获取。方法：postcard.getExtra()
 */
@Route(path = IAppProvider.APP_INTERCEPTOR_PATH,extras = 0x0010)
public class TestInterceptorActivity extends AppCompatActivity {
    @Autowired
    String extra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_interceptor);
        ARouter.getInstance().inject(this);

        TextView text = (TextView) findViewById(R.id.textview);
        text.setText(String.format("获取参数 - [bundle]：\n[extra=%s]"
                ,extra
        ));

    }
}
