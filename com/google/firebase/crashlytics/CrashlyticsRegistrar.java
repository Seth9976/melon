package com.google.firebase.crashlytics;

import Ac.X3;
import N7.a;
import N7.c;
import N7.d;
import X6.b;
import Y6.k;
import Y6.s;
import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.e;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlinx.coroutines.sync.MutexKt;

public class CrashlyticsRegistrar implements ComponentRegistrar {
    public final s a;
    public final s b;
    public final s c;
    public static final int d;

    static {
        Map map0 = c.b;
        d d0 = d.a;
        if(map0.containsKey(d0)) {
            Log.d("SessionsDependencies", "Dependency " + d0 + " already added.");
            return;
        }
        map0.put(d0, new a(MutexKt.Mutex(true)));
        Log.d("SessionsDependencies", "Dependency to " + d0 + " added.");
    }

    public CrashlyticsRegistrar() {
        this.a = new s(X6.a.class, ExecutorService.class);
        this.b = new s(b.class, ExecutorService.class);
        this.c = new s(X6.c.class, ExecutorService.class);
    }

    @Override  // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        Y6.b b0 = Y6.c.b(a7.c.class);
        b0.a = "fire-cls";
        b0.a(k.b(e.class));
        b0.a(k.b(z7.d.class));
        b0.a(new k(this.a, 1, 0));
        b0.a(new k(this.b, 1, 0));
        b0.a(new k(this.c, 1, 0));
        b0.a(new k(0, 2, b7.a.class));
        b0.a(new k(0, 2, V6.b.class));
        b0.a(new k(0, 2, K7.a.class));
        b0.g = new X3(this, 24);
        b0.c(2);
        return Arrays.asList(new Y6.c[]{b0.b(), x1.a.q("fire-cls", "19.4.4")});
    }
}

