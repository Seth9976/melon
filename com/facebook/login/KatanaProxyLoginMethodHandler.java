package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.FacebookSdk;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.NativeProtocol;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000F\b\u0016\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001A\u00020\rH\u0016J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\u0010\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u0012H\u0016R\u0014\u0010\b\u001A\u00020\tX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0014"}, d2 = {"Lcom/facebook/login/KatanaProxyLoginMethodHandler;", "Lcom/facebook/login/NativeAppLoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "nameForLogging", "", "getNameForLogging", "()Ljava/lang/String;", "describeContents", "", "shouldKeepTrackOfMultipleIntents", "", "tryAuthorize", "request", "Lcom/facebook/login/LoginClient$Request;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class KatanaProxyLoginMethodHandler extends NativeAppLoginMethodHandler {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/KatanaProxyLoginMethodHandler$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/KatanaProxyLoginMethodHandler;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Parcelable.Creator CREATOR;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String nameForLogging;

    static {
        KatanaProxyLoginMethodHandler.Companion = new Companion(null);
        KatanaProxyLoginMethodHandler.CREATOR = new KatanaProxyLoginMethodHandler.Companion.CREATOR.1();
    }

    public KatanaProxyLoginMethodHandler(@NotNull Parcel parcel0) {
        q.g(parcel0, "source");
        super(parcel0);
        this.nameForLogging = "katana_proxy_auth";
    }

    public KatanaProxyLoginMethodHandler(@NotNull LoginClient loginClient0) {
        q.g(loginClient0, "loginClient");
        super(loginClient0);
        this.nameForLogging = "katana_proxy_auth";
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override  // com.facebook.login.LoginMethodHandler
    @NotNull
    public String getNameForLogging() {
        return this.nameForLogging;
    }

    @Override  // com.facebook.login.LoginMethodHandler
    public boolean shouldKeepTrackOfMultipleIntents() {
        return true;
    }

    @Override  // com.facebook.login.NativeAppLoginMethodHandler
    public int tryAuthorize(@NotNull Request loginClient$Request0) {
        q.g(loginClient$Request0, "request");
        boolean z = FacebookSdk.ignoreAppSwitchToLoggedOut && CustomTabUtils.getChromePackage() != null && loginClient$Request0.getLoginBehavior().allowsCustomTabAuth();
        CodeChallengeMethod codeChallengeMethod0 = loginClient$Request0.getCodeChallengeMethod();
        List list0 = NativeProtocol.createProxyAuthIntents(this.getLoginClient().getActivity(), loginClient$Request0.getApplicationId(), loginClient$Request0.getPermissions(), "{\"init\":1757129019522}", loginClient$Request0.isRerequest(), loginClient$Request0.hasPublishPermission(), (loginClient$Request0.getDefaultAudience() == null ? DefaultAudience.NONE : loginClient$Request0.getDefaultAudience()), this.getClientState(loginClient$Request0.getAuthId()), loginClient$Request0.getAuthType(), z, loginClient$Request0.getMessengerPageId(), loginClient$Request0.getResetMessengerState(), loginClient$Request0.isFamilyLogin(), loginClient$Request0.shouldSkipAccountDeduplication(), loginClient$Request0.getNonce(), loginClient$Request0.getCodeChallenge(), (codeChallengeMethod0 == null ? null : codeChallengeMethod0.name()));
        this.addLoggingExtra("e2e", "{\"init\":1757129019522}");
        int v = 0;
        Iterator iterator0 = list0.iterator();
        while(iterator0.hasNext()) {
            ++v;
            Object object0 = iterator0.next();
            if(this.tryIntent(((Intent)object0), LoginClient.Companion.getLoginRequestCode())) {
                return v;
            }
            if(false) {
                break;
            }
        }
        return 0;
    }
}

