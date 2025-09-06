package V4;

import U4.D;
import androidx.work.impl.WorkDatabase_Impl;
import d5.h;
import d5.q;
import d5.s;
import java.util.concurrent.Callable;

public final class w implements Callable {
    public final int a;
    public final G b;

    public w(G g0, int v) {
        this.a = v;
        this.b = g0;
        super();
    }

    @Override
    public final Object call() {
        if(this.a != 0) {
            s s0 = this.b.i;
            String s1 = this.b.c;
            if(s0.i(s1) == D.a) {
                s0.p(D.b, s1);
                WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)s0.a;
                workDatabase_Impl0.assertNotSuspendingTransaction();
                h h0 = (h)s0.i;
                H4.h h1 = h0.a();
                h1.k(1, s1);
                try {
                    workDatabase_Impl0.beginTransaction();
                    try {
                        h1.w();
                        workDatabase_Impl0.setTransactionSuccessful();
                    }
                    catch(Throwable throwable0) {
                        workDatabase_Impl0.endTransaction();
                        throw throwable0;
                    }
                    workDatabase_Impl0.endTransaction();
                }
                finally {
                    h0.n(h1);
                }
                s0.q(s1, 0xFFFFFF00);
                return true;
            }
            return false;
        }
        G g0 = this.b;
        q q0 = g0.a;
        String s2 = q0.c;
        D d0 = D.a;
        if(q0.b != d0) {
            U4.w.e().a("WM-WorkerWrapper", s2 + " is not in ENQUEUED state. Nothing more to do");
            return true;
        }
        if(q0.c() || q0.b == d0 && q0.k > 0) {
            g0.f.getClass();
            if(System.currentTimeMillis() < q0.a()) {
                U4.w.e().a("WM-WorkerWrapper", "Delaying execution for " + s2 + " because it is being executed before schedule.");
                return true;
            }
        }
        return false;
    }
}

