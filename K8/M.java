package k8;

import Ac.h0;
import Kb.c;
import d5.t;
import kc.H1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import sc.P0;
import sc.f1;
import sc.i1;

public final class m {
    public final n a;

    public m(n n0) {
        this.a = n0;
    }

    public final P0 a(boolean z) {
        CoroutineDispatcher coroutineDispatcher0 = h0.A();
        CoroutineDispatcher coroutineDispatcher1 = h0.B();
        CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        t.e(coroutineScope0);
        return new P0(coroutineDispatcher0, coroutineDispatcher1, coroutineScope0, ((f1)this.a.a.u0.get()), ((i1)this.a.a.v0.get()), ((H1)this.a.a.r.get()), ((a)this.a.a.l.get()), new c(((Jb.c)this.a.a.e0.get())), z);
    }
}

