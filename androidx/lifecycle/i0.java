package androidx.lifecycle;

import De.d;
import E4.e;
import E4.g;
import S2.c;
import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.q;

public final class i0 implements o0 {
    public final Application a;
    public final n0 b;
    public final Bundle c;
    public final t d;
    public final e e;

    public i0(Application application0, g g0, Bundle bundle0) {
        n0 n00;
        this.e = g0.getSavedStateRegistry();
        this.d = g0.getLifecycle();
        this.c = bundle0;
        this.a = application0;
        if(application0 == null) {
            n00 = new n0(null, 0);
        }
        else {
            if(n0.c == null) {
                n0.c = new n0(application0);
            }
            n00 = n0.c;
            q.d(n00);
        }
        this.b = n00;
    }

    public final m0 a(Class class0, String s) {
        c0 c00;
        q.g(class0, "modelClass");
        t t0 = this.d;
        if(t0 == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean z = a.class.isAssignableFrom(class0);
        Application application0 = this.a;
        Constructor constructor0 = !z || application0 == null ? j0.a(class0, j0.b) : j0.a(class0, j0.a);
        if(constructor0 == null) {
            if(application0 != null) {
                return this.b.create(class0);
            }
            if(p0.a == null) {
                p0.a = new p0();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
            q.d(p0.a);
            return P4.a.n(class0);
        }
        e e0 = this.e;
        q.d(e0);
        Bundle bundle0 = e0.a(s);
        if(bundle0 == null) {
            bundle0 = this.c;
        }
        if(bundle0 == null) {
            c00 = new c0();
        }
        else {
            ClassLoader classLoader0 = c0.class.getClassLoader();
            q.d(classLoader0);
            bundle0.setClassLoader(classLoader0);
            ke.e e1 = new ke.e(bundle0.size());
            for(Object object0: bundle0.keySet()) {
                q.d(((String)object0));
                e1.put(((String)object0), bundle0.get(((String)object0)));
            }
            c00 = new c0(e1.b());
        }
        d0 d00 = new d0(s, c00);
        d00.f(e0, t0);
        s s1 = t0.b();
        if(s1 == s.b || s1.compareTo(s.d) >= 0) {
            e0.d();
        }
        else {
            t0.a(new h(1, t0, e0));
        }
        m0 m00 = !z || application0 == null ? j0.b(class0, constructor0, new Object[]{c00}) : j0.b(class0, constructor0, new Object[]{application0, c00});
        m00.addCloseable("androidx.lifecycle.savedstate.vm.tag", d00);
        return m00;
    }

    @Override  // androidx.lifecycle.o0
    public final m0 create(d d0, c c0) {
        q.g(d0, "modelClass");
        return this.create(df.d.v(d0), c0);
    }

    @Override  // androidx.lifecycle.o0
    public final m0 create(Class class0) {
        q.g(class0, "modelClass");
        String s = class0.getCanonicalName();
        if(s == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return this.a(class0, s);
    }

    @Override  // androidx.lifecycle.o0
    public final m0 create(Class class0, c c0) {
        q.g(c0, "extras");
        String s = (String)c0.a(f0.e);
        if(s == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if(c0.a(f0.a) != null && c0.a(f0.b) != null) {
            Application application0 = (Application)c0.a(n0.d);
            boolean z = a.class.isAssignableFrom(class0);
            Constructor constructor0 = !z || application0 == null ? j0.a(class0, j0.b) : j0.a(class0, j0.a);
            if(constructor0 == null) {
                return this.b.create(class0, c0);
            }
            return !z || application0 == null ? j0.b(class0, constructor0, new Object[]{f0.b(c0)}) : j0.b(class0, constructor0, new Object[]{application0, f0.b(c0)});
        }
        if(this.d == null) {
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        return this.a(class0, s);
    }
}

