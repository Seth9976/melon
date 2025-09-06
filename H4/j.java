package h4;

import java.util.Arrays;

public final class j {
    public boolean a;
    public int b;
    public int c;
    public byte[] d;
    public static final byte[] e;

    static {
        j.e = new byte[]{0, 0, 1};
    }

    public final void a(byte[] arr_b, int v, int v1) {
        if(!this.a) {
            return;
        }
        int v2 = v1 - v;
        byte[] arr_b1 = this.d;
        int v3 = this.b + v2;
        if(arr_b1.length < v3) {
            this.d = Arrays.copyOf(arr_b1, v3 * 2);
        }
        System.arraycopy(arr_b, v, this.d, this.b, v2);
        this.b += v2;
    }
}

