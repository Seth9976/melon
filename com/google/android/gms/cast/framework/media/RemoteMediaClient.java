package com.google.android.gms.cast.framework.media;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLoadOptions.Builder;
import com.google.android.gms.cast.MediaLoadOptions;
import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zzar;
import com.google.android.gms.cast.zzr;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.cast.zzet;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import org.json.JSONObject;

public class RemoteMediaClient implements MessageReceivedCallback {
    public static abstract class Callback {
        public void onAdBreakStatusUpdated() {
        }

        public void onMediaError(MediaError mediaError0) {
        }

        public void onMetadataUpdated() {
        }

        public void onPreloadStatusUpdated() {
        }

        public void onQueueStatusUpdated() {
        }

        public void onSendingRemoteMediaRequest() {
        }

        public void onStatusUpdated() {
        }

        public void zza(String s, long v, int v1, long v2, long v3) {
        }

        public void zzb(int[] arr_v) {
        }

        public void zzc(int[] arr_v, int v) {
        }

        public void zzd(MediaQueueItem[] arr_mediaQueueItem) {
        }

        public void zze(int[] arr_v) {
        }

        public void zzf(List list0, List list1, int v) {
        }

        public void zzg(int[] arr_v) {
        }

        public void zzh() {
        }
    }

    @Deprecated
    public interface Listener {
        void onAdBreakStatusUpdated();

        void onMetadataUpdated();

        void onPreloadStatusUpdated();

        void onQueueStatusUpdated();

        void onSendingRemoteMediaRequest();

        void onStatusUpdated();
    }

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();

        MediaError getMediaError();
    }

    public interface ParseAdsInfoCallback {
        List parseAdBreaksFromMediaStatus(MediaStatus arg1);

        boolean parseIsPlayingAdFromMediaStatus(MediaStatus arg1);
    }

    public interface ProgressListener {
        void onProgressUpdated(long arg1, long arg2);
    }

    public static final String NAMESPACE = null;
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED;
    private static final Logger zza;
    private final Object zzb;
    private final Handler zzc;
    private final zzar zzd;
    private final zzbb zze;
    @NotOnlyInitialized
    private final MediaQueue zzf;
    private zzr zzg;
    private TaskCompletionSource zzh;
    private final List zzi;
    private final List zzj;
    private final Map zzk;
    private final Map zzl;
    private ParseAdsInfoCallback zzm;

    static {
        RemoteMediaClient.zza = new Logger("RemoteMediaClient");
        RemoteMediaClient.NAMESPACE = "urn:x-cast:com.google.cast.media";
    }

    public RemoteMediaClient(zzar zzar0) {
        this.zzi = new CopyOnWriteArrayList();
        this.zzj = new CopyOnWriteArrayList();
        this.zzk = new ConcurrentHashMap();
        this.zzl = new ConcurrentHashMap();
        this.zzb = new Object();
        this.zzc = new zzet(Looper.getMainLooper());
        zzbb zzbb0 = new zzbb(this);
        this.zze = zzbb0;
        zzar zzar1 = (zzar)Preconditions.checkNotNull(zzar0);
        this.zzd = zzar1;
        zzar1.zzQ(new zzbi(this, null));
        zzar1.zzh(zzbb0);
        this.zzf = new MediaQueue(this, 20, 20);
    }

    @Deprecated
    public void addListener(Listener remoteMediaClient$Listener0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(remoteMediaClient$Listener0 != null) {
            this.zzi.add(remoteMediaClient$Listener0);
        }
    }

    public boolean addProgressListener(ProgressListener remoteMediaClient$ProgressListener0, long v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(remoteMediaClient$ProgressListener0 != null) {
            Map map0 = this.zzk;
            if(!map0.containsKey(remoteMediaClient$ProgressListener0)) {
                Map map1 = this.zzl;
                Long long0 = v;
                zzbk zzbk0 = (zzbk)map1.get(long0);
                if(zzbk0 == null) {
                    zzbk0 = new zzbk(this, v);
                    map1.put(long0, zzbk0);
                }
                zzbk0.zzd(remoteMediaClient$ProgressListener0);
                map0.put(remoteMediaClient$ProgressListener0, zzbk0);
                if(this.hasMediaSession()) {
                    zzbk0.zzf();
                }
                return true;
            }
        }
        return false;
    }

    public long getApproximateAdBreakClipPositionMs() {
        synchronized(this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
        }
        return this.zzd.zzj();
    }

    public long getApproximateLiveSeekableRangeEnd() {
        synchronized(this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
        }
        return this.zzd.zzk();
    }

    public long getApproximateLiveSeekableRangeStart() {
        synchronized(this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
        }
        return this.zzd.zzl();
    }

    public long getApproximateStreamPosition() {
        synchronized(this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
        }
        return this.zzd.zzm();
    }

    public MediaQueueItem getCurrentItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus0 = this.getMediaStatus();
        return mediaStatus0 == null ? null : mediaStatus0.getQueueItemById(mediaStatus0.getCurrentItemId());
    }

    public int getIdleReason() {
        MediaStatus mediaStatus0;
        synchronized(this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            mediaStatus0 = this.getMediaStatus();
        }
        return mediaStatus0 == null ? 0 : mediaStatus0.getIdleReason();
    }

    public MediaQueueItem getLoadingItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus0 = this.getMediaStatus();
        return mediaStatus0 == null ? null : mediaStatus0.getQueueItemById(mediaStatus0.getLoadingItemId());
    }

    public MediaInfo getMediaInfo() {
        synchronized(this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
        }
        return this.zzd.zzK();
    }

    public MediaQueue getMediaQueue() {
        synchronized(this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            return this.zzf;
        }
    }

    public MediaStatus getMediaStatus() {
        synchronized(this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
        }
        return this.zzd.zzL();
    }

    public String getNamespace() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzd.zze();
    }

    public int getPlayerState() {
        MediaStatus mediaStatus0;
        synchronized(this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            mediaStatus0 = this.getMediaStatus();
        }
        return mediaStatus0 == null ? 1 : mediaStatus0.getPlayerState();
    }

    public MediaQueueItem getPreloadedItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus0 = this.getMediaStatus();
        return mediaStatus0 == null ? null : mediaStatus0.getQueueItemById(mediaStatus0.getPreloadedItemId());
    }

    public long getStreamDuration() {
        synchronized(this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
        }
        return this.zzd.zzo();
    }

    // 去混淆评级： 低(25)
    public boolean hasMediaSession() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.isBuffering() || this.zzv() || this.isPlaying() || this.isPaused() || this.isLoadingNextItem();
    }

    public boolean isBuffering() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus0 = this.getMediaStatus();
        return mediaStatus0 != null && mediaStatus0.getPlayerState() == 4;
    }

    public boolean isLiveStream() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaInfo mediaInfo0 = this.getMediaInfo();
        return mediaInfo0 != null && mediaInfo0.getStreamType() == 2;
    }

    public boolean isLoadingNextItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus0 = this.getMediaStatus();
        return mediaStatus0 != null && mediaStatus0.getLoadingItemId() != 0;
    }

    public boolean isPaused() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus0 = this.getMediaStatus();
        return mediaStatus0 != null && (mediaStatus0.getPlayerState() == 3 || this.isLiveStream() && this.getIdleReason() == 2);
    }

    public boolean isPlaying() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus0 = this.getMediaStatus();
        return mediaStatus0 != null && mediaStatus0.getPlayerState() == 2;
    }

    public boolean isPlayingAd() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus0 = this.getMediaStatus();
        return mediaStatus0 != null && mediaStatus0.isPlayingAd();
    }

    @Deprecated
    public PendingResult load(MediaInfo mediaInfo0) {
        return this.load(mediaInfo0, new Builder().build());
    }

    public PendingResult load(MediaInfo mediaInfo0, MediaLoadOptions mediaLoadOptions0) {
        com.google.android.gms.cast.MediaLoadRequestData.Builder mediaLoadRequestData$Builder0 = new com.google.android.gms.cast.MediaLoadRequestData.Builder();
        mediaLoadRequestData$Builder0.setMediaInfo(mediaInfo0);
        mediaLoadRequestData$Builder0.setAutoplay(Boolean.valueOf(mediaLoadOptions0.getAutoplay()));
        mediaLoadRequestData$Builder0.setCurrentTime(mediaLoadOptions0.getPlayPosition());
        mediaLoadRequestData$Builder0.setPlaybackRate(mediaLoadOptions0.getPlaybackRate());
        mediaLoadRequestData$Builder0.setActiveTrackIds(mediaLoadOptions0.getActiveTrackIds());
        mediaLoadRequestData$Builder0.setCustomData(mediaLoadOptions0.getCustomData());
        mediaLoadRequestData$Builder0.setCredentials(mediaLoadOptions0.getCredentials());
        mediaLoadRequestData$Builder0.setCredentialsType(mediaLoadOptions0.getCredentialsType());
        return this.load(mediaLoadRequestData$Builder0.build());
    }

    @Deprecated
    public PendingResult load(MediaInfo mediaInfo0, boolean z) {
        Builder mediaLoadOptions$Builder0 = new Builder();
        mediaLoadOptions$Builder0.setAutoplay(z);
        return this.load(mediaInfo0, mediaLoadOptions$Builder0.build());
    }

    @Deprecated
    public PendingResult load(MediaInfo mediaInfo0, boolean z, long v) {
        Builder mediaLoadOptions$Builder0 = new Builder();
        mediaLoadOptions$Builder0.setAutoplay(z);
        mediaLoadOptions$Builder0.setPlayPosition(v);
        return this.load(mediaInfo0, mediaLoadOptions$Builder0.build());
    }

    @Deprecated
    public PendingResult load(MediaInfo mediaInfo0, boolean z, long v, JSONObject jSONObject0) {
        Builder mediaLoadOptions$Builder0 = new Builder();
        mediaLoadOptions$Builder0.setAutoplay(z);
        mediaLoadOptions$Builder0.setPlayPosition(v);
        mediaLoadOptions$Builder0.setCustomData(jSONObject0);
        return this.load(mediaInfo0, mediaLoadOptions$Builder0.build());
    }

    @Deprecated
    public PendingResult load(MediaInfo mediaInfo0, boolean z, long v, long[] arr_v, JSONObject jSONObject0) {
        Builder mediaLoadOptions$Builder0 = new Builder();
        mediaLoadOptions$Builder0.setAutoplay(z);
        mediaLoadOptions$Builder0.setPlayPosition(v);
        mediaLoadOptions$Builder0.setActiveTrackIds(arr_v);
        mediaLoadOptions$Builder0.setCustomData(jSONObject0);
        return this.load(mediaInfo0, mediaLoadOptions$Builder0.build());
    }

    public PendingResult load(MediaLoadRequestData mediaLoadRequestData0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new com.google.android.gms.cast.framework.media.zzar(this, mediaLoadRequestData0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    @Override  // com.google.android.gms.cast.Cast$MessageReceivedCallback
    public void onMessageReceived(CastDevice castDevice0, String s, String s1) {
        this.zzd.zzO(s1);
    }

    public PendingResult pause() {
        return this.pause(null);
    }

    public PendingResult pause(JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzat(this, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult play() {
        return this.play(null);
    }

    public PendingResult play(JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzav(this, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult queueAppendItem(MediaQueueItem mediaQueueItem0, JSONObject jSONObject0) {
        return this.queueInsertItems(new MediaQueueItem[]{mediaQueueItem0}, 0, jSONObject0);
    }

    public PendingResult queueInsertAndPlayItem(MediaQueueItem mediaQueueItem0, int v, long v1, JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzad(this, mediaQueueItem0, v, v1, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult queueInsertAndPlayItem(MediaQueueItem mediaQueueItem0, int v, JSONObject jSONObject0) {
        return this.queueInsertAndPlayItem(mediaQueueItem0, v, -1L, jSONObject0);
    }

    public PendingResult queueInsertItems(MediaQueueItem[] arr_mediaQueueItem, int v, JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzac(this, arr_mediaQueueItem, v, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult queueJumpToItem(int v, long v1, JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzam(this, v, v1, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult queueJumpToItem(int v, JSONObject jSONObject0) {
        return this.queueJumpToItem(v, -1L, jSONObject0);
    }

    public PendingResult queueLoad(MediaQueueItem[] arr_mediaQueueItem, int v, int v1, long v2, JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzab(this, arr_mediaQueueItem, v, v1, v2, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult queueLoad(MediaQueueItem[] arr_mediaQueueItem, int v, int v1, JSONObject jSONObject0) {
        return this.queueLoad(arr_mediaQueueItem, v, v1, -1L, jSONObject0);
    }

    public PendingResult queueMoveItemToNewIndex(int v, int v1, JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzan(this, v, v1, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult queueNext(JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzaj(this, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult queuePrev(JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzai(this, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult queueRemoveItem(int v, JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzal(this, v, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult queueRemoveItems(int[] arr_v, JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzaf(this, arr_v, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult queueReorderItems(int[] arr_v, int v, JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzag(this, arr_v, v, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult queueSetRepeatMode(int v, JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzak(this, v, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    @KeepForSdk
    @ShowFirstParty
    public PendingResult queueShuffle(JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzah(this, true, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult queueUpdateItems(MediaQueueItem[] arr_mediaQueueItem, JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzae(this, arr_mediaQueueItem, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public void registerCallback(Callback remoteMediaClient$Callback0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(remoteMediaClient$Callback0 != null) {
            this.zzj.add(remoteMediaClient$Callback0);
        }
    }

    @Deprecated
    public void removeListener(Listener remoteMediaClient$Listener0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(remoteMediaClient$Listener0 != null) {
            this.zzi.remove(remoteMediaClient$Listener0);
        }
    }

    public void removeProgressListener(ProgressListener remoteMediaClient$ProgressListener0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzbk zzbk0 = (zzbk)this.zzk.remove(remoteMediaClient$ProgressListener0);
        if(zzbk0 != null) {
            zzbk0.zze(remoteMediaClient$ProgressListener0);
            if(!zzbk0.zzh()) {
                this.zzl.remove(zzbk0.zzb());
                zzbk0.zzg();
            }
        }
    }

    public PendingResult requestStatus() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzy(this);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    @Deprecated
    public PendingResult seek(long v) {
        return this.seek(v, 0, null);
    }

    @Deprecated
    public PendingResult seek(long v, int v1) {
        return this.seek(v, v1, null);
    }

    @Deprecated
    public PendingResult seek(long v, int v1, JSONObject jSONObject0) {
        com.google.android.gms.cast.MediaSeekOptions.Builder mediaSeekOptions$Builder0 = new com.google.android.gms.cast.MediaSeekOptions.Builder();
        mediaSeekOptions$Builder0.setPosition(v);
        mediaSeekOptions$Builder0.setResumeState(v1);
        mediaSeekOptions$Builder0.setCustomData(jSONObject0);
        return this.seek(mediaSeekOptions$Builder0.build());
    }

    public PendingResult seek(MediaSeekOptions mediaSeekOptions0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzaw(this, mediaSeekOptions0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult setActiveMediaTracks(long[] arr_v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzz(this, arr_v);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public void setParseAdsInfoCallback(ParseAdsInfoCallback remoteMediaClient$ParseAdsInfoCallback0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzm = remoteMediaClient$ParseAdsInfoCallback0;
    }

    public PendingResult setPlaybackRate(double f) {
        return this.setPlaybackRate(f, null);
    }

    public PendingResult setPlaybackRate(double f, JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzaz(this, f, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult setStreamMute(boolean z) {
        return this.setStreamMute(z, null);
    }

    public PendingResult setStreamMute(boolean z, JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzay(this, z, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult setStreamVolume(double f) {
        return this.setStreamVolume(f, null);
    }

    public PendingResult setStreamVolume(double f, JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzax(this, f, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult setTextTrackStyle(TextTrackStyle textTrackStyle0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzaa(this, textTrackStyle0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult skipAd() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzx(this);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public PendingResult stop() {
        return this.stop(null);
    }

    public PendingResult stop(JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzau(this, jSONObject0);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public void togglePlayback() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        switch(this.getPlayerState()) {
            case 2: 
            case 4: {
                this.pause();
                return;
            }
            default: {
                this.play();
            }
        }
    }

    public void unregisterCallback(Callback remoteMediaClient$Callback0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(remoteMediaClient$Callback0 != null) {
            this.zzj.remove(remoteMediaClient$Callback0);
        }
    }

    public final int zza() {
        if(this.getMediaInfo() != null && this.hasMediaSession()) {
            if(this.isBuffering()) {
                return 6;
            }
            if(this.isPlaying()) {
                return 3;
            }
            if(this.isPaused()) {
                return 2;
            }
            if(this.isLoadingNextItem()) {
                MediaQueueItem mediaQueueItem0 = this.getLoadingItem();
                return mediaQueueItem0 == null || mediaQueueItem0.getMedia() == null ? 0 : 6;
            }
        }
        return 0;
    }

    public static PendingResult zzf(int v, String s) {
        PendingResult pendingResult0 = new zzbd();
        ((BasePendingResult)pendingResult0).setResult(new zzbc(((zzbd)pendingResult0), new Status(v, s)));
        return pendingResult0;
    }

    public final PendingResult zzg(String s, List list0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzas(this, true, s, null);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public final PendingResult zzh(int v, int v1, int v2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzaq(this, true, v, v1, v2);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public final PendingResult zzi() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzao(this, true);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public final PendingResult zzj(int[] arr_v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return RemoteMediaClient.zzf(17, null);
        }
        PendingResult pendingResult0 = new zzap(this, true, arr_v);
        RemoteMediaClient.zzz(((zzbg)pendingResult0));
        return pendingResult0;
    }

    public final Task zzk(JSONObject jSONObject0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.zzy()) {
            return Tasks.forException(new com.google.android.gms.cast.internal.zzap());
        }
        this.zzh = new TaskCompletionSource();
        RemoteMediaClient.zza.d("create SessionState with cached mediaInfo and mediaStatus", new Object[0]);
        MediaInfo mediaInfo0 = this.getMediaInfo();
        MediaStatus mediaStatus0 = this.getMediaStatus();
        SessionState sessionState0 = null;
        if(mediaInfo0 != null && mediaStatus0 != null) {
            com.google.android.gms.cast.MediaLoadRequestData.Builder mediaLoadRequestData$Builder0 = new com.google.android.gms.cast.MediaLoadRequestData.Builder();
            mediaLoadRequestData$Builder0.setMediaInfo(mediaInfo0);
            mediaLoadRequestData$Builder0.setCurrentTime(this.getApproximateStreamPosition());
            mediaLoadRequestData$Builder0.setQueueData(mediaStatus0.getQueueData());
            mediaLoadRequestData$Builder0.setPlaybackRate(mediaStatus0.getPlaybackRate());
            mediaLoadRequestData$Builder0.setActiveTrackIds(mediaStatus0.getActiveTrackIds());
            mediaLoadRequestData$Builder0.setCustomData(mediaStatus0.getCustomData());
            MediaLoadRequestData mediaLoadRequestData0 = mediaLoadRequestData$Builder0.build();
            com.google.android.gms.cast.SessionState.Builder sessionState$Builder0 = new com.google.android.gms.cast.SessionState.Builder();
            sessionState$Builder0.setLoadRequestData(mediaLoadRequestData0);
            sessionState0 = sessionState$Builder0.build();
        }
        if(sessionState0 != null) {
            this.zzh.setResult(sessionState0);
            return this.zzh.getTask();
        }
        this.zzh.setException(new com.google.android.gms.cast.internal.zzap());
        return this.zzh.getTask();
    }

    public static void zzo(RemoteMediaClient remoteMediaClient0) {
        for(Object object0: remoteMediaClient0.zzl.values()) {
            zzbk zzbk0 = (zzbk)object0;
            if(remoteMediaClient0.hasMediaSession() && !zzbk0.zzi()) {
                zzbk0.zzf();
            }
            else if(!remoteMediaClient0.hasMediaSession() && zzbk0.zzi()) {
                zzbk0.zzg();
            }
            if(zzbk0.zzi() && (remoteMediaClient0.isBuffering() || remoteMediaClient0.zzv() || remoteMediaClient0.isPaused() || remoteMediaClient0.isLoadingNextItem())) {
                remoteMediaClient0.zzx(zzbk.zzc(zzbk0));
            }
        }
    }

    public final void zzq() {
        zzr zzr0 = this.zzg;
        if(zzr0 == null) {
            return;
        }
        zzr0.zzi(this.getNamespace(), this);
        this.requestStatus();
    }

    public final void zzr(SessionState sessionState0) {
        if(sessionState0 != null) {
            MediaLoadRequestData mediaLoadRequestData0 = sessionState0.getLoadRequestData();
            if(mediaLoadRequestData0 != null) {
                RemoteMediaClient.zza.d("resume SessionState", new Object[0]);
                this.load(mediaLoadRequestData0);
            }
        }
    }

    public final void zzs(zzr zzr0) {
        zzr zzr1 = this.zzg;
        if(zzr1 != zzr0) {
            if(zzr1 != null) {
                this.zzd.zzf();
                this.zzf.zzl();
                zzr1.zzg(this.getNamespace());
                this.zze.zzc(null);
                this.zzc.removeCallbacksAndMessages(null);
            }
            this.zzg = zzr0;
            if(zzr0 != null) {
                this.zze.zzc(zzr0);
            }
        }
    }

    public final boolean zzt() {
        if(!this.hasMediaSession()) {
            return false;
        }
        MediaStatus mediaStatus0 = (MediaStatus)Preconditions.checkNotNull(this.getMediaStatus());
        if(mediaStatus0.isMediaCommandSupported(0x40L)) {
            return true;
        }
        if(mediaStatus0.getQueueRepeatMode() == 0) {
            Integer integer0 = mediaStatus0.getIndexById(mediaStatus0.getCurrentItemId());
            return integer0 != null && ((int)integer0) < mediaStatus0.getQueueItemCount() - 1;
        }
        return true;
    }

    public final boolean zzu() {
        if(!this.hasMediaSession()) {
            return false;
        }
        MediaStatus mediaStatus0 = (MediaStatus)Preconditions.checkNotNull(this.getMediaStatus());
        if(mediaStatus0.isMediaCommandSupported(0x80L)) {
            return true;
        }
        if(mediaStatus0.getQueueRepeatMode() == 0) {
            Integer integer0 = mediaStatus0.getIndexById(mediaStatus0.getCurrentItemId());
            return integer0 != null && ((int)integer0) > 0;
        }
        return true;
    }

    public final boolean zzv() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus0 = this.getMediaStatus();
        return mediaStatus0 != null && mediaStatus0.getPlayerState() == 5;
    }

    public final boolean zzw() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(!this.isLiveStream()) {
            return true;
        }
        MediaStatus mediaStatus0 = this.getMediaStatus();
        return mediaStatus0 == null ? false : mediaStatus0.isMediaCommandSupported(2L) && mediaStatus0.getLiveSeekableRange() != null;
    }

    private final void zzx(Set set0) {
        HashSet hashSet0 = new HashSet(set0);
        if(this.isPlaying() || this.isPaused() || this.isBuffering() || this.zzv()) {
            for(Object object2: hashSet0) {
                ((ProgressListener)object2).onProgressUpdated(this.getApproximateStreamPosition(), this.getStreamDuration());
            }
        }
        else {
            if(!this.isLoadingNextItem()) {
                goto label_13;
            }
            MediaQueueItem mediaQueueItem0 = this.getLoadingItem();
            if(mediaQueueItem0 != null) {
                MediaInfo mediaInfo0 = mediaQueueItem0.getMedia();
                if(mediaInfo0 != null) {
                    for(Object object0: hashSet0) {
                        ((ProgressListener)object0).onProgressUpdated(0L, mediaInfo0.getStreamDuration());
                    }
                    return;
                label_13:
                    for(Object object1: hashSet0) {
                        ((ProgressListener)object1).onProgressUpdated(0L, 0L);
                    }
                }
            }
        }
    }

    private final boolean zzy() {
        return this.zzg != null;
    }

    private static final zzbg zzz(zzbg zzbg0) {
        try {
            zzbg0.zzc();
            return zzbg0;
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            throw illegalArgumentException0;
        }
        catch(Throwable unused_ex) {
            zzbg0.setResult(new zzbf(zzbg0, new Status(2100)));
            return zzbg0;
        }
    }
}

