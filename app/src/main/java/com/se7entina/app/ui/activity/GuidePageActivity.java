package com.se7entina.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.se7entina.app.App;
import com.se7entina.app.R;
import com.se7entina.app.ui.adapter.GuidePagerAdapter;
import com.se7entina.app.view.CircleIndicator;


/**
 * Class:
 * Created by se7enTina on 2015/12/22.
 * Description:
 */
public class GuidePageActivity extends FragmentActivity {

    public static final String TAG = "GuidePageActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_guide_page);
        App.getInstance().addActivity(this);

        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        viewpager.setAdapter(new GuidePagerAdapter(this));
        indicator.setViewPager(viewpager);
        viewpager.setCurrentItem(0);
    }

    public void inLogin(View v){
        startActivity(new Intent(this, MainUIActivity.class));
        finish();
    }

}