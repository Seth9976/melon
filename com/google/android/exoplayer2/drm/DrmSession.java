package com.google.android.exoplayer2.drm;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public interface DrmSession {
    public static class DrmSessionException extends IOException {
        public DrmSessionException(Throwable throwable0) {
            super(throwable0);
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public static final int STATE_ERROR = 1;
    public static final int STATE_OPENED = 3;
    public static final int STATE_OPENED_WITH_KEYS = 4;
    public static final int STATE_OPENING = 2;
    public static final int STATE_RELEASED;

    void acquire();

    DrmSessionException getError();

    ExoMediaCrypto getMediaCrypto();

    byte[] getOfflineLicenseKeySetId();

    int getState();

    default boolean playClearSamplesWithoutKeys() {
        return false;
    }

    Map queryKeyStatus();

    void release();

    static void replaceSession(DrmSession drmSession0, DrmSession drmSession1) {
        if(drmSession0 != drmSession1) {
            if(drmSession1 != null) {
                drmSession1.acquire();
            }
            if(drmSession0 != null) {
                drmSession0.release();
            }
        }
    }
}

