package hf;

import java.util.ArrayList;

public final class m {
    public final q a;
    public final ArrayList b;
    public final String c;
    public final m d;

    public m(q q0, ArrayList arrayList0, String s) {
        this.a = q0;
        this.b = arrayList0;
        this.c = s;
        m m0 = null;
        if(s != null) {
            q q1 = q0 == null ? null : q0.a();
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
            for(Object object0: arrayList0) {
                q q2 = (q)object0;
                arrayList1.add((q2 == null ? null : q2.a()));
            }
            m0 = new m(q1, arrayList1, null);
        }
        this.d = m0;
    }
}

