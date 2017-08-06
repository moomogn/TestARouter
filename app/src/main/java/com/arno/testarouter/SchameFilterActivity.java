
package com.arno.testarouter;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.arno.testarouter.util.L;

public class SchameFilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schame_filter);
        // 外面用户点击的URL
        Uri uri = getIntent().getData();
        L.i("SchameFilterActivity onCreate: uri="+uri.toString());
        // 直接传递给ARouter即可
        ARouter.getInstance().build(uri).navigation();
        finish();

    }
}
