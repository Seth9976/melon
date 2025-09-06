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
import com.google.android.gms.internal.location.zze;
import k8.Y;

@Class(creator = "LocationAvailabilityRequestCreator")
public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(defaultValue = "false", getter = "isBypass", id = 1)
    private final boolean zza;
    @Field(getter = "getImpersonation", id = 2)
    private final zze zzb;

    static {
        zzad.CREATOR = new zzae();
    }

    @Constructor
    public zzad(@Param(id = 1) boolean z, @Param(id = 2) zze zze0) {
        this.zza = z;
        this.zzb = zze0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof zzad ? this.zza == ((zzad)object0).zza && Objects.equal(this.zzb, ((zzad)object0).zzb) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{Boolean.valueOf(this.zza)});
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = Y.p("LocationAvailabilityRequest[");
        if(this.zza) {
            stringBuilder0.append("bypass, ");
        }
        if(this.zzb != null) {
            stringBuilder0.append("impersonation=");
            stringBuilder0.append(this.zzb);
            stringBuilder0.append(", ");
        }
        stringBuilder0.setLength(stringBuilder0.length() - 2);
        stringBuilder0.append(']');
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBoolean(parcel0, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzb, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

