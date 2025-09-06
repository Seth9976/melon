package com.facebook.internal;

import A6.b;
import Tf.o;
import Tf.v;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask.Status;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.AccessToken;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.common.R.drawable;
import com.facebook.common.R.string;
import com.facebook.common.R.style;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginTargetApp;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 `2\u00020\u0001:\u0006a`bcdeB\u0019\b\u0014\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007B!\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\u0006\u0010\nB?\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001A\u0004\u0018\u00010\f\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\u000F\u001A\u00020\u000E\u0012\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u00A2\u0006\u0004\b\u0006\u0010\u0012J\u001F\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0013\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u001A\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\u0019H\u0014\u00A2\u0006\u0004\b\u001C\u0010\u001BJ\u000F\u0010\u001D\u001A\u00020\u0019H\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001BJ\u000F\u0010\u001E\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001BJ\u000F\u0010\u001F\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\u001F\u0010\u001BJ\u0017\u0010\"\u001A\u00020\u00192\u0006\u0010!\u001A\u00020 H\u0016\u00A2\u0006\u0004\b\"\u0010#J\u0019\u0010%\u001A\u00020\u00192\b\u0010$\u001A\u0004\u0018\u00010\fH\u0014\u00A2\u0006\u0004\b%\u0010&J\u0017\u0010(\u001A\u00020\u00192\u0006\u0010\'\u001A\u00020\u0004H\u0004\u00A2\u0006\u0004\b(\u0010)J\u0019\u0010+\u001A\u00020\f2\b\u0010*\u001A\u0004\u0018\u00010\u0004H\u0017\u00A2\u0006\u0004\b+\u0010,J\r\u0010-\u001A\u00020\u0019\u00A2\u0006\u0004\b-\u0010\u001BJ\u0019\u0010/\u001A\u00020\u00192\b\u0010.\u001A\u0004\u0018\u00010\fH\u0004\u00A2\u0006\u0004\b/\u0010&J\u0019\u00102\u001A\u00020\u00192\b\u00101\u001A\u0004\u0018\u000100H\u0004\u00A2\u0006\u0004\b2\u00103J\u000F\u00104\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b4\u0010\u001BJ/\u0010:\u001A\u00020\b2\u0006\u00105\u001A\u00020\b2\u0006\u00107\u001A\u0002062\u0006\u00108\u001A\u00020\b2\u0006\u00109\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b:\u0010;J\u000F\u0010<\u001A\u00020\u0019H\u0002\u00A2\u0006\u0004\b<\u0010\u001BJ\u0017\u0010>\u001A\u00020\u00192\u0006\u0010=\u001A\u00020\bH\u0003\u00A2\u0006\u0004\b>\u0010?R\u0018\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0005\u0010@R\u0016\u0010\'\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\'\u0010@R$\u0010A\u001A\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bA\u0010B\u001A\u0004\bC\u0010D\"\u0004\bE\u0010FR(\u0010I\u001A\u0004\u0018\u00010G2\b\u0010H\u001A\u0004\u0018\u00010G8\u0004@BX\u0084\u000E\u00A2\u0006\f\n\u0004\bI\u0010J\u001A\u0004\bK\u0010LR\u0018\u0010N\u001A\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010Q\u001A\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010T\u001A\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bT\u0010UR\u001C\u0010W\u001A\b\u0018\u00010VR\u00020\u00008\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bW\u0010XR$\u0010Y\u001A\u00020\u00162\u0006\u0010H\u001A\u00020\u00168\u0004@BX\u0084\u000E\u00A2\u0006\f\n\u0004\bY\u0010Z\u001A\u0004\bY\u0010[R\u0016\u0010\\\u001A\u00020\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\\\u0010ZR$\u0010]\u001A\u00020\u00162\u0006\u0010H\u001A\u00020\u00168\u0004@BX\u0084\u000E\u00A2\u0006\f\n\u0004\b]\u0010Z\u001A\u0004\b]\u0010[R\u0018\u0010^\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b^\u0010_\u00A8\u0006f"}, d2 = {"Lcom/facebook/internal/WebDialog;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "", "url", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "", "theme", "(Landroid/content/Context;Ljava/lang/String;I)V", "action", "Landroid/os/Bundle;", "parameters", "Lcom/facebook/login/LoginTargetApp;", "targetApp", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "listener", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;ILcom/facebook/login/LoginTargetApp;Lcom/facebook/internal/WebDialog$OnCompleteListener;)V", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Lie/H;", "dismiss", "()V", "onStart", "onStop", "onDetachedFromWindow", "onAttachedToWindow", "Landroid/view/WindowManager$LayoutParams;", "params", "onWindowAttributesChanged", "(Landroid/view/WindowManager$LayoutParams;)V", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "expectedRedirectUrl", "setExpectedRedirectUrl", "(Ljava/lang/String;)V", "urlString", "parseResponseUri", "(Ljava/lang/String;)Landroid/os/Bundle;", "resize", "values", "sendSuccessToListener", "", "error", "sendErrorToListener", "(Ljava/lang/Throwable;)V", "cancel", "screenSize", "", "density", "noPaddingSize", "maxPaddingSize", "getScaledSize", "(IFII)I", "createCrossImage", "margin", "setUpWebView", "(I)V", "Ljava/lang/String;", "onCompleteListener", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "getOnCompleteListener", "()Lcom/facebook/internal/WebDialog$OnCompleteListener;", "setOnCompleteListener", "(Lcom/facebook/internal/WebDialog$OnCompleteListener;)V", "Landroid/webkit/WebView;", "<set-?>", "webView", "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "Landroid/app/ProgressDialog;", "spinner", "Landroid/app/ProgressDialog;", "Landroid/widget/ImageView;", "crossImageView", "Landroid/widget/ImageView;", "Landroid/widget/FrameLayout;", "contentFrameLayout", "Landroid/widget/FrameLayout;", "Lcom/facebook/internal/WebDialog$UploadStagingResourcesTask;", "uploadTask", "Lcom/facebook/internal/WebDialog$UploadStagingResourcesTask;", "isListenerCalled", "Z", "()Z", "isDetached", "isPageFinished", "windowParams", "Landroid/view/WindowManager$LayoutParams;", "Companion", "Builder", "DialogWebViewClient", "InitCallback", "OnCompleteListener", "UploadStagingResourcesTask", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class WebDialog extends Dialog {
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B#\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u00A2\u0006\u0004\b\b\u0010\tB-\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u00A2\u0006\u0004\b\b\u0010\u000BJ+\u0010\r\u001A\u00020\f2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0002\u00A2\u0006\u0004\b\r\u0010\tJ\u0015\u0010\u0010\u001A\u00020\u00002\u0006\u0010\u000F\u001A\u00020\u000E\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001A\u00020\u00002\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001A\u0004\u0018\u00010\u0016H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018R(\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0019\u001A\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000E\u00A2\u0006\f\n\u0004\b\u0003\u0010\u001A\u001A\u0004\b\u001B\u0010\u001CR(\u0010\n\u001A\u0004\u0018\u00010\u00042\b\u0010\u0019\u001A\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000E\u00A2\u0006\f\n\u0004\b\n\u0010\u001D\u001A\u0004\b\u001E\u0010\u001FR\u0018\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0005\u0010\u001DR$\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0019\u001A\u00020\u000E8\u0006@BX\u0086\u000E\u00A2\u0006\f\n\u0004\b\u000F\u0010 \u001A\u0004\b!\u0010\"R(\u0010\u0013\u001A\u0004\u0018\u00010\u00122\b\u0010\u0019\u001A\u0004\u0018\u00010\u00128\u0006@BX\u0086\u000E\u00A2\u0006\f\n\u0004\b\u0013\u0010#\u001A\u0004\b$\u0010%R(\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\u0019\u001A\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000E\u00A2\u0006\f\n\u0004\b\u0007\u0010&\u001A\u0004\b\'\u0010(R\u0018\u0010*\u001A\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b*\u0010+\u00A8\u0006,"}, d2 = {"Lcom/facebook/internal/WebDialog$Builder;", "", "Landroid/content/Context;", "context", "", "action", "Landroid/os/Bundle;", "parameters", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V", "applicationId", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "Lie/H;", "finishInit", "", "theme", "setTheme", "(I)Lcom/facebook/internal/WebDialog$Builder;", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "listener", "setOnCompleteListener", "(Lcom/facebook/internal/WebDialog$OnCompleteListener;)Lcom/facebook/internal/WebDialog$Builder;", "Lcom/facebook/internal/WebDialog;", "build", "()Lcom/facebook/internal/WebDialog;", "<set-?>", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Ljava/lang/String;", "getApplicationId", "()Ljava/lang/String;", "I", "getTheme", "()I", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "getListener", "()Lcom/facebook/internal/WebDialog$OnCompleteListener;", "Landroid/os/Bundle;", "getParameters", "()Landroid/os/Bundle;", "Lcom/facebook/AccessToken;", "accessToken", "Lcom/facebook/AccessToken;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static class Builder {
        @Nullable
        private AccessToken accessToken;
        @Nullable
        private String action;
        @Nullable
        private String applicationId;
        @Nullable
        private Context context;
        @Nullable
        private OnCompleteListener listener;
        @Nullable
        private Bundle parameters;
        private int theme;

        public Builder(@NotNull Context context0, @NotNull String s, @Nullable Bundle bundle0) {
            q.g(context0, "context");
            q.g(s, "action");
            super();
            this.accessToken = AccessToken.Companion.getCurrentAccessToken();
            if(!AccessToken.Companion.isCurrentAccessTokenActive()) {
                String s1 = Utility.getMetadataApplicationId(context0);
                if(s1 == null) {
                    throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
                }
                this.applicationId = s1;
            }
            this.finishInit(context0, s, bundle0);
        }

        public Builder(@NotNull Context context0, @Nullable String s, @NotNull String s1, @Nullable Bundle bundle0) {
            q.g(context0, "context");
            q.g(s1, "action");
            super();
            if(s == null) {
                s = Utility.getMetadataApplicationId(context0);
            }
            this.applicationId = Validate.notNullOrEmpty(s, "applicationId");
            this.finishInit(context0, s1, bundle0);
        }

        @Nullable
        public WebDialog build() {
            AccessToken accessToken0 = this.accessToken;
            if(accessToken0 == null) {
                Bundle bundle2 = this.parameters;
                if(bundle2 != null) {
                    bundle2.putString("app_id", this.applicationId);
                }
            }
            else {
                Bundle bundle0 = this.parameters;
                String s = null;
                if(bundle0 != null) {
                    bundle0.putString("app_id", (accessToken0 == null ? null : accessToken0.getApplicationId()));
                }
                Bundle bundle1 = this.parameters;
                if(bundle1 != null) {
                    AccessToken accessToken1 = this.accessToken;
                    if(accessToken1 != null) {
                        s = accessToken1.getToken();
                    }
                    bundle1.putString("access_token", s);
                }
            }
            Companion webDialog$Companion0 = WebDialog.Companion;
            Context context0 = this.context;
            if(context0 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            return webDialog$Companion0.newInstance(context0, this.action, this.parameters, this.theme, this.listener);
        }

        private final void finishInit(Context context0, String s, Bundle bundle0) {
            this.context = context0;
            this.action = s;
            if(bundle0 != null) {
                this.parameters = bundle0;
                return;
            }
            this.parameters = new Bundle();
        }

        @Nullable
        public final String getApplicationId() {
            return this.applicationId;
        }

        @Nullable
        public final Context getContext() {
            return this.context;
        }

        @Nullable
        public final OnCompleteListener getListener() {
            return this.listener;
        }

        @Nullable
        public final Bundle getParameters() {
            return this.parameters;
        }

        public final int getTheme() {
            return this.theme;
        }

        @NotNull
        public final Builder setOnCompleteListener(@Nullable OnCompleteListener webDialog$OnCompleteListener0) {
            this.listener = webDialog$OnCompleteListener0;
            return this;
        }

        @NotNull
        public final Builder setTheme(int v) {
            this.theme = v;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0005\u00A2\u0006\u0004\b\u0007\u0010\bJ=\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u000E\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0013JE\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u00142\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0016J\u000F\u0010\u0017\u001A\u00020\rH\u0007\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\rH\u0007\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0019\u0010\u001D\u001A\u00020\u00062\b\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020\r8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\r8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001A\u00020\r8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010$\u001A\u00020#8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001A\u00020\t8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b&\u0010\'R\u0014\u0010(\u001A\u00020\t8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b(\u0010\'R\u0014\u0010)\u001A\u00020\r8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b)\u0010 R\u0014\u0010*\u001A\u00020\r8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b*\u0010 R\u0014\u0010,\u001A\u00020+8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001A\u00020\r8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b.\u0010 R\u0014\u0010/\u001A\u00020\r8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b/\u0010 R\u0014\u00100\u001A\u00020\t8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b0\u0010\'R\u0018\u00101\u001A\u0004\u0018\u00010\u001B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001A\u00020\r8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b3\u0010 \u00A8\u00064"}, d2 = {"Lcom/facebook/internal/WebDialog$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lie/H;", "initDefaultTheme", "(Landroid/content/Context;)V", "", "action", "Landroid/os/Bundle;", "parameters", "", "theme", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "listener", "Lcom/facebook/internal/WebDialog;", "newInstance", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;ILcom/facebook/internal/WebDialog$OnCompleteListener;)Lcom/facebook/internal/WebDialog;", "Lcom/facebook/login/LoginTargetApp;", "targetApp", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;ILcom/facebook/login/LoginTargetApp;Lcom/facebook/internal/WebDialog$OnCompleteListener;)Lcom/facebook/internal/WebDialog;", "getWebDialogTheme", "()I", "setWebDialogTheme", "(I)V", "Lcom/facebook/internal/WebDialog$InitCallback;", "callback", "setInitCallback", "(Lcom/facebook/internal/WebDialog$InitCallback;)V", "API_EC_DIALOG_CANCEL", "I", "BACKGROUND_GRAY", "DEFAULT_THEME", "", "DISABLE_SSL_CHECK_FOR_TESTING", "Z", "DISPLAY_TOUCH", "Ljava/lang/String;", "LOG_TAG", "MAX_PADDING_SCREEN_HEIGHT", "MAX_PADDING_SCREEN_WIDTH", "", "MIN_SCALE_FACTOR", "D", "NO_PADDING_SCREEN_HEIGHT", "NO_PADDING_SCREEN_WIDTH", "PLATFORM_DIALOG_PATH_REGEX", "initCallback", "Lcom/facebook/internal/WebDialog$InitCallback;", "webDialogTheme", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final int getWebDialogTheme() {
            Validate.sdkInitialized();
            return 0;
        }

        public final void initDefaultTheme(@Nullable Context context0) {
            ApplicationInfo applicationInfo0;
            if(context0 != null) {
                try {
                    applicationInfo0 = context0.getPackageManager().getApplicationInfo("com.iloen.melon", 0x80);
                    if(applicationInfo0 == null) {
                        goto label_5;
                    }
                    else {
                        goto label_3;
                    }
                    goto label_6;
                }
                catch(PackageManager.NameNotFoundException unused_ex) {
                    return;
                }
            label_3:
                Bundle bundle0 = applicationInfo0.metaData;
                goto label_6;
            label_5:
                bundle0 = null;
            label_6:
                if(bundle0 != null) {
                    this.setWebDialogTheme(applicationInfo0.metaData.getInt("com.facebook.sdk.WebDialogTheme"));
                }
            }
        }

        @NotNull
        public final WebDialog newInstance(@NotNull Context context0, @Nullable String s, @Nullable Bundle bundle0, int v, @Nullable OnCompleteListener webDialog$OnCompleteListener0) {
            q.g(context0, "context");
            WebDialog.initDefaultTheme(context0);
            return new WebDialog(context0, s, bundle0, v, LoginTargetApp.FACEBOOK, webDialog$OnCompleteListener0, null);
        }

        @NotNull
        public final WebDialog newInstance(@NotNull Context context0, @Nullable String s, @Nullable Bundle bundle0, int v, @NotNull LoginTargetApp loginTargetApp0, @Nullable OnCompleteListener webDialog$OnCompleteListener0) {
            q.g(context0, "context");
            q.g(loginTargetApp0, "targetApp");
            WebDialog.initDefaultTheme(context0);
            return new WebDialog(context0, s, bundle0, v, loginTargetApp0, webDialog$OnCompleteListener0, null);
        }

        public final void setInitCallback(@Nullable InitCallback webDialog$InitCallback0) {
            WebDialog.initCallback = webDialog$InitCallback0;
        }

        public final void setWebDialogTheme(int v) {
            if(v == 0) {
                v = 0x7F1404F5;  // style:com_facebook_activity_theme
            }
            WebDialog.webDialogTheme = v;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\'\u0010\u0016\u001A\u00020\u000F2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001A\u001A\u00020\u000F2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u001F\u0010\u001C\u001A\u00020\u000F2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u001C\u0010\u001D¨\u0006\u001E"}, d2 = {"Lcom/facebook/internal/WebDialog$DialogWebViewClient;", "Landroid/webkit/WebViewClient;", "<init>", "(Lcom/facebook/internal/WebDialog;)V", "Landroid/webkit/WebView;", "view", "", "url", "", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "", "errorCode", "description", "failingUrl", "Lie/H;", "onReceivedError", "(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V", "Landroid/webkit/SslErrorHandler;", "handler", "Landroid/net/http/SslError;", "error", "onReceivedSslError", "(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V", "Landroid/graphics/Bitmap;", "favicon", "onPageStarted", "(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "onPageFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class DialogWebViewClient extends WebViewClient {
        @Override  // android.webkit.WebViewClient
        public void onPageFinished(@NotNull WebView webView0, @NotNull String s) {
            q.g(webView0, "view");
            q.g(s, "url");
            super.onPageFinished(webView0, s);
            if(!WebDialog.this.isDetached) {
                ProgressDialog progressDialog0 = WebDialog.this.spinner;
                if(progressDialog0 != null) {
                    progressDialog0.dismiss();
                }
            }
            FrameLayout frameLayout0 = WebDialog.this.contentFrameLayout;
            if(frameLayout0 != null) {
                frameLayout0.setBackgroundColor(0);
            }
            WebView webView1 = WebDialog.this.getWebView();
            if(webView1 != null) {
                webView1.setVisibility(0);
            }
            ImageView imageView0 = WebDialog.this.crossImageView;
            if(imageView0 != null) {
                imageView0.setVisibility(0);
            }
            WebDialog.this.isPageFinished = true;
        }

        @Override  // android.webkit.WebViewClient
        public void onPageStarted(@NotNull WebView webView0, @NotNull String s, @Nullable Bitmap bitmap0) {
            q.g(webView0, "view");
            q.g(s, "url");
            Utility.logd("FacebookSDK.WebDialog", "Webview loading URL: " + s);
            super.onPageStarted(webView0, s, bitmap0);
            if(!WebDialog.this.isDetached) {
                ProgressDialog progressDialog0 = WebDialog.this.spinner;
                if(progressDialog0 != null) {
                    progressDialog0.show();
                }
            }
        }

        @Override  // android.webkit.WebViewClient
        public void onReceivedError(@NotNull WebView webView0, int v, @NotNull String s, @NotNull String s1) {
            q.g(webView0, "view");
            q.g(s, "description");
            q.g(s1, "failingUrl");
            super.onReceivedError(webView0, v, s, s1);
            FacebookDialogException facebookDialogException0 = new FacebookDialogException(s, v, s1);
            WebDialog.this.sendErrorToListener(facebookDialogException0);
        }

        @Override  // android.webkit.WebViewClient
        public void onReceivedSslError(@NotNull WebView webView0, @NotNull SslErrorHandler sslErrorHandler0, @NotNull SslError sslError0) {
            q.g(webView0, "view");
            q.g(sslErrorHandler0, "handler");
            q.g(sslError0, "error");
            super.onReceivedSslError(webView0, sslErrorHandler0, sslError0);
            sslErrorHandler0.cancel();
            FacebookDialogException facebookDialogException0 = new FacebookDialogException(null, -11, null);
            WebDialog.this.sendErrorToListener(facebookDialogException0);
        }

        @Override  // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@NotNull WebView webView0, @NotNull String s) {
            q.g(webView0, "view");
            q.g(s, "url");
            Utility.logd("FacebookSDK.WebDialog", "Redirect URL: " + s);
            Uri uri0 = Uri.parse(s);
            boolean z = uri0.getPath() != null && Pattern.matches("^/(v\\d+\\.\\d+/)??dialog/.*", uri0.getPath());
            if(v.r0(s, WebDialog.this.expectedRedirectUrl, false)) {
                Bundle bundle0 = WebDialog.this.parseResponseUri(s);
                String s1 = bundle0.getString("error");
                if(s1 == null) {
                    s1 = bundle0.getString("error_type");
                }
                String s2 = bundle0.getString("error_msg");
                if(s2 == null) {
                    s2 = bundle0.getString("error_message");
                }
                if(s2 == null) {
                    s2 = bundle0.getString("error_description");
                }
                String s3 = bundle0.getString("error_code");
                int v = -1;
                if(s3 != null && !Utility.isNullOrEmpty(s3)) {
                    try {
                        v = Integer.parseInt(s3);
                    }
                    catch(NumberFormatException unused_ex) {
                    }
                }
                if(Utility.isNullOrEmpty(s1) && Utility.isNullOrEmpty(s2) && v == -1) {
                    WebDialog.this.sendSuccessToListener(bundle0);
                    return true;
                }
                if(s1 != null && (s1.equals("access_denied") || s1.equals("OAuthAccessDeniedException"))) {
                    WebDialog.this.cancel();
                    return true;
                }
                if(v == 4201) {
                    WebDialog.this.cancel();
                    return true;
                }
                FacebookServiceException facebookServiceException0 = new FacebookServiceException(new FacebookRequestError(v, s1, s2), s2);
                WebDialog.this.sendErrorToListener(facebookServiceException0);
                return true;
            }
            if(v.r0(s, "fbconnect://cancel", false)) {
                WebDialog.this.cancel();
                return true;
            }
            if(!z && !o.v0(s, "touch", false)) {
                try {
                    WebDialog.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
                    return true;
                }
                catch(ActivityNotFoundException unused_ex) {
                }
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/WebDialog$InitCallback;", "", "Landroid/webkit/WebView;", "webView", "Lie/H;", "onInit", "(Landroid/webkit/WebView;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface InitCallback {
        void onInit(@Nullable WebView arg1);
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J#\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/facebook/internal/WebDialog$OnCompleteListener;", "", "Landroid/os/Bundle;", "values", "Lcom/facebook/FacebookException;", "error", "Lie/H;", "onComplete", "(Landroid/os/Bundle;Lcom/facebook/FacebookException;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface OnCompleteListener {
        void onComplete(@Nullable Bundle arg1, @Nullable FacebookException arg2);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u001E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u000E\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000B\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\u0010\n\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0003\"\u00020\u0002H\u0014¢\u0006\u0004\b\u000B\u0010\fJ!\u0010\u000F\u001A\u00020\u000E2\u0010\u0010\r\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R$\u0010\u0015\u001A\u0010\u0012\f\u0012\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00140\u00038\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/facebook/internal/WebDialog$UploadStagingResourcesTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "", "action", "Landroid/os/Bundle;", "parameters", "<init>", "(Lcom/facebook/internal/WebDialog;Ljava/lang/String;Landroid/os/Bundle;)V", "p0", "doInBackground", "([Ljava/lang/Void;)[Ljava/lang/String;", "results", "Lie/H;", "onPostExecute", "([Ljava/lang/String;)V", "Ljava/lang/String;", "Landroid/os/Bundle;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exceptions", "[Ljava/lang/Exception;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class UploadStagingResourcesTask extends AsyncTask {
        @NotNull
        private final String action;
        @NotNull
        private Exception[] exceptions;
        @NotNull
        private final Bundle parameters;

        public UploadStagingResourcesTask(@NotNull String s, @NotNull Bundle bundle0) {
            q.g(s, "action");
            q.g(bundle0, "parameters");
            WebDialog.this = webDialog0;
            super();
            this.action = s;
            this.parameters = bundle0;
            this.exceptions = new Exception[0];
        }

        @Override  // android.os.AsyncTask
        public Object doInBackground(Object[] arr_object) {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                return this.doInBackground(((Void[])arr_object));
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
                return null;
            }
        }

        @Nullable
        public String[] doInBackground(@NotNull Void[] arr_void) {
            if(!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    q.g(arr_void, "p0");
                    String[] arr_s = this.parameters.getStringArray("media");
                    if(arr_s != null) {
                        String[] arr_s1 = new String[arr_s.length];
                        this.exceptions = new Exception[arr_s.length];
                        CountDownLatch countDownLatch0 = new CountDownLatch(arr_s.length);
                        ConcurrentLinkedQueue concurrentLinkedQueue0 = new ConcurrentLinkedQueue();
                        AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
                        try {
                            for(int v = 0; true; ++v) {
                                if(v >= arr_s.length) {
                                    countDownLatch0.await();
                                    return arr_s1;
                                }
                                if(this.isCancelled()) {
                                    break;
                                }
                                Uri uri0 = Uri.parse(arr_s[v]);
                                if(Utility.isWebUri(uri0)) {
                                    arr_s1[v] = uri0.toString();
                                    countDownLatch0.countDown();
                                }
                                else {
                                    g g0 = new g(arr_s1, v, this, countDownLatch0);
                                    q.f(uri0, "uri");
                                    concurrentLinkedQueue0.add(ShareInternalUtility.newUploadStagingResourceWithImageRequest(accessToken0, uri0, g0).executeAsync());
                                }
                            }
                            for(Object object0: concurrentLinkedQueue0) {
                                ((GraphRequestAsyncTask)object0).cancel(true);
                            }
                            while(true) {
                                return null;
                            }
                        }
                        catch(Exception unused_ex) {
                            goto label_32;
                        }
                    }
                    return null;
                label_32:
                    for(Object object1: concurrentLinkedQueue0) {
                        ((GraphRequestAsyncTask)object1).cancel(true);
                    }
                }
                catch(Throwable throwable0) {
                    CrashShieldHandler.handleThrowable(throwable0, this);
                    return null;
                }
            }
            return null;
        }

        private static final void doInBackground$lambda$0(String[] arr_s, int v, UploadStagingResourcesTask webDialog$UploadStagingResourcesTask0, CountDownLatch countDownLatch0, GraphResponse graphResponse0) {
            q.g(arr_s, "$results");
            q.g(webDialog$UploadStagingResourcesTask0, "this$0");
            q.g(countDownLatch0, "$latch");
            q.g(graphResponse0, "response");
            try {
                String s = "Error staging photo.";
                FacebookRequestError facebookRequestError0 = graphResponse0.getError();
                if(facebookRequestError0 != null) {
                    String s1 = facebookRequestError0.getErrorMessage();
                    if(s1 != null) {
                        s = s1;
                    }
                    throw new FacebookGraphResponseException(graphResponse0, s);
                }
                JSONObject jSONObject0 = graphResponse0.getJSONObject();
                if(jSONObject0 == null) {
                    throw new FacebookException("Error staging photo.");
                }
                String s2 = jSONObject0.optString("uri");
                if(s2 == null) {
                    throw new FacebookException("Error staging photo.");
                }
                arr_s[v] = s2;
            }
            catch(Exception exception0) {
                webDialog$UploadStagingResourcesTask0.exceptions[v] = exception0;
            }
            countDownLatch0.countDown();
        }

        @Override  // android.os.AsyncTask
        public void onPostExecute(Object object0) {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                this.onPostExecute(((String[])object0));
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }

        public void onPostExecute(@Nullable String[] arr_s) {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                ProgressDialog progressDialog0 = WebDialog.this.spinner;
                if(progressDialog0 != null) {
                    progressDialog0.dismiss();
                }
                Exception[] arr_exception = this.exceptions;
                for(int v = 0; v < arr_exception.length; ++v) {
                    Exception exception0 = arr_exception[v];
                    if(exception0 != null) {
                        WebDialog.this.sendErrorToListener(exception0);
                        return;
                    }
                }
                if(arr_s == null) {
                    FacebookException facebookException0 = new FacebookException("Failed to stage photos for web dialog");
                    WebDialog.this.sendErrorToListener(facebookException0);
                    return;
                }
                List list0 = n.N(arr_s);
                if(list0.contains(null)) {
                    FacebookException facebookException1 = new FacebookException("Failed to stage photos for web dialog");
                    WebDialog.this.sendErrorToListener(facebookException1);
                    return;
                }
                JSONArray jSONArray0 = new JSONArray(list0);
                Utility.putJSONValueInBundle(this.parameters, "media", jSONArray0);
                String s = Utility.buildUri("m.null", FacebookSdk.getGraphApiVersion() + "/dialog/" + this.action, this.parameters).toString();
                WebDialog.this.url = s;
                ImageView imageView0 = WebDialog.this.crossImageView;
                if(imageView0 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                int v1 = imageView0.getDrawable().getIntrinsicWidth();
                WebDialog.this.setUpWebView(v1 / 2 + 1);
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[LoginTargetApp.values().length];
            try {
                arr_v[LoginTargetApp.INSTAGRAM.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    private static final int API_EC_DIALOG_CANCEL = 4201;
    private static final int BACKGROUND_GRAY = 0xCC000000;
    @NotNull
    public static final Companion Companion = null;
    private static final int DEFAULT_THEME = 0;
    public static final boolean DISABLE_SSL_CHECK_FOR_TESTING = false;
    @NotNull
    private static final String DISPLAY_TOUCH = "touch";
    @NotNull
    private static final String LOG_TAG = "FacebookSDK.WebDialog";
    private static final int MAX_PADDING_SCREEN_HEIGHT = 0x500;
    private static final int MAX_PADDING_SCREEN_WIDTH = 800;
    private static final double MIN_SCALE_FACTOR = 0.5;
    private static final int NO_PADDING_SCREEN_HEIGHT = 800;
    private static final int NO_PADDING_SCREEN_WIDTH = 480;
    @NotNull
    private static final String PLATFORM_DIALOG_PATH_REGEX = "^/(v\\d+\\.\\d+/)??dialog/.*";
    @Nullable
    private FrameLayout contentFrameLayout;
    @Nullable
    private ImageView crossImageView;
    @NotNull
    private String expectedRedirectUrl;
    @Nullable
    private static InitCallback initCallback;
    private boolean isDetached;
    private boolean isListenerCalled;
    private boolean isPageFinished;
    @Nullable
    private OnCompleteListener onCompleteListener;
    @Nullable
    private ProgressDialog spinner;
    @Nullable
    private UploadStagingResourcesTask uploadTask;
    @Nullable
    private String url;
    private static volatile int webDialogTheme;
    @Nullable
    private WebView webView;
    @Nullable
    private WindowManager.LayoutParams windowParams;

    static {
        WebDialog.Companion = new Companion(null);
        WebDialog.DEFAULT_THEME = style.com_facebook_activity_theme;
    }

    public WebDialog(@NotNull Context context0, @NotNull String s) {
        q.g(context0, "context");
        q.g(s, "url");
        this(context0, s, WebDialog.Companion.getWebDialogTheme());
    }

    private WebDialog(Context context0, String s, int v) {
        if(v == 0) {
            v = WebDialog.Companion.getWebDialogTheme();
        }
        super(context0, v);
        this.expectedRedirectUrl = "fbconnect://success";
        this.url = s;
    }

    private WebDialog(Context context0, String s, Bundle bundle0, int v, LoginTargetApp loginTargetApp0, OnCompleteListener webDialog$OnCompleteListener0) {
        if(v == 0) {
            v = WebDialog.Companion.getWebDialogTheme();
        }
        super(context0, v);
        String s1 = "fbconnect://success";
        this.expectedRedirectUrl = "fbconnect://success";
        if(bundle0 == null) {
            bundle0 = new Bundle();
        }
        if(Utility.isChromeOS(context0)) {
            s1 = "fbconnect://chrome_os_success";
        }
        this.expectedRedirectUrl = s1;
        bundle0.putString("redirect_uri", s1);
        bundle0.putString("display", "touch");
        bundle0.putString("client_id", FacebookSdk.getApplicationId());
        bundle0.putString("sdk", "android-18.1.3");
        this.onCompleteListener = webDialog$OnCompleteListener0;
        if(q.b(s, "share") && bundle0.containsKey("media")) {
            this.uploadTask = new UploadStagingResourcesTask(this, s, bundle0);
            return;
        }
        this.url = (WhenMappings.$EnumSwitchMapping$0[loginTargetApp0.ordinal()] == 1 ? Utility.buildUri("m.null", "oauth/authorize", bundle0) : Utility.buildUri("m.null", FacebookSdk.getGraphApiVersion() + "/dialog/" + s, bundle0)).toString();
    }

    public WebDialog(Context context0, String s, Bundle bundle0, int v, LoginTargetApp loginTargetApp0, OnCompleteListener webDialog$OnCompleteListener0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(context0, s, bundle0, v, loginTargetApp0, webDialog$OnCompleteListener0);
    }

    public static final int access$getDEFAULT_THEME$cp() [...] // 潜在的解密器

    public static final int access$getWebDialogTheme$cp() [...] // 潜在的解密器

    @Override  // android.app.Dialog
    public void cancel() {
        if(this.onCompleteListener != null && !this.isListenerCalled) {
            this.sendErrorToListener(new FacebookOperationCanceledException());
        }
    }

    private final void createCrossImage() {
        ImageView imageView0 = new ImageView(this.getContext());
        this.crossImageView = imageView0;
        imageView0.setOnClickListener(new b(this, 19));
        Drawable drawable0 = this.getContext().getResources().getDrawable(drawable.com_facebook_close);
        ImageView imageView1 = this.crossImageView;
        if(imageView1 != null) {
            imageView1.setImageDrawable(drawable0);
        }
        ImageView imageView2 = this.crossImageView;
        if(imageView2 == null) {
            return;
        }
        imageView2.setVisibility(4);
    }

    private static final void createCrossImage$lambda$5(WebDialog webDialog0, View view0) {
        q.g(webDialog0, "this$0");
        webDialog0.cancel();
    }

    @Override  // android.app.Dialog
    public void dismiss() {
        WebView webView0 = this.webView;
        if(webView0 != null) {
            webView0.stopLoading();
        }
        if(!this.isDetached) {
            ProgressDialog progressDialog0 = this.spinner;
            if(progressDialog0 != null && progressDialog0.isShowing()) {
                progressDialog0.dismiss();
            }
        }
        super.dismiss();
    }

    @Nullable
    public final OnCompleteListener getOnCompleteListener() {
        return this.onCompleteListener;
    }

    private final int getScaledSize(int v, float f, int v1, int v2) {
        int v3 = (int)(((float)v) / f);
        if(v3 <= v1) {
            return (int)(((double)v) * 1.0);
        }
        return v3 < v2 ? ((int)(((double)v) * (((double)(v2 - v3)) / ((double)(v2 - v1)) * 0.5 + 0.5))) : ((int)(((double)v) * 0.5));
    }

    public static final int getWebDialogTheme() {
        return WebDialog.Companion.getWebDialogTheme();
    }

    @Nullable
    public final WebView getWebView() {
        return this.webView;
    }

    public static final void initDefaultTheme(@Nullable Context context0) {
        WebDialog.Companion.initDefaultTheme(context0);
    }

    public final boolean isListenerCalled() {
        return this.isListenerCalled;
    }

    public final boolean isPageFinished() {
        return this.isPageFinished;
    }

    @NotNull
    public static final WebDialog newInstance(@NotNull Context context0, @Nullable String s, @Nullable Bundle bundle0, int v, @Nullable OnCompleteListener webDialog$OnCompleteListener0) {
        return WebDialog.Companion.newInstance(context0, s, bundle0, v, webDialog$OnCompleteListener0);
    }

    @NotNull
    public static final WebDialog newInstance(@NotNull Context context0, @Nullable String s, @Nullable Bundle bundle0, int v, @NotNull LoginTargetApp loginTargetApp0, @Nullable OnCompleteListener webDialog$OnCompleteListener0) {
        return WebDialog.Companion.newInstance(context0, s, bundle0, v, loginTargetApp0, webDialog$OnCompleteListener0);
    }

    @Override  // android.app.Dialog
    public void onAttachedToWindow() {
        IBinder iBinder1;
        this.isDetached = false;
        Context context0 = this.getContext();
        q.f(context0, "context");
        if(Utility.mustFixWindowParamsForAutofill(context0)) {
            IBinder iBinder0 = null;
            WindowManager.LayoutParams windowManager$LayoutParams0 = this.windowParams;
            if(windowManager$LayoutParams0 != null && windowManager$LayoutParams0.token == null) {
                if(windowManager$LayoutParams0 != null) {
                    Activity activity0 = this.getOwnerActivity();
                    if(activity0 == null) {
                        iBinder1 = null;
                    }
                    else {
                        Window window0 = activity0.getWindow();
                        if(window0 == null) {
                            iBinder1 = null;
                        }
                        else {
                            WindowManager.LayoutParams windowManager$LayoutParams1 = window0.getAttributes();
                            iBinder1 = windowManager$LayoutParams1 == null ? null : windowManager$LayoutParams1.token;
                        }
                    }
                    windowManager$LayoutParams0.token = iBinder1;
                }
                StringBuilder stringBuilder0 = new StringBuilder("Set token on onAttachedToWindow(): ");
                WindowManager.LayoutParams windowManager$LayoutParams2 = this.windowParams;
                if(windowManager$LayoutParams2 != null) {
                    iBinder0 = windowManager$LayoutParams2.token;
                }
                stringBuilder0.append(iBinder0);
                Utility.logd("FacebookSDK.WebDialog", stringBuilder0.toString());
            }
        }
        super.onAttachedToWindow();
    }

    @Override  // android.app.Dialog
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        ProgressDialog progressDialog0 = new ProgressDialog(this.getContext());
        this.spinner = progressDialog0;
        progressDialog0.requestWindowFeature(1);
        ProgressDialog progressDialog1 = this.spinner;
        if(progressDialog1 != null) {
            progressDialog1.setMessage(this.getContext().getString(string.com_facebook_loading));
        }
        ProgressDialog progressDialog2 = this.spinner;
        if(progressDialog2 != null) {
            progressDialog2.setCanceledOnTouchOutside(false);
        }
        ProgressDialog progressDialog3 = this.spinner;
        if(progressDialog3 != null) {
            progressDialog3.setOnCancelListener(new U9.b(this, 1));
        }
        this.requestWindowFeature(1);
        this.contentFrameLayout = new FrameLayout(this.getContext());
        this.resize();
        Window window0 = this.getWindow();
        if(window0 != null) {
            window0.setGravity(17);
        }
        Window window1 = this.getWindow();
        if(window1 != null) {
            window1.setSoftInputMode(16);
        }
        this.createCrossImage();
        if(this.url != null) {
            ImageView imageView0 = this.crossImageView;
            if(imageView0 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            this.setUpWebView(imageView0.getDrawable().getIntrinsicWidth() / 2 + 1);
        }
        FrameLayout frameLayout0 = this.contentFrameLayout;
        if(frameLayout0 != null) {
            frameLayout0.addView(this.crossImageView, new ViewGroup.LayoutParams(-2, -2));
        }
        FrameLayout frameLayout1 = this.contentFrameLayout;
        if(frameLayout1 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.setContentView(frameLayout1);
    }

    private static final void onCreate$lambda$4(WebDialog webDialog0, DialogInterface dialogInterface0) {
        q.g(webDialog0, "this$0");
        webDialog0.cancel();
    }

    @Override  // android.app.Dialog
    public void onDetachedFromWindow() {
        this.isDetached = true;
        super.onDetachedFromWindow();
    }

    @Override  // android.app.Dialog
    public boolean onKeyDown(int v, @NotNull KeyEvent keyEvent0) {
        q.g(keyEvent0, "event");
        if(v == 4) {
            if(this.webView != null && this.webView.canGoBack()) {
                WebView webView0 = this.webView;
                if(webView0 != null) {
                    webView0.goBack();
                }
                return true;
            }
            this.cancel();
        }
        return super.onKeyDown(v, keyEvent0);
    }

    @Override  // android.app.Dialog
    public void onStart() {
        super.onStart();
        if(this.uploadTask != null && this.uploadTask.getStatus() == AsyncTask.Status.PENDING) {
            UploadStagingResourcesTask webDialog$UploadStagingResourcesTask0 = this.uploadTask;
            if(webDialog$UploadStagingResourcesTask0 != null) {
                webDialog$UploadStagingResourcesTask0.execute(new Void[0]);
            }
            ProgressDialog progressDialog0 = this.spinner;
            if(progressDialog0 != null) {
                progressDialog0.show();
            }
            return;
        }
        this.resize();
    }

    @Override  // android.app.Dialog
    public void onStop() {
        UploadStagingResourcesTask webDialog$UploadStagingResourcesTask0 = this.uploadTask;
        if(webDialog$UploadStagingResourcesTask0 != null) {
            webDialog$UploadStagingResourcesTask0.cancel(true);
            ProgressDialog progressDialog0 = this.spinner;
            if(progressDialog0 != null) {
                progressDialog0.dismiss();
            }
        }
        super.onStop();
    }

    @Override  // android.app.Dialog
    public void onWindowAttributesChanged(@NotNull WindowManager.LayoutParams windowManager$LayoutParams0) {
        q.g(windowManager$LayoutParams0, "params");
        if(windowManager$LayoutParams0.token == null) {
            this.windowParams = windowManager$LayoutParams0;
        }
        super.onWindowAttributesChanged(windowManager$LayoutParams0);
    }

    @NotNull
    public Bundle parseResponseUri(@Nullable String s) {
        Uri uri0 = Uri.parse(s);
        Bundle bundle0 = Utility.parseUrlQueryString(uri0.getQuery());
        bundle0.putAll(Utility.parseUrlQueryString(uri0.getFragment()));
        return bundle0;
    }

    public final void resize() {
        Object object0 = this.getContext().getSystemService("window");
        q.e(object0, "null cannot be cast to non-null type android.view.WindowManager");
        Display display0 = ((WindowManager)object0).getDefaultDisplay();
        DisplayMetrics displayMetrics0 = new DisplayMetrics();
        display0.getMetrics(displayMetrics0);
        int v = displayMetrics0.widthPixels;
        int v1 = displayMetrics0.heightPixels;
        int v2 = v >= v1 ? v1 : v;
        if(v < v1) {
            v = v1;
        }
        int v3 = Math.min(this.getScaledSize(v2, displayMetrics0.density, 480, 800), displayMetrics0.widthPixels);
        int v4 = Math.min(this.getScaledSize(v, displayMetrics0.density, 800, 0x500), displayMetrics0.heightPixels);
        Window window0 = this.getWindow();
        if(window0 != null) {
            window0.setLayout(v3, v4);
        }
    }

    public final void sendErrorToListener(@Nullable Throwable throwable0) {
        if(this.onCompleteListener != null && !this.isListenerCalled) {
            this.isListenerCalled = true;
            FacebookException facebookException0 = throwable0 instanceof FacebookException ? ((FacebookException)throwable0) : new FacebookException(throwable0);
            OnCompleteListener webDialog$OnCompleteListener0 = this.onCompleteListener;
            if(webDialog$OnCompleteListener0 != null) {
                webDialog$OnCompleteListener0.onComplete(null, facebookException0);
            }
            this.dismiss();
        }
    }

    public final void sendSuccessToListener(@Nullable Bundle bundle0) {
        OnCompleteListener webDialog$OnCompleteListener0 = this.onCompleteListener;
        if(webDialog$OnCompleteListener0 != null && !this.isListenerCalled) {
            this.isListenerCalled = true;
            webDialog$OnCompleteListener0.onComplete(bundle0, null);
            this.dismiss();
        }
    }

    public final void setExpectedRedirectUrl(@NotNull String s) {
        q.g(s, "expectedRedirectUrl");
        this.expectedRedirectUrl = s;
    }

    public static final void setInitCallback(@Nullable InitCallback webDialog$InitCallback0) {
        WebDialog.Companion.setInitCallback(webDialog$InitCallback0);
    }

    public final void setOnCompleteListener(@Nullable OnCompleteListener webDialog$OnCompleteListener0) {
        this.onCompleteListener = webDialog$OnCompleteListener0;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final void setUpWebView(int v) {
        LinearLayout linearLayout0 = new LinearLayout(this.getContext());
        com.facebook.internal.WebDialog.setUpWebView.1 webDialog$setUpWebView$10 = new WebView(/*ERROR_MISSING_ARG_0/*) {
            @Override  // android.webkit.WebView
            public void onWindowFocusChanged(boolean z) {
                try {
                    super.onWindowFocusChanged(z);
                }
                catch(NullPointerException unused_ex) {
                }
            }
        };
        this.webView = webDialog$setUpWebView$10;
        InitCallback webDialog$InitCallback0 = WebDialog.initCallback;
        if(webDialog$InitCallback0 != null) {
            webDialog$InitCallback0.onInit(webDialog$setUpWebView$10);
        }
        WebView webView0 = this.webView;
        if(webView0 != null) {
            webView0.setVerticalScrollBarEnabled(false);
        }
        WebView webView1 = this.webView;
        if(webView1 != null) {
            webView1.setHorizontalScrollBarEnabled(false);
        }
        WebView webView2 = this.webView;
        if(webView2 != null) {
            webView2.setWebViewClient(new DialogWebViewClient(this));
        }
        WebSettings webSettings0 = null;
        WebSettings webSettings1 = this.webView == null ? null : this.webView.getSettings();
        if(webSettings1 != null) {
            webSettings1.setJavaScriptEnabled(true);
        }
        WebView webView3 = this.webView;
        if(webView3 != null) {
            String s = this.url;
            if(s == null) {
                throw new IllegalStateException("Required value was null.");
            }
            webView3.loadUrl(s);
        }
        WebView webView4 = this.webView;
        if(webView4 != null) {
            webView4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        WebView webView5 = this.webView;
        if(webView5 != null) {
            webView5.setVisibility(4);
        }
        WebSettings webSettings2 = this.webView == null ? null : this.webView.getSettings();
        if(webSettings2 != null) {
            webSettings2.setSavePassword(false);
        }
        WebView webView6 = this.webView;
        if(webView6 != null) {
            webSettings0 = webView6.getSettings();
        }
        if(webSettings0 != null) {
            webSettings0.setSaveFormData(false);
        }
        WebView webView7 = this.webView;
        if(webView7 != null) {
            webView7.setFocusable(true);
        }
        WebView webView8 = this.webView;
        if(webView8 != null) {
            webView8.setFocusableInTouchMode(true);
        }
        WebView webView9 = this.webView;
        if(webView9 != null) {
            webView9.setOnTouchListener(new f());  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        linearLayout0.setPadding(v, v, v, v);
        linearLayout0.addView(this.webView);
        linearLayout0.setBackgroundColor(0xCC000000);
        FrameLayout frameLayout0 = this.contentFrameLayout;
        if(frameLayout0 != null) {
            frameLayout0.addView(linearLayout0);
        }
    }

    private static final boolean setUpWebView$lambda$7(View view0, MotionEvent motionEvent0) {
        if(!view0.hasFocus()) {
            view0.requestFocus();
        }
        return false;
    }

    public static final void setWebDialogTheme(int v) {
        WebDialog.Companion.setWebDialogTheme(v);
    }
}

