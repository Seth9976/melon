package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import org.json.JSONObject;

@Class(creator = "CredentialsDataCreator")
public class CredentialsData extends AbstractSafeParcelable {
    public static class Builder {
        private String zza;
        private String zzb;

        public Builder() {
            this.zzb = "android";
        }

        public CredentialsData build() {
            return new CredentialsData(this.zza, this.zzb);
        }

        public Builder setCredentials(String s) {
            this.zza = s;
            return this;
        }

        public Builder setCredentialsType(String s) {
            this.zzb = s;
            return this;
        }
    }

    @KeepForSdk
    public static final Parcelable.Creator CREATOR = null;
    public static final String CREDENTIALS_TYPE_ANDROID = "android";
    public static final String CREDENTIALS_TYPE_CLOUD = "cloud";
    public static final String CREDENTIALS_TYPE_IOS = "ios";
    public static final String CREDENTIALS_TYPE_WEB = "web";
    @Field(getter = "getCredentials", id = 1)
    private final String zza;
    @Field(getter = "getCredentialsType", id = 2)
    private final String zzb;

    static {
        CredentialsData.CREATOR = new zzaq();
    }

    @Constructor
    public CredentialsData(@Param(id = 1) String s, @Param(id = 2) String s1) {
        this.zza = s;
        this.zzb = s1;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof CredentialsData ? Objects.equal(this.zza, ((CredentialsData)object0).zza) && Objects.equal(this.zzb, ((CredentialsData)object0).zzb) : false;
    }

    @KeepForSdk
    public static CredentialsData fromJson(JSONObject jSONObject0) {
        return jSONObject0 == null ? null : new CredentialsData(CastUtils.optStringOrNull(jSONObject0, "credentials"), CastUtils.optStringOrNull(jSONObject0, "credentialsType"));
    }

    public String getCredentials() {
        return this.zza;
    }

    public String getCredentialsType() {
        return this.zzb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb});
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.getCredentials(), false);
        SafeParcelWriter.writeString(parcel0, 2, this.getCredentialsType(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

