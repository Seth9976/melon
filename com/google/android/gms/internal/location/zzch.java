package com.google.android.gms.internal.location;

import java.util.concurrent.Executor;

final class zzch implements Executor {
    static final zzch zza;

    static {
        zzch.zza = new zzch();
    }

    @Override
    public final void execute(Runnable runnable0) {
        runnable0.run();
    }
}

