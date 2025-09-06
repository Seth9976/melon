package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class RootTelemetryConfigManager {
    private static RootTelemetryConfigManager zza;
    private static final RootTelemetryConfiguration zzb;
    private RootTelemetryConfiguration zzc;

    static {
        RootTelemetryConfigManager.zzb = new RootTelemetryConfiguration(0, false, false, 0, 0);
    }

    @KeepForSdk
    public RootTelemetryConfiguration getConfig() {
        return this.zzc;
    }

    @KeepForSdk
    public static RootTelemetryConfigManager getInstance() {
        synchronized(RootTelemetryConfigManager.class) {
            if(RootTelemetryConfigManager.zza == null) {
                RootTelemetryConfigManager.zza = new RootTelemetryConfigManager();
            }
            return RootTelemetryConfigManager.zza;
        }
    }

    public final void zza(RootTelemetryConfiguration rootTelemetryConfiguration0) {
        synchronized(this) {
            if(rootTelemetryConfiguration0 == null) {
                this.zzc = RootTelemetryConfigManager.zzb;
                return;
            }
            if(this.zzc != null && this.zzc.getVersion() >= rootTelemetryConfiguration0.getVersion()) {
                return;
            }
            this.zzc = rootTelemetryConfiguration0;
        }
    }
}

