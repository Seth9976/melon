package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B9\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0004\u0012\u0006\u0010\t\u001A\u00020\b\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0014\u0010\u0007\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/facebook/login/LoginStatusClient;", "Lcom/facebook/internal/PlatformServiceClient;", "Landroid/content/Context;", "context", "", "applicationId", "loggerRef", "graphApiVersion", "", "toastDurationMs", "nonce", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "Landroid/os/Bundle;", "data", "Lie/H;", "populateRequestBundle", "(Landroid/os/Bundle;)V", "Ljava/lang/String;", "J", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class LoginStatusClient extends PlatformServiceClient {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J?\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\u00042\b\u0010\u000E\u001A\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\b\u000FR\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/login/LoginStatusClient$Companion;", "", "()V", "DEFAULT_TOAST_DURATION_MS", "", "newInstance", "Lcom/facebook/login/LoginStatusClient;", "context", "Landroid/content/Context;", "applicationId", "", "loggerRef", "graphApiVersion", "toastDurationMs", "nonce", "newInstance$facebook_common_release", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final LoginStatusClient newInstance$facebook_common_release(@NotNull Context context0, @NotNull String s, @NotNull String s1, @NotNull String s2, long v, @Nullable String s3) {
            q.g(context0, "context");
            q.g(s, "applicationId");
            q.g(s1, "loggerRef");
            q.g(s2, "graphApiVersion");
            return new LoginStatusClient(context0, s, s1, s2, v, s3);
        }
    }

    @NotNull
    public static final Companion Companion = null;
    public static final long DEFAULT_TOAST_DURATION_MS = 5000L;
    @NotNull
    private final String graphApiVersion;
    @NotNull
    private final String loggerRef;
    private final long toastDurationMs;

    static {
        LoginStatusClient.Companion = new Companion(null);
    }

    public LoginStatusClient(@NotNull Context context0, @NotNull String s, @NotNull String s1, @NotNull String s2, long v, @Nullable String s3) {
        q.g(context0, "context");
        q.g(s, "applicationId");
        q.g(s1, "loggerRef");
        q.g(s2, "graphApiVersion");
        super(context0, 0x1000A, 0x1000B, 20170411, s, s3);
        this.loggerRef = s1;
        this.graphApiVersion = s2;
        this.toastDurationMs = v;
    }

    @Override  // com.facebook.internal.PlatformServiceClient
    public void populateRequestBundle(@NotNull Bundle bundle0) {
        q.g(bundle0, "data");
        bundle0.putString("com.facebook.platform.extra.LOGGER_REF", this.loggerRef);
        bundle0.putString("com.facebook.platform.extra.GRAPH_API_VERSION", this.graphApiVersion);
        bundle0.putLong("com.facebook.platform.extra.EXTRA_TOAST_DURATION_MS", this.toastDurationMs);
    }
}

