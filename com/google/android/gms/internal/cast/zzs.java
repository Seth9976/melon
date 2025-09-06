package com.google.android.gms.internal.cast;

import java.util.concurrent.ConcurrentHashMap;

public final class zzs {
    private static zzs zza;

    private zzs(zzh zzh0, String s) {
        new ConcurrentHashMap();
    }

    public static void zza(zzh zzh0, String s) {
        synchronized(zzs.class) {
            if(zzs.zza == null) {
                zzs.zza = new zzs(zzh0, s);
            }
        }
    }
}

