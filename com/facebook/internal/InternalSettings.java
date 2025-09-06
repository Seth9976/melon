package com.facebook.internal;

import Tf.v;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000B\u0010\fR\u0018\u0010\r\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\r\u0010\fR\u001A\u0010\u000F\u001A\u00020\u000E8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0003\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/facebook/internal/InternalSettings;", "", "<init>", "()V", "", "getCustomUserAgent", "()Ljava/lang/String;", "value", "Lie/H;", "setCustomUserAgent", "(Ljava/lang/String;)V", "UNITY_PREFIX", "Ljava/lang/String;", "customUserAgent", "", "isUnityApp", "()Z", "isUnityApp$annotations", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InternalSettings {
    @NotNull
    public static final InternalSettings INSTANCE = null;
    @NotNull
    private static final String UNITY_PREFIX = "Unity.";
    @Nullable
    private static volatile String customUserAgent;

    static {
        InternalSettings.INSTANCE = new InternalSettings();
    }

    @Nullable
    public static final String getCustomUserAgent() {
        return InternalSettings.customUserAgent;
    }

    public static final boolean isUnityApp() {
        return InternalSettings.customUserAgent != null && v.r0(InternalSettings.customUserAgent, "Unity.", false);
    }

    public static void isUnityApp$annotations() {
    }

    public static final void setCustomUserAgent(@NotNull String s) {
        q.g(s, "value");
        InternalSettings.customUserAgent = s;
    }
}

