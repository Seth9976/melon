package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.auth.zzal;
import com.google.android.gms.tasks.Task;

public class WorkAccountClient extends GoogleApi {
    private final WorkAccountApi zza;

    public WorkAccountClient(Activity activity0) {
        super(activity0, WorkAccount.API, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
        this.zza = new zzal();
    }

    public WorkAccountClient(Context context0) {
        super(context0, WorkAccount.API, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
        this.zza = new zzal();
    }

    public Task addWorkAccount(String s) {
        return PendingResultUtil.toTask(this.zza.addWorkAccount(this.asGoogleApiClient(), s), new zzg(this));
    }

    public Task removeWorkAccount(Account account0) {
        return PendingResultUtil.toVoidTask(this.zza.removeWorkAccount(this.asGoogleApiClient(), account0));
    }

    public Task setWorkAuthenticatorEnabled(boolean z) {
        return PendingResultUtil.toVoidTask(this.zza.setWorkAuthenticatorEnabledWithResult(this.asGoogleApiClient(), z));
    }
}

