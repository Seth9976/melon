package com.google.android.gms.common.api.internal;

import android.os.Message;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;

final class zacy implements Runnable {
    final Result zaa;
    final zada zab;

    public zacy(zada zada0, Result result0) {
        this.zab = zada0;
        this.zaa = result0;
        super();
    }

    @Override
    public final void run() {
        try {
            try {
                BasePendingResult.zaa.set(Boolean.TRUE);
                PendingResult pendingResult0 = ((ResultTransform)Preconditions.checkNotNull(zada.zaa(this.zab))).onSuccess(this.zaa);
                Message message0 = zada.zab(this.zab).obtainMessage(0, pendingResult0);
                zada.zab(this.zab).sendMessage(message0);
                goto label_20;
            }
            catch(RuntimeException runtimeException0) {
            }
            Message message1 = zada.zab(this.zab).obtainMessage(1, runtimeException0);
            zada.zab(this.zab).sendMessage(message1);
        }
        catch(Throwable throwable0) {
            goto label_14;
        }
        BasePendingResult.zaa.set(Boolean.FALSE);
        zada.zaf(this.zab, this.zaa);
        GoogleApiClient googleApiClient0 = (GoogleApiClient)zada.zae(this.zab).get();
        if(googleApiClient0 != null) {
            googleApiClient0.zap(this.zab);
            return;
        }
        return;
    label_14:
        BasePendingResult.zaa.set(Boolean.FALSE);
        zada.zaf(this.zab, this.zaa);
        GoogleApiClient googleApiClient1 = (GoogleApiClient)zada.zae(this.zab).get();
        if(googleApiClient1 != null) {
            googleApiClient1.zap(this.zab);
        }
        throw throwable0;
    label_20:
        BasePendingResult.zaa.set(Boolean.FALSE);
        zada.zaf(this.zab, this.zaa);
        googleApiClient0 = (GoogleApiClient)zada.zae(this.zab).get();
        if(googleApiClient0 != null) {
            googleApiClient0.zap(this.zab);
        }
    }
}

