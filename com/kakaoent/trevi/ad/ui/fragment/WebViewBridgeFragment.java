package com.kakaoent.trevi.ad.ui.fragment;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient;
import com.kakaoent.trevi.ad.webview.webkit.IWebViewClient;
import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00F2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\u00A2\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u000B\u001A\u00020\n2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0017\u00A2\u0006\u0004\b\u000B\u0010\fJ#\u0010\u000B\u001A\u00020\n2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0017\u00A2\u0006\u0004\b\u000B\u0010\u000FJ-\u0010\u0013\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0016J#\u0010\u0018\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0017\u00A2\u0006\u0004\b\u0018\u0010\u0016J%\u0010\u001A\u001A\u0004\u0018\u00010\u00192\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0017\u00A2\u0006\u0004\b\u001A\u0010\u001BJ%\u0010\u001A\u001A\u0004\u0018\u00010\u00192\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0017\u00A2\u0006\u0004\b\u001A\u0010\u001CJ-\u0010 \u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001DH\u0016\u00A2\u0006\u0004\b \u0010!J5\u0010&\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010#\u001A\u00020\"2\b\u0010$\u001A\u0004\u0018\u00010\b2\b\u0010%\u001A\u0004\u0018\u00010\bH\u0017\u00A2\u0006\u0004\b&\u0010\'J-\u0010&\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010)\u001A\u0004\u0018\u00010(H\u0017\u00A2\u0006\u0004\b&\u0010*J-\u0010,\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010+\u001A\u0004\u0018\u00010\u0019H\u0017\u00A2\u0006\u0004\b,\u0010-J-\u00100\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010.\u001A\u0004\u0018\u00010\u001D2\b\u0010/\u001A\u0004\u0018\u00010\u001DH\u0016\u00A2\u0006\u0004\b0\u0010!J+\u00102\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u00101\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b2\u00103J-\u00107\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u00105\u001A\u0004\u0018\u0001042\b\u0010)\u001A\u0004\u0018\u000106H\u0017\u00A2\u0006\u0004\b7\u00108J#\u0010:\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\u000E\u001A\u0004\u0018\u000109H\u0017\u00A2\u0006\u0004\b:\u0010;J7\u0010?\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u00105\u001A\u0004\u0018\u00010<2\b\u0010=\u001A\u0004\u0018\u00010\b2\b\u0010>\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b?\u0010@J#\u0010C\u001A\u00020\n2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010B\u001A\u0004\u0018\u00010AH\u0016\u00A2\u0006\u0004\bC\u0010DJ)\u0010H\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010F\u001A\u00020E2\u0006\u0010G\u001A\u00020EH\u0016\u00A2\u0006\u0004\bH\u0010IJ7\u0010L\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010>\u001A\u0004\u0018\u00010\b2\b\u0010J\u001A\u0004\u0018\u00010\b2\b\u0010K\u001A\u0004\u0018\u00010\bH\u0017\u00A2\u0006\u0004\bL\u0010MJ#\u0010P\u001A\u00020\n2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010O\u001A\u0004\u0018\u00010NH\u0017\u00A2\u0006\u0004\bP\u0010QJ!\u0010S\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010R\u001A\u00020\"H\u0016\u00A2\u0006\u0004\bS\u0010TJ#\u0010V\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010U\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\bV\u0010\u0016J#\u0010X\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010W\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\bX\u0010YJ+\u0010[\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010Z\u001A\u00020\nH\u0017\u00A2\u0006\u0004\b[\u00103J#\u0010_\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\\2\b\u0010^\u001A\u0004\u0018\u00010]H\u0017\u00A2\u0006\u0004\b_\u0010`J+\u0010_\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\\2\u0006\u0010a\u001A\u00020\"2\b\u0010^\u001A\u0004\u0018\u00010]H\u0017\u00A2\u0006\u0004\b_\u0010bJ\u000F\u0010c\u001A\u00020\u0012H\u0017\u00A2\u0006\u0004\bc\u0010\u0005J3\u0010g\u001A\u00020\n2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010d\u001A\u00020\n2\u0006\u0010e\u001A\u00020\n2\b\u0010f\u001A\u0004\u0018\u00010\u001DH\u0016\u00A2\u0006\u0004\bg\u0010hJ\u0019\u0010i\u001A\u00020\u00122\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016\u00A2\u0006\u0004\bi\u0010jJ\u0019\u0010l\u001A\u00020\u00122\b\u0010k\u001A\u0004\u0018\u00010\u0006H\u0016\u00A2\u0006\u0004\bl\u0010jJ7\u0010p\u001A\u00020\n2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010m\u001A\u0004\u0018\u00010\b2\b\u0010o\u001A\u0004\u0018\u00010nH\u0016\u00A2\u0006\u0004\bp\u0010qJ7\u0010r\u001A\u00020\n2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010m\u001A\u0004\u0018\u00010\b2\b\u0010o\u001A\u0004\u0018\u00010nH\u0016\u00A2\u0006\u0004\br\u0010qJA\u0010u\u001A\u00020\n2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010m\u001A\u0004\u0018\u00010\b2\b\u0010s\u001A\u0004\u0018\u00010\b2\b\u0010o\u001A\u0004\u0018\u00010tH\u0016\u00A2\u0006\u0004\bu\u0010vJ7\u0010w\u001A\u00020\n2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010m\u001A\u0004\u0018\u00010\b2\b\u0010o\u001A\u0004\u0018\u00010nH\u0016\u00A2\u0006\u0004\bw\u0010qJF\u0010\u007F\u001A\u00020\u00122\b\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010x\u001A\u0004\u0018\u00010\b2\u0006\u0010z\u001A\u00020y2\u0006\u0010{\u001A\u00020y2\u0006\u0010|\u001A\u00020y2\b\u0010~\u001A\u0004\u0018\u00010}H\u0017\u00A2\u0006\u0005\b\u007F\u0010\u0080\u0001J(\u0010\u0083\u0001\u001A\u00020\u00122\t\u0010\u0081\u0001\u001A\u0004\u0018\u00010\b2\t\u0010^\u001A\u0005\u0018\u00010\u0082\u0001H\u0017\u00A2\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u0011\u0010\u0085\u0001\u001A\u00020\u0012H\u0017\u00A2\u0006\u0005\b\u0085\u0001\u0010\u0005J\u001D\u0010\u0087\u0001\u001A\u00020\u00122\t\u0010\u000E\u001A\u0005\u0018\u00010\u0086\u0001H\u0017\u00A2\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u001D\u0010\u0089\u0001\u001A\u00020\u00122\t\u0010\u000E\u001A\u0005\u0018\u00010\u0086\u0001H\u0017\u00A2\u0006\u0006\b\u0089\u0001\u0010\u0088\u0001J\u0012\u0010\u008A\u0001\u001A\u00020\nH\u0017\u00A2\u0006\u0006\b\u008A\u0001\u0010\u008B\u0001J0\u0010\u008E\u0001\u001A\u00020\u00122\b\u0010m\u001A\u0004\u0018\u00010\b2\u0007\u0010\u008C\u0001\u001A\u00020\"2\t\u0010\u008D\u0001\u001A\u0004\u0018\u00010\bH\u0017\u00A2\u0006\u0006\b\u008E\u0001\u0010\u008F\u0001J\u001E\u0010\u008E\u0001\u001A\u00020\n2\n\u0010\u0091\u0001\u001A\u0005\u0018\u00010\u0090\u0001H\u0017\u00A2\u0006\u0006\b\u008E\u0001\u0010\u0092\u0001J*\u0010\u0095\u0001\u001A\u00020\u00122\u0016\u0010^\u001A\u0012\u0012\u000B\u0012\t\u0012\u0004\u0012\u00020\b0\u0094\u0001\u0018\u00010\u0093\u0001H\u0017\u00A2\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001JC\u0010\u009C\u0001\u001A\u00020\n2\t\u0010\u0097\u0001\u001A\u0004\u0018\u00010\u00062\u0018\u0010\u0099\u0001\u001A\u0013\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0098\u00010\u0094\u0001\u0018\u00010\u0093\u00012\n\u0010\u009B\u0001\u001A\u0005\u0018\u00010\u009A\u0001H\u0017\u00A2\u0006\u0006\b\u009C\u0001\u0010\u009D\u0001R\u0019\u0010\u00A0\u0001\u001A\u0004\u0018\u00010\u00108WX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u009E\u0001\u0010\u009F\u0001R\u0019\u0010\u00A3\u0001\u001A\u0004\u0018\u00010\\8WX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00A1\u0001\u0010\u00A2\u0001\u00A8\u0006\u00A4\u0001"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/fragment/WebViewBridgeFragment;", "Lcom/kakaoent/trevi/ad/ui/fragment/BaseFragment;", "Lcom/kakaoent/trevi/ad/webview/webkit/IWebViewClient;", "Lcom/kakaoent/trevi/ad/webview/webkit/IWebChromeClient;", "<init>", "()V", "Landroid/webkit/WebView;", "view", "", "url", "", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Landroid/webkit/WebResourceRequest;", "request", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z", "Landroid/graphics/Bitmap;", "favicon", "Lie/H;", "onPageStarted", "(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "onPageFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "onLoadResource", "onPageCommitVisible", "Landroid/webkit/WebResourceResponse;", "shouldInterceptRequest", "(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;", "Landroid/os/Message;", "cancelMsg", "continueMsg", "onTooManyRedirects", "(Landroid/webkit/WebView;Landroid/os/Message;Landroid/os/Message;)V", "", "errorCode", "description", "failingUrl", "onReceivedError", "(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V", "Landroid/webkit/WebResourceError;", "error", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V", "errorResponse", "onReceivedHttpError", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceResponse;)V", "dontResend", "resend", "onFormResubmission", "isReload", "doUpdateVisitedHistory", "(Landroid/webkit/WebView;Ljava/lang/String;Z)V", "Landroid/webkit/SslErrorHandler;", "handler", "Landroid/net/http/SslError;", "onReceivedSslError", "(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V", "Landroid/webkit/ClientCertRequest;", "onReceivedClientCertRequest", "(Landroid/webkit/WebView;Landroid/webkit/ClientCertRequest;)V", "Landroid/webkit/HttpAuthHandler;", "host", "realm", "onReceivedHttpAuthRequest", "(Landroid/webkit/WebView;Landroid/webkit/HttpAuthHandler;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/view/KeyEvent;", "event", "shouldOverrideKeyEvent", "(Landroid/webkit/WebView;Landroid/view/KeyEvent;)Z", "", "oldScale", "newScale", "onScaleChanged", "(Landroid/webkit/WebView;FF)V", "account", "args", "onReceivedLoginRequest", "(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/webkit/RenderProcessGoneDetail;", "detail", "onRenderProcessGone", "(Landroid/webkit/WebView;Landroid/webkit/RenderProcessGoneDetail;)Z", "newProgress", "onProgressChanged", "(Landroid/webkit/WebView;I)V", "title", "onReceivedTitle", "icon", "onReceivedIcon", "(Landroid/webkit/WebView;Landroid/graphics/Bitmap;)V", "precomposed", "onReceivedTouchIconUrl", "Landroid/view/View;", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "callback", "onShowCustomView", "(Landroid/view/View;Landroid/webkit/WebChromeClient$CustomViewCallback;)V", "requestedOrientation", "(Landroid/view/View;ILandroid/webkit/WebChromeClient$CustomViewCallback;)V", "onHideCustomView", "isDialog", "isUserGesture", "resultMsg", "onCreateWindow", "(Landroid/webkit/WebView;ZZLandroid/os/Message;)Z", "onRequestFocus", "(Landroid/webkit/WebView;)V", "window", "onCloseWindow", "message", "Landroid/webkit/JsResult;", "result", "onJsAlert", "(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/JsResult;)Z", "onJsConfirm", "defaultValue", "Landroid/webkit/JsPromptResult;", "onJsPrompt", "(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/JsPromptResult;)Z", "onJsBeforeUnload", "databaseIdentifier", "", "quota", "estimatedDatabaseSize", "totalQuota", "Landroid/webkit/WebStorage$QuotaUpdater;", "quotaUpdater", "onExceededDatabaseQuota", "(Ljava/lang/String;Ljava/lang/String;JJJLandroid/webkit/WebStorage$QuotaUpdater;)V", "origin", "Landroid/webkit/GeolocationPermissions$Callback;", "onGeolocationPermissionsShowPrompt", "(Ljava/lang/String;Landroid/webkit/GeolocationPermissions$Callback;)V", "onGeolocationPermissionsHidePrompt", "Landroid/webkit/PermissionRequest;", "onPermissionRequest", "(Landroid/webkit/PermissionRequest;)V", "onPermissionRequestCanceled", "onJsTimeout", "()Z", "lineNumber", "sourceID", "onConsoleMessage", "(Ljava/lang/String;ILjava/lang/String;)V", "Landroid/webkit/ConsoleMessage;", "consoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "Landroid/webkit/ValueCallback;", "", "getVisitedHistory", "(Landroid/webkit/ValueCallback;)V", "webView", "Landroid/net/Uri;", "filePathCallback", "Landroid/webkit/WebChromeClient$FileChooserParams;", "fileChooserParams", "onShowFileChooser", "(Landroid/webkit/WebView;Landroid/webkit/ValueCallback;Landroid/webkit/WebChromeClient$FileChooserParams;)Z", "getDefaultVideoPoster", "()Landroid/graphics/Bitmap;", "defaultVideoPoster", "getVideoLoadingProgressView", "()Landroid/view/View;", "videoLoadingProgressView", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public abstract class WebViewBridgeFragment extends BaseFragment implements IWebChromeClient, IWebViewClient {
    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    public void doUpdateVisitedHistory(@Nullable WebView webView0, @Nullable String s, boolean z) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    @TargetApi(7)
    @Nullable
    public Bitmap getDefaultVideoPoster() {
        return null;
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    @TargetApi(7)
    @Nullable
    public View getVideoLoadingProgressView() {
        return null;
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    @TargetApi(7)
    public void getVisitedHistory(@Nullable ValueCallback valueCallback0) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    public void onCloseWindow(@Nullable WebView webView0) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    @d
    public void onConsoleMessage(@Nullable String s, int v, @Nullable String s1) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    @TargetApi(8)
    public boolean onConsoleMessage(@Nullable ConsoleMessage consoleMessage0) {
        return false;
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    public boolean onCreateWindow(@Nullable WebView webView0, boolean z, boolean z1, @Nullable Message message0) {
        return false;
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    @TargetApi(5)
    @d
    public void onExceededDatabaseQuota(@Nullable String s, @Nullable String s1, long v, long v1, long v2, @Nullable WebStorage.QuotaUpdater webStorage$QuotaUpdater0) {
        q.d(webStorage$QuotaUpdater0);
        webStorage$QuotaUpdater0.updateQuota(v);
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    public void onFormResubmission(@Nullable WebView webView0, @Nullable Message message0, @Nullable Message message1) {
        q.d(message0);
        message0.sendToTarget();
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    @TargetApi(5)
    public void onGeolocationPermissionsHidePrompt() {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    @TargetApi(5)
    public void onGeolocationPermissionsShowPrompt(@Nullable String s, @Nullable GeolocationPermissions.Callback geolocationPermissions$Callback0) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    @TargetApi(7)
    public void onHideCustomView() {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    public boolean onJsAlert(@Nullable WebView webView0, @Nullable String s, @Nullable String s1, @Nullable JsResult jsResult0) {
        return false;
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    public boolean onJsBeforeUnload(@Nullable WebView webView0, @Nullable String s, @Nullable String s1, @Nullable JsResult jsResult0) {
        return false;
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    public boolean onJsConfirm(@Nullable WebView webView0, @Nullable String s, @Nullable String s1, @Nullable JsResult jsResult0) {
        return false;
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    public boolean onJsPrompt(@Nullable WebView webView0, @Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable JsPromptResult jsPromptResult0) {
        return false;
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    @TargetApi(7)
    @d
    public boolean onJsTimeout() {
        return true;
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    public void onLoadResource(@Nullable WebView webView0, @Nullable String s) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    @TargetApi(23)
    public void onPageCommitVisible(@Nullable WebView webView0, @Nullable String s) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    public void onPageFinished(@Nullable WebView webView0, @Nullable String s) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    public void onPageStarted(@Nullable WebView webView0, @Nullable String s, @Nullable Bitmap bitmap0) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    @TargetApi(21)
    public void onPermissionRequest(@Nullable PermissionRequest permissionRequest0) {
        q.d(permissionRequest0);
        permissionRequest0.deny();
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    @TargetApi(21)
    public void onPermissionRequestCanceled(@Nullable PermissionRequest permissionRequest0) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    public void onProgressChanged(@Nullable WebView webView0, int v) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    @TargetApi(21)
    public void onReceivedClientCertRequest(@Nullable WebView webView0, @Nullable ClientCertRequest clientCertRequest0) {
        q.d(clientCertRequest0);
        clientCertRequest0.cancel();
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    @d
    public void onReceivedError(@Nullable WebView webView0, int v, @Nullable String s, @Nullable String s1) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    @TargetApi(23)
    public void onReceivedError(@Nullable WebView webView0, @Nullable WebResourceRequest webResourceRequest0, @Nullable WebResourceError webResourceError0) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    public void onReceivedHttpAuthRequest(@Nullable WebView webView0, @Nullable HttpAuthHandler httpAuthHandler0, @Nullable String s, @Nullable String s1) {
        q.d(httpAuthHandler0);
        httpAuthHandler0.cancel();
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    @TargetApi(23)
    public void onReceivedHttpError(@Nullable WebView webView0, @Nullable WebResourceRequest webResourceRequest0, @Nullable WebResourceResponse webResourceResponse0) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    public void onReceivedIcon(@Nullable WebView webView0, @Nullable Bitmap bitmap0) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    @TargetApi(12)
    public void onReceivedLoginRequest(@Nullable WebView webView0, @Nullable String s, @Nullable String s1, @Nullable String s2) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    @TargetApi(8)
    public void onReceivedSslError(@Nullable WebView webView0, @Nullable SslErrorHandler sslErrorHandler0, @Nullable SslError sslError0) {
        q.d(sslErrorHandler0);
        sslErrorHandler0.cancel();
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    public void onReceivedTitle(@Nullable WebView webView0, @Nullable String s) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    @TargetApi(7)
    public void onReceivedTouchIconUrl(@Nullable WebView webView0, @Nullable String s, boolean z) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    @TargetApi(26)
    public boolean onRenderProcessGone(@Nullable WebView webView0, @Nullable RenderProcessGoneDetail renderProcessGoneDetail0) {
        return false;
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    public void onRequestFocus(@Nullable WebView webView0) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    public void onScaleChanged(@Nullable WebView webView0, float f, float f1) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    @TargetApi(14)
    @d
    public void onShowCustomView(@Nullable View view0, int v, @Nullable WebChromeClient.CustomViewCallback webChromeClient$CustomViewCallback0) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    @TargetApi(7)
    public void onShowCustomView(@Nullable View view0, @Nullable WebChromeClient.CustomViewCallback webChromeClient$CustomViewCallback0) {
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient
    @TargetApi(21)
    public boolean onShowFileChooser(@Nullable WebView webView0, @Nullable ValueCallback valueCallback0, @Nullable WebChromeClient.FileChooserParams webChromeClient$FileChooserParams0) {
        return false;
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    public void onTooManyRedirects(@Nullable WebView webView0, @Nullable Message message0, @Nullable Message message1) {
        q.d(message0);
        message0.sendToTarget();
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    @TargetApi(21)
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@Nullable WebView webView0, @Nullable WebResourceRequest webResourceRequest0) {
        return null;
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    @TargetApi(11)
    @d
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@Nullable WebView webView0, @Nullable String s) {
        return null;
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    public boolean shouldOverrideKeyEvent(@Nullable WebView webView0, @Nullable KeyEvent keyEvent0) {
        return false;
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(@Nullable WebView webView0, @Nullable WebResourceRequest webResourceRequest0) {
        return false;
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.IWebViewClient
    @d
    public boolean shouldOverrideUrlLoading(@Nullable WebView webView0, @Nullable String s) {
        return false;
    }
}

