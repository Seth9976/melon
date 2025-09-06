package com.google.protobuf;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public final class l extends n {
    public final int e;
    public final int f;
    private static final long serialVersionUID = 1L;

    public l(byte[] arr_b, int v, int v1) {
        super(arr_b);
        o.b(v, v + v1, arr_b.length);
        this.e = v;
        this.f = v1;
    }

    @Override  // com.google.protobuf.n
    public final byte a(int v) {
        int v1 = this.f;
        if((v1 - (v + 1) | v) < 0) {
            throw v >= 0 ? new ArrayIndexOutOfBoundsException("Index > length: " + v + ", " + v1) : new ArrayIndexOutOfBoundsException("Index < 0: " + v);
        }
        return this.d[this.e + v];
    }

    @Override  // com.google.protobuf.n
    public final byte f(int v) {
        return this.d[this.e + v];
    }

    @Override  // com.google.protobuf.n
    public final int r() {
        return this.e;
    }

    private void readObject(ObjectInputStream objectInputStream0) {
        throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
    }

    @Override  // com.google.protobuf.n
    public final int size() {
        return this.f;
    }

    public Object writeReplace() {
        int v = this.size();
        if(v == 0) {
            return new n(P1.b);
        }
        byte[] arr_b = new byte[v];
        System.arraycopy(this.d, this.e, arr_b, 0, v);
        return new n(arr_b);
    }
}

