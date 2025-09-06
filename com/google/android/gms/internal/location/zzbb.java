package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LastLocationRequest.Builder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzac;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class zzbb implements FusedLocationProviderApi {
    @Override  // com.google.android.gms.location.FusedLocationProviderApi
    public final PendingResult flushLocations(GoogleApiClient googleApiClient0) {
        return googleApiClient0.execute(new zzaq(this, googleApiClient0));
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderApi
    public final Location getLastLocation(GoogleApiClient googleApiClient0) {
        Preconditions.checkArgument(googleApiClient0 != null, "GoogleApiClient parameter is required.");
        zzdz zzdz0 = (zzdz)googleApiClient0.getClient(zzbi.zza);
        AtomicReference atomicReference0 = new AtomicReference();
        CountDownLatch countDownLatch0 = new CountDownLatch(1);
        TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
        try {
            zzdz0.zzq(new Builder().build(), taskCompletionSource0);
        }
        catch(Exception unused_ex) {
            return null;
        }
        taskCompletionSource0.getTask().addOnCompleteListener(new zzbe(atomicReference0, countDownLatch0));
        return zzfd.zza(countDownLatch0, 30L, TimeUnit.SECONDS) ? ((Location)atomicReference0.get()) : null;
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderApi
    public final LocationAvailability getLocationAvailability(GoogleApiClient googleApiClient0) {
        Preconditions.checkArgument(googleApiClient0 != null, "GoogleApiClient parameter is required.");
        zzdz zzdz0 = (zzdz)googleApiClient0.getClient(zzbi.zza);
        AtomicReference atomicReference0 = new AtomicReference();
        CountDownLatch countDownLatch0 = new CountDownLatch(1);
        TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
        try {
            zzdz0.zzp(zzac.zza(), taskCompletionSource0);
        }
        catch(RemoteException unused_ex) {
            return null;
        }
        taskCompletionSource0.getTask().addOnCompleteListener(new zzbc(atomicReference0, countDownLatch0));
        return zzfd.zza(countDownLatch0, 30L, TimeUnit.SECONDS) ? ((LocationAvailability)atomicReference0.get()) : null;
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderApi
    public final PendingResult removeLocationUpdates(GoogleApiClient googleApiClient0, PendingIntent pendingIntent0) {
        return googleApiClient0.execute(new zzav(this, googleApiClient0, pendingIntent0));
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderApi
    public final PendingResult removeLocationUpdates(GoogleApiClient googleApiClient0, LocationCallback locationCallback0) {
        return googleApiClient0.execute(new zzaw(this, googleApiClient0, locationCallback0));
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderApi
    public final PendingResult removeLocationUpdates(GoogleApiClient googleApiClient0, LocationListener locationListener0) {
        return googleApiClient0.execute(new zzau(this, googleApiClient0, locationListener0));
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderApi
    public final PendingResult requestLocationUpdates(GoogleApiClient googleApiClient0, LocationRequest locationRequest0, PendingIntent pendingIntent0) {
        return googleApiClient0.execute(new zzat(this, googleApiClient0, pendingIntent0, locationRequest0));
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderApi
    public final PendingResult requestLocationUpdates(GoogleApiClient googleApiClient0, LocationRequest locationRequest0, LocationCallback locationCallback0, Looper looper0) {
        if(looper0 == null) {
            looper0 = Looper.myLooper();
            Preconditions.checkNotNull(looper0, "invalid null looper");
        }
        return googleApiClient0.execute(new zzas(this, googleApiClient0, ListenerHolders.createListenerHolder(locationCallback0, looper0, "LocationCallback"), locationRequest0));
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderApi
    public final PendingResult requestLocationUpdates(GoogleApiClient googleApiClient0, LocationRequest locationRequest0, LocationListener locationListener0) {
        Looper looper0 = Looper.myLooper();
        Preconditions.checkNotNull(looper0, "invalid null looper");
        return googleApiClient0.execute(new zzar(this, googleApiClient0, ListenerHolders.createListenerHolder(locationListener0, looper0, "LocationListener"), locationRequest0));
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderApi
    public final PendingResult requestLocationUpdates(GoogleApiClient googleApiClient0, LocationRequest locationRequest0, LocationListener locationListener0, Looper looper0) {
        if(looper0 == null) {
            looper0 = Looper.myLooper();
            Preconditions.checkNotNull(looper0, "invalid null looper");
        }
        return googleApiClient0.execute(new zzar(this, googleApiClient0, ListenerHolders.createListenerHolder(locationListener0, looper0, "LocationListener"), locationRequest0));
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderApi
    public final PendingResult setMockLocation(GoogleApiClient googleApiClient0, Location location0) {
        return googleApiClient0.execute(new zzay(this, googleApiClient0, location0));
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderApi
    public final PendingResult setMockMode(GoogleApiClient googleApiClient0, boolean z) {
        return googleApiClient0.execute(new zzax(this, googleApiClient0, z));
    }

    public static TaskCompletionSource zza(ResultHolder baseImplementation$ResultHolder0) {
        TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
        taskCompletionSource0.getTask().addOnCompleteListener(new zzbd(baseImplementation$ResultHolder0));
        return taskCompletionSource0;
    }
}

