package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.JsonUtils;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "MediaLoadRequestDataCreator")
@Reserved({1})
public class MediaLoadRequestData extends AbstractSafeParcelable implements RequestData {
    public static class Builder {
        private MediaInfo zza;
        private MediaQueueData zzb;
        private Boolean zzc;
        private long zzd;
        private double zze;
        private long[] zzf;
        private JSONObject zzg;
        private String zzh;
        private String zzi;
        private String zzj;
        private String zzk;
        private long zzl;

        public Builder() {
            this.zzc = Boolean.TRUE;
            this.zzd = -1L;
            this.zze = 1.0;
        }

        public Builder(MediaLoadRequestData mediaLoadRequestData0) {
            this.zzc = Boolean.TRUE;
            this.zzd = -1L;
            this.zze = 1.0;
            this.zza = mediaLoadRequestData0.getMediaInfo();
            this.zzb = mediaLoadRequestData0.getQueueData();
            this.zzc = mediaLoadRequestData0.getAutoplay();
            this.zzd = mediaLoadRequestData0.getCurrentTime();
            this.zze = mediaLoadRequestData0.getPlaybackRate();
            this.zzf = mediaLoadRequestData0.getActiveTrackIds();
            this.zzg = mediaLoadRequestData0.getCustomData();
            this.zzh = mediaLoadRequestData0.getCredentials();
            this.zzi = mediaLoadRequestData0.getCredentialsType();
            this.zzj = mediaLoadRequestData0.zza();
            this.zzk = mediaLoadRequestData0.zzb();
            this.zzl = mediaLoadRequestData0.getRequestId();
        }

        public MediaLoadRequestData build() {
            return new MediaLoadRequestData(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, null);
        }

        public Builder setActiveTrackIds(long[] arr_v) {
            this.zzf = arr_v;
            return this;
        }

        public Builder setAtvCredentials(String s) {
            this.zzj = s;
            return this;
        }

        public Builder setAtvCredentialsType(String s) {
            this.zzk = s;
            return this;
        }

        public Builder setAutoplay(Boolean boolean0) {
            this.zzc = boolean0;
            return this;
        }

        public Builder setCredentials(String s) {
            this.zzh = s;
            return this;
        }

        public Builder setCredentialsType(String s) {
            this.zzi = s;
            return this;
        }

        public Builder setCurrentTime(long v) {
            this.zzd = v;
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject0) {
            this.zzg = jSONObject0;
            return this;
        }

        public Builder setMediaInfo(MediaInfo mediaInfo0) {
            this.zza = mediaInfo0;
            return this;
        }

        public Builder setPlaybackRate(double f) {
            if(Double.compare(f, 2.0) > 0 || Double.compare(f, 0.5) < 0) {
                throw new IllegalArgumentException("playbackRate must be between PLAYBACK_RATE_MIN and PLAYBACK_RATE_MAX");
            }
            this.zze = f;
            return this;
        }

        public Builder setQueueData(MediaQueueData mediaQueueData0) {
            this.zzb = mediaQueueData0;
            return this;
        }

        public final Builder zza(long v) {
            this.zzl = v;
            return this;
        }
    }

    @KeepForSdk
    public static final Parcelable.Creator CREATOR = null;
    public static final double PLAYBACK_RATE_MAX = 2.0;
    public static final double PLAYBACK_RATE_MIN = 0.5;
    public static final long PLAY_POSITION_UNASSIGNED = -1L;
    @Field(id = 8)
    String zza;
    private static final Logger zzb;
    @Field(getter = "getMediaInfo", id = 2)
    private final MediaInfo zzc;
    @Field(getter = "getQueueData", id = 3)
    private final MediaQueueData zzd;
    @Field(getter = "getAutoplay", id = 4)
    private final Boolean zze;
    @Field(getter = "getCurrentTime", id = 5)
    private final long zzf;
    @Field(getter = "getPlaybackRate", id = 6)
    private final double zzg;
    @Field(getter = "getActiveTrackIds", id = 7)
    private final long[] zzh;
    private final JSONObject zzi;
    @Field(getter = "getCredentials", id = 9)
    private final String zzj;
    @Field(getter = "getCredentialsType", id = 10)
    private final String zzk;
    @Field(getter = "getAtvCredentials", id = 11)
    private final String zzl;
    @Field(getter = "getAtvCredentialsType", id = 12)
    private final String zzm;
    @Field(getter = "getRequestId", id = 13)
    private long zzn;

    static {
        MediaLoadRequestData.zzb = new Logger("MediaLoadRequestData");
        MediaLoadRequestData.CREATOR = new zzca();
    }

    @Constructor
    public MediaLoadRequestData(@Param(id = 2) MediaInfo mediaInfo0, @Param(id = 3) MediaQueueData mediaQueueData0, @Param(id = 4) Boolean boolean0, @Param(id = 5) long v, @Param(id = 6) double f, @Param(id = 7) long[] arr_v, @Param(id = 8) String s, @Param(id = 9) String s1, @Param(id = 10) String s2, @Param(id = 11) String s3, @Param(id = 12) String s4, @Param(id = 13) long v1) {
        this(mediaInfo0, mediaQueueData0, boolean0, v, f, arr_v, CastUtils.jsonStringToJsonObject(s), s1, s2, s3, s4, v1);
    }

    private MediaLoadRequestData(MediaInfo mediaInfo0, MediaQueueData mediaQueueData0, Boolean boolean0, long v, double f, long[] arr_v, JSONObject jSONObject0, String s, String s1, String s2, String s3, long v1) {
        this.zzc = mediaInfo0;
        this.zzd = mediaQueueData0;
        this.zze = boolean0;
        this.zzf = v;
        this.zzg = f;
        this.zzh = arr_v;
        this.zzi = jSONObject0;
        this.zzj = s;
        this.zzk = s1;
        this.zzl = s2;
        this.zzm = s3;
        this.zzn = v1;
    }

    public MediaLoadRequestData(MediaInfo mediaInfo0, MediaQueueData mediaQueueData0, Boolean boolean0, long v, double f, long[] arr_v, JSONObject jSONObject0, String s, String s1, String s2, String s3, long v1, zzbz zzbz0) {
        this(mediaInfo0, mediaQueueData0, boolean0, v, f, arr_v, jSONObject0, s, s1, s2, s3, v1);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof MediaLoadRequestData)) {
            return false;
        }
        return JsonUtils.areJsonValuesEquivalent(this.zzi, ((MediaLoadRequestData)object0).zzi) ? Objects.equal(this.zzc, ((MediaLoadRequestData)object0).zzc) && Objects.equal(this.zzd, ((MediaLoadRequestData)object0).zzd) && Objects.equal(this.zze, ((MediaLoadRequestData)object0).zze) && this.zzf == ((MediaLoadRequestData)object0).zzf && this.zzg == ((MediaLoadRequestData)object0).zzg && Arrays.equals(this.zzh, ((MediaLoadRequestData)object0).zzh) && Objects.equal(this.zzj, ((MediaLoadRequestData)object0).zzj) && Objects.equal(this.zzk, ((MediaLoadRequestData)object0).zzk) && Objects.equal(this.zzl, ((MediaLoadRequestData)object0).zzl) && Objects.equal(this.zzm, ((MediaLoadRequestData)object0).zzm) && this.zzn == ((MediaLoadRequestData)object0).zzn : false;
    }

    @KeepForSdk
    public static MediaLoadRequestData fromJson(JSONObject jSONObject0) {
        Builder mediaLoadRequestData$Builder0 = new Builder();
        try {
            if(jSONObject0.has("media")) {
                mediaLoadRequestData$Builder0.setMediaInfo(new MediaInfo(jSONObject0.getJSONObject("media")));
            }
            if(jSONObject0.has("queueData")) {
                com.google.android.gms.cast.MediaQueueData.Builder mediaQueueData$Builder0 = new com.google.android.gms.cast.MediaQueueData.Builder();
                mediaQueueData$Builder0.zza(jSONObject0.getJSONObject("queueData"));
                mediaLoadRequestData$Builder0.setQueueData(mediaQueueData$Builder0.build());
            }
            if(jSONObject0.has("autoplay")) {
                mediaLoadRequestData$Builder0.setAutoplay(Boolean.valueOf(jSONObject0.getBoolean("autoplay")));
            }
            else {
                mediaLoadRequestData$Builder0.setAutoplay(null);
            }
            if(jSONObject0.has("currentTime")) {
                mediaLoadRequestData$Builder0.setCurrentTime(CastUtils.secToMillisec(jSONObject0.getDouble("currentTime")));
            }
            else {
                mediaLoadRequestData$Builder0.setCurrentTime(-1L);
            }
            mediaLoadRequestData$Builder0.setPlaybackRate(jSONObject0.optDouble("playbackRate", 1.0));
            mediaLoadRequestData$Builder0.setCredentials(CastUtils.optStringOrNull(jSONObject0, "credentials"));
            mediaLoadRequestData$Builder0.setCredentialsType(CastUtils.optStringOrNull(jSONObject0, "credentialsType"));
            mediaLoadRequestData$Builder0.setAtvCredentials(CastUtils.optStringOrNull(jSONObject0, "atvCredentials"));
            mediaLoadRequestData$Builder0.setAtvCredentialsType(CastUtils.optStringOrNull(jSONObject0, "atvCredentialsType"));
            mediaLoadRequestData$Builder0.zza(jSONObject0.optLong("requestId"));
            JSONArray jSONArray0 = jSONObject0.optJSONArray("activeTrackIds");
            if(jSONArray0 != null) {
                long[] arr_v = new long[jSONArray0.length()];
                for(int v = 0; v < jSONArray0.length(); ++v) {
                    arr_v[v] = jSONArray0.getLong(v);
                }
                mediaLoadRequestData$Builder0.setActiveTrackIds(arr_v);
            }
            mediaLoadRequestData$Builder0.setCustomData(jSONObject0.optJSONObject("customData"));
            return mediaLoadRequestData$Builder0.build();
        }
        catch(JSONException unused_ex) {
            return mediaLoadRequestData$Builder0.build();
        }
    }

    public long[] getActiveTrackIds() {
        return this.zzh;
    }

    public Boolean getAutoplay() {
        return this.zze;
    }

    public String getCredentials() {
        return this.zzj;
    }

    public String getCredentialsType() {
        return this.zzk;
    }

    public long getCurrentTime() {
        return this.zzf;
    }

    @Override  // com.google.android.gms.cast.RequestData
    public JSONObject getCustomData() {
        return this.zzi;
    }

    public MediaInfo getMediaInfo() {
        return this.zzc;
    }

    public double getPlaybackRate() {
        return this.zzg;
    }

    public MediaQueueData getQueueData() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.cast.RequestData
    @KeepForSdk
    public long getRequestId() {
        return this.zzn;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, String.valueOf(this.zzi), this.zzj, this.zzk, this.zzl, this.zzm, this.zzn});
    }

    @KeepForSdk
    public void setRequestId(long v) {
        this.zzn = v;
    }

    @KeepForSdk
    public JSONObject toJson() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            MediaInfo mediaInfo0 = this.zzc;
            if(mediaInfo0 != null) {
                jSONObject0.put("media", mediaInfo0.zza());
            }
            MediaQueueData mediaQueueData0 = this.zzd;
            if(mediaQueueData0 != null) {
                jSONObject0.put("queueData", mediaQueueData0.zza());
            }
            jSONObject0.putOpt("autoplay", this.zze);
            long v = this.zzf;
            if(v != -1L) {
                jSONObject0.put("currentTime", ((double)v) / 1000.0);
            }
            jSONObject0.put("playbackRate", this.zzg);
            jSONObject0.putOpt("credentials", this.zzj);
            jSONObject0.putOpt("credentialsType", this.zzk);
            jSONObject0.putOpt("atvCredentials", this.zzl);
            jSONObject0.putOpt("atvCredentialsType", this.zzm);
            long[] arr_v = this.zzh;
            if(arr_v != null) {
                JSONArray jSONArray0 = new JSONArray();
                for(int v1 = 0; v1 < arr_v.length; ++v1) {
                    jSONArray0.put(v1, arr_v[v1]);
                }
                jSONObject0.put("activeTrackIds", jSONArray0);
            }
            jSONObject0.putOpt("customData", this.zzi);
            jSONObject0.put("requestId", this.zzn);
            return jSONObject0;
        }
        catch(JSONException jSONException0) {
        }
        MediaLoadRequestData.zzb.e("Error transforming MediaLoadRequestData into JSONObject", new Object[]{jSONException0});
        return new JSONObject();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        this.zza = this.zzi == null ? null : this.zzi.toString();
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.getMediaInfo(), v, false);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.getQueueData(), v, false);
        SafeParcelWriter.writeBooleanObject(parcel0, 4, this.getAutoplay(), false);
        SafeParcelWriter.writeLong(parcel0, 5, this.getCurrentTime());
        SafeParcelWriter.writeDouble(parcel0, 6, this.getPlaybackRate());
        SafeParcelWriter.writeLongArray(parcel0, 7, this.getActiveTrackIds(), false);
        SafeParcelWriter.writeString(parcel0, 8, this.zza, false);
        SafeParcelWriter.writeString(parcel0, 9, this.getCredentials(), false);
        SafeParcelWriter.writeString(parcel0, 10, this.getCredentialsType(), false);
        SafeParcelWriter.writeString(parcel0, 11, this.zzl, false);
        SafeParcelWriter.writeString(parcel0, 12, this.zzm, false);
        SafeParcelWriter.writeLong(parcel0, 13, this.getRequestId());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final String zza() {
        return this.zzl;
    }

    public final String zzb() {
        return this.zzm;
    }
}

