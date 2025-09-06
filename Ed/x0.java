package ed;

import Ic.h;
import com.iloen.melon.utils.MelonLinkExecutor;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class x0 implements k {
    public final int a;
    public final F0 b;

    public x0(F0 f00, int v) {
        this.a = v;
        this.b = f00;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        if(this.a != 0) {
            q.g(((O0)object0), "keyword");
            h h1 = new h(0, this.b, F0.class, "updateLandBeforeTagData", "updateLandBeforeTagData()V", 0, 15);
            MelonLinkExecutor.INSTANCE.openUrl(((O0)object0).b, h1);
            return h0;
        }
        F0.f(this.b, object0);
        return h0;
    }
}

