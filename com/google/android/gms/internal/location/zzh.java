package com.google.android.gms.internal.location;

import A7.d;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.location.DeviceOrientationRequest.Builder;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.util.Collections;
import java.util.List;
import k8.Y;

@Class(creator = "DeviceOrientationRequestInternalCreator")
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    static final List zza;
    static final DeviceOrientationRequest zzb;
    @Field(defaultValueUnchecked = "DeviceOrientationRequestInternal.DEFAULT_DEVICE_ORIENTATION_REQUEST", id = 1)
    final DeviceOrientationRequest zzc;
    @Field(defaultValueUnchecked = "DeviceOrientationRequestInternal.DEFAULT_CLIENTS", id = 2)
    final List zzd;
    @Field(defaultValueUnchecked = "null", id = 3)
    final String zze;

    static {
        zzh.zza = Collections.EMPTY_LIST;
        zzh.zzb = new Builder(20000L).build();
        zzh.CREATOR = new zzi();
    }

    @Constructor
    public zzh(@Param(id = 1) DeviceOrientationRequest deviceOrientationRequest0, @Param(id = 2) List list0, @Param(id = 3) String s) {
        this.zzc = deviceOrientationRequest0;
        this.zzd = list0;
        this.zze = s;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof zzh ? Objects.equal(this.zzc, ((zzh)object0).zzc) && Objects.equal(this.zzd, ((zzh)object0).zzd) && Objects.equal(this.zze, ((zzh)object0).zze) : false;
    }

    @Override
    public final int hashCode() {
        return this.zzc.hashCode();
    }

    @Override
    public final String toString() {
        String s = String.valueOf(this.zzc);
        String s1 = String.valueOf(this.zzd);
        StringBuilder stringBuilder0 = new StringBuilder(s.length() + 68 + s1.length() + 7 + String.valueOf(this.zze).length() + 2);
        d.u(stringBuilder0, "DeviceOrientationRequestInternal[deviceOrientationRequest=", s, ", clients=", s1);
        return Y.l(stringBuilder0, ", tag=\'", this.zze, "\']");
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.zzc, v, false);
        SafeParcelWriter.writeTypedList(parcel0, 2, this.zzd, false);
        SafeParcelWriter.writeString(parcel0, 3, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

