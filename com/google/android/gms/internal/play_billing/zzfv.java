package com.google.android.gms.internal.play_billing;

public enum zzfv {
    DOUBLE(zzfw.zzd, 1),
    FLOAT(zzfw.zzc, 5),
    INT64(zzfw.zzb, 0),
    UINT64(zzfw.zzb, 0),
    INT32(zzfw.zza, 0),
    FIXED64(zzfw.zzb, 1),
    FIXED32(zzfw.zza, 5),
    BOOL(zzfw.zze, 0),
    STRING(zzfw.zzf, 2),
    GROUP(zzfw.zzi, 3),
    MESSAGE(zzfw.zzi, 2),
    BYTES(zzfw.zzg, 2),
    UINT32(zzfw.zza, 0),
    ENUM(zzfw.zzh, 0),
    SFIXED32(zzfw.zza, 5),
    SFIXED64(zzfw.zzb, 1),
    SINT32(zzfw.zza, 0),
    SINT64(zzfw.zzb, 0);

    private final zzfw zzt;

    private zzfv(zzfw zzfw0, int v1) {
        this.zzt = zzfw0;
    }

    public final zzfw zza() {
        return this.zzt;
    }
}

