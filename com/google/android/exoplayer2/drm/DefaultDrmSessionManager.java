package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.EventDispatcher;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@TargetApi(18)
public class DefaultDrmSessionManager implements DrmSessionManager {
    public static final class Builder {
        private Provider exoMediaDrmProvider;
        private final HashMap keyRequestParameters;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private boolean multiSession;
        private boolean playClearSamplesWithoutKeys;
        private int[] useDrmSessionsForClearContentTrackTypes;
        private UUID uuid;

        public Builder() {
            this.keyRequestParameters = new HashMap();
            this.uuid = C.WIDEVINE_UUID;
            this.exoMediaDrmProvider = FrameworkMediaDrm.DEFAULT_PROVIDER;
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            this.useDrmSessionsForClearContentTrackTypes = new int[0];
        }

        public DefaultDrmSessionManager build(MediaDrmCallback mediaDrmCallback0) {
            return new DefaultDrmSessionManager(this.uuid, this.exoMediaDrmProvider, mediaDrmCallback0, this.keyRequestParameters, this.multiSession, this.useDrmSessionsForClearContentTrackTypes, this.playClearSamplesWithoutKeys, this.loadErrorHandlingPolicy, null);
        }

        public Builder setKeyRequestParameters(Map map0) {
            this.keyRequestParameters.clear();
            Map map1 = (Map)Assertions.checkNotNull(map0);
            this.keyRequestParameters.putAll(map1);
            return this;
        }

        public Builder setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy0) {
            this.loadErrorHandlingPolicy = (LoadErrorHandlingPolicy)Assertions.checkNotNull(loadErrorHandlingPolicy0);
            return this;
        }

        public Builder setMultiSession(boolean z) {
            this.multiSession = z;
            return this;
        }

        public Builder setPlayClearSamplesWithoutKeys(boolean z) {
            this.playClearSamplesWithoutKeys = z;
            return this;
        }

        public Builder setUseDrmSessionsForClearContent(int[] arr_v) {
            for(int v = 0; v < arr_v.length; ++v) {
                boolean z = true;
                switch(arr_v[v]) {
                    case 1: 
                    case 2: {
                        break;
                    }
                    default: {
                        z = false;
                    }
                }
                Assertions.checkArgument(z);
            }
            this.useDrmSessionsForClearContentTrackTypes = (int[])arr_v.clone();
            return this;
        }

        public Builder setUuidAndExoMediaDrmProvider(UUID uUID0, Provider exoMediaDrm$Provider0) {
            this.uuid = (UUID)Assertions.checkNotNull(uUID0);
            this.exoMediaDrmProvider = (Provider)Assertions.checkNotNull(exoMediaDrm$Provider0);
            return this;
        }
    }

    class MediaDrmEventListener implements OnEventListener {
        private MediaDrmEventListener() {
        }

        public MediaDrmEventListener(com.google.android.exoplayer2.drm.DefaultDrmSessionManager.1 defaultDrmSessionManager$10) {
        }

        @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm$OnEventListener
        public void onEvent(ExoMediaDrm exoMediaDrm0, byte[] arr_b, int v, int v1, byte[] arr_b1) {
            ((MediaDrmHandler)Assertions.checkNotNull(DefaultDrmSessionManager.this.mediaDrmHandler)).obtainMessage(v, arr_b).sendToTarget();
        }
    }

    @SuppressLint({"HandlerLeak"})
    class MediaDrmHandler extends Handler {
        public MediaDrmHandler(Looper looper0) {
            super(looper0);
        }

        @Override  // android.os.Handler
        public void handleMessage(Message message0) {
            byte[] arr_b = (byte[])message0.obj;
            if(arr_b != null) {
                for(Object object0: DefaultDrmSessionManager.this.sessions) {
                    DefaultDrmSession defaultDrmSession0 = (DefaultDrmSession)object0;
                    if(defaultDrmSession0.hasSessionId(arr_b)) {
                        defaultDrmSession0.onMediaDrmEvent(message0.what);
                        return;
                    }
                    if(false) {
                        break;
                    }
                }
            }
        }
    }

    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uUID0) {
            super("Media does not support uuid: " + uUID0);
        }

        public MissingSchemeDataException(UUID uUID0, com.google.android.exoplayer2.drm.DefaultDrmSessionManager.1 defaultDrmSessionManager$10) {
            this(uUID0);
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    class ProvisioningManagerImpl implements ProvisioningManager {
        private ProvisioningManagerImpl() {
        }

        public ProvisioningManagerImpl(com.google.android.exoplayer2.drm.DefaultDrmSessionManager.1 defaultDrmSessionManager$10) {
        }

        @Override  // com.google.android.exoplayer2.drm.DefaultDrmSession$ProvisioningManager
        public void onProvisionCompleted() {
            for(Object object0: DefaultDrmSessionManager.this.provisioningSessions) {
                ((DefaultDrmSession)object0).onProvisionCompleted();
            }
            DefaultDrmSessionManager.this.provisioningSessions.clear();
        }

        @Override  // com.google.android.exoplayer2.drm.DefaultDrmSession$ProvisioningManager
        public void onProvisionError(Exception exception0) {
            for(Object object0: DefaultDrmSessionManager.this.provisioningSessions) {
                ((DefaultDrmSession)object0).onProvisionError(exception0);
            }
            DefaultDrmSessionManager.this.provisioningSessions.clear();
        }

        @Override  // com.google.android.exoplayer2.drm.DefaultDrmSession$ProvisioningManager
        public void provisionRequired(DefaultDrmSession defaultDrmSession0) {
            if(!DefaultDrmSessionManager.this.provisioningSessions.contains(defaultDrmSession0)) {
                DefaultDrmSessionManager.this.provisioningSessions.add(defaultDrmSession0);
                if(DefaultDrmSessionManager.this.provisioningSessions.size() == 1) {
                    defaultDrmSession0.provision();
                }
            }
        }
    }

    public static final int INITIAL_DRM_REQUEST_RETRY_COUNT = 3;
    public static final int MODE_DOWNLOAD = 2;
    public static final int MODE_PLAYBACK = 0;
    public static final int MODE_QUERY = 1;
    public static final int MODE_RELEASE = 3;
    public static final String PLAYREADY_CUSTOM_DATA_KEY = "PRCustomData";
    private static final String TAG = "DefaultDrmSessionMgr";
    private final MediaDrmCallback callback;
    private final EventDispatcher eventDispatcher;
    private ExoMediaDrm exoMediaDrm;
    private final Provider exoMediaDrmProvider;
    private final HashMap keyRequestParameters;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    volatile MediaDrmHandler mediaDrmHandler;
    private int mode;
    private final boolean multiSession;
    private DefaultDrmSession noMultiSessionDrmSession;
    private byte[] offlineLicenseKeySetId;
    private DefaultDrmSession placeholderDrmSession;
    private final boolean playClearSamplesWithoutKeys;
    private Looper playbackLooper;
    private int prepareCallsCount;
    private final ProvisioningManagerImpl provisioningManagerImpl;
    private final List provisioningSessions;
    private final List sessions;
    private final int[] useDrmSessionsForClearContentTrackTypes;
    private final UUID uuid;

    private DefaultDrmSessionManager(UUID uUID0, Provider exoMediaDrm$Provider0, MediaDrmCallback mediaDrmCallback0, HashMap hashMap0, boolean z, int[] arr_v, boolean z1, LoadErrorHandlingPolicy loadErrorHandlingPolicy0) {
        Assertions.checkNotNull(uUID0);
        Assertions.checkArgument(!C.COMMON_PSSH_UUID.equals(uUID0), "Use C.CLEARKEY_UUID instead");
        this.uuid = uUID0;
        this.exoMediaDrmProvider = exoMediaDrm$Provider0;
        this.callback = mediaDrmCallback0;
        this.keyRequestParameters = hashMap0;
        this.eventDispatcher = new EventDispatcher();
        this.multiSession = z;
        this.useDrmSessionsForClearContentTrackTypes = arr_v;
        this.playClearSamplesWithoutKeys = z1;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy0;
        this.provisioningManagerImpl = new ProvisioningManagerImpl(this, null);
        this.mode = 0;
        this.sessions = new ArrayList();
        this.provisioningSessions = new ArrayList();
    }

    public DefaultDrmSessionManager(UUID uUID0, Provider exoMediaDrm$Provider0, MediaDrmCallback mediaDrmCallback0, HashMap hashMap0, boolean z, int[] arr_v, boolean z1, LoadErrorHandlingPolicy loadErrorHandlingPolicy0, com.google.android.exoplayer2.drm.DefaultDrmSessionManager.1 defaultDrmSessionManager$10) {
        this(uUID0, exoMediaDrm$Provider0, mediaDrmCallback0, hashMap0, z, arr_v, z1, loadErrorHandlingPolicy0);
    }

    @Deprecated
    public DefaultDrmSessionManager(UUID uUID0, ExoMediaDrm exoMediaDrm0, MediaDrmCallback mediaDrmCallback0, HashMap hashMap0) {
        if(hashMap0 == null) {
            hashMap0 = new HashMap();
        }
        this(uUID0, exoMediaDrm0, mediaDrmCallback0, hashMap0, false, 3);
    }

    @Deprecated
    public DefaultDrmSessionManager(UUID uUID0, ExoMediaDrm exoMediaDrm0, MediaDrmCallback mediaDrmCallback0, HashMap hashMap0, boolean z) {
        if(hashMap0 == null) {
            hashMap0 = new HashMap();
        }
        this(uUID0, exoMediaDrm0, mediaDrmCallback0, hashMap0, z, 3);
    }

    @Deprecated
    public DefaultDrmSessionManager(UUID uUID0, ExoMediaDrm exoMediaDrm0, MediaDrmCallback mediaDrmCallback0, HashMap hashMap0, boolean z, int v) {
        AppManagedProvider exoMediaDrm$AppManagedProvider0 = new AppManagedProvider(exoMediaDrm0);
        if(hashMap0 == null) {
            hashMap0 = new HashMap();
        }
        DefaultLoadErrorHandlingPolicy defaultLoadErrorHandlingPolicy0 = new DefaultLoadErrorHandlingPolicy(v);
        this(uUID0, exoMediaDrm$AppManagedProvider0, mediaDrmCallback0, hashMap0, z, new int[0], false, defaultLoadErrorHandlingPolicy0);
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSessionManager
    public DrmSession acquirePlaceholderSession(Looper looper0, int v) {
        this.assertExpectedPlaybackLooper(looper0);
        ExoMediaDrm exoMediaDrm0 = (ExoMediaDrm)Assertions.checkNotNull(this.exoMediaDrm);
        Class class0 = exoMediaDrm0.getExoMediaCryptoType();
        if((!FrameworkMediaCrypto.class.equals(class0) || !FrameworkMediaCrypto.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) && Util.linearSearch(this.useDrmSessionsForClearContentTrackTypes, v) != -1 && exoMediaDrm0.getExoMediaCryptoType() != null) {
            this.maybeCreateMediaDrmHandler(looper0);
            if(this.placeholderDrmSession == null) {
                DefaultDrmSession defaultDrmSession0 = this.createNewDefaultSession(Collections.EMPTY_LIST, true);
                this.sessions.add(defaultDrmSession0);
                this.placeholderDrmSession = defaultDrmSession0;
            }
            this.placeholderDrmSession.acquire();
            return this.placeholderDrmSession;
        }
        return null;
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSessionManager
    public DrmSession acquireSession(Looper looper0, DrmInitData drmInitData0) {
        List list0;
        this.assertExpectedPlaybackLooper(looper0);
        this.maybeCreateMediaDrmHandler(looper0);
        DefaultDrmSession defaultDrmSession0 = null;
        if(this.offlineLicenseKeySetId == null) {
            list0 = DefaultDrmSessionManager.getSchemeDatas(drmInitData0, this.uuid, false);
            if(list0.isEmpty()) {
                MissingSchemeDataException defaultDrmSessionManager$MissingSchemeDataException0 = new MissingSchemeDataException(this.uuid, null);
                a a0 = new a(defaultDrmSessionManager$MissingSchemeDataException0, 1);
                this.eventDispatcher.dispatch(a0);
                return new ErrorStateDrmSession(new DrmSessionException(defaultDrmSessionManager$MissingSchemeDataException0));
            }
        }
        else {
            list0 = null;
        }
        if(this.multiSession) {
            for(Object object0: this.sessions) {
                DefaultDrmSession defaultDrmSession1 = (DefaultDrmSession)object0;
                if(Util.areEqual(defaultDrmSession1.schemeDatas, list0)) {
                    defaultDrmSession0 = defaultDrmSession1;
                    break;
                }
                if(false) {
                    break;
                }
            }
        }
        else {
            defaultDrmSession0 = this.noMultiSessionDrmSession;
        }
        if(defaultDrmSession0 == null) {
            defaultDrmSession0 = this.createNewDefaultSession(list0, false);
            if(!this.multiSession) {
                this.noMultiSessionDrmSession = defaultDrmSession0;
            }
            this.sessions.add(defaultDrmSession0);
        }
        defaultDrmSession0.acquire();
        return defaultDrmSession0;
    }

    public final void addListener(Handler handler0, DefaultDrmSessionEventListener defaultDrmSessionEventListener0) {
        this.eventDispatcher.addListener(handler0, defaultDrmSessionEventListener0);
    }

    private void assertExpectedPlaybackLooper(Looper looper0) {
        Assertions.checkState(this.playbackLooper == null || this.playbackLooper == looper0);
        this.playbackLooper = looper0;
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSessionManager
    public boolean canAcquireSession(DrmInitData drmInitData0) {
        if(this.offlineLicenseKeySetId != null) {
            return true;
        }
        if(DefaultDrmSessionManager.getSchemeDatas(drmInitData0, this.uuid, true).isEmpty()) {
            if(drmInitData0.schemeDataCount == 1 && drmInitData0.get(0).matches(C.COMMON_PSSH_UUID)) {
                Log.w("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.uuid);
                return drmInitData0.schemeType != null && !"cenc".equals(drmInitData0.schemeType) && ("cbc1".equals(drmInitData0.schemeType) || "cbcs".equals(drmInitData0.schemeType) || "cens".equals(drmInitData0.schemeType)) ? Util.SDK_INT >= 25 : true;
            }
            return false;
        }
        return drmInitData0.schemeType != null && !"cenc".equals(drmInitData0.schemeType) && ("cbc1".equals(drmInitData0.schemeType) || "cbcs".equals(drmInitData0.schemeType) || "cens".equals(drmInitData0.schemeType)) ? Util.SDK_INT >= 25 : true;
    }

    private DefaultDrmSession createNewDefaultSession(List list0, boolean z) {
        Assertions.checkNotNull(this.exoMediaDrm);
        ExoMediaDrm exoMediaDrm0 = this.exoMediaDrm;
        a a0 = new a(this, 2);
        int v = this.mode;
        byte[] arr_b = this.offlineLicenseKeySetId;
        Object object0 = Assertions.checkNotNull(this.playbackLooper);
        return new DefaultDrmSession(this.uuid, exoMediaDrm0, this.provisioningManagerImpl, a0, list0, v, ((boolean)(this.playClearSamplesWithoutKeys | z)), z, arr_b, this.keyRequestParameters, this.callback, ((Looper)object0), this.eventDispatcher, this.loadErrorHandlingPolicy);
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.drm.DrmSessionManager
    public Class getExoMediaCryptoType(DrmInitData drmInitData0) {
        return this.canAcquireSession(drmInitData0) ? ((ExoMediaDrm)Assertions.checkNotNull(this.exoMediaDrm)).getExoMediaCryptoType() : null;
    }

    private static List getSchemeDatas(DrmInitData drmInitData0, UUID uUID0, boolean z) {
        List list0 = new ArrayList(drmInitData0.schemeDataCount);
        for(int v = 0; v < drmInitData0.schemeDataCount; ++v) {
            SchemeData drmInitData$SchemeData0 = drmInitData0.get(v);
            if((drmInitData$SchemeData0.matches(uUID0) || C.CLEARKEY_UUID.equals(uUID0) && drmInitData$SchemeData0.matches(C.COMMON_PSSH_UUID)) && (drmInitData$SchemeData0.data != null || z)) {
                ((ArrayList)list0).add(drmInitData$SchemeData0);
            }
        }
        return list0;
    }

    private static void lambda$acquireSession$0(MissingSchemeDataException defaultDrmSessionManager$MissingSchemeDataException0, DefaultDrmSessionEventListener defaultDrmSessionEventListener0) {
        defaultDrmSessionEventListener0.onDrmSessionManagerError(defaultDrmSessionManager$MissingSchemeDataException0);
    }

    private void maybeCreateMediaDrmHandler(Looper looper0) {
        if(this.mediaDrmHandler == null) {
            this.mediaDrmHandler = new MediaDrmHandler(this, looper0);
        }
    }

    private void onSessionReleased(DefaultDrmSession defaultDrmSession0) {
        this.sessions.remove(defaultDrmSession0);
        if(this.placeholderDrmSession == defaultDrmSession0) {
            this.placeholderDrmSession = null;
        }
        if(this.noMultiSessionDrmSession == defaultDrmSession0) {
            this.noMultiSessionDrmSession = null;
        }
        if(this.provisioningSessions.size() > 1 && this.provisioningSessions.get(0) == defaultDrmSession0) {
            ((DefaultDrmSession)this.provisioningSessions.get(1)).provision();
        }
        this.provisioningSessions.remove(defaultDrmSession0);
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSessionManager
    public final void prepare() {
        int v = this.prepareCallsCount;
        this.prepareCallsCount = v + 1;
        if(v == 0) {
            Assertions.checkState(this.exoMediaDrm == null);
            ExoMediaDrm exoMediaDrm0 = this.exoMediaDrmProvider.acquireExoMediaDrm(this.uuid);
            this.exoMediaDrm = exoMediaDrm0;
            exoMediaDrm0.setOnEventListener(new MediaDrmEventListener(this, null));
        }
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSessionManager
    public final void release() {
        int v = this.prepareCallsCount - 1;
        this.prepareCallsCount = v;
        if(v == 0) {
            ((ExoMediaDrm)Assertions.checkNotNull(this.exoMediaDrm)).release();
            this.exoMediaDrm = null;
        }
    }

    public final void removeListener(DefaultDrmSessionEventListener defaultDrmSessionEventListener0) {
        this.eventDispatcher.removeListener(defaultDrmSessionEventListener0);
    }

    public void setMode(int v, byte[] arr_b) {
        Assertions.checkState(this.sessions.isEmpty());
        if(v == 1 || v == 3) {
            Assertions.checkNotNull(arr_b);
        }
        this.mode = v;
        this.offlineLicenseKeySetId = arr_b;
    }

    class com.google.android.exoplayer2.drm.DefaultDrmSessionManager.1 {
    }

}

