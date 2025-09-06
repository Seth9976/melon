package com.google.protobuf;

import U4.x;
import java.nio.charset.Charset;

public class n extends m {
    public final byte[] d;
    private static final long serialVersionUID = 1L;

    public n(byte[] arr_b) {
        this.a = 0;
        arr_b.getClass();
        this.d = arr_b;
    }

    @Override  // com.google.protobuf.o
    public byte a(int v) {
        return this.d[v];
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != this) {
            if(!(object0 instanceof o) || this.size() != ((o)object0).size()) {
                return false;
            }
            if(this.size() != 0) {
                if(!(object0 instanceof n)) {
                    return object0.equals(this);
                }
                int v = this.a;
                int v1 = ((n)object0).a;
                if(v == 0 || v1 == 0 || v == v1) {
                    int v2 = this.size();
                    if(v2 > ((n)object0).size()) {
                        throw new IllegalArgumentException("Length too large: " + v2 + this.size());
                    }
                    if(v2 <= ((n)object0).size()) {
                        byte[] arr_b = ((n)object0).d;
                        int v3 = this.r();
                        int v4 = this.r();
                        for(int v5 = ((n)object0).r(); v4 < v3 + v2; ++v5) {
                            if(this.d[v4] != arr_b[v5]) {
                                return false;
                            }
                            ++v4;
                        }
                        return true;
                    }
                    StringBuilder stringBuilder0 = x.n(v2, "Ran off end of other: 0, ", ", ");
                    stringBuilder0.append(((n)object0).size());
                    throw new IllegalArgumentException(stringBuilder0.toString());
                }
                return false;
            }
        }
        return true;
    }

    @Override  // com.google.protobuf.o
    public byte f(int v) {
        return this.d[v];
    }

    @Override  // com.google.protobuf.o
    public final boolean g() {
        int v = this.r();
        return b3.a.F(this.d, v, this.size() + v) == 0;
    }

    @Override  // com.google.protobuf.o
    public final t i() {
        return t.h(this.d, this.r(), this.size(), true);
    }

    @Override  // com.google.protobuf.o
    public final int k(int v, int v1) {
        int v2 = this.r();
        for(int v3 = v2; v3 < v2 + v1; ++v3) {
            v = v * 0x1F + this.d[v3];
        }
        return v;
    }

    @Override  // com.google.protobuf.o
    public final o l(int v) {
        int v1 = o.b(0, v, this.size());
        return v1 == 0 ? o.b : new l(this.d, this.r(), v1);
    }

    @Override  // com.google.protobuf.o
    public final String o(Charset charset0) {
        return new String(this.d, this.r(), this.size(), charset0);
    }

    @Override  // com.google.protobuf.o
    public final void q(com.google.protobuf.x x0) {
        x0.I(this.d, this.r(), this.size());
    }

    public int r() {
        return 0;
    }

    @Override  // com.google.protobuf.o
    public int size() {
        return this.d.length;
    }
}

