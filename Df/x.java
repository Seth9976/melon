package df;

import Af.f;
import Af.m;
import Af.p;
import Me.b;
import Pe.L;
import Qf.k;
import Ue.c;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.q;
import qf.e;
import we.a;

public final class x implements a {
    public final int a;
    public final C b;

    public x(C c0, int v) {
        this.a = v;
        this.b = c0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                f f0 = f.m;
                p.a.getClass();
                m m0 = (Object object0) -> switch(this.a) {
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
                };
                q.g(f0, "kindFilter");
                List list0 = f0.a;
                c c0 = c.d;
                LinkedHashSet linkedHashSet0 = new LinkedHashSet();
                C c1 = this.b;
                if(f0.a(f.l)) {
                    for(Object object0: c1.h(f0, m0)) {
                        m0.invoke(((e)object0));
                        k.a(linkedHashSet0, c1.c(((e)object0), c0));
                    }
                }
                if(f0.a(f.i) && !list0.contains(Af.b.a)) {
                    for(Object object1: c1.i(f0, m0)) {
                        m0.invoke(((e)object1));
                        linkedHashSet0.addAll(c1.f(((e)object1), c0));
                    }
                }
                if(f0.a(f.j) && !list0.contains(Af.b.a)) {
                    for(Object object2: c1.o(f0)) {
                        m0.invoke(((e)object2));
                        linkedHashSet0.addAll(c1.b(((e)object2), c0));
                    }
                }
                return je.p.P0(linkedHashSet0);
            }
            case 1: {
                return this.b.k();
            }
            case 2: {
                return this.b.i(f.p, null);
            }
            case 3: {
                return this.b.o(f.q);
            }
            default: {
                return this.b.h(f.o, null);
            }
        }
    }
}

