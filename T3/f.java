package T3;

import B3.s;

public final class f {
    public final byte[] a;
    public int b;
    public int c;
    public static final long[] d;

    static {
        f.d = new long[]{0x80L, 0x40L, 0x20L, 16L, 8L, 4L, 2L, 1L};
    }

    public f() {
        this.a = new byte[8];
    }

    public static long a(byte[] arr_b, int v, boolean z) {
        long v1 = ((long)arr_b[0]) & 0xFFL;
        if(z) {
            v1 &= ~f.d[v - 1];
        }
        for(int v2 = 1; v2 < v; ++v2) {
            v1 = v1 << 8 | ((long)arr_b[v2]) & 0xFFL;
        }
        return v1;
    }

    public final long b(s s0, boolean z, boolean z1, int v) {
        int v3;
        byte[] arr_b = this.a;
        if(this.b == 0) {
            if(!s0.readFully(arr_b, 0, 1, z)) {
                return -1L;
            }
            int v1 = arr_b[0] & 0xFF;
            for(int v2 = 0; true; ++v2) {
                v3 = -1;
                if(v2 >= 8) {
                    break;
                }
                if((f.d[v2] & ((long)v1)) != 0L) {
                    v3 = v2 + 1;
                    break;
                }
            }
            this.c = v3;
            if(v3 == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.b = 1;
        }
        int v4 = this.c;
        if(v4 > v) {
            this.b = 0;
            return -2L;
        }
        if(v4 != 1) {
            s0.readFully(arr_b, 1, v4 - 1);
        }
        this.b = 0;
        return f.a(arr_b, this.c, z1);
    }
}

