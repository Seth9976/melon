package gc;

import com.iloen.melon.custom.S0;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import java.util.Map;
import kotlin.jvm.internal.q;
import we.k;

public final class c implements k {
    public final int a;
    public final e b;

    public c(e e0, int v) {
        this.a = v;
        this.b = e0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((Exception)object0), "it");
            LogU.debug$default(this.b.c, va.e.b("seekTo() error: ", ((Exception)object0).getMessage()), null, false, 6, null);
            this.b.f.set(false);
            ((S0)this.b.a).g0(this.b);
            return H.a;
        }
        q.g(((Map)object0), "it");
        LogU.debug$default(this.b.c, "seekTo() success", null, false, 6, null);
        this.b.f.set(false);
        ((S0)this.b.a).g0(this.b);
        return H.a;
    }
}

