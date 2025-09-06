package N1;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import java.util.HashSet;

public final class z {
    public final Context a;
    public final NotificationManager b;
    public static final Object c;
    public static String d;
    public static HashSet e;
    public static final Object f;
    public static y g;

    static {
        z.c = new Object();
        z.e = new HashSet();
        z.f = new Object();
    }

    public z(Context context0) {
        this.a = context0;
        this.b = (NotificationManager)context0.getSystemService("notification");
    }

    public final void a(int v, Notification notification0) {
        NotificationManager notificationManager0 = this.b;
        if(notification0.extras != null && notification0.extras.getBoolean("android.support.useSideChannel")) {
            v v1 = new v("com.iloen.melon", v, notification0);
            synchronized(z.f) {
                if(z.g == null) {
                    z.g = new y(this.a.getApplicationContext());
                }
                z.g.b.obtainMessage(0, v1).sendToTarget();
            }
            notificationManager0.cancel(null, v);
            return;
        }
        notificationManager0.notify(null, v, notification0);
    }
}

