package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.Callable;
import jeb.synthetic.FIN;

public final class i implements Callable {
    public final Context a;
    public final Intent b;

    public i(Context context0, Intent intent0) {
        this.a = context0;
        this.b = intent0;
    }

    @Override
    public final Object call() {
        ComponentName componentName0;
        Context context0 = this.a;
        Intent intent0 = this.b;
        u u0 = u.m();
        u0.getClass();
        if(Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Starting service");
        }
        ((ArrayDeque)u0.d).offer(intent0);
        Intent intent1 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent1.setPackage("com.iloen.melon");
        __monitor_enter(u0);
        int v = FIN.finallyOpen$NT();
        String s = (String)u0.a;
        if(s == null) {
            ResolveInfo resolveInfo0 = context0.getPackageManager().resolveService(intent1, 0);
            if(resolveInfo0 == null) {
                Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
            label_34:
                FIN.finallyCodeBegin$NT(v);
                __monitor_exit(u0);
                FIN.finallyCodeEnd$NT(v);
                s = null;
            }
            else {
                ServiceInfo serviceInfo0 = resolveInfo0.serviceInfo;
                if(serviceInfo0 == null) {
                    Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
                    goto label_34;
                }
                else if("com.iloen.melon".equals(serviceInfo0.packageName)) {
                    String s1 = serviceInfo0.name;
                    if(s1 == null) {
                        Log.e("FirebaseMessaging", "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo0.packageName + "/" + serviceInfo0.name);
                        goto label_34;
                    }
                    else {
                        u0.a = s1.startsWith(".") ? "com.iloen.melon" + serviceInfo0.name : serviceInfo0.name;
                        s = (String)u0.a;
                        FIN.finallyExec$NT(v);
                    }
                }
                else {
                    Log.e("FirebaseMessaging", "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo0.packageName + "/" + serviceInfo0.name);
                    goto label_34;
                }
            }
        }
        else {
            FIN.finallyExec$NT(v);
        }
        if(s != null) {
            if(Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Restricting intent to a specific service: " + s);
            }
            intent1.setClassName("com.iloen.melon", s);
        }
        try {
            if(u0.r(context0)) {
                componentName0 = F.b(context0, intent1);
            }
            else {
                componentName0 = context0.startService(intent1);
                Log.d("FirebaseMessaging", "Missing wake lock permission, service start may be delayed");
            }
            if(componentName0 == null) {
                Log.e("FirebaseMessaging", "Error while delivering the message: ServiceIntent not found.");
                return 404;
            }
            return -1;
        label_54:
            goto label_58;
        }
        catch(SecurityException securityException0) {
        }
        catch(IllegalStateException illegalStateException0) {
            goto label_54;
        }
        Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", securityException0);
        return 401;
    label_58:
        Log.e("FirebaseMessaging", "Failed to start service while in background: " + illegalStateException0);
        return 402;
    }
}

