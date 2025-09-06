package f4;

import I6.V;
import I6.p0;
import Y3.k;
import Y3.l;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import e3.b;
import e3.e;
import e3.p;
import e3.x;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public final class a implements l {
    public final p a;
    public final boolean b;
    public final int c;
    public final int d;
    public final String e;
    public final float f;
    public final int g;

    public a(List list0) {
        this.a = new p();
        String s = "sans-serif";
        boolean z = false;
        if(list0.size() == 1) {
            switch(((byte[])list0.get(0)).length) {
                case 0x30: 
                case 53: {
                    byte[] arr_b = (byte[])list0.get(0);
                    this.c = arr_b[24];
                    this.d = (arr_b[26] & 0xFF) << 24 | (arr_b[27] & 0xFF) << 16 | (arr_b[28] & 0xFF) << 8 | arr_b[29] & 0xFF;
                    if("Serif".equals(new String(arr_b, 43, arr_b.length - 43, StandardCharsets.UTF_8))) {
                        s = "serif";
                    }
                    this.e = s;
                    int v = arr_b[25] * 20;
                    this.g = v;
                    if((arr_b[0] & 0x20) != 0) {
                        z = true;
                    }
                    this.b = z;
                    if(z) {
                        this.f = x.g(((float)(arr_b[11] & 0xFF | (arr_b[10] & 0xFF) << 8)) / ((float)v), 0.0f, 0.95f);
                        return;
                    }
                    this.f = 0.85f;
                    return;
                }
            }
        }
        this.c = 0;
        this.d = -1;
        this.e = "sans-serif";
        this.b = false;
        this.f = 0.85f;
        this.g = -1;
    }

    public static void a(SpannableStringBuilder spannableStringBuilder0, int v, int v1, int v2, int v3, int v4) {
        if(v != v1) {
            spannableStringBuilder0.setSpan(new ForegroundColorSpan(v >>> 8 | (v & 0xFF) << 24), v2, v3, v4 | 33);
        }
    }

    public static void b(SpannableStringBuilder spannableStringBuilder0, int v, int v1, int v2, int v3, int v4) {
        boolean z = true;
        if(v != v1) {
            boolean z1 = (v & 1) != 0;
            boolean z2 = (v & 2) != 0;
            if(!z1) {
                if(z2) {
                    U4.x.t(2, spannableStringBuilder0, v2, v3, v4 | 33);
                }
            }
            else if(z2) {
                U4.x.t(3, spannableStringBuilder0, v2, v3, v4 | 33);
            }
            else {
                U4.x.t(1, spannableStringBuilder0, v2, v3, v4 | 33);
            }
            if((v & 4) == 0) {
                z = false;
            }
            else {
                spannableStringBuilder0.setSpan(new UnderlineSpan(), v2, v3, v4 | 33);
            }
            if(!z && !z1 && !z2) {
                U4.x.t(0, spannableStringBuilder0, v2, v3, v4 | 33);
            }
        }
    }

    @Override  // Y3.l
    public final void g(byte[] arr_b, int v, int v1, k k0, e e0) {
        int v17;
        String s;
        p p0 = this.a;
        p0.E(arr_b, v + v1);
        p0.G(v);
        b.c(p0.a() >= 2);
        int v2 = p0.A();
        if(v2 == 0) {
            s = "";
        }
        else {
            int v3 = p0.b;
            Charset charset0 = p0.C();
            int v4 = v2 - (p0.b - v3);
            if(charset0 == null) {
                charset0 = StandardCharsets.UTF_8;
            }
            s = p0.s(v4, charset0);
        }
        if(s.isEmpty()) {
            e0.accept(new Y3.a(p0.e, 0x8000000000000001L, 0x8000000000000001L));
            return;
        }
        SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder(s);
        int v5 = spannableStringBuilder0.length();
        a.b(spannableStringBuilder0, this.c, 0, 0, v5, 0xFF0000);
        int v6 = spannableStringBuilder0.length();
        a.a(spannableStringBuilder0, this.d, -1, 0, v6, 0xFF0000);
        int v7 = spannableStringBuilder0.length();
        String s1 = this.e;
        if(s1 != "sans-serif") {
            spannableStringBuilder0.setSpan(new TypefaceSpan(s1), 0, v7, 0xFF0021);
        }
        float f = this.f;
        while(p0.a() >= 8) {
            int v8 = p0.b;
            int v9 = p0.g();
            int v10 = p0.g();
            if(v10 == 1937013100) {
                b.c(p0.a() >= 2);
                int v11 = p0.A();
                for(int v12 = 0; v12 < v11; v12 = v17 + 1) {
                    b.c(p0.a() >= 12);
                    int v13 = p0.A();
                    int v14 = p0.A();
                    p0.H(2);
                    int v15 = p0.u();
                    p0.H(1);
                    int v16 = p0.g();
                    if(v14 > spannableStringBuilder0.length()) {
                        StringBuilder stringBuilder0 = U4.x.n(v14, "Truncating styl end (", ") to cueText.length() (");
                        stringBuilder0.append(spannableStringBuilder0.length());
                        stringBuilder0.append(").");
                        b.D("Tx3gParser", stringBuilder0.toString());
                        v14 = spannableStringBuilder0.length();
                    }
                    if(v13 >= v14) {
                        b.D("Tx3gParser", "Ignoring styl with start (" + v13 + ") >= end (" + v14 + ").");
                        v17 = v12;
                    }
                    else {
                        v17 = v12;
                        a.b(spannableStringBuilder0, v15, this.c, v13, v14, 0);
                        a.a(spannableStringBuilder0, v16, this.d, v13, v14, 0);
                    }
                }
            }
            else if(v10 == 1952608120 && this.b) {
                b.c(p0.a() >= 2);
                f = x.g(((float)p0.A()) / ((float)this.g), 0.0f, 0.95f);
            }
            p0.G(v8 + v9);
        }
        e0.accept(new Y3.a(V.t(new d3.b(spannableStringBuilder0, null, null, null, f, 0, 0, -3.402823E+38f, 0x80000000, 0x80000000, -3.402823E+38f, -3.402823E+38f, -3.402823E+38f, false, 0xFF000000, 0x80000000, 0.0f)), 0x8000000000000001L, 0x8000000000000001L));
    }

    @Override  // Y3.l
    public final int j() {
        return 2;
    }
}

