package androidx.compose.runtime;

import java.util.ArrayList;

public final class b extends w {
    public final int b;

    public b(int v) {
        this.b = v;
    }

    @Override  // androidx.compose.runtime.w
    public final Object k(B0 b00) {
        if(b00.g) {
            q.c("use active SlotWriter to create an anchor location instead");
        }
        int v = this.b;
        if(v < 0 || v >= b00.b) {
            j0.a("Parameter index is out of range");
        }
        ArrayList arrayList0 = b00.i;
        int v1 = D0.f(arrayList0, v, b00.b);
        if(v1 < 0) {
            a a0 = new a(v);
            arrayList0.add(-(v1 + 1), a0);
            return a0;
        }
        return (a)arrayList0.get(v1);
    }
}

