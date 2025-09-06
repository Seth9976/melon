package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Util;
import java.util.UUID;

public final class FrameworkMediaCrypto implements ExoMediaCrypto {
    public static final boolean WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC;
    public final boolean forceAllowInsecureDecoderComponents;
    public final byte[] sessionId;
    public final UUID uuid;

    static {
        FrameworkMediaCrypto.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC = "Amazon".equals(Util.MANUFACTURER) && ("AFTM".equals(Util.MODEL) || "AFTB".equals(Util.MODEL));
    }

    public FrameworkMediaCrypto(UUID uUID0, byte[] arr_b, boolean z) {
        this.uuid = uUID0;
        this.sessionId = arr_b;
        this.forceAllowInsecureDecoderComponents = z;
    }
}

