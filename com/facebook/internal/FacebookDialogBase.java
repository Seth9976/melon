package com.facebook.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.facebook.CallbackManager.ActivityResultParameters;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import e.h;
import e.i;
import f.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001B\b&\u0018\u0000 M*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003:\u0002MNB\u0019\b\u0014\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\b\u0010\tB\u0019\b\u0014\u0012\u0006\u0010\u000B\u001A\u00020\n\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\b\u0010\fB\u0011\b\u0014\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\b\u0010\rJ!\u0010\u0012\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u000E\u001A\u00028\u00002\u0006\u0010\u0010\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0017\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014H\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001B\u001A\u0018\u0012\u0014\u0012\u00120\u001AR\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u0019H\u0002\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010\u001D\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014\u00A2\u0006\u0004\b\u001D\u0010\u0018J%\u0010 \u001A\u00020\u00162\u0006\u0010\u0015\u001A\u00020\u00142\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00010\u001EH\u0016\u00A2\u0006\u0004\b \u0010!J-\u0010 \u001A\u00020\u00162\u0006\u0010\u0015\u001A\u00020\u00142\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00010\u001E2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b \u0010\"J%\u0010$\u001A\u00020\u00162\u0006\u0010\u0015\u001A\u00020#2\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00010\u001EH$\u00A2\u0006\u0004\b$\u0010%J\u0017\u0010\'\u001A\u00020&2\u0006\u0010\u000E\u001A\u00028\u0000H\u0016\u00A2\u0006\u0004\b\'\u0010(J\u001F\u0010)\u001A\u00020&2\u0006\u0010\u000E\u001A\u00028\u00002\u0006\u0010\u0010\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b)\u0010*J\u0017\u0010+\u001A\u00020\u00162\u0006\u0010\u000E\u001A\u00028\u0000H\u0016\u00A2\u0006\u0004\b+\u0010,J-\u0010/\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020.0-2\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001A\u00020\u000FH\u0004\u00A2\u0006\u0004\b/\u00100J%\u0010/\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020.0-2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014H\u0016\u00A2\u0006\u0004\b/\u00101J\u001F\u00102\u001A\u00020\u00162\u0006\u0010\u000E\u001A\u00028\u00002\u0006\u0010\u0010\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b2\u00103J\u001F\u00106\u001A\u00020\u00162\u0006\u00105\u001A\u0002042\u0006\u0010\u0007\u001A\u00020\u0006H\u0004\u00A2\u0006\u0004\b6\u00107J\u000F\u00108\u001A\u00020\u0011H$\u00A2\u0006\u0004\b8\u00109R\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010:R\u0016\u0010\u000B\u001A\u0004\u0018\u00010\n8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u000B\u0010;R.\u0010<\u001A\u001A\u0012\u0014\u0012\u00120\u001AR\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0018\u00010\u00198\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b>\u0010?R$\u0010\u0015\u001A\u0004\u0018\u00010\u00148A@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\u0015\u0010@\u001A\u0004\bA\u0010B\"\u0004\bC\u0010\u0018R$\u0010\u0007\u001A\u00020\u00062\u0006\u0010D\u001A\u00020\u00068F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\bE\u0010F\"\u0004\bG\u0010\rR\u0016\u0010J\u001A\u0004\u0018\u00010\u00048DX\u0084\u0004\u00A2\u0006\u0006\u001A\u0004\bH\u0010IR*\u0010L\u001A\u0018\u0012\u0014\u0012\u00120\u001AR\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u00198$X\u00A4\u0004\u00A2\u0006\u0006\u001A\u0004\bK\u0010\u001C\u00A8\u0006O"}, d2 = {"Lcom/facebook/internal/FacebookDialogBase;", "CONTENT", "RESULT", "Lcom/facebook/FacebookDialog;", "Landroid/app/Activity;", "activity", "", "requestCode", "<init>", "(Landroid/app/Activity;I)V", "Lcom/facebook/internal/FragmentWrapper;", "fragmentWrapper", "(Lcom/facebook/internal/FragmentWrapper;I)V", "(I)V", "content", "", "mode", "Lcom/facebook/internal/AppCall;", "createAppCallForMode", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/facebook/internal/AppCall;", "Lcom/facebook/CallbackManager;", "callbackManager", "Lie/H;", "memorizeCallbackManager", "(Lcom/facebook/CallbackManager;)V", "", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "cachedModeHandlers", "()Ljava/util/List;", "setCallbackManager", "Lcom/facebook/FacebookCallback;", "callback", "registerCallback", "(Lcom/facebook/CallbackManager;Lcom/facebook/FacebookCallback;)V", "(Lcom/facebook/CallbackManager;Lcom/facebook/FacebookCallback;I)V", "Lcom/facebook/internal/CallbackManagerImpl;", "registerCallbackImpl", "(Lcom/facebook/internal/CallbackManagerImpl;Lcom/facebook/FacebookCallback;)V", "", "canShow", "(Ljava/lang/Object;)Z", "canShowImpl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "show", "(Ljava/lang/Object;)V", "Lf/b;", "Lcom/facebook/CallbackManager$ActivityResultParameters;", "createActivityResultContractForShowingDialog", "(Lcom/facebook/CallbackManager;Ljava/lang/Object;)Lf/b;", "(Lcom/facebook/CallbackManager;)Lf/b;", "showImpl", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Landroid/content/Intent;", "intent", "startActivityForResult", "(Landroid/content/Intent;I)V", "createBaseAppCall", "()Lcom/facebook/internal/AppCall;", "Landroid/app/Activity;", "Lcom/facebook/internal/FragmentWrapper;", "modeHandlers", "Ljava/util/List;", "requestCodeField", "I", "Lcom/facebook/CallbackManager;", "getCallbackManager$facebook_common_release", "()Lcom/facebook/CallbackManager;", "setCallbackManager$facebook_common_release", "value", "getRequestCode", "()I", "setRequestCode", "getActivityContext", "()Landroid/app/Activity;", "activityContext", "getOrderedModeHandlers", "orderedModeHandlers", "Companion", "ModeHandler", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class FacebookDialogBase implements FacebookDialog {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001A\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/FacebookDialogBase$Companion;", "", "()V", "BASE_AUTOMATIC_MODE", "TAG", "", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b¤\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001D\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00028\u00002\u0006\u0010\u000B\u001A\u00020\tH&¢\u0006\u0002\u0010\fJ\u0017\u0010\r\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\n\u001A\u00028\u0000H&¢\u0006\u0002\u0010\u000FR\u001A\u0010\u0003\u001A\u00020\u0001X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "", "(Lcom/facebook/internal/FacebookDialogBase;)V", "mode", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "(Ljava/lang/Object;Z)Z", "createAppCall", "Lcom/facebook/internal/AppCall;", "(Ljava/lang/Object;)Lcom/facebook/internal/AppCall;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public abstract class ModeHandler {
        @NotNull
        private Object mode;

        public ModeHandler() {
            this.mode = FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }

        public abstract boolean canShow(Object arg1, boolean arg2);

        @Nullable
        public abstract AppCall createAppCall(Object arg1);

        @NotNull
        public Object getMode() {
            return this.mode;
        }

        public void setMode(@NotNull Object object0) {
            q.g(object0, "<set-?>");
            this.mode = object0;
        }
    }

    @NotNull
    public static final Object BASE_AUTOMATIC_MODE = null;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "FacebookDialog";
    @Nullable
    private final Activity activity;
    @Nullable
    private CallbackManager callbackManager;
    @Nullable
    private final FragmentWrapper fragmentWrapper;
    @Nullable
    private List modeHandlers;
    private int requestCodeField;

    static {
        FacebookDialogBase.Companion = new Companion(null);
        FacebookDialogBase.BASE_AUTOMATIC_MODE = new Object();
    }

    public FacebookDialogBase(int v) {
        this.requestCodeField = v;
        this.activity = null;
        this.fragmentWrapper = null;
    }

    public FacebookDialogBase(@NotNull Activity activity0, int v) {
        q.g(activity0, "activity");
        super();
        this.activity = activity0;
        this.fragmentWrapper = null;
        this.requestCodeField = v;
        this.callbackManager = null;
    }

    public FacebookDialogBase(@NotNull FragmentWrapper fragmentWrapper0, int v) {
        q.g(fragmentWrapper0, "fragmentWrapper");
        super();
        this.fragmentWrapper = fragmentWrapper0;
        this.activity = null;
        this.requestCodeField = v;
        if(fragmentWrapper0.getActivity() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity");
        }
    }

    private final List cachedModeHandlers() {
        if(this.modeHandlers == null) {
            this.modeHandlers = this.getOrderedModeHandlers();
        }
        List list0 = this.modeHandlers;
        q.e(list0, "null cannot be cast to non-null type kotlin.collections.List<com.facebook.internal.FacebookDialogBase.ModeHandler<CONTENT of com.facebook.internal.FacebookDialogBase, RESULT of com.facebook.internal.FacebookDialogBase>>");
        return list0;
    }

    @Override  // com.facebook.FacebookDialog
    public boolean canShow(Object object0) {
        return this.canShowImpl(object0, FacebookDialogBase.BASE_AUTOMATIC_MODE);
    }

    public boolean canShowImpl(Object object0, @NotNull Object object1) {
        q.g(object1, "mode");
        boolean z = object1 == FacebookDialogBase.BASE_AUTOMATIC_MODE;
        for(Object object2: this.cachedModeHandlers()) {
            if((z || Utility.areObjectsEqual(((ModeHandler)object2).getMode(), object1)) && ((ModeHandler)object2).canShow(object0, false)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    @Override  // com.facebook.FacebookDialog
    @NotNull
    public b createActivityResultContractForShowingDialog(@Nullable CallbackManager callbackManager0) {
        return this.createActivityResultContractForShowingDialog(callbackManager0, FacebookDialogBase.BASE_AUTOMATIC_MODE);
    }

    @NotNull
    public final b createActivityResultContractForShowingDialog(@Nullable CallbackManager callbackManager0, @NotNull Object object0) {
        q.g(object0, "mode");
        return new b() {
            @Override  // f.b
            @NotNull
            public Intent createIntent(@NotNull Context context0, Object object0) {
                q.g(context0, "context");
                AppCall appCall0 = object0.createAppCallForMode(object0, callbackManager0);
                Intent intent0 = appCall0 == null ? null : appCall0.getRequestIntent();
                if(intent0 == null) {
                    throw new FacebookException("Content " + object0 + " is not supported");
                }
                appCall0.setPending();
                return intent0;
            }

            @NotNull
            public ActivityResultParameters parseResult(int v, @Nullable Intent intent0) {
                CallbackManager callbackManager0 = this.$callbackManager;
                if(callbackManager0 != null) {
                    callbackManager0.onActivityResult(object0.getRequestCode(), v, intent0);
                }
                return new ActivityResultParameters(object0.getRequestCode(), v, intent0);
            }

            @Override  // f.b
            public Object parseResult(int v, Intent intent0) {
                return this.parseResult(v, intent0);
            }
        };
    }

    private final AppCall createAppCallForMode(Object object0, Object object1) {
        AppCall appCall0 = null;
        boolean z = object1 == FacebookDialogBase.BASE_AUTOMATIC_MODE;
        for(Object object2: this.cachedModeHandlers()) {
            ModeHandler facebookDialogBase$ModeHandler0 = (ModeHandler)object2;
            if((z || Utility.areObjectsEqual(facebookDialogBase$ModeHandler0.getMode(), object1)) && facebookDialogBase$ModeHandler0.canShow(object0, true)) {
                try {
                    appCall0 = facebookDialogBase$ModeHandler0.createAppCall(object0);
                }
                catch(FacebookException facebookException0) {
                    AppCall appCall1 = this.createBaseAppCall();
                    DialogPresenter.setupAppCallForValidationError(appCall1, facebookException0);
                    appCall0 = appCall1;
                }
                break;
            }
        }
        if(appCall0 == null) {
            appCall0 = this.createBaseAppCall();
            DialogPresenter.setupAppCallForCannotShowError(appCall0);
        }
        return appCall0;
    }

    @NotNull
    public abstract AppCall createBaseAppCall();

    @Nullable
    public final Activity getActivityContext() {
        Activity activity0 = this.activity;
        if(activity0 == null) {
            return this.fragmentWrapper == null ? null : this.fragmentWrapper.getActivity();
        }
        return activity0;
    }

    @Nullable
    public final CallbackManager getCallbackManager$facebook_common_release() {
        return this.callbackManager;
    }

    @NotNull
    public abstract List getOrderedModeHandlers();

    public final int getRequestCode() {
        return this.requestCodeField;
    }

    private final void memorizeCallbackManager(CallbackManager callbackManager0) {
        CallbackManager callbackManager1 = this.callbackManager;
        if(callbackManager1 == null) {
            this.callbackManager = callbackManager0;
            return;
        }
        if(callbackManager1 != callbackManager0) {
            Log.w("FacebookDialog", "You\'re registering a callback on a Facebook dialog with two different callback managers. It\'s almost wrong and may cause unexpected results. Only the first callback manager will be used for handling activity result with androidx.");
        }
    }

    @Override  // com.facebook.FacebookDialog
    public void registerCallback(@NotNull CallbackManager callbackManager0, @NotNull FacebookCallback facebookCallback0) {
        q.g(callbackManager0, "callbackManager");
        q.g(facebookCallback0, "callback");
        if(!(callbackManager0 instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        this.memorizeCallbackManager(callbackManager0);
        this.registerCallbackImpl(((CallbackManagerImpl)callbackManager0), facebookCallback0);
    }

    @Override  // com.facebook.FacebookDialog
    public void registerCallback(@NotNull CallbackManager callbackManager0, @NotNull FacebookCallback facebookCallback0, int v) {
        q.g(callbackManager0, "callbackManager");
        q.g(facebookCallback0, "callback");
        this.memorizeCallbackManager(callbackManager0);
        this.setRequestCode(v);
        this.registerCallback(callbackManager0, facebookCallback0);
    }

    public abstract void registerCallbackImpl(@NotNull CallbackManagerImpl arg1, @NotNull FacebookCallback arg2);

    public final void setCallbackManager(@Nullable CallbackManager callbackManager0) {
        this.callbackManager = callbackManager0;
    }

    public final void setCallbackManager$facebook_common_release(@Nullable CallbackManager callbackManager0) {
        this.callbackManager = callbackManager0;
    }

    public final void setRequestCode(int v) {
        if(FacebookSdk.isFacebookRequestCode(v)) {
            throw new IllegalArgumentException(("Request code " + v + " cannot be within the range reserved by the Facebook SDK.").toString());
        }
        this.requestCodeField = v;
    }

    @Override  // com.facebook.FacebookDialog
    public void show(Object object0) {
        this.showImpl(object0, FacebookDialogBase.BASE_AUTOMATIC_MODE);
    }

    public void showImpl(Object object0, @NotNull Object object1) {
        q.g(object1, "mode");
        AppCall appCall0 = this.createAppCallForMode(object0, object1);
        if(appCall0 == null) {
            Log.e("FacebookDialog", "No code path should ever result in a null appCall");
        }
        else {
            if(this.getActivityContext() instanceof i) {
                Activity activity0 = this.getActivityContext();
                q.e(activity0, "null cannot be cast to non-null type androidx.activity.result.ActivityResultRegistryOwner");
                h h0 = ((i)activity0).getActivityResultRegistry();
                q.f(h0, "registryOwner.activityResultRegistry");
                DialogPresenter.present(appCall0, h0, this.callbackManager);
                appCall0.setPending();
                return;
            }
            FragmentWrapper fragmentWrapper0 = this.fragmentWrapper;
            if(fragmentWrapper0 != null) {
                DialogPresenter.present(appCall0, fragmentWrapper0);
                return;
            }
            Activity activity1 = this.activity;
            if(activity1 != null) {
                DialogPresenter.present(appCall0, activity1);
            }
        }
    }

    public final void startActivityForResult(@NotNull Intent intent0, int v) {
        String s;
        q.g(intent0, "intent");
        Activity activity0 = this.getActivityContext();
        if(activity0 instanceof i) {
            h h0 = ((i)activity0).getActivityResultRegistry();
            q.f(h0, "activity as ActivityResu…r).activityResultRegistry");
            DialogPresenter.startActivityForResultWithAndroidX(h0, this.callbackManager, intent0, v);
            s = null;
        }
        else if(activity0 == null) {
            FragmentWrapper fragmentWrapper0 = this.fragmentWrapper;
            if(fragmentWrapper0 == null) {
                s = "Failed to find Activity or Fragment to startActivityForResult ";
            }
            else {
                fragmentWrapper0.startActivityForResult(intent0, v);
                s = null;
            }
        }
        else {
            activity0.startActivityForResult(intent0, v);
            s = null;
        }
        if(s != null) {
            String s1 = this.getClass().getName();
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, 6, s1, s);
        }
    }
}

