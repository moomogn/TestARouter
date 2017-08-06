package com.arno.testarouter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.arno.testarouter.interf.IAppProvider;
import com.arno.testarouter.util.L;

@Route(path = IAppProvider.APP_BUTTON_PATH)
public class ButtonActivity extends AppCompatActivity {

    private static Activity activity;

    public static Activity getThis(){
        return activity==null?null:activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        activity = this;
    }

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.button1://普通
                ARouter.getInstance().build(IAppProvider.APP_BTN_PATH).navigation();
                break;
            case R.id.button2://带参
                Bundle b = new Bundle();
                b.putBoolean("boolean",true);
                b.putString("string","string");
                ARouter.getInstance().build(IAppProvider.APP_BTN_PATH)
                        .with(b)
                        .withString("string","带参跳转")
                        .navigation();
                break;
            case R.id.button3://带requestCode

                break;
            case R.id.button4://URI跳转
                String url = "arouter://m.aliyun.com"+IAppProvider.APP_BTN_PATH +"?string=URI跳转";
                Uri uri = Uri.parse(url);
                ARouter.getInstance().build(uri)
//                        .withString("string","URI跳转")//uri 跳转不支持这样传参的自动注入
                        .navigation();
                break;
            case R.id.button5://跳转拦截
                ARouter.getInstance().build(IAppProvider.APP_INTERCEPTOR_PATH)
                        .withString("string","跳转拦截")
                        .navigation();
                break;
            case R.id.button6://跳转动画
                ARouter.getInstance().build(IAppProvider.APP_BTN_PATH)
                        .withTransition(R.anim.in_from_right,R.anim.out_to_right)
                        .navigation();
                break;
            case R.id.button7://NavigationCallback
                ARouter.getInstance().build(IAppProvider.APP_BTN_PATH)
                        .withString("string","NavigationCallback 处理跳转结果")
                        .navigation(ButtonActivity.getThis(), new NavigationCallback() {
                            @Override
                            public void onFound(Postcard postcard) {
                                Toast.makeText(ButtonActivity.this, "[onFound]:[postcard.path]="+postcard.getPath(), Toast.LENGTH_SHORT).show();
                                L.d(postcard.toString());
                            }

                            @Override
                            public void onLost(Postcard postcard) {
                                Toast.makeText(ButtonActivity.this, "[onLost]:[postcard.path]=", Toast.LENGTH_SHORT).show();
                                L.d(postcard==null?"null":postcard.toString());
                            }

                            @Override
                            public void onArrival(Postcard postcard) {
                                Toast.makeText(ButtonActivity.this, "[onArrival]:[postcard.path]="+postcard.getPath(), Toast.LENGTH_SHORT).show();
                                L.d(postcard.toString());
                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Toast.makeText(ButtonActivity.this, "[onInterrupt]:[postcard.path]="+postcard.getPath(), Toast.LENGTH_SHORT).show();
                                L.d(postcard.toString());
                            }
                        });
                break;
            case R.id.button8://跳转失败
                ARouter.getInstance().build("/x/x").navigation();
                break;
            case R.id.button9://跳转失败
                ARouter.getInstance().build(IAppProvider.APP_BTN_PATH).navigation();
                break;
            case R.id.button10://跳转失败
                ARouter.getInstance().build(IAppProvider.APP_BTN_PATH).navigation();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activity = null;
    }
}
