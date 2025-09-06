package com.iloen.melon.custom;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iloen.melon.utils.ui.ViewUtils;

public class CustomNumberPicker extends LinearLayout {
    public final EditText a;
    public final TextView b;
    public int c;
    public int d;
    public int e;
    public static final char[] f;

    static {
        CustomNumberPicker.f = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    public CustomNumberPicker(Context context0) {
        this(context0, null);
    }

    public CustomNumberPicker(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.c = 0;
        this.e = 0;
        v v0 = new v(this, 1);
        ((LayoutInflater)this.getContext().getSystemService("layout_inflater")).inflate(0x7F0D01DD, this, true);  // layout:custom_number_picker
        ViewUtils.setOnClickListener(((ImageView)this.findViewById(0x7F0A018F)), v0);  // id:btn_plus
        ViewUtils.setOnClickListener(((ImageView)this.findViewById(0x7F0A0177)), v0);  // id:btn_minus
        EditText editText0 = (EditText)this.findViewById(0x7F0A0410);  // id:edit_time
        this.a = editText0;
        ViewUtils.setOnClickListener(editText0, new v(this, 0));
        editText0.setOnFocusChangeListener(new w(this, 0));
        editText0.setFilters(new InputFilter[]{new x(this, 0)});
        editText0.setRawInputType(2);
        editText0.setImeOptions(6);
        this.b = (TextView)this.findViewById(0x7F0A0B8A);  // id:time_label
        this.b();
    }

    public static void a(CustomNumberPicker customNumberPicker0, boolean z) {
        if(z) {
            customNumberPicker0.setValueInternal((customNumberPicker0.d > customNumberPicker0.e ? customNumberPicker0.e + 1 : 0));
            return;
        }
        customNumberPicker0.setValueInternal((customNumberPicker0.c < customNumberPicker0.e ? customNumberPicker0.e - 1 : customNumberPicker0.d));
    }

    public final void b() {
        String s = String.format("%02d", this.e);
        if(!TextUtils.isEmpty(s)) {
            EditText editText0 = this.a;
            if(!s.equals(editText0.getText().toString())) {
                editText0.setText(s);
            }
        }
    }

    public final void c(View view0) {
        int v;
        String s = String.valueOf(((TextView)view0).getText());
        if(TextUtils.isEmpty(s)) {
            this.b();
            return;
        }
        String s1 = s.toString();
        try {
            v = Integer.parseInt(s1);
        }
        catch(NumberFormatException unused_ex) {
            v = this.c;
        }
        this.setValueInternal(v);
    }

    public int getMaxValue() {
        return this.d;
    }

    public int getMinValue() {
        return this.c;
    }

    public int getValue() {
        EditText editText0 = this.a;
        if(editText0.isFocused()) {
            this.c(editText0);
        }
        return this.e;
    }

    @Override  // android.view.View
    public final boolean isFocused() {
        return this.a.isFocused();
    }

    public void setMaxValue(int v) {
        if(this.d == v) {
            return;
        }
        if(v < 0) {
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
        this.d = v;
        if(v < this.e) {
            this.e = v;
        }
        this.b();
        this.invalidate();
    }

    public void setMinValue(int v) {
        if(this.c == v) {
            return;
        }
        if(v < 0) {
            throw new IllegalArgumentException("minValue must be >= 0");
        }
        this.c = v;
        if(v > this.e) {
            this.e = v;
        }
        this.b();
        this.invalidate();
    }

    public void setOnValueChangedListener(y y0) {
    }

    public void setTimeText(String s) {
        this.b.setText(s);
    }

    public void setValue(int v) {
        this.setValueInternal(v);
    }

    private void setValueInternal(int v) {
        if(this.e == v) {
            return;
        }
        this.e = Math.min(Math.max(v, this.c), this.d);
        this.b();
        this.invalidate();
    }
}

