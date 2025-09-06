package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface RendererCapabilities {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdaptiveSupport {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Capabilities {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FormatSupport {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TunnelingSupport {
    }

    public static final int ADAPTIVE_NOT_SEAMLESS = 8;
    public static final int ADAPTIVE_NOT_SUPPORTED = 0;
    public static final int ADAPTIVE_SEAMLESS = 16;
    public static final int ADAPTIVE_SUPPORT_MASK = 24;
    public static final int FORMAT_EXCEEDS_CAPABILITIES = 3;
    public static final int FORMAT_HANDLED = 4;
    public static final int FORMAT_SUPPORT_MASK = 7;
    public static final int FORMAT_UNSUPPORTED_DRM = 2;
    public static final int FORMAT_UNSUPPORTED_SUBTYPE = 1;
    public static final int FORMAT_UNSUPPORTED_TYPE = 0;
    public static final int TUNNELING_NOT_SUPPORTED = 0;
    public static final int TUNNELING_SUPPORTED = 0x20;
    public static final int TUNNELING_SUPPORT_MASK = 0x20;

    static int create(int v) [...] // 潜在的解密器

    @SuppressLint({"WrongConstant"})
    static int create(int v, int v1, int v2) [...] // Inlined contents

    @SuppressLint({"WrongConstant"})
    static int getAdaptiveSupport(int v) {
        return v & 24;
    }

    @SuppressLint({"WrongConstant"})
    static int getFormatSupport(int v) [...] // Inlined contents

    static String getFormatSupportString(int v) [...] // 潜在的解密器

    int getTrackType();

    @SuppressLint({"WrongConstant"})
    static int getTunnelingSupport(int v) {
        return v & 0x20;
    }

    int supportsFormat(Format arg1);

    int supportsMixedMimeTypeAdaptation();
}

