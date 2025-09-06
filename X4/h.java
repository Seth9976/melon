package X4;

import U4.w;
import android.content.Intent;
import android.os.PowerManager.WakeLock;
import androidx.room.Q;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import e5.l;
import java.util.ArrayList;

public final class h implements Runnable {
    public final int a;
    public final j b;

    public h(j j0, int v) {
        this.a = v;
        this.b = j0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            j j0 = this.b;
            w.e().a("WM-SystemAlarmDispatche", "Checking if commands are complete.");
            j.b();
            ArrayList arrayList0 = j0.g;
            synchronized(arrayList0) {
                if(j0.h != null) {
                    w.e().a("WM-SystemAlarmDispatche", "Removing command " + j0.h);
                    if(!((Intent)j0.g.remove(0)).equals(j0.h)) {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                    j0.h = null;
                }
                Q q0 = j0.b.a;
                Object object0 = j0.f.c;
                synchronized(object0) {
                    boolean z = j0.f.b.isEmpty();
                }
                if(!z || !j0.g.isEmpty()) {
                label_40:
                    if(!j0.g.isEmpty()) {
                        j0.c();
                    }
                }
                else {
                    Object object1 = q0.e;
                    synchronized(object1) {
                        boolean z1 = q0.b.isEmpty();
                    }
                    if(z1) {
                        w.e().a("WM-SystemAlarmDispatche", "No more commands & intents.");
                        SystemAlarmService systemAlarmService0 = j0.i;
                        if(systemAlarmService0 != null) {
                            systemAlarmService0.a();
                        }
                    }
                    else {
                        goto label_40;
                    }
                }
            }
            return;
        }
        synchronized(this.b.g) {
            this.b.h = (Intent)this.b.g.get(0);
        }
        Intent intent0 = this.b.h;
        if(intent0 != null) {
            String s = intent0.getAction();
            int v2 = this.b.h.getIntExtra("KEY_START_ID", 0);
            w.e().a("WM-SystemAlarmDispatche", "Processing command " + this.b.h + ", " + v2);
            PowerManager.WakeLock powerManager$WakeLock0 = l.a(this.b.a, s + " (" + v2 + ")");
            try {
                w.e().a("WM-SystemAlarmDispatche", "Acquiring operation wake lock (" + s + ") " + powerManager$WakeLock0);
                powerManager$WakeLock0.acquire();
                this.b.f.a(this.b.h, v2, this.b);
            }
            catch(Throwable throwable2) {
                w.e().d("WM-SystemAlarmDispatche", "Unexpected error in onHandleIntent", throwable2);
            }
            finally {
                w.e().a("WM-SystemAlarmDispatche", "Releasing operation wake lock (" + s + ") " + powerManager$WakeLock0);
                powerManager$WakeLock0.release();
                h h0 = new h(this.b, 1);
                this.b.b.d.execute(h0);
            }
        }
    }
}

