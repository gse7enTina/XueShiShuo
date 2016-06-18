package com.se7entina.app.widgets;

import android.content.Context;
import android.graphics.Color;

import com.se7entina.app.R;


/**
 * Created by se7en on 2015/9/8.
 */
public class ToastTools {

    private ToastTools() {
    }

    public static final String TAG = "ToastTools";


    public static void show(Context context, int resId) {
        new NormalAlertDialog(context).builder()
                .setTitle(R.string.tips_strings)
                .setTitleColor(Color.RED)
                .setMsg(context.getString(resId))
                .show();
    }

    public static void show(Context context, String message) {
        new NormalAlertDialog(context).builder()
                .setTitle(R.string.tips_strings)
                .setTitleColor(Color.RED)
                .setMsg(message)
                .show();
    }

}