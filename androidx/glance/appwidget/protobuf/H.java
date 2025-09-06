package androidx.glance.appwidget.protobuf;

import U4.x;

public class h extends g {
    public final byte[] d;
    private static final long serialVersionUID = 1L;

    public h(byte[] arr_b) {
        this.a = 0;
        arr_b.getClass();
        this.d = arr_b;
    }

    @Override  // androidx.glance.appwidget.protobuf.i
    public byte a(int v) {
        return this.d[v];
    }

    @Override  // androidx.glance.appwidget.protobuf.i
    public byte e(int v) {
        return this.d[v];
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != this) {
            if(!(object0 instanceof i) || this.size() != ((i)object0).size()) {
                return false;
            }
            if(this.size() != 0) {
                if(!(object0 instanceof h)) {
                    return object0.equals(this);
                }
                int v = this.a;
                int v1 = ((h)object0).a;
                if(v == 0 || v1 == 0 || v == v1) {
                    int v2 = this.size();
                    if(v2 > ((h)object0).size()) {
                        throw new IllegalArgumentException("Length too large: " + v2 + this.size());
                    }
                    if(v2 <= ((h)object0).size()) {
                        byte[] arr_b = ((h)object0).d;
                        int v3 = this.f();
                        int v4 = this.f();
                        for(int v5 = ((h)object0).f(); v4 < v3 + v2; ++v5) {
                            if(this.d[v4] != arr_b[v5]) {
                                return false;
                            }
                            ++v4;
                        }
                        return true;
                    }
                    StringBuilder stringBuilder0 = x.n(v2, "Ran off end of other: 0, ", ", ");
                    stringBuilder0.append(((h)object0).size());
                    throw new IllegalArgumentException(stringBuilder0.toString());
                }
                return false;
            }
        }
        return true;
    }

    public int f() {
        return 0;
    }

    @Override  // androidx.glance.appwidget.protobuf.i
    public int size() {
        return this.d.length;
    }
}

