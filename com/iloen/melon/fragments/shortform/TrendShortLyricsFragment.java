package com.iloen.melon.fragments.shortform;

import De.I;
import J8.W2;
import J8.r1;
import J8.x;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import com.bumptech.glide.Glide;
import com.iloen.melon.custom.TypeAnimationText;
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
import java.util.ArrayList;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import x1.a;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001A\u00020\u00042\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001A\u00020\u00042\b\u0010\u0012\u001A\u0004\u0018\u00010\u000EH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J+\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0015\u001A\u00020\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0012\u001A\u0004\u0018\u00010\u000EH\u0016¢\u0006\u0004\b\u0019\u0010\u001AJ!\u0010\u001C\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u00182\b\u0010\u0012\u001A\u0004\u0018\u00010\u000EH\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001E\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u001E\u0010\u0003J\u000F\u0010\u001F\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u001F\u0010\u0003J\u001F\u0010#\u001A\u00020\u00042\u0006\u0010 \u001A\u00020\n2\u0006\u0010\"\u001A\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001A\u00020\u00042\u0006\u0010 \u001A\u00020\nH\u0016¢\u0006\u0004\b%\u0010&R\u0014\u0010(\u001A\u00020\'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010+\u001A\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010/\u001A\u00020*8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendShortLyricsFragment;", "Lcom/iloen/melon/fragments/shortform/TrendMusicPlayerBaseFragment;", "<init>", "()V", "Lie/H;", "init", "Lcom/iloen/melon/net/v6x/response/TrendShortFormRes$Response$SLOTLIST;", "slotItem", "updateUI", "(Lcom/iloen/melon/net/v6x/response/TrendShortFormRes$Response$SLOTLIST;)V", "", "color", "updateBannerBackground", "(Ljava/lang/Integer;)V", "Landroid/os/Bundle;", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "savedInstanceState", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onPause", "onResume", "sumCount", "", "isLike", "updateLikeView", "(IZ)V", "updateCommentCountView", "(I)V", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "LJ8/W2;", "_binding", "LJ8/W2;", "getViewBinding", "()LJ8/W2;", "viewBinding", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TrendShortLyricsFragment extends TrendMusicPlayerBaseFragment {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendShortLyricsFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/shortform/TrendShortLyricsFragment;", "position", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TrendShortLyricsFragment newInstance(int v) {
            TrendShortLyricsFragment trendShortLyricsFragment0 = new TrendShortLyricsFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putInt("argPosition", v);
            trendShortLyricsFragment0.setArguments(bundle0);
            return trendShortLyricsFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "TrendShortLyricsFragment";
    @Nullable
    private W2 _binding;
    @NotNull
    private final LogU log;

    static {
        TrendShortLyricsFragment.Companion = new Companion(null);
        TrendShortLyricsFragment.$stable = 8;
    }

    public TrendShortLyricsFragment() {
        LogU logU0 = new LogU("TrendShortLyricsFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.log = logU0;
    }

    private final W2 getViewBinding() {
        W2 w20 = this._binding;
        q.d(w20);
        return w20;
    }

    private final void init() {
        Bundle bundle0 = this.getArguments();
        this.setTabPosition((bundle0 == null ? -1 : bundle0.getInt("argPosition")));
    }

    public static void o(BANNER trendShortFormRes$Response$SLOTLIST$BANNER0, TrendShortLyricsFragment trendShortLyricsFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, View view0) {
        TrendShortLyricsFragment.updateUI$lambda$5$lambda$4(trendShortFormRes$Response$SLOTLIST$BANNER0, trendShortLyricsFragment0, trendShortFormRes$Response$SLOTLIST0, view0);
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendMusicPlayerBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.init();
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = this.getLayoutInflater().inflate(0x7F0D0841, viewGroup0, false);  // layout:short_form_lyrics_layout
        int v = 0x7F0A00FC;  // id:bg
        ImageView imageView0 = (ImageView)I.C(view0, 0x7F0A00FC);  // id:bg
        if(imageView0 != null) {
            v = 0x7F0A0751;  // id:layout_trend_info
            View view1 = I.C(view0, 0x7F0A0751);  // id:layout_trend_info
            if(view1 != null) {
                r1 r10 = r1.a(view1);
                View view2 = I.C(view0, 0x7F0A0752);  // id:layout_trend_lyrics
                if(view2 != null) {
                    int v1 = 0x7F0A07C0;  // id:lyric_text
                    TypeAnimationText typeAnimationText0 = (TypeAnimationText)I.C(view2, 0x7F0A07C0);  // id:lyric_text
                    if(typeAnimationText0 != null && ((ImageView)I.C(view2, 0x7F0A0991)) != null && ((ImageView)I.C(view2, 0x7F0A0992)) != null) {  // id:quote_left
                        v1 = 0x7F0A0BD0;  // id:top_line
                        View view3 = I.C(view2, 0x7F0A0BD0);  // id:top_line
                        if(view3 != null) {
                            this._binding = new W2(((ConstraintLayout)view0), imageView0, r10, new x(((LinearLayoutCompat)view2), typeAnimationText0, view3, 2));
                            W2 w20 = this.getViewBinding();
                            q.f(w20.a, "getRoot(...)");
                            return w20.a;
                        }
                    }
                    throw new NullPointerException("Missing required view with ID: " + view2.getResources().getResourceName(v1));
                }
                v = 0x7F0A0752;  // id:layout_trend_lyrics
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendMusicPlayerBaseFragment
    public void onPause() {
        super.onPause();
        ((TypeAnimationText)this.getViewBinding().d.c).e();
    }

    @Override  // androidx.fragment.app.I
    public void onResume() {
        super.onResume();
        ((TypeAnimationText)this.getViewBinding().d.c).f();
    }

    @Override  // androidx.fragment.app.I
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argPosition", this.getTabPosition());
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendMusicPlayerBaseFragment
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

    private final void updateBannerBackground(Integer integer0) {
        if(integer0 != null) {
            this.getViewBinding().c.h.setBackgroundColor(integer0.intValue());
        }
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendShortBaseFragment
    public void updateCommentCountView(int v) {
        W2 w20 = this.getViewBinding();
        String s = StringUtils.INSTANCE.getFormattedStringNumberWithoutPlus(String.valueOf(v), 0xF423F);
        w20.c.e.setText(s);
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendShortBaseFragment
    public void updateLikeView(int v, boolean z) {
        this.getViewBinding().c.d.setChecked(z);
        W2 w20 = this.getViewBinding();
        String s = StringUtils.INSTANCE.getFormattedStringNumberWithoutPlus(String.valueOf(v), 0xF423F);
        w20.c.l.setText(s);
    }

    private final void updateUI(SLOTLIST trendShortFormRes$Response$SLOTLIST0) {
        this.getViewBinding().c.p.setText(trendShortFormRes$Response$SLOTLIST0.subTitle);
        W2 w20 = this.getViewBinding();
        String s = StringUtils.INSTANCE.getFormattedStringNumberWithoutPlus(trendShortFormRes$Response$SLOTLIST0.likeCnt, 0xF423F);
        w20.c.l.setText(s);
        boolean z = ProtocolUtils.parseBoolean(trendShortFormRes$Response$SLOTLIST0.likeYn);
        this.getViewBinding().c.d.setChecked(z);
        this.getViewBinding().c.d.setContentDescription((z ? this.getString(0x7F130B5C) : this.getString(0x7F130B5F)));  // string:talkback_like_off "좋아요 취소"
        W2 w21 = this.getViewBinding();
        n n0 = new n(this, trendShortFormRes$Response$SLOTLIST0, 0);
        w21.c.d.setOnClickListener(n0);
        W2 w22 = this.getViewBinding();
        String s1 = StringUtils.INSTANCE.getFormattedStringNumberWithoutPlus(trendShortFormRes$Response$SLOTLIST0.cmtCnt, 0xF423F);
        w22.c.e.setText(s1);
        Glide.with(this).load(trendShortFormRes$Response$SLOTLIST0.bgmImgUrl).into(this.getViewBinding().b);
        BANNER trendShortFormRes$Response$SLOTLIST$BANNER0 = trendShortFormRes$Response$SLOTLIST0.banner;
        if(trendShortFormRes$Response$SLOTLIST$BANNER0 != null) {
            this.getViewBinding().c.i.setVisibility((trendShortFormRes$Response$SLOTLIST$BANNER0.useImgUrl ? 0 : 8));
            if(trendShortFormRes$Response$SLOTLIST$BANNER0.useImgUrl) {
                this.updateBannerBackground(ColorUtils.getColorFromHexStr(this.getContext(), trendShortFormRes$Response$SLOTLIST$BANNER0.bgColor, 0x7F06016A));  // color:gray900e
                Glide.with(this.requireContext()).load(trendShortFormRes$Response$SLOTLIST0.banner.imgUrl).into(this.getViewBinding().c.g);
            }
            this.getViewBinding().c.n.setText(trendShortFormRes$Response$SLOTLIST$BANNER0.text);
            this.getViewBinding().c.n.setFocusable(false);
            this.getViewBinding().c.n.setHorizontallyScrolling(true);
            this.getViewBinding().c.n.setSelected(true);
            W2 w23 = this.getViewBinding();
            s s2 = new s(trendShortFormRes$Response$SLOTLIST$BANNER0, this, trendShortFormRes$Response$SLOTLIST0, 3);
            w23.c.h.setOnClickListener(s2);
        }
        W2 w24 = this.getViewBinding();
        n n1 = new n(this, trendShortFormRes$Response$SLOTLIST0, 1);
        a.N(w24.c.c, n1);
        if(trendShortFormRes$Response$SLOTLIST0.lyricList != null && !trendShortFormRes$Response$SLOTLIST0.lyricList.isEmpty()) {
            W2 w25 = this.getViewBinding();
            ArrayList arrayList0 = trendShortFormRes$Response$SLOTLIST0.lyricList;
            q.f(arrayList0, "lyricList");
            ((TypeAnimationText)w25.d.c).setAnimationText(arrayList0);
        }
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new we.n(trendShortFormRes$Response$SLOTLIST0, null) {
            final SLOTLIST $slotItem;
            int label;

            {
                TrendShortLyricsFragment.this = trendShortLyricsFragment0;
                this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.shortform.TrendShortLyricsFragment.updateUI.4(TrendShortLyricsFragment.this, this.$slotItem, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.shortform.TrendShortLyricsFragment.updateUI.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = TrendShortLyricsFragment.this.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.fragments.shortform.TrendShortLyricsFragment.updateUI.4.1 trendShortLyricsFragment$updateUI$4$10 = new we.n(this.$slotItem, null) {
                            final SLOTLIST $slotItem;
                            int label;

                            {
                                TrendShortLyricsFragment.this = trendShortLyricsFragment0;
                                this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.shortform.TrendShortLyricsFragment.updateUI.4.1(TrendShortLyricsFragment.this, this.$slotItem, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.shortform.TrendShortLyricsFragment.updateUI.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        SharedFlow sharedFlow0 = TrendShortLyricsFragment.this.getViewModel().getEtcEventFlow();
                                        com.iloen.melon.fragments.shortform.TrendShortLyricsFragment.updateUI.4.1.1 trendShortLyricsFragment$updateUI$4$1$10 = new we.n(this.$slotItem, null) {
                                            final SLOTLIST $slotItem;
                                            Object L$0;
                                            int label;

                                            {
                                                TrendShortLyricsFragment.this = trendShortLyricsFragment0;
                                                this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.fragments.shortform.TrendShortLyricsFragment.updateUI.4.1.1(TrendShortLyricsFragment.this, this.$slotItem, continuation0);
                                                continuation1.L$0 = object0;
                                                return continuation1;
                                            }

                                            public final Object invoke(EtcEvent trendShortFormViewModel$EtcEvent0, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.shortform.TrendShortLyricsFragment.updateUI.4.1.1)this.create(trendShortFormViewModel$EtcEvent0, continuation0)).invokeSuspend(H.a);
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
                                                g g0 = TrendShortLyricsFragment.this.getTiaraDefaultBuilder();
                                                H h0 = H.a;
                                                if(g0 == null) {
                                                    return h0;
                                                }
                                                g0.a = TrendShortLyricsFragment.this.getString(0x7F130DCA);  // string:tiara_common_action_name_mute "음소거"
                                                g0.F = TrendShortLyricsFragment.this.getString(0x7F130D5C);  // string:tiara_click_copy_mute "음소거"
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
                                        return FlowKt.collectLatest(sharedFlow0, trendShortLyricsFragment$updateUI$4$1$10, this) == a0 ? a0 : H.a;
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
                        return f0.j(d0, androidx.lifecycle.s.e, trendShortLyricsFragment$updateUI$4$10, this) == a0 ? a0 : H.a;
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

    private static final void updateUI$lambda$2(TrendShortLyricsFragment trendShortLyricsFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, View view0) {
        q.d(view0);
        trendShortLyricsFragment0.updateLike(view0, trendShortFormRes$Response$SLOTLIST0);
        int v = trendShortLyricsFragment0.getViewBinding().c.d.a ? 0x7F130FCC : 0x7F130FCD;  // string:tiara_props_dislike "dislike"
        String s = trendShortLyricsFragment0.getViewBinding().c.d.a ? trendShortLyricsFragment0.getString(0x7F130D22) : trendShortLyricsFragment0.getString(0x7F130D41);  // string:tiara_click_copy_dislike "좋아요 취소"
        q.d(s);
        g g0 = trendShortLyricsFragment0.getTiaraDefaultBuilder();
        if(g0 == null) {
            return;
        }
        g0.a = trendShortLyricsFragment0.getString(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
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
        g0.U = trendShortLyricsFragment0.getString(v);
        g0.a().track();
    }

    private static final void updateUI$lambda$5$lambda$4(BANNER trendShortFormRes$Response$SLOTLIST$BANNER0, TrendShortLyricsFragment trendShortLyricsFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, View view0) {
        MelonLinkExecutor.open(MelonLinkInfo.b(trendShortFormRes$Response$SLOTLIST$BANNER0));
        g g0 = trendShortLyricsFragment0.getTiaraDefaultBuilder();
        if(g0 == null) {
            return;
        }
        g0.a = trendShortLyricsFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        g0.d = ActionKind.ClickContent;
        g0.B = trendShortFormRes$Response$SLOTLIST0.banner.scheme;
        g0.F = trendShortLyricsFragment0.getString(0x7F130D07);  // string:tiara_click_copy_banner_move "배너이동"
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

    private static final void updateUI$lambda$7(TrendShortLyricsFragment trendShortLyricsFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, View view0) {
        TrendShortFormViewModel trendShortFormViewModel0 = trendShortLyricsFragment0.getViewModel();
        int v = ProtocolUtils.parseInt(trendShortFormRes$Response$SLOTLIST0.CmtChnlSeq, 0);
        String s = trendShortFormRes$Response$SLOTLIST0.contsId;
        q.f(s, "contsId");
        trendShortFormViewModel0.showCommentPopup(new BbsParam(null, v, s, 1, null));
        g g0 = trendShortLyricsFragment0.getTiaraDefaultBuilder();
        if(g0 == null) {
            return;
        }
        g0.a = trendShortLyricsFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        g0.F = trendShortLyricsFragment0.getString(0x7F130D16);  // string:tiara_click_copy_comment_move "댓글보기"
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

