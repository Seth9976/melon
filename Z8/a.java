package Z8;

import ie.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

public final class a implements we.a {
    public final int a;
    public final g b;

    public a(g g0, int v) {
        this.a = v;
        this.b = g0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                this.b.i();
                return H.a;
            }
            case 1: {
                this.b.i();
                return H.a;
            }
            default: {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new f(this.b, null), 3, null);
                return H.a;
            }
        }
    }
}

