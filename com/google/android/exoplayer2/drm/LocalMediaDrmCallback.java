package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Assertions;
import java.util.UUID;

public final class LocalMediaDrmCallback implements MediaDrmCallback {
    private final byte[] keyResponse;

    public LocalMediaDrmCallback(byte[] arr_b) {
        this.keyResponse = (byte[])Assertions.checkNotNull(arr_b);
    }

    @Override  // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeKeyRequest(UUID uUID0, KeyRequest exoMediaDrm$KeyRequest0) {
        return this.keyResponse;
    }

    @Override  // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(UUID uUID0, ProvisionRequest exoMediaDrm$ProvisionRequest0) {
        throw new UnsupportedOperationException();
    }
}

