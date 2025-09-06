package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.zav;

@Class(creator = "SignInResponseCreator")
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @VersionField(id = 1)
    final int zaa;
    @Field(getter = "getConnectionResult", id = 2)
    private final ConnectionResult zab;
    @Field(getter = "getResolveAccountResponse", id = 3)
    private final zav zac;

    static {
        zak.CREATOR = new zal();
    }

    @Constructor
    public zak(@Param(id = 1) int v, @Param(id = 2) ConnectionResult connectionResult0, @Param(id = 3) zav zav0) {
        this.zaa = v;
        this.zab = connectionResult0;
        this.zac = zav0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zaa);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zab, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zac, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final ConnectionResult zaa() {
        return this.zab;
    }

    public final zav zab() {
        return this.zac;
    }
}

