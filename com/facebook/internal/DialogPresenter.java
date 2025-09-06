package com.facebook.internal;

import W5.e;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import com.facebook.CallbackManager;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.InternalAppEventsLogger;
import e.g;
import e.h;
import f.b;
import kotlin.Metadata;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00C6\u0002\u0018\u00002\u00020\u0001:\u0001EB\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000B\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\rH\u0007\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0012\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b\u000F\u0010\u0013J)\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0015\u001A\u00020\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016H\u0007\u00A2\u0006\u0004\b\u000F\u0010\u0018J1\u0010\u001D\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u001C\u001A\u00020\u001BH\u0007\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010\"\u001A\u00020!2\u0006\u0010 \u001A\u00020\u001FH\u0007\u00A2\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001A\u00020!2\u0006\u0010 \u001A\u00020\u001FH\u0007\u00A2\u0006\u0004\b$\u0010#J!\u0010&\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010%\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b&\u0010\fJ+\u0010+\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010(\u001A\u0004\u0018\u00010\'2\b\u0010*\u001A\u0004\u0018\u00010)H\u0007\u00A2\u0006\u0004\b+\u0010,J)\u0010-\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010*\u001A\u0004\u0018\u00010)2\u0006\u0010 \u001A\u00020\u001FH\u0007\u00A2\u0006\u0004\b-\u0010.J\'\u00101\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u00100\u001A\u00020/2\u0006\u0010 \u001A\u00020\u001FH\u0007\u00A2\u0006\u0004\b1\u00102J+\u00104\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\b\u00103\u001A\u0004\u0018\u00010\'2\b\u0010*\u001A\u0004\u0018\u00010)H\u0007\u00A2\u0006\u0004\b4\u0010,J\u0019\u00106\u001A\u0004\u0018\u0001052\u0006\u0010 \u001A\u00020\u001FH\u0002\u00A2\u0006\u0004\b6\u00107J\u0017\u00109\u001A\u0002082\u0006\u0010 \u001A\u00020\u001FH\u0007\u00A2\u0006\u0004\b9\u0010:J\'\u0010=\u001A\u00020<2\u0006\u0010;\u001A\u00020\'2\u0006\u0010(\u001A\u00020\'2\u0006\u0010 \u001A\u00020\u001FH\u0002\u00A2\u0006\u0004\b=\u0010>J\'\u0010C\u001A\u00020\u00062\u0006\u0010@\u001A\u00020?2\u0006\u0010A\u001A\u00020\'2\u0006\u0010B\u001A\u00020\'H\u0007\u00A2\u0006\u0004\bC\u0010D\u00A8\u0006F"}, d2 = {"Lcom/facebook/internal/DialogPresenter;", "", "<init>", "()V", "Lcom/facebook/internal/AppCall;", "appCall", "Lie/H;", "setupAppCallForCannotShowError", "(Lcom/facebook/internal/AppCall;)V", "Lcom/facebook/FacebookException;", "validationError", "setupAppCallForValidationError", "(Lcom/facebook/internal/AppCall;Lcom/facebook/FacebookException;)V", "Landroid/app/Activity;", "activity", "present", "(Lcom/facebook/internal/AppCall;Landroid/app/Activity;)V", "Lcom/facebook/internal/FragmentWrapper;", "fragmentWrapper", "(Lcom/facebook/internal/AppCall;Lcom/facebook/internal/FragmentWrapper;)V", "Le/h;", "registry", "Lcom/facebook/CallbackManager;", "callbackManager", "(Lcom/facebook/internal/AppCall;Le/h;Lcom/facebook/CallbackManager;)V", "Landroid/content/Intent;", "intent", "", "requestCode", "startActivityForResultWithAndroidX", "(Le/h;Lcom/facebook/CallbackManager;Landroid/content/Intent;I)V", "Lcom/facebook/internal/DialogFeature;", "feature", "", "canPresentNativeDialogWithFeature", "(Lcom/facebook/internal/DialogFeature;)Z", "canPresentWebFallbackDialogWithFeature", "exception", "setupAppCallForErrorResult", "", "actionName", "Landroid/os/Bundle;", "parameters", "setupAppCallForWebDialog", "(Lcom/facebook/internal/AppCall;Ljava/lang/String;Landroid/os/Bundle;)V", "setupAppCallForWebFallbackDialog", "(Lcom/facebook/internal/AppCall;Landroid/os/Bundle;Lcom/facebook/internal/DialogFeature;)V", "Lcom/facebook/internal/DialogPresenter$ParameterProvider;", "parameterProvider", "setupAppCallForNativeDialog", "(Lcom/facebook/internal/AppCall;Lcom/facebook/internal/DialogPresenter$ParameterProvider;Lcom/facebook/internal/DialogFeature;)V", "action", "setupAppCallForCustomTabDialog", "Landroid/net/Uri;", "getDialogWebFallbackUri", "(Lcom/facebook/internal/DialogFeature;)Landroid/net/Uri;", "Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "getProtocolVersionForNativeDialog", "(Lcom/facebook/internal/DialogFeature;)Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "applicationId", "", "getVersionSpecForFeature", "(Ljava/lang/String;Ljava/lang/String;Lcom/facebook/internal/DialogFeature;)[I", "Landroid/content/Context;", "context", "eventName", "outcome", "logDialogActivity", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "ParameterProvider", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class DialogPresenter {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001A\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001A\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/facebook/internal/DialogPresenter$ParameterProvider;", "", "legacyParameters", "Landroid/os/Bundle;", "getLegacyParameters", "()Landroid/os/Bundle;", "parameters", "getParameters", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface ParameterProvider {
        @Nullable
        Bundle getLegacyParameters();

        @Nullable
        Bundle getParameters();
    }

    @NotNull
    public static final DialogPresenter INSTANCE;

    static {
        DialogPresenter.INSTANCE = new DialogPresenter();
    }

    public static final boolean canPresentNativeDialogWithFeature(@NotNull DialogFeature dialogFeature0) {
        q.g(dialogFeature0, "feature");
        return DialogPresenter.getProtocolVersionForNativeDialog(dialogFeature0).getProtocolVersion() != -1;
    }

    public static final boolean canPresentWebFallbackDialogWithFeature(@NotNull DialogFeature dialogFeature0) {
        q.g(dialogFeature0, "feature");
        return DialogPresenter.INSTANCE.getDialogWebFallbackUri(dialogFeature0) != null;
    }

    private final Uri getDialogWebFallbackUri(DialogFeature dialogFeature0) {
        String s = dialogFeature0.getAction();
        String s1 = FacebookSdk.getApplicationId();
        DialogFeatureConfig fetchedAppSettings$DialogFeatureConfig0 = FetchedAppSettings.Companion.getDialogFeatureConfig(s1, s, dialogFeature0.name());
        return fetchedAppSettings$DialogFeatureConfig0 == null ? null : fetchedAppSettings$DialogFeatureConfig0.getFallbackUrl();
    }

    @NotNull
    public static final ProtocolVersionQueryResult getProtocolVersionForNativeDialog(@NotNull DialogFeature dialogFeature0) {
        q.g(dialogFeature0, "feature");
        String s = FacebookSdk.getApplicationId();
        String s1 = dialogFeature0.getAction();
        return NativeProtocol.getLatestAvailableProtocolVersionForAction(s1, DialogPresenter.INSTANCE.getVersionSpecForFeature(s, s1, dialogFeature0));
    }

    private final int[] getVersionSpecForFeature(String s, String s1, DialogFeature dialogFeature0) {
        DialogFeatureConfig fetchedAppSettings$DialogFeatureConfig0 = FetchedAppSettings.Companion.getDialogFeatureConfig(s, s1, dialogFeature0.name());
        if(fetchedAppSettings$DialogFeatureConfig0 != null) {
            int[] arr_v = fetchedAppSettings$DialogFeatureConfig0.getVersionSpec();
            return arr_v == null ? new int[]{dialogFeature0.getMinVersion()} : arr_v;
        }
        return new int[]{dialogFeature0.getMinVersion()};
    }

    public static final void logDialogActivity(@NotNull Context context0, @NotNull String s, @NotNull String s1) {
        q.g(context0, "context");
        q.g(s, "eventName");
        q.g(s1, "outcome");
        InternalAppEventsLogger internalAppEventsLogger0 = new InternalAppEventsLogger(context0);
        Bundle bundle0 = new Bundle();
        bundle0.putString("fb_dialog_outcome", s1);
        internalAppEventsLogger0.logEventImplicitly(s, bundle0);
    }

    public static final void present(@NotNull AppCall appCall0, @NotNull Activity activity0) {
        q.g(appCall0, "appCall");
        q.g(activity0, "activity");
        activity0.startActivityForResult(appCall0.getRequestIntent(), appCall0.getRequestCode());
        appCall0.setPending();
    }

    public static final void present(@NotNull AppCall appCall0, @NotNull FragmentWrapper fragmentWrapper0) {
        q.g(appCall0, "appCall");
        q.g(fragmentWrapper0, "fragmentWrapper");
        fragmentWrapper0.startActivityForResult(appCall0.getRequestIntent(), appCall0.getRequestCode());
        appCall0.setPending();
    }

    public static final void present(@NotNull AppCall appCall0, @NotNull h h0, @Nullable CallbackManager callbackManager0) {
        q.g(appCall0, "appCall");
        q.g(h0, "registry");
        Intent intent0 = appCall0.getRequestIntent();
        if(intent0 == null) {
            return;
        }
        DialogPresenter.startActivityForResultWithAndroidX(h0, callbackManager0, intent0, appCall0.getRequestCode());
        appCall0.setPending();
    }

    public static final void setupAppCallForCannotShowError(@NotNull AppCall appCall0) {
        q.g(appCall0, "appCall");
        DialogPresenter.setupAppCallForValidationError(appCall0, new FacebookException("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
    }

    public static final void setupAppCallForCustomTabDialog(@NotNull AppCall appCall0, @Nullable String s, @Nullable Bundle bundle0) {
        q.g(appCall0, "appCall");
        Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext(), CustomTabUtils.getDefaultRedirectURI());
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        Intent intent0 = new Intent(FacebookSdk.getApplicationContext(), CustomTabMainActivity.class);
        intent0.putExtra("CustomTabMainActivity.extra_action", s);
        intent0.putExtra("CustomTabMainActivity.extra_params", bundle0);
        intent0.putExtra("CustomTabMainActivity.extra_chromePackage", CustomTabUtils.getChromePackage());
        NativeProtocol.setupProtocolRequestIntent(intent0, appCall0.getCallId().toString(), s, NativeProtocol.getLatestKnownVersion(), null);
        appCall0.setRequestIntent(intent0);
    }

    public static final void setupAppCallForErrorResult(@NotNull AppCall appCall0, @Nullable FacebookException facebookException0) {
        q.g(appCall0, "appCall");
        if(facebookException0 == null) {
            return;
        }
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Intent intent0 = new Intent();
        intent0.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent0.setAction("PassThrough");
        NativeProtocol.setupProtocolRequestIntent(intent0, appCall0.getCallId().toString(), null, NativeProtocol.getLatestKnownVersion(), NativeProtocol.createBundleForException(facebookException0));
        appCall0.setRequestIntent(intent0);
    }

    public static final void setupAppCallForNativeDialog(@NotNull AppCall appCall0, @NotNull ParameterProvider dialogPresenter$ParameterProvider0, @NotNull DialogFeature dialogFeature0) {
        q.g(appCall0, "appCall");
        q.g(dialogPresenter$ParameterProvider0, "parameterProvider");
        q.g(dialogFeature0, "feature");
        Context context0 = FacebookSdk.getApplicationContext();
        String s = dialogFeature0.getAction();
        ProtocolVersionQueryResult nativeProtocol$ProtocolVersionQueryResult0 = DialogPresenter.getProtocolVersionForNativeDialog(dialogFeature0);
        int v = nativeProtocol$ProtocolVersionQueryResult0.getProtocolVersion();
        if(v == -1) {
            throw new FacebookException("Cannot present this dialog. This likely means that the Facebook app is not installed.");
        }
        Bundle bundle0 = NativeProtocol.isVersionCompatibleWithBucketedIntent(v) ? dialogPresenter$ParameterProvider0.getParameters() : dialogPresenter$ParameterProvider0.getLegacyParameters();
        if(bundle0 == null) {
            bundle0 = new Bundle();
        }
        Intent intent0 = NativeProtocol.createPlatformActivityIntent(context0, appCall0.getCallId().toString(), s, nativeProtocol$ProtocolVersionQueryResult0, bundle0);
        if(intent0 == null) {
            throw new FacebookException("Unable to create Intent; this likely means theFacebook app is not installed.");
        }
        appCall0.setRequestIntent(intent0);
    }

    public static final void setupAppCallForValidationError(@NotNull AppCall appCall0, @Nullable FacebookException facebookException0) {
        q.g(appCall0, "appCall");
        DialogPresenter.setupAppCallForErrorResult(appCall0, facebookException0);
    }

    public static final void setupAppCallForWebDialog(@NotNull AppCall appCall0, @Nullable String s, @Nullable Bundle bundle0) {
        q.g(appCall0, "appCall");
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        Bundle bundle1 = new Bundle();
        bundle1.putString("action", s);
        bundle1.putBundle("params", bundle0);
        Intent intent0 = new Intent();
        NativeProtocol.setupProtocolRequestIntent(intent0, appCall0.getCallId().toString(), s, NativeProtocol.getLatestKnownVersion(), bundle1);
        intent0.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent0.setAction("FacebookDialogFragment");
        appCall0.setRequestIntent(intent0);
    }

    public static final void setupAppCallForWebFallbackDialog(@NotNull AppCall appCall0, @Nullable Bundle bundle0, @NotNull DialogFeature dialogFeature0) {
        q.g(appCall0, "appCall");
        q.g(dialogFeature0, "feature");
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        String s = dialogFeature0.name();
        Uri uri0 = DialogPresenter.INSTANCE.getDialogWebFallbackUri(dialogFeature0);
        if(uri0 == null) {
            throw new FacebookException("Unable to fetch the Url for the DialogFeature : \'" + s + '\'');
        }
        int v = NativeProtocol.getLatestKnownVersion();
        String s1 = appCall0.getCallId().toString();
        q.f(s1, "appCall.callId.toString()");
        Bundle bundle1 = ServerProtocol.getQueryParamsForPlatformActivityIntentWebFallback(s1, v, bundle0);
        if(bundle1 == null) {
            throw new FacebookException("Unable to fetch the app\'s key-hash");
        }
        Uri uri1 = uri0.isRelative() ? Utility.buildUri("m.null", uri0.toString(), bundle1) : Utility.buildUri(uri0.getAuthority(), uri0.getPath(), bundle1);
        Bundle bundle2 = new Bundle();
        bundle2.putString("url", uri1.toString());
        bundle2.putBoolean("is_fallback", true);
        Intent intent0 = new Intent();
        NativeProtocol.setupProtocolRequestIntent(intent0, appCall0.getCallId().toString(), dialogFeature0.getAction(), NativeProtocol.getLatestKnownVersion(), bundle2);
        intent0.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent0.setAction("FacebookDialogFragment");
        appCall0.setRequestIntent(intent0);
    }

    public static final void startActivityForResultWithAndroidX(@NotNull h h0, @Nullable CallbackManager callbackManager0, @NotNull Intent intent0, int v) {
        q.g(h0, "registry");
        q.g(intent0, "intent");
        H h1 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
        g g0 = h0.d("facebook-dialog-request-" + v, new b() {
            @NotNull
            public Intent createIntent(@NotNull Context context0, @NotNull Intent intent0) {
                q.g(context0, "context");
                q.g(intent0, "input");
                return intent0;
            }

            @Override  // f.b
            public Intent createIntent(Context context0, Object object0) {
                return this.createIntent(context0, ((Intent)object0));
            }

            @NotNull
            public Pair parseResult(int v, @Nullable Intent intent0) {
                Pair pair0 = Pair.create(v, intent0);
                q.f(pair0, "create(resultCode, intent)");
                return pair0;
            }

            @Override  // f.b
            public Object parseResult(int v, Intent intent0) {
                return this.parseResult(v, intent0);
            }
        }, new e(callbackManager0, v, h1, 5));
        h1.a = g0;
        g0.b(intent0);
    }

    private static final void startActivityForResultWithAndroidX$lambda$2(CallbackManager callbackManager0, int v, H h0, Pair pair0) {
        q.g(h0, "$launcher");
        if(callbackManager0 == null) {
            callbackManager0 = new CallbackManagerImpl();
        }
        Object object0 = pair0.first;
        q.f(object0, "result.first");
        callbackManager0.onActivityResult(v, ((Number)object0).intValue(), ((Intent)pair0.second));
        e.b b0 = (e.b)h0.a;
        if(b0 != null) {
            synchronized(b0) {
                b0.c();
                h0.a = null;
            }
        }
    }
}

