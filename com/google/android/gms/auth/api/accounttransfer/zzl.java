package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.auth.zzap;
import com.google.android.gms.internal.auth.zzau;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzl extends TaskApiCall {
    protected TaskCompletionSource zzb;

    public zzl(int v, zzk zzk0) {
        super(null, false, v);
    }

    @Override  // com.google.android.gms.common.api.internal.TaskApiCall
    public final void doExecute(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) {
        this.zzb = taskCompletionSource0;
        this.zza(((zzau)((zzap)api$AnyClient0).getService()));
    }

    public abstract void zza(zzau arg1);
}

