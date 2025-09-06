package h3;

import H4.b;
import b3.F;
import java.nio.ByteBuffer;

public class e extends b {
    public androidx.media3.common.b c;
    public final h3.b d;
    public ByteBuffer e;
    public boolean f;
    public long g;
    public ByteBuffer h;
    public final int i;

    static {
        F.a("media3.decoder");
    }

    public e(int v) {
        super(2);
        this.d = new h3.b(0);
        this.i = v;
    }

    public void o() {
        this.b = 0;
        ByteBuffer byteBuffer0 = this.e;
        if(byteBuffer0 != null) {
            byteBuffer0.clear();
        }
        ByteBuffer byteBuffer1 = this.h;
        if(byteBuffer1 != null) {
            byteBuffer1.clear();
        }
        this.f = false;
    }

    public final ByteBuffer p(int v) {
        int v1 = this.i;
        if(v1 == 1) {
            return ByteBuffer.allocate(v);
        }
        if(v1 != 2) {
            throw new d("Buffer too small (" + (this.e == null ? 0 : this.e.capacity()) + " < " + v + ")");  // 初始化器: Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
        }
        return ByteBuffer.allocateDirect(v);
    }

    public final void q(int v) {
        ByteBuffer byteBuffer0 = this.e;
        if(byteBuffer0 == null) {
            this.e = this.p(v);
            return;
        }
        int v1 = byteBuffer0.position();
        int v2 = v + v1;
        if(byteBuffer0.capacity() >= v2) {
            this.e = byteBuffer0;
            return;
        }
        ByteBuffer byteBuffer1 = this.p(v2);
        byteBuffer1.order(byteBuffer0.order());
        if(v1 > 0) {
            byteBuffer0.flip();
            byteBuffer1.put(byteBuffer0);
        }
        this.e = byteBuffer1;
    }

    public final void r() {
        ByteBuffer byteBuffer0 = this.e;
        if(byteBuffer0 != null) {
            byteBuffer0.flip();
        }
        ByteBuffer byteBuffer1 = this.h;
        if(byteBuffer1 != null) {
            byteBuffer1.flip();
        }
    }
}

