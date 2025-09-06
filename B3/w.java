package b3;

import F4.a;
import I6.V;
import I6.Y;
import android.net.Uri;
import e3.b;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public final class w {
    public final UUID a;
    public final Uri b;
    public final Y c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final V g;
    public final byte[] h;
    public static final String i;
    public static final String j;
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;

    static {
        w.i = "0";
        w.j = "1";
        w.k = "2";
        w.l = "3";
        w.m = "4";
        w.n = "5";
        w.o = "6";
        w.p = "7";
    }

    public w(a a0) {
        b.j(!a0.c || ((Uri)a0.e) != null);
        UUID uUID0 = (UUID)a0.d;
        uUID0.getClass();
        this.a = uUID0;
        this.b = (Uri)a0.e;
        this.c = (Y)a0.f;
        this.d = a0.a;
        this.f = a0.c;
        this.e = a0.b;
        this.g = (V)a0.g;
        byte[] arr_b = (byte[])a0.h;
        this.h = arr_b == null ? null : Arrays.copyOf(arr_b, arr_b.length);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof w ? this.a.equals(((w)object0).a) && Objects.equals(this.b, ((w)object0).b) && Objects.equals(this.c, ((w)object0).c) && this.d == ((w)object0).d && this.f == ((w)object0).f && this.e == ((w)object0).e && this.g.equals(((w)object0).g) && Arrays.equals(this.h, ((w)object0).h) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? Arrays.hashCode(this.h) + (this.g.hashCode() + ((((this.c.hashCode() + v * 961) * 0x1F + this.d) * 0x1F + this.f) * 0x1F + this.e) * 0x1F) * 0x1F : Arrays.hashCode(this.h) + (this.g.hashCode() + ((((this.c.hashCode() + (v * 0x1F + this.b.hashCode()) * 0x1F) * 0x1F + this.d) * 0x1F + this.f) * 0x1F + this.e) * 0x1F) * 0x1F;
    }
}

