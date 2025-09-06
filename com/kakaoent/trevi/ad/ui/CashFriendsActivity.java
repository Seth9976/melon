package com.kakaoent.trevi.ad.ui;

import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.l0;
import com.kakaoent.trevi.ad.R.id;
import com.kakaoent.trevi.ad.R.layout;
import com.kakaoent.trevi.ad.TreviAd;
import com.kakaoent.trevi.ad.ui.fragment.CashFriendsWebViewFragment;
import com.kakaoent.trevi.ad.util.StatusBarManager;
import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\u0018\u0000 \u001C2\u00020\u0001:\u0001\u001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001A\u00060\u0004R\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000B\u0010\fR\u0016\u0010\u000E\u001A\u00020\r8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR\u0016\u0010\u0010\u001A\u00020\r8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u000FR\u0016\u0010\u0012\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001A\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0014\u0010\u000FR\u0016\u0010\u0016\u001A\u00020\u00158\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001A\u00020\u00118\u0002@\u0002X\u0083\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0016\u0010\u0019\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0016\u0010\u001A\u001A\u00020\u00118\u0002@\u0002X\u0083\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u0013R\u0016\u0010\u001B\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001B\u0010\u0013¨\u0006\u001D"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/CashFriendsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "getTheme", "()Landroid/content/res/Resources$Theme;", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "", "queryParams", "Ljava/lang/String;", "errorPageAssetFileName", "", "mStatusBarColor", "I", "appUserId", "", "isDarkMode", "Z", "backButtonImageRes", "backButtonHorizontalPadding", "titleFontRes", "headerHeight", "Companion", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class CashFriendsActivity extends AppCompatActivity {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u000B\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000B\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000B\u0010\u0006R\u0014\u0010\f\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000E\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000E\u0010\u0006¨\u0006\u000F"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/CashFriendsActivity$Companion;", "", "<init>", "()V", "", "EXTRA_ACTIVITY_THEME", "Ljava/lang/String;", "EXTRA_APP_USER_ID", "EXTRA_BACK_BUTTON_HORIZONTAL_PADDING", "EXTRA_BACK_BUTTON_IMAGE_RES", "EXTRA_DARK_MODE", "EXTRA_ERROR_PAGE_ASSET_FILE_NAME", "EXTRA_HEADER_HEIGHT", "EXTRA_QUERY_PARAMS", "EXTRA_TITLE_FONT_RES", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String EXTRA_ACTIVITY_THEME = "EXTRA_ACTIVITY_THEME";
    @NotNull
    private static final String EXTRA_APP_USER_ID = "EXTRA_USER_ID";
    @NotNull
    private static final String EXTRA_BACK_BUTTON_HORIZONTAL_PADDING = "EXTRA_BACK_BUTTON_HORIZONTAL_PADDING";
    @NotNull
    private static final String EXTRA_BACK_BUTTON_IMAGE_RES = "EXTRA_BACK_BUTTON_IMAGE_RES";
    @NotNull
    private static final String EXTRA_DARK_MODE = "EXTRA_DARK_MODE";
    @NotNull
    private static final String EXTRA_ERROR_PAGE_ASSET_FILE_NAME = "EXTRA_ERROR_PAGE_ASSET_FILE_NAME";
    @NotNull
    private static final String EXTRA_HEADER_HEIGHT = "EXTRA_HEADER_HEIGHT";
    @NotNull
    private static final String EXTRA_QUERY_PARAMS = "EXTRA_CASH_FRIENDS_ID";
    @NotNull
    private static final String EXTRA_TITLE_FONT_RES = "EXTRA_TITLE_FONT_RES";
    @Nullable
    private String appUserId;
    private int backButtonHorizontalPadding;
    private int backButtonImageRes;
    @NotNull
    private String errorPageAssetFileName;
    private int headerHeight;
    private boolean isDarkMode;
    private int mStatusBarColor;
    @NotNull
    private String queryParams;
    private int titleFontRes;

    static {
        CashFriendsActivity.Companion = new Companion(null);
    }

    public CashFriendsActivity() {
        this.queryParams = "";
        this.errorPageAssetFileName = "";
        this.mStatusBarColor = 0xFF000000;
        this.backButtonHorizontalPadding = 18;
        this.headerHeight = 44;
    }

    @Override  // android.view.ContextThemeWrapper
    @NotNull
    public Resources.Theme getTheme() {
        Resources.Theme resources$Theme0 = super.getTheme();
        Bundle bundle0 = this.getIntent().getExtras();
        int v = bundle0 == null ? 0 : bundle0.getInt("EXTRA_ACTIVITY_THEME", 0);
        if(v != 0) {
            resources$Theme0.applyStyle(v, true);
        }
        q.d(resources$Theme0);
        return resources$Theme0;
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.setContentView(R.layout.trevi_cash_friends_activity);
        com.kakaoent.trevi.ad.ui.CashFriendsActivity.onCreate.1 cashFriendsActivity$onCreate$10 = new a() {
            {
                CashFriendsActivity.this = cashFriendsActivity0;
                super(0);
            }

            @Override  // we.a
            public Object invoke() {
                this.invoke();
                return H.a;
            }

            public final void invoke() {
                CashFriendsActivity.this.finish();
            }
        };
        TreviAd.INSTANCE.setOfferWallActivityFinishReceiver$trevi_ad_android_sdk_release(cashFriendsActivity$onCreate$10);
        Bundle bundle1 = this.getIntent().getExtras();
        if(bundle1 != null) {
            this.appUserId = bundle1.getString("EXTRA_USER_ID", "");
            this.isDarkMode = bundle1.getBoolean("EXTRA_DARK_MODE", false);
            this.backButtonImageRes = bundle1.getInt("EXTRA_BACK_BUTTON_IMAGE_RES", 0);
            this.backButtonHorizontalPadding = bundle1.getInt("EXTRA_BACK_BUTTON_HORIZONTAL_PADDING", 18);
            this.titleFontRes = bundle1.getInt("EXTRA_TITLE_FONT_RES", 0);
            this.headerHeight = bundle1.getInt("EXTRA_HEADER_HEIGHT", 44);
            String s = bundle1.getString("EXTRA_CASH_FRIENDS_ID", "");
            q.f(s, "getString(...)");
            this.queryParams = s;
            String s1 = bundle1.getString("EXTRA_ERROR_PAGE_ASSET_FILE_NAME", "");
            q.f(s1, "getString(...)");
            this.errorPageAssetFileName = s1;
        }
        this.mStatusBarColor = this.isDarkMode ? 0xFF000000 : -1;
        if(this.isDarkMode) {
            Window window0 = this.getWindow();
            StatusBarManager.INSTANCE.updateStatusBarDarkTheme(window0);
        }
        else {
            Window window1 = this.getWindow();
            StatusBarManager.INSTANCE.updateStatusBarLightTheme(window1);
        }
        l0 l00 = this.getSupportFragmentManager();
        q.f(l00, "getSupportFragmentManager(...)");
        if(l00.E("CashFriendsWebViewFragment") == null) {
            androidx.fragment.app.a a0 = new androidx.fragment.app.a(l00);
            CashFriendsWebViewFragment cashFriendsWebViewFragment0 = com.kakaoent.trevi.ad.ui.fragment.CashFriendsWebViewFragment.Companion.newInstance$default(CashFriendsWebViewFragment.Companion, this.appUserId, this.isDarkMode, this.backButtonImageRes, this.backButtonHorizontalPadding, this.titleFontRes, this.headerHeight, this.queryParams, this.errorPageAssetFileName, false, false, 0x300, null);
            a0.g(R.id.id_fragment_container, cashFriendsWebViewFragment0, "CashFriendsWebViewFragment");
            a0.k();
        }
    }
}

