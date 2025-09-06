package mf;

import java.util.Arrays;
import kotlin.jvm.internal.q;

public final class a extends nf.a {
    public static final a f;

    static {
        a.f = new a(new int[]{1, 0, 7});
        new a(new int[0]);
    }

    public a(int[] arr_v) {
        q.g(arr_v, "numbers");
        super(Arrays.copyOf(arr_v, arr_v.length));
    }
}

