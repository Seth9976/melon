package com.google.android.gms.signin.internal;

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
import java.util.List;

@Class(creator = "RecordConsentByConsentResultResponseCreator")
public final class zag extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getGrantedScopes", id = 1)
    private final List zaa;
    @Field(getter = "getToken", id = 2)
    private final String zab;

    static {
        zag.CREATOR = new zah();
    }

    @Constructor
    public zag(@Param(id = 1) List list0, @Param(id = 2) String s) {
        this.zaa = list0;
        this.zab = s;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zab == null ? Status.RESULT_CANCELED : Status.RESULT_SUCCESS;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeStringList(parcel0, 1, this.zaa, false);
        SafeParcelWriter.writeString(parcel0, 2, this.zab, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

