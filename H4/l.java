package h4;

import java.util.Arrays;

public final class l {
    public boolean a;
    public int b;
    public int c;
    public int d;
    public byte[] e;
    public static final byte[] f;

    static {
        l.f = new byte[]{0, 0, 1};
    }

    public final void a(byte[] arr_b, int v, int v1) {
        if(!this.a) {
            return;
        }
        int v2 = v1 - v;
        byte[] arr_b1 = this.e;
        int v3 = this.c + v2;
        if(arr_b1.length < v3) {
            this.e = Arrays.copyOf(arr_b1, v3 * 2);
        }
        System.arraycopy(arr_b, v, this.e, this.c, v2);
        this.c += v2;
    }
}

