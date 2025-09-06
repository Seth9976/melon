package androidx.lifecycle;

import E4.b;
import E4.e;
import E4.g;
import R6.c;
import R6.d;
import S2.a;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import d5.f;
import d5.w;
import ie.H;
import ie.l;
import ie.m;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import me.j;

public abstract class f0 {
    public static final c a;
    public static final d b;
    public static final c c;
    public static final T2.c d;
    public static final c e;

    static {
        f0.a = new c(16);
        f0.b = new d(16);
        f0.c = new c(17);
        f0.d = new T2.c();  // 初始化器: Ljava/lang/Object;-><init>()V
        f0.e = new c(18);
    }

    public static final void a(m0 m00, e e0, t t0) {
        q.g(e0, "registry");
        q.g(t0, "lifecycle");
        d0 d00 = (d0)m00.getCloseable("androidx.lifecycle.savedstate.vm.tag");
        if(d00 != null && !d00.c) {
            d00.f(e0, t0);
            s s0 = t0.b();
            if(s0 != s.b && s0.compareTo(s.d) < 0) {
                t0.a(new h(1, t0, e0));
                return;
            }
            e0.d();
        }
    }

    public static final c0 b(S2.c c0) {
        c0 c01;
        q.g(c0, "<this>");
        g g0 = (g)c0.a(f0.a);
        if(g0 == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        r0 r00 = (r0)c0.a(f0.b);
        if(r00 == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle0 = (Bundle)c0.a(f0.c);
        String s = (String)c0.a(f0.e);
        if(s == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        E4.d d0 = g0.getSavedStateRegistry().b();
        Bundle bundle1 = null;
        g0 g00 = d0 instanceof g0 ? ((g0)d0) : null;
        if(g00 == null) {
            throw new IllegalStateException("enableSavedStateHandles() wasn\'t called prior to createSavedStateHandle() call");
        }
        LinkedHashMap linkedHashMap0 = f0.g(r00).a;
        c0 c00 = (c0)linkedHashMap0.get(s);
        if(c00 == null) {
            g00.b();
            Bundle bundle2 = g00.c;
            if(bundle2 != null && bundle2.containsKey(s)) {
                Bundle bundle3 = bundle2.getBundle(s);
                if(bundle3 == null) {
                    bundle3 = f.j(((m[])Arrays.copyOf(new m[0], 0)));
                }
                bundle2.remove(s);
                if(bundle2.isEmpty()) {
                    g00.c = null;
                }
                bundle1 = bundle3;
            }
            if(bundle1 != null) {
                bundle0 = bundle1;
            }
            if(bundle0 == null) {
                c01 = new c0();
            }
            else {
                ClassLoader classLoader0 = c0.class.getClassLoader();
                q.d(classLoader0);
                bundle0.setClassLoader(classLoader0);
                ke.e e0 = new ke.e(bundle0.size());
                for(Object object0: bundle0.keySet()) {
                    q.d(((String)object0));
                    e0.put(((String)object0), bundle0.get(((String)object0)));
                }
                c01 = new c0(e0.b());
            }
            linkedHashMap0.put(s, c01);
            return c01;
        }
        return c00;
    }

    public static final void c(g g0) {
        s s0 = g0.getLifecycle().b();
        if(s0 != s.b && s0 != s.c) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if(g0.getSavedStateRegistry().b() == null) {
            g0 g00 = new g0(g0.getSavedStateRegistry(), ((r0)g0));
            g0.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", g00);
            g0.getLifecycle().a(new b(g00, 2));
        }
    }

    public static final D d(View view0) {
        q.g(view0, "<this>");
        while(view0 != null) {
            Object object0 = view0.getTag(0x7F0A0DD1);  // id:view_tree_lifecycle_owner
            D d0 = object0 instanceof D ? ((D)object0) : null;
            if(d0 != null) {
                return d0;
            }
            ViewParent viewParent0 = w.C(view0);
            view0 = viewParent0 instanceof View ? ((View)viewParent0) : null;
        }
        return null;
    }

    public static final r0 e(View view0) {
        q.g(view0, "<this>");
        while(view0 != null) {
            Object object0 = view0.getTag(0x7F0A0DD4);  // id:view_tree_view_model_store_owner
            r0 r00 = object0 instanceof r0 ? ((r0)object0) : null;
            if(r00 != null) {
                return r00;
            }
            ViewParent viewParent0 = w.C(view0);
            view0 = viewParent0 instanceof View ? ((View)viewParent0) : null;
        }
        return null;
    }

    public static final y f(D d0) {
        q.g(d0, "<this>");
        t t0 = d0.getLifecycle();
        q.g(t0, "<this>");
        androidx.lifecycle.b b0 = t0.a;
        while(true) {
            y y0 = (y)((AtomicReference)b0.b).get();
            if(y0 != null) {
                return y0;
            }
            y y1 = new y(t0, SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
            AtomicReference atomicReference0 = (AtomicReference)b0.b;
            do {
                if(atomicReference0.compareAndSet(null, y1)) {
                    BuildersKt__Builders_commonKt.launch$default(y1, Dispatchers.getMain().getImmediate(), null, new x(y1, null), 2, null);
                    return y1;
                }
            }
            while(atomicReference0.get() == null);
        }
    }

    public static final h0 g(r0 r00) {
        e0 e00 = new e0();  // 初始化器: Ljava/lang/Object;-><init>()V
        S2.c c0 = r00 instanceof n ? ((n)r00).getDefaultViewModelCreationExtras() : a.b;
        q.g(c0, "extras");
        q0 q00 = r00.getViewModelStore();
        q.g(q00, "store");
        return (h0)new o9.b(q00, e00, c0).s(I.a.b(h0.class), "androidx.lifecycle.internal.SavedStateHandlesVM");
    }

    public static final T2.a h(m0 m00) {
        j j0;
        q.g(m00, "<this>");
        synchronized(f0.d) {
            T2.a a0 = (T2.a)m00.getCloseable("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY");
            if(a0 == null) {
                try {
                    j0 = j.a;
                    j0 = Dispatchers.getMain().getImmediate();
                }
                catch(l | IllegalStateException unused_ex) {
                }
                T2.a a1 = new T2.a(j0.plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
                m00.addCloseable("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", a1);
                a0 = a1;
            }
            return a0;
        }
    }

    public static final Object i(t t0, s s0, we.n n0, Continuation continuation0) {
        if(s0 == s.b) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
        }
        if(t0.b() != s.a) {
            Object object0 = CoroutineScopeKt.coroutineScope(new Y(t0, s0, n0, null), continuation0);
            if(object0 == ne.a.a) {
                return object0;
            }
        }
        return H.a;
    }

    public static final Object j(D d0, s s0, we.n n0, Continuation continuation0) {
        Object object0 = f0.i(d0.getLifecycle(), s0, n0, continuation0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    public static final void k(View view0, D d0) {
        q.g(view0, "<this>");
        view0.setTag(0x7F0A0DD1, d0);  // id:view_tree_lifecycle_owner
    }

    public static final void l(View view0, r0 r00) {
        q.g(view0, "<this>");
        view0.setTag(0x7F0A0DD4, r00);  // id:view_tree_view_model_store_owner
    }
}

