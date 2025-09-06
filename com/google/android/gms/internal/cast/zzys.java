package com.google.android.gms.internal.cast;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzys {
    public static final int zza;
    private static final zzys zzb;
    private final zzyw zzc;
    private final ConcurrentMap zzd;

    static {
        zzys.zzb = new zzys();
    }

    private zzys() {
        this.zzd = new ConcurrentHashMap();
        this.zzc = new zzyd();
    }

    public static zzys zza() {
        return zzys.zzb;
    }

    public final zzyv zzb(Class class0) {
        zzxo.zzc(class0, "messageType");
        ConcurrentMap concurrentMap0 = this.zzd;
        zzyv zzyv0 = (zzyv)concurrentMap0.get(class0);
        if(zzyv0 == null) {
            zzyv0 = this.zzc.zza(class0);
            zzxo.zzc(class0, "messageType");
            zzyv zzyv1 = (zzyv)concurrentMap0.putIfAbsent(class0, zzyv0);
            return zzyv1 == null ? zzyv0 : zzyv1;
        }
        return zzyv0;
    }
}

