package ud;

import I0.a;
import O.F;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.SupervisorKt;

public final class h implements a {
    public final CoroutineScope a;
    public final F b;
    public final d9.h c;

    public h(CoroutineScope coroutineScope0, F f0, d9.h h0) {
        this.a = coroutineScope0;
        this.b = f0;
        this.c = h0;
    }

    @Override  // I0.a
    public final Object onPostFling-RZ2iAVY(long v, long v1, Continuation continuation0) {
        CompletableJob completableJob0 = SupervisorKt.SupervisorJob$default(null, 1, null);
        g g0 = new g(this.b, this.c, null);
        BuildersKt__Builders_commonKt.launch$default(this.a, completableJob0, null, g0, 2, null);
        return a.super.onPostFling-RZ2iAVY(v, v1, continuation0);
    }

    @Override  // I0.a
    public final long onPostScroll-DzOQY0M(long v, long v1, int v2) {
        return 0L;
    }

    @Override  // I0.a
    public final long onPreScroll-OzD1aCk(long v, int v1) {
        return 0L;
    }
}

