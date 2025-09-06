package z4;

import df.v;
import kotlin.jvm.internal.q;
import me.g;
import me.h;
import me.i;
import w4.f;
import we.n;

public final class a implements g {
    public final u a;
    public static final f b;

    static {
        a.b = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public a(u u0) {
        q.g(u0, "connectionWrapper");
        super();
        this.a = u0;
    }

    @Override  // me.i
    public final Object fold(Object object0, n n0) {
        return v.v(this, object0, n0);
    }

    @Override  // me.i
    public final g get(h h0) {
        return v.w(this, h0);
    }

    @Override  // me.g
    public final h getKey() {
        return a.b;
    }

    @Override  // me.i
    public final i minusKey(h h0) {
        return v.E(this, h0);
    }

    @Override  // me.i
    public final i plus(i i0) {
        return v.F(i0, this);
    }
}

