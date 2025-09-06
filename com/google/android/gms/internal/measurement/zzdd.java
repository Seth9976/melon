package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "InitializationParamsCreator")
@Reserved({4, 5, 6})
public final class zzdd extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(id = 1)
    public final long zza;
    @Field(id = 2)
    public final long zzb;
    @Field(id = 3)
    public final boolean zzc;
    @Field(id = 7)
    public final Bundle zzd;
    @Field(id = 8)
    public final String zze;

    static {
        zzdd.CREATOR = new zzde();
    }

    @Constructor
    public zzdd(@Param(id = 1) long v, @Param(id = 2) long v1, @Param(id = 3) boolean z, @Param(id = 7) Bundle bundle0, @Param(id = 8) String s) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = z;
        this.zzd = bundle0;
        this.zze = s;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeLong(parcel0, 1, this.zza);
        SafeParcelWriter.writeLong(parcel0, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzc);
        SafeParcelWriter.writeBundle(parcel0, 7, this.zzd, false);
        SafeParcelWriter.writeString(parcel0, 8, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

