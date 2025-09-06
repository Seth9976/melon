package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zznt {
    public static final int zza;
    private static final zznt zzb;
    private final zznx zzc;
    private final ConcurrentMap zzd;

    static {
        zznt.zzb = new zznt();
    }

    private zznt() {
        this.zzd = new ConcurrentHashMap();
        this.zzc = new zznc();
    }

    public static zznt zza() {
        return zznt.zzb;
    }

    public final zznw zzb(Class class0) {
        zzmo.zza(class0, "messageType");
        ConcurrentMap concurrentMap0 = this.zzd;
        zznw zznw0 = (zznw)concurrentMap0.get(class0);
        if(zznw0 == null) {
            zznw0 = this.zzc.zza(class0);
            zzmo.zza(class0, "messageType");
            zznw zznw1 = (zznw)concurrentMap0.putIfAbsent(class0, zznw0);
            return zznw1 == null ? zznw0 : zznw1;
        }
        return zznw0;
    }
}

