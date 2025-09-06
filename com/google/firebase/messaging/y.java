package com.google.firebase.messaging;

import A6.e;
import V4.b;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager.WakeLock;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.appevents.c;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.iloen.melon.utils.a;
import i.n.i.b.a.s.e.D3;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k8.Y;

public final class y implements Runnable {
    public final int a;
    public final long b;
    public final Object c;
    public final Object d;
    public final Object e;

    public y(b b0, long v, e e0, c c0) {
        this.a = 1;
        super();
        this.e = b0;
        this.b = v;
        this.c = e0;
        this.d = c0;
    }

    public y(FirebaseMessaging firebaseMessaging0, long v) {
        this.a = 0;
        super();
        this.e = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));
        this.d = firebaseMessaging0;
        this.b = v;
        PowerManager.WakeLock powerManager$WakeLock0 = ((PowerManager)firebaseMessaging0.b.getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.c = powerManager$WakeLock0;
        powerManager$WakeLock0.setReferenceCounted(false);
    }

    public boolean a() {
        ConnectivityManager connectivityManager0 = (ConnectivityManager)((FirebaseMessaging)this.d).b.getSystemService("connectivity");
        NetworkInfo networkInfo0 = connectivityManager0 == null ? null : connectivityManager0.getActiveNetworkInfo();
        return networkInfo0 != null && networkInfo0.isConnected();
    }

    public boolean b() {
        try {
            if(((FirebaseMessaging)this.d).a() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            }
            if(Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Token successfully retrieved");
            }
            return true;
        }
        catch(IOException iOException0) {
        }
        catch(SecurityException unused_ex) {
            Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
        String s = iOException0.getMessage();
        if(!"SERVICE_NOT_AVAILABLE".equals(s) && !"INTERNAL_SERVER_ERROR".equals(s) && !"InternalServerError".equals(s)) {
            if(iOException0.getMessage() != null) {
                throw iOException0;
            }
            Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
            return false;
        }
        Log.w("FirebaseMessaging", "Token retrieval failed: " + iOException0.getMessage() + ". Will retry token retrieval");
        return false;
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            long v = SystemClock.elapsedRealtime() - this.b;
            D3 d30 = (D3)((e)this.c).c;
            int v1 = ((e)this.c).b;
            long v2 = d30.I.a ? d30.I.b : -1L;
            long v3 = 1000L * v2 / ((long)(v1 / 8));
            if(v3 < 500L && v < 500L && !d30.y0) {
                ((b)this.e).a.postDelayed(this, 20L);
                return;
            }
            StringBuilder stringBuilder0 = Y.o(v2, "wrapper prepared: tx=", " roughDurationMs=");
            stringBuilder0.append(v3);
            a.s(v, " elapsed=", " stream=", stringBuilder0);
            stringBuilder0.append(v1);
            stringBuilder0.append(" actual=");
            stringBuilder0.append(v2 * 8000L / (v + 1L));
            Log.d("HlsSampleStreamWrapper", stringBuilder0.toString());
            ((c)this.d).run();
            return;
        }
        PowerManager.WakeLock powerManager$WakeLock0 = (PowerManager.WakeLock)this.c;
        u u0 = u.m();
        FirebaseMessaging firebaseMessaging0 = (FirebaseMessaging)this.d;
        if(u0.r(firebaseMessaging0.b)) {
            powerManager$WakeLock0.acquire();
        }
        try {
            synchronized(firebaseMessaging0) {
                firebaseMessaging0.i = true;
            }
            if(!firebaseMessaging0.h.n()) {
                goto label_41;
            }
            else if(!u.m().q(firebaseMessaging0.b) || this.a()) {
                if(this.b()) {
                    synchronized(firebaseMessaging0) {
                        firebaseMessaging0.i = false;
                    }
                }
                else {
                    firebaseMessaging0.h(this.b);
                }
                goto label_34;
            }
            else {
                goto label_36;
            }
            return;
        }
        catch(IOException iOException0) {
            goto label_46;
        }
        catch(Throwable throwable0) {
            goto label_53;
        }
    label_34:
        if(u.m().r(firebaseMessaging0.b)) {
            powerManager$WakeLock0.release();
            return;
            try {
            label_36:
                x x0 = new x();  // 初始化器: Landroid/content/BroadcastReceiver;-><init>()V
                x0.a = this;
                x0.a();
            }
            catch(IOException iOException0) {
                goto label_46;
            }
            catch(Throwable throwable0) {
                goto label_53;
            }
            if(u.m().r(firebaseMessaging0.b)) {
                powerManager$WakeLock0.release();
                return;
                try {
                    try {
                    label_41:
                        synchronized(firebaseMessaging0) {
                            firebaseMessaging0.i = false;
                        }
                        goto label_56;
                    }
                    catch(IOException iOException0) {
                    }
                label_46:
                    Log.e("FirebaseMessaging", "Topic sync or token retrieval failed on hard failure exceptions: " + iOException0.getMessage() + ". Won\'t retry the operation.");
                    synchronized(firebaseMessaging0) {
                        firebaseMessaging0.i = false;
                    }
                }
                catch(Throwable throwable0) {
                    goto label_53;
                }
                if(u.m().r(firebaseMessaging0.b)) {
                    powerManager$WakeLock0.release();
                    return;
                }
                return;
            label_53:
                if(u.m().r(firebaseMessaging0.b)) {
                    powerManager$WakeLock0.release();
                }
                throw throwable0;
            label_56:
                if(u.m().r(firebaseMessaging0.b)) {
                    powerManager$WakeLock0.release();
                }
            }
        }
    }
}

