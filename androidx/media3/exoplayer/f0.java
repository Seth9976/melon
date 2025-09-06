package androidx.media3.exoplayer;

import b3.E;
import b3.b;
import b3.m0;
import b3.o0;
import b3.p0;
import s3.o;

public final class f0 extends o {
    public final int f;
    public final Object g;

    public f0(p0 p00) {
        this.f = 0;
        super(p00);
        this.g = new o0();
    }

    public f0(p0 p00, E e0) {
        this.f = 1;
        super(p00);
        this.g = e0;
    }

    @Override  // s3.o
    public m0 f(int v, m0 m00, boolean z) {
        if(this.f != 0) {
            return super.f(v, m00, z);
        }
        m0 m01 = this.e.f(v, m00, z);
        if(this.e.m(m01.c, ((o0)this.g), 0L).a()) {
            m01.i(m00.a, m00.b, m00.c, m00.d, m00.e, b.f, true);
            return m01;
        }
        m01.f = true;
        return m01;
    }

    @Override  // s3.o
    public o0 m(int v, o0 o00, long v1) {
        if(this.f != 1) {
            return super.m(v, o00, v1);
        }
        super.m(v, o00, v1);
        o00.c = (E)this.g;
        o00.getClass();
        return o00;
    }
}

