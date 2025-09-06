package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "ConnectionInfoCreator")
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(id = 1)
    Bundle zza;
    @Field(id = 2)
    Feature[] zzb;
    @Field(defaultValue = "0", id = 3)
    int zzc;
    @Field(id = 4)
    ConnectionTelemetryConfiguration zzd;

    static {
        zzj.CREATOR = new zzk();
    }

    public zzj() {
    }

    @Constructor
    public zzj(@Param(id = 1) Bundle bundle0, @Param(id = 2) Feature[] arr_feature, @Param(id = 3) int v, @Param(id = 4) ConnectionTelemetryConfiguration connectionTelemetryConfiguration0) {
        this.zza = bundle0;
        this.zzb = arr_feature;
        this.zzc = v;
        this.zzd = connectionTelemetryConfiguration0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBundle(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeTypedArray(parcel0, 2, this.zzb, v, false);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzc);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzd, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

