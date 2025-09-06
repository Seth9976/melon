package com.google.gson.internal.bind;

import W7.a;
import W7.b;
import com.google.gson.E;
import com.google.gson.x;
import java.util.Map;

public abstract class o extends E {
    public final q a;

    public o(q q0) {
        this.a = q0;
    }

    @Override  // com.google.gson.E
    public final Object b(a a0) {
        if(a0.Z() == 9) {
            a0.T();
            return null;
        }
        Object object0 = this.d();
        Map map0 = this.a.a;
        try {
            a0.m();
            while(true) {
                if(!a0.E()) {
                    goto label_18;
                }
                n n0 = (n)map0.get(a0.P());
                if(n0 == null) {
                    a0.i0();
                }
                else {
                    this.f(object0, a0, n0);
                }
            }
        }
        catch(IllegalStateException illegalStateException0) {
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.13.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException0);
        }
        throw new x(illegalStateException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
    label_18:
        a0.r();
        return this.e(object0);
    }

    @Override  // com.google.gson.E
    public final void c(b b0, Object object0) {
        if(object0 == null) {
            b0.B();
            return;
        }
        b0.o();
        try {
            for(Object object1: this.a.b) {
                ((n)object1).a(b0, object0);
            }
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.13.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException0);
        }
        b0.r();
    }

    public abstract Object d();

    public abstract Object e(Object arg1);

    public abstract void f(Object arg1, a arg2, n arg3);
}

