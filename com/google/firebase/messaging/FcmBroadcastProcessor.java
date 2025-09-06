package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import androidx.media3.session.J;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.stats.WakeLock;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import l.a;

@KeepForSdk
public class FcmBroadcastProcessor {
    public final Context a;
    public final a b;
    public static final Object c;
    public static I d;

    static {
        FcmBroadcastProcessor.c = new Object();
    }

    public FcmBroadcastProcessor(Context context0) {
        this.a = context0;
        this.b = new a(1);
    }

    public static Task a(Context context0, Intent intent0, boolean z) {
        I i0;
        if(Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        synchronized(FcmBroadcastProcessor.c) {
            if(FcmBroadcastProcessor.d == null) {
                FcmBroadcastProcessor.d = new I(context0);
            }
            i0 = FcmBroadcastProcessor.d;
        }
        if(z) {
            if(u.m().r(context0)) {
                Object object1 = F.b;
                synchronized(object1) {
                    if(F.c == null) {
                        WakeLock wakeLock0 = new WakeLock(context0, 1, "wake:com.google.firebase.iid.WakeLockHolder");
                        F.c = wakeLock0;
                        wakeLock0.setReferenceCounted(true);
                    }
                    boolean z1 = intent0.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                    intent0.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
                    if(!z1) {
                        F.c.acquire(F.a);
                    }
                    i0.b(intent0).addOnCompleteListener(new q(intent0, 2));
                }
                return Tasks.forResult(-1);
            }
            i0.b(intent0);
            return Tasks.forResult(-1);
        }
        return i0.b(intent0).continueWith(new a(1), new j(1));
    }

    public final Task b(Intent intent0) {
        String s = intent0.getStringExtra("gcm.rawData64");
        if(s != null) {
            intent0.putExtra("rawData", Base64.decode(s, 0));
            intent0.removeExtra("gcm.rawData64");
        }
        Context context0 = this.a;
        if((intent0.getFlags() & 0x10000000) == 0) {
            return FcmBroadcastProcessor.a(context0, intent0, false);
        }
        i i0 = new i(context0, intent0);
        Task task0 = Tasks.call(this.b, i0);
        J j0 = new J(context0, intent0, true);
        return task0.continueWithTask(this.b, j0);
    }
}

