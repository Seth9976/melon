package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.collection.V;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationRequest.Builder;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzad;
import com.google.android.gms.location.zzo;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.iloen.melon.utils.a;
import java.util.Objects;

public final class zzdz extends GmsClient {
    public static final int zze;
    private final V zzf;
    private final V zzg;
    private final V zzh;
    private final V zzi;

    public zzdz(Context context0, Looper looper0, ClientSettings clientSettings0, ConnectionCallbacks connectionCallbacks0, OnConnectionFailedListener onConnectionFailedListener0) {
        super(context0, looper0, 23, clientSettings0, connectionCallbacks0, onConnectionFailedListener0);
        this.zzf = new V(0);
        this.zzg = new V(0);
        this.zzh = new V(0);
        this.zzi = new V(0);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final IInterface createServiceInterface(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return iInterface0 instanceof zzv ? ((zzv)iInterface0) : new zzu(iBinder0);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return zzo.zzp;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final int getMinApkVersion() {
        return 11717000;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionSuspended(int v) {
        super.onConnectionSuspended(v);
        synchronized(this.zzf) {
            this.zzf.clear();
        }
        synchronized(this.zzg) {
            this.zzg.clear();
        }
        synchronized(this.zzh) {
            this.zzh.clear();
        }
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    public final void zzA(Location location0, TaskCompletionSource taskCompletionSource0) {
        if(this.zzG(zzo.zzh)) {
            ((zzv)this.getService()).zzB(location0, new zzdj(null, taskCompletionSource0));
            return;
        }
        ((zzv)this.getService()).zzA(location0);
        taskCompletionSource0.setResult(null);
    }

    public final void zzB(TaskCompletionSource taskCompletionSource0) {
        ((zzv)this.getService()).zzC(new zzdn(null, taskCompletionSource0));
    }

    public final void zzC(ListenerHolder listenerHolder0, DeviceOrientationRequest deviceOrientationRequest0, TaskCompletionSource taskCompletionSource0) {
        ListenerKey listenerHolder$ListenerKey0 = listenerHolder0.getListenerKey();
        Objects.requireNonNull(listenerHolder$ListenerKey0);
        synchronized(this.zzh) {
            zzdq zzdq0 = (zzdq)this.zzh.get(listenerHolder$ListenerKey0);
            if(zzdq0 == null) {
                zzdq0 = new zzdq(listenerHolder0);
                this.zzh.put(listenerHolder$ListenerKey0, zzdq0);
            }
            else {
                zzdq0.zzc(listenerHolder0);
            }
            ((zzv)this.getService()).zzF(new zzj(1, new zzh(deviceOrientationRequest0, zzh.zza, null), zzdq0, new zzdn(null, taskCompletionSource0)));
        }
    }

    public final void zzD(ListenerKey listenerHolder$ListenerKey0, TaskCompletionSource taskCompletionSource0) {
        synchronized(this.zzh) {
            zzdq zzdq0 = (zzdq)this.zzh.remove(listenerHolder$ListenerKey0);
            if(zzdq0 == null) {
                taskCompletionSource0.setResult(Boolean.FALSE);
                return;
            }
            zzdq0.zze();
            ((zzv)this.getService()).zzF(new zzj(2, null, zzdq0, new zzdn(Boolean.TRUE, taskCompletionSource0)));
        }
    }

    public final void zzE(GeofencingRequest geofencingRequest0, PendingIntent pendingIntent0, TaskCompletionSource taskCompletionSource0) {
        if(this.zzG(zzo.zzn)) {
            ((zzv)this.getService()).zze(geofencingRequest0, pendingIntent0, new zzdj(null, taskCompletionSource0));
            return;
        }
        ((zzv)this.getService()).zzd(geofencingRequest0, pendingIntent0, new zzdg(taskCompletionSource0));
    }

    public final void zzF(zzem zzem0, TaskCompletionSource taskCompletionSource0) {
        if(this.zzG(zzo.zzn)) {
            ((zzv)this.getService()).zzg(zzem0, new zzdj(null, taskCompletionSource0));
            return;
        }
        ((zzv)this.getService()).zzf(zzem0, new zzdg(taskCompletionSource0));
    }

    private final boolean zzG(Feature feature0) {
        Feature[] arr_feature = this.getAvailableFeatures();
        if(arr_feature != null) {
            for(int v = 0; v < arr_feature.length; ++v) {
                Feature feature1 = arr_feature[v];
                if(feature0.getName().equals(feature1.getName())) {
                    return feature1 == null ? false : feature1.getVersion() >= feature0.getVersion();
                }
            }
            throw new NullPointerException();
        }
        return false;
    }

    public final void zzp(zzad zzad0, TaskCompletionSource taskCompletionSource0) {
        if(this.zzG(zzo.zzj)) {
            ((zzv)this.getService()).zzo(zzad0, new zzee(5, null, new zzdl(taskCompletionSource0), null, null));
            return;
        }
        taskCompletionSource0.setResult(((zzv)this.getService()).zzp("com.iloen.melon"));
    }

    public final void zzq(LastLocationRequest lastLocationRequest0, TaskCompletionSource taskCompletionSource0) {
        if(this.zzG(zzo.zzj)) {
            ((zzv)this.getService()).zzq(lastLocationRequest0, zzee.zzd(new zzdk(taskCompletionSource0)));
            return;
        }
        if(this.zzG(zzo.zzf)) {
            ((zzv)this.getService()).zzr(lastLocationRequest0, new zzdk(taskCompletionSource0));
            return;
        }
        taskCompletionSource0.setResult(((zzv)this.getService()).zzs());
    }

    public final void zzr(CurrentLocationRequest currentLocationRequest0, CancellationToken cancellationToken0, TaskCompletionSource taskCompletionSource0) {
        if(this.zzG(zzo.zzj)) {
            ICancelToken iCancelToken0 = ((zzv)this.getService()).zzt(currentLocationRequest0, zzee.zzd(new zzdk(taskCompletionSource0)));
            if(cancellationToken0 != null) {
                cancellationToken0.onCanceledRequested(new zzed(iCancelToken0));
            }
        }
        else if(this.zzG(zzo.zze)) {
            ICancelToken iCancelToken1 = ((zzv)this.getService()).zzu(currentLocationRequest0, new zzdk(taskCompletionSource0));
            if(cancellationToken0 != null) {
                cancellationToken0.onCanceledRequested(new zzeb(iCancelToken1));
            }
        }
        else {
            ListenerHolder listenerHolder0 = ListenerHolders.createListenerHolder(new zzdh(this, taskCompletionSource0), zzfc.zza(), "GetCurrentLocation");
            ListenerKey listenerHolder$ListenerKey0 = listenerHolder0.getListenerKey();
            Objects.requireNonNull(listenerHolder$ListenerKey0);
            zzdi zzdi0 = new zzdi(this, listenerHolder0, taskCompletionSource0);
            TaskCompletionSource taskCompletionSource1 = new TaskCompletionSource();
            Builder locationRequest$Builder0 = new Builder(currentLocationRequest0.getPriority(), 0L);
            locationRequest$Builder0.setMinUpdateIntervalMillis(0L);
            locationRequest$Builder0.setDurationMillis(currentLocationRequest0.getDurationMillis());
            locationRequest$Builder0.setGranularity(currentLocationRequest0.getGranularity());
            locationRequest$Builder0.setMaxUpdateAgeMillis(currentLocationRequest0.getMaxUpdateAgeMillis());
            locationRequest$Builder0.zzb(currentLocationRequest0.zza());
            locationRequest$Builder0.zza(currentLocationRequest0.zzb());
            locationRequest$Builder0.setWaitForAccurateLocation(true);
            locationRequest$Builder0.zzc(currentLocationRequest0.zzc());
            this.zzt(zzdi0, locationRequest$Builder0.build(), taskCompletionSource1);
            taskCompletionSource1.getTask().addOnCompleteListener(new zzea(taskCompletionSource0));
            if(cancellationToken0 != null) {
                cancellationToken0.onCanceledRequested(new zzec(this, listenerHolder$ListenerKey0));
            }
        }
    }

    public final void zzs(zzdr zzdr0, LocationRequest locationRequest0, TaskCompletionSource taskCompletionSource0) {
        zzdy zzdy1;
        ListenerHolder listenerHolder0 = zzdr0.zza();
        ListenerKey listenerHolder$ListenerKey0 = listenerHolder0.getListenerKey();
        Objects.requireNonNull(listenerHolder$ListenerKey0);
        boolean z = this.zzG(zzo.zzj);
        synchronized(this.zzf) {
            zzdy zzdy0 = (zzdy)this.zzf.get(listenerHolder$ListenerKey0);
            if(zzdy0 == null || z) {
                zzdy zzdy2 = new zzdy(zzdr0);
                this.zzf.put(listenerHolder$ListenerKey0, zzdy2);
                zzdy1 = zzdy2;
            }
            else {
                zzdy0.zzc(listenerHolder0);
                zzdy1 = zzdy0;
                zzdy0 = null;
            }
            if(z) {
                ((zzv)this.getService()).zzw(zzee.zza(zzdy0, zzdy1, listenerHolder$ListenerKey0.toIdString()), locationRequest0, new zzdj(null, taskCompletionSource0));
            }
            else {
                ((zzv)this.getService()).zzv(new zzei(1, zzeg.zza(null, locationRequest0), zzdy1, null, null, new zzdo(taskCompletionSource0, zzdy1), listenerHolder$ListenerKey0.toIdString()));
            }
        }
    }

    public final void zzt(zzdr zzdr0, LocationRequest locationRequest0, TaskCompletionSource taskCompletionSource0) {
        zzdv zzdv1;
        ListenerHolder listenerHolder0 = zzdr0.zza();
        ListenerKey listenerHolder$ListenerKey0 = listenerHolder0.getListenerKey();
        Objects.requireNonNull(listenerHolder$ListenerKey0);
        boolean z = this.zzG(zzo.zzj);
        synchronized(this.zzg) {
            zzdv zzdv0 = (zzdv)this.zzg.get(listenerHolder$ListenerKey0);
            if(zzdv0 == null || z) {
                zzdv zzdv2 = new zzdv(zzdr0);
                this.zzg.put(listenerHolder$ListenerKey0, zzdv2);
                zzdv1 = zzdv2;
            }
            else {
                zzdv0.zzc(listenerHolder0);
                zzdv1 = zzdv0;
                zzdv0 = null;
            }
            if(z) {
                ((zzv)this.getService()).zzw(zzee.zzb(zzdv0, zzdv1, listenerHolder$ListenerKey0.toIdString()), locationRequest0, new zzdj(null, taskCompletionSource0));
            }
            else {
                ((zzv)this.getService()).zzv(new zzei(1, zzeg.zza(null, locationRequest0), null, zzdv1, null, new zzdd(taskCompletionSource0, zzdv1), listenerHolder$ListenerKey0.toIdString()));
            }
        }
    }

    public final void zzu(PendingIntent pendingIntent0, LocationRequest locationRequest0, TaskCompletionSource taskCompletionSource0) {
        if(this.zzG(zzo.zzj)) {
            ((zzv)this.getService()).zzw(zzee.zzc(pendingIntent0), locationRequest0, new zzdj(null, taskCompletionSource0));
            return;
        }
        zzv zzv0 = (zzv)this.getService();
        zzeg zzeg0 = zzeg.zza(null, locationRequest0);
        zzdn zzdn0 = new zzdn(null, taskCompletionSource0);
        int v = pendingIntent0.hashCode();
        zzv0.zzv(new zzei(1, zzeg0, null, null, pendingIntent0, zzdn0, a.k(v, "PendingIntent@", new StringBuilder(String.valueOf(v).length() + 14))));
    }

    public final void zzv(ListenerKey listenerHolder$ListenerKey0, boolean z, TaskCompletionSource taskCompletionSource0) {
        synchronized(this.zzf) {
            Object object0 = this.zzf.remove(listenerHolder$ListenerKey0);
            if(((zzdy)object0) != null) {
                ((zzdy)object0).zzf();
                if(!z) {
                    taskCompletionSource0.setResult(Boolean.TRUE);
                }
                else if(this.zzG(zzo.zzj)) {
                    ((zzv)this.getService()).zzx(zzee.zza(null, ((zzdy)object0), "ILocationListener@" + System.identityHashCode(((zzdy)object0))), new zzdj(Boolean.TRUE, taskCompletionSource0));
                }
                else {
                    ((zzv)this.getService()).zzv(new zzei(2, null, ((zzdy)object0), null, null, new zzdn(Boolean.TRUE, taskCompletionSource0), null));
                }
                return;
            }
            taskCompletionSource0.setResult(Boolean.FALSE);
        }
    }

    public final void zzw(ListenerKey listenerHolder$ListenerKey0, boolean z, TaskCompletionSource taskCompletionSource0) {
        synchronized(this.zzg) {
            Object object0 = this.zzg.remove(listenerHolder$ListenerKey0);
            if(((zzdv)object0) != null) {
                ((zzdv)object0).zzg();
                if(!z) {
                    taskCompletionSource0.setResult(Boolean.TRUE);
                }
                else if(this.zzG(zzo.zzj)) {
                    ((zzv)this.getService()).zzx(zzee.zzb(null, ((zzdv)object0), "ILocationCallback@" + System.identityHashCode(((zzdv)object0))), new zzdj(Boolean.TRUE, taskCompletionSource0));
                }
                else {
                    ((zzv)this.getService()).zzv(new zzei(2, null, null, ((zzdv)object0), null, new zzdn(Boolean.TRUE, taskCompletionSource0), null));
                }
                return;
            }
            taskCompletionSource0.setResult(Boolean.FALSE);
        }
    }

    public final void zzx(PendingIntent pendingIntent0, TaskCompletionSource taskCompletionSource0, Object object0) {
        if(this.zzG(zzo.zzj)) {
            ((zzv)this.getService()).zzx(zzee.zzc(pendingIntent0), new zzdj(null, taskCompletionSource0));
            return;
        }
        ((zzv)this.getService()).zzv(new zzei(2, null, null, null, pendingIntent0, new zzdn(null, taskCompletionSource0), null));
    }

    public final void zzy(TaskCompletionSource taskCompletionSource0) {
        if(this.zzG(zzo.zzg)) {
            ((zzv)this.getService()).zzz(true, new zzdj(null, taskCompletionSource0));
            return;
        }
        ((zzv)this.getService()).zzy(true);
        taskCompletionSource0.setResult(null);
    }

    public final void zzz(TaskCompletionSource taskCompletionSource0) {
        if(this.zzG(zzo.zzg)) {
            ((zzv)this.getService()).zzz(false, new zzdj(Boolean.TRUE, taskCompletionSource0));
            return;
        }
        ((zzv)this.getService()).zzy(false);
        taskCompletionSource0.setResult(Boolean.TRUE);
    }
}

