package com.google.android.exoplayer2.drm;

import android.os.Looper;

public interface DrmSessionManager {
    public static final DrmSessionManager DUMMY;

    static {
        DrmSessionManager.DUMMY = new DrmSessionManager() {
            @Override  // com.google.android.exoplayer2.drm.DrmSessionManager
            public DrmSession acquireSession(Looper looper0, DrmInitData drmInitData0) {
                return new ErrorStateDrmSession(new DrmSessionException(new UnsupportedDrmException(1)));
            }

            @Override  // com.google.android.exoplayer2.drm.DrmSessionManager
            public boolean canAcquireSession(DrmInitData drmInitData0) {
                return false;
            }

            @Override  // com.google.android.exoplayer2.drm.DrmSessionManager
            public Class getExoMediaCryptoType(DrmInitData drmInitData0) {
                return null;
            }
        };
    }

    default DrmSession acquirePlaceholderSession(Looper looper0, int v) {
        return null;
    }

    DrmSession acquireSession(Looper arg1, DrmInitData arg2);

    boolean canAcquireSession(DrmInitData arg1);

    static DrmSessionManager getDummyDrmSessionManager() {
        return DrmSessionManager.DUMMY;
    }

    Class getExoMediaCryptoType(DrmInitData arg1);

    default void prepare() {
    }

    default void release() {
    }
}

