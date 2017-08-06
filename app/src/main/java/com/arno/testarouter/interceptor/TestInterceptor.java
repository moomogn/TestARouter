package com.arno.testarouter.interceptor;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.arno.testarouter.ButtonActivity;
import com.arno.testarouter.interf.IAppProvider;
import com.arno.testarouter.util.Constant;
import com.arno.testarouter.util.L;

/**
 * Created by Arno on 2017/8/2.
 */
@Interceptor(priority = 7)
public class TestInterceptor implements IInterceptor {
    Context mContext;//MyApp

    /**
     * 在回调中，如果要改变路由目标，不能通过修改接口中的 postcard.path 的值
     * 如果要达到目的，还是需要重新获取ARouter对象进行操作。
     * @param postcard 路由信息实体类
     * @param callback 回调
     */
    @Override
    public void process(final Postcard postcard, final InterceptorCallback callback) {
        L.w("postcard:"+postcard);
        if (IAppProvider.APP_INTERCEPTOR_PATH.equals(postcard.getPath())) {
            if (!Constant.hasLogin) {
                final AlertDialog.Builder ab = new AlertDialog.Builder(ButtonActivity.getThis());
                ab.setCancelable(false);
                ab.setTitle("温馨提醒");
                ab.setMessage("需要登陆才能跳转？(触发了拦截器，拦截了本次跳转)");
                ab.setNegativeButton("登陆", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        postcard.withString("targetPath",postcard.getPath());
//                        postcard.setPath(IAppProvider.APP_LOGIN_PATH);
//                        postcard.navigation();
                        ARouter.getInstance().build(IAppProvider.APP_LOGIN_PATH)
                                .withString("targetPath",postcard.getPath())
                                .navigation();
                        callback.onInterrupt(null);
                    }
                });
                ab.setPositiveButton("算了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        callback.onInterrupt(null);
                    }
                });

                Handler handler = new Handler(mContext.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ab.create().show();
                    }
                });
            }else{
                callback.onContinue(postcard);
            }
        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        this.mContext = context;
        L.w(TestInterceptor.class.getName() + " has init.");
    }
}
