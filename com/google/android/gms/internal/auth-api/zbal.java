package com.google.android.gms.internal.auth-api;

import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zbal extends zbk {
    final TaskCompletionSource zba;

    public zbal(zbap zbap0, TaskCompletionSource taskCompletionSource0) {
        this.zba = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.auth-api.zbl
    public final void zbb(Status status0, BeginSignInResult beginSignInResult0) {
        TaskUtil.setResultOrApiException(status0, beginSignInResult0, this.zba);
    }
}

