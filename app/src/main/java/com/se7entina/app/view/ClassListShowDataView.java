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
        TextView textView = (TextView) v.getTag(R.id.adapter_query_trans_txnRst);
        textView.setText(data.getName());
        textView = (TextView) v.getTag(R.id.adapter_query_trans_date);
        textView.setText(data.getSex());
        textView = (TextView) v.getTag(R.id.adapter_query_trans_res);
        textView.setText(data.getEducation());
        textView = (TextView) v.getTag(R.id.adapter_query_trans_button);
        textView.setText(data.getGrade());
    }

}