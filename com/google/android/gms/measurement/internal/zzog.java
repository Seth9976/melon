package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "TriggerUriParcelCreator")
public final class zzog extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(id = 1)
    public final String zza;
    @Field(id = 2)
    public final long zzb;
    @Field(id = 3)
    public final int zzc;

    static {
        zzog.CREATOR = new zzoh();
    }

    @Constructor
    public zzog(@Param(id = 1) String s, @Param(id = 2) long v, @Param(id = 3) int v1) {
        this.zza = s;
        this.zzb = v;
        this.zzc = v1;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeLong(parcel0, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

