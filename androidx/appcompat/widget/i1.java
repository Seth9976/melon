package androidx.appcompat.widget;

import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window.Callback;
import k.a;

public final class i1 implements View.OnClickListener {
    public final a a;
    public final k1 b;

    public i1(k1 k10) {
        this.b = k10;
        Context context0 = k10.a.getContext();
        CharSequence charSequence0 = k10.h;
        a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a0.e = 0x1000;
        a0.g = 0x1000;
        a0.l = null;
        a0.m = null;
        a0.n = false;
        a0.o = false;
        a0.p = 16;
        a0.i = context0;
        a0.a = charSequence0;
        this.a = a0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        Window.Callback window$Callback0 = this.b.k;
        if(window$Callback0 != null && this.b.l) {
            window$Callback0.onMenuItemSelected(0, this.a);
        }
    }
}

