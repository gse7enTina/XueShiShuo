package com.se7entina.app.ui.fragment;

import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.se7entina.app.R;
import com.se7entina.app.base.BaseFragment;
import com.se7entina.app.widgets.CharType;

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

    @Override
    public void onAgain(View rootView) {

    }
}
