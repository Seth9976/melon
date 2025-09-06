package com.kakao.emoticon.ui;

import android.widget.PopupWindow.OnDismissListener;
import android.widget.PopupWindow;

public final class a implements PopupWindow.OnDismissListener {
    public final KeyboardEmoticonManager a;
    public final PopupWindow b;

    public a(KeyboardEmoticonManager keyboardEmoticonManager0, PopupWindow popupWindow0) {
        this.a = keyboardEmoticonManager0;
        this.b = popupWindow0;
    }

    @Override  // android.widget.PopupWindow$OnDismissListener
    public final void onDismiss() {
        this.a.lambda$showByPopupWindow$1(this.b);
    }
}

