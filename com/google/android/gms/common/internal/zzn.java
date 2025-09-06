package com.google.android.gms.common.internal;

import android.content.ComponentName;

public final class zzn {
    private final String zza;
    private final String zzb;
    private final ComponentName zzc;
    private final int zzd;
    private final boolean zze;

    public zzn(ComponentName componentName0, int v) {
        this.zza = null;
        this.zzb = null;
        Preconditions.checkNotNull(componentName0);
        this.zzc = componentName0;
        this.zzd = 0x1081;
        this.zze = false;
    }

    public zzn(String s, int v, boolean z) {
        this(s, "com.google.android.gms", 0x1081, false);
    }

    public zzn(String s, String s1, int v, boolean z) {
        Preconditions.checkNotEmpty(s);
        this.zza = s;
        Preconditions.checkNotEmpty(s1);
        this.zzb = s1;
        this.zzc = null;
        this.zzd = 0x1081;
        this.zze = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzn ? Objects.equal(this.zza, ((zzn)object0).zza) && Objects.equal(this.zzb, ((zzn)object0).zzb) && Objects.equal(this.zzc, ((zzn)object0).zzc) && this.zze == ((zzn)object0).zze : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, 0x1081, Boolean.valueOf(this.zze)});
    }

    @Override
    public final String toString() {
        String s = this.zza;
        if(s == null) {
            Preconditions.checkNotNull(this.zzc);
            return this.zzc.flattenToString();
        }
        return s;
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final ComponentName zzc() {
        return this.zzc;
    }

    public final boolean zzd() {
        return this.zze;
    }
}

