package com.iloen.melon.fragments.shortform;

import De.I;
import J8.n1;
import J8.r1;
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
import androidx.lifecycle.s;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.fragments.comments.BbsParam;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.Meta.Builder;
import he.c;
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
import m4.e;
import m4.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;
import x1.a;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000B\u001A\u00020\u00062\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000B\u0010\fJ+\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000E\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001A\u00020\u00062\u0006\u0010\u0014\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\fJ!\u0010\u0017\u001A\u00020\u00062\u0006\u0010\u0016\u001A\u00020\u00112\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001F\u0010\u001C\u001A\u00020\u00062\u0006\u0010\u0019\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u001AH\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010\u001E\u001A\u00020\u00062\u0006\u0010\u0019\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u001E\u0010\bJ\u000F\u0010\u001F\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u001F\u0010\u0003R\u0014\u0010!\u001A\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001A\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006\'"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendMagazineFragment;", "Lcom/iloen/melon/fragments/shortform/TrendMusicPlayerBaseFragment;", "<init>", "()V", "", "color", "Lie/H;", "updateBannerBackground", "(I)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "outState", "onSaveInstanceState", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "sumCount", "", "isLike", "updateLikeView", "(IZ)V", "updateCommentCountView", "onResume", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "LJ8/n1;", "viewBinding", "LJ8/n1;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TrendMagazineFragment extends TrendMusicPlayerBaseFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendMagazineFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_POSITION", "newInstance", "Lcom/iloen/melon/fragments/shortform/TrendMagazineFragment;", "position", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TrendMagazineFragment newInstance(int v) {
            TrendMagazineFragment trendMagazineFragment0 = new TrendMagazineFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putInt("argPosition", v);
            trendMagazineFragment0.setArguments(bundle0);
            return trendMagazineFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_POSITION = "argPosition";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "TrendMagazineFragment";
    @NotNull
    private final LogU log;
    private n1 viewBinding;

    static {
        TrendMagazineFragment.Companion = new Companion(null);
        TrendMagazineFragment.$stable = 8;
    }

    public TrendMagazineFragment() {
        LogU logU0 = new LogU("TrendMagazineFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.log = logU0;
    }

    public static void n(TrendMagazineFragment trendMagazineFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, View view0) {
        TrendMagazineFragment.onViewCreated$lambda$6(trendShortFormRes$Response$SLOTLIST0, trendMagazineFragment0, view0);
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
        View view0 = this.getLayoutInflater().inflate(0x7F0D02C8, viewGroup0, false);  // layout:fragment_trend_magazine
        int v = 0x7F0A0625;  // id:iv_dim
        if(((ImageView)I.C(view0, 0x7F0A0625)) != null) {  // id:iv_dim
            v = 0x7F0A0673;  // id:iv_primary_color
            ImageView imageView0 = (ImageView)I.C(view0, 0x7F0A0673);  // id:iv_primary_color
            if(imageView0 != null) {
                v = 0x7F0A069A;  // id:iv_thumb
                ImageView imageView1 = (ImageView)I.C(view0, 0x7F0A069A);  // id:iv_thumb
                if(imageView1 != null && ((FrameLayout)I.C(view0, 0x7F0A074B)) != null) {  // id:layout_thumb
                    v = 0x7F0A0751;  // id:layout_trend_info
                    View view1 = I.C(view0, 0x7F0A0751);  // id:layout_trend_info
                    if(view1 != null) {
                        this.viewBinding = new n1(((ConstraintLayout)view0), imageView0, imageView1, r1.a(view1));
                        q.f(((ConstraintLayout)view0), "getRoot(...)");
                        return (ConstraintLayout)view0;
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
                int v = ScreenUtils.dipToPixel(this.requireContext(), 260.0f);
                int v1 = ScreenUtils.dipToPixel(this.requireContext(), 381.0f);
                RequestBuilder requestBuilder0 = Glide.with(this.requireContext()).asBitmap().load(trendShortFormRes$Response$SLOTLIST0.coverImgUrl).apply(RequestOptions.overrideOf(v, v1));
                CenterCrop centerCrop0 = new CenterCrop();
                c c0 = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
                Transformation[] arr_transformation = new Transformation[2];
                int v2 = 0;
                arr_transformation[0] = centerCrop0;
                arr_transformation[1] = c0;
                requestBuilder0.apply(RequestOptions.bitmapTransform(new MultiTransformation(arr_transformation))).into(new CustomTarget() {
                    @Override  // com.bumptech.glide.request.target.Target
                    public void onLoadCleared(Drawable drawable0) {
                    }

                    public void onResourceReady(Bitmap bitmap0, Transition transition0) {
                        q.g(bitmap0, "bitmap");
                        n1 n10 = TrendMagazineFragment.this.viewBinding;
                        if(n10 != null) {
                            n10.c.setImageBitmap(bitmap0);
                            e e0 = new e(bitmap0);
                            e0.a = 24;
                            g g0 = e0.a().e;
                            if(g0 == null) {
                                return;
                            }
                            int v = F.C(g0);
                            TrendMagazineFragment.this.updateBannerBackground(v);
                            return;
                        }
                        q.m("viewBinding");
                        throw null;
                    }

                    @Override  // com.bumptech.glide.request.target.Target
                    public void onResourceReady(Object object0, Transition transition0) {
                        this.onResourceReady(((Bitmap)object0), transition0);
                    }
                });
                n1 n10 = this.viewBinding;
                if(n10 != null) {
                    StringUtils stringUtils0 = StringUtils.INSTANCE;
                    String s = stringUtils0.getFormattedStringNumberWithoutPlus(trendShortFormRes$Response$SLOTLIST0.likeCnt, 0xF423F);
                    n10.d.l.setText(s);
                    boolean z = ProtocolUtils.parseBoolean(trendShortFormRes$Response$SLOTLIST0.likeYn);
                    n1 n11 = this.viewBinding;
                    if(n11 != null) {
                        n11.d.d.setChecked(z);
                        n1 n12 = this.viewBinding;
                        if(n12 != null) {
                            String s1 = z ? this.getString(0x7F130B5C) : this.getString(0x7F130B5F);  // string:talkback_like_off "좋아요 취소"
                            n12.d.d.setContentDescription(s1);
                            n1 n13 = this.viewBinding;
                            if(n13 != null) {
                                com.iloen.melon.fragments.shortform.c c1 = new com.iloen.melon.fragments.shortform.c(this, trendShortFormRes$Response$SLOTLIST0, 0);
                                n13.d.d.setOnClickListener(c1);
                                n1 n14 = this.viewBinding;
                                if(n14 != null) {
                                    String s2 = stringUtils0.getFormattedStringNumberWithoutPlus(trendShortFormRes$Response$SLOTLIST0.cmtCnt, 0xF423F);
                                    n14.d.e.setText(s2);
                                    n1 n15 = this.viewBinding;
                                    if(n15 != null) {
                                        com.iloen.melon.fragments.shortform.c c2 = new com.iloen.melon.fragments.shortform.c(this, trendShortFormRes$Response$SLOTLIST0, 1);
                                        a.N(n15.d.c, c2);
                                        RequestBuilder requestBuilder1 = Glide.with(this.requireContext()).load(trendShortFormRes$Response$SLOTLIST0.badgeImgUrl);
                                        n1 n16 = this.viewBinding;
                                        if(n16 != null) {
                                            requestBuilder1.into(n16.d.f);
                                            n1 n17 = this.viewBinding;
                                            if(n17 != null) {
                                                n17.d.o.setText(trendShortFormRes$Response$SLOTLIST0.title);
                                                n1 n18 = this.viewBinding;
                                                if(n18 != null) {
                                                    n18.d.p.setMaxLines(3);
                                                    n1 n19 = this.viewBinding;
                                                    if(n19 != null) {
                                                        n19.d.p.setText(trendShortFormRes$Response$SLOTLIST0.subTitle);
                                                        n1 n110 = this.viewBinding;
                                                        if(n110 != null) {
                                                            FrameLayout frameLayout0 = n110.d.i;
                                                            if(!trendShortFormRes$Response$SLOTLIST0.banner.useImgUrl) {
                                                                v2 = 8;
                                                            }
                                                            frameLayout0.setVisibility(v2);
                                                            n1 n111 = this.viewBinding;
                                                            if(n111 != null) {
                                                                n111.d.n.setText(trendShortFormRes$Response$SLOTLIST0.banner.text);
                                                                n1 n112 = this.viewBinding;
                                                                if(n112 != null) {
                                                                    n112.d.n.setHorizontallyScrolling(true);
                                                                    n1 n113 = this.viewBinding;
                                                                    if(n113 != null) {
                                                                        n113.d.n.setSelected(true);
                                                                        n1 n114 = this.viewBinding;
                                                                        if(n114 != null) {
                                                                            com.iloen.melon.fragments.shortform.c c3 = new com.iloen.melon.fragments.shortform.c(trendShortFormRes$Response$SLOTLIST0, this);
                                                                            n114.d.h.setOnClickListener(c3);
                                                                            D d0 = this.getViewLifecycleOwner();
                                                                            q.f(d0, "getViewLifecycleOwner(...)");
                                                                            BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(trendShortFormRes$Response$SLOTLIST0, null) {
                                                                                final SLOTLIST $slotItem;
                                                                                int label;

                                                                                {
                                                                                    TrendMagazineFragment.this = trendMagazineFragment0;
                                                                                    this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                                                                                    super(2, continuation0);
                                                                                }

                                                                                @Override  // oe.a
                                                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                                                    return new com.iloen.melon.fragments.shortform.TrendMagazineFragment.onViewCreated.5(TrendMagazineFragment.this, this.$slotItem, continuation0);
                                                                                }

                                                                                @Override  // we.n
                                                                                public Object invoke(Object object0, Object object1) {
                                                                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                                                }

                                                                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                                                    return ((com.iloen.melon.fragments.shortform.TrendMagazineFragment.onViewCreated.5)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                                                }

                                                                                @Override  // oe.a
                                                                                public final Object invokeSuspend(Object object0) {
                                                                                    ne.a a0 = ne.a.a;
                                                                                    switch(this.label) {
                                                                                        case 0: {
                                                                                            d5.n.D(object0);
                                                                                            D d0 = TrendMagazineFragment.this.getViewLifecycleOwner();
                                                                                            q.f(d0, "getViewLifecycleOwner(...)");
                                                                                            com.iloen.melon.fragments.shortform.TrendMagazineFragment.onViewCreated.5.1 trendMagazineFragment$onViewCreated$5$10 = new n(this.$slotItem, null) {
                                                                                                final SLOTLIST $slotItem;
                                                                                                int label;

                                                                                                {
                                                                                                    TrendMagazineFragment.this = trendMagazineFragment0;
                                                                                                    this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                                                                                                    super(2, continuation0);
                                                                                                }

                                                                                                @Override  // oe.a
                                                                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                                                                    return new com.iloen.melon.fragments.shortform.TrendMagazineFragment.onViewCreated.5.1(TrendMagazineFragment.this, this.$slotItem, continuation0);
                                                                                                }

                                                                                                @Override  // we.n
                                                                                                public Object invoke(Object object0, Object object1) {
                                                                                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                                                                }

                                                                                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                                                                    return ((com.iloen.melon.fragments.shortform.TrendMagazineFragment.onViewCreated.5.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                                                                }

                                                                                                @Override  // oe.a
                                                                                                public final Object invokeSuspend(Object object0) {
                                                                                                    ne.a a0 = ne.a.a;
                                                                                                    switch(this.label) {
                                                                                                        case 0: {
                                                                                                            d5.n.D(object0);
                                                                                                            SharedFlow sharedFlow0 = TrendMagazineFragment.this.getViewModel().getEtcEventFlow();
                                                                                                            com.iloen.melon.fragments.shortform.TrendMagazineFragment.onViewCreated.5.1.1 trendMagazineFragment$onViewCreated$5$1$10 = new n(this.$slotItem, null) {
                                                                                                                final SLOTLIST $slotItem;
                                                                                                                Object L$0;
                                                                                                                int label;

                                                                                                                {
                                                                                                                    TrendMagazineFragment.this = trendMagazineFragment0;
                                                                                                                    this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                                                                                                                    super(2, continuation0);
                                                                                                                }

                                                                                                                @Override  // oe.a
                                                                                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                                                                                    Continuation continuation1 = new com.iloen.melon.fragments.shortform.TrendMagazineFragment.onViewCreated.5.1.1(TrendMagazineFragment.this, this.$slotItem, continuation0);
                                                                                                                    continuation1.L$0 = object0;
                                                                                                                    return continuation1;
                                                                                                                }

                                                                                                                public final Object invoke(EtcEvent trendShortFormViewModel$EtcEvent0, Continuation continuation0) {
                                                                                                                    return ((com.iloen.melon.fragments.shortform.TrendMagazineFragment.onViewCreated.5.1.1)this.create(trendShortFormViewModel$EtcEvent0, continuation0)).invokeSuspend(H.a);
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
                                                                                                                    p8.g g0 = TrendMagazineFragment.this.getTiaraDefaultBuilder();
                                                                                                                    H h0 = H.a;
                                                                                                                    if(g0 == null) {
                                                                                                                        return h0;
                                                                                                                    }
                                                                                                                    g0.a = TrendMagazineFragment.this.getString(0x7F130DCA);  // string:tiara_common_action_name_mute "음소거"
                                                                                                                    g0.F = TrendMagazineFragment.this.getString(0x7F130D5C);  // string:tiara_click_copy_mute "음소거"
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
                                                                                                            return FlowKt.collectLatest(sharedFlow0, trendMagazineFragment$onViewCreated$5$1$10, this) == a0 ? a0 : H.a;
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
                                                                                            return f0.j(d0, s.e, trendMagazineFragment$onViewCreated$5$10, this) == a0 ? a0 : H.a;
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
    }

    private static final void onViewCreated$lambda$2(TrendMagazineFragment trendMagazineFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, View view0) {
        q.d(view0);
        trendMagazineFragment0.updateLike(view0, trendShortFormRes$Response$SLOTLIST0);
        n1 n10 = trendMagazineFragment0.viewBinding;
        if(n10 != null) {
            boolean z = n10.d.d.a;
            if(n10 != null) {
                String s = z ? trendMagazineFragment0.getString(0x7F130D22) : trendMagazineFragment0.getString(0x7F130D41);  // string:tiara_click_copy_dislike "좋아요 취소"
                q.d(s);
                p8.g g0 = trendMagazineFragment0.getTiaraDefaultBuilder();
                if(g0 == null) {
                    return;
                }
                g0.a = trendMagazineFragment0.getString(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
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
                g0.U = trendMagazineFragment0.getString((z ? 0x7F130FCC : 0x7F130FCD));  // string:tiara_props_dislike "dislike"
                g0.a().track();
                return;
            }
            q.m("viewBinding");
            throw null;
        }
        q.m("viewBinding");
        throw null;
    }

    private static final void onViewCreated$lambda$4(TrendMagazineFragment trendMagazineFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, View view0) {
        TrendShortFormViewModel trendShortFormViewModel0 = trendMagazineFragment0.getViewModel();
        int v = ProtocolUtils.parseInt(trendShortFormRes$Response$SLOTLIST0.CmtChnlSeq, 0);
        String s = trendShortFormRes$Response$SLOTLIST0.contsId;
        q.f(s, "contsId");
        trendShortFormViewModel0.showCommentPopup(new BbsParam(null, v, s, 1, null));
        p8.g g0 = trendMagazineFragment0.getTiaraDefaultBuilder();
        if(g0 == null) {
            return;
        }
        g0.a = trendMagazineFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        g0.F = trendMagazineFragment0.getString(0x7F130D16);  // string:tiara_click_copy_comment_move "댓글보기"
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

    private static final void onViewCreated$lambda$6(SLOTLIST trendShortFormRes$Response$SLOTLIST0, TrendMagazineFragment trendMagazineFragment0, View view0) {
        MelonLinkExecutor.open(MelonLinkInfo.b(trendShortFormRes$Response$SLOTLIST0.banner));
        p8.g g0 = trendMagazineFragment0.getTiaraDefaultBuilder();
        if(g0 == null) {
            return;
        }
        g0.a = trendMagazineFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        g0.d = ActionKind.ClickContent;
        g0.B = trendShortFormRes$Response$SLOTLIST0.banner.scheme;
        g0.F = trendMagazineFragment0.getString(0x7F130D07);  // string:tiara_click_copy_banner_move "배너이동"
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

    private final void updateBannerBackground(int v) {
        n1 n10 = this.viewBinding;
        if(n10 != null) {
            n10.b.setBackgroundColor(v);
            n1 n11 = this.viewBinding;
            if(n11 != null) {
                n11.d.h.setBackgroundColor(v);
                return;
            }
            q.m("viewBinding");
            throw null;
        }
        q.m("viewBinding");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendShortBaseFragment
    public void updateCommentCountView(int v) {
        n1 n10 = this.viewBinding;
        if(n10 != null) {
            String s = StringUtils.INSTANCE.getFormattedStringNumberWithoutPlus(String.valueOf(v), 0xF423F);
            n10.d.e.setText(s);
            return;
        }
        q.m("viewBinding");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendShortBaseFragment
    public void updateLikeView(int v, boolean z) {
        n1 n10 = this.viewBinding;
        if(n10 != null) {
            n10.d.d.setChecked(z);
            n1 n11 = this.viewBinding;
            if(n11 != null) {
                String s = StringUtils.INSTANCE.getFormattedStringNumberWithoutPlus(String.valueOf(v), 0xF423F);
                n11.d.l.setText(s);
                return;
            }
            q.m("viewBinding");
            throw null;
        }
        q.m("viewBinding");
        throw null;
    }
}

