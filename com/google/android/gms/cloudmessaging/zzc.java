package com.google.android.gms.cloudmessaging;

import android.util.Log;
import java.util.Objects;

public final class zzc extends ClassLoader {
    @Override
    public final Class loadClass(String s, boolean z) {
        if(Objects.equals(s, "com.google.android.gms.iid.MessengerCompat")) {
            if(Log.isLoggable("CloudMessengerCompat", 3)) {
                Log.d("CloudMessengerCompat", "Using renamed FirebaseIidMessengerCompat class");
            }
            return zzd.class;
        }
        return super.loadClass(s, z);
    }
}

