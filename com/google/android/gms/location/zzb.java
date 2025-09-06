package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.WorkSource;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@ShowFirstParty
@Class(creator = "ActivityRecognitionRequestCreator")
@Reserved({1000})
public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getIntervalMillis", id = 1)
    private final long zza;
    @Field(getter = "getTriggerUpdate", id = 2)
    private final boolean zzb;
    @Field(getter = "getWorkSource", id = 3)
    private final WorkSource zzc;
    @Field(getter = "getTag", id = 4)
    private final String zzd;
    @Field(getter = "getNondefaultActivities", id = 5)
    private final int[] zze;
    @Field(getter = "getRequestSensorData", id = 6)
    private final boolean zzf;
    @Field(getter = "getAccountName", id = 7)
    private final String zzg;
    @Field(defaultValueUnchecked = "ActivityRecognitionRequest.DEFAULT_MAX_REPORT_LATENCY_MILLIS", getter = "getMaxReportLatencyMillis", id = 8)
    private final long zzh;
    @Field(getter = "getContextAttributionTag", id = 9)
    private String zzi;

    static {
        zzb.CREATOR = new zzc();
    }

    @Constructor
    public zzb(@Param(id = 1) long v, @Param(id = 2) boolean z, @Param(id = 3) WorkSource workSource0, @Param(id = 4) String s, @Param(id = 5) int[] arr_v, @Param(id = 6) boolean z1, @Param(id = 7) String s1, @Param(id = 8) long v1, @Param(id = 9) String s2) {
        this.zza = v;
        this.zzb = z;
        this.zzc = workSource0;
        this.zzd = s;
        this.zze = arr_v;
        this.zzf = z1;
        this.zzg = s1;
        this.zzh = v1;
        this.zzi = s2;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        Preconditions.checkNotNull(parcel0);
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeLong(parcel0, 1, this.zza);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zzc, v, false);
        SafeParcelWriter.writeString(parcel0, 4, this.zzd, false);
        SafeParcelWriter.writeIntArray(parcel0, 5, this.zze, false);
        SafeParcelWriter.writeBoolean(parcel0, 6, this.zzf);
        SafeParcelWriter.writeString(parcel0, 7, this.zzg, false);
        SafeParcelWriter.writeLong(parcel0, 8, this.zzh);
        SafeParcelWriter.writeString(parcel0, 9, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final zzb zza(String s) {
        this.zzi = s;
        return this;
    }
}

