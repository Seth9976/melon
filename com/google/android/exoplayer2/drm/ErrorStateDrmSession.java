package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Map;

public final class ErrorStateDrmSession implements DrmSession {
    private final DrmSessionException error;

    public ErrorStateDrmSession(DrmSessionException drmSession$DrmSessionException0) {
        this.error = (DrmSessionException)Assertions.checkNotNull(drmSession$DrmSessionException0);
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSession
    public void acquire() {
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSession
    public DrmSessionException getError() {
        return this.error;
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSession
    public ExoMediaCrypto getMediaCrypto() {
        return null;
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSession
    public byte[] getOfflineLicenseKeySetId() {
        return null;
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSession
    public int getState() {
        return 1;
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSession
    public boolean playClearSamplesWithoutKeys() {
        return false;
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSession
    public Map queryKeyStatus() {
        return null;
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSession
    public void release() {
    }
}

