package i.n.i.b.a.s.e;

import B3.k;

public final class r extends k {
    public static int g(int v, byte[] arr_b) {
        return arr_b[v + 3] & 0xFF | ((arr_b[v] & 0xFF) << 24 | (arr_b[v + 1] & 0xFF) << 16 | (arr_b[v + 2] & 0xFF) << 8);
    }
}

