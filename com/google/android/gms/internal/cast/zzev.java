package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.ArrayList;
import java.util.List;

@ShowFirstParty
@Class(creator = "AccountConsentInformationCreator")
public final class zzev extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getAccountName", id = 1)
    private final String zza;
    @Field(getter = "getAccountConsents", id = 2)
    private final byte[] zzb;
    @Field(getter = "getWhitelists", id = 3)
    private final List zzc;

    static {
        zzev.CREATOR = new zzeu();
    }

    @ShowFirstParty
    @Constructor
    public zzev(@Param(id = 1) String s, @Param(id = 2) byte[] arr_b, @Param(id = 3) List list0) {
        this.zza = s;
        this.zzb = arr_b;
        this.zzc = list0 == null ? new ArrayList(0) : new ArrayList(list0);
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof zzev ? Objects.equal(this.zza, ((zzev)object0).zza) && Objects.equal(this.zzb, ((zzev)object0).zzb) && Objects.equal(this.zzc, ((zzev)object0).zzc) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeByteArray(parcel0, 2, this.zzb, false);
        SafeParcelWriter.writeIntegerList(parcel0, 3, new ArrayList(this.zzc), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

