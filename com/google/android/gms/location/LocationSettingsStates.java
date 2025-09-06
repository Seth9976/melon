package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

@Class(creator = "LocationSettingsStatesCreator")
@Reserved({1000})
public final class LocationSettingsStates extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "isGpsUsable", id = 1)
    private final boolean zza;
    @Field(getter = "isNetworkLocationUsable", id = 2)
    private final boolean zzb;
    @Field(getter = "isBleUsable", id = 3)
    private final boolean zzc;
    @Field(getter = "isGpsPresent", id = 4)
    private final boolean zzd;
    @Field(getter = "isNetworkLocationPresent", id = 5)
    private final boolean zze;
    @Field(getter = "isBlePresent", id = 6)
    private final boolean zzf;

    static {
        LocationSettingsStates.CREATOR = new zzaj();
    }

    @Constructor
    public LocationSettingsStates(@Param(id = 1) boolean z, @Param(id = 2) boolean z1, @Param(id = 3) boolean z2, @Param(id = 4) boolean z3, @Param(id = 5) boolean z4, @Param(id = 6) boolean z5) {
        this.zza = z;
        this.zzb = z1;
        this.zzc = z2;
        this.zzd = z3;
        this.zze = z4;
        this.zzf = z5;
    }

    public static LocationSettingsStates fromIntent(Intent intent0) {
        return (LocationSettingsStates)SafeParcelableSerializer.deserializeFromIntentExtra(intent0, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", LocationSettingsStates.CREATOR);
    }

    public boolean isBlePresent() {
        return this.zzf;
    }

    public boolean isBleUsable() {
        return this.zzc;
    }

    public boolean isGpsPresent() {
        return this.zzd;
    }

    public boolean isGpsUsable() {
        return this.zza;
    }

    // 去混淆评级： 低(20)
    public boolean isLocationPresent() {
        return this.zzd || this.zze;
    }

    // 去混淆评级： 低(20)
    public boolean isLocationUsable() {
        return this.zza || this.zzb;
    }

    public boolean isNetworkLocationPresent() {
        return this.zze;
    }

    public boolean isNetworkLocationUsable() {
        return this.zzb;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBoolean(parcel0, 1, this.isGpsUsable());
        SafeParcelWriter.writeBoolean(parcel0, 2, this.isNetworkLocationUsable());
        SafeParcelWriter.writeBoolean(parcel0, 3, this.isBleUsable());
        SafeParcelWriter.writeBoolean(parcel0, 4, this.isGpsPresent());
        SafeParcelWriter.writeBoolean(parcel0, 5, this.isNetworkLocationPresent());
        SafeParcelWriter.writeBoolean(parcel0, 6, this.isBlePresent());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

