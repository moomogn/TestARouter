package com.arno.moduel1;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * Created by Arno on 2017/8/6.
 */
@Route(path = IModuleProvider.MODULE_SERVICE_PATH)
public class ModuleService implements IModuleProvider {
    Context mContext;
    @Override
    public void Toast() {
        Toast.makeText(mContext, "ModuleService Toast", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {
        this.mContext = context;
        Toast.makeText(mContext, "ModuleService init", Toast.LENGTH_SHORT).show();
    }
}
