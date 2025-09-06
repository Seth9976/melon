package p0;

import androidx.collection.F;
import androidx.collection.K;
import androidx.collection.L;
import androidx.compose.foundation.w;
import androidx.compose.runtime.D;
import androidx.compose.runtime.E;
import androidx.compose.runtime.P0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.o;
import d5.t;
import g0.e;
import g0.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import we.a;
import we.k;

public final class r {
    public final k a;
    public Object b;
    public F c;
    public int d;
    public final K e;
    public final K f;
    public final L g;
    public final e h;
    public final o i;
    public int j;
    public final K k;
    public final HashMap l;

    public r(k k0) {
        this.a = k0;
        this.d = -1;
        this.e = t.f();
        this.f = new K();
        this.g = new L();
        this.h = new e(new E[16]);
        this.i = new o(this, 1);
        this.k = t.f();
        this.l = new HashMap();
    }

    public final void a(Object object0, w w0, a a0) {
        int v9;
        Object object1 = this.b;
        F f0 = this.c;
        int v = this.d;
        this.b = object0;
        this.c = (F)this.f.g(object0);
        if(this.d == -1) {
            this.d = Long.hashCode(m.k().g());
        }
        e e0 = androidx.compose.runtime.w.g();
        try {
            e0.b(this.i);
            q.f(w0, a0);
        }
        finally {
            e0.k(e0.c - 1);
        }
        Object object2 = this.b;
        kotlin.jvm.internal.q.d(object2);
        int v2 = this.d;
        F f1 = this.c;
        if(f1 != null) {
            long[] arr_v = f1.a;
            int v3 = arr_v.length - 2;
            if(v3 >= 0) {
                int v4 = 0;
                while(true) {
                    long v5 = arr_v[v4];
                    if((~v5 << 7 & v5 & 0x8080808080808080L) != 0x8080808080808080L) {
                        int v6 = 8 - (~(v4 - v3) >>> 0x1F);
                        for(int v7 = 0; v7 < v6; v7 = v9 + 1) {
                            if((v5 & 0xFFL) < 0x80L) {
                                int v8 = (v4 << 3) + v7;
                                Object object3 = f1.b[v8];
                                v9 = v7;
                                boolean z = f1.c[v8] != v2;
                                if(z) {
                                    this.d(object2, object3);
                                }
                                if(z) {
                                    f1.f(v8);
                                }
                            }
                            else {
                                v9 = v7;
                            }
                            v5 >>= 8;
                        }
                        if(v6 == 8) {
                            goto label_43;
                        }
                        break;
                    }
                label_43:
                    if(v4 == v3) {
                        break;
                    }
                    ++v4;
                }
            }
        }
        this.b = object1;
        this.c = f0;
        this.d = v;
    }

    public final boolean b(Set set0) {
        int v71;
        F f1;
        int v70;
        int v69;
        Object[] arr_object17;
        int v66;
        K k2;
        Iterator iterator1;
        long[] arr_v11;
        long[] arr_v10;
        long v47;
        Object[] arr_object11;
        K k3;
        int v43;
        Iterator iterator2;
        Object object6;
        int v26;
        int v25;
        Object object5;
        int v24;
        Object object4;
        int v19;
        int v18;
        int v16;
        long v15;
        long v12;
        int v9;
        Object[] arr_object1;
        V v7;
        long[] arr_v1;
        boolean z;
        V v0 = V.f;
        e e0 = this.h;
        K k0 = this.k;
        HashMap hashMap0 = this.l;
        K k1 = this.e;
        L l0 = this.g;
        if(set0 instanceof h) {
            Object[] arr_object = ((h)set0).a.b;
            long[] arr_v = ((h)set0).a.a;
            int v1 = arr_v.length - 2;
            if(v1 >= 0) {
                int v2 = 0;
                z = false;
                while(true) {
                    long v3 = arr_v[v2];
                    int v4 = v2;
                    if((~v3 << 7 & v3 & 0x8080808080808080L) == 0x8080808080808080L) {
                        goto label_228;
                    }
                    int v5 = 8 - (~(v4 - v1) >>> 0x1F);
                    int v6 = 0;
                    while(v6 < v5) {
                        if((v3 & 0xFFL) < 0x80L) {
                            arr_v1 = arr_v;
                            Object object0 = arr_object[(v4 << 3) + v6];
                            v7 = v0;
                            if(object0 instanceof u) {
                                arr_object1 = arr_object;
                                if(!((u)object0).j(2)) {
                                    goto label_211;
                                }
                            }
                            else {
                                arr_object1 = arr_object;
                            }
                            if(k0.c(object0)) {
                                Object object1 = k0.g(object0);
                                if(object1 == null) {
                                label_170:
                                    object5 = object0;
                                    v25 = v1;
                                    v26 = v5;
                                    v9 = v6;
                                    v12 = v3;
                                }
                                else if(object1 instanceof L) {
                                    Object[] arr_object2 = ((L)object1).b;
                                    long[] arr_v2 = ((L)object1).a;
                                    Object[] arr_object3 = arr_object2;
                                    int v8 = arr_v2.length - 2;
                                    if(v8 >= 0) {
                                        long[] arr_v3 = arr_v2;
                                        v9 = v6;
                                        boolean z1 = z;
                                        int v10 = 0;
                                        while(true) {
                                            long v11 = arr_v3[v10];
                                            v12 = v3;
                                            if((~v11 << 7 & v11 & 0x8080808080808080L) == 0x8080808080808080L) {
                                                object5 = object0;
                                                v25 = v1;
                                                v26 = v5;
                                            }
                                            else {
                                                int v13 = 8 - (~(v10 - v8) >>> 0x1F);
                                                int v14 = 0;
                                                while(v14 < v13) {
                                                    if((v11 & 0xFFL) < 0x80L) {
                                                        v15 = v11;
                                                        E e1 = (E)arr_object3[(v10 << 3) + v14];
                                                        kotlin.jvm.internal.q.e(e1, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                                                        Object object2 = hashMap0.get(e1);
                                                        v16 = v14;
                                                        P0 p00 = e1.c;
                                                        if(p00 == null) {
                                                            p00 = v7;
                                                        }
                                                        if(p00.a(e1.n().f, object2)) {
                                                            object4 = object0;
                                                            v18 = v1;
                                                            v19 = v5;
                                                            e0.b(e1);
                                                        }
                                                        else {
                                                            Object object3 = k1.g(e1);
                                                            if(object3 == null) {
                                                            label_93:
                                                                object4 = object0;
                                                                v18 = v1;
                                                                v19 = v5;
                                                            }
                                                            else if(object3 instanceof L) {
                                                                Object[] arr_object4 = ((L)object3).b;
                                                                long[] arr_v4 = ((L)object3).a;
                                                                int v17 = arr_v4.length - 2;
                                                                if(v17 >= 0) {
                                                                    v18 = v1;
                                                                    v19 = v5;
                                                                    int v20 = 0;
                                                                    while(true) {
                                                                        long v21 = arr_v4[v20];
                                                                        object4 = object0;
                                                                        if((~v21 << 7 & v21 & 0x8080808080808080L) == 0x8080808080808080L) {
                                                                            goto label_83;
                                                                        }
                                                                        int v22 = 8 - (~(v20 - v17) >>> 0x1F);
                                                                        for(int v23 = 0; v23 < v22; v23 = v24 + 1) {
                                                                            if((v21 & 0xFFL) < 0x80L) {
                                                                                v24 = v23;
                                                                                l0.a(arr_object4[(v20 << 3) + v23]);
                                                                                z1 = true;
                                                                            }
                                                                            else {
                                                                                v24 = v23;
                                                                            }
                                                                            v21 >>= 8;
                                                                        }
                                                                        if(v22 == 8) {
                                                                        label_83:
                                                                            if(v20 != v17) {
                                                                                ++v20;
                                                                                object0 = object4;
                                                                                continue;
                                                                            }
                                                                        }
                                                                        break;
                                                                    }
                                                                }
                                                                else {
                                                                    goto label_93;
                                                                }
                                                            }
                                                            else {
                                                                object4 = object0;
                                                                v18 = v1;
                                                                v19 = v5;
                                                                l0.a(object3);
                                                                z1 = true;
                                                            }
                                                        }
                                                    }
                                                    else {
                                                        object4 = object0;
                                                        v18 = v1;
                                                        v19 = v5;
                                                        v15 = v11;
                                                        v16 = v14;
                                                    }
                                                    v11 = v15 >> 8;
                                                    v14 = v16 + 1;
                                                    v1 = v18;
                                                    v5 = v19;
                                                    object0 = object4;
                                                }
                                                object5 = object0;
                                                v25 = v1;
                                                v26 = v5;
                                                if(v13 != 8) {
                                                    z = z1;
                                                    object6 = object5;
                                                    goto label_182;
                                                }
                                            }
                                            if(v10 == v8) {
                                                break;
                                            }
                                            ++v10;
                                            v3 = v12;
                                            v1 = v25;
                                            v5 = v26;
                                            object0 = object5;
                                        }
                                        z = z1;
                                        goto label_175;
                                    }
                                    else {
                                        goto label_170;
                                    }
                                    goto label_132;
                                }
                                else {
                                label_132:
                                    object5 = object0;
                                    v25 = v1;
                                    v26 = v5;
                                    v9 = v6;
                                    v12 = v3;
                                    Object object7 = hashMap0.get(((E)object1));
                                    P0 p01 = ((E)object1).c;
                                    if(p01 == null) {
                                        p01 = v7;
                                    }
                                    if(p01.a(((E)object1).n().f, object7)) {
                                        e0.b(((E)object1));
                                    }
                                    else {
                                        Object object8 = k1.g(((E)object1));
                                        if(object8 != null) {
                                            if(object8 instanceof L) {
                                                Object[] arr_object5 = ((L)object8).b;
                                                long[] arr_v5 = ((L)object8).a;
                                                int v27 = arr_v5.length - 2;
                                                if(v27 >= 0) {
                                                    int v28 = 0;
                                                    while(true) {
                                                        long v29 = arr_v5[v28];
                                                        if((~v29 << 7 & v29 & 0x8080808080808080L) == 0x8080808080808080L) {
                                                            goto label_162;
                                                        }
                                                        int v30 = 8 - (~(v28 - v27) >>> 0x1F);
                                                        for(int v31 = 0; v31 < v30; ++v31) {
                                                            if((v29 & 0xFFL) < 0x80L) {
                                                                l0.a(arr_object5[(v28 << 3) + v31]);
                                                                z = true;
                                                            }
                                                            v29 >>= 8;
                                                        }
                                                        if(v30 == 8) {
                                                        label_162:
                                                            if(v28 != v27) {
                                                                ++v28;
                                                                continue;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                }
                                            }
                                            else {
                                                l0.a(object8);
                                                z = true;
                                            }
                                        }
                                    }
                                }
                            label_175:
                                object6 = object5;
                            }
                            else {
                                v25 = v1;
                                v26 = v5;
                                v9 = v6;
                                v12 = v3;
                                object6 = object0;
                            }
                        label_182:
                            Object object9 = k1.g(object6);
                            if(object9 != null) {
                                if(object9 instanceof L) {
                                    Object[] arr_object6 = ((L)object9).b;
                                    long[] arr_v6 = ((L)object9).a;
                                    int v32 = arr_v6.length - 2;
                                    if(v32 >= 0) {
                                        int v33 = 0;
                                        while(true) {
                                            long v34 = arr_v6[v33];
                                            if((~v34 << 7 & v34 & 0x8080808080808080L) == 0x8080808080808080L) {
                                                goto label_202;
                                            }
                                            int v35 = 8 - (~(v33 - v32) >>> 0x1F);
                                            for(int v36 = 0; v36 < v35; ++v36) {
                                                if((v34 & 0xFFL) < 0x80L) {
                                                    l0.a(arr_object6[(v33 << 3) + v36]);
                                                    z = true;
                                                }
                                                v34 >>= 8;
                                            }
                                            if(v35 == 8) {
                                            label_202:
                                                if(v33 != v32) {
                                                    ++v33;
                                                    continue;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                }
                                else {
                                    l0.a(object9);
                                    z = true;
                                }
                            }
                        }
                        else {
                            arr_v1 = arr_v;
                            v7 = v0;
                            arr_object1 = arr_object;
                        label_211:
                            v25 = v1;
                            v26 = v5;
                            v9 = v6;
                            v12 = v3;
                        }
                        v6 = v9 + 1;
                        v0 = v7;
                        arr_object = arr_object1;
                        v1 = v25;
                        v5 = v26;
                        v3 = v12 >> 8;
                        arr_v = arr_v1;
                    }
                    long[] arr_v7 = arr_v;
                    V v37 = v0;
                    Object[] arr_object7 = arr_object;
                    if(v5 == 8) {
                        goto label_231;
                    label_228:
                        arr_v7 = arr_v;
                        v37 = v0;
                        arr_object7 = arr_object;
                    label_231:
                        if(v4 != v1) {
                            v2 = v4 + 1;
                            v0 = v37;
                            arr_v = arr_v7;
                            arr_object = arr_object7;
                            continue;
                        }
                    }
                    break;
                }
            }
            else {
                z = false;
            }
        }
        else {
            z = false;
            Iterator iterator0 = set0.iterator();
            while(iterator0.hasNext()) {
                Object object10 = iterator0.next();
                if(!(object10 instanceof u) || ((u)object10).j(2)) {
                    if(k0.c(object10)) {
                        Object object11 = k0.g(object10);
                        if(object11 == null) {
                            iterator1 = iterator0;
                            k2 = k0;
                        }
                        else if(object11 instanceof L) {
                            Object[] arr_object8 = ((L)object11).b;
                            long[] arr_v8 = ((L)object11).a;
                            int v38 = arr_v8.length - 2;
                            if(v38 >= 0) {
                                int v39 = 0;
                                while(true) {
                                    long v40 = arr_v8[v39];
                                    Object[] arr_object9 = arr_object8;
                                    if((~v40 << 7 & v40 & 0x8080808080808080L) == 0x8080808080808080L) {
                                        goto label_340;
                                    }
                                    int v41 = 8 - (~(v39 - v38) >>> 0x1F);
                                    int v42 = 0;
                                    while(v42 < v41) {
                                        if((v40 & 0xFFL) < 0x80L) {
                                            iterator2 = iterator0;
                                            E e2 = (E)arr_object9[(v39 << 3) + v42];
                                            kotlin.jvm.internal.q.e(e2, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                                            v43 = v42;
                                            Object object12 = hashMap0.get(e2);
                                            P0 p02 = e2.c;
                                            if(p02 == null) {
                                                p02 = v0;
                                            }
                                            k3 = k0;
                                            if(p02.a(e2.n().f, object12)) {
                                                arr_object11 = arr_object9;
                                                v47 = v40;
                                                e0.b(e2);
                                            }
                                            else {
                                                Object object13 = k1.g(e2);
                                                if(object13 != null) {
                                                    if(object13 instanceof L) {
                                                        Object[] arr_object10 = ((L)object13).b;
                                                        long[] arr_v9 = ((L)object13).a;
                                                        int v44 = arr_v9.length - 2;
                                                        if(v44 >= 0) {
                                                            arr_object11 = arr_object9;
                                                            boolean z2 = z;
                                                            int v45 = 0;
                                                            while(true) {
                                                                long v46 = arr_v9[v45];
                                                                v47 = v40;
                                                                if((~v46 << 7 & v46 & 0x8080808080808080L) == 0x8080808080808080L) {
                                                                label_304:
                                                                    arr_v11 = arr_v9;
                                                                }
                                                                else {
                                                                    int v48 = 8 - (~(v45 - v44) >>> 0x1F);
                                                                    int v49 = 0;
                                                                    while(v49 < v48) {
                                                                        if((v46 & 0xFFL) < 0x80L) {
                                                                            arr_v10 = arr_v9;
                                                                            l0.a(arr_object10[(v45 << 3) + v49]);
                                                                            z2 = true;
                                                                        }
                                                                        else {
                                                                            arr_v10 = arr_v9;
                                                                        }
                                                                        v46 >>= 8;
                                                                        ++v49;
                                                                        arr_v9 = arr_v10;
                                                                    }
                                                                    if(v48 == 8) {
                                                                        arr_v11 = arr_v9;
                                                                        goto label_305;
                                                                    }
                                                                    else {
                                                                        z = z2;
                                                                        goto label_329;
                                                                    }
                                                                    goto label_304;
                                                                }
                                                            label_305:
                                                                if(v45 == v44) {
                                                                    break;
                                                                }
                                                                ++v45;
                                                                v40 = v47;
                                                                arr_v9 = arr_v11;
                                                            }
                                                            z = z2;
                                                            goto label_329;
                                                        }
                                                    }
                                                    else {
                                                        arr_object11 = arr_object9;
                                                        v47 = v40;
                                                        l0.a(object13);
                                                        z = true;
                                                        goto label_329;
                                                    }
                                                }
                                                arr_object11 = arr_object9;
                                                v47 = v40;
                                            }
                                        }
                                        else {
                                            iterator2 = iterator0;
                                            v43 = v42;
                                            k3 = k0;
                                            arr_object11 = arr_object9;
                                            v47 = v40;
                                        }
                                    label_329:
                                        v40 = v47 >> 8;
                                        k0 = k3;
                                        arr_object9 = arr_object11;
                                        v42 = v43 + 1;
                                        iterator0 = iterator2;
                                    }
                                    iterator1 = iterator0;
                                    k2 = k0;
                                    Object[] arr_object12 = arr_object9;
                                    if(v41 == 8) {
                                        goto label_343;
                                    label_340:
                                        iterator1 = iterator0;
                                        k2 = k0;
                                        arr_object12 = arr_object9;
                                    label_343:
                                        if(v39 != v38) {
                                            ++v39;
                                            iterator0 = iterator1;
                                            k0 = k2;
                                            arr_object8 = arr_object12;
                                            continue;
                                        }
                                    }
                                    break;
                                }
                            }
                            else {
                                iterator1 = iterator0;
                                k2 = k0;
                            }
                        }
                        else {
                            iterator1 = iterator0;
                            k2 = k0;
                            Object object14 = hashMap0.get(((E)object11));
                            P0 p03 = ((E)object11).c;
                            if(p03 == null) {
                                p03 = v0;
                            }
                            if(p03.a(((E)object11).n().f, object14)) {
                                e0.b(((E)object11));
                            }
                            else {
                                Object object15 = k1.g(((E)object11));
                                if(object15 != null) {
                                    if(object15 instanceof L) {
                                        Object[] arr_object13 = ((L)object15).b;
                                        long[] arr_v12 = ((L)object15).a;
                                        int v50 = arr_v12.length - 2;
                                        if(v50 >= 0) {
                                            int v51 = 0;
                                            while(true) {
                                                long v52 = arr_v12[v51];
                                                if((~v52 << 7 & v52 & 0x8080808080808080L) == 0x8080808080808080L) {
                                                    goto label_379;
                                                }
                                                int v53 = 8 - (~(v51 - v50) >>> 0x1F);
                                                for(int v54 = 0; v54 < v53; ++v54) {
                                                    if((v52 & 0xFFL) < 0x80L) {
                                                        l0.a(arr_object13[(v51 << 3) + v54]);
                                                        z = true;
                                                    }
                                                    v52 >>= 8;
                                                }
                                                if(v53 == 8) {
                                                label_379:
                                                    if(v51 != v50) {
                                                        ++v51;
                                                        continue;
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    else {
                                        l0.a(object15);
                                        z = true;
                                    }
                                }
                            }
                        }
                    }
                    else {
                        iterator1 = iterator0;
                        k2 = k0;
                    }
                    Object object16 = k1.g(object10);
                    if(object16 != null) {
                        if(object16 instanceof L) {
                            Object[] arr_object14 = ((L)object16).b;
                            long[] arr_v13 = ((L)object16).a;
                            int v55 = arr_v13.length - 2;
                            if(v55 >= 0) {
                                int v56 = 0;
                                while(true) {
                                    long v57 = arr_v13[v56];
                                    if((~v57 << 7 & v57 & 0x8080808080808080L) == 0x8080808080808080L) {
                                        goto label_409;
                                    }
                                    int v58 = 8 - (~(v56 - v55) >>> 0x1F);
                                    for(int v59 = 0; v59 < v58; ++v59) {
                                        if((v57 & 0xFFL) < 0x80L) {
                                            l0.a(arr_object14[(v56 << 3) + v59]);
                                            z = true;
                                        }
                                        v57 >>= 8;
                                    }
                                    if(v58 == 8) {
                                    label_409:
                                        if(v56 != v55) {
                                            ++v56;
                                            continue;
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                        else {
                            l0.a(object16);
                            z = true;
                        }
                    }
                }
                else {
                    iterator1 = iterator0;
                    k2 = k0;
                }
                iterator0 = iterator1;
                k0 = k2;
            }
        }
        int v60 = e0.c;
        if(v60 != 0) {
            Object[] arr_object15 = e0.a;
            int v61 = 0;
            while(v61 < v60) {
                E e3 = (E)arr_object15[v61];
                int v62 = Long.hashCode(m.k().g());
                Object object17 = k1.g(e3);
                if(object17 == null) {
                    v66 = v60;
                    arr_object17 = arr_object15;
                    v71 = v61;
                }
                else {
                    K k4 = this.f;
                    if(object17 instanceof L) {
                        Object[] arr_object16 = ((L)object17).b;
                        long[] arr_v14 = ((L)object17).a;
                        int v63 = arr_v14.length - 2;
                        if(v63 >= 0) {
                            int v64 = 0;
                            while(true) {
                                long v65 = arr_v14[v64];
                                v66 = v60;
                                arr_object17 = arr_object15;
                                if((~v65 << 7 & v65 & 0x8080808080808080L) == 0x8080808080808080L) {
                                    goto label_461;
                                }
                                int v67 = 8 - (~(v64 - v63) >>> 0x1F);
                                int v68 = 0;
                                while(v68 < v67) {
                                    if((v65 & 0xFFL) < 0x80L) {
                                        v69 = v68;
                                        Object object18 = arr_object16[(v64 << 3) + v68];
                                        F f0 = (F)k4.g(object18);
                                        v70 = v61;
                                        if(f0 == null) {
                                            f1 = new F();
                                            k4.l(object18, f1);
                                        }
                                        else {
                                            f1 = f0;
                                        }
                                        this.c(e3, v62, object18, f1);
                                    }
                                    else {
                                        v69 = v68;
                                        v70 = v61;
                                    }
                                    v65 >>= 8;
                                    v68 = v69 + 1;
                                    v61 = v70;
                                }
                                v71 = v61;
                                if(v67 == 8) {
                                    goto label_462;
                                label_461:
                                    v71 = v61;
                                label_462:
                                    if(v64 != v63) {
                                        ++v64;
                                        v60 = v66;
                                        arr_object15 = arr_object17;
                                        v61 = v71;
                                        continue;
                                    }
                                }
                                break;
                            }
                        }
                        else {
                            v66 = v60;
                            arr_object17 = arr_object15;
                            v71 = v61;
                        }
                    }
                    else {
                        v66 = v60;
                        arr_object17 = arr_object15;
                        v71 = v61;
                        F f2 = (F)k4.g(object17);
                        if(f2 == null) {
                            f2 = new F();
                            k4.l(object17, f2);
                        }
                        this.c(e3, v62, object17, f2);
                    }
                }
                v61 = v71 + 1;
                v60 = v66;
                arr_object15 = arr_object17;
            }
            e0.g();
            return z;
        }
        return z;
    }

    public final void c(Object object0, int v, Object object1, F f0) {
        int v2;
        if(this.j <= 0) {
            int v1 = f0.c(object0);
            if(v1 < 0) {
                v1 = ~v1;
                v2 = -1;
            }
            else {
                v2 = f0.c[v1];
            }
            f0.b[v1] = object0;
            f0.c[v1] = v;
            if(!(object0 instanceof E) || v2 == v) {
            label_37:
                if(v2 == -1) {
                    if(object0 instanceof u) {
                        ((u)object0).k(2);
                    }
                    t.c(this.e, object0, object1);
                }
            }
            else {
                D d0 = ((E)object0).n();
                this.l.put(object0, d0.f);
                F f1 = d0.e;
                K k0 = this.k;
                t.p(k0, object0);
                Object[] arr_object = f1.b;
                long[] arr_v = f1.a;
                int v3 = arr_v.length - 2;
                if(v3 >= 0) {
                    int v4 = 0;
                    while(true) {
                        long v5 = arr_v[v4];
                        if((~v5 << 7 & v5 & 0x8080808080808080L) == 0x8080808080808080L) {
                            goto label_34;
                        }
                        int v6 = 8 - (~(v4 - v3) >>> 0x1F);
                        for(int v7 = 0; v7 < v6; ++v7) {
                            if((v5 & 0xFFL) < 0x80L) {
                                p0.t t0 = (p0.t)arr_object[(v4 << 3) + v7];
                                if(t0 instanceof u) {
                                    ((u)t0).k(2);
                                }
                                t.c(k0, t0, object0);
                            }
                            v5 >>= 8;
                        }
                        if(v6 == 8) {
                        label_34:
                            if(v4 != v3) {
                                ++v4;
                                continue;
                            }
                        }
                        goto label_37;
                    }
                }
                else {
                    goto label_37;
                }
            }
        }
    }

    public final void d(Object object0, Object object1) {
        t.o(this.e, object1, object0);
        if(object1 instanceof E && !this.e.c(object1)) {
            t.p(this.k, object1);
            this.l.remove(object1);
        }
    }

    public final void e() {
        long[] arr_v4;
        P0.e e2;
        long v13;
        Boolean boolean1;
        long v7;
        long[] arr_v3;
        P0.e e1;
        P0.e e0 = P0.e.l;
        K k0 = this.f;
        long[] arr_v = k0.a;
        int v = arr_v.length - 2;
        if(v >= 0) {
            int v1 = 0;
            while(true) {
                long v2 = arr_v[v1];
                if((~v2 << 7 & v2 & 0x8080808080808080L) == 0x8080808080808080L) {
                    e2 = e0;
                    arr_v4 = arr_v;
                }
                else {
                    int v3 = 8 - (~(v1 - v) >>> 0x1F);
                    int v4 = 0;
                    while(v4 < v3) {
                        if((v2 & 0xFFL) < 0x80L) {
                            int v5 = (v1 << 3) + v4;
                            Object object0 = k0.b[v5];
                            F f0 = (F)k0.c[v5];
                            Boolean boolean0 = (Boolean)e0.invoke(object0);
                            if(boolean0.booleanValue()) {
                                Object[] arr_object = f0.b;
                                int[] arr_v1 = f0.c;
                                long[] arr_v2 = f0.a;
                                e1 = e0;
                                int v6 = arr_v2.length - 2;
                                arr_v3 = arr_v;
                                v7 = v2;
                                if(v6 >= 0) {
                                    int v8 = 0;
                                    while(true) {
                                        long v9 = arr_v2[v8];
                                        boolean1 = boolean0;
                                        if((~v9 << 7 & v9 & 0x8080808080808080L) == 0x8080808080808080L) {
                                            goto label_44;
                                        }
                                        int v10 = 8 - (~(v8 - v6) >>> 0x1F);
                                        for(int v11 = 0; v11 < v10; ++v11) {
                                            if((v9 & 0xFFL) < 0x80L) {
                                                int v12 = (v8 << 3) + v11;
                                                v13 = v9;
                                                Object object1 = arr_object[v12];
                                                int v14 = arr_v1[v12];
                                                this.d(object0, object1);
                                            }
                                            else {
                                                v13 = v9;
                                            }
                                            v9 = v13 >> 8;
                                        }
                                        if(v10 == 8) {
                                        label_44:
                                            if(v8 != v6) {
                                                ++v8;
                                                boolean0 = boolean1;
                                                continue;
                                            }
                                        }
                                        break;
                                    }
                                }
                                else {
                                    boolean1 = boolean0;
                                }
                            }
                            else {
                                e1 = e0;
                                arr_v3 = arr_v;
                                v7 = v2;
                                boolean1 = boolean0;
                            }
                            if(boolean1.booleanValue()) {
                                k0.k(v5);
                            }
                        }
                        else {
                            e1 = e0;
                            arr_v3 = arr_v;
                            v7 = v2;
                        }
                        ++v4;
                        v2 = v7 >> 8;
                        e0 = e1;
                        arr_v = arr_v3;
                    }
                    e2 = e0;
                    arr_v4 = arr_v;
                    if(v3 != 8) {
                        break;
                    }
                }
                if(v1 == v) {
                    break;
                }
                ++v1;
                e0 = e2;
                arr_v = arr_v4;
            }
        }
    }
}

