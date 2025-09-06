package androidx.recyclerview.widget;

import android.view.View;

public final class Z0 {
    public final Y0 a;
    public final X0 b;

    public Z0(Y0 y00) {
        this.a = y00;
        X0 x00 = new X0();  // 初始化器: Ljava/lang/Object;-><init>()V
        x00.a = 0;
        this.b = x00;
    }

    public final View a(int v, int v1, int v2, int v3) {
        Y0 y00 = this.a;
        int v4 = y00.b();
        int v5 = y00.c();
        int v6 = v1 <= v ? -1 : 1;
        View view0 = null;
        while(v != v1) {
            View view1 = y00.d(v);
            int v7 = y00.a(view1);
            int v8 = y00.e(view1);
            X0 x00 = this.b;
            x00.b = v4;
            x00.c = v5;
            x00.d = v7;
            x00.e = v8;
            if(v2 != 0) {
                x00.a = v2;
                if(x00.b()) {
                    return view1;
                }
            }
            if(v3 != 0) {
                x00.a = v3;
                if(x00.b()) {
                    view0 = view1;
                }
            }
            v += v6;
        }
        return view0;
    }

    public final boolean b(View view0) {
        int v = this.a.b();
        int v1 = this.a.c();
        int v2 = this.a.a(view0);
        int v3 = this.a.e(view0);
        this.b.b = v;
        this.b.c = v1;
        this.b.d = v2;
        this.b.e = v3;
        this.b.a = 0x6003;
        return this.b.b();
    }
}

