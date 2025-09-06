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

@Class(creator = "GoogleMultiAssertionExtensionCreator")
public final class zzz extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getRequestForMultiAssertion", id = 1)
    private final boolean zza;

    static {
        zzz.CREATOR = new zzaa();
    }

    @Constructor
    public zzz(@Param(id = 1) boolean z) {
        this.zza = ((Boolean)Preconditions.checkNotNull(Boolean.valueOf(z))).booleanValue();
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof zzz ? this.zza == ((zzz)object0).zza : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{Boolean.valueOf(this.zza)});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBoolean(parcel0, 1, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

