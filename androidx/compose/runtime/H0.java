package androidx.compose.runtime;

import X.k;
import androidx.collection.z;
import d3.g;
import ie.r;
import java.util.ArrayList;

public final class h0 {
    public final ArrayList a;
    public final int b;
    public int c;
    public final ArrayList d;
    public final z e;
    public final r f;

    public h0(int v, ArrayList arrayList0) {
        this.a = arrayList0;
        this.b = v;
        if(v < 0) {
            j0.a("Invalid start index");
        }
        this.d = new ArrayList();
        z z0 = new z();
        int v1 = arrayList0.size();
        int v3 = 0;
        for(int v2 = 0; v2 < v1; ++v2) {
            S s0 = (S)this.a.get(v2);
            L l0 = new L(v2, v3, s0.d);
            z0.h(s0.c, l0);
            v3 += s0.d;
        }
        this.e = z0;
        this.f = g.Q(new k(this, 11));
    }

    public final boolean a(int v, int v1) {
        z z0 = this.e;
        L l0 = (L)z0.b(v);
        if(l0 != null) {
            int v2 = l0.b;
            int v3 = v1 - l0.c;
            l0.c = v1;
            if(v3 != 0) {
                Object[] arr_object = z0.c;
                long[] arr_v = z0.a;
                int v4 = arr_v.length - 2;
                if(v4 >= 0) {
                    int v5 = 0;
                    while(true) {
                        long v6 = arr_v[v5];
                        if((~v6 << 7 & v6 & 0x8080808080808080L) != 0x8080808080808080L) {
                            int v7 = 8 - (~(v5 - v4) >>> 0x1F);
                            for(int v8 = 0; v8 < v7; ++v8) {
                                if((0xFFL & v6) < 0x80L) {
                                    L l1 = (L)arr_object[(v5 << 3) + v8];
                                    if(l1.b >= v2 && !l1.equals(l0)) {
                                        int v9 = l1.b + v3;
                                        if(v9 >= 0) {
                                            l1.b = v9;
                                        }
                                    }
                                }
                                v6 >>= 8;
                            }
                            if(v7 == 8) {
                                goto label_27;
                            }
                            break;
                        }
                    label_27:
                        if(v5 == v4) {
                            break;
                        }
                        ++v5;
                    }
                }
            }
            return true;
        }
        return false;
    }
}

