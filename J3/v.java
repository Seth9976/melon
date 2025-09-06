package j3;

import java.nio.ByteBuffer;
import y5.a;

public final class v {
    public ByteBuffer a;
    public int b;
    public int c;
    public static final byte[] d;
    public static final byte[] e;

    static {
        v.d = new byte[]{0x4F, 103, 103, 83, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, -43, -59, -9, 1, 19, 0x4F, 0x70, 0x75, 0x73, 72, 101, 97, 100, 1, 2, 56, 1, (byte)0x80, -69, 0, 0, 0, 0, 0};
        v.e = new byte[]{0x4F, 103, 103, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 11, -103, 87, 83, 1, 16, 0x4F, 0x70, 0x75, 0x73, 84, 97, 103, 0x73, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    public static void a(ByteBuffer byteBuffer0, long v, int v1, int v2, boolean z) {
        byteBuffer0.put(0x4F);
        byteBuffer0.put(103);
        byteBuffer0.put(103);
        byteBuffer0.put(83);
        boolean z1 = false;
        byteBuffer0.put(0);
        byteBuffer0.put(((byte)(z ? 2 : 0)));
        byteBuffer0.putLong(v);
        byteBuffer0.putInt(0);
        byteBuffer0.putInt(v1);
        byteBuffer0.putInt(0);
        if(((long)v2) >> 8 == 0L) {
            z1 = true;
        }
        a.l("out of range: %s", ((long)v2), z1);
        byteBuffer0.put(((byte)(((int)(((long)v2))))));
    }
}

