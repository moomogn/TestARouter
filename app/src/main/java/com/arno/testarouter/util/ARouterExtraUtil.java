package com.arno.testarouter.util;

/**
 * Created by Arno on 2017/8/3.
 */

public class ARouterExtraUtil {

    private ARouterExtraUtil(){}

    /**
     * ARouter 标记的页面，可以设置一个 extra 值作为 32 个开关
     * 这个方法用于获取开关的值，需要通过 position 获取开关位数的掩码，与操作后查看是否等于零
     * @param extra extra 值
     * @param position 开关位置
     * @return 开关状态
     */
    public static boolean checkTag(int extra,int position){

        return false;
    }
}
