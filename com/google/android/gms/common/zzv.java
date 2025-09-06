package com.google.android.gms.common;

final class zzv {
    private String zza;
    private Boolean zzb;
    private Boolean zzc;

    private zzv() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }

    public zzv(byte[] arr_b) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }

    public final zzv zza(String s) {
        this.zza = s;
        return this;
    }

    public final zzv zzb(boolean z) {
        this.zzb = Boolean.valueOf(z);
        return this;
    }

    public final zzv zzc(boolean z) {
        this.zzc = Boolean.valueOf(z);
        return this;
    }

    public final zzw zzd() {
        Boolean boolean0 = this.zzb;
        if(boolean0 == null) {
            throw new IllegalStateException("allowTestKeys must be set");
        }
        if(this.zzc == null) {
            throw new IllegalStateException("isGoogleOrPlatformOnly must be set");
        }
        return new zzw(this.zza, boolean0.booleanValue(), false, false, this.zzc.booleanValue(), false, null);
    }
}

