package com.google.android.gms.cast;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.internal.cast.zzhd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "MediaInfoCreator")
@Reserved({1})
public class MediaInfo extends AbstractSafeParcelable implements ReflectedParcelable {
    public static class Builder {
        private String zza;
        private int zzb;
        private String zzc;
        private MediaMetadata zzd;
        private long zze;
        private List zzf;
        private TextTrackStyle zzg;
        private String zzh;
        private List zzi;
        private List zzj;
        private String zzk;
        private VastAdsRequest zzl;
        private String zzm;
        private String zzn;
        @HlsSegmentFormat
        private String zzo;
        @HlsVideoSegmentFormat
        private String zzp;

        public Builder() {
            this.zzb = -1;
            this.zze = -1L;
        }

        public Builder(String s) {
            this.zzb = -1;
            this.zze = -1L;
            this.zza = s;
        }

        public Builder(String s, String s1) {
            this.zzb = -1;
            this.zze = -1L;
            this.zza = s;
            this.zzk = s1;
        }

        public MediaInfo build() {
            return new MediaInfo(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, -1L, this.zzm, this.zzn, this.zzo, this.zzp);
        }

        public Builder setAdBreakClips(List list0) {
            this.zzj = list0;
            return this;
        }

        public Builder setAdBreaks(List list0) {
            this.zzi = list0;
            return this;
        }

        public Builder setAtvEntity(String s) {
            this.zzm = s;
            return this;
        }

        public Builder setContentType(String s) {
            this.zzc = s;
            return this;
        }

        public Builder setContentUrl(String s) {
            this.zzn = s;
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject0) {
            this.zzh = jSONObject0 == null ? null : jSONObject0.toString();
            return this;
        }

        public Builder setEntity(String s) {
            this.zzk = s;
            return this;
        }

        public Builder setHlsSegmentFormat(@HlsSegmentFormat String s) {
            this.zzo = s;
            return this;
        }

        public Builder setHlsVideoSegmentFormat(@HlsVideoSegmentFormat String s) {
            this.zzp = s;
            return this;
        }

        public Builder setMediaTracks(List list0) {
            this.zzf = list0;
            return this;
        }

        public Builder setMetadata(MediaMetadata mediaMetadata0) {
            this.zzd = mediaMetadata0;
            return this;
        }

        public Builder setStreamDuration(long v) {
            if(v < 0L && v != -1L) {
                throw new IllegalArgumentException("Invalid stream duration");
            }
            this.zze = v;
            return this;
        }

        public Builder setStreamType(int v) {
            if(v < -1 || v > 2) {
                throw new IllegalArgumentException("invalid stream type");
            }
            this.zzb = v;
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle0) {
            this.zzg = textTrackStyle0;
            return this;
        }

        public Builder setVmapAdsRequest(VastAdsRequest vastAdsRequest0) {
            this.zzl = vastAdsRequest0;
            return this;
        }
    }

    @KeepForSdk
    public class Writer {
        final MediaInfo zza;

        @KeepForSdk
        public void setAdBreakClips(List list0) {
            MediaInfo.this.zzk = list0;
        }

        @KeepForSdk
        public void setAdBreaks(List list0) {
            MediaInfo.this.zzj = list0;
        }

        @KeepForSdk
        public void setContentId(String s) {
            MediaInfo.this.zzc = s;
        }

        @KeepForSdk
        public void setContentType(String s) {
            MediaInfo.this.zze = s;
        }

        @KeepForSdk
        public void setContentUrl(String s) {
            MediaInfo.this.zzp = s;
        }

        @KeepForSdk
        public void setCustomData(JSONObject jSONObject0) {
            MediaInfo.this.zzs = jSONObject0;
        }

        @KeepForSdk
        public void setEntity(String s) {
            MediaInfo.this.zzl = s;
        }

        @KeepForSdk
        public void setHlsSegmentFormat(@HlsSegmentFormat String s) {
            MediaInfo.this.zzq = s;
        }

        @KeepForSdk
        public void setHlsVideoSegmentFormat(@HlsVideoSegmentFormat String s) {
            MediaInfo.this.zzr = s;
        }

        @KeepForSdk
        public void setMediaTracks(List list0) {
            MediaInfo.this.zzh = list0;
        }

        @KeepForSdk
        public void setMetadata(MediaMetadata mediaMetadata0) {
            MediaInfo.this.zzf = mediaMetadata0;
        }

        @KeepForSdk
        public void setStartAbsoluteTime(long v) {
            if(v < 0L && v != -1L) {
                throw new IllegalArgumentException("Invalid start absolute time");
            }
            MediaInfo.this.zzn = v;
        }

        @KeepForSdk
        public void setStreamDuration(long v) {
            if(v < 0L && v != -1L) {
                throw new IllegalArgumentException("Invalid stream duration");
            }
            MediaInfo.this.zzg = v;
        }

        @KeepForSdk
        public void setStreamType(int v) {
            if(v < -1 || v > 2) {
                throw new IllegalArgumentException("invalid stream type");
            }
            MediaInfo.this.zzd = v;
        }

        @KeepForSdk
        public void setTextTrackStyle(TextTrackStyle textTrackStyle0) {
            MediaInfo.this.zzi = textTrackStyle0;
        }

        @KeepForSdk
        public void setVmapAdsRequest(VastAdsRequest vastAdsRequest0) {
            MediaInfo.this.zzm = vastAdsRequest0;
        }
    }

    public static final Parcelable.Creator CREATOR = null;
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1L;
    public static final long UNKNOWN_START_ABSOLUTE_TIME = -1L;
    public static final long zza;
    @Field(id = 9)
    String zzb;
    @Field(getter = "getContentId", id = 2)
    private String zzc;
    @Field(getter = "getStreamType", id = 3)
    private int zzd;
    @Field(getter = "getContentType", id = 4)
    private String zze;
    @Field(getter = "getMetadata", id = 5)
    private MediaMetadata zzf;
    @Field(getter = "getStreamDuration", id = 6)
    private long zzg;
    @Field(getter = "getMediaTracks", id = 7)
    private List zzh;
    @Field(getter = "getTextTrackStyle", id = 8)
    private TextTrackStyle zzi;
    @Field(getter = "getAdBreaks", id = 10)
    private List zzj;
    @Field(getter = "getAdBreakClips", id = 11)
    private List zzk;
    @Field(getter = "getEntity", id = 12)
    private String zzl;
    @Field(getter = "getVmapAdsRequest", id = 13)
    private VastAdsRequest zzm;
    @Field(getter = "getStartAbsoluteTime", id = 14)
    private long zzn;
    @Field(getter = "getAtvEntity", id = 15)
    private String zzo;
    @Field(getter = "getContentUrl", id = 16)
    private String zzp;
    @HlsSegmentFormat
    @Field(getter = "getHlsSegmentFormat", id = 17)
    private String zzq;
    @HlsVideoSegmentFormat
    @Field(getter = "getHlsVideoSegmentFormat", id = 18)
    private String zzr;
    private JSONObject zzs;
    private final Writer zzt;

    static {
        MediaInfo.zza = -1000L;
        MediaInfo.CREATOR = new zzbw();
    }

    @Constructor
    public MediaInfo(@Param(id = 2) String s, @Param(id = 3) int v, @Param(id = 4) String s1, @Param(id = 5) MediaMetadata mediaMetadata0, @Param(id = 6) long v1, @Param(id = 7) List list0, @Param(id = 8) TextTrackStyle textTrackStyle0, @Param(id = 9) String s2, @Param(id = 10) List list1, @Param(id = 11) List list2, @Param(id = 12) String s3, @Param(id = 13) VastAdsRequest vastAdsRequest0, @Param(id = 14) long v2, @Param(id = 15) String s4, @Param(id = 16) String s5, @HlsSegmentFormat @Param(id = 17) String s6, @HlsVideoSegmentFormat @Param(id = 18) String s7) {
        this.zzt = new Writer(this);
        this.zzc = s;
        this.zzd = v;
        this.zze = s1;
        this.zzf = mediaMetadata0;
        this.zzg = v1;
        this.zzh = list0;
        this.zzi = textTrackStyle0;
        this.zzb = s2;
        if(s2 == null) {
            this.zzs = null;
        }
        else {
            try {
                this.zzs = new JSONObject(this.zzb);
            }
            catch(JSONException unused_ex) {
                this.zzs = null;
                this.zzb = null;
            }
        }
        this.zzj = list1;
        this.zzk = list2;
        this.zzl = s3;
        this.zzm = vastAdsRequest0;
        this.zzn = v2;
        this.zzo = s4;
        this.zzp = s5;
        this.zzq = s6;
        this.zzr = s7;
        if(this.zzc == null && s5 == null && s3 == null) {
            throw new IllegalArgumentException("Either contentID or contentUrl or entity should be set");
        }
    }

    public MediaInfo(JSONObject jSONObject0) {
        this(jSONObject0.optString("contentId"), -1, null, null, -1L, null, null, null, null, null, null, null, -1L, null, null, null, null);
        List list0;
        int v3;
        String s = jSONObject0.optString("streamType", "NONE");
        if("NONE".equals(s)) {
            this.zzd = 0;
        }
        else if("BUFFERED".equals(s)) {
            this.zzd = 1;
        }
        else if("LIVE".equals(s)) {
            this.zzd = 2;
        }
        else {
            this.zzd = -1;
        }
        this.zze = CastUtils.optStringOrNull(jSONObject0, "contentType");
        if(jSONObject0.has("metadata")) {
            JSONObject jSONObject1 = jSONObject0.getJSONObject("metadata");
            MediaMetadata mediaMetadata0 = new MediaMetadata(jSONObject1.getInt("metadataType"));
            this.zzf = mediaMetadata0;
            mediaMetadata0.zzc(jSONObject1);
        }
        this.zzg = -1L;
        if(this.zzd != 2 && jSONObject0.has("duration") && !jSONObject0.isNull("duration")) {
            double f = jSONObject0.optDouble("duration", 0.0);
            if(!Double.isNaN(f) && !Double.isInfinite(f) && f >= 0.0) {
                this.zzg = (long)(f * 1000.0);
            }
        }
        if(jSONObject0.has("tracks")) {
            ArrayList arrayList0 = new ArrayList();
            JSONArray jSONArray0 = jSONObject0.getJSONArray("tracks");
            for(int v = 0; v < jSONArray0.length(); ++v) {
                JSONObject jSONObject2 = jSONArray0.getJSONObject(v);
                long v1 = jSONObject2.getLong("trackId");
                String s1 = jSONObject2.optString("type");
                int v2 = 3;
                if("TEXT".equals(s1)) {
                    v2 = 1;
                }
                else if("AUDIO".equals(s1)) {
                    v2 = 2;
                }
                else if(!"VIDEO".equals(s1)) {
                    v2 = 0;
                }
                String s2 = CastUtils.optStringOrNull(jSONObject2, "trackContentId");
                String s3 = CastUtils.optStringOrNull(jSONObject2, "trackContentType");
                String s4 = CastUtils.optStringOrNull(jSONObject2, "name");
                String s5 = CastUtils.optStringOrNull(jSONObject2, "language");
                if(jSONObject2.has("subtype")) {
                    String s6 = jSONObject2.getString("subtype");
                    if("SUBTITLES".equals(s6)) {
                        v3 = 1;
                    }
                    else if("CAPTIONS".equals(s6)) {
                        v3 = 2;
                    }
                    else if("DESCRIPTIONS".equals(s6)) {
                        v3 = 3;
                    }
                    else if("CHAPTERS".equals(s6)) {
                        v3 = 4;
                    }
                    else if("METADATA".equals(s6)) {
                        v3 = 5;
                    }
                    else {
                        v3 = -1;
                    }
                }
                else {
                    v3 = 0;
                }
                if(jSONObject2.has("roles")) {
                    zzhd zzhd0 = new zzhd();
                    JSONArray jSONArray1 = jSONObject2.getJSONArray("roles");
                    for(int v4 = 0; v4 < jSONArray1.length(); ++v4) {
                        zzhd0.zzb(jSONArray1.optString(v4));
                    }
                    list0 = zzhd0.zzc();
                }
                else {
                    list0 = null;
                }
                arrayList0.add(new MediaTrack(v1, v2, s2, s3, s4, s5, v3, list0, jSONObject2.optJSONObject("customData")));
            }
            this.zzh = new ArrayList(arrayList0);
        }
        else {
            this.zzh = null;
        }
        if(jSONObject0.has("textTrackStyle")) {
            JSONObject jSONObject3 = jSONObject0.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle0 = new TextTrackStyle();
            textTrackStyle0.fromJson(jSONObject3);
            this.zzi = textTrackStyle0;
        }
        else {
            this.zzi = null;
        }
        this.zzr(jSONObject0);
        this.zzs = jSONObject0.optJSONObject("customData");
        this.zzl = CastUtils.optStringOrNull(jSONObject0, "entity");
        this.zzo = CastUtils.optStringOrNull(jSONObject0, "atvEntity");
        this.zzm = VastAdsRequest.fromJson(jSONObject0.optJSONObject("vmapAdsRequest"));
        if(jSONObject0.has("startAbsoluteTime") && !jSONObject0.isNull("startAbsoluteTime")) {
            double f1 = jSONObject0.optDouble("startAbsoluteTime");
            if(!Double.isNaN(f1) && !Double.isInfinite(f1) && f1 >= 0.0) {
                this.zzn = (long)(f1 * 1000.0);
            }
        }
        if(jSONObject0.has("contentUrl")) {
            this.zzp = jSONObject0.optString("contentUrl");
        }
        this.zzq = CastUtils.optStringOrNull(jSONObject0, "hlsSegmentFormat");
        this.zzr = CastUtils.optStringOrNull(jSONObject0, "hlsVideoSegmentFormat");
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof MediaInfo)) {
            return false;
        }
        JSONObject jSONObject0 = this.zzs;
        JSONObject jSONObject1 = ((MediaInfo)object0).zzs;
        if((jSONObject0 == null ? 1 : 0) != (jSONObject1 == null ? 1 : 0)) {
            return false;
        }
        return jSONObject0 == null || jSONObject1 == null || JsonUtils.areJsonValuesEquivalent(jSONObject0, jSONObject1) ? CastUtils.zze(this.zzc, ((MediaInfo)object0).zzc) && this.zzd == ((MediaInfo)object0).zzd && CastUtils.zze(this.zze, ((MediaInfo)object0).zze) && CastUtils.zze(this.zzf, ((MediaInfo)object0).zzf) && this.zzg == ((MediaInfo)object0).zzg && CastUtils.zze(this.zzh, ((MediaInfo)object0).zzh) && CastUtils.zze(this.zzi, ((MediaInfo)object0).zzi) && CastUtils.zze(this.zzj, ((MediaInfo)object0).zzj) && CastUtils.zze(this.zzk, ((MediaInfo)object0).zzk) && CastUtils.zze(this.zzl, ((MediaInfo)object0).zzl) && CastUtils.zze(this.zzm, ((MediaInfo)object0).zzm) && this.zzn == ((MediaInfo)object0).zzn && CastUtils.zze(this.zzo, ((MediaInfo)object0).zzo) && CastUtils.zze(this.zzp, ((MediaInfo)object0).zzp) && CastUtils.zze(this.zzq, ((MediaInfo)object0).zzq) && CastUtils.zze(this.zzr, ((MediaInfo)object0).zzr) : false;
    }

    public List getAdBreakClips() {
        return this.zzk == null ? null : Collections.unmodifiableList(this.zzk);
    }

    public List getAdBreaks() {
        return this.zzj == null ? null : Collections.unmodifiableList(this.zzj);
    }

    public String getContentId() {
        return this.zzc == null ? "" : this.zzc;
    }

    public String getContentType() {
        return this.zze;
    }

    public String getContentUrl() {
        return this.zzp;
    }

    public JSONObject getCustomData() {
        return this.zzs;
    }

    public String getEntity() {
        return this.zzl;
    }

    @HlsSegmentFormat
    public String getHlsSegmentFormat() {
        return this.zzq;
    }

    @HlsVideoSegmentFormat
    public String getHlsVideoSegmentFormat() {
        return this.zzr;
    }

    public List getMediaTracks() {
        return this.zzh;
    }

    public MediaMetadata getMetadata() {
        return this.zzf;
    }

    public long getStartAbsoluteTime() {
        return this.zzn;
    }

    public long getStreamDuration() {
        return this.zzg;
    }

    public int getStreamType() {
        return this.zzd;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.zzi;
    }

    public VastAdsRequest getVmapAdsRequest() {
        return this.zzm;
    }

    @KeepForSdk
    public Writer getWriter() {
        return this.zzt;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zzc, this.zzd, this.zze, this.zzf, this.zzg, String.valueOf(this.zzs), this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr});
    }

    public void setTextTrackStyle(TextTrackStyle textTrackStyle0) {
        this.zzi = textTrackStyle0;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        this.zzb = this.zzs == null ? null : this.zzs.toString();
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.getContentId(), false);
        SafeParcelWriter.writeInt(parcel0, 3, this.getStreamType());
        SafeParcelWriter.writeString(parcel0, 4, this.getContentType(), false);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.getMetadata(), v, false);
        SafeParcelWriter.writeLong(parcel0, 6, this.getStreamDuration());
        SafeParcelWriter.writeTypedList(parcel0, 7, this.getMediaTracks(), false);
        SafeParcelWriter.writeParcelable(parcel0, 8, this.getTextTrackStyle(), v, false);
        SafeParcelWriter.writeString(parcel0, 9, this.zzb, false);
        SafeParcelWriter.writeTypedList(parcel0, 10, this.getAdBreaks(), false);
        SafeParcelWriter.writeTypedList(parcel0, 11, this.getAdBreakClips(), false);
        SafeParcelWriter.writeString(parcel0, 12, this.getEntity(), false);
        SafeParcelWriter.writeParcelable(parcel0, 13, this.getVmapAdsRequest(), v, false);
        SafeParcelWriter.writeLong(parcel0, 14, this.getStartAbsoluteTime());
        SafeParcelWriter.writeString(parcel0, 15, this.zzo, false);
        SafeParcelWriter.writeString(parcel0, 16, this.getContentUrl(), false);
        SafeParcelWriter.writeString(parcel0, 17, this.getHlsSegmentFormat(), false);
        SafeParcelWriter.writeString(parcel0, 18, this.getHlsVideoSegmentFormat(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final JSONObject zza() {
        String s;
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("contentId", this.zzc);
            jSONObject0.putOpt("contentUrl", this.zzp);
            switch(this.zzd) {
                case 1: {
                    s = "BUFFERED";
                    break;
                }
                case 2: {
                    s = "LIVE";
                    break;
                }
                default: {
                    s = "NONE";
                }
            }
            jSONObject0.put("streamType", s);
            String s1 = this.zze;
            if(s1 != null) {
                jSONObject0.put("contentType", s1);
            }
            MediaMetadata mediaMetadata0 = this.zzf;
            if(mediaMetadata0 != null) {
                jSONObject0.put("metadata", mediaMetadata0.zza());
            }
            long v = this.zzg;
            if(Long.compare(v, -1L) <= 0) {
                jSONObject0.put("duration", JSONObject.NULL);
            }
            else {
                jSONObject0.put("duration", ((double)v) / 1000.0);
            }
            if(this.zzh != null) {
                JSONArray jSONArray0 = new JSONArray();
                for(Object object0: this.zzh) {
                    jSONArray0.put(((MediaTrack)object0).zza());
                }
                jSONObject0.put("tracks", jSONArray0);
            }
            TextTrackStyle textTrackStyle0 = this.zzi;
            if(textTrackStyle0 != null) {
                jSONObject0.put("textTrackStyle", textTrackStyle0.zza());
            }
            JSONObject jSONObject1 = this.zzs;
            if(jSONObject1 != null) {
                jSONObject0.put("customData", jSONObject1);
            }
            String s2 = this.zzl;
            if(s2 != null) {
                jSONObject0.put("entity", s2);
            }
            if(this.zzj != null) {
                JSONArray jSONArray1 = new JSONArray();
                for(Object object1: this.zzj) {
                    jSONArray1.put(((AdBreakInfo)object1).zza());
                }
                jSONObject0.put("breaks", jSONArray1);
            }
            if(this.zzk != null) {
                JSONArray jSONArray2 = new JSONArray();
                for(Object object2: this.zzk) {
                    jSONArray2.put(((AdBreakClipInfo)object2).zza());
                }
                jSONObject0.put("breakClips", jSONArray2);
            }
            VastAdsRequest vastAdsRequest0 = this.zzm;
            if(vastAdsRequest0 != null) {
                jSONObject0.put("vmapAdsRequest", vastAdsRequest0.zza());
            }
            long v1 = this.zzn;
            if(v1 != -1L) {
                jSONObject0.put("startAbsoluteTime", ((double)v1) / 1000.0);
            }
            jSONObject0.putOpt("atvEntity", this.zzo);
            String s3 = this.zzq;
            if(s3 != null) {
                jSONObject0.put("hlsSegmentFormat", s3);
            }
            String s4 = this.zzr;
            if(s4 != null) {
                jSONObject0.put("hlsVideoSegmentFormat", s4);
            }
        }
        catch(JSONException unused_ex) {
        }
        return jSONObject0;
    }

    public final void zzr(JSONObject jSONObject0) {
        AdBreakClipInfo adBreakClipInfo0;
        long v6;
        JSONObject jSONObject4;
        AdBreakInfo adBreakInfo0;
        if(jSONObject0.has("breaks")) {
            JSONArray jSONArray0 = jSONObject0.getJSONArray("breaks");
            ArrayList arrayList0 = new ArrayList(jSONArray0.length());
            int v = 0;
            while(v < jSONArray0.length()) {
                JSONObject jSONObject1 = jSONArray0.getJSONObject(v);
                if(jSONObject1 == null || (!jSONObject1.has("id") || !jSONObject1.has("position"))) {
                label_24:
                    adBreakInfo0 = null;
                }
                else {
                    try {
                        String s = jSONObject1.getString("id");
                        long v1 = CastUtils.secToMillisec(jSONObject1.getLong("position"));
                        boolean z = jSONObject1.optBoolean("isWatched");
                        long v2 = CastUtils.secToMillisec(jSONObject1.optLong("duration"));
                        JSONArray jSONArray1 = jSONObject1.optJSONArray("breakClipIds");
                        String[] arr_s = new String[0];
                        if(jSONArray1 != null) {
                            arr_s = new String[jSONArray1.length()];
                            for(int v3 = 0; v3 < jSONArray1.length(); ++v3) {
                                arr_s[v3] = jSONArray1.getString(v3);
                            }
                        }
                        adBreakInfo0 = new AdBreakInfo(v1, s, v2, z, arr_s, jSONObject1.optBoolean("isEmbedded"), jSONObject1.optBoolean("expanded"));
                        goto label_25;
                    }
                    catch(JSONException jSONException0) {
                    }
                    x.w("Error while creating an AdBreakInfo from JSON: ", jSONException0.getMessage(), "AdBreakInfo");
                    goto label_24;
                }
            label_25:
                if(adBreakInfo0 == null) {
                    arrayList0.clear();
                    this.zzj = new ArrayList(arrayList0);
                    goto label_34;
                }
                arrayList0.add(adBreakInfo0);
                ++v;
            }
            this.zzj = new ArrayList(arrayList0);
        }
    label_34:
        if(jSONObject0.has("breakClips")) {
            JSONArray jSONArray2 = jSONObject0.getJSONArray("breakClips");
            ArrayList arrayList1 = new ArrayList(jSONArray2.length());
            int v4 = 0;
            while(v4 < jSONArray2.length()) {
                JSONObject jSONObject2 = jSONArray2.getJSONObject(v4);
                if(jSONObject2 == null || !jSONObject2.has("id")) {
                label_64:
                    adBreakClipInfo0 = null;
                }
                else {
                    try {
                        String s1 = jSONObject2.getString("id");
                        long v5 = CastUtils.secToMillisec(jSONObject2.optLong("duration"));
                        String s2 = CastUtils.optStringOrNull(jSONObject2, "clickThroughUrl");
                        String s3 = CastUtils.optStringOrNull(jSONObject2, "contentUrl");
                        String s4 = CastUtils.optStringOrNull(jSONObject2, "mimeType");
                        if(s4 == null) {
                            s4 = CastUtils.optStringOrNull(jSONObject2, "contentType");
                        }
                        String s5 = CastUtils.optStringOrNull(jSONObject2, "title");
                        JSONObject jSONObject3 = jSONObject2.optJSONObject("customData");
                        String s6 = CastUtils.optStringOrNull(jSONObject2, "contentId");
                        String s7 = CastUtils.optStringOrNull(jSONObject2, "posterUrl");
                        if(jSONObject2.has("whenSkippable")) {
                            jSONObject4 = jSONObject3;
                            v6 = CastUtils.secToMillisec(((int)(((Integer)jSONObject2.get("whenSkippable")))));
                        }
                        else {
                            jSONObject4 = jSONObject3;
                            v6 = -1L;
                        }
                        String s8 = CastUtils.optStringOrNull(jSONObject2, "hlsSegmentFormat");
                        VastAdsRequest vastAdsRequest0 = VastAdsRequest.fromJson(jSONObject2.optJSONObject("vastAdsRequest"));
                        adBreakClipInfo0 = new AdBreakClipInfo(s1, s5, v5, s3, s4, s2, (jSONObject4 != null && jSONObject4.length() != 0 ? jSONObject4.toString() : null), s6, s7, v6, s8, vastAdsRequest0);
                        goto label_65;
                    }
                    catch(JSONException jSONException1) {
                    }
                    x.w("Error while creating an AdBreakClipInfo from JSON: ", jSONException1.getMessage(), "AdBreakClipInfo");
                    goto label_64;
                }
            label_65:
                if(adBreakClipInfo0 == null) {
                    arrayList1.clear();
                    if(true) {
                        break;
                    }
                }
                else {
                    arrayList1.add(adBreakClipInfo0);
                    ++v4;
                }
            }
            this.zzk = new ArrayList(arrayList1);
        }
    }
}

