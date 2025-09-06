package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.CastUtils;
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
@Class(creator = "EqualizerSettingsCreator")
@Reserved({1})
public final class zzat extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getLowShelf", id = 2)
    private final zzar zza;
    @Field(getter = "getHighShelf", id = 3)
    private final zzar zzb;

    static {
        zzat.CREATOR = new zzau();
    }

    @Constructor
    public zzat(@Param(id = 2) zzar zzar0, @Param(id = 3) zzar zzar1) {
        this.zza = zzar0;
        this.zzb = zzar1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzat ? CastUtils.zze(this.zza, ((zzat)object0).zza) && CastUtils.zze(this.zzb, ((zzat)object0).zzb) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zza, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zzb, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

