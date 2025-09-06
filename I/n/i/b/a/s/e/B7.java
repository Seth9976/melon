package i.n.i.b.a.s.e;

import java.nio.ByteBuffer;

public final class b7 extends I8 {
    public long i;
    public int j;
    public int k;

    @Override  // i.n.i.b.a.s.e.I8
    public final void o() {
        super.o();
        this.j = 0;
    }

    public final boolean s(I8 i80) {
        M7.u(!i80.f(0x40000000));
        M7.u(!i80.f(0x10000000));
        M7.u(!i80.f(4));
        if(this.j > 0 && (this.j >= this.k || i80.f(0x80000000) != this.f(0x80000000) || i80.d != null && (this.d != null && i80.d.remaining() + this.d.position() > 3072000))) {
            return false;
        }
        int v = this.j;
        this.j = v + 1;
        if(v == 0) {
            this.f = i80.f;
            if(i80.f(1)) {
                this.b = 1;
            }
        }
        if(i80.f(0x80000000)) {
            this.b = 0x80000000;
        }
        ByteBuffer byteBuffer0 = i80.d;
        if(byteBuffer0 != null) {
            this.r(byteBuffer0.remaining());
            this.d.put(byteBuffer0);
        }
        this.i = i80.f;
        return true;
    }
}

