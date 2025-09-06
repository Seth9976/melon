package com.google.android.gms.cloudmessaging;

import java.util.concurrent.Executor;

public final class zzy implements Executor {
    public static final zzy zza;

    static {
        zzy.zza = new zzy();
    }

    @Override
    public final void execute(Runnable runnable0) {
        runnable0.run();
    }
}

