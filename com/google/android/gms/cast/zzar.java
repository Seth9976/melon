package com.google.android.gms.cast;

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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@ShowFirstParty
@Class(creator = "EqualizerBandSettingsCreator")
@Reserved({1})
public final class zzar extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getFrequency", id = 2)
    private final float zza;
    @Field(getter = "getQFactor", id = 3)
    private final float zzb;
    @Field(getter = "getGainDb", id = 4)
    private final float zzc;

    static {
        zzar.CREATOR = new zzas();
    }

    @Constructor
    public zzar(@Param(id = 2) float f, @Param(id = 3) float f1, @Param(id = 4) float f2) {
        this.zza = f;
        this.zzb = f1;
        this.zzc = f2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzar ? this.zza == ((zzar)object0).zza && this.zzb == ((zzar)object0).zzb && this.zzc == ((zzar)object0).zzc : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeFloat(parcel0, 2, this.zza);
        SafeParcelWriter.writeFloat(parcel0, 3, this.zzb);
        SafeParcelWriter.writeFloat(parcel0, 4, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

