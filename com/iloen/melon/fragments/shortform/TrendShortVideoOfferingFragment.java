package com.iloen.melon.fragments.shortform;

import De.I;
import J8.Y2;
import J8.r1;
import J8.u;
import Tf.o;
import U4.F;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.iloen.melon.fragments.detail.viewholder.s;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST.BANNER;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST.MEDIAINFO;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
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
import m4.e;
import m4.g;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\tH\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u0019\u0010\u0012\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J+\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0014\u001A\u00020\u00132\b\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\u0011\u001A\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001B\u001A\u00020\u00062\u0006\u0010\u001A\u001A\u00020\u00172\b\u0010\u0011\u001A\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\u001D\u0010\u0003J\u000F\u0010\u001E\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u001E\u0010\u0003J\u001F\u0010\"\u001A\u00020\u00062\u0006\u0010\u001F\u001A\u00020\t2\u0006\u0010!\u001A\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001A\u00020\u00062\u0006\u0010\u001F\u001A\u00020\tH\u0016¢\u0006\u0004\b$\u0010\fR\u0014\u0010&\u001A\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\'R\u0018\u0010)\u001A\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001A\u00020(8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendShortVideoOfferingFragment;", "Lcom/iloen/melon/fragments/shortform/TrendVideoPlayerBaseFragment;", "<init>", "()V", "Lcom/iloen/melon/net/v6x/response/TrendShortFormRes$Response$SLOTLIST;", "slotItem", "Lie/H;", "updateUI", "(Lcom/iloen/melon/net/v6x/response/TrendShortFormRes$Response$SLOTLIST;)V", "", "color", "updateBannerBackground", "(I)V", "Landroid/os/Bundle;", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "savedInstanceState", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "failToPlayMedia", "onRenderPlayer", "sumCount", "", "isLike", "updateLikeView", "(IZ)V", "updateCommentCountView", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "LJ8/Y2;", "_binding", "LJ8/Y2;", "getViewBinding", "()LJ8/Y2;", "viewBinding", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TrendShortVideoOfferingFragment extends TrendVideoPlayerBaseFragment {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendShortVideoOfferingFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/shortform/TrendShortVideoOfferingFragment;", "position", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TrendShortVideoOfferingFragment newInstance(int v) {
            TrendShortVideoOfferingFragment trendShortVideoOfferingFragment0 = new TrendShortVideoOfferingFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putInt("argPosition", v);
            trendShortVideoOfferingFragment0.setArguments(bundle0);
            return trendShortVideoOfferingFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "TrendShortVideoOfferingFragment";
    @Nullable
    private Y2 _binding;
    @NotNull
    private final LogU log;

    static {
        TrendShortVideoOfferingFragment.Companion = new Companion(null);
        TrendShortVideoOfferingFragment.$stable = 8;
    }

    public TrendShortVideoOfferingFragment() {
        LogU logU0 = new LogU("TrendShortVideoOfferingFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.log = logU0;
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendShortBaseFragment
    public void failToPlayMedia() {
        super.failToPlayMedia();
        Y2 y20 = this.getViewBinding();
        q.f(((PlayerView)y20.c.d), "exoPlayerView");
        ((PlayerView)y20.c.d).setVisibility(8);
        Y2 y21 = this.getViewBinding();
        q.f(((ImageView)y21.c.b), "imgDefault");
        ((ImageView)y21.c.b).setVisibility(0);
        Y2 y22 = this.getViewBinding();
        q.f(((ImageView)y22.c.e), "imgStill");
        ((ImageView)y22.c.e).setVisibility(8);
    }

    private final Y2 getViewBinding() {
        Y2 y20 = this._binding;
        q.d(y20);
        return y20;
    }

    public static void m(BANNER trendShortFormRes$Response$SLOTLIST$BANNER0, TrendShortVideoOfferingFragment trendShortVideoOfferingFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, View view0) {
        TrendShortVideoOfferingFragment.updateUI$lambda$4$lambda$3(trendShortFormRes$Response$SLOTLIST$BANNER0, trendShortVideoOfferingFragment0, trendShortFormRes$Response$SLOTLIST0, view0);
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
        View view0 = this.getLayoutInflater().inflate(0x7F0D0843, viewGroup0, false);  // layout:short_form_video_layout
        int v = 0x7F0A0751;  // id:layout_trend_info
        View view1 = I.C(view0, 0x7F0A0751);  // id:layout_trend_info
        if(view1 != null) {
            r1 r10 = r1.a(view1);
            View view2 = I.C(view0, 0x7F0A0926);  // id:player_container
            if(view2 != null) {
                this._binding = new Y2(((ConstraintLayout)view0), r10, u.b(view2));
                Y2 y20 = this.getViewBinding();
                q.f(y20.a, "getRoot(...)");
                return y20.a;
            }
            v = 0x7F0A0926;  // id:player_container
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendVideoPlayerBaseFragment
    public void onRenderPlayer() {
        Y2 y20 = this.getViewBinding();
        q.f(((ImageView)y20.c.b), "imgDefault");
        ((ImageView)y20.c.b).setVisibility(8);
        Y2 y21 = this.getViewBinding();
        q.f(((ImageView)y21.c.e), "imgStill");
        ((ImageView)y21.c.e).setVisibility(8);
        Y2 y22 = this.getViewBinding();
        q.f(((PlayerView)y22.c.d), "exoPlayerView");
        ((PlayerView)y22.c.d).setVisibility(0);
    }

    @Override  // androidx.fragment.app.I
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argPosition", this.getTabPosition());
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

    private final void updateBannerBackground(int v) {
        this.getViewBinding().b.h.setBackgroundColor(v);
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendShortBaseFragment
    public void updateCommentCountView(int v) {
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendShortBaseFragment
    public void updateLikeView(int v, boolean z) {
    }

    private final void updateUI(SLOTLIST trendShortFormRes$Response$SLOTLIST0) {
        int v = 0;
        ((PlayerView)this.getViewBinding().c.d).setUseController(false);
        ((PlayerView)this.getViewBinding().c.d).setResizeMode(4);
        Y2 y20 = this.getViewBinding();
        SimpleExoPlayer simpleExoPlayer0 = this.getTrendPlayer().getPlayer();
        ((PlayerView)y20.c.d).setPlayer(simpleExoPlayer0);
        this.getViewBinding().b.p.setText(trendShortFormRes$Response$SLOTLIST0.subTitle);
        this.getViewBinding().b.k.setVisibility(8);
        MEDIAINFO trendShortFormRes$Response$SLOTLIST$MEDIAINFO0 = trendShortFormRes$Response$SLOTLIST0.mediaInfo;
        ImageView imageView0 = (ImageView)this.getViewBinding().c.e;
        com.iloen.melon.fragments.shortform.TrendShortVideoOfferingFragment.updateUI.1.1 trendShortVideoOfferingFragment$updateUI$1$10 = (com.iloen.melon.fragments.shortform.TrendShortVideoOfferingFragment.updateUI.1.1)Glide.with(this).asBitmap().load((trendShortFormRes$Response$SLOTLIST$MEDIAINFO0 == null ? null : trendShortFormRes$Response$SLOTLIST$MEDIAINFO0.contentImgPath)).into(new CustomTarget() {
            @Override  // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable drawable0) {
            }

            public void onResourceReady(Bitmap bitmap0, Transition transition0) {
                q.g(bitmap0, "bitmap");
                if(!imageView0.isVideoRendered()) {
                    q.d(this.$stillImage);
                    this.$stillImage.setVisibility(0);
                    this.$stillImage.setImageBitmap(bitmap0);
                }
                e e0 = new e(bitmap0);
                e0.a = 24;
                g g0 = e0.a().e;
                if(g0 == null) {
                    return;
                }
                int v = F.C(g0);
                imageView0.updateBannerBackground(v);
            }

            @Override  // com.bumptech.glide.request.target.Target
            public void onResourceReady(Object object0, Transition transition0) {
                this.onResourceReady(((Bitmap)object0), transition0);
            }
        });
        BANNER trendShortFormRes$Response$SLOTLIST$BANNER0 = trendShortFormRes$Response$SLOTLIST0.banner;
        if(trendShortFormRes$Response$SLOTLIST$BANNER0 != null) {
            FrameLayout frameLayout0 = this.getViewBinding().b.i;
            if(!trendShortFormRes$Response$SLOTLIST$BANNER0.useImgUrl) {
                v = 8;
            }
            frameLayout0.setVisibility(v);
            this.getViewBinding().b.n.setText(trendShortFormRes$Response$SLOTLIST$BANNER0.text);
            this.getViewBinding().b.n.setHorizontallyScrolling(true);
            this.getViewBinding().b.n.setSelected(true);
            Y2 y21 = this.getViewBinding();
            s s0 = new s(trendShortFormRes$Response$SLOTLIST$BANNER0, this, trendShortFormRes$Response$SLOTLIST0, 5);
            y21.b.h.setOnClickListener(s0);
        }
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(trendShortFormRes$Response$SLOTLIST0, null) {
            final SLOTLIST $slotItem;
            int label;

            {
                TrendShortVideoOfferingFragment.this = trendShortVideoOfferingFragment0;
                this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.shortform.TrendShortVideoOfferingFragment.updateUI.3(TrendShortVideoOfferingFragment.this, this.$slotItem, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.shortform.TrendShortVideoOfferingFragment.updateUI.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = TrendShortVideoOfferingFragment.this.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.fragments.shortform.TrendShortVideoOfferingFragment.updateUI.3.1 trendShortVideoOfferingFragment$updateUI$3$10 = new n(this.$slotItem, null) {
                            final SLOTLIST $slotItem;
                            int label;

                            {
                                TrendShortVideoOfferingFragment.this = trendShortVideoOfferingFragment0;
                                this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.shortform.TrendShortVideoOfferingFragment.updateUI.3.1(TrendShortVideoOfferingFragment.this, this.$slotItem, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.shortform.TrendShortVideoOfferingFragment.updateUI.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        SharedFlow sharedFlow0 = TrendShortVideoOfferingFragment.this.getViewModel().getEtcEventFlow();
                                        com.iloen.melon.fragments.shortform.TrendShortVideoOfferingFragment.updateUI.3.1.1 trendShortVideoOfferingFragment$updateUI$3$1$10 = new n(this.$slotItem, null) {
                                            final SLOTLIST $slotItem;
                                            Object L$0;
                                            int label;

                                            {
                                                TrendShortVideoOfferingFragment.this = trendShortVideoOfferingFragment0;
                                                this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.fragments.shortform.TrendShortVideoOfferingFragment.updateUI.3.1.1(TrendShortVideoOfferingFragment.this, this.$slotItem, continuation0);
                                                continuation1.L$0 = object0;
                                                return continuation1;
                                            }

                                            public final Object invoke(EtcEvent trendShortFormViewModel$EtcEvent0, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.shortform.TrendShortVideoOfferingFragment.updateUI.3.1.1)this.create(trendShortFormViewModel$EtcEvent0, continuation0)).invokeSuspend(H.a);
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
                                                p8.g g0 = TrendShortVideoOfferingFragment.this.getTiaraDefaultBuilder();
                                                H h0 = H.a;
                                                if(g0 == null) {
                                                    return h0;
                                                }
                                                g0.a = TrendShortVideoOfferingFragment.this.getString(0x7F130DCA);  // string:tiara_common_action_name_mute "음소거"
                                                g0.F = TrendShortVideoOfferingFragment.this.getString(0x7F130D5C);  // string:tiara_click_copy_mute "음소거"
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
                                        return FlowKt.collectLatest(sharedFlow0, trendShortVideoOfferingFragment$updateUI$3$1$10, this) == a0 ? a0 : H.a;
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
                        return f0.j(d0, androidx.lifecycle.s.e, trendShortVideoOfferingFragment$updateUI$3$10, this) == a0 ? a0 : H.a;
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

    private static final void updateUI$lambda$4$lambda$3(BANNER trendShortFormRes$Response$SLOTLIST$BANNER0, TrendShortVideoOfferingFragment trendShortVideoOfferingFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, View view0) {
        MelonLinkExecutor.open(MelonLinkInfo.b(trendShortFormRes$Response$SLOTLIST$BANNER0));
        String s = trendShortFormRes$Response$SLOTLIST$BANNER0.scheme == null || o.H0(trendShortFormRes$Response$SLOTLIST$BANNER0.scheme) ? trendShortFormRes$Response$SLOTLIST$BANNER0.linkurl : trendShortFormRes$Response$SLOTLIST$BANNER0.scheme;
        p8.g g0 = trendShortVideoOfferingFragment0.getTiaraDefaultBuilder();
        if(g0 == null) {
            return;
        }
        g0.a = trendShortVideoOfferingFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        g0.d = ActionKind.ClickContent;
        g0.B = s;
        g0.F = trendShortVideoOfferingFragment0.getString(0x7F130D07);  // string:tiara_click_copy_banner_move "배너이동"
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

