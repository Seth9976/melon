package mg;

import java.io.ByteArrayOutputStream;
import java.net.InetAddress;
import jg.h;

public final class g implements h {
    public final e a;

    public g(d5.e e0, e e1) {
        this.a = e1;
    }

    @Override  // jg.h
    public final void a() {
    }

    @Override  // jg.h
    public final String b() {
        return this.a.c;
    }

    @Override  // jg.h
    public final long c() {
        return this.a.a;
    }

    @Override  // jg.h
    public final void d(ByteArrayOutputStream byteArrayOutputStream0) {
        this.a.d(byteArrayOutputStream0);
    }

    @Override  // jg.h
    public final String e() {
        return this.a.b;
    }

    @Override  // jg.h
    public final int f() {
        return this.a.f();
    }

    @Override  // jg.h
    public final String g() {
        return this.a.d;
    }

    @Override  // jg.h
    public final String getHeader() {
        return this.a.getHeader();
    }

    @Override  // jg.h
    public final InetAddress getLocalAddress() {
        return this.a.f;
    }

    @Override
    public final String toString() {
        return this.a.e.toString();
    }
}

