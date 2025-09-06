package j3;

import c3.b;
import c3.c;
import c3.e;
import java.nio.ByteBuffer;

public final class m extends e {
    public int[] i;
    public int[] j;

    @Override  // c3.e
    public final b b(b b0) {
        int[] arr_v = this.i;
        if(arr_v == null) {
            return b.e;
        }
        int v = b0.b;
        if(b0.c != 2) {
            throw new c(b0);
        }
        int v1 = v == arr_v.length ? 0 : 1;
        for(int v2 = 0; v2 < arr_v.length; ++v2) {
            int v3 = arr_v[v2];
            if(v3 >= v) {
                throw new c(b0);
            }
            v1 |= (v3 == v2 ? 0 : 1);
        }
        return v1 == 0 ? b.e : new b(b0.a, arr_v.length, 2);
    }

    @Override  // c3.e
    public final void c() {
        this.j = this.i;
    }

    @Override  // c3.e
    public final void e() {
        this.j = null;
        this.i = null;
    }

    @Override  // c3.d
    public final void queueInput(ByteBuffer byteBuffer0) {
        int[] arr_v = this.j;
        arr_v.getClass();
        int v = byteBuffer0.position();
        int v1 = byteBuffer0.limit();
        ByteBuffer byteBuffer1 = this.f((v1 - v) / this.b.d * this.c.d);
        while(v < v1) {
            for(int v2 = 0; v2 < arr_v.length; ++v2) {
                byteBuffer1.putShort(byteBuffer0.getShort(arr_v[v2] * 2 + v));
            }
            v += this.b.d;
        }
        byteBuffer0.position(v1);
        byteBuffer1.flip();
    }
}

