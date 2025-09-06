package M2;

import android.content.Context;
import d5.n;
import ie.H;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import l2.i;
import oe.c;

public final class f implements a {
    public static final f a;
    public static final Mutex b;
    public static final LinkedHashMap c;

    static {
        f.a = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        f.b = MutexKt.Mutex$default(false, 1, null);
        f.c = new LinkedHashMap();
    }

    public final Object a(Context context0, g g0, String s, c c0) {
        Mutex mutex0;
        b b0;
        if(c0 instanceof b) {
            b0 = (b)c0;
            int v = b0.I;
            if((v & 0x80000000) == 0) {
                b0 = new b(this, c0);
            }
            else {
                b0.I = v ^ 0x80000000;
            }
        }
        else {
            b0 = new b(this, c0);
        }
        Object object0 = b0.E;
        ne.a a0 = ne.a.a;
        switch(b0.I) {
            case 0: {
                n.D(object0);
                b0.r = context0;
                b0.w = g0;
                b0.B = s;
                mutex0 = f.b;
                b0.D = mutex0;
                b0.I = 1;
                if(mutex0.lock(null, b0) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                Mutex mutex1 = b0.D;
                s = b0.B;
                g0 = b0.w;
                Context context1 = b0.r;
                n.D(object0);
                mutex0 = mutex1;
                context0 = context1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            f.c.remove(s);
            g0.a(context0, s).delete();
            return H.a;
        }
        finally {
            mutex0.unlock(null);
        }
    }

    public final Object b(Context context0, g g0, String s, c c0) {
        Mutex mutex2;
        Object object1;
        i i0;
        LinkedHashMap linkedHashMap0;
        Mutex mutex0;
        M2.c c1;
        if(c0 instanceof M2.c) {
            c1 = (M2.c)c0;
            int v = c1.I;
            if((v & 0x80000000) == 0) {
                c1 = new M2.c(this, c0);
            }
            else {
                c1.I = v ^ 0x80000000;
            }
        }
        else {
            c1 = new M2.c(this, c0);
        }
        Object object0 = c1.E;
        ne.a a0 = ne.a.a;
        switch(c1.I) {
            case 0: {
                n.D(object0);
                c1.r = context0;
                c1.w = g0;
                c1.B = s;
                mutex0 = f.b;
                c1.D = mutex0;
                c1.I = 1;
                if(mutex0.lock(null, c1) == a0) {
                    return a0;
                }
                goto label_29;
            }
            case 1: {
                Mutex mutex1 = c1.D;
                s = (String)c1.B;
                g0 = (g)c1.w;
                Context context1 = (Context)c1.r;
                n.D(object0);
                mutex0 = mutex1;
                context0 = context1;
                try {
                label_29:
                    linkedHashMap0 = f.c;
                    i0 = linkedHashMap0.get(s);
                    if(i0 == null) {
                        c1.r = s;
                        c1.w = mutex0;
                        c1.B = linkedHashMap0;
                        c1.D = null;
                        c1.I = 2;
                        object1 = g0.b(context0, s);
                        goto label_42;
                    }
                    else {
                        mutex2 = mutex0;
                    }
                    goto label_56;
                }
                catch(Throwable throwable0) {
                    try {
                        mutex2 = mutex0;
                        break;
                    label_42:
                        if(object1 == a0) {
                            return a0;
                        }
                        mutex2 = mutex0;
                        i0 = (i)object1;
                        linkedHashMap0.put(s, i0);
                        goto label_56;
                    }
                    catch(Throwable throwable0) {
                        break;
                    }
                }
            }
            case 2: {
                Map map0 = (Map)c1.B;
                mutex2 = (Mutex)c1.w;
                s = (String)c1.r;
                try {
                    n.D(object0);
                    i0 = (i)object0;
                    map0.put(s, i0);
                label_56:
                    q.e(i0, "null cannot be cast to non-null type androidx.datastore.core.DataStore<T of androidx.glance.state.GlanceState.getDataStore$lambda$2>");
                    goto label_61;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable0;
    label_61:
        mutex2.unlock(null);
        return i0;
    }

    public final Object c(Context context0, g g0, String s, c c0) {
        d d0;
        if(c0 instanceof d) {
            d0 = (d)c0;
            int v = d0.B;
            if((v & 0x80000000) == 0) {
                d0 = new d(this, c0);
            }
            else {
                d0.B = v ^ 0x80000000;
            }
        }
        else {
            d0 = new d(this, c0);
        }
        Object object0 = d0.r;
        ne.a a0 = ne.a.a;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                d0.B = 1;
                object0 = this.b(context0, g0, s, d0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Flow flow0 = ((i)object0).getData();
        d0.B = 2;
        Object object1 = FlowKt.first(flow0, d0);
        return object1 == a0 ? a0 : object1;
    }

    public final Object d(Context context0, g g0, String s, we.n n0, c c0) {
        e e0;
        if(c0 instanceof e) {
            e0 = (e)c0;
            int v = e0.D;
            if((v & 0x80000000) == 0) {
                e0 = new e(this, c0);
            }
            else {
                e0.D = v ^ 0x80000000;
            }
        }
        else {
            e0 = new e(this, c0);
        }
        Object object0 = e0.w;
        ne.a a0 = ne.a.a;
        switch(e0.D) {
            case 0: {
                n.D(object0);
                e0.r = (oe.i)n0;
                e0.D = 1;
                object0 = this.b(context0, g0, s, e0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n0 = (we.n)e0.r;
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        e0.r = null;
        e0.D = 2;
        Object object1 = ((i)object0).a(n0, e0);
        return object1 == a0 ? a0 : object1;
    }
}

