package com.google.android.gms.internal.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.location.zzo;
import com.google.android.gms.tasks.Task;

public final class zzda extends GoogleApi implements SettingsClient {
    public static final int zza;

    public zzda(Activity activity0) {
        super(activity0, zzbi.zzb, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    public zzda(Context context0) {
        super(context0, zzbi.zzb, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    @Override  // com.google.android.gms.location.SettingsClient
    public final Task checkLocationSettings(LocationSettingsRequest locationSettingsRequest0) {
        return this.doRead(TaskApiCall.builder().run(new zzdb(locationSettingsRequest0)).setMethodKey(0x97A).build());
    }

    @Override  // com.google.android.gms.location.SettingsClient
    public final Task isGoogleLocationAccuracyEnabled() {
        return this.doRead(TaskApiCall.builder().run(zzdc.zza).setMethodKey(0x98C).setFeatures(new Feature[]{zzo.zzm}).build());
    }
}

