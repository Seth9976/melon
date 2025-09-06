package com.kakaoent.trevi.ad.webview.helper;

import B0.s;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import c2.h0;
import com.google.android.material.internal.F;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ=\u0010\u0014\u001A\u00020\u00042\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\b\u0010\r\u001A\u0004\u0018\u00010\f2\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001A\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0003J\r\u0010\u0017\u001A\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0003R\u0018\u0010\u0019\u001A\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u0018\u0010\u001B\u001A\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u0018\u0010\u001D\u001A\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0018\u0010\u000F\u001A\u0004\u0018\u00010\u000E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000F\u0010\u001FR\u0018\u0010\r\u001A\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\r\u0010 R\u0018\u0010\u000B\u001A\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000B\u0010!R\u0016\u0010#\u001A\u00020\"8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b#\u0010$R\u0011\u0010%\u001A\u00020\u00068F¢\u0006\u0006\u001A\u0004\b%\u0010&¨\u0006\'"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/helper/CustomViewHandler;", "", "<init>", "()V", "Lie/H;", "clearCustomViewCallback", "", "enabled", "setFullscreen", "(Z)V", "Landroid/app/Activity;", "activity", "Landroid/view/ViewGroup;", "container", "Landroid/webkit/WebView;", "webView", "Landroid/view/View;", "view", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "callback", "onShowCustomView", "(Landroid/app/Activity;Landroid/view/ViewGroup;Landroid/webkit/WebView;Landroid/view/View;Landroid/webkit/WebChromeClient$CustomViewCallback;)V", "onHideCustomView", "hideCustomView", "Lcom/kakaoent/trevi/ad/webview/helper/FullscreenHolder;", "fullscreenHolder", "Lcom/kakaoent/trevi/ad/webview/helper/FullscreenHolder;", "customViewCallback", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "customView", "Landroid/view/View;", "Landroid/webkit/WebView;", "Landroid/view/ViewGroup;", "Landroid/app/Activity;", "", "originalOrientation", "I", "isCustomViewShowing", "()Z", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class CustomViewHandler {
    @Nullable
    private Activity activity;
    @Nullable
    private ViewGroup container;
    @Nullable
    private View customView;
    @Nullable
    private WebChromeClient.CustomViewCallback customViewCallback;
    @Nullable
    private FullscreenHolder fullscreenHolder;
    private int originalOrientation;
    @Nullable
    private WebView webView;

    private final void clearCustomViewCallback() {
        try {
            WebChromeClient.CustomViewCallback webChromeClient$CustomViewCallback0 = this.customViewCallback;
            if(webChromeClient$CustomViewCallback0 != null) {
                webChromeClient$CustomViewCallback0.onCustomViewHidden();
            }
        }
        catch(IllegalArgumentException | NullPointerException unused_ex) {
        }
        this.customViewCallback = null;
    }

    public final void hideCustomView() {
        this.clearCustomViewCallback();
    }

    public final boolean isCustomViewShowing() {
        return this.customView != null;
    }

    public final void onHideCustomView() {
        Activity activity0 = this.activity;
        if(activity0 != null) {
            WebView webView0 = this.webView;
            if(webView0 != null) {
                webView0.setVisibility(0);
                activity0.getWindow().clearFlags(0x80);
                activity0.setRequestedOrientation(this.originalOrientation);
                if(this.customView != null) {
                    webView0.loadUrl("javascript:setSize(\'99.9%\', \'100%\')");
                    this.setFullscreen(false);
                    View view0 = activity0.getWindow().getDecorView();
                    q.e(view0, "null cannot be cast to non-null type android.widget.FrameLayout");
                    ((FrameLayout)view0).removeView(this.fullscreenHolder);
                    FullscreenHolder fullscreenHolder0 = this.fullscreenHolder;
                    if(fullscreenHolder0 != null) {
                        fullscreenHolder0.removeView(this.customView);
                    }
                    this.fullscreenHolder = null;
                    this.customView = null;
                    this.container = null;
                    this.webView = null;
                    this.activity = null;
                }
            }
        }
    }

    public final void onShowCustomView(@Nullable Activity activity0, @Nullable ViewGroup viewGroup0, @NotNull WebView webView0, @Nullable View view0, @Nullable WebChromeClient.CustomViewCallback webChromeClient$CustomViewCallback0) {
        q.g(webView0, "webView");
        if(activity0 != null) {
            if(!this.isCustomViewShowing()) {
                goto label_7;
            }
            WebChromeClient.CustomViewCallback webChromeClient$CustomViewCallback1 = this.customViewCallback;
            if(webChromeClient$CustomViewCallback1 != null) {
                webChromeClient$CustomViewCallback1.onCustomViewHidden();
                return;
            label_7:
                this.activity = activity0;
                this.container = viewGroup0;
                this.webView = webView0;
                webView0.loadUrl("javascript:setSize(\'99.9%\', \'100%\')");
                activity0.getWindow().addFlags(0x80);
                this.originalOrientation = activity0.getRequestedOrientation();
                activity0.setRequestedOrientation(0);
                View view1 = activity0.getWindow().getDecorView();
                q.e(view1, "null cannot be cast to non-null type android.widget.FrameLayout");
                FullscreenHolder fullscreenHolder0 = new FullscreenHolder(activity0);
                FrameLayout.LayoutParams frameLayout$LayoutParams0 = new FrameLayout.LayoutParams(-1, -1);
                fullscreenHolder0.addView(view0, frameLayout$LayoutParams0);
                ((FrameLayout)view1).addView(fullscreenHolder0, frameLayout$LayoutParams0);
                this.fullscreenHolder = fullscreenHolder0;
                this.customView = view0;
                webView0.setVisibility(4);
                this.setFullscreen(true);
                this.customViewCallback = webChromeClient$CustomViewCallback0;
            }
        }
    }

    private final void setFullscreen(boolean z) {
        Activity activity0 = this.activity;
        if(activity0 != null) {
            Window window0 = activity0.getWindow();
            if(z) {
                if(Build.VERSION.SDK_INT < 30) {
                    window0.setFlags(0x400, 0x400);
                    window0.getDecorView().setSystemUiVisibility(0x1706);
                    window0.addFlags(0x8000000);
                    return;
                }
                s.q(window0);
                WindowInsetsController windowInsetsController0 = window0.getInsetsController();
                if(windowInsetsController0 != null) {
                    windowInsetsController0.hide(h0.b() | h0.s());
                    h0.u(windowInsetsController0);
                }
            }
            else {
                if(Build.VERSION.SDK_INT < 30) {
                    window0.clearFlags(0x400);
                    window0.getDecorView().setSystemUiVisibility(0);
                    window0.clearFlags(0x8000000);
                    return;
                }
                F.v(window0);
                WindowInsetsController windowInsetsController1 = window0.getInsetsController();
                if(windowInsetsController1 != null) {
                    windowInsetsController1.show(h0.b() | h0.s());
                }
            }
        }
    }
}

