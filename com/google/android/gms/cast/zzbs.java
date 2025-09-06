package com.google.android.gms.cast;

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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@ShowFirstParty
@Class(creator = "JoinOptionsCreator")
@Reserved({1})
public final class zzbs extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getConnectionType", id = 2)
    private final int zza;

    static {
        zzbs.CREATOR = new zzbt();
    }

    public zzbs() {
        this.zza = 0;
    }

    @Constructor
    public zzbs(@Param(id = 2) int v) {
        this.zza = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof zzbs ? this.zza == ((zzbs)object0).zza : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zza});
    }

    // 去混淆评级： 低(30)
    @Override
    public final String toString() {
        switch(this.zza) {
            case 0: {
                return "joinOptions(connectionType=STRONG)";
            }
            case 2: {
                return "joinOptions(connectionType=INVISIBLE)";
            }
            default: {
                return "joinOptions(connectionType=UNKNOWN)";
            }
        }
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 2, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

