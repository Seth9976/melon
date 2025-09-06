package com.kakaoent.trevi.ad;

import Tf.o;
import android.content.Context;
import androidx.fragment.app.I;
import com.kakaoent.trevi.ad.constants.ServerConfig;
import com.kakaoent.trevi.ad.repository.remote.interactor.CashFriendsInteractor;
import com.kakaoent.trevi.ad.repository.remote.interactor.CashFriendsManager;
import com.kakaoent.trevi.ad.repository.remote.interactor.TreviBannerAdInteractor;
import com.kakaoent.trevi.ad.ui.fragment.CashFriendsWebViewFragment.Companion;
import com.kakaoent.trevi.ad.ui.fragment.CashFriendsWebViewFragment;
import com.kakaoent.trevi.ad.util.AppContextHolder;
import com.kakaoent.trevi.ad.util.TreviLog;
import ie.d;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;
import we.k;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\t\b\u00C6\u0002\u0018\u00002\u00020\u0001:\u0003lmnB\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J/\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u00062\b\b\u0002\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\u0006\u00A2\u0006\u0004\b\u000F\u0010\u0010Jo\u0010 \u001A\u00020\u001F2\b\u0010\u000E\u001A\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0012\u001A\u00020\u00112\b\b\u0002\u0010\u0014\u001A\u00020\u00132\b\b\u0002\u0010\u0015\u001A\u00020\u00062\b\b\u0002\u0010\u0016\u001A\u00020\u00062\b\b\u0002\u0010\u0017\u001A\u00020\u00112\b\b\u0002\u0010\u0018\u001A\u00020\u00112\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u001C\u001A\u00020\u001B2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001D\u00A2\u0006\u0004\b \u0010!J\r\u0010\"\u001A\u00020\u0011\u00A2\u0006\u0004\b\"\u0010#J\r\u0010$\u001A\u00020\u0011\u00A2\u0006\u0004\b$\u0010#R*\u0010\n\u001A\u00020\t2\u0006\u0010%\u001A\u00020\t8\u0000@@X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\n\u0010&\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u0016\u0010\b\u001A\u00020\u00068\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b\b\u0010+R\"\u0010\u0007\u001A\u00020\u00068\u0000@\u0000X\u0080.\u00A2\u0006\u0012\n\u0004\b\u0007\u0010+\u001A\u0004\b,\u0010-\"\u0004\b.\u0010\u0010R$\u0010\u000E\u001A\u00020\u00062\u0006\u0010/\u001A\u00020\u00068\u0000@BX\u0080\u000E\u00A2\u0006\f\n\u0004\b\u000E\u0010+\u001A\u0004\b0\u0010-R\"\u00101\u001A\u00020\u00068\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b1\u0010+\u001A\u0004\b2\u0010-\"\u0004\b3\u0010\u0010R\"\u00104\u001A\u00020\u00068\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b4\u0010+\u001A\u0004\b5\u0010-\"\u0004\b6\u0010\u0010R\"\u00107\u001A\u00020\u00068\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b7\u0010+\u001A\u0004\b8\u0010-\"\u0004\b9\u0010\u0010R\"\u0010:\u001A\u00020\u00118\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b:\u0010;\u001A\u0004\b<\u0010#\"\u0004\b=\u0010>R6\u0010A\u001A\u001E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00190?j\u000E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0019`@8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\bA\u0010B\u001A\u0004\bC\u0010DR6\u0010E\u001A\u001E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001B0?j\u000E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001B`@8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\bE\u0010B\u001A\u0004\bF\u0010DR\"\u0010G\u001A\u00020\u00068\u0000@\u0000X\u0080.\u00A2\u0006\u0012\n\u0004\bG\u0010+\u001A\u0004\bH\u0010-\"\u0004\bI\u0010\u0010R*\u0010K\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010J8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\bK\u0010L\u001A\u0004\bM\u0010N\"\u0004\bO\u0010PR*\u0010Q\u001A\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010J8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\bQ\u0010L\u001A\u0004\bR\u0010N\"\u0004\bS\u0010PR*\u0010T\u001A\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010J8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\bT\u0010L\u001A\u0004\bU\u0010N\"\u0004\bV\u0010PR*\u0010W\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010J8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\bW\u0010L\u001A\u0004\bX\u0010N\"\u0004\bY\u0010PR0\u0010[\u001A\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000B\u0018\u00010Z8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b[\u0010\\\u001A\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010\u001E\u001A\u0004\u0018\u00010\u001D8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\u001E\u0010a\u001A\u0004\bb\u0010c\"\u0004\bd\u0010eR6\u0010g\u001A\u001E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020f0?j\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020f`@8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\bg\u0010B\u001A\u0004\bh\u0010DR.\u0010i\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000B0Z8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\bi\u0010\\\u001A\u0004\bj\u0010^\"\u0004\bk\u0010`\u00A8\u0006o"}, d2 = {"Lcom/kakaoent/trevi/ad/TreviAd;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "serviceCode", "clientId", "Lcom/kakaoent/trevi/ad/constants/ServerConfig;", "serverConfig", "Lie/H;", "register", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/kakaoent/trevi/ad/constants/ServerConfig;)V", "appUserId", "setAppUserId", "(Ljava/lang/String;)V", "", "isDarkMode", "", "headerHeight", "query", "errorPageAssetFileName", "enabledWebViewTimerControl", "isWebContentsDebuggingEnabled", "Lcom/kakaoent/trevi/ad/TreviAd$OfferWallCallback;", "offerWallCallback", "Lcom/kakaoent/trevi/ad/TreviAd$OfferWallEventCallback;", "offerWallEventCallback", "Lcom/kakaoent/trevi/ad/TreviAd$OfferWallNavigationDelegate;", "offerWallNavigationDelegate", "Landroidx/fragment/app/I;", "getOfferWallFragment", "(Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;ZZLcom/kakaoent/trevi/ad/TreviAd$OfferWallCallback;Lcom/kakaoent/trevi/ad/TreviAd$OfferWallEventCallback;Lcom/kakaoent/trevi/ad/TreviAd$OfferWallNavigationDelegate;)Landroidx/fragment/app/I;", "canGoBackOfferWall", "()Z", "onBackPressedOfferWall", "value", "Lcom/kakaoent/trevi/ad/constants/ServerConfig;", "getServerConfig$trevi_ad_android_sdk_release", "()Lcom/kakaoent/trevi/ad/constants/ServerConfig;", "setServerConfig$trevi_ad_android_sdk_release", "(Lcom/kakaoent/trevi/ad/constants/ServerConfig;)V", "Ljava/lang/String;", "getServiceCode$trevi_ad_android_sdk_release", "()Ljava/lang/String;", "setServiceCode$trevi_ad_android_sdk_release", "<set-?>", "getAppUserId$trevi_ad_android_sdk_release", "appId", "getAppId$trevi_ad_android_sdk_release", "setAppId$trevi_ad_android_sdk_release", "appVersion", "getAppVersion$trevi_ad_android_sdk_release", "setAppVersion$trevi_ad_android_sdk_release", "adid", "getAdid$trevi_ad_android_sdk_release", "setAdid$trevi_ad_android_sdk_release", "isLimitAdTrackingEnabled", "Z", "isLimitAdTrackingEnabled$trevi_ad_android_sdk_release", "setLimitAdTrackingEnabled$trevi_ad_android_sdk_release", "(Z)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "offerWallCallbackList", "Ljava/util/HashMap;", "getOfferWallCallbackList$trevi_ad_android_sdk_release", "()Ljava/util/HashMap;", "offerWallEventCallbackList", "getOfferWallEventCallbackList$trevi_ad_android_sdk_release", "javascriptInterfaceName", "getJavascriptInterfaceName$trevi_ad_android_sdk_release", "setJavascriptInterfaceName$trevi_ad_android_sdk_release", "Lkotlin/Function0;", "loginReceiver", "Lwe/a;", "getLoginReceiver$trevi_ad_android_sdk_release", "()Lwe/a;", "setLoginReceiver$trevi_ad_android_sdk_release", "(Lwe/a;)V", "offerWallGoBackReceiver", "getOfferWallGoBackReceiver$trevi_ad_android_sdk_release", "setOfferWallGoBackReceiver$trevi_ad_android_sdk_release", "offerWallOnBackPressedReceiver", "getOfferWallOnBackPressedReceiver$trevi_ad_android_sdk_release", "setOfferWallOnBackPressedReceiver$trevi_ad_android_sdk_release", "offerWallActivityFinishReceiver", "getOfferWallActivityFinishReceiver$trevi_ad_android_sdk_release", "setOfferWallActivityFinishReceiver$trevi_ad_android_sdk_release", "Lkotlin/Function1;", "darkModeChangedReceiver", "Lwe/k;", "getDarkModeChangedReceiver$trevi_ad_android_sdk_release", "()Lwe/k;", "setDarkModeChangedReceiver$trevi_ad_android_sdk_release", "(Lwe/k;)V", "Lcom/kakaoent/trevi/ad/TreviAd$OfferWallNavigationDelegate;", "getOfferWallNavigationDelegate$trevi_ad_android_sdk_release", "()Lcom/kakaoent/trevi/ad/TreviAd$OfferWallNavigationDelegate;", "setOfferWallNavigationDelegate$trevi_ad_android_sdk_release", "(Lcom/kakaoent/trevi/ad/TreviAd$OfferWallNavigationDelegate;)V", "Lcom/kakaoent/trevi/ad/data/VideoState;", "videoStateMap", "getVideoStateMap$trevi_ad_android_sdk_release", "loginHandler", "getLoginHandler$trevi_ad_android_sdk_release", "setLoginHandler$trevi_ad_android_sdk_release", "OfferWallCallback", "OfferWallEventCallback", "OfferWallNavigationDelegate", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class TreviAd {
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000B\bf\u0018\u00002\u00020\u0001J\u001D\u0010\u0006\u001A\u00020\u00052\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\'¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\n\u001A\u00020\u00052\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\bH&¢\u0006\u0004\b\n\u0010\u000BJg\u0010\u0015\u001A\u00020\u00052\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\f\u001A\u0004\u0018\u00010\b2\b\u0010\r\u001A\u0004\u0018\u00010\b2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\b2\b\u0010\u0011\u001A\u0004\u0018\u00010\b2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00050\u00122\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00050\u0012H&¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u0019\u001A\u00020\u00052\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0017H&¢\u0006\u0004\b\u0019\u0010\u001AJ;\u0010\u001F\u001A\u00020\u00052\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001B\u001A\u00020\u000E2\u0006\u0010\u001D\u001A\u00020\u001C2\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00050\u0012H&¢\u0006\u0004\b\u001F\u0010 J\u0017\u0010\"\u001A\u00020\u00052\u0006\u0010!\u001A\u00020\u000EH&¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001A\u00020\u00052\u0006\u0010$\u001A\u00020\bH&¢\u0006\u0004\b%\u0010&¨\u0006\'"}, d2 = {"Lcom/kakaoent/trevi/ad/TreviAd$OfferWallCallback;", "", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "activityRef", "Lie/H;", "showCustomerCenter", "(Ljava/lang/ref/WeakReference;)V", "", "text", "showToast", "(Ljava/lang/ref/WeakReference;Ljava/lang/String;)V", "title", "message", "", "cancelable", "positiveButtonText", "negativeButtonText", "Lkotlin/Function0;", "positiveButtonAction", "negativeButtonAction", "showAlertDialog", "(Ljava/lang/ref/WeakReference;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lwe/a;Lwe/a;)V", "Lkotlin/Function1;", "setAppUserId", "showLogin", "(Ljava/lang/ref/WeakReference;Lwe/k;)V", "isEnter", "", "webViewClientErrorCode", "reload", "onNetworkError", "(Ljava/lang/ref/WeakReference;ZILwe/a;)V", "isCreated", "cpvLifecycle", "(Z)V", "url", "onReceivedAnotherSchemeUrl", "(Ljava/lang/String;)V", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public interface OfferWallCallback {
        void cpvLifecycle(boolean arg1);

        void onNetworkError(@NotNull WeakReference arg1, boolean arg2, int arg3, @NotNull a arg4);

        void onReceivedAnotherSchemeUrl(@NotNull String arg1);

        void showAlertDialog(@NotNull WeakReference arg1, @Nullable String arg2, @Nullable String arg3, boolean arg4, @NotNull String arg5, @Nullable String arg6, @NotNull a arg7, @NotNull a arg8);

        @d
        void showCustomerCenter(@NotNull WeakReference arg1);

        void showLogin(@NotNull WeakReference arg1, @NotNull k arg2);

        void showToast(@NotNull WeakReference arg1, @Nullable String arg2);
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J9\u0010\u0007\u001A\u00020\u00062(\b\u0002\u0010\u0005\u001A\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\t\u001A\u00020\u00062(\b\u0002\u0010\u0005\u001A\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H&¢\u0006\u0004\b\t\u0010\bJ9\u0010\n\u001A\u00020\u00062(\b\u0002\u0010\u0005\u001A\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H&¢\u0006\u0004\b\n\u0010\bJ9\u0010\u000B\u001A\u00020\u00062(\b\u0002\u0010\u0005\u001A\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H&¢\u0006\u0004\b\u000B\u0010\b¨\u0006\f"}, d2 = {"Lcom/kakaoent/trevi/ad/TreviAd$OfferWallEventCallback;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "data", "Lie/H;", "pageViewEvent", "(Ljava/util/HashMap;)V", "trackExtraEvent", "trackEvent", "viewImp", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public interface OfferWallEventCallback {
        void pageViewEvent(@Nullable HashMap arg1);

        void trackEvent(@Nullable HashMap arg1);

        void trackExtraEvent(@Nullable HashMap arg1);

        void viewImp(@Nullable HashMap arg1);
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/kakaoent/trevi/ad/TreviAd$OfferWallNavigationDelegate;", "", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public interface OfferWallNavigationDelegate {
    }

    @NotNull
    public static final TreviAd INSTANCE;
    @NotNull
    private static String adid;
    @NotNull
    private static String appId;
    @NotNull
    private static String appUserId;
    @NotNull
    private static String appVersion;
    private static String clientId;
    @Nullable
    private static k darkModeChangedReceiver;
    private static boolean isLimitAdTrackingEnabled;
    public static String javascriptInterfaceName;
    @NotNull
    private static k loginHandler;
    @Nullable
    private static a loginReceiver;
    @Nullable
    private static a offerWallActivityFinishReceiver;
    @NotNull
    private static final HashMap offerWallCallbackList;
    @NotNull
    private static final HashMap offerWallEventCallbackList;
    @Nullable
    private static a offerWallGoBackReceiver;
    @Nullable
    private static OfferWallNavigationDelegate offerWallNavigationDelegate;
    @Nullable
    private static a offerWallOnBackPressedReceiver;
    @NotNull
    private static ServerConfig serverConfig;
    public static String serviceCode;
    @NotNull
    private static final HashMap videoStateMap;

    static {
        TreviAd.INSTANCE = new TreviAd();
        TreviAd.serverConfig = ServerConfig.PRODUCTION;
        TreviAd.appUserId = "0";
        TreviAd.appId = "";
        TreviAd.appVersion = "";
        TreviAd.adid = "";
        TreviAd.offerWallCallbackList = new HashMap();
        TreviAd.offerWallEventCallbackList = new HashMap();
        TreviAd.videoStateMap = new HashMap();
        TreviAd.loginHandler = TreviAd.loginHandler.1.INSTANCE;
    }

    public final boolean canGoBackOfferWall() {
        return TreviAd.offerWallGoBackReceiver == null ? false : ((Boolean)TreviAd.offerWallGoBackReceiver.invoke()).booleanValue();
    }

    @NotNull
    public final String getAdid$trevi_ad_android_sdk_release() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    @NotNull
    public final String getAppId$trevi_ad_android_sdk_release() [...] // 潜在的解密器

    @NotNull
    public final String getAppUserId$trevi_ad_android_sdk_release() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    @NotNull
    public final String getAppVersion$trevi_ad_android_sdk_release() [...] // 潜在的解密器

    @NotNull
    public final String getJavascriptInterfaceName$trevi_ad_android_sdk_release() {
        String s = TreviAd.javascriptInterfaceName;
        if(s != null) {
            return s;
        }
        q.m("javascriptInterfaceName");
        throw null;
    }

    @NotNull
    public final k getLoginHandler$trevi_ad_android_sdk_release() {
        return TreviAd.loginHandler;
    }

    @Nullable
    public final a getLoginReceiver$trevi_ad_android_sdk_release() {
        return TreviAd.loginReceiver;
    }

    @NotNull
    public final HashMap getOfferWallCallbackList$trevi_ad_android_sdk_release() {
        return TreviAd.offerWallCallbackList;
    }

    @NotNull
    public final HashMap getOfferWallEventCallbackList$trevi_ad_android_sdk_release() {
        return TreviAd.offerWallEventCallbackList;
    }

    @NotNull
    public final I getOfferWallFragment(@Nullable String s, boolean z, int v, @NotNull String s1, @NotNull String s2, boolean z1, boolean z2, @NotNull OfferWallCallback treviAd$OfferWallCallback0, @NotNull OfferWallEventCallback treviAd$OfferWallEventCallback0, @Nullable OfferWallNavigationDelegate treviAd$OfferWallNavigationDelegate0) {
        q.g(s1, "query");
        q.g(s2, "errorPageAssetFileName");
        q.g(treviAd$OfferWallCallback0, "offerWallCallback");
        q.g(treviAd$OfferWallEventCallback0, "offerWallEventCallback");
        TreviAd.offerWallNavigationDelegate = treviAd$OfferWallNavigationDelegate0;
        I i0 = Companion.newInstance$default(CashFriendsWebViewFragment.Companion, s, z, 0, 0, 0, v, s1, s2, z1, z2, 28, null);
        TreviAd.offerWallCallbackList.put(i0.hashCode(), treviAd$OfferWallCallback0);
        TreviAd.offerWallEventCallbackList.put(i0.hashCode(), treviAd$OfferWallEventCallback0);
        return i0;
    }

    public static I getOfferWallFragment$default(TreviAd treviAd0, String s, boolean z, int v, String s1, String s2, boolean z1, boolean z2, OfferWallCallback treviAd$OfferWallCallback0, OfferWallEventCallback treviAd$OfferWallEventCallback0, OfferWallNavigationDelegate treviAd$OfferWallNavigationDelegate0, int v1, Object object0) {
        if((v1 & 2) != 0) {
            z = true;
        }
        if((v1 & 4) != 0) {
            v = 44;
        }
        if((v1 & 8) != 0) {
            s1 = "";
        }
        if((v1 & 16) != 0) {
            s2 = "";
        }
        if((v1 & 0x20) != 0) {
            z1 = true;
        }
        if((v1 & 0x40) != 0) {
            z2 = false;
        }
        if((v1 & 0x200) != 0) {
            treviAd$OfferWallNavigationDelegate0 = null;
        }
        return treviAd0.getOfferWallFragment(s, z, v, s1, s2, z1, z2, treviAd$OfferWallCallback0, treviAd$OfferWallEventCallback0, treviAd$OfferWallNavigationDelegate0);
    }

    @Nullable
    public final OfferWallNavigationDelegate getOfferWallNavigationDelegate$trevi_ad_android_sdk_release() {
        return TreviAd.offerWallNavigationDelegate;
    }

    @NotNull
    public final ServerConfig getServerConfig$trevi_ad_android_sdk_release() {
        return TreviAd.serverConfig;
    }

    @NotNull
    public final String getServiceCode$trevi_ad_android_sdk_release() {
        String s = TreviAd.serviceCode;
        if(s != null) {
            return s;
        }
        q.m("serviceCode");
        throw null;
    }

    public final boolean isLimitAdTrackingEnabled$trevi_ad_android_sdk_release() [...] // 潜在的解密器

    public final boolean onBackPressedOfferWall() {
        return TreviAd.offerWallOnBackPressedReceiver == null ? false : ((Boolean)TreviAd.offerWallOnBackPressedReceiver.invoke()).booleanValue();
    }

    public final void register(@NotNull Context context0, @NotNull String s, @NotNull String s1, @NotNull ServerConfig serverConfig0) {
        q.g(context0, "context");
        q.g(s, "serviceCode");
        q.g(s1, "clientId");
        q.g(serverConfig0, "serverConfig");
        AppContextHolder.INSTANCE.setContext(context0);
        CashFriendsManager.INSTANCE.initialize(context0);
        this.setServiceCode$trevi_ad_android_sdk_release(s);
        TreviAd.clientId = s1;
        this.setServerConfig$trevi_ad_android_sdk_release(serverConfig0);
        q.f("com.iloen.melon", "getPackageName(...)");
        TreviAd.appId = "com.iloen.melon";
        String s2 = context0.getPackageManager().getPackageInfo("com.iloen.melon", 0).versionName;
        if(s2 == null) {
            s2 = "";
        }
        TreviAd.appVersion = s2;
        this.setJavascriptInterfaceName$trevi_ad_android_sdk_release(this.getServiceCode$trevi_ad_android_sdk_release() + "App");
        TreviLog.INSTANCE.i("TreviAd", "[TREVI SDK]==================\nVERSION_NAME: 2.3.0\nVERSION_CODE: 2300\nBUILD_TYPE: release\nGIT REV: 916ae50\n=============================");
    }

    public final void setAdid$trevi_ad_android_sdk_release(@NotNull String s) {
        q.g(s, "<set-?>");
        TreviAd.adid = s;
    }

    public final void setAppUserId(@NotNull String s) {
        q.g(s, "appUserId");
        if(!o.H0(s)) {
            TreviAd.appUserId = s;
            return;
        }
        TreviLog.INSTANCE.e("TreviAd", "setAppUserId - invalid appUserId");
    }

    public final void setDarkModeChangedReceiver$trevi_ad_android_sdk_release(@Nullable k k0) {
        TreviAd.darkModeChangedReceiver = k0;
    }

    public final void setJavascriptInterfaceName$trevi_ad_android_sdk_release(@NotNull String s) {
        q.g(s, "<set-?>");
        TreviAd.javascriptInterfaceName = s;
    }

    public final void setLimitAdTrackingEnabled$trevi_ad_android_sdk_release(boolean z) {
        TreviAd.isLimitAdTrackingEnabled = z;
    }

    public final void setLoginReceiver$trevi_ad_android_sdk_release(@Nullable a a0) {
        TreviAd.loginReceiver = a0;
    }

    public final void setOfferWallActivityFinishReceiver$trevi_ad_android_sdk_release(@Nullable a a0) {
        TreviAd.offerWallActivityFinishReceiver = a0;
    }

    public final void setOfferWallGoBackReceiver$trevi_ad_android_sdk_release(@Nullable a a0) {
        TreviAd.offerWallGoBackReceiver = a0;
    }

    public final void setOfferWallOnBackPressedReceiver$trevi_ad_android_sdk_release(@Nullable a a0) {
        TreviAd.offerWallOnBackPressedReceiver = a0;
    }

    public final void setServerConfig$trevi_ad_android_sdk_release(@NotNull ServerConfig serverConfig0) {
        q.g(serverConfig0, "value");
        TreviAd.serverConfig = serverConfig0;
        CashFriendsInteractor.INSTANCE.changeApi();
        TreviBannerAdInteractor.INSTANCE.changeApi();
    }

    public final void setServiceCode$trevi_ad_android_sdk_release(@NotNull String s) {
        q.g(s, "<set-?>");
        TreviAd.serviceCode = s;
    }
}

