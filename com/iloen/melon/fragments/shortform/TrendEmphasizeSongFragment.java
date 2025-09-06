package com.iloen.melon.fragments.shortform;

import De.I;
import J8.m1;
import J8.r1;
import U4.F;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.n;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.s;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.comments.BbsParam;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.ResourceUtilsKt;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.SystemSettingUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.Meta.Builder;
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
import x1.a;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0019\u0010\f\u001A\u00020\u00062\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\rJ!\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u00122\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001D\u001A\u00020\u00062\u0006\u0010\u001A\u001A\u00020\u00042\u0006\u0010\u001C\u001A\u00020\u001BH\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010\u001F\u001A\u00020\u00062\u0006\u0010\u001A\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u001F\u0010\bJ\u000F\u0010 \u001A\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u0003J\u000F\u0010!\u001A\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\u0003R\u0018\u0010#\u001A\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001A\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\'R\u0016\u0010)\u001A\u00020(8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendEmphasizeSongFragment;", "Lcom/iloen/melon/fragments/shortform/TrendMusicPlayerBaseFragment;", "<init>", "()V", "", "color", "Lie/H;", "updateBannerBackground", "(I)V", "startBackgroundAnim", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "outState", "onSaveInstanceState", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "sumCount", "", "isLike", "updateLikeView", "(IZ)V", "updateCommentCountView", "onResume", "onPause", "Landroid/graphics/drawable/Animatable;", "animationDrawable", "Landroid/graphics/drawable/Animatable;", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "LJ8/m1;", "viewBinding", "LJ8/m1;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TrendEmphasizeSongFragment extends TrendMusicPlayerBaseFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendEmphasizeSongFragment$Companion;", "", "<init>", "()V", "TAG", "", "MIN_MEMORY_TO_PLAY_ANIM", "", "newInstance", "Lcom/iloen/melon/fragments/shortform/TrendEmphasizeSongFragment;", "position", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TrendEmphasizeSongFragment newInstance(int v) {
            TrendEmphasizeSongFragment trendEmphasizeSongFragment0 = new TrendEmphasizeSongFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putInt("argPosition", v);
            trendEmphasizeSongFragment0.setArguments(bundle0);
            return trendEmphasizeSongFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int MIN_MEMORY_TO_PLAY_ANIM = 500;
    @NotNull
    private static final String TAG = "TrendEmphasizeSongFragment";
    @Nullable
    private Animatable animationDrawable;
    @NotNull
    private final LogU log;
    private m1 viewBinding;

    static {
        TrendEmphasizeSongFragment.Companion = new Companion(null);
        TrendEmphasizeSongFragment.$stable = 8;
    }

    public TrendEmphasizeSongFragment() {
        LogU logU0 = new LogU("TrendEmphasizeSongFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.log = logU0;
    }

    public static void m(TrendEmphasizeSongFragment trendEmphasizeSongFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, View view0) {
        TrendEmphasizeSongFragment.onViewCreated$lambda$8(trendShortFormRes$Response$SLOTLIST0, trendEmphasizeSongFragment0, view0);
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
        View view0 = this.getLayoutInflater().inflate(0x7F0D02C7, viewGroup0, false);  // layout:fragment_trend_emphasize_song
        int v = 0x7F0A05F0;  // id:iv_animator
        View view1 = I.C(view0, 0x7F0A05F0);  // id:iv_animator
        if(((ImageView)view1) != null) {
            v = 0x7F0A0617;  // id:iv_cover
            View view2 = I.C(view0, 0x7F0A0617);  // id:iv_cover
            if(((ImageView)view2) != null && ((ImageView)I.C(view0, 0x7F0A0625)) != null) {  // id:iv_dim
                v = 0x7F0A0673;  // id:iv_primary_color
                View view3 = I.C(view0, 0x7F0A0673);  // id:iv_primary_color
                if(((ImageView)view3) != null) {
                    v = 0x7F0A069A;  // id:iv_thumb
                    View view4 = I.C(view0, 0x7F0A069A);  // id:iv_thumb
                    if(((MelonImageView)view4) != null) {
                        v = 0x7F0A0712;  // id:layout_contents
                        View view5 = I.C(view0, 0x7F0A0712);  // id:layout_contents
                        if(((ConstraintLayout)view5) != null && ((FrameLayout)I.C(view0, 0x7F0A074B)) != null) {  // id:layout_thumb
                            v = 0x7F0A0751;  // id:layout_trend_info
                            View view6 = I.C(view0, 0x7F0A0751);  // id:layout_trend_info
                            if(view6 != null) {
                                r1 r10 = r1.a(view6);
                                v = 0x7F0A0C12;  // id:tv_artist
                                View view7 = I.C(view0, 0x7F0A0C12);  // id:tv_artist
                                if(((MelonTextView)view7) != null) {
                                    v = 0x7F0A0D1B;  // id:tv_song_title
                                    View view8 = I.C(view0, 0x7F0A0D1B);  // id:tv_song_title
                                    if(((MelonTextView)view8) != null) {
                                        v = 0x7F0A0D34;  // id:tv_title
                                        View view9 = I.C(view0, 0x7F0A0D34);  // id:tv_title
                                        if(((MelonTextView)view9) != null) {
                                            this.viewBinding = new m1(((ConstraintLayout)view0), ((ImageView)view1), ((ImageView)view2), ((ImageView)view3), ((MelonImageView)view4), ((ConstraintLayout)view5), r10, ((MelonTextView)view7), ((MelonTextView)view8), ((MelonTextView)view9));
                                            q.f(((ConstraintLayout)view0), "getRoot(...)");
                                            return (ConstraintLayout)view0;
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
        this.startBackgroundAnim();
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
                Context context0 = this.getContext();
                if(context0 != null) {
                    com.iloen.melon.fragments.shortform.TrendEmphasizeSongFragment.onViewCreated.1.1 trendEmphasizeSongFragment$onViewCreated$1$10 = (com.iloen.melon.fragments.shortform.TrendEmphasizeSongFragment.onViewCreated.1.1)Glide.with(context0).load(trendShortFormRes$Response$SLOTLIST0.shapeImgUrl).into(new CustomTarget() {
                        @Override  // com.bumptech.glide.request.target.Target
                        public void onLoadCleared(Drawable drawable0) {
                        }

                        public void onResourceReady(Drawable drawable0, Transition transition0) {
                            q.g(drawable0, "d");
                            m1 m10 = TrendEmphasizeSongFragment.this.viewBinding;
                            if(m10 != null) {
                                m10.b.setImageDrawable(drawable0);
                                if(drawable0 instanceof Animatable) {
                                    TrendEmphasizeSongFragment.this.animationDrawable = (Animatable)drawable0;
                                    if(TrendEmphasizeSongFragment.this.getLifecycle().b() == s.e) {
                                        TrendEmphasizeSongFragment.this.startBackgroundAnim();
                                    }
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
                m1 m10 = this.viewBinding;
                if(m10 != null) {
                    ViewGroup.LayoutParams viewGroup$LayoutParams0 = m10.f.getLayoutParams();
                    ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0) : null;
                    int v = 0;
                    int v1 = viewGroup$MarginLayoutParams0 == null ? 0 : viewGroup$MarginLayoutParams0.bottomMargin;
                    float f = ResourceUtilsKt.getDimension(0x7F070057);  // dimen:bottom_tab_height
                    float f1 = (float)ScreenUtils.getScreenHeight(this.requireContext());
                    int v2 = ViewUtilsKt.dpToPx(0xFA);
                    n n0 = new n();
                    m1 m11 = this.viewBinding;
                    if(m11 != null) {
                        n0.f(m11.a);
                        m1 m12 = this.viewBinding;
                        if(m12 != null) {
                            n0.l(m12.f.getId()).e.d = -2;
                            m1 m13 = this.viewBinding;
                            if(m13 != null) {
                                n0.l(m13.f.getId()).e.b0 = (int)(f1 - (((float)(v2 * 2)) - (f + ((float)v1))));
                                m1 m14 = this.viewBinding;
                                if(m14 != null) {
                                    n0.b(m14.a);
                                    m1 m15 = this.viewBinding;
                                    if(m15 != null) {
                                        m15.j.setText(trendShortFormRes$Response$SLOTLIST0.title);
                                        m1 m16 = this.viewBinding;
                                        if(m16 != null) {
                                            m16.i.setText(trendShortFormRes$Response$SLOTLIST0.songName);
                                            m1 m17 = this.viewBinding;
                                            if(m17 != null) {
                                                String s = ProtocolUtils.getArtistNames(trendShortFormRes$Response$SLOTLIST0.artistlist);
                                                m17.h.setText(s);
                                                Glide.with(this.requireContext()).asBitmap().load(trendShortFormRes$Response$SLOTLIST0.albumImgLarge).into(new CustomTarget() {
                                                    @Override  // com.bumptech.glide.request.target.Target
                                                    public void onLoadCleared(Drawable drawable0) {
                                                    }

                                                    public void onResourceReady(Bitmap bitmap0, Transition transition0) {
                                                        q.g(bitmap0, "bitmap");
                                                        m1 m10 = TrendEmphasizeSongFragment.this.viewBinding;
                                                        if(m10 != null) {
                                                            m10.c.setImageBitmap(bitmap0);
                                                            m1 m11 = TrendEmphasizeSongFragment.this.viewBinding;
                                                            if(m11 != null) {
                                                                m11.e.setImageBitmap(bitmap0);
                                                                e e0 = new e(bitmap0);
                                                                e0.a = 24;
                                                                g g0 = e0.a().e;
                                                                if(g0 == null) {
                                                                    return;
                                                                }
                                                                int v = F.C(g0);
                                                                TrendEmphasizeSongFragment.this.updateBannerBackground(v);
                                                                return;
                                                            }
                                                            q.m("viewBinding");
                                                            throw null;
                                                        }
                                                        q.m("viewBinding");
                                                        throw null;
                                                    }

                                                    @Override  // com.bumptech.glide.request.target.Target
                                                    public void onResourceReady(Object object0, Transition transition0) {
                                                        this.onResourceReady(((Bitmap)object0), transition0);
                                                    }
                                                });
                                                m1 m18 = this.viewBinding;
                                                if(m18 != null) {
                                                    StringUtils stringUtils0 = StringUtils.INSTANCE;
                                                    String s1 = stringUtils0.getFormattedStringNumberWithoutPlus(trendShortFormRes$Response$SLOTLIST0.likeCnt, 0xF423F);
                                                    m18.g.l.setText(s1);
                                                    boolean z = ProtocolUtils.parseBoolean(trendShortFormRes$Response$SLOTLIST0.likeYn);
                                                    m1 m19 = this.viewBinding;
                                                    if(m19 != null) {
                                                        m19.g.d.setChecked(z);
                                                        m1 m110 = this.viewBinding;
                                                        if(m110 != null) {
                                                            String s2 = z ? this.getString(0x7F130B5C) : this.getString(0x7F130B5F);  // string:talkback_like_off "좋아요 취소"
                                                            m110.g.d.setContentDescription(s2);
                                                            m1 m111 = this.viewBinding;
                                                            if(m111 != null) {
                                                                b b0 = new b(this, trendShortFormRes$Response$SLOTLIST0, 0);
                                                                m111.g.d.setOnClickListener(b0);
                                                                m1 m112 = this.viewBinding;
                                                                if(m112 != null) {
                                                                    String s3 = stringUtils0.getFormattedStringNumberWithoutPlus(trendShortFormRes$Response$SLOTLIST0.cmtCnt, 0xF423F);
                                                                    m112.g.e.setText(s3);
                                                                    m1 m113 = this.viewBinding;
                                                                    if(m113 != null) {
                                                                        b b1 = new b(this, trendShortFormRes$Response$SLOTLIST0, 1);
                                                                        a.N(m113.g.c, b1);
                                                                        m1 m114 = this.viewBinding;
                                                                        if(m114 != null) {
                                                                            m114.g.p.setText(trendShortFormRes$Response$SLOTLIST0.subTitle);
                                                                            m1 m115 = this.viewBinding;
                                                                            if(m115 != null) {
                                                                                FrameLayout frameLayout0 = m115.g.i;
                                                                                if(!trendShortFormRes$Response$SLOTLIST0.banner.useImgUrl) {
                                                                                    v = 8;
                                                                                }
                                                                                frameLayout0.setVisibility(v);
                                                                                if(trendShortFormRes$Response$SLOTLIST0.banner.useImgUrl) {
                                                                                    RequestBuilder requestBuilder0 = Glide.with(this.requireContext()).load(trendShortFormRes$Response$SLOTLIST0.banner.imgUrl);
                                                                                    m1 m116 = this.viewBinding;
                                                                                    if(m116 != null) {
                                                                                        requestBuilder0.into(m116.g.g);
                                                                                        goto label_84;
                                                                                    }
                                                                                    q.m("viewBinding");
                                                                                    throw null;
                                                                                }
                                                                            label_84:
                                                                                m1 m117 = this.viewBinding;
                                                                                if(m117 != null) {
                                                                                    m117.g.n.setText(trendShortFormRes$Response$SLOTLIST0.banner.text);
                                                                                    m1 m118 = this.viewBinding;
                                                                                    if(m118 != null) {
                                                                                        m118.g.n.setHorizontallyScrolling(true);
                                                                                        m1 m119 = this.viewBinding;
                                                                                        if(m119 != null) {
                                                                                            m119.g.n.setSelected(true);
                                                                                            m1 m120 = this.viewBinding;
                                                                                            if(m120 != null) {
                                                                                                b b2 = new b(trendShortFormRes$Response$SLOTLIST0, this);
                                                                                                m120.g.h.setOnClickListener(b2);
                                                                                                D d0 = this.getViewLifecycleOwner();
                                                                                                q.f(d0, "getViewLifecycleOwner(...)");
                                                                                                BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new we.n(trendShortFormRes$Response$SLOTLIST0, null) {
                                                                                                    final SLOTLIST $slotItem;
                                                                                                    int label;

                                                                                                    {
                                                                                                        TrendEmphasizeSongFragment.this = trendEmphasizeSongFragment0;
                                                                                                        this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                                                                                                        super(2, continuation0);
                                                                                                    }

                                                                                                    @Override  // oe.a
                                                                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                                                                        return new com.iloen.melon.fragments.shortform.TrendEmphasizeSongFragment.onViewCreated.7(TrendEmphasizeSongFragment.this, this.$slotItem, continuation0);
                                                                                                    }

                                                                                                    @Override  // we.n
                                                                                                    public Object invoke(Object object0, Object object1) {
                                                                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                                                                    }

                                                                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                                                                        return ((com.iloen.melon.fragments.shortform.TrendEmphasizeSongFragment.onViewCreated.7)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                                                                    }

                                                                                                    @Override  // oe.a
                                                                                                    public final Object invokeSuspend(Object object0) {
                                                                                                        ne.a a0 = ne.a.a;
                                                                                                        switch(this.label) {
                                                                                                            case 0: {
                                                                                                                d5.n.D(object0);
                                                                                                                D d0 = TrendEmphasizeSongFragment.this.getViewLifecycleOwner();
                                                                                                                q.f(d0, "getViewLifecycleOwner(...)");
                                                                                                                com.iloen.melon.fragments.shortform.TrendEmphasizeSongFragment.onViewCreated.7.1 trendEmphasizeSongFragment$onViewCreated$7$10 = new we.n(this.$slotItem, null) {
                                                                                                                    final SLOTLIST $slotItem;
                                                                                                                    int label;

                                                                                                                    {
                                                                                                                        TrendEmphasizeSongFragment.this = trendEmphasizeSongFragment0;
                                                                                                                        this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                                                                                                                        super(2, continuation0);
                                                                                                                    }

                                                                                                                    @Override  // oe.a
                                                                                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                                                                                        return new com.iloen.melon.fragments.shortform.TrendEmphasizeSongFragment.onViewCreated.7.1(TrendEmphasizeSongFragment.this, this.$slotItem, continuation0);
                                                                                                                    }

                                                                                                                    @Override  // we.n
                                                                                                                    public Object invoke(Object object0, Object object1) {
                                                                                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                                                                                    }

                                                                                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                                                                                        return ((com.iloen.melon.fragments.shortform.TrendEmphasizeSongFragment.onViewCreated.7.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                                                                                    }

                                                                                                                    @Override  // oe.a
                                                                                                                    public final Object invokeSuspend(Object object0) {
                                                                                                                        ne.a a0 = ne.a.a;
                                                                                                                        switch(this.label) {
                                                                                                                            case 0: {
                                                                                                                                d5.n.D(object0);
                                                                                                                                SharedFlow sharedFlow0 = TrendEmphasizeSongFragment.this.getViewModel().getEtcEventFlow();
                                                                                                                                com.iloen.melon.fragments.shortform.TrendEmphasizeSongFragment.onViewCreated.7.1.1 trendEmphasizeSongFragment$onViewCreated$7$1$10 = new we.n(this.$slotItem, null) {
                                                                                                                                    final SLOTLIST $slotItem;
                                                                                                                                    Object L$0;
                                                                                                                                    int label;

                                                                                                                                    {
                                                                                                                                        TrendEmphasizeSongFragment.this = trendEmphasizeSongFragment0;
                                                                                                                                        this.$slotItem = trendShortFormRes$Response$SLOTLIST0;
                                                                                                                                        super(2, continuation0);
                                                                                                                                    }

                                                                                                                                    @Override  // oe.a
                                                                                                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                                                                                                        Continuation continuation1 = new com.iloen.melon.fragments.shortform.TrendEmphasizeSongFragment.onViewCreated.7.1.1(TrendEmphasizeSongFragment.this, this.$slotItem, continuation0);
                                                                                                                                        continuation1.L$0 = object0;
                                                                                                                                        return continuation1;
                                                                                                                                    }

                                                                                                                                    public final Object invoke(EtcEvent trendShortFormViewModel$EtcEvent0, Continuation continuation0) {
                                                                                                                                        return ((com.iloen.melon.fragments.shortform.TrendEmphasizeSongFragment.onViewCreated.7.1.1)this.create(trendShortFormViewModel$EtcEvent0, continuation0)).invokeSuspend(H.a);
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
                                                                                                                                        p8.g g0 = TrendEmphasizeSongFragment.this.getTiaraDefaultBuilder();
                                                                                                                                        H h0 = H.a;
                                                                                                                                        if(g0 == null) {
                                                                                                                                            return h0;
                                                                                                                                        }
                                                                                                                                        g0.a = TrendEmphasizeSongFragment.this.getString(0x7F130DCA);  // string:tiara_common_action_name_mute "음소거"
                                                                                                                                        g0.F = TrendEmphasizeSongFragment.this.getString(0x7F130D5C);  // string:tiara_click_copy_mute "음소거"
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
                                                                                                                                return FlowKt.collectLatest(sharedFlow0, trendEmphasizeSongFragment$onViewCreated$7$1$10, this) == a0 ? a0 : H.a;
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
                                                                                                                return f0.j(d0, s.e, trendEmphasizeSongFragment$onViewCreated$7$10, this) == a0 ? a0 : H.a;
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

    private static final void onViewCreated$lambda$4(TrendEmphasizeSongFragment trendEmphasizeSongFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, View view0) {
        q.d(view0);
        trendEmphasizeSongFragment0.updateLike(view0, trendShortFormRes$Response$SLOTLIST0);
        m1 m10 = trendEmphasizeSongFragment0.viewBinding;
        if(m10 != null) {
            boolean z = m10.g.d.a;
            if(m10 != null) {
                String s = z ? trendEmphasizeSongFragment0.getString(0x7F130D22) : trendEmphasizeSongFragment0.getString(0x7F130D41);  // string:tiara_click_copy_dislike "좋아요 취소"
                q.d(s);
                p8.g g0 = trendEmphasizeSongFragment0.getTiaraDefaultBuilder();
                if(g0 == null) {
                    return;
                }
                g0.a = trendEmphasizeSongFragment0.getString(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
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
                g0.U = trendEmphasizeSongFragment0.getString((z ? 0x7F130FCC : 0x7F130FCD));  // string:tiara_props_dislike "dislike"
                g0.a().track();
                return;
            }
            q.m("viewBinding");
            throw null;
        }
        q.m("viewBinding");
        throw null;
    }

    private static final void onViewCreated$lambda$6(TrendEmphasizeSongFragment trendEmphasizeSongFragment0, SLOTLIST trendShortFormRes$Response$SLOTLIST0, View view0) {
        TrendShortFormViewModel trendShortFormViewModel0 = trendEmphasizeSongFragment0.getViewModel();
        int v = ProtocolUtils.parseInt(trendShortFormRes$Response$SLOTLIST0.CmtChnlSeq, 0);
        String s = trendShortFormRes$Response$SLOTLIST0.contsId;
        q.f(s, "contsId");
        trendShortFormViewModel0.showCommentPopup(new BbsParam(null, v, s, 1, null));
        p8.g g0 = trendEmphasizeSongFragment0.getTiaraDefaultBuilder();
        if(g0 == null) {
            return;
        }
        g0.a = trendEmphasizeSongFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        g0.F = trendEmphasizeSongFragment0.getString(0x7F130D16);  // string:tiara_click_copy_comment_move "댓글보기"
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

    private static final void onViewCreated$lambda$8(SLOTLIST trendShortFormRes$Response$SLOTLIST0, TrendEmphasizeSongFragment trendEmphasizeSongFragment0, View view0) {
        MelonLinkExecutor.open(MelonLinkInfo.b(trendShortFormRes$Response$SLOTLIST0.banner));
        p8.g g0 = trendEmphasizeSongFragment0.getTiaraDefaultBuilder();
        if(g0 == null) {
            return;
        }
        g0.a = trendEmphasizeSongFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        g0.d = ActionKind.ClickContent;
        g0.B = trendShortFormRes$Response$SLOTLIST0.banner.scheme;
        g0.F = trendEmphasizeSongFragment0.getString(0x7F130D07);  // string:tiara_click_copy_banner_move "배너이동"
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

    private final void startBackgroundAnim() {
        if(this.animationDrawable == null || this.animationDrawable.isRunning()) {
            return;
        }
        if(SystemSettingUtils.getAvailMemoryMB(this.requireContext()) > 500L) {
            Animatable animatable0 = this.animationDrawable;
            if(animatable0 != null) {
                a.l(animatable0);
            }
        }
    }

    private final void updateBannerBackground(int v) {
        m1 m10 = this.viewBinding;
        if(m10 != null) {
            m10.d.setBackgroundColor(v);
            m1 m11 = this.viewBinding;
            if(m11 != null) {
                m11.g.h.setBackgroundColor(v);
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
        m1 m10 = this.viewBinding;
        if(m10 != null) {
            String s = StringUtils.INSTANCE.getFormattedStringNumberWithoutPlus(String.valueOf(v), 0xF423F);
            m10.g.e.setText(s);
            return;
        }
        q.m("viewBinding");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendShortBaseFragment
    public void updateLikeView(int v, boolean z) {
        m1 m10 = this.viewBinding;
        if(m10 != null) {
            m10.g.d.setChecked(z);
            m1 m11 = this.viewBinding;
            if(m11 != null) {
                String s = StringUtils.INSTANCE.getFormattedStringNumberWithoutPlus(String.valueOf(v), 0xF423F);
                m11.g.l.setText(s);
                return;
            }
            q.m("viewBinding");
            throw null;
        }
        q.m("viewBinding");
        throw null;
    }
}

