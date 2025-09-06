package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.ICancelToken.Stub;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.location.zzad;
import com.google.android.gms.location.zzb;

public final class zzu extends zza implements zzv {
    public zzu(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzA(Location location0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, location0);
        this.zzc(13, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzB(Location location0, IStatusCallback iStatusCallback0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, location0);
        zzc.zzc(parcel0, iStatusCallback0);
        this.zzc(85, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzC(zzr zzr0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, zzr0);
        this.zzc(67, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzD(LocationSettingsRequest locationSettingsRequest0, zzab zzab0, String s) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, locationSettingsRequest0);
        zzc.zzc(parcel0, zzab0);
        parcel0.writeString(null);
        this.zzc(0x3F, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzE(zzo zzo0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, zzo0);
        this.zzc(0x5F, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzF(zzj zzj0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, zzj0);
        this.zzc(75, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzd(GeofencingRequest geofencingRequest0, PendingIntent pendingIntent0, zzt zzt0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, geofencingRequest0);
        zzc.zzb(parcel0, pendingIntent0);
        zzc.zzc(parcel0, zzt0);
        this.zzc(57, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zze(GeofencingRequest geofencingRequest0, PendingIntent pendingIntent0, IStatusCallback iStatusCallback0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, geofencingRequest0);
        zzc.zzb(parcel0, pendingIntent0);
        zzc.zzc(parcel0, iStatusCallback0);
        this.zzc(97, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzf(zzem zzem0, zzt zzt0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, zzem0);
        zzc.zzc(parcel0, zzt0);
        this.zzc(74, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzg(zzem zzem0, IStatusCallback iStatusCallback0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, zzem0);
        zzc.zzc(parcel0, iStatusCallback0);
        this.zzc(98, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzh(long v, boolean z, PendingIntent pendingIntent0) {
        Parcel parcel0 = this.zza();
        parcel0.writeLong(v);
        parcel0.writeInt(1);
        zzc.zzb(parcel0, pendingIntent0);
        this.zzc(5, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzi(zzb zzb0, PendingIntent pendingIntent0, IStatusCallback iStatusCallback0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, zzb0);
        zzc.zzb(parcel0, pendingIntent0);
        zzc.zzc(parcel0, iStatusCallback0);
        this.zzc(70, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzj(ActivityTransitionRequest activityTransitionRequest0, PendingIntent pendingIntent0, IStatusCallback iStatusCallback0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, activityTransitionRequest0);
        zzc.zzb(parcel0, pendingIntent0);
        zzc.zzc(parcel0, iStatusCallback0);
        this.zzc(72, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzk(PendingIntent pendingIntent0, IStatusCallback iStatusCallback0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, pendingIntent0);
        zzc.zzc(parcel0, iStatusCallback0);
        this.zzc(73, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzl(PendingIntent pendingIntent0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, pendingIntent0);
        this.zzc(6, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzm(PendingIntent pendingIntent0, SleepSegmentRequest sleepSegmentRequest0, IStatusCallback iStatusCallback0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, pendingIntent0);
        zzc.zzb(parcel0, sleepSegmentRequest0);
        zzc.zzc(parcel0, iStatusCallback0);
        this.zzc(0x4F, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzn(PendingIntent pendingIntent0, IStatusCallback iStatusCallback0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, pendingIntent0);
        zzc.zzc(parcel0, iStatusCallback0);
        this.zzc(69, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzo(zzad zzad0, zzee zzee0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, zzad0);
        zzc.zzb(parcel0, zzee0);
        this.zzc(91, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final LocationAvailability zzp(String s) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        Parcel parcel1 = this.zzb(34, parcel0);
        LocationAvailability locationAvailability0 = (LocationAvailability)zzc.zza(parcel1, LocationAvailability.CREATOR);
        parcel1.recycle();
        return locationAvailability0;
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzq(LastLocationRequest lastLocationRequest0, zzee zzee0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, lastLocationRequest0);
        zzc.zzb(parcel0, zzee0);
        this.zzc(90, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzr(LastLocationRequest lastLocationRequest0, zzz zzz0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, lastLocationRequest0);
        zzc.zzc(parcel0, zzz0);
        this.zzc(82, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final Location zzs() {
        Parcel parcel0 = this.zzb(7, this.zza());
        Location location0 = (Location)zzc.zza(parcel0, Location.CREATOR);
        parcel0.recycle();
        return location0;
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final ICancelToken zzt(CurrentLocationRequest currentLocationRequest0, zzee zzee0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, currentLocationRequest0);
        zzc.zzb(parcel0, zzee0);
        Parcel parcel1 = this.zzb(92, parcel0);
        ICancelToken iCancelToken0 = Stub.asInterface(parcel1.readStrongBinder());
        parcel1.recycle();
        return iCancelToken0;
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final ICancelToken zzu(CurrentLocationRequest currentLocationRequest0, zzz zzz0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, currentLocationRequest0);
        zzc.zzc(parcel0, zzz0);
        Parcel parcel1 = this.zzb(87, parcel0);
        ICancelToken iCancelToken0 = Stub.asInterface(parcel1.readStrongBinder());
        parcel1.recycle();
        return iCancelToken0;
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzv(zzei zzei0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, zzei0);
        this.zzc(59, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzw(zzee zzee0, LocationRequest locationRequest0, IStatusCallback iStatusCallback0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, zzee0);
        zzc.zzb(parcel0, locationRequest0);
        zzc.zzc(parcel0, iStatusCallback0);
        this.zzc(88, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzx(zzee zzee0, IStatusCallback iStatusCallback0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, zzee0);
        zzc.zzc(parcel0, iStatusCallback0);
        this.zzc(89, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzy(boolean z) {
        Parcel parcel0 = this.zza();
        parcel0.writeInt(((int)z));
        this.zzc(12, parcel0);
    }

    @Override  // com.google.android.gms.internal.location.zzv
    public final void zzz(boolean z, IStatusCallback iStatusCallback0) {
        Parcel parcel0 = this.zza();
        parcel0.writeInt(((int)z));
        zzc.zzc(parcel0, iStatusCallback0);
        this.zzc(84, parcel0);
    }
}

