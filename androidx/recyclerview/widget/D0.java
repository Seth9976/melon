package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;

public abstract class d0 {
    public final w0 a;
    public int b;
    public final Rect c;

    public d0(w0 w00) {
        this.b = 0x80000000;
        this.c = new Rect();
        this.a = w00;
    }

    public static d0 a(w0 w00, int v) {
        switch(v) {
            case 0: {
                return new b0(w00);  // 初始化器: Landroidx/recyclerview/widget/d0;-><init>(Landroidx/recyclerview/widget/w0;)V
            }
            case 1: {
                return new c0(w00);  // 初始化器: Landroidx/recyclerview/widget/d0;-><init>(Landroidx/recyclerview/widget/w0;)V
            }
            default: {
                throw new IllegalArgumentException("invalid orientation");
            }
        }
    }

    public abstract int b(View arg1);

    public abstract int c(View arg1);

    public abstract int d(View arg1);

    public abstract int e(View arg1);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public final int m() {
        return 0x80000000 == this.b ? 0 : this.l() - this.b;
    }

    public abstract int n(View arg1);

    public abstract int o(View arg1);

    public abstract void p(int arg1);
}

