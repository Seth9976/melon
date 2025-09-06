package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;

public interface ContentMetadata {
    public static final String KEY_CONTENT_LENGTH = "exo_len";
    public static final String KEY_CUSTOM_PREFIX = "custom_";
    public static final String KEY_REDIRECTED_URI = "exo_redir";

    boolean contains(String arg1);

    long get(String arg1, long arg2);

    String get(String arg1, String arg2);

    byte[] get(String arg1, byte[] arg2);

    static long getContentLength(ContentMetadata contentMetadata0) {
        return contentMetadata0.get("exo_len", -1L);
    }

    static Uri getRedirectedUri(ContentMetadata contentMetadata0) {
        String s = contentMetadata0.get("exo_redir", null);
        return s == null ? null : Uri.parse(s);
    }
}

