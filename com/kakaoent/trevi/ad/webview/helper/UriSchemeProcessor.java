package com.kakaoent.trevi.ad.webview.helper;

import Tf.v;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.net.Uri.Builder;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.kakaoent.trevi.ad.constants.UrlPatterns;
import com.kakaoent.trevi.ad.util.TreviLog;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\u000B\u0010\fJ#\u0010\u0012\u001A\u00020\u00112\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0019\u001A\u00020\n2\u0006\u0010\u0017\u001A\u00020\u00162\b\u0010\u0018\u001A\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001AJ\u001B\u0010\u001B\u001A\u0004\u0018\u00010\u00162\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001B\u0010\u001CJ3\u0010\u001F\u001A\u00020\n2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u000E\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u001E\u001A\u00020\u001DH\u0007¢\u0006\u0004\b\u001F\u0010 J)\u0010#\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010!\u001A\u00020\u00162\n\b\u0002\u0010\"\u001A\u0004\u0018\u00010\u0016¢\u0006\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/helper/UriSchemeProcessor;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "Landroid/content/Intent;", "intent", "", "requestCode", "", "startActivityForResult", "(Landroid/app/Activity;Landroid/content/Intent;I)Z", "Landroid/webkit/WebView;", "webView", "Landroid/webkit/WebChromeClient;", "webChromeClient", "Lie/H;", "closeWindowIfNeeded", "(Landroid/webkit/WebView;Landroid/webkit/WebChromeClient;)V", "isSpecializedHandlerAvailable", "(Landroid/app/Activity;Landroid/content/Intent;)Z", "", "url", "webViewHost", "isDeepLinkWhiteList", "(Ljava/lang/String;Ljava/lang/String;)Z", "extractHost", "(Landroid/webkit/WebView;)Ljava/lang/String;", "Lcom/kakaoent/trevi/ad/webview/helper/UriSchemeProcessor$Callback;", "callback", "process", "(Ljava/lang/String;Landroid/webkit/WebView;Landroid/webkit/WebChromeClient;Lcom/kakaoent/trevi/ad/webview/helper/UriSchemeProcessor$Callback;)Z", "packageName", "referrer", "startDetailsOverlay", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)Z", "Callback", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class UriSchemeProcessor {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/helper/UriSchemeProcessor$Callback;", "", "", "url", "Lie/H;", "onReceivedFallbackUrl", "(Ljava/lang/String;)V", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public interface Callback {
        void onReceivedFallbackUrl(@NotNull String arg1);
    }

    @NotNull
    public static final UriSchemeProcessor INSTANCE;

    static {
        UriSchemeProcessor.INSTANCE = new UriSchemeProcessor();
    }

    private final void closeWindowIfNeeded(WebView webView0, WebChromeClient webChromeClient0) {
        if(webView0 != null && webChromeClient0 != null) {
            WebBackForwardList webBackForwardList0 = webView0.copyBackForwardList();
            q.f(webBackForwardList0, "copyBackForwardList(...)");
            if(webBackForwardList0.getSize() <= 0) {
                webChromeClient0.onCloseWindow(webView0);
            }
        }
    }

    private final String extractHost(WebView webView0) {
        if(webView0 != null) {
            try {
                return Uri.parse(webView0.getUrl()).getHost();
            }
            catch(Exception exception0) {
                TreviLog.INSTANCE.e("UriSchemeProcessor", "", exception0);
            }
        }
        return null;
    }

    private final boolean isDeepLinkWhiteList(String s, String s1) {
        List list0 = Arrays.asList(new String[]{"m.map.daum.net"});
        try {
            Uri uri0 = Uri.parse(s);
            Iterator iterator0 = list0.iterator();
            while(true) {
            label_3:
                if(!iterator0.hasNext()) {
                    return false;
                }
                Object object0 = iterator0.next();
                String s2 = (String)object0;
                if(v.j0(s2, uri0.getHost(), true)) {
                    break;
                }
            }
        }
        catch(Exception exception0) {
            TreviLog.INSTANCE.e("UriSchemeProcessor", "", exception0);
            return false;
        }
        if(!v.j0(s2, s1, true)) {
            return true;
        }
        goto label_3;
    }

    private final boolean isSpecializedHandlerAvailable(Activity activity0, Intent intent0) {
        List list0 = activity0.getPackageManager().queryIntentActivities(intent0, 0x40);
        q.f(list0, "queryIntentActivities(...)");
        if(list0.size() == 0) {
            return false;
        }
        for(Object object0: list0) {
            IntentFilter intentFilter0 = ((ResolveInfo)object0).filter;
            if(intentFilter0 != null && (intentFilter0.countDataAuthorities() != 0 || intentFilter0.countDataPaths() != 0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public final boolean process(@NotNull String s, @NotNull WebView webView0, @Nullable WebChromeClient webChromeClient0, @NotNull Callback uriSchemeProcessor$Callback0) {
        Intent intent0;
        q.g(s, "url");
        q.g(webView0, "webView");
        q.g(uriSchemeProcessor$Callback0, "callback");
        Context context0 = webView0.getContext();
        if((context0 instanceof Activity ? ((Activity)context0) : null) == null) {
            return false;
        }
        Context context1 = webView0.getContext();
        q.e(context1, "null cannot be cast to non-null type android.app.Activity");
        Activity activity0 = (Activity)context1;
        if(activity0.isFinishing()) {
            return false;
        }
        try {
            intent0 = Intent.parseUri(s, 1);
            q.d(intent0);
        }
        catch(URISyntaxException unused_ex) {
            return false;
        }
        if(activity0.getPackageManager().resolveActivity(intent0, 0) == null) {
            String s1 = intent0.getStringExtra("browser_fallback_url");
            if(!TextUtils.isEmpty(s1)) {
                try {
                    s1 = URLDecoder.decode(s1, "utf-8");
                }
                catch(UnsupportedEncodingException unused_ex) {
                }
                if(URLUtils.INSTANCE.isValidUrl((s1 == null ? "" : s1))) {
                    q.d(s1);
                    uriSchemeProcessor$Callback0.onReceivedFallbackUrl(s1);
                    return true;
                }
            }
            String s2 = intent0.getPackage();
            if(s2 != null && UriSchemeProcessor.startDetailsOverlay$default(this, activity0, s2, null, 4, null)) {
                this.closeWindowIfNeeded(webView0, webChromeClient0);
                return true;
            }
            if(!UrlPatterns.INSTANCE.getACCEPTED_URI_SCHEMA().matcher(s).matches()) {
                return true;
            }
        }
        intent0.addCategory("android.intent.category.BROWSABLE");
        intent0.setComponent(null);
        Intent intent1 = intent0.getSelector();
        if(intent1 != null) {
            intent1.addCategory("android.intent.category.BROWSABLE");
            intent1.setComponent(null);
        }
        if(UrlPatterns.INSTANCE.getACCEPTED_URI_SCHEMA().matcher(s).matches() && (!this.isDeepLinkWhiteList(s, this.extractHost(webView0)) || !this.isSpecializedHandlerAvailable(activity0, intent0))) {
            return false;
        }
        try {
            intent0.addFlags(0x10000000);
            if(activity0.startActivityIfNeeded(intent0, -1)) {
                this.closeWindowIfNeeded(webView0, webChromeClient0);
                return true;
            }
        }
        catch(ActivityNotFoundException unused_ex) {
        }
        return false;
    }

    public static boolean process$default(UriSchemeProcessor uriSchemeProcessor0, String s, WebView webView0, WebChromeClient webChromeClient0, Callback uriSchemeProcessor$Callback0, int v, Object object0) {
        if((v & 8) != 0) {
            uriSchemeProcessor$Callback0 = new Callback() {
                @Override  // com.kakaoent.trevi.ad.webview.helper.UriSchemeProcessor$Callback
                public void onReceivedFallbackUrl(@NotNull String s) {
                    q.g(s, "url");
                    webView0.loadUrl(s);
                }
            };
        }
        return uriSchemeProcessor0.process(s, webView0, webChromeClient0, uriSchemeProcessor$Callback0);
    }

    private final boolean startActivityForResult(Activity activity0, Intent intent0, int v) {
        try {
            activity0.startActivityForResult(intent0, v);
            return true;
        }
        catch(ActivityNotFoundException | SecurityException | NullPointerException unused_ex) {
            return false;
        }
    }

    public final boolean startDetailsOverlay(@NotNull Activity activity0, @NotNull String s, @Nullable String s1) {
        q.g(activity0, "activity");
        q.g(s, "packageName");
        Uri.Builder uri$Builder0 = new Uri.Builder().scheme("market").authority("details").appendQueryParameter("id", s);
        if(!TextUtils.isEmpty(s1)) {
            uri$Builder0.appendQueryParameter("referrer", s1);
        }
        return this.startActivityForResult(activity0, new Intent("android.intent.action.VIEW").setData(uri$Builder0.build()).putExtra("overlay", true).putExtra("callerId", "com.iloen.melon"), 0);
    }

    public static boolean startDetailsOverlay$default(UriSchemeProcessor uriSchemeProcessor0, Activity activity0, String s, String s1, int v, Object object0) {
        if((v & 4) != 0) {
            s1 = null;
        }
        return uriSchemeProcessor0.startDetailsOverlay(activity0, s, s1);
    }
}

