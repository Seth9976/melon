package androidx.media3.common;

import I6.V;
import I6.p0;
import android.net.Uri;
import android.os.Bundle;
import b3.G;
import b3.T;
import e3.b;
import java.util.Objects;

public final class c {
    public CharSequence A;
    public Integer B;
    public Integer C;
    public CharSequence D;
    public CharSequence E;
    public CharSequence F;
    public Integer G;
    public Bundle H;
    public V I;
    public CharSequence a;
    public CharSequence b;
    public CharSequence c;
    public CharSequence d;
    public CharSequence e;
    public CharSequence f;
    public CharSequence g;
    public Long h;
    public T i;
    public T j;
    public byte[] k;
    public Integer l;
    public Uri m;
    public Integer n;
    public Integer o;
    public Integer p;
    public Boolean q;
    public Boolean r;
    public Integer s;
    public Integer t;
    public Integer u;
    public Integer v;
    public Integer w;
    public Integer x;
    public CharSequence y;
    public CharSequence z;

    public c() {
        this.I = p0.e;
    }

    public final void a(int v, byte[] arr_b) {
        if(this.k != null && !v.equals(3) && Objects.equals(this.l, 3)) {
            return;
        }
        this.k = (byte[])arr_b.clone();
        this.l = v;
    }

    public final void b(G g0) {
        if(g0 != null) {
            V v0 = g0.J;
            byte[] arr_b = g0.k;
            CharSequence charSequence0 = g0.a;
            if(charSequence0 != null) {
                this.a = charSequence0;
            }
            CharSequence charSequence1 = g0.b;
            if(charSequence1 != null) {
                this.b = charSequence1;
            }
            CharSequence charSequence2 = g0.c;
            if(charSequence2 != null) {
                this.c = charSequence2;
            }
            CharSequence charSequence3 = g0.d;
            if(charSequence3 != null) {
                this.d = charSequence3;
            }
            CharSequence charSequence4 = g0.e;
            if(charSequence4 != null) {
                this.e = charSequence4;
            }
            CharSequence charSequence5 = g0.f;
            if(charSequence5 != null) {
                this.f = charSequence5;
            }
            CharSequence charSequence6 = g0.g;
            if(charSequence6 != null) {
                this.g = charSequence6;
            }
            Long long0 = g0.h;
            if(long0 != null) {
                this.d(long0);
            }
            T t0 = g0.i;
            if(t0 != null) {
                this.i = t0;
            }
            T t1 = g0.j;
            if(t1 != null) {
                this.j = t1;
            }
            Uri uri0 = g0.m;
            if(uri0 != null || arr_b != null) {
                this.m = uri0;
                this.c(arr_b, g0.l);
            }
            Integer integer0 = g0.n;
            if(integer0 != null) {
                this.n = integer0;
            }
            Integer integer1 = g0.o;
            if(integer1 != null) {
                this.o = integer1;
            }
            Integer integer2 = g0.p;
            if(integer2 != null) {
                this.p = integer2;
            }
            Boolean boolean0 = g0.q;
            if(boolean0 != null) {
                this.q = boolean0;
            }
            Boolean boolean1 = g0.r;
            if(boolean1 != null) {
                this.r = boolean1;
            }
            Integer integer3 = g0.s;
            if(integer3 != null) {
                this.s = integer3;
            }
            Integer integer4 = g0.t;
            if(integer4 != null) {
                this.s = integer4;
            }
            Integer integer5 = g0.u;
            if(integer5 != null) {
                this.t = integer5;
            }
            Integer integer6 = g0.v;
            if(integer6 != null) {
                this.u = integer6;
            }
            Integer integer7 = g0.w;
            if(integer7 != null) {
                this.v = integer7;
            }
            Integer integer8 = g0.x;
            if(integer8 != null) {
                this.w = integer8;
            }
            Integer integer9 = g0.y;
            if(integer9 != null) {
                this.x = integer9;
            }
            CharSequence charSequence7 = g0.z;
            if(charSequence7 != null) {
                this.y = charSequence7;
            }
            CharSequence charSequence8 = g0.A;
            if(charSequence8 != null) {
                this.z = charSequence8;
            }
            CharSequence charSequence9 = g0.B;
            if(charSequence9 != null) {
                this.A = charSequence9;
            }
            Integer integer10 = g0.C;
            if(integer10 != null) {
                this.B = integer10;
            }
            Integer integer11 = g0.D;
            if(integer11 != null) {
                this.C = integer11;
            }
            CharSequence charSequence10 = g0.E;
            if(charSequence10 != null) {
                this.D = charSequence10;
            }
            CharSequence charSequence11 = g0.F;
            if(charSequence11 != null) {
                this.E = charSequence11;
            }
            CharSequence charSequence12 = g0.G;
            if(charSequence12 != null) {
                this.F = charSequence12;
            }
            Integer integer12 = g0.H;
            if(integer12 != null) {
                this.G = integer12;
            }
            Bundle bundle0 = g0.I;
            if(bundle0 != null) {
                this.H = bundle0;
            }
            if(!v0.isEmpty()) {
                this.I = V.p(v0);
            }
        }
    }

    public final void c(byte[] arr_b, Integer integer0) {
        this.k = arr_b == null ? null : ((byte[])arr_b.clone());
        this.l = integer0;
    }

    public final void d(Long long0) {
        b.c(long0 == null || ((long)long0) >= 0L);
        this.h = long0;
    }
}

