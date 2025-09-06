package com.kakaoent.trevi.ad.webview.webkit;

import T9.d;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView.WebViewTransport;
import android.webkit.WebView;
import android.widget.Toast;
import com.kakaoent.trevi.ad.R.string;
import com.kakaoent.trevi.ad.util.TreviLog;
import com.kakaoent.trevi.ad.webview.helper.CustomViewHandler;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00BC\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 x2\u00020\u0001:\u0001xB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\u000B\u0010\fJ\r\u0010\r\u001A\u00020\u0006\u00A2\u0006\u0004\b\r\u0010\u0003J\u0019\u0010\u000F\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u000F\u0010\bJ#\u0010\u0013\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00102\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0013\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001A\u00020\u00152\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0003J\r\u0010\u001A\u001A\u00020\u0019\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\r\u0010\u001C\u001A\u00020\u0006\u00A2\u0006\u0004\b\u001C\u0010\u0003J7\u0010\"\u001A\u00020\u00192\b\u0010\u000E\u001A\u0004\u0018\u00010\u00042\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001D2\b\u0010!\u001A\u0004\u0018\u00010 H\u0016\u00A2\u0006\u0004\b\"\u0010#JA\u0010&\u001A\u00020\u00192\b\u0010\u000E\u001A\u0004\u0018\u00010\u00042\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001D2\b\u0010$\u001A\u0004\u0018\u00010\u001D2\b\u0010!\u001A\u0004\u0018\u00010%H\u0016\u00A2\u0006\u0004\b&\u0010\'J7\u0010(\u001A\u00020\u00192\b\u0010\u000E\u001A\u0004\u0018\u00010\u00042\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001D2\b\u0010!\u001A\u0004\u0018\u00010 H\u0016\u00A2\u0006\u0004\b(\u0010#J7\u0010)\u001A\u00020\u00192\b\u0010\u000E\u001A\u0004\u0018\u00010\u00042\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001D2\b\u0010!\u001A\u0004\u0018\u00010 H\u0016\u00A2\u0006\u0004\b)\u0010#J#\u0010,\u001A\u00020\u00062\b\u0010*\u001A\u0004\u0018\u00010\u001D2\b\u0010\u0012\u001A\u0004\u0018\u00010+H\u0016\u00A2\u0006\u0004\b,\u0010-J\u0019\u00100\u001A\u00020\u00062\b\u0010/\u001A\u0004\u0018\u00010.H\u0016\u00A2\u0006\u0004\b0\u00101J+\u00104\u001A\u00020\u00062\b\u0010\u001F\u001A\u0004\u0018\u00010\u001D2\u0006\u00102\u001A\u00020\u00152\b\u00103\u001A\u0004\u0018\u00010\u001DH\u0016\u00A2\u0006\u0004\b4\u00105J\u0019\u00104\u001A\u00020\u00192\b\u00107\u001A\u0004\u0018\u000106H\u0016\u00A2\u0006\u0004\b4\u00108J\u0019\u00109\u001A\u00020\u00062\b\u0010/\u001A\u0004\u0018\u00010.H\u0016\u00A2\u0006\u0004\b9\u00101J9\u0010@\u001A\u00020\u00192\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0014\u0010=\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0;\u0018\u00010:2\b\u0010?\u001A\u0004\u0018\u00010>H\u0016\u00A2\u0006\u0004\b@\u0010AJ+\u0010C\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00042\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\u0006\u0010B\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\bC\u0010DJ#\u0010G\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00042\b\u0010F\u001A\u0004\u0018\u00010EH\u0016\u00A2\u0006\u0004\bG\u0010HJE\u0010P\u001A\u00020\u00062\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\b\u0010I\u001A\u0004\u0018\u00010\u001D2\u0006\u0010K\u001A\u00020J2\u0006\u0010L\u001A\u00020J2\u0006\u0010M\u001A\u00020J2\b\u0010O\u001A\u0004\u0018\u00010NH\u0016\u00A2\u0006\u0004\bP\u0010QJ#\u0010S\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00042\b\u0010R\u001A\u0004\u0018\u00010\u001DH\u0016\u00A2\u0006\u0004\bS\u0010TJ!\u0010V\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00042\u0006\u0010U\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\bV\u0010WJ%\u0010X\u001A\u00020\u00062\u0014\u0010\u0012\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001D0;\u0018\u00010:H\u0016\u00A2\u0006\u0004\bX\u0010YJ\u0011\u0010Z\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\bZ\u0010[J\u000F\u0010\\\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\\\u0010\u0003J\u0011\u0010]\u001A\u0004\u0018\u00010EH\u0016\u00A2\u0006\u0004\b]\u0010^J3\u0010c\u001A\u00020\u00192\b\u0010\u000E\u001A\u0004\u0018\u00010\u00042\u0006\u0010_\u001A\u00020\u00192\u0006\u0010`\u001A\u00020\u00192\b\u0010b\u001A\u0004\u0018\u00010aH\u0016\u00A2\u0006\u0004\bc\u0010dJ\u001F\u0010e\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u00042\b\u0010b\u001A\u0004\u0018\u00010a\u00A2\u0006\u0004\be\u0010fJ\u0019\u0010h\u001A\u00020\u00062\b\u0010g\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\bh\u0010\bJ\u000F\u0010i\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\bi\u0010\u001BR\u0014\u0010k\u001A\u00020j8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bk\u0010lR\u001A\u0010n\u001A\b\u0012\u0004\u0012\u00020\t0m8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bn\u0010oR\"\u0010p\u001A\u00020\u00198\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bp\u0010q\u001A\u0004\br\u0010\u001B\"\u0004\bs\u0010tR\u001E\u0010v\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bv\u0010w\u00A8\u0006y"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/webkit/BaseWebChromeClient;", "Landroid/webkit/WebChromeClient;", "<init>", "()V", "Landroid/webkit/WebView;", "webView", "Lie/H;", "linkWebView", "(Landroid/webkit/WebView;)V", "Lcom/kakaoent/trevi/ad/webview/webkit/IWebChromeClient;", "webChromeClient", "addWebChromeClient", "(Lcom/kakaoent/trevi/ad/webview/webkit/IWebChromeClient;)V", "clear", "view", "onRequestFocus", "Landroid/view/View;", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "callback", "onShowCustomView", "(Landroid/view/View;Landroid/webkit/WebChromeClient$CustomViewCallback;)V", "", "requestedOrientation", "(Landroid/view/View;ILandroid/webkit/WebChromeClient$CustomViewCallback;)V", "onHideCustomView", "", "isCustomViewShowing", "()Z", "hideCustomView", "", "url", "message", "Landroid/webkit/JsResult;", "result", "onJsAlert", "(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/JsResult;)Z", "defaultValue", "Landroid/webkit/JsPromptResult;", "onJsPrompt", "(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/JsPromptResult;)Z", "onJsConfirm", "onJsBeforeUnload", "origin", "Landroid/webkit/GeolocationPermissions$Callback;", "onGeolocationPermissionsShowPrompt", "(Ljava/lang/String;Landroid/webkit/GeolocationPermissions$Callback;)V", "Landroid/webkit/PermissionRequest;", "request", "onPermissionRequest", "(Landroid/webkit/PermissionRequest;)V", "lineNumber", "sourceID", "onConsoleMessage", "(Ljava/lang/String;ILjava/lang/String;)V", "Landroid/webkit/ConsoleMessage;", "consoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "onPermissionRequestCanceled", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "filePathCallback", "Landroid/webkit/WebChromeClient$FileChooserParams;", "fileChooserParams", "onShowFileChooser", "(Landroid/webkit/WebView;Landroid/webkit/ValueCallback;Landroid/webkit/WebChromeClient$FileChooserParams;)Z", "precomposed", "onReceivedTouchIconUrl", "(Landroid/webkit/WebView;Ljava/lang/String;Z)V", "Landroid/graphics/Bitmap;", "icon", "onReceivedIcon", "(Landroid/webkit/WebView;Landroid/graphics/Bitmap;)V", "databaseIdentifier", "", "quota", "estimatedDatabaseSize", "totalQuota", "Landroid/webkit/WebStorage$QuotaUpdater;", "quotaUpdater", "onExceededDatabaseQuota", "(Ljava/lang/String;Ljava/lang/String;JJJLandroid/webkit/WebStorage$QuotaUpdater;)V", "title", "onReceivedTitle", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "newProgress", "onProgressChanged", "(Landroid/webkit/WebView;I)V", "getVisitedHistory", "(Landroid/webkit/ValueCallback;)V", "getVideoLoadingProgressView", "()Landroid/view/View;", "onGeolocationPermissionsHidePrompt", "getDefaultVideoPoster", "()Landroid/graphics/Bitmap;", "isDialog", "isUserGesture", "Landroid/os/Message;", "resultMsg", "onCreateWindow", "(Landroid/webkit/WebView;ZZLandroid/os/Message;)Z", "onCreateWindowImpl", "(Landroid/webkit/WebView;Landroid/os/Message;)V", "window", "onCloseWindow", "onJsTimeout", "Lcom/kakaoent/trevi/ad/webview/helper/CustomViewHandler;", "customViewHandler", "Lcom/kakaoent/trevi/ad/webview/helper/CustomViewHandler;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "chainWebChromeClient", "Ljava/util/concurrent/CopyOnWriteArrayList;", "enabledTimerControl", "Z", "getEnabledTimerControl", "setEnabledTimerControl", "(Z)V", "Ljava/lang/ref/WeakReference;", "webViewRef", "Ljava/lang/ref/WeakReference;", "Companion", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class BaseWebChromeClient extends WebChromeClient {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/webkit/BaseWebChromeClient$Companion;", "", "()V", "TAG", "", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final CopyOnWriteArrayList chainWebChromeClient;
    @NotNull
    private final CustomViewHandler customViewHandler;
    private boolean enabledTimerControl;
    @Nullable
    private WeakReference webViewRef;

    static {
        BaseWebChromeClient.Companion = new Companion(null);
    }

    public BaseWebChromeClient() {
        this.customViewHandler = new CustomViewHandler();
        this.chainWebChromeClient = new CopyOnWriteArrayList();
        this.enabledTimerControl = true;
    }

    public static void a(WebViewVisibleCallback webViewVisibleCallback0, BaseWebChromeClient baseWebChromeClient0, WebView webView0, Message message0, DialogInterface dialogInterface0, int v) {
        BaseWebChromeClient.onCreateWindow$lambda$25(webViewVisibleCallback0, baseWebChromeClient0, webView0, message0, dialogInterface0, v);
    }

    public final void addWebChromeClient(@NotNull IWebChromeClient iWebChromeClient0) {
        q.g(iWebChromeClient0, "webChromeClient");
        this.chainWebChromeClient.add(iWebChromeClient0);
    }

    public final void clear() {
        this.chainWebChromeClient.clear();
    }

    @Override  // android.webkit.WebChromeClient
    @Nullable
    public Bitmap getDefaultVideoPoster() {
        for(Object object0: this.chainWebChromeClient) {
            Bitmap bitmap0 = ((IWebChromeClient)object0).getDefaultVideoPoster();
            if(bitmap0 != null) {
                return bitmap0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    @Override  // android.webkit.WebChromeClient
    @Nullable
    public View getVideoLoadingProgressView() {
        for(Object object0: this.chainWebChromeClient) {
            View view0 = ((IWebChromeClient)object0).getVideoLoadingProgressView();
            if(view0 != null) {
                return view0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    @Override  // android.webkit.WebChromeClient
    public void getVisitedHistory(@Nullable ValueCallback valueCallback0) {
        for(Object object0: this.chainWebChromeClient) {
            ((IWebChromeClient)object0).getVisitedHistory(valueCallback0);
        }
    }

    public final void hideCustomView() {
        this.customViewHandler.hideCustomView();
    }

    public final boolean isCustomViewShowing() {
        return this.customViewHandler.isCustomViewShowing();
    }

    public final void linkWebView(@NotNull WebView webView0) {
        q.g(webView0, "webView");
        this.webViewRef = new WeakReference(webView0);
    }

    @Override  // android.webkit.WebChromeClient
    public void onCloseWindow(@Nullable WebView webView0) {
        for(Object object0: this.chainWebChromeClient) {
            ((IWebChromeClient)object0).onCloseWindow(webView0);
        }
    }

    @Override  // android.webkit.WebChromeClient
    public void onConsoleMessage(@Nullable String s, int v, @Nullable String s1) {
        for(Object object0: this.chainWebChromeClient) {
            ((IWebChromeClient)object0).onConsoleMessage(s, v, s1);
        }
    }

    @Override  // android.webkit.WebChromeClient
    public boolean onConsoleMessage(@Nullable ConsoleMessage consoleMessage0) {
        for(Object object0: this.chainWebChromeClient) {
            if(((IWebChromeClient)object0).onConsoleMessage(consoleMessage0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    @Override  // android.webkit.WebChromeClient
    public boolean onCreateWindow(@Nullable WebView webView0, boolean z, boolean z1, @Nullable Message message0) {
        for(Object object0: this.chainWebChromeClient) {
            if(((IWebChromeClient)object0).onCreateWindow(webView0, z, z1, message0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        WebViewVisibleCallback webViewVisibleCallback0 = webView0 instanceof WebViewVisibleCallback ? ((WebViewVisibleCallback)webView0) : null;
        if(webViewVisibleCallback0 != null && (!this.enabledTimerControl || webViewVisibleCallback0.isForeground())) {
            if(z1) {
                this.onCreateWindowImpl(webView0, message0);
                return true;
            }
            d d0 = new d(webViewVisibleCallback0, this, webView0, message0);
            new AlertDialog.Builder(webView0.getContext()).setMessage(R.string.trevi_popup_window_attempt).setPositiveButton(R.string.trevi_webview_allow, d0).setNegativeButton(R.string.trevi_webview_block, d0).setCancelable(false).create().show();
            return true;
        }
        return false;
    }

    private static final void onCreateWindow$lambda$25(WebViewVisibleCallback webViewVisibleCallback0, BaseWebChromeClient baseWebChromeClient0, WebView webView0, Message message0, DialogInterface dialogInterface0, int v) {
        q.g(baseWebChromeClient0, "this$0");
        if(v == -1 && !webViewVisibleCallback0.isDestroyed()) {
            baseWebChromeClient0.onCreateWindowImpl(webView0, message0);
            return;
        }
        if(message0 != null) {
            message0.sendToTarget();
        }
    }

    public final void onCreateWindowImpl(@NotNull WebView webView0, @Nullable Message message0) {
        q.g(webView0, "view");
        WebView.WebViewTransport webView$WebViewTransport0 = null;
        Object object0 = message0 == null ? null : message0.obj;
        if(object0 instanceof WebView.WebViewTransport) {
            webView$WebViewTransport0 = (WebView.WebViewTransport)object0;
        }
        if(webView$WebViewTransport0 == null) {
            return;
        }
        webView$WebViewTransport0.setWebView(new WebView(webView0.getContext()));
        message0.sendToTarget();
    }

    @Override  // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(@Nullable String s, @Nullable String s1, long v, long v1, long v2, @Nullable WebStorage.QuotaUpdater webStorage$QuotaUpdater0) {
        for(Object object0: this.chainWebChromeClient) {
            ((IWebChromeClient)object0).onExceededDatabaseQuota(s, s1, v, v1, v2, webStorage$QuotaUpdater0);
        }
    }

    @Override  // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        for(Object object0: this.chainWebChromeClient) {
            ((IWebChromeClient)object0).onGeolocationPermissionsHidePrompt();
        }
    }

    @Override  // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(@Nullable String s, @Nullable GeolocationPermissions.Callback geolocationPermissions$Callback0) {
        for(Object object0: this.chainWebChromeClient) {
            ((IWebChromeClient)object0).onGeolocationPermissionsShowPrompt(s, geolocationPermissions$Callback0);
        }
    }

    @Override  // android.webkit.WebChromeClient
    public void onHideCustomView() {
        for(Object object0: this.chainWebChromeClient) {
            ((IWebChromeClient)object0).onHideCustomView();
        }
        this.customViewHandler.onHideCustomView();
    }

    @Override  // android.webkit.WebChromeClient
    public boolean onJsAlert(@Nullable WebView webView0, @Nullable String s, @Nullable String s1, @Nullable JsResult jsResult0) {
        TreviLog.INSTANCE.d("BaseWebChromeClient", "onJsAlert() message: " + s1 + ", url: " + s);
        for(Object object0: this.chainWebChromeClient) {
            if(((IWebChromeClient)object0).onJsAlert(webView0, s, s1, jsResult0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        TreviLog.INSTANCE.d("BaseWebChromeClient", "onJsAlert(client not handled): message: " + s1 + ", url: " + s);
        Context context0 = webView0 == null ? null : webView0.getContext();
        if(context0 == null) {
            return false;
        }
        Toast.makeText(context0, s1, 1).show();
        return false;
    }

    @Override  // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(@Nullable WebView webView0, @Nullable String s, @Nullable String s1, @Nullable JsResult jsResult0) {
        for(Object object0: this.chainWebChromeClient) {
            if(((IWebChromeClient)object0).onJsBeforeUnload(webView0, s, s1, jsResult0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        Context context0 = webView0 == null ? null : webView0.getContext();
        if(context0 == null) {
            return false;
        }
        Toast.makeText(context0, s1, 1).show();
        return true;
    }

    @Override  // android.webkit.WebChromeClient
    public boolean onJsConfirm(@Nullable WebView webView0, @Nullable String s, @Nullable String s1, @Nullable JsResult jsResult0) {
        TreviLog.INSTANCE.d("BaseWebChromeClient", "onJsConfirm() message: " + s1 + ", url: " + s);
        for(Object object0: this.chainWebChromeClient) {
            if(((IWebChromeClient)object0).onJsConfirm(webView0, s, s1, jsResult0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        TreviLog.INSTANCE.d("BaseWebChromeClient", "onJsConfirm(client not handled): message: " + s1 + ", url: " + s);
        Context context0 = webView0 == null ? null : webView0.getContext();
        if(context0 == null) {
            return false;
        }
        Toast.makeText(context0, s1, 1).show();
        return false;
    }

    @Override  // android.webkit.WebChromeClient
    public boolean onJsPrompt(@Nullable WebView webView0, @Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable JsPromptResult jsPromptResult0) {
        TreviLog.INSTANCE.d("BaseWebChromeClient", "onJsPrompt() message: " + s1 + ", url: " + s);
        for(Object object0: this.chainWebChromeClient) {
            if(((IWebChromeClient)object0).onJsPrompt(webView0, s, s1, s2, jsPromptResult0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        TreviLog.INSTANCE.d("BaseWebChromeClient", "onJsPrompt(client not handled): message: " + s1 + ", url: " + s);
        Context context0 = webView0 == null ? null : webView0.getContext();
        if(context0 == null) {
            return false;
        }
        Toast.makeText(context0, s1, 1).show();
        return true;
    }

    @Override  // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        for(Object object0: this.chainWebChromeClient) {
            if(((IWebChromeClient)object0).onJsTimeout()) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    @Override  // android.webkit.WebChromeClient
    public void onPermissionRequest(@Nullable PermissionRequest permissionRequest0) {
        if(permissionRequest0 != null) {
            String[] arr_s = permissionRequest0.getResources();
            if(arr_s != null) {
                for(int v = 0; v < arr_s.length; ++v) {
                    if("android.webkit.resource.PROTECTED_MEDIA_ID".equals(arr_s[v])) {
                        permissionRequest0.grant(arr_s);
                        return;
                    }
                }
            }
        }
        for(Object object0: this.chainWebChromeClient) {
            ((IWebChromeClient)object0).onPermissionRequest(permissionRequest0);
        }
    }

    @Override  // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(@Nullable PermissionRequest permissionRequest0) {
        for(Object object0: this.chainWebChromeClient) {
            ((IWebChromeClient)object0).onPermissionRequestCanceled(permissionRequest0);
        }
    }

    @Override  // android.webkit.WebChromeClient
    public void onProgressChanged(@Nullable WebView webView0, int v) {
        for(Object object0: this.chainWebChromeClient) {
            ((IWebChromeClient)object0).onProgressChanged(webView0, v);
        }
    }

    @Override  // android.webkit.WebChromeClient
    public void onReceivedIcon(@Nullable WebView webView0, @Nullable Bitmap bitmap0) {
        for(Object object0: this.chainWebChromeClient) {
            ((IWebChromeClient)object0).onReceivedIcon(webView0, bitmap0);
        }
    }

    @Override  // android.webkit.WebChromeClient
    public void onReceivedTitle(@Nullable WebView webView0, @Nullable String s) {
        for(Object object0: this.chainWebChromeClient) {
            ((IWebChromeClient)object0).onReceivedTitle(webView0, s);
        }
    }

    @Override  // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(@Nullable WebView webView0, @Nullable String s, boolean z) {
        for(Object object0: this.chainWebChromeClient) {
            ((IWebChromeClient)object0).onReceivedTouchIconUrl(webView0, s, z);
        }
    }

    @Override  // android.webkit.WebChromeClient
    public void onRequestFocus(@Nullable WebView webView0) {
        for(Object object0: this.chainWebChromeClient) {
            ((IWebChromeClient)object0).onRequestFocus(webView0);
        }
    }

    @Override  // android.webkit.WebChromeClient
    public void onShowCustomView(@Nullable View view0, int v, @Nullable WebChromeClient.CustomViewCallback webChromeClient$CustomViewCallback0) {
        Activity activity0;
        for(Object object0: this.chainWebChromeClient) {
            ((IWebChromeClient)object0).onShowCustomView(view0, v, webChromeClient$CustomViewCallback0);
        }
        WeakReference weakReference0 = this.webViewRef;
        if(weakReference0 != null) {
            Object object1 = weakReference0.get();
            if(((WebView)object1) != null && (!(((WebView)object1) instanceof WebViewVisibleCallback) || ((WebViewVisibleCallback)(((WebView)object1))).isForeground())) {
                Context context0 = ((WebView)object1).getContext();
                if(context0 != null) {
                    if(context0 instanceof Activity) {
                        activity0 = (Activity)context0;
                    }
                    else {
                        Context context1 = ((ContextWrapper)context0).getBaseContext();
                        activity0 = context1 instanceof Activity ? ((Activity)context1) : null;
                    }
                    ViewParent viewParent0 = ((WebView)object1).getParent();
                    q.e(viewParent0, "null cannot be cast to non-null type android.view.ViewGroup");
                    this.customViewHandler.onShowCustomView(activity0, ((ViewGroup)viewParent0), ((WebView)object1), view0, webChromeClient$CustomViewCallback0);
                }
            }
        }
    }

    @Override  // android.webkit.WebChromeClient
    public void onShowCustomView(@Nullable View view0, @Nullable WebChromeClient.CustomViewCallback webChromeClient$CustomViewCallback0) {
        for(Object object0: this.chainWebChromeClient) {
            ((IWebChromeClient)object0).onShowCustomView(view0, webChromeClient$CustomViewCallback0);
        }
        this.onShowCustomView(view0, 4, webChromeClient$CustomViewCallback0);
    }

    @Override  // android.webkit.WebChromeClient
    public boolean onShowFileChooser(@Nullable WebView webView0, @Nullable ValueCallback valueCallback0, @Nullable WebChromeClient.FileChooserParams webChromeClient$FileChooserParams0) {
        for(Object object0: this.chainWebChromeClient) {
            if(((IWebChromeClient)object0).onShowFileChooser(webView0, valueCallback0, webChromeClient$FileChooserParams0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public final void setEnabledTimerControl(boolean z) {
        this.enabledTimerControl = z;
    }
}

