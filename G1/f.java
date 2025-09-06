package G1;

import F1.c;
import F1.d;
import F1.i;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public final class f {
    public boolean a;
    public boolean b;
    public final Object c;
    public final Object d;
    public final Object e;
    public Object f;
    public Object g;
    public final Object h;

    public f(F1.f f0) {
        this.a = true;
        this.b = true;
        this.e = new ArrayList();
        new ArrayList();
        this.g = null;
        this.h = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.f = new ArrayList();
        this.c = f0;
        this.d = f0;
    }

    public f(e e0) {
        Boolean boolean1;
        Boolean boolean0;
        Object object0 = new Object();
        this.e = object0;
        this.f = new TaskCompletionSource();
        this.a = false;
        this.b = false;
        this.h = new TaskCompletionSource();
        e0.a();
        Context context0 = e0.a;
        this.d = e0;
        SharedPreferences sharedPreferences0 = context0.getSharedPreferences("com.google.firebase.crashlytics", 0);
        this.c = sharedPreferences0;
        if(sharedPreferences0.contains("firebase_crashlytics_collection_enabled")) {
            this.b = false;
            boolean0 = Boolean.valueOf(sharedPreferences0.getBoolean("firebase_crashlytics_collection_enabled", true));
        }
        else {
            boolean0 = null;
        }
        if(boolean0 == null) {
            try {
                PackageManager packageManager0 = context0.getPackageManager();
                if(packageManager0 == null) {
                    goto label_30;
                }
                else {
                    ApplicationInfo applicationInfo0 = packageManager0.getApplicationInfo("com.iloen.melon", 0x80);
                    boolean1 = applicationInfo0 == null || (applicationInfo0.metaData == null || !applicationInfo0.metaData.containsKey("firebase_crashlytics_collection_enabled")) ? null : Boolean.valueOf(applicationInfo0.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
                }
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                Log.e("FirebaseCrashlytics", "Could not read data collection permission from manifest", packageManager$NameNotFoundException0);
                boolean1 = null;
            }
            goto label_31;
        label_30:
            boolean1 = null;
        label_31:
            if(boolean1 == null) {
                this.b = false;
                boolean0 = null;
            }
            else {
                this.b = true;
                boolean0 = Boolean.valueOf(Boolean.TRUE.equals(boolean1));
            }
        }
        this.g = boolean0;
        synchronized(object0) {
            if(this.f()) {
                ((TaskCompletionSource)this.f).trySetResult(null);
                this.a = true;
            }
        }
    }

    public void a(g g0, int v, ArrayList arrayList0, m m0) {
        p p0 = g0.d;
        g g1 = p0.i;
        g g2 = p0.h;
        if(p0.c == null) {
            F1.f f0 = (F1.f)this.c;
            if(p0 != f0.d && p0 != f0.e) {
                if(m0 == null) {
                    m0 = new m();  // 初始化器: Ljava/lang/Object;-><init>()V
                    m0.a = null;
                    m0.b = new ArrayList();
                    m0.a = p0;
                    arrayList0.add(m0);
                }
                p0.c = m0;
                m0.b.add(p0);
                for(Object object0: g2.k) {
                    G1.e e0 = (G1.e)object0;
                    if(e0 instanceof g) {
                        this.a(((g)e0), v, arrayList0, m0);
                    }
                }
                for(Object object1: g1.k) {
                    G1.e e1 = (G1.e)object1;
                    if(e1 instanceof g) {
                        this.a(((g)e1), v, arrayList0, m0);
                    }
                }
                if(v == 1 && p0 instanceof n) {
                    for(Object object2: ((n)p0).k.k) {
                        G1.e e2 = (G1.e)object2;
                        if(e2 instanceof g) {
                            this.a(((g)e2), 1, arrayList0, m0);
                        }
                    }
                }
                for(Object object3: g2.l) {
                    this.a(((g)object3), v, arrayList0, m0);
                }
                for(Object object4: g1.l) {
                    this.a(((g)object4), v, arrayList0, m0);
                }
                if(v == 1 && p0 instanceof n) {
                    for(Object object5: ((n)p0).k.l) {
                        this.a(((g)object5), 1, arrayList0, m0);
                    }
                }
            }
        }
    }

    public void b(F1.f f0) {
        d d13;
        int v6;
        d d11;
        d d10;
        d d9;
        d d7;
        d d6;
        for(Object object0: f0.v0) {
            F1.e e0 = (F1.e)object0;
            d[] arr_d = e0.V;
            c[] arr_c = e0.S;
            c c0 = e0.N;
            c c1 = e0.L;
            c c2 = e0.M;
            c c3 = e0.K;
            d d0 = arr_d[0];
            d d1 = arr_d[1];
            if(e0.j0 == 8) {
                e0.a = true;
            }
            else {
                float f1 = e0.x;
                d d2 = d.c;
                if(Float.compare(f1, 1.0f) < 0 && d0 == d2) {
                    e0.s = 2;
                }
                float f2 = e0.A;
                if(f2 < 1.0f && d1 == d2) {
                    e0.t = 2;
                }
                d d3 = d.b;
                d d4 = d.a;
                if(Float.compare(e0.Z, 0.0f) > 0) {
                    if(d0 == d2 && (d1 == d3 || d1 == d4)) {
                        e0.s = 3;
                    }
                    else if(d1 == d2 && (d0 == d3 || d0 == d4)) {
                        e0.t = 3;
                    }
                    else if(d0 == d2 && d1 == d2) {
                        if(e0.s == 0) {
                            e0.s = 3;
                        }
                        if(e0.t == 0) {
                            e0.t = 3;
                        }
                    }
                }
                if(d0 == d2 && e0.s == 1 && (c3.f == null || c2.f == null)) {
                    d0 = d3;
                }
                if(d1 == d2 && e0.t == 1 && (c1.f == null || c0.f == null)) {
                    d1 = d3;
                }
                l l0 = e0.d;
                l0.d = d0;
                int v = e0.s;
                l0.a = v;
                e0.e.d = d1;
                int v1 = e0.t;
                e0.e.a = v1;
                d d5 = d.d;
                if(d0 != d5 && d0 != d4 && d0 != d3 || d1 != d5 && d1 != d4 && d1 != d3) {
                    if(d0 != d2 || d1 != d3 && d1 != d4) {
                        d6 = d1;
                        d7 = d3;
                    }
                    else if(v == 3) {
                        if(d1 == d3) {
                            this.h(e0, d3, 0, d3, 0);
                        }
                        int v2 = e0.m();
                        this.h(e0, d4, ((int)(((float)v2) * e0.Z + 0.5f)), d4, v2);
                        e0.d.e.d(e0.s());
                        e0.e.e.d(e0.m());
                        e0.a = true;
                        continue;
                    }
                    else if(v == 1) {
                        this.h(e0, d3, 0, d1, 0);
                        e0.d.e.m = e0.s();
                        continue;
                    }
                    else {
                        d7 = d3;
                        d6 = d1;
                        if(v == 2) {
                            d d8 = f0.V[0];
                            if(d8 == d4 || d8 == d5) {
                                this.h(e0, d4, ((int)(f1 * ((float)f0.s()) + 0.5f)), d6, e0.m());
                                e0.d.e.d(e0.s());
                                e0.e.e.d(e0.m());
                                e0.a = true;
                                continue;
                            }
                        }
                        else if(arr_c[0].f == null || arr_c[1].f == null) {
                            this.h(e0, d7, 0, d6, 0);
                            e0.d.e.d(e0.s());
                            e0.e.e.d(e0.m());
                            e0.a = true;
                            continue;
                        }
                    }
                    if(d6 != d2 || d0 != d7 && d0 != d4) {
                        d9 = d7;
                        d10 = d4;
                        d11 = d6;
                    }
                    else if(v1 == 3) {
                        if(d0 == d7) {
                            this.h(e0, d7, 0, d7, 0);
                        }
                        int v3 = e0.s();
                        this.h(e0, d4, v3, d4, ((int)(((float)v3) * (e0.a0 == -1 ? 1.0f / e0.Z : e0.Z) + 0.5f)));
                        e0.d.e.d(e0.s());
                        e0.e.e.d(e0.m());
                        e0.a = true;
                        continue;
                    }
                    else {
                        switch(v1) {
                            case 1: {
                                this.h(e0, d0, 0, d7, 0);
                                e0.e.e.m = e0.m();
                                continue;
                            }
                            case 2: {
                                d d12 = f0.V[1];
                                if(d12 != d4 && d12 != d5) {
                                    d11 = d6;
                                    d9 = d7;
                                    d10 = d4;
                                }
                                else {
                                    this.h(e0, d0, e0.s(), d4, ((int)(f2 * ((float)f0.m()) + 0.5f)));
                                    e0.d.e.d(e0.s());
                                    e0.e.e.d(e0.m());
                                    e0.a = true;
                                    continue;
                                }
                                break;
                            }
                            default: {
                                d10 = d4;
                                if(arr_c[2].f == null || arr_c[3].f == null) {
                                    this.h(e0, d7, 0, d6, 0);
                                    e0.d.e.d(e0.s());
                                    e0.e.e.d(e0.m());
                                    e0.a = true;
                                    continue;
                                }
                                else {
                                    d11 = d6;
                                    d9 = d7;
                                    break;
                                }
                                this.h(e0, d0, 0, d7, 0);
                                e0.e.e.m = e0.m();
                                continue;
                            }
                        }
                    }
                    if(d0 != d2 || d11 != d2) {
                        continue;
                    }
                    if(v == 1 || v1 == 1) {
                        this.h(e0, d9, 0, d9, 0);
                        e0.d.e.m = e0.s();
                        e0.e.e.m = e0.m();
                    }
                    else {
                        if(v1 != 2 || v != 2 || (f0.V[0] != d10 || f0.V[1] != d10)) {
                            continue;
                        }
                        this.h(e0, d10, ((int)(f1 * ((float)f0.s()) + 0.5f)), d10, ((int)(f2 * ((float)f0.m()) + 0.5f)));
                        e0.d.e.d(e0.s());
                        e0.e.e.d(e0.m());
                        e0.a = true;
                    }
                }
                else {
                    int v4 = e0.s();
                    if(d0 == d5) {
                        v4 = f0.s() - c3.g - c2.g;
                        d0 = d4;
                    }
                    int v5 = e0.m();
                    if(d1 == d5) {
                        v6 = f0.m() - c1.g - c0.g;
                        d13 = d4;
                    }
                    else {
                        v6 = v5;
                        d13 = d1;
                    }
                    this.h(e0, d0, v4, d13, v6);
                    e0.d.e.d(e0.s());
                    e0.e.e.d(e0.m());
                    e0.a = true;
                }
            }
        }
    }

    public void c() {
        F1.f f0 = (F1.f)this.c;
        ArrayList arrayList0 = (ArrayList)this.f;
        ArrayList arrayList1 = (ArrayList)this.e;
        arrayList1.clear();
        F1.f f1 = (F1.f)this.d;
        f1.d.f();
        f1.e.f();
        arrayList1.add(f1.d);
        arrayList1.add(f1.e);
        Collection collection0 = null;
        for(Object object0: f1.v0) {
            F1.e e0 = (F1.e)object0;
            if(e0 instanceof i) {
                j j0 = new j(e0);  // 初始化器: LG1/p;-><init>(LF1/e;)V
                e0.d.f();
                e0.e.f();
                j0.f = ((i)e0).z0;
                arrayList1.add(j0);
            }
            else {
                if(e0.z()) {
                    if(e0.b == null) {
                        e0.b = new G1.d(e0, 0);
                    }
                    if(collection0 == null) {
                        collection0 = new HashSet();
                    }
                    ((HashSet)collection0).add(e0.b);
                }
                else {
                    arrayList1.add(e0.d);
                }
                if(e0.A()) {
                    if(e0.c == null) {
                        e0.c = new G1.d(e0, 1);
                    }
                    if(collection0 == null) {
                        collection0 = new HashSet();
                    }
                    ((HashSet)collection0).add(e0.c);
                }
                else {
                    arrayList1.add(e0.e);
                }
                if(e0 instanceof F1.j) {
                    arrayList1.add(new k(e0));  // 初始化器: LG1/p;-><init>(LF1/e;)V
                }
            }
        }
        if(collection0 != null) {
            arrayList1.addAll(collection0);
        }
        for(Object object1: arrayList1) {
            ((p)object1).f();
        }
        for(Object object2: arrayList1) {
            p p0 = (p)object2;
            if(p0.b != f1) {
                p0.d();
            }
        }
        arrayList0.clear();
        this.e(f0.d, 0, arrayList0);
        this.e(f0.e, 1, arrayList0);
        this.a = false;
    }

    public int d(F1.f f0, int v) {
        long v12;
        float f1;
        ArrayList arrayList0 = (ArrayList)this.f;
        int v1 = arrayList0.size();
        int v2 = 0;
        long v3 = 0L;
        while(v2 < v1) {
            p p0 = ((m)arrayList0.get(v2)).a;
            if(p0 instanceof G1.d) {
                if(((G1.d)p0).f == v) {
                    goto label_13;
                }
                else {
                    goto label_57;
                }
                goto label_9;
            }
            else {
            label_9:
                if(v == 0) {
                    if(p0 instanceof l) {
                        goto label_13;
                    }
                    else {
                        goto label_57;
                    }
                    goto label_12;
                }
                else {
                label_12:
                    if(p0 instanceof n) {
                    label_13:
                        l l0 = v == 0 ? f0.d : f0.e;
                        g g0 = l0.h;
                        l l1 = v == 0 ? f0.d : f0.e;
                        g g1 = p0.h;
                        g g2 = p0.i;
                        boolean z = g1.l.contains(g0);
                        boolean z1 = g2.l.contains(l1.i);
                        long v4 = p0.j();
                        if(z && z1) {
                            long v5 = m.b(g1, 0L);
                            long v6 = m.a(g2, 0L);
                            long v7 = v5 - v4;
                            int v8 = g2.f;
                            if(v7 >= ((long)(-v8))) {
                                v7 += (long)v8;
                            }
                            long v9 = (long)g1.f;
                            long v10 = -v6 - v4 - v9;
                            F1.e e0 = p0.b;
                            if(v == 0) {
                                f1 = e0.g0;
                            }
                            else if(v == 1) {
                                f1 = e0.h0;
                            }
                            else {
                                e0.getClass();
                                f1 = -1.0f;
                            }
                            long v11 = Float.compare(f1, 0.0f) <= 0 ? 0L : ((long)(((float)v7) / (1.0f - f1) + ((float)(v10 < v9 ? -v6 - v4 - v9 : v10 - v9)) / f1));
                            v12 = ((long)g1.f) + (((long)(((float)v11) * f1 + 0.5f)) + v4 + ((long)((1.0f - f1) * ((float)v11) + 0.5f))) - ((long)g2.f);
                        }
                        else if(z) {
                            v12 = Math.max(m.b(g1, ((long)g1.f)), ((long)g1.f) + v4);
                        }
                        else if(z1) {
                            v12 = Math.max(-m.a(g2, ((long)g2.f)), ((long)(-g2.f)) + v4);
                        }
                        else {
                            long v13 = (long)g1.f;
                            v12 = p0.j() + v13 - ((long)g2.f);
                        }
                        goto label_58;
                    }
                }
            }
        label_57:
            v12 = 0L;
        label_58:
            v3 = Math.max(v3, v12);
            ++v2;
        }
        return (int)v3;
    }

    public void e(p p0, int v, ArrayList arrayList0) {
        g g0 = p0.i;
        for(Object object0: p0.h.k) {
            G1.e e0 = (G1.e)object0;
            if(e0 instanceof g) {
                this.a(((g)e0), v, arrayList0, null);
            }
            else if(e0 instanceof p) {
                this.a(((p)e0).h, v, arrayList0, null);
            }
        }
        for(Object object1: g0.k) {
            G1.e e1 = (G1.e)object1;
            if(e1 instanceof g) {
                this.a(((g)e1), v, arrayList0, null);
            }
            else if(e1 instanceof p) {
                this.a(((p)e1).i, v, arrayList0, null);
            }
        }
        if(v == 1) {
            for(Object object2: ((n)p0).k.k) {
                G1.e e2 = (G1.e)object2;
                if(e2 instanceof g) {
                    this.a(((g)e2), 1, arrayList0, null);
                }
            }
        }
    }

    public boolean f() {
        boolean z;
        synchronized(this) {
            Boolean boolean0 = (Boolean)this.g;
            if(boolean0 == null) {
                try {
                    z = false;
                    z = ((e)this.d).h();
                }
                catch(IllegalStateException unused_ex) {
                }
            }
            else {
                z = boolean0.booleanValue();
            }
            this.g(z);
            return z;
        }
    }

    public void g(boolean z) {
        String s;
        if(((Boolean)this.g) == null) {
            s = "global Firebase setting";
        }
        else {
            s = this.b ? "firebase_crashlytics_collection_enabled manifest flag" : "API";
        }
        if(Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Crashlytics automatic data collection " + (z ? "ENABLED" : "DISABLED") + " by " + s + ".", null);
        }
    }

    public void h(F1.e e0, d d0, int v, d d1, int v1) {
        ((b)this.h).a = d0;
        ((b)this.h).b = d1;
        ((b)this.h).c = v;
        ((b)this.h).d = v1;
        ((G1.c)this.g).b(e0, ((b)this.h));
        e0.T(((b)this.h).e);
        e0.O(((b)this.h).f);
        e0.F = ((b)this.h).h;
        e0.K(((b)this.h).g);
    }

    public void i() {
        for(Object object0: ((F1.f)this.c).v0) {
            F1.e e0 = (F1.e)object0;
            if(!e0.a) {
                d[] arr_d = e0.V;
                boolean z = false;
                d d0 = arr_d[0];
                d d1 = arr_d[1];
                d d2 = d.c;
                d d3 = d.b;
                boolean z1 = d0 == d3 || d0 == d2 && e0.s == 1;
                if(d1 == d3 || d1 == d2 && e0.t == 1) {
                    z = true;
                }
                h h0 = e0.d.e;
                boolean z2 = h0.j;
                h h1 = e0.e.e;
                boolean z3 = h1.j;
                d d4 = d.a;
                if(z2 && z3) {
                    this.h(e0, d4, h0.g, d4, h1.g);
                    e0.a = true;
                }
                else if(z2 && z) {
                    this.h(e0, d4, h0.g, d3, h1.g);
                    if(d1 == d2) {
                        e0.e.e.m = e0.m();
                    }
                    else {
                        e0.e.e.d(e0.m());
                        e0.a = true;
                    }
                }
                else if(z3 && z1) {
                    this.h(e0, d3, h0.g, d4, h1.g);
                    if(d0 == d2) {
                        e0.d.e.m = e0.s();
                    }
                    else {
                        e0.d.e.d(e0.s());
                        e0.a = true;
                    }
                }
                if(e0.a) {
                    a a0 = e0.e.l;
                    if(a0 != null) {
                        a0.d(e0.d0);
                    }
                }
            }
        }
    }
}

