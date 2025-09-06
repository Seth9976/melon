package com.facebook.login.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DeviceLoginManager;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B\u001F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\tB\u000F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\nR\u001C\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u0018\u0010\u0011\u001A\u00060\u0012R\u00020\u00018TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/facebook/login/widget/DeviceLoginButton;", "Lcom/facebook/login/widget/LoginButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "deviceRedirectUri", "Landroid/net/Uri;", "getDeviceRedirectUri", "()Landroid/net/Uri;", "setDeviceRedirectUri", "(Landroid/net/Uri;)V", "newLoginClickListener", "Lcom/facebook/login/widget/LoginButton$LoginClickListener;", "getNewLoginClickListener", "()Lcom/facebook/login/widget/LoginButton$LoginClickListener;", "DeviceLoginClickListener", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class DeviceLoginButton extends LoginButton {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0083\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/widget/DeviceLoginButton$DeviceLoginClickListener;", "Lcom/facebook/login/widget/LoginButton$LoginClickListener;", "Lcom/facebook/login/widget/LoginButton;", "(Lcom/facebook/login/widget/DeviceLoginButton;)V", "getLoginManager", "Lcom/facebook/login/LoginManager;", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class DeviceLoginClickListener extends LoginClickListener {
        @Override  // com.facebook.login.widget.LoginButton$LoginClickListener
        @NotNull
        public LoginManager getLoginManager() {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                LoginManager loginManager0 = DeviceLoginManager.Companion.getInstance();
                loginManager0.setDefaultAudience(DeviceLoginButton.this.getDefaultAudience());
                loginManager0.setLoginBehavior(LoginBehavior.DEVICE_AUTH);
                ((DeviceLoginManager)loginManager0).setDeviceRedirectUri(DeviceLoginButton.this.getDeviceRedirectUri());
                return loginManager0;
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
                return null;
            }
        }
    }

    @Nullable
    private Uri deviceRedirectUri;

    public DeviceLoginButton(@NotNull Context context0) {
        q.g(context0, "context");
        super(context0);
    }

    public DeviceLoginButton(@NotNull Context context0, @NotNull AttributeSet attributeSet0) {
        q.g(context0, "context");
        q.g(attributeSet0, "attrs");
        super(context0, attributeSet0);
    }

    public DeviceLoginButton(@NotNull Context context0, @NotNull AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        q.g(attributeSet0, "attrs");
        super(context0, attributeSet0, v);
    }

    @Nullable
    public final Uri getDeviceRedirectUri() {
        return this.deviceRedirectUri;
    }

    @Override  // com.facebook.login.widget.LoginButton
    @NotNull
    public LoginClickListener getNewLoginClickListener() {
        return new DeviceLoginClickListener(this);
    }

    public final void setDeviceRedirectUri(@Nullable Uri uri0) {
        this.deviceRedirectUri = uri0;
    }
}

