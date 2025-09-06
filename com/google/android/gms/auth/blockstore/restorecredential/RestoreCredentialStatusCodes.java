package com.google.android.gms.auth.blockstore.restorecredential;

import com.google.android.gms.common.api.CommonStatusCodes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/google/android/gms/auth/blockstore/restorecredential/RestoreCredentialStatusCodes;", "Lcom/google/android/gms/common/api/CommonStatusCodes;", "<init>", "()V", "RESTORE_CREDENTIAL_BASE", "", "RESTORE_CREDENTIAL_DEVELOPER_ERROR", "RESTORE_CREDENTIAL_INTERNAL_FAILURE", "RESTORE_CREDENTIAL_FIDO_FAILURE", "RESTORE_CREDENTIAL_E2EE_UNAVAILABLE", "getStringStatusCode", "", "statusCode", "java.com.google.android.gmscore.integ.client.auth_blockstore_client_auth_blockstore"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class RestoreCredentialStatusCodes extends CommonStatusCodes {
    @NotNull
    public static final RestoreCredentialStatusCodes INSTANCE = null;
    public static final int RESTORE_CREDENTIAL_DEVELOPER_ERROR = 40200;
    public static final int RESTORE_CREDENTIAL_E2EE_UNAVAILABLE = 40203;
    public static final int RESTORE_CREDENTIAL_FIDO_FAILURE = 40202;
    public static final int RESTORE_CREDENTIAL_INTERNAL_FAILURE = 40201;

    static {
        RestoreCredentialStatusCodes.INSTANCE = new RestoreCredentialStatusCodes();
    }
}

