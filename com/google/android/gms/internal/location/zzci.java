package com.google.android.gms.internal.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.location.DeviceOrientationListener;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.location.FusedOrientationProviderClient;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

public final class zzci extends GoogleApi implements FusedOrientationProviderClient {
    public static final int zza;

    public zzci(Activity activity0) {
        super(activity0, zzbi.zzb, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    public zzci(Context context0) {
        super(context0, zzbi.zzb, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    @Override  // com.google.android.gms.common.api.GoogleApi
    public final String getApiFallbackAttributionTag(Context context0) {
        return null;
    }

    @Override  // com.google.android.gms.location.FusedOrientationProviderClient
    public final Task removeOrientationUpdates(DeviceOrientationListener deviceOrientationListener0) {
        return this.doUnregisterEventListener(ListenerHolders.createListenerKey(deviceOrientationListener0, "DeviceOrientationListener"), 2440).continueWith((zzcm this) -> runnable0.run(), (Task task0) -> null);
    }

    @Override  // com.google.android.gms.location.FusedOrientationProviderClient
    public final Task requestOrientationUpdates(DeviceOrientationRequest deviceOrientationRequest0, Executor executor0, DeviceOrientationListener deviceOrientationListener0) {
        ListenerHolder listenerHolder0 = ListenerHolders.createListenerHolder(deviceOrientationListener0, executor0, "DeviceOrientationListener");
        zzcl zzcl0 = new zzcl(listenerHolder0, deviceOrientationRequest0);
        zzcj zzcj0 = new zzcj(listenerHolder0);
        return this.doRegisterEventListener(RegistrationMethods.builder().register(zzcl0).unregister(zzcj0).withHolder(listenerHolder0).setMethodKey(0x982).build());
    }
}

