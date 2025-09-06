package g7;

import U4.x;

public final class i {
    public final int a;
    public final int b;
    public static final i c;

    static {
        i.c = new i(0, 0);
    }

    public i(int v, int v1) {
        this.a = v;
        this.b = v1;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("i");
        stringBuilder0.append("[position = ");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", length = ");
        return x.g(this.b, "]", stringBuilder0);
    }
}

