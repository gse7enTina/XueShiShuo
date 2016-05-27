package com.se7entina.app.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.se7entina.app.App;
import com.se7entina.app.R;

/**
 * Class:
 * Created by se7enTina on 2015/12/22.
 * Description:
 */
@SuppressWarnings("ALL")
public class HelloActivity extends Activity {

    private View view;
    private static int TIME = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = View.inflate(this, R.layout.ac_hello, null);
        setContentView(view);
        App.getInstance().addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        into();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 跳转类型方法
     */
    private void into() {
        // 渐变动画
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.ac_hello_alpha);

        view.startAnimation(animation);
        // 跳转动画动画
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation arg0) {
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {

                new Handler().postDelayed(new Runnable() {
                    @SuppressLint("NewApi")
                    @Override
                    public void run() {
                        Intent intent;
                        App app = (App) getApplication();
                        if (app.initFirstSetting()) {
                            intent = new Intent(HelloActivity.this, MainUIActivity.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                        } else {
                            intent = new Intent(HelloActivity.this, GuidePageActivity.class);
                            startActivity(intent);
                        }
                        finish();
                    }
                }, TIME);
            }
        });
    }
}
