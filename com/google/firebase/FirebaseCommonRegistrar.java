package com.google.firebase;

import B3.n;
import G7.a;
import Y6.b;
import Y6.c;
import Y6.k;
import Y6.s;
import android.content.Context;
import android.os.Build;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import w7.d;
import w7.e;
import w7.f;

public class FirebaseCommonRegistrar implements ComponentRegistrar {
    public static String a(String s) {
        return s.replace(' ', '_').replace('/', '_');
    }

    @Override  // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        List list0 = new ArrayList();
        b b0 = c.b(G7.b.class);
        b0.a(new k(2, 0, a.class));
        b0.g = new n(12);
        ((ArrayList)list0).add(b0.b());
        s s0 = new s(X6.a.class, Executor.class);
        b b1 = new b(w7.c.class, new Class[]{e.class, f.class});
        b1.a(k.b(Context.class));
        b1.a(k.b(com.google.firebase.e.class));
        b1.a(new k(2, 0, d.class));
        b1.a(new k(1, 1, G7.b.class));
        b1.a(new k(s0, 1, 0));
        b1.g = new H7.n(s0, 1);
        ((ArrayList)list0).add(b1.b());
        ((ArrayList)list0).add(x1.a.q("fire-android", "33"));
        ((ArrayList)list0).add(x1.a.q("fire-core", "21.0.0"));
        ((ArrayList)list0).add(x1.a.q("device-name", FirebaseCommonRegistrar.a(Build.PRODUCT)));
        ((ArrayList)list0).add(x1.a.q("device-model", FirebaseCommonRegistrar.a(Build.DEVICE)));
        ((ArrayList)list0).add(x1.a.q("device-brand", FirebaseCommonRegistrar.a(Build.BRAND)));
        ((ArrayList)list0).add(x1.a.y("android-target-sdk", new com.google.android.exoplayer2.upstream.cache.a(6)));
        ((ArrayList)list0).add(x1.a.y("android-min-sdk", new com.google.android.exoplayer2.upstream.cache.a(7)));
        ((ArrayList)list0).add(x1.a.y("android-platform", new com.google.android.exoplayer2.upstream.cache.a(8)));
        ((ArrayList)list0).add(x1.a.y("android-installer", new com.google.android.exoplayer2.upstream.cache.a(9)));
        ((ArrayList)list0).add(x1.a.q("kotlin", "2.2.0"));
        return list0;
    }
}

