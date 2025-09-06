package o1;

import G.C0;
import G.H;
import G.I;
import G.X;
import G.o;
import java.util.Iterator;
import kotlin.jvm.internal.q;
import n1.k;

public final class c implements b {
    public final k a;
    public final X.k b;

    public c(k k0, X.k k1) {
        this.a = k0;
        this.b = k1;
    }

    @Override  // o1.b
    public final long a() {
        return Math.max(this.c(), ((Number)this.b.invoke()).longValue());
    }

    public static long b(I i0) {
        o o0 = i0.e;
        q.e(o0, "null cannot be cast to non-null type androidx.compose.animation.core.InfiniteRepeatableSpec<T of androidx.compose.ui.tooling.animation.clock.InfiniteTransitionClock.getIterationDuration>");
        C0 c00 = ((H)o0).a.a(i0.c);
        return (((long)c00.n()) + ((long)(c00.r() * (((H)o0).b == X.b ? 2 : 1)))) * 1000000L;
    }

    public final long c() {
        Iterator iterator0 = this.a.a.a.f().iterator();
        if(!iterator0.hasNext()) {
            throw new NullPointerException();
        }
        Object object0 = iterator0.next();
        Long long0 = c.b(((I)object0));
        while(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            Long long1 = c.b(((I)object1));
            if(long0.compareTo(long1) < 0) {
                long0 = long1;
            }
        }
        return long0 == null ? 0L : (((long)long0) + 0xF423FL) / 1000000L;
    }
}

