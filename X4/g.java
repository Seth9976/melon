package X4;

import Q5.s;
import Q8.h;
import U4.w;
import U4.x;
import V4.k;
import Z4.a;
import Z4.c;
import Z4.j;
import Z4.n;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager.WakeLock;
import androidx.room.Q;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import d5.q;
import e5.l;
import e5.r;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;

public final class g implements j, r {
    public final Context a;
    public final int b;
    public final d5.j c;
    public final X4.j d;
    public final h e;
    public final Object f;
    public int g;
    public final Q h;
    public final s i;
    public PowerManager.WakeLock j;
    public boolean k;
    public final k l;
    public final CoroutineDispatcher m;
    public volatile Job n;
    public static final String o;

    static {
        g.o = "WM-DelayMetCommandHandl";
    }

    public g(Context context0, int v, X4.j j0, k k0) {
        this.a = context0;
        this.b = v;
        this.d = j0;
        this.c = k0.a;
        this.l = k0;
        this.h = j0.b.a;
        this.i = j0.b.d;
        this.m = j0.b.b;
        this.e = new h(j0.e.q);
        this.k = false;
        this.g = 0;
        this.f = new Object();
    }

    @Override  // Z4.j
    public final void a(q q0, c c0) {
        Q q1 = this.h;
        if(c0 instanceof a) {
            q1.execute(new f(this, 1));
            return;
        }
        q1.execute(new f(this, 0));
    }

    public static void b(g g0) {
        int v = g0.b;
        s s0 = g0.i;
        Context context0 = g0.a;
        X4.j j0 = g0.d;
        d5.j j1 = g0.c;
        String s1 = j1.a;
        if(g0.g < 2) {
            g0.g = 2;
            w.e().a("WM-DelayMetCommandHandl", "Stopping work for WorkSpec " + s1);
            Intent intent0 = new Intent(context0, SystemAlarmService.class);
            intent0.setAction("ACTION_STOP_WORK");
            b.c(intent0, j1);
            s0.execute(new i(j0, intent0, v, 0));
            synchronized(j0.d.k) {
                boolean z = j0.d.c(j1.a) != null;
            }
            if(z) {
                w.e().a("WM-DelayMetCommandHandl", "WorkSpec " + s1 + " needs to be rescheduled");
                Intent intent1 = new Intent(context0, SystemAlarmService.class);
                intent1.setAction("ACTION_SCHEDULE_WORK");
                b.c(intent1, j1);
                s0.execute(new i(j0, intent1, v, 0));
                return;
            }
            w.e().a("WM-DelayMetCommandHandl", "Processor does not have WorkSpec " + s1 + ". No need to reschedule");
            return;
        }
        w.e().a("WM-DelayMetCommandHandl", "Already stopped work for " + s1);
    }

    public static void c(g g0) {
        if(g0.g == 0) {
            g0.g = 1;
            w.e().a("WM-DelayMetCommandHandl", "onAllConstraintsMet for " + g0.c);
            if(g0.d.d.f(g0.l, null)) {
                synchronized(g0.d.c.d) {
                    w.e().a("WM-WorkTimer", "Starting timer for " + g0.c);
                    g0.d.c.a(g0.c);
                    e5.s s0 = new e5.s(g0.d.c, g0.c);
                    g0.d.c.b.put(g0.c, s0);
                    g0.d.c.c.put(g0.c, g0);
                    g0.d.c.a.a.postDelayed(s0, 600000L);
                }
                return;
            }
            g0.d();
            return;
        }
        w.e().a("WM-DelayMetCommandHandl", "Already started work for " + g0.c);
    }

    public final void d() {
        synchronized(this.f) {
            if(this.n != null) {
                this.n.cancel(null);
            }
            this.d.c.a(this.c);
            if(this.j != null && this.j.isHeld()) {
                w.e().a("WM-DelayMetCommandHandl", "Releasing wakelock " + this.j + "for WorkSpec " + this.c);
                this.j.release();
            }
        }
    }

    public final void e() {
        String s = this.c.a;
        StringBuilder stringBuilder0 = x.p(s, " (");
        stringBuilder0.append(this.b);
        stringBuilder0.append(")");
        this.j = l.a(this.a, stringBuilder0.toString());
        w.e().a("WM-DelayMetCommandHandl", "Acquiring wakelock " + this.j + "for WorkSpec " + s);
        this.j.acquire();
        q q0 = this.d.e.j.g().j(s);
        if(q0 == null) {
            f f0 = new f(this, 0);
            this.h.execute(f0);
            return;
        }
        boolean z = q0.b();
        this.k = z;
        if(!z) {
            w.e().a("WM-DelayMetCommandHandl", "No constraints for " + s);
            f f1 = new f(this, 1);
            this.h.execute(f1);
            return;
        }
        this.n = n.a(this.e, q0, this.m, this);
    }

    public final void f(boolean z) {
        w w0 = w.e();
        d5.j j0 = this.c;
        w0.a("WM-DelayMetCommandHandl", "onExecuted " + j0 + ", " + z);
        this.d();
        Class class0 = SystemAlarmService.class;
        int v = this.b;
        X4.j j1 = this.d;
        s s0 = this.i;
        Context context0 = this.a;
        if(z) {
            Intent intent0 = new Intent(context0, class0);
            intent0.setAction("ACTION_SCHEDULE_WORK");
            b.c(intent0, j0);
            s0.execute(new i(j1, intent0, v, 0));
        }
        if(this.k) {
            Intent intent1 = new Intent(context0, class0);
            intent1.setAction("ACTION_CONSTRAINTS_CHANGED");
            s0.execute(new i(j1, intent1, v, 0));
        }
    }
}

