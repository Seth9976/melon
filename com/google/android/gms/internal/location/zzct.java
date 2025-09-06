package com.google.android.gms.internal.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.tasks.Task;
import java.util.List;

public final class zzct extends GoogleApi implements GeofencingClient {
    public static final int zza;

    public zzct(Activity activity0) {
        super(activity0, zzbi.zzb, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    public zzct(Context context0) {
        super(context0, zzbi.zzb, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    @Override  // com.google.android.gms.location.GeofencingClient
    public final Task addGeofences(GeofencingRequest geofencingRequest0, PendingIntent pendingIntent0) {
        return this.doWrite(TaskApiCall.builder().run(new zzcw(geofencingRequest0, pendingIntent0)).setMethodKey(0x978).build());
    }

    @Override  // com.google.android.gms.location.GeofencingClient
    public final Task removeGeofences(PendingIntent pendingIntent0) {
        return this.doWrite(TaskApiCall.builder().run(new zzcu(pendingIntent0)).setMethodKey(0x979).build());
    }

    @Override  // com.google.android.gms.location.GeofencingClient
    public final Task removeGeofences(List list0) {
        return this.doWrite(TaskApiCall.builder().run(new zzcv(list0)).setMethodKey(0x979).build());
    }
}

