package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "GoogleThirdPartyPaymentExtensionCreator")
public class GoogleThirdPartyPaymentExtension extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getThirdPartyPayment", id = 1)
    private final boolean zza;

    static {
        GoogleThirdPartyPaymentExtension.CREATOR = new zzaf();
    }

    @Constructor
    public GoogleThirdPartyPaymentExtension(@Param(id = 1) boolean z) {
        this.zza = z;
    }

    @Override
    public boolean equals(Object object0) {
        return object0 instanceof GoogleThirdPartyPaymentExtension ? this.zza == ((GoogleThirdPartyPaymentExtension)object0).getThirdPartyPayment() : false;
    }

    public boolean getThirdPartyPayment() {
        return this.zza;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{Boolean.valueOf(this.zza)});
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBoolean(parcel0, 1, this.getThirdPartyPayment());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

