package com.google.firebase.messaging;

import V4.u;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Binder;
import android.util.Log;
import c2.n0;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class t implements Runnable {
    public final Context a;
    public final boolean b;
    public final TaskCompletionSource c;

    public t(Context context0, boolean z, TaskCompletionSource taskCompletionSource0) {
        this.a = context0;
        this.b = z;
        this.c = taskCompletionSource0;
    }

    @Override
    public final void run() {
        TaskCompletionSource taskCompletionSource0;
        try {
            Context context0 = this.a;
            taskCompletionSource0 = this.c;
            if(Binder.getCallingUid() != context0.getApplicationInfo().uid) {
                Log.e("FirebaseMessaging", "error configuring notification delegate for package com.iloen.melon");
                return;
            }
            SharedPreferences.Editor sharedPreferences$Editor0 = u.s(context0).edit();
            sharedPreferences$Editor0.putBoolean("proxy_notification_initialized", true);
            sharedPreferences$Editor0.apply();
            NotificationManager notificationManager0 = (NotificationManager)context0.getSystemService(NotificationManager.class);
            if(this.b) {
                n0.o(notificationManager0);
            }
            else if("com.google.android.gms".equals(notificationManager0.getNotificationDelegate())) {
                n0.y(notificationManager0);
            }
        }
        finally {
            taskCompletionSource0.trySetResult(null);
        }
    }
}

