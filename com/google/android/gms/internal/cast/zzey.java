package com.google.android.gms.internal.cast;

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
@Class(creator = "ElCapitanOptionsCreator")
@Reserved({1})
public final class zzey extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "isElCapitanReviewed", id = 2)
    private final boolean zza;
    @Field(getter = "getElCapitanReviewedVersion", id = 3)
    private final int zzb;

    static {
        zzey.CREATOR = new zzez();
    }

    @ShowFirstParty
    @Constructor
    public zzey(@Param(id = 2) boolean z, @Param(id = 3) int v) {
        this.zza = z;
        this.zzb = v;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.zza);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

