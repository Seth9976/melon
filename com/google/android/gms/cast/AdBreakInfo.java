package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "AdBreakInfoCreator")
@Reserved({1})
public class AdBreakInfo extends AbstractSafeParcelable {
    public static class Builder {
        private final long zza;
        private String zzb;
        private long zzc;
        private boolean zzd;
        private boolean zze;
        private String[] zzf;
        private boolean zzg;

        public Builder(long v) {
            this.zza = v;
        }

        public AdBreakInfo build() {
            return new AdBreakInfo(this.zza, this.zzb, this.zzc, this.zzd, this.zzf, this.zze, this.zzg);
        }

        public Builder setBreakClipIds(String[] arr_s) {
            this.zzf = arr_s;
            return this;
        }

        public Builder setDurationInMs(long v) {
            this.zzc = v;
            return this;
        }

        public Builder setId(String s) {
            this.zzb = s;
            return this;
        }

        public Builder setIsEmbedded(boolean z) {
            this.zze = z;
            return this;
        }

        @KeepForSdk
        public Builder setIsExpanded(boolean z) {
            this.zzg = z;
            return this;
        }

        public Builder setIsWatched(boolean z) {
            this.zzd = z;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getPlaybackPositionInMs", id = 2)
    private final long zza;
    @Field(getter = "getId", id = 3)
    private final String zzb;
    @Field(getter = "getDurationInMs", id = 4)
    private final long zzc;
    @Field(getter = "isWatched", id = 5)
    private final boolean zzd;
    @Field(getter = "getBreakClipIds", id = 6)
    private final String[] zze;
    @Field(getter = "isEmbedded", id = 7)
    private final boolean zzf;
    @Field(getter = "isExpanded", id = 8)
    private final boolean zzg;

    static {
        AdBreakInfo.CREATOR = new zzb();
    }

    @Constructor
    public AdBreakInfo(@Param(id = 2) long v, @Param(id = 3) String s, @Param(id = 4) long v1, @Param(id = 5) boolean z, @Param(id = 6) String[] arr_s, @Param(id = 7) boolean z1, @Param(id = 8) boolean z2) {
        this.zza = v;
        this.zzb = s;
        this.zzc = v1;
        this.zzd = z;
        this.zze = arr_s;
        this.zzf = z1;
        this.zzg = z2;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof AdBreakInfo ? CastUtils.zze(this.zzb, ((AdBreakInfo)object0).zzb) && this.zza == ((AdBreakInfo)object0).zza && this.zzc == ((AdBreakInfo)object0).zzc && this.zzd == ((AdBreakInfo)object0).zzd && Arrays.equals(this.zze, ((AdBreakInfo)object0).zze) && this.zzf == ((AdBreakInfo)object0).zzf && this.zzg == ((AdBreakInfo)object0).zzg : false;
    }

    public String[] getBreakClipIds() {
        return this.zze;
    }

    public long getDurationInMs() {
        return this.zzc;
    }

    public String getId() {
        return this.zzb;
    }

    public long getPlaybackPositionInMs() {
        return this.zza;
    }

    @Override
    public int hashCode() {
        return this.zzb.hashCode();
    }

    public boolean isEmbedded() {
        return this.zzf;
    }

    @KeepForSdk
    public boolean isExpanded() {
        return this.zzg;
    }

    public boolean isWatched() {
        return this.zzd;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeLong(parcel0, 2, this.getPlaybackPositionInMs());
        SafeParcelWriter.writeString(parcel0, 3, this.getId(), false);
        SafeParcelWriter.writeLong(parcel0, 4, this.getDurationInMs());
        SafeParcelWriter.writeBoolean(parcel0, 5, this.isWatched());
        SafeParcelWriter.writeStringArray(parcel0, 6, this.getBreakClipIds(), false);
        SafeParcelWriter.writeBoolean(parcel0, 7, this.isEmbedded());
        SafeParcelWriter.writeBoolean(parcel0, 8, this.isExpanded());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final JSONObject zza() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("id", this.zzb);
            jSONObject0.put("position", ((double)this.zza) / 1000.0);
            jSONObject0.put("isWatched", this.zzd);
            jSONObject0.put("isEmbedded", this.zzf);
            jSONObject0.put("duration", ((double)this.zzc) / 1000.0);
            jSONObject0.put("expanded", this.zzg);
            String[] arr_s = this.zze;
            if(arr_s != null) {
                JSONArray jSONArray0 = new JSONArray();
                for(int v = 0; v < arr_s.length; ++v) {
                    jSONArray0.put(arr_s[v]);
                }
                jSONObject0.put("breakClipIds", jSONArray0);
            }
        }
        catch(JSONException unused_ex) {
        }
        return jSONObject0;
    }
}

