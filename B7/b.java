package b7;

import H8.q;
import L7.c;
import L7.d;
import L7.e;
import android.util.Log;
import b.l;
import java.util.ArrayList;
import java.util.List;

public final class b {
    public final q a;

    public b(q q0) {
        this.a = q0;
    }

    public final void a(d d0) {
        q q0 = this.a;
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, d0.a));
        for(Object object0: d0.a) {
            String s = ((c)(((e)object0))).b;
            String s1 = ((c)(((e)object0))).d;
            String s2 = ((c)(((e)object0))).e;
            String s3 = ((c)(((e)object0))).c;
            long v = ((c)(((e)object0))).f;
            if(s2.length() > 0x100) {
                s2 = s2.substring(0, 0x100);
            }
            arrayList0.add(new g7.b(v, s, s1, s2, s3));
        }
        synchronized(((T3.e)q0.f)) {
            if(((T3.e)q0.f).k(arrayList0)) {
                List list0 = ((T3.e)q0.f).f();
                ((f7.d)q0.b).b.a(new l(28, q0, list0));
            }
        }
        if(Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Updated Crashlytics Rollout State", null);
        }
    }
}

