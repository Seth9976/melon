package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
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

@Class(creator = "VastAdsRequestCreator")
@Reserved({1})
public class VastAdsRequest extends AbstractSafeParcelable {
    public static class Builder {
        private String zza;
        private String zzb;

        public VastAdsRequest build() {
            return new VastAdsRequest(this.zza, this.zzb);
        }

        public Builder setAdTagUrl(String s) {
            this.zza = s;
            return this;
        }

        public Builder setAdsResponse(String s) {
            this.zzb = s;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getAdTagUrl", id = 2)
    private final String zza;
    @Field(getter = "getAdsResponse", id = 3)
    private final String zzb;

    static {
        VastAdsRequest.CREATOR = new zzdr();
    }

    @Constructor
    public VastAdsRequest(@Param(id = 2) String s, @Param(id = 3) String s1) {
        this.zza = s;
        this.zzb = s1;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof VastAdsRequest ? CastUtils.zze(this.zza, ((VastAdsRequest)object0).zza) && CastUtils.zze(this.zzb, ((VastAdsRequest)object0).zzb) : false;
    }

    public static VastAdsRequest fromJson(JSONObject jSONObject0) {
        return jSONObject0 == null ? null : new VastAdsRequest(CastUtils.optStringOrNull(jSONObject0, "adTagUrl"), CastUtils.optStringOrNull(jSONObject0, "adsResponse"));
    }

    public String getAdTagUrl() {
        return this.zza;
    }

    public String getAdsResponse() {
        return this.zzb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb});
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.getAdTagUrl(), false);
        SafeParcelWriter.writeString(parcel0, 3, this.getAdsResponse(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final JSONObject zza() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            String s = this.zza;
            if(s != null) {
                jSONObject0.put("adTagUrl", s);
            }
            String s1 = this.zzb;
            if(s1 != null) {
                jSONObject0.put("adsResponse", s1);
            }
        }
        catch(JSONException unused_ex) {
        }
        return jSONObject0;
    }
}

