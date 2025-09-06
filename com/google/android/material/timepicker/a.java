package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.A;

public final class a extends A {
    public final ChipTextInputComboView a;

    public a(ChipTextInputComboView chipTextInputComboView0) {
        this.a = chipTextInputComboView0;
    }

    @Override  // android.text.TextWatcher
    public final void afterTextChanged(Editable editable0) {
        boolean z = TextUtils.isEmpty(editable0);
        ChipTextInputComboView chipTextInputComboView0 = this.a;
        if(z) {
            String s = ChipTextInputComboView.a(chipTextInputComboView0, "00");
            chipTextInputComboView0.a.setText(s);
            return;
        }
        String s1 = ChipTextInputComboView.a(chipTextInputComboView0, editable0);
        Chip chip0 = chipTextInputComboView0.a;
        if(TextUtils.isEmpty(s1)) {
            s1 = ChipTextInputComboView.a(chipTextInputComboView0, "00");
        }
        chip0.setText(s1);
    }
}

