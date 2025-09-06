package com.google.android.gms.cast.framework;

public final class CastState {
    public static final int CONNECTED = 4;
    public static final int CONNECTING = 3;
    public static final int NOT_CONNECTED = 2;
    public static final int NO_DEVICES_AVAILABLE = 1;

    public static String toString(int v) {
        switch(v) {
            case 1: {
                return "NO_DEVICES_AVAILABLE";
            }
            case 2: {
                return "NOT_CONNECTED";
            }
            case 3: {
                return "CONNECTING";
            }
            case 4: {
                return "CONNECTED";
            }
            default: {
                return "UNKNOWN_STATE(" + v + ")";
            }
        }
    }
}

