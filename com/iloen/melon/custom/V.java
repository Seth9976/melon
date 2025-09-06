package com.iloen.melon.custom;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.utils.ui.InputMethodUtils;

public final class v implements View.OnClickListener {
    public final int a;
    public final CustomNumberPicker b;

    public v(CustomNumberPicker customNumberPicker0, int v) {
        this.a = v;
        this.b = customNumberPicker0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            CustomNumberPicker customNumberPicker0 = this.b;
            InputMethodUtils.hideInputMethod(customNumberPicker0.getContext(), customNumberPicker0.a);
            customNumberPicker0.a.clearFocus();
            if(view0.getId() == 0x7F0A018F) {  // id:btn_plus
                CustomNumberPicker.a(customNumberPicker0, true);
                return;
            }
            CustomNumberPicker.a(customNumberPicker0, false);
            return;
        }
        this.b.a.setFocusableInTouchMode(true);
        this.b.a.requestFocus();
        InputMethodUtils.showInputMethod(this.b.getContext(), this.b.a);
    }
}

