package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import com.google.android.gms.common.api.internal.IStatusCallback;
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

public interface zzv extends IInterface {
    @Deprecated
    void zzA(Location arg1);

    void zzB(Location arg1, IStatusCallback arg2);

    void zzC(zzr arg1);

    void zzD(LocationSettingsRequest arg1, zzab arg2, String arg3);

    void zzE(zzo arg1);

    void zzF(zzj arg1);

    @Deprecated
    void zzd(GeofencingRequest arg1, PendingIntent arg2, zzt arg3);

    void zze(GeofencingRequest arg1, PendingIntent arg2, IStatusCallback arg3);

    @Deprecated
    void zzf(zzem arg1, zzt arg2);

    void zzg(zzem arg1, IStatusCallback arg2);

    void zzh(long arg1, boolean arg2, PendingIntent arg3);

    void zzi(zzb arg1, PendingIntent arg2, IStatusCallback arg3);

    void zzj(ActivityTransitionRequest arg1, PendingIntent arg2, IStatusCallback arg3);

    void zzk(PendingIntent arg1, IStatusCallback arg2);

    void zzl(PendingIntent arg1);

    void zzm(PendingIntent arg1, SleepSegmentRequest arg2, IStatusCallback arg3);

    void zzn(PendingIntent arg1, IStatusCallback arg2);

    void zzo(zzad arg1, zzee arg2);

    @Deprecated
    LocationAvailability zzp(String arg1);

    void zzq(LastLocationRequest arg1, zzee arg2);

    @Deprecated
    void zzr(LastLocationRequest arg1, zzz arg2);

    @Deprecated
    Location zzs();

    ICancelToken zzt(CurrentLocationRequest arg1, zzee arg2);

    @Deprecated
    ICancelToken zzu(CurrentLocationRequest arg1, zzz arg2);

    @Deprecated
    void zzv(zzei arg1);

    void zzw(zzee arg1, LocationRequest arg2, IStatusCallback arg3);

    void zzx(zzee arg1, IStatusCallback arg2);

    @Deprecated
    void zzy(boolean arg1);

    void zzz(boolean arg1, IStatusCallback arg2);
}

