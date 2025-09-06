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
import java.util.Arrays;

@Class(creator = "AuthenticationExtensionsDevicePublicKeyOutputsCreator")
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getSignature", id = 1)
    private final byte[] zza;
    @Field(getter = "getAuthenticatorOutput", id = 2)
    private final byte[] zzb;

    static {
        zzf.CREATOR = new zzg();
    }

    @Constructor
    public zzf(@Param(id = 1) byte[] arr_b, @Param(id = 2) byte[] arr_b1) {
        this.zza = arr_b;
        this.zzb = arr_b1;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof zzf ? Arrays.equals(this.zza, ((zzf)object0).zza) && Arrays.equals(this.zzb, ((zzf)object0).zzb) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeByteArray(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeByteArray(parcel0, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

