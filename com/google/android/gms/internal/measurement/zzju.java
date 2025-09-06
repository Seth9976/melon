package com.google.android.gms.internal.measurement;

import android.os.Binder;

interface zzju {
    Object zze(String arg1);

    static Object zzg(zzjt zzjt0) {
        try {
            return zzjt0.zza();
        }
        catch(SecurityException unused_ex) {
            long v = Binder.clearCallingIdentity();
            try {
                return zzjt0.zza();
            }
            finally {
                Binder.restoreCallingIdentity(v);
            }
        }
    }
}

