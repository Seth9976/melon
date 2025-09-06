package com.google.android.gms.auth.blockstore.restorecredential.internal;

import com.google.android.gms.auth.blockstore.restorecredential.GetRestoreCredentialRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class InternalRestoreCredentialClient..ExternalSyntheticLambda2 implements RemoteCall {
    public GetRestoreCredentialRequest f$0;

    public InternalRestoreCredentialClient..ExternalSyntheticLambda2(GetRestoreCredentialRequest getRestoreCredentialRequest0) {
        this.f$0 = getRestoreCredentialRequest0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        InternalRestoreCredentialClient.$r8$lambda$6nzcDLrXx618XzL1jxRATH2b6h0(this.f$0, ((RestoreCredentialClientImpl)object0), ((TaskCompletionSource)object1));
    }
}

