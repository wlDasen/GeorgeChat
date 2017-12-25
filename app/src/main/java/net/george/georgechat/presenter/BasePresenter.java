package net.george.georgechat.presenter;


import net.george.georgechat.BaseActivity;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @author George
 * @date 2017/12/25
 * @email georgejiapeidi@gmail.com
 * @describe 基类Presenter，保持View的弱引用防止Memory Leak
 */
public class BasePresenter<V> {
    public BaseActivity mActivity;
    private Reference<V> mViewRef;

    public BasePresenter(BaseActivity activity) {
        mActivity = activity;
    }
    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
    public V get() {
        return mViewRef != null ? mViewRef.get() : null;
    }
}
