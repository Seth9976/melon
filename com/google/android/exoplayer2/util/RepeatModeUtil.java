package com.google.android.exoplayer2.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class RepeatModeUtil {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatToggleModes {
    }

    public static final int REPEAT_TOGGLE_MODE_ALL = 2;
    public static final int REPEAT_TOGGLE_MODE_NONE = 0;
    public static final int REPEAT_TOGGLE_MODE_ONE = 1;

    public static int getNextRepeatMode(int v, int v1) {
        for(int v2 = 1; v2 <= 2; ++v2) {
            int v3 = (v + v2) % 3;
            if(RepeatModeUtil.isRepeatModeEnabled(v3, v1)) {
                return v3;
            }
        }
        return v;
    }

    public static boolean isRepeatModeEnabled(int v, int v1) {
        switch(v) {
            case 0: {
                return true;
            }
            case 1: {
                return (v1 & 1) != 0;
            }
            case 2: {
                return (v1 & 2) != 0;
            }
            default: {
                return false;
            }
        }
    }
}

