package androidx.room;

import e1.m;
import ea.a;
import java.util.Set;
import je.y;
import kotlin.jvm.internal.q;

public final class v {
    public final a a;
    public final int[] b;
    public final String[] c;
    public final Set d;

    public v(a a0, int[] arr_v, String[] arr_s) {
        q.g(a0, "observer");
        q.g(arr_v, "tableIds");
        q.g(arr_s, "tableNames");
        super();
        this.a = a0;
        this.b = arr_v;
        this.c = arr_s;
        if(arr_v.length != arr_s.length) {
            throw new IllegalStateException("Check failed.");
        }
        Set set0 = arr_s.length == 0 ? y.a : m.E(arr_s[0]);
        this.d = set0;
    }
}

