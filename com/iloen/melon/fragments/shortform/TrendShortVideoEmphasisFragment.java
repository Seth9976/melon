package com.iloen.melon.fragments.shortform;

import De.I;
import J8.X2;
import J8.r1;
import J8.u;
import U4.F;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.iloen.melon.fragments.comments.BbsParam;
import com.iloen.melon.fragments.detail.viewholder.s;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST.BANNER;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.Meta.Builder;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import m4.d;
import m4.e;
import m4.g;
import m4.h;
import m4.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;
import x1.a;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001A\u00020\u00042\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0002\u00A2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001A\u00020\u00042\b\u0010\u0012\u001A\u0004\u0018\u00010\u000EH\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0011J+\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0015\u001A\u00020\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0012\u001A\u0004\u0018\u00010\u000EH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ!\u0010\u001C\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u00182\b\u0010\u0012\u001A\u0004\u0018\u00010\u000EH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001E\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u001E\u0010\u0003J\u001F\u0010!\u001A\u00020\u00042\u0006\u0010\u001F\u001A\u00020\n2\u0006\u0010 \u001A\u00020\nH\u0016\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010#\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b#\u0010\u0003J\u001F\u0010\'\u001A\u00020\u00042\u0006\u0010$\u001A\u00020\n2\u0006\u0010&\u001A\u00020%H\u0016\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010)\u001A\u00020\u00042\u0006\u0010$\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b)\u0010*R\u0014\u0010,\u001A\u00020+8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001A\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001A\u00020.8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b1\u00102\u00A8\u00065"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendShortVideoEmphasisFragment;", "Lcom/iloen/melon/fragments/shortform/TrendVideoPlayerBaseFragment;", "<init>", "()V", "Lie/H;", "setFirstFrameToBackground", "Lcom/iloen/melon/net/v6x/response/TrendShortFormRes$Response$SLOTLIST;", "slotItem", "updateUI", "(Lcom/iloen/melon/net/v6x/response/TrendShortFormRes$Response$SLOTLIST;)V", "", "color", "updateBannerBackground", "(Ljava/lang/Integer;)V", "Landroid/os/Bundle;", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "savedInstanceState", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "failToPlayMedia", "width", "height", "onVideoSize", "(II)V", "onRenderPlayer", "sumCount", "", "isLike", "updateLikeView", "(IZ)V", "updateCommentCountView", "(I)V", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "LJ8/X2;", "_binding", "LJ8/X2;", "getViewBinding", "()LJ8/X2;", "viewBinding", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TrendShortVideoEmphasisFragment extends TrendVideoPlayerBaseFragment {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendShortVideoEmphasisFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/shortform/TrendShortVideoEmphasisFragment;", "position", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TrendShortVideoEmphasisFragment newInstance(int v) {
            TrendShortVideoEmphasisFragment trendShortVideoEmphasisFragment0 = new TrendShortVideoEmphasisFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putInt("argPosition", v);
            trendShortVideoEmphasisFragment0.setArguments(bundle0);
            return trendShortVideoEmphasisFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "TrendShortVideoEmphasisFragment";
    @Nullable
    private X2 _binding;
    @NotNull
    private final LogU log;

    static {
        TrendShortVideoEmphasisFragment.Companion = new Companion(null);
        TrendShortVideoEmphasisFragment.$stable = 8;
    }

    public TrendShortVideoEmphasisFragment() {
        LogU logU0 = new LogU("TrendShortVideoEmphasisFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.log = logU0;
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendShortBaseFragment
    public void failToPlayMedia() {
        super.failToPlayMedia();
        X2 x20 = this.getViewBinding();
        q.f(((PlayerView)x20.e.d), "exoPlayerView");
        ((PlayerView)x20.e.d).setVisibility(8);
        X2 x21 = this.getViewBinding();
        q.f(((ImageView)x21.e.b), "imgDefault");
        ((ImageView)x21.e.b).setVisibility(0);
        X2 x22 = this.getViewBinding();
        q.f(((ImageView)x22.e.e), "imgStill");
        ((ImageView)x22.e.e).setVisibility(8);
        X2 x23 = this.getViewBinding();
        q.f(x23.c, "dimFullScreen");
        x23.c.setVisibility(8);
    }

    private final X2 getViewBinding() {
        X2 x20 = this._binding;
        q.d(x20);
        return x20;
    }

    public static void o(BANNER trendShortFormRes$Response$SLOTLIST$BANNER0, TrendShortVideoEmphasisFragment trendShortVideoEmphasisFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, View view0) {
        TrendShortVideoEmphasisFragment.updateUI$lambda$9$lambda$8(trendShortFormRes$Response$SLOTLIST$BANNER0, trendShortVideoEmphasisFragment0, trendShortFormRes$Response$SLOTLIST0, view0);
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendVideoPlayerBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        Bundle bundle1 = this.getArguments();
        this.setTabPosition((bundle1 == null ? -1 : bundle1.getInt("argPosition")));
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = this.getLayoutInflater().inflate(0x7F0D0842, viewGroup0, false);  // layout:short_form_video_emphasis_layout
        int v = 0x7F0A00FC;  // id:bg
        View view1 = I.C(view0, 0x7F0A00FC);  // id:bg
        if(((ImageView)view1) != null) {
            v = 0x7F0A03C5;  // id:dim_full_screen
            View view2 = I.C(view0, 0x7F0A03C5);  // id:dim_full_screen
            if(((ImageView)view2) != null) {
                v = 0x7F0A0751;  // id:layout_trend_info
                View view3 = I.C(view0, 0x7F0A0751);  // id:layout_trend_info
                if(view3 != null) {
                    r1 r10 = r1.a(view3);
                    v = 0x7F0A0926;  // id:player_container
                    View view4 = I.C(view0, 0x7F0A0926);  // id:player_container
                    if(view4 != null) {
                        this._binding = new X2(((ConstraintLayout)view0), ((ImageView)view1), ((ImageView)view2), r10, u.b(view4));
                        X2 x20 = this.getViewBinding();
                        q.f(x20.a, "getRoot(...)");
                        return x20.a;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendVideoPlayerBaseFragment
    public void onRenderPlayer() {
        if(!this.isVideoRendered()) {
            X2 x20 = this.getViewBinding();
            q.f(((ImageView)x20.e.b), "imgDefault");
            ((ImageView)x20.e.b).setVisibility(8);
            X2 x21 = this.getViewBinding();
            q.f(((ImageView)x21.e.e), "imgStill");
            ((ImageView)x21.e.e).setVisibility(8);
            X2 x22 = this.getViewBinding();
            q.f(((PlayerView)x22.e.d), "exoPlayerView");
            ((PlayerView)x22.e.d).setVisibility(0);
            this.setFirstFrameToBackground();
        }
    }

    @Override  // androidx.fragment.app.I
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argPosition", this.getTabPosition());
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendVideoPlayerBaseFragment
    public void onVideoSize(int v, int v1) {
        int v2 = v1 < v ? 1 : 4;
        if(v2 != ((PlayerView)this.getViewBinding().e.d).getResizeMode()) {
            ((PlayerView)this.getViewBinding().e.d).setResizeMode(v2);
            ImageView imageView0 = this.getViewBinding().c;
            q.f(imageView0, "dimFullScreen");
            imageView0.setVisibility((v2 == 4 ? 0 : 8));
        }
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendVideoPlayerBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        List list0 = (List)this.getViewModel().getList().getValue();
        if(list0 != null) {
            SLOTLIST trendShortFormRes$Response$SLOTLIST0 = (SLOTLIST)p.n0(this.getTabPosition(), list0);
            if(trendShortFormRes$Response$SLOTLIST0 != null) {
                this.updateUI(trendShortFormRes$Response$SLOTLIST0);
                LogU.debug$default(this.log, "onViewCreated: " + this.getTabPosition(), null, false, 6, null);
            }
        }
    }

    private final void setFirstFrameToBackground() {
        X2 x20 = this.getViewBinding();
        o o0 = new o(this);
        ((PlayerView)x20.e.d).postDelayed(o0, 100L);
    }

    private static final void setFirstFrameToBackground$lambda$4(TrendShortVideoEmphasisFragment trendShortVideoEmphasisFragment0) {
        View view0 = ((PlayerView)trendShortVideoEmphasisFragment0.getViewBinding().e.d).getVideoSurfaceView();
        TextureView textureView0 = view0 instanceof TextureView ? ((TextureView)view0) : null;
        if(textureView0 != null) {
            Bitmap bitmap0 = textureView0.getBitmap(0x90, 0x90);
            if(bitmap0 != null) {
                e e0 = new e(bitmap0);
                e0.a = 24;
                new d(e0, new j(trendShortVideoEmphasisFragment0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[]{((Bitmap)e0.d)});
            }
        }
    }

    private static final void setFirstFrameToBackground$lambda$4$lambda$3$lambda$2(TrendShortVideoEmphasisFragment trendShortVideoEmphasisFragment0, h h0) {
        Integer integer0;
        if(h0 == null) {
            integer0 = null;
        }
        else {
            g g0 = h0.e;
            integer0 = g0 == null ? null : F.C(g0);
        }
        trendShortVideoEmphasisFragment0.updateBannerBackground(integer0);
        if(h0 != null) {
            GradientDrawable.Orientation gradientDrawable$Orientation0 = GradientDrawable.Orientation.TOP_BOTTOM;
            int v = ColorUtils.getColor(trendShortVideoEmphasisFragment0.getContext(), 0x7F06016A);  // color:gray900e
            g g1 = h0.a(i.f);
            if(g1 != null) {
                v = g1.d;
            }
            GradientDrawable gradientDrawable0 = new GradientDrawable(gradientDrawable$Orientation0, new int[]{v, (integer0 == null ? ColorUtils.getColor(trendShortVideoEmphasisFragment0.getContext(), 0x7F06016A) : ((int)integer0))});  // color:gray900e
            trendShortVideoEmphasisFragment0.getViewBinding().b.setBackground(gradientDrawable0);
        }
    }

    private final void updateBannerBackground(Integer integer0) {
        if(integer0 != null) {
            this.getViewBinding().d.h.setBackgroundColor(integer0.intValue());
        }
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendShortBaseFragment
    public void updateCommentCountView(int v) {
        X2 x20 = this.getViewBinding();
        String s = StringUtils.INSTANCE.getFormattedStringNumberWithoutPlus(String.valueOf(v), 0xF423F);
        x20.d.e.setText(s);
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendShortBaseFragment
    public void updateLikeView(int v, boolean z) {
        this.getViewBinding().d.d.setChecked(z);
        X2 x20 = this.getViewBinding();
        String s = StringUtils.INSTANCE.getFormattedStringNumberWithoutPlus(String.valueOf(v), 0xF423F);
        x20.d.l.setText(s);
    }

    private final void updateUI(SLOTLIST trendShortFormRes$Response$SLOTLIST0) {
        this.getViewBinding().d.p.setText(trendShortFormRes$Response$SLOTLIST0.subTitle);
        X2 x20 = this.getViewBinding();
        String s = StringUtils.INSTANCE.getFormattedStringNumberWithoutPlus(trendShortFormRes$Response$SLOTLIST0.likeCnt, 0xF423F);
        x20.d.l.setText(s);
        boolean z = ProtocolUtils.parseBoolean(trendShortFormRes$Response$SLOTLIST0.likeYn);
        this.getViewBinding().d.d.setChecked(z);
        this.getViewBinding().d.d.setContentDescription((z ? this.getString(0x7F130B5C) : this.getString(0x7F130B5F)));  // string:talkback_like_off "좋아요 취소"
        X2 x21 = this.getViewBinding();
        com.iloen.melon.fragments.shortform.p p0 = new com.iloen.melon.fragments.shortform.p(this, trendShortFormRes$Response$SLOTLIST0, 0);
        x21.d.d.setOnClickListener(p0);
        X2 x22 = this.getViewBinding();
        String s1 = StringUtils.INSTANCE.getFormattedStringNumberWithoutPlus(trendShortFormRes$Response$SLOTLIST0.cmtCnt, 0xF423F);
        x22.d.e.setText(s1);
        BANNER trendShortFormRes$Response$SLOTLIST$BANNER0 = trendShortFormRes$Response$SLOTLIST0.banner;
        if(trendShortFormRes$Response$SLOTLIST$BANNER0 != null) {
            this.getViewBinding().d.i.setVisibility((trendShortFormRes$Response$SLOTLIST$BANNER0.useImgUrl ? 0 : 8));
            this.getViewBinding().d.n.setText(trendShortFormRes$Response$SLOTLIST$BANNER0.text);
            this.getViewBinding().d.n.setHorizontallyScrolling(true);
            this.getViewBinding().d.n.setSelected(true);
            X2 x23 = this.getViewBinding();
            s s2 = new s(trendShortFormRes$Response$SLOTLIST$BANNER0, this, trendShortFormRes$Response$SLOTLIST0, 4);
            x23.d.h.setOnClickListener(s2);
        }
        X2 x24 = this.getViewBinding();
        com.iloen.melon.fragments.shortform.p p1 = new com.iloen.melon.fragments.shortform.p(this, trendShortFormRes$Response$SLOTLIST0, 1);
        a.N(x24.d.c, p1);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(trendShortFormRes$Response$SLOTLIST0, null) {
            final SLOTLIST $slotItem;
            int label;

            {
                TrendShortVideoEmphasisFragment.this = trendShortVideoEmphasisFragment0;
                this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.shortform.TrendShortVideoEmphasisFragment.updateUI.4(TrendShortVideoEmphasisFragment.this, this.$slotItem, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.shortform.TrendShortVideoEmphasisFragment.updateUI.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = TrendShortVideoEmphasisFragment.this.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.fragments.shortform.TrendShortVideoEmphasisFragment.updateUI.4.1 trendShortVideoEmphasisFragment$updateUI$4$10 = new n(this.$slotItem, null) {
                            final SLOTLIST $slotItem;
                            int label;

                            {
                                TrendShortVideoEmphasisFragment.this = trendShortVideoEmphasisFragment0;
                                this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.shortform.TrendShortVideoEmphasisFragment.updateUI.4.1(TrendShortVideoEmphasisFragment.this, this.$slotItem, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.shortform.TrendShortVideoEmphasisFragment.updateUI.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        SharedFlow sharedFlow0 = TrendShortVideoEmphasisFragment.this.getViewModel().getEtcEventFlow();
                                        com.iloen.melon.fragments.shortform.TrendShortVideoEmphasisFragment.updateUI.4.1.1 trendShortVideoEmphasisFragment$updateUI$4$1$10 = new n(this.$slotItem, null) {
                                            final SLOTLIST $slotItem;
                                            Object L$0;
                                            int label;

                                            {
                                                TrendShortVideoEmphasisFragment.this = trendShortVideoEmphasisFragment0;
                                                this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.fragments.shortform.TrendShortVideoEmphasisFragment.updateUI.4.1.1(TrendShortVideoEmphasisFragment.this, this.$slotItem, continuation0);
                                                continuation1.L$0 = object0;
                                                return continuation1;
                                            }

                                            public final Object invoke(EtcEvent trendShortFormViewModel$EtcEvent0, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.shortform.TrendShortVideoEmphasisFragment.updateUI.4.1.1)this.create(trendShortFormViewModel$EtcEvent0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((EtcEvent)object0), ((Continuation)object1));
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                EtcEvent trendShortFormViewModel$EtcEvent0 = (EtcEvent)this.L$0;
                                                if(this.label != 0) {
                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                }
                                                d5.n.D(object0);
                                                if(!q.b(trendShortFormViewModel$EtcEvent0, ClickSoundButton.INSTANCE)) {
                                                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                                }
                                                p8.g g0 = TrendShortVideoEmphasisFragment.this.getTiaraDefaultBuilder();
                                                H h0 = H.a;
                                                if(g0 == null) {
                                                    return h0;
                                                }
                                                g0.a = TrendShortVideoEmphasisFragment.this.getString(0x7F130DCA);  // string:tiara_common_action_name_mute "음소거"
                                                g0.F = TrendShortVideoEmphasisFragment.this.getString(0x7F130D5C);  // string:tiara_click_copy_mute "음소거"
                                                g0.J = this.$slotItem.statsElements.rangeCode;
                                                Builder meta$Builder0 = new Builder();
                                                meta$Builder0.id(this.$slotItem.contsId);
                                                meta$Builder0.type(this.$slotItem.contsTypeCode);
                                                meta$Builder0.name(this.$slotItem.contsTitle);
                                                meta$Builder0.category(this.$slotItem.slotTypeDesc);
                                                meta$Builder0.categoryId(this.$slotItem.slotType);
                                                g0.b0 = meta$Builder0.build();
                                                g0.a().track();
                                                return h0;
                                            }
                                        };
                                        this.label = 1;
                                        return FlowKt.collectLatest(sharedFlow0, trendShortVideoEmphasisFragment$updateUI$4$1$10, this) == a0 ? a0 : H.a;
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
                        };
                        this.label = 1;
                        return f0.j(d0, androidx.lifecycle.s.e, trendShortVideoEmphasisFragment$updateUI$4$10, this) == a0 ? a0 : H.a;
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
        ((PlayerView)this.getViewBinding().e.d).setUseController(false);
        X2 x25 = this.getViewBinding();
        SimpleExoPlayer simpleExoPlayer0 = this.getTrendPlayer().getPlayer();
        ((PlayerView)x25.e.d).setPlayer(simpleExoPlayer0);
    }

    private static final void updateUI$lambda$11(TrendShortVideoEmphasisFragment trendShortVideoEmphasisFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, View view0) {
        TrendShortFormViewModel trendShortFormViewModel0 = trendShortVideoEmphasisFragment0.getViewModel();
        int v = ProtocolUtils.parseInt(trendShortFormRes$Response$SLOTLIST0.CmtChnlSeq, 0);
        String s = trendShortFormRes$Response$SLOTLIST0.contsId;
        q.f(s, "contsId");
        trendShortFormViewModel0.showCommentPopup(new BbsParam(null, v, s, 1, null));
        p8.g g0 = trendShortVideoEmphasisFragment0.getTiaraDefaultBuilder();
        if(g0 == null) {
            return;
        }
        g0.a = trendShortVideoEmphasisFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        g0.F = trendShortVideoEmphasisFragment0.getString(0x7F130D16);  // string:tiara_click_copy_comment_move "댓글보기"
        Builder meta$Builder0 = new Builder();
        meta$Builder0.id(trendShortFormRes$Response$SLOTLIST0.contsId);
        meta$Builder0.type(trendShortFormRes$Response$SLOTLIST0.contsTypeCode);
        meta$Builder0.name(trendShortFormRes$Response$SLOTLIST0.contsTitle);
        meta$Builder0.category(trendShortFormRes$Response$SLOTLIST0.slotTypeDesc);
        meta$Builder0.categoryId(trendShortFormRes$Response$SLOTLIST0.slotType);
        g0.b0 = meta$Builder0.build();
        g0.J = trendShortFormRes$Response$SLOTLIST0.statsElements.rangeCode;
        g0.a().track();
    }

    private static final void updateUI$lambda$6(TrendShortVideoEmphasisFragment trendShortVideoEmphasisFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, View view0) {
        q.d(view0);
        trendShortVideoEmphasisFragment0.updateLike(view0, trendShortFormRes$Response$SLOTLIST0);
        int v = trendShortVideoEmphasisFragment0.getViewBinding().d.d.a ? 0x7F130FCC : 0x7F130FCD;  // string:tiara_props_dislike "dislike"
        String s = trendShortVideoEmphasisFragment0.getViewBinding().d.d.a ? trendShortVideoEmphasisFragment0.getString(0x7F130D22) : trendShortVideoEmphasisFragment0.getString(0x7F130D41);  // string:tiara_click_copy_dislike "좋아요 취소"
        q.d(s);
        p8.g g0 = trendShortVideoEmphasisFragment0.getTiaraDefaultBuilder();
        if(g0 == null) {
            return;
        }
        g0.a = trendShortVideoEmphasisFragment0.getString(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
        g0.d = ActionKind.Like;
        g0.F = s;
        Builder meta$Builder0 = new Builder();
        meta$Builder0.id(trendShortFormRes$Response$SLOTLIST0.contsId);
        meta$Builder0.type(trendShortFormRes$Response$SLOTLIST0.contsTypeCode);
        meta$Builder0.name(trendShortFormRes$Response$SLOTLIST0.contsTitle);
        meta$Builder0.category(trendShortFormRes$Response$SLOTLIST0.slotTypeDesc);
        meta$Builder0.categoryId(trendShortFormRes$Response$SLOTLIST0.slotType);
        g0.b0 = meta$Builder0.build();
        g0.J = trendShortFormRes$Response$SLOTLIST0.statsElements.rangeCode;
        g0.U = trendShortVideoEmphasisFragment0.getString(v);
        g0.a().track();
    }

    private static final void updateUI$lambda$9$lambda$8(BANNER trendShortFormRes$Response$SLOTLIST$BANNER0, TrendShortVideoEmphasisFragment trendShortVideoEmphasisFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, View view0) {
        MelonLinkExecutor.open(MelonLinkInfo.b(trendShortFormRes$Response$SLOTLIST$BANNER0));
        p8.g g0 = trendShortVideoEmphasisFragment0.getTiaraDefaultBuilder();
        if(g0 == null) {
            return;
        }
        g0.a = trendShortVideoEmphasisFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        g0.d = ActionKind.ClickContent;
        g0.B = trendShortFormRes$Response$SLOTLIST0.banner.scheme;
        g0.F = trendShortVideoEmphasisFragment0.getString(0x7F130D07);  // string:tiara_click_copy_banner_move "배너이동"
        Builder meta$Builder0 = new Builder();
        meta$Builder0.id(trendShortFormRes$Response$SLOTLIST0.contsId);
        meta$Builder0.type(trendShortFormRes$Response$SLOTLIST0.contsTypeCode);
        meta$Builder0.name(trendShortFormRes$Response$SLOTLIST0.contsTitle);
        meta$Builder0.category(trendShortFormRes$Response$SLOTLIST0.slotTypeDesc);
        meta$Builder0.categoryId(trendShortFormRes$Response$SLOTLIST0.slotType);
        g0.b0 = meta$Builder0.build();
        g0.J = trendShortFormRes$Response$SLOTLIST0.statsElements.rangeCode;
        g0.a().track();
    }
}

