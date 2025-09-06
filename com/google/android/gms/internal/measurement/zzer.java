package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzjo;

final class zzer extends zzcz {
    private final zzjo zza;

    public zzer(zzjo zzjo0) {
        this.zza = zzjo0;
    }

    @Override  // com.google.android.gms.internal.measurement.zzda
    public final void zze(String s, String s1, Bundle bundle0, long v) {
        this.zza.interceptEvent(s, s1, bundle0, v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzda
    public final int zzf() {
        return System.identityHashCode(this.zza);
    }
}

