package Fc;

import Ac.K;
import Cb.i;
import G4.a;
import L8.s;
import O.j;
import O.w;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.melon.playback.melon.analytics.AnalyticsTask;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.q;
import m0.b;
import we.k;

public final class c implements k {
    public final int a;
    public final long b;
    public final Object c;
    public final Object d;

    public c(int v, long v1, Object object0, Object object1) {
        this.a = v;
        this.c = object0;
        this.b = v1;
        this.d = object1;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                K k0 = new K(((List)this.c), 7);
                b b0 = new b(0xBEF78951, new h(((List)this.c), this.b, ((Integer)this.d), ((List)this.c)), true);
                ((j)(((w)object0))).u(((List)this.c).size(), null, k0, b0);
                return H.a;
            }
            case 1: {
                try(G4.c c0 = ((a)object0).l0(((String)this.c))) {
                    c0.a(1, this.b);
                    Iterator iterator0 = ((ArrayList)this.d).iterator();
                    for(int v = 2; true; ++v) {
                        if(!iterator0.hasNext()) {
                            break;
                        }
                        Object object1 = iterator0.next();
                        c0.e(v, ((String)object1));
                    }
                    c0.j0();
                }
                return null;
            }
            case 2: {
                k k1 = (k)this.d;
                q.g(((Exception)object0), "it");
                LogConstantsKt.debug(((s)this.c).d, "setAVTransportURI() :: error", this.b);
                if(k1 != null) {
                    k1.invoke(((Exception)object0));
                }
                return H.a;
            }
            default: {
                q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("[" + i.o(((AnalyticsTask)this.c)) + "] prepare()");
                i.a(((StringBuilder)object0), "Content Duration: " + this.b);
                i.a(((StringBuilder)object0), "Timer: " + ((AnalyticsTask)this.c).b(((ac.w)this.d), this.b));
                i.a(((StringBuilder)object0), "Contents Source: " + ((ac.w)this.d).b.m);
                i.a(((StringBuilder)object0), String.valueOf(((ac.w)this.d)));
                return H.a;
            }
        }
    }
}

