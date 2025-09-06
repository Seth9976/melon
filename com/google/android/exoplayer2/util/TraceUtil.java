package com.google.android.exoplayer2.util;

import android.annotation.TargetApi;
import android.os.Trace;

public final class TraceUtil {
    public static void beginSection(String s) {
        if(Util.SDK_INT >= 18) {
            TraceUtil.beginSectionV18(s);
        }
    }

    @TargetApi(18)
    private static void beginSectionV18(String s) {
        Trace.beginSection(s);
    }

    public static void endSection() {
        if(Util.SDK_INT >= 18) {
            TraceUtil.endSectionV18();
        }
    }

    @TargetApi(18)
    private static void endSectionV18() {
        Trace.endSection();
    }
}

