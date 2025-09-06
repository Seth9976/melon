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
@Class(creator = "SafetyOptionsCreator")
@Reserved({1})
public final class zzff extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "isSafetyNoticeReviewed", id = 2)
    private final boolean zza;
    @Field(getter = "isGaiaUploadAllowed", id = 3)
    private final boolean zzb;
    @Field(getter = "getSafetyNoticeReviewedVersion", id = 4)
    private final int zzc;

    static {
        zzff.CREATOR = new zzfg();
    }

    @ShowFirstParty
    @Constructor
    public zzff(@Param(id = 2) boolean z, @Param(id = 3) boolean z1, @Param(id = 4) int v) {
        this.zza = z;
        this.zzb = z1;
        this.zzc = v;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.zza);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel0, 4, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

