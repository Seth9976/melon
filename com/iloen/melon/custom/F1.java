package com.iloen.melon.custom;

import kotlin.jvm.internal.q;
import pe.b;

public enum f1 {
    NORMAL,
    USE_STAUST_BAR_AREA,
    ADJUST_FOR_IME,
    CUSTOM;

    public static final f1[] e;

    static {
        f1.e = arr_f1;
        q.g(arr_f1, "entries");
        new b(arr_f1);
    }
}

