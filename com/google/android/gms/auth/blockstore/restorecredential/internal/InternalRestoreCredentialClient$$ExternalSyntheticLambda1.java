package com.google.android.gms.auth.blockstore.restorecredential.internal;

import com.google.android.gms.auth.blockstore.restorecredential.CreateRestoreCredentialRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class InternalRestoreCredentialClient..ExternalSyntheticLambda1 implements RemoteCall {
    public CreateRestoreCredentialRequest f$0;

    public InternalRestoreCredentialClient..ExternalSyntheticLambda1(CreateRestoreCredentialRequest createRestoreCredentialRequest0) {
        this.f$0 = createRestoreCredentialRequest0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        InternalRestoreCredentialClient.$r8$lambda$e0glqmP_gi22l9sgDfuPXsQXqBI(this.f$0, ((RestoreCredentialClientImpl)object0), ((TaskCompletionSource)object1));
    }
}

