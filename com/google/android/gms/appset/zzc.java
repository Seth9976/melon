package com.google.android.gms.appset;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "AppSetInfoParcelCreator")
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getId", id = 1)
    private final String zza;
    @Field(getter = "getScope", id = 2)
    private final int zzb;

    static {
        zzc.CREATOR = new zzd();
    }

    @Constructor
    public zzc(@Param(id = 1) String s, @Param(id = 2) int v) {
        this.zza = s;
        this.zzb = v;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final int zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}

