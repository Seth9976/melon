package com.google.android.gms.auth.blockstore.restorecredential.internal;

import com.google.android.gms.auth.blockstore.restorecredential.ClearRestoreCredentialRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class InternalRestoreCredentialClient..ExternalSyntheticLambda0 implements RemoteCall {
    public ClearRestoreCredentialRequest f$0;

    public InternalRestoreCredentialClient..ExternalSyntheticLambda0(ClearRestoreCredentialRequest clearRestoreCredentialRequest0) {
        this.f$0 = clearRestoreCredentialRequest0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        InternalRestoreCredentialClient.$r8$lambda$dBhy0I4iwuQfEdtIz_LYwO5_jWQ(this.f$0, ((RestoreCredentialClientImpl)object0), ((TaskCompletionSource)object1));
    }
}

