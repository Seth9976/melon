package androidx.lifecycle;

import E4.b;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import m.a;
import m.c;
import m.d;

public final class F extends t {
    public final boolean b;
    public a c;
    public s d;
    public final WeakReference e;
    public int f;
    public boolean g;
    public boolean h;
    public final ArrayList i;
    public final MutableStateFlow j;

    public F(D d0) {
        q.g(d0, "provider");
        this(d0, true);
    }

    public F(D d0, boolean z) {
        this.b = z;
        this.c = new a();
        this.d = s.b;
        this.i = new ArrayList();
        this.e = new WeakReference(d0);
        this.j = StateFlowKt.MutableStateFlow(s.b);
    }

    @Override  // androidx.lifecycle.t
    public final void a(C c0) {
        r r0;
        Object object1;
        B b0;
        q.g(c0, "observer");
        this.e("addObserver");
        s s0 = this.d == s.a ? s.a : s.b;
        E e0 = new E();  // 初始化器: Ljava/lang/Object;-><init>()V
        boolean z = false;
        if(c0 instanceof B && c0 instanceof f) {
            b0 = new h(((f)c0), ((B)c0));
        }
        else if(c0 instanceof f) {
            b0 = new h(((f)c0), null);
        }
        else if(c0 instanceof B) {
            b0 = (B)c0;
        }
        else {
            Class class0 = c0.getClass();
            if(G.b(class0) == 2) {
                Object object0 = G.b.get(class0);
                q.d(object0);
                if(((List)object0).size() != 1) {
                    int v = ((List)object0).size();
                    m[] arr_m = new m[v];
                    if(v <= 0) {
                        b0 = new b(arr_m, 1);
                        goto label_29;
                    }
                    G.a(((Constructor)((List)object0).get(0)), c0);
                    throw null;
                }
                G.a(((Constructor)((List)object0).get(0)), c0);
                throw null;
            }
            else {
                b0 = new h(c0);
            }
        }
    label_29:
        e0.b = b0;
        e0.a = s0;
        a a0 = this.c;
        c c1 = a0.a(c0);
        if(c1 == null) {
            HashMap hashMap0 = a0.e;
            c c2 = new c(c0, e0);
            ++a0.d;
            c c3 = a0.b;
            if(c3 == null) {
                a0.a = c2;
            }
            else {
                c3.c = c2;
                c2.d = c3;
            }
            a0.b = c2;
            hashMap0.put(c0, c2);
            object1 = null;
        }
        else {
            object1 = c1.b;
        }
        if(((E)object1) == null) {
            D d0 = (D)this.e.get();
            if(d0 != null) {
                if(this.f != 0 || this.g) {
                    z = true;
                }
                s s1 = this.d(c0);
                ++this.f;
                while(e0.a.compareTo(s1) < 0 && this.c.e.containsKey(c0)) {
                    ArrayList arrayList0 = this.i;
                    arrayList0.add(e0.a);
                    s s2 = e0.a;
                    r.Companion.getClass();
                    q.g(s2, "state");
                    int v1 = s2.ordinal();
                    switch(v1) {
                        case 1: {
                            r0 = r.ON_CREATE;
                            break;
                        }
                        case 2: {
                            r0 = r.ON_START;
                            break;
                        }
                        default: {
                            r0 = v1 == 3 ? r.ON_RESUME : null;
                        }
                    }
                    if(r0 == null) {
                        throw new IllegalStateException("no event up from " + e0.a);
                    }
                    e0.a(d0, r0);
                    arrayList0.remove(arrayList0.size() - 1);
                    s1 = this.d(c0);
                }
                if(!z) {
                    this.i();
                }
                --this.f;
            }
        }
    }

    @Override  // androidx.lifecycle.t
    public final s b() {
        return this.d;
    }

    @Override  // androidx.lifecycle.t
    public final void c(C c0) {
        q.g(c0, "observer");
        this.e("removeObserver");
        this.c.b(c0);
    }

    public final s d(C c0) {
        HashMap hashMap0 = this.c.e;
        s s0 = null;
        c c1 = hashMap0.containsKey(c0) ? ((c)hashMap0.get(c0)).d : null;
        s s1 = c1 == null ? null : ((E)c1.b).a;
        ArrayList arrayList0 = this.i;
        if(!arrayList0.isEmpty()) {
            s0 = (s)com.iloen.melon.utils.a.i(1, arrayList0);
        }
        s s2 = this.d;
        q.g(s2, "state1");
        if(s1 == null || s1.compareTo(s2) >= 0) {
            s1 = s2;
        }
        return s0 == null || s0.compareTo(s1) >= 0 ? s1 : s0;
    }

    public final void e(String s) {
        if(this.b) {
            l.b.P().g.getClass();
            if(Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(("Method " + s + " must be called on the main thread").toString());
            }
        }
    }

    public final void f(r r0) {
        q.g(r0, "event");
        this.e("handleLifecycleEvent");
        this.g(r0.a());
    }

    public final void g(s s0) {
        if(this.d != s0) {
            D d0 = (D)this.e.get();
            s s1 = this.d;
            q.g(s1, "current");
            q.g(s0, "next");
            if(s1 == s.b && s0 == s.a) {
                throw new IllegalStateException(("State must be at least \'" + s.c + "\' to be moved to \'" + s0 + "\' in component " + d0).toString());
            }
            s s2 = s.a;
            if(s1 == s2 && s1 != s0) {
                throw new IllegalStateException(("State is \'" + s2 + "\' and cannot be moved to `" + s0 + "` in component " + d0).toString());
            }
            this.d = s0;
            if(this.g || this.f != 0) {
                this.h = true;
                return;
            }
            this.g = true;
            this.i();
            this.g = false;
            if(this.d == s2) {
                this.c = new a();
            }
        }
    }

    public final void h(s s0) {
        q.g(s0, "state");
        this.e("setCurrentState");
        this.g(s0);
    }

    public final void i() {
        r r1;
        d d1;
        D d0 = (D)this.e.get();
        if(d0 == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
    alab1:
        while(true) {
            while(true) {
                a a0 = this.c;
                if(a0.d == 0) {
                    break alab1;
                }
                c c0 = a0.a;
                q.d(c0);
                s s0 = ((E)c0.b).a;
                c c1 = this.c.b;
                q.d(c1);
                s s1 = ((E)c1.b).a;
                if(s0 == s1 && this.d == s1) {
                    break alab1;
                }
                this.h = false;
                s s2 = this.d;
                c c2 = this.c.a;
                q.d(c2);
                if(s2.compareTo(((E)c2.b).a) < 0) {
                    a a1 = this.c;
                    m.b b0 = new m.b(a1.b, a1.a, 1);
                    a1.c.put(b0, Boolean.FALSE);
                    while(b0.hasNext() && !this.h) {
                        Map.Entry map$Entry0 = (Map.Entry)b0.next();
                        q.d(map$Entry0);
                        C c3 = (C)map$Entry0.getKey();
                        E e0 = (E)map$Entry0.getValue();
                        while(e0.a.compareTo(this.d) > 0 && !this.h && this.c.e.containsKey(c3)) {
                            s s3 = e0.a;
                            r.Companion.getClass();
                            r r0 = p.a(s3);
                            if(r0 == null) {
                                throw new IllegalStateException("no event down from " + e0.a);
                            }
                            s s4 = r0.a();
                            this.i.add(s4);
                            e0.a(d0, r0);
                            this.i.remove(this.i.size() - 1);
                        }
                    }
                }
                c c4 = this.c.b;
                if(!this.h && c4 != null && this.d.compareTo(((E)c4.b).a) > 0) {
                    a a2 = this.c;
                    a2.getClass();
                    d1 = new d(a2);
                    a2.c.put(d1, Boolean.FALSE);
                label_42:
                    if(!d1.hasNext() || this.h) {
                        continue;
                    }
                    break;
                }
            }
            Map.Entry map$Entry1 = (Map.Entry)d1.next();
            C c5 = (C)map$Entry1.getKey();
            E e1 = (E)map$Entry1.getValue();
            while(true) {
                if(e1.a.compareTo(this.d) >= 0 || this.h || !this.c.e.containsKey(c5)) {
                    goto label_42;
                }
                this.i.add(e1.a);
                s s5 = e1.a;
                r.Companion.getClass();
                q.g(s5, "state");
                switch(s5.ordinal()) {
                    case 1: {
                        r1 = r.ON_CREATE;
                        break;
                    }
                    case 2: {
                        r1 = r.ON_START;
                        break;
                    }
                    case 3: {
                        r1 = r.ON_RESUME;
                        break;
                    }
                    default: {
                        r1 = null;
                    }
                }
                if(r1 == null) {
                    break;
                }
                e1.a(d0, r1);
                this.i.remove(this.i.size() - 1);
            }
            throw new IllegalStateException("no event up from " + e1.a);
        }
        this.h = false;
        this.j.setValue(this.d);
    }
}

