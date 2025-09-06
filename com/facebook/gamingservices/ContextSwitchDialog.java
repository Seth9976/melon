package com.facebook.gamingservices;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.fragment.app.I;
import androidx.media3.session.a0;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import com.facebook.gamingservices.model.ContextSwitchContent;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import e.k;
import ie.H;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004*+,-B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u0006\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\t\u001A\u00020\u000B¢\u0006\u0004\b\u0006\u0010\fB\u0011\b\u0012\u0012\u0006\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u0006\u0010\u000FJ\u0017\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0010\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001F\u0010\u0019\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001AJ%\u0010\u001F\u001A\u00020\u00112\u0006\u0010\u001C\u001A\u00020\u001B2\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00030\u001DH\u0014¢\u0006\u0004\b\u001F\u0010 J\u000F\u0010\"\u001A\u00020!H\u0014¢\u0006\u0004\b\"\u0010#R\u001E\u0010\u001E\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001D8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001E\u0010$R*\u0010)\u001A\u0018\u0012\u0014\u0012\u00120&R\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010%8TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010(¨\u0006."}, d2 = {"Lcom/facebook/gamingservices/ContextSwitchDialog;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/gamingservices/model/ContextSwitchContent;", "Lcom/facebook/gamingservices/ContextSwitchDialog$Result;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "Landroidx/fragment/app/I;", "fragment", "(Landroidx/fragment/app/I;)V", "Landroid/app/Fragment;", "(Landroid/app/Fragment;)V", "Lcom/facebook/internal/FragmentWrapper;", "fragmentWrapper", "(Lcom/facebook/internal/FragmentWrapper;)V", "content", "Lie/H;", "showForCloud", "(Lcom/facebook/gamingservices/model/ContextSwitchContent;)V", "", "canShow", "(Lcom/facebook/gamingservices/model/ContextSwitchContent;)Z", "", "mode", "showImpl", "(Lcom/facebook/gamingservices/model/ContextSwitchContent;Ljava/lang/Object;)V", "Lcom/facebook/internal/CallbackManagerImpl;", "callbackManager", "Lcom/facebook/FacebookCallback;", "callback", "registerCallbackImpl", "(Lcom/facebook/internal/CallbackManagerImpl;Lcom/facebook/FacebookCallback;)V", "Lcom/facebook/internal/AppCall;", "createBaseAppCall", "()Lcom/facebook/internal/AppCall;", "Lcom/facebook/FacebookCallback;", "", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "getOrderedModeHandlers", "()Ljava/util/List;", "orderedModeHandlers", "Companion", "FacebookAppHandler", "Result", "WebHandler", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ContextSwitchDialog extends FacebookDialogBase {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/gamingservices/ContextSwitchDialog$Companion;", "", "()V", "DEFAULT_REQUEST_CODE", "", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00120\u0001R\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0007H\u0016J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/ContextSwitchDialog$FacebookAppHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/gamingservices/model/ContextSwitchContent;", "Lcom/facebook/gamingservices/ContextSwitchDialog$Result;", "(Lcom/facebook/gamingservices/ContextSwitchDialog;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class FacebookAppHandler extends ModeHandler {
        public boolean canShow(@NotNull ContextSwitchContent contextSwitchContent0, boolean z) {
            q.g(contextSwitchContent0, "content");
            Activity activity0 = ContextSwitchDialog.this.getActivityContext();
            String s = null;
            PackageManager packageManager0 = activity0 == null ? null : activity0.getPackageManager();
            Intent intent0 = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent0.setType("text/plain");
            boolean z1 = (packageManager0 == null ? null : intent0.resolveActivity(packageManager0)) != null;
            AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
            if(accessToken0 != null) {
                s = accessToken0.getGraphDomain();
            }
            return z1 && (s != null && "gaming".equals(accessToken0.getGraphDomain()));
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public boolean canShow(Object object0, boolean z) {
            return this.canShow(((ContextSwitchContent)object0), z);
        }

        @NotNull
        public AppCall createAppCall(@NotNull ContextSwitchContent contextSwitchContent0) {
            q.g(contextSwitchContent0, "content");
            AppCall appCall0 = ContextSwitchDialog.this.createBaseAppCall();
            Intent intent0 = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent0.setType("text/plain");
            AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
            Bundle bundle0 = Y.b("deeplink", "CONTEXT_SWITCH");
            if(accessToken0 == null) {
                bundle0.putString("game_id", FacebookSdk.getApplicationId());
            }
            else {
                bundle0.putString("game_id", accessToken0.getApplicationId());
            }
            if(contextSwitchContent0.getContextID() != null) {
                bundle0.putString("context_token_id", contextSwitchContent0.getContextID());
            }
            NativeProtocol.setupProtocolRequestIntent(intent0, appCall0.getCallId().toString(), "", NativeProtocol.getLatestKnownVersion(), bundle0);
            appCall0.setRequestIntent(intent0);
            return appCall0;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public AppCall createAppCall(Object object0) {
            return this.createAppCall(((ContextSwitchContent)object0));
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000F\b\u0010\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000F\b\u0010\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004¨\u0006\u000B"}, d2 = {"Lcom/facebook/gamingservices/ContextSwitchDialog$Result;", "", "contextID", "", "(Ljava/lang/String;)V", "response", "Lcom/facebook/GraphResponse;", "(Lcom/facebook/GraphResponse;)V", "getContextID", "()Ljava/lang/String;", "setContextID", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Result {
        @Nullable
        private String contextID;

        public Result(@NotNull GraphResponse graphResponse0) {
            q.g(graphResponse0, "response");
            super();
            try {
                JSONObject jSONObject0 = graphResponse0.getJSONObject();
                if(jSONObject0 != null) {
                    JSONObject jSONObject1 = jSONObject0.optJSONObject("data");
                    if(jSONObject1 != null) {
                        this.contextID = jSONObject1.getString("id");
                    }
                }
            }
            catch(JSONException unused_ex) {
                this.contextID = null;
            }
        }

        public Result(@NotNull String s) {
            q.g(s, "contextID");
            super();
            this.contextID = s;
        }

        @Nullable
        public final String getContextID() {
            return this.contextID;
        }

        public final void setContextID(@Nullable String s) {
            this.contextID = s;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00120\u0001R\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0007H\u0016J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/ContextSwitchDialog$WebHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/gamingservices/model/ContextSwitchContent;", "Lcom/facebook/gamingservices/ContextSwitchDialog$Result;", "(Lcom/facebook/gamingservices/ContextSwitchDialog;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class WebHandler extends ModeHandler {
        public boolean canShow(@NotNull ContextSwitchContent contextSwitchContent0, boolean z) {
            q.g(contextSwitchContent0, "content");
            return true;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public boolean canShow(Object object0, boolean z) {
            return this.canShow(((ContextSwitchContent)object0), z);
        }

        @NotNull
        public AppCall createAppCall(@NotNull ContextSwitchContent contextSwitchContent0) {
            q.g(contextSwitchContent0, "content");
            AppCall appCall0 = ContextSwitchDialog.this.createBaseAppCall();
            Bundle bundle0 = new Bundle();
            bundle0.putString("context_id", contextSwitchContent0.getContextID());
            AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
            if(accessToken0 != null) {
                bundle0.putString("dialog_access_token", accessToken0.getToken());
            }
            DialogPresenter.setupAppCallForWebDialog(appCall0, "context", bundle0);
            return appCall0;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public AppCall createAppCall(Object object0) {
            return this.createAppCall(((ContextSwitchContent)object0));
        }
    }

    @NotNull
    public static final Companion Companion;
    private static final int DEFAULT_REQUEST_CODE;
    @Nullable
    private FacebookCallback callback;

    static {
        ContextSwitchDialog.Companion = new Companion(null);
        ContextSwitchDialog.DEFAULT_REQUEST_CODE = RequestCodeOffset.GamingContextSwitch.toRequestCode();
    }

    public ContextSwitchDialog(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        super(activity0, ContextSwitchDialog.DEFAULT_REQUEST_CODE);
    }

    public ContextSwitchDialog(@NotNull Fragment fragment0) {
        q.g(fragment0, "fragment");
        this(new FragmentWrapper(fragment0));
    }

    public ContextSwitchDialog(@NotNull I i0) {
        q.g(i0, "fragment");
        this(new FragmentWrapper(i0));
    }

    private ContextSwitchDialog(FragmentWrapper fragmentWrapper0) {
        super(fragmentWrapper0, ContextSwitchDialog.DEFAULT_REQUEST_CODE);
    }

    public static void a(ContextSwitchDialog contextSwitchDialog0, GraphResponse graphResponse0) {
        ContextSwitchDialog.showForCloud$lambda$2(contextSwitchDialog0, graphResponse0);
    }

    // 去混淆评级： 低(25)
    public boolean canShow(@NotNull ContextSwitchContent contextSwitchContent0) {
        q.g(contextSwitchContent0, "content");
        return new FacebookAppHandler(this).canShow(contextSwitchContent0, true) || new WebHandler(this).canShow(contextSwitchContent0, true);
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public boolean canShow(Object object0) {
        return this.canShow(((ContextSwitchContent)object0));
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    @NotNull
    public AppCall createBaseAppCall() {
        return new AppCall(this.getRequestCode(), null, 2, null);
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    @NotNull
    public List getOrderedModeHandlers() {
        return k.A(new ModeHandler[]{new FacebookAppHandler(this), new WebHandler(this)});
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(@NotNull CallbackManagerImpl callbackManagerImpl0, @NotNull FacebookCallback facebookCallback0) {
        q.g(callbackManagerImpl0, "callbackManager");
        q.g(facebookCallback0, "callback");
        this.callback = facebookCallback0;
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
                    String s = bundle0.getString("id");
                    String s1 = bundle0.getString("context_id");
                    if(s != null) {
                        GamingContext gamingContext0 = new GamingContext(s);
                        GamingContext.Companion.setCurrentGamingContext(gamingContext0);
                        Result contextSwitchDialog$Result0 = new Result(s);
                        this.$callback.onSuccess(contextSwitchDialog$Result0);
                    }
                    else if(s1 != null) {
                        GamingContext gamingContext1 = new GamingContext(s1);
                        GamingContext.Companion.setCurrentGamingContext(gamingContext1);
                        Result contextSwitchDialog$Result1 = new Result(s1);
                        this.$callback.onSuccess(contextSwitchDialog$Result1);
                    }
                    FacebookException facebookException1 = new FacebookException(bundle0.getString("Invalid response received from server."));
                    this.$callback.onError(facebookException1);
                    return;
                }
                this.onCancel(appCall0);
            }
        }, 2));
    }

    private static final boolean registerCallbackImpl$lambda$3(ContextSwitchDialog contextSwitchDialog0, ResultProcessor resultProcessor0, int v, Intent intent0) {
        q.g(contextSwitchDialog0, "this$0");
        q.g(resultProcessor0, "$resultProcessor");
        return ShareInternalUtility.handleActivityResult(contextSwitchDialog0.getRequestCode(), v, intent0, resultProcessor0);
    }

    private final void showForCloud(ContextSwitchContent contextSwitchContent0) {
        AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
        if(accessToken0 == null || accessToken0.isExpired()) {
            throw new FacebookException("Attempted to open ContextSwitchContent with an invalid access token");
        }
        a0 a00 = new a0(this, 15);
        String s = contextSwitchContent0.getContextID();
        if(s != null) {
            goto label_9;
        }
        FacebookCallback facebookCallback0 = this.callback;
        if(facebookCallback0 != null) {
            facebookCallback0.onError(new FacebookException("Required string contextID not provided."));
            return;
        label_9:
            JSONObject jSONObject0 = new JSONObject();
            try {
                jSONObject0.put("id", s);
                DaemonRequest.executeAsync(this.getActivityContext(), jSONObject0, a00, SDKMessageEnum.CONTEXT_SWITCH);
            }
            catch(JSONException unused_ex) {
                FacebookCallback facebookCallback1 = this.callback;
                if(facebookCallback1 != null) {
                    facebookCallback1.onError(new FacebookException("Couldn\'t prepare Context Switch Dialog"));
                }
            }
        }
    }

    private static final void showForCloud$lambda$2(ContextSwitchDialog contextSwitchDialog0, GraphResponse graphResponse0) {
        H h0;
        q.g(contextSwitchDialog0, "this$0");
        FacebookCallback facebookCallback0 = contextSwitchDialog0.callback;
        if(facebookCallback0 != null) {
            FacebookRequestError facebookRequestError0 = graphResponse0.getError();
            if(facebookRequestError0 == null) {
                h0 = null;
            }
            else {
                facebookCallback0.onError(new FacebookException(facebookRequestError0.getErrorMessage()));
                h0 = H.a;
            }
            if(h0 == null) {
                facebookCallback0.onSuccess(new Result(graphResponse0));
            }
        }
    }

    public void showImpl(@NotNull ContextSwitchContent contextSwitchContent0, @NotNull Object object0) {
        q.g(contextSwitchContent0, "content");
        q.g(object0, "mode");
        super.showImpl(contextSwitchContent0, object0);
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public void showImpl(Object object0, Object object1) {
        this.showImpl(((ContextSwitchContent)object0), object1);
    }
}

