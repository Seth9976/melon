package Ff;

import Af.p;
import Me.b;
import Pe.L;
import java.util.Collection;
import kotlin.jvm.internal.q;
import qf.e;
import we.a;

public final class f implements a {
    public final int a;
    public final h b;

    public f(h h0, int v) {
        this.a = v;
        this.b = h0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        h h0 = this.b;
        if(this.a != 0) {
            h0.g.getClass();
            q.g(h0.j, "classDescriptor");
            Collection collection0 = ((Hf.f)h0.j.q()).f();
            q.f(collection0, "getSupertypes(...)");
            return collection0;
        }
        p.a.getClass();
        return h0.i(Af.f.m, (Object object0) -> switch(this.a) {
            case 0: {
                q.g(((e)object0), "it");
                return true;
            }
            case 1: {
                q.g(((L)object0), "$this$selectMostSpecificInEachOverridableGroup");
                return (L)object0;
            }
            case 2: {
                q.g(((Me.L)object0), "$this$selectMostSpecificInEachOverridableGroup");
                return (Me.L)object0;
            }
            default: {
                q.g(((b)object0), "$this$selectMostSpecificInEachOverridableGroup");
                return (b)object0;
            }
        });
    }
}

