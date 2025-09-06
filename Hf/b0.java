package Hf;

import kotlin.jvm.internal.q;
import pe.b;

public enum b0 {
    INVARIANT("", true),
    IN_VARIANCE("in", false),
    OUT_VARIANCE("out", true);

    public final String a;
    public final boolean b;
    public static final b0[] f;

    static {
        b0.f = arr_b0;
        q.g(arr_b0, "entries");
        new b(arr_b0);
    }

    public b0(String s1, boolean z) {
        this.a = s1;
        this.b = z;
    }

    @Override
    public final String toString() {
        return this.a;
    }
}

