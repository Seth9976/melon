package com.bumptech.glide.util.pool;

import java.util.concurrent.atomic.AtomicInteger;

public final class GlideTrace {
    private static final AtomicInteger COOKIE_CREATOR = null;
    private static final int MAX_LENGTH = 0x7F;
    private static final boolean TRACING_ENABLED = false;

    public static void beginSection(String s) {
    }

    public static int beginSectionAsync(String s) [...] // Inlined contents

    public static void beginSectionFormat(String s, Object object0) {
    }

    public static void beginSectionFormat(String s, Object object0, Object object1) {
    }

    public static void beginSectionFormat(String s, Object object0, Object object1, Object object2) {
    }

    public static void endSection() {
    }

    public static void endSectionAsync(String s, int v) {
    }

    private static String truncateTag(String s) {
        return s.length() <= 0x7F ? s : s.substring(0, 0x7E);
    }
}

