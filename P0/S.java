package p0;

import F.e;
import androidx.compose.foundation.w;
import androidx.compose.runtime.j0;
import androidx.compose.runtime.q;
import i.n.i.b.a.s.e.M3;
import j3.n;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import je.p;
import k8.Y;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.r;
import we.a;
import we.k;

public final class s {
    public final r a;
    public final AtomicReference b;
    public boolean c;
    public final e d;
    public final w e;
    public final g0.e f;
    public final Object g;
    public n h;
    public p0.r i;
    public long j;

    public s(k k0) {
        this.a = (r)k0;
        this.b = new AtomicReference(null);
        this.d = new e(this, 21);
        this.e = new w(this, 19);
        this.f = new g0.e(new p0.r[16]);
        this.g = new Object();
        this.j = -1L;
    }

    public static final boolean a(s s0) {
        Set set0;
        Object object1;
        synchronized(s0.g) {
        }
        if(s0.c) {
            return false;
        }
        boolean z = false;
        while(true) {
            AtomicReference atomicReference0 = s0.b;
        alab1:
            while(true) {
                Object object0 = atomicReference0.get();
                object1 = null;
                if(object0 == null) {
                    break;
                }
                if(object0 instanceof Set) {
                    set0 = (Set)object0;
                }
                else {
                    if(!(object0 instanceof List)) {
                        q.d("Unexpected notification");
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    Set set1 = (Set)((List)object0).get(0);
                    if(((List)object0).size() == 2) {
                        object1 = ((List)object0).get(1);
                    }
                    else if(((List)object0).size() > 2) {
                        object1 = ((List)object0).subList(1, ((List)object0).size());
                    }
                    set0 = set1;
                }
                do {
                    if(atomicReference0.compareAndSet(object0, object1)) {
                        object1 = set0;
                        break alab1;
                    }
                }
                while(atomicReference0.get() == object0);
            }
            if(object1 == null) {
                return z;
            }
            synchronized(s0.g) {
                Object[] arr_object = s0.f.a;
                int v1 = s0.f.c;
                for(int v2 = 0; v2 < v1; ++v2) {
                    z = ((p0.r)arr_object[v2]).b(((Set)object1)) || z;
                }
            }
        }
    }

    public final void b() {
        synchronized(this.g) {
            Object[] arr_object = this.f.a;
            int v1 = this.f.c;
            for(int v2 = 0; v2 < v1; ++v2) {
                p0.r r0 = (p0.r)arr_object[v2];
                r0.e.a();
                r0.f.a();
                r0.k.a();
                r0.l.clear();
            }
        }
    }

    public final void c(Object object0, k k0, a a0) {
        p0.r r0;
        Object object2;
        synchronized(this.g) {
            g0.e e0 = this.f;
            Object[] arr_object = e0.a;
            int v1 = e0.c;
            for(int v2 = 0; true; ++v2) {
                object2 = null;
                if(v2 >= v1) {
                    break;
                }
                Object object3 = arr_object[v2];
                if(((p0.r)object3).a == k0) {
                    object2 = object3;
                    break;
                }
            }
            r0 = (p0.r)object2;
            if(r0 == null) {
                kotlin.jvm.internal.q.e(k0, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
                N.e(1, k0);
                r0 = new p0.r(k0);
                e0.b(r0);
            }
        }
        p0.r r1 = this.i;
        long v3 = this.j;
        if(v3 != -1L && v3 != 0x6EB4BL) {
            StringBuilder stringBuilder0 = Y.o(v3, "Detected multithreaded access to SnapshotStateObserver: previousThreadId=", "), currentThread={id=");
            stringBuilder0.append(0x6EB4BL);
            stringBuilder0.append(", name=");
            stringBuilder0.append("jeb-dexdec-sb-st-1257");
            stringBuilder0.append("}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
            j0.a(stringBuilder0.toString());
        }
        try {
            this.i = r0;
            this.j = 0x6EB4BL;
            r0.a(object0, this.e, a0);
            this.i = r1;
            this.j = v3;
        }
        catch(Throwable throwable0) {
            this.i = r1;
            this.j = v3;
            throw throwable0;
        }
    }

    public final void d() {
        m.f(p0.a.h);
        synchronized(m.b) {
            m.g = p.z0(this.d, ((Collection)m.g));
        }
        this.h = new n(this.d, 5);
    }
}

