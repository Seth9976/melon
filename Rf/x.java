package rf;

import com.iloen.melon.utils.a;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public final class x extends d {
    public final int b;
    public final d c;
    public final d d;
    public final int e;
    public final int f;
    public int g;
    public static final int[] h;

    static {
        ArrayList arrayList0 = new ArrayList();
        int v = 1;
        for(int v1 = 1; v1 > 0; v1 = v2) {
            int v2 = a.d(v1, v, v1, arrayList0);
            v = v1;
        }
        arrayList0.add(0x7FFFFFFF);
        x.h = new int[arrayList0.size()];
        for(int v3 = 0; true; ++v3) {
            int[] arr_v = x.h;
            if(v3 >= arr_v.length) {
                break;
            }
            arr_v[v3] = (int)(((Integer)arrayList0.get(v3)));
        }
    }

    public x(d d0, d d1) {
        this.g = 0;
        this.c = d0;
        this.d = d1;
        int v = d0.size();
        this.e = v;
        this.b = d1.size() + v;
        this.f = Math.max(d0.f(), d1.f()) + 1;
    }

    @Override  // rf.d
    public final void e(int v, int v1, int v2, byte[] arr_b) {
        d d0 = this.c;
        int v3 = this.e;
        if(v + v2 <= v3) {
            d0.e(v, v1, v2, arr_b);
            return;
        }
        d d1 = this.d;
        if(v >= v3) {
            d1.e(v - v3, v1, v2, arr_b);
            return;
        }
        int v4 = v3 - v;
        d0.e(v, v1, v4, arr_b);
        d1.e(0, v1 + v4, v2 - v4, arr_b);
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != this) {
            if(!(object0 instanceof d)) {
                return false;
            }
            int v = this.b;
            if(v != ((d)object0).size()) {
                return false;
            }
            if(v != 0) {
                if(this.g == 0) {
                label_8:
                    v v2 = new v(this);
                    s s0 = v2.a();
                    v v3 = new v(((d)object0));
                    s s1 = v3.a();
                    int v4 = 0;
                    int v5 = 0;
                    int v6 = 0;
                    while(true) {
                        int v7 = s0.b.length - v4;
                        int v8 = s1.b.length - v5;
                        int v9 = Math.min(v7, v8);
                        if(!(v4 == 0 ? s0.t(s1, v5, v9) : s1.t(s0, v4, v9))) {
                            break;
                        }
                        v6 += v9;
                        if(v6 >= v) {
                            if(v6 != v) {
                                throw new IllegalStateException();
                            }
                            return true;
                        }
                        if(v9 == v7) {
                            s0 = v2.a();
                            v4 = 0;
                        }
                        else {
                            v4 += v9;
                        }
                        if(v9 == v8) {
                            s1 = v3.a();
                            v5 = 0;
                        }
                        else {
                            v5 += v9;
                        }
                    }
                }
                else {
                    int v1 = ((d)object0).p();
                    if(v1 == 0 || this.g == v1) {
                        goto label_8;
                    }
                }
                return false;
            }
        }
        return true;
    }

    @Override  // rf.d
    public final int f() {
        return this.f;
    }

    @Override  // rf.d
    public final boolean g() {
        return this.b >= x.h[this.f];
    }

    @Override
    public final int hashCode() {
        int v = this.g;
        if(v == 0) {
            v = this.l(this.b, 0, this.b);
            if(v == 0) {
                v = 1;
            }
            this.g = v;
        }
        return v;
    }

    @Override  // rf.d
    public final boolean i() {
        int v = this.c.o(0, 0, this.e);
        return this.d.o(v, 0, this.d.size()) == 0;
    }

    @Override
    public final Iterator iterator() {
        return new w(this);
    }

    @Override  // rf.d
    public final int l(int v, int v1, int v2) {
        d d0 = this.c;
        int v3 = this.e;
        if(v1 + v2 <= v3) {
            return d0.l(v, v1, v2);
        }
        return v1 < v3 ? this.d.l(d0.l(v, v1, v3 - v1), 0, v2 - (v3 - v1)) : this.d.l(v, v1 - v3, v2);
    }

    @Override  // rf.d
    public final int o(int v, int v1, int v2) {
        d d0 = this.c;
        int v3 = this.e;
        if(v1 + v2 <= v3) {
            return d0.o(v, v1, v2);
        }
        return v1 < v3 ? this.d.o(d0.o(v, v1, v3 - v1), 0, v2 - (v3 - v1)) : this.d.o(v, v1 - v3, v2);
    }

    @Override  // rf.d
    public final int p() {
        return this.g;
    }

    @Override  // rf.d
    public final String q() {
        int v = this.b;
        if(v == 0) {
            return "";
        }
        byte[] arr_b = new byte[v];
        this.e(0, 0, v, arr_b);
        return new String(arr_b, "UTF-8");
    }

    @Override  // rf.d
    public final void s(int v, OutputStream outputStream0, int v1) {
        d d0 = this.c;
        int v2 = this.e;
        if(v + v1 <= v2) {
            d0.s(v, outputStream0, v1);
            return;
        }
        d d1 = this.d;
        if(v >= v2) {
            d1.s(v - v2, outputStream0, v1);
            return;
        }
        int v3 = v2 - v;
        d0.s(v, outputStream0, v3);
        d1.s(0, outputStream0, v1 - v3);
    }

    @Override  // rf.d
    public final int size() {
        return this.b;
    }
}

