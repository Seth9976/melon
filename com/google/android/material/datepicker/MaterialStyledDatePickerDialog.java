package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import df.d;
import e1.m;
import o6.a;
import z6.i;

public class MaterialStyledDatePickerDialog extends DatePickerDialog {
    public final InsetDrawable a;
    public final Rect b;

    public MaterialStyledDatePickerDialog(Context context0) {
        super(context0, 0, null, -1, -1, -1);
        Context context1 = this.getContext();
        int v = m.A(this.getContext(), 0x7F040190, this.getClass().getCanonicalName()).data;  // attr:colorSurface
        i i0 = new i(context1, null, 0x101035C, 0x7F140180);  // style:MaterialAlertDialog.MaterialComponents.Picker.Date.Spinner
        i0.m(ColorStateList.valueOf(v));
        Rect rect0 = d.u(context1, 0x101035C, 0x7F140180);  // style:MaterialAlertDialog.MaterialComponents.Picker.Date.Spinner
        this.b = rect0;
        this.a = new InsetDrawable(i0, rect0.left, rect0.top, rect0.right, rect0.bottom);
    }

    @Override  // android.app.AlertDialog
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.getWindow().setBackgroundDrawable(this.a);
        this.getWindow().getDecorView().setOnTouchListener(new a(this, this.b));
    }
}

