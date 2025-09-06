package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdh extends LocationCallback {
    final TaskCompletionSource zza;
    final zzdz zzb;

    public zzdh(zzdz zzdz0, TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        this.zzb = zzdz0;
        super();
    }

    @Override  // com.google.android.gms.location.LocationCallback
    public final void onLocationResult(LocationResult locationResult0) {
        Location location0 = locationResult0.getLastLocation();
        this.zza.trySetResult(location0);
        try {
            ListenerKey listenerHolder$ListenerKey0 = ListenerHolders.createListenerKey(this, "GetCurrentLocation");
            TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
            this.zzb.zzw(listenerHolder$ListenerKey0, false, taskCompletionSource0);
        }
        catch(RemoteException unused_ex) {
        }
    }
}

