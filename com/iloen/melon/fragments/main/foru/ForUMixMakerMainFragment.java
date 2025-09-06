package com.iloen.melon.fragments.main.foru;

import Cc.N1;
import Cc.c1;
import Cc.e0;
import De.I;
import J8.a1;
import J8.b;
import M.c;
import M.g;
import M.j;
import M.n0;
import M.p0;
import M.w;
import M.y;
import Q0.k0;
import X0.u;
import X0.x;
import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.request.ForuMixMakerMainReq;
import com.iloen.melon.net.v6x.response.ForuMixMakerMainRes.RESPONSE.ARTISTTAGLIST;
import com.iloen.melon.net.v6x.response.ForuMixMakerMainRes.RESPONSE.TAGLIST;
import com.iloen.melon.net.v6x.response.ForuMixMakerMainRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ForuMixMakerMainRes;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.datastore.MixMakerPreferencesRepository;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewTreeObserverHelper;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import d8.d;
import ie.H;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.p;
import p8.s;
import v9.h;
import v9.i;
import we.o;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001BB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\rH\u0014\u00A2\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0016\u001A\u0004\u0018\u00010\rH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001B\u001A\u00020\u000F2\u0006\u0010\u001A\u001A\u00020\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\rH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u0003J\u000F\u0010\u001E\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u0003J\u0017\u0010!\u001A\u00020\u000F2\u0006\u0010 \u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b!\u0010\"J\u0011\u0010$\u001A\u0004\u0018\u00010#H\u0014\u00A2\u0006\u0004\b$\u0010%J\u001D\u0010)\u001A\b\u0012\u0002\b\u0003\u0018\u00010(2\u0006\u0010\'\u001A\u00020&H\u0014\u00A2\u0006\u0004\b)\u0010*J-\u00100\u001A\u00020\u00072\b\u0010,\u001A\u0004\u0018\u00010+2\b\u0010.\u001A\u0004\u0018\u00010-2\b\u0010/\u001A\u0004\u0018\u00010\nH\u0014\u00A2\u0006\u0004\b0\u00101J\u0011\u00103\u001A\u0004\u0018\u000102H\u0002\u00A2\u0006\u0004\b3\u00104J\u0017\u00107\u001A\u00020\u000F2\u0006\u00106\u001A\u000205H\u0002\u00A2\u0006\u0004\b7\u00108R\u0018\u0010:\u001A\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001A\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010>R\u0011\u0010A\u001A\u0002098F\u00A2\u0006\u0006\u001A\u0004\b?\u0010@\u00A8\u0006D\u00B2\u0006\f\u0010C\u001A\u00020\u00078\nX\u008A\u0084\u0002"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerMainFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lcom/iloen/melon/custom/f1;", "getInsetHandlingType", "()Lcom/iloen/melon/custom/f1;", "", "isScreenLandscapeSupported", "()Z", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onForeground", "onDestroyView", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Lcom/iloen/melon/net/v6x/response/ForuMixMakerMainRes;", "fetchData", "()Lcom/iloen/melon/net/v6x/response/ForuMixMakerMainRes;", "Lcom/iloen/melon/net/v6x/response/ForuMixMakerMainRes$RESPONSE;", "res", "updateUi", "(Lcom/iloen/melon/net/v6x/response/ForuMixMakerMainRes$RESPONSE;)V", "LJ8/a1;", "_binding", "LJ8/a1;", "Lcom/iloen/melon/utils/ui/ViewTreeObserverHelper;", "observerHelper", "Lcom/iloen/melon/utils/ui/ViewTreeObserverHelper;", "getBinding", "()LJ8/a1;", "binding", "Companion", "isPressed", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ForUMixMakerMainFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001A\u00020\u0007H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerMainFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/main/foru/ForUMixMakerMainFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ForUMixMakerMainFragment newInstance() {
            ForUMixMakerMainFragment forUMixMakerMainFragment0 = new ForUMixMakerMainFragment();
            forUMixMakerMainFragment0.setArguments(new Bundle());
            return forUMixMakerMainFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "ForUMixMakerMainFragment";
    @Nullable
    private a1 _binding;
    @Nullable
    private ViewTreeObserverHelper observerHelper;

    static {
        ForUMixMakerMainFragment.Companion = new Companion(null);
        ForUMixMakerMainFragment.$stable = 8;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return null;
    }

    private final ForuMixMakerMainRes fetchData() {
        ForuMixMakerMainRes foruMixMakerMainRes0;
        Closeable closeable0 = a.f(this.getContext(), this.getCacheKey());
        try {
            foruMixMakerMainRes0 = (ForuMixMakerMainRes)a.d(((Cursor)closeable0), ForuMixMakerMainRes.class);
        }
        catch(Throwable throwable0) {
            d.l(closeable0, throwable0);
            throw throwable0;
        }
        d.l(closeable0, null);
        return foruMixMakerMainRes0;
    }

    @NotNull
    public final a1 getBinding() {
        a1 a10 = this._binding;
        q.d(a10);
        return a10;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.w.buildUpon().build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public f1 getInsetHandlingType() {
        return f1.b;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    // 检测为 Lambda 实现
    public static void k0(View view0, boolean z) [...]

    @NotNull
    public static final ForUMixMakerMainFragment newInstance() {
        return ForUMixMakerMainFragment.Companion.newInstance();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        if(ScreenUtils.isTablet(this.getContext())) {
            this.getBinding().d.setImageResource(0x7F080652);  // drawable:img_mixmaker_top_bg_large
        }
        this.startFetch("redraw");
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D02AD, viewGroup0, false);  // layout:fragment_for_u_mix_maker_main
        int v = 0x7F0A00B3;  // id:artist_container
        View view1 = I.C(view0, 0x7F0A00B3);  // id:artist_container
        if(((MixMakerTagCollectionView)view1) != null) {
            v = 0x7F0A0308;  // id:compose_recently
            View view2 = I.C(view0, 0x7F0A0308);  // id:compose_recently
            if(((ComposeView)view2) != null && ((Guideline)I.C(view0, 0x7F0A050B)) != null && ((Guideline)I.C(view0, 0x7F0A051D)) != null) {  // id:guideline_add
                v = 0x7F0A05FE;  // id:iv_bg
                View view3 = I.C(view0, 0x7F0A05FE);  // id:iv_bg
                if(((ImageView)view3) != null) {
                    v = 0x7F0A061D;  // id:iv_delete
                    View view4 = I.C(view0, 0x7F0A061D);  // id:iv_delete
                    if(((ImageView)view4) != null) {
                        v = 0x7F0A06AB;  // id:iv_tooltip_arrow
                        View view5 = I.C(view0, 0x7F0A06AB);  // id:iv_tooltip_arrow
                        if(((ImageView)view5) != null) {
                            v = 0x7F0A06F4;  // id:layout_add
                            View view6 = I.C(view0, 0x7F0A06F4);  // id:layout_add
                            if(((LinearLayoutCompat)view6) != null) {
                                v = 0x7F0A074F;  // id:layout_tooltip
                                View view7 = I.C(view0, 0x7F0A074F);  // id:layout_tooltip
                                if(((LinearLayoutCompat)view7) != null) {
                                    v = 0x7F0A08A5;  // id:network_error_layout
                                    View view8 = I.C(view0, 0x7F0A08A5);  // id:network_error_layout
                                    if(view8 != null) {
                                        b b0 = b.a(view8);
                                        v = 0x7F0A0A0D;  // id:root_scroll_view
                                        View view9 = I.C(view0, 0x7F0A0A0D);  // id:root_scroll_view
                                        if(((NestedScrollView)view9) != null) {
                                            v = 0x7F0A0A2D;  // id:scroll_linear
                                            View view10 = I.C(view0, 0x7F0A0A2D);  // id:scroll_linear
                                            if(((LinearLayoutCompat)view10) != null) {
                                                v = 0x7F0A0B25;  // id:tag_container
                                                View view11 = I.C(view0, 0x7F0A0B25);  // id:tag_container
                                                if(((MixMakerTagCollectionView)view11) != null) {
                                                    v = 0x7F0A0B2E;  // id:tag_scroll
                                                    View view12 = I.C(view0, 0x7F0A0B2E);  // id:tag_scroll
                                                    if(((HorizontalScrollView)view12) != null) {
                                                        v = 0x7F0A0C04;  // id:tv_add_keyword
                                                        View view13 = I.C(view0, 0x7F0A0C04);  // id:tv_add_keyword
                                                        if(((MelonTextView)view13) != null) {
                                                            this._binding = new a1(((FrameLayout)view0), ((MixMakerTagCollectionView)view1), ((ComposeView)view2), ((ImageView)view3), ((ImageView)view4), ((ImageView)view5), ((LinearLayoutCompat)view6), ((LinearLayoutCompat)view7), b0, ((NestedScrollView)view9), ((LinearLayoutCompat)view10), ((MixMakerTagCollectionView)view11), ((HorizontalScrollView)view12), ((MelonTextView)view13));
                                                            a1 a10 = this.getBinding();
                                                            q.f(a10.a, "getRoot(...)");
                                                            return a10.a;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
        ViewTreeObserverHelper viewTreeObserverHelper0 = this.observerHelper;
        if(viewTreeObserverHelper0 != null) {
            viewTreeObserverHelper0.unregisterGlobalLayoutListener();
            this.observerHelper = null;
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        Context context0 = this.getContext();
        if(a.e(300000L, this.getCacheKey(), context0)) {
            RequestBuilder.newInstance(new ForuMixMakerMainReq(this.getContext())).tag(this.getRequestTag()).listener(new k(this)).errorListener(new k(this)).request();
            return true;
        }
        ForuMixMakerMainRes foruMixMakerMainRes0 = this.fetchData();
        if(foruMixMakerMainRes0 != null) {
            RESPONSE foruMixMakerMainRes$RESPONSE0 = foruMixMakerMainRes0.response;
            if(foruMixMakerMainRes$RESPONSE0 != null) {
                this.mMelonTiaraProperty = new s(foruMixMakerMainRes$RESPONSE0.section, foruMixMakerMainRes$RESPONSE0.page, foruMixMakerMainRes$RESPONSE0.menuId, null);
                this.updateUi(foruMixMakerMainRes$RESPONSE0);
            }
        }
        return false;
    }

    private static final void onFetchStart$lambda$2(ForUMixMakerMainFragment forUMixMakerMainFragment0, ForuMixMakerMainRes foruMixMakerMainRes0) {
        if(!forUMixMakerMainFragment0.prepareFetchComplete(foruMixMakerMainRes0)) {
            a1 a10 = forUMixMakerMainFragment0._binding;
            if(a10 != null) {
                a10.j.setVisibility(8);
            }
            a1 a11 = forUMixMakerMainFragment0._binding;
            if(a11 != null) {
                a11.d.setVisibility(8);
            }
            return;
        }
        a1 a12 = forUMixMakerMainFragment0._binding;
        if(a12 != null) {
            a12.j.setVisibility(0);
        }
        a1 a13 = forUMixMakerMainFragment0._binding;
        if(a13 != null) {
            a13.d.setVisibility(0);
        }
        a.a(forUMixMakerMainFragment0.getContext(), foruMixMakerMainRes0, forUMixMakerMainFragment0.getCacheKey());
        if(foruMixMakerMainRes0 != null) {
            RESPONSE foruMixMakerMainRes$RESPONSE0 = foruMixMakerMainRes0.response;
            if(foruMixMakerMainRes$RESPONSE0 != null) {
                forUMixMakerMainFragment0.mMelonTiaraProperty = new s(foruMixMakerMainRes$RESPONSE0.section, foruMixMakerMainRes$RESPONSE0.page, "", null);
                forUMixMakerMainFragment0.updateUi(foruMixMakerMainRes$RESPONSE0);
            }
        }
        forUMixMakerMainFragment0.performFetchCompleteOnlyViews();
    }

    private static final void onFetchStart$lambda$3(ForUMixMakerMainFragment forUMixMakerMainFragment0, VolleyError volleyError0) {
        a1 a10 = forUMixMakerMainFragment0._binding;
        if(a10 != null) {
            NestedScrollView nestedScrollView0 = a10.j;
            if(nestedScrollView0 != null) {
                nestedScrollView0.setVisibility(8);
            }
        }
        a1 a11 = forUMixMakerMainFragment0._binding;
        if(a11 != null) {
            ImageView imageView0 = a11.d;
            if(imageView0 != null) {
                imageView0.setVisibility(8);
            }
        }
        forUMixMakerMainFragment0.performFetchError(volleyError0);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onForeground() {
        super.onForeground();
        FragmentActivity fragmentActivity0 = this.getActivity();
        ScreenUtils.setAppearanceLightStatusBars((fragmentActivity0 == null ? null : fragmentActivity0.getWindow()), !ScreenUtils.isDarkMode(this.getContext()));
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(B.a.s(1));
            titleBar0.setTitle("믹스메이커");
            titleBar0.setBackgroundColor(0);
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = titleBar0.getLayoutParams();
            q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin = ScreenUtils.getStatusBarHeight(titleBar0.getContext());
            titleBar0.requestLayout();
        }
        if(ScreenUtils.isTablet(this.getContext())) {
            this.getBinding().d.setImageResource(0x7F080652);  // drawable:img_mixmaker_top_bg_large
        }
        this.mEmptyView = (LinearLayout)this.getBinding().i.b;
    }

    private final void updateUi(RESPONSE foruMixMakerMainRes$RESPONSE0) {
        a1 a10 = this.getBinding();
        if(ScreenUtils.isTablet(this.getContext())) {
            a10.d.setImageResource(0x7F080652);  // drawable:img_mixmaker_top_bg_large
            int v = ScreenUtils.dipToPixel(this.getContext(), 36.0f);
            a10.k.setPadding(v, 0, v, 0);
            int v1 = ScreenUtils.getScreenWidth(this.getContext()) - v * 2;
            a10.l.setRowWidth(v1);
            a10.l.setMaxRowCount(7);
            a10.b.setRowWidth(v1);
        }
        boolean z = MelonPrefs.getInstance().getBoolean("mixMakerTooltipClicked", false);
        ComposeView composeView0 = a10.c;
        a10.g.setVisibility(0);
        m m0 = (View view0) -> ForUMixMakerMainFragment.updateUi$lambda$39$lambda$6(z, view0);
        a10.g.setOnClickListener(m0);
        ViewUtilsKt.setAccessibilityButtonClassName(a10.n);
        if(!z) {
            a10.h.setVisibility(0);
            a10.f.setVisibility(0);
            com.iloen.melon.fragments.main.foru.d d0 = new com.iloen.melon.fragments.main.foru.d(a10, 3);
            a10.e.setOnClickListener(d0);
        }
        ArrayList arrayList0 = MixMakerUtils.INSTANCE.getRecentSelectedTagHistory();
        ArrayList arrayList1 = foruMixMakerMainRes$RESPONSE0.tagList;
        if(arrayList1 != null) {
            MixMakerTagCollectionView mixMakerTagCollectionView0 = a10.l;
            for(Object object0: arrayList1) {
                TAGLIST foruMixMakerMainRes$RESPONSE$TAGLIST0 = (TAGLIST)object0;
                for(Object object1: arrayList0) {
                    if(!q.b(foruMixMakerMainRes$RESPONSE$TAGLIST0.tagName, ((String)object1))) {
                        continue;
                    }
                    goto label_34;
                }
                object1 = null;
            label_34:
                foruMixMakerMainRes$RESPONSE$TAGLIST0.isSaved = object1 != null;
            }
            mixMakerTagCollectionView0.setItemLayoutRes(0x7F0D051E);  // layout:mix_maker_unselected_keyword_item_layout
            mixMakerTagCollectionView0.setItems(foruMixMakerMainRes$RESPONSE0.tagList);
            mixMakerTagCollectionView0.setOnItemClickListener(new n(foruMixMakerMainRes$RESPONSE0, 0));
        }
        ArrayList arrayList2 = foruMixMakerMainRes$RESPONSE0.artistTagList;
        if(arrayList2 != null) {
            MixMakerTagCollectionView mixMakerTagCollectionView1 = a10.b;
            for(Object object2: arrayList2) {
                ARTISTTAGLIST foruMixMakerMainRes$RESPONSE$ARTISTTAGLIST0 = (ARTISTTAGLIST)object2;
                for(Object object3: arrayList0) {
                    if(!q.b(foruMixMakerMainRes$RESPONSE$ARTISTTAGLIST0.tagName, ((String)object3))) {
                        continue;
                    }
                    goto label_52;
                }
                object3 = null;
            label_52:
                foruMixMakerMainRes$RESPONSE$ARTISTTAGLIST0.isSaved = object3 != null;
            }
            mixMakerTagCollectionView1.setItemLayoutRes(0x7F0D051E);  // layout:mix_maker_unselected_keyword_item_layout
            mixMakerTagCollectionView1.setItems(foruMixMakerMainRes$RESPONSE0.artistTagList);
            mixMakerTagCollectionView1.setOnItemClickListener(new n(foruMixMakerMainRes$RESPONSE0, 1));
        }
        composeView0.setContent(new m0.b(0x3EAAC3BF, (l l0, int v) -> {
            p p3;
            r0.n n1;
            androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
            boolean z = p0.Q(v & 1, (v & 3) != 2);
            H h0 = H.a;
            if(z) {
                p p1 = p0.N();
                V v1 = androidx.compose.runtime.k.a;
                if(p1 == v1) {
                    p1 = new p();
                    p0.l0(p1);
                }
                com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.1.1 forUMixMakerMainFragment$updateUi$1$5$1$10 = p0.N();
                if(forUMixMakerMainFragment$updateUi$1$5$1$10 == v1) {
                    forUMixMakerMainFragment$updateUi$1$5$1$10 = new com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.1.1(p1, null);
                    p0.l0(forUMixMakerMainFragment$updateUi$1$5$1$10);
                }
                J.d(p0, h0, forUMixMakerMainFragment$updateUi$1$5$1$10);
                r0.n n0 = r0.n.a;
                r0.q q0 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3);
                y y0 = w.a(j.c, r0.d.m, p0, 0);
                int v2 = p0.P;
                i0 i00 = p0.m();
                r0.q q1 = r0.a.d(p0, q0);
                P0.k.y.getClass();
                P0.i i0 = P0.j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                P0.h h1 = P0.j.f;
                androidx.compose.runtime.w.x(p0, y0, h1);
                P0.h h2 = P0.j.e;
                androidx.compose.runtime.w.x(p0, i00, h2);
                P0.h h3 = P0.j.g;
                if(p0.O || !q.b(p0.N(), v2)) {
                    A7.d.q(v2, p0, v2, h3);
                }
                P0.h h4 = P0.j.d;
                androidx.compose.runtime.w.x(p0, q1, h4);
                r0.q q2 = androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 42.0f), 20.0f, 0.0f, 2);
                p0 p00 = n0.a(j.g, r0.d.k, p0, 54);
                int v3 = p0.P;
                i0 i01 = p0.m();
                r0.q q3 = r0.a.d(p0, q2);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, p00, h1);
                androidx.compose.runtime.w.x(p0, i01, h2);
                if(p0.O || !q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h3);
                }
                androidx.compose.runtime.w.x(p0, q3, h4);
                String s = this.getString(0x7F130451);  // string:for_u_mix_maker_keyword_recently "최근에 만든"
                q.f(s, "getString(...)");
                long v4 = e0.T(p0, 0x7F06016D);  // color:gray900s
                e1.y y1 = e1.y.i;
                com.iloen.melon.fragments.main.foru.p p2 = p0.N();
                if(p2 == v1) {
                    p2 = (x x0) -> {
                        q.g(x0, "$this$semantics");
                        u.e(x0);
                        return H.a;
                    };
                    p0.l0(p2);
                }
                N1.b(s, X0.n.c(n0, false, p2), v4, 16.0f, y1, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD0);
                if(p1.isEmpty()) {
                    p3 = p1;
                    n1 = n0;
                    p0.a0(0x63AC6009);
                }
                else {
                    p0.a0(0x64740CBC);
                    String s1 = this.getString(0x7F13107A);  // string:toolbar_delete_all "전체삭제"
                    q.f(s1, "getString(...)");
                    long v5 = e0.T(p0, 0x7F060163);  // color:gray700s
                    n1 = n0;
                    r0.q q4 = r0.a.a(n1, new com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.lambda.39.lambda.36.lambda.35.lambda.23..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0, this));
                    boolean z1 = p0.i(this);
                    com.iloen.melon.fragments.main.foru.l l1 = p0.N();
                    if(z1 || l1 == v1) {
                        l1 = new com.iloen.melon.fragments.main.foru.l(this, 1);
                        p0.l0(l1);
                    }
                    p3 = p1;
                    N1.b(s1, X0.n.b(q4, l1), v5, 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);
                }
                p0.p(false);
                p0.p(true);
                if(p3.isEmpty()) {
                    p0.a0(0xB5E9E520);
                    c.d(p0, androidx.compose.foundation.layout.d.h(n1, 30.0f));
                    String s2 = this.getString(0x7F130453);  // string:for_u_mix_maker_keyword_recently_empty "최근에 만든 믹스가 없습니다."
                    q.f(s2, "getString(...)");
                    long v6 = e0.T(p0, 0x7F060163);  // color:gray700s
                    N1.b(s2, new HorizontalAlignElement(r0.d.n), v6, 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);
                    A7.d.v(n1, 30.0f, p0, false);
                }
                else {
                    p0.a0(0xB5F333A5);
                    c.d(p0, androidx.compose.foundation.layout.d.h(n1, 10.0f));
                    r0.q q5 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.t(n1, 3), 1.0f);
                    g g0 = j.h(8.0f);
                    M.j0 j00 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
                    com.iloen.melon.fragments.main.foru.l l2 = p0.N();
                    if(l2 == v1) {
                        l2 = new com.iloen.melon.fragments.main.foru.l(p3, 0);
                        p0.l0(l2);
                    }
                    c1.q(q5, null, j00, g0, null, null, false, l2, p0, 0x6006186, 0xEA);
                    A7.d.v(n1, 40.0f, p0, false);
                }
                p0.p(true);
                return h0;
            }
            p0.T();
            return h0;
        }, true));
        composeView0.setVisibility(0);
        ViewTreeObserverHelper viewTreeObserverHelper0 = this.observerHelper;
        if(viewTreeObserverHelper0 != null) {
            viewTreeObserverHelper0.unregisterGlobalLayoutListener();
            this.observerHelper = null;
        }
        ViewTreeObserverHelper viewTreeObserverHelper1 = new ViewTreeObserverHelper();
        com.iloen.melon.fragments.main.foru.g g0 = new com.iloen.melon.fragments.main.foru.g(3, a10, this);
        viewTreeObserverHelper1.registerGlobalLayoutListener(a10.k, g0);
        this.observerHelper = viewTreeObserverHelper1;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment$updateUi$1$5$1$1", f = "ForUMixMakerMainFragment.kt", l = {285}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.1.1 extends oe.i implements we.n {
            final p $displayedTitleList;
            int label;

            public com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.1.1(p p0, Continuation continuation0) {
                this.$displayedTitleList = p0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.1.1(this.$displayedTitleList, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.1.1.1 forUMixMakerMainFragment$updateUi$1$5$1$1$10 = new we.n(null) {
                            final p $displayedTitleList;
                            Object L$0;
                            int label;

                            {
                                this.$displayedTitleList = p0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.1.1.1(this.$displayedTitleList, continuation0);
                                continuation1.L$0 = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((List)object0), ((Continuation)object1));
                            }

                            public final Object invoke(List list0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.1.1.1)this.create(list0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                List list0 = (List)this.L$0;
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                this.$displayedTitleList.clear();
                                Collection collection0 = je.p.C0(list0);
                                this.$displayedTitleList.addAll(collection0);
                                return H.a;
                            }
                        };
                        this.label = 1;
                        return FlowKt.collectLatest(MixMakerPreferencesRepository.INSTANCE.getMixTitleFlow(), forUMixMakerMainFragment$updateUi$1$5$1$1$10, this) == a0 ? a0 : H.a;
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
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.1.2.1 implements we.a {
            public static final com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.1.2.1 INSTANCE;

            static {
                com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.1.2.1.INSTANCE = new com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.1.2.1();
            }

            public com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.1.2.1() {
                super();
            }

            @Override  // we.a
            public Object invoke() {
                this.invoke();
                return H.a;
            }

            public final void invoke() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new we.n() {
                    int label;

                    {
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.1.2.1.1(continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.1.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        switch(this.label) {
                            case 0: {
                                d5.n.D(object0);
                                this.label = 1;
                                return MixMakerPreferencesRepository.INSTANCE.clear(this) == a0 ? a0 : H.a;
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
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.1.1 implements we.a {
            public com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.1.1(String s) {
            }

            @Override  // we.a
            public Object invoke() {
                this.invoke();
                return H.a;
            }

            public final void invoke() {
                Navigator.INSTANCE.openMixMakerPlaylistDetail(this.$mixTitle, 1);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.2.1 implements we.k {
            public static final com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.2.1 INSTANCE;

            static {
                com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.2.1.INSTANCE = new com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.2.1();
            }

            public com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.2.1() {
                super();
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((x)object0));
                return H.a;
            }

            public final void invoke(x x0) {
                q.g(x0, "$this$semantics");
                u.k(x0, 0);
            }
        }


        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment$updateUi$1$5$2$2$1$1$3$1$1", f = "ForUMixMakerMainFragment.kt", l = {400}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.3.1.1 extends oe.i implements we.n {
            final String $mixTitle;
            int label;

            public com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.3.1.1(String s, Continuation continuation0) {
                this.$mixTitle = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.3.1.1(this.$mixTitle, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.3.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        return MixMakerPreferencesRepository.INSTANCE.remove(this.$mixTitle, this) == a0 ? a0 : H.a;
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
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.3.2.1 implements we.k {
            public static final com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.3.2.1 INSTANCE;

            static {
                com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.3.2.1.INSTANCE = new com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.3.2.1();
            }

            public com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.3.2.1() {
                super();
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((x)object0));
                return H.a;
            }

            public final void invoke(x x0) {
                q.g(x0, "$this$semantics");
                u.k(x0, 0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.lambda.39.lambda.36.lambda.35.lambda.23..inlined.noRippleClickable-YQRRFTQ.default.1 implements o {
            public com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.lambda.39.lambda.36.lambda.35.lambda.23..inlined.noRippleClickable-YQRRFTQ.default.1(boolean z, String s, int v, ForUMixMakerMainFragment forUMixMakerMainFragment0) {
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
            }

            public final r0.q invoke(r0.q q0, l l0, int v) {
                q.g(q0, "$this$composed");
                ((androidx.compose.runtime.p)l0).a0(0x1FF03545);
                w0.h h0 = (w0.h)((androidx.compose.runtime.p)l0).k(k0.i);
                K.m m0 = ((androidx.compose.runtime.p)l0).N();
                if(m0 == androidx.compose.runtime.k.a) {
                    m0 = androidx.appcompat.app.o.d(((androidx.compose.runtime.p)l0));
                }
                X0.i i0 = new X0.i(this.$role);
                com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.lambda.39.lambda.36.lambda.35.lambda.23..inlined.noRippleClickable-YQRRFTQ.default.1.1 forUMixMakerMainFragment$updateUi$lambda$39$lambda$36$lambda$35$lambda$23$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        w0.h.a(ForUMixMakerMainFragment.this);
                        com.melon.ui.popup.b.x(ForUMixMakerMainFragment.this.getChildFragmentManager(), ForUMixMakerMainFragment.this.getString(0x7F1300D0), ForUMixMakerMainFragment.this.getString(0x7F130452), false, false, null, null, com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.1.2.1.INSTANCE, null, null, null, 0xEF8);  // string:alert_dlg_title_info "안내"
                    }
                };
                r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, this.$enabled, this.$onClickLabel, i0, forUMixMakerMainFragment$updateUi$lambda$39$lambda$36$lambda$35$lambda$23$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                ((androidx.compose.runtime.p)l0).p(false);
                return q1;
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.lambda.39.lambda.36.lambda.35.lambda.34.lambda.33..inlined.itemsIndexed.default.1 extends r implements we.k {
            final List $items;
            final we.n $key;

            public com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.lambda.39.lambda.36.lambda.35.lambda.34.lambda.33..inlined.itemsIndexed.default.1(we.n n0, List list0) {
                this.$key = n0;
                this.$items = list0;
                super(1);
            }

            public final Object invoke(int v) {
                Object object0 = this.$items.get(v);
                return this.$key.invoke(v, object0);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Number)object0).intValue());
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.lambda.39.lambda.36.lambda.35.lambda.34.lambda.33..inlined.itemsIndexed.default.2 extends r implements we.k {
            final List $items;

            public com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.lambda.39.lambda.36.lambda.35.lambda.34.lambda.33..inlined.itemsIndexed.default.2(List list0) {
                this.$items = list0;
                super(1);
            }

            public final Object invoke(int v) {
                this.$items.get(v);
                return null;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Number)object0).intValue());
            }
        }


        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0002H\u000B¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Landroidx/compose/foundation/lazy/a;", "", "it", "Lie/H;", "invoke", "(Landroidx/compose/foundation/lazy/a;ILandroidx/compose/runtime/l;I)V", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.lambda.39.lambda.36.lambda.35.lambda.34.lambda.33..inlined.itemsIndexed.default.3 extends r implements we.p {
            final List $items;

            public com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.lambda.39.lambda.36.lambda.35.lambda.34.lambda.33..inlined.itemsIndexed.default.3(List list0) {
                this.$items = list0;
                super(4);
            }

            @Override  // we.p
            public Object invoke(Object object0, Object object1, Object object2, Object object3) {
                this.invoke(((androidx.compose.foundation.lazy.a)object0), ((Number)object1).intValue(), ((l)object2), ((Number)object3).intValue());
                return H.a;
            }

            public final void invoke(androidx.compose.foundation.lazy.a a0, int v, l l0, int v1) {
                int v2 = (v1 & 6) == 0 ? v1 | (((androidx.compose.runtime.p)l0).g(a0) ? 4 : 2) : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((androidx.compose.runtime.p)l0).e(v) ? 0x20 : 16);
                }
                androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
                if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    Object object0 = this.$items.get(v);
                    p0.a0(1147101060);
                    K.m m0 = p0.N();
                    V v3 = androidx.compose.runtime.k.a;
                    if(m0 == v3) {
                        m0 = androidx.appcompat.app.o.d(p0);
                    }
                    b0 b00 = ye.a.u(m0, p0, 6);
                    r0.n n0 = r0.n.a;
                    r0.q q0 = androidx.compose.foundation.q.e(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.v(n0, null, 3), 46.0f), wc.u.e(e.k.A(new y0.s[]{new y0.s(0xFF00CD3C00000000L), new y0.s(0xFF00BDFF00000000L)}), 0.0f, 0.0f, 14), T.e.b(100.0f), 4);
                    boolean z = p0.g(((String)object0));
                    com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.1.1 forUMixMakerMainFragment$updateUi$1$5$2$2$1$1$1$10 = p0.N();
                    if(z || forUMixMakerMainFragment$updateUi$1$5$2$2$1$1$1$10 == v3) {
                        forUMixMakerMainFragment$updateUi$1$5$2$2$1$1$1$10 = new com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.1.1(((String)object0));
                        p0.l0(forUMixMakerMainFragment$updateUi$1$5$2$2$1$1$1$10);
                    }
                    r0.q q1 = androidx.compose.foundation.q.m(q0, m0, null, false, null, forUMixMakerMainFragment$updateUi$1$5$2$2$1$1$1$10, 28);
                    com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.2.1 forUMixMakerMainFragment$updateUi$1$5$2$2$1$1$2$10 = p0.N();
                    if(forUMixMakerMainFragment$updateUi$1$5$2$2$1$1$2$10 == v3) {
                        forUMixMakerMainFragment$updateUi$1$5$2$2$1$1$2$10 = com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.2.1.INSTANCE;
                        p0.l0(forUMixMakerMainFragment$updateUi$1$5$2$2$1$1$2$10);
                    }
                    r0.q q2 = X0.n.c(q1, false, forUMixMakerMainFragment$updateUi$1$5$2$2$1$1$2$10);
                    r0.h h0 = r0.d.k;
                    M.b b0 = j.a;
                    p0 p00 = n0.a(b0, h0, p0, 0x30);
                    int v4 = p0.P;
                    i0 i00 = p0.m();
                    r0.q q3 = r0.a.d(p0, q2);
                    P0.k.y.getClass();
                    P0.i i0 = P0.j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i0);
                    }
                    else {
                        p0.o0();
                    }
                    P0.h h1 = P0.j.f;
                    androidx.compose.runtime.w.x(p0, p00, h1);
                    P0.h h2 = P0.j.e;
                    androidx.compose.runtime.w.x(p0, i00, h2);
                    P0.h h3 = P0.j.g;
                    if(p0.O || !q.b(p0.N(), v4)) {
                        A7.d.q(v4, p0, v4, h3);
                    }
                    P0.h h4 = P0.j.d;
                    androidx.compose.runtime.w.x(p0, q3, h4);
                    c.d(p0, androidx.compose.foundation.layout.d.q(n0, 18.0f));
                    N1.b(((String)object0), androidx.compose.foundation.layout.d.r(n0, 0.0f, 200.0f), e0.T(p0, (ForUMixMakerMainFragment.updateUi$lambda$39$lambda$36$lambda$35$lambda$34$lambda$33$lambda$32$lambda$25(b00) ? 0x7F0604B4 : 0x7F0604A1)), 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);  // color:white500e_support_high_contrast
                    r0.q q4 = r0.a.a(androidx.compose.foundation.layout.d.c(androidx.compose.foundation.layout.d.v(n0, null, 3), 1.0f), new com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.lambda.39.lambda.36.lambda.35.lambda.34.lambda.33.lambda.32.lambda.31..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0, ((String)object0)));
                    com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.3.2.1 forUMixMakerMainFragment$updateUi$1$5$2$2$1$1$3$2$10 = p0.N();
                    if(forUMixMakerMainFragment$updateUi$1$5$2$2$1$1$3$2$10 == v3) {
                        forUMixMakerMainFragment$updateUi$1$5$2$2$1$1$3$2$10 = com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.3.2.1.INSTANCE;
                        p0.l0(forUMixMakerMainFragment$updateUi$1$5$2$2$1$1$3$2$10);
                    }
                    r0.q q5 = X0.n.c(q4, false, forUMixMakerMainFragment$updateUi$1$5$2$2$1$1$3$2$10);
                    p0 p01 = n0.a(b0, h0, p0, 0x30);
                    int v5 = p0.P;
                    i0 i01 = p0.m();
                    r0.q q6 = r0.a.d(p0, q5);
                    p0.e0();
                    if(p0.O) {
                        p0.l(i0);
                    }
                    else {
                        p0.o0();
                    }
                    androidx.compose.runtime.w.x(p0, p01, h1);
                    androidx.compose.runtime.w.x(p0, i01, h2);
                    if(p0.O || !q.b(p0.N(), v5)) {
                        A7.d.q(v5, p0, v5, h3);
                    }
                    androidx.compose.runtime.w.x(p0, q6, h4);
                    androidx.compose.foundation.q.c(I.Q(0x7F080134, p0, 6), "", null, null, null, 0.0f, null, p0, 0, 0x7C);  // drawable:btn_common_delete_26g_tooltip
                    c.d(p0, androidx.compose.foundation.layout.d.q(n0, 10.0f));
                    p0.p(true);
                    p0.p(true);
                    p0.p(false);
                    return;
                }
                p0.T();
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.lambda.39.lambda.36.lambda.35.lambda.34.lambda.33.lambda.32.lambda.31..inlined.noRippleClickable-YQRRFTQ.default.1 implements o {
            public com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.lambda.39.lambda.36.lambda.35.lambda.34.lambda.33.lambda.32.lambda.31..inlined.noRippleClickable-YQRRFTQ.default.1(boolean z, String s, int v, String s1) {
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
            }

            public final r0.q invoke(r0.q q0, l l0, int v) {
                q.g(q0, "$this$composed");
                ((androidx.compose.runtime.p)l0).a0(0x1FF03545);
                w0.h h0 = (w0.h)((androidx.compose.runtime.p)l0).k(k0.i);
                K.m m0 = ((androidx.compose.runtime.p)l0).N();
                if(m0 == androidx.compose.runtime.k.a) {
                    m0 = androidx.appcompat.app.o.d(((androidx.compose.runtime.p)l0));
                }
                X0.i i0 = new X0.i(this.$role);
                com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.lambda.39.lambda.36.lambda.35.lambda.34.lambda.33.lambda.32.lambda.31..inlined.noRippleClickable-YQRRFTQ.default.1.1 forUMixMakerMainFragment$updateUi$lambda$39$lambda$36$lambda$35$lambda$34$lambda$33$lambda$32$lambda$31$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        w0.h.a(this.$mixTitle$inlined);
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.1.5.2.2.1.1.3.1.1(this.$mixTitle$inlined, null), 3, null);
                    }
                };
                r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, this.$enabled, this.$onClickLabel, i0, forUMixMakerMainFragment$updateUi$lambda$39$lambda$36$lambda$35$lambda$34$lambda$33$lambda$32$lambda$31$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                ((androidx.compose.runtime.p)l0).p(false);
                return q1;
            }
        }

    }

    private static final void updateUi$lambda$39$lambda$11$lambda$10(RESPONSE foruMixMakerMainRes$RESPONSE0, View view0, int v) {
        SelectedTag selectedTag0 = new SelectedTag(((TAGLIST)foruMixMakerMainRes$RESPONSE0.tagList.get(v)).tagName, ((TAGLIST)foruMixMakerMainRes$RESPONSE0.tagList.get(v)).emoji);
        MixMakerUtils.INSTANCE.addRecentSelectedTagHistory(selectedTag0);
        ArrayList arrayList0 = new ArrayList(e.k.z(selectedTag0));
        Navigator.open(ForUMixMakerKeywordSelectFragment.Companion.newInstance(arrayList0));
    }

    private static final void updateUi$lambda$39$lambda$15$lambda$14(RESPONSE foruMixMakerMainRes$RESPONSE0, View view0, int v) {
        SelectedTag selectedTag0 = new SelectedTag(((ARTISTTAGLIST)foruMixMakerMainRes$RESPONSE0.artistTagList.get(v)).tagName, null, 2, null);
        MixMakerUtils.INSTANCE.addRecentSelectedTagHistory(selectedTag0);
        ArrayList arrayList0 = new ArrayList(e.k.z(selectedTag0));
        Navigator.open(ForUMixMakerKeywordSelectFragment.Companion.newInstance(arrayList0));
    }

    // 检测为 Lambda 实现
    private static final H updateUi$lambda$39$lambda$36(ForUMixMakerMainFragment forUMixMakerMainFragment0, l l0, int v) [...]

    // 检测为 Lambda 实现
    private static final H updateUi$lambda$39$lambda$36$lambda$35$lambda$23$lambda$19$lambda$18(x x0) [...]

    private static final H updateUi$lambda$39$lambda$36$lambda$35$lambda$23$lambda$22$lambda$21(ForUMixMakerMainFragment forUMixMakerMainFragment0, x x0) {
        q.g(x0, "$this$clearAndSetSemantics");
        String s = forUMixMakerMainFragment0.getString(0x7F13107A);  // string:toolbar_delete_all "전체삭제"
        q.f(s, "getString(...)");
        u.h(x0, s);
        u.k(x0, 0);
        return H.a;
    }

    private static final H updateUi$lambda$39$lambda$36$lambda$35$lambda$34$lambda$33(p p0, O.w w0) {
        q.g(w0, "$this$MelonLazyRow");
        ((O.j)w0).u(p0.size(), null, new com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.lambda.39.lambda.36.lambda.35.lambda.34.lambda.33..inlined.itemsIndexed.default.2(p0), new m0.b(0xBEF78951, new com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment.updateUi.lambda.39.lambda.36.lambda.35.lambda.34.lambda.33..inlined.itemsIndexed.default.3(p0), true));
        return H.a;
    }

    private static final boolean updateUi$lambda$39$lambda$36$lambda$35$lambda$34$lambda$33$lambda$32$lambda$25(b1 b10) {
        return ((Boolean)b10.getValue()).booleanValue();
    }

    private static final void updateUi$lambda$39$lambda$38$lambda$37(a1 a10, ForUMixMakerMainFragment forUMixMakerMainFragment0) {
        int v = a10.k.getWidth();
        int v1 = ScreenUtils.getScreenWidth(forUMixMakerMainFragment0.getContext());
        if(v > v1) {
            a10.m.scrollTo(v / 2 - v1 / 2, 0);
        }
    }

    private static final void updateUi$lambda$39$lambda$6(boolean z, View view0) {
        if(!z) {
            MelonPrefs.getInstance().setBoolean("mixMakerTooltipClicked", true);
        }
        Navigator.open(com.iloen.melon.fragments.main.foru.ForUMixMakerKeywordPredictiveFragment.Companion.newInstance$default(ForUMixMakerKeywordPredictiveFragment.Companion, null, 1, null));
    }

    private static final void updateUi$lambda$39$lambda$7(a1 a10, View view0) {
        q.f(a10.h, "layoutTooltip");
        a10.h.setVisibility(8);
        q.f(a10.f, "ivTooltipArrow");
        a10.f.setVisibility(8);
        MelonPrefs.getInstance().setBoolean("mixMakerTooltipClicked", true);
    }
}

