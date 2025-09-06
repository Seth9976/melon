package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.upstream.HttpDataSource.Factory;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@TargetApi(18)
public final class OfflineLicenseHelper {
    private static final DrmInitData DUMMY_DRM_INIT_DATA;
    private final ConditionVariable conditionVariable;
    private final DefaultDrmSessionManager drmSessionManager;
    private final HandlerThread handlerThread;

    static {
        OfflineLicenseHelper.DUMMY_DRM_INIT_DATA = new DrmInitData(new SchemeData[0]);
    }

    public OfflineLicenseHelper(UUID uUID0, Provider exoMediaDrm$Provider0, MediaDrmCallback mediaDrmCallback0, Map map0) {
        HandlerThread handlerThread0 = new HandlerThread("OfflineLicenseHelper");
        this.handlerThread = handlerThread0;
        handlerThread0.start();
        this.conditionVariable = new ConditionVariable();
        com.google.android.exoplayer2.drm.OfflineLicenseHelper.1 offlineLicenseHelper$10 = new DefaultDrmSessionEventListener() {
            @Override  // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
            public void onDrmKeysLoaded() {
                OfflineLicenseHelper.access$000(OfflineLicenseHelper.this).open();
            }

            @Override  // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
            public void onDrmKeysRemoved() {
                OfflineLicenseHelper.access$000(OfflineLicenseHelper.this).open();
            }

            @Override  // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
            public void onDrmKeysRestored() {
                OfflineLicenseHelper.access$000(OfflineLicenseHelper.this).open();
            }

            @Override  // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
            public void onDrmSessionManagerError(Exception exception0) {
                OfflineLicenseHelper.access$000(OfflineLicenseHelper.this).open();
            }
        };
        if(map0 == null) {
            map0 = Collections.EMPTY_MAP;
        }
        DefaultDrmSessionManager defaultDrmSessionManager0 = new Builder().setUuidAndExoMediaDrmProvider(uUID0, exoMediaDrm$Provider0).setKeyRequestParameters(map0).build(mediaDrmCallback0);
        this.drmSessionManager = defaultDrmSessionManager0;
        defaultDrmSessionManager0.addListener(new Handler(handlerThread0.getLooper()), offlineLicenseHelper$10);
    }

    public static ConditionVariable access$000(OfflineLicenseHelper offlineLicenseHelper0) {
        return offlineLicenseHelper0.conditionVariable;
    }

    private byte[] blockingKeyRequest(int v, byte[] arr_b, DrmInitData drmInitData0) {
        this.drmSessionManager.prepare();
        DrmSession drmSession0 = this.openBlockingKeyRequest(v, arr_b, drmInitData0);
        DrmSessionException drmSession$DrmSessionException0 = drmSession0.getError();
        byte[] arr_b1 = drmSession0.getOfflineLicenseKeySetId();
        drmSession0.release();
        this.drmSessionManager.release();
        if(drmSession$DrmSessionException0 != null) {
            throw drmSession$DrmSessionException0;
        }
        return (byte[])Assertions.checkNotNull(arr_b1);
    }

    public byte[] downloadLicense(DrmInitData drmInitData0) {
        synchronized(this) {
            Assertions.checkArgument(drmInitData0 != null);
            return this.blockingKeyRequest(2, null, drmInitData0);
        }
    }

    public Pair getLicenseDurationRemainingSec(byte[] arr_b) {
        synchronized(this) {
            Assertions.checkNotNull(arr_b);
            this.drmSessionManager.prepare();
            DrmSession drmSession0 = this.openBlockingKeyRequest(1, arr_b, OfflineLicenseHelper.DUMMY_DRM_INIT_DATA);
            DrmSessionException drmSession$DrmSessionException0 = drmSession0.getError();
            Pair pair0 = WidevineUtil.getLicenseDurationRemainingSec(drmSession0);
            drmSession0.release();
            this.drmSessionManager.release();
            if(drmSession$DrmSessionException0 != null) {
                if(!(drmSession$DrmSessionException0.getCause() instanceof KeysExpiredException)) {
                    throw drmSession$DrmSessionException0;
                }
                return Pair.create(0L, 0L);
            }
            return (Pair)Assertions.checkNotNull(pair0);
        }
    }

    public static OfflineLicenseHelper newWidevineInstance(String s, Factory httpDataSource$Factory0) {
        return OfflineLicenseHelper.newWidevineInstance(s, false, httpDataSource$Factory0, null);
    }

    public static OfflineLicenseHelper newWidevineInstance(String s, boolean z, Factory httpDataSource$Factory0) {
        return OfflineLicenseHelper.newWidevineInstance(s, z, httpDataSource$Factory0, null);
    }

    public static OfflineLicenseHelper newWidevineInstance(String s, boolean z, Factory httpDataSource$Factory0, Map map0) {
        HttpMediaDrmCallback httpMediaDrmCallback0 = new HttpMediaDrmCallback(s, z, httpDataSource$Factory0);
        return new OfflineLicenseHelper(C.WIDEVINE_UUID, FrameworkMediaDrm.DEFAULT_PROVIDER, httpMediaDrmCallback0, map0);
    }

    private DrmSession openBlockingKeyRequest(int v, byte[] arr_b, DrmInitData drmInitData0) {
        this.drmSessionManager.setMode(v, arr_b);
        this.conditionVariable.close();
        Looper looper0 = this.handlerThread.getLooper();
        DrmSession drmSession0 = this.drmSessionManager.acquireSession(looper0, drmInitData0);
        this.conditionVariable.block();
        return drmSession0;
    }

    public void release() {
        this.handlerThread.quit();
    }

    public void releaseLicense(byte[] arr_b) {
        synchronized(this) {
            Assertions.checkNotNull(arr_b);
            this.blockingKeyRequest(3, arr_b, OfflineLicenseHelper.DUMMY_DRM_INIT_DATA);
        }
    }

    public byte[] renewLicense(byte[] arr_b) {
        synchronized(this) {
            Assertions.checkNotNull(arr_b);
            return this.blockingKeyRequest(2, arr_b, OfflineLicenseHelper.DUMMY_DRM_INIT_DATA);
        }
    }
}

