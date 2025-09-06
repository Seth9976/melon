package pb;

import kotlin.jvm.internal.q;
import pe.b;

public enum r {
    UNKNOWN,
    LOCAL_MP3,
    LOCAL_DCF,
    LOCAL_FLAC,
    ST_FLAC,
    ST_AAC,
    ST_AAC_128,
    ST_AAC_320,
    ST_MP3_128,
    ST_MP3_192,
    ST_MP3_320,
    ST_DOLBY;

    public static final r[] m;

    static {
        r.m = arr_r;
        q.g(arr_r, "entries");
        new b(arr_r);
    }
}

