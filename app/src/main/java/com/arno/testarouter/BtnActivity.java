package com.arno.testarouter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.arno.testarouter.interf.IAppProvider;
import com.arno.testarouter.service.AppService;
import com.arno.testarouter.service.AppService2;

@Route(path = IAppProvider.APP_BTN_PATH)
public class BtnActivity extends AppCompatActivity {

    //自动注入  注解属性不能为 private 修饰
    @Autowired
    String string;
    @Autowired
    String string1;
    @Autowired
    AppService service1;
    @Autowired
    AppService2 service2;

    //手动获取
    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn);
        ARouter.getInstance().inject(this);
        TextView text = (TextView) findViewById(R.id.textview);

        //获取参数
        b = getIntent().getExtras();
        if (b != null) {
            text.setText(String.format("获取参数 - [bundle]：\n[b.boolean=%s],\n[b.string=%s],\n[string=%s],\n[string1=%s]"
                    ,String.valueOf( b.getBoolean("boolean"))
                    ,b.getString("string")
                    ,string
                    ,string1
            ));
        }else {
            text.setText(String.format("获取参数 - [bundle]：\n[string=%s],\n[string1=%s]"
                    , string
                    , string1
            ));
        }

        //获取接口服务
        if (service1!=null) {
            service1.Toast(this,"这是服务 1");
        }
        if (service2!=null) {
            service2.Toast(this,"这是服务 2");
        }

    }
}
