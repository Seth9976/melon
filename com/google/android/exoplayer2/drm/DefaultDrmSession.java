package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.facebook.appevents.b;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.EventDispatcher;
import com.google.android.exoplayer2.util.Log;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@TargetApi(18)
class DefaultDrmSession implements DrmSession {
    public interface ProvisioningManager {
        void onProvisionCompleted();

        void onProvisionError(Exception arg1);

        void provisionRequired(DefaultDrmSession arg1);
    }

    public interface ReleaseCallback {
        void onSessionReleased(DefaultDrmSession arg1);
    }

    @SuppressLint({"HandlerLeak"})
    class RequestHandler extends Handler {
        public RequestHandler(Looper looper0) {
            super(looper0);
        }

        @Override  // android.os.Handler
        public void handleMessage(Message message0) {
            RequestTask defaultDrmSession$RequestTask0 = (RequestTask)message0.obj;
            try {
                switch(message0.what) {
                    case 0: {
                        arr_b = DefaultDrmSession.this.callback.executeProvisionRequest(DefaultDrmSession.this.uuid, ((ProvisionRequest)defaultDrmSession$RequestTask0.request));
                        goto label_10;
                    }
                    case 1: {
                        arr_b = DefaultDrmSession.this.callback.executeKeyRequest(DefaultDrmSession.this.uuid, ((KeyRequest)defaultDrmSession$RequestTask0.request));
                        goto label_10;
                    }
                    default: {
                        throw new RuntimeException();
                    }
                }
            }
            catch(Exception arr_b) {
            }
            if(this.maybeRetryRequest(message0, ((Exception)arr_b))) {
                return;
            }
        label_10:
            int v = message0.what;
            Pair pair0 = Pair.create(defaultDrmSession$RequestTask0.request, arr_b);
            DefaultDrmSession.this.responseHandler.obtainMessage(v, pair0).sendToTarget();
        }

        private boolean maybeRetryRequest(Message message0, Exception exception0) {
            RequestTask defaultDrmSession$RequestTask0 = (RequestTask)message0.obj;
            if(!defaultDrmSession$RequestTask0.allowRetry) {
                return false;
            }
            int v = defaultDrmSession$RequestTask0.errorCount + 1;
            defaultDrmSession$RequestTask0.errorCount = v;
            if(v > DefaultDrmSession.this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(3)) {
                return false;
            }
            IOException iOException0 = exception0 instanceof IOException ? ((IOException)exception0) : new UnexpectedDrmSessionException(exception0);
            long v1 = SystemClock.elapsedRealtime();
            long v2 = DefaultDrmSession.this.loadErrorHandlingPolicy.getRetryDelayMsFor(3, v1 - defaultDrmSession$RequestTask0.startTimeMs, iOException0, defaultDrmSession$RequestTask0.errorCount);
            if(v2 == 0x8000000000000001L) {
                return false;
            }
            this.sendMessageDelayed(Message.obtain(message0), v2);
            return true;
        }

        public void post(int v, Object object0, boolean z) {
            this.obtainMessage(v, new RequestTask(z, SystemClock.elapsedRealtime(), object0)).sendToTarget();
        }
    }

    static final class RequestTask {
        public final boolean allowRetry;
        public int errorCount;
        public final Object request;
        public final long startTimeMs;

        public RequestTask(boolean z, long v, Object object0) {
            this.allowRetry = z;
            this.startTimeMs = v;
            this.request = object0;
        }
    }

    @SuppressLint({"HandlerLeak"})
    class ResponseHandler extends Handler {
        public ResponseHandler(Looper looper0) {
            super(looper0);
        }

        @Override  // android.os.Handler
        public void handleMessage(Message message0) {
            Object object0 = ((Pair)message0.obj).first;
            Object object1 = ((Pair)message0.obj).second;
            switch(message0.what) {
                case 0: {
                    DefaultDrmSession.this.onProvisionResponse(object0, object1);
                    return;
                }
                case 1: {
                    DefaultDrmSession.this.onKeyResponse(object0, object1);
                }
            }
        }
    }

    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(Throwable throwable0) {
            super("Unexpected " + throwable0.getClass().getSimpleName() + ": " + throwable0.getMessage(), throwable0);
        }
    }

    private static final int MAX_LICENSE_DURATION_TO_RENEW_SECONDS = 60;
    private static final int MSG_KEYS = 1;
    private static final int MSG_PROVISION = 0;
    private static final String TAG = "DefaultDrmSession";
    final MediaDrmCallback callback;
    private KeyRequest currentKeyRequest;
    private ProvisionRequest currentProvisionRequest;
    private final EventDispatcher eventDispatcher;
    private final boolean isPlaceholderSession;
    private final HashMap keyRequestParameters;
    private DrmSessionException lastException;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private ExoMediaCrypto mediaCrypto;
    private final ExoMediaDrm mediaDrm;
    private final int mode;
    private byte[] offlineLicenseKeySetId;
    private final boolean playClearSamplesWithoutKeys;
    private final ProvisioningManager provisioningManager;
    private int referenceCount;
    private final ReleaseCallback releaseCallback;
    private RequestHandler requestHandler;
    private HandlerThread requestHandlerThread;
    final ResponseHandler responseHandler;
    public final List schemeDatas;
    private byte[] sessionId;
    private int state;
    final UUID uuid;

    public DefaultDrmSession(UUID uUID0, ExoMediaDrm exoMediaDrm0, ProvisioningManager defaultDrmSession$ProvisioningManager0, ReleaseCallback defaultDrmSession$ReleaseCallback0, List list0, int v, boolean z, boolean z1, byte[] arr_b, HashMap hashMap0, MediaDrmCallback mediaDrmCallback0, Looper looper0, EventDispatcher eventDispatcher0, LoadErrorHandlingPolicy loadErrorHandlingPolicy0) {
        if(v == 1 || v == 3) {
            Assertions.checkNotNull(arr_b);
        }
        this.uuid = uUID0;
        this.provisioningManager = defaultDrmSession$ProvisioningManager0;
        this.releaseCallback = defaultDrmSession$ReleaseCallback0;
        this.mediaDrm = exoMediaDrm0;
        this.mode = v;
        this.playClearSamplesWithoutKeys = z;
        this.isPlaceholderSession = z1;
        if(arr_b == null) {
            this.schemeDatas = Collections.unmodifiableList(((List)Assertions.checkNotNull(list0)));
        }
        else {
            this.offlineLicenseKeySetId = arr_b;
            this.schemeDatas = null;
        }
        this.keyRequestParameters = hashMap0;
        this.callback = mediaDrmCallback0;
        this.eventDispatcher = eventDispatcher0;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy0;
        this.state = 2;
        this.responseHandler = new ResponseHandler(this, looper0);
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSession
    public void acquire() {
        boolean z = false;
        Assertions.checkState(this.referenceCount >= 0);
        int v = this.referenceCount + 1;
        this.referenceCount = v;
        if(v == 1) {
            if(this.state == 2) {
                z = true;
            }
            Assertions.checkState(z);
            HandlerThread handlerThread0 = new HandlerThread("DrmRequestHandler");
            this.requestHandlerThread = handlerThread0;
            handlerThread0.start();
            this.requestHandler = new RequestHandler(this, this.requestHandlerThread.getLooper());
            if(this.openInternal(true)) {
                this.doLicense(true);
            }
        }
    }

    @RequiresNonNull({"sessionId"})
    private void doLicense(boolean z) {
        if(!this.isPlaceholderSession) {
            byte[] arr_b = this.sessionId;
            int v = this.mode;
            switch(v) {
                case 0: 
                case 1: {
                    if(this.offlineLicenseKeySetId == null) {
                        this.postKeyRequest(arr_b, 1, z);
                        return;
                    }
                    if(this.state == 4 || this.restoreKeys()) {
                        long v1 = this.getLicenseDurationRemainingSec();
                        if(this.mode == 0 && v1 <= 60L) {
                            Log.d("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + v1);
                            this.postKeyRequest(arr_b, 2, z);
                            return;
                        }
                        if(v1 <= 0L) {
                            this.onError(new KeysExpiredException());
                            return;
                        }
                        this.state = 4;
                        b b0 = new b(10);
                        this.eventDispatcher.dispatch(b0);
                        return;
                    }
                    break;
                }
                case 2: {
                    if(this.offlineLicenseKeySetId == null || this.restoreKeys()) {
                        this.postKeyRequest(arr_b, 2, z);
                        return;
                    }
                    break;
                }
                default: {
                    if(v == 3) {
                        Assertions.checkNotNull(this.offlineLicenseKeySetId);
                        Assertions.checkNotNull(this.sessionId);
                        if(this.restoreKeys()) {
                            this.postKeyRequest(this.offlineLicenseKeySetId, 3, z);
                        }
                    }
                }
            }
        }
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSession
    public final DrmSessionException getError() {
        return this.state == 1 ? this.lastException : null;
    }

    private long getLicenseDurationRemainingSec() {
        if(!C.WIDEVINE_UUID.equals(this.uuid)) {
            return 0x7FFFFFFFFFFFFFFFL;
        }
        Pair pair0 = (Pair)Assertions.checkNotNull(WidevineUtil.getLicenseDurationRemainingSec(this));
        return Math.min(((long)(((Long)pair0.first))), ((long)(((Long)pair0.second))));
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSession
    public final ExoMediaCrypto getMediaCrypto() {
        return this.mediaCrypto;
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSession
    public byte[] getOfflineLicenseKeySetId() {
        return this.offlineLicenseKeySetId;
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.state;
    }

    public boolean hasSessionId(byte[] arr_b) {
        return Arrays.equals(this.sessionId, arr_b);
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean isOpen() {
        return this.state == 3 || this.state == 4;
    }

    private static void lambda$onError$0(Exception exception0, DefaultDrmSessionEventListener defaultDrmSessionEventListener0) {
        defaultDrmSessionEventListener0.onDrmSessionManagerError(exception0);
    }

    private void onError(Exception exception0) {
        this.lastException = new DrmSessionException(exception0);
        a a0 = new a(exception0, 0);
        this.eventDispatcher.dispatch(a0);
        if(this.state != 4) {
            this.state = 1;
        }
    }

    private void onKeyResponse(Object object0, Object object1) {
        if(object0 == this.currentKeyRequest && this.isOpen()) {
            this.currentKeyRequest = null;
            if(object1 instanceof Exception) {
                this.onKeysError(((Exception)object1));
                return;
            }
            try {
                if(this.mode == 3) {
                    this.mediaDrm.provideKeyResponse(this.offlineLicenseKeySetId, ((byte[])object1));
                    b b0 = new b(10);
                    this.eventDispatcher.dispatch(b0);
                    return;
                }
                byte[] arr_b = this.mediaDrm.provideKeyResponse(this.sessionId, ((byte[])object1));
                if((this.mode == 2 || this.mode == 0 && this.offlineLicenseKeySetId != null) && arr_b != null && arr_b.length != 0) {
                    this.offlineLicenseKeySetId = arr_b;
                }
                this.state = 4;
                b b1 = new b(11);
                this.eventDispatcher.dispatch(b1);
                return;
            }
            catch(Exception exception0) {
            }
            this.onKeysError(exception0);
        }
    }

    private void onKeysError(Exception exception0) {
        if(exception0 instanceof NotProvisionedException) {
            this.provisioningManager.provisionRequired(this);
            return;
        }
        this.onError(exception0);
    }

    private void onKeysRequired() {
        if(this.mode == 0 && this.state == 4) {
            this.doLicense(false);
        }
    }

    public void onMediaDrmEvent(int v) {
        if(v != 2) {
            return;
        }
        this.onKeysRequired();
    }

    public void onProvisionCompleted() {
        if(this.openInternal(false)) {
            this.doLicense(true);
        }
    }

    public void onProvisionError(Exception exception0) {
        this.onError(exception0);
    }

    private void onProvisionResponse(Object object0, Object object1) {
        if(object0 == this.currentProvisionRequest && (this.state == 2 || this.isOpen())) {
            this.currentProvisionRequest = null;
            if(object1 instanceof Exception) {
                this.provisioningManager.onProvisionError(((Exception)object1));
                return;
            }
            try {
                this.mediaDrm.provideProvisionResponse(((byte[])object1));
            }
            catch(Exception exception0) {
                this.provisioningManager.onProvisionError(exception0);
                return;
            }
            this.provisioningManager.onProvisionCompleted();
        }
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean openInternal(boolean z) {
        if(this.isOpen()) {
            return true;
        }
        try {
            byte[] arr_b = this.mediaDrm.openSession();
            this.sessionId = arr_b;
            this.mediaCrypto = this.mediaDrm.createMediaCrypto(arr_b);
            b b0 = new b(9);
            this.eventDispatcher.dispatch(b0);
            this.state = 3;
            Assertions.checkNotNull(this.sessionId);
            return true;
        }
        catch(NotProvisionedException notProvisionedException0) {
            if(z) {
                this.provisioningManager.provisionRequired(this);
                return false;
            }
            this.onError(notProvisionedException0);
            return false;
        }
        catch(Exception exception0) {
            this.onError(exception0);
            return false;
        }
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSession
    public boolean playClearSamplesWithoutKeys() {
        return this.playClearSamplesWithoutKeys;
    }

    private void postKeyRequest(byte[] arr_b, int v, boolean z) {
        try {
            this.currentKeyRequest = this.mediaDrm.getKeyRequest(arr_b, this.schemeDatas, v, this.keyRequestParameters);
            this.requestHandler.post(1, Assertions.checkNotNull(this.currentKeyRequest), z);
        }
        catch(Exception exception0) {
            this.onKeysError(exception0);
        }
    }

    public void provision() {
        this.currentProvisionRequest = this.mediaDrm.getProvisionRequest();
        this.requestHandler.post(0, Assertions.checkNotNull(this.currentProvisionRequest), true);
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSession
    public Map queryKeyStatus() {
        return this.sessionId == null ? null : this.mediaDrm.queryKeyStatus(this.sessionId);
    }

    @Override  // com.google.android.exoplayer2.drm.DrmSession
    public void release() {
        int v = this.referenceCount - 1;
        this.referenceCount = v;
        if(v == 0) {
            this.state = 0;
            this.responseHandler.removeCallbacksAndMessages(null);
            this.requestHandler.removeCallbacksAndMessages(null);
            this.requestHandler = null;
            this.requestHandlerThread.quit();
            this.requestHandlerThread = null;
            this.mediaCrypto = null;
            this.lastException = null;
            this.currentKeyRequest = null;
            this.currentProvisionRequest = null;
            byte[] arr_b = this.sessionId;
            if(arr_b != null) {
                this.mediaDrm.closeSession(arr_b);
                this.sessionId = null;
                b b0 = new b(8);
                this.eventDispatcher.dispatch(b0);
            }
            this.releaseCallback.onSessionReleased(this);
        }
    }

    @RequiresNonNull({"sessionId", "offlineLicenseKeySetId"})
    private boolean restoreKeys() {
        try {
            this.mediaDrm.restoreKeys(this.sessionId, this.offlineLicenseKeySetId);
            return true;
        }
        catch(Exception exception0) {
            Log.e("DefaultDrmSession", "Error trying to restore keys.", exception0);
            this.onError(exception0);
            return false;
        }
    }
}

