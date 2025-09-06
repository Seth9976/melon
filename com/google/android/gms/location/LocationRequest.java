package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.os.WorkSource;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.RemovedParam;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zze;
import com.google.android.gms.internal.location.zzeo;
import com.iloen.melon.utils.a;
import k8.Y;
import org.checkerframework.dataflow.qual.Pure;

@Class(creator = "LocationRequestCreator")
@Reserved({4, 5, 14, 1000})
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final class Builder {
        public static final long IMPLICIT_MAX_UPDATE_AGE = -1L;
        public static final long IMPLICIT_MIN_UPDATE_INTERVAL = -1L;
        private int zza;
        private long zzb;
        private long zzc;
        private long zzd;
        private long zze;
        private int zzf;
        private float zzg;
        private boolean zzh;
        private long zzi;
        private int zzj;
        private int zzk;
        private boolean zzl;
        private WorkSource zzm;
        private zze zzn;

        public Builder(int v, long v1) {
            this(v1);
            this.setPriority(v);
        }

        public Builder(long v) {
            this.zza = 102;
            this.zzc = -1L;
            this.zzd = 0L;
            this.zze = 0x7FFFFFFFFFFFFFFFL;
            this.zzf = 0x7FFFFFFF;
            this.zzg = 0.0f;
            this.zzh = true;
            this.zzi = -1L;
            this.zzj = 0;
            this.zzk = 0;
            this.zzl = false;
            this.zzm = null;
            this.zzn = null;
            this.setIntervalMillis(v);
        }

        public Builder(LocationRequest locationRequest0) {
            this(locationRequest0.getPriority(), locationRequest0.getIntervalMillis());
            this.setMinUpdateIntervalMillis(locationRequest0.getMinUpdateIntervalMillis());
            this.setMaxUpdateDelayMillis(locationRequest0.getMaxUpdateDelayMillis());
            this.setDurationMillis(locationRequest0.getDurationMillis());
            this.setMaxUpdates(locationRequest0.getMaxUpdates());
            this.setMinUpdateDistanceMeters(locationRequest0.getMinUpdateDistanceMeters());
            this.setWaitForAccurateLocation(locationRequest0.isWaitForAccurateLocation());
            this.setMaxUpdateAgeMillis(locationRequest0.getMaxUpdateAgeMillis());
            this.setGranularity(locationRequest0.getGranularity());
            int v = locationRequest0.zza();
            zzar.zza(v);
            this.zzk = v;
            this.zzl = locationRequest0.zzb();
            this.zzm = locationRequest0.zzc();
            zze zze0 = locationRequest0.zzd();
            Preconditions.checkArgument(zze0 == null || !zze0.zza());
            this.zzn = zze0;
        }

        public LocationRequest build() {
            int v = this.zza;
            long v1 = this.zzb;
            long v2 = this.zzc;
            if(v2 == -1L) {
                return new LocationRequest(v, v1, v1, Math.max(this.zzd, this.zzb), 0x7FFFFFFFFFFFFFFFL, this.zze, this.zzf, this.zzg, this.zzh, (this.zzi == -1L ? this.zzb : this.zzi), this.zzj, this.zzk, this.zzl, new WorkSource(this.zzm), this.zzn);
            }
            if(v != 105) {
                v2 = Math.min(v2, v1);
            }
            return new LocationRequest(v, v1, v2, Math.max(this.zzd, this.zzb), 0x7FFFFFFFFFFFFFFFL, this.zze, this.zzf, this.zzg, this.zzh, (this.zzi == -1L ? this.zzb : this.zzi), this.zzj, this.zzk, this.zzl, new WorkSource(this.zzm), this.zzn);
        }

        public Builder setDurationMillis(long v) {
            Preconditions.checkArgument(v > 0L, "durationMillis must be greater than 0");
            this.zze = v;
            return this;
        }

        public Builder setGranularity(int v) {
            zzq.zza(v);
            this.zzj = v;
            return this;
        }

        public Builder setIntervalMillis(long v) {
            Preconditions.checkArgument(v >= 0L, "intervalMillis must be greater than or equal to 0");
            this.zzb = v;
            return this;
        }

        public Builder setMaxUpdateAgeMillis(long v) {
            Preconditions.checkArgument(Long.compare(v, -1L) == 0 || v >= 0L, "maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE");
            this.zzi = v;
            return this;
        }

        public Builder setMaxUpdateDelayMillis(long v) {
            Preconditions.checkArgument(v >= 0L, "maxUpdateDelayMillis must be greater than or equal to 0");
            this.zzd = v;
            return this;
        }

        public Builder setMaxUpdates(int v) {
            Preconditions.checkArgument(v > 0, "maxUpdates must be greater than 0");
            this.zzf = v;
            return this;
        }

        public Builder setMinUpdateDistanceMeters(float f) {
            Preconditions.checkArgument(f >= 0.0f, "minUpdateDistanceMeters must be greater than or equal to 0");
            this.zzg = f;
            return this;
        }

        public Builder setMinUpdateIntervalMillis(long v) {
            Preconditions.checkArgument(Long.compare(v, -1L) == 0 || v >= 0L, "minUpdateIntervalMillis must be greater than or equal to 0, or IMPLICIT_MIN_UPDATE_INTERVAL");
            this.zzc = v;
            return this;
        }

        public Builder setPriority(int v) {
            zzan.zza(v);
            this.zza = v;
            return this;
        }

        public Builder setWaitForAccurateLocation(boolean z) {
            this.zzh = z;
            return this;
        }

        public final Builder zza(int v) {
            zzar.zza(v);
            this.zzk = v;
            return this;
        }

        public final Builder zzb(boolean z) {
            this.zzl = z;
            return this;
        }

        public final Builder zzc(WorkSource workSource0) {
            this.zzm = workSource0;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR = null;
    @Deprecated
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    @Deprecated
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    @Deprecated
    public static final int PRIORITY_LOW_POWER = 104;
    @Deprecated
    public static final int PRIORITY_NO_POWER = 105;
    @Field(defaultValueUnchecked = "Priority.PRIORITY_BALANCED_POWER_ACCURACY", getter = "getPriority", id = 1)
    private int zza;
    @Field(defaultValue = "3600000", getter = "getIntervalMillis", id = 2)
    private long zzb;
    @Field(defaultValue = "600000", getter = "getMinUpdateIntervalMillis", id = 3)
    private long zzc;
    @Field(defaultValue = "0", getter = "getMaxUpdateDelayMillis", id = 8)
    private long zzd;
    @Field(defaultValueUnchecked = "Long.MAX_VALUE", getter = "getDurationMillis", id = 10)
    private long zze;
    @Field(defaultValueUnchecked = "Integer.MAX_VALUE", getter = "getMaxUpdates", id = 6)
    private int zzf;
    @Field(defaultValue = "0", getter = "getMinUpdateDistanceMeters", id = 7)
    private float zzg;
    @Field(defaultValue = "false", getter = "isWaitForAccurateLocation", id = 9)
    private boolean zzh;
    @Field(defaultValueUnchecked = "-1", getter = "getMaxUpdateAgeMillis", id = 11)
    private long zzi;
    @Field(defaultValueUnchecked = "Granularity.GRANULARITY_PERMISSION_LEVEL", getter = "getGranularity", id = 12)
    private final int zzj;
    @Field(defaultValueUnchecked = "ThrottleBehavior.THROTTLE_BACKGROUND", getter = "getThrottleBehavior", id = 13)
    private final int zzk;
    @Field(defaultValue = "false", getter = "isBypass", id = 15)
    private final boolean zzl;
    @Field(defaultValueUnchecked = "new android.os.WorkSource()", getter = "getWorkSource", id = 16)
    private final WorkSource zzm;
    @Field(getter = "getImpersonation", id = 17)
    private final zze zzn;

    static {
        LocationRequest.CREATOR = new zzaf();
    }

    @Deprecated
    public LocationRequest() {
        this(102, 3600000L, 600000L, 0L, 0x7FFFFFFFFFFFFFFFL, 0x7FFFFFFFFFFFFFFFL, 0x7FFFFFFF, 0.0f, true, 3600000L, 0, 0, false, new WorkSource(), null);
    }

    @Constructor
    public LocationRequest(@Param(id = 1) int v, @Param(id = 2) long v1, @Param(id = 3) long v2, @Param(id = 8) long v3, @RemovedParam(defaultValueUnchecked = "Long.MAX_VALUE", id = 5) long v4, @Param(id = 10) long v5, @Param(id = 6) int v6, @Param(id = 7) float f, @Param(id = 9) boolean z, @Param(id = 11) long v7, @Param(id = 12) int v8, @Param(id = 13) int v9, @Param(id = 15) boolean z1, @Param(id = 16) WorkSource workSource0, @Param(id = 17) zze zze0) {
        this.zza = v;
        this.zzb = v == 105 ? 0x7FFFFFFFFFFFFFFFL : v1;
        this.zzc = v2;
        this.zzd = v3;
        this.zze = v4 == 0x7FFFFFFFFFFFFFFFL ? v5 : Math.min(Math.max(1L, v4 - SystemClock.elapsedRealtime()), v5);
        this.zzf = v6;
        this.zzg = f;
        this.zzh = z;
        if(v7 != -1L) {
            v1 = v7;
        }
        this.zzi = v1;
        this.zzj = v8;
        this.zzk = v9;
        this.zzl = z1;
        this.zzm = workSource0;
        this.zzn = zze0;
    }

    @Deprecated
    public static LocationRequest create() {
        return new LocationRequest(102, 3600000L, 600000L, 0L, 0x7FFFFFFFFFFFFFFFL, 0x7FFFFFFFFFFFFFFFL, 0x7FFFFFFF, 0.0f, true, 3600000L, 0, 0, false, new WorkSource(), null);
    }

    // 去混淆评级： 中等(50)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof LocationRequest && this.zza == ((LocationRequest)object0).zza && (this.isPassive() || this.zzb == ((LocationRequest)object0).zzb) && this.zzc == ((LocationRequest)object0).zzc && this.isBatched() == ((LocationRequest)object0).isBatched() && (!this.isBatched() || this.zzd == ((LocationRequest)object0).zzd) && this.zze == ((LocationRequest)object0).zze && this.zzf == ((LocationRequest)object0).zzf && this.zzg == ((LocationRequest)object0).zzg && this.zzh == ((LocationRequest)object0).zzh && this.zzj == ((LocationRequest)object0).zzj && this.zzk == ((LocationRequest)object0).zzk && this.zzl == ((LocationRequest)object0).zzl && this.zzm.equals(((LocationRequest)object0).zzm) && Objects.equal(this.zzn, ((LocationRequest)object0).zzn);
    }

    @Pure
    public long getDurationMillis() {
        return this.zze;
    }

    @Deprecated
    @Pure
    public long getExpirationTime() {
        long v = SystemClock.elapsedRealtime();
        long v1 = v + this.zze;
        return ((v ^ v1) & (this.zze ^ v1)) >= 0L ? v1 : 0x7FFFFFFFFFFFFFFFL;
    }

    @Deprecated
    @Pure
    public long getFastestInterval() {
        return this.getMinUpdateIntervalMillis();
    }

    @Pure
    public int getGranularity() {
        return this.zzj;
    }

    @Deprecated
    @Pure
    public long getInterval() {
        return this.getIntervalMillis();
    }

    @Pure
    public long getIntervalMillis() {
        return this.zzb;
    }

    @Pure
    public long getMaxUpdateAgeMillis() {
        return this.zzi;
    }

    @Pure
    public long getMaxUpdateDelayMillis() {
        return this.zzd;
    }

    @Pure
    public int getMaxUpdates() {
        return this.zzf;
    }

    @Deprecated
    @Pure
    public long getMaxWaitTime() {
        return Math.max(this.zzd, this.zzb);
    }

    @Pure
    public float getMinUpdateDistanceMeters() {
        return this.zzg;
    }

    @Pure
    public long getMinUpdateIntervalMillis() {
        return this.zzc;
    }

    @Deprecated
    @Pure
    public int getNumUpdates() {
        return this.getMaxUpdates();
    }

    @Pure
    public int getPriority() {
        return this.zza;
    }

    @Deprecated
    @Pure
    public float getSmallestDisplacement() {
        return this.getMinUpdateDistanceMeters();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzm});
    }

    @Pure
    public boolean isBatched() {
        return this.zzd > 0L && this.zzd >> 1 >= this.zzb;
    }

    @Deprecated
    @Pure
    public boolean isFastestIntervalExplicitlySet() {
        return true;
    }

    @Pure
    public boolean isPassive() {
        return this.zza == 105;
    }

    public boolean isWaitForAccurateLocation() {
        return this.zzh;
    }

    @Deprecated
    public LocationRequest setExpirationDuration(long v) {
        Preconditions.checkArgument(v > 0L, "durationMillis must be greater than 0");
        this.zze = v;
        return this;
    }

    @Deprecated
    public LocationRequest setExpirationTime(long v) {
        this.zze = Math.max(1L, v - SystemClock.elapsedRealtime());
        return this;
    }

    @Deprecated
    public LocationRequest setFastestInterval(long v) {
        Preconditions.checkArgument(v >= 0L, "illegal fastest interval: %d", new Object[]{v});
        this.zzc = v;
        return this;
    }

    @Deprecated
    public LocationRequest setInterval(long v) {
        Preconditions.checkArgument(v >= 0L, "intervalMillis must be greater than or equal to 0");
        long v1 = this.zzb;
        if(this.zzc == v1 / 6L) {
            this.zzc = v / 6L;
        }
        if(this.zzi == v1) {
            this.zzi = v;
        }
        this.zzb = v;
        return this;
    }

    @Deprecated
    public LocationRequest setMaxWaitTime(long v) {
        Preconditions.checkArgument(v >= 0L, "illegal max wait time: %d", new Object[]{v});
        this.zzd = v;
        return this;
    }

    @Deprecated
    public LocationRequest setNumUpdates(int v) {
        if(v <= 0) {
            throw new IllegalArgumentException(a.k(v, "invalid numUpdates: ", new StringBuilder(String.valueOf(v).length() + 20)));
        }
        this.zzf = v;
        return this;
    }

    @Deprecated
    public LocationRequest setPriority(int v) {
        zzan.zza(v);
        this.zza = v;
        return this;
    }

    @Deprecated
    public LocationRequest setSmallestDisplacement(float f) {
        if(f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
        this.zzg = f;
        return this;
    }

    @Deprecated
    public LocationRequest setWaitForAccurateLocation(boolean z) {
        this.zzh = z;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = Y.p("Request[");
        if(this.isPassive()) {
            stringBuilder0.append(zzan.zzb(this.zza));
            if(this.zzd > 0L) {
                stringBuilder0.append("/");
                zzeo.zzc(this.zzd, stringBuilder0);
            }
        }
        else {
            stringBuilder0.append("@");
            if(this.isBatched()) {
                zzeo.zzc(this.zzb, stringBuilder0);
                stringBuilder0.append("/");
                zzeo.zzc(this.zzd, stringBuilder0);
            }
            else {
                zzeo.zzc(this.zzb, stringBuilder0);
            }
            stringBuilder0.append(" ");
            stringBuilder0.append(zzan.zzb(this.zza));
        }
        if(this.isPassive() || this.zzc != this.zzb) {
            stringBuilder0.append(", minUpdateInterval=");
            stringBuilder0.append(LocationRequest.zze(this.zzc));
        }
        if(((double)this.zzg) > 0.0) {
            stringBuilder0.append(", minUpdateDistance=");
            stringBuilder0.append(this.zzg);
        }
        if(!this.isPassive()) {
            if(this.zzi != this.zzb) {
                stringBuilder0.append(", maxUpdateAge=");
                stringBuilder0.append(LocationRequest.zze(this.zzi));
            }
        }
        else if(this.zzi != 0x7FFFFFFFFFFFFFFFL) {
            stringBuilder0.append(", maxUpdateAge=");
            stringBuilder0.append(LocationRequest.zze(this.zzi));
        }
        if(this.zze != 0x7FFFFFFFFFFFFFFFL) {
            stringBuilder0.append(", duration=");
            zzeo.zzc(this.zze, stringBuilder0);
        }
        if(this.zzf != 0x7FFFFFFF) {
            stringBuilder0.append(", maxUpdates=");
            stringBuilder0.append(this.zzf);
        }
        if(this.zzk != 0) {
            stringBuilder0.append(", ");
            stringBuilder0.append(zzar.zzb(this.zzk));
        }
        if(this.zzj != 0) {
            stringBuilder0.append(", ");
            stringBuilder0.append(zzq.zzb(this.zzj));
        }
        if(this.zzh) {
            stringBuilder0.append(", waitForAccurateLocation");
        }
        if(this.zzl) {
            stringBuilder0.append(", bypass");
        }
        if(!WorkSourceUtil.isEmpty(this.zzm)) {
            stringBuilder0.append(", ");
            stringBuilder0.append(this.zzm);
        }
        if(this.zzn != null) {
            stringBuilder0.append(", impersonation=");
            stringBuilder0.append(this.zzn);
        }
        stringBuilder0.append(']');
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.getPriority());
        SafeParcelWriter.writeLong(parcel0, 2, this.getIntervalMillis());
        SafeParcelWriter.writeLong(parcel0, 3, this.getMinUpdateIntervalMillis());
        SafeParcelWriter.writeInt(parcel0, 6, this.getMaxUpdates());
        SafeParcelWriter.writeFloat(parcel0, 7, this.getMinUpdateDistanceMeters());
        SafeParcelWriter.writeLong(parcel0, 8, this.getMaxUpdateDelayMillis());
        SafeParcelWriter.writeBoolean(parcel0, 9, this.isWaitForAccurateLocation());
        SafeParcelWriter.writeLong(parcel0, 10, this.getDurationMillis());
        SafeParcelWriter.writeLong(parcel0, 11, this.getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel0, 12, this.getGranularity());
        SafeParcelWriter.writeInt(parcel0, 13, this.zzk);
        SafeParcelWriter.writeBoolean(parcel0, 15, this.zzl);
        SafeParcelWriter.writeParcelable(parcel0, 16, this.zzm, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 17, this.zzn, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Pure
    public final int zza() {
        return this.zzk;
    }

    @Pure
    public final boolean zzb() {
        return this.zzl;
    }

    @Pure
    public final WorkSource zzc() {
        return this.zzm;
    }

    @Pure
    public final zze zzd() {
        return this.zzn;
    }

    private static String zze(long v) {
        return v == 0x7FFFFFFFFFFFFFFFL ? "∞" : zzeo.zzb(v);
    }
}

