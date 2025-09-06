package sc;

import com.iloen.melon.playback.SpApiQueueBaseTask;
import ie.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import we.a;

public final class k1 implements a {
    public final int a;
    public final S2 b;
    public final SpApiQueueBaseTask c;

    public k1(S2 s20, SpApiQueueBaseTask spApiQueueBaseTask0, int v) {
        this.a = v;
        this.b = s20;
        this.c = spApiQueueBaseTask0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                this.b.d.dequeue(this.c);
                return H.a;
            }
            case 1: {
                this.b.d.dequeue(this.c);
                this.b.d.start();
                return H.a;
            }
            case 2: {
                this.b.d.dequeue(this.c);
                return H.a;
            }
            case 3: {
                this.b.d.dequeue(this.c);
                P1 p10 = new P1(this.b, this.c, null);
                BuildersKt__Builders_commonKt.launch$default(this.b.c, null, null, p10, 3, null);
                return H.a;
            }
            case 4: {
                this.b.d.dequeue(this.c);
                return H.a;
            }
            case 5: {
                this.b.d.dequeue(this.c);
                Q1 q10 = new Q1(this.b, this.c, null);
                BuildersKt__Builders_commonKt.launch$default(this.b.c, null, null, q10, 3, null);
                return H.a;
            }
            case 6: {
                this.b.d.dequeue(this.c);
                R1 r10 = new R1(this.b, this.c, null);
                BuildersKt__Builders_commonKt.launch$default(this.b.c, null, null, r10, 3, null);
                return H.a;
            }
            default: {
                this.b.d.dequeue(this.c);
                L1 l10 = new L1(this.b, this.c, null);
                BuildersKt__Builders_commonKt.launch$default(this.b.c, null, null, l10, 3, null);
                this.b.d.start();
                return H.a;
            }
        }
    }
}

