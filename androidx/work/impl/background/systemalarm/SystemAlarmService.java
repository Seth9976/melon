package androidx.work.impl.background.systemalarm;

import U4.w;
import X4.j;
import android.content.Intent;
import android.os.PowerManager.WakeLock;
import androidx.lifecycle.LifecycleService;
import e5.m;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class SystemAlarmService extends LifecycleService {
    public j a;
    public boolean b;
    public static final String c;

    static {
        SystemAlarmService.c = "WM-SystemAlarmService";
    }

    public final void a() {
        this.b = true;
        w.e().a("WM-SystemAlarmService", "All commands completed in dispatcher");
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        synchronized(m.a) {
            linkedHashMap0.putAll(m.b);
        }
        for(Object object0: linkedHashMap0.entrySet()) {
            PowerManager.WakeLock powerManager$WakeLock0 = (PowerManager.WakeLock)((Map.Entry)object0).getKey();
            String s = (String)((Map.Entry)object0).getValue();
            if(powerManager$WakeLock0 != null && powerManager$WakeLock0.isHeld()) {
                w.e().h("WM-WakeLocks", "WakeLock held for " + s);
            }
        }
        this.stopSelf();
    }

    @Override  // androidx.lifecycle.LifecycleService
    public final void onCreate() {
        super.onCreate();
        j j0 = new j(this);
        this.a = j0;
        if(j0.i == null) {
            j0.i = this;
        }
        else {
            w.e().c("WM-SystemAlarmDispatche", "A completion listener for SystemAlarmDispatcher already exists.");
        }
        this.b = false;
    }

    @Override  // androidx.lifecycle.LifecycleService
    public final void onDestroy() {
        super.onDestroy();
        this.b = true;
        j j0 = this.a;
        j0.getClass();
        w.e().a("WM-SystemAlarmDispatche", "Destroying SystemAlarmDispatcher");
        j0.d.e(j0);
        j0.i = null;
    }

    @Override  // androidx.lifecycle.LifecycleService
    public final int onStartCommand(Intent intent0, int v, int v1) {
        super.onStartCommand(intent0, v, v1);
        if(this.b) {
            w.e().f("WM-SystemAlarmService", "Re-initializing SystemAlarmDispatcher after a request to shut-down.");
            j j0 = this.a;
            j0.getClass();
            w.e().a("WM-SystemAlarmDispatche", "Destroying SystemAlarmDispatcher");
            j0.d.e(j0);
            j0.i = null;
            j j1 = new j(this);
            this.a = j1;
            if(j1.i == null) {
                j1.i = this;
            }
            else {
                w.e().c("WM-SystemAlarmDispatche", "A completion listener for SystemAlarmDispatcher already exists.");
            }
            this.b = false;
        }
        if(intent0 != null) {
            this.a.a(v1, intent0);
        }
        return 3;
    }
}

