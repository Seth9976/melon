package com.google.android.gms.internal.cast;

import M6.B;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public abstract class zzvi extends zzvg implements B {
    @Override  // M6.B
    public final void addListener(Runnable runnable0, Executor executor0) {
        this.zzc().addListener(runnable0, executor0);
    }

    @Override  // com.google.android.gms.internal.cast.zzvg
    public Future zzb() {
        throw null;
    }

    public abstract B zzc();
}

