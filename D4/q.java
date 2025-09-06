package D4;

import A7.d;
import Tf.p;
import Tf.v;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class q {
    public final String a;
    public final boolean b;
    public final List c;
    public final List d;

    public q(String s, boolean z, List list0, List list1) {
        kotlin.jvm.internal.q.g(s, "name");
        kotlin.jvm.internal.q.g(list0, "columns");
        kotlin.jvm.internal.q.g(list1, "orders");
        super();
        this.a = s;
        this.b = z;
        this.c = list0;
        this.d = list1;
        Collection collection0 = list1;
        if(collection0.isEmpty()) {
            int v = list0.size();
            collection0 = new ArrayList(v);
            for(int v1 = 0; v1 < v; ++v1) {
                ((ArrayList)collection0).add("ASC");
            }
        }
        this.d = (List)collection0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 instanceof q) {
            String s = ((q)object0).a;
            if(this.b == ((q)object0).b && kotlin.jvm.internal.q.b(this.c, ((q)object0).c) && kotlin.jvm.internal.q.b(this.d, ((q)object0).d)) {
                return v.r0(this.a, "index_", false) ? v.r0(s, "index_", false) : this.a.equals(s);
            }
        }
        return false;
    }

    // 去混淆评级： 低(20)
    @Override
    public final int hashCode() {
        return v.r0(this.a, "index_", false) ? this.d.hashCode() + d.d((this.b + 0x73D447D3) * 0x1F, 0x1F, this.c) : this.d.hashCode() + d.d((this.a.hashCode() * 0x1F + this.b) * 0x1F, 0x1F, this.c);
    }

    @Override
    public final String toString() {
        p.b0(je.p.q0(this.c, ",", null, null, null, 62));
        new String("    },");
        p.b0(je.p.q0(this.d, ",", null, null, null, 62));
        new String("     }");
        return p.a0(p.d0(("\n            |Index {\n            |   name = \'" + this.a + "\',\n            |   unique = \'" + this.b + "\',\n            |   columns = {" + H.a + "\n            |   orders = {" + H.a + "\n            |}\n        ")), "    ");
    }
}

