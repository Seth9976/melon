package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.ArrayList;
import java.util.List;

@Class(creator = "UploadBatchesCriteriaCreator")
public final class zzon extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(id = 1)
    public final List zza;

    static {
        zzon.CREATOR = new zzoo();
    }

    @Constructor
    public zzon(@Param(id = 1) List list0) {
        this.zza = list0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeIntegerList(parcel0, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static zzon zza(zzlr[] arr_zzlr) {
        ArrayList arrayList0 = new ArrayList(1);
        arrayList0.add(arr_zzlr[0].zza());
        return new zzon(arrayList0);
    }
}

