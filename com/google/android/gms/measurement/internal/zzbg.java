package com.google.android.gms.measurement.internal;

import A7.d;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "EventParcelCreator")
@Reserved({1})
public final class zzbg extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(id = 2)
    public final String zza;
    @Field(id = 3)
    public final zzbe zzb;
    @Field(id = 4)
    public final String zzc;
    @Field(id = 5)
    public final long zzd;

    static {
        zzbg.CREATOR = new zzbh();
    }

    public zzbg(zzbg zzbg0, long v) {
        Preconditions.checkNotNull(zzbg0);
        this.zza = zzbg0.zza;
        this.zzb = zzbg0.zzb;
        this.zzc = zzbg0.zzc;
        this.zzd = v;
    }

    @Constructor
    public zzbg(@Param(id = 2) String s, @Param(id = 3) zzbe zzbe0, @Param(id = 4) String s1, @Param(id = 5) long v) {
        this.zza = s;
        this.zzb = zzbe0;
        this.zzc = s1;
        this.zzd = v;
    }

    @Override
    public final String toString() {
        String s = String.valueOf(this.zzb);
        StringBuilder stringBuilder0 = new StringBuilder(String.valueOf(this.zzc).length() + 13 + String.valueOf(this.zza).length() + 8 + s.length());
        d.u(stringBuilder0, "origin=", this.zzc, ",name=", this.zza);
        return x.m(stringBuilder0, ",params=", s);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        zzbh.zza(this, parcel0, v);
    }
}

