package Af;

import Gf.i;
import Gf.m;
import Me.b;
import Me.h;
import Pe.L;
import Ue.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.q;
import qf.e;
import we.a;

public final class l implements p {
    public final int b;
    public final Object c;

    public l(p p0) {
        this.b = 1;
        super();
        this.c = p0;
    }

    public l(Gf.p p0, a a0) {
        this.b = 0;
        q.g(p0, "storageManager");
        super();
        this.c = new i(((m)p0), new k(0, a0));  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
    }

    @Override  // Af.p
    public final Set a() {
        return this.l().a();
    }

    @Override  // Af.p
    public Collection b(e e0, c c0) {
        if(this.b != 1) {
            return this.k(e0, c0);
        }
        q.g(e0, "name");
        return tf.m.o(this.k(e0, c0), (Object object0) -> switch(this.a) {
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

    @Override  // Af.r
    public final h c(e e0, Ue.a a0) {
        q.g(e0, "name");
        q.g(a0, "location");
        return this.l().c(e0, a0);
    }

    @Override  // Af.p
    public final Set d() {
        return this.l().d();
    }

    @Override  // Af.r
    public Collection e(f f0, we.k k0) {
        if(this.b != 1) {
            return this.i(f0, k0);
        }
        q.g(f0, "kindFilter");
        Iterable iterable0 = this.i(f0, k0);
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: iterable0) {
            if(((Me.k)object0) instanceof b) {
                arrayList0.add(object0);
            }
            else {
                arrayList1.add(object0);
            }
        }
        return je.p.A0(tf.m.o(arrayList0, (Object object0) -> switch(this.a) {
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
        }), arrayList1);
    }

    @Override  // Af.p
    public Collection f(e e0, Ue.a a0) {
        if(this.b != 1) {
            return this.j(e0, a0);
        }
        q.g(e0, "name");
        return tf.m.o(this.j(e0, a0), (Object object0) -> switch(this.a) {
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

    @Override  // Af.p
    public final Set g() {
        return this.l().g();
    }

    public final p h() {
        if(this.l() instanceof l) {
            p p0 = this.l();
            q.e(p0, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.AbstractScopeAdapter");
            return ((l)p0).h();
        }
        return this.l();
    }

    public final Collection i(f f0, we.k k0) {
        q.g(f0, "kindFilter");
        return this.l().e(f0, k0);
    }

    public final Collection j(e e0, Ue.a a0) {
        q.g(e0, "name");
        return this.l().f(e0, a0);
    }

    public final Collection k(e e0, c c0) {
        q.g(e0, "name");
        return this.l().b(e0, c0);
    }

    public final p l() {
        return this.b == 0 ? ((p)((i)this.c).invoke()) : ((p)this.c);
    }
}

