package com.google.android.gms.auth.blockstore.restorecredential;

import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001A\u00020\u0007H\'J\u0016\u0010\b\u001A\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0006\u001A\u00020\nH\'J\u0016\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001A\u00020\rH\'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000EÀ\u0006\u0001"}, d2 = {"Lcom/google/android/gms/auth/blockstore/restorecredential/RestoreCredentialClient;", "Lcom/google/android/gms/common/api/HasApiKey;", "Lcom/google/android/gms/common/api/Api$ApiOptions$NoOptions;", "getRestoreCredential", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/auth/blockstore/restorecredential/GetRestoreCredentialResponse;", "request", "Lcom/google/android/gms/auth/blockstore/restorecredential/GetRestoreCredentialRequest;", "createRestoreCredential", "Lcom/google/android/gms/auth/blockstore/restorecredential/CreateRestoreCredentialResponse;", "Lcom/google/android/gms/auth/blockstore/restorecredential/CreateRestoreCredentialRequest;", "clearRestoreCredential", "", "Lcom/google/android/gms/auth/blockstore/restorecredential/ClearRestoreCredentialRequest;", "java.com.google.android.gmscore.integ.client.auth_blockstore_client_auth_blockstore"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public interface RestoreCredentialClient extends HasApiKey {
    @NotNull
    Task clearRestoreCredential(ClearRestoreCredentialRequest arg1);

    @NotNull
    Task createRestoreCredential(CreateRestoreCredentialRequest arg1);

    @NotNull
    Task getRestoreCredential(GetRestoreCredentialRequest arg1);
}

