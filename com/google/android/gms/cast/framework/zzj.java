package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@ShowFirstParty
@Class(creator = "CastExperimentOptionsCreator")
@Reserved({1})
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getAppVisibilityDetectorFixed", id = 2)
    private final boolean zza;

    static {
        zzj.CREATOR = new zzk();
    }

    @Constructor
    public zzj(@Param(id = 2) boolean z) {
        this.zza = z;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

