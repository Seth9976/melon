package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@ShowFirstParty
@Class(creator = "UserPreferredSleepWindowCreator")
@Reserved({1000})
public final class zzas extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getStartHour", id = 1)
    private final int zza;
    @Field(getter = "getStartMinute", id = 2)
    private final int zzb;
    @Field(getter = "getEndHour", id = 3)
    private final int zzc;
    @Field(getter = "getEndMinute", id = 4)
    private final int zzd;

    static {
        zzas.CREATOR = new zzat();
    }

    @Constructor
    public zzas(@Param(id = 1) int v, @Param(id = 2) int v1, @Param(id = 3) int v2, @Param(id = 4) int v3) {
        boolean z = true;
        Preconditions.checkState(v >= 0 && v <= 23, "Start hour must be in range [0, 23].");
        Preconditions.checkState(v1 >= 0 && v1 <= 59, "Start minute must be in range [0, 59].");
        Preconditions.checkState(v2 >= 0 && v2 <= 23, "End hour must be in range [0, 23].");
        Preconditions.checkState(v3 >= 0 && v3 <= 59, "End minute must be in range [0, 59].");
        if(v + v1 + v2 + v3 <= 0) {
            z = false;
        }
        Preconditions.checkState(z, "Parameters can\'t be all 0.");
        this.zza = v;
        this.zzb = v1;
        this.zzc = v2;
        this.zzd = v3;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzas ? this.zza == ((zzas)object0).zza && this.zzb == ((zzas)object0).zzb && this.zzc == ((zzas)object0).zzc && this.zzd == ((zzas)object0).zzd : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd});
    }

    @Override
    public final String toString() {
        return "UserPreferredSleepWindow [startHour=" + this.zza + ", startMinute=" + this.zzb + ", endHour=" + this.zzc + ", endMinute=" + this.zzd + "]";
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        Preconditions.checkNotNull(parcel0);
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zza);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel0, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

