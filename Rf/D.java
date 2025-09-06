package rf;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Stack;
import pc.t;

public abstract class d implements Iterable {
    public static final s a;

    static {
        d.a = new s(new byte[0]);
    }

    public static d a(Iterator iterator0, int v) {
        return v == 1 ? iterator0.next() : d.a(iterator0, v >>> 1).b(d.a(iterator0, v - (v >>> 1)));
    }

    public final d b(d d0) {
        int v = this.size();
        int v1 = d0.size();
        if(((long)v) + ((long)v1) >= 0x7FFFFFFFL) {
            throw new IllegalArgumentException("ByteString would be too long: " + v + "+" + v1);
        }
        x x0 = this instanceof x ? ((x)this) : null;
        if(d0.size() == 0) {
            return this;
        }
        if(this.size() == 0) {
            return d0;
        }
        int v2 = d0.size() + this.size();
        if(v2 < 0x80) {
            int v3 = this.size();
            int v4 = d0.size();
            byte[] arr_b = new byte[v3 + v4];
            this.d(0, 0, v3, arr_b);
            d0.d(0, v3, v4, arr_b);
            return new s(arr_b);
        }
        if(x0 != null) {
            d d1 = x0.d;
            if(d0.size() + d1.size() < 0x80) {
                int v5 = d1.size();
                int v6 = d0.size();
                byte[] arr_b1 = new byte[v5 + v6];
                d1.d(0, 0, v5, arr_b1);
                d0.d(0, v5, v6, arr_b1);
                s s0 = new s(arr_b1);
                return new x(x0.c, s0);
            }
        }
        if(x0 != null) {
            d d2 = x0.d;
            d d3 = x0.c;
            if(d3.f() > d2.f()) {
                int v7 = d0.f();
                if(x0.f > v7) {
                    return new x(d3, new x(d2, d0));
                }
            }
        }
        if(v2 >= x.h[Math.max(this.f(), d0.f()) + 1]) {
            return new x(this, d0);
        }
        t t0 = new t(8);
        t0.n(this);
        t0.n(d0);
        Stack stack0 = (Stack)t0.b;
        d d4;
        for(d4 = (d)stack0.pop(); !stack0.isEmpty(); d4 = new x(((d)stack0.pop()), d4)) {
        }
        return d4;
    }

    public final void d(int v, int v1, int v2, byte[] arr_b) {
        if(v < 0) {
            throw new IndexOutOfBoundsException("Source offset < 0: " + v);
        }
        if(v1 < 0) {
            throw new IndexOutOfBoundsException("Target offset < 0: " + v1);
        }
        if(v2 < 0) {
            throw new IndexOutOfBoundsException("Length < 0: " + v2);
        }
        int v3 = v + v2;
        if(v3 > this.size()) {
            throw new IndexOutOfBoundsException("Source end offset < 0: " + v3);
        }
        int v4 = v1 + v2;
        if(v4 > arr_b.length) {
            throw new IndexOutOfBoundsException("Target end offset < 0: " + v4);
        }
        if(v2 > 0) {
            this.e(v, v1, v2, arr_b);
        }
    }

    public abstract void e(int arg1, int arg2, int arg3, byte[] arg4);

    public abstract int f();

    public abstract boolean g();

    public abstract boolean i();

    public static c k() {
        return new c();
    }

    public abstract int l(int arg1, int arg2, int arg3);

    public abstract int o(int arg1, int arg2, int arg3);

    public abstract int p();

    public abstract String q();

    public final String r() {
        try {
            return this.q();
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            throw new RuntimeException("UTF-8 not supported?", unsupportedEncodingException0);
        }
    }

    public abstract void s(int arg1, OutputStream arg2, int arg3);

    public abstract int size();

    @Override
    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), this.size());
    }
}

