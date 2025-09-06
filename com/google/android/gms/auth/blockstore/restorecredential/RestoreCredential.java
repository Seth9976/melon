package com.google.android.gms.auth.blockstore.restorecredential;

import android.content.Context;
import com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/google/android/gms/auth/blockstore/restorecredential/RestoreCredential;", "", "<init>", "()V", "getRestoreCredentialClient", "Lcom/google/android/gms/auth/blockstore/restorecredential/RestoreCredentialClient;", "context", "Landroid/content/Context;", "java.com.google.android.gmscore.integ.client.auth_blockstore_client_auth_blockstore"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class RestoreCredential {
    @NotNull
    public static final RestoreCredential INSTANCE;

    static {
        RestoreCredential.INSTANCE = new RestoreCredential();
    }

    @NotNull
    public static final RestoreCredentialClient getRestoreCredentialClient(Context context0) {
        q.g(context0, "context");
        return new InternalRestoreCredentialClient(context0);
    }
}

