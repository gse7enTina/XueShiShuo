package com.se7entina.app.ui.fragment;

import android.view.View;
import android.widget.ListView;

import com.se7entina.app.R;
import com.se7entina.app.base.BaseFragment;
import com.se7entina.app.bean.ClassBean;
import com.se7entina.app.ui.adapter.ClassListAdapter;
import com.se7entina.app.view.ptr.PtrClassicFrameLayout;
import com.se7entina.app.view.ptr.PtrDefaultHandler;
import com.se7entina.app.view.ptr.PtrFrameLayout;
import com.se7entina.app.view.ptr.PtrHandler;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Class:
 * Created by se7enTina on 2016/4/23.
 * Description:
 */
public class ClassListFragment extends BaseFragment {

    private PtrClassicFrameLayout mPtrFrame;
    @InjectView(R.id.rotate_header_list_view)
    ListView listView;
    private ClassBean classBean;
    private ClassListAdapter classListAdapter;
    List<ClassBean> classBeanList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.fg_class_list;
    }

    @Override
    public void onFirst(View rootView) {


        mPtrFrame = (PtrClassicFrameLayout) getRootView().findViewById(R.id.rotate_header_list_view_frame);
        mPtrFrame.setLastUpdateTimeRelateObject(this);
        mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                updateData();
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }
        });
        // the following are default settings
        mPtrFrame.setResistance(1.7f);
        mPtrFrame.setRatioOfHeaderHeightToRefresh(1.2f);
        mPtrFrame.setDurationToClose(200);
        mPtrFrame.setDurationToCloseHeader(1000);
        // default is false
        mPtrFrame.setPullToRefresh(false);
        // default is true
        mPtrFrame.setKeepHeaderWhenRefresh(true);
        mPtrFrame.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrame.autoRefresh();
            }
        }, 100);
    }

    protected void updateData() {
        classBean = new ClassBean();
        classBean.setName("se7enTina");
        classBean.setCategory("物理全能王");
        classBean.setGrade("3");
        classBean.setEducation("本科");
        classBeanList.add(classBean);
        classListAdapter.setData(classBeanList);
        listView.setAdapter(classListAdapter);
        mPtrFrame.refreshComplete();
    }

    @Override
    public void onAgain(View rootView) {
        classListAdapter = new ClassListAdapter(getActivity(), classBeanList);
        classListAdapter.setData(classBeanList);
        listView.setAdapter(classListAdapter);
    }
}
