package com.melon.ui.playermusic;

import Ac.Z1;
import J8.q1;
import Q0.t0;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.P0;
import com.iloen.melon.custom.h0;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import com.iloen.melon.types.ContextItemInfo;
import com.iloen.melon.types.ContextItemType;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.SongMetaParser;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.h;
import d3.g;
import e.k;
import ed.w0;
import hd.i;
import i.n.i.b.a.s.e.I2;
import ie.r;
import j3.n;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import m0.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.e;
import qb.I;
import td.D1;
import td.F1;
import td.H1;
import td.I1;
import td.c;
import td.w1;
import td.x1;
import td.y1;
import wc.u;
import we.a;
import y0.s;
import zd.s0;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0003\u001023B\'\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000F\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000ER$\u0010\u0017\u001A\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001F\u001A\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\u001B\u0010%\u001A\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001A\u0004\b#\u0010$R\"\u0010-\u001A\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\'\u0010(\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u00101\u001A\u00020.8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/melon/ui/playermusic/PlayerMoreView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LJ8/q1;", "E", "LJ8/q1;", "getBinding", "()LJ8/q1;", "binding", "Ltd/F1;", "M", "Ltd/F1;", "getOnEventListener", "()Ltd/F1;", "setOnEventListener", "(Ltd/F1;)V", "onEventListener", "Lcom/iloen/melon/playback/Playable;", "N", "Lcom/iloen/melon/playback/Playable;", "getPlayable", "()Lcom/iloen/melon/playback/Playable;", "setPlayable", "(Lcom/iloen/melon/playback/Playable;)V", "playable", "Lcom/melon/ui/playermusic/PlayerViewCalculator;", "T", "Lie/j;", "getPlayerViewCalculator", "()Lcom/melon/ui/playermusic/PlayerViewCalculator;", "playerViewCalculator", "Lqb/I;", "b0", "Lqb/I;", "getMoreUseCase", "()Lqb/I;", "setMoreUseCase", "(Lqb/I;)V", "moreUseCase", "Lkotlinx/coroutines/CoroutineScope;", "getVisibleScope", "()Lkotlinx/coroutines/CoroutineScope;", "visibleScope", "td/D1", "td/E1", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlayerMoreView extends c {
    public final String B;
    public final b0 D;
    public final q1 E;
    public Point G;
    public boolean I;
    public F1 M;
    public Playable N;
    public final D1 S;
    public final r T;
    public AnimatorSet V;
    public CompletableJob W;
    public I b0;
    public final I1 c0;
    public final boolean d0;
    public final n e0;
    public static final int f0;
    public final LogU w;

    public PlayerMoreView(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 6, 0);
    }

    public PlayerMoreView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 4, 0);
    }

    public PlayerMoreView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        this.w = new LogU("PlayerMoreView");
        this.B = "1000002908";
        this.D = w.s(Boolean.FALSE);
        LayoutInflater.from(context0).inflate(0x7F0D043F, this);  // layout:layout_player_more
        int v1 = 0x7F0A008D;  // id:album_shadow
        ImageView imageView0 = (ImageView)De.I.C(this, 0x7F0A008D);  // id:album_shadow
        if(imageView0 != null) {
            v1 = 0x7F0A00B9;  // id:artist_name_more
            MelonTextView melonTextView0 = (MelonTextView)De.I.C(this, 0x7F0A00B9);  // id:artist_name_more
            if(melonTextView0 != null) {
                v1 = 0x7F0A0118;  // id:bottom_container
                LinearLayout linearLayout0 = (LinearLayout)De.I.C(this, 0x7F0A0118);  // id:bottom_container
                if(linearLayout0 != null) {
                    v1 = 0x7F0A013B;  // id:btn_add
                    ImageView imageView1 = (ImageView)De.I.C(this, 0x7F0A013B);  // id:btn_add
                    if(imageView1 != null) {
                        v1 = 0x7F0A015C;  // id:btn_download
                        ImageView imageView2 = (ImageView)De.I.C(this, 0x7F0A015C);  // id:btn_download
                        if(imageView2 != null) {
                            v1 = 0x7F0A016F;  // id:btn_like
                            ImageView imageView3 = (ImageView)De.I.C(this, 0x7F0A016F);  // id:btn_like
                            if(imageView3 != null) {
                                v1 = 0x7F0A01B7;  // id:btn_share
                                ImageView imageView4 = (ImageView)De.I.C(this, 0x7F0A01B7);  // id:btn_share
                                if(imageView4 != null) {
                                    v1 = 0x7F0A01B8;  // id:btn_share_insta
                                    ImageView imageView5 = (ImageView)De.I.C(this, 0x7F0A01B8);  // id:btn_share_insta
                                    if(imageView5 != null) {
                                        v1 = 0x7F0A02CA;  // id:close_btn
                                        LinearLayout linearLayout1 = (LinearLayout)De.I.C(this, 0x7F0A02CA);  // id:close_btn
                                        if(linearLayout1 != null && ((ConstraintLayout)De.I.C(this, 0x7F0A033D)) != null) {  // id:content_view
                                            v1 = 0x7F0A0341;  // id:context_items_recycler_view
                                            RecyclerView recyclerView0 = (RecyclerView)De.I.C(this, 0x7F0A0341);  // id:context_items_recycler_view
                                            if(recyclerView0 != null) {
                                                v1 = 0x7F0A03FE;  // id:dummy_view
                                                View view0 = De.I.C(this, 0x7F0A03FE);  // id:dummy_view
                                                if(view0 != null) {
                                                    v1 = 0x7F0A040A;  // id:edge_gradient_view
                                                    ComposeView composeView0 = (ComposeView)De.I.C(this, 0x7F0A040A);  // id:edge_gradient_view
                                                    if(composeView0 != null) {
                                                        v1 = 0x7F0A06A5;  // id:iv_thumbnail
                                                        MelonImageView melonImageView0 = (MelonImageView)De.I.C(this, 0x7F0A06A5);  // id:iv_thumbnail
                                                        if(melonImageView0 != null) {
                                                            v1 = 0x7F0A06A8;  // id:iv_thumbnail_container
                                                            RelativeLayout relativeLayout0 = (RelativeLayout)De.I.C(this, 0x7F0A06A8);  // id:iv_thumbnail_container
                                                            if(relativeLayout0 != null) {
                                                                v1 = 0x7F0A0765;  // id:like_count
                                                                MelonTextView melonTextView1 = (MelonTextView)De.I.C(this, 0x7F0A0765);  // id:like_count
                                                                if(melonTextView1 != null && ((Flow)De.I.C(this, 0x7F0A0802)) != null) {  // id:mid_5_buttons_flow
                                                                    v1 = 0x7F0A0803;  // id:mid_button_container
                                                                    ConstraintLayout constraintLayout0 = (ConstraintLayout)De.I.C(this, 0x7F0A0803);  // id:mid_button_container
                                                                    if(constraintLayout0 != null) {
                                                                        v1 = 0x7F0A0805;  // id:mid_info_container
                                                                        LinearLayout linearLayout2 = (LinearLayout)De.I.C(this, 0x7F0A0805);  // id:mid_info_container
                                                                        if(linearLayout2 != null) {
                                                                            v1 = 0x7F0A080F;  // id:mixup_button
                                                                            RelativeLayout relativeLayout1 = (RelativeLayout)De.I.C(this, 0x7F0A080F);  // id:mixup_button
                                                                            if(relativeLayout1 != null && ((RelativeLayout)De.I.C(this, 0x7F0A09D2)) != null) {  // id:recycler_view_spacer
                                                                                v1 = 0x7F0A0A2F;  // id:scroll_view
                                                                                NestedScrollView nestedScrollView0 = (NestedScrollView)De.I.C(this, 0x7F0A0A2F);  // id:scroll_view
                                                                                if(nestedScrollView0 != null && ((MelonImageView)De.I.C(this, 0x7F0A0A97)) != null) {  // id:small_album_view_default
                                                                                    v1 = 0x7F0A0AB0;  // id:song_name_more
                                                                                    MelonTextView melonTextView2 = (MelonTextView)De.I.C(this, 0x7F0A0AB0);  // id:song_name_more
                                                                                    if(melonTextView2 != null) {
                                                                                        v1 = 0x7F0A0ABC;  // id:sound_iv
                                                                                        ImageView imageView6 = (ImageView)De.I.C(this, 0x7F0A0ABC);  // id:sound_iv
                                                                                        if(imageView6 != null) {
                                                                                            v1 = 0x7F0A0BCE;  // id:top_container
                                                                                            LinearLayout linearLayout3 = (LinearLayout)De.I.C(this, 0x7F0A0BCE);  // id:top_container
                                                                                            if(linearLayout3 != null) {
                                                                                                q1 q10 = new q1(this, imageView0, melonTextView0, linearLayout0, imageView1, imageView2, imageView3, imageView4, imageView5, linearLayout1, recyclerView0, view0, composeView0, melonImageView0, relativeLayout0, melonTextView1, constraintLayout0, linearLayout2, relativeLayout1, nestedScrollView0, melonTextView2, imageView6, linearLayout3);
                                                                                                composeView0.setViewCompositionStrategy(t0.c);
                                                                                                composeView0.setContent(new b(0x25F84293, new y1(this), true));
                                                                                                this.E = q10;
                                                                                                D1 d10 = new D1(new i(this, 23));
                                                                                                this.S = d10;
                                                                                                this.T = g.Q(new h0(context0, 4));
                                                                                                this.c0 = new I1(CoroutineExceptionHandler.Key, this);
                                                                                                this.d0 = MelonSettingInfo.isLowMemoryMode();
                                                                                                this.setBackgroundColor(ColorUtils.getColor(context0, 0x7F06003C));  // color:black_40
                                                                                                recyclerView0.setLayoutManager(new LinearLayoutManager(recyclerView0.getContext()));
                                                                                                recyclerView0.setAdapter(d10);
                                                                                                view0.addOnLayoutChangeListener(new P0(this, 4));
                                                                                                imageView6.setOnClickListener(new w1(this, 2));
                                                                                                imageView1.setOnClickListener(new w1(this, 3));
                                                                                                imageView2.setOnClickListener(new w1(this, 4));
                                                                                                imageView3.setOnClickListener(new w1(this, 5));
                                                                                                imageView4.setOnClickListener(new w1(this, 6));
                                                                                                imageView5.setOnClickListener(new w1(this, 0));
                                                                                                relativeLayout1.setOnClickListener(new w1(this, 1));
                                                                                                this.e0 = new n(this, 11);
                                                                                                return;
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
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + this.getResources().getResourceName(v1));
    }

    public PlayerMoreView(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0, 0);
    }

    public static void c(PlayerMoreView playerMoreView0, ValueAnimator valueAnimator0) {
        q.g(valueAnimator0, "it");
        Object object0 = valueAnimator0.getAnimatedValue();
        q.e(object0, "null cannot be cast to non-null type kotlin.Int");
        int v = (int)(((Integer)object0));
        RelativeLayout relativeLayout0 = playerMoreView0.E.j;
        q.f(relativeLayout0, "ivThumbnailContainer");
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = relativeLayout0.getLayoutParams();
        if(viewGroup$LayoutParams0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        viewGroup$LayoutParams0.width = v;
        viewGroup$LayoutParams0.height = v;
        relativeLayout0.setLayoutParams(viewGroup$LayoutParams0);
        int v1 = playerMoreView0.getPlayerViewCalculator().a(v);
        ImageView imageView0 = playerMoreView0.E.b;
        q.f(imageView0, "albumShadow");
        ViewGroup.LayoutParams viewGroup$LayoutParams1 = imageView0.getLayoutParams();
        if(viewGroup$LayoutParams1 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        viewGroup$LayoutParams1.width = v1;
        viewGroup$LayoutParams1.height = v1;
        imageView0.setLayoutParams(viewGroup$LayoutParams1);
    }

    public static void d(PlayerMoreView playerMoreView0, int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7) {
        LogU.debug$default(playerMoreView0.w, "scrollView OnLayoutChangeListener()", null, false, 6, null);
        int v8 = v2 - v;
        int v9 = v3 - v1;
        if(v8 == v6 - v4 && v9 == v7 - v5) {
            return;
        }
        playerMoreView0.G = new Point(v8, v9);
        LogU.debug$default(playerMoreView0.w, "screenSizeChanged()", null, false, 6, null);
        LinearLayout linearLayout0 = playerMoreView0.E.q;
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = linearLayout0.getLayoutParams();
        if(viewGroup$LayoutParams0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        viewGroup$LayoutParams0.height = playerMoreView0.getPlayerViewCalculator().c();
        linearLayout0.setLayoutParams(viewGroup$LayoutParams0);
        playerMoreView0.post(new x1(playerMoreView0, new e(17), 0));
    }

    public static void e(PlayerMoreView playerMoreView0, a a0) {
        boolean z = playerMoreView0.isAttachedToWindow();
        q1 q10 = playerMoreView0.E;
        if(!z) {
            return;
        }
        int v = playerMoreView0.S.getItemCount();
        LogU.debug$default(playerMoreView0.w, "updateThumbSize() menuItemCount:" + v, null, false, 6, null);
        int v1 = playerMoreView0.i(v);
        int v2 = playerMoreView0.getPlayerViewCalculator().a(v1);
        AnimatorSet animatorSet0 = playerMoreView0.V;
        if(animatorSet0 != null) {
            animatorSet0.cancel();
        }
        RelativeLayout relativeLayout0 = q10.j;
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = relativeLayout0.getLayoutParams();
        if(viewGroup$LayoutParams0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        viewGroup$LayoutParams0.width = v1;
        viewGroup$LayoutParams0.height = v1;
        relativeLayout0.setLayoutParams(viewGroup$LayoutParams0);
        ImageView imageView0 = q10.b;
        ViewGroup.LayoutParams viewGroup$LayoutParams1 = imageView0.getLayoutParams();
        if(viewGroup$LayoutParams1 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        viewGroup$LayoutParams1.width = v2;
        viewGroup$LayoutParams1.height = v2;
        imageView0.setLayoutParams(viewGroup$LayoutParams1);
        playerMoreView0.k();
        a0.invoke();
    }

    public static void f(Playable playable0, PlayerMoreView playerMoreView0, ArrayList arrayList0) {
        if(playable0.isTypeOfSong()) {
            BuildersKt__Builders_commonKt.launch$default(playerMoreView0.getVisibleScope(), SupervisorKt.SupervisorJob$default(null, 1, null).plus(playerMoreView0.c0), null, new H1(playerMoreView0, playable0, arrayList0, null), 2, null);
        }
    }

    public final void g(l l0, int v) {
        ((p)l0).c0(0xC6E89672);
        if(((p)l0).Q(v & 1, (v & 1) != 0)) {
            M.p.a(androidx.compose.foundation.q.e(d.h(d.f(r0.n.a, 1.0f), 90.0f), u.f(k.A(new s[]{new s(s.f), new s(0xFF0A0A0A00000000L)}), 0.0f, 0.0f, 14), null, 6), ((p)l0), 6);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new y1(this, v);
        }
    }

    @NotNull
    public final q1 getBinding() {
        return this.E;
    }

    @NotNull
    public final I getMoreUseCase() {
        I i0 = this.b0;
        if(i0 != null) {
            return i0;
        }
        q.m("moreUseCase");
        throw null;
    }

    @Nullable
    public final F1 getOnEventListener() {
        return this.M;
    }

    @Nullable
    public final Playable getPlayable() {
        return this.N;
    }

    private final PlayerViewCalculator getPlayerViewCalculator() {
        return (PlayerViewCalculator)this.T.getValue();
    }

    private final CoroutineScope getVisibleScope() {
        MainCoroutineDispatcher mainCoroutineDispatcher0 = Dispatchers.getMain();
        CompletableJob completableJob0 = this.W;
        if(completableJob0 != null) {
            return CoroutineScopeKt.CoroutineScope(mainCoroutineDispatcher0.plus(completableJob0));
        }
        q.m("job");
        throw null;
    }

    public final void h(boolean z, boolean z1, h h0) {
        if(this.d0) {
            z = false;
        }
        if(this.I) {
            MelonAppBase.Companion.getClass();
            t.a().getRequestQueue().cancelAll("PlayerMoreView");
            CompletableJob completableJob0 = this.W;
            if(completableJob0 != null) {
                completableJob0.cancel(new CancellationException("PlayerMoreView closed."));
                AnimatorSet animatorSet0 = this.V;
                if(animatorSet0 != null) {
                    animatorSet0.cancel();
                }
                this.I = false;
                if(z) {
                    int v = this.getPlayerViewCalculator().b(this.G);
                    if(v < 1) {
                        v = 1;
                    }
                    PlayerMoreView.m(this, v, (z1 ? 1.0f : 0.0f), new w0(29, this, h0));
                    return;
                }
                this.E.n.scrollTo(0, 0);
                this.setVisibility(4);
                this.E.n.setOnScrollChangeListener(null);
                this.k();
                h0.invoke();
                return;
            }
            q.m("job");
            throw null;
        }
    }

    public final int i(int v) {
        int v6;
        je.w w0;
        LogU.debug$default(this.w, "getThumbSize() menuItemCount:" + v, null, false, 6, null);
        float f = this.getResources().getDimension(0x7F070412);  // dimen:player_more_menu_item_height
        int v1 = this.E.n.getMeasuredHeight();
        int v2 = this.E.q.getMeasuredHeight();
        int v3 = this.E.m.getMeasuredHeight();
        ConstraintLayout constraintLayout0 = this.E.l;
        boolean z = false;
        int v4 = constraintLayout0.getVisibility() == 0 ? constraintLayout0.getMeasuredHeight() : 0;
        int v5 = this.E.d.getMeasuredHeight();
        I i0 = this.getMoreUseCase();
        Playable playable0 = this.N;
        i0.getClass();
        if(playable0 == null) {
            w0 = je.w.a;
        }
        else {
            w0 = new ArrayList();
            boolean z1 = playable0.isOriginMelon();
            boolean z2 = playable0.isMelonSong() && playable0.hasSongId();
            boolean z3 = playable0.isOriginLocal() && playable0.hasLocalFile();
            boolean z4 = playable0.isAdult();
            boolean z5 = z2 && (z1 ? StringIds.a(playable0.getArtistid(), StringIds.e) : true);
            boolean z6 = PlayableExtensionsKt.isMvEnabled(playable0);
            ContextItemInfo contextItemInfo0 = new ContextItemInfo();
            contextItemInfo0.a = ContextItemType.h;
            contextItemInfo0.b = z2;
            ((ArrayList)w0).add(contextItemInfo0);
            ContextItemInfo contextItemInfo1 = new ContextItemInfo();
            contextItemInfo1.a = ContextItemType.i;
            contextItemInfo1.b = z2 && !z1;
            ((ArrayList)w0).add(contextItemInfo1);
            ContextItemInfo contextItemInfo2 = new ContextItemInfo();
            contextItemInfo2.a = ContextItemType.j;
            contextItemInfo2.b = z5;
            ((ArrayList)w0).add(contextItemInfo2);
            ContextItemInfo contextItemInfo3 = new ContextItemInfo();
            contextItemInfo3.a = ContextItemType.k;
            contextItemInfo3.b = z6;
            ((ArrayList)w0).add(contextItemInfo3);
            ContextItemInfo contextItemInfo4 = new ContextItemInfo();
            contextItemInfo4.a = ContextItemType.l;
            contextItemInfo4.b = z2;
            ((ArrayList)w0).add(contextItemInfo4);
            if(z3 && z2) {
                if(!playable0.isTypeOfSong() || !playable0.hasLocalFile()) {
                    v6 = 0;
                }
                else {
                    File file0 = SongMetaParser.getLyricFile(playable0);
                    v6 = file0 == null || !file0.exists() ? !TextUtils.isEmpty((StorageUtils.isScopedStorage() ? SongMetaParser.parseLyricCodeFromUri(Uri.parse("")) : SongMetaParser.parseLyricCodeFromFile(""))) : 0;
                }
                if(v6 != 0) {
                    ((ArrayList)w0).add(ContextItemInfo.a(ContextItemType.o));
                }
            }
            ContextItemInfo contextItemInfo5 = new ContextItemInfo();
            contextItemInfo5.a = ContextItemType.Q;
            if(z2 && !z4) {
                z = true;
            }
            contextItemInfo5.b = z;
            ((ArrayList)w0).add(contextItemInfo5);
        }
        int v7 = w0.size();
        if(v > v7) {
            v = v7;
        }
        int v8 = (int)(((float)(v1 - v2 - v3 - v4 - v5)) - f * ((float)v));
        int v9 = (int)(((float)this.getMeasuredWidth()) - this.getResources().getDimension(0x7F07040D) * 2.0f);  // dimen:player_horizontal_margin
        int v10 = ScreenUtils.dipToPixel(this.getContext(), 120.0f);
        if(v8 > v9) {
            v8 = v9;
        }
        return v8 >= v10 ? v8 : v10;
    }

    public final void j(Playable playable0, boolean z) {
        if(playable0 == null) {
            LogU.warn$default(this.w, "open() playable is null", null, false, 6, null);
            return;
        }
        LogU.debug$default(this.w, "open() isAlbumArtShowBeforeOpen:" + z, null, false, 6, null);
        if(!this.I) {
            this.W = JobKt__JobKt.Job$default(null, 1, null);
            AnimatorSet animatorSet0 = this.V;
            if(animatorSet0 != null) {
                animatorSet0.cancel();
            }
            this.I = true;
            this.N = playable0;
            int v = this.getPlayerViewCalculator().b(this.G);
            if(v < 1) {
                v = 1;
            }
            int v1 = this.getPlayerViewCalculator().a(v);
            q1 q10 = this.E;
            RelativeLayout relativeLayout0 = q10.j;
            ImageView imageView0 = q10.b;
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = relativeLayout0.getLayoutParams();
            if(viewGroup$LayoutParams0 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            viewGroup$LayoutParams0.width = v;
            viewGroup$LayoutParams0.height = v;
            relativeLayout0.setLayoutParams(viewGroup$LayoutParams0);
            ViewGroup.LayoutParams viewGroup$LayoutParams1 = imageView0.getLayoutParams();
            if(viewGroup$LayoutParams1 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            viewGroup$LayoutParams1.width = v1;
            viewGroup$LayoutParams1.height = v1;
            imageView0.setLayoutParams(viewGroup$LayoutParams1);
            q10.j.setAlpha((z ? 1.0f : 0.0f));
            imageView0.setAlpha((z ? 1.0f : 0.0f));
            ArrayList arrayList0 = new s0(playable0).c();
            this.l(arrayList0, new Z1(playable0, this, arrayList0, 26), true);
            this.setVisibility(0);
        }
    }

    public final void k() {
        boolean z = !this.I || this.V != null && this.V.isRunning() ? false : this.E.n.canScrollVertically(1);
        ((O0)this.D).setValue(Boolean.valueOf(z));
    }

    public final void l(ArrayList arrayList0, a a0, boolean z) {
        if(this.d0) {
            z = false;
        }
        D1 d10 = this.S;
        if(z) {
            d10.submitList(arrayList0, new I2(this, arrayList0, a0, 7));
            return;
        }
        d10.submitList(arrayList0, new x1(this, a0, 1));
    }

    public static void m(PlayerMoreView playerMoreView0, int v, float f, a a0) {
        playerMoreView0.getClass();
        playerMoreView0.post(new ed.r(playerMoreView0, v, f, a0));
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AnimatorSet animatorSet0 = this.V;
        if(animatorSet0 != null) {
            animatorSet0.cancel();
        }
        CompletableJob completableJob0 = this.W;
        if(completableJob0 != null) {
            completableJob0.cancel(new CancellationException("PlayerMoreView detachedFromWindow"));
        }
        this.E.n.setOnScrollChangeListener(null);
    }

    public final void setMoreUseCase(@NotNull I i0) {
        q.g(i0, "<set-?>");
        this.b0 = i0;
    }

    public final void setOnEventListener(@Nullable F1 f10) {
        this.M = f10;
    }

    public final void setPlayable(@Nullable Playable playable0) {
        this.N = playable0;
    }
}

