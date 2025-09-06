package com.google.protobuf;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

public abstract class o implements Serializable, Iterable {
    public int a;
    public static final n b = null;
    public static final k c = null;
    private static final long serialVersionUID = 1L;

    static {
        o.b = new n(P1.b);
        o.c = new k(0);
    }

    public abstract byte a(int arg1);

    public static int b(int v, int v1, int v2) {
        int v3 = v1 - v;
        if((v | v1 | v3 | v2 - v1) < 0) {
            if(v < 0) {
                throw new IndexOutOfBoundsException("Beginning index: " + v + " < 0");
            }
            throw v1 >= v ? new IndexOutOfBoundsException("End index: " + v1 + " >= " + v2) : new IndexOutOfBoundsException("Beginning index larger than ending index: " + v + ", " + v1);
        }
        return v3;
    }

    public static n d(byte[] arr_b, int v, int v1) {
        o.b(v, v + v1, arr_b.length);
        if(o.c.a != 0) {
            byte[] arr_b1 = new byte[v1];
            System.arraycopy(arr_b, v, arr_b1, 0, v1);
            return new n(arr_b1);
        }
        return new n(Arrays.copyOfRange(arr_b, v, v1 + v));
    }

    public static n e(String s) {
        return new n(s.getBytes(P1.a));
    }

    public abstract byte f(int arg1);

    public abstract boolean g();

    @Override
    public final int hashCode() {
        int v = this.a;
        if(v == 0) {
            int v1 = this.size();
            v = this.k(v1, v1);
            if(v == 0) {
                v = 1;
            }
            this.a = v;
        }
        return v;
    }

    public abstract t i();

    public abstract int k(int arg1, int arg2);

    public abstract o l(int arg1);

    public abstract String o(Charset arg1);

    public final String p() {
        return this.size() == 0 ? "" : this.o(P1.a);
    }

    public abstract void q(x arg1);

    public abstract int size();

    @Override
    public final String toString() {
        String s1;
        String s = Integer.toHexString(System.identityHashCode(this));
        int v = this.size();
        if(this.size() <= 50) {
            s1 = h.B(this);
            return U4.x.m(androidx.appcompat.app.o.u(v, "<ByteString@", s, " size=", " contents=\""), s1, "\">");
        }
        s1 = h.B(this.l(0x2F)) + "...";
        return U4.x.m(androidx.appcompat.app.o.u(v, "<ByteString@", s, " size=", " contents=\""), s1, "\">");
    }
}

