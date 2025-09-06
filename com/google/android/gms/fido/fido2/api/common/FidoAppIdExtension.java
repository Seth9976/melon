package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "FidoAppIdExtensionCreator")
@Reserved({1})
public class FidoAppIdExtension extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getAppId", id = 2)
    private final String zza;

    static {
        FidoAppIdExtension.CREATOR = new zzx();
    }

    @Constructor
    public FidoAppIdExtension(@Param(id = 2) String s) {
        this.zza = (String)Preconditions.checkNotNull(s);
    }

    @Override
    public boolean equals(Object object0) {
        return object0 instanceof FidoAppIdExtension ? this.zza.equals(((FidoAppIdExtension)object0).zza) : false;
    }

    public String getAppId() {
        return this.zza;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza});
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.getAppId(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

