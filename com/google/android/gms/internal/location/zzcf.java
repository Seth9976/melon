package com.google.android.gms.internal.location;

import java.util.concurrent.Executor;

final class zzcf implements Executor {
    static final zzcf zza;

    static {
        zzcf.zza = new zzcf();
    }

    @Override
    public final void execute(Runnable runnable0) {
        runnable0.run();
    }
}

