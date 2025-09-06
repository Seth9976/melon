package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookSdk;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001F2\u00020\u0001:\u0001\u001FB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001A\u0010\u0016\u001A\u00020\u00158\u0016X\u0096D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u001A\u0010\u001B\u001A\u00020\u001A8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u001E¨\u0006 "}, d2 = {"Lcom/facebook/login/InstagramAppLoginMethodHandler;", "Lcom/facebook/login/NativeAppLoginMethodHandler;", "Lcom/facebook/login/LoginClient;", "loginClient", "<init>", "(Lcom/facebook/login/LoginClient;)V", "Landroid/os/Parcel;", "source", "(Landroid/os/Parcel;)V", "Lcom/facebook/login/LoginClient$Request;", "request", "", "tryAuthorize", "(Lcom/facebook/login/LoginClient$Request;)I", "describeContents", "()I", "dest", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "nameForLogging", "Ljava/lang/String;", "getNameForLogging", "()Ljava/lang/String;", "Lcom/facebook/AccessTokenSource;", "tokenSource", "Lcom/facebook/AccessTokenSource;", "getTokenSource", "()Lcom/facebook/AccessTokenSource;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InstagramAppLoginMethodHandler extends NativeAppLoginMethodHandler {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/InstagramAppLoginMethodHandler$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/InstagramAppLoginMethodHandler;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    @NotNull
    private final AccessTokenSource tokenSource;

    static {
        InstagramAppLoginMethodHandler.Companion = new Companion(null);
        InstagramAppLoginMethodHandler.CREATOR = new InstagramAppLoginMethodHandler.Companion.CREATOR.1();
    }

    public InstagramAppLoginMethodHandler(@NotNull Parcel parcel0) {
        q.g(parcel0, "source");
        super(parcel0);
        this.nameForLogging = "instagram_login";
        this.tokenSource = AccessTokenSource.INSTAGRAM_APPLICATION_WEB;
    }

    public InstagramAppLoginMethodHandler(@NotNull LoginClient loginClient0) {
        q.g(loginClient0, "loginClient");
        super(loginClient0);
        this.nameForLogging = "instagram_login";
        this.tokenSource = AccessTokenSource.INSTAGRAM_APPLICATION_WEB;
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

    @Override  // com.facebook.login.NativeAppLoginMethodHandler
    @NotNull
    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    @Override  // com.facebook.login.NativeAppLoginMethodHandler
    public int tryAuthorize(@NotNull Request loginClient$Request0) {
        q.g(loginClient$Request0, "request");
        com.facebook.login.LoginClient.Companion loginClient$Companion0 = LoginClient.Companion;
        Context context0 = this.getLoginClient().getActivity();
        if(context0 == null) {
            context0 = FacebookSdk.getApplicationContext();
        }
        Intent intent0 = NativeProtocol.createInstagramIntent(context0, loginClient$Request0.getApplicationId(), loginClient$Request0.getPermissions(), "{\"init\":1757129019037}", loginClient$Request0.isRerequest(), loginClient$Request0.hasPublishPermission(), (loginClient$Request0.getDefaultAudience() == null ? DefaultAudience.NONE : loginClient$Request0.getDefaultAudience()), this.getClientState(loginClient$Request0.getAuthId()), loginClient$Request0.getAuthType(), loginClient$Request0.getMessengerPageId(), loginClient$Request0.getResetMessengerState(), loginClient$Request0.isFamilyLogin(), loginClient$Request0.shouldSkipAccountDeduplication());
        this.addLoggingExtra("e2e", "{\"init\":1757129019037}");
        return this.tryIntent(intent0, loginClient$Companion0.getLoginRequestCode());
    }

    @Override  // com.facebook.login.LoginMethodHandler
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        super.writeToParcel(parcel0, v);
    }
}

