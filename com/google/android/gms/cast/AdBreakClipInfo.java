package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.appcompat.app.o;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "AdBreakClipInfoCreator")
@Reserved({1})
public class AdBreakClipInfo extends AbstractSafeParcelable {
    public static class Builder {
        private final String zza;
        private String zzb;
        private long zzc;
        private String zzd;
        private String zze;
        private String zzf;
        private String zzg;
        private String zzh;
        private String zzi;
        private long zzj;
        @HlsSegmentFormat
        private String zzk;
        private VastAdsRequest zzl;

        public Builder(String s) {
            this.zzj = -1L;
            this.zza = s;
        }

        public AdBreakClipInfo build() {
            return new AdBreakClipInfo(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl);
        }

        public Builder setClickThroughUrl(String s) {
            this.zzf = s;
            return this;
        }

        public Builder setContentId(String s) {
            this.zzh = s;
            return this;
        }

        public Builder setContentUrl(String s) {
            this.zzd = s;
            return this;
        }

        public Builder setCustomDataJsonString(String s) {
            this.zzg = s;
            return this;
        }

        public Builder setDurationInMs(long v) {
            this.zzc = v;
            return this;
        }

        public Builder setHlsSegmentFormat(String s) {
            this.zzk = s;
            return this;
        }

        public Builder setImageUrl(String s) {
            this.zzi = s;
            return this;
        }

        public Builder setMimeType(String s) {
            this.zze = s;
            return this;
        }

        public Builder setTitle(String s) {
            this.zzb = s;
            return this;
        }

        public Builder setVastAdsRequest(VastAdsRequest vastAdsRequest0) {
            this.zzl = vastAdsRequest0;
            return this;
        }

        public Builder setWhenSkippableInMs(long v) {
            this.zzj = v;
            return this;
        }
    }

    public static final long AD_BREAK_CLIP_NOT_SKIPPABLE = -1L;
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getId", id = 2)
    private final String zza;
    @Field(getter = "getTitle", id = 3)
    private final String zzb;
    @Field(getter = "getDurationInMs", id = 4)
    private final long zzc;
    @Field(getter = "getContentUrl", id = 5)
    private final String zzd;
    @Field(getter = "getMimeType", id = 6)
    private final String zze;
    @Field(getter = "getClickThroughUrl", id = 7)
    private final String zzf;
    @Field(getter = "getCustomDataAsString", id = 8)
    private String zzg;
    @Field(getter = "getContentId", id = 9)
    private final String zzh;
    @Field(getter = "getImageUrl", id = 10)
    private final String zzi;
    @Field(getter = "getWhenSkippableInMs", id = 11)
    private final long zzj;
    @HlsSegmentFormat
    @Field(getter = "getHlsSegmentFormat", id = 12)
    private final String zzk;
    @Field(getter = "getVastAdsRequest", id = 13)
    private final VastAdsRequest zzl;
    private JSONObject zzm;

    static {
        AdBreakClipInfo.CREATOR = new zza();
    }

    @Constructor
    public AdBreakClipInfo(@Param(id = 2) String s, @Param(id = 3) String s1, @Param(id = 4) long v, @Param(id = 5) String s2, @Param(id = 6) String s3, @Param(id = 7) String s4, @Param(id = 8) String s5, @Param(id = 9) String s6, @Param(id = 10) String s7, @Param(id = 11) long v1, @HlsSegmentFormat @Param(id = 12) String s8, @Param(id = 13) VastAdsRequest vastAdsRequest0) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = v;
        this.zzd = s2;
        this.zze = s3;
        this.zzf = s4;
        this.zzg = s5;
        this.zzh = s6;
        this.zzi = s7;
        this.zzj = v1;
        this.zzk = s8;
        this.zzl = vastAdsRequest0;
        if(!TextUtils.isEmpty(s5)) {
            try {
                this.zzm = new JSONObject(this.zzg);
            }
            catch(JSONException jSONException0) {
                o.A("Error creating AdBreakClipInfo: ", jSONException0.getMessage(), "AdBreakClipInfo");
                this.zzg = null;
                this.zzm = new JSONObject();
            }
            return;
        }
        this.zzm = new JSONObject();
    }

    // 去混淆评级： 低(36)
    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof AdBreakClipInfo ? CastUtils.zze(this.zza, ((AdBreakClipInfo)object0).zza) && CastUtils.zze(this.zzb, ((AdBreakClipInfo)object0).zzb) && this.zzc == ((AdBreakClipInfo)object0).zzc && CastUtils.zze(this.zzd, ((AdBreakClipInfo)object0).zzd) && CastUtils.zze(this.zze, ((AdBreakClipInfo)object0).zze) && CastUtils.zze(this.zzf, ((AdBreakClipInfo)object0).zzf) && CastUtils.zze(this.zzg, ((AdBreakClipInfo)object0).zzg) && CastUtils.zze(this.zzh, ((AdBreakClipInfo)object0).zzh) && CastUtils.zze(this.zzi, ((AdBreakClipInfo)object0).zzi) && this.zzj == ((AdBreakClipInfo)object0).zzj && CastUtils.zze(this.zzk, ((AdBreakClipInfo)object0).zzk) && CastUtils.zze(this.zzl, ((AdBreakClipInfo)object0).zzl) : false;
    }

    public String getClickThroughUrl() {
        return this.zzf;
    }

    public String getContentId() {
        return this.zzh;
    }

    public String getContentUrl() {
        return this.zzd;
    }

    public JSONObject getCustomData() {
        return this.zzm;
    }

    public long getDurationInMs() {
        return this.zzc;
    }

    public String getHlsSegmentFormat() {
        return this.zzk;
    }

    public String getId() {
        return this.zza;
    }

    public String getImageUrl() {
        return this.zzi;
    }

    public String getMimeType() {
        return this.zze;
    }

    public String getTitle() {
        return this.zzb;
    }

    public VastAdsRequest getVastAdsRequest() {
        return this.zzl;
    }

    public long getWhenSkippableInMs() {
        return this.zzj;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl});
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.getId(), false);
        SafeParcelWriter.writeString(parcel0, 3, this.getTitle(), false);
        SafeParcelWriter.writeLong(parcel0, 4, this.getDurationInMs());
        SafeParcelWriter.writeString(parcel0, 5, this.getContentUrl(), false);
        SafeParcelWriter.writeString(parcel0, 6, this.getMimeType(), false);
        SafeParcelWriter.writeString(parcel0, 7, this.getClickThroughUrl(), false);
        SafeParcelWriter.writeString(parcel0, 8, this.zzg, false);
        SafeParcelWriter.writeString(parcel0, 9, this.getContentId(), false);
        SafeParcelWriter.writeString(parcel0, 10, this.getImageUrl(), false);
        SafeParcelWriter.writeLong(parcel0, 11, this.getWhenSkippableInMs());
        SafeParcelWriter.writeString(parcel0, 12, this.getHlsSegmentFormat(), false);
        SafeParcelWriter.writeParcelable(parcel0, 13, this.getVastAdsRequest(), v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final JSONObject zza() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("id", this.zza);
            jSONObject0.put("duration", ((double)this.zzc) / 1000.0);
            long v = this.zzj;
            if(v != -1L) {
                jSONObject0.put("whenSkippable", ((double)v) / 1000.0);
            }
            String s = this.zzh;
            if(s != null) {
                jSONObject0.put("contentId", s);
            }
            String s1 = this.zze;
            if(s1 != null) {
                jSONObject0.put("contentType", s1);
            }
            String s2 = this.zzb;
            if(s2 != null) {
                jSONObject0.put("title", s2);
            }
            String s3 = this.zzd;
            if(s3 != null) {
                jSONObject0.put("contentUrl", s3);
            }
            String s4 = this.zzf;
            if(s4 != null) {
                jSONObject0.put("clickThroughUrl", s4);
            }
            JSONObject jSONObject1 = this.zzm;
            if(jSONObject1 != null) {
                jSONObject0.put("customData", jSONObject1);
            }
            String s5 = this.zzi;
            if(s5 != null) {
                jSONObject0.put("posterUrl", s5);
            }
            String s6 = this.zzk;
            if(s6 != null) {
                jSONObject0.put("hlsSegmentFormat", s6);
            }
            VastAdsRequest vastAdsRequest0 = this.zzl;
            if(vastAdsRequest0 != null) {
                jSONObject0.put("vastAdsRequest", vastAdsRequest0.zza());
            }
        }
        catch(JSONException unused_ex) {
        }
        return jSONObject0;
    }
}

