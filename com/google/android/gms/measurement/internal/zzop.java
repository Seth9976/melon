package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.List;

@Class(creator = "UploadBatchesParcelCreator")
public final class zzop extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(id = 1)
    public final List zza;

    static {
        zzop.CREATOR = new zzoq();
    }

    @Constructor
    public zzop(@Param(id = 1) List list0) {
        this.zza = list0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

