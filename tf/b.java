package tf;

import Me.k;
import kotlin.jvm.internal.q;
import we.n;

public final class b implements n {
    public final Me.b a;
    public final Me.b b;

    public b(Me.b b0, Me.b b1) {
        this.a = b0;
        this.b = b1;
    }

    // 去混淆评级： 低(20)
    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return !q.b(((k)object0), this.a) || !q.b(((k)object1), this.b) ? false : true;
    }
}

