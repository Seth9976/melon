package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

final class zzdh extends zzeq {
    final String zza;
    final String zzb;
    final Object zzc;
    final boolean zzd;
    final zzfb zze;

    public zzdh(zzfb zzfb0, String s, String s1, Object object0, boolean z) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = object0;
        this.zzd = z;
        Objects.requireNonNull(zzfb0);
        this.zze = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        Object object0 = Preconditions.checkNotNull(this.zze.zzQ());
        IObjectWrapper iObjectWrapper0 = ObjectWrapper.wrap(this.zzc);
        ((zzcr)object0).setUserProperty(this.zza, this.zzb, iObjectWrapper0, this.zzd, this.zzh);
    }
}

