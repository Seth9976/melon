package com.google.android.gms.internal.play_billing;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Objects;

final class zzap extends zzai {
    final zzaq zza;

    public zzap(zzaq zzaq0) {
        this.zza = zzaq0;
        super();
    }

    @Override
    public final Object get(int v) {
        zzaa.zza(v, zzaq.zzi(this.zza), "index");
        int v1 = v + v;
        Object object0 = zzaq.zzj(this.zza)[v1];
        Objects.requireNonNull(object0);
        Object object1 = zzaq.zzj(this.zza)[v1 + 1];
        Objects.requireNonNull(object1);
        return new AbstractMap.SimpleImmutableEntry(object0, object1);
    }

    @Override
    public final int size() {
        return zzaq.zzi(this.zza);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    public final boolean zzf() {
        return true;
    }
}

