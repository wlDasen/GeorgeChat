package net.george.georgechat.utils;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;

import net.george.georgechat.app.BaseApplication;

/**
 * @author George
 * @date 2017/12/23
 * @email georgejiapeidi@gmail.com
 * @describe 封装跟UI相关的常用接口
 */
public class UIUtils {
    private static Toast mToast;

    private static Context getContext() {
        return BaseApplication.getAppContext();
    }
    private static Resources getResources() {
        return getContext().getResources();
    }
    public static int getColor(int resourceID) {
        return getResources().getColor(resourceID);
    }
    public static void showToast(String msg) {
        showToast(msg, Toast.LENGTH_SHORT);
    }
    public static void showToast(String msg, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(getContext(), msg, duration);
        }
        mToast.setText(msg);
        mToast.setDuration(duration);
        mToast.show();
    }
}
