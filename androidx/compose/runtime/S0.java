package androidx.compose.runtime;

import android.os.Trace;
import androidx.collection.L;
import g0.e;
import ie.H;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.r;
import p0.m;
import we.k;

public final class s0 extends r implements k {
    public final u0 f;
    public final L g;
    public final L h;
    public final List i;
    public final List j;
    public final L k;
    public final List l;
    public final L m;
    public final Set n;

    public s0(u0 u00, L l0, L l1, List list0, List list1, L l2, List list2, L l3, Set set0) {
        this.f = u00;
        this.g = l0;
        this.h = l1;
        this.i = list0;
        this.j = list1;
        this.k = l2;
        this.l = list2;
        this.m = l3;
        this.n = set0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        long v = ((Number)object0).longValue();
        synchronized(this.f.c) {
            boolean z = this.f.v();
        }
        if(z) {
            Trace.beginSection("Recomposer:animation");
            try {
                this.f.b.a(v);
                synchronized(m.b) {
                    boolean z1 = true;
                    L l0 = m.i.h;
                    if(l0 == null || !l0.h()) {
                        z1 = false;
                    }
                }
                if(z1) {
                    m.a();
                }
            }
            catch(Throwable throwable0) {
                Trace.endSection();
                throw throwable0;
            }
            Trace.endSection();
        }
        u0 u00 = this.f;
        L l1 = this.g;
        L l2 = this.h;
        List list0 = this.i;
        List list1 = this.j;
        L l3 = this.k;
        List list2 = this.l;
        L l4 = this.m;
        Set set0 = this.n;
        Trace.beginSection("Recomposer:recompose");
        try {
            u0.r(u00);
            synchronized(u00.c) {
                Object[] arr_object = u00.i.a;
                int v4 = u00.i.c;
                for(int v5 = 0; v5 < v4; ++v5) {
                    list0.add(((v)arr_object[v5]));
                }
                u00.i.g();
            }
            l1.b();
            l2.b();
            while(true) {
            label_54:
                if(list0.isEmpty() && list1.isEmpty()) {
                    if(!list2.isEmpty()) {
                        ++u00.a;
                        break;
                    }
                    goto label_78;
                }
                goto label_148;
            }
        }
        catch(Throwable throwable1) {
            Trace.endSection();
            throw throwable1;
        }
        try {
            int v6 = list2.size();
            for(int v7 = 0; v7 < v6; ++v7) {
                l4.a(((v)list2.get(v7)));
            }
            int v8 = list2.size();
            int v9 = 0;
            while(true) {
                if(v9 >= v8) {
                    goto label_77;
                }
                ((v)list2.get(v9)).e();
                ++v9;
            }
        }
        catch(Throwable throwable2) {
        }
        try {
            u00.A(throwable2, null);
            t0.d(u00, list0, list1, list2, l3, l4, l1, l2);
            goto label_219;
        label_77:
            list2.clear();
        label_78:
            if(l3.h()) {
                goto label_79;
            }
            goto label_108;
        }
        catch(Throwable throwable1) {
            Trace.endSection();
            throw throwable1;
        }
        finally {
            list2.clear();
        }
        try {
        label_79:
            l4.j(l3);
            Object[] arr_object1 = l3.b;
            long[] arr_v = l3.a;
            int v11 = arr_v.length - 2;
            if(v11 >= 0) {
                int v12 = 0;
                while(true) {
                    long v13 = arr_v[v12];
                    if((~v13 << 7 & v13 & 0x8080808080808080L) == 0x8080808080808080L) {
                        goto label_96;
                    }
                    int v14 = 8 - (~(v12 - v11) >>> 0x1F);
                    for(int v15 = 0; v15 < v14; ++v15) {
                        if((v13 & 0xFFL) < 0x80L) {
                            ((v)arr_object1[(v12 << 3) + v15]).g();
                        }
                        v13 >>= 8;
                    }
                    if(v14 == 8) {
                    label_96:
                        if(v12 != v11) {
                            ++v12;
                            continue;
                        }
                    }
                    break;
                }
            }
            goto label_107;
        }
        catch(Throwable throwable3) {
            try {
                u00.A(throwable3, null);
                t0.d(u00, list0, list1, list2, l3, l4, l1, l2);
                goto label_219;
            label_107:
                l3.b();
            label_108:
                if(l4.h()) {
                    goto label_109;
                }
                goto label_137;
            }
            catch(Throwable throwable1) {
                Trace.endSection();
                throw throwable1;
            }
            finally {
                l3.b();
            }
        }
        try {
        label_109:
            Object[] arr_object2 = l4.b;
            long[] arr_v1 = l4.a;
            int v17 = arr_v1.length - 2;
            if(v17 >= 0) {
                int v18 = 0;
                while(true) {
                    long v19 = arr_v1[v18];
                    if((~v19 << 7 & v19 & 0x8080808080808080L) == 0x8080808080808080L) {
                        goto label_125;
                    }
                    int v20 = 8 - (~(v18 - v17) >>> 0x1F);
                    for(int v21 = 0; v21 < v20; ++v21) {
                        if((v19 & 0xFFL) < 0x80L) {
                            ((v)arr_object2[(v18 << 3) + v21]).h();
                        }
                        v19 >>= 8;
                    }
                    if(v20 == 8) {
                    label_125:
                        if(v18 != v17) {
                            ++v18;
                            continue;
                        }
                    }
                    break;
                }
            }
            goto label_136;
        }
        catch(Throwable throwable4) {
            try {
                u00.A(throwable4, null);
                t0.d(u00, list0, list1, list2, l3, l4, l1, l2);
                goto label_219;
            label_136:
                l4.b();
            label_137:
                synchronized(u00.c) {
                    u00.u();
                }
                m.k().m();
                l2.b();
                l1.b();
                u00.q = null;
                goto label_219;
            }
            catch(Throwable throwable1) {
                Trace.endSection();
                throw throwable1;
            }
            finally {
                l4.b();
            }
        }
        try {
        label_148:
            int v24 = list0.size();
            int v25 = 0;
            while(true) {
                if(v25 >= v24) {
                    goto label_166;
                }
                v v26 = (v)list0.get(v25);
                v v27 = u0.q(u00, v26, l1);
                if(v27 != null) {
                    list2.add(v27);
                }
                l2.a(v26);
                ++v25;
            }
        }
        catch(Throwable throwable5) {
        }
        try {
            u00.A(throwable5, null);
            t0.d(u00, list0, list1, list2, l3, l4, l1, l2);
            goto label_219;
        label_166:
            list0.clear();
            if(l1.h() || u00.i.c != 0) {
                synchronized(u00.c) {
                    List list3 = u00.x();
                    int v30 = list3.size();
                    for(int v31 = 0; v31 < v30; ++v31) {
                        v v32 = (v)list3.get(v31);
                        if(!l2.c(v32) && v32.u(set0)) {
                            list0.add(v32);
                        }
                    }
                    e e0 = u00.i;
                    int v33 = e0.c;
                    int v35 = 0;
                    for(int v34 = 0; v34 < v33; ++v34) {
                        v v36 = (v)e0.a[v34];
                        if(!l2.c(v36) && !list0.contains(v36)) {
                            list0.add(v36);
                            ++v35;
                        }
                        else if(v35 > 0) {
                            e0.a[v34 - v35] = e0.a[v34];
                        }
                    }
                    int v37 = v33 - v35;
                    Arrays.fill(e0.a, v37, v33, null);
                    e0.c = v37;
                }
            }
            if(list0.isEmpty()) {
                goto label_201;
            }
            else {
                goto label_54;
            }
            goto label_219;
        }
        catch(Throwable throwable1) {
            Trace.endSection();
            throw throwable1;
        }
        finally {
            list0.clear();
        }
        try {
        label_201:
            t0.e(list1, u00);
            while(true) {
                if(list1.isEmpty()) {
                    goto label_54;
                }
                Iterable iterable0 = u00.z(list1, l1);
                l3.getClass();
                for(Object object4: iterable0) {
                    l3.k(object4);
                }
                t0.e(list1, u00);
            }
        }
        catch(Throwable throwable6) {
            try {
                u00.A(throwable6, null);
                t0.d(u00, list0, list1, list2, l3, l4, l1, l2);
                goto label_219;
            }
            catch(Throwable throwable1) {
            }
        }
        Trace.endSection();
        throw throwable1;
    label_219:
        Trace.endSection();
        return H.a;
    }
}

