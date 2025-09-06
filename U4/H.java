package U4;

import java.util.Arrays;
import java.util.Map.Entry;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.k;

public final class h extends r implements k {
    public static final h f;

    static {
        h.f = new h(1);  // 初始化器: Lkotlin/jvm/internal/r;-><init>(I)V
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((Map.Entry)object0), "<name for destructuring parameter 0>");
        String s = (String)((Map.Entry)object0).getKey();
        String s1 = ((Map.Entry)object0).getValue();
        StringBuilder stringBuilder0 = x.p(s, " : ");
        if(s1 instanceof Object[]) {
            s1 = Arrays.toString(((Object[])s1));
            q.f(s1, "toString(this)");
        }
        stringBuilder0.append(s1);
        return stringBuilder0.toString();
    }
}

