package vf;

import Hf.x;
import Je.i;
import Je.k;
import Me.z;
import kotlin.jvm.internal.q;

public final class c extends g {
    public final int b;

    public c(double f) {
        this.b = 1;
        super(f);
    }

    public c(float f) {
        this.b = 2;
        super(f);
    }

    public c(Object object0) {
        this.b = 0;
        super(object0);
    }

    @Override  // vf.g
    public final x a(z z0) {
        switch(this.b) {
            case 0: {
                q.g(z0, "module");
                i i1 = z0.d();
                i1.getClass();
                return i1.t(k.f);
            }
            case 1: {
                q.g(z0, "module");
                i i2 = z0.d();
                i2.getClass();
                return i2.t(k.m);
            }
            default: {
                q.g(z0, "module");
                i i0 = z0.d();
                i0.getClass();
                return i0.t(k.k);
            }
        }
    }

    @Override  // vf.g
    public String toString() {
        switch(this.b) {
            case 1: {
                return ((Number)this.a).doubleValue() + ".toDouble()";
            }
            case 2: {
                return ((Number)this.a).floatValue() + ".toFloat()";
            }
            default: {
                return super.toString();
            }
        }
    }
}

