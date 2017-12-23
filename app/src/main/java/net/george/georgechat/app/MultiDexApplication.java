package net.george.georgechat.app;


import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;

/**
 * @author George
 * @date 2017/12/23
 * @email georgejiapeidi@gmail.com
 * @describe MultiDex装配App
 */
public class MultiDexApplication extends Application {
    private static final String TAG = "jpd-MDApp";
    
    @Override
    protected void attachBaseContext(Context base) {
        Log.d(TAG, "attachBaseContext: ");
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
