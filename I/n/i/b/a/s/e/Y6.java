package i.n.i.b.a.s.e;

import androidx.appcompat.app.o;

public final class y6 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public static final y6 e;

    static {
        y6.e = new y6(-1, -1, -1);
    }

    public y6(int v, int v1, int v2) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = L7.G(v2) ? L7.v(v2, v1) : -1;
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

