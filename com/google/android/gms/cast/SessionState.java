package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.JsonUtils;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "SessionStateCreator")
@Reserved({1})
public class SessionState extends AbstractSafeParcelable {
    public static class Builder {
        private MediaLoadRequestData zza;
        private JSONObject zzb;

        public SessionState build() {
            return new SessionState(this.zza, this.zzb);
        }

        public Builder setCustomData(JSONObject jSONObject0) {
            this.zzb = jSONObject0;
            return this;
        }

        public Builder setLoadRequestData(MediaLoadRequestData mediaLoadRequestData0) {
            this.zza = mediaLoadRequestData0;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    @Field(id = 3)
    String zza;
    @Field(getter = "getLoadRequestData", id = 2)
    private final MediaLoadRequestData zzb;
    private final JSONObject zzc;

    static {
        SessionState.CREATOR = new zzdp();
    }

    public SessionState(MediaLoadRequestData mediaLoadRequestData0, JSONObject jSONObject0) {
        this.zzb = mediaLoadRequestData0;
        this.zzc = jSONObject0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof SessionState)) {
            return false;
        }
        return JsonUtils.areJsonValuesEquivalent(this.zzc, ((SessionState)object0).zzc) ? Objects.equal(this.zzb, ((SessionState)object0).zzb) : false;
    }

    @KeepForSdk
    public static SessionState fromJson(JSONObject jSONObject0) {
        JSONObject jSONObject1 = jSONObject0.optJSONObject("loadRequestData");
        return jSONObject1 == null ? new SessionState(null, jSONObject0.optJSONObject("customData")) : new SessionState(MediaLoadRequestData.fromJson(jSONObject1), jSONObject0.optJSONObject("customData"));
    }

    public JSONObject getCustomData() {
        return this.zzc;
    }

    public MediaLoadRequestData getLoadRequestData() {
        return this.zzb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zzb, String.valueOf(this.zzc)});
    }

    @KeepForSdk
    public JSONObject toJson() {
        try {
            JSONObject jSONObject0 = new JSONObject();
            MediaLoadRequestData mediaLoadRequestData0 = this.zzb;
            if(mediaLoadRequestData0 != null) {
                jSONObject0.put("loadRequestData", mediaLoadRequestData0.toJson());
            }
            jSONObject0.put("customData", this.zzc);
            return jSONObject0;
        }
        catch(JSONException unused_ex) {
            return null;
        }
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        this.zza = this.zzc == null ? null : this.zzc.toString();
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.getLoadRequestData(), v, false);
        SafeParcelWriter.writeString(parcel0, 3, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

