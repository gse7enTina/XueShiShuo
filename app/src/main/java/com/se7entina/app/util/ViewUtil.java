package com.se7entina.app.util;

import android.view.View;
import android.view.ViewGroup;

/**
 * Class:
 * Created by se7enTina on 2015/11/28.
 * Description:
 */
public class ViewUtil {
    public static final String TAG = "ViewUtil";


    public static View setViewChildToTag(View v) {

        if (v == null) return null;

        if (v instanceof ViewGroup) {

            ViewGroup viewGroup = (ViewGroup) v;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {

                View view = viewGroup.getChildAt(i);
                viewGroup.setTag(view.getId(), view);
            }
        }
        return v;
    }
}
