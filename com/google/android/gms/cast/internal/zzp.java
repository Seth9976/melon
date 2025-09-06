package com.google.android.gms.cast.internal;

public final class zzp {
    private final int zza;

    public zzp(int v, zzaa zzaa0) {
        this.zza = v;
    }

    public final int zza() {
        return this.zza;
    }

    public final boolean zzb(int v) {
        return (this.zza & v) == v;
    }

    // 去混淆评级： 低(40)
    public final boolean zzc() {
        return this.zzb(0x20) && !this.zzb(0x40) && !this.zzb(0x80) || this.zzb(0x40);
    }

    // 去混淆评级： 低(20)
    public final boolean zzd() {
        return this.zzc() || this.zzb(0x80);
    }
}

