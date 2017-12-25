package net.george.georgechat.presenter;


import android.text.TextUtils;

import net.george.georgechat.BaseActivity;
import net.george.georgechat.utils.RegularUtils;
import net.george.georgechat.utils.UIUtils;
import net.george.georgechat.view.IRegisterAtView;

/**
 * @author George
 * @date 2017/12/25
 * @email georgejiapeidi@gmail.com
 * @describe MVP模式中RegisterActivity对应的Presenter
 */
public class PresenterAtView extends BasePresenter<IRegisterAtView> {
    public PresenterAtView(BaseActivity activity) {
        super(activity);
    }

    /**
     * 发送验证码实现接口
     */
    public void sendCode() {
        String phone = get().getNumberEdit().getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            UIUtils.showToast("手机号不能为空");
            return;
        }
        if (!RegularUtils.isMobleNumber(phone)) {
            UIUtils.showToast("手机格式有误");
            return;
        }
    }
}
