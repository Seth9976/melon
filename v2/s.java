package v2;

import java.nio.ByteBuffer;
import o9.b;
import w2.a;

public final class s {
    public final int a;
    public final b b;
    public volatile int c;
    public static final ThreadLocal d;

    static {
        s.d = new ThreadLocal();
    }

    public s(b b0, int v) {
        this.c = 0;
        this.b = b0;
        this.a = v;
    }

    public final int a(int v) {
        a a0 = this.b();
        int v1 = a0.a(16);
        if(v1 != 0) {
            ByteBuffer byteBuffer0 = (ByteBuffer)a0.d;
            int v2 = v1 + a0.a;
            return byteBuffer0.getInt(v * 4 + (byteBuffer0.getInt(v2) + v2 + 4));
        }
        return 0;
    }

    public final a b() {
        ThreadLocal threadLocal0 = s.d;
        a a0 = (a)threadLocal0.get();
        if(a0 == null) {
            a0 = new a();  // 初始化器: Lc2/J;-><init>()V
            threadLocal0.set(a0);
        }
        w2.b b0 = (w2.b)this.b.a;
        int v = b0.a(6);
        if(v != 0) {
            int v1 = v + b0.a;
            int v2 = ((ByteBuffer)b0.d).getInt(v1);
            int v3 = this.a * 4 + (v2 + v1 + 4);
            int v4 = ((ByteBuffer)b0.d).getInt(v3) + v3;
            ByteBuffer byteBuffer0 = (ByteBuffer)b0.d;
            a0.d = byteBuffer0;
            if(byteBuffer0 != null) {
                a0.a = v4;
                int v5 = v4 - byteBuffer0.getInt(v4);
                a0.b = v5;
                a0.c = ((ByteBuffer)a0.d).getShort(v5);
                return a0;
            }
            a0.a = 0;
            a0.b = 0;
            a0.c = 0;
        }
        return a0;
    }

    @Override
    public final String toString() {
        int v5;
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(super.toString());
        stringBuilder0.append(", id:");
        a a0 = this.b();
        int v = a0.a(4);
        stringBuilder0.append(Integer.toHexString((v == 0 ? 0 : ((ByteBuffer)a0.d).getInt(v + a0.a))));
        stringBuilder0.append(", codepoints:");
        a a1 = this.b();
        int v2 = a1.a(16);
        if(v2 == 0) {
            v5 = 0;
        }
        else {
            int v3 = v2 + a1.a;
            int v4 = ((ByteBuffer)a1.d).getInt(v3);
            v5 = ((ByteBuffer)a1.d).getInt(v4 + v3);
        }
        for(int v1 = 0; v1 < v5; ++v1) {
            stringBuilder0.append(Integer.toHexString(this.a(v1)));
            stringBuilder0.append(" ");
        }
        return stringBuilder0.toString();
    }
}

