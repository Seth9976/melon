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
import java.util.HashSet;
import java.util.List;

@Class(creator = "CableAuthenticationExtensionCreator")
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getCableAuthentication", id = 1)
    private final List zza;

    static {
        zzs.CREATOR = new zzt();
    }

    @Constructor
    public zzs(@Param(id = 1) List list0) {
        this.zza = (List)Preconditions.checkNotNull(list0);
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof zzs ? this.zza.containsAll(((zzs)object0).zza) && ((zzs)object0).zza.containsAll(this.zza) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{new HashSet(this.zza)});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

