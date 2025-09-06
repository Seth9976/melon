package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "UploadBatchParcelCreator")
public final class zzol extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(id = 1)
    public final long zza;
    @Field(id = 2)
    public byte[] zzb;
    @Field(id = 3)
    public final String zzc;
    @Field(id = 4)
    public final Bundle zzd;
    @Field(id = 5)
    public final int zze;
    @Field(id = 6)
    public final long zzf;
    @Field(id = 7)
    public String zzg;

    static {
        zzol.CREATOR = new zzom();
    }

    @Constructor
    public zzol(@Param(id = 1) long v, @Param(id = 2) byte[] arr_b, @Param(id = 3) String s, @Param(id = 4) Bundle bundle0, @Param(id = 5) int v1, @Param(id = 6) long v2, @Param(id = 7) String s1) {
        this.zza = v;
        this.zzb = arr_b;
        this.zzc = s;
        this.zzd = bundle0;
        this.zze = v1;
        this.zzf = v2;
        this.zzg = s1;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeLong(parcel0, 1, this.zza);
        SafeParcelWriter.writeByteArray(parcel0, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel0, 3, this.zzc, false);
        SafeParcelWriter.writeBundle(parcel0, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel0, 5, this.zze);
        SafeParcelWriter.writeLong(parcel0, 6, this.zzf);
        SafeParcelWriter.writeString(parcel0, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

