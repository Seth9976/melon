package com.google.android.exoplayer2;

import java.util.HashSet;

public final class ExoPlayerLibraryInfo {
    public static final boolean ASSERTIONS_ENABLED = true;
    public static final boolean GL_ASSERTIONS_ENABLED = false;
    public static final String TAG = "ExoPlayer";
    public static final boolean TRACE_ENABLED = true;
    public static final String VERSION = "2.11.7";
    public static final int VERSION_INT = 2011007;
    public static final String VERSION_SLASHY = "ExoPlayerLib/2.11.7";
    private static final HashSet registeredModules;
    private static String registeredModulesString;

    static {
        ExoPlayerLibraryInfo.registeredModules = new HashSet();
        ExoPlayerLibraryInfo.registeredModulesString = "goog.exo.core";
    }

    public static void registerModule(String s) {
        synchronized(ExoPlayerLibraryInfo.class) {
            if(ExoPlayerLibraryInfo.registeredModules.add(s)) {
                ExoPlayerLibraryInfo.registeredModulesString = "goog.exo.core, " + s;
            }
        }
    }

    public static String registeredModules() [...] // 潜在的解密器
}

