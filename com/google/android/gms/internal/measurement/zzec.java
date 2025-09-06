package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

final class zzec extends zzeq {
    final String zza;
    final Object zzb;
    final zzfb zzc;

    public zzec(zzfb zzfb0, boolean z, int v, String s, Object object0, Object object1, Object object2) {
        this.zza = s;
        this.zzb = object0;
        Objects.requireNonNull(zzfb0);
        this.zzc = zzfb0;
        super(zzfb0, false);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        Object object0 = Preconditions.checkNotNull(this.zzc.zzQ());
        IObjectWrapper iObjectWrapper0 = ObjectWrapper.wrap(this.zzb);
        IObjectWrapper iObjectWrapper1 = ObjectWrapper.wrap(null);
        IObjectWrapper iObjectWrapper2 = ObjectWrapper.wrap(null);
        ((zzcr)object0).logHealthData(5, this.zza, iObjectWrapper0, iObjectWrapper1, iObjectWrapper2);
    }
}

