package Ze;

import Me.L;
import Me.b;
import Me.e;
import df.d;
import kotlin.jvm.internal.q;
import tf.f;

public final class k implements f {
    @Override  // tf.f
    public final int a(b b0, b b1, e e0) {
        q.g(b0, "superDescriptor");
        q.g(b1, "subDescriptor");
        if(b1 instanceof L && b0 instanceof L && q.b(((L)b1).getName(), ((L)b0).getName())) {
            if(d.B(((L)b1)) && d.B(((L)b0))) {
                return 1;
            }
            return !d.B(((L)b1)) && !d.B(((L)b0)) ? 3 : 2;
        }
        return 3;
    }

    @Override  // tf.f
    public final int b() {
        return 3;
    }
}

