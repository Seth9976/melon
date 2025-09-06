package com.google.android.gms.cast.framework;

import android.os.Bundle;
import com.google.android.gms.internal.cast.zzah;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public class CastReasonCodes {
    @Retention(RetentionPolicy.SOURCE)
    public @interface CastReasonType {
    }

    public static final int APPLICATION_LAUNCH_ERROR = 10;
    public static final int CASTING_ROUTE_CHANGED = 9;
    public static final int CASTING_STOPPED = 2;
    public static final int CAST_CANCELLED = 11;
    public static final int CAST_INTERNAL_ERROR = 1;
    public static final int CAST_SOCKET_ERROR = 6;
    public static final int CAST_TIMEOUT = 7;
    public static final int NETWORK_ERROR = 8;
    public static final int RECEIVER_APP_NOT_RUNNING = 3;
    public static final int SESSION_RESUME_FAILED = 5;
    public static final int SESSION_START_FAILED = 4;
    public static final int UNKNOWN_REASON;
    private final Map zza;

    public CastReasonCodes(Bundle bundle0) {
        this.zza = zzah.zza(bundle0, "com.google.android.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES");
    }

    public final int zza(int v) {
        Map map0 = this.zza;
        if(map0 != null) {
            Integer integer0 = v;
            if(map0.containsKey(integer0)) {
                Integer integer1 = (Integer)map0.get(integer0);
                return integer1 == null ? 0 : ((int)integer1);
            }
        }
        return 0;
    }
}

