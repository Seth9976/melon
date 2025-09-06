package com.gaa.sdk.iap;

import E9.g;
import E9.t;
import K5.c;
import M6.u;
import Z8.e;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import com.iloen.melon.utils.log.LogU;
import y5.a;

public final class i implements ServiceConnection {
    public final Object a;
    public boolean b;
    public e c;
    public final j d;

    public i(j j0, e e0) {
        this.d = j0;
        this.a = new Object();
        this.b = false;
        this.c = e0;
    }

    public final void a(d d0) {
        g g0 = this.d.j;
        u u0 = new u(this, d0, false, 15);
        g0.getClass();
        if(Thread.interrupted()) {
            return;
        }
        ((Handler)g0.a).post(u0);
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
        c c0;
        a.X("PurchaseClientImpl", "Purchasing service connected.");
        if(iBinder0 == null) {
            c0 = null;
        }
        else {
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.gaa.extern.iap.IGlobalInAppService");
            if(iInterface0 == null || !(iInterface0 instanceof c)) {
                c0 = new K5.a();  // 初始化器: Ljava/lang/Object;-><init>()V
                c0.a = iBinder0;
            }
            else {
                c0 = (c)iInterface0;
            }
        }
        j j0 = this.d;
        j0.f = c0;
        V2.d d0 = new V2.d(this, 2);
        t t0 = new t(this, 13);
        if(j0.j.f(d0, 30000L, t0) == null) {
            this.a(j0.b());
        }
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName0) {
        a.Y("PurchaseClientImpl", "Purchasing service disconnected");
        this.d.f = null;
        this.d.a = 0;
        synchronized(this.a) {
            e e0 = this.c;
            if(e0 != null) {
                LogU.Companion.d("OneStoreIapClientLifecycle", "onServiceDisconnected()");
                e0.a.g = false;
            }
        }
    }
}

