package Mf;

import Hf.G;
import Hf.M;
import Hf.N;
import Hf.P;
import Hf.b0;
import kotlin.jvm.internal.q;
import uf.b;

public final class c extends N {
    @Override  // Hf.N
    public final P g(M m0) {
        q.g(m0, "key");
        b b0 = m0 instanceof b ? ((b)m0) : null;
        if(b0 == null) {
            return null;
        }
        return b0.a().c() ? new G(b0.a().b(), b0.e) : b0.a();
    }
}

