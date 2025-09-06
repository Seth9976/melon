package com.google.android.gms.cast;

import android.annotation.SuppressLint;
import com.google.android.gms.cast.internal.zzar;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import org.json.JSONObject;

@SuppressLint({"MissingRemoteException"})
@Deprecated
public class RemoteMediaPlayer implements MessageReceivedCallback {
    @Deprecated
    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    @Deprecated
    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    @Deprecated
    public interface OnPreloadStatusUpdatedListener {
        void onPreloadStatusUpdated();
    }

    @Deprecated
    public interface OnQueueStatusUpdatedListener {
        void onQueueStatusUpdated();
    }

    @Deprecated
    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    public static final String NAMESPACE = null;
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private final Object zza;
    private final zzar zzb;
    private final zzdk zzc;
    private OnPreloadStatusUpdatedListener zzd;
    private OnQueueStatusUpdatedListener zze;
    private OnMetadataUpdatedListener zzf;
    private OnStatusUpdatedListener zzg;

    static {
        RemoteMediaPlayer.NAMESPACE = "urn:x-cast:com.google.cast.media";
    }

    public RemoteMediaPlayer() {
        zzar zzar0 = new zzar(null);
        super();
        this.zza = new Object();
        this.zzb = zzar0;
        zzar0.zzQ(new zzcw(this));
        zzdk zzdk0 = new zzdk(this);
        this.zzc = zzdk0;
        zzar0.zzh(zzdk0);
    }

    public long getApproximateStreamPosition() {
        synchronized(this.zza) {
        }
        return this.zzb.zzm();
    }

    public MediaInfo getMediaInfo() {
        synchronized(this.zza) {
        }
        return this.zzb.zzK();
    }

    public MediaStatus getMediaStatus() {
        synchronized(this.zza) {
        }
        return this.zzb.zzL();
    }

    public String getNamespace() {
        return this.zzb.zze();
    }

    public long getStreamDuration() {
        synchronized(this.zza) {
        }
        return this.zzb.zzo();
    }

    public PendingResult load(GoogleApiClient googleApiClient0, MediaInfo mediaInfo0) {
        return this.load(googleApiClient0, mediaInfo0, true, -1L, null, null);
    }

    public PendingResult load(GoogleApiClient googleApiClient0, MediaInfo mediaInfo0, boolean z) {
        return this.load(googleApiClient0, mediaInfo0, z, -1L, null, null);
    }

    public PendingResult load(GoogleApiClient googleApiClient0, MediaInfo mediaInfo0, boolean z, long v) {
        return this.load(googleApiClient0, mediaInfo0, z, v, null, null);
    }

    public PendingResult load(GoogleApiClient googleApiClient0, MediaInfo mediaInfo0, boolean z, long v, JSONObject jSONObject0) {
        return this.load(googleApiClient0, mediaInfo0, z, v, null, jSONObject0);
    }

    public PendingResult load(GoogleApiClient googleApiClient0, MediaInfo mediaInfo0, boolean z, long v, long[] arr_v, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzdb(this, googleApiClient0, mediaInfo0, z, v, arr_v, jSONObject0));
    }

    @Override  // com.google.android.gms.cast.Cast$MessageReceivedCallback
    public void onMessageReceived(CastDevice castDevice0, String s, String s1) {
        this.zzb.zzO(s1);
    }

    public PendingResult pause(GoogleApiClient googleApiClient0) {
        return this.pause(googleApiClient0, null);
    }

    public PendingResult pause(GoogleApiClient googleApiClient0, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzdc(this, googleApiClient0, jSONObject0));
    }

    public PendingResult play(GoogleApiClient googleApiClient0) {
        return this.play(googleApiClient0, null);
    }

    public PendingResult play(GoogleApiClient googleApiClient0, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzde(this, googleApiClient0, jSONObject0));
    }

    public PendingResult queueAppendItem(GoogleApiClient googleApiClient0, MediaQueueItem mediaQueueItem0, JSONObject jSONObject0) {
        return this.queueInsertItems(googleApiClient0, new MediaQueueItem[]{mediaQueueItem0}, 0, jSONObject0);
    }

    public PendingResult queueInsertAndPlayItem(GoogleApiClient googleApiClient0, MediaQueueItem mediaQueueItem0, int v, long v1, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzcq(this, googleApiClient0, mediaQueueItem0, v, v1, jSONObject0));
    }

    public PendingResult queueInsertAndPlayItem(GoogleApiClient googleApiClient0, MediaQueueItem mediaQueueItem0, int v, JSONObject jSONObject0) {
        return this.queueInsertAndPlayItem(googleApiClient0, mediaQueueItem0, v, -1L, jSONObject0);
    }

    public PendingResult queueInsertItems(GoogleApiClient googleApiClient0, MediaQueueItem[] arr_mediaQueueItem, int v, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzcp(this, googleApiClient0, arr_mediaQueueItem, v, jSONObject0));
    }

    public PendingResult queueJumpToItem(GoogleApiClient googleApiClient0, int v, long v1, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzcz(this, googleApiClient0, v, v1, jSONObject0));
    }

    public PendingResult queueJumpToItem(GoogleApiClient googleApiClient0, int v, JSONObject jSONObject0) {
        return this.queueJumpToItem(googleApiClient0, v, -1L, jSONObject0);
    }

    public PendingResult queueLoad(GoogleApiClient googleApiClient0, MediaQueueItem[] arr_mediaQueueItem, int v, int v1, long v2, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzco(this, googleApiClient0, arr_mediaQueueItem, v, v1, v2, jSONObject0));
    }

    public PendingResult queueLoad(GoogleApiClient googleApiClient0, MediaQueueItem[] arr_mediaQueueItem, int v, int v1, JSONObject jSONObject0) {
        return this.queueLoad(googleApiClient0, arr_mediaQueueItem, v, v1, -1L, jSONObject0);
    }

    public PendingResult queueMoveItemToNewIndex(GoogleApiClient googleApiClient0, int v, int v1, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzda(this, googleApiClient0, v, v1, jSONObject0));
    }

    public PendingResult queueNext(GoogleApiClient googleApiClient0, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzcv(this, googleApiClient0, jSONObject0));
    }

    public PendingResult queuePrev(GoogleApiClient googleApiClient0, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzcu(this, googleApiClient0, jSONObject0));
    }

    public PendingResult queueRemoveItem(GoogleApiClient googleApiClient0, int v, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzcy(this, googleApiClient0, v, jSONObject0));
    }

    public PendingResult queueRemoveItems(GoogleApiClient googleApiClient0, int[] arr_v, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzcs(this, googleApiClient0, arr_v, jSONObject0));
    }

    public PendingResult queueReorderItems(GoogleApiClient googleApiClient0, int[] arr_v, int v, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzct(this, googleApiClient0, arr_v, v, jSONObject0));
    }

    public PendingResult queueSetRepeatMode(GoogleApiClient googleApiClient0, int v, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzcx(this, googleApiClient0, v, jSONObject0));
    }

    public PendingResult queueUpdateItems(GoogleApiClient googleApiClient0, MediaQueueItem[] arr_mediaQueueItem, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzcr(this, googleApiClient0, arr_mediaQueueItem, jSONObject0));
    }

    public PendingResult requestStatus(GoogleApiClient googleApiClient0) {
        return googleApiClient0.execute(new zzdi(this, googleApiClient0));
    }

    public PendingResult seek(GoogleApiClient googleApiClient0, long v) {
        return this.seek(googleApiClient0, v, 0, null);
    }

    public PendingResult seek(GoogleApiClient googleApiClient0, long v, int v1) {
        return this.seek(googleApiClient0, v, v1, null);
    }

    public PendingResult seek(GoogleApiClient googleApiClient0, long v, int v1, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzdf(this, googleApiClient0, v, v1, jSONObject0));
    }

    public PendingResult setActiveMediaTracks(GoogleApiClient googleApiClient0, long[] arr_v) {
        return googleApiClient0.execute(new zzcm(this, googleApiClient0, arr_v));
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener remoteMediaPlayer$OnMetadataUpdatedListener0) {
        this.zzf = remoteMediaPlayer$OnMetadataUpdatedListener0;
    }

    public void setOnPreloadStatusUpdatedListener(OnPreloadStatusUpdatedListener remoteMediaPlayer$OnPreloadStatusUpdatedListener0) {
        this.zzd = remoteMediaPlayer$OnPreloadStatusUpdatedListener0;
    }

    public void setOnQueueStatusUpdatedListener(OnQueueStatusUpdatedListener remoteMediaPlayer$OnQueueStatusUpdatedListener0) {
        this.zze = remoteMediaPlayer$OnQueueStatusUpdatedListener0;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener remoteMediaPlayer$OnStatusUpdatedListener0) {
        this.zzg = remoteMediaPlayer$OnStatusUpdatedListener0;
    }

    public PendingResult setStreamMute(GoogleApiClient googleApiClient0, boolean z) {
        return this.setStreamMute(googleApiClient0, z, null);
    }

    public PendingResult setStreamMute(GoogleApiClient googleApiClient0, boolean z, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzdh(this, googleApiClient0, z, jSONObject0));
    }

    public PendingResult setStreamVolume(GoogleApiClient googleApiClient0, double f) {
        return this.setStreamVolume(googleApiClient0, f, null);
    }

    public PendingResult setStreamVolume(GoogleApiClient googleApiClient0, double f, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzdg(this, googleApiClient0, f, jSONObject0));
    }

    public PendingResult setTextTrackStyle(GoogleApiClient googleApiClient0, TextTrackStyle textTrackStyle0) {
        return googleApiClient0.execute(new zzcn(this, googleApiClient0, textTrackStyle0));
    }

    public PendingResult stop(GoogleApiClient googleApiClient0) {
        return this.stop(googleApiClient0, null);
    }

    public PendingResult stop(GoogleApiClient googleApiClient0, JSONObject jSONObject0) {
        return googleApiClient0.execute(new zzdd(this, googleApiClient0, jSONObject0));
    }

    public static int zza(RemoteMediaPlayer remoteMediaPlayer0, int v) {
        MediaStatus mediaStatus0 = remoteMediaPlayer0.getMediaStatus();
        if(mediaStatus0 == null) {
            return -1;
        }
        for(int v1 = 0; v1 < mediaStatus0.getQueueItemCount(); ++v1) {
            MediaQueueItem mediaQueueItem0 = mediaStatus0.getQueueItem(v1);
            if(mediaQueueItem0 != null && mediaQueueItem0.getItemId() == v) {
                return v1;
            }
        }
        return -1;
    }

    public static void zze(RemoteMediaPlayer remoteMediaPlayer0) {
        OnMetadataUpdatedListener remoteMediaPlayer$OnMetadataUpdatedListener0 = remoteMediaPlayer0.zzf;
        if(remoteMediaPlayer$OnMetadataUpdatedListener0 != null) {
            remoteMediaPlayer$OnMetadataUpdatedListener0.onMetadataUpdated();
        }
    }

    public static void zzf(RemoteMediaPlayer remoteMediaPlayer0) {
        OnPreloadStatusUpdatedListener remoteMediaPlayer$OnPreloadStatusUpdatedListener0 = remoteMediaPlayer0.zzd;
        if(remoteMediaPlayer$OnPreloadStatusUpdatedListener0 != null) {
            remoteMediaPlayer$OnPreloadStatusUpdatedListener0.onPreloadStatusUpdated();
        }
    }

    public static void zzg(RemoteMediaPlayer remoteMediaPlayer0) {
        OnQueueStatusUpdatedListener remoteMediaPlayer$OnQueueStatusUpdatedListener0 = remoteMediaPlayer0.zze;
        if(remoteMediaPlayer$OnQueueStatusUpdatedListener0 != null) {
            remoteMediaPlayer$OnQueueStatusUpdatedListener0.onQueueStatusUpdated();
        }
    }

    public static void zzh(RemoteMediaPlayer remoteMediaPlayer0) {
        OnStatusUpdatedListener remoteMediaPlayer$OnStatusUpdatedListener0 = remoteMediaPlayer0.zzg;
        if(remoteMediaPlayer$OnStatusUpdatedListener0 != null) {
            remoteMediaPlayer$OnStatusUpdatedListener0.onStatusUpdated();
        }
    }
}

