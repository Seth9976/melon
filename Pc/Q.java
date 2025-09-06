package pc;

import com.iloen.melon.playback.playlist.db.MixUpPlaylistDao;
import d5.n;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import ne.a;
import oe.c;

public final class q {
    public final MixUpPlaylistDao a;
    public final Mutex b;

    public q(MixUpPlaylistDao mixUpPlaylistDao0) {
        this.a = mixUpPlaylistDao0;
        this.b = MutexKt.Mutex$default(false, 1, null);
    }

    public final Object a(c c0) {
        List list0;
        Throwable throwable1;
        Mutex mutex2;
        Object object1;
        int v1;
        Mutex mutex0;
        e e0;
        if(c0 instanceof e) {
            e0 = (e)c0;
            int v = e0.E;
            if((v & 0x80000000) == 0) {
                e0 = new e(this, c0);
            }
            else {
                e0.E = v ^ 0x80000000;
            }
        }
        else {
            e0 = new e(this, c0);
        }
        Object object0 = e0.B;
        a a0 = a.a;
        switch(e0.E) {
            case 0: {
                n.D(object0);
                mutex0 = this.b;
                e0.r = mutex0;
                v1 = 0;
                e0.w = 0;
                e0.E = 1;
                if(mutex0.lock(null, e0) == a0) {
                    return a0;
                }
                goto label_25;
            }
            case 1: {
                v1 = e0.w;
                Mutex mutex1 = e0.r;
                n.D(object0);
                mutex0 = mutex1;
                try {
                label_25:
                    f f0 = new f(this, null);
                    e0.r = mutex0;
                    e0.w = v1;
                    e0.E = 2;
                    object1 = BuildersKt.withContext(Dispatchers.getIO(), f0, e0);
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex0;
                    throwable1 = throwable0;
                    break;
                }
                if(object1 == a0) {
                    return a0;
                }
                mutex2 = mutex0;
                object0 = object1;
                list0 = (List)object0;
                goto label_47;
            }
            case 2: {
                try {
                    mutex2 = e0.r;
                    n.D(object0);
                    list0 = (List)object0;
                    goto label_47;
                }
                catch(Throwable throwable1) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable1;
    label_47:
        mutex2.unlock(null);
        return list0;
    }

    public final Object b(List list0, c c0) {
        Mutex mutex2;
        Throwable throwable1;
        int v1;
        Mutex mutex0;
        g g0;
        if(c0 instanceof g) {
            g0 = (g)c0;
            int v = g0.G;
            if((v & 0x80000000) == 0) {
                g0 = new g(this, c0);
            }
            else {
                g0.G = v ^ 0x80000000;
            }
        }
        else {
            g0 = new g(this, c0);
        }
        Object object0 = g0.D;
        a a0 = a.a;
        switch(g0.G) {
            case 0: {
                n.D(object0);
                g0.r = list0;
                mutex0 = this.b;
                g0.w = mutex0;
                v1 = 0;
                g0.B = 0;
                g0.G = 1;
                if(mutex0.lock(null, g0) == a0) {
                    return a0;
                }
                goto label_29;
            }
            case 1: {
                int v2 = g0.B;
                Mutex mutex1 = g0.w;
                List list1 = g0.r;
                n.D(object0);
                mutex0 = mutex1;
                v1 = v2;
                list0 = list1;
                try {
                label_29:
                    h h0 = new h(this, list0, null);
                    g0.r = null;
                    g0.w = mutex0;
                    g0.B = v1;
                    g0.G = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), h0, g0) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    throwable1 = throwable0;
                    mutex2 = mutex0;
                    mutex2.unlock(null);
                    throw throwable1;
                }
                mutex2 = mutex0;
                break;
            }
            case 2: {
                try {
                    mutex2 = g0.w;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable1) {
                }
                mutex2.unlock(null);
                throw throwable1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        return H.a;
    }

    public final Object c(List list0, Collection collection0, List list1, c c0) {
        Mutex mutex1;
        List list3;
        Collection collection1;
        List list2;
        int v1;
        i i0;
        if(c0 instanceof i) {
            i0 = (i)c0;
            int v = i0.M;
            if((v & 0x80000000) == 0) {
                i0 = new i(this, c0);
            }
            else {
                i0.M = v ^ 0x80000000;
            }
        }
        else {
            i0 = new i(this, c0);
        }
        Object object0 = i0.G;
        a a0 = a.a;
        switch(i0.M) {
            case 0: {
                n.D(object0);
                i0.r = list0;
                i0.w = collection0;
                i0.B = list1;
                Mutex mutex0 = this.b;
                i0.D = mutex0;
                v1 = 0;
                i0.E = 0;
                i0.M = 1;
                if(mutex0.lock(null, i0) == a0) {
                    return a0;
                }
                list2 = list0;
                collection1 = collection0;
                list3 = list1;
                mutex1 = mutex0;
                goto label_39;
            }
            case 1: {
                int v2 = i0.E;
                Mutex mutex2 = i0.D;
                List list4 = i0.B;
                Collection collection2 = i0.w;
                List list5 = i0.r;
                n.D(object0);
                list3 = list4;
                collection1 = collection2;
                list2 = list5;
                v1 = v2;
                mutex1 = mutex2;
                try {
                label_39:
                    j j0 = new j(this, list2, collection1, list3, null);
                    i0.r = null;
                    i0.w = null;
                    i0.B = null;
                    i0.D = mutex1;
                    i0.E = v1;
                    i0.M = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), j0, i0) == a0) {
                        return a0;
                    label_48:
                        mutex1 = i0.D;
                        n.D(object0);
                    }
                    break;
                }
                catch(Throwable throwable0) {
                    mutex1.unlock(null);
                    throw throwable0;
                }
            }
            case 2: {
                goto label_48;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex1.unlock(null);
        return H.a;
    }

    public final Object d(ArrayList arrayList0, c c0) {
        Mutex mutex2;
        Throwable throwable1;
        int v1;
        Mutex mutex0;
        k k0;
        if(c0 instanceof k) {
            k0 = (k)c0;
            int v = k0.G;
            if((v & 0x80000000) == 0) {
                k0 = new k(this, c0);
            }
            else {
                k0.G = v ^ 0x80000000;
            }
        }
        else {
            k0 = new k(this, c0);
        }
        Object object0 = k0.D;
        a a0 = a.a;
        switch(k0.G) {
            case 0: {
                n.D(object0);
                k0.r = arrayList0;
                mutex0 = this.b;
                k0.w = mutex0;
                v1 = 0;
                k0.B = 0;
                k0.G = 1;
                if(mutex0.lock(null, k0) == a0) {
                    return a0;
                }
                goto label_29;
            }
            case 1: {
                int v2 = k0.B;
                Mutex mutex1 = k0.w;
                ArrayList arrayList1 = k0.r;
                n.D(object0);
                mutex0 = mutex1;
                v1 = v2;
                arrayList0 = arrayList1;
                try {
                label_29:
                    l l0 = new l(this, arrayList0, null);
                    k0.r = null;
                    k0.w = mutex0;
                    k0.B = v1;
                    k0.G = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), l0, k0) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    throwable1 = throwable0;
                    mutex2 = mutex0;
                    mutex2.unlock(null);
                    throw throwable1;
                }
                mutex2 = mutex0;
                break;
            }
            case 2: {
                try {
                    mutex2 = k0.w;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable1) {
                }
                mutex2.unlock(null);
                throw throwable1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        return H.a;
    }

    public final Object e(List list0, c c0) {
        Mutex mutex2;
        Throwable throwable1;
        int v1;
        Mutex mutex0;
        m m0;
        if(c0 instanceof m) {
            m0 = (m)c0;
            int v = m0.G;
            if((v & 0x80000000) == 0) {
                m0 = new m(this, c0);
            }
            else {
                m0.G = v ^ 0x80000000;
            }
        }
        else {
            m0 = new m(this, c0);
        }
        Object object0 = m0.D;
        a a0 = a.a;
        switch(m0.G) {
            case 0: {
                n.D(object0);
                m0.r = list0;
                mutex0 = this.b;
                m0.w = mutex0;
                v1 = 0;
                m0.B = 0;
                m0.G = 1;
                if(mutex0.lock(null, m0) == a0) {
                    return a0;
                }
                goto label_29;
            }
            case 1: {
                int v2 = m0.B;
                Mutex mutex1 = m0.w;
                List list1 = m0.r;
                n.D(object0);
                mutex0 = mutex1;
                v1 = v2;
                list0 = list1;
                try {
                label_29:
                    pc.n n0 = new pc.n(this, list0, null);
                    m0.r = null;
                    m0.w = mutex0;
                    m0.B = v1;
                    m0.G = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), n0, m0) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    throwable1 = throwable0;
                    mutex2 = mutex0;
                    mutex2.unlock(null);
                    throw throwable1;
                }
                mutex2 = mutex0;
                break;
            }
            case 2: {
                try {
                    mutex2 = m0.w;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable1) {
                }
                mutex2.unlock(null);
                throw throwable1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        return H.a;
    }

    public final Object f(ArrayList arrayList0, c c0) {
        Mutex mutex2;
        Throwable throwable1;
        Object object1;
        int v1;
        Mutex mutex0;
        o o0;
        if(c0 instanceof o) {
            o0 = (o)c0;
            int v = o0.G;
            if((v & 0x80000000) == 0) {
                o0 = new o(this, c0);
            }
            else {
                o0.G = v ^ 0x80000000;
            }
        }
        else {
            o0 = new o(this, c0);
        }
        Object object0 = o0.D;
        a a0 = a.a;
        switch(o0.G) {
            case 0: {
                n.D(object0);
                o0.r = arrayList0;
                mutex0 = this.b;
                o0.w = mutex0;
                v1 = 0;
                o0.B = 0;
                o0.G = 1;
                if(mutex0.lock(null, o0) == a0) {
                    return a0;
                }
                goto label_29;
            }
            case 1: {
                int v2 = o0.B;
                Mutex mutex1 = o0.w;
                ArrayList arrayList1 = o0.r;
                n.D(object0);
                mutex0 = mutex1;
                v1 = v2;
                arrayList0 = arrayList1;
                try {
                label_29:
                    p p0 = new p(this, arrayList0, null);
                    o0.r = null;
                    o0.w = mutex0;
                    o0.B = v1;
                    o0.G = 2;
                    object1 = BuildersKt.withContext(Dispatchers.getIO(), p0, o0);
                }
                catch(Throwable throwable0) {
                    throwable1 = throwable0;
                    mutex2 = mutex0;
                    break;
                }
                if(object1 == a0) {
                    return a0;
                }
                object0 = object1;
                mutex2 = mutex0;
                goto label_47;
            }
            case 2: {
                try {
                    mutex2 = o0.w;
                    n.D(object0);
                label_47:
                    ((Number)object0).intValue();
                    goto label_52;
                }
                catch(Throwable throwable1) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable1;
    label_52:
        mutex2.unlock(null);
        return H.a;
    }
}

