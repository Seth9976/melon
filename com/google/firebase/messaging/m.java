package com.google.firebase.messaging;

import E9.u;
import U4.F;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.media3.session.S0;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.tasks.Task;
import l.a;

public final class m implements Runnable {
    public final int a;
    public final FirebaseMessaging b;

    public m(FirebaseMessaging firebaseMessaging0, int v) {
        this.a = v;
        this.b = firebaseMessaging0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            FirebaseMessaging firebaseMessaging0 = this.b;
            Context context0 = firebaseMessaging0.b;
            F.K(context0);
            u u0 = firebaseMessaging0.c;
            boolean z = firebaseMessaging0.g();
            SharedPreferences sharedPreferences0 = V4.u.s(context0);
            if(!sharedPreferences0.contains("proxy_retention") || sharedPreferences0.getBoolean("proxy_retention", false) != z) {
                ((Rpc)u0.c).setRetainProxiedNotifications(z).addOnSuccessListener(new a(1), new S0(context0, z, 3));
            }
            if(firebaseMessaging0.g()) {
                Task task0 = ((Rpc)u0.c).getProxiedNotificationData();
                o o0 = new o(firebaseMessaging0, 0);
                task0.addOnSuccessListener(firebaseMessaging0.f, o0);
            }
            return;
        }
        FirebaseMessaging firebaseMessaging1 = this.b;
        if(firebaseMessaging1.e.i() && firebaseMessaging1.i(firebaseMessaging1.f())) {
            synchronized(firebaseMessaging1) {
                if(!firebaseMessaging1.i) {
                    firebaseMessaging1.h(0L);
                }
            }
        }
    }
}

