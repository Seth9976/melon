package E9;

import U4.x;

public final class c {
    public final int a;
    public final int b;
    public final Object c;

    public c(int v, int v1, Object object0) {
        this.a = v;
        this.b = v1;
        this.c = object0;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("MediaLoadData(data=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(" track=");
        return x.g(this.b, ")", stringBuilder0);
    }
}

