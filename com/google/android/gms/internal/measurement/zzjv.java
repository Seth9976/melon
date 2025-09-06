package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.Objects;

final class zzjv extends ContentObserver {
    public zzjv(zzjx zzjx0, Handler handler0) {
        Objects.requireNonNull(zzjx0);
        super(null);
    }

    @Override  // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzkl.zzc();
    }
}

