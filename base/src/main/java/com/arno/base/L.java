package com.arno.base;

import android.util.Log;

/**
 * Created by Arno on 2017/8/2.
 */

public class L {
    private static final String TAG = "AAA";
    private L(){}

    public static void i(String msg){
        Log.i(TAG, "[i]: "+msg);
    }

    public static void w(String msg){
        Log.w(TAG, "[w]: "+msg );
    }

}
