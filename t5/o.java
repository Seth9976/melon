package t5;

import A7.d;
import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.ColorSpace;
import okhttp3.Headers;
import u5.f;
import u5.g;

public final class o {
    public final Context a;
    public final Bitmap.Config b;
    public final ColorSpace c;
    public final g d;
    public final f e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final String i;
    public final Headers j;
    public final t k;
    public final q l;
    public final b m;
    public final b n;
    public final b o;

    public o(Context context0, Bitmap.Config bitmap$Config0, ColorSpace colorSpace0, g g0, f f0, boolean z, boolean z1, boolean z2, String s, Headers headers0, t t0, q q0, b b0, b b1, b b2) {
        this.a = context0;
        this.b = bitmap$Config0;
        this.c = colorSpace0;
        this.d = g0;
        this.e = f0;
        this.f = z;
        this.g = z1;
        this.h = z2;
        this.i = s;
        this.j = headers0;
        this.k = t0;
        this.l = q0;
        this.m = b0;
        this.n = b1;
        this.o = b2;
    }

    // 去混淆评级： 中等(90)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof o && kotlin.jvm.internal.q.b(this.a, ((o)object0).a) && this.b == ((o)object0).b && kotlin.jvm.internal.q.b(this.c, ((o)object0).c) && kotlin.jvm.internal.q.b(this.d, ((o)object0).d) && this.e == ((o)object0).e && this.f == ((o)object0).f && this.g == ((o)object0).g && this.h == ((o)object0).h && kotlin.jvm.internal.q.b(this.i, ((o)object0).i) && kotlin.jvm.internal.q.b(this.j, ((o)object0).j) && kotlin.jvm.internal.q.b(this.k, ((o)object0).k) && kotlin.jvm.internal.q.b(this.l, ((o)object0).l) && this.m == ((o)object0).m && this.n == ((o)object0).n && this.o == ((o)object0).o;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = d.e(d.e(d.e((this.e.hashCode() + (this.d.hashCode() + ((this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F + (this.c == null ? 0 : this.c.hashCode())) * 0x1F) * 0x1F) * 0x1F, 0x1F, this.f), 0x1F, this.g), 0x1F, this.h);
        String s = this.i;
        if(s != null) {
            v = s.hashCode();
        }
        return this.o.hashCode() + (this.n.hashCode() + (this.m.hashCode() + (this.l.a.hashCode() + (this.k.a.hashCode() + (this.j.hashCode() + (v1 + v) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F;
    }
}

