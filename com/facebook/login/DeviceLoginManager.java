package com.facebook.login;

import android.net.Uri;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import d3.g;
import ie.j;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001E\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000F\u001A\u00020\u00102\u000E\u0010\u0011\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012H\u0014R\u001C\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001C\u0010\t\u001A\u0004\u0018\u00010\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u0014"}, d2 = {"Lcom/facebook/login/DeviceLoginManager;", "Lcom/facebook/login/LoginManager;", "()V", "deviceAuthTargetUserId", "", "getDeviceAuthTargetUserId", "()Ljava/lang/String;", "setDeviceAuthTargetUserId", "(Ljava/lang/String;)V", "deviceRedirectUri", "Landroid/net/Uri;", "getDeviceRedirectUri", "()Landroid/net/Uri;", "setDeviceRedirectUri", "(Landroid/net/Uri;)V", "createLoginRequest", "Lcom/facebook/login/LoginClient$Request;", "permissions", "", "Companion", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class DeviceLoginManager extends LoginManager {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001B\u0010\t\u001A\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/facebook/login/DeviceLoginManager$Companion;", "", "<init>", "()V", "Lcom/facebook/login/DeviceLoginManager;", "instance$delegate", "Lie/j;", "getInstance", "()Lcom/facebook/login/DeviceLoginManager;", "instance", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DeviceLoginManager getInstance() {
            return (DeviceLoginManager)DeviceLoginManager.access$getInstance$delegate$cp().getValue();
        }
    }

    @NotNull
    public static final Companion Companion;
    @Nullable
    private String deviceAuthTargetUserId;
    @Nullable
    private Uri deviceRedirectUri;
    @NotNull
    private static final j instance$delegate;

    static {
        DeviceLoginManager.Companion = new Companion(null);
        DeviceLoginManager.instance$delegate = g.Q(DeviceLoginManager.Companion.instance.2.INSTANCE);
    }

    // 去混淆评级： 低(20)
    public static final j access$getInstance$delegate$cp() {
        return CrashShieldHandler.isObjectCrashing(DeviceLoginManager.class) ? null : DeviceLoginManager.instance$delegate;
    }

    @Override  // com.facebook.login.LoginManager
    @NotNull
    public Request createLoginRequest(@Nullable Collection collection0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Request loginClient$Request0 = super.createLoginRequest(collection0);
            Uri uri0 = this.deviceRedirectUri;
            if(uri0 != null) {
                loginClient$Request0.setDeviceRedirectUriString(uri0.toString());
            }
            String s = this.deviceAuthTargetUserId;
            if(s != null) {
                loginClient$Request0.setDeviceAuthTargetUserId(s);
            }
            return loginClient$Request0;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    // 去混淆评级： 低(20)
    @Nullable
    public final String getDeviceAuthTargetUserId() {
        return CrashShieldHandler.isObjectCrashing(this) ? null : this.deviceAuthTargetUserId;
    }

    // 去混淆评级： 低(20)
    @Nullable
    public final Uri getDeviceRedirectUri() {
        return CrashShieldHandler.isObjectCrashing(this) ? null : this.deviceRedirectUri;
    }

    public final void setDeviceAuthTargetUserId(@Nullable String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        this.deviceAuthTargetUserId = s;
    }

    public final void setDeviceRedirectUri(@Nullable Uri uri0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        this.deviceRedirectUri = uri0;
    }
}

