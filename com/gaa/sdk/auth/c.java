package com.gaa.sdk.auth;

import E9.g;
import E9.t;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import y5.a;

public final class c implements ServiceConnection {
    public final Object a;
    public final b b;
    public final d c;

    public c(d d0, b b0) {
        this.c = d0;
        this.a = new Object();
        this.b = b0;
    }

    public final void a(e e0, Intent intent0) {
        g g0 = this.c.f;
        X4.d d0 = new X4.d(this, e0, intent0);
        g0.getClass();
        if(Thread.interrupted()) {
            return;
        }
        ((Handler)g0.a).post(d0);
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
        J5.c c0;
        a.X("GaaSignInClientImpl", "service connected.");
        if(iBinder0 == null) {
            c0 = null;
        }
        else {
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.gaa.extern.auth.IGlobalAuthService");
            if(iInterface0 == null || !(iInterface0 instanceof J5.c)) {
                c0 = new J5.a();  // 初始化器: Ljava/lang/Object;-><init>()V
                c0.a = iBinder0;
            }
            else {
                c0 = (J5.c)iInterface0;
            }
        }
        d d0 = this.c;
        d0.c = c0;
        d0.a = 2;
        V2.d d1 = new V2.d(this, 1);
        t t0 = new t(this, 11);
        if(d0.f.f(d1, 30000L, t0) == null) {
            this.a((d0.a == 0 || d0.a == 3 ? d.c(2) : d.c(6)), null);
        }
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName0) {
        a.X("GaaSignInClientImpl", "Service unexpectedly disconnected.");
        this.c.a = 0;
        this.c.c = null;
    }
}

