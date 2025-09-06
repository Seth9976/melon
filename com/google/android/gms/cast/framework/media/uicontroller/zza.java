package com.google.android.gms.cast.framework.media.uicontroller;

import android.text.format.DateUtils;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.text.DateFormat;
import java.util.Date;

@ShowFirstParty
public final class zza {
    RemoteMediaClient zza;

    public final int zza() {
        if(this.zza != null && this.zza.hasMediaSession()) {
            RemoteMediaClient remoteMediaClient0 = this.zza;
            if(remoteMediaClient0.isLiveStream() || !remoteMediaClient0.isLoadingNextItem()) {
                int v = (int)(remoteMediaClient0.getApproximateStreamPosition() - this.zze());
                if(remoteMediaClient0.zzw()) {
                    v = Math.min(Math.max(v, this.zzd()), this.zzc());
                }
                return Math.min(Math.max(v, 0), this.zzb());
            }
        }
        return 0;
    }

    public final int zzb() {
        long v = 1L;
        if(this.zza != null && this.zza.hasMediaSession()) {
            RemoteMediaClient remoteMediaClient0 = this.zza;
            if(remoteMediaClient0.isLiveStream()) {
                Long long0 = this.zzi();
                if(long0 != null) {
                    return Math.max(((int)(((long)long0) - this.zze())), 1);
                }
                Long long1 = this.zzg();
                if(long1 != null) {
                    return Math.max(((int)(((long)long1) - this.zze())), 1);
                }
                v = Math.max(remoteMediaClient0.getApproximateStreamPosition(), 1L);
            }
            else {
                if(!remoteMediaClient0.isLoadingNextItem()) {
                    return Math.max(((int)(Math.max(remoteMediaClient0.getStreamDuration(), 1L) - this.zze())), 1);
                }
                MediaQueueItem mediaQueueItem0 = remoteMediaClient0.getLoadingItem();
                if(mediaQueueItem0 != null) {
                    MediaInfo mediaInfo0 = mediaQueueItem0.getMedia();
                    return mediaInfo0 == null ? Math.max(((int)(1L - this.zze())), 1) : Math.max(((int)(Math.max(mediaInfo0.getStreamDuration(), 1L) - this.zze())), 1);
                }
            }
        }
        return Math.max(((int)(v - this.zze())), 1);
    }

    public final int zzc() {
        if(this.zza != null && this.zza.hasMediaSession() && this.zza.isLiveStream()) {
            return this.zza.zzw() ? Math.min(Math.max(((int)(((long)(((Long)Preconditions.checkNotNull(this.zzg())))) - this.zze())), 0), this.zzb()) : 0;
        }
        return this.zzb();
    }

    // 去混淆评级： 低(30)
    public final int zzd() {
        return this.zza == null || !this.zza.hasMediaSession() || !this.zza.isLiveStream() || !this.zza.zzw() ? 0 : Math.min(Math.max(((int)(((long)(((Long)Preconditions.checkNotNull(this.zzh())))) - this.zze())), 0), this.zzb());
    }

    public final long zze() {
        if(this.zza != null && this.zza.hasMediaSession() && this.zza.isLiveStream()) {
            RemoteMediaClient remoteMediaClient0 = this.zza;
            Long long0 = this.zzj();
            if(long0 != null) {
                return (long)long0;
            }
            Long long1 = this.zzh();
            return long1 == null ? remoteMediaClient0.getApproximateStreamPosition() : ((long)long1);
        }
        return 0L;
    }

    public static zza zzf() {
        return new zza();
    }

    public final Long zzg() {
        if(this.zza != null && this.zza.hasMediaSession() && this.zza.isLiveStream() && this.zza.zzw()) {
            RemoteMediaClient remoteMediaClient0 = this.zza;
            MediaStatus mediaStatus0 = remoteMediaClient0.getMediaStatus();
            return mediaStatus0 == null || mediaStatus0.getLiveSeekableRange() == null ? null : remoteMediaClient0.getApproximateLiveSeekableRangeEnd();
        }
        return null;
    }

    public final Long zzh() {
        if(this.zza != null && this.zza.hasMediaSession() && this.zza.isLiveStream() && this.zza.zzw()) {
            RemoteMediaClient remoteMediaClient0 = this.zza;
            MediaStatus mediaStatus0 = remoteMediaClient0.getMediaStatus();
            return mediaStatus0 == null || mediaStatus0.getLiveSeekableRange() == null ? null : remoteMediaClient0.getApproximateLiveSeekableRangeStart();
        }
        return null;
    }

    public final Long zzi() {
        if(this.zza != null && this.zza.hasMediaSession() && this.zza.isLiveStream()) {
            MediaMetadata mediaMetadata0 = this.zzo();
            if(mediaMetadata0 != null && mediaMetadata0.containsKey("com.google.android.gms.cast.metadata.SECTION_DURATION")) {
                Long long0 = this.zzj();
                return long0 == null ? null : ((long)(mediaMetadata0.getTimeMillis("com.google.android.gms.cast.metadata.SECTION_DURATION") + ((long)long0)));
            }
        }
        return null;
    }

    public final Long zzj() {
        if(this.zza != null && this.zza.hasMediaSession() && this.zza.isLiveStream()) {
            RemoteMediaClient remoteMediaClient0 = this.zza;
            MediaInfo mediaInfo0 = remoteMediaClient0.getMediaInfo();
            MediaMetadata mediaMetadata0 = this.zzo();
            return mediaInfo0 == null || mediaMetadata0 == null || !mediaMetadata0.containsKey("com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA") || !mediaMetadata0.containsKey("com.google.android.gms.cast.metadata.SECTION_DURATION") && !remoteMediaClient0.zzw() ? null : mediaMetadata0.getTimeMillis("com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA");
        }
        return null;
    }

    public final Long zzk() {
        if(this.zza != null && this.zza.hasMediaSession() && this.zza.isLiveStream()) {
            MediaInfo mediaInfo0 = this.zza.getMediaInfo();
            return mediaInfo0 == null || mediaInfo0.getStartAbsoluteTime() == -1L ? null : mediaInfo0.getStartAbsoluteTime();
        }
        return null;
    }

    public final String zzl(long v) {
        if(this.zza != null && this.zza.hasMediaSession()) {
            RemoteMediaClient remoteMediaClient0 = this.zza;
            if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession() && this.zza.isLiveStream() && this.zzk() != null) {
                long v1 = (long)(((Long)Preconditions.checkNotNull(this.zzk())));
                return DateFormat.getTimeInstance().format(new Date(v1 + v));
            }
            return !remoteMediaClient0.isLiveStream() || this.zzj() != null ? zza.zzp(v - this.zze()) : zza.zzp(v);
        }
        return null;
    }

    public final boolean zzm() {
        long v = (long)this.zza();
        return this.zzn(this.zze() + v);
    }

    public final boolean zzn(long v) {
        if(this.zza == null || !this.zza.hasMediaSession() || !this.zza.zzw()) {
            return false;
        }
        long v1 = (long)this.zzc();
        return this.zze() + v1 - v < 10000L;
    }

    private final MediaMetadata zzo() {
        if(this.zza != null && this.zza.hasMediaSession()) {
            MediaInfo mediaInfo0 = this.zza.getMediaInfo();
            return mediaInfo0 == null ? null : mediaInfo0.getMetadata();
        }
        return null;
    }

    private static final String zzp(long v) {
        return Long.compare(v, 0L) < 0 ? "-" + DateUtils.formatElapsedTime(-v / 1000L) : DateUtils.formatElapsedTime(v / 1000L);
    }
}

