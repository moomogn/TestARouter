package com.arno.moduel1;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by Arno on 2017/8/6.
 */

public interface IModuleProvider extends IProvider {

    String MODULE_SERVICE_PATH = "/module/service";
    String MODULE_ACTI_PATH = "/module/acti";

    void Toast();

}
