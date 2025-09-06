package s3;

import b3.m0;
import b3.o0;
import b3.p0;
import java.util.Objects;

public final class s extends o {
    public final Object f;
    public final Object g;
    public static final Object h;

    static {
        s.h = new Object();
    }

    public s(p0 p00, Object object0, Object object1) {
        super(p00);
        this.f = object0;
        this.g = object1;
    }

    @Override  // s3.o
    public final int b(Object object0) {
        if(s.h.equals(object0)) {
            Object object1 = this.g;
            if(object1 != null) {
                object0 = object1;
            }
        }
        return this.e.b(object0);
    }

    @Override  // s3.o
    public final m0 f(int v, m0 m00, boolean z) {
        this.e.f(v, m00, z);
        if(Objects.equals(m00.b, this.g) && z) {
            m00.b = s.h;
        }
        return m00;
    }

    @Override  // s3.o
    public final Object l(int v) {
        Object object0 = this.e.l(v);
        return Objects.equals(object0, this.g) ? s.h : object0;
    }

    @Override  // s3.o
    public final o0 m(int v, o0 o00, long v1) {
        this.e.m(v, o00, v1);
        if(Objects.equals(o00.a, this.f)) {
            o00.a = o0.q;
        }
        return o00;
    }
}

