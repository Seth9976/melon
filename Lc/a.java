package lc;

import com.iloen.melon.playback.PlayableComparators.MyOrderPlayableComparator;
import com.iloen.melon.types.Range;
import com.iloen.melon.utils.log.LogU;
import e1.b;
import java.util.Collection;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;
import oc.Q;
import oc.S;
import oc.d0;
import oc.t;

public final class a {
    public final LogU a;
    public static final MyOrderPlayableComparator b;

    static {
        a.b = new MyOrderPlayableComparator();
    }

    public a(String s) {
        this.a = new LogU(s);
    }

    public static t a(int v, int v1, Q q0) {
        q.g(q0, "curState");
        if(v == v1) {
            return new t("same index");
        }
        if(!new Range(b.B(q0).size()).a(v)) {
            return new t("Invalid fromIndex");
        }
        return new Range(b.B(q0).size()).a(v1) ? null : new t("Invalid toIndex");
    }

    public static S b(List list0, Q q0) {
        q.g(list0, "indices");
        q.g(q0, "curState");
        if(list0.isEmpty()) {
            return new S("Empty Indices", false);
        }
        if(!(list0 instanceof Collection) || !list0.isEmpty()) {
            for(Object object0: list0) {
                int v = ((Number)object0).intValue();
                if(v < 0 || v >= b.B(q0).size()) {
                    return new S("Invalid Indices", false);
                }
                if(false) {
                    break;
                }
            }
        }
        return p.T0(list0).size() == list0.size() ? null : new S("Duplicated Indices", false);
    }

    public final d0 c(int v, Q q0) {
        q.g(q0, "curState");
        if(b.B(q0).isEmpty()) {
            LogU.warn$default(this.a, "adjustRequestedPosition - list is empty", null, false, 6, null);
            return new d0();  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        if(!new Range(b.B(q0).size()).a(v)) {
            LogU.warn$default(this.a, "adjustRequestedPosition wrong position requested: " + v, null, false, 6, null);
            return new d0();  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        return null;
    }

    public static int d(Q q0) {
        q.g(q0, "curState");
        if(b.B(q0).isEmpty()) {
            return -1;
        }
        int v = q0.b();
        return v + 1 < b.B(q0).size() ? v + 1 : 0;
    }

    public static int e(Q q0) {
        q.g(q0, "curState");
        if(b.B(q0).isEmpty()) {
            return -1;
        }
        int v = q0.b();
        return v - 1 >= 0 ? v - 1 : b.B(q0).size() - 1;
    }

    public static boolean f(int v, Q q0) {
        return v == b.B(q0).size() - 1;
    }
}

