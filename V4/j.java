package V4;

import U4.a;
import U4.k;
import androidx.work.impl.WorkDatabase;
import d5.q;
import d5.s;
import java.util.ArrayList;
import java.util.List;

public abstract class j {
    public static final String a;

    static {
        j.a = "WM-Schedulers";
    }

    public static void a(s s0, k k0, ArrayList arrayList0) {
        if(arrayList0.size() > 0) {
            k0.getClass();
            long v = System.currentTimeMillis();
            for(Object object0: arrayList0) {
                s0.l(v, ((q)object0).a);
            }
        }
    }

    public static void b(a a0, WorkDatabase workDatabase0, List list0) {
        ArrayList arrayList2;
        ArrayList arrayList1;
        if(list0 != null && list0.size() != 0) {
            s s0 = workDatabase0.g();
            workDatabase0.beginTransaction();
            try {
                ArrayList arrayList0 = s0.f();
                j.a(s0, a0.d, arrayList0);
                arrayList1 = s0.e(a0.k);
                j.a(s0, a0.d, arrayList1);
                arrayList1.addAll(arrayList0);
                arrayList2 = s0.d();
                workDatabase0.setTransactionSuccessful();
            }
            finally {
                workDatabase0.endTransaction();
            }
            if(arrayList1.size() > 0) {
                q[] arr_q = (q[])arrayList1.toArray(new q[arrayList1.size()]);
                for(Object object0: list0) {
                    h h0 = (h)object0;
                    if(h0.c()) {
                        h0.d(arr_q);
                    }
                }
            }
            if(arrayList2.size() > 0) {
                q[] arr_q1 = (q[])arrayList2.toArray(new q[arrayList2.size()]);
                for(Object object1: list0) {
                    h h1 = (h)object1;
                    if(!h1.c()) {
                        h1.d(arr_q1);
                    }
                }
            }
        }
    }
}

