package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@ShowFirstParty
@Class(creator = "FieldMapPairCreator")
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @VersionField(id = 1)
    final int zaa;
    @Field(id = 2)
    final String zab;
    @Field(id = 3)
    final com.google.android.gms.common.server.response.FastJsonResponse.Field zac;

    static {
        zam.CREATOR = new zak();
    }

    @Constructor
    public zam(@Param(id = 1) int v, @Param(id = 2) String s, @Param(id = 3) com.google.android.gms.common.server.response.FastJsonResponse.Field fastJsonResponse$Field0) {
        this.zaa = v;
        this.zab = s;
        this.zac = fastJsonResponse$Field0;
    }

    public zam(String s, com.google.android.gms.common.server.response.FastJsonResponse.Field fastJsonResponse$Field0) {
        this.zaa = 1;
        this.zab = s;
        this.zac = fastJsonResponse$Field0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zaa);
        SafeParcelWriter.writeString(parcel0, 2, this.zab, false);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zac, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

