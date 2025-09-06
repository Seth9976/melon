package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.WorkSource;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zze;
import com.google.android.gms.internal.location.zzeo;
import k8.Y;
import org.checkerframework.dataflow.qual.Pure;

@Class(creator = "CurrentLocationRequestCreator")
@Reserved({8})
public final class CurrentLocationRequest extends AbstractSafeParcelable {
    public static final class Builder {
        private long zza;
        private int zzb;
        private int zzc;
        private long zzd;
        private final boolean zze;
        private final int zzf;
        private final WorkSource zzg;
        private final zze zzh;

        public Builder() {
            this.zza = 10000L;
            this.zzb = 0;
            this.zzc = 102;
            this.zzd = 0x7FFFFFFFFFFFFFFFL;
            this.zze = false;
            this.zzf = 0;
            this.zzg = null;
            this.zzh = null;
        }

        public Builder(CurrentLocationRequest currentLocationRequest0) {
            this.zza = currentLocationRequest0.getMaxUpdateAgeMillis();
            this.zzb = currentLocationRequest0.getGranularity();
            this.zzc = currentLocationRequest0.getPriority();
            this.zzd = currentLocationRequest0.getDurationMillis();
            this.zze = currentLocationRequest0.zza();
            this.zzf = currentLocationRequest0.zzb();
            this.zzg = new WorkSource(currentLocationRequest0.zzc());
            this.zzh = currentLocationRequest0.zzd();
        }

        public CurrentLocationRequest build() {
            long v = this.zza;
            int v1 = this.zzb;
            int v2 = this.zzc;
            long v3 = this.zzd;
            WorkSource workSource0 = new WorkSource(this.zzg);
            return new CurrentLocationRequest(v, v1, v2, v3, this.zze, this.zzf, workSource0, this.zzh);
        }

        public Builder setDurationMillis(long v) {
            Preconditions.checkArgument(v > 0L, "durationMillis must be greater than 0");
            this.zzd = v;
            return this;
        }

        public Builder setGranularity(int v) {
            zzq.zza(v);
            this.zzb = v;
            return this;
        }

        public Builder setMaxUpdateAgeMillis(long v) {
            Preconditions.checkArgument(v >= 0L, "maxUpdateAgeMillis must be greater than or equal to 0");
            this.zza = v;
            return this;
        }

        public Builder setPriority(int v) {
            zzan.zza(v);
            this.zzc = v;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    @Field(defaultValueUnchecked = "Long.MAX_VALUE", getter = "getMaxUpdateAgeMillis", id = 1)
    private final long zza;
    @Field(defaultValueUnchecked = "Granularity.GRANULARITY_PERMISSION_LEVEL", getter = "getGranularity", id = 2)
    private final int zzb;
    @Field(defaultValueUnchecked = "Priority.PRIORITY_BALANCED_POWER_ACCURACY", getter = "getPriority", id = 3)
    private final int zzc;
    @Field(defaultValueUnchecked = "Long.MAX_VALUE", getter = "getDurationMillis", id = 4)
    private final long zzd;
    @Field(defaultValue = "false", getter = "isBypass", id = 5)
    private final boolean zze;
    @Field(defaultValueUnchecked = "ThrottleBehavior.THROTTLE_BACKGROUND", getter = "getThrottleBehavior", id = 7)
    private final int zzf;
    @Field(defaultValueUnchecked = "new android.os.WorkSource()", getter = "getWorkSource", id = 6)
    private final WorkSource zzg;
    @Field(getter = "getImpersonation", id = 9)
    private final zze zzh;

    static {
        CurrentLocationRequest.CREATOR = new zzj();
    }

    @Constructor
    public CurrentLocationRequest(@Param(id = 1) long v, @Param(id = 2) int v1, @Param(id = 3) int v2, @Param(id = 4) long v3, @Param(id = 5) boolean z, @Param(id = 7) int v4, @Param(id = 6) WorkSource workSource0, @Param(id = 9) zze zze0) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = v2;
        this.zzd = v3;
        this.zze = z;
        this.zzf = v4;
        this.zzg = workSource0;
        this.zzh = zze0;
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof CurrentLocationRequest ? this.zza == ((CurrentLocationRequest)object0).zza && this.zzb == ((CurrentLocationRequest)object0).zzb && this.zzc == ((CurrentLocationRequest)object0).zzc && this.zzd == ((CurrentLocationRequest)object0).zzd && this.zze == ((CurrentLocationRequest)object0).zze && this.zzf == ((CurrentLocationRequest)object0).zzf && Objects.equal(this.zzg, ((CurrentLocationRequest)object0).zzg) && Objects.equal(this.zzh, ((CurrentLocationRequest)object0).zzh) : false;
    }

    @Pure
    public long getDurationMillis() {
        return this.zzd;
    }

    @Pure
    public int getGranularity() {
        return this.zzb;
    }

    @Pure
    public long getMaxUpdateAgeMillis() {
        return this.zza;
    }

    @Pure
    public int getPriority() {
        return this.zzc;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd});
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = Y.p("CurrentLocationRequest[");
        stringBuilder0.append(zzan.zzb(this.zzc));
        if(this.zza != 0x7FFFFFFFFFFFFFFFL) {
            stringBuilder0.append(", maxAge=");
            zzeo.zzc(this.zza, stringBuilder0);
        }
        if(this.zzd != 0x7FFFFFFFFFFFFFFFL) {
            stringBuilder0.append(", duration=");
            stringBuilder0.append(this.zzd);
            stringBuilder0.append("ms");
        }
        if(this.zzb != 0) {
            stringBuilder0.append(", ");
            stringBuilder0.append(zzq.zzb(this.zzb));
        }
        if(this.zze) {
            stringBuilder0.append(", bypass");
        }
        if(this.zzf != 0) {
            stringBuilder0.append(", ");
            stringBuilder0.append(zzar.zzb(this.zzf));
        }
        if(!WorkSourceUtil.isEmpty(this.zzg)) {
            stringBuilder0.append(", workSource=");
            stringBuilder0.append(this.zzg);
        }
        if(this.zzh != null) {
            stringBuilder0.append(", impersonation=");
            stringBuilder0.append(this.zzh);
        }
        stringBuilder0.append(']');
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeLong(parcel0, 1, this.getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel0, 2, this.getGranularity());
        SafeParcelWriter.writeInt(parcel0, 3, this.getPriority());
        SafeParcelWriter.writeLong(parcel0, 4, this.getDurationMillis());
        SafeParcelWriter.writeBoolean(parcel0, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel0, 6, this.zzg, v, false);
        SafeParcelWriter.writeInt(parcel0, 7, this.zzf);
        SafeParcelWriter.writeParcelable(parcel0, 9, this.zzh, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Pure
    public final boolean zza() {
        return this.zze;
    }

    @Pure
    public final int zzb() {
        return this.zzf;
    }

    @Pure
    public final WorkSource zzc() {
        return this.zzg;
    }

    @Pure
    public final zze zzd() {
        return this.zzh;
    }
}

