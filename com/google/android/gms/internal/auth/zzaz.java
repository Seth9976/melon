package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "SendDataRequestCreator")
public final class zzaz extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @VersionField(id = 1)
    final int zza;
    @Field(id = 2)
    public final String zzb;
    @Field(id = 3)
    public final byte[] zzc;

    static {
        zzaz.CREATOR = new zzba();
    }

    @Constructor
    public zzaz(@Param(id = 1) int v, @Param(id = 2) String s, @Param(id = 3) byte[] arr_b) {
        this.zza = 1;
        this.zzb = (String)Preconditions.checkNotNull(s);
        this.zzc = (byte[])Preconditions.checkNotNull(arr_b);
    }

    public zzaz(String s, byte[] arr_b) {
        this(1, s, arr_b);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zza);
        SafeParcelWriter.writeString(parcel0, 2, this.zzb, false);
        SafeParcelWriter.writeByteArray(parcel0, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

