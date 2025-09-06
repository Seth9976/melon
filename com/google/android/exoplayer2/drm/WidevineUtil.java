package com.google.android.exoplayer2.drm;

import android.util.Pair;
import java.util.Map;

public final class WidevineUtil {
    public static final String PROPERTY_LICENSE_DURATION_REMAINING = "LicenseDurationRemaining";
    public static final String PROPERTY_PLAYBACK_DURATION_REMAINING = "PlaybackDurationRemaining";

    private static long getDurationRemainingSec(Map map0, String s) {
        if(map0 != null) {
            try {
                String s1 = (String)map0.get(s);
                return s1 == null ? 0x8000000000000001L : Long.parseLong(s1);
            }
            catch(NumberFormatException unused_ex) {
            }
        }
        return 0x8000000000000001L;
    }

    public static Pair getLicenseDurationRemainingSec(DrmSession drmSession0) {
        Map map0 = drmSession0.queryKeyStatus();
        return map0 == null ? null : new Pair(WidevineUtil.getDurationRemainingSec(map0, "LicenseDurationRemaining"), WidevineUtil.getDurationRemainingSec(map0, "PlaybackDurationRemaining"));
    }
}

