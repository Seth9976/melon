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
import com.facebook.gamingservices.model.ContextChooseContent;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004+*,-B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u0006\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\t\u001A\u00020\u000B¢\u0006\u0004\b\u0006\u0010\fB\u0011\b\u0012\u0012\u0006\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u0006\u0010\u000FJ\u0017\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0010\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001F\u0010\u0019\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001AJ%\u0010\u001F\u001A\u00020\u00112\u0006\u0010\u001C\u001A\u00020\u001B2\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00030\u001DH\u0014¢\u0006\u0004\b\u001F\u0010 J\u000F\u0010\"\u001A\u00020!H\u0014¢\u0006\u0004\b\"\u0010#R\u001E\u0010\u001E\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001D8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001E\u0010$R*\u0010)\u001A\u0018\u0012\u0014\u0012\u00120&R\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010%8TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010(¨\u0006."}, d2 = {"Lcom/facebook/gamingservices/ContextChooseDialog;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/gamingservices/model/ContextChooseContent;", "Lcom/facebook/gamingservices/ContextChooseDialog$Result;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "Landroidx/fragment/app/I;", "fragment", "(Landroidx/fragment/app/I;)V", "Landroid/app/Fragment;", "(Landroid/app/Fragment;)V", "Lcom/facebook/internal/FragmentWrapper;", "fragmentWrapper", "(Lcom/facebook/internal/FragmentWrapper;)V", "content", "Lie/H;", "showForCloud", "(Lcom/facebook/gamingservices/model/ContextChooseContent;)V", "", "canShow", "(Lcom/facebook/gamingservices/model/ContextChooseContent;)Z", "", "mode", "showImpl", "(Lcom/facebook/gamingservices/model/ContextChooseContent;Ljava/lang/Object;)V", "Lcom/facebook/internal/CallbackManagerImpl;", "callbackManager", "Lcom/facebook/FacebookCallback;", "callback", "registerCallbackImpl", "(Lcom/facebook/internal/CallbackManagerImpl;Lcom/facebook/FacebookCallback;)V", "Lcom/facebook/internal/AppCall;", "createBaseAppCall", "()Lcom/facebook/internal/AppCall;", "Lcom/facebook/FacebookCallback;", "", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "getOrderedModeHandlers", "()Ljava/util/List;", "orderedModeHandlers", "Companion", "ChromeCustomTabHandler", "FacebookAppHandler", "Result", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ContextChooseDialog extends FacebookDialogBase {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00120\u0001R\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0007H\u0016J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/ContextChooseDialog$ChromeCustomTabHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/gamingservices/model/ContextChooseContent;", "Lcom/facebook/gamingservices/ContextChooseDialog$Result;", "(Lcom/facebook/gamingservices/ContextChooseDialog;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class ChromeCustomTabHandler extends ModeHandler {
        public boolean canShow(@NotNull ContextChooseContent contextChooseContent0, boolean z) {
            q.g(contextChooseContent0, "content");
            return CustomTabUtils.getChromePackage() != null;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public boolean canShow(Object object0, boolean z) {
            return this.canShow(((ContextChooseContent)object0), z);
        }

        @NotNull
        public AppCall createAppCall(@NotNull ContextChooseContent contextChooseContent0) {
            String s;
            q.g(contextChooseContent0, "content");
            AppCall appCall0 = ContextChooseDialog.this.createBaseAppCall();
            AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
            Bundle bundle0 = new Bundle();
            Bundle bundle1 = new Bundle();
            Bundle bundle2 = new Bundle();
            if(accessToken0 == null) {
                s = FacebookSdk.getApplicationId();
            }
            else {
                s = accessToken0.getApplicationId();
                if(s == null) {
                    s = FacebookSdk.getApplicationId();
                }
            }
            bundle0.putString("app_id", s);
            if(contextChooseContent0.getMinSize() != null) {
                bundle2.putString("min_size", contextChooseContent0.getMinSize().toString());
            }
            if(contextChooseContent0.getMaxSize() != null) {
                bundle2.putString("max_size", contextChooseContent0.getMaxSize().toString());
            }
            if(contextChooseContent0.getFilters() != null) {
                bundle2.putString("filters", new JSONArray(contextChooseContent0.getFilters()).toString());
            }
            bundle1.putString("filters", bundle2.toString());
            bundle0.putString("payload", bundle1.toString());
            bundle0.putString("redirect_uri", CustomTabUtils.getDefaultRedirectURI());
            DialogPresenter.setupAppCallForCustomTabDialog(appCall0, "context_choose", bundle0);
            return appCall0;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public AppCall createAppCall(Object object0) {
            return this.createAppCall(((ContextChooseContent)object0));
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/facebook/gamingservices/ContextChooseDialog$Companion;", "", "()V", "CONTEXT_CHOOSE_DIALOG", "", "DEFAULT_REQUEST_CODE", "", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00120\u0001R\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0007H\u0016J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/ContextChooseDialog$FacebookAppHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/gamingservices/model/ContextChooseContent;", "Lcom/facebook/gamingservices/ContextChooseDialog$Result;", "(Lcom/facebook/gamingservices/ContextChooseDialog;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class FacebookAppHandler extends ModeHandler {
        public boolean canShow(@NotNull ContextChooseContent contextChooseContent0, boolean z) {
            q.g(contextChooseContent0, "content");
            Activity activity0 = ContextChooseDialog.this.getActivityContext();
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
            return this.canShow(((ContextChooseContent)object0), z);
        }

        @NotNull
        public AppCall createAppCall(@NotNull ContextChooseContent contextChooseContent0) {
            q.g(contextChooseContent0, "content");
            AppCall appCall0 = ContextChooseDialog.this.createBaseAppCall();
            Intent intent0 = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent0.setType("text/plain");
            AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
            Bundle bundle0 = Y.b("deeplink", "CONTEXT_CHOOSE");
            if(accessToken0 == null) {
                bundle0.putString("game_id", FacebookSdk.getApplicationId());
            }
            else {
                bundle0.putString("game_id", accessToken0.getApplicationId());
            }
            if(contextChooseContent0.getMinSize() != null) {
                bundle0.putString("min_thread_size", contextChooseContent0.getMinSize().toString());
            }
            if(contextChooseContent0.getMaxSize() != null) {
                bundle0.putString("max_thread_size", contextChooseContent0.getMaxSize().toString());
            }
            if(contextChooseContent0.getFilters() != null) {
                bundle0.putString("filters", new JSONArray(contextChooseContent0.getFilters()).toString());
            }
            NativeProtocol.setupProtocolRequestIntent(intent0, appCall0.getCallId().toString(), "", NativeProtocol.getLatestKnownVersion(), bundle0);
            appCall0.setRequestIntent(intent0);
            return appCall0;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public AppCall createAppCall(Object object0) {
            return this.createAppCall(((ContextChooseContent)object0));
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000F\b\u0016\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001C\u0010\b\u001A\u0004\u0018\u00010\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/facebook/gamingservices/ContextChooseDialog$Result;", "", "results", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "response", "Lcom/facebook/GraphResponse;", "(Lcom/facebook/GraphResponse;)V", "contextID", "", "getContextID", "()Ljava/lang/String;", "setContextID", "(Ljava/lang/String;)V", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Result {
        @Nullable
        private String contextID;

        public Result(@NotNull Bundle bundle0) {
            q.g(bundle0, "results");
            super();
            this.contextID = bundle0.getString("id");
        }

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

        @Nullable
        public final String getContextID() {
            return this.contextID;
        }

        public final void setContextID(@Nullable String s) {
            this.contextID = s;
        }
    }

    @NotNull
    private static final String CONTEXT_CHOOSE_DIALOG = "context_choose";
    @NotNull
    public static final Companion Companion;
    private static final int DEFAULT_REQUEST_CODE;
    @Nullable
    private FacebookCallback callback;

    static {
        ContextChooseDialog.Companion = new Companion(null);
        ContextChooseDialog.DEFAULT_REQUEST_CODE = RequestCodeOffset.GamingContextChoose.toRequestCode();
    }

    public ContextChooseDialog(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        super(activity0, ContextChooseDialog.DEFAULT_REQUEST_CODE);
    }

    public ContextChooseDialog(@NotNull Fragment fragment0) {
        q.g(fragment0, "fragment");
        this(new FragmentWrapper(fragment0));
    }

    public ContextChooseDialog(@NotNull I i0) {
        q.g(i0, "fragment");
        this(new FragmentWrapper(i0));
    }

    private ContextChooseDialog(FragmentWrapper fragmentWrapper0) {
        super(fragmentWrapper0, ContextChooseDialog.DEFAULT_REQUEST_CODE);
    }

    public static void a(ContextChooseDialog contextChooseDialog0, GraphResponse graphResponse0) {
        ContextChooseDialog.showForCloud$lambda$2(contextChooseDialog0, graphResponse0);
    }

    // 去混淆评级： 低(25)
    public boolean canShow(@NotNull ContextChooseContent contextChooseContent0) {
        q.g(contextChooseContent0, "content");
        return new FacebookAppHandler(this).canShow(contextChooseContent0, true) || new ChromeCustomTabHandler(this).canShow(contextChooseContent0, true);
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public boolean canShow(Object object0) {
        return this.canShow(((ContextChooseContent)object0));
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
                    if(s != null) {
                        GamingContext gamingContext0 = new GamingContext(s);
                        GamingContext.Companion.setCurrentGamingContext(gamingContext0);
                        Result contextChooseDialog$Result0 = new Result(bundle0);
                        this.$callback.onSuccess(contextChooseDialog$Result0);
                    }
                    FacebookException facebookException1 = new FacebookException(bundle0.getString("Invalid response received from server."));
                    this.$callback.onError(facebookException1);
                    return;
                }
                this.onCancel(appCall0);
            }
        }, 0));
    }

    private static final boolean registerCallbackImpl$lambda$4(ContextChooseDialog contextChooseDialog0, com.facebook.gamingservices.ContextChooseDialog.registerCallbackImpl.resultProcessor.1 contextChooseDialog$registerCallbackImpl$resultProcessor$10, int v, Intent intent0) {
        q.g(contextChooseDialog0, "this$0");
        q.g(contextChooseDialog$registerCallbackImpl$resultProcessor$10, "$resultProcessor");
        return ShareInternalUtility.handleActivityResult(contextChooseDialog0.getRequestCode(), v, intent0, contextChooseDialog$registerCallbackImpl$resultProcessor$10);
    }

    private final void showForCloud(ContextChooseContent contextChooseContent0) {
        AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
        if(accessToken0 == null || accessToken0.isExpired()) {
            throw new FacebookException("Attempted to open ContextChooseContent with an invalid access token");
        }
        a0 a00 = new a0(this, 13);
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("filters", contextChooseContent0.getFilters());
            jSONObject0.put("minSize", contextChooseContent0.getMinSize());
            List list0 = contextChooseContent0.getFilters();
            if(list0 != null) {
                JSONArray jSONArray0 = new JSONArray();
                for(Object object0: list0) {
                    jSONArray0.put(((String)object0));
                }
                jSONObject0.put("filters", jSONArray0);
            }
            DaemonRequest.executeAsync(this.getActivityContext(), jSONObject0, a00, SDKMessageEnum.CONTEXT_CHOOSE);
        }
        catch(JSONException unused_ex) {
            FacebookCallback facebookCallback0 = this.callback;
            if(facebookCallback0 != null) {
                facebookCallback0.onError(new FacebookException("Couldn\'t prepare Context Choose Dialog"));
            }
        }
    }

    private static final void showForCloud$lambda$2(ContextChooseDialog contextChooseDialog0, GraphResponse graphResponse0) {
        H h0;
        q.g(contextChooseDialog0, "this$0");
        FacebookCallback facebookCallback0 = contextChooseDialog0.callback;
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

    public void showImpl(@NotNull ContextChooseContent contextChooseContent0, @NotNull Object object0) {
        q.g(contextChooseContent0, "content");
        q.g(object0, "mode");
        super.showImpl(contextChooseContent0, object0);
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public void showImpl(Object object0, Object object1) {
        this.showImpl(((ContextChooseContent)object0), object1);
    }
}

