package com.google.android.gms.cast;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.ShowFirstParty;

public final class CastStatusCodes extends CommonStatusCodes {
    public static final int APPLICATION_NOT_FOUND = 2004;
    public static final int APPLICATION_NOT_RUNNING = 2005;
    public static final int AUTHENTICATION_FAILED = 2000;
    public static final int CANCELED = 2002;
    public static final int DEVICE_CONNECTION_SUSPENDED = 0x7E0;
    @KeepForSdk
    @ShowFirstParty
    public static final int ERROR_CAST_PLATFORM_INCOMPATIBLE = 2110;
    @KeepForSdk
    @ShowFirstParty
    public static final int ERROR_CAST_PLATFORM_NOT_CONNECTED = 0x841;
    @KeepForSdk
    @ShowFirstParty
    public static final int ERROR_DEVICE_ID_FLAGS_NOT_SET = 0x843;
    @KeepForSdk
    @ShowFirstParty
    public static final int ERROR_HOST_NOT_ALLOWED = 0x840;
    @KeepForSdk
    @ShowFirstParty
    public static final int ERROR_NO_CAST_CONFIGURATION = 0x842;
    public static final int ERROR_SERVICE_CREATION_FAILED = 2200;
    public static final int ERROR_SERVICE_DISCONNECTED = 2201;
    public static final int ERROR_STOPPING_SERVICE_FAILED = 2202;
    @KeepForSdk
    @ShowFirstParty
    public static final int ERROR_URL_INSEURE = 0x83F;
    public static final int FAILED = 2100;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 14;
    public static final int INVALID_REQUEST = 2001;
    public static final int MEDIA_ERROR = 2104;
    public static final int MESSAGE_SEND_BUFFER_TOO_FULL = 2007;
    public static final int MESSAGE_TOO_LARGE = 2006;
    public static final int NETWORK_ERROR = 7;
    public static final int NOT_ALLOWED = 2003;
    public static final int REPLACED = 2103;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 15;
    public static final int UNKNOWN_ERROR = 13;

    @Override  // com.google.android.gms.common.api.CommonStatusCodes
    public static String getStatusCodeString(int v) {
        if(v >= -999 && v <= 999) {
            switch(v) {
                case 0: {
                    return "SUCCESS";
                }
                case 7: {
                    return "NETWORK_ERROR";
                }
                case 14: {
                    return "INTERRUPTED";
                }
                case 15: {
                    return "TIMEOUT";
                }
                default: {
                    return CommonStatusCodes.getStatusCodeString(v);
                }
            }
        }
        if(v >= 2000 && v <= 0x801) {
            if(v != 0x7DF) {
                switch(v) {
                    case 2000: {
                        return "AUTHENTICATION_FAILED";
                    }
                    case 2001: {
                        return "INVALID_REQUEST";
                    }
                    case 2002: {
                        return "CANCELED";
                    }
                    case 2003: {
                        return "NOT_ALLOWED";
                    }
                    case 2004: {
                        return "APPLICATION_NOT_FOUND";
                    }
                    case 2005: {
                        return "APPLICATION_NOT_RUNNING";
                    }
                    case 2006: {
                        return "MESSAGE_TOO_LARGE";
                    }
                    case 2007: {
                        return "MESSAGE_SEND_BUFFER_TOO_FULL";
                    }
                    default: {
                        return "Common cast status code " + v;
                    }
                }
            }
            return "TCP_PROBER_FAIL_TO_VERIFY_DEVICE";
        }
        if(v >= 2050 && v <= 0x80B) {
            return "Cast controller status code " + v;
        }
        if(v >= 2100 && v <= 2109) {
            return "Media control channel status code " + v;
        }
        if(v >= 2150 && v <= 0x879) {
            return "Cast session status code " + v;
        }
        if(v >= 2200 && v <= 0x8AB) {
            return "Cast remote display status code " + v;
        }
        if(v >= 2250 && v <= 0x8FB) {
            return "Cast socket status code " + v;
        }
        if(v >= 2300 && v <= 0x905) {
            return "Cast service status code " + v;
        }
        if(v >= 0x906 && v <= 0x90F) {
            return "Endpoint switch status code " + v;
        }
        if(v >= 2350 && v <= 0x937) {
            return "Cast multizone device status code " + v;
        }
        if(v >= 2400 && v <= 0x973) {
            return "Cast relay casting status code " + v;
        }
        if(v >= 2450 && v <= 0x9A5) {
            return "Cast nearby casting status code " + v;
        }
        if(v >= 2420 && v <= 0x987) {
            return "Remote connection status code " + v;
        }
        if(v >= 2470 && v <= 0x9AF) {
            return "Cast application status code " + v;
        }
        return v < 2490 || v > 0x9C3 ? "Unknown cast status code " + v : "Cast media loading status code " + v;
    }
}

