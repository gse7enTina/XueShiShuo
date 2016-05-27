package com.se7entina.app.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.se7entina.app.R;

import java.util.Random;
/**
 * Class:
 * Created by se7enTina on 2015/12/22.
 * Description:
 */
public class GuidePagerAdapter extends PagerAdapter {

    private final Random random = new Random();
    private final SparseArray<View> mHolderArray = new SparseArray<>();
    private int mSize;
    private Context context;

    public GuidePagerAdapter(Context context) {
        this.context = context;
        mSize = 3;
    }

    public GuidePagerAdapter(int count) {
        mSize = count;
    }

    @Override
    public int getCount() {
        return mSize;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup view, int position, Object object) {
        view.removeView(mHolderArray.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View viewPager = null;
        switch (position){
            case 0:
                viewPager = View.inflate(context, R.layout.ac_view_page1,null);
                break;
            case 1:
                viewPager = View.inflate(context,R.layout.ac_view_page2,null);
                break;
            case 2:
                viewPager = View.inflate(context,R.layout.ac_view_page3,null);
                break;
            default:
                break;
        }
        view.addView(viewPager, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mHolderArray.put(position, viewPager);
        return viewPager;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public void addItem() {
        mSize++;
        notifyDataSetChanged();
    }

    public void removeItem() {
        mSize--;
        mSize = mSize < 0 ? 0 : mSize;

        notifyDataSetChanged();
    }
}