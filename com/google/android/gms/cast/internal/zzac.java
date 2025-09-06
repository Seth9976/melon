package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.zzat;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Locale;

@Class(creator = "DeviceStatusCreator")
@Reserved({1})
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getVolume", id = 2)
    private double zza;
    @Field(getter = "getMuteState", id = 3)
    private boolean zzb;
    @Field(getter = "getActiveInputState", id = 4)
    private int zzc;
    @Field(getter = "getApplicationMetadata", id = 5)
    private ApplicationMetadata zzd;
    @Field(getter = "getStandbyState", id = 6)
    private int zze;
    @Field(getter = "getEqualizerSettings", id = 7)
    private zzat zzf;
    @Field(getter = "getStepInterval", id = 8)
    private double zzg;

    static {
        zzac.CREATOR = new zzad();
    }

    public zzac() {
        this(NaN, false, -1, null, -1, null, NaN);
    }

    @Constructor
    public zzac(@Param(id = 2) double f, @Param(id = 3) boolean z, @Param(id = 4) int v, @Param(id = 5) ApplicationMetadata applicationMetadata0, @Param(id = 6) int v1, @Param(id = 7) zzat zzat0, @Param(id = 8) double f1) {
        this.zza = f;
        this.zzb = z;
        this.zzc = v;
        this.zzd = applicationMetadata0;
        this.zze = v1;
        this.zzf = zzat0;
        this.zzg = f1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof zzac ? this.zza == ((zzac)object0).zza && this.zzb == ((zzac)object0).zzb && this.zzc == ((zzac)object0).zzc && CastUtils.zze(this.zzd, ((zzac)object0).zzd) && this.zze == ((zzac)object0).zze && CastUtils.zze(this.zzf, this.zzf) && this.zzg == ((zzac)object0).zzg : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, Boolean.valueOf(this.zzb), this.zzc, this.zzd, this.zze, this.zzf, this.zzg});
    }

    @Override
    public final String toString() {
        return String.format(Locale.ROOT, "volume=%f", this.zza);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeDouble(parcel0, 2, this.zza);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel0, 4, this.zzc);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.zzd, v, false);
        SafeParcelWriter.writeInt(parcel0, 6, this.zze);
        SafeParcelWriter.writeParcelable(parcel0, 7, this.zzf, v, false);
        SafeParcelWriter.writeDouble(parcel0, 8, this.zzg);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final double zza() {
        return this.zzg;
    }

    public final double zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zze;
    }

    public final ApplicationMetadata zze() {
        return this.zzd;
    }

    public final zzat zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return this.zzb;
    }
}

