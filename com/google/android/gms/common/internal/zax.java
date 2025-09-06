package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "SignInButtonConfigCreator")
public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @VersionField(id = 1)
    final int zaa;
    @Field(getter = "getButtonSize", id = 2)
    private final int zab;
    @Field(getter = "getColorScheme", id = 3)
    private final int zac;
    @Field(getter = "getScopes", id = 4)
    @Deprecated
    private final Scope[] zad;

    static {
        zax.CREATOR = new zay();
    }

    @Constructor
    public zax(@Param(id = 1) int v, @Param(id = 2) int v1, @Param(id = 3) int v2, @Param(id = 4) Scope[] arr_scope) {
        this.zaa = v;
        this.zab = v1;
        this.zac = v2;
        this.zad = arr_scope;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zaa);
        SafeParcelWriter.writeInt(parcel0, 2, this.zab);
        SafeParcelWriter.writeInt(parcel0, 3, this.zac);
        SafeParcelWriter.writeTypedArray(parcel0, 4, this.zad, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

