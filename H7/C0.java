package h7;

import U4.x;

public final class c0 extends F0 {
    public final Double a;
    public final int b;
    public final boolean c;
    public final int d;
    public final long e;
    public final long f;

    public c0(Double double0, int v, boolean z, int v1, long v2, long v3) {
        this.a = double0;
        this.b = v;
        this.c = z;
        this.d = v1;
        this.e = v2;
        this.f = v3;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof F0) {
            Double double0 = this.a;
            if(double0 == null) {
                return ((c0)(((F0)object0))).a == null ? this.b == ((c0)(((F0)object0))).b && this.c == ((c0)(((F0)object0))).c && this.d == ((c0)(((F0)object0))).d && this.e == ((c0)(((F0)object0))).e && this.f == ((c0)(((F0)object0))).f : false;
            }
            return double0.equals(((c0)(((F0)object0))).a) ? this.b == ((c0)(((F0)object0))).b && this.c == ((c0)(((F0)object0))).c && this.d == ((c0)(((F0)object0))).d && this.e == ((c0)(((F0)object0))).e && this.f == ((c0)(((F0)object0))).f : false;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = (((this.a == null ? 0 : this.a.hashCode()) ^ 1000003) * 1000003 ^ this.b) * 1000003;
        return this.c ? (((v ^ 0x4CF) * 1000003 ^ this.d) * 1000003 ^ ((int)(this.e ^ this.e >>> 0x20))) * 1000003 ^ ((int)(this.f ^ this.f >>> 0x20)) : (((v ^ 0x4D5) * 1000003 ^ this.d) * 1000003 ^ ((int)(this.e ^ this.e >>> 0x20))) * 1000003 ^ ((int)(this.f ^ this.f >>> 0x20));
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Device{batteryLevel=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", batteryVelocity=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", proximityOn=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", orientation=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", ramUsed=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", diskUsed=");
        return x.h(this.f, "}", stringBuilder0);
    }
}

