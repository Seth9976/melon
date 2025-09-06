package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzjp;

final class zzes extends zzcz {
    private final zzjp zza;

    public zzes(zzjp zzjp0) {
        this.zza = zzjp0;
    }

    @Override  // com.google.android.gms.internal.measurement.zzda
    public final void zze(String s, String s1, Bundle bundle0, long v) {
        this.zza.onEvent(s, s1, bundle0, v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzda
    public final int zzf() {
        return System.identityHashCode(this.zza);
    }
}

