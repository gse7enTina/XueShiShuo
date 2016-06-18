package com.se7entina.app.view;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.se7entina.app.R;
import com.se7entina.app.bean.ClassBean;

import java.util.List;


/**
 * Class:
 * Created by se7enTina on 2016/4/23.
 * Description:
 */
public class ClassListShowDataView implements ShowDataView<ClassBean> {

    public static final String TAG = "ClassListShowDataView";

    private Activity activity;
    private List<ClassBean> dataList;


    public ClassListShowDataView(Activity activity, List<ClassBean> dataList) {
        this.activity = activity;
        this.dataList = dataList;
    }

    @Override
    public void showDataView(View v, ClassBean data, int position) {
    }

}