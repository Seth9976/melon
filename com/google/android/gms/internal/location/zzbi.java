package com.google.android.gms.internal.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.CurrentLocationRequest.Builder;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.DeviceOrientationListener;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzac;
import com.google.android.gms.location.zzo;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;

public final class zzbi extends GoogleApi implements FusedLocationProviderClient {
    static final ClientKey zza;
    public static final Api zzb;
    private static final Object zzc;
    private static Object zzd;

    static {
        ClientKey api$ClientKey0 = new ClientKey();
        zzbi.zza = api$ClientKey0;
        zzbi.zzb = new Api("LocationServices.API", new zzbf(), api$ClientKey0);
        zzbi.zzc = new Object();
    }

    public zzbi(Activity activity0) {
        super(activity0, zzbi.zzb, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    public zzbi(Context context0) {
        super(context0, zzbi.zzb, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task flushLocations() {
        return this.doWrite(TaskApiCall.builder().run(zzca.zza).setMethodKey(0x976).build());
    }

    @Override  // com.google.android.gms.common.api.GoogleApi
    public final String getApiFallbackAttributionTag(Context context0) {
        return null;
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task getCurrentLocation(int v, CancellationToken cancellationToken0) {
        Builder currentLocationRequest$Builder0 = new Builder();
        currentLocationRequest$Builder0.setPriority(v);
        CurrentLocationRequest currentLocationRequest0 = currentLocationRequest$Builder0.build();
        if(cancellationToken0 != null) {
            Preconditions.checkArgument(!cancellationToken0.isCancellationRequested(), "cancellationToken may not be already canceled");
        }
        Task task0 = this.doRead(TaskApiCall.builder().run(new zzbp(currentLocationRequest0, cancellationToken0)).setMethodKey(0x96F).build());
        if(cancellationToken0 != null) {
            TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource(cancellationToken0);
            task0.continueWith(new zzbq(taskCompletionSource0));
            return taskCompletionSource0.getTask();
        }
        return task0;
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task getCurrentLocation(CurrentLocationRequest currentLocationRequest0, CancellationToken cancellationToken0) {
        if(cancellationToken0 != null) {
            Preconditions.checkArgument(!cancellationToken0.isCancellationRequested(), "cancellationToken may not be already canceled");
        }
        Task task0 = this.doRead(TaskApiCall.builder().run(new zzbp(currentLocationRequest0, cancellationToken0)).setMethodKey(0x96F).build());
        if(cancellationToken0 != null) {
            TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource(cancellationToken0);
            task0.continueWith(new zzbq(taskCompletionSource0));
            return taskCompletionSource0.getTask();
        }
        return task0;
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task getLastLocation() {
        return this.doRead(TaskApiCall.builder().run(zzby.zza).setMethodKey(0x96E).build());
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task getLastLocation(LastLocationRequest lastLocationRequest0) {
        return this.doRead(TaskApiCall.builder().run(new zzbj(lastLocationRequest0)).setMethodKey(0x96E).setFeatures(new Feature[]{zzo.zzf}).build());
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task getLocationAvailability() {
        return this.doRead(TaskApiCall.builder().run((zzbr this, Object object1) -> ((zzdz)object0).zzp(zzac.zza(), ((TaskCompletionSource)object1))).setMethodKey(0x970).build());
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task removeDeviceOrientationUpdates(DeviceOrientationListener deviceOrientationListener0) {
        return this.doUnregisterEventListener(ListenerHolders.createListenerKey(deviceOrientationListener0, "DeviceOrientationListener"), 2440).continueWith(zzcg.zza, (Task task0) -> null);
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task removeLocationUpdates(PendingIntent pendingIntent0) {
        return this.doWrite(TaskApiCall.builder().run(new zzbx(pendingIntent0)).setMethodKey(0x972).build());
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task removeLocationUpdates(LocationCallback locationCallback0) {
        return this.doUnregisterEventListener(ListenerHolders.createListenerKey(locationCallback0, "LocationCallback"), 0x972).continueWith(zzce.zza, (Task task0) -> null);
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task removeLocationUpdates(LocationListener locationListener0) {
        return this.doUnregisterEventListener(ListenerHolders.createListenerKey(locationListener0, "LocationListener"), 0x972).continueWith(zzch.zza, (Task task0) -> null);
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task requestDeviceOrientationUpdates(DeviceOrientationRequest deviceOrientationRequest0, DeviceOrientationListener deviceOrientationListener0, Looper looper0) {
        if(looper0 == null) {
            looper0 = Looper.myLooper();
            Preconditions.checkNotNull(looper0, "invalid null looper");
        }
        return this.zzc(deviceOrientationRequest0, ListenerHolders.createListenerHolder(deviceOrientationListener0, looper0, "DeviceOrientationListener"));
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task requestDeviceOrientationUpdates(DeviceOrientationRequest deviceOrientationRequest0, Executor executor0, DeviceOrientationListener deviceOrientationListener0) {
        return this.zzc(deviceOrientationRequest0, ListenerHolders.createListenerHolder(deviceOrientationListener0, executor0, "DeviceOrientationListener"));
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task requestLocationUpdates(LocationRequest locationRequest0, PendingIntent pendingIntent0) {
        return this.doWrite(TaskApiCall.builder().run(new zzbs(pendingIntent0, locationRequest0)).setMethodKey(0x971).build());
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task requestLocationUpdates(LocationRequest locationRequest0, LocationCallback locationCallback0, Looper looper0) {
        if(looper0 == null) {
            looper0 = Looper.myLooper();
            Preconditions.checkNotNull(looper0, "invalid null looper");
        }
        return this.zzb(locationRequest0, ListenerHolders.createListenerHolder(locationCallback0, looper0, "LocationCallback"));
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task requestLocationUpdates(LocationRequest locationRequest0, LocationListener locationListener0, Looper looper0) {
        if(looper0 == null) {
            looper0 = Looper.myLooper();
            Preconditions.checkNotNull(looper0, "invalid null looper");
        }
        return this.zza(locationRequest0, ListenerHolders.createListenerHolder(locationListener0, looper0, "LocationListener"));
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task requestLocationUpdates(LocationRequest locationRequest0, Executor executor0, LocationCallback locationCallback0) {
        return this.zzb(locationRequest0, ListenerHolders.createListenerHolder(locationCallback0, executor0, "LocationCallback"));
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task requestLocationUpdates(LocationRequest locationRequest0, Executor executor0, LocationListener locationListener0) {
        return this.zza(locationRequest0, ListenerHolders.createListenerHolder(locationListener0, executor0, "LocationListener"));
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task setMockLocation(Location location0) {
        Preconditions.checkArgument(location0 != null);
        return this.doWrite(TaskApiCall.builder().run(new zzbl(location0)).setMethodKey(0x975).build());
    }

    @Override  // com.google.android.gms.location.FusedLocationProviderClient
    public final Task setMockMode(boolean z) {
        synchronized(zzbi.zzc) {
            if(!z) {
                Object object2 = zzbi.zzd;
                if(object2 != null) {
                    zzbi.zzd = null;
                    return this.doUnregisterEventListener(ListenerHolders.createListenerKey(object2, "Object"), 2420).continueWith(zzcf.zza, (Task task0) -> null);
                }
            }
            else if(zzbi.zzd == null) {
                Object object1 = new Object();
                zzbi.zzd = object1;
                return this.doRegisterEventListener(RegistrationMethods.builder().register(zzcb.zza).unregister(zzcc.zza).withHolder(ListenerHolders.createListenerHolder(object1, Looper.getMainLooper(), "Object")).setMethodKey(2420).build());
            }
        }
        return Tasks.forResult(null);
    }

    private final Task zza(LocationRequest locationRequest0, ListenerHolder listenerHolder0) {
        zzbh zzbh0 = new zzbh(this, listenerHolder0, zzcd.zza);
        zzbt zzbt0 = new zzbt(zzbh0, locationRequest0);
        return this.doRegisterEventListener(RegistrationMethods.builder().register(zzbt0).unregister(zzbh0).withHolder(listenerHolder0).setMethodKey(0x983).build());
    }

    private final Task zzb(LocationRequest locationRequest0, ListenerHolder listenerHolder0) {
        zzbh zzbh0 = new zzbh(this, listenerHolder0, zzbz.zza);
        zzbu zzbu0 = new zzbu(zzbh0, locationRequest0);
        return this.doRegisterEventListener(RegistrationMethods.builder().register(zzbu0).unregister(zzbh0).withHolder(listenerHolder0).setMethodKey(0x984).build());
    }

    private final Task zzc(DeviceOrientationRequest deviceOrientationRequest0, ListenerHolder listenerHolder0) {
        zzbm zzbm0 = new zzbm(listenerHolder0, deviceOrientationRequest0);
        zzbn zzbn0 = new zzbn(listenerHolder0);
        return this.doRegisterEventListener(RegistrationMethods.builder().register(zzbm0).unregister(zzbn0).withHolder(listenerHolder0).setMethodKey(0x982).build());
    }
}

