package com.google.android.gms.cast;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.media.MediaCommon;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.JsonUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "MediaStatusCreator")
@Reserved({1})
public class MediaStatus extends AbstractSafeParcelable {
    @KeepForSdk
    public static class Builder {
        private MediaInfo zza;
        private long zzb;
        private int zzc;
        private double zzd;
        private int zze;
        private int zzf;
        private long zzg;
        private long zzh;
        private double zzi;
        private boolean zzj;
        private long[] zzk;
        private int zzl;
        private int zzm;
        private JSONObject zzn;
        private int zzo;
        private final List zzp;
        private boolean zzq;
        private AdBreakStatus zzr;
        private VideoInfo zzs;
        private MediaLiveSeekableRange zzt;
        private MediaQueueData zzu;

        public Builder() {
            this.zzc = 0;
            this.zze = 0;
            this.zzf = 0;
            this.zzl = 0;
            this.zzm = 0;
            this.zzo = 0;
            this.zzp = new ArrayList();
        }

        @KeepForSdk
        public MediaStatus build() {
            MediaStatus mediaStatus0 = new MediaStatus(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, null, this.zzo, this.zzp, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu);
            mediaStatus0.zzo = this.zzn;
            return mediaStatus0;
        }

        @KeepForSdk
        public Builder setActiveTrackIds(long[] arr_v) {
            this.zzk = arr_v;
            return this;
        }

        @KeepForSdk
        public Builder setAdBreakStatus(AdBreakStatus adBreakStatus0) {
            this.zzr = adBreakStatus0;
            return this;
        }

        @KeepForSdk
        public Builder setCurrentItemId(int v) {
            this.zzc = v;
            return this;
        }

        @KeepForSdk
        public Builder setCustomData(JSONObject jSONObject0) {
            this.zzn = jSONObject0;
            return this;
        }

        @KeepForSdk
        public Builder setIdleReason(int v) {
            this.zzf = v;
            return this;
        }

        @KeepForSdk
        public Builder setIsMute(boolean z) {
            this.zzj = z;
            return this;
        }

        @KeepForSdk
        public Builder setIsPlayingAd(boolean z) {
            this.zzq = z;
            return this;
        }

        @KeepForSdk
        public Builder setLiveSeekableRange(MediaLiveSeekableRange mediaLiveSeekableRange0) {
            this.zzt = mediaLiveSeekableRange0;
            return this;
        }

        @KeepForSdk
        public Builder setLoadingItemId(int v) {
            this.zzl = v;
            return this;
        }

        @KeepForSdk
        public Builder setMediaInfo(MediaInfo mediaInfo0) {
            this.zza = mediaInfo0;
            return this;
        }

        @KeepForSdk
        public Builder setMediaSessionId(long v) {
            this.zzb = v;
            return this;
        }

        @KeepForSdk
        public Builder setPlaybackRate(double f) {
            this.zzd = f;
            return this;
        }

        @KeepForSdk
        public Builder setPlayerState(int v) {
            this.zze = v;
            return this;
        }

        @KeepForSdk
        public Builder setPreloadedItemId(int v) {
            this.zzm = v;
            return this;
        }

        @KeepForSdk
        public Builder setQueueData(MediaQueueData mediaQueueData0) {
            this.zzu = mediaQueueData0;
            return this;
        }

        @KeepForSdk
        public Builder setQueueItems(List list0) {
            this.zzp.clear();
            this.zzp.addAll(list0);
            return this;
        }

        @KeepForSdk
        public Builder setQueueRepeatMode(int v) {
            this.zzo = v;
            return this;
        }

        @KeepForSdk
        public Builder setStreamPosition(long v) {
            this.zzg = v;
            return this;
        }

        @KeepForSdk
        public Builder setStreamVolume(double f) {
            this.zzi = f;
            return this;
        }

        @KeepForSdk
        public Builder setSupportedMediaCommands(long v) {
            this.zzh = v;
            return this;
        }

        @KeepForSdk
        public Builder setVideoInfo(VideoInfo videoInfo0) {
            this.zzs = videoInfo0;
            return this;
        }
    }

    @KeepForSdk
    public class Writer {
        final MediaStatus zza;

        @KeepForSdk
        public void setActiveTrackIds(long[] arr_v) {
            MediaStatus.this.zzk = arr_v;
        }

        @KeepForSdk
        public void setAdBreakStatus(AdBreakStatus adBreakStatus0) {
            MediaStatus.this.zzs = adBreakStatus0;
        }

        @KeepForSdk
        public void setCurrentItemId(int v) {
            MediaStatus.this.zzc = v;
        }

        @KeepForSdk
        public void setCustomData(JSONObject jSONObject0) {
            MediaStatus.this.zzo = jSONObject0;
            MediaStatus.this.zzn = null;
        }

        @KeepForSdk
        public void setIdleReason(int v) {
            MediaStatus.this.zzf = v;
        }

        @KeepForSdk
        public void setIsPlayingAd(boolean z) {
            MediaStatus.this.zzr = z;
        }

        @KeepForSdk
        public void setLiveSeekableRange(MediaLiveSeekableRange mediaLiveSeekableRange0) {
            MediaStatus.this.zzu = mediaLiveSeekableRange0;
        }

        @KeepForSdk
        public void setLoadingItemId(int v) {
            MediaStatus.this.zzl = v;
        }

        @KeepForSdk
        public void setMediaInfo(MediaInfo mediaInfo0) {
            MediaStatus.this.zza = mediaInfo0;
        }

        @KeepForSdk
        public void setMute(boolean z) {
            MediaStatus.this.zzj = z;
        }

        @KeepForSdk
        public void setPlaybackRate(double f) {
            MediaStatus.this.zzd = f;
        }

        @KeepForSdk
        public void setPlayerState(int v) {
            MediaStatus.this.zze = v;
        }

        @KeepForSdk
        public void setPreloadedItemId(int v) {
            MediaStatus.this.zzm = v;
        }

        @KeepForSdk
        public void setQueueData(MediaQueueData mediaQueueData0) {
            MediaStatus.this.zzv = mediaQueueData0;
        }

        @KeepForSdk
        public void setQueueItems(List list0) {
            MediaStatus.this.zze(list0);
        }

        @KeepForSdk
        public void setQueueRepeatMode(int v) {
            MediaStatus.this.zzp = v;
        }

        @KeepForSdk
        public void setShuffle(boolean z) {
            MediaStatus.this.zzw = z;
        }

        @KeepForSdk
        public void setStreamPosition(long v) {
            MediaStatus.this.zzg = v;
        }

        @KeepForSdk
        public void setStreamVolume(double f) {
            MediaStatus.this.zzi = f;
        }

        @KeepForSdk
        public void setSupportedMediaCommands(long v) {
            MediaStatus.this.zzh = v;
        }

        @KeepForSdk
        public void setVideoInfo(VideoInfo videoInfo0) {
            MediaStatus.this.zzt = videoInfo0;
        }
    }

    public static final long COMMAND_DISLIKE = 0x8000L;
    public static final long COMMAND_EDIT_TRACKS = 0x1000L;
    public static final long COMMAND_FOLLOW = 0x10000L;
    public static final long COMMAND_LIKE = 0x4000L;
    public static final long COMMAND_PAUSE = 1L;
    public static final long COMMAND_PLAYBACK_RATE = 0x2000L;
    public static final long COMMAND_QUEUE_NEXT = 0x40L;
    public static final long COMMAND_QUEUE_PREVIOUS = 0x80L;
    public static final long COMMAND_QUEUE_REPEAT = 0xC00L;
    public static final long COMMAND_QUEUE_REPEAT_ALL = 0x400L;
    public static final long COMMAND_QUEUE_REPEAT_ONE = 0x800L;
    public static final long COMMAND_QUEUE_SHUFFLE = 0x100L;
    public static final long COMMAND_SEEK = 2L;
    public static final long COMMAND_SET_VOLUME = 4L;
    public static final long COMMAND_SKIP_AD = 0x200L;
    @Deprecated
    public static final long COMMAND_SKIP_BACKWARD = 0x20L;
    @Deprecated
    public static final long COMMAND_SKIP_FORWARD = 16L;
    @KeepForSdk
    @ShowFirstParty
    public static final long COMMAND_STREAM_TRANSFER = 0x40000L;
    public static final long COMMAND_TOGGLE_MUTE = 8L;
    public static final long COMMAND_UNFOLLOW = 0x20000L;
    @KeepForSdk
    public static final Parcelable.Creator CREATOR = null;
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_LOADING = 5;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    public static final int REPEAT_MODE_REPEAT_ALL = 1;
    public static final int REPEAT_MODE_REPEAT_ALL_AND_SHUFFLE = 3;
    public static final int REPEAT_MODE_REPEAT_OFF = 0;
    public static final int REPEAT_MODE_REPEAT_SINGLE = 2;
    @Field(getter = "getMediaInfo", id = 2)
    MediaInfo zza;
    @Field(getter = "getMediaSessionId", id = 3)
    long zzb;
    @Field(getter = "getCurrentItemId", id = 4)
    int zzc;
    @Field(getter = "getPlaybackRate", id = 5)
    double zzd;
    @Field(getter = "getPlayerState", id = 6)
    int zze;
    @Field(getter = "getIdleReason", id = 7)
    int zzf;
    @Field(getter = "getStreamPosition", id = 8)
    long zzg;
    @Field(id = 9)
    long zzh;
    @Field(getter = "getStreamVolume", id = 10)
    double zzi;
    @Field(getter = "isMute", id = 11)
    boolean zzj;
    @Field(getter = "getActiveTrackIds", id = 12)
    long[] zzk;
    @Field(getter = "getLoadingItemId", id = 13)
    int zzl;
    @Field(getter = "getPreloadedItemId", id = 14)
    int zzm;
    @Field(id = 15)
    String zzn;
    JSONObject zzo;
    @Field(id = 16)
    int zzp;
    @Field(id = 17)
    final List zzq;
    @Field(getter = "isPlayingAd", id = 18)
    boolean zzr;
    @Field(getter = "getAdBreakStatus", id = 19)
    AdBreakStatus zzs;
    @Field(getter = "getVideoInfo", id = 20)
    VideoInfo zzt;
    @Field(getter = "getLiveSeekableRange", id = 21)
    MediaLiveSeekableRange zzu;
    @Field(getter = "getQueueData", id = 22)
    MediaQueueData zzv;
    boolean zzw;
    private static final Logger zzx;
    private final SparseArray zzy;
    private final Writer zzz;

    static {
        MediaStatus.zzx = new Logger("MediaStatus");
        MediaStatus.CREATOR = new zzck();
    }

    @SuppressLint({"NonSdkVisibleApi"})
    @Constructor
    public MediaStatus(@Param(id = 2) MediaInfo mediaInfo0, @Param(id = 3) long v, @Param(id = 4) int v1, @Param(id = 5) double f, @Param(id = 6) int v2, @Param(id = 7) int v3, @Param(id = 8) long v4, @Param(id = 9) long v5, @Param(id = 10) double f1, @Param(id = 11) boolean z, @Param(id = 12) long[] arr_v, @Param(id = 13) int v6, @Param(id = 14) int v7, @Param(id = 15) String s, @Param(id = 16) int v8, @Param(id = 17) List list0, @Param(id = 18) boolean z1, @Param(id = 19) AdBreakStatus adBreakStatus0, @Param(id = 20) VideoInfo videoInfo0, @Param(id = 21) MediaLiveSeekableRange mediaLiveSeekableRange0, @Param(id = 22) MediaQueueData mediaQueueData0) {
        this.zzq = new ArrayList();
        this.zzy = new SparseArray();
        this.zzz = new Writer(this);
        this.zza = mediaInfo0;
        this.zzb = v;
        this.zzc = v1;
        this.zzd = f;
        this.zze = v2;
        this.zzf = v3;
        this.zzg = v4;
        this.zzh = v5;
        this.zzi = f1;
        this.zzj = z;
        this.zzk = arr_v;
        this.zzl = v6;
        this.zzm = v7;
        this.zzn = s;
        if(s == null) {
            this.zzo = null;
        }
        else {
            try {
                this.zzo = new JSONObject(this.zzn);
            }
            catch(JSONException unused_ex) {
                this.zzo = null;
                this.zzn = null;
            }
        }
        this.zzp = v8;
        if(list0 != null && !list0.isEmpty()) {
            this.zze(list0);
        }
        this.zzr = z1;
        this.zzs = adBreakStatus0;
        this.zzt = videoInfo0;
        this.zzu = mediaLiveSeekableRange0;
        this.zzv = mediaQueueData0;
        this.zzw = mediaQueueData0 != null && mediaQueueData0.zzk();
    }

    @KeepForSdk
    public MediaStatus(JSONObject jSONObject0) {
        this(null, 0L, 0, 0.0, 0, 0, 0L, 0L, 0.0, false, null, 0, 0, null, 0, null, false, null, null, null, null);
        this.zza(jSONObject0, 0);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof MediaStatus)) {
            return false;
        }
        MediaStatus mediaStatus0 = (MediaStatus)object0;
        return (this.zzo == null ? 1 : 0) == (mediaStatus0.zzo == null ? 1 : 0) ? this.zzb == mediaStatus0.zzb && this.zzc == mediaStatus0.zzc && this.zzd == mediaStatus0.zzd && this.zze == mediaStatus0.zze && this.zzf == mediaStatus0.zzf && this.zzg == mediaStatus0.zzg && this.zzi == mediaStatus0.zzi && this.zzj == mediaStatus0.zzj && this.zzl == mediaStatus0.zzl && this.zzm == mediaStatus0.zzm && this.zzp == mediaStatus0.zzp && Arrays.equals(this.zzk, mediaStatus0.zzk) && CastUtils.zze(this.zzh, mediaStatus0.zzh) && CastUtils.zze(this.zzq, mediaStatus0.zzq) && CastUtils.zze(this.zza, mediaStatus0.zza) && ((this.zzo == null || (mediaStatus0.zzo == null || JsonUtils.areJsonValuesEquivalent(this.zzo, mediaStatus0.zzo))) && (this.zzr == mediaStatus0.isPlayingAd() && CastUtils.zze(this.zzs, mediaStatus0.zzs) && CastUtils.zze(this.zzt, mediaStatus0.zzt) && CastUtils.zze(this.zzu, mediaStatus0.zzu) && Objects.equal(this.zzv, mediaStatus0.zzv) && this.zzw == mediaStatus0.zzw)) : false;
    }

    public long[] getActiveTrackIds() {
        return this.zzk;
    }

    public AdBreakStatus getAdBreakStatus() {
        return this.zzs;
    }

    public AdBreakInfo getCurrentAdBreak() {
        AdBreakStatus adBreakStatus0 = this.zzs;
        if(adBreakStatus0 == null) {
            return null;
        }
        String s = adBreakStatus0.getBreakId();
        if(TextUtils.isEmpty(s)) {
            return null;
        }
        MediaInfo mediaInfo0 = this.zza;
        if(mediaInfo0 == null) {
            return null;
        }
        List list0 = mediaInfo0.getAdBreaks();
        if(list0 != null && !list0.isEmpty()) {
            for(Object object0: list0) {
                AdBreakInfo adBreakInfo0 = (AdBreakInfo)object0;
                if(s.equals(adBreakInfo0.getId())) {
                    return adBreakInfo0;
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    public AdBreakClipInfo getCurrentAdBreakClip() {
        AdBreakStatus adBreakStatus0 = this.zzs;
        if(adBreakStatus0 == null) {
            return null;
        }
        String s = adBreakStatus0.getBreakClipId();
        if(TextUtils.isEmpty(s)) {
            return null;
        }
        MediaInfo mediaInfo0 = this.zza;
        if(mediaInfo0 == null) {
            return null;
        }
        List list0 = mediaInfo0.getAdBreakClips();
        if(list0 != null && !list0.isEmpty()) {
            for(Object object0: list0) {
                AdBreakClipInfo adBreakClipInfo0 = (AdBreakClipInfo)object0;
                if(s.equals(adBreakClipInfo0.getId())) {
                    return adBreakClipInfo0;
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    public int getCurrentItemId() {
        return this.zzc;
    }

    public JSONObject getCustomData() {
        return this.zzo;
    }

    public int getIdleReason() {
        return this.zzf;
    }

    public Integer getIndexById(int v) {
        return (Integer)this.zzy.get(v);
    }

    public MediaQueueItem getItemById(int v) {
        Integer integer0 = (Integer)this.zzy.get(v);
        return integer0 == null ? null : ((MediaQueueItem)this.zzq.get(((int)integer0)));
    }

    public MediaQueueItem getItemByIndex(int v) {
        if(v >= 0) {
            return v >= this.zzq.size() ? null : ((MediaQueueItem)this.zzq.get(v));
        }
        return null;
    }

    public MediaLiveSeekableRange getLiveSeekableRange() {
        return this.zzu;
    }

    public int getLoadingItemId() {
        return this.zzl;
    }

    public MediaInfo getMediaInfo() {
        return this.zza;
    }

    public double getPlaybackRate() {
        return this.zzd;
    }

    public int getPlayerState() {
        return this.zze;
    }

    public int getPreloadedItemId() {
        return this.zzm;
    }

    public MediaQueueData getQueueData() {
        return this.zzv;
    }

    public MediaQueueItem getQueueItem(int v) {
        return this.getItemByIndex(v);
    }

    public MediaQueueItem getQueueItemById(int v) {
        return this.getItemById(v);
    }

    public int getQueueItemCount() {
        return this.zzq.size();
    }

    public List getQueueItems() {
        return this.zzq;
    }

    public int getQueueRepeatMode() {
        return this.zzp;
    }

    public long getStreamPosition() {
        return this.zzg;
    }

    public double getStreamVolume() {
        return this.zzi;
    }

    @KeepForSdk
    public long getSupportedMediaCommands() {
        return this.zzh;
    }

    public VideoInfo getVideoInfo() {
        return this.zzt;
    }

    @KeepForSdk
    public Writer getWriter() {
        return this.zzz;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, Boolean.valueOf(this.zzj), Arrays.hashCode(this.zzk), this.zzl, this.zzm, String.valueOf(this.zzo), this.zzp, this.zzq, Boolean.valueOf(this.zzr), this.zzs, this.zzt, this.zzu, this.zzv});
    }

    public boolean isMediaCommandSupported(long v) {
        return (v & this.zzh) != 0L;
    }

    public boolean isMute() {
        return this.zzj;
    }

    public boolean isPlayingAd() {
        return this.zzr;
    }

    @KeepForSdk
    public JSONObject toJson() {
        String s1;
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("mediaSessionId", this.zzb);
            int v = this.zze;
            String s = "IDLE";
            switch(v) {
                case 1: {
                    break;
                }
                case 2: {
                    s = "PLAYING";
                    break;
                }
                case 3: {
                    s = "PAUSED";
                    break;
                }
                case 4: {
                    s = "BUFFERING";
                    break;
                }
                default: {
                    if(v == 5) {
                        s = "LOADING";
                    }
                }
            }
            jSONObject0.put("playerState", s);
            JSONArray jSONArray0 = null;
            if(this.zze == 1) {
                switch(this.zzf) {
                    case 1: {
                        s1 = "FINISHED";
                        break;
                    }
                    case 2: {
                        s1 = "CANCELLED";
                        break;
                    }
                    case 3: {
                        s1 = "INTERRUPTED";
                        break;
                    }
                    case 4: {
                        s1 = "ERROR";
                        break;
                    }
                    default: {
                        s1 = null;
                    }
                }
                jSONObject0.putOpt("idleReason", s1);
            }
            jSONObject0.put("playbackRate", this.zzd);
            jSONObject0.put("currentTime", ((double)this.zzg) / 1000.0);
            jSONObject0.put("supportedMediaCommands", this.zzh);
            JSONObject jSONObject1 = new JSONObject();
            jSONObject1.put("level", this.zzi);
            jSONObject1.put("muted", this.zzj);
            jSONObject0.put("volume", jSONObject1);
            if(this.zzk != null) {
                jSONArray0 = new JSONArray();
                long[] arr_v = this.zzk;
                for(int v1 = 0; v1 < arr_v.length; ++v1) {
                    jSONArray0.put(arr_v[v1]);
                }
            }
            jSONObject0.putOpt("activeTrackIds", jSONArray0);
            jSONObject0.putOpt("customData", this.zzo);
            jSONObject0.putOpt("shuffle", Boolean.valueOf(this.zzw));
            MediaInfo mediaInfo0 = this.zza;
            if(mediaInfo0 != null) {
                jSONObject0.putOpt("media", mediaInfo0.zza());
            }
            int v2 = this.zzc;
            if(v2 != 0) {
                jSONObject0.put("currentItemId", v2);
            }
            int v3 = this.zzm;
            if(v3 != 0) {
                jSONObject0.put("preloadedItemId", v3);
            }
            int v4 = this.zzl;
            if(v4 != 0) {
                jSONObject0.put("loadingItemId", v4);
            }
            AdBreakStatus adBreakStatus0 = this.zzs;
            if(adBreakStatus0 != null) {
                jSONObject0.putOpt("breakStatus", adBreakStatus0.zzb());
            }
            VideoInfo videoInfo0 = this.zzt;
            if(videoInfo0 != null) {
                jSONObject0.putOpt("videoInfo", videoInfo0.zzb());
            }
            MediaQueueData mediaQueueData0 = this.zzv;
            if(mediaQueueData0 != null) {
                jSONObject0.putOpt("queueData", mediaQueueData0.zza());
            }
            MediaLiveSeekableRange mediaLiveSeekableRange0 = this.zzu;
            if(mediaLiveSeekableRange0 != null) {
                jSONObject0.putOpt("liveSeekableRange", mediaLiveSeekableRange0.zzb());
            }
            jSONObject0.putOpt("repeatMode", MediaCommon.zza(this.zzp));
            List list0 = this.zzq;
            if(list0 != null && !list0.isEmpty()) {
                JSONArray jSONArray1 = new JSONArray();
                for(Object object0: list0) {
                    jSONArray1.put(((MediaQueueItem)object0).toJson());
                }
                jSONObject0.put("items", jSONArray1);
            }
            return jSONObject0;
        }
        catch(JSONException jSONException0) {
        }
        MediaStatus.zzx.e(jSONException0, "Error transforming MediaStatus into JSONObject", new Object[0]);
        return new JSONObject();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        this.zzn = this.zzo == null ? null : this.zzo.toString();
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.getMediaInfo(), v, false);
        SafeParcelWriter.writeLong(parcel0, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel0, 4, this.getCurrentItemId());
        SafeParcelWriter.writeDouble(parcel0, 5, this.getPlaybackRate());
        SafeParcelWriter.writeInt(parcel0, 6, this.getPlayerState());
        SafeParcelWriter.writeInt(parcel0, 7, this.getIdleReason());
        SafeParcelWriter.writeLong(parcel0, 8, this.getStreamPosition());
        SafeParcelWriter.writeLong(parcel0, 9, this.zzh);
        SafeParcelWriter.writeDouble(parcel0, 10, this.getStreamVolume());
        SafeParcelWriter.writeBoolean(parcel0, 11, this.isMute());
        SafeParcelWriter.writeLongArray(parcel0, 12, this.getActiveTrackIds(), false);
        SafeParcelWriter.writeInt(parcel0, 13, this.getLoadingItemId());
        SafeParcelWriter.writeInt(parcel0, 14, this.getPreloadedItemId());
        SafeParcelWriter.writeString(parcel0, 15, this.zzn, false);
        SafeParcelWriter.writeInt(parcel0, 16, this.zzp);
        SafeParcelWriter.writeTypedList(parcel0, 17, this.zzq, false);
        SafeParcelWriter.writeBoolean(parcel0, 18, this.isPlayingAd());
        SafeParcelWriter.writeParcelable(parcel0, 19, this.getAdBreakStatus(), v, false);
        SafeParcelWriter.writeParcelable(parcel0, 20, this.getVideoInfo(), v, false);
        SafeParcelWriter.writeParcelable(parcel0, 21, this.getLiveSeekableRange(), v, false);
        SafeParcelWriter.writeParcelable(parcel0, 22, this.getQueueData(), v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final int zza(JSONObject jSONObject0, int v) {
        boolean z2;
        int v4;
        int v2;
        JSONObject jSONObject1 = jSONObject0.optJSONObject("extendedStatus");
        boolean z = false;
        if(jSONObject1 != null) {
            try {
                ArrayList arrayList0 = new ArrayList();
                Iterator iterator0 = jSONObject0.keys();
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    arrayList0.add(((String)object0));
                }
                JSONObject jSONObject2 = new JSONObject(jSONObject0, ((String[])arrayList0.toArray(new String[0])));
                Iterator iterator1 = jSONObject1.keys();
                while(iterator1.hasNext()) {
                    Object object1 = iterator1.next();
                    jSONObject2.put(((String)object1), jSONObject1.get(((String)object1)));
                }
                jSONObject2.remove("extendedStatus");
                jSONObject0 = jSONObject2;
            }
            catch(JSONException unused_ex) {
            }
        }
        long v1 = jSONObject0.getLong("mediaSessionId");
        if(Long.compare(v1, this.zzb) == 0) {
            v2 = 0;
        }
        else {
            this.zzb = v1;
            v2 = 1;
        }
        if(jSONObject0.has("playerState")) {
            String s = jSONObject0.getString("playerState");
            int v3 = 3;
            if(s.equals("IDLE")) {
                v4 = 1;
            }
            else if(s.equals("PLAYING")) {
                v4 = 2;
            }
            else if(s.equals("PAUSED")) {
                v4 = 3;
            }
            else if(s.equals("BUFFERING")) {
                v4 = 4;
            }
            else {
                v4 = s.equals("LOADING") ? 5 : 0;
            }
            if(v4 != this.zze) {
                this.zze = v4;
                v2 |= 2;
            }
            if(v4 == 1 && jSONObject0.has("idleReason")) {
                String s1 = jSONObject0.getString("idleReason");
                if(s1.equals("CANCELLED")) {
                    v3 = 2;
                }
                else if(!s1.equals("INTERRUPTED")) {
                    if(s1.equals("FINISHED")) {
                        v3 = 1;
                    }
                    else {
                        v3 = s1.equals("ERROR") ? 4 : 0;
                    }
                }
                if(v3 != this.zzf) {
                    this.zzf = v3;
                    v2 |= 2;
                }
            }
        }
        if(jSONObject0.has("playbackRate")) {
            double f = jSONObject0.getDouble("playbackRate");
            if(this.zzd != f) {
                this.zzd = f;
                v2 |= 2;
            }
        }
        if(jSONObject0.has("currentTime")) {
            long v5 = CastUtils.secToMillisec(jSONObject0.getDouble("currentTime"));
            if(v5 != this.zzg) {
                this.zzg = v5;
                v2 |= 2;
            }
            v2 |= 0x80;
        }
        if(jSONObject0.has("supportedMediaCommands")) {
            long v6 = jSONObject0.getLong("supportedMediaCommands");
            if(v6 != this.zzh) {
                this.zzh = v6;
                v2 |= 2;
            }
        }
        if(jSONObject0.has("volume") && v == 0) {
            JSONObject jSONObject3 = jSONObject0.getJSONObject("volume");
            double f1 = jSONObject3.getDouble("level");
            if(f1 != this.zzi) {
                this.zzi = f1;
                v2 |= 2;
            }
            boolean z1 = jSONObject3.getBoolean("muted");
            if(z1 != this.zzj) {
                this.zzj = z1;
                v2 |= 2;
            }
        }
        long[] arr_v = CastUtils.zzg((jSONObject0.has("activeTrackIds") ? jSONObject0.getJSONArray("activeTrackIds") : null));
        if(arr_v != null) {
            if(this.zzk != null && this.zzk.length == arr_v.length) {
                int v7 = 0;
                while(v7 < arr_v.length) {
                    if(this.zzk[v7] != arr_v[v7]) {
                        goto label_90;
                    }
                    ++v7;
                }
                goto label_96;
            }
        label_90:
            this.zzk = arr_v;
            v2 |= 2;
        }
        else if(this.zzk != null) {
            this.zzk = null;
            v2 |= 2;
        }
    label_96:
        if(jSONObject0.has("customData")) {
            this.zzo = jSONObject0.getJSONObject("customData");
            this.zzn = null;
            v2 |= 2;
        }
        if(jSONObject0.has("media")) {
            JSONObject jSONObject4 = jSONObject0.getJSONObject("media");
            MediaInfo mediaInfo0 = new MediaInfo(jSONObject4);
            if(this.zza == null || !this.zza.equals(mediaInfo0)) {
                this.zza = mediaInfo0;
                v2 |= 2;
            }
            if(jSONObject4.has("metadata")) {
                v2 |= 4;
            }
        }
        if(jSONObject0.has("currentItemId")) {
            int v8 = jSONObject0.getInt("currentItemId");
            if(this.zzc != v8) {
                this.zzc = v8;
                v2 |= 2;
            }
        }
        int v9 = jSONObject0.optInt("preloadedItemId", 0);
        if(this.zzm != v9) {
            this.zzm = v9;
            v2 |= 16;
        }
        int v10 = jSONObject0.optInt("loadingItemId", 0);
        if(this.zzl != v10) {
            this.zzl = v10;
            v2 |= 2;
        }
        if(MediaStatus.zzf(this.zze, this.zzf, this.zzl, (this.zza == null ? -1 : this.zza.getStreamType()))) {
            this.zzc = 0;
            this.zzl = 0;
            this.zzm = 0;
            List list0 = this.zzq;
            if(!list0.isEmpty()) {
                v2 |= 8;
                this.zzp = 0;
                list0.clear();
                this.zzy.clear();
            }
        }
        else {
            if(jSONObject0.has("repeatMode")) {
                Integer integer0 = MediaCommon.mediaRepeatModeFromString(jSONObject0.getString("repeatMode"));
                int v11 = integer0 == null ? this.zzp : ((int)integer0);
                if(this.zzp == v11) {
                    z2 = false;
                }
                else {
                    this.zzp = v11;
                    z2 = true;
                }
            }
            else {
                z2 = false;
            }
            if(jSONObject0.has("items")) {
                JSONArray jSONArray0 = jSONObject0.getJSONArray("items");
                int v12 = jSONArray0.length();
                SparseArray sparseArray0 = new SparseArray();
                for(int v13 = 0; v13 < v12; ++v13) {
                    sparseArray0.put(v13, jSONArray0.getJSONObject(v13).getInt("itemId"));
                }
                ArrayList arrayList1 = new ArrayList();
                int v14 = 0;
                while(v14 < v12) {
                    Integer integer1 = (Integer)sparseArray0.get(v14);
                    JSONObject jSONObject5 = jSONArray0.getJSONObject(v14);
                    MediaQueueItem mediaQueueItem0 = this.getItemById(((int)integer1));
                    if(mediaQueueItem0 == null) {
                        if(((int)integer1) == this.zzc) {
                            MediaInfo mediaInfo1 = this.zza;
                            if(mediaInfo1 != null) {
                                MediaQueueItem mediaQueueItem1 = new com.google.android.gms.cast.MediaQueueItem.Builder(mediaInfo1).build();
                                mediaQueueItem1.fromJson(jSONObject5);
                                arrayList1.add(mediaQueueItem1);
                            }
                        }
                        else {
                            arrayList1.add(new MediaQueueItem(jSONObject5));
                        }
                        z2 = true;
                    }
                    else {
                        z2 |= mediaQueueItem0.fromJson(jSONObject5);
                        arrayList1.add(mediaQueueItem0);
                        if(v14 != ((int)this.getIndexById(((int)integer1)))) {
                            z2 = true;
                            ++v14;
                            continue;
                        }
                    }
                    ++v14;
                }
                z2 |= (this.zzq.size() == v12 ? 1 : 0) ^ 1;
                this.zze(arrayList1);
            }
            if(z2) {
                v2 |= 8;
            }
        }
        AdBreakStatus adBreakStatus0 = AdBreakStatus.zza(jSONObject0.optJSONObject("breakStatus"));
        if(this.zzs == null && adBreakStatus0 != null || this.zzs != null && !this.zzs.equals(adBreakStatus0)) {
            if(adBreakStatus0 != null && (adBreakStatus0.getBreakId() != null || adBreakStatus0.getBreakClipId() != null)) {
                z = true;
            }
            this.zzr = z;
            this.zzs = adBreakStatus0;
            v2 |= 0x20;
        }
        VideoInfo videoInfo0 = VideoInfo.zza(jSONObject0.optJSONObject("videoInfo"));
        if(this.zzt == null && videoInfo0 != null || this.zzt != null && !this.zzt.equals(videoInfo0)) {
            this.zzt = videoInfo0;
            v2 |= 0x40;
        }
        if(jSONObject0.has("breakInfo")) {
            MediaInfo mediaInfo2 = this.zza;
            if(mediaInfo2 != null) {
                mediaInfo2.zzr(jSONObject0.getJSONObject("breakInfo"));
                v2 |= 2;
            }
        }
        if(jSONObject0.has("queueData")) {
            com.google.android.gms.cast.MediaQueueData.Builder mediaQueueData$Builder0 = new com.google.android.gms.cast.MediaQueueData.Builder();
            mediaQueueData$Builder0.zza(jSONObject0.getJSONObject("queueData"));
            MediaQueueData mediaQueueData0 = mediaQueueData$Builder0.build();
            this.zzv = mediaQueueData0;
            boolean z3 = mediaQueueData0.zzk();
            if(this.zzw != z3) {
                this.zzw = z3;
                v2 |= 8;
            }
        }
        if(jSONObject0.has("liveSeekableRange")) {
            this.zzu = MediaLiveSeekableRange.zza(jSONObject0.optJSONObject("liveSeekableRange"));
            return v2 | 2;
        }
        if(this.zzu != null) {
            v2 |= 2;
        }
        this.zzu = null;
        return v2;
    }

    public final long zzb() {
        return this.zzb;
    }

    public final boolean zzd() {
        return this.zza == null ? MediaStatus.zzf(this.zze, this.zzf, this.zzl, -1) : MediaStatus.zzf(this.zze, this.zzf, this.zzl, this.zza.getStreamType());
    }

    private final void zze(List list0) {
        List list1 = this.zzq;
        list1.clear();
        SparseArray sparseArray0 = this.zzy;
        sparseArray0.clear();
        if(list0 != null) {
            for(int v = 0; v < list0.size(); ++v) {
                MediaQueueItem mediaQueueItem0 = (MediaQueueItem)list0.get(v);
                list1.add(mediaQueueItem0);
                sparseArray0.put(mediaQueueItem0.getItemId(), v);
            }
        }
    }

    private static final boolean zzf(int v, int v1, int v2, int v3) {
        if(v != 1) {
            return false;
        }
        switch(v1) {
            case 2: {
                return v3 != 2;
            }
            case 1: 
            case 3: {
                return v2 == 0;
            }
            default: {
                return true;
            }
        }
    }
}

