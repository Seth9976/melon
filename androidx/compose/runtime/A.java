package androidx.compose.runtime;

import U4.x;

public final class a {
    public int a;

    public a(int v) {
        this.a = v;
    }

    public final boolean a() {
        return this.a != 0x80000000;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(super.toString());
        stringBuilder0.append("{ location = ");
        return x.g(this.a, " }", stringBuilder0);
    }
}

