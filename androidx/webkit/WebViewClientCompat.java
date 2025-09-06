package androidx.webkit;

import T4.b;
import T4.d;
import T4.k;
import T4.l;
import W.p;
import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import d5.c;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;
import org.chromium.support_lib_boundary.WebResourceErrorBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewClientBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
import x1.a;

public abstract class WebViewClientCompat extends WebViewClient implements WebViewClientBoundaryInterface {
    public static final String[] a;

    static {
        WebViewClientCompat.a = new String[]{"VISUAL_STATE_CALLBACK", "RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_HTTP_ERROR", "SHOULD_OVERRIDE_WITH_REDIRECTS", "SAFE_BROWSING_HIT"};
    }

    public final void a(WebView webView0, WebResourceRequest webResourceRequest0, c c0) {
        if(a.G("WEB_RESOURCE_ERROR_GET_CODE") && a.G("WEB_RESOURCE_ERROR_GET_DESCRIPTION") && webResourceRequest0.isForMainFrame()) {
            k.b.getClass();
            if(((WebResourceError)c0.b) == null) {
                InvocationHandler invocationHandler0 = Proxy.getInvocationHandler(((WebResourceErrorBoundaryInterface)c0.c));
                c0.b = (WebResourceError)((WebkitToCompatConverterBoundaryInterface)l.a.b).convertWebResourceError(invocationHandler0);
            }
            int v = ((WebResourceError)c0.b).getErrorCode();
            k.a.getClass();
            if(((WebResourceError)c0.b) == null) {
                InvocationHandler invocationHandler1 = Proxy.getInvocationHandler(((WebResourceErrorBoundaryInterface)c0.c));
                c0.b = (WebResourceError)((WebkitToCompatConverterBoundaryInterface)l.a.b).convertWebResourceError(invocationHandler1);
            }
            this.onReceivedError(webView0, v, ((WebResourceError)c0.b).getDescription().toString(), webResourceRequest0.getUrl().toString());
        }
    }

    public static void b(p p0) {
        if(!a.G("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL")) {
            throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
        }
        b b0 = k.c;
        if(b0.a()) {
            if(((SafeBrowsingResponse)p0.a) == null) {
                InvocationHandler invocationHandler0 = Proxy.getInvocationHandler(((SafeBrowsingResponseBoundaryInterface)p0.b));
                p0.a = d.b(((WebkitToCompatConverterBoundaryInterface)l.a.b).convertSafeBrowsingResponse(invocationHandler0));
            }
            d.f(((SafeBrowsingResponse)p0.a));
            return;
        }
        if(!b0.b()) {
            throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
        }
        if(((SafeBrowsingResponseBoundaryInterface)p0.b) == null) {
            InvocationHandler invocationHandler1 = ((WebkitToCompatConverterBoundaryInterface)l.a.b).convertSafeBrowsingResponse(((SafeBrowsingResponse)p0.a));
            p0.b = (SafeBrowsingResponseBoundaryInterface)BoundaryInterfaceReflectionUtil.castToSuppLibClass(SafeBrowsingResponseBoundaryInterface.class, invocationHandler1);
        }
        ((SafeBrowsingResponseBoundaryInterface)p0.b).showInterstitial(true);
    }

    @Override  // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public final String[] getSupportedFeatures() {
        return WebViewClientCompat.a;
    }

    @Override  // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public final void onPageCommitVisible(WebView webView0, String s) {
    }

    @Override  // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView0, WebResourceRequest webResourceRequest0, WebResourceError webResourceError0) {
        c c0 = new c(4);
        c0.b = webResourceError0;
        this.a(webView0, webResourceRequest0, c0);
    }

    @Override  // org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public final void onReceivedError(WebView webView0, WebResourceRequest webResourceRequest0, InvocationHandler invocationHandler0) {
        c c0 = new c(4);
        c0.c = (WebResourceErrorBoundaryInterface)BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebResourceErrorBoundaryInterface.class, invocationHandler0);
        this.a(webView0, webResourceRequest0, c0);
    }

    @Override  // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public final void onReceivedHttpError(WebView webView0, WebResourceRequest webResourceRequest0, WebResourceResponse webResourceResponse0) {
    }

    @Override  // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView webView0, WebResourceRequest webResourceRequest0, int v, SafeBrowsingResponse safeBrowsingResponse0) {
        p p0 = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
        p0.a = safeBrowsingResponse0;
        WebViewClientCompat.b(p0);
    }

    @Override  // org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public final void onSafeBrowsingHit(WebView webView0, WebResourceRequest webResourceRequest0, int v, InvocationHandler invocationHandler0) {
        p p0 = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
        p0.b = (SafeBrowsingResponseBoundaryInterface)BoundaryInterfaceReflectionUtil.castToSuppLibClass(SafeBrowsingResponseBoundaryInterface.class, invocationHandler0);
        WebViewClientCompat.b(p0);
    }
}

