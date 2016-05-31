package com.se7entina.app.widgets;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Class:
 * Created by se7enTina on 2015/11/30.
 * Description:
 */
public class CharType {

    public static final int TYPE_FARR = 0;
    public static final int TYPE_LIGHT = 1;
    public static final int TYPE_LUCI = 2;

    public static Typeface getCharType(Context context, int type) {
        switch (type) {
            case TYPE_FARR:
                return Typeface.createFromAsset(context.getAssets(), "fonts/Farrington7B_Qiqi.ttf");
            case TYPE_LIGHT:
                return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");
            case TYPE_LUCI:
                return Typeface.createFromAsset(context.getAssets(), "fonts/LucidaGrande.ttc");
            default:
                return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");
        }
    }
}
