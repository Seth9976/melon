package com.google.android.gms.auth.blockstore.restorecredential.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.internal.auth_blockstore.zzab;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001E2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001EB/\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\b\u0010\u000F\u001A\u00020\u0010H\u0014J\b\u0010\u0011\u001A\u00020\u0010H\u0014J\u0010\u0010\u0012\u001A\u00020\u00022\u0006\u0010\u0013\u001A\u00020\u0014H\u0014J\u0013\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\b\u0010\u001B\u001A\u00020\u001CH\u0014J\b\u0010\u001D\u001A\u00020\u001CH\u0016¨\u0006\u001F"}, d2 = {"Lcom/google/android/gms/auth/blockstore/restorecredential/internal/RestoreCredentialClientImpl;", "Lcom/google/android/gms/common/internal/GmsClient;", "Lcom/google/android/gms/auth/blockstore/restorecredential/internal/IRestoreCredentialService;", "context", "Landroid/content/Context;", "looper", "Landroid/os/Looper;", "clientSettings", "Lcom/google/android/gms/common/internal/ClientSettings;", "connectionCallbacks", "Lcom/google/android/gms/common/api/internal/ConnectionCallbacks;", "connectionFailedListener", "Lcom/google/android/gms/common/api/internal/OnConnectionFailedListener;", "<init>", "(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/common/internal/ClientSettings;Lcom/google/android/gms/common/api/internal/ConnectionCallbacks;Lcom/google/android/gms/common/api/internal/OnConnectionFailedListener;)V", "getStartServiceAction", "", "getServiceDescriptor", "createServiceInterface", "binder", "Landroid/os/IBinder;", "getApiFeatures", "", "Lcom/google/android/gms/common/Feature;", "()[Lcom/google/android/gms/common/Feature;", "getMinApkVersion", "", "getUseDynamicLookup", "", "usesClientTelemetry", "Companion", "java.com.google.android.gmscore.integ.client.auth_blockstore_client_auth_blockstore"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class RestoreCredentialClientImpl extends GmsClient {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/google/android/gms/auth/blockstore/restorecredential/internal/RestoreCredentialClientImpl$Companion;", "", "<init>", "()V", "ACTION_START_SERVICE", "", "SERVICE_DESCRIPTOR", "java.com.google.android.gmscore.integ.client.auth_blockstore_client_auth_blockstore"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        RestoreCredentialClientImpl.Companion = new Companion(null);
    }

    public RestoreCredentialClientImpl(Context context0, Looper looper0, ClientSettings clientSettings0, ConnectionCallbacks connectionCallbacks0, OnConnectionFailedListener onConnectionFailedListener0) {
        q.g(context0, "context");
        q.g(looper0, "looper");
        q.g(clientSettings0, "clientSettings");
        q.g(connectionCallbacks0, "connectionCallbacks");
        q.g(onConnectionFailedListener0, "connectionFailedListener");
        super(context0, looper0, 381, clientSettings0, connectionCallbacks0, onConnectionFailedListener0);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public IInterface createServiceInterface(IBinder iBinder0) {
        return this.createServiceInterface(iBinder0);
    }

    @NotNull
    public IRestoreCredentialService createServiceInterface(IBinder iBinder0) {
        q.g(iBinder0, "binder");
        IRestoreCredentialService iRestoreCredentialService0 = Stub.asInterface(iBinder0);
        q.f(iRestoreCredentialService0, "asInterface(...)");
        return iRestoreCredentialService0;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    @NotNull
    public Feature[] getApiFeatures() {
        q.f(zzab.zzl, "ALL_FEATURES");
        return zzab.zzl;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public int getMinApkVersion() {
        return 17895000;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    @NotNull
    public String getServiceDescriptor() {
        return "com.google.android.gms.auth.blockstore.restorecredential.internal.IRestoreCredentialService";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    @NotNull
    public String getStartServiceAction() {
        return "com.google.android.gms.auth.blockstore.restorecredential.service.START_RESTORE_CRED";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public boolean getUseDynamicLookup() {
        return true;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public boolean usesClientTelemetry() {
        return true;
    }
}

