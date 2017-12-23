package net.george.georgechat.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;

/**
 * @author George
 * @date 2017/12/23
 * @email georgejiapeidi@gmail.com
 * @describe 应用基础App
 */
public class BaseApplication extends MultiDexApplication {
    private static final String TAG = "jpd-BApp";
    private static Context mContext;

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return mContext;
    }
}
