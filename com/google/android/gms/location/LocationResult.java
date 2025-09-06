package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Build.VERSION;
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
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Class(creator = "LocationResultCreator")
@Reserved({1000})
public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    static final List zza;
    @Field(defaultValueUnchecked = "LocationResult.DEFAULT_LOCATIONS", getter = "getLocations", id = 1)
    private final List zzb;

    static {
        LocationResult.zza = Collections.EMPTY_LIST;
        LocationResult.CREATOR = new zzag();
    }

    @Constructor
    public LocationResult(@Param(id = 1) List list0) {
        this.zzb = list0;
    }

    public static LocationResult create(List list0) {
        if(list0 == null) {
            list0 = LocationResult.zza;
        }
        return new LocationResult(list0);
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 instanceof LocationResult) {
            if(Build.VERSION.SDK_INT >= 0x1F) {
                return this.zzb.equals(((LocationResult)object0).zzb);
            }
            if(this.zzb.size() != ((LocationResult)object0).zzb.size()) {
                return false;
            }
            Iterator iterator0 = this.zzb.iterator();
            Iterator iterator1 = ((LocationResult)object0).zzb.iterator();
            while(iterator0.hasNext()) {
                Object object1 = iterator0.next();
                Object object2 = iterator1.next();
                if(Double.compare(((Location)object1).getLatitude(), ((Location)object2).getLatitude()) != 0) {
                    return false;
                }
                if(Double.compare(((Location)object1).getLongitude(), ((Location)object2).getLongitude()) != 0) {
                    return false;
                }
                if(((Location)object1).getTime() != ((Location)object2).getTime()) {
                    return false;
                }
                if(((Location)object1).getElapsedRealtimeNanos() != ((Location)object2).getElapsedRealtimeNanos()) {
                    return false;
                }
                if(!Objects.equal(((Location)object1).getProvider(), ((Location)object2).getProvider())) {
                    return false;
                }
                if(false) {
                    break;
                }
            }
            return true;
        }
        return false;
    }

    public static LocationResult extractResult(Intent intent0) {
        if(!LocationResult.hasResult(intent0)) {
            return null;
        }
        LocationResult locationResult0 = (LocationResult)SafeParcelableSerializer.deserializeFromIntentExtra(intent0, "com.google.android.gms.location.EXTRA_LOCATION_RESULT_BYTES", LocationResult.CREATOR);
        return locationResult0 == null ? ((LocationResult)intent0.getParcelableExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT")) : locationResult0;
    }

    public Location getLastLocation() {
        int v = this.zzb.size();
        return v == 0 ? null : ((Location)this.zzb.get(v - 1));
    }

    public List getLocations() {
        return this.zzb;
    }

    // 去混淆评级： 低(30)
    public static boolean hasResult(Intent intent0) {
        return intent0 == null ? false : intent0.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT") || intent0.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT_BYTES");
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zzb});
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("LocationResult");
        stringBuilder0.ensureCapacity(this.zzb.size() * 100);
        stringBuilder0.append("[");
        boolean z = false;
        for(Object object0: this.zzb) {
            zzak.zza(((Location)object0), stringBuilder0);
            stringBuilder0.append(", ");
            z = true;
        }
        if(z) {
            stringBuilder0.setLength(stringBuilder0.length() - 2);
        }
        stringBuilder0.append("]");
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 1, this.getLocations(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

