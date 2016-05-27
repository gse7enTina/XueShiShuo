package com.se7entina.app.base;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.se7entina.app.R;

/**
 * Class:
 * Created by se7enTina on 2015/11/24.
 * Description:
 */
public abstract class BaseActivity extends FragmentActivity {
    protected ActionBar actionBar;
    private TextView tvTitle;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActionBar();
    }

    private void initActionBar() {
        actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
        }
        View view = View.inflate(this, R.layout.actionbar_title, null);
        tvTitle = (TextView) view.findViewById(R.id.tv_shimmer);
        actionBar.setCustomView(view);
    }

    public void setTitle(int resId) {
        tvTitle.setText(resId);
    }

    public void setTitle(CharSequence text) {
        tvTitle.setText(text);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
