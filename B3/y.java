package b3;

import android.os.Bundle;

public final class y {
    public final long a;
    public final long b;
    public final long c;
    public final float d;
    public final float e;
    public static final y f;
    public static final String g;
    public static final String h;
    public static final String i;
    public static final String j;
    public static final String k;

    static {
        y.f = new y(new x());
        y.g = "0";
        y.h = "1";
        y.i = "2";
        y.j = "3";
        y.k = "4";
    }

    public y(x x0) {
        long v = x0.a;
        long v1 = x0.b;
        long v2 = x0.c;
        float f = x0.d;
        float f1 = x0.e;
        super();
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = f;
        this.e = f1;
    }

    public final x a() {
        x x0 = new x();  // 初始化器: Ljava/lang/Object;-><init>()V
        x0.a = this.a;
        x0.b = this.b;
        x0.c = this.c;
        x0.d = this.d;
        x0.e = this.e;
        return x0;
    }

    public static y b(Bundle bundle0) {
        x x0 = new x();
        x0.a = bundle0.getLong("0", y.f.a);
        x0.b = bundle0.getLong("1", y.f.b);
        x0.c = bundle0.getLong("2", y.f.c);
        x0.d = bundle0.getFloat("3", y.f.d);
        x0.e = bundle0.getFloat("4", y.f.e);
        return new y(x0);
    }

    public final Bundle c() {
        Bundle bundle0 = new Bundle();
        y y0 = y.f;
        long v = this.a;
        if(v != y0.a) {
            bundle0.putLong("0", v);
        }
        long v1 = this.b;
        if(v1 != y0.b) {
            bundle0.putLong("1", v1);
        }
        long v2 = this.c;
        if(v2 != y0.c) {
            bundle0.putLong("2", v2);
        }
        float f = this.d;
        if(f != y0.d) {
            bundle0.putFloat("3", f);
        }
        float f1 = this.e;
        if(f1 != y0.e) {
            bundle0.putFloat("4", f1);
        }
        return bundle0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof y ? this.a == ((y)object0).a && this.b == ((y)object0).b && this.c == ((y)object0).c && this.d == ((y)object0).d && this.e == ((y)object0).e : false;
    }

    @Override
    public final int hashCode() {
        int v = ((((int)(this.a ^ this.a >>> 0x20)) * 0x1F + ((int)(this.b ^ this.b >>> 0x20))) * 0x1F + ((int)(this.c >>> 0x20 ^ this.c))) * 0x1F;
        int v1 = 0;
        int v2 = Float.compare(this.d, 0.0f) == 0 ? 0 : Float.floatToIntBits(this.d);
        float f = this.e;
        if(f != 0.0f) {
            v1 = Float.floatToIntBits(f);
        }
        return (v + v2) * 0x1F + v1;
    }
}

