package com.google.android.gms.internal.auth-api-phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.phone.SmsCodeBrowserClient;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

public final class zzad extends GoogleApi implements SmsCodeBrowserClient {
    private static final ClientKey zza;
    private static final AbstractClientBuilder zzb;
    private static final Api zzc;

    static {
        ClientKey api$ClientKey0 = new ClientKey();
        zzad.zza = api$ClientKey0;
        zzab zzab0 = new zzab();
        zzad.zzb = zzab0;
        zzad.zzc = new Api("SmsCodeBrowser.API", zzab0, api$ClientKey0);
    }

    public zzad(Activity activity0) {
        super(activity0, zzad.zzc, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    public zzad(Context context0) {
        super(context0, zzad.zzc, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    @Override  // com.google.android.gms.auth.api.phone.SmsCodeBrowserClient
    public final Task startSmsCodeRetriever() {
        return this.doWrite(TaskApiCall.builder().setFeatures(new Feature[]{zzal.zzb}).run(new zzaa(this)).setMethodKey(0x61E).build());
    }
}

