package gd;

import com.melon.ui.K4;
import com.melon.ui.c3;
import kotlin.jvm.internal.q;
import we.k;
import xd.j;

public final class u7 implements k {
    public final int a;
    public final c3 b;

    public u7(c3 c30, int v) {
        this.a = v;
        this.b = c30;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        c3 c30 = this.b;
        if(this.a != 0) {
            q.g(((K4)object0), "it");
            return new j(c30);
        }
        q.g(((K4)object0), "it");
        return new f7(c30);
    }
}

