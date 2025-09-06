package com.google.firebase.installations;

import X6.a;
import Y6.b;
import Y6.c;
import Y6.k;
import Y6.s;
import Z6.i;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.e;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import t9.B;
import z7.d;

@Keep
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    @Override  // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        b b0 = c.b(d.class);
        b0.a = "fire-installations";
        b0.a(k.b(e.class));
        b0.a(new k(0, 1, w7.e.class));
        b0.a(new k(new s(a.class, ExecutorService.class), 1, 0));
        b0.a(new k(new s(X6.b.class, Executor.class), 1, 0));
        b0.g = new B(13);
        c c0 = b0.b();
        w7.d d0 = new w7.d(0);
        b b1 = c.b(w7.d.class);
        b1.c = 1;
        b1.g = new Y6.a(d0);
        return Arrays.asList(new c[]{c0, b1.b(), x1.a.q("fire-installations", "18.0.0")});
    }

    private static d lambda$getComponents$0(Y6.d d0) {
        return new z7.c(((e)d0.get(e.class)), d0.b(w7.e.class), ((ExecutorService)d0.d(new s(a.class, ExecutorService.class))), new i(((Executor)d0.d(new s(X6.b.class, Executor.class)))));
    }
}

