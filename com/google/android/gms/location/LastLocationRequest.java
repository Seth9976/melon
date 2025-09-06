package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.location.zze;
import com.google.android.gms.internal.location.zzeo;
import k8.Y;
import org.checkerframework.dataflow.qual.Pure;

@Class(creator = "LastLocationRequestCreator")
@Reserved({4})
public final class LastLocationRequest extends AbstractSafeParcelable {
    public static final class Builder {
        private long zza;
        private int zzb;
        private final boolean zzc;
        private final zze zzd;

        public Builder() {
            this.zza = 0x7FFFFFFFFFFFFFFFL;
            this.zzb = 0;
            this.zzc = false;
            this.zzd = null;
        }

        public Builder(LastLocationRequest lastLocationRequest0) {
            this.zza = lastLocationRequest0.getMaxUpdateAgeMillis();
            this.zzb = lastLocationRequest0.getGranularity();
            this.zzc = lastLocationRequest0.zza();
            this.zzd = lastLocationRequest0.zzb();
        }

        public LastLocationRequest build() {
            return new LastLocationRequest(this.zza, this.zzb, this.zzc, this.zzd);
        }

        public Builder setGranularity(int v) {
            zzq.zza(v);
            this.zzb = v;
            return this;
        }

        public Builder setMaxUpdateAgeMillis(long v) {
            Preconditions.checkArgument(v > 0L, "maxUpdateAgeMillis must be greater than 0");
            this.zza = v;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    @Field(defaultValueUnchecked = "Long.MAX_VALUE", getter = "getMaxUpdateAgeMillis", id = 1)
    private final long zza;
    @Field(defaultValueUnchecked = "com.google.android.gms.location.Granularity.GRANULARITY_PERMISSION_LEVEL", getter = "getGranularity", id = 2)
    private final int zzb;
    @Field(defaultValue = "false", getter = "isBypass", id = 3)
    private final boolean zzc;
    @Field(getter = "getImpersonation", id = 5)
    private final zze zzd;

    static {
        LastLocationRequest.CREATOR = new zzaa();
    }

    @Constructor
    public LastLocationRequest(@Param(id = 1) long v, @Param(id = 2) int v1, @Param(id = 3) boolean z, @Param(id = 5) zze zze0) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = z;
        this.zzd = zze0;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof LastLocationRequest ? this.zza == ((LastLocationRequest)object0).zza && this.zzb == ((LastLocationRequest)object0).zzb && this.zzc == ((LastLocationRequest)object0).zzc && Objects.equal(this.zzd, ((LastLocationRequest)object0).zzd) : false;
    }

    @Pure
    public int getGranularity() {
        return this.zzb;
    }

    @Pure
    public long getMaxUpdateAgeMillis() {
        return this.zza;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, Boolean.valueOf(this.zzc)});
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = Y.p("LastLocationRequest[");
        if(this.zza != 0x7FFFFFFFFFFFFFFFL) {
            stringBuilder0.append("maxAge=");
            zzeo.zzc(this.zza, stringBuilder0);
        }
        if(this.zzb != 0) {
            stringBuilder0.append(", ");
            stringBuilder0.append(zzq.zzb(this.zzb));
        }
        if(this.zzc) {
            stringBuilder0.append(", bypass");
        }
        if(this.zzd != null) {
            stringBuilder0.append(", impersonation=");
            stringBuilder0.append(this.zzd);
        }
        stringBuilder0.append(']');
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeLong(parcel0, 1, this.getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel0, 2, this.getGranularity());
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzc);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.zzd, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Pure
    public final boolean zza() {
        return this.zzc;
    }

    @Pure
    public final zze zzb() {
        return this.zzd;
    }
}

