package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.location.zzer;
import org.checkerframework.dataflow.qual.Pure;

@Class(creator = "DeviceOrientationRequestCreator")
@Reserved({1, 3, 4, 5})
public final class DeviceOrientationRequest extends AbstractSafeParcelable {
    public static final class Builder {
        private long zza;
        private final boolean zzb;

        public Builder(long v) {
            this.zzb = false;
            this.setSamplingPeriodMicros(v);
        }

        public Builder(DeviceOrientationRequest deviceOrientationRequest0) {
            this.zza = deviceOrientationRequest0.zza();
            this.zzb = deviceOrientationRequest0.zzb();
        }

        public DeviceOrientationRequest build() {
            return new DeviceOrientationRequest(this.zza, this.zzb);
        }

        public Builder setSamplingPeriodMicros(long v) {
            zzer.zzb(Long.compare(v, 0L) >= 0 && v < 0x7FFFFFFFFFFFFFFFL, "Invalid interval: " + v + " should be greater than or equal to 0. Note: Long.MAX_VALUE is not a valid interval.");
            this.zza = v;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR = null;
    public static final long OUTPUT_PERIOD_DEFAULT = 20000L;
    public static final long OUTPUT_PERIOD_FAST = 5000L;
    public static final long OUTPUT_PERIOD_MEDIUM = 10000L;
    @Field(getter = "getSamplingPeriodMicros", id = 2)
    private final long zza;
    @Field(defaultValueUnchecked = "false", getter = "isVelocityEnabled", id = 6)
    private final boolean zzb;

    static {
        DeviceOrientationRequest.CREATOR = new zzn();
    }

    @Constructor
    public DeviceOrientationRequest(@Param(id = 2) long v, @Param(id = 6) boolean z) {
        this.zza = v;
        this.zzb = z;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof DeviceOrientationRequest ? this.zza == ((DeviceOrientationRequest)object0).zza && this.zzb == ((DeviceOrientationRequest)object0).zzb : false;
    }

    @Pure
    public long getSamplingPeriodMicros() {
        return this.zza;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, Boolean.valueOf(this.zzb)});
    }

    @Override
    public String toString() {
        String.valueOf(this.zza).length();
        return this.zzb ? "DeviceOrientationRequest[samplingPeriodMicros=" + this.zza + ", withVelocity" + "]" : "DeviceOrientationRequest[samplingPeriodMicros=" + this.zza + "" + "]";
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeLong(parcel0, 2, this.getSamplingPeriodMicros());
        SafeParcelWriter.writeBoolean(parcel0, 6, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final long zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return this.zzb;
    }
}

