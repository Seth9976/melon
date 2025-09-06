package com.google.android.gms.internal.measurement;

final class zzbt extends zzbz {
    private String zza;
    private byte zzb;
    private int zzc;
    private int zzd;

    public final zzbz zza(String s) {
        this.zza = "";
        return this;
    }

    @Override  // com.google.android.gms.internal.measurement.zzbz
    public final zzbz zzb(boolean z) {
        this.zzb = 1;
        return this;
    }

    @Override  // com.google.android.gms.internal.measurement.zzbz
    public final zzca zzc() {
        if(this.zzb == 1 && this.zza != null && this.zzc != 0 && this.zzd != 0) {
            return new zzbu(this.zza, false, this.zzc, null, null, this.zzd, null);
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        if(this.zza == null) {
            stringBuilder0.append(" fileOwner");
        }
        if(this.zzb == 0) {
            stringBuilder0.append(" hasDifferentDmaOwner");
        }
        if(this.zzc == 0) {
            stringBuilder0.append(" fileChecks");
        }
        if(this.zzd == 0) {
            stringBuilder0.append(" filePurpose");
        }
        throw new IllegalStateException("Missing required properties:" + stringBuilder0.toString());
    }

    @Override  // com.google.android.gms.internal.measurement.zzbz
    public final zzbz zzd(int v) {
        this.zzc = v;
        return this;
    }

    @Override  // com.google.android.gms.internal.measurement.zzbz
    public final zzbz zze(int v) {
        this.zzd = 1;
        return this;
    }
}

