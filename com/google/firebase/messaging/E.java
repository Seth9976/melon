package com.google.firebase.messaging;

import android.content.res.Resources.NotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class e {
    public static final AtomicInteger a;

    static {
        e.a = new AtomicInteger(((int)SystemClock.elapsedRealtime()));
    }

    public static boolean a(Resources resources0, int v) {
        if(Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if(resources0.getDrawable(v, null) instanceof AdaptiveIconDrawable) {
                Log.e("FirebaseMessaging", "Adaptive icons cannot be used in notifications. Ignoring icon id: " + v);
                return false;
            }
            return true;
        }
        catch(Resources.NotFoundException unused_ex) {
            Log.e("FirebaseMessaging", "Couldn\'t find resource " + v + ", treating it as an invalid icon");
            return false;
        }
    }
}

