package com.google.firebase.messaging;

import N5.g;
import Y6.c;
import Y6.k;
import Y6.s;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.e;
import java.util.Arrays;
import java.util.List;
import p7.b;
import w7.f;
import x7.a;
import z7.d;

@Keep
@KeepForSdk
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    @Override  // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List getComponents() {
        s s0 = new s(b.class, g.class);
        Y6.b b0 = c.b(FirebaseMessaging.class);
        b0.a = "fire-fcm";
        b0.a(k.b(e.class));
        b0.a(new k(0, 0, a.class));
        b0.a(new k(0, 1, G7.b.class));
        b0.a(new k(0, 1, f.class));
        b0.a(k.b(d.class));
        b0.a(new k(s0, 0, 1));
        b0.a(k.b(v7.c.class));
        b0.g = new q(s0, 0);
        b0.c(1);
        return Arrays.asList(new c[]{b0.b(), x1.a.q("fire-fcm", "24.1.2")});
    }

    private static FirebaseMessaging lambda$getComponents$0(s s0, Y6.d d0) {
        e e0 = (e)d0.get(e.class);
        if(d0.get(a.class) != null) {
            throw new ClassCastException();
        }
        return new FirebaseMessaging(e0, d0.b(G7.b.class), d0.b(f.class), ((d)d0.get(d.class)), d0.c(s0), ((v7.c)d0.get(v7.c.class)));
    }
}

