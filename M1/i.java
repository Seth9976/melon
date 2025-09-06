package m1;

import P0.r0;
import android.content.Context;
import android.view.View;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n;
import androidx.compose.ui.tooling.ComposeViewAdapter;
import e1.m;
import e1.u;
import ie.H;
import java.util.Arrays;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import u1.o;
import we.a;
import we.k;

public final class i extends r implements a {
    public final int f;
    public final int g;
    public final Object h;
    public final Object i;
    public final Object j;
    public final Object k;
    public final View l;

    public i(Object object0, Object object1, Object object2, Object object3, int v, View view0, int v1) {
        this.f = v1;
        this.h = object0;
        this.i = object1;
        this.j = object2;
        this.k = object3;
        this.g = v;
        this.l = view0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.f != 0) {
            q.e(this.l, "null cannot be cast to non-null type androidx.compose.ui.node.Owner");
            return new o(((Context)this.h), ((k)this.i), ((n)this.j), ((o0.i)this.k), this.g, ((r0)this.l)).getLayoutNode();
        }
        try {
            Object[] arr_object = Arrays.copyOf(u.x(this.g, ((Class)this.k)), 0);
            m.u(((String)this.h), ((String)this.i), ((l)this.j), arr_object);
            return H.a;
        }
        catch(Throwable throwable0) {
            Throwable throwable1;
            for(throwable1 = throwable0; throwable1 instanceof ReflectiveOperationException; throwable1 = throwable2) {
                Throwable throwable2 = throwable1.getCause();
                if(throwable2 == null) {
                    break;
                }
            }
            synchronized(((ComposeViewAdapter)this.l).i.c) {
                ((ComposeViewAdapter)this.l).i.b = throwable1;
            }
            throw throwable0;
        }
    }
}

