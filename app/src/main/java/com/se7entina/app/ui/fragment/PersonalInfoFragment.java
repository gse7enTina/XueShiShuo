package com.se7entina.app.ui.fragment;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.se7entina.app.App;
import com.se7entina.app.R;
import com.se7entina.app.base.BaseActivity;
import com.se7entina.app.base.BaseFragment;
import com.se7entina.app.ui.activity.MainUIActivity;
import com.se7entina.app.widgets.CharType;
import com.se7entina.app.widgets.ToastTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class:
 * Created by se7enTina on 2016/5/31.
 * Description:
 */
public class PersonalInfoFragment extends BaseFragment {

    private ListView infoListView =null;
    private List<Map<String, Object>> listData = null;
    private SimpleAdapter adapter = null;
    private static MainUIActivity activity;
    @Override
    public int getLayoutId() {
        return R.layout.fg_personal_info;
    }

    @Override
    public void onFirst(View rootView) {

        infoListView = (ListView) getRootView().findViewById(R.id.lv_item);
        setListData();

        adapter = new SimpleAdapter(getActivity(), listData, R.layout.lv_setting_list_item,
                new String[]{"text","pic"}, new int[]{R.id.tv_system_title,R.id.iv_pic_show});

        infoListView.setAdapter(adapter);
        infoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startMarket();
            }
        });
    }

    private void setListData() {
        listData = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("text", "我的消息");
        map.put("pic", R.mipmap.advance);
        listData.add(map);

        map = new HashMap<String, Object>();
        map.put("text", "修改密码");
        map.put("pic", R.mipmap.advance);
        listData.add(map);

        map = new HashMap<String, Object>();
        map.put("text", "问题反馈");
        map.put("pic", R.mipmap.advance);
        listData.add(map);

        map = new HashMap<String, Object>();
        map.put("text", "分享应用");
        map.put("pic",R.mipmap.advance);
        listData.add(map);

        map = new HashMap<String, Object>();
        map.put("text", "关于应用");
        map.put("pic",R.mipmap.advance);
        listData.add(map);

    }

    public void startMarket() {
        Uri uri = Uri.parse(String.format("market://details?id=%s", App.getPackage(getActivity())));
        if (App.isIntentSafe(getActivity(), uri)) {
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            App.getContext().startActivity(intent);
        }
        // 没有安装市场
        else {
            ToastTools.show(getActivity(), R.string.settings_error_market);
        }
    }
    @Override
    public void onAgain(View rootView) {

    }
}
