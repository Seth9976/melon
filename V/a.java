package v;

import java.util.HashSet;

public final class a {
    public final HashSet a;
    public static final a b;

    static {
        a.b = new a(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        new a(new int[]{1, 2, 3, 4, 5, 6, 7});
    }

    public a(int[] arr_v) {
        this.a = new HashSet();
        for(int v = 0; v < arr_v.length; ++v) {
            this.a.add(((int)arr_v[v]));
        }
    }
}

