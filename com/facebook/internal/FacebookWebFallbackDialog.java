package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.facebook.appevents.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B!\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001A\u00020\t2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u0016\u0010\u0010\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/facebook/internal/FacebookWebFallbackDialog;", "Lcom/facebook/internal/WebDialog;", "Landroid/content/Context;", "context", "", "url", "expectedRedirectUrl", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Bundle;", "parseResponseUri", "(Ljava/lang/String;)Landroid/os/Bundle;", "Lie/H;", "cancel", "()V", "", "waitingForDialogToClose", "Z", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FacebookWebFallbackDialog extends WebDialog {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u0006H\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001A\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/facebook/internal/FacebookWebFallbackDialog$Companion;", "", "()V", "OS_BACK_BUTTON_RESPONSE_TIMEOUT_MILLISECONDS", "", "TAG", "", "kotlin.jvm.PlatformType", "newInstance", "Lcom/facebook/internal/FacebookWebFallbackDialog;", "context", "Landroid/content/Context;", "url", "expectedRedirectUrl", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final FacebookWebFallbackDialog newInstance(@NotNull Context context0, @NotNull String s, @NotNull String s1) {
            q.g(context0, "context");
            q.g(s, "url");
            q.g(s1, "expectedRedirectUrl");
            WebDialog.initDefaultTheme(context0);
            return new FacebookWebFallbackDialog(context0, s, s1, null);
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private static final int OS_BACK_BUTTON_RESPONSE_TIMEOUT_MILLISECONDS = 1500;
    private static final String TAG;
    private boolean waitingForDialogToClose;

    static {
        FacebookWebFallbackDialog.Companion = new Companion(null);
        FacebookWebFallbackDialog.TAG = "com.facebook.internal.FacebookWebFallbackDialog";
    }

    private FacebookWebFallbackDialog(Context context0, String s, String s1) {
        super(context0, s);
        this.setExpectedRedirectUrl(s1);
    }

    public FacebookWebFallbackDialog(Context context0, String s, String s1, DefaultConstructorMarker defaultConstructorMarker0) {
        this(context0, s, s1);
    }

    @Override  // com.facebook.internal.WebDialog
    public void cancel() {
        WebView webView0 = this.getWebView();
        if(this.isPageFinished() && !this.isListenerCalled() && webView0 != null && webView0.isShown()) {
            if(this.waitingForDialogToClose) {
                return;
            }
            this.waitingForDialogToClose = true;
            webView0.loadUrl("javascript:(function() {  var event = document.createEvent(\'Event\');  event.initEvent(\'fbPlatformDialogMustClose\',true,true);  document.dispatchEvent(event);})();");
            new Handler(Looper.getMainLooper()).postDelayed(new c(this, 5), 1500L);
            return;
        }
        super.cancel();
    }

    private static final void cancel$lambda$0(FacebookWebFallbackDialog facebookWebFallbackDialog0) {
        q.g(facebookWebFallbackDialog0, "this$0");
        facebookWebFallbackDialog0.super.cancel();
    }

    public static void d(FacebookWebFallbackDialog facebookWebFallbackDialog0) {
        FacebookWebFallbackDialog.cancel$lambda$0(facebookWebFallbackDialog0);
    }

    @NotNull
    public static final FacebookWebFallbackDialog newInstance(@NotNull Context context0, @NotNull String s, @NotNull String s1) {
        return FacebookWebFallbackDialog.Companion.newInstance(context0, s, s1);
    }

    @Override  // com.facebook.internal.WebDialog
    @NotNull
    public Bundle parseResponseUri(@Nullable String s) {
        Bundle bundle0 = Utility.parseUrlQueryString(Uri.parse(s).getQuery());
        String s1 = bundle0.getString("bridge_args");
        bundle0.remove("bridge_args");
        if(!Utility.isNullOrEmpty(s1)) {
            try {
                bundle0.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", BundleJSONConverter.convertToBundle(new JSONObject(s1)));
            }
            catch(JSONException jSONException0) {
                Utility.logd("com.facebook.internal.FacebookWebFallbackDialog", "Unable to parse bridge_args JSON", jSONException0);
            }
        }
        String s2 = bundle0.getString("method_results");
        bundle0.remove("method_results");
        if(!Utility.isNullOrEmpty(s2)) {
            try {
                bundle0.putBundle("com.facebook.platform.protocol.RESULT_ARGS", BundleJSONConverter.convertToBundle(new JSONObject(s2)));
            }
            catch(JSONException jSONException1) {
                Utility.logd("com.facebook.internal.FacebookWebFallbackDialog", "Unable to parse bridge_args JSON", jSONException1);
            }
        }
        bundle0.remove("version");
        bundle0.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", NativeProtocol.getLatestKnownVersion());
        return bundle0;
    }
}

