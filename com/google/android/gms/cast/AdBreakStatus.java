package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
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

@Class(creator = "AdBreakStatusCreator")
@Reserved({1})
public class AdBreakStatus extends AbstractSafeParcelable {
    public static class Builder {
        private long zza;
        private long zzb;
        private String zzc;
        private String zzd;
        private long zze;

        public Builder() {
            this.zze = -1L;
        }

        public AdBreakStatus build() {
            return new AdBreakStatus(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }

        public Builder setBreakClipId(String s) {
            this.zzd = s;
            return this;
        }

        public Builder setBreakId(String s) {
            this.zzc = s;
            return this;
        }

        public Builder setCurrentBreakClipTimeInMs(long v) {
            this.zzb = v;
            return this;
        }

        public Builder setCurrentBreakTimeInMs(long v) {
            this.zza = v;
            return this;
        }

        public Builder setWhenSkippableInMs(long v) {
            this.zze = v;
            return this;
        }
    }

    @Deprecated
    public static final int AD_BREAK_CLIP_NOT_SKIPPABLE = -1;
    public static final Parcelable.Creator CREATOR;
    private static final Logger zza;
    @Field(getter = "getCurrentBreakTimeInMs", id = 2)
    private final long zzb;
    @Field(getter = "getCurrentBreakClipTimeInMs", id = 3)
    private final long zzc;
    @Field(getter = "getBreakId", id = 4)
    private final String zzd;
    @Field(getter = "getBreakClipId", id = 5)
    private final String zze;
    @Field(getter = "getWhenSkippableInMs", id = 6)
    private final long zzf;

    static {
        AdBreakStatus.zza = new Logger("AdBreakStatus");
        AdBreakStatus.CREATOR = new zzc();
    }

    @Constructor
    public AdBreakStatus(@Param(id = 2) long v, @Param(id = 3) long v1, @Param(id = 4) String s, @Param(id = 5) String s1, @Param(id = 6) long v2) {
        this.zzb = v;
        this.zzc = v1;
        this.zzd = s;
        this.zze = s1;
        this.zzf = v2;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof AdBreakStatus ? this.zzb == ((AdBreakStatus)object0).zzb && this.zzc == ((AdBreakStatus)object0).zzc && CastUtils.zze(this.zzd, ((AdBreakStatus)object0).zzd) && CastUtils.zze(this.zze, ((AdBreakStatus)object0).zze) && this.zzf == ((AdBreakStatus)object0).zzf : false;
    }

    public String getBreakClipId() {
        return this.zze;
    }

    public String getBreakId() {
        return this.zzd;
    }

    public long getCurrentBreakClipTimeInMs() {
        return this.zzc;
    }

    public long getCurrentBreakTimeInMs() {
        return this.zzb;
    }

    public long getWhenSkippableInMs() {
        return this.zzf;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zzb, this.zzc, this.zzd, this.zze, this.zzf});
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeLong(parcel0, 2, this.getCurrentBreakTimeInMs());
        SafeParcelWriter.writeLong(parcel0, 3, this.getCurrentBreakClipTimeInMs());
        SafeParcelWriter.writeString(parcel0, 4, this.getBreakId(), false);
        SafeParcelWriter.writeString(parcel0, 5, this.getBreakClipId(), false);
        SafeParcelWriter.writeLong(parcel0, 6, this.getWhenSkippableInMs());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static AdBreakStatus zza(JSONObject jSONObject0) {
        if(jSONObject0 == null) {
            return null;
        }
        if(jSONObject0.has("currentBreakTime") && jSONObject0.has("currentBreakClipTime")) {
            try {
                long v = CastUtils.secToMillisec(jSONObject0.getLong("currentBreakTime"));
                long v1 = CastUtils.secToMillisec(jSONObject0.getLong("currentBreakClipTime"));
                String s = CastUtils.optStringOrNull(jSONObject0, "breakId");
                String s1 = CastUtils.optStringOrNull(jSONObject0, "breakClipId");
                long v2 = jSONObject0.optLong("whenSkippable", -1L);
                if(v2 != -1L) {
                    v2 *= 1000L;
                }
                return new AdBreakStatus(v, v1, s, s1, v2);
            }
            catch(JSONException jSONException0) {
                AdBreakStatus.zza.e(jSONException0, "Error while creating an AdBreakClipInfo from JSON", new Object[0]);
            }
        }
        return null;
    }

    public final JSONObject zzb() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("currentBreakTime", ((double)this.zzb) / 1000.0);
            jSONObject0.put("currentBreakClipTime", ((double)this.zzc) / 1000.0);
            jSONObject0.putOpt("breakId", this.zzd);
            jSONObject0.putOpt("breakClipId", this.zze);
            long v = this.zzf;
            if(v != -1L) {
                jSONObject0.put("whenSkippable", ((double)v) / 1000.0);
                return jSONObject0;
            }
            return jSONObject0;
        }
        catch(JSONException jSONException0) {
            AdBreakStatus.zza.e(jSONException0, "Error transforming AdBreakStatus into JSONObject", new Object[0]);
            return new JSONObject();
        }
    }
}

