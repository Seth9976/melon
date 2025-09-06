package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.LocaleList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import c2.B;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;

class ChipTextInputComboView extends FrameLayout implements Checkable {
    public final Chip a;
    public final EditText b;

    public ChipTextInputComboView(Context context0) {
        this(context0, null);
    }

    public ChipTextInputComboView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public ChipTextInputComboView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        LayoutInflater layoutInflater0 = LayoutInflater.from(context0);
        Chip chip0 = (Chip)layoutInflater0.inflate(0x7F0D04D3, this, false);  // layout:material_time_chip
        this.a = chip0;
        chip0.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout0 = (TextInputLayout)layoutInflater0.inflate(0x7F0D04D4, this, false);  // layout:material_time_input
        EditText editText0 = textInputLayout0.getEditText();
        this.b = editText0;
        editText0.setVisibility(4);
        editText0.addTextChangedListener(new a(this));
        editText0.setImeHintLocales(this.getContext().getResources().getConfiguration().getLocales());
        this.addView(chip0);
        this.addView(textInputLayout0);
        TextView textView0 = (TextView)this.findViewById(0x7F0A07E2);  // id:material_label
        editText0.setId(View.generateViewId());
        textView0.setLabelFor(editText0.getId());
        editText0.setSaveEnabled(false);
        editText0.setLongClickable(false);
    }

    public static String a(ChipTextInputComboView chipTextInputComboView0, CharSequence charSequence0) {
        Resources resources0 = chipTextInputComboView0.getResources();
        try {
            return String.format(resources0.getConfiguration().locale, "%02d", Integer.parseInt(String.valueOf(charSequence0)));
        }
        catch(NumberFormatException unused_ex) {
            return null;
        }
    }

    @Override  // android.widget.Checkable
    public final boolean isChecked() {
        return this.a.isChecked();
    }

    @Override  // android.view.View
    public final void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        LocaleList localeList0 = this.getContext().getResources().getConfiguration().getLocales();
        this.b.setImeHintLocales(localeList0);
    }

    @Override  // android.widget.Checkable
    public final void setChecked(boolean z) {
        Chip chip0 = this.a;
        chip0.setChecked(z);
        int v = 0;
        EditText editText0 = this.b;
        editText0.setVisibility((z ? 0 : 4));
        if(z) {
            v = 8;
        }
        chip0.setVisibility(v);
        if(chip0.isChecked()) {
            editText0.requestFocus();
            editText0.post(new B(editText0, 3));
        }
    }

    @Override  // android.view.View
    public final void setOnClickListener(View.OnClickListener view$OnClickListener0) {
        this.a.setOnClickListener(view$OnClickListener0);
    }

    @Override  // android.view.View
    public final void setTag(int v, Object object0) {
        this.a.setTag(v, object0);
    }

    @Override  // android.widget.Checkable
    public final void toggle() {
        this.a.toggle();
    }
}

