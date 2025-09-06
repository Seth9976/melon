package com.iloen.melon.activity;

import S1.d;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import b.a;
import c2.B0;
import c2.M;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.g1;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.kakao.emoticon.ui.widget.b;
import com.melon.ui.c0;
import i.n.i.b.a.s.e.M3;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import l8.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001\'B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001A\u00020\u00072\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001A\u00020\u0007¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\f\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\u0005H\u0014¢\u0006\u0004\b\f\u0010\tJ\u0017\u0010\u000E\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u000E\u0010\tJ\u000F\u0010\u000F\u001A\u00020\u0007H\u0014¢\u0006\u0004\b\u000F\u0010\u0004J\u000F\u0010\u0010\u001A\u00020\u0007H\u0014¢\u0006\u0004\b\u0010\u0010\u0004J\u000F\u0010\u0011\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000F\u0010\u0013\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u001A\u001A\u0004\u0018\u00010\u00198\u0004@\u0004X\u0084\u000E¢\u0006\u0012\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR\u0016\u0010 \u001A\u00020\u00128\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001A\u0004\u0018\u00010\"8TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/iloen/melon/activity/PopupFragmentActivity;", "Lcom/iloen/melon/activity/PopupFragmentBaseActivity;", "Lcom/iloen/melon/custom/g1;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "destroyActivity", "inState", "onRestoreInstanceState", "outState", "onSaveInstanceState", "onResume", "onPause", "onBackPressedCallback", "", "removeFragment", "()Z", "Lcom/iloen/melon/custom/f1;", "type", "updateSystemUiFit", "(Lcom/iloen/melon/custom/f1;)V", "Landroid/view/View;", "fragmentContainer", "Landroid/view/View;", "getFragmentContainer", "()Landroid/view/View;", "setFragmentContainer", "(Landroid/view/View;)V", "lastHighContrastMode", "Z", "Landroidx/fragment/app/I;", "getAddFragment", "()Landroidx/fragment/app/I;", "addFragment", "Companion", "l8/y", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class PopupFragmentActivity extends PopupFragmentBaseActivity implements g1 {
    public static final int $stable = 8;
    @NotNull
    private static final String ARG_LAST_HIGH_CONTRAST_MODE = "ARG_LAST_HIGH_CONTRAST_MODE";
    @NotNull
    public static final y Companion = null;
    @NotNull
    private static final String TAG = "PopupFragmentActivity";
    @Nullable
    private View fragmentContainer;
    private boolean lastHighContrastMode;

    static {
        PopupFragmentActivity.Companion = new y();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final void destroyActivity() {
        this.removeFragment();
        this.finish();
    }

    @Nullable
    public I getAddFragment() {
        return null;
    }

    @Nullable
    public final View getFragmentContainer() {
        return this.fragmentContainer;
    }

    @Override  // com.iloen.melon.activity.PopupFragmentBaseActivity
    public void onBackPressedCallback() {
        LogU.Companion.d("PopupFragmentActivity", "onBackPressedCallback() : " + this);
        if(this.getFragmentCount() <= 1) {
            this.destroyActivity();
            return;
        }
        super.onBackPressedCallback();
    }

    @Override  // com.iloen.melon.activity.PopupFragmentBaseActivity
    public void onBackStackChangeCancelled() {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentBaseActivity
    public void onBackStackChangeCommitted(I i0, boolean z) {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentBaseActivity
    public void onBackStackChangeProgressed(a a0) {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentBaseActivity
    public void onBackStackChangeStarted(I i0, boolean z) {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentBaseActivity
    public void onCreate(@Nullable Bundle bundle0) {
        LogU.Companion.d("PopupFragmentActivity", "onCreate() activity:" + this);
        super.onCreate(bundle0);
        if(!this.lastHighContrastMode && ScreenUtils.INSTANCE.isHighContrastMode()) {
            this.setTheme(0x7F140171);  // style:HighContrastAppTheme
        }
        this.overridePendingTransition(0, 0);
        this.setContentView(0x7F0D0020);  // layout:activity_popup_fragment
        this.fragmentContainer = this.findViewById(0x7F0A04DB);  // id:fragment
        this.addFragment(this.getAddFragment());
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onPause() {
        LogU.Companion.d("PopupFragmentActivity", "onPause()");
        super.onPause();
    }

    @Override  // android.app.Activity
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        super.onRestoreInstanceState(bundle0);
        this.lastHighContrastMode = bundle0.getBoolean("ARG_LAST_HIGH_CONTRAST_MODE", false);
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onResume() {
        LogU.Companion.d("PopupFragmentActivity", "onResume()");
        super.onResume();
    }

    @Override  // androidx.activity.ComponentActivity
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putBoolean("ARG_LAST_HIGH_CONTRAST_MODE", this.lastHighContrastMode);
    }

    @Override  // com.iloen.melon.activity.PopupFragmentBaseActivity
    public boolean removeFragment() {
        int v = this.getSupportFragmentManager().J();
        if(v > 0) {
            androidx.fragment.app.a a0 = this.getSupportFragmentManager().I(v - 1);
            q.f(a0, "getBackStackEntryAt(...)");
            I i0 = this.getSupportFragmentManager().E(a0.i);
            if(i0 != null) {
                l0 l00 = this.getSupportFragmentManager();
                l00.getClass();
                androidx.fragment.app.a a1 = new androidx.fragment.app.a(l00);
                a1.d(i0);
                a1.f(i0);
                a1.l(true, true);
                this.getSupportFragmentManager().X();
                return true;
            }
        }
        return false;
    }

    public final void setFragmentContainer(@Nullable View view0) {
        this.fragmentContainer = view0;
    }

    @Override  // com.iloen.melon.custom.g1
    public void updateSystemUiFit(@NotNull f1 f10) {
        q.g(f10, "type");
        View view0 = this.fragmentContainer;
        if(view0 != null) {
            switch(f10.ordinal()) {
                case 0: {
                    view0.setFitsSystemWindows(false);
                    M.n(view0, new b(view0, 5));
                    ScreenUtils.setAppearanceLightStatusBars(this.getWindow(), ((boolean)(true ^ ScreenUtils.isDarkMode(this.getBaseContext()))));
                    break;
                }
                case 1: {
                    view0.setFitsSystemWindows(false);
                    M.n(view0, new b(view0, 6));
                    ScreenUtils.setAppearanceLightStatusBars(this.getWindow(), false);
                    break;
                }
                case 2: {
                    view0.setFitsSystemWindows(false);
                    M.n(view0, new b(view0, 7));
                    ScreenUtils.setAppearanceLightStatusBars(this.getWindow(), ((boolean)(true ^ ScreenUtils.isDarkMode(this.getBaseContext()))));
                    break;
                }
                case 3: {
                    I i0 = this.getCurrentFragment();
                    c0 c00 = i0 instanceof c0 ? ((c0)i0) : null;
                    if(c00 != null) {
                        k k0 = c00.getCustomInsetHandling();
                        if(k0 != null) {
                            k0.invoke(view0);
                        }
                    }
                    break;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
            view0.requestApplyInsets();
        }
    }

    private static final B0 updateSystemUiFit$lambda$3$lambda$0(View view0, View view1, B0 b00) {
        q.g(view1, "<unused var>");
        q.g(b00, "insets");
        d d0 = b00.a.g(647);
        q.f(d0, "getInsets(...)");
        view0.setPadding(d0.a, d0.b, d0.c, d0.d);
        return b00;
    }

    private static final B0 updateSystemUiFit$lambda$3$lambda$1(View view0, View view1, B0 b00) {
        q.g(view1, "<unused var>");
        q.g(b00, "insets");
        d d0 = b00.a.g(647);
        q.f(d0, "getInsets(...)");
        view0.setPadding(d0.a, 0, d0.c, d0.d);
        return b00;
    }

    private static final B0 updateSystemUiFit$lambda$3$lambda$2(View view0, View view1, B0 b00) {
        q.g(view1, "<unused var>");
        q.g(b00, "insets");
        d d0 = b00.a.g(0x28F);
        q.f(d0, "getInsets(...)");
        view0.setPadding(d0.a, d0.b, d0.c, d0.d);
        return b00;
    }
}

