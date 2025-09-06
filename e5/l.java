package e5;

import android.content.Context;
import android.os.PowerManager.WakeLock;
import android.os.PowerManager;
import kotlin.jvm.internal.q;

public abstract class l {
    public static final String a;

    // 去混淆评级： 低(20)
    static {
        q.f("WM-WakeLocks", "tagWithPrefix(\"WakeLocks\")");
        l.a = "WM-WakeLocks";
    }

    public static final PowerManager.WakeLock a(Context context0, String s) {
        q.g(context0, "context");
        q.g(s, "tag");
        Object object0 = context0.getApplicationContext().getSystemService("power");
        q.e(object0, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager.WakeLock powerManager$WakeLock0 = ((PowerManager)object0).newWakeLock(1, "WorkManager: " + s);
        synchronized(m.a) {
            String s1 = (String)m.b.put(powerManager$WakeLock0, "WorkManager: " + s);
        }
        q.f(powerManager$WakeLock0, "wakeLock");
        return powerManager$WakeLock0;
    }
}

