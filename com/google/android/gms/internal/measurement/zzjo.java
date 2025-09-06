package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.Objects;

final class zzjo extends ContentObserver {
    final zzjq zza;

    public zzjo(zzjq zzjq0, Handler handler0) {
        Objects.requireNonNull(zzjq0);
        this.zza = zzjq0;
        super(null);
    }

    @Override  // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zza.zzc();
    }
}

