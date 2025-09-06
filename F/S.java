package F;

import Cb.i;
import L.a;
import N0.Z;
import N0.a0;
import Q.j;
import gd.e2;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import we.k;

public final class s extends r implements k {
    public final int f;
    public final ArrayList g;

    public s(int v, ArrayList arrayList0) {
        this.f = v;
        this.g = arrayList0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.f) {
            case 0: {
                ArrayList arrayList0 = this.g;
                int v = arrayList0.size();
                for(int v1 = 0; v1 < v; ++v1) {
                    Z.e(((Z)object0), ((a0)arrayList0.get(v1)), 0, 0);
                }
                return H.a;
            }
            case 1: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 2: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 3: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 4: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 5: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 6: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 7: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 8: {
                ArrayList arrayList1 = this.g;
                int v2 = arrayList1.size();
                for(int v3 = 0; v3 < v2; ++v3) {
                    Z.h(((Z)object0), ((a0)arrayList1.get(v3)), 0, 0);
                }
                return H.a;
            }
            case 9: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 10: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 11: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 12: {
                ArrayList arrayList2 = this.g;
                int v4 = arrayList2.size();
                for(int v5 = 0; v5 < v4; ++v5) {
                    j j0 = (j)arrayList2.get(v5);
                    List list0 = j0.b;
                    boolean z = j0.i;
                    if(j0.m == 0x80000000) {
                        a.a("position() should be called first");
                    }
                    int v6 = list0.size();
                    for(int v7 = 0; v7 < v6; ++v7) {
                        a0 a00 = (a0)list0.get(v7);
                        long v8 = ((long)j0.k[v7 * 2 + 1]) & 0xFFFFFFFFL | ((long)j0.k[v7 * 2]) << 0x20;
                        if(j0.h) {
                            v8 = ((long)(z ? j0.m - ((int)(v8 & 0xFFFFFFFFL)) - a00.b : ((int)(v8 & 0xFFFFFFFFL)))) & 0xFFFFFFFFL | ((long)(z ? ((int)(v8 >> 0x20)) : j0.m - ((int)(v8 >> 0x20)) - a00.a)) << 0x20;
                        }
                        long v9 = r1.j.c(v8, j0.c);
                        if(z) {
                            Z.l(((Z)object0), a00, v9);
                        }
                        else {
                            Z.i(((Z)object0), a00, v9);
                        }
                    }
                }
                return H.a;
            }
            case 13: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 14: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 15: {
                ArrayList arrayList3 = this.g;
                int v10 = arrayList3.size();
                for(int v11 = 0; v11 < v10; ++v11) {
                    Z.g(((Z)object0), ((a0)arrayList3.get(v11)), 0, 0);
                }
                return H.a;
            }
            case 16: {
                ArrayList arrayList4 = this.g;
                int v12 = arrayList4.size();
                for(int v13 = 0; v13 < v12; ++v13) {
                    Z.e(((Z)object0), ((a0)arrayList4.get(v13)), 0, 0);
                }
                return H.a;
            }
            case 17: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 18: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 19: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 20: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 21: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 22: {
                return i.o(((e2)this.g.get(((Number)object0).intValue())));
            }
            case 23: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 24: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 25: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 26: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            case 27: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
            default: {
                this.g.get(((Number)object0).intValue());
                return null;
            }
        }
    }
}

