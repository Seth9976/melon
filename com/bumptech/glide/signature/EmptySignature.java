package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

public final class EmptySignature implements Key {
    private static final EmptySignature EMPTY_KEY;

    static {
        EmptySignature.EMPTY_KEY = new EmptySignature();
    }

    public static EmptySignature obtain() {
        return EmptySignature.EMPTY_KEY;
    }

    @Override
    public String toString() {
        return "EmptySignature";
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
    }
}

