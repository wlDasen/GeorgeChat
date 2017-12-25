package net.george.georgechat;

import android.Manifest;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import net.george.georgechat.presenter.BasePresenter;

import butterknife.BindView;
import george.net.george_permission.GeorgePermission;

/**
 * @author George
 * @date 2017/12/21
 * @email georgejiapeidi@gmail.com
 * @describe 应用程序的初始Activity
 */
public class MainActivity extends BaseActivity {
    private static final String TAG = "jpd-MAc";
    @BindView(R.id.btnLogin)
    Button loginBtn;
    @BindView(R.id.btnRegister)
    Button registerBtn;

    @Override
    public void init() {
        GeorgePermission.with(MainActivity.this).addRequestCode(100).permissions(
                Manifest.permission.READ_CALENDAR,
                Manifest.permission.CAMERA,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.READ_EXTERNAL_STORAGE).request();
    }

    @Override
    public void initListener() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumpToActivity(LoginActivity.class);
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumpToActivity(RegisterActivity.class);
            }
        });
    }

    @Override
    protected BasePresenter createPresenter() {
        Log.d(TAG, "createPresenter: ");
        return null;
    }

    @Override
    protected int provideLayoutView() {
        return R.layout.activity_main;
    }
}