package M7;

import Gd.e;
import android.app.Application;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.android.gms.common.util.ProcessUtils;
import kotlin.jvm.internal.r;
import l2.b;
import we.k;

public final class q extends r implements k {
    public final int f;
    public static final q g;
    public static final q h;

    static {
        q.g = new q(1, 0);
        q.h = new q(1, 1);
    }

    public q(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        String s1;
        String s;
        if(this.f != 0) {
            kotlin.jvm.internal.q.g(((b)object0), "ex");
            StringBuilder stringBuilder0 = new StringBuilder("CorruptionException in sessions DataStore in ");
            int v = Build.VERSION.SDK_INT;
            if(v > 33) {
                s = e.t();
                kotlin.jvm.internal.q.f(s, "myProcessName()");
            }
            else if(v >= 28) {
                s = Application.getProcessName();
                if(s == null) {
                    goto label_11;
                }
            }
            else {
            label_11:
                s = ProcessUtils.getMyProcessName();
                if(s == null) {
                    s = "";
                }
            }
            stringBuilder0.append(s);
            stringBuilder0.append('.');
            Log.w("FirebaseSessions", stringBuilder0.toString(), ((b)object0));
            return new q2.b(true);
        }
        kotlin.jvm.internal.q.g(((b)object0), "ex");
        StringBuilder stringBuilder1 = new StringBuilder("CorruptionException in settings DataStore in ");
        int v1 = Build.VERSION.SDK_INT;
        if(v1 > 33) {
            s1 = e.t();
            kotlin.jvm.internal.q.f(s1, "myProcessName()");
        }
        else if(v1 >= 28) {
            s1 = Application.getProcessName();
            if(s1 == null) {
                goto label_28;
            }
        }
        else {
        label_28:
            s1 = ProcessUtils.getMyProcessName();
            if(s1 == null) {
                s1 = "";
            }
        }
        stringBuilder1.append(s1);
        stringBuilder1.append('.');
        Log.w("FirebaseSessions", stringBuilder1.toString(), ((b)object0));
        return new q2.b(true);
    }
}

