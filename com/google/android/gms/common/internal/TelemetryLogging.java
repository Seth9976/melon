package com.google.android.gms.common.internal;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.service.zao;

@KeepForSdk
public class TelemetryLogging {
    @KeepForSdk
    public static TelemetryLoggingClient getClient(Context context0) {
        return TelemetryLogging.getClient(context0, TelemetryLoggingOptions.zaa);
    }

    @KeepForSdk
    public static TelemetryLoggingClient getClient(Context context0, TelemetryLoggingOptions telemetryLoggingOptions0) {
        return new zao(context0, telemetryLoggingOptions0);
    }
}

