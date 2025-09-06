package com.facebook.gamingservices;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.I;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@AutoHandleExceptions
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 62\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u00047689B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\u0006\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\t\u001A\u00020\u000B\u00A2\u0006\u0004\b\u0006\u0010\fB\u0011\b\u0012\u0012\u0006\u0010\u000E\u001A\u00020\r\u00A2\u0006\u0004\b\u0006\u0010\u000FJ\u001D\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u001D\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0018J!\u0010\u001C\u001A\u00020\u00132\b\u0010\u0019\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u001B\u001A\u00020\u001AH\u0014\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\'\u0010\"\u001A\u00020\u00132\u0006\u0010\u001F\u001A\u00020\u001E2\u000E\u0010!\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030 H\u0014\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010%\u001A\u00020$H\u0014\u00A2\u0006\u0004\b%\u0010&R$\u0010\u0011\u001A\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0011\u0010\'\u001A\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010\u0017\u001A\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0017\u0010,\u001A\u0004\b-\u0010.\"\u0004\b/\u00100R.\u00105\u001A\u001C\u0012\u0018\u0012\u001602R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001018TX\u0094\u0004\u00A2\u0006\u0006\u001A\u0004\b3\u00104\u00A8\u0006:"}, d2 = {"Lcom/facebook/gamingservices/TournamentShareDialog;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/gamingservices/TournamentConfig;", "Lcom/facebook/gamingservices/TournamentShareDialog$Result;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "Landroidx/fragment/app/I;", "fragment", "(Landroidx/fragment/app/I;)V", "Landroid/app/Fragment;", "(Landroid/app/Fragment;)V", "Lcom/facebook/internal/FragmentWrapper;", "fragmentWrapper", "(Lcom/facebook/internal/FragmentWrapper;)V", "", "score", "newTournamentConfig", "Lie/H;", "show", "(Ljava/lang/Number;Lcom/facebook/gamingservices/TournamentConfig;)V", "Lcom/facebook/gamingservices/Tournament;", "tournament", "(Ljava/lang/Number;Lcom/facebook/gamingservices/Tournament;)V", "content", "", "mode", "showImpl", "(Lcom/facebook/gamingservices/TournamentConfig;Ljava/lang/Object;)V", "Lcom/facebook/internal/CallbackManagerImpl;", "callbackManager", "Lcom/facebook/FacebookCallback;", "callback", "registerCallbackImpl", "(Lcom/facebook/internal/CallbackManagerImpl;Lcom/facebook/FacebookCallback;)V", "Lcom/facebook/internal/AppCall;", "createBaseAppCall", "()Lcom/facebook/internal/AppCall;", "Ljava/lang/Number;", "getScore", "()Ljava/lang/Number;", "setScore", "(Ljava/lang/Number;)V", "Lcom/facebook/gamingservices/Tournament;", "getTournament", "()Lcom/facebook/gamingservices/Tournament;", "setTournament", "(Lcom/facebook/gamingservices/Tournament;)V", "", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "getOrderedModeHandlers", "()Ljava/util/List;", "orderedModeHandlers", "Companion", "AppSwitchHandler", "FacebookAppHandler", "Result", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class TournamentShareDialog extends FacebookDialogBase {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00160\u0001R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u001A\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u00032\u0006\u0010\t\u001A\u00020\u0007H\u0016J\u0012\u0010\n\u001A\u00020\u000B2\b\u0010\b\u001A\u0004\u0018\u00010\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/TournamentShareDialog$AppSwitchHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/gamingservices/TournamentConfig;", "Lcom/facebook/gamingservices/TournamentShareDialog$Result;", "(Lcom/facebook/gamingservices/TournamentShareDialog;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class AppSwitchHandler extends ModeHandler {
        public boolean canShow(@Nullable TournamentConfig tournamentConfig0, boolean z) {
            return true;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public boolean canShow(Object object0, boolean z) {
            return this.canShow(((TournamentConfig)object0), z);
        }

        @NotNull
        public AppCall createAppCall(@Nullable TournamentConfig tournamentConfig0) {
            Uri uri0;
            AppCall appCall0 = TournamentShareDialog.this.createBaseAppCall();
            AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
            if(accessToken0 == null || accessToken0.isExpired()) {
                throw new FacebookException("Attempted to share tournament with an invalid access token");
            }
            if(accessToken0.getGraphDomain() != null && !"gaming".equals(accessToken0.getGraphDomain())) {
                throw new FacebookException("Attempted to share tournament without without gaming login");
            }
            Number number0 = TournamentShareDialog.this.getScore();
            if(number0 == null) {
                throw new FacebookException("Attempted to share tournament without a score");
            }
            if(tournamentConfig0 == null) {
                Tournament tournament0 = TournamentShareDialog.this.getTournament();
                uri0 = tournament0 == null ? null : TournamentShareDialogURIBuilder.INSTANCE.uriForUpdating$facebook_gamingservices_release(tournament0.identifier, number0, accessToken0.getApplicationId());
            }
            else {
                uri0 = TournamentShareDialogURIBuilder.INSTANCE.uriForCreating$facebook_gamingservices_release(tournamentConfig0, number0, accessToken0.getApplicationId());
            }
            Intent intent0 = new Intent("android.intent.action.VIEW", uri0);
            TournamentShareDialog.this.startActivityForResult(intent0, TournamentShareDialog.this.getRequestCode());
            return appCall0;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public AppCall createAppCall(Object object0) {
            return this.createAppCall(((TournamentConfig)object0));
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/gamingservices/TournamentShareDialog$Companion;", "", "()V", "defaultRequestCode", "", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00160\u0001R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u001A\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u00032\u0006\u0010\t\u001A\u00020\u0007H\u0016J\u0012\u0010\n\u001A\u00020\u000B2\b\u0010\b\u001A\u0004\u0018\u00010\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/TournamentShareDialog$FacebookAppHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/gamingservices/TournamentConfig;", "Lcom/facebook/gamingservices/TournamentShareDialog$Result;", "(Lcom/facebook/gamingservices/TournamentShareDialog;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class FacebookAppHandler extends ModeHandler {
        public boolean canShow(@Nullable TournamentConfig tournamentConfig0, boolean z) {
            PackageManager packageManager0 = FacebookSdk.getApplicationContext().getPackageManager();
            q.f(packageManager0, "getApplicationContext().packageManager");
            Intent intent0 = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent0.setType("text/plain");
            return intent0.resolveActivity(packageManager0) != null;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public boolean canShow(Object object0, boolean z) {
            return this.canShow(((TournamentConfig)object0), z);
        }

        @NotNull
        public AppCall createAppCall(@Nullable TournamentConfig tournamentConfig0) {
            Bundle bundle0;
            AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
            AppCall appCall0 = TournamentShareDialog.this.createBaseAppCall();
            Intent intent0 = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent0.setType("text/plain");
            if(accessToken0 == null || accessToken0.isExpired()) {
                throw new FacebookException("Attempted to share tournament with an invalid access token");
            }
            if(accessToken0.getGraphDomain() != null && !"gaming".equals(accessToken0.getGraphDomain())) {
                throw new FacebookException("Attempted to share tournament while user is not gaming logged in");
            }
            String s = accessToken0.getApplicationId();
            Number number0 = TournamentShareDialog.this.getScore();
            if(number0 == null) {
                throw new FacebookException("Attempted to share tournament without a score");
            }
            if(tournamentConfig0 == null) {
                Tournament tournament0 = TournamentShareDialog.this.getTournament();
                bundle0 = tournament0 == null ? null : TournamentShareDialogURIBuilder.INSTANCE.bundleForUpdating$facebook_gamingservices_release(tournament0.identifier, number0, s);
            }
            else {
                bundle0 = TournamentShareDialogURIBuilder.INSTANCE.bundleForCreating$facebook_gamingservices_release(tournamentConfig0, number0, s);
            }
            NativeProtocol.setupProtocolRequestIntent(intent0, appCall0.getCallId().toString(), "", 20210906, bundle0);
            appCall0.setRequestIntent(intent0);
            return appCall0;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public AppCall createAppCall(Object object0) {
            return this.createAppCall(((TournamentConfig)object0));
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001C\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001C\u0010\u000B\u001A\u0004\u0018\u00010\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000E"}, d2 = {"Lcom/facebook/gamingservices/TournamentShareDialog$Result;", "", "results", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "requestID", "", "getRequestID", "()Ljava/lang/String;", "setRequestID", "(Ljava/lang/String;)V", "tournamentID", "getTournamentID", "setTournamentID", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Result {
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
        }

        @Nullable
        public final String getRequestID() {
            return this.requestID;
        }

        @Nullable
        public final String getTournamentID() {
            return this.tournamentID;
        }

        public final void setRequestID(@Nullable String s) {
            this.requestID = s;
        }

        public final void setTournamentID(@Nullable String s) {
            this.tournamentID = s;
        }
    }

    @NotNull
    public static final Companion Companion;
    private static final int defaultRequestCode;
    @Nullable
    private Number score;
    @Nullable
    private Tournament tournament;

    static {
        TournamentShareDialog.Companion = new Companion(null);
        TournamentShareDialog.defaultRequestCode = RequestCodeOffset.TournamentShareDialog.toRequestCode();
    }

    public TournamentShareDialog(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        super(activity0, TournamentShareDialog.defaultRequestCode);
    }

    public TournamentShareDialog(@NotNull Fragment fragment0) {
        q.g(fragment0, "fragment");
        this(new FragmentWrapper(fragment0));
    }

    public TournamentShareDialog(@NotNull I i0) {
        q.g(i0, "fragment");
        this(new FragmentWrapper(i0));
    }

    private TournamentShareDialog(FragmentWrapper fragmentWrapper0) {
        super(fragmentWrapper0, TournamentShareDialog.defaultRequestCode);
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    @NotNull
    public AppCall createBaseAppCall() {
        return new AppCall(this.getRequestCode(), null, 2, null);
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    @NotNull
    public List getOrderedModeHandlers() {
        List list0 = new ArrayList();
        ((ArrayList)list0).add(new FacebookAppHandler(this));
        ((ArrayList)list0).add(new AppSwitchHandler(this));
        return list0;
    }

    @Nullable
    public final Number getScore() {
        return this.score;
    }

    @Nullable
    public final Tournament getTournament() {
        return this.tournament;
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
                    if(bundle0.getString("tournament_id") != null) {
                        Result tournamentShareDialog$Result0 = new Result(bundle0);
                        this.$callback.onSuccess(tournamentShareDialog$Result0);
                        return;
                    }
                }
                this.onCancel(appCall0);
            }
        }, 4));
    }

    private static final boolean registerCallbackImpl$lambda$0(TournamentShareDialog tournamentShareDialog0, ResultProcessor resultProcessor0, int v, Intent intent0) {
        q.g(tournamentShareDialog0, "this$0");
        return ShareInternalUtility.handleActivityResult(tournamentShareDialog0.getRequestCode(), v, intent0, resultProcessor0);
    }

    public final void setScore(@Nullable Number number0) {
        this.score = number0;
    }

    public final void setTournament(@Nullable Tournament tournament0) {
        this.tournament = tournament0;
    }

    public final void show(@NotNull Number number0, @NotNull Tournament tournament0) {
        q.g(number0, "score");
        q.g(tournament0, "tournament");
        this.score = number0;
        this.tournament = tournament0;
        this.showImpl(null, FacebookDialogBase.BASE_AUTOMATIC_MODE);
    }

    public final void show(@NotNull Number number0, @NotNull TournamentConfig tournamentConfig0) {
        q.g(number0, "score");
        q.g(tournamentConfig0, "newTournamentConfig");
        this.score = number0;
        this.showImpl(tournamentConfig0, FacebookDialogBase.BASE_AUTOMATIC_MODE);
    }

    public void showImpl(@Nullable TournamentConfig tournamentConfig0, @NotNull Object object0) {
        q.g(object0, "mode");
        super.showImpl(tournamentConfig0, object0);
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public void showImpl(Object object0, Object object1) {
        this.showImpl(((TournamentConfig)object0), object1);
    }
}

