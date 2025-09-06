package com.iloen.melon.activity;

import Qd.e;
import Tf.o;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import androidx.fragment.app.w;
import androidx.lifecycle.f0;
import androidx.lifecycle.y;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.U;
import com.iloen.melon.custom.V;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.g1;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventNotificationDialog;
import com.iloen.melon.eventbus.EventNotificationScheme;
import com.iloen.melon.fragments.MelonFragmentManager.FragmentAnimations;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.fragments.tabs.BottomTabBaseFragment;
import com.iloen.melon.fragments.tabs.BottomTabPagerAdapter;
import com.iloen.melon.fragments.webview.MelonWebViewFragment;
import com.iloen.melon.fragments.webview.PopupWebView;
import com.iloen.melon.net.HttpResponse.Notification.Buttons;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.popup.FullscreenProgressDialog;
import com.iloen.melon.popup.RetainPopup;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import d3.g;
import gd.r5;
import ie.H;
import ie.j;
import java.util.HashMap;
import javax.inject.Inject;
import k8.a;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import l8.d;
import l8.f;
import mb.k;
import mb.s;
import me.i;
import ob.z;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r8.b;
import vd.E;

@Metadata(d1 = {"\u0000\u00AE\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\b\'\u0018\u0000 v2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001wB\u0007\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0014\u00A2\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b\r\u0010\u0007J\u000F\u0010\u000E\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u0007J\u000F\u0010\u0010\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0011J\u0011\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u0004\u0018\u00010\u0013\u00A2\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0018\u001A\u00020\n2\b\u0010\u0017\u001A\u0004\u0018\u00010\u0013\u00A2\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u0018\u001A\u00020\n2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00132\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B\u00A2\u0006\u0004\b\u0018\u0010\u001DJ+\u0010\u0018\u001A\u00020\n2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00132\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001E\u00A2\u0006\u0004\b\u0018\u0010 J\r\u0010!\u001A\u00020\u000F\u00A2\u0006\u0004\b!\u0010\u0011J\r\u0010\"\u001A\u00020\u000F\u00A2\u0006\u0004\b\"\u0010\u0011J\u0015\u0010\"\u001A\u00020\u000F2\u0006\u0010$\u001A\u00020#\u00A2\u0006\u0004\b\"\u0010%J\r\u0010&\u001A\u00020\n\u00A2\u0006\u0004\b&\u0010\u0007J\u001B\u0010(\u001A\u00020\n2\n\b\u0002\u0010\'\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\b(\u0010)J\r\u0010*\u001A\u00020\n\u00A2\u0006\u0004\b*\u0010\u0007J\u000F\u0010+\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b+\u0010\u0011J\r\u0010,\u001A\u00020\n\u00A2\u0006\u0004\b,\u0010\u0007J\u000F\u0010-\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b-\u0010\u0011J\r\u0010.\u001A\u00020\n\u00A2\u0006\u0004\b.\u0010\u0007J\r\u0010/\u001A\u00020\n\u00A2\u0006\u0004\b/\u0010\u0007J\u000F\u00100\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b0\u0010\u0011J\u0017\u00103\u001A\u00020\n2\u0006\u00102\u001A\u000201H\u0007\u00A2\u0006\u0004\b3\u00104J\r\u00105\u001A\u00020\n\u00A2\u0006\u0004\b5\u0010\u0007J\u0017\u00103\u001A\u00020\n2\u0006\u00102\u001A\u000206H\u0007\u00A2\u0006\u0004\b3\u00107J\u000F\u00108\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b8\u0010\u0007J\u0017\u0010:\u001A\u00020\u000F2\u0006\u00109\u001A\u00020#H\u0002\u00A2\u0006\u0004\b:\u0010%J!\u0010:\u001A\u00020\u000F2\u0006\u00109\u001A\u00020#2\b\u0010;\u001A\u0004\u0018\u00010\u001BH\u0002\u00A2\u0006\u0004\b:\u0010<J\u0019\u0010>\u001A\u00020\n2\b\u0010=\u001A\u0004\u0018\u00010\u001BH\u0002\u00A2\u0006\u0004\b>\u0010)J\u0017\u0010?\u001A\u00020\n2\u0006\u00102\u001A\u000201H\u0002\u00A2\u0006\u0004\b?\u00104R0\u0010B\u001A\u001E\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020#0@j\u000E\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020#`A8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001A\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010H\u001A\u00020G8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bH\u0010IR\"\u0010K\u001A\u00020J8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bK\u0010L\u001A\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010R\u001A\u00020Q8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bR\u0010S\u001A\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010Y\u001A\u00020X8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bY\u0010Z\u001A\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010`\u001A\u00020_8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b`\u0010a\u001A\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010g\u001A\u00020f8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bg\u0010h\u001A\u0004\bi\u0010j\"\u0004\bk\u0010lR\u001B\u0010r\u001A\u00020m8FX\u0086\u0084\u0002\u00A2\u0006\f\n\u0004\bn\u0010o\u001A\u0004\bp\u0010qR\u0011\u0010u\u001A\u00020#8F\u00A2\u0006\u0006\u001A\u0004\bs\u0010t\u00A8\u0006x"}, d2 = {"Lcom/iloen/melon/activity/BaseActivity;", "Lcom/iloen/melon/activity/PermissionSupportActivity;", "Lr8/b;", "Lcom/iloen/melon/custom/V;", "Lcom/iloen/melon/custom/U;", "Lcom/iloen/melon/custom/g1;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "onBackPressedCallback", "", "shouldIgnoreForeground", "()Z", "isLockScreen", "Landroidx/fragment/app/I;", "getCurrentFragment", "()Landroidx/fragment/app/I;", "getFragment", "f", "addFragment", "(Landroidx/fragment/app/I;)V", "fragment", "", "tag", "(Landroidx/fragment/app/I;Ljava/lang/String;)V", "Lcom/iloen/melon/fragments/MelonFragmentManager$FragmentAnimations;", "animations", "(Landroidx/fragment/app/I;Ljava/lang/String;Lcom/iloen/melon/fragments/MelonFragmentManager$FragmentAnimations;)V", "removeFragment", "navigateBack", "", "count", "(I)Z", "goToHome", "text", "showMelonProgressDialog", "(Ljava/lang/String;)V", "dismissMelonProgressDialog", "isMelonProgressDialogShowing", "hideAllPopup", "isProgressShowing", "closeAllPopupWebView", "closeAllWebViewFragment", "isUseToastInsteadNotificationDialog", "Lcom/iloen/melon/eventbus/EventNotificationDialog;", "event", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventNotificationDialog;)V", "dismissEventNotificationDialog", "Lcom/iloen/melon/eventbus/EventNotificationScheme;", "(Lcom/iloen/melon/eventbus/EventNotificationScheme;)V", "initBigUserBlockedProgressDialog", "index", "removeFragmentByIndex", "newFragmentTag", "(ILjava/lang/String;)Z", "linkUri", "executeLinkUri", "showEventNotificationDialog", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "tagStack", "Ljava/util/HashMap;", "Lcom/iloen/melon/popup/FullscreenProgressDialog;", "fullscreenProgressDialog", "Lcom/iloen/melon/popup/FullscreenProgressDialog;", "Lme/i;", "mainDispatcher", "Lme/i;", "Lk8/a;", "blockingProgressDialogManage", "Lk8/a;", "getBlockingProgressDialogManage", "()Lk8/a;", "setBlockingProgressDialogManage", "(Lk8/a;)V", "Lob/z;", "playerUseCase", "Lob/z;", "getPlayerUseCase", "()Lob/z;", "setPlayerUseCase", "(Lob/z;)V", "Lmb/k;", "loginUseCase", "Lmb/k;", "getLoginUseCase", "()Lmb/k;", "setLoginUseCase", "(Lmb/k;)V", "Lmb/f;", "kakaoLoginUseCase", "Lmb/f;", "getKakaoLoginUseCase", "()Lmb/f;", "setKakaoLoginUseCase", "(Lmb/f;)V", "Lmb/s;", "tokenCheckUseCase", "Lmb/s;", "getTokenCheckUseCase", "()Lmb/s;", "setTokenCheckUseCase", "(Lmb/s;)V", "LQd/e;", "kakaoLoginHelper$delegate", "Lie/j;", "getKakaoLoginHelper", "()LQd/e;", "kakaoLoginHelper", "getFragmentCount", "()I", "fragmentCount", "Companion", "l8/f", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class BaseActivity extends Hilt_BaseActivity implements U, V, g1, b {
    public static final int $stable = 8;
    @NotNull
    public static final f Companion = null;
    private static final boolean DEBUG = false;
    @NotNull
    private static final String TAG = "BaseActivity";
    @Inject
    public a blockingProgressDialogManage;
    @Nullable
    private FullscreenProgressDialog fullscreenProgressDialog;
    @NotNull
    private final j kakaoLoginHelper$delegate;
    @Inject
    public mb.f kakaoLoginUseCase;
    @Inject
    public k loginUseCase;
    @NotNull
    private final i mainDispatcher;
    @Inject
    public z playerUseCase;
    @NotNull
    private final HashMap tagStack;
    @Inject
    public s tokenCheckUseCase;

    static {
        BaseActivity.Companion = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        BaseActivity.DEBUG = false;
    }

    public BaseActivity() {
        this.tagStack = new HashMap();
        this.mainDispatcher = Dispatchers.getMain();
        this.kakaoLoginHelper$delegate = g.Q(new d(this, 0));
    }

    public final void addFragment(@Nullable I i0) {
        this.addFragment(i0, null);
    }

    public final void addFragment(@Nullable I i0, @Nullable String s) {
        this.addFragment(i0, s, null);
    }

    public final void addFragment(@Nullable I i0, @Nullable String s, @Nullable FragmentAnimations melonFragmentManager$FragmentAnimations0) {
        synchronized(this) {
            if(i0 != null) {
                BottomTabBaseFragment bottomTabBaseFragment0 = this.getCurrentTabContainerFragment();
                if(bottomTabBaseFragment0 != null) {
                    bottomTabBaseFragment0.addFragment(i0, s, melonFragmentManager$FragmentAnimations0);
                }
            }
        }
    }

    public final void closeAllPopupWebView() {
        while(this.getCurrentFragment() instanceof PopupWebView) {
            if(this.getFragmentCount() > 1) {
                this.dismissMelonProgressDialog();
                this.navigateBack();
            }
        }
    }

    public final void closeAllWebViewFragment() {
        while(this.getCurrentFragment() instanceof MelonWebViewFragment) {
            if(this.getFragmentCount() > 1) {
                this.dismissMelonProgressDialog();
                this.navigateBack();
            }
        }
    }

    public final void dismissEventNotificationDialog() {
        BaseActivity baseActivity0;
        if(BaseActivity.DEBUG) {
            LogU.Companion.v("BaseActivity", "dismissEventNotificationDialog()");
        }
        MelonFragmentManager melonFragmentManager0 = MelonFragmentManager.getInstance();
        if(this.isFinishing()) {
            baseActivity0 = melonFragmentManager0.getCurrentActivity();
            q.f(baseActivity0, "getCurrentActivity(...)");
        }
        else {
            baseActivity0 = this;
        }
        l0 l00 = baseActivity0.getSupportFragmentManager();
        E e0 = E.c;
        if(l00 != null) {
            w w0 = com.melon.ui.popup.b.b(l00, "", e0, null, 8);
            if(w0 != null) {
                w0.dismissAllowingStateLoss();
            }
        }
    }

    public final void dismissMelonProgressDialog() {
        if(BaseActivity.DEBUG) {
            LogU.Companion.v("BaseActivity", "dismissMelonProgressDialog()");
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new l8.g(this, null), 3, null);
    }

    private final void executeLinkUri(String s) {
        if(TextUtils.isEmpty(s)) {
            return;
        }
        LogU.Companion.v("BaseActivity", "executeLinkUri() linkUri:" + s);
        EventNotificationScheme eventNotificationScheme0 = new EventNotificationScheme();
        eventNotificationScheme0.scheme = s;
        EventBusHelper.post(eventNotificationScheme0);
    }

    @NotNull
    public final a getBlockingProgressDialogManage() {
        a a0 = this.blockingProgressDialogManage;
        if(a0 != null) {
            return a0;
        }
        q.m("blockingProgressDialogManage");
        throw null;
    }

    @Nullable
    public abstract BottomTabPagerAdapter getBottomTabPagerAdapter();

    @Nullable
    public abstract View getCtlBottom();

    @Nullable
    public I getCurrentFragment() {
        BottomTabBaseFragment bottomTabBaseFragment0 = this.getCurrentTabContainerFragment();
        return bottomTabBaseFragment0 == null ? null : bottomTabBaseFragment0.getCurrentFragment();
    }

    @Override  // com.iloen.melon.custom.V
    @Nullable
    public abstract BottomTabBaseFragment getCurrentTabContainerFragment();

    @Nullable
    public final I getFragment() {
        BottomTabBaseFragment bottomTabBaseFragment0 = this.getCurrentTabContainerFragment();
        return bottomTabBaseFragment0 == null ? null : bottomTabBaseFragment0.getFragment();
    }

    public final int getFragmentCount() {
        BottomTabBaseFragment bottomTabBaseFragment0 = this.getCurrentTabContainerFragment();
        return bottomTabBaseFragment0 == null ? 0 : bottomTabBaseFragment0.getFragmentCount();
    }

    @NotNull
    public final e getKakaoLoginHelper() {
        return (e)this.kakaoLoginHelper$delegate.getValue();
    }

    @NotNull
    public final mb.f getKakaoLoginUseCase() {
        mb.f f0 = this.kakaoLoginUseCase;
        if(f0 != null) {
            return f0;
        }
        q.m("kakaoLoginUseCase");
        throw null;
    }

    @NotNull
    public final k getLoginUseCase() {
        k k0 = this.loginUseCase;
        if(k0 != null) {
            return k0;
        }
        q.m("loginUseCase");
        throw null;
    }

    @Override  // com.iloen.melon.custom.U
    public abstract int getMiniPlayerHeight();

    @NotNull
    public final z getPlayerUseCase() {
        z z0 = this.playerUseCase;
        if(z0 != null) {
            return z0;
        }
        q.m("playerUseCase");
        throw null;
    }

    @NotNull
    public final s getTokenCheckUseCase() {
        s s0 = this.tokenCheckUseCase;
        if(s0 != null) {
            return s0;
        }
        q.m("tokenCheckUseCase");
        throw null;
    }

    public final void goToHome() {
        LogU.Companion.v("BaseActivity", "goToHome()");
        this.getCurrentTabContainerFragment();
        this.hideAllPopup();
        this.removeFragmentByIndex(1);
        this.tagStack.clear();
    }

    public final void hideAllPopup() {
        I i0 = this.getFragment();
        if(!(i0 instanceof RetainPopup)) {
            return;
        }
        ((RetainPopup)i0).dismissRetainedPopup();
    }

    private final void initBigUserBlockedProgressDialog() {
        y y0 = f0.f(this);
        l8.j j0 = new l8.j(this, null);
        BuildersKt__Builders_commonKt.launch$default(y0, this.mainDispatcher, null, j0, 2, null).invokeOnCompletion(new hd.i(this, 15));
    }

    private static final H initBigUserBlockedProgressDialog$lambda$2(BaseActivity baseActivity0, Throwable throwable0) {
        l0 l00 = baseActivity0.getSupportFragmentManager();
        if(l00 != null && !l00.T() && !l00.K) {
            l00.C();
            vd.e e0 = null;
            w w0 = com.melon.ui.popup.b.b(l00, "BlockingProgressDialogFragment", null, null, 12);
            if(w0 != null) {
                if(w0 instanceof vd.e) {
                    e0 = (vd.e)w0;
                }
                if(e0 != null) {
                    e0.dismissAllowingStateLoss();
                }
            }
        }
        return H.a;
    }

    @Override  // r8.b
    public boolean isLockScreen() {
        return false;
    }

    public boolean isMelonProgressDialogShowing() {
        return this.fullscreenProgressDialog == null ? false : this.fullscreenProgressDialog.isShowing();
    }

    public boolean isProgressShowing() {
        BottomTabBaseFragment bottomTabBaseFragment0 = this.getCurrentTabContainerFragment();
        return bottomTabBaseFragment0 == null ? false : bottomTabBaseFragment0.isProgressShowing();
    }

    @Override  // com.iloen.melon.custom.V
    public abstract boolean isTabInitialized();

    public boolean isUseToastInsteadNotificationDialog() [...] // Inlined contents

    private static final e kakaoLoginHelper_delegate$lambda$0(BaseActivity baseActivity0) {
        return new e(baseActivity0, baseActivity0.getKakaoLoginUseCase(), baseActivity0.getPlayerUseCase());
    }

    public final boolean navigateBack() {
        if(BaseActivity.DEBUG) {
            LogU.Companion.v("BaseActivity", "navigateBack()");
        }
        return this.navigateBack(1);
    }

    public final boolean navigateBack(int v) {
        LogU.Companion.v("BaseActivity", "navigateBack(" + v + ")");
        return this.removeFragmentByIndex(this.getFragmentCount() - v);
    }

    @Override  // com.iloen.melon.activity.PermissionSupportActivity
    public void onBackPressedCallback() {
        if(this.getFragmentCount() > 1) {
            this.getCurrentTabContainerFragment();
            this.removeFragment();
            return;
        }
        this.finish();
    }

    @Override  // com.iloen.melon.activity.PermissionSupportActivity
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        LogU.Companion.v("BaseActivity", "onCreate() savedInstanceState: " + bundle0);
        Window window0 = this.getWindow();
        if(window0 != null) {
            com.google.firebase.b.A(window0);
        }
        EventBusHelper.register(this);
        MelonFragmentManager.getInstance().increaseActivityCount();
        this.initBigUserBlockedProgressDialog();
    }

    @Override  // com.iloen.melon.activity.PermissionSupportActivity
    public void onDestroy() {
        super.onDestroy();
        LogU.Companion.v("BaseActivity", "onDestroy()");
        MelonFragmentManager.getInstance().decreaseActivityCount();
        EventBusHelper.unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventNotificationDialog eventNotificationDialog0) {
        q.g(eventNotificationDialog0, "event");
        this.showEventNotificationDialog(eventNotificationDialog0);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventNotificationScheme eventNotificationScheme0) {
        q.g(eventNotificationScheme0, "event");
        String s = eventNotificationScheme0.scheme;
        if(s != null && !o.H0(s)) {
            MelonFragmentManager melonFragmentManager0 = MelonFragmentManager.getInstance();
            int v = r8.f.c(Uri.parse(s));
            BaseActivity baseActivity0 = melonFragmentManager0.getCurrentActivity();
            q.f(baseActivity0, "getCurrentActivity(...)");
            if(baseActivity0 != this) {
                Companion logU$Companion0 = LogU.Companion;
                logU$Companion0.v("BaseActivity", "EventNotificationScheme() not same activity");
                if(v == 101) {
                    logU$Companion0.d("BaseActivity", "EventNotificationScheme() not handled : " + s);
                    this.finish();
                    return;
                }
            }
            int v1 = melonFragmentManager0.getActivityCount();
            Companion logU$Companion1 = LogU.Companion;
            logU$Companion1.v("BaseActivity", "EventNotificationScheme() activity count:" + v1);
            if(v1 > 1 && v == 101) {
                com.iloen.melon.utils.a.v("EventNotificationScheme() not handled : ", s, logU$Companion1, "BaseActivity");
                return;
            }
            logU$Companion1.v("BaseActivity", "EventNotificationScheme() scheme: " + s);
            MelonLinkExecutor.open(s);
            return;
        }
        LogU.Companion.w("BaseActivity", "EventNotificationScheme() invalid scheme");
    }

    public final boolean removeFragment() {
        return this.navigateBack();
    }

    private final boolean removeFragmentByIndex(int v) {
        synchronized(this) {
            return this.removeFragmentByIndex(v, null);
        }
    }

    private final boolean removeFragmentByIndex(int v, String s) {
        synchronized(this) {
            if(BaseActivity.DEBUG) {
                LogU.Companion.v("BaseActivity", "removeFragmentByIndex() index: " + v + ", newFragmentTag: " + s);
            }
            BottomTabBaseFragment bottomTabBaseFragment0 = this.getCurrentTabContainerFragment();
            return bottomTabBaseFragment0 == null ? false : bottomTabBaseFragment0.removeFragmentByIndex(v, s);
        }
    }

    @Override  // com.iloen.melon.custom.V
    public abstract void selectTab(int arg1, boolean arg2, boolean arg3);

    @Override  // com.iloen.melon.custom.V
    public abstract void selectTabAndClear(int arg1);

    public final void setBlockingProgressDialogManage(@NotNull a a0) {
        q.g(a0, "<set-?>");
        this.blockingProgressDialogManage = a0;
    }

    @Override  // com.iloen.melon.custom.V
    public abstract void setBottomTabFragmentForeground(boolean arg1);

    public final void setKakaoLoginUseCase(@NotNull mb.f f0) {
        q.g(f0, "<set-?>");
        this.kakaoLoginUseCase = f0;
    }

    public final void setLoginUseCase(@NotNull k k0) {
        q.g(k0, "<set-?>");
        this.loginUseCase = k0;
    }

    public final void setPlayerUseCase(@NotNull z z0) {
        q.g(z0, "<set-?>");
        this.playerUseCase = z0;
    }

    @Override  // com.iloen.melon.custom.V
    public abstract void setTabAndMiniPlayerVisible(boolean arg1, boolean arg2, boolean arg3);

    public final void setTokenCheckUseCase(@NotNull s s0) {
        q.g(s0, "<set-?>");
        this.tokenCheckUseCase = s0;
    }

    @Override  // com.iloen.melon.custom.U
    public abstract void setVideoMiniPlayer();

    @Override  // r8.b
    public boolean shouldIgnoreForeground() {
        return false;
    }

    private final void showEventNotificationDialog(EventNotificationDialog eventNotificationDialog0) {
        BaseActivity baseActivity0;
        MelonAppBase.Companion.getClass();
        if(!t.a().isAppForeground()) {
            return;
        }
        MelonFragmentManager melonFragmentManager0 = MelonFragmentManager.getInstance();
        if(melonFragmentManager0.getActivityCount() > 1 && melonFragmentManager0.getCurrentActivity() == this) {
            LogU.Companion.w("BaseActivity", "EventNotificationDialog() ignore main activity");
            return;
        }
        Buttons httpResponse$Notification$Buttons0 = HttpResponse.Companion.getNotificationButton(eventNotificationDialog0.buttons, 0);
        Buttons httpResponse$Notification$Buttons1 = HttpResponse.Companion.getNotificationButton(eventNotificationDialog0.buttons, 1);
        String s = null;
        String s1 = httpResponse$Notification$Buttons0 == null ? null : httpResponse$Notification$Buttons0.label;
        if(httpResponse$Notification$Buttons1 != null) {
            s = httpResponse$Notification$Buttons1.label;
        }
        int v = httpResponse$Notification$Buttons0 == null || httpResponse$Notification$Buttons1 == null ? 1 : 2;
        LogU.Companion.v("BaseActivity", "EventNotificationDialog() buttonCount:" + v);
        if(this.isFinishing()) {
            baseActivity0 = melonFragmentManager0.getCurrentActivity();
            q.f(baseActivity0, "getCurrentActivity(...)");
        }
        else {
            baseActivity0 = this;
        }
        if(v == 1) {
            String s2 = eventNotificationDialog0.message;
            boolean z = eventNotificationDialog0.isCancelable;
            l8.e e0 = new l8.e(this, httpResponse$Notification$Buttons0, 0);
            com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, baseActivity0.getSupportFragmentManager(), "안내", s2, z, true, false, s1, E.c, e0, null, null, 0x620);
            return;
        }
        com.melon.ui.popup.b.x(baseActivity0.getSupportFragmentManager(), "안내", eventNotificationDialog0.message, eventNotificationDialog0.isCancelable, true, s1, s, new l8.e(this, httpResponse$Notification$Buttons1, 1), new l8.e(this, httpResponse$Notification$Buttons0, 2), new r5(24), E.c, 0x20);
    }

    private static final H showEventNotificationDialog$lambda$4(BaseActivity baseActivity0, Buttons httpResponse$Notification$Buttons0) {
        baseActivity0.executeLinkUri((httpResponse$Notification$Buttons0 == null ? null : httpResponse$Notification$Buttons0.linkUri));
        return H.a;
    }

    private static final H showEventNotificationDialog$lambda$5(BaseActivity baseActivity0, Buttons httpResponse$Notification$Buttons0) {
        baseActivity0.executeLinkUri((httpResponse$Notification$Buttons0 == null ? null : httpResponse$Notification$Buttons0.linkUri));
        return H.a;
    }

    private static final H showEventNotificationDialog$lambda$6(BaseActivity baseActivity0, Buttons httpResponse$Notification$Buttons0) {
        baseActivity0.executeLinkUri((httpResponse$Notification$Buttons0 == null ? null : httpResponse$Notification$Buttons0.linkUri));
        return H.a;
    }

    private static final H showEventNotificationDialog$lambda$7() {
        return H.a;
    }

    public final void showMelonProgressDialog() {
        BaseActivity.showMelonProgressDialog$default(this, null, 1, null);
    }

    public final void showMelonProgressDialog(@Nullable String s) {
        if(BaseActivity.DEBUG) {
            LogU.Companion.v("BaseActivity", "showMelonProgressDialog()");
        }
        if(this.fullscreenProgressDialog != null && this.fullscreenProgressDialog.isShowing()) {
            FullscreenProgressDialog fullscreenProgressDialog0 = this.fullscreenProgressDialog;
            if(fullscreenProgressDialog0 != null) {
                fullscreenProgressDialog0.setText(s);
            }
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new l8.k(this, s, null), 3, null);
    }

    public static void showMelonProgressDialog$default(BaseActivity baseActivity0, String s, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMelonProgressDialog");
        }
        if((v & 1) != 0) {
            s = "";
        }
        baseActivity0.showMelonProgressDialog(s);
    }

    @Override  // com.iloen.melon.custom.g1
    public abstract void updateSystemUiFit(@NotNull f1 arg1);
}

