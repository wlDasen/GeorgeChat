package net.george.georgechat.view;


import android.widget.EditText;

/**
 * @author George
 * @date 2017/12/25
 * @email georgejiapeidi@gmail.com
 * @describe MPV模式中V依赖的接口供Presenter与V通讯
 */
public interface IRegisterAtView {
    /**
     * 获取V的手机Edit
     * @return
     */
    public EditText getNumberEdit();
}
