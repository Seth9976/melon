package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.Objects;

final class zzjj extends ContentObserver {
    final zzjl zza;

    public zzjj(zzjl zzjl0, Handler handler0) {
        Objects.requireNonNull(zzjl0);
        this.zza = zzjl0;
        super(null);
    }

    @Override  // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zza.zzb().set(true);
    }
}

