package vd;

import kotlin.jvm.internal.q;
import pe.b;

public enum a {
    NOW_PLAYING,
    NORMAL_PLAYLIST,
    DJ_PLAYLIST;

    public static final a[] d;

    static {
        a.d = arr_a;
        q.g(arr_a, "entries");
        new b(arr_a);
    }
}

