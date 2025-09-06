package com.kakaoent.trevi.ad.webview.webkit;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import ie.d;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009A\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b`\u0018\u00002\u00020\u0001J!\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&\u00A2\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000B\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\n\u001A\u0004\u0018\u00010\tH&\u00A2\u0006\u0004\b\u000B\u0010\fJ#\u0010\u000F\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u000E\u001A\u0004\u0018\u00010\rH&\u00A2\u0006\u0004\b\u000F\u0010\u0010J+\u0010\u0014\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0011\u001A\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001A\u00020\u0012H\'\u00A2\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0019\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00162\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\'\u00A2\u0006\u0004\b\u0019\u0010\u001AJ+\u0010\u0019\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00162\u0006\u0010\u001B\u001A\u00020\u00042\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\'\u00A2\u0006\u0004\b\u0019\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u0006H\'\u00A2\u0006\u0004\b\u001D\u0010\u001EJ3\u0010#\u001A\u00020\u00122\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u001F\u001A\u00020\u00122\u0006\u0010 \u001A\u00020\u00122\b\u0010\"\u001A\u0004\u0018\u00010!H&\u00A2\u0006\u0004\b#\u0010$J\u0019\u0010%\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H&\u00A2\u0006\u0004\b%\u0010&J\u0019\u0010(\u001A\u00020\u00062\b\u0010\'\u001A\u0004\u0018\u00010\u0002H&\u00A2\u0006\u0004\b(\u0010&J7\u0010,\u001A\u00020\u00122\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0011\u001A\u0004\u0018\u00010\t2\b\u0010)\u001A\u0004\u0018\u00010\t2\b\u0010+\u001A\u0004\u0018\u00010*H&\u00A2\u0006\u0004\b,\u0010-J7\u0010.\u001A\u00020\u00122\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0011\u001A\u0004\u0018\u00010\t2\b\u0010)\u001A\u0004\u0018\u00010\t2\b\u0010+\u001A\u0004\u0018\u00010*H&\u00A2\u0006\u0004\b.\u0010-JA\u00101\u001A\u00020\u00122\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0011\u001A\u0004\u0018\u00010\t2\b\u0010)\u001A\u0004\u0018\u00010\t2\b\u0010/\u001A\u0004\u0018\u00010\t2\b\u0010+\u001A\u0004\u0018\u000100H&\u00A2\u0006\u0004\b1\u00102J7\u00103\u001A\u00020\u00122\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0011\u001A\u0004\u0018\u00010\t2\b\u0010)\u001A\u0004\u0018\u00010\t2\b\u0010+\u001A\u0004\u0018\u00010*H&\u00A2\u0006\u0004\b3\u0010-JE\u0010;\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\t2\b\u00104\u001A\u0004\u0018\u00010\t2\u0006\u00106\u001A\u0002052\u0006\u00107\u001A\u0002052\u0006\u00108\u001A\u0002052\b\u0010:\u001A\u0004\u0018\u000109H\'\u00A2\u0006\u0004\b;\u0010<J#\u0010?\u001A\u00020\u00062\b\u0010=\u001A\u0004\u0018\u00010\t2\b\u0010\u0018\u001A\u0004\u0018\u00010>H\'\u00A2\u0006\u0004\b?\u0010@J\u000F\u0010A\u001A\u00020\u0006H\'\u00A2\u0006\u0004\bA\u0010\u001EJ\u0019\u0010D\u001A\u00020\u00062\b\u0010C\u001A\u0004\u0018\u00010BH\'\u00A2\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001A\u00020\u00062\b\u0010C\u001A\u0004\u0018\u00010BH\'\u00A2\u0006\u0004\bF\u0010EJ\u000F\u0010G\u001A\u00020\u0012H\'\u00A2\u0006\u0004\bG\u0010HJ+\u0010K\u001A\u00020\u00062\b\u0010)\u001A\u0004\u0018\u00010\t2\u0006\u0010I\u001A\u00020\u00042\b\u0010J\u001A\u0004\u0018\u00010\tH\'\u00A2\u0006\u0004\bK\u0010LJ\u0019\u0010K\u001A\u00020\u00122\b\u0010N\u001A\u0004\u0018\u00010MH\'\u00A2\u0006\u0004\bK\u0010OJ%\u0010R\u001A\u00020\u00062\u0014\u0010\u0018\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0Q\u0018\u00010PH\'\u00A2\u0006\u0004\bR\u0010SJ9\u0010Y\u001A\u00020\u00122\b\u0010T\u001A\u0004\u0018\u00010\u00022\u0014\u0010V\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0Q\u0018\u00010P2\b\u0010X\u001A\u0004\u0018\u00010WH\'\u00A2\u0006\u0004\bY\u0010ZR\u0016\u0010]\u001A\u0004\u0018\u00010\r8gX\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b[\u0010\\R\u0016\u0010`\u001A\u0004\u0018\u00010\u00168gX\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b^\u0010_\u00A8\u0006a"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/webkit/IWebChromeClient;", "", "Landroid/webkit/WebView;", "view", "", "newProgress", "Lie/H;", "onProgressChanged", "(Landroid/webkit/WebView;I)V", "", "title", "onReceivedTitle", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "Landroid/graphics/Bitmap;", "icon", "onReceivedIcon", "(Landroid/webkit/WebView;Landroid/graphics/Bitmap;)V", "url", "", "precomposed", "onReceivedTouchIconUrl", "(Landroid/webkit/WebView;Ljava/lang/String;Z)V", "Landroid/view/View;", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "callback", "onShowCustomView", "(Landroid/view/View;Landroid/webkit/WebChromeClient$CustomViewCallback;)V", "requestedOrientation", "(Landroid/view/View;ILandroid/webkit/WebChromeClient$CustomViewCallback;)V", "onHideCustomView", "()V", "isDialog", "isUserGesture", "Landroid/os/Message;", "resultMsg", "onCreateWindow", "(Landroid/webkit/WebView;ZZLandroid/os/Message;)Z", "onRequestFocus", "(Landroid/webkit/WebView;)V", "window", "onCloseWindow", "message", "Landroid/webkit/JsResult;", "result", "onJsAlert", "(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/JsResult;)Z", "onJsConfirm", "defaultValue", "Landroid/webkit/JsPromptResult;", "onJsPrompt", "(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/JsPromptResult;)Z", "onJsBeforeUnload", "databaseIdentifier", "", "quota", "estimatedDatabaseSize", "totalQuota", "Landroid/webkit/WebStorage$QuotaUpdater;", "quotaUpdater", "onExceededDatabaseQuota", "(Ljava/lang/String;Ljava/lang/String;JJJLandroid/webkit/WebStorage$QuotaUpdater;)V", "origin", "Landroid/webkit/GeolocationPermissions$Callback;", "onGeolocationPermissionsShowPrompt", "(Ljava/lang/String;Landroid/webkit/GeolocationPermissions$Callback;)V", "onGeolocationPermissionsHidePrompt", "Landroid/webkit/PermissionRequest;", "request", "onPermissionRequest", "(Landroid/webkit/PermissionRequest;)V", "onPermissionRequestCanceled", "onJsTimeout", "()Z", "lineNumber", "sourceID", "onConsoleMessage", "(Ljava/lang/String;ILjava/lang/String;)V", "Landroid/webkit/ConsoleMessage;", "consoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "Landroid/webkit/ValueCallback;", "", "getVisitedHistory", "(Landroid/webkit/ValueCallback;)V", "webView", "Landroid/net/Uri;", "filePathCallback", "Landroid/webkit/WebChromeClient$FileChooserParams;", "fileChooserParams", "onShowFileChooser", "(Landroid/webkit/WebView;Landroid/webkit/ValueCallback;Landroid/webkit/WebChromeClient$FileChooserParams;)Z", "getDefaultVideoPoster", "()Landroid/graphics/Bitmap;", "defaultVideoPoster", "getVideoLoadingProgressView", "()Landroid/view/View;", "videoLoadingProgressView", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface IWebChromeClient {
    @TargetApi(7)
    @Nullable
    Bitmap getDefaultVideoPoster();

    @TargetApi(7)
    @Nullable
    View getVideoLoadingProgressView();

    @TargetApi(7)
    void getVisitedHistory(@Nullable ValueCallback arg1);

    void onCloseWindow(@Nullable WebView arg1);

    @TargetApi(7)
    @d
    void onConsoleMessage(@Nullable String arg1, int arg2, @Nullable String arg3);

    @TargetApi(8)
    boolean onConsoleMessage(@Nullable ConsoleMessage arg1);

    boolean onCreateWindow(@Nullable WebView arg1, boolean arg2, boolean arg3, @Nullable Message arg4);

    @TargetApi(5)
    @d
    void onExceededDatabaseQuota(@Nullable String arg1, @Nullable String arg2, long arg3, long arg4, long arg5, @Nullable WebStorage.QuotaUpdater arg6);

    @TargetApi(5)
    void onGeolocationPermissionsHidePrompt();

    @TargetApi(5)
    void onGeolocationPermissionsShowPrompt(@Nullable String arg1, @Nullable GeolocationPermissions.Callback arg2);

    @TargetApi(7)
    void onHideCustomView();

    boolean onJsAlert(@Nullable WebView arg1, @Nullable String arg2, @Nullable String arg3, @Nullable JsResult arg4);

    boolean onJsBeforeUnload(@Nullable WebView arg1, @Nullable String arg2, @Nullable String arg3, @Nullable JsResult arg4);

    boolean onJsConfirm(@Nullable WebView arg1, @Nullable String arg2, @Nullable String arg3, @Nullable JsResult arg4);

    boolean onJsPrompt(@Nullable WebView arg1, @Nullable String arg2, @Nullable String arg3, @Nullable String arg4, @Nullable JsPromptResult arg5);

    @TargetApi(7)
    @d
    boolean onJsTimeout();

    @TargetApi(21)
    void onPermissionRequest(@Nullable PermissionRequest arg1);

    @TargetApi(21)
    void onPermissionRequestCanceled(@Nullable PermissionRequest arg1);

    void onProgressChanged(@Nullable WebView arg1, int arg2);

    void onReceivedIcon(@Nullable WebView arg1, @Nullable Bitmap arg2);

    void onReceivedTitle(@Nullable WebView arg1, @Nullable String arg2);

    @TargetApi(7)
    void onReceivedTouchIconUrl(@Nullable WebView arg1, @Nullable String arg2, boolean arg3);

    void onRequestFocus(@Nullable WebView arg1);

    @TargetApi(14)
    @d
    void onShowCustomView(@Nullable View arg1, int arg2, @Nullable WebChromeClient.CustomViewCallback arg3);

    @TargetApi(7)
    void onShowCustomView(@Nullable View arg1, @Nullable WebChromeClient.CustomViewCallback arg2);

    @TargetApi(21)
    boolean onShowFileChooser(@Nullable WebView arg1, @Nullable ValueCallback arg2, @Nullable WebChromeClient.FileChooserParams arg3);
}

