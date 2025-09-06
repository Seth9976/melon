package androidx.compose.foundation.lazy.layout;

import L.a;

public final class g {
    public final int a;
    public final int b;
    public final p c;

    public g(int v, int v1, p p0) {
        this.a = v;
        this.b = v1;
        this.c = p0;
        if(v < 0) {
            a.a("startIndex should be >= 0");
        }
        if(v1 > 0) {
            return;
        }
        a.a("size should be > 0");
    }
}

