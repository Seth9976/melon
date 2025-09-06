package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

@Class(creator = "LocationAvailabilityCreator")
@Reserved({1000})
public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    public static final LocationAvailability zza;
    public static final LocationAvailability zzb;
    @Field(defaultValueUnchecked = "LocationAvailability.STATUS_UNSUCCESSFUL", id = 4)
    final int zzc;
    @Field(defaultValueUnchecked = "LocationAvailability.STATUS_UNKNOWN", getter = "getCellStatus", id = 1)
    private final int zzd;
    @Field(defaultValueUnchecked = "LocationAvailability.STATUS_UNKNOWN", getter = "getWifiStatus", id = 2)
    private final int zze;
    @Field(defaultValueUnchecked = "0", getter = "getElapsedRealtimeNs", id = 3)
    private final long zzf;
    @Field(getter = "getBatchedStatus", id = 5)
    private final zzal[] zzg;

    static {
        LocationAvailability.zza = new LocationAvailability(0, 1, 1, 0L, null, true);
        LocationAvailability.zzb = new LocationAvailability(1000, 1, 1, 0L, null, false);
        LocationAvailability.CREATOR = new zzab();
    }

    @Constructor
    public LocationAvailability(@Param(id = 4) int v, @Param(id = 1) int v1, @Param(id = 2) int v2, @Param(id = 3) long v3, @Param(id = 5) zzal[] arr_zzal, @Param(id = 6) boolean z) {
        this.zzc = v >= 1000 ? 1000 : 0;
        this.zzd = v1;
        this.zze = v2;
        this.zzf = v3;
        this.zzg = arr_zzal;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof LocationAvailability && this.zzd == ((LocationAvailability)object0).zzd && this.zze == ((LocationAvailability)object0).zze && this.zzf == ((LocationAvailability)object0).zzf && this.zzc == ((LocationAvailability)object0).zzc && Arrays.equals(this.zzg, ((LocationAvailability)object0).zzg);
    }

    public static LocationAvailability extractLocationAvailability(Intent intent0) {
        if(!LocationAvailability.hasLocationAvailability(intent0)) {
            return null;
        }
        try {
            return (LocationAvailability)intent0.getParcelableExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
        }
        catch(ClassCastException unused_ex) {
            return null;
        }
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    public static boolean hasLocationAvailability(Intent intent0) {
        return intent0 != null && intent0.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zzc});
    }

    public boolean isLocationAvailable() {
        return this.zzc < 1000;
    }

    @Override
    public String toString() {
        return "LocationAvailability[" + this.isLocationAvailable() + "]";
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zzd);
        SafeParcelWriter.writeInt(parcel0, 2, this.zze);
        SafeParcelWriter.writeLong(parcel0, 3, this.zzf);
        SafeParcelWriter.writeInt(parcel0, 4, this.zzc);
        SafeParcelWriter.writeTypedArray(parcel0, 5, this.zzg, v, false);
        SafeParcelWriter.writeBoolean(parcel0, 6, this.isLocationAvailable());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

