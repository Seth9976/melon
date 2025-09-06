package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import k8.Y;

@KeepForSdk
@Class(creator = "ApiMetadataCreator")
public final class ApiMetadata extends AbstractSafeParcelable {
    @KeepForSdk
    public static final class Builder {
        private ComplianceOptions zza;
        private boolean zzb;

        @KeepForSdk
        public ApiMetadata build() {
            ApiMetadata apiMetadata0 = new ApiMetadata(this.zza);
            apiMetadata0.zza(this.zzb);
            return apiMetadata0;
        }

        @KeepForSdk
        public Builder setComplianceOptions(ComplianceOptions complianceOptions0) {
            this.zza = complianceOptions0;
            return this;
        }

        public final Builder zza(boolean z) {
            this.zzb = true;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    public static final ApiMetadata zza;
    private static final ApiMetadata zzb;
    @Field(getter = "getComplianceOptions", id = 1)
    private final ComplianceOptions zzc;
    private boolean zzd;

    static {
        ApiMetadata.CREATOR = zza.zza();
        ApiMetadata.zzb = ApiMetadata.newBuilder().build();
        Builder apiMetadata$Builder0 = ApiMetadata.newBuilder();
        apiMetadata$Builder0.zza(true);
        ApiMetadata.zza = apiMetadata$Builder0.build();
    }

    @Constructor
    public ApiMetadata(@Param(id = 1) ComplianceOptions complianceOptions0) {
        this.zzc = complianceOptions0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof ApiMetadata ? Objects.equal(this.zzc, ((ApiMetadata)object0).zzc) && this.zzd == ((ApiMetadata)object0).zzd : false;
    }

    @KeepForSdk
    public static final ApiMetadata fromComplianceOptions(ComplianceOptions complianceOptions0) {
        Builder apiMetadata$Builder0 = ApiMetadata.newBuilder();
        apiMetadata$Builder0.setComplianceOptions(complianceOptions0);
        return apiMetadata$Builder0.build();
    }

    @KeepForSdk
    public static final ApiMetadata getEmptyInstance() {
        return ApiMetadata.zzb;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzc, Boolean.valueOf(this.zzd)});
    }

    @KeepForSdk
    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public final String toString() {
        String s = String.valueOf(this.zzc);
        return Y.l(new StringBuilder(s.length() + 0x1F), "ApiMetadata(complianceOptions=", s, ")");
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        if(this.zzd) {
            parcel0.setDataPosition(parcel0.dataPosition() - 4);
            parcel0.setDataSize(parcel0.dataSize() - 4);
            return;
        }
        parcel0.writeInt(-204102970);
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.zzc, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final void zza(boolean z) {
        this.zzd = z;
    }
}

