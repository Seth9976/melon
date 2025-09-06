package com.iloen.melon.activity;

import H8.i;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.a;
import androidx.fragment.app.h0;
import androidx.fragment.app.l0;
import androidx.lifecycle.f0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.C;
import com.iloen.melon.custom.F;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventNotificationDialog;
import com.iloen.melon.eventbus.EventNotificationScheme;
import com.iloen.melon.fragments.FragmentStack;
import com.iloen.melon.fragments.MelonFragmentManager.FragmentAnimations;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.net.HttpResponse.Notification.Buttons;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.popup.FullscreenProgressDialog;
import com.iloen.melon.popup.RetainPopup;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.MenuIdQueue;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import d3.g;
import ie.H;
import ie.j;
import java.util.HashMap;
import jd.e3;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import l8.A;
import l8.B;
import l8.D;
import l8.G;
import l8.z;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r8.b;
import r8.f;
import vd.E;

@Metadata(d1 = {"\u0000\u008A\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 Z2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001[B\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0014\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\tH\u0014\u00A2\u0006\u0004\b\f\u0010\u0006J\u000F\u0010\r\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\r\u0010\u0006J\u000F\u0010\u000E\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u0006J\u000F\u0010\u0010\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0011J\u0011\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0017\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001A\u001A\u00020\t2\b\u0010\u0019\u001A\u0004\u0018\u00010\u0013\u00A2\u0006\u0004\b\u001A\u0010\u001BJ!\u0010\u001A\u001A\u00020\t2\b\u0010\u001C\u001A\u0004\u0018\u00010\u00132\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D\u00A2\u0006\u0004\b\u001A\u0010\u001FJ+\u0010\u001A\u001A\u00020\t2\b\u0010\u001C\u001A\u0004\u0018\u00010\u00132\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\b\u0010!\u001A\u0004\u0018\u00010 \u00A2\u0006\u0004\b\u001A\u0010\"J\u000F\u0010#\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b#\u0010\u0011J\r\u0010$\u001A\u00020\u000F\u00A2\u0006\u0004\b$\u0010\u0011J\u0015\u0010$\u001A\u00020\u000F2\u0006\u0010%\u001A\u00020\u0016\u00A2\u0006\u0004\b$\u0010&J\r\u0010\'\u001A\u00020\t\u00A2\u0006\u0004\b\'\u0010\u0006J\u0017\u0010)\u001A\u00020\t2\b\u0010(\u001A\u0004\u0018\u00010\u001D\u00A2\u0006\u0004\b)\u0010*J\r\u0010+\u001A\u00020\t\u00A2\u0006\u0004\b+\u0010\u0006J\u000F\u0010,\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b,\u0010\u0011J\u0011\u0010.\u001A\u0004\u0018\u00010-H\u0016\u00A2\u0006\u0004\b.\u0010/J\u0015\u00101\u001A\u00020\t2\u0006\u00100\u001A\u00020\u000F\u00A2\u0006\u0004\b1\u00102J\u000F\u00103\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b3\u0010\u0011J\u000F\u00104\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b4\u0010\u0011J\u0017\u00107\u001A\u00020\t2\u0006\u00106\u001A\u000205H\u0007\u00A2\u0006\u0004\b7\u00108J\u0017\u00107\u001A\u00020\t2\u0006\u00106\u001A\u000209H\u0007\u00A2\u0006\u0004\b7\u0010:J\u0017\u0010<\u001A\u00020\u000F2\u0006\u0010;\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\b<\u0010&J!\u0010<\u001A\u00020\u000F2\u0006\u0010;\u001A\u00020\u00162\b\u0010=\u001A\u0004\u0018\u00010\u001DH\u0002\u00A2\u0006\u0004\b<\u0010>J\u0019\u0010?\u001A\u00020\t2\b\u0010=\u001A\u0004\u0018\u00010\u001DH\u0002\u00A2\u0006\u0004\b?\u0010*J\u000F\u0010@\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b@\u0010\u0006J\u0019\u0010A\u001A\u00020\t2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001DH\u0002\u00A2\u0006\u0004\bA\u0010*J\u0019\u0010B\u001A\u00020\t2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001DH\u0002\u00A2\u0006\u0004\bB\u0010*J\u0019\u0010C\u001A\u00020\u000F2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001DH\u0002\u00A2\u0006\u0004\bC\u0010DJ\u000F\u0010E\u001A\u00020\tH\u0002\u00A2\u0006\u0004\bE\u0010\u0006J\u0019\u0010G\u001A\u00020\t2\b\u0010F\u001A\u0004\u0018\u00010\u001DH\u0002\u00A2\u0006\u0004\bG\u0010*R4\u0010J\u001A\"\u0012\u0006\u0012\u0004\u0018\u00010\u001D\u0012\u0004\u0012\u00020\u00160Hj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001D\u0012\u0004\u0012\u00020\u0016`I8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010M\u001A\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bM\u0010NR\u001B\u0010T\u001A\u00020O8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bP\u0010Q\u001A\u0004\bR\u0010SR\u001B\u0010Y\u001A\u00020U8VX\u0096\u0084\u0002\u00A2\u0006\f\n\u0004\bV\u0010Q\u001A\u0004\bW\u0010X\u00A8\u0006\\"}, d2 = {"Lcom/iloen/melon/activity/PopupFragmentBaseActivity;", "Lcom/iloen/melon/activity/PermissionSupportActivity;", "Landroidx/fragment/app/h0;", "Lr8/b;", "Lcom/iloen/melon/custom/F;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "onBackPressedCallback", "onBackStackChanged", "", "shouldIgnoreForeground", "()Z", "isLockScreen", "Landroidx/fragment/app/I;", "getCurrentFragment", "()Landroidx/fragment/app/I;", "", "getFragmentCount", "()I", "f", "addFragment", "(Landroidx/fragment/app/I;)V", "fragment", "", "tag", "(Landroidx/fragment/app/I;Ljava/lang/String;)V", "Lcom/iloen/melon/fragments/MelonFragmentManager$FragmentAnimations;", "animations", "(Landroidx/fragment/app/I;Ljava/lang/String;Lcom/iloen/melon/fragments/MelonFragmentManager$FragmentAnimations;)V", "removeFragment", "navigateBack", "count", "(I)Z", "goToHome", "text", "showMelonProgressDialog", "(Ljava/lang/String;)V", "dismissMelonProgressDialog", "isMelonProgressDialogShowing", "Landroid/view/View;", "getProgressBar", "()Landroid/view/View;", "show", "showProgress", "(Z)V", "isProgressShowing", "isUseToastInsteadNotificationDialog", "Lcom/iloen/melon/eventbus/EventNotificationDialog;", "event", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventNotificationDialog;)V", "Lcom/iloen/melon/eventbus/EventNotificationScheme;", "(Lcom/iloen/melon/eventbus/EventNotificationScheme;)V", "index", "removeFragmentByIndex", "newFragmentTag", "(ILjava/lang/String;)Z", "removeBringToFrontFragment", "dumpFragmentStack", "setTagStackReuse", "setTagStackDirty", "isTagDirty", "(Ljava/lang/String;)Z", "hideAllPopup", "linkUri", "executeLinkUri", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "tagStack", "Ljava/util/HashMap;", "Lcom/iloen/melon/popup/FullscreenProgressDialog;", "fullscreenProgressDialog", "Lcom/iloen/melon/popup/FullscreenProgressDialog;", "Ll8/G;", "viewModel$delegate", "Lie/j;", "getViewModel", "()Ll8/G;", "viewModel", "Lcom/iloen/melon/custom/C;", "progressManager$delegate", "getProgressManager", "()Lcom/iloen/melon/custom/C;", "progressManager", "Companion", "l8/B", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class PopupFragmentBaseActivity extends PermissionSupportActivity implements h0, F, b {
    public static final int $stable = 8;
    @NotNull
    public static final B Companion = null;
    private static final boolean DEBUG = false;
    @NotNull
    private static final String TAG = "PopupFragmentBaseActivity";
    private static final int TAG_DIRTY = 0;
    private static final int TAG_REUSE = 1;
    @Nullable
    private FullscreenProgressDialog fullscreenProgressDialog;
    @NotNull
    private final j progressManager$delegate;
    @NotNull
    private final HashMap tagStack;
    @NotNull
    private final j viewModel$delegate;

    static {
        PopupFragmentBaseActivity.Companion = new B();  // 初始化器: Ljava/lang/Object;-><init>()V
        PopupFragmentBaseActivity.DEBUG = false;
    }

    public PopupFragmentBaseActivity() {
        this.tagStack = new HashMap();
        l8.F f0 = new l8.F(this, 0);
        this.viewModel$delegate = new i(I.a.b(G.class), new l8.F(this, 1), f0, new l8.F(this, 2));
        this.progressManager$delegate = g.Q(new e3(this, 7));
    }

    public final void addFragment(@Nullable androidx.fragment.app.I i0) {
        this.addFragment(i0, null);
    }

    public final void addFragment(@Nullable androidx.fragment.app.I i0, @Nullable String s) {
        this.addFragment(i0, s, null);
    }

    public final void addFragment(@Nullable androidx.fragment.app.I i0, @Nullable String s, @Nullable FragmentAnimations melonFragmentManager$FragmentAnimations0) {
        androidx.fragment.app.I i6;
        String s2;
        synchronized(this) {
            if(i0 == null) {
                LogU.Companion.w("PopupFragmentBaseActivity", "addFragment() invalid fragment");
                return;
            }
            androidx.fragment.app.I i1 = this.getCurrentFragment();
            l0 l00 = this.getSupportFragmentManager();
            q.f(l00, "getSupportFragmentManager(...)");
            int v1 = l00.J();
            a a0 = v1 <= 0 ? null : l00.I(v1 - 1);
            String s1 = a0 == null ? "" : a0.i;
            androidx.fragment.app.I i2 = i0 instanceof FragmentStack ? i0 : null;
            boolean z = i2 != null && ((FragmentStack)i2).isAppEntryPointFragment();
            boolean z1 = i2 != null && ((FragmentStack)i2).isTopLevelFragment();
            boolean z2 = i2 != null && ((FragmentStack)i2).isBringToFrontFragment();
            boolean z3 = i2 != null && ((FragmentStack)i2).isPlayerFragment();
            boolean z4 = i2 != null && ((FragmentStack)i2).isPlaylistFragment();
            if(!TextUtils.isEmpty(s)) {
                s2 = s;
            }
            else if(i2 != null) {
                s2 = ((FragmentStack)i2).getFragmentTag();
            }
            else {
                s2 = i0.getClass().getSimpleName();
            }
            if(PopupFragmentBaseActivity.DEBUG) {
                LogU.Companion.v("PopupFragmentBaseActivity", "addFragment() tag: " + s2 + ", id: " + i0.getId() + ", stackCount:" + v1 + ", topEntryName:" + s1 + ", isTopLevelFragment:" + z1 + ", isAppEntryPointFragment:" + z + ", isBringToFrontFragment:" + z2 + ", isPlayerFragment:" + z3 + ", isPlaylistFragment:" + z4);
            }
            if(v1 > 0) {
                if(StringUtils.equals(s2, s1) && !z && i1 instanceof FragmentStack) {
                    ((FragmentStack)i1).onNewArguments(i0.getArguments());
                    return;
                }
                if(z) {
                    this.goToHome();
                    a a1 = l00.I(0);
                    q.f(a1, "getBackStackEntryAt(...)");
                    androidx.fragment.app.I i3 = l00.E(a1.i);
                    if(i3 instanceof FragmentStack) {
                        ((FragmentStack)i3).onNewArguments(i0.getArguments());
                    }
                    return;
                }
                if(z1) {
                    MenuIdQueue.getInstance().setSkipAction(true);
                    this.goToHome();
                }
                if(z3 && i1 instanceof FragmentStack && ((FragmentStack)i1).isPlaylistFragment() && v1 > 1) {
                    a a2 = l00.I(v1 - 2);
                    q.f(a2, "getBackStackEntryAt(...)");
                    String s3 = a2.i;
                    if(q.b(s2, s3)) {
                        androidx.fragment.app.I i4 = l00.E(s3);
                        if(i4 instanceof FragmentStack && ((FragmentStack)i4).isPlayerFragment()) {
                            new Handler(Looper.getMainLooper()).post(new z(this, i4, i0, 0));
                            return;
                        }
                    }
                }
                if(z4 && (i1 instanceof FragmentStack && ((FragmentStack)i1).isPlayerFragment() && v1 > 1)) {
                    a a3 = l00.I(v1 - 2);
                    q.f(a3, "getBackStackEntryAt(...)");
                    String s4 = a3.i;
                    if(q.b(s2, s4)) {
                        androidx.fragment.app.I i5 = l00.E(s4);
                        if(i5 instanceof FragmentStack && ((FragmentStack)i5).isPlaylistFragment()) {
                            new Handler(Looper.getMainLooper()).post(new z(this, i5, i0, 1));
                            return;
                        }
                    }
                }
                if(!z2 || this.isTagDirty(s2)) {
                    i6 = null;
                }
                else {
                    i6 = l00.E(s2);
                    if(i6 != null) {
                        ((FragmentStack)i6).onNewArguments(i0.getArguments());
                        this.setTagStackReuse(s2);
                    }
                }
            }
            else {
                i6 = null;
            }
            a a4 = new a(l00);
            if(melonFragmentManager$FragmentAnimations0 != null) {
                a4.b = melonFragmentManager$FragmentAnimations0.enterAnimation;
                a4.c = melonFragmentManager$FragmentAnimations0.exitAnimation;
                a4.d = melonFragmentManager$FragmentAnimations0.popEnterAnimation;
                a4.e = melonFragmentManager$FragmentAnimations0.popExitAnimation;
            }
            if(i6 == null) {
                i6 = i0;
            }
            a4.g(0x7F0A04DB, i6, s2);  // id:fragment
            a4.c(s2);
            a4.l(true, true);
            l00.C();
        }
    }

    private static final void addFragment$lambda$2(PopupFragmentBaseActivity popupFragmentBaseActivity0, androidx.fragment.app.I i0, androidx.fragment.app.I i1) {
        if(popupFragmentBaseActivity0.isFinishing()) {
            return;
        }
        q.e(i0, "null cannot be cast to non-null type com.iloen.melon.fragments.FragmentStack");
        ((FragmentStack)i0).onNewArguments(i1.getArguments());
        popupFragmentBaseActivity0.removeFragmentByIndex(popupFragmentBaseActivity0.getFragmentCount() - 1, ((FragmentStack)i0).getFragmentTag());
    }

    private static final void addFragment$lambda$3(PopupFragmentBaseActivity popupFragmentBaseActivity0, androidx.fragment.app.I i0, androidx.fragment.app.I i1) {
        if(popupFragmentBaseActivity0.isFinishing()) {
            return;
        }
        q.e(i0, "null cannot be cast to non-null type com.iloen.melon.fragments.FragmentStack");
        ((FragmentStack)i0).onNewArguments(i1.getArguments());
        popupFragmentBaseActivity0.removeFragmentByIndex(popupFragmentBaseActivity0.getFragmentCount() - 1, ((FragmentStack)i0).getFragmentTag());
    }

    public final void dismissMelonProgressDialog() {
        if(PopupFragmentBaseActivity.DEBUG) {
            LogU.Companion.v("PopupFragmentBaseActivity", "dismissMelonProgressDialog()");
        }
        FullscreenProgressDialog fullscreenProgressDialog0 = this.fullscreenProgressDialog;
        if(fullscreenProgressDialog0 != null) {
            if(fullscreenProgressDialog0.isShowing()) {
                fullscreenProgressDialog0.dismiss();
            }
            this.fullscreenProgressDialog = null;
        }
    }

    private final void dumpFragmentStack() {
        if(PopupFragmentBaseActivity.DEBUG) {
            StringBuilder stringBuilder0 = new StringBuilder("[FragmentManager Stack]--------------------\n");
            l0 l00 = this.getSupportFragmentManager();
            q.f(l00, "getSupportFragmentManager(...)");
            for(int v = l00.J() - 1; -1 < v; --v) {
                a a0 = l00.I(v);
                q.f(a0, "getBackStackEntryAt(...)");
                androidx.fragment.app.I i0 = l00.E(a0.i);
                if(i0 != null) {
                    stringBuilder0.append("[");
                    stringBuilder0.append(v);
                    stringBuilder0.append("]");
                    stringBuilder0.append(i0.getClass());
                    stringBuilder0.append("\n");
                }
            }
            stringBuilder0.append("-------------------------------------------");
            String s = stringBuilder0.toString();
            q.f(s, "toString(...)");
            LogU.Companion.v("PopupFragmentBaseActivity", s);
        }
    }

    private final void executeLinkUri(String s) {
        if(s != null && s.length() != 0) {
            LogU.Companion.v("PopupFragmentBaseActivity", "executeLinkUri() linkUri: " + s);
            EventNotificationScheme eventNotificationScheme0 = new EventNotificationScheme();
            eventNotificationScheme0.scheme = s;
            EventBusHelper.post(eventNotificationScheme0);
        }
    }

    @Nullable
    public androidx.fragment.app.I getCurrentFragment() {
        l0 l00 = this.getSupportFragmentManager();
        q.f(l00, "getSupportFragmentManager(...)");
        int v = l00.J();
        if(v > 0) {
            a a0 = l00.I(v - 1);
            q.f(a0, "getBackStackEntryAt(...)");
            return l00.E(a0.i);
        }
        return null;
    }

    public int getFragmentCount() {
        int v = this.getSupportFragmentManager().J();
        if(PopupFragmentBaseActivity.DEBUG) {
            LogU.Companion.v("PopupFragmentBaseActivity", "getFragmentCount() count:" + v);
        }
        return v;
    }

    @Nullable
    public View getProgressBar() {
        return this.findViewById(0x7F0A097E);  // id:progress
    }

    @Override  // com.iloen.melon.custom.F
    @NotNull
    public C getProgressManager() {
        return (C)this.progressManager$delegate.getValue();
    }

    private final G getViewModel() {
        return (G)this.viewModel$delegate.getValue();
    }

    public final void goToHome() {
        LogU.Companion.v("PopupFragmentBaseActivity", "goToHome()");
        this.hideAllPopup();
        this.removeFragmentByIndex(1);
        this.tagStack.clear();
    }

    private final void hideAllPopup() {
        androidx.fragment.app.I i0 = this.getCurrentFragment();
        if(!(i0 instanceof RetainPopup)) {
            return;
        }
        ((RetainPopup)i0).dismissRetainedPopup();
    }

    @Override  // r8.b
    public boolean isLockScreen() {
        return false;
    }

    public boolean isMelonProgressDialogShowing() {
        return this.fullscreenProgressDialog == null ? false : this.fullscreenProgressDialog.isShowing();
    }

    public boolean isProgressShowing() {
        View view0 = this.getProgressBar();
        return view0 != null && view0.getVisibility() == 0;
    }

    private final boolean isTagDirty(String s) {
        boolean z = false;
        synchronized(this.tagStack) {
            if(this.tagStack.containsKey(s)) {
                Integer integer0 = (Integer)this.tagStack.get(s);
                if(integer0 != null && ((int)integer0) == 0) {
                    z = true;
                }
                return z;
            }
            return false;
        }
    }

    public boolean isUseToastInsteadNotificationDialog() [...] // Inlined contents

    public final boolean navigateBack() {
        if(PopupFragmentBaseActivity.DEBUG) {
            LogU.Companion.v("PopupFragmentBaseActivity", "navigateBack()");
        }
        return this.navigateBack(1);
    }

    public final boolean navigateBack(int v) {
        LogU.Companion.v("PopupFragmentBaseActivity", "navigateBack(" + v + ")");
        return this.removeFragmentByIndex(this.getFragmentCount() - v);
    }

    @Override  // com.iloen.melon.activity.PermissionSupportActivity
    public void onBackPressedCallback() {
        if(this.getFragmentCount() > 1) {
            this.removeFragment();
            return;
        }
        this.finish();
    }

    @Override  // androidx.fragment.app.h0
    public void onBackStackChangeCancelled() {
    }

    @Override  // androidx.fragment.app.h0
    public void onBackStackChangeCommitted(androidx.fragment.app.I i0, boolean z) {
    }

    @Override  // androidx.fragment.app.h0
    public void onBackStackChangeProgressed(b.a a0) {
    }

    @Override  // androidx.fragment.app.h0
    public void onBackStackChangeStarted(androidx.fragment.app.I i0, boolean z) {
    }

    @Override  // androidx.fragment.app.h0
    public void onBackStackChanged() {
        if(PopupFragmentBaseActivity.DEBUG) {
            LogU.Companion.v("PopupFragmentBaseActivity", "onBackStackChanged()");
        }
        this.dumpFragmentStack();
    }

    @Override  // com.iloen.melon.activity.PermissionSupportActivity
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        LogU.Companion.v("PopupFragmentBaseActivity", "onCreate() savedInstanceState: " + bundle0);
        Window window0 = this.getWindow();
        if(window0 != null) {
            com.google.firebase.b.A(window0);
        }
        EventBusHelper.register(this);
        l0 l00 = this.getSupportFragmentManager();
        q.f(l00, "getSupportFragmentManager(...)");
        l00.o.add(this);
        MelonFragmentManager.getInstance().increaseActivityCount();
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new D(this, null), 3, null);
    }

    @Override  // com.iloen.melon.activity.PermissionSupportActivity
    public void onDestroy() {
        super.onDestroy();
        LogU.Companion.v("PopupFragmentBaseActivity", "onDestroy()");
        MelonFragmentManager.getInstance().decreaseActivityCount();
        l0 l00 = this.getSupportFragmentManager();
        q.f(l00, "getSupportFragmentManager(...)");
        l00.o.remove(this);
        EventBusHelper.unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventNotificationDialog eventNotificationDialog0) {
        BaseActivity baseActivity0;
        q.g(eventNotificationDialog0, "event");
        MelonAppBase.Companion.getClass();
        if(!t.a().isAppForeground()) {
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
        LogU.Companion.v("PopupFragmentBaseActivity", "EventNotificationDialog() buttonCount:" + v);
        MelonFragmentManager melonFragmentManager0 = MelonFragmentManager.getInstance();
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
            A a0 = new A(this, httpResponse$Notification$Buttons0, 0);
            com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, baseActivity0.getSupportFragmentManager(), "안내", s2, z, true, false, s1, E.c, a0, null, null, 0x620);
            return;
        }
        com.melon.ui.popup.b.x(baseActivity0.getSupportFragmentManager(), "안내", eventNotificationDialog0.message, eventNotificationDialog0.isCancelable, true, s1, s, new A(this, httpResponse$Notification$Buttons1, 1), new A(this, httpResponse$Notification$Buttons0, 2), null, E.c, 0x420);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventNotificationScheme eventNotificationScheme0) {
        q.g(eventNotificationScheme0, "event");
        String s = eventNotificationScheme0.scheme;
        if(TextUtils.isEmpty(s)) {
            LogU.Companion.w("PopupFragmentBaseActivity", "EventNotificationScheme() invalid scheme");
            return;
        }
        MelonFragmentManager melonFragmentManager0 = MelonFragmentManager.getInstance();
        int v = f.c(Uri.parse(s));
        BaseActivity baseActivity0 = melonFragmentManager0.getCurrentActivity();
        q.f(baseActivity0, "getCurrentActivity(...)");
        if(baseActivity0 != this) {
            Companion logU$Companion0 = LogU.Companion;
            logU$Companion0.v("PopupFragmentBaseActivity", "EventNotificationScheme() not same activity");
            if(v == 101) {
                logU$Companion0.d("PopupFragmentBaseActivity", "EventNotificationScheme() not handled : " + s);
                this.finish();
                return;
            }
        }
        int v1 = melonFragmentManager0.getActivityCount();
        Companion logU$Companion1 = LogU.Companion;
        logU$Companion1.v("PopupFragmentBaseActivity", "EventNotificationScheme() activity count:" + v1);
        if(v1 > 1 && v == 101) {
            com.iloen.melon.utils.a.v("EventNotificationScheme() not handled : ", s, logU$Companion1, "PopupFragmentBaseActivity");
            return;
        }
        logU$Companion1.v("PopupFragmentBaseActivity", "EventNotificationScheme() scheme: " + s);
        MelonLinkExecutor.open(s);
    }

    private static final H onEventMainThread$lambda$10(PopupFragmentBaseActivity popupFragmentBaseActivity0, Buttons httpResponse$Notification$Buttons0) {
        popupFragmentBaseActivity0.executeLinkUri((httpResponse$Notification$Buttons0 == null ? null : httpResponse$Notification$Buttons0.linkUri));
        return H.a;
    }

    private static final H onEventMainThread$lambda$8(PopupFragmentBaseActivity popupFragmentBaseActivity0, Buttons httpResponse$Notification$Buttons0) {
        popupFragmentBaseActivity0.executeLinkUri((httpResponse$Notification$Buttons0 == null ? null : httpResponse$Notification$Buttons0.linkUri));
        return H.a;
    }

    private static final H onEventMainThread$lambda$9(PopupFragmentBaseActivity popupFragmentBaseActivity0, Buttons httpResponse$Notification$Buttons0) {
        popupFragmentBaseActivity0.executeLinkUri((httpResponse$Notification$Buttons0 == null ? null : httpResponse$Notification$Buttons0.linkUri));
        return H.a;
    }

    private static final G progressManager_delegate$lambda$0(PopupFragmentBaseActivity popupFragmentBaseActivity0) {
        return popupFragmentBaseActivity0.getViewModel();
    }

    private final void removeBringToFrontFragment(String s) {
        synchronized(this) {
            l0 l00 = this.getSupportFragmentManager();
            q.f(l00, "getSupportFragmentManager(...)");
            int v1 = l00.J();
            if(v1 > 1) {
                a a0 = new a(l00);
                a0.p = true;
                int v2 = v1 - 1;
                int v3 = 0;
                while(v2 > 0) {
                    a a1 = l00.I(v2);
                    q.f(a1, "getBackStackEntryAt(...)");
                    String s1 = a1.i;
                    boolean z = v2 == v1 - 1;
                    if(z && !this.isTagDirty(s1)) {
                        LogU.Companion.v("PopupFragmentBaseActivity", "removeBringToFrontFragment() top entry: " + s1);
                        break;
                    }
                    if(z && q.b(s1, s)) {
                        LogU.Companion.v("PopupFragmentBaseActivity", "removeBringToFrontFragment() same entry: " + s1);
                        break;
                    }
                    if(!this.tagStack.containsKey(s1)) {
                        LogU.Companion.v("PopupFragmentBaseActivity", "removeBringToFrontFragment() not tag stack entry: " + s1);
                        break;
                    }
                    androidx.fragment.app.I i0 = l00.E(s1);
                    if(i0 != null) {
                        a0.d(i0);
                        a0.f(i0);
                        this.setTagStackDirty(s1);
                        ++v3;
                        LogU.Companion.v("PopupFragmentBaseActivity", "removeBringToFrontFragment() " + i0 + " removed");
                    }
                    --v2;
                }
                a0.l(true, true);
                if(v3 > 0) {
                    a a2 = l00.I(v1 - v3);
                    q.f(a2, "getBackStackEntryAt(...)");
                    try {
                        l00.W(a2.t);
                    }
                    catch(IllegalStateException illegalStateException0) {
                        LogU.Companion.v("PopupFragmentBaseActivity", "removeBringToFrontFragment() " + illegalStateException0);
                    }
                }
                if(l00.J() == 1) {
                    this.tagStack.clear();
                }
            }
        }
    }

    public boolean removeFragment() {
        return this.navigateBack();
    }

    private final boolean removeFragmentByIndex(int v) {
        synchronized(this) {
            return this.removeFragmentByIndex(v, null);
        }
    }

    private final boolean removeFragmentByIndex(int v, String s) {
        synchronized(this) {
            if(PopupFragmentBaseActivity.DEBUG) {
                LogU.Companion.v("PopupFragmentBaseActivity", "removeFragmentByIndex() index: " + v);
                LogU.Companion.v("PopupFragmentBaseActivity", "removeFragmentByIndex() newFragmentTag: " + s);
            }
            l0 l00 = this.getSupportFragmentManager();
            q.f(l00, "getSupportFragmentManager(...)");
            int v2 = l00.J();
            int v3 = 0;
            if(v2 > 1 && v < v2) {
                a a0 = new a(l00);
                a0.p = true;
                int v4 = v2 - 1;
                if(v <= v4) {
                    while(true) {
                        a a1 = l00.I(v4);
                        q.f(a1, "getBackStackEntryAt(...)");
                        String s1 = a1.i;
                        androidx.fragment.app.I i0 = l00.E(s1);
                        if(i0 != null) {
                            a0.d(i0);
                            a0.f(i0);
                            this.setTagStackDirty(s1);
                            ++v3;
                            LogU.Companion.v("PopupFragmentBaseActivity", "removeFragmentByIndex() " + i0 + " removed");
                        }
                        if(v4 == v) {
                            break;
                        }
                        --v4;
                    }
                }
                if(v > 0) {
                    for(int v5 = v - 1; v5 > 0; --v5) {
                        a a2 = l00.I(v5);
                        q.f(a2, "getBackStackEntryAt(...)");
                        String s2 = a2.i;
                        androidx.fragment.app.I i1 = l00.E(s2);
                        if(i1 instanceof FragmentStack) {
                            if(((FragmentStack)i1).shouldOnResume()) {
                                break;
                            }
                            a0.d(i1);
                            a0.f(i1);
                            this.setTagStackDirty(s2);
                            ++v3;
                            LogU.Companion.v("PopupFragmentBaseActivity", "removeFragmentByIndex(shouldOnResume) " + i1 + " removed");
                        }
                    }
                }
                a0.l(true, true);
                if(v3 > 0) {
                    a a3 = l00.I(v2 - v3);
                    q.f(a3, "getBackStackEntryAt(...)");
                    try {
                        l00.W(a3.t);
                    }
                    catch(IllegalStateException illegalStateException0) {
                        LogU.Companion.v("PopupFragmentBaseActivity", "removeFragmentByIndex() " + illegalStateException0);
                    }
                }
                this.removeBringToFrontFragment(s);
                return true;
            }
            return false;
        }
    }

    private final void setTagStackDirty(String s) {
        if(TextUtils.isEmpty(s)) {
            return;
        }
        synchronized(this.tagStack) {
            if(this.tagStack.containsKey(s)) {
                if(PopupFragmentBaseActivity.DEBUG) {
                    LogU.Companion.v("PopupFragmentBaseActivity", "setTagStackDirty() tag: " + s);
                }
                this.tagStack.put(s, 0);
            }
        }
    }

    private final void setTagStackReuse(String s) {
        if(TextUtils.isEmpty(s)) {
            return;
        }
        synchronized(this.tagStack) {
            if(!this.tagStack.containsKey(s)) {
                if(PopupFragmentBaseActivity.DEBUG) {
                    LogU.Companion.v("PopupFragmentBaseActivity", "setTagStackReuse() tag: " + s);
                }
                this.tagStack.put(s, 1);
            }
        }
    }

    @Override  // r8.b
    public boolean shouldIgnoreForeground() {
        return false;
    }

    public final void showMelonProgressDialog(@Nullable String s) {
        if(PopupFragmentBaseActivity.DEBUG) {
            LogU.Companion.v("PopupFragmentBaseActivity", "showMelonProgressDialog()");
        }
        if(this.fullscreenProgressDialog != null && this.fullscreenProgressDialog.isShowing()) {
            FullscreenProgressDialog fullscreenProgressDialog0 = this.fullscreenProgressDialog;
            if(fullscreenProgressDialog0 != null) {
                fullscreenProgressDialog0.setText(s);
            }
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new l8.E(this, s, null), 3, null);
    }

    public final void showProgress(boolean z) {
        LogU.Companion.v("PopupFragmentBaseActivity", "showProgress() - show: " + z);
        ViewUtils.showWhen(this.getProgressBar(), z);
    }
}

