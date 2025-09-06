package androidx.compose.foundation.lazy.layout;

import B7.b;
import androidx.appcompat.app.o;
import androidx.collection.K;
import androidx.collection.L;
import java.util.ArrayList;
import java.util.Collections;
import je.n;
import je.p;
import je.t;
import r0.q;

public final class s {
    public final K a;
    public b b;
    public final L c;
    public final ArrayList d;
    public final ArrayList e;
    public final ArrayList f;
    public final ArrayList g;
    public final ArrayList h;
    public final q i;

    public s() {
        this.a = new K();
        this.c = new L();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new LazyLayoutItemAnimator.DisplayingDisappearingItemsElement(this);
    }

    public final void a(int v, Object object0) {
        o.z(this.a.g(object0));
    }

    public final long b() {
        ArrayList arrayList0 = this.h;
        if(arrayList0.size() <= 0) {
            return 0L;
        }
        o.z(arrayList0.get(0));
        throw null;
    }

    public final void c(int v, int v1, ArrayList arrayList0, b b0, B b1, boolean z, int v2, boolean z1, int v3, int v4) {
        ArrayList arrayList3;
        int v17;
        int v16;
        b b2 = this.b;
        this.b = b0;
        int v5 = arrayList0.size();
        for(int v6 = 0; v6 < v5; ++v6) {
            A a0 = (A)arrayList0.get(v6);
            int v7 = a0.a();
            for(int v8 = 0; v8 < v7; ++v8) {
                a0.e(v8);
            }
        }
        K k0 = this.a;
        if(k0.i()) {
            this.d();
            return;
        }
        A a1 = (A)p.m0(arrayList0);
        Object[] arr_object = k0.b;
        long[] arr_v = k0.a;
        int v9 = arr_v.length - 2;
        L l0 = this.c;
        if(v9 >= 0) {
            int v10 = 0;
            while(true) {
                long v11 = arr_v[v10];
                int v12 = v10;
                if((~v11 << 7 & v11 & 0x8080808080808080L) == 0x8080808080808080L) {
                    goto label_41;
                }
                int v13 = 8 - (~(v12 - v9) >>> 0x1F);
                long v14 = v11;
                for(int v15 = 0; v15 < v13; ++v15) {
                    if((v14 & 0xFFL) < 0x80L) {
                        l0.a(arr_object[(v12 << 3) + v15]);
                    }
                    v14 >>= 8;
                }
                if(v13 == 8) {
                label_41:
                    if(v12 != v9) {
                        v10 = v12 + 1;
                        continue;
                    }
                    break;
                }
                else {
                    v16 = arrayList0.size();
                    v17 = 0;
                }
                goto label_49;
            }
        }
        v16 = arrayList0.size();
        v17 = 0;
    label_49:
        while(v17 < v16) {
            A a2 = (A)arrayList0.get(v17);
            l0.l(a2.getKey());
            int v18 = a2.a();
            for(int v19 = 0; v19 < v18; ++v19) {
                a2.e(v19);
            }
            Object object0 = a2.getKey();
            o.z(this.a.j(object0));
            ++v17;
        }
        int[] arr_v1 = new int[v2];
        ArrayList arrayList1 = this.e;
        ArrayList arrayList2 = this.d;
        if((z || !z1) && b2 != null) {
            if(!arrayList2.isEmpty()) {
                if(arrayList2.size() > 1) {
                    t.S(arrayList2, new r(b2, 2));
                }
                if(arrayList2.size() <= 0) {
                    n.d0(0, arr_v1);
                    goto label_79;
                }
                A a3 = (A)arrayList2.get(0);
                s.e(arr_v1, a3);
                Object object1 = k0.g(a3.getKey());
                kotlin.jvm.internal.q.d(object1);
                o.z(object1);
                a3.h(0);
                throw null;
            }
        label_79:
            if(!arrayList1.isEmpty()) {
                if(arrayList1.size() > 1) {
                    t.S(arrayList1, new r(b2, 0));
                }
                if(arrayList1.size() <= 0) {
                    n.d0(0, arr_v1);
                    goto label_92;
                }
                A a4 = (A)arrayList1.get(0);
                s.e(arr_v1, a4);
                Object object2 = k0.g(a4.getKey());
                kotlin.jvm.internal.q.d(object2);
                o.z(object2);
                a4.h(0);
                throw null;
            }
        }
    label_92:
        Object[] arr_object1 = l0.b;
        long[] arr_v2 = l0.a;
        int v20 = arr_v2.length - 2;
        if(v20 >= 0) {
            int v21 = 0;
            while(true) {
                long v22 = arr_v2[v21];
                if((~v22 << 7 & v22 & 0x8080808080808080L) == 0x8080808080808080L) {
                    goto label_109;
                }
                int v23 = 8 - (~(v21 - v20) >>> 0x1F);
                long v24 = v22;
                for(int v25 = 0; v25 < v23; ++v25) {
                    if((v24 & 0xFFL) < 0x80L) {
                        o.z(k0.g(arr_object1[(v21 << 3) + v25]));
                    }
                    v24 >>= 8;
                }
                if(v23 == 8) {
                label_109:
                    if(v21 != v20) {
                        ++v21;
                        continue;
                    }
                }
                goto label_112;
            }
        }
        else {
        label_112:
            arrayList3 = this.f;
            if(!arrayList3.isEmpty()) {
                if(arrayList3.size() > 1) {
                    t.S(arrayList3, new r(b0, 3));
                }
                if(arrayList3.size() > 0) {
                    A a5 = (A)arrayList3.get(0);
                    Object object3 = k0.g(a5.getKey());
                    kotlin.jvm.internal.q.d(object3);
                    o.z(object3);
                    s.e(arr_v1, a5);
                    if(z) {
                        ((A)p.k0(arrayList0)).h(0);
                    }
                    throw null;
                }
                n.d0(0, arr_v1);
            }
        }
        ArrayList arrayList4 = this.g;
        if(!arrayList4.isEmpty()) {
            if(arrayList4.size() > 1) {
                t.S(arrayList4, new r(b0, 1));
            }
            if(arrayList4.size() > 0) {
                A a6 = (A)arrayList4.get(0);
                Object object4 = k0.g(a6.getKey());
                kotlin.jvm.internal.q.d(object4);
                o.z(object4);
                s.e(arr_v1, a6);
                if(z) {
                    ((A)p.s0(arrayList0)).h(0);
                }
                throw null;
            }
        }
        Collections.reverse(arrayList3);
        arrayList0.addAll(0, arrayList3);
        arrayList0.addAll(arrayList4);
        arrayList2.clear();
        arrayList1.clear();
        arrayList3.clear();
        arrayList4.clear();
        l0.b();
    }

    public final void d() {
        K k0 = this.a;
        if(k0.e != 0) {
            Object[] arr_object = k0.c;
            long[] arr_v = k0.a;
            int v = arr_v.length - 2;
            if(v >= 0) {
                int v1 = 0;
                while(true) {
                    long v2 = arr_v[v1];
                    if((~v2 << 7 & v2 & 0x8080808080808080L) != 0x8080808080808080L) {
                        int v3 = 8 - (~(v1 - v) >>> 0x1F);
                        int v4 = 0;
                        while(v4 < v3) {
                            if((0xFFL & v2) >= 0x80L) {
                                v2 >>= 8;
                                ++v4;
                                continue;
                            }
                            o.z(arr_object[(v1 << 3) + v4]);
                            throw null;
                        }
                        if(v3 != 8) {
                            k0.a();
                            return;
                        }
                    }
                    if(v1 == v) {
                        break;
                    }
                    ++v1;
                }
                k0.a();
                return;
            }
            k0.a();
        }
    }

    public static int e(int[] arr_v, A a0) {
        int v = a0.i();
        int v1 = a0.b() + v;
        int v2 = 0;
        while(v < v1) {
            int v3 = arr_v[v];
            int v4 = a0.d() + v3;
            arr_v[v] = v4;
            v2 = Math.max(v2, v4);
            ++v;
        }
        return v2;
    }
}

