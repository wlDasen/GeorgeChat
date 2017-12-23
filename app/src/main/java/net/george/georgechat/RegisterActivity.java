package net.george.georgechat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.nicknameEdit)
    EditText mNicknameEdit;
    @BindView(R.id.numberEdit)
    EditText mNumberEdit;
    @BindView(R.id.passEdit)
    EditText mPassEdit;
    @BindView(R.id.verificationEdit)
    EditText mVerifiEdit;
    @BindView(R.id.btnRegister)
    Button mRegister;
    private TextWatcher textWatcher;

    @Override
    protected int provideLayoutView() {
        return R.layout.activity_register;
    }

    @Override
    public void initData() {
        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mRegister.setEnabled(canRegister());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }

    @Override
    public void initListener() {
        mNicknameEdit.addTextChangedListener(textWatcher);
        mNumberEdit.addTextChangedListener(textWatcher);
        mPassEdit.addTextChangedListener(textWatcher);
        mVerifiEdit.addTextChangedListener(textWatcher);
    }

    /**
     * 控制注册界面按钮是否变成enable状态
      * @return true-允许enable false-禁止enable
     */
    private boolean canRegister() {
        int nickLen = mNicknameEdit.getText().toString().trim().length();
        int numberLen = mNumberEdit.getText().toString().trim().length();
        int passLen = mPassEdit.getText().toString().trim().length();
        int verifLen = mVerifiEdit.getText().toString().trim().length();
        if(nickLen > 0 && numberLen > 0 && passLen > 0 && verifLen > 0) {
            return true;
        }

        return false;
    }
}
