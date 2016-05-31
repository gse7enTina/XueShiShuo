package com.se7entina.app.view.ptr;

import android.view.View;

/**
 * Class:
 * Created by se7enTina on 2016/1/14.
 * Description:
 */
public interface PtrHandler {

    public boolean checkCanDoRefresh(final PtrFrameLayout frame, final View content, final View header);

    public void onRefreshBegin(final PtrFrameLayout frame);
}