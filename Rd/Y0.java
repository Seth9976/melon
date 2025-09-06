package rd;

import com.iloen.melon.net.v4x.common.ContsTypeCode;
import ie.H;
import java.util.Map;
import je.p;
import k8.Y;
import kotlin.jvm.internal.q;
import q8.f;
import we.k;

public final class y0 implements k {
    public final int a;
    public final Map b;

    public y0(int v, Map map0) {
        this.a = v;
        this.b = map0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        Map map0 = this.b;
        if(this.a != 0) {
            q.g(((f)object0), "$this$eventMeta");
            ((f)object0).a = p.q0(map0.keySet(), ",", null, null, null, 62);
            ((f)object0).b = Y.i(ContsTypeCode.ARTIST, "code(...)");
            ((f)object0).c = p.q0(map0.values(), ",", null, null, null, 62);
            return h0;
        }
        q.g(((f)object0), "$this$eventMeta");
        ((f)object0).a = p.q0(map0.keySet(), ",", null, null, null, 62);
        ((f)object0).b = Y.i(ContsTypeCode.ARTIST, "code(...)");
        ((f)object0).c = p.q0(map0.values(), ",", null, null, null, 62);
        return h0;
    }
}

