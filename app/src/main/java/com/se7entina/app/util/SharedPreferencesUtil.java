package com.se7entina.app.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ice on 15/12/1.
 */
public class SharedPreferencesUtil {

    private static final String SHARED_PATH = "APP_SHARED_PATH";
    private static SharedPreferences sharedPreferences;

    private SharedPreferencesUtil() {
    }

    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(SHARED_PATH, Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    /**
     * 保存键值对
     *
     * @param context 应用上下文
     * @param key     key
     * @param value   value
     */
    public static void putInt(Context context, String key, int value) {
        SharedPreferences sharedPreferences = getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(key, value);
        edit.commit();
    }

    /**
     * 获取KEY对应的VALUE
     *
     * @param context 应用上下文
     * @param key     key
     * @return value
     */
    public static int getInt(Context context, String key) {
        SharedPreferences sharedPreferences = getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(key, 0);
    }

    /**
     * 保存键值对
     *
     * @param context 应用上下文
     * @param key     key
     * @param value   value
     */
    public static void putString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(key, value);
        edit.commit();
    }

    /**
     * 获取KEY对应的VALUE
     *
     * @param context 应用上下文
     * @param key     key
     * @return value
     */
    public static String getString(Context context, String key) {
        SharedPreferences sharedPreferences = getDefaultSharedPreferences(context);
        return sharedPreferences.getString(key, null);
    }

    /**
     * 保存键值对
     *
     * @param context 应用上下文
     * @param key     key
     * @param value   value
     */
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(key, value);
        edit.commit();
    }

    /**
     * 获取KEY对应的VALUE
     *
     * @param context 应用上下文
     * @param key     key
     * @return value
     */
    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sharedPreferences = getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(key, defValue);
    }

    /**
     * 移除键值对
     *
     * @param context 应用上下文
     * @param key     KEY
     */
    public static void remove(Context context, String key) {
        SharedPreferences sharedPreferences = getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(key);
        edit.commit();
    }
}
