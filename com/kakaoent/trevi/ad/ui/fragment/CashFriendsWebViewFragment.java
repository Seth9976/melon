package com.kakaoent.trevi.ad.ui.fragment;

import A6.b;
import P1.c;
import R1.j;
import Tf.o;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.t;
import com.iloen.melon.fragments.cashfriends.CashFriendsFragment;
import com.kakaoent.trevi.ad.R.color;
import com.kakaoent.trevi.ad.R.id;
import com.kakaoent.trevi.ad.R.layout;
import com.kakaoent.trevi.ad.R.string;
import com.kakaoent.trevi.ad.TreviAd.OfferWallCallback;
import com.kakaoent.trevi.ad.TreviAd;
import com.kakaoent.trevi.ad.ui.CashFriendsVideoActivity;
import com.kakaoent.trevi.ad.ui.CashFriendsWebInterface;
import com.kakaoent.trevi.ad.util.NetworkManager;
import com.kakaoent.trevi.ad.util.NumberExtKt;
import com.kakaoent.trevi.ad.util.TreviLog;
import com.kakaoent.trevi.ad.webview.TreviWebView;
import com.kakaoent.trevi.ad.webview.webkit.AppWebViewSettingsUtils;
import ie.H;
import ie.d;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;
import we.k;

@Metadata(d1 = {"\u0000\u009C\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u0000 n2\u00020\u0001:\u0001nB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000E\u001A\u0004\u0018\u00010\r2\u0006\u0010\n\u001A\u00020\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\r2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0003J\u000F\u0010\u0014\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0003J\u000F\u0010\u0015\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0003J-\u0010\u001B\u001A\u00020\u00062\b\u0010\u0010\u001A\u0004\u0018\u00010\u00162\b\u0010\u0018\u001A\u0004\u0018\u00010\u00172\b\u0010\u001A\u001A\u0004\u0018\u00010\u0019H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ#\u0010\u001D\u001A\u00020\u00062\b\u0010\u0010\u001A\u0004\u0018\u00010\u00162\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ5\u0010#\u001A\u00020\u00062\b\u0010\u0010\u001A\u0004\u0018\u00010\u00162\u0006\u0010 \u001A\u00020\u001F2\b\u0010!\u001A\u0004\u0018\u00010\u00172\b\u0010\"\u001A\u0004\u0018\u00010\u0017H\u0017\u00A2\u0006\u0004\b#\u0010$J-\u0010#\u001A\u00020\u00062\b\u0010\u0010\u001A\u0004\u0018\u00010\u00162\b\u0010&\u001A\u0004\u0018\u00010%2\b\u0010(\u001A\u0004\u0018\u00010\'H\u0017\u00A2\u0006\u0004\b#\u0010)J#\u0010-\u001A\u00020,2\b\u0010\u0010\u001A\u0004\u0018\u00010\u00162\b\u0010+\u001A\u0004\u0018\u00010*H\u0016\u00A2\u0006\u0004\b-\u0010.J/\u00103\u001A\u00020\u00062\n\b\u0002\u0010/\u001A\u0004\u0018\u00010\u00172\n\b\u0002\u00100\u001A\u0004\u0018\u00010\u00172\b\b\u0002\u00102\u001A\u000201\u00A2\u0006\u0004\b3\u00104J-\u00109\u001A\u00020\u00062\u0006\u00105\u001A\u00020\u00172\u0006\u00106\u001A\u00020\u00172\u0006\u00107\u001A\u00020\u00172\u0006\u00108\u001A\u00020\u0017\u00A2\u0006\u0004\b9\u0010:J\r\u0010;\u001A\u00020\u0006\u00A2\u0006\u0004\b;\u0010\u0003J\r\u0010<\u001A\u00020\u0006\u00A2\u0006\u0004\b<\u0010\u0003J\r\u0010=\u001A\u00020\u0006\u00A2\u0006\u0004\b=\u0010\u0003J\r\u0010>\u001A\u00020\u0006\u00A2\u0006\u0004\b>\u0010\u0003J\u000F\u0010?\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b?\u0010\u0003J\u000F\u0010A\u001A\u00020@H\u0002\u00A2\u0006\u0004\bA\u0010BJ\u000F\u0010C\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\bC\u0010\u0003J+\u0010E\u001A\u00020\u00062\b\u0010\u0010\u001A\u0004\u0018\u00010\u00162\u0006\u0010 \u001A\u00020\u001F2\b\b\u0002\u0010D\u001A\u00020,H\u0003\u00A2\u0006\u0004\bE\u0010FJ\u001F\u0010I\u001A\u00020\u00062\u0006\u0010G\u001A\u00020,2\u0006\u0010H\u001A\u00020\u001FH\u0002\u00A2\u0006\u0004\bI\u0010JJ\u000F\u0010K\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\bK\u0010\u0003R\u0018\u0010L\u001A\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010N\u001A\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010Q\u001A\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010T\u001A\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010W\u001A\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001A\u00020,8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010\\\u001A\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010^\u001A\u00020,8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b^\u0010ZR\u0016\u0010_\u001A\u00020\u001F8\u0002@\u0002X\u0083\u000E\u00A2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001A\u00020\u001F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\ba\u0010`R\u0016\u0010b\u001A\u00020\u001F8\u0002@\u0002X\u0083\u000E\u00A2\u0006\u0006\n\u0004\bb\u0010`R\u0016\u0010c\u001A\u00020\u001F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bc\u0010`R\u0016\u0010d\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bd\u0010OR\u0016\u0010e\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\be\u0010OR\u0016\u0010f\u001A\u00020,8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bf\u0010ZR\u0016\u0010g\u001A\u00020,8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bg\u0010ZR\u0016\u0010h\u001A\u00020,8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bh\u0010ZR\u0016\u0010i\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bi\u0010OR\u0016\u0010k\u001A\u00020j8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010m\u001A\u00020,8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bm\u0010Z\u00A8\u0006o"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/fragment/CashFriendsWebViewFragment;", "Lcom/kakaoent/trevi/ad/ui/fragment/WebViewBridgeFragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onDestroyView", "onDestroy", "Landroid/webkit/WebView;", "", "url", "Landroid/graphics/Bitmap;", "favicon", "onPageStarted", "(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "onPageFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "", "errorCode", "description", "failingUrl", "onReceivedError", "(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V", "Landroid/webkit/WebResourceRequest;", "request", "Landroid/webkit/WebResourceError;", "error", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V", "Landroid/webkit/RenderProcessGoneDetail;", "detail", "", "onRenderProcessGone", "(Landroid/webkit/WebView;Landroid/webkit/RenderProcessGoneDetail;)Z", "type", "content", "", "opacity", "setHeaderTitle", "(Ljava/lang/String;Ljava/lang/String;F)V", "videoUrl", "orientation", "ask", "popupUrl", "playVideo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "showAdIdSetting", "showCustomerCenter", "reload", "showLogin", "onBackPressed", "Lcom/kakaoent/trevi/ad/ui/CashFriendsWebInterface;", "getJavascriptInterface", "()Lcom/kakaoent/trevi/ad/ui/CashFriendsWebInterface;", "setWebViewUrl", "isMainFrame", "showError", "(Landroid/webkit/WebView;IZ)V", "isEnter", "webViewClientErrorCode", "showNetworkError", "(ZI)V", "setTitleColor", "cashFriendsJavascriptInterface", "Lcom/kakaoent/trevi/ad/ui/CashFriendsWebInterface;", "webViewUrl", "Ljava/lang/String;", "Landroid/widget/TextView;", "titleTextView", "Landroid/widget/TextView;", "Landroid/widget/ImageButton;", "backButton", "Landroid/widget/ImageButton;", "Landroid/os/ResultReceiver;", "videoPlayResultReceiver", "Landroid/os/ResultReceiver;", "inLogin", "Z", "Lcom/kakaoent/trevi/ad/webview/TreviWebView;", "webView", "Lcom/kakaoent/trevi/ad/webview/TreviWebView;", "isDarkMode", "backButtonImageRes", "I", "backButtonHorizontalPadding", "titleFontRes", "headerHeight", "query", "errorPageAssetFileName", "enabledWebViewTimerControl", "isWebContentsDebuggingEnabled", "isJustCreatedWebView", "titleText", "", "networkErrorTime", "J", "doClearHistory", "Companion", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class CashFriendsWebViewFragment extends WebViewBridgeFragment {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jl\u0010\u0011\u001A\u00020\u00122\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0014\u001A\u00020\u00102\b\b\u0003\u0010\u0015\u001A\u00020\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u00162\b\b\u0003\u0010\u0018\u001A\u00020\u00162\b\b\u0002\u0010\u0019\u001A\u00020\u00162\b\b\u0002\u0010\u001A\u001A\u00020\u00042\b\b\u0002\u0010\u001B\u001A\u00020\u00042\b\b\u0002\u0010\u001C\u001A\u00020\u00102\b\b\u0002\u0010\u001D\u001A\u00020\u0010R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/fragment/CashFriendsWebViewFragment$Companion;", "", "()V", "ARGS_APP_USER_ID", "", "ARGS_BACK_BUTTON_HORIZONTAL_PADDING", "ARGS_BACK_BUTTON_IMAGE_RES", "ARGS_DARK_MODE", "ARGS_ENABLED_DEBUGGING", "ARGS_ENABLED_TIMER_CONTROL", "ARGS_ERROR_PAGE_ASSET_FILE_NAME", "ARGS_HEADER_HEIGHT", "ARGS_QUERY", "ARGS_TITLE_FONT_RES", "TAG", "USE_OPEN_APP_SCHEME_URL", "", "newInstance", "Lcom/kakaoent/trevi/ad/ui/fragment/CashFriendsWebViewFragment;", "appUserId", "isDarkMode", "backButtonImageRes", "", "backButtonHorizontalPadding", "titleFontRes", "headerHeight", "query", "errorPageAssetFileName", "enabledWebViewTimerControl", "isWebContentsDebuggingEnabled", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final CashFriendsWebViewFragment newInstance(@Nullable String s, boolean z, int v, int v1, int v2, int v3, @NotNull String s1, @NotNull String s2, boolean z1, boolean z2) {
            q.g(s1, "query");
            q.g(s2, "errorPageAssetFileName");
            CashFriendsWebViewFragment cashFriendsWebViewFragment0 = new CashFriendsWebViewFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("ARGS_USER_ID", s);
            bundle0.putBoolean("ARGS_DARK_MODE", z);
            bundle0.putInt("ARGS_BACK_BUTTON_IMAGE_RES", v);
            bundle0.putInt("ARGS_BACK_BUTTON_HORIZONTAL_PADDING", v1);
            bundle0.putInt("ARGS_TITLE_FONT_RES", v2);
            bundle0.putInt("ARGS_HEADER_HEIGHT", v3);
            bundle0.putString("ARGS_QUERY", s1);
            bundle0.putString("ARGS_ERROR_PAGE_ASSET_FILE_NAME", s2);
            bundle0.putBoolean("ARGS_ENABLED_TIMER_CONTROL", z1);
            bundle0.putBoolean("ARGS_ENABLED_DEBUGGING", z2);
            cashFriendsWebViewFragment0.setArguments(bundle0);
            return cashFriendsWebViewFragment0;
        }

        public static CashFriendsWebViewFragment newInstance$default(Companion cashFriendsWebViewFragment$Companion0, String s, boolean z, int v, int v1, int v2, int v3, String s1, String s2, boolean z1, boolean z2, int v4, Object object0) {
            if((v4 & 1) != 0) {
                s = null;
            }
            if((v4 & 2) != 0) {
                z = false;
            }
            if((v4 & 4) != 0) {
                v = 0;
            }
            if((v4 & 8) != 0) {
                v1 = 18;
            }
            if((v4 & 16) != 0) {
                v2 = 0;
            }
            if((v4 & 0x20) != 0) {
                v3 = 44;
            }
            if((v4 & 0x40) != 0) {
                s1 = "";
            }
            if((v4 & 0x80) != 0) {
                s2 = "";
            }
            if((v4 & 0x100) != 0) {
                z1 = true;
            }
            return (v4 & 0x200) == 0 ? cashFriendsWebViewFragment$Companion0.newInstance(s, z, v, v1, v2, v3, s1, s2, z1, z2) : cashFriendsWebViewFragment$Companion0.newInstance(s, z, v, v1, v2, v3, s1, s2, z1, false);
        }
    }

    @NotNull
    public static final Companion Companion;
    @Nullable
    private ImageButton backButton;
    private int backButtonHorizontalPadding;
    private int backButtonImageRes;
    @Nullable
    private CashFriendsWebInterface cashFriendsJavascriptInterface;
    private boolean doClearHistory;
    private boolean enabledWebViewTimerControl;
    @NotNull
    private String errorPageAssetFileName;
    private int headerHeight;
    private boolean inLogin;
    private boolean isDarkMode;
    private boolean isJustCreatedWebView;
    private boolean isWebContentsDebuggingEnabled;
    private long networkErrorTime;
    @NotNull
    private String query;
    private int titleFontRes;
    @NotNull
    private String titleText;
    @Nullable
    private TextView titleTextView;
    @Nullable
    private ResultReceiver videoPlayResultReceiver;
    @Nullable
    private TreviWebView webView;
    @Nullable
    private String webViewUrl;

    static {
        CashFriendsWebViewFragment.Companion = new Companion(null);
    }

    public CashFriendsWebViewFragment() {
        this.backButtonHorizontalPadding = 18;
        this.headerHeight = 44;
        this.query = "";
        this.errorPageAssetFileName = "";
        this.enabledWebViewTimerControl = true;
        this.isJustCreatedWebView = true;
        this.titleText = "";
    }

    private final CashFriendsWebInterface getJavascriptInterface() {
        TreviLog.INSTANCE.d("CashFriendsWebViewFragment", "child getJavascriptInterface");
        CashFriendsWebInterface cashFriendsWebInterface0 = this.cashFriendsJavascriptInterface;
        if(cashFriendsWebInterface0 == null) {
            cashFriendsWebInterface0 = new CashFriendsWebInterface(this);
            this.cashFriendsJavascriptInterface = cashFriendsWebInterface0;
        }
        return cashFriendsWebInterface0;
    }

    // 检测为 Lambda 实现
    public static void l(String s) [...]

    public static void m(CashFriendsWebViewFragment cashFriendsWebViewFragment0, View view0) {
        CashFriendsWebViewFragment.onViewCreated$lambda$8(cashFriendsWebViewFragment0, view0);
    }

    @Override  // com.kakaoent.trevi.ad.ui.fragment.BaseFragment
    public void onBackPressed() {
        if(this.webView != null && this.webView.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override  // com.kakaoent.trevi.ad.ui.fragment.BaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.useBackPressed();
        Bundle bundle1 = this.getArguments();
        if(bundle1 != null) {
            String s = bundle1.getString("ARGS_USER_ID", "");
            q.f(s, "getString(...)");
            TreviAd.INSTANCE.setAppUserId(s);
            this.isDarkMode = bundle1.getBoolean("ARGS_DARK_MODE", false);
            this.backButtonImageRes = bundle1.getInt("ARGS_BACK_BUTTON_IMAGE_RES", 0);
            this.backButtonHorizontalPadding = bundle1.getInt("ARGS_BACK_BUTTON_HORIZONTAL_PADDING", 18);
            this.titleFontRes = bundle1.getInt("ARGS_TITLE_FONT_RES", 0);
            this.headerHeight = bundle1.getInt("ARGS_HEADER_HEIGHT", 44);
            String s1 = bundle1.getString("ARGS_QUERY", "");
            q.f(s1, "getString(...)");
            this.query = s1;
            String s2 = bundle1.getString("ARGS_ERROR_PAGE_ASSET_FILE_NAME", "");
            q.f(s2, "getString(...)");
            this.errorPageAssetFileName = s2;
            this.enabledWebViewTimerControl = bundle1.getBoolean("ARGS_ENABLED_TIMER_CONTROL", true);
            this.isWebContentsDebuggingEnabled = bundle1.getBoolean("ARGS_ENABLED_DEBUGGING", false);
        }
        Context context0 = this.getContext();
        if(context0 != null && this.webView == null) {
            this.isJustCreatedWebView = true;
            TreviWebView treviWebView0 = new TreviWebView(context0, null, 2, null);
            treviWebView0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            treviWebView0.setOverScrollMode(2);
            this.webView = treviWebView0;
        }
        TreviWebView treviWebView1 = this.webView;
        if(treviWebView1 != null) {
            if(bundle0 == null) {
                CookieManager.getInstance().acceptThirdPartyCookies(treviWebView1);
            }
            treviWebView1.setWebViewBackgroundColor(this.isDarkMode);
            t t0 = this.getLifecycle();
            q.f(t0, "<get-lifecycle>(...)");
            treviWebView1.initializeWebView(t0, this.enabledWebViewTimerControl, this.isWebContentsDebuggingEnabled);
            Context context1 = treviWebView1.getContext();
            q.f(context1, "getContext(...)");
            AppWebViewSettingsUtils.INSTANCE.expandWebViewSettings(context1, treviWebView1, 100);
            treviWebView1.addJavascriptInterface(this.getJavascriptInterface(), TreviAd.INSTANCE.getJavascriptInterfaceName$trevi_ad_android_sdk_release());
            treviWebView1.addWebViewClient(this);
            treviWebView1.addWebChromeClient(this);
        }
        this.setWebViewUrl();
        this.videoPlayResultReceiver = new ResultReceiver(/*ERROR_MISSING_ARG_1/*) {
            @Override  // android.os.ResultReceiver
            public void onReceiveResult(int v, @Nullable Bundle bundle0) {
                new Handler(Looper.getMainLooper()).reload();
            }
        };
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(R.layout.trevi_cash_friends_webview_fragment, viewGroup0, false);
    }

    @Override  // com.kakaoent.trevi.ad.ui.fragment.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        CashFriendsWebInterface cashFriendsWebInterface0 = this.cashFriendsJavascriptInterface;
        if(cashFriendsWebInterface0 != null) {
            cashFriendsWebInterface0.clear();
        }
        this.cashFriendsJavascriptInterface = null;
        TreviWebView treviWebView0 = this.webView;
        if(treviWebView0 != null) {
            treviWebView0.removeJavascriptInterface(TreviAd.INSTANCE.getJavascriptInterfaceName$trevi_ad_android_sdk_release());
        }
        this.videoPlayResultReceiver = null;
        TreviAd.INSTANCE.getOfferWallCallbackList$trevi_ad_android_sdk_release().remove(this.hashCode());
        TreviAd.INSTANCE.getOfferWallEventCallbackList$trevi_ad_android_sdk_release().remove(this.hashCode());
        TreviAd.INSTANCE.setLoginReceiver$trevi_ad_android_sdk_release(null);
        TreviAd.INSTANCE.setOfferWallGoBackReceiver$trevi_ad_android_sdk_release(null);
        TreviAd.INSTANCE.setOfferWallOnBackPressedReceiver$trevi_ad_android_sdk_release(null);
        TreviAd.INSTANCE.setDarkModeChangedReceiver$trevi_ad_android_sdk_release(null);
        this.webView = null;
    }

    @Override  // androidx.fragment.app.I
    public void onDestroyView() {
        super.onDestroyView();
        View view0 = this.getView();
        if(view0 != null) {
            FrameLayout frameLayout0 = (FrameLayout)view0.findViewById(R.id.cashFriendsWebViewLayout);
            if(frameLayout0 != null) {
                frameLayout0.removeAllViews();
            }
        }
    }

    @Override  // com.kakaoent.trevi.ad.ui.fragment.WebViewBridgeFragment
    public void onPageFinished(@Nullable WebView webView0, @Nullable String s) {
        if(this.doClearHistory) {
            this.doClearHistory = false;
            if(webView0 != null) {
                webView0.clearHistory();
            }
        }
        super.onPageFinished(webView0, s);
    }

    @Override  // com.kakaoent.trevi.ad.ui.fragment.WebViewBridgeFragment
    public void onPageStarted(@Nullable WebView webView0, @Nullable String s, @Nullable Bitmap bitmap0) {
        super.onPageStarted(webView0, s, bitmap0);
        if(webView0 != null) {
            webView0.requestFocus();
        }
    }

    @Override  // com.kakaoent.trevi.ad.ui.fragment.WebViewBridgeFragment
    @d
    public void onReceivedError(@Nullable WebView webView0, int v, @Nullable String s, @Nullable String s1) {
        super.onReceivedError(webView0, v, s, s1);
    }

    @Override  // com.kakaoent.trevi.ad.ui.fragment.WebViewBridgeFragment
    public void onReceivedError(@Nullable WebView webView0, @Nullable WebResourceRequest webResourceRequest0, @Nullable WebResourceError webResourceError0) {
        super.onReceivedError(webView0, webResourceRequest0, webResourceError0);
        TreviLog.INSTANCE.e("CashFriendsWebViewFragment", "onReceivedError() url: " + (webResourceRequest0 == null ? null : webResourceRequest0.getUrl()));
        this.showError(webView0, (webResourceError0 == null ? 0 : webResourceError0.getErrorCode()), (webResourceRequest0 == null ? true : webResourceRequest0.isForMainFrame()));
    }

    @Override  // com.kakaoent.trevi.ad.ui.fragment.WebViewBridgeFragment
    public boolean onRenderProcessGone(@Nullable WebView webView0, @Nullable RenderProcessGoneDetail renderProcessGoneDetail0) {
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            OfferWallCallback treviAd$OfferWallCallback0 = (OfferWallCallback)TreviAd.INSTANCE.getOfferWallCallbackList$trevi_ad_android_sdk_release().get(this.hashCode());
            if(treviAd$OfferWallCallback0 != null) {
                treviAd$OfferWallCallback0.showToast(new WeakReference(this.getActivity()), fragmentActivity0.getString(R.string.trevi_webview_error));
            }
            fragmentActivity0.finish();
        }
        return true;
    }

    @Override  // androidx.fragment.app.I
    public void onResume() {
        super.onResume();
        com.kakaoent.trevi.ad.ui.fragment.CashFriendsWebViewFragment.onResume.1.1 cashFriendsWebViewFragment$onResume$1$10 = new a() {
            {
                CashFriendsWebViewFragment.this = cashFriendsWebViewFragment0;
                super(0);
            }

            // 检测为 Lambda 实现
            public static void d(CashFriendsWebViewFragment cashFriendsWebViewFragment0) [...]

            @Override  // we.a
            public Object invoke() {
                this.invoke();
                return H.a;
            }

            public final void invoke() {
                new Handler(Looper.getMainLooper()).post(() -> com.kakaoent.trevi.ad.ui.fragment.CashFriendsWebViewFragment.onResume.1.1.invoke$lambda$0(CashFriendsWebViewFragment.this));
            }

            private static final void invoke$lambda$0(CashFriendsWebViewFragment cashFriendsWebViewFragment0) {
                q.g(cashFriendsWebViewFragment0, "this$0");
                cashFriendsWebViewFragment0.reload();
            }
        };
        TreviAd.INSTANCE.setLoginReceiver$trevi_ad_android_sdk_release(cashFriendsWebViewFragment$onResume$1$10);
        com.kakaoent.trevi.ad.ui.fragment.CashFriendsWebViewFragment.onResume.1.2 cashFriendsWebViewFragment$onResume$1$20 = new a() {
            {
                CashFriendsWebViewFragment.this = cashFriendsWebViewFragment0;
                super(0);
            }

            @NotNull
            public final Boolean invoke() {
                TreviWebView treviWebView0 = CashFriendsWebViewFragment.this.webView;
                return treviWebView0 == null ? false : Boolean.valueOf(treviWebView0.canGoBack());
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        TreviAd.INSTANCE.setOfferWallGoBackReceiver$trevi_ad_android_sdk_release(cashFriendsWebViewFragment$onResume$1$20);
        com.kakaoent.trevi.ad.ui.fragment.CashFriendsWebViewFragment.onResume.1.3 cashFriendsWebViewFragment$onResume$1$30 = new a() {
            {
                CashFriendsWebViewFragment.this = cashFriendsWebViewFragment0;
                super(0);
            }

            @NotNull
            public final Boolean invoke() {
                TreviWebView treviWebView0 = CashFriendsWebViewFragment.this.webView;
                return treviWebView0 == null ? false : Boolean.valueOf(treviWebView0.onBackPressed());
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        TreviAd.INSTANCE.setOfferWallOnBackPressedReceiver$trevi_ad_android_sdk_release(cashFriendsWebViewFragment$onResume$1$30);
        com.kakaoent.trevi.ad.ui.fragment.CashFriendsWebViewFragment.onResume.1.4 cashFriendsWebViewFragment$onResume$1$40 = new k() {
            {
                CashFriendsWebViewFragment.this = cashFriendsWebViewFragment0;
                super(1);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Boolean)object0).booleanValue());
                return H.a;
            }

            public final void invoke(boolean z) {
                if(CashFriendsWebViewFragment.this.isDarkMode != z) {
                    CashFriendsWebViewFragment.this.isDarkMode = z;
                    CashFriendsWebViewFragment.this.setWebViewUrl();
                    CashFriendsWebViewFragment.this.setTitleColor();
                    TreviWebView treviWebView0 = CashFriendsWebViewFragment.this.webView;
                    if(treviWebView0 != null) {
                        treviWebView0.setWebViewBackgroundColor(CashFriendsWebViewFragment.this.isDarkMode);
                        CashFriendsWebViewFragment.this.doClearHistory = true;
                        treviWebView0.clearCache(true);
                        String s = CashFriendsWebViewFragment.this.webViewUrl;
                        if(s != null) {
                            treviWebView0.loadUrl(s);
                        }
                    }
                }
            }
        };
        TreviAd.INSTANCE.setDarkModeChangedReceiver$trevi_ad_android_sdk_release(cashFriendsWebViewFragment$onResume$1$40);
        if(!this.inLogin) {
            this.reload();
        }
    }

    @Override  // androidx.fragment.app.I
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        if(this.getContext() != null) {
            TreviWebView treviWebView0 = this.webView;
            if(treviWebView0 != null) {
                FrameLayout frameLayout0 = (FrameLayout)view0.findViewById(R.id.cashFriendsWebViewLayout);
                frameLayout0.removeAllViews();
                frameLayout0.addView(treviWebView0);
            }
        }
        View view1 = view0.findViewById(R.id.cashFriendsBackButton);
        if(view1 != null) {
            view1.setOnClickListener(new b(this, 17));
        }
        this.titleTextView = (TextView)view0.findViewById(R.id.cashFriendsTitleTextView);
        this.backButton = (ImageButton)view0.findViewById(0x7F0A0215);  // id:cashFriendsBackButton
        TextView textView0 = this.titleTextView;
        if(textView0 != null) {
            if(this.titleFontRes != 0) {
                textView0.setTypeface(j.a(textView0.getContext(), this.titleFontRes));
            }
            textView0.getLayoutParams().height = NumberExtKt.dpToPx(this.headerHeight);
            textView0.setText(this.titleText);
        }
        ImageButton imageButton0 = this.backButton;
        if(imageButton0 != null) {
            int v = this.backButtonImageRes;
            if(v != 0) {
                imageButton0.setImageResource(v);
            }
            int v1 = NumberExtKt.dpToPx(this.backButtonHorizontalPadding);
            imageButton0.setPadding(v1, 0, v1, 0);
        }
        this.setTitleColor();
        if(TreviAd.INSTANCE.getOfferWallNavigationDelegate$trevi_ad_android_sdk_release() != null) {
            CashFriendsFragment.d0(new WeakReference(this.backButton), new WeakReference(this.titleTextView));
        }
        String s = this.webViewUrl;
        if(s != null) {
            TreviWebView treviWebView1 = this.webView;
            if(treviWebView1 != null) {
                Context context0 = treviWebView1.getContext();
                q.f(context0, "getContext(...)");
                if(NetworkManager.INSTANCE.checkConnect(context0) != null) {
                    this.showNetworkError(true, -6);
                    return;
                }
                if(this.isJustCreatedWebView) {
                    treviWebView1.loadUrl(s);
                    this.isJustCreatedWebView = false;
                }
            }
        }
    }

    private static final void onViewCreated$lambda$8(CashFriendsWebViewFragment cashFriendsWebViewFragment0, View view0) {
        q.g(cashFriendsWebViewFragment0, "this$0");
        if((cashFriendsWebViewFragment0.webView == null ? false : cashFriendsWebViewFragment0.webView.canGoBack())) {
            TreviWebView treviWebView0 = cashFriendsWebViewFragment0.webView;
            if(treviWebView0 != null) {
                treviWebView0.goBack();
            }
        }
        else {
            FragmentActivity fragmentActivity0 = cashFriendsWebViewFragment0.getActivity();
            if(fragmentActivity0 != null) {
                fragmentActivity0.onBackPressed();
            }
        }
    }

    public final void playVideo(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "videoUrl");
        q.g(s1, "orientation");
        q.g(s2, "ask");
        q.g(s3, "popupUrl");
        FragmentActivity fragmentActivity0 = this.getActivity();
        CashFriendsVideoActivity.Companion.startActivity(fragmentActivity0, s, s1, s2, s3, this.videoPlayResultReceiver, this.hashCode());
    }

    public final void reload() {
        TreviLog.INSTANCE.d("CashFriendsWebViewFragment", "reload called");
        TreviWebView treviWebView0 = this.webView;
        if(treviWebView0 != null) {
            treviWebView0.evaluateJavascript("javascript:window." + TreviAd.INSTANCE.getServiceCode$trevi_ad_android_sdk_release() + "Web.reload();", (String s) -> CashFriendsWebViewFragment.reload$lambda$23(s));
        }
    }

    private static final void reload$lambda$23(String s) {
        TreviLog.INSTANCE.d("CashFriendsWebViewFragment", "reload called js callback : " + s);
    }

    public final void setHeaderTitle(@Nullable String s, @Nullable String s1, float f) {
        this.titleText = s1 == null ? "" : s1;
        TextView textView0 = this.titleTextView;
        if(textView0 != null) {
            textView0.setText(s1);
        }
        if(this.isDarkMode) {
            TextView textView1 = this.titleTextView;
            if(textView1 != null) {
                textView1.setAlpha(f);
            }
            ImageButton imageButton0 = this.backButton;
            if(imageButton0 != null) {
                imageButton0.setAlpha(f);
            }
        }
    }

    private final void setTitleColor() {
        Context context0 = this.getContext();
        if(context0 != null) {
            int v = c.getColor(context0, (this.isDarkMode ? R.color.trevi_white : R.color.trevi_black));
            TextView textView0 = this.titleTextView;
            if(textView0 != null) {
                textView0.setBackgroundColor(c.getColor(context0, R.color.trevi_title_background_color));
                textView0.setTextColor(v);
            }
            if(this.backButtonImageRes == 0) {
                ImageButton imageButton0 = this.backButton;
                if(imageButton0 != null) {
                    imageButton0.setColorFilter(v);
                }
            }
        }
    }

    private final void setWebViewUrl() {
        StringBuilder stringBuilder0 = new StringBuilder();
        if(this.query.length() > 0) {
            stringBuilder0.append(this.query);
        }
        if(o.v0(this.query, "?", false)) {
            stringBuilder0.append("&");
        }
        else {
            stringBuilder0.append("?");
        }
        stringBuilder0.append("isLightMode=" + !this.isDarkMode);
        stringBuilder0.append("&offerwallHeaderHeight=" + this.headerHeight);
        stringBuilder0.append("&sdkVersion=2.3.0&useOpenAppSchemeUrl=true");
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        this.webViewUrl = TreviAd.INSTANCE.getServerConfig$trevi_ad_android_sdk_release().getOfferWallUrl() + s;
        TreviLog.INSTANCE.d("CashFriendsWebViewFragment", "setWebViewUrl() webViewUrl: " + this.webViewUrl);
    }

    public final void showAdIdSetting() {
        this.startActivity(new Intent("com.google.android.gms.settings.ADS_PRIVACY"));
    }

    public final void showCustomerCenter() {
        OfferWallCallback treviAd$OfferWallCallback0 = (OfferWallCallback)TreviAd.INSTANCE.getOfferWallCallbackList$trevi_ad_android_sdk_release().get(this.hashCode());
        if(treviAd$OfferWallCallback0 != null) {
            treviAd$OfferWallCallback0.showCustomerCenter(new WeakReference(this.getActivity()));
        }
    }

    @SuppressLint({"StringFormatInvalid"})
    private final void showError(WebView webView0, int v, boolean z) {
        if(this.isAdded()) {
            Context context0 = this.getContext();
            if(context0 != null) {
                if(NetworkManager.INSTANCE.checkConnect(context0) != null) {
                    this.showNetworkError(false, -6);
                    return;
                }
                TreviLog.INSTANCE.e("CashFriendsWebViewFragment", "showError: " + v);
                if(v == -8 || (v == -7 || v == -6) || v == -2) {
                    this.showNetworkError(false, v);
                }
                else if(v != -1 && z) {
                    OfferWallCallback treviAd$OfferWallCallback0 = (OfferWallCallback)TreviAd.INSTANCE.getOfferWallCallbackList$trevi_ad_android_sdk_release().get(this.hashCode());
                    if(treviAd$OfferWallCallback0 != null) {
                        treviAd$OfferWallCallback0.showToast(new WeakReference(this.getActivity()), this.getString(R.string.trevi_temporary_error, new Object[]{v}));
                    }
                }
            }
        }
    }

    public final void showLogin() {
        this.inLogin = true;
        TreviAd treviAd0 = TreviAd.INSTANCE;
        OfferWallCallback treviAd$OfferWallCallback0 = (OfferWallCallback)treviAd0.getOfferWallCallbackList$trevi_ad_android_sdk_release().get(this.hashCode());
        if(treviAd$OfferWallCallback0 != null) {
            treviAd$OfferWallCallback0.showLogin(new WeakReference(this.getActivity()), treviAd0.getLoginHandler$trevi_ad_android_sdk_release());
        }
    }

    private final void showNetworkError(boolean z, int v) {
        long v1 = System.currentTimeMillis();
        if(this.networkErrorTime + 300L <= v1) {
            this.networkErrorTime = v1;
            OfferWallCallback treviAd$OfferWallCallback0 = (OfferWallCallback)TreviAd.INSTANCE.getOfferWallCallbackList$trevi_ad_android_sdk_release().get(this.hashCode());
            if(treviAd$OfferWallCallback0 != null) {
                treviAd$OfferWallCallback0.onNetworkError(new WeakReference(this.getActivity()), z, v, new a() {
                    {
                        CashFriendsWebViewFragment.this = cashFriendsWebViewFragment0;
                        super(0);
                    }

                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        String s = CashFriendsWebViewFragment.this.webViewUrl;
                        if(s != null) {
                            TreviWebView treviWebView0 = CashFriendsWebViewFragment.this.webView;
                            if(treviWebView0 != null) {
                                CashFriendsWebViewFragment cashFriendsWebViewFragment0 = CashFriendsWebViewFragment.this;
                                if(treviWebView0.canGoBack()) {
                                    treviWebView0.reload();
                                    treviWebView0.goBack();
                                    return;
                                }
                                cashFriendsWebViewFragment0.doClearHistory = true;
                                treviWebView0.loadUrl(s);
                            }
                        }
                    }
                });
            }
            if(this.errorPageAssetFileName.length() == 0) {
                TreviWebView treviWebView0 = this.webView;
                if(treviWebView0 != null) {
                    treviWebView0.loadDataWithBaseURL("", "<HTML><BODY></BODY></HTML>", "text/html", "utf-8", "");
                }
            }
            else {
                TreviWebView treviWebView1 = this.webView;
                if(treviWebView1 != null) {
                    treviWebView1.loadUrl("file:///android_asset/" + this.errorPageAssetFileName);
                }
            }
        }
    }
}

