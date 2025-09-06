package com.iloen.melon.mcache.util;

import android.util.Log;
import f9.q;

public class CacheTrackingLog {
    private static final String TAG = "TRACKING";

    public static void i(String s) {
        if(q.a() && q.e <= 2) {
            Log.i("MCACHE-TRACKING", s);
        }
    }
}

