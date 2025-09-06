package com.google.android.gms.location;

import com.google.android.gms.common.api.CommonStatusCodes;

public final class GeofenceStatusCodes extends CommonStatusCodes {
    public static final int GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION = 1004;
    public static final int GEOFENCE_NOT_AVAILABLE = 1000;
    public static final int GEOFENCE_REQUEST_TOO_FREQUENT = 1005;
    public static final int GEOFENCE_TOO_MANY_GEOFENCES = 1001;
    public static final int GEOFENCE_TOO_MANY_PENDING_INTENTS = 1002;

    @Override  // com.google.android.gms.common.api.CommonStatusCodes
    public static String getStatusCodeString(int v) {
        switch(v) {
            case 1000: {
                return "GEOFENCE_NOT_AVAILABLE";
            }
            case 1001: {
                return "GEOFENCE_TOO_MANY_GEOFENCES";
            }
            case 1002: {
                return "GEOFENCE_TOO_MANY_PENDING_INTENTS";
            }
            case 1004: {
                return "GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION";
            }
            default: {
                return CommonStatusCodes.getStatusCodeString(v);
            }
        }
    }

    public static int zza(int v) {
        return v == 0 || v >= 1000 && v < 1006 ? v : 13;
    }
}

