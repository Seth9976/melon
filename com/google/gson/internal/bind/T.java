package com.google.gson.internal.bind;

import W7.a;
import androidx.lifecycle.b;
import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import com.google.gson.w;

public final class t extends s {
    public final w a;
    public final n b;
    public final TypeToken c;
    public final F d;
    public final b e;
    public final boolean f;
    public volatile E g;

    public t(w w0, n n0, TypeToken typeToken0, F f0, boolean z) {
        this.e = new b(this, 26);
        this.a = w0;
        this.b = n0;
        this.c = typeToken0;
        this.d = f0;
        this.f = z;
    }

    @Override  // com.google.gson.E
    public final Object b(a a0) {
        E e0 = this.g;
        if(e0 == null) {
            e0 = this.b.h(this.d, this.c);
            this.g = e0;
        }
        return e0.b(a0);
    }

    @Override  // com.google.gson.E
    public final void c(W7.b b0, Object object0) {
        w w0 = this.a;
        if(w0 == null) {
            E e0 = this.g;
            if(e0 == null) {
                e0 = this.b.h(this.d, this.c);
                this.g = e0;
            }
            e0.c(b0, object0);
            return;
        }
        if(this.f && object0 == null) {
            b0.B();
            return;
        }
        com.google.gson.t t0 = w0.a(object0, this.c.getType(), this.e);
        X.z.getClass();
        f.e(b0, t0);
    }

    @Override  // com.google.gson.internal.bind.s
    public final E d() {
        if(this.a != null) {
            return this;
        }
        E e0 = this.g;
        if(e0 == null) {
            e0 = this.b.h(this.d, this.c);
            this.g = e0;
        }
        return e0;
    }

    public static F e(TypeToken typeToken0, w w0) {
        return typeToken0.getType() == typeToken0.getRawType() ? new TreeTypeAdapter.SingleTypeFactory(w0, typeToken0, true) : new TreeTypeAdapter.SingleTypeFactory(w0, typeToken0, false);
    }
}

