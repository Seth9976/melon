package com.iloen.melon.custom;

import android.text.TextUtils;
import android.view.View.OnFocusChangeListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class w implements View.OnFocusChangeListener {
    public final int a;
    public final LinearLayout b;

    public w(LinearLayout linearLayout0, int v) {
        this.a = v;
        this.b = linearLayout0;
        super();
    }

    @Override  // android.view.View$OnFocusChangeListener
    public final void onFocusChange(View view0, boolean z) {
        if(this.a != 0) {
            NumberPicker numberPicker0 = (NumberPicker)this.b;
            if(z) {
                numberPicker0.a.selectAll();
                return;
            }
            numberPicker0.a.setSelection(0, 0);
            numberPicker0.getClass();
            String s = String.valueOf(((TextView)view0).getText());
            if(TextUtils.isEmpty(s)) {
                numberPicker0.p();
                return;
            }
            numberPicker0.n(numberPicker0.e(s.toString()), true);
            return;
        }
        CustomNumberPicker customNumberPicker0 = (CustomNumberPicker)this.b;
        if(z) {
            customNumberPicker0.a.selectAll();
            return;
        }
        customNumberPicker0.a.setSelection(0, 0);
        customNumberPicker0.c(view0);
    }
}

