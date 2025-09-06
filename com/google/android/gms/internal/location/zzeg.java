package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.WorkSource;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.RemovedParam;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.location.LocationRequest.Builder;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

@Class(creator = "LocationRequestInternalCreator")
@Reserved({2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 1000})
@Deprecated
public final class zzeg extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(defaultValueUnchecked = "null", id = 1)
    LocationRequest zza;

    static {
        zzeg.CREATOR = new zzeh();
    }

    @Constructor
    public zzeg(@Param(id = 1) LocationRequest locationRequest0, @RemovedParam(defaultValueUnchecked = "null", id = 5) List list0, @RemovedParam(defaultValue = "false", id = 8) boolean z, @RemovedParam(defaultValue = "false", id = 9) boolean z1, @RemovedParam(defaultValue = "false", id = 11) boolean z2, @RemovedParam(defaultValue = "false", id = 12) boolean z3, @RemovedParam(defaultValueUnchecked = "null", id = 13) String s, @RemovedParam(defaultValueUnchecked = "Long.MAX_VALUE", id = 14) long v) {
        WorkSource workSource0;
        Builder locationRequest$Builder0 = new Builder(locationRequest0);
        if(list0 != null) {
            if(list0.isEmpty()) {
                workSource0 = null;
            }
            else {
                workSource0 = new WorkSource();
                for(Object object0: list0) {
                    WorkSourceUtil.add(workSource0, ((ClientIdentity)object0).uid, ((ClientIdentity)object0).packageName);
                }
            }
            locationRequest$Builder0.zzc(workSource0);
        }
        if(z) {
            locationRequest$Builder0.setGranularity(1);
        }
        if(z1) {
            locationRequest$Builder0.zza(2);
        }
        if(z2) {
            locationRequest$Builder0.zzb(true);
        }
        if(z3) {
            locationRequest$Builder0.setWaitForAccurateLocation(true);
        }
        if(v != 0x7FFFFFFFFFFFFFFFL) {
            locationRequest$Builder0.setMaxUpdateAgeMillis(v);
        }
        this.zza = locationRequest$Builder0.build();
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof zzeg ? Objects.equal(this.zza, ((zzeg)object0).zza) : false;
    }

    @Override
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override
    public final String toString() {
        return this.zza.toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.zza, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Deprecated
    public static zzeg zza(String s, LocationRequest locationRequest0) {
        return new zzeg(locationRequest0, null, false, false, false, false, null, 0x7FFFFFFFFFFFFFFFL);
    }
}

