package com.google.android.exoplayer2.ext.flac;

import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.util.LibraryLoader;

public final class FlacLibrary {
    private static final LibraryLoader LOADER;
    public static final int a;

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.flac");
        FlacLibrary.LOADER = new LibraryLoader(new String[]{"flacJNI"});
    }

    public static boolean isAvailable() {
        return FlacLibrary.LOADER.isAvailable();
    }

    public static void setLibraries(String[] arr_s) {
        FlacLibrary.LOADER.setLibraries(arr_s);
    }
}

