package androidx.glance.appwidget.protobuf;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public final class f extends h {
    public final int e;
    public final int f;
    private static final long serialVersionUID = 1L;

    public f(byte[] arr_b, int v, int v1) {
        super(arr_b);
        i.b(v, v + v1, arr_b.length);
        this.e = v;
        this.f = v1;
    }

    @Override  // androidx.glance.appwidget.protobuf.h
    public final byte a(int v) {
        int v1 = this.f;
        if((v1 - (v + 1) | v) < 0) {
            throw v >= 0 ? new ArrayIndexOutOfBoundsException("Index > length: " + v + ", " + v1) : new ArrayIndexOutOfBoundsException("Index < 0: " + v);
        }
        return this.d[this.e + v];
    }

    @Override  // androidx.glance.appwidget.protobuf.h
    public final byte e(int v) {
        return this.d[this.e + v];
    }

    @Override  // androidx.glance.appwidget.protobuf.h
    public final int f() {
        return this.e;
    }

    private void readObject(ObjectInputStream objectInputStream0) {
        throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
    }

    @Override  // androidx.glance.appwidget.protobuf.h
    public final int size() {
        return this.f;
    }

    public Object writeReplace() {
        int v = this.f;
        if(v == 0) {
            return new h(B.b);
        }
        byte[] arr_b = new byte[v];
        System.arraycopy(this.d, this.e, arr_b, 0, v);
        return new h(arr_b);
    }
}

