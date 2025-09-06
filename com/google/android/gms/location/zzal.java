package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.iloen.melon.utils.a;

@ShowFirstParty
@Class(creator = "NetworkLocationStatusCreator")
@Deprecated
public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(defaultValueUnchecked = "LocationAvailability.STATUS_UNKNOWN", id = 1)
    public final int zza;
    @Field(defaultValueUnchecked = "LocationAvailability.STATUS_UNKNOWN", id = 2)
    public final int zzb;
    @Field(defaultValueUnchecked = "NetworkLocationStatus.STATUS_INVALID_TIMESTAMP", id = 3)
    public final long zzc;
    @Field(defaultValueUnchecked = "NetworkLocationStatus.STATUS_INVALID_TIMESTAMP", id = 4)
    public final long zzd;

    static {
        zzal.CREATOR = new zzam();
    }

    @Constructor
    public zzal(@Param(id = 1) int v, @Param(id = 2) int v1, @Param(id = 3) long v2, @Param(id = 4) long v3) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = v2;
        this.zzd = v3;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof zzal && this.zza == ((zzal)object0).zza && this.zzb == ((zzal)object0).zzb && this.zzc == ((zzal)object0).zzc && this.zzd == ((zzal)object0).zzd;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzb, this.zza, this.zzd, this.zzc});
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(String.valueOf(this.zza).length() + 50 + String.valueOf(this.zzb).length() + 18 + String.valueOf(this.zzd).length() + 17 + String.valueOf(this.zzc).length());
        stringBuilder0.append("NetworkLocationStatus: Wifi status: ");
        stringBuilder0.append(this.zza);
        stringBuilder0.append(" Cell status: ");
        stringBuilder0.append(this.zzb);
        a.s(this.zzd, " elapsed time NS: ", " system time ms: ", stringBuilder0);
        stringBuilder0.append(this.zzc);
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zza);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzb);
        SafeParcelWriter.writeLong(parcel0, 3, this.zzc);
        SafeParcelWriter.writeLong(parcel0, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

