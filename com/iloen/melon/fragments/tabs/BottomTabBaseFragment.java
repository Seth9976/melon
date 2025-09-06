package com.iloen.melon.fragments.tabs;

import F8.U;
import H8.i;
import S2.c;
import U4.x;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.o;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.fragment.app.h0;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import androidx.lifecycle.s;
import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.custom.C;
import com.iloen.melon.custom.F;
import com.iloen.melon.custom.MelonContentLoadingProgressBar;
import com.iloen.melon.custom.P;
import com.iloen.melon.custom.V;
import com.iloen.melon.custom.k0;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.FragmentStack;
import com.iloen.melon.fragments.MelonFragmentManager.FragmentAnimations;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.main.common.ViewableCheckViewHolder.OnStateChangeListener;
import com.iloen.melon.fragments.mymusic.dna.d;
import com.iloen.melon.utils.MenuIdQueue;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.RefreshStateHelper.RefreshStateListener;
import com.iloen.melon.utils.ui.RefreshStateHelper;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.q1;
import d3.g;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.j;
import ie.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\'\u0018\u0000 c2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0003cdeB\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\tH\u0017\u00A2\u0006\u0004\b\f\u0010\u0006J\u000F\u0010\r\u001A\u00020\tH&\u00A2\u0006\u0004\b\r\u0010\u0006J\u000F\u0010\u000E\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u0006J\u000F\u0010\u000F\u001A\u00020\u0000H\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0012\u001A\u00020\t2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0007\u00A2\u0006\u0004\b\u0012\u0010\u000BJ\u0017\u0010\u0014\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u000BJ\u000F\u0010\u0015\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0006J-\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u0017\u001A\u00020\u00162\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ!\u0010\u001E\u001A\u00020\t2\u0006\u0010\u001D\u001A\u00020\u001A2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0015\u0010\"\u001A\u00020\t2\u0006\u0010!\u001A\u00020 \u00A2\u0006\u0004\b\"\u0010#J\r\u0010%\u001A\u00020$\u00A2\u0006\u0004\b%\u0010&J\r\u0010\'\u001A\u00020\t\u00A2\u0006\u0004\b\'\u0010\u0006J\r\u0010(\u001A\u00020\t\u00A2\u0006\u0004\b(\u0010\u0006J\u000F\u0010)\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b)\u0010\u0006J\u000F\u0010*\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b*\u0010\u0006J\u0017\u0010,\u001A\u00020\t2\u0006\u0010+\u001A\u00020$H\u0016\u00A2\u0006\u0004\b,\u0010-J\u0011\u0010.\u001A\u0004\u0018\u00010\u0002H\u0016\u00A2\u0006\u0004\b.\u0010/J\u000F\u00100\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b0\u0010/J\u000F\u00102\u001A\u000201H\u0016\u00A2\u0006\u0004\b2\u00103J\u0017\u00105\u001A\u00020\t2\u0006\u00104\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b5\u00106J\u001F\u00105\u001A\u00020\t2\u0006\u00107\u001A\u00020\u00022\b\u00109\u001A\u0004\u0018\u000108\u00A2\u0006\u0004\b5\u0010:J)\u00105\u001A\u00020\t2\u0006\u00107\u001A\u00020\u00022\b\u00109\u001A\u0004\u0018\u0001082\b\u0010<\u001A\u0004\u0018\u00010;\u00A2\u0006\u0004\b5\u0010=J\u0015\u0010?\u001A\u00020$2\u0006\u0010>\u001A\u000201\u00A2\u0006\u0004\b?\u0010@J\u001F\u0010?\u001A\u00020$2\u0006\u0010>\u001A\u0002012\b\u0010A\u001A\u0004\u0018\u000108\u00A2\u0006\u0004\b?\u0010BJ\u0017\u0010C\u001A\u00020\t2\b\u0010A\u001A\u0004\u0018\u000108\u00A2\u0006\u0004\bC\u0010DJ\u000F\u0010E\u001A\u00020\tH\u0016\u00A2\u0006\u0004\bE\u0010\u0006J\r\u0010F\u001A\u00020$\u00A2\u0006\u0004\bF\u0010&J\u0019\u0010G\u001A\u00020$2\b\u00109\u001A\u0004\u0018\u000108H\u0002\u00A2\u0006\u0004\bG\u0010HJ\u0019\u0010I\u001A\u00020\t2\b\u00109\u001A\u0004\u0018\u000108H\u0002\u00A2\u0006\u0004\bI\u0010DJ\u0017\u0010J\u001A\u00020\t2\u0006\u00109\u001A\u000208H\u0002\u00A2\u0006\u0004\bJ\u0010DJ\u000F\u0010K\u001A\u00020\tH\u0002\u00A2\u0006\u0004\bK\u0010\u0006R\u0014\u0010L\u001A\u00020$8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bL\u0010MR0\u0010P\u001A\u001E\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002010Nj\u000E\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000201`O8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010S\u001A\u00020R8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bS\u0010TR\"\u0010U\u001A\u00020$8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bU\u0010M\u001A\u0004\bU\u0010&\"\u0004\bV\u0010-R\u0018\u0010!\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b!\u0010WR\u001B\u0010]\u001A\u00020X8FX\u0086\u0084\u0002\u00A2\u0006\f\n\u0004\bY\u0010Z\u001A\u0004\b[\u0010\\R\u001B\u0010b\u001A\u00020^8VX\u0096\u0084\u0002\u00A2\u0006\f\n\u0004\b_\u0010Z\u001A\u0004\b`\u0010a\u00A8\u0006f"}, d2 = {"Lcom/iloen/melon/fragments/tabs/BottomTabBaseFragment;", "Landroidx/fragment/app/h0;", "Landroidx/fragment/app/I;", "Lcom/iloen/melon/custom/P;", "Lcom/iloen/melon/custom/F;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onLazyCreateView", "onDestroy", "getBottomTabContainer", "()Lcom/iloen/melon/fragments/tabs/BottomTabBaseFragment;", "inState", "onRestoreInstanceState", "outState", "onSaveInstanceState", "onBackStackChanged", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/iloen/melon/fragments/tabs/BottomTabBaseFragment$BottomTabEventListener;", "listener", "setBottomTabEventListener", "(Lcom/iloen/melon/fragments/tabs/BottomTabBaseFragment$BottomTabEventListener;)V", "", "isRootFragment", "()Z", "saveState", "restoreState", "goToHome", "forceRefresh", "animate", "scrollToTop", "(Z)V", "getCurrentFragment", "()Landroidx/fragment/app/I;", "getFragment", "", "getFragmentCount", "()I", "f", "addFragment", "(Landroidx/fragment/app/I;)V", "fragment", "", "tag", "(Landroidx/fragment/app/I;Ljava/lang/String;)V", "Lcom/iloen/melon/fragments/MelonFragmentManager$FragmentAnimations;", "animations", "(Landroidx/fragment/app/I;Ljava/lang/String;Lcom/iloen/melon/fragments/MelonFragmentManager$FragmentAnimations;)V", "index", "removeFragmentByIndex", "(I)Z", "newFragmentTag", "(ILjava/lang/String;)Z", "removeBringToFrontFragment", "(Ljava/lang/String;)V", "dumpFragmentStack", "isProgressShowing", "isTagDirty", "(Ljava/lang/String;)Z", "setTagStackDirty", "setTagStackReuse", "hideAllPopup", "DEBUG", "Z", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mTagStack", "Ljava/util/HashMap;", "Lcom/iloen/melon/custom/MelonContentLoadingProgressBar;", "progressBar", "Lcom/iloen/melon/custom/MelonContentLoadingProgressBar;", "isInnerFragmentCreated", "setInnerFragmentCreated", "Lcom/iloen/melon/fragments/tabs/BottomTabBaseFragment$BottomTabEventListener;", "Lcom/iloen/melon/fragments/tabs/TabBaseFragmentViewModel;", "viewModel$delegate", "Lie/j;", "getViewModel", "()Lcom/iloen/melon/fragments/tabs/TabBaseFragmentViewModel;", "viewModel", "Lcom/iloen/melon/custom/C;", "progressManager$delegate", "getProgressManager", "()Lcom/iloen/melon/custom/C;", "progressManager", "Companion", "BottomTabEventListener", "BottomTabInnerBaseFragment", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class BottomTabBaseFragment extends I implements h0, F, P {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/tabs/BottomTabBaseFragment$BottomTabEventListener;", "", "Lcom/iloen/melon/fragments/tabs/BottomTabBaseFragment;", "fragment", "Lie/H;", "onFragmentViewCreated", "(Lcom/iloen/melon/fragments/tabs/BottomTabBaseFragment;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface BottomTabEventListener {
        void onFragmentViewCreated(@NotNull BottomTabBaseFragment arg1);
    }

    @Metadata(d1 = {"\u0000\u008E\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u0006\u001A\u00020\u00052\b\u0010\b\u001A\u0004\u0018\u00010\u00072\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016\u00A2\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0017J\u000F\u0010\u0019\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u0004J\u000F\u0010\u001A\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u0004J\u000F\u0010\u001B\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u0004J\u000F\u0010\u001C\u001A\u00020\u000FH&\u00A2\u0006\u0004\b\u001C\u0010\u0004J\r\u0010\u001D\u001A\u00020\u000F\u00A2\u0006\u0004\b\u001D\u0010\u0004J\r\u0010\u001E\u001A\u00020\u000F\u00A2\u0006\u0004\b\u001E\u0010\u0004J\u0011\u0010 \u001A\u0004\u0018\u00010\u001FH\u0014\u00A2\u0006\u0004\b \u0010!J\u0011\u0010\"\u001A\u0004\u0018\u00010\u000BH&\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010$\u001A\u00020\u0012H&\u00A2\u0006\u0004\b$\u0010\u0017J\u000F\u0010%\u001A\u00020\u0012H&\u00A2\u0006\u0004\b%\u0010\u0017J\u000F\u0010&\u001A\u00020\u0012H\u0014\u00A2\u0006\u0004\b&\u0010\u0017J\u000F\u0010\'\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\'\u0010\u0004J\u0017\u0010)\u001A\u00020\u000F2\u0006\u0010(\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b)\u0010\u0015R\u0018\u0010+\u001A\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001A\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00100\u001A\u0004\u0018\u00010\u000B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001A\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010%\u001A\u00020\u00128\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b%\u00105R\u0018\u00107\u001A\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b7\u00108R3\u0010=\u001A\u001E\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;09j\u000E\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;`<8\u0006\u00A2\u0006\f\n\u0004\b=\u0010>\u001A\u0004\b?\u0010@R\'\u0010D\u001A\u0012\u0012\u0004\u0012\u00020B0Aj\b\u0012\u0004\u0012\u00020B`C8\u0006\u00A2\u0006\f\n\u0004\bD\u0010E\u001A\u0004\bF\u0010GR\u001B\u0010M\u001A\u00020H8FX\u0086\u0084\u0002\u00A2\u0006\f\n\u0004\bI\u0010J\u001A\u0004\bK\u0010L\u00A8\u0006N"}, d2 = {"Lcom/iloen/melon/fragments/tabs/BottomTabBaseFragment$BottomTabInnerBaseFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Lcom/melon/ui/q1;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "isVisible", "onFragmentVisibilityChanged", "(Z)V", "getUserVisibleHint", "()Z", "getBottomTabVisible", "onStop", "onDestroyView", "onRefresh", "tiaraViewImpMapFlush", "startViewableCheck", "stopViewableCheck", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "onCreateParallaxLayout", "()Landroid/view/View;", "isShowTitleBar", "isShowScrolledLine", "isBottomTabFragment", "forceRefresh", "animate", "scrollToTop", "Landroid/widget/FrameLayout;", "parallaxContainer", "Landroid/widget/FrameLayout;", "Lcom/iloen/melon/utils/ui/RefreshStateHelper;", "refreshStateHelper", "Lcom/iloen/melon/utils/ui/RefreshStateHelper;", "scrolledLine", "Landroid/view/View;", "Landroidx/recyclerview/widget/A0;", "scrollListener", "Landroidx/recyclerview/widget/A0;", "Z", "Lcom/google/android/material/appbar/AppBarLayout;", "titleAppBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "Ljava/util/HashMap;", "", "Lcom/kakao/tiara/data/ViewImpContent;", "Lkotlin/collections/HashMap;", "tiaraViewImpMap", "Ljava/util/HashMap;", "getTiaraViewImpMap", "()Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder$OnStateChangeListener;", "Lkotlin/collections/HashSet;", "onStateChangeListenerHashSet", "Ljava/util/HashSet;", "getOnStateChangeListenerHashSet", "()Ljava/util/HashSet;", "LF8/U;", "webpAutoController$delegate", "Lie/j;", "getWebpAutoController", "()LF8/U;", "webpAutoController", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static abstract class BottomTabInnerBaseFragment extends MetaContentBaseFragment implements q1 {
        public static final int $stable = 8;
        private boolean isShowScrolledLine;
        @NotNull
        private final HashSet onStateChangeListenerHashSet;
        @Nullable
        private FrameLayout parallaxContainer;
        @Nullable
        private RefreshStateHelper refreshStateHelper;
        @Nullable
        private A0 scrollListener;
        @Nullable
        private View scrolledLine;
        @NotNull
        private final HashMap tiaraViewImpMap;
        @Nullable
        private AppBarLayout titleAppBarLayout;
        @NotNull
        private final j webpAutoController$delegate;

        public BottomTabInnerBaseFragment() {
            this.tiaraViewImpMap = new HashMap();
            this.onStateChangeListenerHashSet = new HashSet();
            this.webpAutoController$delegate = g.Q(new d(11));
        }

        public static U d0() {
            return BottomTabInnerBaseFragment.webpAutoController_delegate$lambda$0();
        }

        @Override  // com.melon.ui.q1
        public void forceRefresh() {
            D d0 = this.getViewLifecycleOwner();
            q.f(d0, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(f0.f(d0), Dispatchers.getIO(), null, new n(null) {
                int label;

                {
                    BottomTabInnerBaseFragment.this = bottomTabBaseFragment$BottomTabInnerBaseFragment0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.fragments.tabs.BottomTabBaseFragment.BottomTabInnerBaseFragment.forceRefresh.1(BottomTabInnerBaseFragment.this, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.fragments.tabs.BottomTabBaseFragment.BottomTabInnerBaseFragment.forceRefresh.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    a a0 = a.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            com.iloen.melon.fragments.tabs.BottomTabBaseFragment.BottomTabInnerBaseFragment.forceRefresh.1.1 bottomTabBaseFragment$BottomTabInnerBaseFragment$forceRefresh$1$10 = new n(null) {
                                int label;

                                {
                                    BottomTabInnerBaseFragment.this = bottomTabBaseFragment$BottomTabInnerBaseFragment0;
                                    super(2, continuation0);
                                }

                                @Override  // oe.a
                                public final Continuation create(Object object0, Continuation continuation0) {
                                    return new com.iloen.melon.fragments.tabs.BottomTabBaseFragment.BottomTabInnerBaseFragment.forceRefresh.1.1(BottomTabInnerBaseFragment.this, continuation0);
                                }

                                @Override  // we.n
                                public Object invoke(Object object0, Object object1) {
                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                }

                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                    return ((com.iloen.melon.fragments.tabs.BottomTabBaseFragment.BottomTabInnerBaseFragment.forceRefresh.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                }

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    if(this.label != 0) {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                    d5.n.D(object0);
                                    SwipeRefreshLayout swipeRefreshLayout0 = BottomTabInnerBaseFragment.this.mSwipeRefreshLayout;
                                    if(swipeRefreshLayout0 != null) {
                                        swipeRefreshLayout0.setRefreshing(true);
                                    }
                                    SwipeRefreshLayout swipeRefreshLayout1 = BottomTabInnerBaseFragment.this.mSwipeRefreshLayout;
                                    if(swipeRefreshLayout1 != null) {
                                        swipeRefreshLayout1.setContentDescription(BottomTabInnerBaseFragment.this.getString(0x7F130C1D));  // string:talkback_refresh_done "새로고침 됨"
                                    }
                                    return H.a;
                                }
                            };
                            this.label = 1;
                            if(BuildersKt.withContext(Dispatchers.getMain(), bottomTabBaseFragment$BottomTabInnerBaseFragment$forceRefresh$1$10, this) == a0) {
                                return a0;
                            }
                            goto label_11;
                        }
                        case 1: {
                            d5.n.D(object0);
                        label_11:
                            this.label = 2;
                            if(DelayKt.delay(1000L, this) == a0) {
                                return a0;
                            }
                            break;
                        }
                        case 2: {
                            d5.n.D(object0);
                            break;
                        }
                        case 3: {
                            d5.n.D(object0);
                            return H.a;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                    com.iloen.melon.fragments.tabs.BottomTabBaseFragment.BottomTabInnerBaseFragment.forceRefresh.1.2 bottomTabBaseFragment$BottomTabInnerBaseFragment$forceRefresh$1$20 = new n(null) {
                        int label;

                        {
                            BottomTabInnerBaseFragment.this = bottomTabBaseFragment$BottomTabInnerBaseFragment0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.fragments.tabs.BottomTabBaseFragment.BottomTabInnerBaseFragment.forceRefresh.1.2(BottomTabInnerBaseFragment.this, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.tabs.BottomTabBaseFragment.BottomTabInnerBaseFragment.forceRefresh.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            d5.n.D(object0);
                            SwipeRefreshLayout swipeRefreshLayout0 = BottomTabInnerBaseFragment.this.mSwipeRefreshLayout;
                            if(swipeRefreshLayout0 != null) {
                                swipeRefreshLayout0.sendAccessibilityEvent(4);
                            }
                            SwipeRefreshLayout swipeRefreshLayout1 = BottomTabInnerBaseFragment.this.mSwipeRefreshLayout;
                            if(swipeRefreshLayout1 != null) {
                                swipeRefreshLayout1.setContentDescription("");
                            }
                            BottomTabInnerBaseFragment.this.onRefresh();
                            return H.a;
                        }
                    };
                    this.label = 3;
                    return BuildersKt.withContext(Dispatchers.getMain(), bottomTabBaseFragment$BottomTabInnerBaseFragment$forceRefresh$1$20, this) == a0 ? a0 : H.a;
                }
            }, 2, null);
        }

        @Override  // com.melon.ui.q1
        public boolean getBottomTabVisible() {
            return this.isFragmentVisible;
        }

        @NotNull
        public final HashSet getOnStateChangeListenerHashSet() {
            return this.onStateChangeListenerHashSet;
        }

        @NotNull
        public final HashMap getTiaraViewImpMap() {
            return this.tiaraViewImpMap;
        }

        @Override  // androidx.fragment.app.I
        public boolean getUserVisibleHint() {
            return this.isFragmentVisible;
        }

        @NotNull
        public final U getWebpAutoController() {
            return (U)this.webpAutoController$delegate.getValue();
        }

        @Override  // com.iloen.melon.fragments.MelonBaseFragment
        public boolean isBottomTabFragment() {
            return true;
        }

        public abstract boolean isShowScrolledLine();

        public abstract boolean isShowTitleBar();

        @Nullable
        public abstract View onCreateParallaxLayout();

        @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
        @Nullable
        public RecyclerView onCreateRecyclerView() {
            View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
            q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            return (RecyclerView)view0;
        }

        @Override  // androidx.fragment.app.I
        @Nullable
        public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
            q.g(layoutInflater0, "inflater");
            return layoutInflater0.inflate(0x7F0D005E, viewGroup0, false);  // layout:bottom_tab_inner_fragment
        }

        @Override  // com.iloen.melon.fragments.FetcherBaseFragment
        public void onDestroyView() {
            boolean z = false;
            A0 a00 = this.scrollListener;
            if(a00 != null) {
                if(this.scrolledLine != null && this.scrolledLine.getVisibility() == 0) {
                    z = true;
                }
                this.isShowScrolledLine = z;
                RecyclerView recyclerView0 = this.getRecyclerView();
                if(recyclerView0 != null) {
                    recyclerView0.removeOnScrollListener(a00);
                }
            }
            RefreshStateHelper refreshStateHelper0 = this.refreshStateHelper;
            if(refreshStateHelper0 != null) {
                refreshStateHelper0.removeRefreshStateListener();
            }
            this.refreshStateHelper = null;
            this.getWebpAutoController().a.clear();
            if(this.parallaxContainer != null) {
                this.parallaxContainer = null;
            }
            super.onDestroyView();
        }

        @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
        public void onFragmentVisibilityChanged(boolean z) {
            super.onFragmentVisibilityChanged(z);
            this.getWebpAutoController().a(z);
        }

        @Override  // com.iloen.melon.fragments.FetcherBaseFragment
        public void onRefresh() {
            super.onRefresh();
            this.scrollToTop(false);
        }

        @Override  // com.iloen.melon.fragments.FetcherBaseFragment
        public void onStop() {
            super.onStop();
            this.tiaraViewImpMapFlush();
            this.stopViewableCheck();
        }

        @Override  // com.iloen.melon.fragments.FetcherBaseFragment
        public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
            q.g(view0, "view");
            super.onViewCreated(view0, bundle0);
            View view1 = this.findViewById(0x7F0A08FE);  // id:parallax_container
            AppBarLayout appBarLayout0 = null;
            this.parallaxContainer = view1 instanceof FrameLayout ? ((FrameLayout)view1) : null;
            View view2 = this.onCreateParallaxLayout();
            if(view2 != null) {
                FrameLayout frameLayout0 = this.parallaxContainer;
                if(frameLayout0 != null) {
                    frameLayout0.addView(view2);
                }
            }
            TitleBar titleBar0 = this.getTitleBar();
            if(titleBar0 != null) {
                ViewUtils.showWhen(titleBar0, this.isShowTitleBar());
            }
            View view3 = view0.findViewById(0x7F0A042C);  // id:empty_or_error_layout
            View view4 = view3 == null ? null : view3.findViewById(0x7F0A042B);  // id:empty_layout
            if(view4 != null) {
                view4.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F0604A1));  // color:white000e
            }
            View view5 = view3 == null ? null : view3.findViewById(0x7F0A08A5);  // id:network_error_layout
            if(view5 != null) {
                view5.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F0604A1));  // color:white000e
            }
            this.bindSwipeRefreshLayout(0x7F0A0B0C);  // id:swipe_refresh_layout
            View view6 = this.findViewById(0x7F0A0B91);  // id:title_appbar_container
            if(view6 instanceof AppBarLayout) {
                appBarLayout0 = (AppBarLayout)view6;
            }
            this.titleAppBarLayout = appBarLayout0;
            RefreshStateHelper refreshStateHelper0 = new RefreshStateHelper(appBarLayout0, this.mRecyclerView);
            this.refreshStateHelper = refreshStateHelper0;
            refreshStateHelper0.addRefreshStateListener(new RefreshStateListener() {
                @Override  // com.iloen.melon.utils.ui.RefreshStateHelper$RefreshStateListener
                public void onRefreshEnable(boolean z) {
                    SwipeRefreshLayout swipeRefreshLayout0 = BottomTabInnerBaseFragment.this.mSwipeRefreshLayout;
                    if(swipeRefreshLayout0 != null) {
                        if(z) {
                            swipeRefreshLayout0.setEnabled(true);
                            return;
                        }
                        swipeRefreshLayout0.setEnabled(false);
                        swipeRefreshLayout0.setRefreshing(false);
                    }
                }
            });
            this.isFragmentVisible = q.b(this.getCurrentTabContainerFragment().getCurrentFragment(), this);
            this.getWebpAutoController().a(this.isFragmentVisible);
            if(this.isShowScrolledLine() && this.getRecyclerView() != null) {
                View view7 = this.findViewById(0x7F0A0A32);  // id:scrolled_line
                this.scrolledLine = view7;
                ViewUtils.showWhen(view7, this.isShowScrolledLine);
                com.iloen.melon.fragments.tabs.BottomTabBaseFragment.BottomTabInnerBaseFragment.onViewCreated.4 bottomTabBaseFragment$BottomTabInnerBaseFragment$onViewCreated$40 = new A0() {
                    @Override  // androidx.recyclerview.widget.A0
                    public void onScrolled(RecyclerView recyclerView0, int v, int v1) {
                        q.g(recyclerView0, "recyclerView");
                        View view0 = BottomTabInnerBaseFragment.this.scrolledLine;
                        if(view0 != null) {
                            if(view0.getVisibility() != 0 && recyclerView0.canScrollVertically(-1)) {
                                ViewUtils.showWhen(view0, true);
                            }
                            else if(view0.getVisibility() == 0 && !recyclerView0.canScrollVertically(-1)) {
                                ViewUtils.hideWhen(view0, true);
                            }
                        }
                        super.onScrolled(recyclerView0, v, v1);
                    }
                };
                this.scrollListener = bottomTabBaseFragment$BottomTabInnerBaseFragment$onViewCreated$40;
                RecyclerView recyclerView0 = this.getRecyclerView();
                if(recyclerView0 != null) {
                    recyclerView0.addOnScrollListener(bottomTabBaseFragment$BottomTabInnerBaseFragment$onViewCreated$40);
                }
            }
        }

        @Override  // com.melon.ui.q1
        public void scrollToTop(boolean z) {
            if(z) {
                RecyclerView recyclerView0 = this.getRecyclerView();
                if(recyclerView0 != null) {
                    recyclerView0.smoothScrollToPosition(0);
                }
            }
            else {
                RecyclerView recyclerView1 = this.getRecyclerView();
                if(recyclerView1 != null) {
                    recyclerView1.scrollToPosition(0);
                }
            }
            AppBarLayout appBarLayout0 = this.titleAppBarLayout;
            if(appBarLayout0 != null) {
                appBarLayout0.e(true, z, true);
            }
        }

        public final void startViewableCheck() {
            synchronized(this.onStateChangeListenerHashSet) {
                Iterator iterator0 = this.onStateChangeListenerHashSet.iterator();
                q.f(iterator0, "iterator(...)");
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    q.f(object0, "next(...)");
                    ((OnStateChangeListener)object0).onStart();
                }
            }
        }

        public final void stopViewableCheck() {
            synchronized(this.onStateChangeListenerHashSet) {
                Iterator iterator0 = this.onStateChangeListenerHashSet.iterator();
                q.f(iterator0, "iterator(...)");
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    q.f(object0, "next(...)");
                    ((OnStateChangeListener)object0).onStop();
                }
            }
        }

        public abstract void tiaraViewImpMapFlush();

        private static final U webpAutoController_delegate$lambda$0() {
            return new U();
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/tabs/BottomTabBaseFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_IS_INNER_FRAGMENT_CREATED", "TAG_DIRTY", "", "TAG_REUSE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_IS_INNER_FRAGMENT_CREATED = "ARG_IS_INNER_FRAGMENT_CREATED";
    @NotNull
    public static final Companion Companion = null;
    private final boolean DEBUG;
    @NotNull
    private static final String TAG = "BottomTabBaseFragment";
    private static final int TAG_DIRTY = 0;
    private static final int TAG_REUSE = 1;
    private boolean isInnerFragmentCreated;
    @Nullable
    private BottomTabEventListener listener;
    @NotNull
    private final HashMap mTagStack;
    private MelonContentLoadingProgressBar progressBar;
    @NotNull
    private final j progressManager$delegate;
    @NotNull
    private final j viewModel$delegate;

    static {
        BottomTabBaseFragment.Companion = new Companion(null);
        BottomTabBaseFragment.$stable = 8;
    }

    public BottomTabBaseFragment() {
        this.DEBUG = false;
        this.mTagStack = new HashMap();
        com.iloen.melon.fragments.tabs.BottomTabBaseFragment.special..inlined.viewModels.default.2 bottomTabBaseFragment$special$$inlined$viewModels$default$20 = new we.a() {
            final we.a $ownerProducer;

            {
                this.$ownerProducer = a0;
                super(0);
            }

            @NotNull
            public final r0 invoke() {
                return (r0)this.$ownerProducer.invoke();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        j j0 = g.P(k.c, bottomTabBaseFragment$special$$inlined$viewModels$default$20);
        De.d d0 = kotlin.jvm.internal.I.a.b(TabBaseFragmentViewModel.class);
        com.iloen.melon.fragments.tabs.BottomTabBaseFragment.special..inlined.viewModels.default.3 bottomTabBaseFragment$special$$inlined$viewModels$default$30 = new we.a() {
            final j $owner$delegate;

            {
                this.$owner$delegate = j0;
                super(0);
            }

            @NotNull
            public final q0 invoke() {
                return ((r0)this.$owner$delegate.getValue()).getViewModelStore();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        com.iloen.melon.fragments.tabs.BottomTabBaseFragment.special..inlined.viewModels.default.4 bottomTabBaseFragment$special$$inlined$viewModels$default$40 = new we.a(j0) {
            final we.a $extrasProducer;
            final j $owner$delegate;

            {
                this.$extrasProducer = a0;
                this.$owner$delegate = j0;
                super(0);
            }

            @NotNull
            public final c invoke() {
                we.a a0 = this.$extrasProducer;
                if(a0 != null) {
                    c c0 = (c)a0.invoke();
                    if(c0 != null) {
                        return c0;
                    }
                }
                r0 r00 = (r0)this.$owner$delegate.getValue();
                androidx.lifecycle.n n0 = r00 instanceof androidx.lifecycle.n ? ((androidx.lifecycle.n)r00) : null;
                return n0 != null ? n0.getDefaultViewModelCreationExtras() : S2.a.b;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        this.viewModel$delegate = new i(d0, bottomTabBaseFragment$special$$inlined$viewModels$default$30, new we.a(j0) {
            final j $owner$delegate;
            final I $this_viewModels;

            {
                this.$this_viewModels = i0;
                this.$owner$delegate = j0;
                super(0);
            }

            @NotNull
            public final o0 invoke() {
                r0 r00 = (r0)this.$owner$delegate.getValue();
                androidx.lifecycle.n n0 = r00 instanceof androidx.lifecycle.n ? ((androidx.lifecycle.n)r00) : null;
                if(n0 != null) {
                    o0 o00 = n0.getDefaultViewModelProviderFactory();
                    return o00 == null ? this.$this_viewModels.getDefaultViewModelProviderFactory() : o00;
                }
                return this.$this_viewModels.getDefaultViewModelProviderFactory();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }, bottomTabBaseFragment$special$$inlined$viewModels$default$40);
        this.progressManager$delegate = g.Q(new b9.a(this, 20));

        @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001A\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/m0;", "VM", "Landroidx/fragment/app/I;", "invoke", "()Landroidx/fragment/app/I;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.tabs.BottomTabBaseFragment.special..inlined.viewModels.default.1 extends r implements we.a {
            final I $this_viewModels;

            public com.iloen.melon.fragments.tabs.BottomTabBaseFragment.special..inlined.viewModels.default.1(I i0) {
                this.$this_viewModels = i0;
                super(0);
            }

            @NotNull
            public final I invoke() {
                return this.$this_viewModels;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public void addFragment(@NotNull I i0) {
        q.g(i0, "f");
        this.addFragment(i0, null);
    }

    public final void addFragment(@NotNull I i0, @Nullable String s) {
        q.g(i0, "fragment");
        this.addFragment(i0, s, null);
    }

    public final void addFragment(@NotNull I i0, @Nullable String s, @Nullable FragmentAnimations melonFragmentManager$FragmentAnimations0) {
        I i6;
        q.g(i0, "fragment");
        I i1 = this.getCurrentFragment();
        l0 l00 = this.getChildFragmentManager();
        q.f(l00, "getChildFragmentManager(...)");
        int v = l00.J();
        androidx.fragment.app.a a0 = v <= 0 ? null : l00.I(v - 1);
        String s1 = "";
        String s2 = a0 == null ? "" : a0.i;
        I i2 = i0 instanceof FragmentStack ? i0 : null;
        boolean z = i2 != null && ((FragmentStack)i2).isAppEntryPointFragment();
        boolean z1 = i2 != null && ((FragmentStack)i2).isTopLevelFragment();
        boolean z2 = i2 != null && ((FragmentStack)i2).isBringToFrontFragment();
        boolean z3 = i2 != null && ((FragmentStack)i2).isPlayerFragment();
        boolean z4 = i2 != null && ((FragmentStack)i2).isPlaylistFragment();
        if(TextUtils.isEmpty(s)) {
            s1 = i2 == null ? i0.getClass().getSimpleName() : ((FragmentStack)i2).getFragmentTag();
            q.d(s1);
        }
        if(this.DEBUG) {
            StringBuilder stringBuilder0 = o.u(i0.getId(), "addFragment() newTag: ", s1, ", id: ", ", stackCount:");
            stringBuilder0.append(v);
            stringBuilder0.append(", topEntryName:");
            stringBuilder0.append(s2);
            stringBuilder0.append(", isTopLevelFragment:");
            x.y(stringBuilder0, z1, ", isAppEntryPointFragment:", z, ", isBringToFrontFragment:");
            x.y(stringBuilder0, z2, ", isPlayerFragment:", z3, ", isPlaylistFragment:");
            stringBuilder0.append(z4);
            LogU.Companion.v("BottomTabBaseFragment", stringBuilder0.toString());
        }
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null && fragmentActivity0 instanceof com.iloen.melon.custom.U) {
            ((com.iloen.melon.custom.U)fragmentActivity0).setVideoMiniPlayer();
        }
        if(v <= 0) {
            goto label_71;
        }
        if(StringUtils.equals(s1, s2) && !z && i1 instanceof FragmentStack) {
            ((FragmentStack)i1).onNewArguments(i0.getArguments());
            return;
        }
        if(!z) {
            goto label_42;
        }
        this.goToHome();
        androidx.fragment.app.a a1 = l00.I(0);
        q.f(a1, "getBackStackEntryAt(...)");
        I i3 = l00.E(a1.i);
        if(i3 instanceof FragmentStack) {
            ((FragmentStack)i3).onNewArguments(i0.getArguments());
            return;
        label_42:
            if(z1) {
                MenuIdQueue.getInstance().setSkipAction(true);
                this.goToHome();
            }
            if(z3 && i1 instanceof FragmentStack && ((FragmentStack)i1).isPlaylistFragment() && v > 1) {
                androidx.fragment.app.a a2 = l00.I(v - 2);
                q.f(a2, "getBackStackEntryAt(...)");
                String s3 = a2.i;
                if(s1.equals(s3)) {
                    I i4 = l00.E(s3);
                    if(i4 instanceof FragmentStack && ((FragmentStack)i4).isPlayerFragment()) {
                        new Handler(Looper.getMainLooper()).post(new com.iloen.melon.fragments.tabs.a(this, i4, i0, 0));
                        return;
                    }
                }
            }
            if(z4 && i1 instanceof FragmentStack && ((FragmentStack)i1).isPlayerFragment() && v > 1) {
                androidx.fragment.app.a a3 = l00.I(v - 2);
                q.f(a3, "getBackStackEntryAt(...)");
                String s4 = a3.i;
                if(s1.equals(s4)) {
                    I i5 = l00.E(s4);
                    if(i5 instanceof FragmentStack && ((FragmentStack)i5).isPlaylistFragment()) {
                        new Handler(Looper.getMainLooper()).post(new com.iloen.melon.fragments.tabs.a(this, i5, i0, 1));
                        return;
                    }
                }
            }
            if(!z2 || this.isTagDirty(s1)) {
                i6 = null;
                goto label_72;
            label_71:
                i6 = null;
            }
            else {
                i6 = l00.E(s1);
                if(i6 != null) {
                    ((FragmentStack)i6).onNewArguments(i0.getArguments());
                    this.setTagStackReuse(s1);
                }
            }
        label_72:
            androidx.fragment.app.a a4 = new androidx.fragment.app.a(l00);
            if(melonFragmentManager$FragmentAnimations0 != null) {
                a4.b = melonFragmentManager$FragmentAnimations0.enterAnimation;
                a4.c = melonFragmentManager$FragmentAnimations0.exitAnimation;
                a4.d = melonFragmentManager$FragmentAnimations0.popEnterAnimation;
                a4.e = melonFragmentManager$FragmentAnimations0.popExitAnimation;
            }
            if(i6 == null) {
                i6 = i0;
            }
            a4.g(0x7F0A04DB, i6, s1);  // id:fragment
            a4.c(s1);
            a4.l(true, true);
            try {
                l00.C();
            }
            catch(Exception exception0) {
                LogU.Companion.v("BottomTabBaseFragment", "addFragment() " + exception0);
                if(this.DEBUG) {
                    exception0.printStackTrace();
                }
            }
        }
    }

    private static final void addFragment$lambda$10(BottomTabBaseFragment bottomTabBaseFragment0, I i0, I i1) {
        FragmentActivity fragmentActivity0 = bottomTabBaseFragment0.getActivity();
        if(fragmentActivity0 != null && !fragmentActivity0.isFinishing()) {
            q.e(i0, "null cannot be cast to non-null type com.iloen.melon.fragments.FragmentStack");
            ((FragmentStack)i0).onNewArguments(i1.getArguments());
            bottomTabBaseFragment0.removeFragmentByIndex(bottomTabBaseFragment0.getFragmentCount() - 1, ((FragmentStack)i0).getFragmentTag());
        }
    }

    private static final void addFragment$lambda$12(BottomTabBaseFragment bottomTabBaseFragment0, I i0, I i1) {
        FragmentActivity fragmentActivity0 = bottomTabBaseFragment0.getActivity();
        if(fragmentActivity0 != null && !fragmentActivity0.isFinishing()) {
            q.e(i0, "null cannot be cast to non-null type com.iloen.melon.fragments.FragmentStack");
            ((FragmentStack)i0).onNewArguments(i1.getArguments());
            bottomTabBaseFragment0.removeFragmentByIndex(bottomTabBaseFragment0.getFragmentCount() - 1, ((FragmentStack)i0).getFragmentTag());
        }
    }

    public void dumpFragmentStack() {
        if(this.DEBUG) {
            StringBuilder stringBuilder0 = new StringBuilder("[FragmentManager Stack]--------------------\n");
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            for(int v = l00.J() - 1; -1 < v; --v) {
                androidx.fragment.app.a a0 = l00.I(v);
                q.f(a0, "getBackStackEntryAt(...)");
                I i0 = l00.E(a0.i);
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
            LogU.Companion.v("BottomTabBaseFragment", s);
        }
    }

    public void forceRefresh() {
        I i0 = this.getCurrentFragment();
        if(i0 != null && i0 instanceof q1) {
            ((q1)i0).forceRefresh();
        }
    }

    @Override  // com.iloen.melon.custom.P
    @NotNull
    public BottomTabBaseFragment getBottomTabContainer() {
        return this;
    }

    @Nullable
    public I getCurrentFragment() {
        return this.getFragment();
    }

    @Nullable
    public final I getFragment() {
        if(this.getContext() != null) {
            l0 l00 = this.getChildFragmentManager();
            int v = l00.J();
            if(v > 0) {
                androidx.fragment.app.a a0 = l00.I(v - 1);
                q.f(a0, "getBackStackEntryAt(...)");
                return l00.E(a0.i);
            }
        }
        return null;
    }

    public int getFragmentCount() {
        l0 l00 = this.getChildFragmentManager();
        q.f(l00, "getChildFragmentManager(...)");
        int v = l00.J();
        if(this.DEBUG) {
            LogU.Companion.v("BottomTabBaseFragment", "getFragmentCount() count:" + v);
        }
        return v;
    }

    @Override  // com.iloen.melon.custom.F
    @NotNull
    public C getProgressManager() {
        return (C)this.progressManager$delegate.getValue();
    }

    @NotNull
    public final TabBaseFragmentViewModel getViewModel() {
        return (TabBaseFragmentViewModel)this.viewModel$delegate.getValue();
    }

    public void goToHome() {
        LogU.Companion.v("BottomTabBaseFragment", "goToHome()");
        this.removeFragmentByIndex(1);
        this.mTagStack.clear();
    }

    private final void hideAllPopup() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null && fragmentActivity0 instanceof MusicBrowserActivity) {
            ((MusicBrowserActivity)fragmentActivity0).hideAllPopup();
        }
    }

    public final boolean isInnerFragmentCreated() {
        return this.isInnerFragmentCreated;
    }

    public final boolean isProgressShowing() {
        MelonContentLoadingProgressBar melonContentLoadingProgressBar0 = this.progressBar;
        if(melonContentLoadingProgressBar0 != null) {
            return melonContentLoadingProgressBar0.getVisibility() == 0;
        }
        q.m("progressBar");
        throw null;
    }

    public final boolean isRootFragment() {
        l0 l00 = this.getChildFragmentManager();
        q.f(l00, "getChildFragmentManager(...)");
        return l00.J() <= 1;
    }

    private final boolean isTagDirty(String s) {
        boolean z = false;
        synchronized(this.mTagStack) {
            if(this.mTagStack.containsKey(s)) {
                Integer integer0 = (Integer)this.mTagStack.get(s);
                if(integer0 != null && ((int)integer0) == 0) {
                    z = true;
                }
                return z;
            }
            return false;
        }
    }

    public static TabBaseFragmentViewModel l(BottomTabBaseFragment bottomTabBaseFragment0) {
        return BottomTabBaseFragment.progressManager_delegate$lambda$0(bottomTabBaseFragment0);
    }

    public static void m(BottomTabBaseFragment bottomTabBaseFragment0, I i0, I i1) {
        BottomTabBaseFragment.addFragment$lambda$12(bottomTabBaseFragment0, i0, i1);
    }

    public static void n(BottomTabBaseFragment bottomTabBaseFragment0, I i0, I i1) {
        BottomTabBaseFragment.addFragment$lambda$10(bottomTabBaseFragment0, i0, i1);
    }

    @Override  // androidx.fragment.app.h0
    public void onBackStackChangeCancelled() {
    }

    @Override  // androidx.fragment.app.h0
    public void onBackStackChangeCommitted(I i0, boolean z) {
    }

    @Override  // androidx.fragment.app.h0
    public void onBackStackChangeProgressed(b.a a0) {
    }

    @Override  // androidx.fragment.app.h0
    public void onBackStackChangeStarted(I i0, boolean z) {
    }

    @Override  // androidx.fragment.app.h0
    public void onBackStackChanged() {
        this.dumpFragmentStack();
    }

    @Override  // androidx.fragment.app.I
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.onRestoreInstanceState(bundle0);
        this.getChildFragmentManager().o.add(this);
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D005D, viewGroup0, false);  // layout:bottom_tab_base_fragment
    }

    @Override  // androidx.fragment.app.I
    public void onDestroy() {
        super.onDestroy();
        this.getChildFragmentManager().o.remove(this);
    }

    public abstract void onLazyCreateView();

    public final void onRestoreInstanceState(@Nullable Bundle bundle0) {
        if(bundle0 != null) {
            this.isInnerFragmentCreated = bundle0.getBoolean("ARG_IS_INNER_FRAGMENT_CREATED");
        }
    }

    @Override  // androidx.fragment.app.I
    public void onResume() {
        super.onResume();
        if(this.isAdded() && !this.isInnerFragmentCreated) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            V v0 = fragmentActivity0 instanceof V ? ((V)fragmentActivity0) : null;
            if(v0 != null && v0.isTabInitialized()) {
                this.onLazyCreateView();
                this.isInnerFragmentCreated = true;
            }
        }
    }

    @Override  // androidx.fragment.app.I
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putBoolean("ARG_IS_INNER_FRAGMENT_CREATED", this.isInnerFragmentCreated);
    }

    @Override  // androidx.fragment.app.I
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        BottomTabEventListener bottomTabBaseFragment$BottomTabEventListener0 = this.listener;
        if(bottomTabBaseFragment$BottomTabEventListener0 != null) {
            bottomTabBaseFragment$BottomTabEventListener0.onFragmentViewCreated(this);
        }
        View view1 = view0.findViewById(0x7F0A097E);  // id:progress
        q.f(view1, "findViewById(...)");
        this.progressBar = (MelonContentLoadingProgressBar)view1;
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
            int label;

            {
                BottomTabBaseFragment.this = bottomTabBaseFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.tabs.BottomTabBaseFragment.onViewCreated.1(BottomTabBaseFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.tabs.BottomTabBaseFragment.onViewCreated.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.fragments.tabs.BottomTabBaseFragment.onViewCreated.1.1 bottomTabBaseFragment$onViewCreated$1$10 = new n(null) {
                            int label;

                            {
                                BottomTabBaseFragment.this = bottomTabBaseFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.tabs.BottomTabBaseFragment.onViewCreated.1.1(BottomTabBaseFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.tabs.BottomTabBaseFragment.onViewCreated.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        StateFlow stateFlow0 = BottomTabBaseFragment.this.getProgressManager().isProgressVisible();
                                        com.iloen.melon.fragments.tabs.BottomTabBaseFragment.onViewCreated.1.1.1 bottomTabBaseFragment$onViewCreated$1$1$10 = new FlowCollector() {
                                            @Override  // kotlinx.coroutines.flow.FlowCollector
                                            public Object emit(Object object0, Continuation continuation0) {
                                                return this.emit(((Boolean)object0).booleanValue(), continuation0);
                                            }

                                            public final Object emit(boolean z, Continuation continuation0) {
                                                if(z) {
                                                    MelonContentLoadingProgressBar melonContentLoadingProgressBar0 = BottomTabBaseFragment.this.progressBar;
                                                    if(melonContentLoadingProgressBar0 != null) {
                                                        melonContentLoadingProgressBar0.post(new k0(melonContentLoadingProgressBar0, 0));
                                                        return H.a;
                                                    }
                                                    q.m("progressBar");
                                                    throw null;
                                                }
                                                MelonContentLoadingProgressBar melonContentLoadingProgressBar1 = BottomTabBaseFragment.this.progressBar;
                                                if(melonContentLoadingProgressBar1 != null) {
                                                    melonContentLoadingProgressBar1.post(new k0(melonContentLoadingProgressBar1, 3));
                                                    return H.a;
                                                }
                                                q.m("progressBar");
                                                throw null;
                                            }
                                        };
                                        this.label = 1;
                                        if(stateFlow0.collect(bottomTabBaseFragment$onViewCreated$1$1$10, this) == a0) {
                                            return a0;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        d5.n.D(object0);
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            }
                        };
                        this.label = 1;
                        return f0.j(BottomTabBaseFragment.this, s.e, bottomTabBaseFragment$onViewCreated$1$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
    }

    private static final TabBaseFragmentViewModel progressManager_delegate$lambda$0(BottomTabBaseFragment bottomTabBaseFragment0) {
        return bottomTabBaseFragment0.getViewModel();
    }

    public final void removeBringToFrontFragment(@Nullable String s) {
        synchronized(this) {
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            int v1 = l00.J();
            if(v1 > 1) {
                androidx.fragment.app.a a0 = new androidx.fragment.app.a(l00);
                a0.p = true;
                int v2 = v1 - 1;
                int v3 = 0;
                while(v2 > 0) {
                    androidx.fragment.app.a a1 = l00.I(v2);
                    q.f(a1, "getBackStackEntryAt(...)");
                    String s1 = a1.i;
                    boolean z = v2 == v1 - 1;
                    if(z && !this.isTagDirty(s1)) {
                        LogU.Companion.v("BottomTabBaseFragment", "removeBringToFrontFragment() top entry: " + s1);
                        break;
                    }
                    if(z && q.b(s1, s)) {
                        LogU.Companion.v("BottomTabBaseFragment", "removeBringToFrontFragment() same entry: " + s1);
                        break;
                    }
                    if(!this.mTagStack.containsKey(s1)) {
                        LogU.Companion.v("BottomTabBaseFragment", "removeBringToFrontFragment() not tag stack entry: " + s1);
                        break;
                    }
                    I i0 = l00.E(s1);
                    if(i0 != null) {
                        a0.d(i0);
                        a0.f(i0);
                        q.d(s1);
                        this.setTagStackDirty(s1);
                        ++v3;
                        LogU.Companion.v("BottomTabBaseFragment", "removeBringToFrontFragment() " + i0 + " removed");
                    }
                    --v2;
                }
                a0.l(true, true);
                if(v3 > 0) {
                    androidx.fragment.app.a a2 = l00.I(v1 - v3);
                    q.f(a2, "getBackStackEntryAt(...)");
                    try {
                        l00.W(a2.t);
                    }
                    catch(IllegalStateException illegalStateException0) {
                        LogU.Companion.v("BottomTabBaseFragment", "removeBringToFrontFragment() " + illegalStateException0);
                        if(this.DEBUG) {
                            illegalStateException0.printStackTrace();
                        }
                    }
                }
                if(l00.J() == 1) {
                    this.mTagStack.clear();
                }
            }
        }
    }

    public final boolean removeFragmentByIndex(int v) {
        synchronized(this) {
            return this.removeFragmentByIndex(v, "");
        }
    }

    public final boolean removeFragmentByIndex(int v, @Nullable String s) {
        synchronized(this) {
            if(this.DEBUG) {
                LogU.Companion.v("BottomTabBaseFragment", "removeFragmentByIndex() index: " + v);
                LogU.Companion.v("BottomTabBaseFragment", "removeFragmentByIndex() newFragmentTag: " + s);
            }
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            int v2 = l00.J();
            int v3 = 0;
            if(v2 > 1 && v < v2) {
                androidx.fragment.app.a a0 = new androidx.fragment.app.a(l00);
                a0.p = true;
                int v4 = v2 - 1;
                if(v <= v4) {
                    while(true) {
                        androidx.fragment.app.a a1 = l00.I(v4);
                        q.f(a1, "getBackStackEntryAt(...)");
                        String s1 = a1.i;
                        I i0 = l00.E(s1);
                        if(i0 != null) {
                            a0.d(i0);
                            a0.f(i0);
                            this.setTagStackDirty(s1);
                            ++v3;
                            LogU.Companion.v("BottomTabBaseFragment", "removeFragmentByIndex() " + i0 + " removed");
                        }
                        if(v4 == v) {
                            break;
                        }
                        --v4;
                    }
                }
                if(v > 0) {
                    for(int v5 = v - 1; v5 > 0; --v5) {
                        androidx.fragment.app.a a2 = l00.I(v5);
                        q.f(a2, "getBackStackEntryAt(...)");
                        String s2 = a2.i;
                        I i1 = l00.E(s2);
                        if(i1 instanceof FragmentStack) {
                            if(((FragmentStack)i1).shouldOnResume()) {
                                break;
                            }
                            a0.d(i1);
                            a0.f(i1);
                            this.setTagStackDirty(s2);
                            ++v3;
                            LogU.Companion.v("BottomTabBaseFragment", "removeFragmentByIndex(shouldOnResume) " + i1 + " removed");
                        }
                    }
                }
                a0.l(true, true);
                if(v3 > 0) {
                    androidx.fragment.app.a a3 = l00.I(v2 - v3);
                    q.f(a3, "getBackStackEntryAt(...)");
                    try {
                        l00.W(a3.t);
                    }
                    catch(IllegalStateException illegalStateException0) {
                        LogU.Companion.v("BottomTabBaseFragment", "removeFragmentByIndex() " + illegalStateException0);
                        if(this.DEBUG) {
                            illegalStateException0.printStackTrace();
                        }
                    }
                }
                this.removeBringToFrontFragment(s);
                return true;
            }
            return false;
        }
    }

    public final void restoreState() {
        for(Object object0: this.getChildFragmentManager().c.f()) {
            I i0 = (I)object0;
            try {
                q.d(i0);
                this.addFragment(i0);
            }
            catch(Exception exception0) {
                com.iloen.melon.utils.a.v("restoreState() - ", exception0.getMessage(), LogU.Companion, "BottomTabBaseFragment");
            }
        }
    }

    public final void saveState() {
        l0 l00 = this.getChildFragmentManager();
        List list0 = l00.c.f();
        q.f(list0, "getFragments(...)");
        int v = 0;
        for(Object object0: list0) {
            l00.a0(new Bundle(), "fragment:" + v, ((I)object0));
            ++v;
        }
    }

    public void scrollToTop(boolean z) {
        I i0 = this.getCurrentFragment();
        if(i0 != null && i0 instanceof q1) {
            ((q1)i0).scrollToTop(z);
        }
    }

    public final void setBottomTabEventListener(@NotNull BottomTabEventListener bottomTabBaseFragment$BottomTabEventListener0) {
        q.g(bottomTabBaseFragment$BottomTabEventListener0, "listener");
        this.listener = bottomTabBaseFragment$BottomTabEventListener0;
    }

    public final void setInnerFragmentCreated(boolean z) {
        this.isInnerFragmentCreated = z;
    }

    private final void setTagStackDirty(String s) {
        if(TextUtils.isEmpty(s)) {
            return;
        }
        synchronized(this.mTagStack) {
            if(this.mTagStack.containsKey(s)) {
                if(this.DEBUG) {
                    LogU.Companion.v("BottomTabBaseFragment", "setTagStackDirty() tag: " + s);
                }
                if(s != null) {
                    this.mTagStack.put(s, 0);
                }
            }
        }
    }

    private final void setTagStackReuse(String s) {
        if(TextUtils.isEmpty(s)) {
            return;
        }
        synchronized(this.mTagStack) {
            if(!this.mTagStack.containsKey(s)) {
                if(this.DEBUG) {
                    LogU.Companion.v("BottomTabBaseFragment", "setTagStackReuse() tag: " + s);
                }
                this.mTagStack.put(s, 1);
            }
        }
    }
}

