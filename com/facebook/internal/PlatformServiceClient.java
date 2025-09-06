package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0001:B9\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0004\u0012\u0006\u0010\t\u001A\u00020\b\u0012\b\u0010\n\u001A\u0004\u0018\u00010\b\u00A2\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0019\u0010\u0012\u001A\u00020\r2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001A\u00020\r2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0019\u001A\u00020\u0018\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\r\u0010\u001B\u001A\u00020\r\u00A2\u0006\u0004\b\u001B\u0010\u000FJ\u001F\u0010 \u001A\u00020\r2\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001F\u001A\u00020\u001EH\u0016\u00A2\u0006\u0004\b \u0010!J\u0017\u0010\"\u001A\u00020\r2\u0006\u0010\u001D\u001A\u00020\u001CH\u0016\u00A2\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001A\u00020\r2\u0006\u0010$\u001A\u00020\u0010H$\u00A2\u0006\u0004\b%\u0010\u0013J\u0017\u0010(\u001A\u00020\r2\u0006\u0010\'\u001A\u00020&H\u0004\u00A2\u0006\u0004\b(\u0010)R\u001A\u0010\u0003\u001A\u00020\u00028\u0004X\u0084\u0004\u00A2\u0006\f\n\u0004\b\u0003\u0010*\u001A\u0004\b+\u0010,R\u0014\u0010.\u001A\u00020-8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\u0015\u001A\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0015\u00100R\u0016\u00101\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001A\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u00106R\u0014\u0010\u0006\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0006\u00106R\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\t\u00107R\u0014\u0010\u0007\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u00106R\u0019\u0010\n\u001A\u0004\u0018\u00010\b8\u0006\u00A2\u0006\f\n\u0004\b\n\u00107\u001A\u0004\b8\u00109\u00A8\u0006;"}, d2 = {"Lcom/facebook/internal/PlatformServiceClient;", "Landroid/content/ServiceConnection;", "Landroid/content/Context;", "context", "", "requestMessage", "replyMessage", "protocolVersion", "", "applicationId", "nonce", "<init>", "(Landroid/content/Context;IIILjava/lang/String;Ljava/lang/String;)V", "Lie/H;", "sendMessage", "()V", "Landroid/os/Bundle;", "result", "callback", "(Landroid/os/Bundle;)V", "Lcom/facebook/internal/PlatformServiceClient$CompletedListener;", "listener", "setCompletedListener", "(Lcom/facebook/internal/PlatformServiceClient$CompletedListener;)V", "", "start", "()Z", "cancel", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "data", "populateRequestBundle", "Landroid/os/Message;", "message", "handleMessage", "(Landroid/os/Message;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Lcom/facebook/internal/PlatformServiceClient$CompletedListener;", "running", "Z", "Landroid/os/Messenger;", "sender", "Landroid/os/Messenger;", "I", "Ljava/lang/String;", "getNonce", "()Ljava/lang/String;", "CompletedListener", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class PlatformServiceClient implements ServiceConnection {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/PlatformServiceClient$CompletedListener;", "", "Landroid/os/Bundle;", "result", "Lie/H;", "completed", "(Landroid/os/Bundle;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface CompletedListener {
        void completed(@Nullable Bundle arg1);
    }

    @NotNull
    private final String applicationId;
    @NotNull
    private final Context context;
    @NotNull
    private final Handler handler;
    @Nullable
    private CompletedListener listener;
    @Nullable
    private final String nonce;
    private final int protocolVersion;
    private final int replyMessage;
    private final int requestMessage;
    private boolean running;
    @Nullable
    private Messenger sender;

    public PlatformServiceClient(@NotNull Context context0, int v, int v1, int v2, @NotNull String s, @Nullable String s1) {
        q.g(context0, "context");
        q.g(s, "applicationId");
        super();
        Context context1 = context0.getApplicationContext();
        if(context1 != null) {
            context0 = context1;
        }
        this.context = context0;
        this.requestMessage = v;
        this.replyMessage = v1;
        this.applicationId = s;
        this.protocolVersion = v2;
        this.nonce = s1;
        this.handler = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(@NotNull Message message0) {
                if(CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    q.g(message0, "message");
                    PlatformServiceClient.this.handleMessage(message0);
                }
                catch(Throwable throwable0) {
                    CrashShieldHandler.handleThrowable(throwable0, this);
                }
            }
        };
    }

    private final void callback(Bundle bundle0) {
        if(this.running) {
            this.running = false;
            CompletedListener platformServiceClient$CompletedListener0 = this.listener;
            if(platformServiceClient$CompletedListener0 != null) {
                platformServiceClient$CompletedListener0.completed(bundle0);
            }
        }
    }

    public final void cancel() {
        this.running = false;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final String getNonce() {
        return this.nonce;
    }

    public final void handleMessage(@NotNull Message message0) {
        q.g(message0, "message");
        if(message0.what == this.replyMessage) {
            Bundle bundle0 = message0.getData();
            if(bundle0.getString("com.facebook.platform.status.ERROR_TYPE") == null) {
                this.callback(bundle0);
            }
            else {
                this.callback(null);
            }
            try {
                this.context.unbindService(this);
            }
            catch(IllegalArgumentException unused_ex) {
            }
        }
    }

    @Override  // android.content.ServiceConnection
    public void onServiceConnected(@NotNull ComponentName componentName0, @NotNull IBinder iBinder0) {
        q.g(componentName0, "name");
        q.g(iBinder0, "service");
        this.sender = new Messenger(iBinder0);
        this.sendMessage();
    }

    @Override  // android.content.ServiceConnection
    public void onServiceDisconnected(@NotNull ComponentName componentName0) {
        q.g(componentName0, "name");
        this.sender = null;
        try {
            this.context.unbindService(this);
        }
        catch(IllegalArgumentException unused_ex) {
        }
        this.callback(null);
    }

    public abstract void populateRequestBundle(@NotNull Bundle arg1);

    private final void sendMessage() {
        Bundle bundle0 = new Bundle();
        bundle0.putString("com.facebook.platform.extra.APPLICATION_ID", this.applicationId);
        String s = this.nonce;
        if(s != null) {
            bundle0.putString("com.facebook.platform.extra.NONCE", s);
        }
        this.populateRequestBundle(bundle0);
        Message message0 = Message.obtain(null, this.requestMessage);
        message0.arg1 = this.protocolVersion;
        message0.setData(bundle0);
        message0.replyTo = new Messenger(this.handler);
        try {
            Messenger messenger0 = this.sender;
            if(messenger0 != null) {
                messenger0.send(message0);
            }
        }
        catch(RemoteException unused_ex) {
            this.callback(null);
        }
    }

    public final void setCompletedListener(@Nullable CompletedListener platformServiceClient$CompletedListener0) {
        this.listener = platformServiceClient$CompletedListener0;
    }

    public final boolean start() {
        boolean z = false;
        synchronized(this) {
            if(this.running) {
                return false;
            }
            if(NativeProtocol.getLatestAvailableProtocolVersionForService(this.protocolVersion) == -1) {
                return false;
            }
            Intent intent0 = NativeProtocol.createPlatformServiceIntent(this.context);
            if(intent0 != null) {
                z = true;
                this.running = true;
                this.context.bindService(intent0, this, 1);
            }
            return z;
        }
    }
}

