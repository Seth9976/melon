package v9;

import android.text.TextUtils;
import android.view.View.OnClickListener;

public final class e {
    public boolean a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public String f;
    public int g;
    public String h;
    public int i;
    public String j;
    public int k;
    public int l;
    public View.OnClickListener m;
    public static final e n;
    public static final e o;

    static {
        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.d = -1;
        e0.e = -1;
        e0.g = -1;
        e0.i = -1;
        e0.k = -1;
        e0.l = -1;
        e0.a = true;
        e.n = e0;
        e e1 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e1.d = -1;
        e1.e = -1;
        e1.g = -1;
        e1.i = -1;
        e1.k = -1;
        e1.l = -1;
        e1.b = true;
        e.o = e1;
    }

    public static e a(e e0, e e1) {
        if(e0 == null && e1 == null) {
            return null;
        }
        if(e0 != null && e1 == null) {
            return e0;
        }
        if(e0 == null && e1 != null) {
            return e1;
        }
        if(!e1.b && !e1.a) {
            e1.c = e1.c > 0 ? e1.c : e0.c;
            e1.d = e1.d == -1 ? e0.d : e1.d;
            e1.e = e1.e == -1 ? e0.e : e1.e;
            e1.f = TextUtils.isEmpty(e1.f) ? e0.f : e1.f;
            e1.h = TextUtils.isEmpty(e1.h) ? e0.h : e1.h;
            e1.j = TextUtils.isEmpty(e1.j) ? e0.j : e1.j;
            e1.m = e1.m == null ? e0.m : e1.m;
            e1.k = e1.k == -1 ? e0.k : e1.k;
            e1.l = e1.l == -1 ? e0.l : e1.l;
            e1.g = e1.g == -1 ? e0.g : e1.g;
            e1.i = e1.i == -1 ? e0.i : e1.i;
        }
        return e1;
    }

    @Override
    public final String toString() {
        return "EmptyViewInfo{invisible=" + this.a + ", reset=" + this.b + ", heightOfPixels=" + this.c + ", bgResId=" + this.d + ", imageResId=" + this.e + ", message=\'" + this.f + "\', messageColor=" + this.g + ", subMessage=\'" + this.h + "\', subMessageColor=" + this.i + ", buttonText=\'" + this.j + "\', buttonTextColor=" + this.k + ", buttonBgResId=" + this.l + ", buttonClickListener=" + this.m + '}';
    }
}

