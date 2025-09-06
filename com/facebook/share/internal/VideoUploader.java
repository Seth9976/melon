package com.facebook.share.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest.OnProgressCallback;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.WorkQueue.WorkItem;
import com.facebook.internal.WorkQueue;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import k8.Y;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoUploader {
    static class FinishUploadWorkItem extends UploadWorkItemBase {
        static final Set transientErrorCodes;

        static {
            FinishUploadWorkItem.transientErrorCodes = new HashSet() {
                {
                    this.add(1363011);
                }
            };
        }

        public FinishUploadWorkItem(UploadContext videoUploader$UploadContext0, int v) {
            super(videoUploader$UploadContext0, v);
        }

        @Override  // com.facebook.share.internal.VideoUploader$UploadWorkItemBase
        public void enqueueRetry(int v) {
            VideoUploader.enqueueUploadFinish(this.uploadContext, v);
        }

        @Override  // com.facebook.share.internal.VideoUploader$UploadWorkItemBase
        public Bundle getParameters() {
            Bundle bundle0 = new Bundle();
            Bundle bundle1 = this.uploadContext.params;
            if(bundle1 != null) {
                bundle0.putAll(bundle1);
            }
            bundle0.putString("upload_phase", "finish");
            bundle0.putString("upload_session_id", this.uploadContext.sessionId);
            Utility.putNonEmptyString(bundle0, "title", this.uploadContext.title);
            Utility.putNonEmptyString(bundle0, "description", this.uploadContext.description);
            Utility.putNonEmptyString(bundle0, "ref", this.uploadContext.ref);
            return bundle0;
        }

        @Override  // com.facebook.share.internal.VideoUploader$UploadWorkItemBase
        public Set getTransientErrorCodes() {
            return FinishUploadWorkItem.transientErrorCodes;
        }

        @Override  // com.facebook.share.internal.VideoUploader$UploadWorkItemBase
        public void handleError(FacebookException facebookException0) {
            VideoUploader.logError(facebookException0, "Video \'%s\' failed to finish uploading", new Object[]{this.uploadContext.videoId});
            this.endUploadWithFailure(facebookException0);
        }

        @Override  // com.facebook.share.internal.VideoUploader$UploadWorkItemBase
        public void handleSuccess(JSONObject jSONObject0) {
            if(jSONObject0.getBoolean("success")) {
                this.issueResponseOnMainThread(null, this.uploadContext.videoId);
                return;
            }
            this.handleError(new FacebookException("Unexpected error in server response"));
        }
    }

    static class StartUploadWorkItem extends UploadWorkItemBase {
        static final Set transientErrorCodes;

        static {
            StartUploadWorkItem.transientErrorCodes = new HashSet() {
                {
                    this.add(6000);
                }
            };
        }

        public StartUploadWorkItem(UploadContext videoUploader$UploadContext0, int v) {
            super(videoUploader$UploadContext0, v);
        }

        @Override  // com.facebook.share.internal.VideoUploader$UploadWorkItemBase
        public void enqueueRetry(int v) {
            VideoUploader.enqueueUploadStart(this.uploadContext, v);
        }

        @Override  // com.facebook.share.internal.VideoUploader$UploadWorkItemBase
        public Bundle getParameters() {
            Bundle bundle0 = Y.b("upload_phase", "start");
            bundle0.putLong("file_size", this.uploadContext.videoSize);
            return bundle0;
        }

        @Override  // com.facebook.share.internal.VideoUploader$UploadWorkItemBase
        public Set getTransientErrorCodes() {
            return StartUploadWorkItem.transientErrorCodes;
        }

        @Override  // com.facebook.share.internal.VideoUploader$UploadWorkItemBase
        public void handleError(FacebookException facebookException0) {
            VideoUploader.logError(facebookException0, "Error starting video upload", new Object[0]);
            this.endUploadWithFailure(facebookException0);
        }

        @Override  // com.facebook.share.internal.VideoUploader$UploadWorkItemBase
        public void handleSuccess(JSONObject jSONObject0) {
            UploadContext videoUploader$UploadContext0 = this.uploadContext;
            videoUploader$UploadContext0.sessionId = jSONObject0.getString("upload_session_id");
            UploadContext videoUploader$UploadContext1 = this.uploadContext;
            videoUploader$UploadContext1.videoId = jSONObject0.getString("video_id");
            String s = jSONObject0.getString("start_offset");
            String s1 = jSONObject0.getString("end_offset");
            if(this.uploadContext.progressCallback != null) {
                long v = Long.parseLong(s);
                this.uploadContext.progressCallback.onProgress(v, this.uploadContext.videoSize);
            }
            VideoUploader.enqueueUploadChunk(this.uploadContext, s, s1, 0);
        }
    }

    static class TransferChunkWorkItem extends UploadWorkItemBase {
        private String chunkEnd;
        private String chunkStart;
        static final Set transientErrorCodes;

        static {
            TransferChunkWorkItem.transientErrorCodes = new HashSet() {
                {
                    this.add(1363019);
                    this.add(1363021);
                    this.add(1363030);
                    this.add(1363033);
                    this.add(1363041);
                }
            };
        }

        public TransferChunkWorkItem(UploadContext videoUploader$UploadContext0, String s, String s1, int v) {
            super(videoUploader$UploadContext0, v);
            this.chunkStart = s;
            this.chunkEnd = s1;
        }

        @Override  // com.facebook.share.internal.VideoUploader$UploadWorkItemBase
        public void enqueueRetry(int v) {
            VideoUploader.enqueueUploadChunk(this.uploadContext, this.chunkStart, this.chunkEnd, v);
        }

        @Override  // com.facebook.share.internal.VideoUploader$UploadWorkItemBase
        public Bundle getParameters() {
            Bundle bundle0 = Y.b("upload_phase", "transfer");
            bundle0.putString("upload_session_id", this.uploadContext.sessionId);
            bundle0.putString("start_offset", this.chunkStart);
            byte[] arr_b = VideoUploader.getChunk(this.uploadContext, this.chunkStart, this.chunkEnd);
            if(arr_b == null) {
                throw new FacebookException("Error reading video");
            }
            bundle0.putByteArray("video_file_chunk", arr_b);
            return bundle0;
        }

        @Override  // com.facebook.share.internal.VideoUploader$UploadWorkItemBase
        public Set getTransientErrorCodes() {
            return TransferChunkWorkItem.transientErrorCodes;
        }

        @Override  // com.facebook.share.internal.VideoUploader$UploadWorkItemBase
        public void handleError(FacebookException facebookException0) {
            VideoUploader.logError(facebookException0, "Error uploading video \'%s\'", new Object[]{this.uploadContext.videoId});
            this.endUploadWithFailure(facebookException0);
        }

        @Override  // com.facebook.share.internal.VideoUploader$UploadWorkItemBase
        public void handleSuccess(JSONObject jSONObject0) {
            String s = jSONObject0.getString("start_offset");
            String s1 = jSONObject0.getString("end_offset");
            if(this.uploadContext.progressCallback != null) {
                long v = Long.parseLong(s);
                this.uploadContext.progressCallback.onProgress(v, this.uploadContext.videoSize);
            }
            if(Utility.areObjectsEqual(s, s1)) {
                VideoUploader.enqueueUploadFinish(this.uploadContext, 0);
                return;
            }
            VideoUploader.enqueueUploadChunk(this.uploadContext, s, s1, 0);
        }
    }

    static class UploadContext {
        public final AccessToken accessToken;
        public final FacebookCallback callback;
        public String chunkStart;
        public final String description;
        public final String graphNode;
        public boolean isCanceled;
        public Bundle params;
        public final OnProgressCallback progressCallback;
        public final String ref;
        public String sessionId;
        public final String title;
        public String videoId;
        public long videoSize;
        public InputStream videoStream;
        public final Uri videoUri;
        public WorkItem workItem;

        private UploadContext(ShareVideoContent shareVideoContent0, String s, FacebookCallback facebookCallback0, OnProgressCallback graphRequest$OnProgressCallback0) {
            this.chunkStart = "0";
            this.accessToken = AccessToken.getCurrentAccessToken();
            this.videoUri = shareVideoContent0.getVideo().getLocalUrl();
            this.title = shareVideoContent0.getContentTitle();
            this.description = shareVideoContent0.getContentDescription();
            this.ref = shareVideoContent0.getRef();
            this.graphNode = s;
            this.callback = facebookCallback0;
            this.progressCallback = graphRequest$OnProgressCallback0;
            this.params = shareVideoContent0.getVideo().getParameters();
            if(!Utility.isNullOrEmpty(shareVideoContent0.getPeopleIds())) {
                this.params.putString("tags", TextUtils.join(", ", shareVideoContent0.getPeopleIds()));
            }
            if(!Utility.isNullOrEmpty(shareVideoContent0.getPlaceId())) {
                this.params.putString("place", shareVideoContent0.getPlaceId());
            }
            if(!Utility.isNullOrEmpty(shareVideoContent0.getRef())) {
                this.params.putString("ref", shareVideoContent0.getRef());
            }
        }

        public UploadContext(ShareVideoContent shareVideoContent0, String s, FacebookCallback facebookCallback0, OnProgressCallback graphRequest$OnProgressCallback0, com.facebook.share.internal.VideoUploader.1 videoUploader$10) {
            this(shareVideoContent0, s, facebookCallback0, graphRequest$OnProgressCallback0);
        }

        public static void access$100(UploadContext videoUploader$UploadContext0) {
            videoUploader$UploadContext0.initialize();
        }

        private void initialize() {
            try {
                if(Utility.isFileUri(this.videoUri)) {
                    ParcelFileDescriptor parcelFileDescriptor0 = ParcelFileDescriptor.open(new File(this.videoUri.getPath()), 0x10000000);
                    this.videoSize = parcelFileDescriptor0.getStatSize();
                    this.videoStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor0);
                    return;
                }
                if(!Utility.isContentUri(this.videoUri)) {
                    throw new FacebookException("Uri must be a content:// or file:// uri");
                }
                this.videoSize = Utility.getContentSize(this.videoUri);
                this.videoStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(this.videoUri);
                return;
            }
            catch(FileNotFoundException fileNotFoundException0) {
            }
            Utility.closeQuietly(this.videoStream);
            throw fileNotFoundException0;
        }
    }

    static abstract class UploadWorkItemBase implements Runnable {
        protected int completedRetries;
        protected GraphResponse response;
        protected UploadContext uploadContext;

        public UploadWorkItemBase(UploadContext videoUploader$UploadContext0, int v) {
            this.uploadContext = videoUploader$UploadContext0;
            this.completedRetries = v;
        }

        private boolean attemptRetry(int v) {
            if(this.completedRetries < 2 && this.getTransientErrorCodes().contains(v)) {
                int v1 = ((int)Math.pow(3.0, this.completedRetries)) * 5000;
                VideoUploader.getHandler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            UploadWorkItemBase.this.enqueueRetry(UploadWorkItemBase.this.completedRetries + 1);
                        }
                        catch(Throwable throwable0) {
                            CrashShieldHandler.handleThrowable(throwable0, this);
                        }
                    }
                }, ((long)v1));
                return true;
            }
            return false;
        }

        public void endUploadWithFailure(FacebookException facebookException0) {
            this.issueResponseOnMainThread(facebookException0, null);
        }

        public abstract void enqueueRetry(int arg1);

        public void executeGraphRequestSynchronously(Bundle bundle0) {
            GraphResponse graphResponse0 = new GraphRequest(this.uploadContext.accessToken, this.uploadContext.graphNode + "/videos", bundle0, HttpMethod.POST, null).executeAndWait();
            this.response = graphResponse0;
            if(graphResponse0 != null) {
                FacebookRequestError facebookRequestError0 = graphResponse0.getError();
                JSONObject jSONObject0 = this.response.getJSONObject();
                if(facebookRequestError0 == null) {
                    if(jSONObject0 != null) {
                        try {
                            this.handleSuccess(jSONObject0);
                        }
                        catch(JSONException jSONException0) {
                            this.endUploadWithFailure(new FacebookException("Unexpected error in server response", jSONException0));
                        }
                        return;
                    }
                    this.handleError(new FacebookException("Unexpected error in server response"));
                }
                else if(!this.attemptRetry(facebookRequestError0.getSubErrorCode())) {
                    this.handleError(new FacebookGraphResponseException(this.response, "Video upload failed"));
                    return;
                }
                return;
            }
            this.handleError(new FacebookException("Unexpected error in server response"));
        }

        public abstract Bundle getParameters();

        public abstract Set getTransientErrorCodes();

        public abstract void handleError(FacebookException arg1);

        public abstract void handleSuccess(JSONObject arg1);

        public void issueResponseOnMainThread(FacebookException facebookException0, String s) {
            VideoUploader.getHandler().post(new Runnable() {
                @Override
                public void run() {
                    if(CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        VideoUploader.issueResponse(UploadWorkItemBase.this.uploadContext, facebookException0, UploadWorkItemBase.this.response, s);
                    }
                    catch(Throwable throwable0) {
                        CrashShieldHandler.handleThrowable(throwable0, this);
                    }
                }
            });
        }

        @Override
        public void run() {
            if(!CrashShieldHandler.isObjectCrashing(this)) {
                if(!this.uploadContext.isCanceled) {
                    try {
                        try {
                            this.executeGraphRequestSynchronously(this.getParameters());
                        }
                        catch(FacebookException facebookException0) {
                            this.endUploadWithFailure(facebookException0);
                        }
                        catch(Exception exception0) {
                            this.endUploadWithFailure(new FacebookException("Video upload failed", exception0));
                        }
                        return;
                    label_10:
                        this.endUploadWithFailure(null);
                    }
                    catch(Throwable throwable0) {
                        CrashShieldHandler.handleThrowable(throwable0, this);
                    }
                    return;
                }
                goto label_10;
            }
        }
    }

    private static final String ERROR_BAD_SERVER_RESPONSE = "Unexpected error in server response";
    private static final String ERROR_UPLOAD = "Video upload failed";
    private static final int MAX_RETRIES_PER_PHASE = 2;
    private static final String PARAM_DESCRIPTION = "description";
    private static final String PARAM_END_OFFSET = "end_offset";
    private static final String PARAM_FILE_SIZE = "file_size";
    private static final String PARAM_REF = "ref";
    private static final String PARAM_SESSION_ID = "upload_session_id";
    private static final String PARAM_START_OFFSET = "start_offset";
    private static final String PARAM_TITLE = "title";
    private static final String PARAM_UPLOAD_PHASE = "upload_phase";
    private static final String PARAM_VALUE_UPLOAD_FINISH_PHASE = "finish";
    private static final String PARAM_VALUE_UPLOAD_START_PHASE = "start";
    private static final String PARAM_VALUE_UPLOAD_TRANSFER_PHASE = "transfer";
    private static final String PARAM_VIDEO_FILE_CHUNK = "video_file_chunk";
    private static final String PARAM_VIDEO_ID = "video_id";
    private static final int RETRY_DELAY_BACK_OFF_FACTOR = 3;
    private static final int RETRY_DELAY_UNIT_MS = 5000;
    private static final String TAG = "VideoUploader";
    private static final int UPLOAD_QUEUE_MAX_CONCURRENT = 8;
    private static AccessTokenTracker accessTokenTracker;
    private static Handler handler;
    private static boolean initialized;
    private static Set pendingUploads;
    private static WorkQueue uploadQueue;

    static {
        VideoUploader.uploadQueue = new WorkQueue(8);
        VideoUploader.pendingUploads = new HashSet();
    }

    private static void cancelAllRequests() {
        synchronized(VideoUploader.class) {
            for(Object object0: VideoUploader.pendingUploads) {
                ((UploadContext)object0).isCanceled = true;
            }
        }
    }

    private static void enqueueRequest(UploadContext videoUploader$UploadContext0, Runnable runnable0) {
        synchronized(VideoUploader.class) {
            videoUploader$UploadContext0.workItem = VideoUploader.uploadQueue.addActiveWorkItem(runnable0);
        }
    }

    private static void enqueueUploadChunk(UploadContext videoUploader$UploadContext0, String s, String s1, int v) {
        VideoUploader.enqueueRequest(videoUploader$UploadContext0, new TransferChunkWorkItem(videoUploader$UploadContext0, s, s1, v));
    }

    private static void enqueueUploadFinish(UploadContext videoUploader$UploadContext0, int v) {
        VideoUploader.enqueueRequest(videoUploader$UploadContext0, new FinishUploadWorkItem(videoUploader$UploadContext0, v));
    }

    private static void enqueueUploadStart(UploadContext videoUploader$UploadContext0, int v) {
        VideoUploader.enqueueRequest(videoUploader$UploadContext0, new StartUploadWorkItem(videoUploader$UploadContext0, v));
    }

    private static byte[] getChunk(UploadContext videoUploader$UploadContext0, String s, String s1) {
        if(!Utility.areObjectsEqual(s, videoUploader$UploadContext0.chunkStart)) {
            VideoUploader.logError(null, "Error reading video chunk. Expected chunk \'%s\'. Requested chunk \'%s\'.", new Object[]{videoUploader$UploadContext0.chunkStart, s});
            return null;
        }
        long v = Long.parseLong(s);
        int v1 = (int)(Long.parseLong(s1) - v);
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        byte[] arr_b = new byte[Math.min(0x2000, v1)];
        int v2;
        while((v2 = videoUploader$UploadContext0.videoStream.read(arr_b)) != -1) {
            byteArrayOutputStream0.write(arr_b, 0, v2);
            v1 -= v2;
            if(v1 == 0) {
                break;
            }
            if(v1 < 0) {
                VideoUploader.logError(null, "Error reading video chunk. Expected buffer length - \'%d\'. Actual - \'%d\'.", new Object[]{((int)(v1 + v2)), v2});
                return null;
            }
        }
        videoUploader$UploadContext0.chunkStart = s1;
        return byteArrayOutputStream0.toByteArray();
    }

    private static Handler getHandler() {
        synchronized(VideoUploader.class) {
            if(VideoUploader.handler == null) {
                VideoUploader.handler = new Handler(Looper.getMainLooper());
            }
            return VideoUploader.handler;
        }
    }

    private static void issueResponse(UploadContext videoUploader$UploadContext0, FacebookException facebookException0, GraphResponse graphResponse0, String s) {
        VideoUploader.removePendingUpload(videoUploader$UploadContext0);
        Utility.closeQuietly(videoUploader$UploadContext0.videoStream);
        FacebookCallback facebookCallback0 = videoUploader$UploadContext0.callback;
        if(facebookCallback0 != null) {
            if(facebookException0 != null) {
                ShareInternalUtility.invokeOnErrorCallback(facebookCallback0, facebookException0);
            }
            else if(videoUploader$UploadContext0.isCanceled) {
                ShareInternalUtility.invokeOnCancelCallback(facebookCallback0);
            }
            else {
                ShareInternalUtility.invokeOnSuccessCallback(facebookCallback0, s);
            }
        }
        if(videoUploader$UploadContext0.progressCallback != null) {
            if(graphResponse0 != null) {
                try {
                    if(graphResponse0.getJSONObject() != null) {
                        graphResponse0.getJSONObject().put("video_id", s);
                    }
                }
                catch(JSONException unused_ex) {
                }
            }
            videoUploader$UploadContext0.progressCallback.onCompleted(graphResponse0);
        }
    }

    private static void logError(Exception exception0, String s, Object[] arr_object) {
        Log.e("VideoUploader", String.format(Locale.ROOT, s, arr_object), exception0);
    }

    private static void registerAccessTokenTracker() {
        VideoUploader.accessTokenTracker = new AccessTokenTracker() {
            @Override  // com.facebook.AccessTokenTracker
            public void onCurrentAccessTokenChanged(AccessToken accessToken0, AccessToken accessToken1) {
                if(accessToken0 == null || accessToken1 != null && Utility.areObjectsEqual(accessToken1.getUserId(), accessToken0.getUserId())) {
                    return;
                }
                VideoUploader.cancelAllRequests();
            }
        };
    }

    private static void removePendingUpload(UploadContext videoUploader$UploadContext0) {
        synchronized(VideoUploader.class) {
            VideoUploader.pendingUploads.remove(videoUploader$UploadContext0);
        }
    }

    public static void uploadAsync(ShareVideoContent shareVideoContent0, String s, FacebookCallback facebookCallback0) {
        synchronized(VideoUploader.class) {
            VideoUploader.uploadAsync(shareVideoContent0, s, facebookCallback0, null);
        }
    }

    private static void uploadAsync(ShareVideoContent shareVideoContent0, String s, FacebookCallback facebookCallback0, OnProgressCallback graphRequest$OnProgressCallback0) {
        synchronized(VideoUploader.class) {
            if(!VideoUploader.initialized) {
                VideoUploader.registerAccessTokenTracker();
                VideoUploader.initialized = true;
            }
            Validate.notNull(shareVideoContent0, "videoContent");
            Validate.notNull(s, "graphNode");
            ShareVideo shareVideo0 = shareVideoContent0.getVideo();
            Validate.notNull(shareVideo0, "videoContent.video");
            Validate.notNull(shareVideo0.getLocalUrl(), "videoContent.video.localUrl");
            UploadContext videoUploader$UploadContext0 = new UploadContext(shareVideoContent0, s, facebookCallback0, graphRequest$OnProgressCallback0, null);
            UploadContext.access$100(videoUploader$UploadContext0);
            VideoUploader.pendingUploads.add(videoUploader$UploadContext0);
            VideoUploader.enqueueUploadStart(videoUploader$UploadContext0, 0);
        }
    }

    public static void uploadAsyncWithProgressCallback(ShareVideoContent shareVideoContent0, OnProgressCallback graphRequest$OnProgressCallback0) {
        synchronized(VideoUploader.class) {
            VideoUploader.uploadAsync(shareVideoContent0, "me", null, graphRequest$OnProgressCallback0);
        }
    }

    public static void uploadAsyncWithProgressCallback(ShareVideoContent shareVideoContent0, String s, OnProgressCallback graphRequest$OnProgressCallback0) {
        synchronized(VideoUploader.class) {
            VideoUploader.uploadAsync(shareVideoContent0, s, null, graphRequest$OnProgressCallback0);
        }
    }
}

