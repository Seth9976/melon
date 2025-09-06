package com.kakaoent.trevi.ad.webview.webkit;

import android.webkit.WebView;
import androidx.lifecycle.D;
import androidx.lifecycle.f;
import com.kakaoent.trevi.ad.util.TreviLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000B\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u000B\u0010\nJ\u0017\u0010\f\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\nR\u0018\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0003\u0010\r¨\u0006\u000F"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/webkit/WebViewLifecycleObserver;", "Landroidx/lifecycle/f;", "Landroid/webkit/WebView;", "webView", "<init>", "(Landroid/webkit/WebView;)V", "Landroidx/lifecycle/D;", "owner", "Lie/H;", "onResume", "(Landroidx/lifecycle/D;)V", "onPause", "onDestroy", "Landroid/webkit/WebView;", "Companion", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class WebViewLifecycleObserver implements f {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/webkit/WebViewLifecycleObserver$Companion;", "", "()V", "TAG", "", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion;
    @Nullable
    private WebView webView;

    static {
        WebViewLifecycleObserver.Companion = new Companion(null);
    }

    public WebViewLifecycleObserver(@Nullable WebView webView0) {
        this.webView = webView0;
    }

    @Override  // androidx.lifecycle.f
    public void onDestroy(@NotNull D d0) {
        q.g(d0, "owner");
        WebViewVisibleCallback webViewVisibleCallback0 = this.webView instanceof WebViewVisibleCallback ? ((WebViewVisibleCallback)this.webView) : null;
        if(webViewVisibleCallback0 != null) {
            webViewVisibleCallback0.destroyWebView();
        }
        this.webView = null;
        d0.getLifecycle().c(this);
    }

    @Override  // androidx.lifecycle.f
    public void onPause(@NotNull D d0) {
        q.g(d0, "owner");
        try {
            WebView webView0 = this.webView;
            if(webView0 != null) {
                webView0.onPause();
                AppWebViewSettingsUtils.INSTANCE.pauseTimers(this.webView);
            }
        }
        catch(Exception exception0) {
            TreviLog.INSTANCE.e("WebViewLifecycleObserver", "onPause error", exception0);
        }
    }

    @Override  // androidx.lifecycle.f
    public void onResume(@NotNull D d0) {
        q.g(d0, "owner");
        WebView webView0 = this.webView;
        if(webView0 != null) {
            webView0.onResume();
        }
        AppWebViewSettingsUtils.INSTANCE.resumeTimers(this.webView);
    }
}

