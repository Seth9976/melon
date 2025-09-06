package com.google.android.gms.internal.measurement;

public enum zzos {
    DOUBLE(zzot.zzd, 1),
    FLOAT(zzot.zzc, 5),
    INT64(zzot.zzb, 0),
    UINT64(zzot.zzb, 0),
    INT32(zzot.zza, 0),
    FIXED64(zzot.zzb, 1),
    FIXED32(zzot.zza, 5),
    BOOL(zzot.zze, 0),
    STRING(zzot.zzf, 2),
    GROUP(zzot.zzi, 3),
    MESSAGE(zzot.zzi, 2),
    BYTES(zzot.zzg, 2),
    UINT32(zzot.zza, 0),
    ENUM(zzot.zzh, 0),
    SFIXED32(zzot.zza, 5),
    SFIXED64(zzot.zzb, 1),
    SINT32(zzot.zza, 0),
    SINT64(zzot.zzb, 0);

    private final zzot zzs;
    private final int zzt;

    private zzos(zzot zzot0, int v1) {
        this.zzs = zzot0;
        this.zzt = v1;
    }

    public final zzot zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}

