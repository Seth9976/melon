package com.iloen.melon.fragments.shortform;

import De.I;
import J8.g1;
import Zc.N;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.fragments.artistchannel.viewholder.e;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.Meta.Builder;
import com.melon.utils.system.SystemSettingUtils;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import m0.b;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import we.n;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ+\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\n2\b\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\tJ!\u0010\u0014\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u000E2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u001A\u001A\u00020\u00042\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001C\u001A\u00020\u00042\u0006\u0010\u0017\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001E\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u001E\u0010\u0003J\u000F\u0010\u001F\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u001F\u0010\u0003R\u0014\u0010!\u001A\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001A\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\'\u001A\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\'\u0010(¨\u0006*"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendMusicWavePopularFragment;", "Lcom/iloen/melon/fragments/shortform/TrendMusicPlayerBaseFragment;", "<init>", "()V", "Lie/H;", "startBackgroundAnim", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "outState", "onSaveInstanceState", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "sumCount", "", "isLike", "updateLikeView", "(IZ)V", "updateCommentCountView", "(I)V", "onResume", "onPause", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "LJ8/g1;", "viewBinding", "LJ8/g1;", "Landroid/graphics/drawable/Animatable;", "animationDrawable", "Landroid/graphics/drawable/Animatable;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TrendMusicWavePopularFragment extends TrendMusicPlayerBaseFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\bR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendMusicWavePopularFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_POSITION", "MIN_MEMORY_TO_PLAY_ANIM", "", "newInstance", "Lcom/iloen/melon/fragments/shortform/TrendMusicWavePopularFragment;", "position", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TrendMusicWavePopularFragment newInstance(int v) {
            TrendMusicWavePopularFragment trendMusicWavePopularFragment0 = new TrendMusicWavePopularFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putInt("argPosition", v);
            trendMusicWavePopularFragment0.setArguments(bundle0);
            return trendMusicWavePopularFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_POSITION = "argPosition";
    @NotNull
    public static final Companion Companion = null;
    private static final int MIN_MEMORY_TO_PLAY_ANIM = 500;
    @NotNull
    private static final String TAG = "TrendMusicWavePopularFragment";
    @Nullable
    private Animatable animationDrawable;
    @NotNull
    private final LogU log;
    private g1 viewBinding;

    static {
        TrendMusicWavePopularFragment.Companion = new Companion(null);
        TrendMusicWavePopularFragment.$stable = 8;
    }

    public TrendMusicWavePopularFragment() {
        LogU logU0 = new LogU("TrendMusicWavePopularFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.log = logU0;
    }

    public static H n(SLOTLIST trendShortFormRes$Response$SLOTLIST0, TrendMusicWavePopularFragment trendMusicWavePopularFragment0, l l0, int v) {
        return TrendMusicWavePopularFragment.onViewCreated$lambda$4(trendShortFormRes$Response$SLOTLIST0, trendMusicWavePopularFragment0, l0, v);
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
        View view0 = this.getLayoutInflater().inflate(0x7F0D02B8, viewGroup0, false);  // layout:fragment_music_wave_popular
        int v = 0x7F0A0309;  // id:compose_view
        ComposeView composeView0 = (ComposeView)I.C(view0, 0x7F0A0309);  // id:compose_view
        if(composeView0 != null) {
            v = 0x7F0A05F0;  // id:iv_animator
            ImageView imageView0 = (ImageView)I.C(view0, 0x7F0A05F0);  // id:iv_animator
            if(imageView0 != null) {
                this.viewBinding = new g1(((ConstraintLayout)view0), composeView0, imageView0);
                q.f(((ConstraintLayout)view0), "getRoot(...)");
                return (ConstraintLayout)view0;
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendMusicPlayerBaseFragment
    public void onPause() {
        super.onPause();
        Animatable animatable0 = this.animationDrawable;
        if(animatable0 != null) {
            animatable0.stop();
        }
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
                g1 g10 = this.viewBinding;
                if(g10 != null) {
                    b b0 = new b(-159087253, new e(4, trendShortFormRes$Response$SLOTLIST0, this), true);
                    g10.b.setContent(b0);
                    BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new n(null) {
                        int label;

                        {
                            TrendMusicWavePopularFragment.this = trendMusicWavePopularFragment0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragment.onViewCreated.2(TrendMusicWavePopularFragment.this, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragment.onViewCreated.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    d5.n.D(object0);
                                    t t0 = TrendMusicWavePopularFragment.this.getViewLifecycleOwner().getLifecycle();
                                    com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragment.onViewCreated.2.1 trendMusicWavePopularFragment$onViewCreated$2$10 = new n(null) {
                                        int label;

                                        {
                                            TrendMusicWavePopularFragment.this = trendMusicWavePopularFragment0;
                                            super(2, continuation0);
                                        }

                                        @Override  // oe.a
                                        public final Continuation create(Object object0, Continuation continuation0) {
                                            return new com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragment.onViewCreated.2.1(TrendMusicWavePopularFragment.this, continuation0);
                                        }

                                        @Override  // we.n
                                        public Object invoke(Object object0, Object object1) {
                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                        }

                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                            return ((com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragment.onViewCreated.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                        }

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            if(this.label != 0) {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                            d5.n.D(object0);
                                            TrendMusicWavePopularFragment.this.startBackgroundAnim();
                                            return H.a;
                                        }
                                    };
                                    this.label = 1;
                                    return f0.i(t0, s.e, trendMusicWavePopularFragment$onViewCreated$2$10, this) == a0 ? a0 : H.a;
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
                    Context context0 = this.getContext();
                    if(context0 != null) {
                        com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragment.onViewCreated.3.1 trendMusicWavePopularFragment$onViewCreated$3$10 = (com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragment.onViewCreated.3.1)Glide.with(context0).load(trendShortFormRes$Response$SLOTLIST0.shapeImgUrl).into(new CustomTarget() {
                            @Override  // com.bumptech.glide.request.target.Target
                            public void onLoadCleared(Drawable drawable0) {
                            }

                            public void onResourceReady(Drawable drawable0, Transition transition0) {
                                q.g(drawable0, "d");
                                g1 g10 = TrendMusicWavePopularFragment.this.viewBinding;
                                if(g10 != null) {
                                    g10.c.setImageDrawable(drawable0);
                                    if(drawable0 instanceof Animatable) {
                                        TrendMusicWavePopularFragment.this.animationDrawable = (Animatable)drawable0;
                                    }
                                    return;
                                }
                                q.m("viewBinding");
                                throw null;
                            }

                            @Override  // com.bumptech.glide.request.target.Target
                            public void onResourceReady(Object object0, Transition transition0) {
                                this.onResourceReady(((Drawable)object0), transition0);
                            }
                        });
                    }
                    D d0 = this.getViewLifecycleOwner();
                    q.f(d0, "getViewLifecycleOwner(...)");
                    BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(trendShortFormRes$Response$SLOTLIST0, null) {
                        final SLOTLIST $slotItem;
                        int label;

                        {
                            TrendMusicWavePopularFragment.this = trendMusicWavePopularFragment0;
                            this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragment.onViewCreated.4(TrendMusicWavePopularFragment.this, this.$slotItem, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragment.onViewCreated.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    d5.n.D(object0);
                                    D d0 = TrendMusicWavePopularFragment.this.getViewLifecycleOwner();
                                    q.f(d0, "getViewLifecycleOwner(...)");
                                    com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragment.onViewCreated.4.1 trendMusicWavePopularFragment$onViewCreated$4$10 = new n(this.$slotItem, null) {
                                        final SLOTLIST $slotItem;
                                        int label;

                                        {
                                            TrendMusicWavePopularFragment.this = trendMusicWavePopularFragment0;
                                            this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                                            super(2, continuation0);
                                        }

                                        @Override  // oe.a
                                        public final Continuation create(Object object0, Continuation continuation0) {
                                            return new com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragment.onViewCreated.4.1(TrendMusicWavePopularFragment.this, this.$slotItem, continuation0);
                                        }

                                        @Override  // we.n
                                        public Object invoke(Object object0, Object object1) {
                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                        }

                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                            return ((com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragment.onViewCreated.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                        }

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            a a0 = a.a;
                                            switch(this.label) {
                                                case 0: {
                                                    d5.n.D(object0);
                                                    SharedFlow sharedFlow0 = TrendMusicWavePopularFragment.this.getViewModel().getEtcEventFlow();
                                                    com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragment.onViewCreated.4.1.1 trendMusicWavePopularFragment$onViewCreated$4$1$10 = new n(this.$slotItem, null) {
                                                        final SLOTLIST $slotItem;
                                                        Object L$0;
                                                        int label;

                                                        {
                                                            TrendMusicWavePopularFragment.this = trendMusicWavePopularFragment0;
                                                            this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                                                            super(2, continuation0);
                                                        }

                                                        @Override  // oe.a
                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                            Continuation continuation1 = new com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragment.onViewCreated.4.1.1(TrendMusicWavePopularFragment.this, this.$slotItem, continuation0);
                                                            continuation1.L$0 = object0;
                                                            return continuation1;
                                                        }

                                                        public final Object invoke(EtcEvent trendShortFormViewModel$EtcEvent0, Continuation continuation0) {
                                                            return ((com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragment.onViewCreated.4.1.1)this.create(trendShortFormViewModel$EtcEvent0, continuation0)).invokeSuspend(H.a);
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
                                                            g g0 = TrendMusicWavePopularFragment.this.getTiaraDefaultBuilder();
                                                            H h0 = H.a;
                                                            if(g0 == null) {
                                                                return h0;
                                                            }
                                                            g0.a = TrendMusicWavePopularFragment.this.getString(0x7F130DCA);  // string:tiara_common_action_name_mute "음소거"
                                                            g0.F = TrendMusicWavePopularFragment.this.getString(0x7F130D5C);  // string:tiara_click_copy_mute "음소거"
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
                                                    return FlowKt.collectLatest(sharedFlow0, trendMusicWavePopularFragment$onViewCreated$4$1$10, this) == a0 ? a0 : H.a;
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
                                    return f0.j(d0, s.e, trendMusicWavePopularFragment$onViewCreated$4$10, this) == a0 ? a0 : H.a;
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
        }
    }

    private static final H onViewCreated$lambda$4(SLOTLIST trendShortFormRes$Response$SLOTLIST0, TrendMusicWavePopularFragment trendMusicWavePopularFragment0, l l0, int v) {
        if(((p)l0).Q(v & 1, (v & 3) != 2)) {
            boolean z = ((p)l0).i(trendShortFormRes$Response$SLOTLIST0);
            boolean z1 = ((p)l0).i(trendMusicWavePopularFragment0);
            N n0 = ((p)l0).N();
            if(z || z1 || n0 == k.a) {
                n0 = new N(17, trendShortFormRes$Response$SLOTLIST0, trendMusicWavePopularFragment0);
                ((p)l0).l0(n0);
            }
            TrendMusicWavePopularFragmentKt.access$TrendMusicWavePopularScreen(trendShortFormRes$Response$SLOTLIST0, n0, ((p)l0), 0);
            return H.a;
        }
        ((p)l0).T();
        return H.a;
    }

    private static final H onViewCreated$lambda$4$lambda$3$lambda$2(SLOTLIST trendShortFormRes$Response$SLOTLIST0, TrendMusicWavePopularFragment trendMusicWavePopularFragment0) {
        MelonLinkExecutor.open(MelonLinkInfo.b(trendShortFormRes$Response$SLOTLIST0.banner));
        g g0 = trendMusicWavePopularFragment0.getTiaraDefaultBuilder();
        H h0 = H.a;
        if(g0 == null) {
            return h0;
        }
        g0.a = trendMusicWavePopularFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        g0.d = ActionKind.ClickContent;
        g0.B = trendShortFormRes$Response$SLOTLIST0.banner.scheme;
        g0.F = trendMusicWavePopularFragment0.getString(0x7F130D07);  // string:tiara_click_copy_banner_move "배너이동"
        g0.e = trendShortFormRes$Response$SLOTLIST0.contsId;
        String s = trendShortFormRes$Response$SLOTLIST0.contsTypeCode;
        q.f(s, "contsTypeCode");
        g0.f = p8.b.a(s);
        g0.g = trendShortFormRes$Response$SLOTLIST0.contsTitle;
        Builder meta$Builder0 = new Builder();
        meta$Builder0.id(trendShortFormRes$Response$SLOTLIST0.contsId);
        meta$Builder0.type(trendShortFormRes$Response$SLOTLIST0.contsTypeCode);
        meta$Builder0.name(trendShortFormRes$Response$SLOTLIST0.contsTitle);
        meta$Builder0.category(trendShortFormRes$Response$SLOTLIST0.slotTypeDesc);
        meta$Builder0.categoryId(trendShortFormRes$Response$SLOTLIST0.slotNo);
        g0.b0 = meta$Builder0.build();
        g0.J = trendShortFormRes$Response$SLOTLIST0.statsElements.rangeCode;
        g0.a().track();
        return h0;
    }

    private final void startBackgroundAnim() {
        if(this.animationDrawable == null || this.animationDrawable.isRunning()) {
            return;
        }
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        Object object0 = new SystemSettingUtils(context0).a.getSystemService("activity");
        q.e(object0, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager.MemoryInfo activityManager$MemoryInfo0 = new ActivityManager.MemoryInfo();
        ((ActivityManager)object0).getMemoryInfo(activityManager$MemoryInfo0);
        if(activityManager$MemoryInfo0.availMem / 0x100000L > 500L) {
            Animatable animatable0 = this.animationDrawable;
            if(animatable0 != null) {
                x1.a.l(animatable0);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendShortBaseFragment
    public void updateCommentCountView(int v) {
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendShortBaseFragment
    public void updateLikeView(int v, boolean z) {
    }
}

