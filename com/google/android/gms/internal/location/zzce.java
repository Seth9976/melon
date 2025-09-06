package com.google.android.gms.internal.location;

import java.util.concurrent.Executor;

final class zzce implements Executor {
    static final zzce zza;

    static {
        zzce.zza = new zzce();
    }

    @Override
    public final void execute(Runnable runnable0) {
        runnable0.run();
    }
}

