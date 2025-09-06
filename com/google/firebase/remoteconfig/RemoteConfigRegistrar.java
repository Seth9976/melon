package com.google.firebase.remoteconfig;

import H7.m;
import H7.n;
import K7.a;
import X6.b;
import Y6.c;
import Y6.k;
import Y6.s;
import Y6.u;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.e;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import z7.d;

@Keep
public class RemoteConfigRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-rc";

    public static m a(s s0, u u0) {
        return RemoteConfigRegistrar.lambda$getComponents$0(s0, u0);
    }

    @Override  // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        s s0 = new s(b.class, ScheduledExecutorService.class);
        Y6.b b0 = new Y6.b(m.class, new Class[]{a.class});
        b0.a = "fire-rc";
        b0.a(k.b(Context.class));
        b0.a(new k(s0, 1, 0));
        b0.a(k.b(e.class));
        b0.a(k.b(d.class));
        b0.a(k.b(T6.a.class));
        b0.a(new k(0, 1, V6.b.class));
        b0.g = new n(s0, 0);
        b0.c(2);
        return Arrays.asList(new c[]{b0.b(), x1.a.q("fire-rc", "22.1.2")});
    }

    private static m lambda$getComponents$0(s s0, Y6.d d0) {
        S6.c c1;
        Context context0 = (Context)d0.get(Context.class);
        Object object0 = d0.d(s0);
        Object object1 = d0.get(e.class);
        Object object2 = d0.get(d.class);
        T6.a a0 = (T6.a)d0.get(T6.a.class);
        synchronized(a0) {
            if(!a0.a.containsKey("frc")) {
                S6.c c0 = new S6.c(a0.b);
                a0.a.put("frc", c0);
            }
            c1 = (S6.c)a0.a.get("frc");
        }
        return new m(context0, ((ScheduledExecutorService)object0), ((e)object1), ((d)object2), c1, d0.b(V6.b.class));
    }
}

