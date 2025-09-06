package com.google.android.gms.location;

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
import com.google.android.gms.internal.location.zzek;
import java.util.ArrayList;
import java.util.List;

@Class(creator = "GeofencingRequestCreator")
@Reserved({3, 1000})
public class GeofencingRequest extends AbstractSafeParcelable {
    public static final class Builder {
        private final List zza;
        @InitialTrigger
        private int zzb;

        public Builder() {
            this.zza = new ArrayList();
            this.zzb = 5;
        }

        public Builder addGeofence(Geofence geofence0) {
            Preconditions.checkArgument(geofence0 instanceof zzek, "Geofence must be created using Geofence.Builder.");
            this.zza.add(((zzek)geofence0));
            return this;
        }

        public Builder addGeofences(List list0) {
            for(Object object0: list0) {
                this.addGeofence(((Geofence)object0));
            }
            return this;
        }

        public GeofencingRequest build() {
            Preconditions.checkArgument(!this.zza.isEmpty(), "No geofence has been added to this request.");
            return new GeofencingRequest(new ArrayList(this.zza), this.zzb, null);
        }

        public Builder setInitialTrigger(@InitialTrigger int v) {
            this.zzb = v & 7;
            return this;
        }
    }

    public @interface InitialTrigger {
    }

    public static final Parcelable.Creator CREATOR = null;
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    @Field(getter = "getParcelableGeofences", id = 1)
    private final List zza;
    @Field(getter = "getInitialTrigger", id = 2)
    @InitialTrigger
    private final int zzb;
    @Field(getter = "getAttributionTag", id = 4)
    private final String zzc;

    static {
        GeofencingRequest.CREATOR = new zzp();
    }

    @Constructor
    public GeofencingRequest(@Param(id = 1) List list0, @Param(id = 2) @InitialTrigger int v, @Param(id = 4) String s) {
        this.zza = list0;
        this.zzb = v;
        this.zzc = s;
    }

    public List getGeofences() {
        return new ArrayList(this.zza);
    }

    @InitialTrigger
    public int getInitialTrigger() {
        return this.zzb;
    }

    @Override
    public String toString() {
        return "GeofencingRequest[geofences=" + this.zza + ", initialTrigger=" + this.zzb + "]";
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel0, 2, this.getInitialTrigger());
        SafeParcelWriter.writeString(parcel0, 4, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

