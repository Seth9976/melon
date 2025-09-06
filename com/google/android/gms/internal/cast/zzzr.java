package com.google.android.gms.internal.cast;

public enum zzzr {
    DOUBLE(zzzs.zzd, 1),
    FLOAT(zzzs.zzc, 5),
    INT64(zzzs.zzb, 0),
    UINT64(zzzs.zzb, 0),
    INT32(zzzs.zza, 0),
    FIXED64(zzzs.zzb, 1),
    FIXED32(zzzs.zza, 5),
    BOOL(zzzs.zze, 0),
    STRING(zzzs.zzf, 2),
    GROUP(zzzs.zzi, 3),
    MESSAGE(zzzs.zzi, 2),
    BYTES(zzzs.zzg, 2),
    UINT32(zzzs.zza, 0),
    ENUM(zzzs.zzh, 0),
    SFIXED32(zzzs.zza, 5),
    SFIXED64(zzzs.zzb, 1),
    SINT32(zzzs.zza, 0),
    SINT64(zzzs.zzb, 0);

    private final zzzs zzt;

    private zzzr(zzzs zzzs0, int v1) {
        this.zzt = zzzs0;
    }

    public final zzzs zza() {
        return this.zzt;
    }
}

