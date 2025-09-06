package com.google.android.gms.location;

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

@Class(creator = "LocationSettingsResultCreator")
@Reserved({1000})
public final class LocationSettingsResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getStatus", id = 1)
    private final Status zza;
    @Field(getter = "getLocationSettingsStates", id = 2)
    private final LocationSettingsStates zzb;

    static {
        LocationSettingsResult.CREATOR = new zzai();
    }

    @Constructor
    public LocationSettingsResult(@Param(id = 1) Status status0, @Param(id = 2) LocationSettingsStates locationSettingsStates0) {
        this.zza = status0;
        this.zzb = locationSettingsStates0;
    }

    public LocationSettingsStates getLocationSettingsStates() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zza;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.getStatus(), v, false);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.getLocationSettingsStates(), v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

