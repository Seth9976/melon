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
@Class(creator = "ConnectionTelemetryConfigurationCreator")
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    @KeepForSdk
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getRootTelemetryConfiguration", id = 1)
    private final RootTelemetryConfiguration zza;
    @Field(getter = "getMethodInvocationTelemetryEnabled", id = 2)
    private final boolean zzb;
    @Field(getter = "getMethodTimingTelemetryEnabled", id = 3)
    private final boolean zzc;
    @Field(getter = "getMethodInvocationMethodKeyAllowlist", id = 4)
    private final int[] zzd;
    @Field(getter = "getMaxMethodInvocationsLogged", id = 5)
    private final int zze;
    @Field(getter = "getMethodInvocationMethodKeyDisallowlist", id = 6)
    private final int[] zzf;

    static {
        ConnectionTelemetryConfiguration.CREATOR = new zzl();
    }

    @Constructor
    public ConnectionTelemetryConfiguration(@Param(id = 1) RootTelemetryConfiguration rootTelemetryConfiguration0, @Param(id = 2) boolean z, @Param(id = 3) boolean z1, @Param(id = 4) int[] arr_v, @Param(id = 5) int v, @Param(id = 6) int[] arr_v1) {
        this.zza = rootTelemetryConfiguration0;
        this.zzb = z;
        this.zzc = z1;
        this.zzd = arr_v;
        this.zze = v;
        this.zzf = arr_v1;
    }

    @KeepForSdk
    public int getMaxMethodInvocationsLogged() {
        return this.zze;
    }

    @KeepForSdk
    public int[] getMethodInvocationMethodKeyAllowlist() {
        return this.zzd;
    }

    @KeepForSdk
    public int[] getMethodInvocationMethodKeyDisallowlist() {
        return this.zzf;
    }

    @KeepForSdk
    public boolean getMethodInvocationTelemetryEnabled() {
        return this.zzb;
    }

    @KeepForSdk
    public boolean getMethodTimingTelemetryEnabled() {
        return this.zzc;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.zza, v, false);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.getMethodInvocationTelemetryEnabled());
        SafeParcelWriter.writeBoolean(parcel0, 3, this.getMethodTimingTelemetryEnabled());
        SafeParcelWriter.writeIntArray(parcel0, 4, this.getMethodInvocationMethodKeyAllowlist(), false);
        SafeParcelWriter.writeInt(parcel0, 5, this.getMaxMethodInvocationsLogged());
        SafeParcelWriter.writeIntArray(parcel0, 6, this.getMethodInvocationMethodKeyDisallowlist(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final RootTelemetryConfiguration zza() {
        return this.zza;
    }
}

