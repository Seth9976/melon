package Kf;

import kotlin.jvm.internal.q;
import pe.b;

public enum i {
    IN("in"),
    OUT("out"),
    INV("");

    public final String a;
    public static final i[] e;

    static {
        i.e = arr_i;
        q.g(arr_i, "entries");
        new b(arr_i);
    }

    public i(String s1) {
        this.a = s1;
    }

    @Override
    public final String toString() {
        return this.a;
    }
}

