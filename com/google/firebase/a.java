package com.google.firebase;

import U4.x;

public final class a {
    public final long a;
    public final long b;
    public final long c;

    public a(long v, long v1, long v2) {
        this.a = v;
        this.b = v1;
        this.c = v2;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this ? true : object0 instanceof a && this.a == ((a)object0).a && this.b == ((a)object0).b && this.c == ((a)object0).c;
    }

    @Override
    public final int hashCode() {
        return ((((int)(this.a ^ this.a >>> 0x20)) ^ 1000003) * 1000003 ^ ((int)(this.b ^ this.b >>> 0x20))) * 1000003 ^ ((int)(this.c >>> 0x20 ^ this.c));
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("StartupTime{epochMillis=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", elapsedRealtime=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", uptimeMillis=");
        return x.h(this.c, "}", stringBuilder0);
    }
}

