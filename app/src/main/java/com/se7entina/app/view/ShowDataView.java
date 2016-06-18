package com.se7entina.app.view;

import android.view.View;

/**
 * Class:
 * Created by se7enTina on 2015/11/28.
 * Description:
 */
public interface ShowDataView<T> {

    public void showDataView(View v, T data, int position);

}