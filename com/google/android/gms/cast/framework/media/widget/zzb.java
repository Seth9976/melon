package com.google.android.gms.cast.framework.media.widget;

public final class zzb {
    public final int zza;
    public final int zzb;
    public final boolean zzc;

    public zzb(int v, int v1, boolean z) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzb ? this.zza == ((zzb)object0).zza : false;
    }

    @Override
    public final int hashCode() {
        return this.zza.hashCode();
    }
}

