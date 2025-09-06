package com.google.android.gms.common.internal;

import android.os.IBinder;
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

@Class(creator = "ResolveAccountResponseCreator")
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @VersionField(id = 1)
    final int zaa;
    @Field(id = 2)
    final IBinder zab;
    @Field(getter = "getConnectionResult", id = 3)
    private final ConnectionResult zac;
    @Field(getter = "getSaveDefaultAccount", id = 4)
    private final boolean zad;
    @Field(getter = "isFromCrossClientAuth", id = 5)
    private final boolean zae;

    static {
        zav.CREATOR = new zaw();
    }

    @Constructor
    public zav(@Param(id = 1) int v, @Param(id = 2) IBinder iBinder0, @Param(id = 3) ConnectionResult connectionResult0, @Param(id = 4) boolean z, @Param(id = 5) boolean z1) {
        this.zaa = v;
        this.zab = iBinder0;
        this.zac = connectionResult0;
        this.zad = z;
        this.zae = z1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == null) {
            return false;
        }
        if(this == object0) {
            return true;
        }
        return object0 instanceof zav ? this.zac.equals(((zav)object0).zac) && Objects.equal(this.zab(), ((zav)object0).zab()) : false;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zaa);
        SafeParcelWriter.writeIBinder(parcel0, 2, this.zab, false);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zac, v, false);
        SafeParcelWriter.writeBoolean(parcel0, 4, this.zad);
        SafeParcelWriter.writeBoolean(parcel0, 5, this.zae);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final ConnectionResult zaa() {
        return this.zac;
    }

    public final IAccountAccessor zab() {
        return this.zab == null ? null : Stub.asInterface(this.zab);
    }

    public final boolean zac() {
        return this.zad;
    }

    public final boolean zad() {
        return this.zae;
    }
}

