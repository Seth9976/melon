package jf;

import kotlin.jvm.internal.q;

public enum b {
    PROPERTY,
    BACKING_FIELD,
    DELEGATE_FIELD;

    public static final b[] d;

    static {
        b.d = arr_b;
        q.g(arr_b, "entries");
        new pe.b(arr_b);
    }
}

