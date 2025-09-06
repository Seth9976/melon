package com.google.android.gms.internal.measurement;

import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class zzed implements ThreadFactory {
    private final ThreadFactory zza;

    public zzed(zzfb zzfb0) {
        Objects.requireNonNull(zzfb0);
        super();
        this.zza = Executors.defaultThreadFactory();
    }

    @Override
    public final Thread newThread(Runnable runnable0) {
        Thread thread0 = this.zza.newThread(runnable0);
        thread0.setName("ScionFrontendApi");
        return thread0;
    }
}

