package androidx.datastore.preferences.protobuf;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public final class g extends i {
    public final int e;
    public final int f;
    private static final long serialVersionUID = 1L;

    public g(byte[] arr_b, int v, int v1) {
        super(arr_b);
        j.b(v, v + v1, arr_b.length);
        this.e = v;
        this.f = v1;
    }

    @Override  // androidx.datastore.preferences.protobuf.i
    public final byte a(int v) {
        int v1 = this.f;
        if((v1 - (v + 1) | v) < 0) {
            throw v >= 0 ? new ArrayIndexOutOfBoundsException("Index > length: " + v + ", " + v1) : new ArrayIndexOutOfBoundsException("Index < 0: " + v);
        }
        return this.d[this.e + v];
    }

    @Override  // androidx.datastore.preferences.protobuf.i
    public final void e(int v, byte[] arr_b) {
        System.arraycopy(this.d, this.e, arr_b, 0, v);
    }

    @Override  // androidx.datastore.preferences.protobuf.i
    public final byte f(int v) {
        return this.d[this.e + v];
    }

    @Override  // androidx.datastore.preferences.protobuf.i
    public final int g() {
        return this.e;
    }

    private void readObject(ObjectInputStream objectInputStream0) {
        throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
    }

    @Override  // androidx.datastore.preferences.protobuf.i
    public final int size() {
        return this.f;
    }

    public Object writeReplace() {
        int v = this.size();
        if(v == 0) {
            return new i(D.b);
        }
        byte[] arr_b = new byte[v];
        this.e(v, arr_b);
        return new i(arr_b);
    }
}

