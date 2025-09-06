package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zzg;
import java.util.concurrent.Executor;

@KeepForSdk
public class HandlerExecutor implements Executor {
    private final Handler zza;

    @KeepForSdk
    public HandlerExecutor(Looper looper0) {
        this.zza = new zzg(looper0);
    }

    @Override
    public final void execute(Runnable runnable0) {
        this.zza.post(runnable0);
    }
}

