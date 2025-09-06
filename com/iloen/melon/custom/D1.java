package com.iloen.melon.custom;

import Vb.p0;
import androidx.lifecycle.M;
import ie.f;
import kotlin.jvm.internal.k;

public final class d1 implements M, k {
    public final int a;
    public final we.k b;

    public d1(int v, we.k k0) {
        this.a = v;
        this.b = k0;
        super();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this.a != 0) {
            if(object0 instanceof M && object0 instanceof k) {
                f f0 = ((k)object0).getFunctionDelegate();
                return this.b.equals(f0);
            }
            return false;
        }
        if(object0 instanceof M && object0 instanceof k) {
            f f1 = ((k)object0).getFunctionDelegate();
            return ((p0)this.b).equals(f1);
        }
        return false;
    }

    @Override  // kotlin.jvm.internal.k
    public final f getFunctionDelegate() {
        return this.a != 0 ? this.b : ((p0)this.b);
    }

    @Override
    public final int hashCode() {
        return this.a == 0 ? ((p0)this.b).hashCode() : this.b.hashCode();
    }

    @Override  // androidx.lifecycle.M
    public final void onChanged(Object object0) {
        if(this.a != 0) {
            this.b.invoke(object0);
            return;
        }
        ((p0)this.b).invoke(object0);
    }
}

