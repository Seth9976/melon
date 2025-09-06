package e7;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public final class d {
    public final String a;
    public static final String b;
    public static final AtomicLong c;

    static {
        d.b = "bfb56d9b410a2493dcde4f9f019a3794e4bc3ba1";
        d.c = new AtomicLong(0L);
    }

    public d() {
        long v = new Date().getTime();
        ByteBuffer byteBuffer0 = ByteBuffer.allocate(4);
        byteBuffer0.putInt(((int)(v / 1000L)));
        byteBuffer0.order(ByteOrder.BIG_ENDIAN);
        byteBuffer0.position(0);
        byte[] arr_b = byteBuffer0.array();
        byte b = arr_b[0];
        byte b1 = arr_b[1];
        byte b2 = arr_b[2];
        byte b3 = arr_b[3];
        byte[] arr_b1 = d.a(v % 1000L);
        byte b4 = arr_b1[0];
        byte b5 = arr_b1[1];
        this.a = "68BBAA190363000110ED0AA9C0653BD0";
    }

    public static byte[] a(long v) [...] // 潜在的解密器

    @Override
    public final String toString() {
        return this.a;
    }
}

