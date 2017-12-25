package net.george.georgechat.widget;


import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class CustomDialog extends Dialog {
    public CustomDialog(@NonNull Context context, View view, int themeResId) {
        super(context, themeResId);
        setContentView(view);
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);
    }
}
