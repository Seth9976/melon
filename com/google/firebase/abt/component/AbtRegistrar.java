package com.google.firebase.abt.component;

import B3.n;
import T6.a;
import Y6.b;
import Y6.c;
import Y6.d;
import Y6.k;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;

@Keep
public class AbtRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-abt";

    @Override  // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        b b0 = c.b(a.class);
        b0.a = "fire-abt";
        b0.a(k.b(Context.class));
        b0.a(new k(0, 1, V6.b.class));
        b0.g = new n(27);
        return Arrays.asList(new c[]{b0.b(), x1.a.q("fire-abt", "21.1.1")});
    }

    private static a lambda$getComponents$0(d d0) {
        return new a(((Context)d0.get(Context.class)), d0.b(V6.b.class));
    }
}

