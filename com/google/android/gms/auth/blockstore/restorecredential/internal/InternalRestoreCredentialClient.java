package com.google.android.gms.auth.blockstore.restorecredential.internal;

import android.content.Context;
import com.google.android.gms.auth.blockstore.restorecredential.ClearRestoreCredentialRequest;
import com.google.android.gms.auth.blockstore.restorecredential.CreateRestoreCredentialRequest;
import com.google.android.gms.auth.blockstore.restorecredential.CreateRestoreCredentialResponse;
import com.google.android.gms.auth.blockstore.restorecredential.GetRestoreCredentialRequest;
import com.google.android.gms.auth.blockstore.restorecredential.GetRestoreCredentialResponse;
import com.google.android.gms.auth.blockstore.restorecredential.RestoreCredentialClient;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.auth_blockstore.zzab;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0013B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\u0016\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000E0\t2\u0006\u0010\u000B\u001A\u00020\u000FH\u0016J\u0016\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00110\t2\u0006\u0010\u000B\u001A\u00020\u0012H\u0016¨\u0006\u0014"}, d2 = {"Lcom/google/android/gms/auth/blockstore/restorecredential/internal/InternalRestoreCredentialClient;", "Lcom/google/android/gms/common/api/GoogleApi;", "Lcom/google/android/gms/common/api/Api$ApiOptions$NoOptions;", "Lcom/google/android/gms/auth/blockstore/restorecredential/RestoreCredentialClient;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getRestoreCredential", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/auth/blockstore/restorecredential/GetRestoreCredentialResponse;", "request", "Lcom/google/android/gms/auth/blockstore/restorecredential/GetRestoreCredentialRequest;", "createRestoreCredential", "Lcom/google/android/gms/auth/blockstore/restorecredential/CreateRestoreCredentialResponse;", "Lcom/google/android/gms/auth/blockstore/restorecredential/CreateRestoreCredentialRequest;", "clearRestoreCredential", "", "Lcom/google/android/gms/auth/blockstore/restorecredential/ClearRestoreCredentialRequest;", "Companion", "java.com.google.android.gmscore.integ.client.auth_blockstore_client_auth_blockstore"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class InternalRestoreCredentialClient extends GoogleApi implements RestoreCredentialClient {
    @Metadata(d1 = {"\u0000\'\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/google/android/gms/auth/blockstore/restorecredential/internal/InternalRestoreCredentialClient$Companion;", "", "<init>", "()V", "CLIENT_KEY", "Lcom/google/android/gms/common/api/Api$ClientKey;", "Lcom/google/android/gms/auth/blockstore/restorecredential/internal/RestoreCredentialClientImpl;", "clientBuilder", "com/google/android/gms/auth/blockstore/restorecredential/internal/InternalRestoreCredentialClient$Companion$clientBuilder$1", "Lcom/google/android/gms/auth/blockstore/restorecredential/internal/InternalRestoreCredentialClient$Companion$clientBuilder$1;", "API", "Lcom/google/android/gms/common/api/Api;", "Lcom/google/android/gms/common/api/Api$ApiOptions$NoOptions;", "java.com.google.android.gmscore.integ.client.auth_blockstore_client_auth_blockstore"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    private static final Api API;
    @NotNull
    private static final ClientKey CLIENT_KEY;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final InternalRestoreCredentialClient.Companion.clientBuilder.1 clientBuilder;

    // 检测为 Lambda 实现
    public static void $r8$lambda$6nzcDLrXx618XzL1jxRATH2b6h0(GetRestoreCredentialRequest getRestoreCredentialRequest0, RestoreCredentialClientImpl restoreCredentialClientImpl0, TaskCompletionSource taskCompletionSource0) [...]

    // 检测为 Lambda 实现
    public static void $r8$lambda$dBhy0I4iwuQfEdtIz_LYwO5_jWQ(ClearRestoreCredentialRequest clearRestoreCredentialRequest0, RestoreCredentialClientImpl restoreCredentialClientImpl0, TaskCompletionSource taskCompletionSource0) [...]

    // 检测为 Lambda 实现
    public static void $r8$lambda$e0glqmP_gi22l9sgDfuPXsQXqBI(CreateRestoreCredentialRequest createRestoreCredentialRequest0, RestoreCredentialClientImpl restoreCredentialClientImpl0, TaskCompletionSource taskCompletionSource0) [...]

    static {
        InternalRestoreCredentialClient.Companion = new Companion(null);
        ClientKey api$ClientKey0 = new ClientKey();
        InternalRestoreCredentialClient.CLIENT_KEY = api$ClientKey0;
        InternalRestoreCredentialClient.Companion.clientBuilder.1 internalRestoreCredentialClient$Companion$clientBuilder$10 = new InternalRestoreCredentialClient.Companion.clientBuilder.1();
        InternalRestoreCredentialClient.clientBuilder = internalRestoreCredentialClient$Companion$clientBuilder$10;
        InternalRestoreCredentialClient.API = new Api("RestoreCredential.API", internalRestoreCredentialClient$Companion$clientBuilder$10, api$ClientKey0);
    }

    public InternalRestoreCredentialClient(Context context0) {
        q.g(context0, "context");
        super(context0, InternalRestoreCredentialClient.API, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    @Override  // com.google.android.gms.auth.blockstore.restorecredential.RestoreCredentialClient
    @NotNull
    public Task clearRestoreCredential(ClearRestoreCredentialRequest clearRestoreCredentialRequest0) {
        q.g(clearRestoreCredentialRequest0, "request");
        Task task0 = this.doRead(TaskApiCall.builder().setFeatures(new Feature[]{zzab.zzi}).run((RestoreCredentialClientImpl restoreCredentialClientImpl0, TaskCompletionSource taskCompletionSource0) -> InternalRestoreCredentialClient.clearRestoreCredential$lambda$2(clearRestoreCredentialRequest0, restoreCredentialClientImpl0, taskCompletionSource0)).setMethodKey(0x69E).build());
        q.f(task0, "doRead(...)");
        return task0;

        @Metadata(d1 = {"\u0000\u001D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/google/android/gms/auth/blockstore/restorecredential/internal/InternalRestoreCredentialClient$clearRestoreCredential$1$callback$1", "Lcom/google/android/gms/auth/blockstore/restorecredential/internal/IClearRestoreCredentialCallback$Stub;", "Lcom/google/android/gms/common/api/Status;", "status", "", "cleared", "Lie/H;", "onClearRestoreCredential", "(Lcom/google/android/gms/common/api/Status;Z)V", "java.com.google.android.gmscore.integ.client.auth_blockstore_client_auth_blockstore"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
        public final class com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient.clearRestoreCredential.1.callback.1 extends Stub {
            public com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient.clearRestoreCredential.1.callback.1(TaskCompletionSource taskCompletionSource0) {
            }

            @Override  // com.google.android.gms.auth.blockstore.restorecredential.internal.IClearRestoreCredentialCallback
            public void onClearRestoreCredential(Status status0, boolean z) {
                q.g(status0, "status");
                TaskUtil.setResultOrApiException(status0, Boolean.valueOf(z), this.$completionSource);
            }
        }

    }

    private static final void clearRestoreCredential$lambda$2(ClearRestoreCredentialRequest clearRestoreCredentialRequest0, RestoreCredentialClientImpl restoreCredentialClientImpl0, TaskCompletionSource taskCompletionSource0) {
        q.g(clearRestoreCredentialRequest0, "$request");
        com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient.clearRestoreCredential.1.callback.1 internalRestoreCredentialClient$clearRestoreCredential$1$callback$10 = new com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient.clearRestoreCredential.1.callback.1(taskCompletionSource0);
        ((IRestoreCredentialService)restoreCredentialClientImpl0.getService()).clearRestoreCredential(clearRestoreCredentialRequest0, internalRestoreCredentialClient$clearRestoreCredential$1$callback$10);
    }

    @Override  // com.google.android.gms.auth.blockstore.restorecredential.RestoreCredentialClient
    @NotNull
    public Task createRestoreCredential(CreateRestoreCredentialRequest createRestoreCredentialRequest0) {
        q.g(createRestoreCredentialRequest0, "request");
        Task task0 = this.doRead(TaskApiCall.builder().setFeatures(new Feature[]{zzab.zzj}).run((RestoreCredentialClientImpl restoreCredentialClientImpl0, TaskCompletionSource taskCompletionSource0) -> InternalRestoreCredentialClient.createRestoreCredential$lambda$1(createRestoreCredentialRequest0, restoreCredentialClientImpl0, taskCompletionSource0)).setMethodKey(0x69D).build());
        q.f(task0, "doRead(...)");
        return task0;

        @Metadata(d1 = {"\u0000\u001D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/google/android/gms/auth/blockstore/restorecredential/internal/InternalRestoreCredentialClient$createRestoreCredential$1$callback$1", "Lcom/google/android/gms/auth/blockstore/restorecredential/internal/ICreateRestoreCredentialCallback$Stub;", "Lcom/google/android/gms/common/api/Status;", "status", "Lcom/google/android/gms/auth/blockstore/restorecredential/CreateRestoreCredentialResponse;", "response", "Lie/H;", "onCreateRestoreCredential", "(Lcom/google/android/gms/common/api/Status;Lcom/google/android/gms/auth/blockstore/restorecredential/CreateRestoreCredentialResponse;)V", "java.com.google.android.gmscore.integ.client.auth_blockstore_client_auth_blockstore"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
        public final class com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient.createRestoreCredential.1.callback.1 extends com.google.android.gms.auth.blockstore.restorecredential.internal.ICreateRestoreCredentialCallback.Stub {
            public com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient.createRestoreCredential.1.callback.1(TaskCompletionSource taskCompletionSource0) {
            }

            @Override  // com.google.android.gms.auth.blockstore.restorecredential.internal.ICreateRestoreCredentialCallback
            public void onCreateRestoreCredential(Status status0, CreateRestoreCredentialResponse createRestoreCredentialResponse0) {
                q.g(status0, "status");
                q.g(createRestoreCredentialResponse0, "response");
                TaskUtil.setResultOrApiException(status0, createRestoreCredentialResponse0, this.$completionSource);
            }
        }

    }

    private static final void createRestoreCredential$lambda$1(CreateRestoreCredentialRequest createRestoreCredentialRequest0, RestoreCredentialClientImpl restoreCredentialClientImpl0, TaskCompletionSource taskCompletionSource0) {
        q.g(createRestoreCredentialRequest0, "$request");
        com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient.createRestoreCredential.1.callback.1 internalRestoreCredentialClient$createRestoreCredential$1$callback$10 = new com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient.createRestoreCredential.1.callback.1(taskCompletionSource0);
        ((IRestoreCredentialService)restoreCredentialClientImpl0.getService()).createRestoreCredential(createRestoreCredentialRequest0, internalRestoreCredentialClient$createRestoreCredential$1$callback$10);
    }

    @Override  // com.google.android.gms.auth.blockstore.restorecredential.RestoreCredentialClient
    @NotNull
    public Task getRestoreCredential(GetRestoreCredentialRequest getRestoreCredentialRequest0) {
        q.g(getRestoreCredentialRequest0, "request");
        Task task0 = this.doRead(TaskApiCall.builder().setFeatures(new Feature[]{zzab.zzk}).run((RestoreCredentialClientImpl restoreCredentialClientImpl0, TaskCompletionSource taskCompletionSource0) -> InternalRestoreCredentialClient.getRestoreCredential$lambda$0(getRestoreCredentialRequest0, restoreCredentialClientImpl0, taskCompletionSource0)).setMethodKey(0x69F).build());
        q.f(task0, "doRead(...)");
        return task0;

        @Metadata(d1 = {"\u0000\u001D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/google/android/gms/auth/blockstore/restorecredential/internal/InternalRestoreCredentialClient$getRestoreCredential$1$callback$1", "Lcom/google/android/gms/auth/blockstore/restorecredential/internal/IGetRestoreCredentialCallback$Stub;", "Lcom/google/android/gms/common/api/Status;", "status", "Lcom/google/android/gms/auth/blockstore/restorecredential/GetRestoreCredentialResponse;", "response", "Lie/H;", "onGetRestoreCredential", "(Lcom/google/android/gms/common/api/Status;Lcom/google/android/gms/auth/blockstore/restorecredential/GetRestoreCredentialResponse;)V", "java.com.google.android.gmscore.integ.client.auth_blockstore_client_auth_blockstore"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
        public final class com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient.getRestoreCredential.1.callback.1 extends com.google.android.gms.auth.blockstore.restorecredential.internal.IGetRestoreCredentialCallback.Stub {
            public com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient.getRestoreCredential.1.callback.1(TaskCompletionSource taskCompletionSource0) {
            }

            @Override  // com.google.android.gms.auth.blockstore.restorecredential.internal.IGetRestoreCredentialCallback
            public void onGetRestoreCredential(Status status0, GetRestoreCredentialResponse getRestoreCredentialResponse0) {
                q.g(status0, "status");
                q.g(getRestoreCredentialResponse0, "response");
                TaskUtil.setResultOrApiException(status0, getRestoreCredentialResponse0, this.$completionSource);
            }
        }

    }

    private static final void getRestoreCredential$lambda$0(GetRestoreCredentialRequest getRestoreCredentialRequest0, RestoreCredentialClientImpl restoreCredentialClientImpl0, TaskCompletionSource taskCompletionSource0) {
        q.g(getRestoreCredentialRequest0, "$request");
        com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient.getRestoreCredential.1.callback.1 internalRestoreCredentialClient$getRestoreCredential$1$callback$10 = new com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient.getRestoreCredential.1.callback.1(taskCompletionSource0);
        ((IRestoreCredentialService)restoreCredentialClientImpl0.getService()).getRestoreCredential(getRestoreCredentialRequest0, internalRestoreCredentialClient$getRestoreCredential$1$callback$10);
    }
}

