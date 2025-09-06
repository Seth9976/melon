package a7;

import R6.d;
import android.os.Bundle;
import android.util.Log;
import b7.c;
import d5.l;
import e7.n;
import java.util.ArrayList;
import y8.s;

public final class a implements c7.a, d7.a, y7.a {
    public final b a;

    public a(b b0) {
        this.a = b0;
        super();
    }

    @Override  // y7.a
    public void g(y7.b b0) {
        b b1 = this.a;
        c c0 = c.a;
        c0.b("AnalyticsConnector now available.");
        V6.b b2 = (V6.b)b0.get();
        androidx.lifecycle.b b3 = new androidx.lifecycle.b(b2, 11);
        l l0 = new l(5, false);
        d d0 = ((V6.c)b2).b("clx", l0);
        if(d0 == null) {
            if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Could not register AnalyticsConnectorListener with Crashlytics origin.", null);
            }
            d0 = ((V6.c)b2).b("crash", l0);
            if(d0 != null) {
                Log.w("FirebaseCrashlytics", "A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.", null);
            }
        }
        if(d0 != null) {
            c0.b("Registered Firebase Analytics listener.");
            androidx.lifecycle.b b4 = new androidx.lifecycle.b(10);
            s s0 = new s();  // 初始化器: Ljava/lang/Object;-><init>()V
            s0.b = new Object();
            s0.a = b3;
            synchronized(b1) {
                for(Object object0: ((ArrayList)b1.a)) {
                    b4.t(((n)object0));
                }
                l0.c = b4;
                l0.b = s0;
                b1.c = b4;
                b1.b = s0;
            }
            return;
        }
        c0.f("Could not register Firebase Analytics listener; a listener is already registered.", null);
    }

    @Override  // d7.a
    public void t(n n0) {
        b b0 = this.a;
        synchronized(b0) {
            if(((d7.a)b0.c) instanceof d7.b) {
                ((ArrayList)b0.a).add(n0);
            }
            ((d7.a)b0.c).t(n0);
        }
    }

    @Override  // c7.a
    public void u(Bundle bundle0) {
        ((c7.a)this.a.b).u(bundle0);
    }
}

