package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.List;

@Class(creator = "RemoveGeofencingRequestCreator")
@Reserved({1000})
public final class zzem extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getGeofenceIds", id = 1)
    private final List zza;
    @Field(getter = "getPendingIntent", id = 2)
    private final PendingIntent zzb;
    @Field(defaultValue = "", getter = "getTag", id = 3)
    private final String zzc;

    static {
        zzem.CREATOR = new zzen();
    }

    @Constructor
    public zzem(@Param(id = 1) List list0, @Param(id = 2) PendingIntent pendingIntent0, @Param(id = 3) String s) {
        this.zza = list0 == null ? zzex.zzi() : zzex.zzj(list0);
        this.zzb = pendingIntent0;
        this.zzc = s;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeStringList(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzb, v, false);
        SafeParcelWriter.writeString(parcel0, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static zzem zza(List list0) {
        Preconditions.checkNotNull(list0, "geofence can\'t be null.");
        Preconditions.checkArgument(!list0.isEmpty(), "Geofences must contains at least one id.");
        return new zzem(list0, null, "");
    }

    public static zzem zzb(PendingIntent pendingIntent0) {
        Preconditions.checkNotNull(pendingIntent0, "PendingIntent can not be null.");
        return new zzem(null, pendingIntent0, "");
    }
}

