package mg;

import e3.o;
import java.io.ByteArrayOutputStream;
import java.net.InetAddress;
import jg.h;
import kotlin.jvm.internal.q;

public final class f implements h {
    public final o a;
    public final e b;

    public f(o o0, e e0) {
        this.a = o0;
        this.b = e0;
    }

    @Override  // jg.h
    public final void a() {
    }

    @Override  // jg.h
    public final String b() {
        return this.b.c;
    }

    @Override  // jg.h
    public final long c() {
        return this.b.a;
    }

    @Override  // jg.h
    public final void d(ByteArrayOutputStream byteArrayOutputStream0) {
        this.b.d(byteArrayOutputStream0);
    }

    @Override  // jg.h
    public final String e() {
        return this.b.b;
    }

    @Override  // jg.h
    public final int f() {
        return this.b.f();
    }

    @Override  // jg.h
    public final String g() {
        return this.b.d;
    }

    @Override  // jg.h
    public final String getHeader() {
        return this.b.getHeader();
    }

    @Override  // jg.h
    public final InetAddress getLocalAddress() {
        return this.b.f;
    }

    public final void h(String s, String s1) {
        q.g(s1, "value");
        this.b.e.setHeader(s, s1);
    }

    @Override
    public final String toString() {
        return this.b.e.toString();
    }
}

