package i.n.i.b.a.s.e;

import java.util.ArrayList;

public final class Hb implements re {
    public Gd b;
    public static final int[] c;

    static {
        Hb.c = new int[]{8, 13, 11, 2, 0, 1, 7};
    }

    public Hb() {
        this.b = Gd.h0;
    }

    public static void a(int v, ArrayList arrayList0) {
        int v1;
        for(v1 = 0; true; ++v1) {
            if(v1 >= 7) {
                v1 = -1;
                break;
            }
            if(Hb.c[v1] == v) {
                break;
            }
        }
        if(v1 != -1 && !arrayList0.contains(v)) {
            arrayList0.add(v);
        }
    }
}

