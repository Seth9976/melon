package com.iloen.melon.fragments.shortform;

import Cc.c1;
import De.I;
import J8.f1;
import J8.r1;
import K.m;
import M.j;
import M.w;
import M.y;
import Q0.k0;
import U4.x;
import X0.i;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.s;
import com.iloen.melon.fragments.present.a;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.Meta.Builder;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import je.p;
import kd.T;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import m0.b;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import w0.h;
import we.n;
import we.o;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000E\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\bJ!\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\r2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0019\u001A\u00020\u00062\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001B\u001A\u00020\u00062\u0006\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u001D\u0010\u0003R\u0014\u0010\u001F\u001A\u00020\u001E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001F\u0010 R\u0016\u0010\"\u001A\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendMusicWaveExclusiveFragment;", "Lcom/iloen/melon/fragments/shortform/TrendMusicPlayerBaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "outState", "onSaveInstanceState", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "sumCount", "", "isLike", "updateLikeView", "(IZ)V", "updateCommentCountView", "(I)V", "onResume", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "LJ8/f1;", "viewBinding", "LJ8/f1;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TrendMusicWaveExclusiveFragment extends TrendMusicPlayerBaseFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendMusicWaveExclusiveFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_POSITION", "newInstance", "Lcom/iloen/melon/fragments/shortform/TrendMusicWaveExclusiveFragment;", "position", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TrendMusicWaveExclusiveFragment newInstance(int v) {
            TrendMusicWaveExclusiveFragment trendMusicWaveExclusiveFragment0 = new TrendMusicWaveExclusiveFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putInt("argPosition", v);
            trendMusicWaveExclusiveFragment0.setArguments(bundle0);
            return trendMusicWaveExclusiveFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_POSITION = "argPosition";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "TrendMusicWaveExclusiveFragment";
    @NotNull
    private final LogU log;
    private f1 viewBinding;

    static {
        TrendMusicWaveExclusiveFragment.Companion = new Companion(null);
        TrendMusicWaveExclusiveFragment.$stable = 8;
    }

    public TrendMusicWaveExclusiveFragment() {
        LogU logU0 = new LogU("TrendMusicWaveExclusiveFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.log = logU0;
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendMusicPlayerBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        Bundle bundle1 = this.getArguments();
        this.setTabPosition((bundle1 == null ? -1 : bundle1.getInt("argPosition")));
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = this.getLayoutInflater().inflate(0x7F0D02B7, viewGroup0, false);  // layout:fragment_music_wave_exclusive
        int v = 0x7F0A0304;  // id:compose_background_view
        View view1 = I.C(view0, 0x7F0A0304);  // id:compose_background_view
        if(((ComposeView)view1) != null) {
            v = 0x7F0A0306;  // id:compose_chat_view
            View view2 = I.C(view0, 0x7F0A0306);  // id:compose_chat_view
            if(((ComposeView)view2) != null) {
                v = 0x7F0A0307;  // id:compose_pattern_view
                View view3 = I.C(view0, 0x7F0A0307);  // id:compose_pattern_view
                if(((ComposeView)view3) != null) {
                    v = 0x7F0A0625;  // id:iv_dim
                    View view4 = I.C(view0, 0x7F0A0625);  // id:iv_dim
                    if(((ImageView)view4) != null) {
                        v = 0x7F0A0751;  // id:layout_trend_info
                        View view5 = I.C(view0, 0x7F0A0751);  // id:layout_trend_info
                        if(view5 != null) {
                            r1 r10 = r1.a(view5);
                            this.viewBinding = new f1(((ConstraintLayout)view0), ((ComposeView)view1), ((ComposeView)view2), ((ComposeView)view3), ((ImageView)view4), r10);
                            r10.k.setVisibility(8);
                            f1 f10 = this.viewBinding;
                            if(f10 != null) {
                                q.f(f10.a, "getRoot(...)");
                                return f10.a;
                            }
                            q.m("viewBinding");
                            throw null;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // androidx.fragment.app.I
    public void onResume() {
        super.onResume();
        LogU.debug$default(this.log, "onResume : " + this.getTabPosition(), null, false, 6, null);
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
            SLOTLIST trendShortFormRes$Response$SLOTLIST0 = (SLOTLIST)list0.get(this.getTabPosition());
            if(trendShortFormRes$Response$SLOTLIST0 != null) {
                f1 f10 = this.viewBinding;
                if(f10 != null) {
                    b b0 = new b(-189217077, new d(trendShortFormRes$Response$SLOTLIST0, this, 0), true);
                    f10.b.setContent(b0);
                    f1 f11 = this.viewBinding;
                    if(f11 != null) {
                        b b1 = new b(-2030906316, new d(trendShortFormRes$Response$SLOTLIST0, this, 1), true);
                        f11.c.setContent(b1);
                        f1 f12 = this.viewBinding;
                        if(f12 != null) {
                            b b2 = new b(0x74BB3753, new e(trendShortFormRes$Response$SLOTLIST0), true);
                            f12.d.setContent(b2);
                            f1 f13 = this.viewBinding;
                            if(f13 != null) {
                                r1 r10 = f13.f;
                                r10.f.setVisibility(8);
                                r10.o.setVisibility(8);
                                r10.p.setVisibility(8);
                                r10.j.setVisibility(0);
                                b b3 = new b(0x4F1160BA, new com.iloen.melon.fragments.artistchannel.viewholder.e(3, view0, trendShortFormRes$Response$SLOTLIST0), true);
                                r10.j.setContent(b3);
                                ConstraintLayout constraintLayout0 = r10.h;
                                String s = trendShortFormRes$Response$SLOTLIST0.patternColorType;
                                q.f(s, "patternColorType");
                                ColorSet colorSet0 = ColorSet.Companion.fromString(s);
                                if(colorSet0 == null) {
                                    colorSet0 = TypeA.INSTANCE;
                                }
                                constraintLayout0.setBackgroundColor(ColorUtils.getColor(constraintLayout0.getContext(), ((Number)p.s0(colorSet0.getColors())).intValue()));
                                r10.n.setText(trendShortFormRes$Response$SLOTLIST0.banner.text);
                                constraintLayout0.setOnClickListener(new a(4, trendShortFormRes$Response$SLOTLIST0, this));
                                D d0 = this.getViewLifecycleOwner();
                                q.f(d0, "getViewLifecycleOwner(...)");
                                BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(trendShortFormRes$Response$SLOTLIST0, null) {
                                    final SLOTLIST $slotItem;
                                    int label;

                                    {
                                        TrendMusicWaveExclusiveFragment.this = trendMusicWaveExclusiveFragment0;
                                        this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragment.onViewCreated.5(TrendMusicWaveExclusiveFragment.this, this.$slotItem, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragment.onViewCreated.5)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        ne.a a0 = ne.a.a;
                                        switch(this.label) {
                                            case 0: {
                                                d5.n.D(object0);
                                                D d0 = TrendMusicWaveExclusiveFragment.this.getViewLifecycleOwner();
                                                q.f(d0, "getViewLifecycleOwner(...)");
                                                com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragment.onViewCreated.5.1 trendMusicWaveExclusiveFragment$onViewCreated$5$10 = new n(this.$slotItem, null) {
                                                    final SLOTLIST $slotItem;
                                                    int label;

                                                    {
                                                        TrendMusicWaveExclusiveFragment.this = trendMusicWaveExclusiveFragment0;
                                                        this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        return new com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragment.onViewCreated.5.1(TrendMusicWaveExclusiveFragment.this, this.$slotItem, continuation0);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                        return ((com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragment.onViewCreated.5.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        ne.a a0 = ne.a.a;
                                                        switch(this.label) {
                                                            case 0: {
                                                                d5.n.D(object0);
                                                                SharedFlow sharedFlow0 = TrendMusicWaveExclusiveFragment.this.getViewModel().getEtcEventFlow();
                                                                com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragment.onViewCreated.5.1.1 trendMusicWaveExclusiveFragment$onViewCreated$5$1$10 = new n(this.$slotItem, null) {
                                                                    final SLOTLIST $slotItem;
                                                                    Object L$0;
                                                                    int label;

                                                                    {
                                                                        TrendMusicWaveExclusiveFragment.this = trendMusicWaveExclusiveFragment0;
                                                                        this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                                                                        super(2, continuation0);
                                                                    }

                                                                    @Override  // oe.a
                                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                                        Continuation continuation1 = new com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragment.onViewCreated.5.1.1(TrendMusicWaveExclusiveFragment.this, this.$slotItem, continuation0);
                                                                        continuation1.L$0 = object0;
                                                                        return continuation1;
                                                                    }

                                                                    public final Object invoke(EtcEvent trendShortFormViewModel$EtcEvent0, Continuation continuation0) {
                                                                        return ((com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragment.onViewCreated.5.1.1)this.create(trendShortFormViewModel$EtcEvent0, continuation0)).invokeSuspend(H.a);
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
                                                                        g g0 = TrendMusicWaveExclusiveFragment.this.getTiaraDefaultBuilder();
                                                                        H h0 = H.a;
                                                                        if(g0 == null) {
                                                                            return h0;
                                                                        }
                                                                        g0.a = TrendMusicWaveExclusiveFragment.this.getString(0x7F130DCA);  // string:tiara_common_action_name_mute "음소거"
                                                                        g0.F = TrendMusicWaveExclusiveFragment.this.getString(0x7F130D5C);  // string:tiara_click_copy_mute "음소거"
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
                                                                return FlowKt.collectLatest(sharedFlow0, trendMusicWaveExclusiveFragment$onViewCreated$5$1$10, this) == a0 ? a0 : H.a;
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
                                                return f0.j(d0, s.e, trendMusicWaveExclusiveFragment$onViewCreated$5$10, this) == a0 ? a0 : H.a;
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
                                return;
                            }
                            q.m("viewBinding");
                            throw null;
                        }
                        q.m("viewBinding");
                        throw null;
                    }
                    q.m("viewBinding");
                    throw null;
                }
                q.m("viewBinding");
                throw null;
            }
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragment.onViewCreated.lambda.3..inlined.noRippleClickable-YQRRFTQ.default.1 implements o {
            public com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragment.onViewCreated.lambda.3..inlined.noRippleClickable-YQRRFTQ.default.1(boolean z, String s, int v, TrendMusicWaveExclusiveFragment trendMusicWaveExclusiveFragment0) {
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
            }

            public final r0.q invoke(r0.q q0, l l0, int v) {
                q.g(q0, "$this$composed");
                ((androidx.compose.runtime.p)l0).a0(0x1FF03545);
                h h0 = (h)((androidx.compose.runtime.p)l0).k(k0.i);
                m m0 = ((androidx.compose.runtime.p)l0).N();
                if(m0 == k.a) {
                    m0 = androidx.appcompat.app.o.d(((androidx.compose.runtime.p)l0));
                }
                i i0 = new i(this.$role);
                com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragment.onViewCreated.lambda.3..inlined.noRippleClickable-YQRRFTQ.default.1.1 trendMusicWaveExclusiveFragment$onViewCreated$lambda$3$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        h.a(TrendMusicWaveExclusiveFragment.this);
                        TrendMusicWaveExclusiveFragment.this.getViewModel().setSoundFlag(!((Boolean)TrendMusicWaveExclusiveFragment.this.getViewModel().getSoundAble().getValue()).booleanValue());
                        TrendMusicWaveExclusiveFragment.this.getViewModel().clickSoundButton();
                    }
                };
                r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, this.$enabled, this.$onClickLabel, i0, trendMusicWaveExclusiveFragment$onViewCreated$lambda$3$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                ((androidx.compose.runtime.p)l0).p(false);
                return q1;
            }
        }

    }

    private static final H onViewCreated$lambda$1(SLOTLIST trendShortFormRes$Response$SLOTLIST0, TrendMusicWaveExclusiveFragment trendMusicWaveExclusiveFragment0, l l0, int v) {
        if(((androidx.compose.runtime.p)l0).Q(v & 1, (v & 3) != 2)) {
            ArrayList arrayList0 = trendShortFormRes$Response$SLOTLIST0.imgList;
            long v1 = x1.a.P(3, Uf.d.d);
            TrendMusicWaveExclusiveFragmentKt.AutoSwitchingImage-WPi__2c(androidx.compose.foundation.layout.d.c, arrayList0, v1, ((androidx.compose.runtime.p)l0), 6, 0);
            String s = trendShortFormRes$Response$SLOTLIST0.imgDpType;
            q.f(s, "imgDpType");
            String s1 = s.toUpperCase(Locale.ROOT);
            q.f(s1, "toUpperCase(...)");
            if(!s1.equals("D") && (trendShortFormRes$Response$SLOTLIST0.imgList != null && !trendShortFormRes$Response$SLOTLIST0.imgList.isEmpty())) {
                f1 f10 = trendMusicWaveExclusiveFragment0.viewBinding;
                if(f10 != null) {
                    f10.e.setVisibility(0);
                    return H.a;
                }
                q.m("viewBinding");
                throw null;
            }
            f1 f11 = trendMusicWaveExclusiveFragment0.viewBinding;
            if(f11 != null) {
                f11.e.setVisibility(8);
                return H.a;
            }
            q.m("viewBinding");
            throw null;
        }
        ((androidx.compose.runtime.p)l0).T();
        return H.a;
    }

    private static final H onViewCreated$lambda$10$lambda$6(View view0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, l l0, int v) {
        if(((androidx.compose.runtime.p)l0).Q(v & 1, (v & 3) != 2)) {
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3), 20.0f, 0.0f, 2);
            y y0 = w.a(j.c, r0.d.m, ((androidx.compose.runtime.p)l0), 0);
            int v1 = ((androidx.compose.runtime.p)l0).P;
            i0 i00 = ((androidx.compose.runtime.p)l0).m();
            r0.q q1 = r0.a.d(((androidx.compose.runtime.p)l0), q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            ((androidx.compose.runtime.p)l0).e0();
            if(((androidx.compose.runtime.p)l0).O) {
                ((androidx.compose.runtime.p)l0).l(i0);
            }
            else {
                ((androidx.compose.runtime.p)l0).o0();
            }
            androidx.compose.runtime.w.x(((androidx.compose.runtime.p)l0), y0, P0.j.f);
            androidx.compose.runtime.w.x(((androidx.compose.runtime.p)l0), i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(((androidx.compose.runtime.p)l0).O || !q.b(((androidx.compose.runtime.p)l0).N(), v1)) {
                A7.d.q(v1, ((androidx.compose.runtime.p)l0), v1, h0);
            }
            androidx.compose.runtime.w.x(((androidx.compose.runtime.p)l0), q1, P0.j.d);
            String s = H0.e.Y(((androidx.compose.runtime.p)l0), 0x7F130750);  // string:music_wave_visitor "%s명 방문"
            Context context0 = view0.getContext();
            q.f(context0, "getContext(...)");
            String s1 = trendShortFormRes$Response$SLOTLIST0.viewCnt;
            q.f(s1, "viewCnt");
            String s2 = String.format(s, Arrays.copyOf(new Object[]{d5.w.r(context0, Util.toLongOrDefault(s1, 0L))}, 1));
            c1.n(null, 0x7F0805DA, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((androidx.compose.runtime.p)l0), 0x30, 0, 0x7FFD);  // drawable:ic_shortmusic_musicwave_25
            r0.q q2 = x.s(n0, 12.0f, ((androidx.compose.runtime.p)l0), n0, 1.0f);
            String s3 = trendShortFormRes$Response$SLOTLIST0.title;
            q.f(s3, "title");
            String s4 = trendShortFormRes$Response$SLOTLIST0.artistInfo.getArtistName();
            String s5 = trendShortFormRes$Response$SLOTLIST0.artistInfo.getArtistImg();
            String s6 = trendShortFormRes$Response$SLOTLIST0.likeCnt;
            q.f(s6, "likeCnt");
            long v2 = Long.parseLong(s6);
            Boolean boolean0 = trendShortFormRes$Response$SLOTLIST0.isEvent;
            q.f(boolean0, "isEvent");
            T.g(q2, s3, (s4 == null ? "" : s4), (s5 == null ? "" : s5), v2, s2, boolean0.booleanValue(), ((androidx.compose.runtime.p)l0), 6);
            ((androidx.compose.runtime.p)l0).p(true);
            return H.a;
        }
        ((androidx.compose.runtime.p)l0).T();
        return H.a;
    }

    private static final void onViewCreated$lambda$10$lambda$9$lambda$8(SLOTLIST trendShortFormRes$Response$SLOTLIST0, TrendMusicWaveExclusiveFragment trendMusicWaveExclusiveFragment0, View view0) {
        MelonLinkExecutor.open(MelonLinkInfo.b(trendShortFormRes$Response$SLOTLIST0.banner));
        g g0 = trendMusicWaveExclusiveFragment0.getTiaraDefaultBuilder();
        if(g0 == null) {
            return;
        }
        g0.a = trendMusicWaveExclusiveFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        g0.d = ActionKind.ClickContent;
        g0.B = trendShortFormRes$Response$SLOTLIST0.banner.scheme;
        g0.F = trendMusicWaveExclusiveFragment0.getString(0x7F130D07);  // string:tiara_click_copy_banner_move "배너이동"
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

    private static final H onViewCreated$lambda$3(SLOTLIST trendShortFormRes$Response$SLOTLIST0, TrendMusicWaveExclusiveFragment trendMusicWaveExclusiveFragment0, l l0, int v) {
        if(((androidx.compose.runtime.p)l0).Q(v & 1, (v & 3) != 2)) {
            com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragment.onViewCreated.lambda.3..inlined.noRippleClickable-YQRRFTQ.default.1 trendMusicWaveExclusiveFragment$onViewCreated$lambda$3$$inlined$noRippleClickable-YQRRFTQ$default$10 = new com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragment.onViewCreated.lambda.3..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0, trendMusicWaveExclusiveFragment0);
            r0.q q0 = r0.a.a(androidx.compose.foundation.layout.d.c, trendMusicWaveExclusiveFragment$onViewCreated$lambda$3$$inlined$noRippleClickable-YQRRFTQ$default$10);
            ArrayList arrayList0 = trendShortFormRes$Response$SLOTLIST0.chatList;
            if(arrayList0 == null) {
                arrayList0 = je.w.a;
            }
            TrendMusicWaveExclusiveFragmentKt.MusicWaveChatList(q0, arrayList0, ((androidx.compose.runtime.p)l0), 0, 0);
            return H.a;
        }
        ((androidx.compose.runtime.p)l0).T();
        return H.a;
    }

    private static final H onViewCreated$lambda$4(SLOTLIST trendShortFormRes$Response$SLOTLIST0, l l0, int v) {
        if(((androidx.compose.runtime.p)l0).Q(v & 1, (v & 3) != 2)) {
            r0.q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(r0.n.a, 360.0f), 330.0f);
            String s = trendShortFormRes$Response$SLOTLIST0.patternImgType;
            q.f(s, "patternImgType");
            String s1 = trendShortFormRes$Response$SLOTLIST0.patternColorType;
            q.f(s1, "patternColorType");
            TrendMusicWaveBackgroundPatternKt.TrendMusicWaveBackgroundPattern(q0, s, s1, ((androidx.compose.runtime.p)l0), 6, 0);
            return H.a;
        }
        ((androidx.compose.runtime.p)l0).T();
        return H.a;
    }

    public static void p(SLOTLIST trendShortFormRes$Response$SLOTLIST0, TrendMusicWaveExclusiveFragment trendMusicWaveExclusiveFragment0, View view0) {
        TrendMusicWaveExclusiveFragment.onViewCreated$lambda$10$lambda$9$lambda$8(trendShortFormRes$Response$SLOTLIST0, trendMusicWaveExclusiveFragment0, view0);
    }

    public static H q(View view0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, l l0, int v) {
        return TrendMusicWaveExclusiveFragment.onViewCreated$lambda$10$lambda$6(view0, trendShortFormRes$Response$SLOTLIST0, l0, v);
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendShortBaseFragment
    public void updateCommentCountView(int v) {
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendShortBaseFragment
    public void updateLikeView(int v, boolean z) {
    }
}

