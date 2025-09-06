package com.facebook.gamingservices;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.fragment.app.I;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.gamingservices.internal.TournamentJoinDialogURIBuilder;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import e.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@AutoHandleExceptions
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 /2\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u00040/12B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\u0006\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\t\u001A\u00020\u000B\u00A2\u0006\u0004\b\u0006\u0010\fB\u0011\b\u0012\u0012\u0006\u0010\u000E\u001A\u00020\r\u00A2\u0006\u0004\b\u0006\u0010\u000FJ!\u0010\u0013\u001A\u00020\u00122\b\u0010\u0010\u001A\u0004\u0018\u00010\u00022\b\u0010\u0011\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001A\u00020\u00122\b\u0010\u0015\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001A\u00020\u0016H\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0019J\'\u0010\u001E\u001A\u00020\u00122\u0006\u0010\u001B\u001A\u00020\u001A2\u000E\u0010\u001D\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001CH\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010!\u001A\u00020 H\u0014\u00A2\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001A\u00020#2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0002H\u0016\u00A2\u0006\u0004\b$\u0010%R\u0018\u0010\u0010\u001A\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0010\u0010&R\u0018\u0010(\u001A\u0004\u0018\u00010\'8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010\u0011\u001A\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0011\u0010&R.\u0010.\u001A\u001C\u0012\u0018\u0012\u00160+R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010*8TX\u0094\u0004\u00A2\u0006\u0006\u001A\u0004\b,\u0010-\u00A8\u00063"}, d2 = {"Lcom/facebook/gamingservices/TournamentJoinDialog;", "Lcom/facebook/internal/FacebookDialogBase;", "", "Lcom/facebook/gamingservices/TournamentJoinDialog$Result;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "Landroidx/fragment/app/I;", "fragment", "(Landroidx/fragment/app/I;)V", "Landroid/app/Fragment;", "(Landroid/app/Fragment;)V", "Lcom/facebook/internal/FragmentWrapper;", "fragmentWrapper", "(Lcom/facebook/internal/FragmentWrapper;)V", "tournamentID", "payload", "Lie/H;", "show", "(Ljava/lang/String;Ljava/lang/String;)V", "content", "", "mode", "showImpl", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lcom/facebook/internal/CallbackManagerImpl;", "callbackManager", "Lcom/facebook/FacebookCallback;", "callback", "registerCallbackImpl", "(Lcom/facebook/internal/CallbackManagerImpl;Lcom/facebook/FacebookCallback;)V", "Lcom/facebook/internal/AppCall;", "createBaseAppCall", "()Lcom/facebook/internal/AppCall;", "", "canShow", "(Ljava/lang/String;)Z", "Ljava/lang/String;", "", "requestID", "Ljava/lang/Number;", "", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "getOrderedModeHandlers", "()Ljava/util/List;", "orderedModeHandlers", "Companion", "ChromeCustomTabHandler", "FacebookAppHandler", "Result", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class TournamentJoinDialog extends FacebookDialogBase {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00160\u0001R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u001A\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u00032\u0006\u0010\t\u001A\u00020\u0007H\u0016J\u0012\u0010\n\u001A\u00020\u000B2\b\u0010\b\u001A\u0004\u0018\u00010\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/TournamentJoinDialog$ChromeCustomTabHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "", "Lcom/facebook/gamingservices/TournamentJoinDialog$Result;", "(Lcom/facebook/gamingservices/TournamentJoinDialog;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class ChromeCustomTabHandler extends ModeHandler {
        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public boolean canShow(Object object0, boolean z) {
            return this.canShow(((String)object0), z);
        }

        public boolean canShow(@Nullable String s, boolean z) {
            return CustomTabUtils.getChromePackage() != null;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public AppCall createAppCall(Object object0) {
            return this.createAppCall(((String)object0));
        }

        @NotNull
        public AppCall createAppCall(@Nullable String s) {
            String s1;
            AppCall appCall0 = TournamentJoinDialog.this.createBaseAppCall();
            AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
            Bundle bundle0 = new Bundle();
            Bundle bundle1 = new Bundle();
            if(accessToken0 == null) {
                s1 = FacebookSdk.getApplicationId();
            }
            else {
                s1 = accessToken0.getApplicationId();
                if(s1 == null) {
                    s1 = FacebookSdk.getApplicationId();
                }
            }
            bundle0.putString("app_id", s1);
            bundle0.putString("payload", bundle1.toString());
            bundle0.putString("access_token", (accessToken0 == null ? null : accessToken0.getToken()));
            bundle0.putString("redirect_uri", CustomTabUtils.getDefaultRedirectURI());
            DialogPresenter.setupAppCallForCustomTabDialog(appCall0, "join_tournament", bundle0);
            return appCall0;
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/facebook/gamingservices/TournamentJoinDialog$Companion;", "", "()V", "DEFAULT_REQUEST_CODE", "", "JOIN_TOURNAMENT_ACCESS_TOKEN_KEY", "", "JOIN_TOURNAMENT_ACTION", "JOIN_TOURNAMENT_CONTENT_TYPE", "JOIN_TOURNAMENT_DIALOG", "JOIN_TOURNAMENT_ERROR_MESSAGE_KEY", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00160\u0001R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u001A\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u00032\u0006\u0010\t\u001A\u00020\u0007H\u0016J\u0012\u0010\n\u001A\u00020\u000B2\b\u0010\b\u001A\u0004\u0018\u00010\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/TournamentJoinDialog$FacebookAppHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "", "Lcom/facebook/gamingservices/TournamentJoinDialog$Result;", "(Lcom/facebook/gamingservices/TournamentJoinDialog;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class FacebookAppHandler extends ModeHandler {
        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public boolean canShow(Object object0, boolean z) {
            return this.canShow(((String)object0), z);
        }

        public boolean canShow(@Nullable String s, boolean z) {
            PackageManager packageManager0 = FacebookSdk.getApplicationContext().getPackageManager();
            q.f(packageManager0, "getApplicationContext().packageManager");
            Intent intent0 = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent0.setType("text/plain");
            return intent0.resolveActivity(packageManager0) != null;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public AppCall createAppCall(Object object0) {
            return this.createAppCall(((String)object0));
        }

        @NotNull
        public AppCall createAppCall(@Nullable String s) {
            AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
            AppCall appCall0 = TournamentJoinDialog.this.createBaseAppCall();
            Intent intent0 = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent0.setType("text/plain");
            if(accessToken0 == null || accessToken0.isExpired()) {
                throw new FacebookException("Attempted to present TournamentJoinDialog with an invalid access token");
            }
            if(accessToken0.getGraphDomain() != null && !"gaming".equals(accessToken0.getGraphDomain())) {
                throw new FacebookException("Attempted to present TournamentJoinDialog while user is not gaming logged in");
            }
            Bundle bundle0 = TournamentJoinDialogURIBuilder.INSTANCE.bundle$facebook_gamingservices_release(accessToken0.getApplicationId(), TournamentJoinDialog.this.tournamentID, TournamentJoinDialog.this.payload);
            NativeProtocol.setupProtocolRequestIntent(intent0, appCall0.getCallId().toString(), "", 20210906, bundle0);
            appCall0.setRequestIntent(intent0);
            return appCall0;
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u000B\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001C\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001C\u0010\u000B\u001A\u0004\u0018\u00010\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001C\u0010\u000E\u001A\u0004\u0018\u00010\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\b\"\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/facebook/gamingservices/TournamentJoinDialog$Result;", "", "results", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "payload", "", "getPayload", "()Ljava/lang/String;", "setPayload", "(Ljava/lang/String;)V", "requestID", "getRequestID", "setRequestID", "tournamentID", "getTournamentID", "setTournamentID", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Result {
        @Nullable
        private String payload;
        @Nullable
        private String requestID;
        @Nullable
        private String tournamentID;

        public Result(@NotNull Bundle bundle0) {
            q.g(bundle0, "results");
            super();
            if(bundle0.getString("request") != null) {
                this.requestID = bundle0.getString("request");
            }
            this.tournamentID = bundle0.getString("tournament_id");
            this.payload = bundle0.getString("payload");
        }

        @Nullable
        public final String getPayload() {
            return this.payload;
        }

        @Nullable
        public final String getRequestID() {
            return this.requestID;
        }

        @Nullable
        public final String getTournamentID() {
            return this.tournamentID;
        }

        public final void setPayload(@Nullable String s) {
            this.payload = s;
        }

        public final void setRequestID(@Nullable String s) {
            this.requestID = s;
        }

        public final void setTournamentID(@Nullable String s) {
            this.tournamentID = s;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private static final int DEFAULT_REQUEST_CODE = 0;
    @NotNull
    private static final String JOIN_TOURNAMENT_ACCESS_TOKEN_KEY = "access_token";
    @NotNull
    private static final String JOIN_TOURNAMENT_ACTION = "com.facebook.games.gaming_services.DEEPLINK";
    @NotNull
    private static final String JOIN_TOURNAMENT_CONTENT_TYPE = "text/plain";
    @NotNull
    private static final String JOIN_TOURNAMENT_DIALOG = "join_tournament";
    @NotNull
    private static final String JOIN_TOURNAMENT_ERROR_MESSAGE_KEY = "error_message";
    @Nullable
    private String payload;
    @Nullable
    private Number requestID;
    @Nullable
    private String tournamentID;

    static {
        TournamentJoinDialog.Companion = new Companion(null);
        TournamentJoinDialog.DEFAULT_REQUEST_CODE = RequestCodeOffset.TournamentJoinDialog.toRequestCode();
    }

    public TournamentJoinDialog(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        super(activity0, TournamentJoinDialog.DEFAULT_REQUEST_CODE);
    }

    public TournamentJoinDialog(@NotNull Fragment fragment0) {
        q.g(fragment0, "fragment");
        this(new FragmentWrapper(fragment0));
    }

    public TournamentJoinDialog(@NotNull I i0) {
        q.g(i0, "fragment");
        this(new FragmentWrapper(i0));
    }

    private TournamentJoinDialog(FragmentWrapper fragmentWrapper0) {
        super(fragmentWrapper0, TournamentJoinDialog.DEFAULT_REQUEST_CODE);
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public boolean canShow(Object object0) {
        return this.canShow(((String)object0));
    }

    // 去混淆评级： 中等(50)
    public boolean canShow(@Nullable String s) {
        return new FacebookAppHandler(this).canShow(s, true) ? true : new ChromeCustomTabHandler(this).canShow(s, true);
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    @NotNull
    public AppCall createBaseAppCall() {
        return new AppCall(this.getRequestCode(), null, 2, null);
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    @NotNull
    public List getOrderedModeHandlers() {
        return k.A(new ModeHandler[]{new FacebookAppHandler(this), new ChromeCustomTabHandler(this)});
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(@NotNull CallbackManagerImpl callbackManagerImpl0, @NotNull FacebookCallback facebookCallback0) {
        q.g(callbackManagerImpl0, "callbackManager");
        q.g(facebookCallback0, "callback");
        callbackManagerImpl0.registerCallback(this.getRequestCode(), new a(this, new ResultProcessor(/*ERROR_MISSING_ARG_0/*) {
            @Override  // com.facebook.share.internal.ResultProcessor
            public void onSuccess(@NotNull AppCall appCall0, @Nullable Bundle bundle0) {
                q.g(appCall0, "appCall");
                if(bundle0 != null) {
                    if(bundle0.getString("error_message") != null) {
                        FacebookException facebookException0 = new FacebookException(bundle0.getString("error_message"));
                        this.$callback.onError(facebookException0);
                        return;
                    }
                    if(bundle0.getString("payload") != null) {
                        Result tournamentJoinDialog$Result0 = new Result(bundle0);
                        this.$callback.onSuccess(tournamentJoinDialog$Result0);
                        return;
                    }
                }
                this.onCancel(appCall0);
            }
        }, 3));
    }

    private static final boolean registerCallbackImpl$lambda$0(TournamentJoinDialog tournamentJoinDialog0, ResultProcessor resultProcessor0, int v, Intent intent0) {
        q.g(tournamentJoinDialog0, "this$0");
        q.g(resultProcessor0, "$resultProcessor");
        return ShareInternalUtility.handleActivityResult(tournamentJoinDialog0.getRequestCode(), v, intent0, resultProcessor0);
    }

    public final void show(@Nullable String s, @Nullable String s1) {
        this.tournamentID = s;
        this.payload = s1;
        super.showImpl(s, FacebookDialogBase.BASE_AUTOMATIC_MODE);
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public void showImpl(Object object0, Object object1) {
        this.showImpl(((String)object0), object1);
    }

    public void showImpl(@Nullable String s, @NotNull Object object0) {
        q.g(object0, "mode");
        super.showImpl(s, object0);
    }
}

