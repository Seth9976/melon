package c5;

import Q8.h;
import U4.m;
import U4.w;
import U4.x;
import V4.c;
import V4.k;
import V4.s;
import Z4.b;
import Z4.j;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import androidx.work.impl.foreground.SystemForegroundService;
import com.google.android.material.bottomappbar.f;
import d5.q;
import d5.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import kotlinx.coroutines.Job;

public final class a implements c, j {
    public final s a;
    public final f5.a b;
    public final Object c;
    public d5.j d;
    public final LinkedHashMap e;
    public final HashMap f;
    public final HashMap g;
    public final h h;
    public SystemForegroundService i;
    public static final String j;

    static {
        a.j = "WM-SystemFgDispatcher";
    }

    public a(Context context0) {
        this.c = new Object();
        s s0 = s.c0(context0);
        this.a = s0;
        this.b = s0.k;
        this.d = null;
        this.e = new LinkedHashMap();
        this.g = new HashMap();
        this.f = new HashMap();
        this.h = new h(s0.q);
        s0.m.a(this);
    }

    @Override  // Z4.j
    public final void a(q q0, Z4.c c0) {
        if(c0 instanceof b) {
            w.e().a("WM-SystemFgDispatcher", "Constraints unmet for WorkSpec " + q0.a);
            k k0 = new k(t.i(q0));
            f f0 = new f(this.a.m, k0, true, ((b)c0).a);
            this.a.k.a(f0);
        }
    }

    public static Intent b(Context context0, d5.j j0, m m0) {
        Intent intent0 = new Intent(context0, SystemForegroundService.class);
        intent0.setAction("ACTION_START_FOREGROUND");
        intent0.putExtra("KEY_WORKSPEC_ID", j0.a);
        intent0.putExtra("KEY_GENERATION", j0.b);
        intent0.putExtra("KEY_NOTIFICATION_ID", m0.a);
        intent0.putExtra("KEY_FOREGROUND_SERVICE_TYPE", m0.b);
        intent0.putExtra("KEY_NOTIFICATION", m0.c);
        return intent0;
    }

    public final void c(Intent intent0) {
        if(this.i == null) {
            throw new IllegalStateException("handleNotify was called on the destroyed dispatcher");
        }
        int v = 0;
        int v1 = intent0.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int v2 = intent0.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String s = intent0.getStringExtra("KEY_WORKSPEC_ID");
        d5.j j0 = new d5.j(s, intent0.getIntExtra("KEY_GENERATION", 0));
        Notification notification0 = (Notification)intent0.getParcelableExtra("KEY_NOTIFICATION");
        w w0 = w.e();
        StringBuilder stringBuilder0 = x.o(v1, "Notifying with (id:", ", workSpecId: ", s, ", notificationType :");
        stringBuilder0.append(v2);
        stringBuilder0.append(")");
        w0.a("WM-SystemFgDispatcher", stringBuilder0.toString());
        if(notification0 == null) {
            throw new IllegalArgumentException("Notification passed in the intent was null.");
        }
        m m0 = new m(v1, notification0, v2);
        LinkedHashMap linkedHashMap0 = this.e;
        linkedHashMap0.put(j0, m0);
        m m1 = (m)linkedHashMap0.get(this.d);
        if(m1 == null) {
            this.d = j0;
        }
        else {
            this.i.c.notify(v1, notification0);
            if(Build.VERSION.SDK_INT >= 29) {
                for(Object object0: linkedHashMap0.entrySet()) {
                    v |= ((m)((Map.Entry)object0).getValue()).b;
                }
                m0 = new m(m1.a, m1.c, v);
            }
            else {
                m0 = m1;
            }
        }
        SystemForegroundService systemForegroundService0 = this.i;
        int v3 = m0.a;
        int v4 = m0.b;
        Notification notification1 = m0.c;
        systemForegroundService0.getClass();
        int v5 = Build.VERSION.SDK_INT;
        if(v5 >= 0x1F) {
            S1.b.m(systemForegroundService0, v3, notification1, v4);
            return;
        }
        if(v5 >= 29) {
            S1.b.l(systemForegroundService0, v3, notification1, v4);
            return;
        }
        systemForegroundService0.startForeground(v3, notification1);
    }

    public final void d() {
        this.i = null;
        synchronized(this.c) {
            for(Object object1: this.g.values()) {
                ((Job)object1).cancel(null);
            }
        }
        this.a.m.e(this);
    }

    @Override  // V4.c
    public final void e(d5.j j0, boolean z) {
        synchronized(this.c) {
            Job job0 = ((q)this.f.remove(j0)) == null ? null : ((Job)this.g.remove(j0));
            if(job0 != null) {
                job0.cancel(null);
            }
        }
        m m0 = (m)this.e.remove(j0);
        if(j0.equals(this.d)) {
            if(this.e.size() > 0) {
                Iterator iterator0 = this.e.entrySet().iterator();
                Object object1 = iterator0.next();
                Map.Entry map$Entry0;
                for(map$Entry0 = (Map.Entry)object1; iterator0.hasNext(); map$Entry0 = (Map.Entry)object2) {
                    Object object2 = iterator0.next();
                }
                this.d = (d5.j)map$Entry0.getKey();
                if(this.i != null) {
                    m m1 = (m)map$Entry0.getValue();
                    SystemForegroundService systemForegroundService0 = this.i;
                    int v1 = m1.a;
                    int v2 = m1.b;
                    Notification notification0 = m1.c;
                    systemForegroundService0.getClass();
                    int v3 = Build.VERSION.SDK_INT;
                    if(v3 >= 0x1F) {
                        S1.b.m(systemForegroundService0, v1, notification0, v2);
                    }
                    else if(v3 >= 29) {
                        S1.b.l(systemForegroundService0, v1, notification0, v2);
                    }
                    else {
                        systemForegroundService0.startForeground(v1, notification0);
                    }
                    this.i.c.cancel(m1.a);
                }
            }
            else {
                this.d = null;
            }
        }
        SystemForegroundService systemForegroundService1 = this.i;
        if(m0 != null && systemForegroundService1 != null) {
            w.e().a("WM-SystemFgDispatcher", "Removing Notification (id: " + m0.a + ", workSpecId: " + j0 + ", notificationType: " + m0.b);
            systemForegroundService1.c.cancel(m0.a);
        }
    }

    public final void f(int v) {
        w.e().f("WM-SystemFgDispatcher", "Foreground service timed out, FGS type: " + v);
        for(Object object0: this.e.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            if(((m)map$Entry0.getValue()).b == v) {
                k k0 = new k(((d5.j)map$Entry0.getKey()));
                f f0 = new f(this.a.m, k0, true, 0xFFFFFF80);
                this.a.k.a(f0);
            }
        }
        SystemForegroundService systemForegroundService0 = this.i;
        if(systemForegroundService0 != null) {
            systemForegroundService0.a = true;
            w.e().a("WM-SystemFgService", "Shutting down.");
            systemForegroundService0.stopForeground(true);
            systemForegroundService0.stopSelf();
        }
    }
}

