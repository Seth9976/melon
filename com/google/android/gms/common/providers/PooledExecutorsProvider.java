package com.google.android.gms.common.providers;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ScheduledExecutorService;

@KeepForSdk
@Deprecated
public class PooledExecutorsProvider {
    public interface PooledExecutorFactory {
        @KeepForSdk
        @Deprecated
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    private static PooledExecutorFactory zza;

    @KeepForSdk
    @Deprecated
    public static PooledExecutorFactory getInstance() {
        synchronized(PooledExecutorsProvider.class) {
            if(PooledExecutorsProvider.zza == null) {
                PooledExecutorsProvider.zza = new zza();
            }
            return PooledExecutorsProvider.zza;
        }
    }
}

