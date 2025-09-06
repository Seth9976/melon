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
import java.util.Arrays;

@Class(creator = "CableAuthenticationDataCreator")
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getVersion", id = 1)
    private final long zza;
    @Field(getter = "getClientEid", id = 2)
    private final byte[] zzb;
    @Field(getter = "getAuthenticatorEid", id = 3)
    private final byte[] zzc;
    @Field(getter = "getSessionPreKey", id = 4)
    private final byte[] zzd;

    static {
        zzq.CREATOR = new zzr();
    }

    @Constructor
    public zzq(@Param(id = 1) long v, @Param(id = 2) byte[] arr_b, @Param(id = 3) byte[] arr_b1, @Param(id = 4) byte[] arr_b2) {
        this.zza = v;
        this.zzb = (byte[])Preconditions.checkNotNull(arr_b);
        this.zzc = (byte[])Preconditions.checkNotNull(arr_b1);
        this.zzd = (byte[])Preconditions.checkNotNull(arr_b2);
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof zzq ? this.zza == ((zzq)object0).zza && Arrays.equals(this.zzb, ((zzq)object0).zzb) && Arrays.equals(this.zzc, ((zzq)object0).zzc) && Arrays.equals(this.zzd, ((zzq)object0).zzd) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeLong(parcel0, 1, this.zza);
        SafeParcelWriter.writeByteArray(parcel0, 2, this.zzb, false);
        SafeParcelWriter.writeByteArray(parcel0, 3, this.zzc, false);
        SafeParcelWriter.writeByteArray(parcel0, 4, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

