package nf;

import java.util.Arrays;
import kotlin.jvm.internal.q;

public final class e extends a {
    public final boolean f;
    public static final e g;
    public static final e h;

    static {
        e e0 = new e(new int[]{2, 2, 0}, false);
        e.g = e0;
        e.h = e0.b != 1 || e0.c != 9 ? new e(new int[]{e0.b, e0.c + 1, 0}, false) : new e(new int[]{2, 0, 0}, false);
        new e(new int[0], false);
    }

    public e(int[] arr_v, boolean z) {
        q.g(arr_v, "versionArray");
        super(Arrays.copyOf(arr_v, arr_v.length));
        this.f = z;
    }

    public final boolean b(e e0) {
        q.g(e0, "metadataVersionFromLanguageVersion");
        e e1 = this.f ? e.g : e.h;
        if(e1.b > e0.b || e1.b >= e0.b && e1.c > e0.c) {
            e0 = e1;
        }
        int v = this.c;
        int v1 = 0;
        int v2 = this.b;
        if(v2 == 1 && v == 0 || v2 == 0) {
            return false;
        }
        if(v2 > e0.b || v2 >= e0.b && v > e0.c) {
            v1 = 1;
        }
        return v1 ^ 1;
    }
}

