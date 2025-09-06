package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import javax.annotation.CheckForNull;

final class zzar extends zzam {
    private final transient zzal zza;
    private final transient zzai zzb;

    public zzar(zzal zzal0, zzai zzai0) {
        this.zza = zzal0;
        this.zzb = zzai0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    public final boolean contains(@CheckForNull Object object0) {
        return this.zza.get(object0) != null;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzam
    public final Iterator iterator() {
        return this.zzb.zzl(0);
    }

    @Override
    public final int size() {
        return this.zza.size();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    public final int zza(Object[] arr_object, int v) {
        return this.zzb.zza(arr_object, 0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzam
    public final zzai zzd() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzam
    public final zzav zze() {
        return this.zzb.zzl(0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    public final boolean zzf() {
        throw null;
    }
}

