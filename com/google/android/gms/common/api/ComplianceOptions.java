package com.google.android.gms.common.api;

import android.content.Context;
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

@KeepForSdk
@Class(creator = "ComplianceOptionsCreator")
public final class ComplianceOptions extends AbstractSafeParcelable {
    @KeepForSdk
    public static final class Builder {
        private int zza;
        private int zzb;
        private int zzc;
        private boolean zzd;

        public Builder() {
            this.zza = -1;
            this.zzb = -1;
            this.zzc = 0;
            this.zzd = true;
        }

        @KeepForSdk
        public ComplianceOptions build() {
            return new ComplianceOptions(this.zza, this.zzb, this.zzc, this.zzd);
        }

        @KeepForSdk
        public Builder setCallerProductId(int v) {
            this.zza = v;
            return this;
        }

        @KeepForSdk
        public Builder setDataOwnerProductId(int v) {
            this.zzb = v;
            return this;
        }

        @KeepForSdk
        public Builder setIsUserData(boolean z) {
            this.zzd = z;
            return this;
        }

        @KeepForSdk
        public Builder setProcessingReason(int v) {
            this.zzc = v;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    public static final ComplianceOptions zza;
    @Field(getter = "getCallerProductId", id = 1)
    private final int zzb;
    @Field(getter = "getDataOwnerProductId", id = 2)
    private final int zzc;
    @Field(getter = "getProcessingReason", id = 3)
    private final int zzd;
    @Field(defaultValue = "true", getter = "isUserData", id = 4)
    private final boolean zze;

    static {
        Builder complianceOptions$Builder0 = ComplianceOptions.newBuilder();
        complianceOptions$Builder0.setCallerProductId(-1);
        complianceOptions$Builder0.setDataOwnerProductId(-1);
        complianceOptions$Builder0.setProcessingReason(0);
        complianceOptions$Builder0.setIsUserData(true);
        ComplianceOptions.zza = complianceOptions$Builder0.build();
        ComplianceOptions.CREATOR = new zzc();
    }

    @Constructor
    public ComplianceOptions(@Param(id = 1) int v, @Param(id = 2) int v1, @Param(id = 3) int v2, @Param(id = 4) boolean z) {
        this.zzb = v;
        this.zzc = v1;
        this.zzd = v2;
        this.zze = z;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof ComplianceOptions ? this.zzb == ((ComplianceOptions)object0).zzb && this.zzc == ((ComplianceOptions)object0).zzc && this.zzd == ((ComplianceOptions)object0).zzd && this.zze == ((ComplianceOptions)object0).zze : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzb, this.zzc, this.zzd, Boolean.valueOf(this.zze)});
    }

    @KeepForSdk
    public static Builder newBuilder() {
        return new Builder();
    }

    @KeepForSdk
    public static final Builder newBuilder(Context context0) {
        return ComplianceOptions.newBuilder();
    }

    @KeepForSdk
    public Builder toBuilder() {
        Builder complianceOptions$Builder0 = new Builder();
        complianceOptions$Builder0.setCallerProductId(this.zzb);
        complianceOptions$Builder0.setDataOwnerProductId(this.zzc);
        complianceOptions$Builder0.setProcessingReason(this.zzd);
        complianceOptions$Builder0.setIsUserData(this.zze);
        return complianceOptions$Builder0;
    }

    @Override
    public final String toString() {
        return "ComplianceOptions{callerProductId=" + this.zzb + ", dataOwnerProductId=" + this.zzc + ", processingReason=" + this.zzd + ", isUserData=" + this.zze + "}";
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zzb);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzc);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzd);
        SafeParcelWriter.writeBoolean(parcel0, 4, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

