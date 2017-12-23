package net.george.georgechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.ButterKnife;

/**
 * @author George
 * @date 2017/12/21
 * @email georgejiapeidi@gmail.com
 * @describe 基类Activity，简化各个子类的代码量，同时规范各个子类的接口
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = "jpd-BAc";
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        init();
        setContentView(provideLayoutView());
        ButterKnife.bind(this);
        initListener();
    }

    /**
     * 跳转Activity
     * @param activity 要跳转的Activity的Class类
     */
    public void jumpToActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    /**
     * 子类Activity提供布局ResourceID
     * @return 布局ID
     */
    protected abstract int provideLayoutView();

    /**
     * 子类展示UI之前做的一些操作（比如动态申请权限等）
     */
    public void init() {}

    /**
     * 子类初始化监听器接口
     */
    public void initListener() {}
}