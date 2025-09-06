package com.google.firebase.messaging;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.e;

public final class p implements SuccessContinuation {
    public final FirebaseMessaging a;
    public final String b;
    public final w c;

    public p(FirebaseMessaging firebaseMessaging0, String s, w w0) {
        this.a = firebaseMessaging0;
        this.b = s;
        this.c = w0;
    }

    @Override  // com.google.android.gms.tasks.SuccessContinuation
    public final Task then(Object object0) {
        FirebaseMessaging firebaseMessaging0 = this.a;
        String s = this.b;
        w w0 = this.c;
        Store store0 = FirebaseMessaging.d(firebaseMessaging0.b);
        firebaseMessaging0.a.a();
        String s1 = "[DEFAULT]".equals(firebaseMessaging0.a.b) ? "" : firebaseMessaging0.a.d();
        String s2 = firebaseMessaging0.h.h();
        synchronized(store0) {
            String s3 = w.a(System.currentTimeMillis(), ((String)object0), s2);
            if(s3 != null) {
                SharedPreferences.Editor sharedPreferences$Editor0 = store0.a.edit();
                sharedPreferences$Editor0.putString(s1 + "|T|" + s + "|*", s3);
                sharedPreferences$Editor0.commit();
            }
        }
        if(w0 == null || !((String)object0).equals(w0.a)) {
            e e0 = firebaseMessaging0.a;
            e0.a();
            if("[DEFAULT]".equals(e0.b)) {
                if(Log.isLoggable("FirebaseMessaging", 3)) {
                    e0.a();
                    Log.d("FirebaseMessaging", "Invoking onNewToken for app: " + e0.b);
                }
                Intent intent0 = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent0.putExtra("token", ((String)object0));
                new FcmBroadcastProcessor(firebaseMessaging0.b).b(intent0);
            }
        }
        return Tasks.forResult(((String)object0));
    }
}

