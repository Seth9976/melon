package com.google.firebase.messaging;

import H8.i;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.ArrayDeque;

public final class v implements Runnable {
    public final int a;
    public final Object b;

    public v(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            Log.w("FirebaseMessaging", "Service took too long to process intent: " + ((H)this.b).a.getAction() + " finishing.");
            ((H)this.b).b.trySetResult(null);
            return;
        }
        i i0 = (i)this.b;
        synchronized(((ArrayDeque)i0.e)) {
            SharedPreferences.Editor sharedPreferences$Editor0 = ((SharedPreferences)i0.b).edit();
            String s = (String)i0.c;
            StringBuilder stringBuilder0 = new StringBuilder();
            for(Object object0: ((ArrayDeque)i0.e)) {
                stringBuilder0.append(((String)object0));
                stringBuilder0.append(((String)i0.d));
            }
            sharedPreferences$Editor0.putString(s, stringBuilder0.toString()).commit();
        }
    }
}

