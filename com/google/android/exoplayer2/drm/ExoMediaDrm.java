package com.google.android.exoplayer2.drm;

import android.os.PersistableBundle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ExoMediaDrm {
    public static final class AppManagedProvider implements Provider {
        private final ExoMediaDrm exoMediaDrm;

        public AppManagedProvider(ExoMediaDrm exoMediaDrm0) {
            this.exoMediaDrm = exoMediaDrm0;
        }

        @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm$Provider
        public ExoMediaDrm acquireExoMediaDrm(UUID uUID0) {
            this.exoMediaDrm.acquire();
            return this.exoMediaDrm;
        }
    }

    public static final class KeyRequest {
        private final byte[] data;
        private final String licenseServerUrl;

        public KeyRequest(byte[] arr_b, String s) {
            this.data = arr_b;
            this.licenseServerUrl = s;
        }

        public byte[] getData() {
            return this.data;
        }

        public String getLicenseServerUrl() {
            return this.licenseServerUrl;
        }
    }

    public static final class KeyStatus {
        private final byte[] keyId;
        private final int statusCode;

        public KeyStatus(int v, byte[] arr_b) {
            this.statusCode = v;
            this.keyId = arr_b;
        }

        public byte[] getKeyId() {
            return this.keyId;
        }

        public int getStatusCode() {
            return this.statusCode;
        }
    }

    public interface OnEventListener {
        void onEvent(ExoMediaDrm arg1, byte[] arg2, int arg3, int arg4, byte[] arg5);
    }

    public interface OnKeyStatusChangeListener {
        void onKeyStatusChange(ExoMediaDrm arg1, byte[] arg2, List arg3, boolean arg4);
    }

    public interface Provider {
        ExoMediaDrm acquireExoMediaDrm(UUID arg1);
    }

    public static final class ProvisionRequest {
        private final byte[] data;
        private final String defaultUrl;

        public ProvisionRequest(byte[] arr_b, String s) {
            this.data = arr_b;
            this.defaultUrl = s;
        }

        public byte[] getData() {
            return this.data;
        }

        public String getDefaultUrl() {
            return this.defaultUrl;
        }
    }

    public static final int EVENT_KEY_EXPIRED = 3;
    public static final int EVENT_KEY_REQUIRED = 2;
    public static final int EVENT_PROVISION_REQUIRED = 1;
    public static final int KEY_TYPE_OFFLINE = 2;
    public static final int KEY_TYPE_RELEASE = 3;
    public static final int KEY_TYPE_STREAMING = 1;

    void acquire();

    void closeSession(byte[] arg1);

    ExoMediaCrypto createMediaCrypto(byte[] arg1);

    Class getExoMediaCryptoType();

    KeyRequest getKeyRequest(byte[] arg1, List arg2, int arg3, HashMap arg4);

    PersistableBundle getMetrics();

    byte[] getPropertyByteArray(String arg1);

    String getPropertyString(String arg1);

    ProvisionRequest getProvisionRequest();

    byte[] openSession();

    byte[] provideKeyResponse(byte[] arg1, byte[] arg2);

    void provideProvisionResponse(byte[] arg1);

    Map queryKeyStatus(byte[] arg1);

    void release();

    void restoreKeys(byte[] arg1, byte[] arg2);

    void setOnEventListener(OnEventListener arg1);

    void setOnKeyStatusChangeListener(OnKeyStatusChangeListener arg1);

    void setPropertyByteArray(String arg1, byte[] arg2);

    void setPropertyString(String arg1, String arg2);
}

