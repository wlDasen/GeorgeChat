package net.george.georgechat;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import net.george.georgechat.presenter.BasePresenter;
import net.george.georgechat.presenter.PresenterAtView;
import net.george.georgechat.utils.UIUtils;
import net.george.georgechat.view.IRegisterAtView;

import butterknife.BindView;

/**
 * @author George
 * @date 2017/12/25
 * @email georgejiapeidi@gmail.com
 * @describe 注册Activity
 */
public class RegisterActivity extends BaseActivity<IRegisterAtView, PresenterAtView> implements IRegisterAtView {
    private static final String TAG = "jpd-RstAc";
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
    @BindView(R.id.btnSendVerification)
    Button mSendVerif;
    @BindView(R.id.nicknameDivider)
    View mNickDivider;
    @BindView(R.id.numberDivider)
    View mNumberDivider;
    @BindView(R.id.passDivider)
    View mPassDivider;
    @BindView(R.id.verfiDivider)
    View mVerifDivider;
    @BindView(R.id.showPassImg)
    ImageView mShowpassImg;
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
        mShowpassImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public void initListener() {
        mNicknameEdit.addTextChangedListener(textWatcher);
        mNumberEdit.addTextChangedListener(textWatcher);
        mPassEdit.addTextChangedListener(textWatcher);
        mVerifiEdit.addTextChangedListener(textWatcher);
        mNicknameEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    Log.d(TAG, "onFocusChange: nickname hasfocus.");
                    mNickDivider.setBackgroundColor(UIUtils.getColor(R.color.green1));
                } else {
                    Log.d(TAG, "onFocusChange: nickname nofocus.");
                    mNickDivider.setBackgroundColor(UIUtils.getColor(R.color.line));
                }
            }
        });
        mNumberEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    Log.d(TAG, "onFocusChange: number hasfocus.");
                    mNumberDivider.setBackgroundColor(UIUtils.getColor(R.color.green1));
                } else {
                    Log.d(TAG, "onFocusChange: number nofocus.");
                    mNumberDivider.setBackgroundColor(UIUtils.getColor(R.color.line));
                }
            }
        });
        mPassEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    Log.d(TAG, "onFocusChange: pass hasfocus.");
                    mPassDivider.setBackgroundColor(UIUtils.getColor(R.color.green1));
                } else {
                    Log.d(TAG, "onFocusChange: pass nofocus.");
                    mPassDivider.setBackgroundColor(UIUtils.getColor(R.color.line));
                }
            }
        });
        mVerifiEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    Log.d(TAG, "onFocusChange: verif hasfocus.");
                    mVerifDivider.setBackgroundColor(UIUtils.getColor(R.color.green1));
                } else {
                    Log.d(TAG, "onFocusChange: verif nofocus.");
                    mVerifDivider.setBackgroundColor(UIUtils.getColor(R.color.line));
                }
            }
        });
        mShowpassImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPassEdit.getTransformationMethod() == HideReturnsTransformationMethod.getInstance()) {
                    mPassEdit.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    mShowpassImg.setImageDrawable(getResources().getDrawable(R.mipmap.ic_register_password_visible));
                } else {
                    mPassEdit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    mShowpassImg.setImageDrawable(getResources().getDrawable(R.mipmap.ic_register_password_invisible));
                }
                mPassEdit.setSelection(mPassEdit.getText().toString().trim().length());
            }
        });
        mSendVerif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ");
                mPresenter.sendCode();
            }
        });
    }

    @Override
    protected PresenterAtView createPresenter() {
        return new PresenterAtView(this);
    }

    @Override
    public EditText getNumberEdit() {
        return mNumberEdit;
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
