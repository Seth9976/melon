package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Objects;

@Class(creator = "ScionActivityInfoCreator")
public final class zzdf extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(id = 1)
    public final int zza;
    @Field(id = 2)
    public final String zzb;
    @Field(id = 3)
    public final Intent zzc;

    static {
        zzdf.CREATOR = new zzdg();
    }

    @Constructor
    public zzdf(@Param(id = 1) int v, @Param(id = 2) String s, @Param(id = 3) Intent intent0) {
        this.zza = v;
        this.zzb = s;
        this.zzc = intent0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzdf ? this.zza == ((zzdf)object0).zza && Objects.equals(this.zzb, ((zzdf)object0).zzb) && Objects.equals(this.zzc, ((zzdf)object0).zzc) : false;
    }

    @Override
    public final int hashCode() {
        return this.zza;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zza);
        SafeParcelWriter.writeString(parcel0, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zzc, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static zzdf zza(Activity activity0) {
        return new zzdf(activity0.hashCode(), activity0.getClass().getCanonicalName(), activity0.getIntent());
    }
}

