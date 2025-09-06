package androidx.work.impl.foreground;

import G.g;
import H0.e;
import M6.u;
import U4.w;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleService;
import c5.a;
import java.util.UUID;
import kotlin.jvm.internal.q;

public class SystemForegroundService extends LifecycleService {
    public boolean a;
    public a b;
    public NotificationManager c;
    public static final String d;

    static {
        SystemForegroundService.d = "WM-SystemFgService";
    }

    public final void a() {
        this.c = (NotificationManager)this.getApplicationContext().getSystemService("notification");
        a a0 = new a(this.getApplicationContext());
        this.b = a0;
        if(a0.i != null) {
            w.e().c("WM-SystemFgDispatcher", "A callback already exists.");
            return;
        }
        a0.i = this;
    }

    @Override  // androidx.lifecycle.LifecycleService
    public final void onCreate() {
        super.onCreate();
        this.a();
    }

    @Override  // androidx.lifecycle.LifecycleService
    public final void onDestroy() {
        super.onDestroy();
        this.b.d();
    }

    @Override  // androidx.lifecycle.LifecycleService
    public final int onStartCommand(Intent intent0, int v, int v1) {
        super.onStartCommand(intent0, v, v1);
        if(this.a) {
            w.e().f("WM-SystemFgService", "Re-initializing SystemForegroundService after a request to shut-down.");
            this.b.d();
            this.a();
            this.a = false;
        }
        if(intent0 != null) {
            a a0 = this.b;
            a0.getClass();
            String s = intent0.getAction();
            if("ACTION_START_FOREGROUND".equals(s)) {
                w.e().f("WM-SystemFgDispatcher", "Started foreground service " + intent0);
                u u0 = new u(a0, intent0.getStringExtra("KEY_WORKSPEC_ID"), false, 12);
                a0.b.a(u0);
                a0.c(intent0);
                return 3;
            }
            if("ACTION_NOTIFY".equals(s)) {
                a0.c(intent0);
                return 3;
            }
            if("ACTION_CANCEL_WORK".equals(s)) {
                w.e().f("WM-SystemFgDispatcher", "Stopping foreground work for " + intent0);
                String s1 = intent0.getStringExtra("KEY_WORKSPEC_ID");
                if(s1 != null && !TextUtils.isEmpty(s1)) {
                    UUID uUID0 = UUID.fromString(s1);
                    a0.a.getClass();
                    q.g(uUID0, "id");
                    q.f(a0.a.k.a, "workManagerImpl.workTask…ecutor.serialTaskExecutor");
                    g g0 = new g(28, a0.a, uUID0);
                    e.O(a0.a.i.m, "CancelWorkById", a0.a.k.a, g0);
                    return 3;
                }
            }
            else if("ACTION_STOP_FOREGROUND".equals(s)) {
                w.e().f("WM-SystemFgDispatcher", "Stopping foreground service");
                SystemForegroundService systemForegroundService0 = a0.i;
                if(systemForegroundService0 != null) {
                    systemForegroundService0.a = true;
                    w.e().a("WM-SystemFgService", "Shutting down.");
                    systemForegroundService0.stopForeground(true);
                    systemForegroundService0.stopSelf();
                }
            }
        }
        return 3;
    }

    @Override  // android.app.Service
    public final void onTimeout(int v) {
        if(Build.VERSION.SDK_INT >= 35) {
            return;
        }
        this.b.f(0x800);
    }

    @Override  // android.app.Service
    public final void onTimeout(int v, int v1) {
        this.b.f(v1);
    }
}

