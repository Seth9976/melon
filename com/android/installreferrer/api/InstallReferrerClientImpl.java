package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.RemoteException;
import c6.c;
import e2.a;
import java.util.List;

class InstallReferrerClientImpl extends InstallReferrerClient {
    public int a;
    public final Context b;
    public c c;
    public b d;

    public InstallReferrerClientImpl(Context context0) {
        this.a = 0;
        this.b = context0.getApplicationContext();
    }

    @Override  // com.android.installreferrer.api.InstallReferrerClient
    public final void a() {
        this.a = 3;
        if(this.d != null) {
            a.L("Unbinding from service.");
            this.b.unbindService(this.d);
            this.d = null;
        }
        this.c = null;
    }

    @Override  // com.android.installreferrer.api.InstallReferrerClient
    public final ReferrerDetails b() {
        if(this.a == 2 && this.c != null && this.d != null) {
            Bundle bundle0 = new Bundle();
            bundle0.putString("package_name", "com.iloen.melon");
            try {
                return new ReferrerDetails(((c6.a)this.c).C0(bundle0));
            }
            catch(RemoteException remoteException0) {
                a.M("RemoteException getting install referrer information");
                this.a = 0;
                throw remoteException0;
            }
        }
        throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
    }

    @Override  // com.android.installreferrer.api.InstallReferrerClient
    public final void c(InstallReferrerStateListener installReferrerStateListener0) {
        int v = this.a;
        if(v == 2 && this.c != null && this.d != null) {
            a.L("Service connection is valid. No need to re-initialize.");
            installReferrerStateListener0.onInstallReferrerSetupFinished(0);
            return;
        }
        switch(v) {
            case 1: {
                a.M("Client is already in the process of connecting to the service.");
                installReferrerStateListener0.onInstallReferrerSetupFinished(3);
                return;
            }
            case 3: {
                a.M("Client was already closed and can\'t be reused. Please create another instance.");
                installReferrerStateListener0.onInstallReferrerSetupFinished(3);
                return;
            }
            default: {
                a.L("Starting install referrer service setup.");
                Intent intent0 = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                intent0.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                Context context0 = this.b;
                List list0 = context0.getPackageManager().queryIntentServices(intent0, 0);
                if(list0 != null && !list0.isEmpty()) {
                    ServiceInfo serviceInfo0 = ((ResolveInfo)list0.get(0)).serviceInfo;
                    if(serviceInfo0 != null) {
                        if("com.android.vending".equals(serviceInfo0.packageName) && serviceInfo0.name != null) {
                            PackageManager packageManager0 = context0.getPackageManager();
                            try {
                                if(packageManager0.getPackageInfo("com.android.vending", 0x80).versionCode >= 80837300) {
                                    goto label_17;
                                }
                            }
                            catch(PackageManager.NameNotFoundException unused_ex) {
                            }
                            a.M("Play Store missing or incompatible. Version 8.3.73 or later required.");
                            this.a = 0;
                            installReferrerStateListener0.onInstallReferrerSetupFinished(2);
                            return;
                        label_17:
                            Intent intent1 = new Intent(intent0);
                            b b0 = new b(this, installReferrerStateListener0);
                            this.d = b0;
                            if(context0.bindService(intent1, b0, 1)) {
                                a.L("Service was bonded successfully.");
                                return;
                            }
                            a.M("Connection to service is blocked.");
                            this.a = 0;
                            installReferrerStateListener0.onInstallReferrerSetupFinished(1);
                            return;
                        }
                        a.M("Play Store missing or incompatible. Version 8.3.73 or later required.");
                        this.a = 0;
                        installReferrerStateListener0.onInstallReferrerSetupFinished(2);
                        return;
                    }
                }
                this.a = 0;
                a.L("Install Referrer service unavailable on device.");
                installReferrerStateListener0.onInstallReferrerSetupFinished(2);
            }
        }
    }
}

