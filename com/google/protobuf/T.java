package com.google.protobuf;

import Vd.w;
import java.io.InputStream;

public abstract class t {
    public int a;
    public int b;
    public w c;

    public abstract int A();

    public abstract long B();

    public abstract String C();

    public abstract String D();

    public abstract int E();

    public abstract int F();

    public abstract long G();

    public abstract boolean H(int arg1);

    public final void I() {
        do {
            int v = this.E();
            if(v == 0) {
                break;
            }
            this.b();
            ++this.b;
            boolean z = this.H(v);
            --this.b;
        }
        while(z);
    }

    public abstract void a(int arg1);

    public final void b() {
        if(this.a + this.b >= 100) {
            throw new R1("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
    }

    public static int c(int v) [...] // Inlined contents

    public static long d(long v) [...] // Inlined contents

    public abstract int e();

    public abstract int f();

    public abstract boolean g();

    public static q h(byte[] arr_b, int v, int v1, boolean z) {
        q q0 = new q(arr_b, v, v1, z);
        try {
            q0.k(v1);
            return q0;
        }
        catch(R1 r10) {
            throw new IllegalArgumentException(r10);
        }
    }

    public static t i(InputStream inputStream0) {
        return inputStream0 == null ? t.h(P1.b, 0, P1.b.length, false) : new r(inputStream0);
    }

    public abstract void j(int arg1);

    public abstract int k(int arg1);

    public abstract boolean l();

    public abstract n m();

    public abstract double n();

    public abstract int o();

    public abstract int p();

    public abstract long q();

    public abstract float r();

    public abstract void s(int arg1, k2 arg2, g1 arg3);

    public abstract int t();

    public abstract long u();

    public abstract void v(k2 arg1, g1 arg2);

    public abstract int w();

    public static int x(InputStream inputStream0, int v) {
        if((v & 0x80) == 0) {
            return v;
        }
        int v1 = v & 0x7F;
        int v2;
        for(v2 = 7; v2 < 0x20; v2 += 7) {
            int v3 = inputStream0.read();
            if(v3 == -1) {
                throw R1.h();
            }
            v1 |= (v3 & 0x7F) << v2;
            if((v3 & 0x80) == 0) {
                return v1;
            }
        }
        while(v2 < 0x40) {
            int v4 = inputStream0.read();
            if(v4 == -1) {
                throw R1.h();
            }
            if((v4 & 0x80) == 0) {
                return v1;
            }
            v2 += 7;
        }
        throw R1.e();
    }

    public abstract int y();

    public abstract long z();
}

