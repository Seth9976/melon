package X4;

import M6.u;
import U4.w;
import Z1.f;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import androidx.media3.session.legacy.MediaBrowserServiceCompat;
import androidx.media3.session.legacy.n;
import androidx.media3.session.legacy.p;
import androidx.work.impl.background.systemalarm.ConstraintProxy.BatteryChargingProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy.BatteryNotLowProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy.NetworkStateProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy.StorageNotLowProxy;
import com.gaa.sdk.auth.c;
import com.gaa.sdk.auth.e;
import com.google.android.gms.tasks.TaskCompletionSource;
import e5.j;
import e7.a;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public final class d implements Runnable {
    public final int a;
    public Object b;
    public Object c;
    public Object d;

    public d() {
        this.a = 1;
        super();
    }

    public d(BroadcastReceiver.PendingResult broadcastReceiver$PendingResult0, Context context0, Intent intent0) {
        this.a = 0;
        super();
        this.b = intent0;
        this.c = context0;
        this.d = broadcastReceiver$PendingResult0;
    }

    public d(c c0, e e0, Intent intent0) {
        this.a = 3;
        super();
        this.d = c0;
        this.c = e0;
        this.b = intent0;
    }

    public d(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.d = object0;
        this.b = object1;
        this.c = object2;
        super();
    }

    @Override
    public final void run() {
        Object object0;
        switch(this.a) {
            case 0: {
                BroadcastReceiver.PendingResult broadcastReceiver$PendingResult0 = (BroadcastReceiver.PendingResult)this.d;
                Context context0 = (Context)this.c;
                Intent intent0 = (Intent)this.b;
                try {
                    boolean z = intent0.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                    boolean z1 = intent0.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                    boolean z2 = intent0.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                    boolean z3 = intent0.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                    w.e().a("WM-ConstrntProxyUpdtRec", "Updating proxies: (BatteryNotLowProxy (" + z + "), BatteryChargingProxy (" + z1 + "), StorageNotLowProxy (" + z2 + "), NetworkStateProxy (" + z3 + "), ");
                    j.a(context0, ConstraintProxy.BatteryNotLowProxy.class, z);
                    j.a(context0, ConstraintProxy.BatteryChargingProxy.class, z1);
                    j.a(context0, ConstraintProxy.StorageNotLowProxy.class, z2);
                    j.a(context0, ConstraintProxy.NetworkStateProxy.class, z3);
                }
                finally {
                    broadcastReceiver$PendingResult0.finish();
                }
                return;
            }
            case 1: {
                try {
                    object0 = null;
                    object0 = ((Z1.e)this.b).call();
                }
                catch(Exception unused_ex) {
                }
                ((Handler)this.d).post(new u(8, ((f)this.c), object0));
                return;
            }
            case 2: {
                p p0 = (p)this.d;
                for(Object object1: ((MediaBrowserServiceCompat)p0.d).e.keySet()) {
                    n n0 = (n)((MediaBrowserServiceCompat)p0.d).e.get(((IBinder)object1));
                    n0.getClass();
                    p0.m(n0, ((String)this.b), ((Bundle)this.c));
                }
                return;
            }
            case 3: {
                synchronized(((c)this.d).a) {
                    ((c)this.d).b.c(((e)this.c), ((Intent)this.b));
                }
                return;
            }
            default: {
                l7.c c0 = (l7.c)this.d;
                a a0 = (a)this.b;
                c0.b(a0, ((TaskCompletionSource)this.c));
                ((AtomicInteger)c0.i.b).set(0);
                double f = (double)c0.a();
                double f1 = Math.min(3600000.0, Math.pow(c0.b, f) * (60000.0 / c0.a));
                String s = "Delay for: " + String.format(Locale.US, "%.2f", ((double)(f1 / 1000.0))) + " s for report: " + a0.b;
                if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", s, null);
                }
                try {
                    Thread.sleep(((long)f1));
                }
                catch(InterruptedException unused_ex) {
                }
            }
        }
    }
}

