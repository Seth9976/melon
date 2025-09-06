package com.google.android.gms.measurement.internal;

import androidx.collection.u;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzhl extends u {
    final zzhs zza;

    public zzhl(zzhs zzhs0, int v) {
        Objects.requireNonNull(zzhs0);
        this.zza = zzhs0;
        super(20);
    }

    @Override  // androidx.collection.u
    public final Object create(Object object0) {
        Preconditions.checkNotEmpty(((String)object0));
        return this.zza.zzC(((String)object0));
    }
}

