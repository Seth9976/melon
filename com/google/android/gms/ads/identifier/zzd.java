package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public final class zzd {
    private static volatile zzd zza;
    private static final Object zzb;
    private static final Duration zzc;
    private final TelemetryLoggingClient zzd;
    private final AtomicLong zze;

    static {
        zzd.zzb = new Object();
        zzd.zzc = Duration.ofMinutes(30L);
    }

    private zzd(Context context0, String s) {
        this.zze = new AtomicLong(-1L);
        this.zzd = TelemetryLogging.getClient(context0, TelemetryLoggingOptions.builder().setApi("ads_identifier:api").build());
    }

    public static zzd zza(Context context0) {
        if(zzd.zza == null) {
            Object object0 = zzd.zzb;
            synchronized(object0) {
                if(zzd.zza == null) {
                    zzd.zza = new zzd(context0, "ads_identifier:api");
                }
            }
        }
        return zzd.zza;
    }

    // 检测为 Lambda 实现
    public static void zzb(zzd zzd0, long v, Exception exception0) [...]

    public final void zzc(int v, int v1, long v2, long v3, int v4) {
        synchronized(this) {
            long v6 = SystemClock.elapsedRealtime();
            Log.i("AdvertisingIdClient", "shouldSendLog " + this.zze.get());
            if(this.zze.get() == -1L || v6 - this.zze.get() > zzd.zzc.toMillis()) {
                TelemetryLoggingClient telemetryLoggingClient0 = this.zzd;
                if(telemetryLoggingClient0 != null) {
                    telemetryLoggingClient0.log(new TelemetryData(0, Arrays.asList(new MethodInvocation[]{new MethodInvocation(35401, v1, 0, v2, v3, null, null, 0, v4)}))).addOnFailureListener((Exception exception0) -> {
                        Log.i("AdvertisingIdClient", "getting error as " + exception0.getMessage());
                        if(exception0 instanceof ApiException) {
                            ConnectionResult connectionResult0 = ((ApiException)exception0).getStatus().getConnectionResult();
                            if(connectionResult0 != null && connectionResult0.getErrorCode() == 24) {
                                this.zze.set(v6);
                            }
                        }
                    });
                }
            }
        }
    }
}

