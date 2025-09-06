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
@Class(creator = "ConsentInformationCreator")
public final class zzew extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getAccountInformation", id = 1)
    private final List zza;
    @Field(getter = "getZwiebackKeyed", id = 2)
    private final boolean zzb;
    @Field(getter = "getIsAnonymous", id = 3)
    private final boolean zzc;

    static {
        new zzew(null, false, false);
        zzew.CREATOR = new zzex();
    }

    @ShowFirstParty
    @Constructor
    public zzew(@Param(id = 1) List list0, @Param(id = 2) boolean z, @Param(id = 3) boolean z1) {
        this.zza = list0 == null ? new ArrayList(0) : new ArrayList(list0);
        this.zzb = z;
        this.zzc = z1;
    }

    @Override
    @ShowFirstParty
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof zzew ? Objects.equal(this.zza, ((zzew)object0).zza) && Objects.equal(Boolean.valueOf(this.zzb), Boolean.valueOf(((zzew)object0).zzb)) : false;
    }

    @Override
    @ShowFirstParty
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, Boolean.valueOf(this.zzb)});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 1, new ArrayList(this.zza), false);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

