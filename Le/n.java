package Le;

import Me.c;
import Me.e;
import Qf.k;
import d3.g;
import java.io.Serializable;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;

public final class n extends k {
    public final int b;
    public final Object c;
    public final Serializable d;

    public n(Object object0, Serializable serializable0, int v) {
        this.b = v;
        this.c = object0;
        this.d = serializable0;
        super();
    }

    public n(H h0, we.k k0) {
        this.b = 2;
        super();
        this.d = h0;
        this.c = k0;
    }

    @Override  // Qf.k
    public void b(Object object0) {
        if(this.b != 2) {
            return;
        }
        q.g(((c)object0), "current");
        H h0 = (H)this.d;
        if(h0.a == null && ((Boolean)((we.k)this.c).invoke(((c)object0))).booleanValue()) {
            h0.a = (c)object0;
        }
    }

    @Override  // Qf.k
    public final boolean c(Object object0) {
        switch(this.b) {
            case 0: {
                H h0 = (H)this.d;
                q.g(((e)object0), "javaClassDescriptor");
                String s = g.g0(((e)object0), ((String)this.c));
                if(r.b.contains(s)) {
                    h0.a = l.a;
                    return h0.a == null;
                }
                if(r.d.contains(s)) {
                    h0.a = l.b;
                    return h0.a == null;
                }
                if(r.c.contains(s)) {
                    h0.a = l.c;
                    return h0.a == null;
                }
                if(r.a.contains(s)) {
                    h0.a = l.e;
                }
                return h0.a == null;
            }
            case 1: {
                boolean[] arr_z = (boolean[])this.d;
                if(((Boolean)((we.k)this.c).invoke(object0)).booleanValue()) {
                    arr_z[0] = true;
                }
                return !arr_z[0];
            }
            default: {
                q.g(((c)object0), "current");
                return ((H)this.d).a == null;
            }
        }
    }

    @Override  // Qf.k
    public final Object j() {
        switch(this.b) {
            case 0: {
                l l0 = (l)((H)this.d).a;
                return l0 == null ? l.d : l0;
            }
            case 1: {
                return Boolean.valueOf(((boolean[])this.d)[0]);
            }
            default: {
                return (c)((H)this.d).a;
            }
        }
    }
}

