package com.kakaoent.trevi.ad.webview.webkit;

import U9.a;
import U9.b;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AlertDialog.Builder;
import com.kakaoent.trevi.ad.R.string;
import com.kakaoent.trevi.ad.webview.helper.ClientCertRequestDialog;
import com.kakaoent.trevi.ad.webview.helper.SslErrorDialog;
import com.kakaoent.trevi.ad.webview.helper.UriSchemeProcessor;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00BC\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001iB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001A\u00020\u0006\u00A2\u0006\u0004\b\t\u0010\u0003J\u0015\u0010\f\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\n\u00A2\u0006\u0004\b\f\u0010\rJ!\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015H\u0017\u00A2\u0006\u0004\b\u0013\u0010\u0017J-\u0010\u001A\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ#\u0010\u001C\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ#\u0010\u001E\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001DJ#\u0010\u001F\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\b\u001F\u0010\u001DJ%\u0010!\u001A\u0004\u0018\u00010 2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\b!\u0010\"J%\u0010!\u001A\u0004\u0018\u00010 2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015H\u0017\u00A2\u0006\u0004\b!\u0010#J-\u0010\'\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010%\u001A\u0004\u0018\u00010$2\b\u0010&\u001A\u0004\u0018\u00010$H\u0016\u00A2\u0006\u0004\b\'\u0010(J5\u0010-\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0006\u0010*\u001A\u00020)2\b\u0010+\u001A\u0004\u0018\u00010\u00102\b\u0010,\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\b-\u0010.J)\u0010-\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u00100\u001A\u00020/H\u0017\u00A2\u0006\u0004\b-\u00101J+\u00103\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u0016\u001A\u00020\u00152\b\u00102\u001A\u0004\u0018\u00010 H\u0017\u00A2\u0006\u0004\b3\u00104J-\u00107\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u00105\u001A\u0004\u0018\u00010$2\b\u00106\u001A\u0004\u0018\u00010$H\u0016\u00A2\u0006\u0004\b7\u0010(J+\u00109\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0006\u00108\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b9\u0010:J-\u0010>\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010<\u001A\u0004\u0018\u00010;2\b\u00100\u001A\u0004\u0018\u00010=H\u0016\u00A2\u0006\u0004\b>\u0010?J#\u0010A\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0016\u001A\u0004\u0018\u00010@H\u0016\u00A2\u0006\u0004\bA\u0010BJ7\u0010F\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010<\u001A\u0004\u0018\u00010C2\b\u0010D\u001A\u0004\u0018\u00010\u00102\b\u0010E\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\bF\u0010GJ#\u0010J\u001A\u00020\u00122\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010I\u001A\u0004\u0018\u00010HH\u0016\u00A2\u0006\u0004\bJ\u0010KJ#\u0010L\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010I\u001A\u0004\u0018\u00010HH\u0016\u00A2\u0006\u0004\bL\u0010MJ)\u0010Q\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0006\u0010O\u001A\u00020N2\u0006\u0010P\u001A\u00020NH\u0016\u00A2\u0006\u0004\bQ\u0010RJ7\u0010U\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010E\u001A\u0004\u0018\u00010\u00102\b\u0010S\u001A\u0004\u0018\u00010\u00102\b\u0010T\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\bU\u0010VJ5\u0010Z\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0016\u001A\u0004\u0018\u00010\u00152\u0006\u0010W\u001A\u00020)2\b\u0010Y\u001A\u0004\u0018\u00010XH\u0016\u00A2\u0006\u0004\bZ\u0010[J#\u0010^\u001A\u00020\u00122\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010]\u001A\u0004\u0018\u00010\\H\u0017\u00A2\u0006\u0004\b^\u0010_R\u001A\u0010a\u001A\b\u0012\u0004\u0012\u00020\u00040`8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\ba\u0010bR\u001E\u0010d\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010c8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010g\u001A\u00020f8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bg\u0010h\u00A8\u0006j"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/webkit/BaseWebViewClient;", "Landroid/webkit/WebViewClient;", "<init>", "()V", "Lcom/kakaoent/trevi/ad/webview/webkit/IWebViewClient;", "webViewClient", "Lie/H;", "addWebViewClient", "(Lcom/kakaoent/trevi/ad/webview/webkit/IWebViewClient;)V", "clear", "Lcom/kakaoent/trevi/ad/webview/webkit/BaseWebChromeClient;", "webChromeClient", "linkWebChromeClient", "(Lcom/kakaoent/trevi/ad/webview/webkit/BaseWebChromeClient;)V", "Landroid/webkit/WebView;", "view", "", "url", "", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Landroid/webkit/WebResourceRequest;", "request", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z", "Landroid/graphics/Bitmap;", "favicon", "onPageStarted", "(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "onPageFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "onLoadResource", "onPageCommitVisible", "Landroid/webkit/WebResourceResponse;", "shouldInterceptRequest", "(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;", "Landroid/os/Message;", "cancelMsg", "continueMsg", "onTooManyRedirects", "(Landroid/webkit/WebView;Landroid/os/Message;Landroid/os/Message;)V", "", "errorCode", "description", "failingUrl", "onReceivedError", "(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V", "Landroid/webkit/WebResourceError;", "error", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V", "errorResponse", "onReceivedHttpError", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceResponse;)V", "dontResend", "resend", "onFormResubmission", "isReload", "doUpdateVisitedHistory", "(Landroid/webkit/WebView;Ljava/lang/String;Z)V", "Landroid/webkit/SslErrorHandler;", "handler", "Landroid/net/http/SslError;", "onReceivedSslError", "(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V", "Landroid/webkit/ClientCertRequest;", "onReceivedClientCertRequest", "(Landroid/webkit/WebView;Landroid/webkit/ClientCertRequest;)V", "Landroid/webkit/HttpAuthHandler;", "host", "realm", "onReceivedHttpAuthRequest", "(Landroid/webkit/WebView;Landroid/webkit/HttpAuthHandler;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/view/KeyEvent;", "event", "shouldOverrideKeyEvent", "(Landroid/webkit/WebView;Landroid/view/KeyEvent;)Z", "onUnhandledKeyEvent", "(Landroid/webkit/WebView;Landroid/view/KeyEvent;)V", "", "oldScale", "newScale", "onScaleChanged", "(Landroid/webkit/WebView;FF)V", "account", "args", "onReceivedLoginRequest", "(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "threatType", "Landroid/webkit/SafeBrowsingResponse;", "callback", "onSafeBrowsingHit", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;ILandroid/webkit/SafeBrowsingResponse;)V", "Landroid/webkit/RenderProcessGoneDetail;", "detail", "onRenderProcessGone", "(Landroid/webkit/WebView;Landroid/webkit/RenderProcessGoneDetail;)Z", "Ljava/util/concurrent/CopyOnWriteArrayList;", "chainWebViewClient", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "webChromeClientRef", "Ljava/lang/ref/WeakReference;", "Lcom/kakaoent/trevi/ad/webview/webkit/BaseWebViewClient$FormResubmissionDialog;", "formResubmissionDialog", "Lcom/kakaoent/trevi/ad/webview/webkit/BaseWebViewClient$FormResubmissionDialog;", "FormResubmissionDialog", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class BaseWebViewClient extends WebViewClient {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010\n\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u000E\u001A\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR\u0018\u0010\u0010\u001A\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u000F¨\u0006\u0011"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/webkit/BaseWebViewClient$FormResubmissionDialog;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "Landroid/webkit/WebView;", "view", "Landroid/os/Message;", "dontResend", "resend", "Lie/H;", "onFormResubmission", "(Landroid/app/Activity;Landroid/webkit/WebView;Landroid/os/Message;Landroid/os/Message;)V", "mDontResend", "Landroid/os/Message;", "mResend", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class FormResubmissionDialog {
        @Nullable
        private Message mDontResend;
        @Nullable
        private Message mResend;

        public static void a(FormResubmissionDialog baseWebViewClient$FormResubmissionDialog0, DialogInterface dialogInterface0) {
            FormResubmissionDialog.onFormResubmission$lambda$2(baseWebViewClient$FormResubmissionDialog0, dialogInterface0);
        }

        public static void b(FormResubmissionDialog baseWebViewClient$FormResubmissionDialog0, DialogInterface dialogInterface0, int v) {
            FormResubmissionDialog.onFormResubmission$lambda$0(baseWebViewClient$FormResubmissionDialog0, dialogInterface0, v);
        }

        public static void c(FormResubmissionDialog baseWebViewClient$FormResubmissionDialog0, DialogInterface dialogInterface0, int v) {
            FormResubmissionDialog.onFormResubmission$lambda$1(baseWebViewClient$FormResubmissionDialog0, dialogInterface0, v);
        }

        public final void onFormResubmission(@NotNull Activity activity0, @Nullable WebView webView0, @Nullable Message message0, @Nullable Message message1) {
            q.g(activity0, "activity");
            if(this.mDontResend != null) {
                if(message0 != null) {
                    message0.sendToTarget();
                }
                return;
            }
            this.mDontResend = message0;
            this.mResend = message1;
            AlertDialog.Builder alertDialog$Builder0 = new AlertDialog.Builder(activity0);
            alertDialog$Builder0.a.e = alertDialog$Builder0.a.a.getText(0x104000A);
            alertDialog$Builder0.a.g = alertDialog$Builder0.a.a.getText(R.string.trevi_browser_frame_form_resubmit_message);
            alertDialog$Builder0.d(0x104000A, new a(this, 0));
            a a0 = new a(this, 1);
            alertDialog$Builder0.a.j = alertDialog$Builder0.a.a.getText(0x1040000);
            alertDialog$Builder0.a.k = a0;
            alertDialog$Builder0.a.o = new b(this, 0);
            alertDialog$Builder0.a().show();
        }

        private static final void onFormResubmission$lambda$0(FormResubmissionDialog baseWebViewClient$FormResubmissionDialog0, DialogInterface dialogInterface0, int v) {
            q.g(baseWebViewClient$FormResubmissionDialog0, "this$0");
            Message message0 = baseWebViewClient$FormResubmissionDialog0.mResend;
            if(message0 != null) {
                message0.sendToTarget();
            }
            baseWebViewClient$FormResubmissionDialog0.mResend = null;
            baseWebViewClient$FormResubmissionDialog0.mDontResend = null;
        }

        private static final void onFormResubmission$lambda$1(FormResubmissionDialog baseWebViewClient$FormResubmissionDialog0, DialogInterface dialogInterface0, int v) {
            q.g(baseWebViewClient$FormResubmissionDialog0, "this$0");
            Message message0 = baseWebViewClient$FormResubmissionDialog0.mDontResend;
            if(message0 != null) {
                message0.sendToTarget();
            }
            baseWebViewClient$FormResubmissionDialog0.mResend = null;
            baseWebViewClient$FormResubmissionDialog0.mDontResend = null;
        }

        private static final void onFormResubmission$lambda$2(FormResubmissionDialog baseWebViewClient$FormResubmissionDialog0, DialogInterface dialogInterface0) {
            q.g(baseWebViewClient$FormResubmissionDialog0, "this$0");
            Message message0 = baseWebViewClient$FormResubmissionDialog0.mDontResend;
            if(message0 != null) {
                message0.sendToTarget();
            }
            baseWebViewClient$FormResubmissionDialog0.mResend = null;
            baseWebViewClient$FormResubmissionDialog0.mDontResend = null;
        }
    }

    @NotNull
    private final CopyOnWriteArrayList chainWebViewClient;
    @NotNull
    private final FormResubmissionDialog formResubmissionDialog;
    @Nullable
    private WeakReference webChromeClientRef;

    public BaseWebViewClient() {
        this.chainWebViewClient = new CopyOnWriteArrayList();
        this.formResubmissionDialog = new FormResubmissionDialog();
    }

    public final void addWebViewClient(@NotNull IWebViewClient iWebViewClient0) {
        q.g(iWebViewClient0, "webViewClient");
        this.chainWebViewClient.add(iWebViewClient0);
    }

    public final void clear() {
        this.chainWebViewClient.clear();
    }

    @Override  // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(@Nullable WebView webView0, @Nullable String s, boolean z) {
        for(Object object0: this.chainWebViewClient) {
            ((IWebViewClient)object0).doUpdateVisitedHistory(webView0, s, z);
        }
    }

    public final void linkWebChromeClient(@NotNull BaseWebChromeClient baseWebChromeClient0) {
        q.g(baseWebChromeClient0, "webChromeClient");
        this.webChromeClientRef = new WeakReference(baseWebChromeClient0);
    }

    @Override  // android.webkit.WebViewClient
    public void onFormResubmission(@Nullable WebView webView0, @Nullable Message message0, @Nullable Message message1) {
        Activity activity1;
        Activity activity0;
        Iterator iterator0 = this.chainWebViewClient.iterator();
        while(true) {
            activity0 = null;
            if(!iterator0.hasNext()) {
                break;
            }
            Object object0 = iterator0.next();
            ((IWebViewClient)object0).onFormResubmission(webView0, message0, message1);
        }
        WebViewVisibleCallback webViewVisibleCallback0 = webView0 instanceof WebViewVisibleCallback ? ((WebViewVisibleCallback)webView0) : null;
        if(webViewVisibleCallback0 != null && webViewVisibleCallback0.isForeground()) {
            Context context0 = webView0.getContext();
            if(context0 != null) {
                if(context0 instanceof Activity) {
                    activity1 = (Activity)context0;
                    this.formResubmissionDialog.onFormResubmission(activity1, webView0, message0, message1);
                    return;
                }
                Context context1 = ((ContextWrapper)context0).getBaseContext();
                if(context1 instanceof Activity) {
                    activity0 = (Activity)context1;
                }
                if(activity0 != null) {
                    activity1 = activity0;
                    this.formResubmissionDialog.onFormResubmission(activity1, webView0, message0, message1);
                }
            }
        }
        else if(message0 != null) {
            message0.sendToTarget();
        }
    }

    @Override  // android.webkit.WebViewClient
    public void onLoadResource(@Nullable WebView webView0, @Nullable String s) {
        for(Object object0: this.chainWebViewClient) {
            ((IWebViewClient)object0).onLoadResource(webView0, s);
        }
    }

    @Override  // android.webkit.WebViewClient
    public void onPageCommitVisible(@Nullable WebView webView0, @Nullable String s) {
        for(Object object0: this.chainWebViewClient) {
            ((IWebViewClient)object0).onPageCommitVisible(webView0, s);
        }
    }

    @Override  // android.webkit.WebViewClient
    public void onPageFinished(@Nullable WebView webView0, @Nullable String s) {
        for(Object object0: this.chainWebViewClient) {
            ((IWebViewClient)object0).onPageFinished(webView0, s);
        }
    }

    @Override  // android.webkit.WebViewClient
    public void onPageStarted(@Nullable WebView webView0, @Nullable String s, @Nullable Bitmap bitmap0) {
        for(Object object0: this.chainWebViewClient) {
            ((IWebViewClient)object0).onPageStarted(webView0, s, bitmap0);
        }
    }

    @Override  // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(@Nullable WebView webView0, @Nullable ClientCertRequest clientCertRequest0) {
        Activity activity0;
        Iterator iterator0 = this.chainWebViewClient.iterator();
        while(true) {
            activity0 = null;
            if(!iterator0.hasNext()) {
                break;
            }
            Object object0 = iterator0.next();
            ((IWebViewClient)object0).onReceivedClientCertRequest(webView0, clientCertRequest0);
        }
        Context context0 = webView0 == null ? null : webView0.getContext();
        if(context0 == null) {
            return;
        }
        if(context0 instanceof Activity) {
            activity0 = (Activity)context0;
        }
        else {
            Context context1 = ((ContextWrapper)context0).getBaseContext();
            if(context1 instanceof Activity) {
                activity0 = (Activity)context1;
            }
        }
        ClientCertRequestDialog.INSTANCE.onReceivedClientCertRequest(activity0, webView0, clientCertRequest0);
    }

    @Override  // android.webkit.WebViewClient
    public void onReceivedError(@Nullable WebView webView0, int v, @Nullable String s, @Nullable String s1) {
        for(Object object0: this.chainWebViewClient) {
            ((IWebViewClient)object0).onReceivedError(webView0, v, s, s1);
        }
    }

    @Override  // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(@Nullable WebView webView0, @NotNull WebResourceRequest webResourceRequest0, @NotNull WebResourceError webResourceError0) {
        q.g(webResourceRequest0, "request");
        q.g(webResourceError0, "error");
        for(Object object0: this.chainWebViewClient) {
            ((IWebViewClient)object0).onReceivedError(webView0, webResourceRequest0, webResourceError0);
        }
        if(webResourceRequest0.isForMainFrame()) {
            this.onReceivedError(webView0, webResourceError0.getErrorCode(), webResourceError0.getDescription().toString(), webResourceRequest0.getUrl().toString());
        }
    }

    @Override  // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(@Nullable WebView webView0, @Nullable HttpAuthHandler httpAuthHandler0, @Nullable String s, @Nullable String s1) {
        for(Object object0: this.chainWebViewClient) {
            ((IWebViewClient)object0).onReceivedHttpAuthRequest(webView0, httpAuthHandler0, s, s1);
        }
    }

    @Override  // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedHttpError(@Nullable WebView webView0, @NotNull WebResourceRequest webResourceRequest0, @Nullable WebResourceResponse webResourceResponse0) {
        q.g(webResourceRequest0, "request");
        for(Object object0: this.chainWebViewClient) {
            ((IWebViewClient)object0).onReceivedHttpError(webView0, webResourceRequest0, webResourceResponse0);
        }
    }

    @Override  // android.webkit.WebViewClient
    public void onReceivedLoginRequest(@Nullable WebView webView0, @Nullable String s, @Nullable String s1, @Nullable String s2) {
        for(Object object0: this.chainWebViewClient) {
            ((IWebViewClient)object0).onReceivedLoginRequest(webView0, s, s1, s2);
        }
    }

    @Override  // android.webkit.WebViewClient
    public void onReceivedSslError(@Nullable WebView webView0, @Nullable SslErrorHandler sslErrorHandler0, @Nullable SslError sslError0) {
        Activity activity0;
        BaseWebChromeClient baseWebChromeClient0;
        Iterator iterator0 = this.chainWebViewClient.iterator();
        while(true) {
            baseWebChromeClient0 = null;
            if(!iterator0.hasNext()) {
                break;
            }
            Object object0 = iterator0.next();
            ((IWebViewClient)object0).onReceivedSslError(webView0, sslErrorHandler0, sslError0);
        }
        WebViewVisibleCallback webViewVisibleCallback0 = webView0 instanceof WebViewVisibleCallback ? ((WebViewVisibleCallback)webView0) : null;
        if(webViewVisibleCallback0 != null && webViewVisibleCallback0.isForeground()) {
            Context context0 = webView0.getContext();
            if(context0 != null) {
                if(context0 instanceof Activity) {
                    activity0 = (Activity)context0;
                }
                else {
                    Context context1 = ((ContextWrapper)context0).getBaseContext();
                    activity0 = context1 instanceof Activity ? ((Activity)context1) : null;
                }
                SslErrorDialog sslErrorDialog0 = SslErrorDialog.INSTANCE;
                WeakReference weakReference0 = this.webChromeClientRef;
                if(weakReference0 != null) {
                    baseWebChromeClient0 = (BaseWebChromeClient)weakReference0.get();
                }
                sslErrorDialog0.onReceivedSslError(activity0, webView0, sslErrorHandler0, sslError0, this, baseWebChromeClient0);
            }
        }
        else if(sslErrorHandler0 != null) {
            sslErrorHandler0.cancel();
        }
    }

    @Override  // android.webkit.WebViewClient
    @TargetApi(26)
    public boolean onRenderProcessGone(@Nullable WebView webView0, @Nullable RenderProcessGoneDetail renderProcessGoneDetail0) {
        for(Object object0: this.chainWebViewClient) {
            if(((IWebViewClient)object0).onRenderProcessGone(webView0, renderProcessGoneDetail0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    @Override  // android.webkit.WebViewClient
    public void onSafeBrowsingHit(@Nullable WebView webView0, @Nullable WebResourceRequest webResourceRequest0, int v, @Nullable SafeBrowsingResponse safeBrowsingResponse0) {
        super.onSafeBrowsingHit(webView0, webResourceRequest0, v, safeBrowsingResponse0);
    }

    @Override  // android.webkit.WebViewClient
    public void onScaleChanged(@Nullable WebView webView0, float f, float f1) {
        for(Object object0: this.chainWebViewClient) {
            ((IWebViewClient)object0).onScaleChanged(webView0, f, f1);
        }
    }

    @Override  // android.webkit.WebViewClient
    public void onTooManyRedirects(@Nullable WebView webView0, @Nullable Message message0, @Nullable Message message1) {
        for(Object object0: this.chainWebViewClient) {
            ((IWebViewClient)object0).onTooManyRedirects(webView0, message0, message1);
        }
    }

    @Override  // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(@Nullable WebView webView0, @Nullable KeyEvent keyEvent0) {
        super.onUnhandledKeyEvent(webView0, keyEvent0);
    }

    @Override  // android.webkit.WebViewClient
    @TargetApi(21)
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@Nullable WebView webView0, @Nullable WebResourceRequest webResourceRequest0) {
        for(Object object0: this.chainWebViewClient) {
            WebResourceResponse webResourceResponse0 = ((IWebViewClient)object0).shouldInterceptRequest(webView0, webResourceRequest0);
            if(webResourceResponse0 != null) {
                return webResourceResponse0;
            }
            if(false) {
                break;
            }
        }
        return webResourceRequest0 == null ? this.shouldInterceptRequest(webView0, "null") : this.shouldInterceptRequest(webView0, String.valueOf(webResourceRequest0.getUrl()));
    }

    @Override  // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@Nullable WebView webView0, @Nullable String s) {
        for(Object object0: this.chainWebViewClient) {
            WebResourceResponse webResourceResponse0 = ((IWebViewClient)object0).shouldInterceptRequest(webView0, s);
            if(webResourceResponse0 != null) {
                return webResourceResponse0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    @Override  // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(@Nullable WebView webView0, @Nullable KeyEvent keyEvent0) {
        for(Object object0: this.chainWebViewClient) {
            if(((IWebViewClient)object0).shouldOverrideKeyEvent(webView0, keyEvent0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    @Override  // android.webkit.WebViewClient
    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(@NotNull WebView webView0, @Nullable WebResourceRequest webResourceRequest0) {
        q.g(webView0, "view");
        for(Object object0: this.chainWebViewClient) {
            if(((IWebViewClient)object0).shouldOverrideUrlLoading(webView0, webResourceRequest0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return webResourceRequest0 == null ? this.shouldOverrideUrlLoading(webView0, "null") : this.shouldOverrideUrlLoading(webView0, String.valueOf(webResourceRequest0.getUrl()));
    }

    @Override  // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(@NotNull WebView webView0, @Nullable String s) {
        q.g(webView0, "view");
        if(s == null) {
            return false;
        }
        for(Object object0: this.chainWebViewClient) {
            if(((IWebViewClient)object0).shouldOverrideUrlLoading(webView0, s)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        WeakReference weakReference0 = this.webChromeClientRef;
        return weakReference0 == null ? UriSchemeProcessor.process$default(UriSchemeProcessor.INSTANCE, s, webView0, null, null, 8, null) : UriSchemeProcessor.process$default(UriSchemeProcessor.INSTANCE, s, webView0, ((BaseWebChromeClient)weakReference0.get()), null, 8, null);
    }
}

