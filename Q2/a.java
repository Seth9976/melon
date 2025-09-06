package q2;

import java.util.Map.Entry;
import je.n;
import k8.Y;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.k;

public final class a extends r implements k {
    public static final a f;

    static {
        a.f = new a(1);  // 初始化器: Lkotlin/jvm/internal/r;-><init>(I)V
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        String s;
        q.g(((Map.Entry)object0), "entry");
        Object object1 = ((Map.Entry)object0).getValue();
        if(object1 instanceof byte[]) {
            s = n.q0(((byte[])object1), ", ", null, 56);
            return Y.l(new StringBuilder("  "), ((f)((Map.Entry)object0).getKey()).a, " = ", s);
        }
        s = String.valueOf(((Map.Entry)object0).getValue());
        return Y.l(new StringBuilder("  "), ((f)((Map.Entry)object0).getKey()).a, " = ", s);
    }
}

