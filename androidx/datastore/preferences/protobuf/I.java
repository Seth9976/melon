package androidx.datastore.preferences.protobuf;

import U4.x;

public class i extends h {
    public final byte[] d;
    private static final long serialVersionUID = 1L;

    public i(byte[] arr_b) {
        this.a = 0;
        arr_b.getClass();
        this.d = arr_b;
    }

    @Override  // androidx.datastore.preferences.protobuf.j
    public byte a(int v) {
        return this.d[v];
    }

    @Override  // androidx.datastore.preferences.protobuf.j
    public void e(int v, byte[] arr_b) {
        System.arraycopy(this.d, 0, arr_b, 0, v);
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != this) {
            if(!(object0 instanceof j) || this.size() != ((j)object0).size()) {
                return false;
            }
            if(this.size() != 0) {
                if(!(object0 instanceof i)) {
                    return object0.equals(this);
                }
                int v = this.a;
                int v1 = ((i)object0).a;
                if(v == 0 || v1 == 0 || v == v1) {
                    int v2 = this.size();
                    if(v2 > ((i)object0).size()) {
                        throw new IllegalArgumentException("Length too large: " + v2 + this.size());
                    }
                    if(v2 <= ((i)object0).size()) {
                        byte[] arr_b = ((i)object0).d;
                        int v3 = this.g();
                        int v4 = this.g();
                        for(int v5 = ((i)object0).g(); v4 < v3 + v2; ++v5) {
                            if(this.d[v4] != arr_b[v5]) {
                                return false;
                            }
                            ++v4;
                        }
                        return true;
                    }
                    StringBuilder stringBuilder0 = x.n(v2, "Ran off end of other: 0, ", ", ");
                    stringBuilder0.append(((i)object0).size());
                    throw new IllegalArgumentException(stringBuilder0.toString());
                }
                return false;
            }
        }
        return true;
    }

    @Override  // androidx.datastore.preferences.protobuf.j
    public byte f(int v) {
        return this.d[v];
    }

    public int g() {
        return 0;
    }

    @Override  // androidx.datastore.preferences.protobuf.j
    public int size() {
        return this.d.length;
    }
}

