package com.google.android.exoplayer2.upstream.crypto;

final class CryptoUtil {
    public static long getFNV64Hash(String s) {
        long v = 0L;
        if(s == null) {
            return 0L;
        }
        for(int v1 = 0; v1 < s.length(); ++v1) {
            v = 435 * (v ^ ((long)s.charAt(v1)));
        }
        return v;
    }
}

