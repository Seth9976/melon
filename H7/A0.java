package h7;

import androidx.appcompat.app.o;

public final class a0 extends D0 {
    public final String a;
    public final int b;
    public final int c;
    public final boolean d;

    public a0(String s, int v, int v1, boolean z) {
        this.a = s;
        this.b = v;
        this.c = v1;
        this.d = z;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this ? true : object0 instanceof D0 && this.a.equals(((a0)(((D0)object0))).a) && this.b == ((a0)(((D0)object0))).b && this.c == ((a0)(((D0)object0))).c && this.d == ((a0)(((D0)object0))).d;
    }

    @Override
    public final int hashCode() {
        int v = (((this.a.hashCode() ^ 1000003) * 1000003 ^ this.b) * 1000003 ^ this.c) * 1000003;
        return this.d ? v ^ 0x4CF : v ^ 0x4D5;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ProcessDetails{processName=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", pid=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", importance=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", defaultProcess=");
        return o.s(stringBuilder0, this.d, "}");
    }
}

