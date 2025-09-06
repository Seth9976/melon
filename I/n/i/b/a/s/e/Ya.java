package i.n.i.b.a.s.e;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;

public final class ya {
    public static final int[] A;
    public static final boolean[] B;
    public static final int[] C;
    public static final int[] D;
    public static final int[] E;
    public static final int[] F;
    public final ArrayList a;
    public final SpannableStringBuilder b;
    public boolean c;
    public boolean d;
    public int e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public static final int w;
    public static final int x;
    public static final int[] y;
    public static final int[] z;

    static {
        ya.w = ya.a(2, 2, 2, 0);
        int v = ya.a(0, 0, 0, 0);
        ya.x = v;
        int v1 = ya.a(0, 0, 0, 3);
        ya.y = new int[]{0, 0, 0, 0, 0, 2, 0};
        ya.z = new int[]{0, 0, 0, 0, 0, 0, 2};
        ya.A = new int[]{3, 3, 3, 3, 3, 3, 1};
        ya.B = new boolean[]{false, false, false, true, true, true, false};
        ya.C = new int[]{v, v1, v, v, v1, v, v};
        ya.D = new int[]{0, 1, 2, 3, 4, 3, 4};
        ya.E = new int[]{0, 0, 0, 0, 0, 3, 3};
        ya.F = new int[]{v, v, v, v, v, v1, v1};
    }

    public ya() {
        this.a = new ArrayList();
        this.b = new SpannableStringBuilder();
        this.f();
    }

    public static int a(int v, int v1, int v2, int v3) {
        int v5;
        M7.z(v, 4);
        M7.z(v1, 4);
        M7.z(v2, 4);
        M7.z(v3, 4);
        int v4 = 0xFF;
        switch(v3) {
            case 2: {
                v5 = 0x7F;
                break;
            }
            case 3: {
                v5 = 0;
                break;
            }
            default: {
                v5 = 0xFF;
            }
        }
        if(v2 <= 1) {
            v4 = 0;
        }
        return Color.argb(v5, (v <= 1 ? 0 : 0xFF), (v1 <= 1 ? 0 : 0xFF), v4);
    }

    public final void b(char c) {
        SpannableStringBuilder spannableStringBuilder0 = this.b;
        if(c == 10) {
            SpannableString spannableString0 = this.e();
            ArrayList arrayList0 = this.a;
            arrayList0.add(spannableString0);
            spannableStringBuilder0.clear();
            if(this.p != -1) {
                this.p = 0;
            }
            if(this.q != -1) {
                this.q = 0;
            }
            if(this.r != -1) {
                this.r = 0;
            }
            if(this.t != -1) {
                this.t = 0;
            }
            while(this.k && arrayList0.size() >= this.j || arrayList0.size() >= 15) {
                arrayList0.remove(0);
            }
            return;
        }
        spannableStringBuilder0.append(c);
    }

    public final void c(boolean z, boolean z1) {
        SpannableStringBuilder spannableStringBuilder0 = this.b;
        if(this.p == -1) {
            if(z) {
                this.p = spannableStringBuilder0.length();
            }
        }
        else if(!z) {
            spannableStringBuilder0.setSpan(new StyleSpan(2), this.p, spannableStringBuilder0.length(), 33);
            this.p = -1;
        }
        if(this.q != -1) {
            if(!z1) {
                spannableStringBuilder0.setSpan(new UnderlineSpan(), this.q, spannableStringBuilder0.length(), 33);
                this.q = -1;
            }
        }
        else if(z1) {
            this.q = spannableStringBuilder0.length();
        }
    }

    public final void d(int v, int v1) {
        SpannableStringBuilder spannableStringBuilder0 = this.b;
        if(this.r != -1 && this.s != v) {
            spannableStringBuilder0.setSpan(new ForegroundColorSpan(this.s), this.r, spannableStringBuilder0.length(), 33);
        }
        if(v != ya.w) {
            this.r = spannableStringBuilder0.length();
            this.s = v;
        }
        if(this.t != -1 && this.u != v1) {
            spannableStringBuilder0.setSpan(new BackgroundColorSpan(this.u), this.t, spannableStringBuilder0.length(), 33);
        }
        if(v1 != ya.x) {
            this.t = spannableStringBuilder0.length();
            this.u = v1;
        }
    }

    public final SpannableString e() {
        SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder(this.b);
        int v = spannableStringBuilder0.length();
        if(v > 0) {
            if(this.p != -1) {
                spannableStringBuilder0.setSpan(new StyleSpan(2), this.p, v, 33);
            }
            if(this.q != -1) {
                spannableStringBuilder0.setSpan(new UnderlineSpan(), this.q, v, 33);
            }
            if(this.r != -1) {
                spannableStringBuilder0.setSpan(new ForegroundColorSpan(this.s), this.r, v, 33);
            }
            if(this.t != -1) {
                spannableStringBuilder0.setSpan(new BackgroundColorSpan(this.u), this.t, v, 33);
            }
        }
        return new SpannableString(spannableStringBuilder0);
    }

    public final void f() {
        this.a.clear();
        this.b.clear();
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.t = -1;
        this.v = 0;
        this.c = false;
        this.d = false;
        this.e = 4;
        this.f = false;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 15;
        this.k = true;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = ya.x;
        this.s = ya.w;
        this.u = ya.x;
    }
}

