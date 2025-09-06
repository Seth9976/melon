package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public final class zzgp {
    private static zzgp zza;
    private final zzib zzb;
    private final TelemetryLoggingClient zzc;
    private final AtomicLong zzd;

    private zzgp(Context context0, zzib zzib0) {
        this.zzd = new AtomicLong(-1L);
        this.zzc = TelemetryLogging.getClient(context0, TelemetryLoggingOptions.builder().setApi("measurement:api").build());
        this.zzb = zzib0;
    }

    public static zzgp zza(zzib zzib0) {
        if(zzgp.zza == null) {
            zzgp.zza = new zzgp(zzib0.zzaY(), zzib0);
        }
        return zzgp.zza;
    }

    public final void zzb(int v, int v1, long v2, long v3, int v4) {
        synchronized(this) {
            long v6 = this.zzb.zzaZ().elapsedRealtime();
            if(this.zzd.get() != -1L && v6 - this.zzd.get() <= 1800000L) {
                return;
            }
            TelemetryData telemetryData0 = new TelemetryData(0, Arrays.asList(new MethodInvocation[]{new MethodInvocation(36301, v1, 0, v2, v3, null, null, 0, v4)}));
            this.zzc.log(telemetryData0).addOnFailureListener((Exception exception0) -> this.zzd.set(v6));
        }
    }

    // 检测为 Lambda 实现
    public final void zzc(long v, Exception exception0) [...]
}

