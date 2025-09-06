package X4;

import D2.E0;
import U4.w;
import V4.c;
import V4.f;
import V4.s;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import d5.v;
import e5.l;
import e5.t;
import f5.a;
import java.util.ArrayList;

public final class j implements c {
    public final Context a;
    public final a b;
    public final t c;
    public final f d;
    public final s e;
    public final b f;
    public final ArrayList g;
    public Intent h;
    public SystemAlarmService i;
    public final ea.a j;
    public static final String k;

    static {
        j.k = "WM-SystemAlarmDispatche";
    }

    public j(SystemAlarmService systemAlarmService0) {
        Context context0 = systemAlarmService0.getApplicationContext();
        this.a = context0;
        v v0 = new v(new E0(1));
        s s0 = s.c0(systemAlarmService0);
        this.e = s0;
        this.f = new b(context0, s0.i.d, v0);
        this.c = new t(s0.i.g);
        this.d = s0.m;
        this.b = s0.k;
        this.j = new ea.a(s0.m, s0.k);
        s0.m.a(this);
        this.g = new ArrayList();
        this.h = null;
    }

    public final void a(int v, Intent intent0) {
        w.e().a("WM-SystemAlarmDispatche", "Adding command " + intent0 + " (" + v + ")");
        j.b();
        String s = intent0.getAction();
        if(TextUtils.isEmpty(s)) {
            w.e().h("WM-SystemAlarmDispatche", "Unknown command. Ignoring");
            return;
        }
        if("ACTION_CONSTRAINTS_CHANGED".equals(s)) {
            j.b();
            synchronized(this.g) {
                for(Object object0: this.g) {
                    if("ACTION_CONSTRAINTS_CHANGED".equals(((Intent)object0).getAction())) {
                        return;
                    }
                    if(false) {
                        break;
                    }
                }
            }
        }
        intent0.putExtra("KEY_START_ID", v);
        synchronized(this.g) {
            this.g.add(intent0);
            if(this.g.isEmpty()) {
                this.c();
            }
        }
    }

    public static void b() {
        if(Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public final void c() {
        j.b();
        PowerManager.WakeLock powerManager$WakeLock0 = l.a(this.a, "ProcessCommand");
        try {
            powerManager$WakeLock0.acquire();
            h h0 = new h(this, 0);
            this.e.k.a(h0);
        }
        finally {
            powerManager$WakeLock0.release();
        }
    }

    @Override  // V4.c
    public final void e(d5.j j0, boolean z) {
        Intent intent0 = new Intent(this.a, SystemAlarmService.class);
        intent0.setAction("ACTION_EXECUTION_COMPLETED");
        intent0.putExtra("KEY_NEEDS_RESCHEDULE", z);
        b.c(intent0, j0);
        i i0 = new i(this, intent0, 0, 0);
        this.b.d.execute(i0);
    }
}

