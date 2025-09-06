package com.google.android.gms.internal.auth-api-phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.phone.SmsCodeAutofillClient;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;

public final class zzz extends GoogleApi implements SmsCodeAutofillClient {
    private static final ClientKey zza;
    private static final AbstractClientBuilder zzb;
    private static final Api zzc;

    static {
        ClientKey api$ClientKey0 = new ClientKey();
        zzz.zza = api$ClientKey0;
        zzv zzv0 = new zzv();
        zzz.zzb = zzv0;
        zzz.zzc = new Api("SmsCodeAutofill.API", zzv0, api$ClientKey0);
    }

    public zzz(Activity activity0) {
        super(activity0, zzz.zzc, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    public zzz(Context context0) {
        super(context0, zzz.zzc, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    @Override  // com.google.android.gms.auth.api.phone.SmsCodeAutofillClient
    public final Task checkPermissionState() {
        return this.doRead(TaskApiCall.builder().setFeatures(new Feature[]{zzal.zza}).run(new zzs(this)).setMethodKey(0x61C).build());
    }

    @Override  // com.google.android.gms.auth.api.phone.SmsCodeAutofillClient
    public final Task hasOngoingSmsRequest(String s) {
        Preconditions.checkNotNull(s);
        Preconditions.checkArgument(!s.isEmpty(), "The package name cannot be empty.");
        return this.doRead(TaskApiCall.builder().setFeatures(new Feature[]{zzal.zza}).run(new zzt(this, s)).setMethodKey(0x61D).build());
    }

    @Override  // com.google.android.gms.auth.api.phone.SmsCodeAutofillClient
    public final Task startSmsCodeRetriever() {
        return this.doWrite(TaskApiCall.builder().setFeatures(new Feature[]{zzal.zza}).run(new zzu(this)).setMethodKey(0x61B).build());
    }
}

