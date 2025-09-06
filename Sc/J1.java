package sc;

import com.iloen.melon.playback.SpApiQueueBaseTask;
import ie.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import we.a;

public final class j1 implements a {
    public final int a;
    public final S2 b;
    public final SpApiQueueBaseTask c;
    public final String d;

    public j1(S2 s20, SpApiQueueBaseTask spApiQueueBaseTask0, String s, int v) {
        this.a = v;
        this.b = s20;
        this.c = spApiQueueBaseTask0;
        this.d = s;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                this.b.d.dequeue(this.c);
                N1 n10 = new N1(this.b, this.d, null);
                BuildersKt__Builders_commonKt.launch$default(this.b.c, null, null, n10, 3, null);
                return H.a;
            }
            case 1: {
                this.b.d.dequeueAndClear(this.c);
                O1 o10 = new O1(this.b, this.d, null);
                BuildersKt__Builders_commonKt.launch$default(this.b.c, null, null, o10, 3, null);
                return H.a;
            }
            default: {
                i i0 = this.b.g;
                q.d(i0);
                x0 x00 = new x0(i0.a, null);
                BuildersKt__Builders_commonKt.launch$default(i0.a.c, null, null, x00, 3, null);
                this.b.d.dequeue(this.c);
                M1 m10 = new M1(this.b, this.d, null);
                BuildersKt__Builders_commonKt.launch$default(this.b.c, null, null, m10, 3, null);
                return H.a;
            }
        }
    }
}

