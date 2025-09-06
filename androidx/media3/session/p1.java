package androidx.media3.session;

import b3.E;

public final class p1 {
    public final E a;
    public final long b;
    public final long c;

    public p1(E e0, long v, long v1) {
        this.a = e0;
        this.b = v;
        this.c = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof p1 ? this.b == ((p1)object0).b && this.a.equals(((p1)object0).a) && this.c == ((p1)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return (this.a.hashCode() + (0xD9 + ((int)(this.b ^ this.b >>> 0x20))) * 0x1F) * 0x1F + ((int)(this.c >>> 0x20 ^ this.c));
    }
}

