package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

final class zzbd implements OnCompleteListener {
    private final ResultHolder zza;

    public zzbd(ResultHolder baseImplementation$ResultHolder0) {
        this.zza = baseImplementation$ResultHolder0;
    }

    @Override  // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task0) {
        ResultHolder baseImplementation$ResultHolder0 = this.zza;
        if(task0.isSuccessful()) {
            baseImplementation$ResultHolder0.setResult(Status.RESULT_SUCCESS);
            return;
        }
        if(task0.isCanceled()) {
            baseImplementation$ResultHolder0.setFailedResult(Status.RESULT_CANCELED);
            return;
        }
        Exception exception0 = task0.getException();
        if(exception0 instanceof ApiException) {
            baseImplementation$ResultHolder0.setFailedResult(((ApiException)exception0).getStatus());
            return;
        }
        baseImplementation$ResultHolder0.setFailedResult(Status.RESULT_INTERNAL_ERROR);
    }
}

