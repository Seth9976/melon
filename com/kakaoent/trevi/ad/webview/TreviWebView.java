package com.kakaoent.trevi.ad.webview;

import A3.l;
import P1.c;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import androidx.lifecycle.t;
import com.kakaoent.trevi.ad.R.color;
import com.kakaoent.trevi.ad.webview.webkit.AppWebViewSettingsUtils;
import com.kakaoent.trevi.ad.webview.webkit.BaseWebChromeClient;
import com.kakaoent.trevi.ad.webview.webkit.BaseWebViewClient;
import com.kakaoent.trevi.ad.webview.webkit.IWebChromeClient;
import com.kakaoent.trevi.ad.webview.webkit.IWebViewClient;
import com.kakaoent.trevi.ad.webview.webkit.WebViewLifecycleObserver;
import com.kakaoent.trevi.ad.webview.webkit.WebViewVisibleCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u00015B\u001D\b\u0007\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\f\u0010\u000BJ\'\u0010\u0012\u001A\u00020\t2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0017\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u0017\u0010\u000BJ\u000F\u0010\u0018\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u000BJ\u000F\u0010\u0019\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001B\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001AJ\u000F\u0010\u001C\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u000BJ\r\u0010\u001D\u001A\u00020\u000F\u00A2\u0006\u0004\b\u001D\u0010\u001AJ\u0015\u0010 \u001A\u00020\t2\u0006\u0010\u001F\u001A\u00020\u001E\u00A2\u0006\u0004\b \u0010!J\u0015\u0010$\u001A\u00020\t2\u0006\u0010#\u001A\u00020\"\u00A2\u0006\u0004\b$\u0010%J\u000F\u0010&\u001A\u00020\tH\u0014\u00A2\u0006\u0004\b&\u0010\u000BR\u0014\u0010(\u001A\u00020\'8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001A\u00020*8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001A\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001A\u0002008\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b3\u00104\u00A8\u00066"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/TreviWebView;", "Landroid/webkit/WebView;", "Lcom/kakaoent/trevi/ad/webview/webkit/WebViewVisibleCallback;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lie/H;", "destroyAppWebView", "()V", "postDestroy", "Landroidx/lifecycle/t;", "lifecycle", "", "enabledTimerControl", "isWebContentsDebuggingEnabled", "initializeWebView", "(Landroidx/lifecycle/t;ZZ)V", "isDarkMode", "setWebViewBackgroundColor", "(Z)V", "onResume", "onPause", "isForeground", "()Z", "isDestroyed", "destroyWebView", "onBackPressed", "Lcom/kakaoent/trevi/ad/webview/webkit/IWebViewClient;", "iWebViewClient", "addWebViewClient", "(Lcom/kakaoent/trevi/ad/webview/webkit/IWebViewClient;)V", "Lcom/kakaoent/trevi/ad/webview/webkit/IWebChromeClient;", "iWebChromeClient", "addWebChromeClient", "(Lcom/kakaoent/trevi/ad/webview/webkit/IWebChromeClient;)V", "onDetachedFromWindow", "Lcom/kakaoent/trevi/ad/webview/webkit/BaseWebViewClient;", "baseWebViewClient", "Lcom/kakaoent/trevi/ad/webview/webkit/BaseWebViewClient;", "Lcom/kakaoent/trevi/ad/webview/webkit/BaseWebChromeClient;", "baseWebChromeClient", "Lcom/kakaoent/trevi/ad/webview/webkit/BaseWebChromeClient;", "", "webViewId", "Ljava/lang/String;", "Lcom/kakaoent/trevi/ad/webview/TreviWebView$Status;", "status", "Lcom/kakaoent/trevi/ad/webview/TreviWebView$Status;", "destroyWhenDetach", "Z", "Status", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class TreviWebView extends WebView implements WebViewVisibleCallback {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/TreviWebView$Status;", "", "(Ljava/lang/String;I)V", "INITIAL", "RESUMED", "PAUSED", "DESTROYED", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    static enum Status {
        INITIAL,
        RESUMED,
        PAUSED,
        DESTROYED;

        private static final a $ENTRIES;
        private static final Status[] $VALUES;

        private static final Status[] $values() [...] // Inlined contents

        static {
            Status.$VALUES = arr_treviWebView$Status;
            q.g(arr_treviWebView$Status, "entries");
            Status.$ENTRIES = new b(arr_treviWebView$Status);
        }
    }

    @NotNull
    private final BaseWebChromeClient baseWebChromeClient;
    @NotNull
    private final BaseWebViewClient baseWebViewClient;
    private boolean destroyWhenDetach;
    @NotNull
    private Status status;
    @Nullable
    private String webViewId;

    public TreviWebView(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 2, null);
    }

    public TreviWebView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        super(context0, attributeSet0);
        this.baseWebViewClient = new BaseWebViewClient();
        this.baseWebChromeClient = new BaseWebChromeClient();
        this.status = Status.INITIAL;
    }

    public TreviWebView(Context context0, AttributeSet attributeSet0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0);
    }

    public final void addWebChromeClient(@NotNull IWebChromeClient iWebChromeClient0) {
        q.g(iWebChromeClient0, "iWebChromeClient");
        this.baseWebChromeClient.addWebChromeClient(iWebChromeClient0);
    }

    public final void addWebViewClient(@NotNull IWebViewClient iWebViewClient0) {
        q.g(iWebViewClient0, "iWebViewClient");
        this.baseWebViewClient.addWebViewClient(iWebViewClient0);
    }

    private final void destroyAppWebView() {
        this.destroyWhenDetach = false;
        this.removeAllViews();
        this.setOnCreateContextMenuListener(null);
        this.postDestroy();
        this.status = Status.DESTROYED;
        this.baseWebViewClient.clear();
        this.baseWebChromeClient.clear();
        this.setDownloadListener(null);
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.WebViewVisibleCallback
    public void destroyWebView() {
        if(this.getParent() != null && this.isAttachedToWindow()) {
            this.destroyWhenDetach = true;
            return;
        }
        this.destroyAppWebView();
    }

    public final void initializeWebView(@NotNull t t0, boolean z, boolean z1) {
        q.g(t0, "lifecycle");
        this.setScrollBarStyle(0x2000000);
        this.setScrollbarFadingEnabled(true);
        this.webViewId = "3e55c963-8a8e-49d1-bb1f-c9a2e5431c79";
        if(z1) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        Context context0 = this.getContext();
        q.f(context0, "getContext(...)");
        AppWebViewSettingsUtils.INSTANCE.defaultWebViewSetting(context0, this);
        if(z) {
            t0.a(new WebViewLifecycleObserver(this));
        }
        this.baseWebViewClient.linkWebChromeClient(this.baseWebChromeClient);
        this.baseWebChromeClient.linkWebView(this);
        this.baseWebChromeClient.setEnabledTimerControl(z);
        this.setWebViewClient(this.baseWebViewClient);
        this.setWebChromeClient(this.baseWebChromeClient);
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.WebViewVisibleCallback
    public boolean isDestroyed() {
        return this.status == Status.DESTROYED;
    }

    @Override  // com.kakaoent.trevi.ad.webview.webkit.WebViewVisibleCallback
    public boolean isForeground() {
        return this.status == Status.RESUMED;
    }

    public final boolean onBackPressed() {
        if(this.baseWebChromeClient.isCustomViewShowing()) {
            this.baseWebChromeClient.hideCustomView();
            return true;
        }
        if(this.isDestroyed()) {
            return false;
        }
        if(this.canGoBack()) {
            this.goBack();
            return true;
        }
        return false;
    }

    @Override  // android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(this.destroyWhenDetach) {
            this.destroyAppWebView();
        }
    }

    @Override  // android.webkit.WebView
    public void onPause() {
        super.onPause();
        this.status = Status.PAUSED;
    }

    @Override  // android.webkit.WebView
    public void onResume() {
        super.onResume();
        this.status = Status.RESUMED;
    }

    private final void postDestroy() {
        this.setWebChromeClient(null);
        this.post(new l(this, 11));
    }

    private static final void postDestroy$lambda$0(TreviWebView treviWebView0) {
        q.g(treviWebView0, "this$0");
        treviWebView0.destroy();
    }

    public final void setWebViewBackgroundColor(boolean z) {
        this.setBackgroundColor(c.getColor(this.getContext(), (z ? R.color.trevi_dark_mode_background_color : R.color.trevi_light_mode_background_color)));
    }
}

