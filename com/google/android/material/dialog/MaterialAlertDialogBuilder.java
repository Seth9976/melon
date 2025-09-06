package com.google.android.material.dialog;

import E6.a;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.g;
import androidx.appcompat.view.ContextThemeWrapper;
import c2.M;
import df.d;
import e1.m;
import e1.n;
import z6.i;

public class MaterialAlertDialogBuilder extends AlertDialog.Builder {
    public final i c;
    public final Rect d;

    public MaterialAlertDialogBuilder(Context context0) {
        TypedValue typedValue0 = m.y(context0, 0x7F0403EE);  // attr:materialAlertDialogTheme
        int v = 0;
        int v1 = typedValue0 == null ? 0 : typedValue0.data;
        Context context1 = a.a(context0, null, 0x7F040039, 0x7F14017D);  // attr:alertDialogStyle
        if(v1 != 0) {
            context1 = new ContextThemeWrapper(context1, v1);
        }
        TypedValue typedValue1 = m.y(context0, 0x7F0403EE);  // attr:materialAlertDialogTheme
        if(typedValue1 != null) {
            v = typedValue1.data;
        }
        super(context1, v);
        Resources.Theme resources$Theme0 = this.a.a.getTheme();
        this.d = d.u(this.a.a, 0x7F040039, 0x7F14017D);  // attr:alertDialogStyle
        String s = this.getClass().getCanonicalName();
        int v2 = n.p(this.a.a, 0x7F040190, s);  // attr:colorSurface
        TypedArray typedArray0 = this.a.a.obtainStyledAttributes(null, d6.a.y, 0x7F040039, 0x7F14017D);  // attr:alertDialogStyle
        int v3 = typedArray0.getColor(4, v2);
        typedArray0.recycle();
        i i0 = new i(this.a.a, null, 0x7F040039, 0x7F14017D);  // attr:alertDialogStyle
        i0.k(this.a.a);
        i0.m(ColorStateList.valueOf(v3));
        if(Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue2 = new TypedValue();
            resources$Theme0.resolveAttribute(0x1010571, typedValue2, true);
            float f = typedValue2.getDimension(this.a.a.getResources().getDisplayMetrics());
            if(typedValue2.type == 5 && f >= 0.0f) {
                z6.m m0 = i0.a.a.g();
                m0.c(f);
                i0.setShapeAppearanceModel(m0.a());
            }
        }
        this.c = i0;
    }

    @Override  // androidx.appcompat.app.AlertDialog$Builder
    public final g a() {
        g g0 = super.a();
        Window window0 = g0.getWindow();
        View view0 = window0.getDecorView();
        i i0 = this.c;
        if(i0 != null) {
            i0.l(M.e(view0));
        }
        window0.setBackgroundDrawable(new InsetDrawable(i0, this.d.left, this.d.top, this.d.right, this.d.bottom));
        view0.setOnTouchListener(new o6.a(g0, this.d));
        return g0;
    }

    @Override  // androidx.appcompat.app.AlertDialog$Builder
    public final void c(DialogInterface.OnCancelListener dialogInterface$OnCancelListener0) {
        this.a.o = dialogInterface$OnCancelListener0;
    }
}

