package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "FusedLocationProviderResultCreator")
@Reserved({1000})
public final class zzl extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator CREATOR;
    public static final zzl zza;
    @Field(getter = "getStatus", id = 1)
    private final Status zzb;

    static {
        zzl.zza = new zzl(Status.RESULT_SUCCESS);
        zzl.CREATOR = new zzm();
    }

    @Constructor
    public zzl(@Param(id = 1) Status status0) {
        this.zzb = status0;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzb;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.zzb, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

