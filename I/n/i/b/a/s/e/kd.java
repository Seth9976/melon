package i.n.i.b.a.s.e;

import U4.x;

public final class Kd {
    public final int a;
    public final String b;
    public static final Kd c;

    static {
        Kd.c = new Kd(-1, "default");
    }

    public Kd(int v, String s) {
        this.a = v;
        this.b = s;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Stream(id=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", type=");
        return x.m(stringBuilder0, this.b, ")");
    }
}

