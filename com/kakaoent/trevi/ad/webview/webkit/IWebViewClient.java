package com.kakaoent.trevi.ad.webview.webkit;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import ie.d;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J#\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\'\u00A2\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\n\u001A\u0004\u0018\u00010\tH&\u00A2\u0006\u0004\b\u0007\u0010\u000BJ-\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\r\u001A\u0004\u0018\u00010\fH&\u00A2\u0006\u0004\b\u000F\u0010\u0010J#\u0010\u0011\u001A\u00020\u000E2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H&\u00A2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001A\u00020\u000E2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H&\u00A2\u0006\u0004\b\u0013\u0010\u0012J#\u0010\u0014\u001A\u00020\u000E2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\'\u00A2\u0006\u0004\b\u0014\u0010\u0012J%\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\'\u00A2\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\n\u001A\u0004\u0018\u00010\tH\'\u00A2\u0006\u0004\b\u0016\u0010\u0018J-\u0010\u001C\u001A\u00020\u000E2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u001A\u001A\u0004\u0018\u00010\u00192\b\u0010\u001B\u001A\u0004\u0018\u00010\u0019H\'\u00A2\u0006\u0004\b\u001C\u0010\u001DJ5\u0010\"\u001A\u00020\u000E2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u001F\u001A\u00020\u001E2\b\u0010 \u001A\u0004\u0018\u00010\u00042\b\u0010!\u001A\u0004\u0018\u00010\u0004H\'\u00A2\u0006\u0004\b\"\u0010#J-\u0010\"\u001A\u00020\u000E2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010%\u001A\u0004\u0018\u00010$H\'\u00A2\u0006\u0004\b\"\u0010&J-\u0010(\u001A\u00020\u000E2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\'\u001A\u0004\u0018\u00010\u0015H\'\u00A2\u0006\u0004\b(\u0010)J-\u0010,\u001A\u00020\u000E2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010*\u001A\u0004\u0018\u00010\u00192\b\u0010+\u001A\u0004\u0018\u00010\u0019H&\u00A2\u0006\u0004\b,\u0010\u001DJ+\u0010.\u001A\u00020\u000E2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010-\u001A\u00020\u0006H&\u00A2\u0006\u0004\b.\u0010/J-\u00103\u001A\u00020\u000E2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u00101\u001A\u0004\u0018\u0001002\b\u0010%\u001A\u0004\u0018\u000102H\'\u00A2\u0006\u0004\b3\u00104J#\u00106\u001A\u00020\u000E2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\n\u001A\u0004\u0018\u000105H\'\u00A2\u0006\u0004\b6\u00107J7\u0010;\u001A\u00020\u000E2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u00101\u001A\u0004\u0018\u0001082\b\u00109\u001A\u0004\u0018\u00010\u00042\b\u0010:\u001A\u0004\u0018\u00010\u0004H&\u00A2\u0006\u0004\b;\u0010<J#\u0010?\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010>\u001A\u0004\u0018\u00010=H&\u00A2\u0006\u0004\b?\u0010@J)\u0010D\u001A\u00020\u000E2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010B\u001A\u00020A2\u0006\u0010C\u001A\u00020AH&\u00A2\u0006\u0004\bD\u0010EJ7\u0010H\u001A\u00020\u000E2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010:\u001A\u0004\u0018\u00010\u00042\b\u0010F\u001A\u0004\u0018\u00010\u00042\b\u0010G\u001A\u0004\u0018\u00010\u0004H\'\u00A2\u0006\u0004\bH\u0010IJ#\u0010L\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010K\u001A\u0004\u0018\u00010JH\'\u00A2\u0006\u0004\bL\u0010M\u00A8\u0006N"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/webkit/IWebViewClient;", "", "Landroid/webkit/WebView;", "view", "", "url", "", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Landroid/webkit/WebResourceRequest;", "request", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z", "Landroid/graphics/Bitmap;", "favicon", "Lie/H;", "onPageStarted", "(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "onPageFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "onLoadResource", "onPageCommitVisible", "Landroid/webkit/WebResourceResponse;", "shouldInterceptRequest", "(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;", "Landroid/os/Message;", "cancelMsg", "continueMsg", "onTooManyRedirects", "(Landroid/webkit/WebView;Landroid/os/Message;Landroid/os/Message;)V", "", "errorCode", "description", "failingUrl", "onReceivedError", "(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V", "Landroid/webkit/WebResourceError;", "error", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V", "errorResponse", "onReceivedHttpError", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceResponse;)V", "dontResend", "resend", "onFormResubmission", "isReload", "doUpdateVisitedHistory", "(Landroid/webkit/WebView;Ljava/lang/String;Z)V", "Landroid/webkit/SslErrorHandler;", "handler", "Landroid/net/http/SslError;", "onReceivedSslError", "(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V", "Landroid/webkit/ClientCertRequest;", "onReceivedClientCertRequest", "(Landroid/webkit/WebView;Landroid/webkit/ClientCertRequest;)V", "Landroid/webkit/HttpAuthHandler;", "host", "realm", "onReceivedHttpAuthRequest", "(Landroid/webkit/WebView;Landroid/webkit/HttpAuthHandler;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/view/KeyEvent;", "event", "shouldOverrideKeyEvent", "(Landroid/webkit/WebView;Landroid/view/KeyEvent;)Z", "", "oldScale", "newScale", "onScaleChanged", "(Landroid/webkit/WebView;FF)V", "account", "args", "onReceivedLoginRequest", "(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/webkit/RenderProcessGoneDetail;", "detail", "onRenderProcessGone", "(Landroid/webkit/WebView;Landroid/webkit/RenderProcessGoneDetail;)Z", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface IWebViewClient {
    void doUpdateVisitedHistory(@Nullable WebView arg1, @Nullable String arg2, boolean arg3);

    void onFormResubmission(@Nullable WebView arg1, @Nullable Message arg2, @Nullable Message arg3);

    void onLoadResource(@Nullable WebView arg1, @Nullable String arg2);

    @TargetApi(23)
    void onPageCommitVisible(@Nullable WebView arg1, @Nullable String arg2);

    void onPageFinished(@Nullable WebView arg1, @Nullable String arg2);

    void onPageStarted(@Nullable WebView arg1, @Nullable String arg2, @Nullable Bitmap arg3);

    @TargetApi(21)
    void onReceivedClientCertRequest(@Nullable WebView arg1, @Nullable ClientCertRequest arg2);

    @d
    void onReceivedError(@Nullable WebView arg1, int arg2, @Nullable String arg3, @Nullable String arg4);

    @TargetApi(23)
    void onReceivedError(@Nullable WebView arg1, @Nullable WebResourceRequest arg2, @Nullable WebResourceError arg3);

    void onReceivedHttpAuthRequest(@Nullable WebView arg1, @Nullable HttpAuthHandler arg2, @Nullable String arg3, @Nullable String arg4);

    @TargetApi(23)
    void onReceivedHttpError(@Nullable WebView arg1, @Nullable WebResourceRequest arg2, @Nullable WebResourceResponse arg3);

    @TargetApi(12)
    void onReceivedLoginRequest(@Nullable WebView arg1, @Nullable String arg2, @Nullable String arg3, @Nullable String arg4);

    @TargetApi(8)
    void onReceivedSslError(@Nullable WebView arg1, @Nullable SslErrorHandler arg2, @Nullable SslError arg3);

    @TargetApi(26)
    boolean onRenderProcessGone(@Nullable WebView arg1, @Nullable RenderProcessGoneDetail arg2);

    void onScaleChanged(@Nullable WebView arg1, float arg2, float arg3);

    @d
    void onTooManyRedirects(@Nullable WebView arg1, @Nullable Message arg2, @Nullable Message arg3);

    @TargetApi(21)
    @Nullable
    WebResourceResponse shouldInterceptRequest(@Nullable WebView arg1, @Nullable WebResourceRequest arg2);

    @TargetApi(11)
    @d
    @Nullable
    WebResourceResponse shouldInterceptRequest(@Nullable WebView arg1, @Nullable String arg2);

    boolean shouldOverrideKeyEvent(@Nullable WebView arg1, @Nullable KeyEvent arg2);

    boolean shouldOverrideUrlLoading(@Nullable WebView arg1, @Nullable WebResourceRequest arg2);

    @d
    boolean shouldOverrideUrlLoading(@Nullable WebView arg1, @Nullable String arg2);
}

