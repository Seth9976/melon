package com.kakaoent.trevi.ad.webview.webkit;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings;
import android.webkit.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\'\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001D\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001A\u00020\u000F2\b\u0010\u0014\u001A\u0004\u0018\u00010\u000B¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001A\u00020\u000F2\b\u0010\u0014\u001A\u0004\u0018\u00010\u000B¢\u0006\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0019\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/webkit/AppWebViewSettingsUtils;", "", "<init>", "()V", "Landroid/webkit/WebSettings;", "s", "", "buildUserAgent", "(Landroid/webkit/WebSettings;)Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/webkit/WebView;", "webView", "", "textZoom", "Lie/H;", "expandWebViewSettings", "(Landroid/content/Context;Landroid/webkit/WebView;I)V", "defaultWebViewSetting", "(Landroid/content/Context;Landroid/webkit/WebView;)V", "view", "resumeTimers", "(Landroid/webkit/WebView;)V", "pauseTimers", "", "timersResumed", "Z", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class AppWebViewSettingsUtils {
    @NotNull
    public static final AppWebViewSettingsUtils INSTANCE;
    private static boolean timersResumed;

    static {
        AppWebViewSettingsUtils.INSTANCE = new AppWebViewSettingsUtils();
    }

    private final String buildUserAgent(WebSettings webSettings0) {
        String s = webSettings0.getUserAgentString() + " trevi";
        q.f(s, "toString(...)");
        return s;
    }

    public final void defaultWebViewSetting(@NotNull Context context0, @NotNull WebView webView0) {
        q.g(context0, "context");
        q.g(webView0, "webView");
        WebSettings webSettings0 = webView0.getSettings();
        q.f(webSettings0, "getSettings(...)");
        webSettings0.setAllowContentAccess(false);
        webSettings0.setAllowFileAccess(true);
        PackageManager packageManager0 = context0.getPackageManager();
        int v = packageManager0.hasSystemFeature("android.hardware.touchscreen.multitouch") || packageManager0.hasSystemFeature("android.hardware.faketouch.multitouch.distinct") ? 1 : 0;
        try {
            webSettings0.setDisplayZoomControls(((boolean)(v ^ 1)));
        }
        catch(NullPointerException unused_ex) {
        }
        webSettings0.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings0.setLightTouchEnabled(false);
        webSettings0.setLoadWithOverviewMode(true);
        webSettings0.setLoadsImagesAutomatically(true);
        webSettings0.setNeedInitialFocus(false);
        webSettings0.setSupportMultipleWindows(true);
        webSettings0.setUserAgentString(this.buildUserAgent(webSettings0));
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(19)
    public final void expandWebViewSettings(@NotNull Context context0, @NotNull WebView webView0, int v) {
        q.g(context0, "context");
        q.g(webView0, "webView");
        WebSettings webSettings0 = webView0.getSettings();
        q.f(webSettings0, "getSettings(...)");
        webSettings0.setBuiltInZoomControls(true);
        webSettings0.setDatabaseEnabled(true);
        webSettings0.setDefaultFixedFontSize(13);
        webSettings0.setDefaultFontSize(16);
        webSettings0.setDefaultTextEncodingName("EUC-KR");
        webSettings0.setMinimumFontSize(8);
        webSettings0.setMinimumLogicalFontSize(8);
        webSettings0.setTextZoom(v);
        webSettings0.setDomStorageEnabled(true);
        webSettings0.setJavaScriptEnabled(true);
        webSettings0.setJavaScriptCanOpenWindowsAutomatically(false);
        webSettings0.setUseWideViewPort(true);
    }

    public final void pauseTimers(@Nullable WebView webView0) {
        if(AppWebViewSettingsUtils.timersResumed && webView0 != null) {
            webView0.pauseTimers();
            AppWebViewSettingsUtils.timersResumed = false;
        }
    }

    public final void resumeTimers(@Nullable WebView webView0) {
        if(!AppWebViewSettingsUtils.timersResumed && webView0 != null) {
            webView0.resumeTimers();
            AppWebViewSettingsUtils.timersResumed = true;
        }
    }
}

