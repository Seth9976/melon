package com.google.android.gms.internal.cast;

final class zzhe extends zzgw {
    private final zzhg zza;

    public zzhe(zzhg zzhg0, int v) {
        super(zzhg0.size(), v);
        this.zza = zzhg0;
    }

    @Override  // com.google.android.gms.internal.cast.zzgw
    public final Object zza(int v) {
        return this.zza.get(v);
    }
}

