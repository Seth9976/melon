package com.google.android.gms.internal.location;

import java.util.concurrent.Executor;

final class zzcg implements Executor {
    static final zzcg zza;

    static {
        zzcg.zza = new zzcg();
    }

    @Override
    public final void execute(Runnable runnable0) {
        runnable0.run();
    }
}

