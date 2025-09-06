package androidx.appcompat.app;

import Q0.a;
import V4.u;
import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.PowerManager;
import android.util.Log;
import java.util.Calendar;
import y8.s;

public final class y extends a {
    public final int c;
    public final D d;
    public final Object e;

    public y(D d0, Context context0) {
        this.c = 0;
        this.d = d0;
        super(d0);
        this.e = (PowerManager)context0.getApplicationContext().getSystemService("power");
    }

    public y(D d0, s s0) {
        this.c = 1;
        this.d = d0;
        super(d0);
        this.e = s0;
    }

    @Override  // Q0.a
    public final IntentFilter e() {
        if(this.c != 0) {
            IntentFilter intentFilter0 = new IntentFilter();
            intentFilter0.addAction("android.intent.action.TIME_SET");
            intentFilter0.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter0.addAction("android.intent.action.TIME_TICK");
            return intentFilter0;
        }
        IntentFilter intentFilter1 = new IntentFilter();
        intentFilter1.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        return intentFilter1;
    }

    @Override  // Q0.a
    public final int g() {
        long v4;
        Location location2;
        Location location1;
        if(this.c != 0) {
            s s0 = (s)this.e;
            M m0 = (M)s0.c;
            LocationManager locationManager0 = (LocationManager)s0.b;
            if(Long.compare(m0.b, System.currentTimeMillis()) > 0) {
                return m0.a ? 2 : 1;
            }
            Context context0 = (Context)s0.a;
            Location location0 = null;
            if(u.l(context0, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                try {
                    if(locationManager0.isProviderEnabled("network")) {
                        location1 = locationManager0.getLastKnownLocation("network");
                    }
                    else {
                        goto label_16;
                    }
                }
                catch(Exception exception0) {
                    Log.d("TwilightManager", "Failed to get last known location", exception0);
                    location1 = null;
                }
                goto label_17;
            label_16:
                location1 = null;
            label_17:
                location2 = location1;
            }
            else {
                location2 = null;
            }
            if(u.l(context0, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                try {
                    if(locationManager0.isProviderEnabled("gps")) {
                        location0 = locationManager0.getLastKnownLocation("gps");
                    }
                }
                catch(Exception exception1) {
                    Log.d("TwilightManager", "Failed to get last known location", exception1);
                }
            }
            if(location0 == null || location2 == null) {
                if(location0 != null) {
                    location2 = location0;
                }
            }
            else if(location0.getTime() > location2.getTime()) {
                location2 = location0;
            }
            boolean z = false;
            if(location2 != null) {
                long v = System.currentTimeMillis();
                if(L.d == null) {
                    L.d = new L();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                L l0 = L.d;
                l0.a(location2.getLatitude(), location2.getLongitude(), v - 86400000L);
                l0.a(location2.getLatitude(), location2.getLongitude(), v);
                if(l0.c == 1) {
                    z = true;
                }
                long v1 = l0.b;
                long v2 = l0.a;
                l0.a(location2.getLatitude(), location2.getLongitude(), v + 86400000L);
                long v3 = l0.b;
                if(v1 == -1L || v2 == -1L) {
                    v4 = v + 43200000L;
                }
                else {
                    if(v > v2) {
                        v1 = v3;
                    }
                    else if(v > v1) {
                        v1 = v2;
                    }
                    v4 = v1 + 60000L;
                }
                m0.a = z;
                m0.b = v4;
                return z ? 2 : 1;
            }
            Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
            int v5 = Calendar.getInstance().get(11);
            if(v5 < 6 || v5 >= 22) {
                z = true;
            }
            return z ? 2 : 1;
        }
        return t.a(((PowerManager)this.e)) ? 2 : 1;
    }

    @Override  // Q0.a
    public final void o() {
        if(this.c != 0) {
            this.d.o(true, true);
            return;
        }
        this.d.o(true, true);
    }
}

