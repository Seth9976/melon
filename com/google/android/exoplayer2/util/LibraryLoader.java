package com.google.android.exoplayer2.util;

import java.util.Arrays;

public final class LibraryLoader {
    private static final String TAG = "LibraryLoader";
    private boolean isAvailable;
    private boolean loadAttempted;
    private String[] nativeLibraries;

    public LibraryLoader(String[] arr_s) {
        this.nativeLibraries = arr_s;
    }

    public boolean isAvailable() {
        synchronized(this) {
            if(this.loadAttempted) {
                return this.isAvailable;
            }
            try {
                this.loadAttempted = true;
                String[] arr_s = this.nativeLibraries;
                for(int v1 = 0; v1 < arr_s.length; ++v1) {
                    System.loadLibrary(arr_s[v1]);
                }
                this.isAvailable = true;
            }
            catch(UnsatisfiedLinkError unused_ex) {
                String s = Arrays.toString(this.nativeLibraries);
                Log.w("LibraryLoader", (s.length() == 0 ? new String("Failed to load ") : "Failed to load " + s));
            }
            return this.isAvailable;
        }
    }

    public void setLibraries(String[] arr_s) {
        synchronized(this) {
            Assertions.checkState(!this.loadAttempted, "Cannot set libraries after loading");
            this.nativeLibraries = arr_s;
        }
    }
}

