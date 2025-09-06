package com.google.firebase.datatransport;

import N5.g;
import Y6.b;
import Y6.c;
import Y6.k;
import Y6.s;
import Y6.u;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import i3.d;
import java.util.Arrays;
import java.util.List;
import p7.a;

@Keep
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    public static g a(u u0) {
        return TransportRegistrar.lambda$getComponents$2(u0);
    }

    public static g b(u u0) {
        return TransportRegistrar.lambda$getComponents$1(u0);
    }

    public static g c(u u0) {
        return TransportRegistrar.lambda$getComponents$0(u0);
    }

    @Override  // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        b b0 = c.b(g.class);
        b0.a = "fire-transport";
        b0.a(k.b(Context.class));
        b0.g = new d(20);
        c c0 = b0.b();
        b b1 = c.a(new s(a.class, g.class));
        b1.a(k.b(Context.class));
        b1.g = new d(21);
        c c1 = b1.b();
        b b2 = c.a(new s(p7.b.class, g.class));
        b2.a(k.b(Context.class));
        b2.g = new d(22);
        return Arrays.asList(new c[]{c0, c1, b2.b(), x1.a.q("fire-transport", "19.0.0")});
    }

    private static g lambda$getComponents$0(Y6.d d0) {
        Q5.u.b(((Context)d0.get(Context.class)));
        return Q5.u.a().c(O5.a.f);
    }

    private static g lambda$getComponents$1(Y6.d d0) {
        Q5.u.b(((Context)d0.get(Context.class)));
        return Q5.u.a().c(O5.a.f);
    }

    private static g lambda$getComponents$2(Y6.d d0) {
        Q5.u.b(((Context)d0.get(Context.class)));
        return Q5.u.a().c(O5.a.e);
    }
}

