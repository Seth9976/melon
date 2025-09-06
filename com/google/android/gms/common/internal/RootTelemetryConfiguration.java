package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@KeepForSdk
@Class(creator = "RootTelemetryConfigurationCreator")
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    @KeepForSdk
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getVersion", id = 1)
    private final int zza;
    @Field(getter = "getMethodInvocationTelemetryEnabled", id = 2)
    private final boolean zzb;
    @Field(getter = "getMethodTimingTelemetryEnabled", id = 3)
    private final boolean zzc;
    @Field(getter = "getBatchPeriodMillis", id = 4)
    private final int zzd;
    @Field(getter = "getMaxMethodInvocationsInBatch", id = 5)
    private final int zze;

    static {
        RootTelemetryConfiguration.CREATOR = new zzag();
    }

    @Constructor
    public RootTelemetryConfiguration(@Param(id = 1) int v, @Param(id = 2) boolean z, @Param(id = 3) boolean z1, @Param(id = 4) int v1, @Param(id = 5) int v2) {
        this.zza = v;
        this.zzb = z;
        this.zzc = z1;
        this.zzd = v1;
        this.zze = v2;
    }

    @KeepForSdk
    public int getBatchPeriodMillis() {
        return this.zzd;
    }

    @KeepForSdk
    public int getMaxMethodInvocationsInBatch() {
        return this.zze;
    }

    @KeepForSdk
    public boolean getMethodInvocationTelemetryEnabled() {
        return this.zzb;
    }

    @KeepForSdk
    public boolean getMethodTimingTelemetryEnabled() {
        return this.zzc;
    }

    @KeepForSdk
    public int getVersion() {
        return this.zza;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.getVersion());
        SafeParcelWriter.writeBoolean(parcel0, 2, this.getMethodInvocationTelemetryEnabled());
        SafeParcelWriter.writeBoolean(parcel0, 3, this.getMethodTimingTelemetryEnabled());
        SafeParcelWriter.writeInt(parcel0, 4, this.getBatchPeriodMillis());
        SafeParcelWriter.writeInt(parcel0, 5, this.getMaxMethodInvocationsInBatch());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

