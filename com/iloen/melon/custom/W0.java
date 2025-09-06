package com.iloen.melon.custom;

import Ac.U2;
import Ac.X3;
import R6.c;
import U4.x;
import Y8.d;
import Y8.h;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.webkit.WebViewClientCompat;
import b3.Z;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder;
import com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams;
import com.android.billingclient.api.QueryProductDetailsParams.Product;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.gaa.sdk.iap.l;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.tasks.Task;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventPlaybackScheme;
import com.iloen.melon.eventbus.EventWebView.Error;
import com.iloen.melon.eventbus.EventWebView.KakaoEmoticonPopup;
import com.iloen.melon.eventbus.EventWebView.Load;
import com.iloen.melon.eventbus.EventWebView.OpenUri;
import com.iloen.melon.eventbus.EventWebView.ShowPayAppInstall;
import com.iloen.melon.eventbus.EventWebView.UncheckAll;
import com.iloen.melon.eventbus.EventWebViewClose.CloseAllView;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.CookieHelper;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.network.UrlHttpCheckHelper;
import com.iloen.melon.utils.system.ToastManager;
import ea.b;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;
import k8.Y;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mb.k;
import r8.f;
import va.b0;
import va.e0;
import va.o;

public final class w0 extends WebViewClientCompat {
    public final MelonWebView b;

    public w0(MelonWebView melonWebView0) {
        this.b = melonWebView0;
        super();
    }

    @Override  // android.webkit.WebViewClient
    public final void onFormResubmission(WebView webView0, Message message0, Message message1) {
        message1.sendToTarget();
    }

    @Override  // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView0, String s) {
        super.onPageFinished(webView0, s);
        LogU.d("MelonWebView", "onPageFinished " + s);
        CookieManager.getInstance().flush();
        int v = NetUtils.checkDataNetwork();
        if(v != -1) {
            MelonWebView melonWebView0 = this.b;
            if(v == 2) {
                if(melonWebView0.D) {
                    EventBusHelper.post(new Error());
                }
                else {
                    webView0.loadUrl("file:///android_asset/main_local.html");
                }
            label_13:
                MelonWebViewInterface melonWebViewInterface0 = melonWebView0.a;
                if(melonWebViewInterface0 != null) {
                    melonWebView0.c = false;
                    melonWebViewInterface0.showProgress(false);
                }
                EventBusHelper.post(new UncheckAll());
                melonWebView0.d = true;
            }
            else if(v != 3) {
                goto label_13;
            }
        }
    }

    @Override  // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView0, String s, Bitmap bitmap0) {
        super.onPageStarted(webView0, s, bitmap0);
        Z.w("onPageStarted url : ", s, "MelonWebView");
        UrlHttpCheckHelper.INSTANCE.checkUrl(s);
        MelonWebView melonWebView0 = this.b;
        melonWebView0.d = false;
        MelonWebViewInterface melonWebViewInterface0 = melonWebView0.a;
        if(melonWebViewInterface0 != null) {
            melonWebViewInterface0.showToolbar(false, 0, 0, false);
        }
        switch(NetUtils.checkDataNetwork()) {
            case 2: {
                try {
                    webView0.stopLoading();
                }
                catch(Exception exception0) {
                    LogU.e("MelonWebView", exception0.toString());
                }
            label_14:
                MelonWebViewInterface melonWebViewInterface1 = melonWebView0.a;
                if(melonWebViewInterface1 != null) {
                    melonWebView0.c = true;
                    melonWebViewInterface1.showProgress(true);
                }
                if(melonWebView0.D) {
                    EventBusHelper.post(new Load());
                }
                break;
            }
            case -1: 
            case 3: {
                break;
            }
            default: {
                goto label_14;
            }
        }
    }

    @Override  // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView0, int v, String s, String s1) {
        StringBuilder stringBuilder0 = x.o(v, "onReceivedError - errorCode:", ", desc:", s, ", failingUrl : ");
        stringBuilder0.append(s1);
        LogU.e("MelonWebView", stringBuilder0.toString());
        try {
            webView0.stopLoading();
        }
        catch(Exception exception0) {
            LogU.e("MelonWebView", exception0.toString());
        }
        this.b.d = true;
        this.b.c = false;
        this.b.a.showProgress(false);
        if(this.b.D) {
            EventBusHelper.post(new Error());
            return;
        }
        webView0.loadUrl("file:///android_asset/main_local.html");
    }

    @Override  // android.webkit.WebViewClient
    public final void onScaleChanged(WebView webView0, float f, float f1) {
        LogU.d("MelonWebView", "onScaleChanged() - old:" + f + ", new:" + f1);
        super.onScaleChanged(webView0, f, f1);
    }

    @Override  // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public final boolean shouldOverrideUrlLoading(WebView webView0, WebResourceRequest webResourceRequest0) {
        SubscriptionUpdateParams billingFlowParams$SubscriptionUpdateParams0;
        String s10;
        String s = webResourceRequest0.getUrl().toString();
        LogU.d("MelonWebView", "handleUrlLoading() osVersion: More than N");
        Z.w("handleUrlLoading() url: ", s, "MelonWebView");
        MelonWebView melonWebView0 = this.b;
        boolean z = false;
        if(!(melonWebView0.w == null ? false : melonWebView0.w.shouldOverrideUrlLoading(webView0, s))) {
            if(s == null) {
                LogU.e("MelonWebView", "handleOverrideUrlLoading url is null!");
                return false;
            }
            LogU.e("MelonWebView", "handleOverrideUrlLoading() " + s);
            if(URLUtil.isNetworkUrl(s)) {
                if(FilenameUtils.isMusic(s)) {
                    Intent intent0 = new Intent("android.intent.action.VIEW");
                    intent0.setDataAndType(Uri.parse(s), "audio/*");
                    try {
                        melonWebView0.getContext().startActivity(intent0);
                    }
                    catch(Exception exception0) {
                        LogU.e("MelonWebView", exception0.toString());
                    }
                    return true;
                }
                if(FilenameUtils.isVideo(s)) {
                    Intent intent1 = new Intent("android.intent.action.VIEW");
                    intent1.setDataAndType(Uri.parse(s), "video/*");
                    try {
                        melonWebView0.getContext().startActivity(intent1);
                    }
                    catch(Exception exception1) {
                        LogU.e("MelonWebView", exception1.toString());
                    }
                    return true;
                }
            }
            else {
                if(s.startsWith("tel:")) {
                    Intent intent2 = new Intent("android.intent.action.DIAL", Uri.parse(s));
                    intent2.setFlags(0x10000000);
                    try {
                        melonWebView0.getContext().startActivity(intent2);
                    }
                    catch(Exception exception2) {
                        LogU.e("MelonWebView", exception2.toString());
                    }
                    return true;
                }
                if(s.startsWith("mailto:")) {
                    Intent intent3 = new Intent("android.intent.action.SENDTO", Uri.parse(s));
                    intent3.setFlags(0x10000000);
                    try {
                        melonWebView0.getContext().startActivity(intent3);
                    }
                    catch(Exception exception3) {
                        LogU.e("MelonWebView", exception3.toString());
                    }
                    return true;
                }
            }
            Uri uri0 = s.contains("https://m2.melon.com/link/") ? Uri.parse(s.replace("https://m2.melon.com/link/", "melonapp://")) : Uri.parse(s);
            String s1 = uri0.getScheme();
            if("melonapp".equalsIgnoreCase(s1)) {
                int v = f.c(uri0);
                if(v == 1800) {
                    goto label_200;
                }
                String s2 = "";
                switch(v) {
                    case 109: {
                        String s3 = uri0.getQueryParameter("close");
                        LogU.d("MelonWebView", "handleOverrideUrlLoading() :: MelOn.WEBVIEW : " + uri0);
                        if("A".equalsIgnoreCase(s3)) {
                            EventBusHelper.post(new CloseAllView(uri0));
                            return true;
                        }
                        EventBusHelper.post(new OpenUri(uri0));
                        return true;
                    }
                    case 110: {
                        ToastManager.debug("SMS scheme delivered");
                        SmsRetrieverClient smsRetrieverClient0 = SmsRetriever.getClient(melonWebView0.getContext());
                        melonWebView0.g = smsRetrieverClient0;
                        Task task0 = smsRetrieverClient0.startSmsRetriever();
                        b b0 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                        b0.b = melonWebView0;
                        b0.a = s;
                        task0.addOnSuccessListener(b0);
                        task0.addOnFailureListener(new c(24));
                        return true;
                    }
                    case 0x6F: {
                        break;
                    }
                    case 0x70: {
                        new s0(melonWebView0).execute(uri0);
                        return true;
                    }
                    case 0x71: {
                        Set set0 = NetUtils.getQueryParameterNames(uri0);
                        if(set0 != null) {
                            for(Object object0: set0) {
                                String s18 = uri0.getQueryParameter(((String)object0));
                                LogU.d("MelonWebView", "COOKIES_SET " + ((String)object0) + ":" + s18);
                                CookieHelper.getInstance().setCookie(((String)object0), s18);
                                if("IS_INPUT_AUTHENTICATION_ADULT_PWD".equalsIgnoreCase(((String)object0))) {
                                    k k1 = o.a();
                                    b0 b00 = new b0(((e0)k1), "Y".equals(s18), null);
                                    BuildersKt__Builders_commonKt.launch$default(((e0)k1).i, null, null, b00, 3, null);
                                }
                            }
                            return true;
                        label_200:
                            String s19 = uri0.getQueryParameter("option");
                            LogU.d("MelonWebView", "WEBVIEW_KEYBOARD - option: " + s19);
                            if("show".equalsIgnoreCase(s19)) {
                                LogU.v("MelonWebView", "showSoftInputMethod()");
                                melonWebView0.requestFocus();
                                ((InputMethodManager)melonWebView0.getContext().getSystemService("input_method")).showSoftInputFromInputMethod(melonWebView0.getWindowToken(), 1);
                                return true;
                            }
                            if("hide".equalsIgnoreCase(s19)) {
                                LogU.v("MelonWebView", "hideSoftInputMethod()");
                                ((InputMethodManager)melonWebView0.getContext().getSystemService("input_method")).hideSoftInputFromWindow(melonWebView0.getWindowToken(), 0);
                                return true;
                            }
                            if("toggle".equalsIgnoreCase(s19)) {
                                LogU.v("MelonWebView", "toggleSoftInputMethod()");
                                melonWebView0.requestFocus();
                                ((InputMethodManager)melonWebView0.getContext().getSystemService("input_method")).toggleSoftInput(1, 0);
                                return true;
                            }
                        }
                        break;
                    }
                    case 0x70C: {
                        EventBusHelper.post(new KakaoEmoticonPopup());
                        return true;
                    }
                    case 8001: {
                        LogU.d("MelonWebView", "purchaseGoogleIap()");
                        if(melonWebView0.j == null) {
                            LogU.e("MelonWebView", "purchaseGoogleIap() googleIapViewModel is null");
                            return true;
                        }
                        String s4 = uri0.getQueryParameter("sku");
                        String s5 = uri0.getQueryParameter("type");
                        String s6 = uri0.getQueryParameter("token");
                        String s7 = uri0.getQueryParameter("mode");
                        String s8 = uri0.getQueryParameter("data");
                        String s9 = uri0.getQueryParameter("alternativeBillingUrl");
                        int v1 = -1;
                        if(s6 != null) {
                            try {
                                v1 = Integer.parseInt(s7);
                            }
                            catch(Exception unused_ex) {
                            }
                        }
                        d d0 = melonWebView0.j.a;
                        if(d0 != null && (d0.b != null && d0.b.isReady())) {
                            z = true;
                        }
                        LogU.d("MelonWebView", "purchaseGoogleIap() isClientAvailable:" + z);
                        if(!z) {
                            melonWebView0.loadUrl("javascript:inAppPurchaseCancel()");
                            ToastManager.show("PlayStore에 로그인 되었는지 확인해 보세요.");
                            return true;
                        }
                        h h0 = melonWebView0.j;
                        h0.getClass();
                        q.g(s4, "productId");
                        q.g(s5, "type");
                        Companion logU$Companion0 = LogU.Companion;
                        StringBuilder stringBuilder0 = A7.d.o("startPurchaseProcess() productId:", s4, ", type:", s5, ", purchaseToken:");
                        A7.d.t(stringBuilder0, s6, ", replacementMode:", v1, ", data:");
                        logU$Companion0.d("GoogleIapViewModel", Y.l(stringBuilder0, s8, ", alternativeBillingUrl:", s9));
                        if(h0.d != null) {
                            logU$Companion0.d("GoogleIapViewModel", "startPurchaseProcess() too much event");
                            return true;
                        }
                        if(s8 == null) {
                            s10 = "";
                        }
                        else {
                            String s11 = URLEncoder.encode(s8, "utf-8");
                            q.f(s11, "encode(...)");
                            s10 = s11;
                        }
                        if(s6 == null) {
                            billingFlowParams$SubscriptionUpdateParams0 = null;
                        }
                        else {
                            Builder billingFlowParams$SubscriptionUpdateParams$Builder0 = SubscriptionUpdateParams.newBuilder();
                            billingFlowParams$SubscriptionUpdateParams$Builder0.setOldPurchaseToken(s6);
                            billingFlowParams$SubscriptionUpdateParams$Builder0.setSubscriptionReplacementMode(v1);
                            billingFlowParams$SubscriptionUpdateParams0 = billingFlowParams$SubscriptionUpdateParams$Builder0.build();
                        }
                        if(s9 != null) {
                            s2 = s9;
                        }
                        h0.d = s2;
                        logU$Companion0.d("GoogleIapViewModel", "queryProductInfo productId:" + s4);
                        List list0 = e.k.z(Product.newBuilder().setProductId(s4).setProductType(s5).build());
                        com.android.billingclient.api.QueryProductDetailsParams.Builder queryProductDetailsParams$Builder0 = QueryProductDetailsParams.newBuilder();
                        queryProductDetailsParams$Builder0.setProductList(list0);
                        QueryProductDetailsParams queryProductDetailsParams0 = queryProductDetailsParams$Builder0.build();
                        q.f(queryProductDetailsParams0, "build(...)");
                        d d1 = h0.a;
                        if(d1 != null) {
                            U2 u20 = new U2(h0, s5, s10, billingFlowParams$SubscriptionUpdateParams0, 19);
                            Log.d("BillingClientLifecycle", "queryProductDetails");
                            BillingClient billingClient0 = d1.b;
                            if(billingClient0 != null) {
                                billingClient0.queryProductDetailsAsync(queryProductDetailsParams0, new X3(u20, 20));
                                return true;
                            }
                            q.m("billingClient");
                            throw null;
                        }
                        return true;
                    }
                    case 8002: {
                        LogU.d("MelonWebView", "purchaseOneStoreIap()");
                        if(melonWebView0.k == null) {
                            LogU.e("MelonWebView", "purchaseOneStoreIap() oneStoreIapViewModel is null");
                            return true;
                        }
                        LogU.d("MelonWebView", "purchaseOneStoreIap() uri:" + uri0);
                        String s12 = uri0.getQueryParameter("productId");
                        String s13 = uri0.getQueryParameter("devPayload");
                        String s14 = uri0.getQueryParameter("actionUrl");
                        String s15 = uri0.getQueryParameter("productType");
                        int v2 = Integer.parseInt(uri0.getQueryParameter("quantity"));
                        String s16 = uri0.getQueryParameter("data");
                        Z8.k k0 = melonWebView0.k;
                        if(s16 != null) {
                            s2 = s16;
                        }
                        k0.getClass();
                        q.g(s12, "productId");
                        q.g(s15, "productType");
                        q.g(s13, "devPayload");
                        q.g(s14, "actionUrl");
                        String s17 = URLDecoder.decode(s14, "utf-8");
                        q.f(s17, "decode(...)");
                        StringBuilder stringBuilder1 = A7.d.o("purchaseOneStoreIap() productId:", s12, ", devPayload:", s13, ", actionUrl:");
                        A7.d.t(stringBuilder1, s14, ", quantity:", v2, ", actionUrl:");
                        A7.d.u(stringBuilder1, s14, "decodedActionUrl:", s17, ", returnData:");
                        stringBuilder1.append(s2);
                        LogU.Companion.d("OneStoreIapViewModel", stringBuilder1.toString());
                        l l0 = new l(0);
                        l0.b = s12;
                        l0.c = s15;
                        l0.e = s13;
                        l0.d = v2;
                        Z8.h h1 = new Z8.h(l0, s17, s2);
                        k0.b.postValue(h1);
                        return true;
                    }
                    case 9000: {
                        EventBusHelper.post(new EventPlaybackScheme(uri0));
                        EventBusHelper.post(new UncheckAll());
                        return true;
                    label_174:
                        Context context0 = melonWebView0.getContext();
                        if(context0 != null) {
                            Intent intent4 = new Intent();
                            Q1.c.Y(intent4, "android.intent.action.VIEW", false);
                            intent4.addFlags(0x4000000);
                            intent4.setData(uri0);
                            try {
                                LogU.d("MelonWebView", "startActivity - data:" + uri0);
                                context0.startActivity(intent4);
                            }
                            catch(ActivityNotFoundException activityNotFoundException0) {
                                LogU.e("MelonWebView", activityNotFoundException0.toString());
                            }
                            return true;
                        }
                        MelonSettingInfo.isUseDataNetwork();
                        return false;
                    }
                    default: {
                        goto label_174;
                    }
                }
                return true;
            }
            else if("intent".equalsIgnoreCase(s1)) {
                Context context1 = melonWebView0.getContext();
                if(context1 != null) {
                    try {
                        Intent intent5 = Intent.parseUri(s, 1);
                        Uri uri1 = intent5.getData();
                        if(9000 == f.c(uri1)) {
                            EventBusHelper.post(new EventPlaybackScheme(uri1));
                            return true;
                        }
                        intent5.addFlags(0x4000000);
                        LogU.d("MelonWebView", "startActivity - url:" + s);
                        context1.startActivity(intent5);
                        return true;
                    }
                    catch(URISyntaxException uRISyntaxException0) {
                    }
                    catch(ActivityNotFoundException activityNotFoundException1) {
                        LogU.e("MelonWebView", activityNotFoundException1.toString());
                        return true;
                    }
                    LogU.e("MelonWebView", uRISyntaxException0.toString());
                    return true;
                }
            }
            else if("ispmobile".equalsIgnoreCase(s1) || "market".equalsIgnoreCase(s1)) {
                Context context4 = melonWebView0.getContext();
                if(context4 != null) {
                    try {
                        Intent intent8 = Intent.parseUri(s, 1);
                        intent8.addFlags(0x4000000);
                        LogU.d("MelonWebView", "startActivity - url:" + s);
                        context4.startActivity(intent8);
                        return true;
                    }
                    catch(URISyntaxException uRISyntaxException2) {
                        LogU.e("MelonWebView", uRISyntaxException2.toString());
                        return true;
                    }
                    catch(ActivityNotFoundException activityNotFoundException4) {
                        LogU.e("MelonWebView", activityNotFoundException4.toString());
                        if(s.startsWith("ispmobile://")) {
                            ShowPayAppInstall eventWebView$ShowPayAppInstall1 = new ShowPayAppInstall();
                            eventWebView$ShowPayAppInstall1.type = 0;
                            EventBusHelper.post(eventWebView$ShowPayAppInstall1);
                            return false;
                        }
                    }
                    return true;
                }
            }
            else if("kftc-bankpay".equalsIgnoreCase(s1)) {
                Context context2 = melonWebView0.getContext();
                if(context2 != null) {
                    try {
                        Intent intent6 = Intent.parseUri(s, 1);
                        intent6.addFlags(0x4000000);
                        LogU.d("MelonWebView", "startActivity - url:" + s);
                        context2.startActivity(intent6);
                        return true;
                    }
                    catch(URISyntaxException uRISyntaxException1) {
                        LogU.e("MelonWebView", uRISyntaxException1.toString());
                        return true;
                    }
                    catch(ActivityNotFoundException activityNotFoundException2) {
                        LogU.e("MelonWebView", activityNotFoundException2.toString());
                        if(!s.startsWith("kftc-bankpay://")) {
                            return true;
                        }
                        ShowPayAppInstall eventWebView$ShowPayAppInstall0 = new ShowPayAppInstall();
                        eventWebView$ShowPayAppInstall0.type = 1;
                        EventBusHelper.post(eventWebView$ShowPayAppInstall0);
                        return false;
                    }
                }
            }
            else if(s.contains("onelink.me")) {
                Context context3 = melonWebView0.getContext();
                if(context3 != null) {
                    try {
                        Intent intent7 = new Intent("android.intent.action.VIEW");
                        intent7.setData(Uri.parse(s));
                        LogU.d("MelonWebView", "startActivity - url:" + s);
                        context3.startActivity(intent7);
                    }
                    catch(ActivityNotFoundException activityNotFoundException3) {
                        LogU.e("MelonWebView", activityNotFoundException3.toString());
                    }
                    return true;
                }
            }
            MelonSettingInfo.isUseDataNetwork();
            return false;
        }
        return true;
    }
}

