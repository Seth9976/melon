package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.location.Geofence;
import com.iloen.melon.utils.a;
import java.util.Locale;

@Class(creator = "ParcelableGeofenceCreator")
@Reserved({1000})
public final class zzek extends AbstractSafeParcelable implements Geofence {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getRequestId", id = 1)
    private final String zza;
    @Field(getter = "getExpirationTime", id = 2)
    private final long zzb;
    @Field(getter = "getType", id = 3)
    private final short zzc;
    @Field(getter = "getLatitude", id = 4)
    private final double zzd;
    @Field(getter = "getLongitude", id = 5)
    private final double zze;
    @Field(getter = "getRadius", id = 6)
    private final float zzf;
    @Field(getter = "getTransitionTypes", id = 7)
    private final int zzg;
    @Field(defaultValue = "0", getter = "getNotificationResponsiveness", id = 8)
    private final int zzh;
    @Field(defaultValue = "-1", getter = "getLoiteringDelay", id = 9)
    private final int zzi;

    static {
        zzek.CREATOR = new zzel();
    }

    @Constructor
    public zzek(@Param(id = 1) String s, @Param(id = 7) int v, @Param(id = 3) short v1, @Param(id = 4) double f, @Param(id = 5) double f1, @Param(id = 6) float f2, @Param(id = 2) long v2, @Param(id = 8) int v3, @Param(id = 9) int v4) {
        if(s == null || s.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + s);
        }
        if(f2 <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f2);
        }
        if(f > 90.0 || f < -90.0) {
            throw new IllegalArgumentException("invalid latitude: " + f);
        }
        if(f1 > 180.0 || f1 < -180.0) {
            throw new IllegalArgumentException("invalid longitude: " + f1);
        }
        if((v & 7) == 0) {
            throw new IllegalArgumentException(a.k(v, "No supported transition specified: ", new StringBuilder(String.valueOf(v).length() + 35)));
        }
        this.zzc = v1;
        this.zza = s;
        this.zzd = f;
        this.zze = f1;
        this.zzf = f2;
        this.zzb = v2;
        this.zzg = v & 7;
        this.zzh = v3;
        this.zzi = v4;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzek && this.zzf == ((zzek)object0).zzf && this.zzd == ((zzek)object0).zzd && this.zze == ((zzek)object0).zze && this.zzc == ((zzek)object0).zzc && this.zzg == ((zzek)object0).zzg;
    }

    @Override  // com.google.android.gms.location.Geofence
    public final long getExpirationTime() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.location.Geofence
    public final double getLatitude() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.location.Geofence
    public final int getLoiteringDelay() {
        return this.zzi;
    }

    @Override  // com.google.android.gms.location.Geofence
    public final double getLongitude() {
        return this.zze;
    }

    @Override  // com.google.android.gms.location.Geofence
    public final int getNotificationResponsiveness() {
        return this.zzh;
    }

    @Override  // com.google.android.gms.location.Geofence
    public final float getRadius() {
        return this.zzf;
    }

    @Override  // com.google.android.gms.location.Geofence
    public final String getRequestId() {
        return this.zza;
    }

    @Override  // com.google.android.gms.location.Geofence
    public final int getTransitionTypes() {
        return this.zzg;
    }

    @Override
    public final int hashCode() {
        long v = Double.doubleToLongBits(this.zzd);
        long v1 = Double.doubleToLongBits(this.zze);
        return ((Float.floatToIntBits(this.zzf) + ((((int)(v ^ v >>> 0x20)) + 0x1F) * 0x1F + ((int)(v1 ^ v1 >>> 0x20))) * 0x1F) * 0x1F + this.zzc) * 0x1F + this.zzg;
    }

    @Override
    public final String toString() {
        Locale locale0 = Locale.US;
        switch(this.zzc) {
            case -1: {
                return String.format(locale0, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", "INVALID", this.zza.replaceAll("\\p{C}", "?"), this.zzg, this.zzd, this.zze, this.zzf, ((int)(this.zzh / 1000)), this.zzi, this.zzb);
            }
            case 1: {
                return String.format(locale0, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", "CIRCLE", this.zza.replaceAll("\\p{C}", "?"), this.zzg, this.zzd, this.zze, this.zzf, ((int)(this.zzh / 1000)), this.zzi, this.zzb);
            }
            default: {
                return String.format(locale0, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", "UNKNOWN", this.zza.replaceAll("\\p{C}", "?"), this.zzg, this.zzd, this.zze, this.zzf, ((int)(this.zzh / 1000)), this.zzi, this.zzb);
            }
        }
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeLong(parcel0, 2, this.zzb);
        SafeParcelWriter.writeShort(parcel0, 3, this.zzc);
        SafeParcelWriter.writeDouble(parcel0, 4, this.zzd);
        SafeParcelWriter.writeDouble(parcel0, 5, this.zze);
        SafeParcelWriter.writeFloat(parcel0, 6, this.zzf);
        SafeParcelWriter.writeInt(parcel0, 7, this.zzg);
        SafeParcelWriter.writeInt(parcel0, 8, this.zzh);
        SafeParcelWriter.writeInt(parcel0, 9, this.zzi);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

