package D4;

import A7.d;
import U4.x;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;

public final class p {
    public final String a;
    public final String b;
    public final String c;
    public final List d;
    public final List e;

    public p(String s, String s1, String s2, List list0, List list1) {
        q.g(s, "referenceTable");
        q.g(s1, "onDelete");
        q.g(s2, "onUpdate");
        q.g(list0, "columnNames");
        q.g(list1, "referenceColumnNames");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = list0;
        this.e = list1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof p && q.b(this.a, ((p)object0).a) && q.b(this.b, ((p)object0).b) && q.b(this.c, ((p)object0).c) && q.b(this.d, ((p)object0).d) ? q.b(this.e, ((p)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        return this.e.hashCode() + d.d(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d);
    }

    @Override
    public final String toString() {
        Tf.p.b0(je.p.q0(je.p.I0(this.d), ",", null, null, null, 62));
        new String("    },");
        Tf.p.b0(je.p.q0(je.p.I0(this.e), ",", null, null, null, 62));
        new String("     }");
        return Tf.p.a0(Tf.p.d0(("\n            |ForeignKey {\n            |   referenceTable = \'" + this.a + "\',\n            |   onDelete = \'" + this.b + "\',\n            |   onUpdate = \'" + this.c + "\',\n            |   columnNames = {" + H.a + "\n            |   referenceColumnNames = {" + H.a + "\n            |}\n        ")), "    ");
    }
}

