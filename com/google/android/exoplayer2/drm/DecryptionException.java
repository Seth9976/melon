package com.google.android.exoplayer2.drm;

public class DecryptionException extends Exception {
    public final int errorCode;

    public DecryptionException(int v, String s) {
        super(s);
        this.errorCode = v;
    }
}

