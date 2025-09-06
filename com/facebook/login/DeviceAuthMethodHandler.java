package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u0000 02\u00020\u0001:\u00010B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0014\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u0011H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001A\u00020\u000B2\u0006\u0010\u0017\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0085\u0001\u0010(\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001A2\u0010\u0010\u001F\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u001A\u0018\u00010\u001E2\u0010\u0010 \u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u001A\u0018\u00010\u001E2\u0010\u0010!\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u001A\u0018\u00010\u001E2\b\u0010#\u001A\u0004\u0018\u00010\"2\b\u0010%\u001A\u0004\u0018\u00010$2\b\u0010&\u001A\u0004\u0018\u00010$2\b\u0010\'\u001A\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b(\u0010)J\u000F\u0010*\u001A\u00020\u000EH\u0016¢\u0006\u0004\b*\u0010+R\u001A\u0010,\u001A\u00020\u001A8\u0016X\u0096D¢\u0006\f\n\u0004\b,\u0010-\u001A\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/facebook/login/DeviceAuthMethodHandler;", "Lcom/facebook/login/LoginMethodHandler;", "Lcom/facebook/login/LoginClient;", "loginClient", "<init>", "(Lcom/facebook/login/LoginClient;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "Lcom/facebook/login/LoginClient$Request;", "request", "Lie/H;", "showDialog", "(Lcom/facebook/login/LoginClient$Request;)V", "", "tryAuthorize", "(Lcom/facebook/login/LoginClient$Request;)I", "Lcom/facebook/login/DeviceAuthDialog;", "createDeviceAuthDialog", "()Lcom/facebook/login/DeviceAuthDialog;", "onCancel", "()V", "Ljava/lang/Exception;", "ex", "onError", "(Ljava/lang/Exception;)V", "", "accessToken", "applicationId", "userId", "", "permissions", "declinedPermissions", "expiredPermissions", "Lcom/facebook/AccessTokenSource;", "accessTokenSource", "Ljava/util/Date;", "expirationTime", "lastRefreshTime", "dataAccessExpirationTime", "onSuccess", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Collection;Lcom/facebook/AccessTokenSource;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;)V", "describeContents", "()I", "nameForLogging", "Ljava/lang/String;", "getNameForLogging", "()Ljava/lang/String;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class DeviceAuthMethodHandler extends LoginMethodHandler {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001A\u00020\u0007H\u0007R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/login/DeviceAuthMethodHandler$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/DeviceAuthMethodHandler;", "backgroundExecutor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "getBackgroundExecutor", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ScheduledThreadPoolExecutor getBackgroundExecutor() {
            synchronized(this) {
                if(DeviceAuthMethodHandler.backgroundExecutor == null) {
                    DeviceAuthMethodHandler.backgroundExecutor = new ScheduledThreadPoolExecutor(1);
                }
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor0 = DeviceAuthMethodHandler.backgroundExecutor;
                if(scheduledThreadPoolExecutor0 != null) {
                    return scheduledThreadPoolExecutor0;
                }
                q.m("backgroundExecutor");
            }
            throw null;
        }
    }

    @NotNull
    public static final Parcelable.Creator CREATOR;
    @NotNull
    public static final Companion Companion;
    private static ScheduledThreadPoolExecutor backgroundExecutor;
    @NotNull
    private final String nameForLogging;

    static {
        DeviceAuthMethodHandler.Companion = new Companion(null);
        DeviceAuthMethodHandler.CREATOR = new DeviceAuthMethodHandler.Companion.CREATOR.1();
    }

    public DeviceAuthMethodHandler(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super(parcel0);
        this.nameForLogging = "device_auth";
    }

    public DeviceAuthMethodHandler(@NotNull LoginClient loginClient0) {
        q.g(loginClient0, "loginClient");
        super(loginClient0);
        this.nameForLogging = "device_auth";
    }

    @NotNull
    public DeviceAuthDialog createDeviceAuthDialog() {
        return new DeviceAuthDialog();
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public static final ScheduledThreadPoolExecutor getBackgroundExecutor() {
        synchronized(DeviceAuthMethodHandler.class) {
            return DeviceAuthMethodHandler.Companion.getBackgroundExecutor();
        }
    }

    @Override  // com.facebook.login.LoginMethodHandler
    @NotNull
    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public void onCancel() {
        Request loginClient$Request0 = this.getLoginClient().getPendingRequest();
        Result loginClient$Result0 = Result.Companion.createCancelResult(loginClient$Request0, "User canceled log in.");
        this.getLoginClient().completeAndValidate(loginClient$Result0);
    }

    public void onError(@NotNull Exception exception0) {
        q.g(exception0, "ex");
        Request loginClient$Request0 = this.getLoginClient().getPendingRequest();
        Result loginClient$Result0 = com.facebook.login.LoginClient.Result.Companion.createErrorResult$default(Result.Companion, loginClient$Request0, null, exception0.getMessage(), null, 8, null);
        this.getLoginClient().completeAndValidate(loginClient$Result0);
    }

    public void onSuccess(@NotNull String s, @NotNull String s1, @NotNull String s2, @Nullable Collection collection0, @Nullable Collection collection1, @Nullable Collection collection2, @Nullable AccessTokenSource accessTokenSource0, @Nullable Date date0, @Nullable Date date1, @Nullable Date date2) {
        q.g(s, "accessToken");
        q.g(s1, "applicationId");
        q.g(s2, "userId");
        AccessToken accessToken0 = new AccessToken(s, s1, s2, collection0, collection1, collection2, accessTokenSource0, date0, date1, date2, null, 0x400, null);
        Request loginClient$Request0 = this.getLoginClient().getPendingRequest();
        Result loginClient$Result0 = Result.Companion.createTokenResult(loginClient$Request0, accessToken0);
        this.getLoginClient().completeAndValidate(loginClient$Result0);
    }

    private final void showDialog(Request loginClient$Request0) {
        FragmentActivity fragmentActivity0 = this.getLoginClient().getActivity();
        if(fragmentActivity0 != null && !fragmentActivity0.isFinishing()) {
            DeviceAuthDialog deviceAuthDialog0 = this.createDeviceAuthDialog();
            deviceAuthDialog0.show(fragmentActivity0.getSupportFragmentManager(), "login_with_facebook");
            deviceAuthDialog0.startLogin(loginClient$Request0);
        }
    }

    @Override  // com.facebook.login.LoginMethodHandler
    public int tryAuthorize(@NotNull Request loginClient$Request0) {
        q.g(loginClient$Request0, "request");
        this.showDialog(loginClient$Request0);
        return 1;
    }
}

