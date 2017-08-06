package com.arno.testarouter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.arno.testarouter.interf.IAppProvider;
import com.arno.testarouter.util.Constant;
import com.arno.testarouter.util.L;

@Route(path = IAppProvider.APP_LOGIN_PATH)
public class LoginActivity extends AppCompatActivity {
    //注解属性不能为 private 修饰
    @Autowired
    String targetPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ARouter.getInstance().inject(this);
    }

    public void onClick(View view){
        Constant.hasLogin = true;
        L.i(targetPath);
        if (targetPath!=null) {
            ARouter.getInstance().build(targetPath).withString("extra",targetPath).navigation();
        }
        finish();
    }

}
