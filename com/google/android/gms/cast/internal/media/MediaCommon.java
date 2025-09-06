package com.google.android.gms.cast.internal.media;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class MediaCommon {
    @KeepForSdk
    public static Integer mediaRepeatModeFromString(String s) {
        if(s != null) {
            switch(s) {
                case "REPEAT_ALL": {
                    return 1;
                }
                case "REPEAT_ALL_AND_SHUFFLE": {
                    return 3;
                }
                case "REPEAT_OFF": {
                    return 0;
                }
                case "REPEAT_SINGLE": {
                    return 2;
                }
                default: {
                    return null;
                }
            }
        }
        return null;
    }

    public static String zza(Integer integer0) {
        if(integer0 != null) {
            switch(((int)integer0)) {
                case 0: {
                    return "REPEAT_OFF";
                }
                case 1: {
                    return "REPEAT_ALL";
                }
                case 2: {
                    return "REPEAT_SINGLE";
                }
                case 3: {
                    return "REPEAT_ALL_AND_SHUFFLE";
                }
                default: {
                    return null;
                }
            }
        }
        return null;
    }
}

