package com.google.android.gms.cast.framework.media.widget;

import com.google.android.gms.common.internal.Objects;

public final class zze {
    public int zza;
    public int zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public boolean zzf;

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zze ? this.zza == ((zze)object0).zza && this.zzb == ((zze)object0).zzb && this.zzc == ((zze)object0).zzc && this.zzd == ((zze)object0).zzd && this.zze == ((zze)object0).zze && this.zzf == ((zze)object0).zzf : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze, Boolean.valueOf(this.zzf)});
    }
}

