package com.google.android.gms.internal.auth-api;

import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zbae extends zbt {
    final TaskCompletionSource zba;

    public zbae(zbaf zbaf0, TaskCompletionSource taskCompletionSource0) {
        this.zba = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.auth-api.zbu
    public final void zbb(Status status0, SavePasswordResult savePasswordResult0) {
        TaskUtil.setResultOrApiException(status0, savePasswordResult0, this.zba);
    }
}

