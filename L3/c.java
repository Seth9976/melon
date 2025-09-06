package l3;

import androidx.media3.common.b;
import b3.n;
import java.util.ArrayList;
import ye.a;

public final class c implements h {
    public R6.c a;
    public boolean b;
    public static final int[] c;

    static {
        c.c = new int[]{8, 13, 11, 2, 0, 1, 7};
    }

    public static void a(int v, ArrayList arrayList0) {
        if(a.I(v, c.c, 0, 7) != -1 && !arrayList0.contains(v)) {
            arrayList0.add(v);
        }
    }

    public final b b(b b0) {
        if(this.b && this.a.n(b0)) {
            n n0 = b0.a();
            n0.m = "application/x-media3-cues";
            n0.H = this.a.e(b0);
            n0.j = b0.n + (b0.k == null ? "" : " " + b0.k);
            n0.r = 0x7FFFFFFFFFFFFFFFL;
            return new b(n0);
        }
        return b0;
    }
}

