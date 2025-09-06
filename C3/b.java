package c3;

import androidx.appcompat.app.o;
import e3.x;
import java.util.Arrays;

public final class b {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public static final b e;

    static {
        b.e = new b(-1, -1, -1);
    }

    public b(int v, int v1, int v2) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = x.H(v2) ? x.A(v2, v1) : -1;
    }

    @Override
    public final boolean equals(Object object0) [...] // 潜在的解密器

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c});
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("AudioFormat[sampleRate=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", channelCount=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", encoding=");
        return o.q(stringBuilder0, this.c, ']');
    }
}

