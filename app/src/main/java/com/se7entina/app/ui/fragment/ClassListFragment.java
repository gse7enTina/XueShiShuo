package com.se7entina.app.ui.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.se7entina.app.R;
import com.se7entina.app.base.BaseFragment;
import com.se7entina.app.bean.ClassBean;
import com.se7entina.app.ui.adapter.ClassListAdapter;
import com.se7entina.app.ui.adapter.ListDropDownAdapter;
import com.se7entina.app.util.LogCat;
import com.se7entina.app.view.ptr.PtrClassicFrameLayout;
import com.se7entina.app.view.ptr.PtrDefaultHandler;
import com.se7entina.app.view.ptr.PtrFrameLayout;
import com.se7entina.app.view.ptr.PtrHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.InjectView;
import android.widget.PopupWindow.OnDismissListener;
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
    private int fenlei;
    private PopupWindow popupWindow;

    @Override
    public int getLayoutId() {
        return R.layout.fg_class_list;
    }

    @Override
    public void onFirst(View rootView) {

        TextView txt_sex = (TextView) getRootView().findViewById(R.id.txt_fenlei);
        txt_sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				if (popupWindow != null && popupWindow.isShowing()) {
					popupWindow.dismiss();
				} else {
					fenlei = 1;
					showPopupWindow();
				}
            }
        });

        TextView txt_rank = (TextView) getRootView().findViewById(R.id.txt_rank);
        txt_rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                } else {
                    fenlei = 2;
                    showPopupWindow();
                }
            }
        });

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

    private void showPopupWindow() {

        // 获取要显示在PopupWindow上的窗体视图
        View view = layoutInflater.inflate(R.layout.popw_view, null);
        // 实例化并且设置PopupWindow显示的视图 LayoutParams.WRAP_CONTENT
        LinearLayout ll_title = (LinearLayout) getRootView().findViewById(R.id.ll_title);
        popupWindow = new PopupWindow(view, ll_title.getWidth(), 600);

        // 获取PopupWindow中的控件
        ListView lsvAccount = (ListView) view.findViewById(R.id.lsvAccount);

        // 绑定ListView的数据
        ListDropDownAdapter adapter;
        if (fenlei == 1) {
            String[] data = { "不限", "男","女"};
            adapter = new ListDropDownAdapter(getActivity() , Arrays.asList(data) );
            lsvAccount.setAdapter(adapter);
        } else if (fenlei == 2) {
            String[] data = { "不限","人气最高","价格最低","价格最高"};
            adapter = new ListDropDownAdapter(getActivity() , Arrays.asList(data) );
            lsvAccount.setAdapter(adapter);
        }
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        // android.R.layout.simple_list_item_1, data);

        // 想要让PopupWindow中的控件能够使用，就必须设置PopupWindow为focusable
        popupWindow.setFocusable(true);

        // 想做到在你点击PopupWindow以外的区域时候让PopupWindow消失就做如下两步操作
        // 1：设置setOutsideTouchable为ture，这个很容易理解吧，跟AlertDialog一样的
        popupWindow.setOutsideTouchable(true);
        // 2：设置PopupWindow的背景不能为空，所以你就随便设置个背景吧，你不用担心背景会影响你的显示效果
        popupWindow.setBackgroundDrawable(getResources().getDrawable(
                R.mipmap.drop_down_checked));

        // 设置PopupWindow消失的时候触发的事件
        popupWindow.setOnDismissListener(new OnDismissListener() {

            public void onDismiss() {

            }
        });

        // 设置ListView点击事件
        lsvAccount.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                if (fenlei == 1) {
//                    lv_data = lsvAccount.getItemAtPosition(arg2).toString();
//                    txt_time.setText(lv_data);
//                    if (lv_data.equals("时段不限")) {
//                        lv_data = "";
//                    }
//
//                    getScheduleTablesData(lv_data, shopid);
                } else if (fenlei == 2) {
//                    lv_data1 = lsvAccount.getItemAtPosition(arg2).toString();
//                    txt_people.setText(lv_data1);
//                    if(lv_data1.equals("人数不限")){
//                        lv_data1 = "";
//                    }
//
//                    getScheduleTablesData(lv_data, shopid);
                }

                dismissPopupWindow();
            }
        });

        // 显示PopupWindow有3个方法
//         popupWindow.showAsDropDown();
//         popupWindow.showAsDropDown(anchor, xoff, yoff);
//         popupWindow.showAtLocation(parent, gravity, x, y);
        // 需要注意的是以上三个方法必须在触发事件中使用，比如在点击某个按钮的时候
        popupWindow.showAsDropDown(ll_title, 0, 0);



    }

    protected void updateData() {
        classBean = new ClassBean();
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

    @Override
    public void onDestroyView() {
            super.onDestroyView();
    }

    // 让PopupWindow消失
    private void dismissPopupWindow() {
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }
}
