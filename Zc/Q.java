package zc;

import O.F;
import com.melon.net.res.common.SongInfoBase;
import ie.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import we.k;
import we.n;

public final class q implements k {
    public final n a;
    public final int b;
    public final CoroutineScope c;
    public final F d;

    public q(n n0, int v, CoroutineScope coroutineScope0, F f0) {
        this.a = n0;
        this.b = v;
        this.c = coroutineScope0;
        this.d = f0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        kotlin.jvm.internal.q.g(((SongInfoBase)object0), "it");
        int v = this.b;
        n n0 = this.a;
        if(n0 != null) {
            n0.invoke(v, ((SongInfoBase)object0));
        }
        p p0 = new p(this.d, v, null);
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, p0, 3, null);
        return H.a;
    }
}

