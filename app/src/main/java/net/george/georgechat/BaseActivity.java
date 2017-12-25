package net.george.georgechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import net.george.georgechat.presenter.BasePresenter;

import butterknife.ButterKnife;

/**
 * @author George
 * @date 2017/12/21
 * @email georgejiapeidi@gmail.com
 * @describe 基类Activity，简化各个子类的代码量，同时规范各个子类的接口
 */
public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {
    private static final String TAG = "jpd-BAc";
    protected T mPresenter;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        init();
        // 是否采用MVP模式
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V)this);
        }
        setContentView(provideLayoutView());
        ButterKnife.bind(this);
        initData();
        initListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
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
     * 创建MVP模式中的Presenter
     * @return null-不需要使用MVP模式 other-对应Acitivity的Presenter
     */
    protected abstract T createPresenter();

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

    /**
     * 子类初始化数据接口
     */
    public void initData() {}
}