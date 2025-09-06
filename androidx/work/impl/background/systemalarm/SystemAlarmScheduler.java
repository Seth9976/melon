package androidx.work.impl.background.systemalarm;

import U4.w;
import V4.h;
import X4.b;
import android.content.Context;
import android.content.Intent;
import d5.j;
import d5.q;
import d5.t;

public class SystemAlarmScheduler implements h {
    public final Context a;
    public static final String b;

    static {
        SystemAlarmScheduler.b = "WM-SystemAlarmScheduler";
    }

    public SystemAlarmScheduler(Context context0) {
        this.a = context0.getApplicationContext();
    }

    @Override  // V4.h
    public final void b(String s) {
        Intent intent0 = new Intent(this.a, SystemAlarmService.class);
        intent0.setAction("ACTION_STOP_WORK");
        intent0.putExtra("KEY_WORKSPEC_ID", s);
        this.a.startService(intent0);
    }

    @Override  // V4.h
    public final boolean c() {
        return true;
    }

    @Override  // V4.h
    public final void d(q[] arr_q) {
        for(int v = 0; v < arr_q.length; ++v) {
            q q0 = arr_q[v];
            w.e().a("WM-SystemAlarmScheduler", "Scheduling work with workSpecId " + q0.a);
            j j0 = t.i(q0);
            Intent intent0 = new Intent(this.a, SystemAlarmService.class);
            intent0.setAction("ACTION_SCHEDULE_WORK");
            b.c(intent0, j0);
            this.a.startService(intent0);
        }
    }
}

