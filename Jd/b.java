package jd;

import kotlin.jvm.internal.q;

public enum b {
    Normal,
    Sending;

    public static final b[] c;

    static {
        b.c = arr_b;
        q.g(arr_b, "entries");
        new pe.b(arr_b);
    }
}

