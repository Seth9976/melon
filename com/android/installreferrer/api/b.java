package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import c6.c;
import e2.a;

public final class b implements ServiceConnection {
    public final InstallReferrerStateListener a;
    public final InstallReferrerClientImpl b;

    public b(InstallReferrerClientImpl installReferrerClientImpl0, InstallReferrerStateListener installReferrerStateListener0) {
        this.b = installReferrerClientImpl0;
        this.a = installReferrerStateListener0;
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
        c c0;
        a.L("Install Referrer service connected.");
        if(iBinder0 == null) {
            c0 = null;
        }
        else {
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            c0 = iInterface0 instanceof c ? ((c)iInterface0) : new c6.a(iBinder0);
        }
        this.b.c = c0;
        this.b.a = 2;
        this.a.onInstallReferrerSetupFinished(0);
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName0) {
        a.M("Install Referrer service disconnected.");
        this.b.c = null;
        this.b.a = 0;
        this.a.onInstallReferrerServiceDisconnected();
    }
}

