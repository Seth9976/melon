package io.netty.util.internal.shaded.org.jctools.util;

public interface PortableJvmInfo {
    public static final int CACHE_LINE_SIZE;
    public static final int CPUs;
    public static final int RECOMENDED_OFFER_BATCH;
    public static final int RECOMENDED_POLL_BATCH;

    static {
        PortableJvmInfo.CACHE_LINE_SIZE = 0x40;
        int v = Runtime.getRuntime().availableProcessors();
        PortableJvmInfo.CPUs = v;
        PortableJvmInfo.RECOMENDED_OFFER_BATCH = v * 4;
        PortableJvmInfo.RECOMENDED_POLL_BATCH = v * 4;
    }
}

