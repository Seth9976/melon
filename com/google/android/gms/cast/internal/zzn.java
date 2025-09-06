package com.google.android.gms.cast.internal;

import android.content.Context;
import com.google.android.gms.cast.zzav;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

public final class zzn extends GoogleApi {
    private static final ClientKey zza;
    private static final AbstractClientBuilder zzb;
    private static final Api zzc;

    static {
        ClientKey api$ClientKey0 = new ClientKey();
        zzn.zza = api$ClientKey0;
        zzi zzi0 = new zzi();
        zzn.zzb = zzi0;
        zzn.zzc = new Api("CastApi.API", zzi0, api$ClientKey0);
    }

    public zzn(Context context0) {
        super(context0, zzn.zzc, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    public final Task zza(String[] arr_s) {
        return this.doRead(TaskApiCall.builder().run(new zzg(this, arr_s)).setFeatures(new Feature[]{zzav.zzd}).setAutoResolveMissingFeatures(false).setMethodKey(0x20E9).build());
    }
}

