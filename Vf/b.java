package vf;

import Hf.x;
import Je.i;
import Je.o;
import Me.h;
import Me.z;
import java.util.List;
import kotlin.jvm.internal.q;
import we.k;

public class b extends g {
    public final k b;

    public b(List list0, k k0) {
        super(list0);
        this.b = k0;
    }

    @Override  // vf.g
    public final x a(z z0) {
        q.g(z0, "module");
        x x0 = (x)this.b.invoke(z0);
        if(!i.z(x0)) {
            h h0 = x0.w().e();
            if(h0 != null && i.s(h0) != null) {
                return x0;
            }
            if(!i.C(x0, o.W.a) && !i.C(x0, o.X.a) && !i.C(x0, o.Y.a)) {
                i.C(x0, o.Z.a);
            }
        }
        return x0;
    }
}

