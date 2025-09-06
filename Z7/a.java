package z7;

import U4.x;

public final class a {
    public final String a;
    public final long b;
    public final long c;

    public a(String s, long v, long v1) {
        this.a = s;
        this.b = v;
        this.c = v1;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this ? true : object0 instanceof a && this.a.equals(((a)object0).a) && this.b == ((a)object0).b && this.c == ((a)object0).c;
    }

    @Override
    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003 ^ ((int)(this.b ^ this.b >>> 0x20))) * 1000003 ^ ((int)(this.c ^ this.c >>> 0x20));
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("InstallationTokenResult{token=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", tokenExpirationTimestamp=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", tokenCreationTimestamp=");
        return x.h(this.c, "}", stringBuilder0);
    }
}

