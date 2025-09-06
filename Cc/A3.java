package Cc;

import Ac.J;
import Ac.V;
import Bd.e;
import Dc.g;
import Dc.u;
import F.s;
import Ic.A0;
import Ld.q;
import O.j;
import O.w;
import P.F;
import R6.d;
import Vb.p0;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.b0;
import androidx.fragment.app.I;
import cd.l;
import cd.r;
import com.airbnb.lottie.compose.LottieAnimationState;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.ChartHeader;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart;
import com.iloen.melon.net.v6x.response.AlbumContentsListRes;
import com.iloen.melon.net.v6x.response.AlbumSongListRes;
import com.iloen.melon.net.v6x.response.PromotionContentsBannerRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.common.h;
import com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1;
import com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment;
import com.iloen.melon.player.playlist.tiara.MixUpPlaylistTiaraLogHelper;
import com.melon.ui.H1;
import com.melon.ui.I1;
import com.melon.ui.K1;
import com.melon.ui.M1;
import com.melon.ui.N1;
import com.melon.ui.c2;
import com.melon.ui.d1;
import com.melon.ui.e2;
import com.melon.ui.f2;
import com.melon.ui.h2;
import com.melon.ui.i2;
import com.melon.ui.k2;
import com.melon.ui.k3;
import com.melon.ui.q3;
import com.melon.ui.w1;
import com.melon.ui.x1;
import e1.m;
import gd.M6;
import gd.y1;
import ie.H;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import m0.b;
import p0.p;
import pc.c;
import q8.f;
import we.a;
import we.k;
import we.n;

public final class a3 implements k {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final Object g;

    public a3(Object object0, Object object1, Object object2, Object object3, Object object4, Object object5, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        this.e = object3;
        this.f = object4;
        this.g = object5;
        super();
    }

    public a3(ArrayList arrayList0, q q0, n n0, n n1, LottieCompositionResult lottieCompositionResult0, LottieAnimationState lottieAnimationState0) {
        this.a = 2;
        super();
        this.b = arrayList0;
        this.c = q0;
        this.g = n0;
        this.d = n1;
        this.e = lottieCompositionResult0;
        this.f = lottieAnimationState0;
    }

    public a3(List list0, K0 k00, b0 b00, CoroutineScope coroutineScope0, r r0, F f0) {
        this.a = 3;
        super();
        this.b = list0;
        this.d = k00;
        this.c = b00;
        this.e = coroutineScope0;
        this.f = r0;
        this.g = f0;
    }

    public a3(List list0, String s, String s1, a a0, k k0, b0 b00) {
        this.a = 7;
        super();
        this.b = list0;
        this.e = s;
        this.f = s1;
        this.g = a0;
        this.d = k0;
        this.c = b00;
    }

    public a3(p p0, u u0, g g0, MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0, MixUpPlaylistComposeFragment.getClickListener.1 mixUpPlaylistComposeFragment$getClickListener$10, O.F f0) {
        this.a = 4;
        super();
        this.b = p0;
        this.c = u0;
        this.d = g0;
        this.e = mixUpPlaylistComposeFragment0;
        this.g = mixUpPlaylistComposeFragment$getClickListener$10;
        this.f = f0;
    }

    public a3(k k0, List list0, String s, I i0, String s1, a a0) {
        this.a = 6;
        super();
        this.d = k0;
        this.b = list0;
        this.c = s;
        this.e = i0;
        this.f = s1;
        this.g = a0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        String s = "";
        H h0 = H.a;
        Object object1 = this.b;
        Object object2 = this.g;
        Object object3 = this.f;
        Object object4 = this.e;
        Object object5 = this.d;
        Object object6 = this.c;
        switch(this.a) {
            case 0: {
                kotlin.jvm.internal.q.g(((w)object0), "$this$MelonLazyRow");
                J j0 = new J(5, new Ac.F(9), this.b);
                V v0 = new V(this.b, 2);
                b b0 = new b(0xBEF78951, new f3(((List)this.b), ((b0)object6), ((k)object5), ((CoroutineScope)object4), ((O.F)object3), 0), true);
                ((j)(((w)object0))).u(((List)this.b).size(), j0, v0, b0);
                w.a(((w)object0), new b(-330981030, new e(((n)object2), 4), true));
                return h0;
            }
            case 1: {
                return A0.o(((kotlin.jvm.internal.H)object1), ((kotlin.jvm.internal.H)object6), ((AlbumSongListRes)object5), ((A0)object4), ((AlbumContentsListRes)object3), ((PromotionContentsBannerRes)object2), ((d1)object0));
            }
            case 2: {
                kotlin.jvm.internal.q.g(((w)object0), "$this$MelonLazyColumn");
                w.a(((w)object0), new b(0x7B471F0D, new e(((q)object6), 7), true));
                ((j)(((w)object0))).u(((ArrayList)object1).size(), new Ld.p(0, new Ac.F(24), ((ArrayList)object1)), new s(3, ((ArrayList)object1)), new b(0xBEF78951, new f3(((ArrayList)object1), ((n)object2), ((n)object5), ((LottieCompositionResult)object4), ((LottieAnimationState)object3), 1), true));
                return h0;
            }
            case 3: {
                int v1 = (int)(((Integer)object0));
                Chart mainMusicRes$RESPONSE$MELONCHART$Chart0 = (Chart)((List)object1).get(v1);
                if(mainMusicRes$RESPONSE$MELONCHART$Chart0 != null) {
                    ((K0)object5).n(v1);
                    ChartHeader mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0 = mainMusicRes$RESPONSE$MELONCHART$Chart0.getHeader();
                    if(mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0 != null) {
                        String s1 = mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0.subTitle;
                        if(s1 != null) {
                            s = s1;
                        }
                    }
                    ((b0)object6).setValue(s);
                    BuildersKt__Builders_commonKt.launch$default(((CoroutineScope)object4), null, null, new l(((F)object2), null), 3, null);
                    cd.u u0 = new cd.u(mainMusicRes$RESPONSE$MELONCHART$Chart0);
                    ((r)object3).c.invoke(u0);
                }
                return h0;
            }
            case 4: {
                kotlin.jvm.internal.q.g(((w)object0), "$this$LazyColumn");
                h h1 = new h(12);
                h h2 = new h(13);
                ((j)(((w)object0))).u(((p)object1).size(), new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.lambda.62.lambda.55.lambda.54.lambda.53.lambda.52..inlined.items.1(h1, ((p)object1)), new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.lambda.62.lambda.55.lambda.54.lambda.53.lambda.52..inlined.items.2(h2, ((p)object1)), new b(0xDA480CDF, new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.lambda.62.lambda.55.lambda.54.lambda.53.lambda.52..inlined.items.3(((p)object1), ((u)object6), ((g)object5), ((MixUpPlaylistComposeFragment)object4), ((MixUpPlaylistComposeFragment.getClickListener.1)object2), ((O.F)object3)), true));
                return h0;
            }
            case 5: {
                kotlin.jvm.internal.q.g(((k2)object0), "event");
                if(((k2)object0) instanceof I1 || ((k2)object0) instanceof f2 || ((k2)object0) instanceof w1 || ((k2)object0) instanceof x1 || ((k2)object0) instanceof N1 || ((k2)object0) instanceof c2 || ((k2)object0) instanceof h2 || ((k2)object0) instanceof e2 || ((k2)object0) instanceof H1) {
                    ((d)object1).x(((I)object6), ((k)object5), ((zd.A0)object4), ((k2)object0));
                }
                else {
                    if(((k2)object0) instanceof M1) {
                        ((d)object1).x(((I)object6), ((k)object5), ((zd.A0)object4), ((k2)object0));
                        ((d)object1).v(((I)object6).getContext(), ((String)object3), new p0(16, ((I)object6), ((Playable)object2)));
                        return h0;
                    }
                    if(((k2)object0) instanceof i2) {
                        ((d)object1).x(((I)object6), ((k)object5), ((zd.A0)object4), ((k2)object0));
                        ((k)object5).invoke(new Ed.a("songListTiktok"));
                        return h0;
                    }
                }
                return h0;
            }
            case 6: {
                kotlin.jvm.internal.q.g(((k2)object0), "moreListPopupOnEvent");
                if(((k2)object0) instanceof K1) {
                    switch(((K1)(((k2)object0))).b.a.ordinal()) {
                        case 24: {
                            if(((I)object4) instanceof k3) {
                                ((k)object5).invoke(new com.melon.ui.g(((List)object1), ((String)object3)));
                            }
                            break;
                        }
                        case 25: {
                            ((k)object5).invoke(new q3("M20001", ((List)object1), ((String)object6)));
                            break;
                        }
                        case 27: {
                            ((k)object5).invoke(new q3("M20002", ((List)object1), ((String)object6)));
                        }
                    }
                }
                if(((a)object2) != null) {
                    ((a)object2).invoke();
                }
                return h0;
            }
            case 7: {
                kotlin.jvm.internal.q.g(((w)object0), "$this$MelonLazyColumn");
                ((j)(((w)object0))).u(((List)object1).size(), new y1(22, new M6(16), ((List)object1)), new hd.w(((List)object1), 8), new b(0xBEF78951, new kd.u(((List)object1), ((String)object4), ((String)object3), ((a)object2), ((k)object5), ((b0)object6)), true));
                return h0;
            }
            case 8: {
                kotlin.jvm.internal.q.g(((q8.d)object0), "$this$tiaraEventLogBuilder");
                ((MixUpPlaylistTiaraLogHelper)object1).c(((q8.d)object0));
                q8.b b1 = (q8.b)((q8.d)object0).c;
                if(b1 == null) {
                    q8.b b2 = new q8.b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b2.a(new m9.d(2));
                    ((q8.d)object0).c = b2;
                }
                else {
                    b1.a(new m9.d(2));
                }
                ((q8.d)object0).b(new m9.j(((MixUpPlaylistTiaraLogHelper)object1), ((String)object3), 5));
                ((MixUpPlaylistTiaraLogHelper)object1).e(((q8.d)object0), ((Playable)object6));
                ((q8.h)((q8.d)object0).b).a = ((MixUpPlaylistTiaraLogHelper)object1).a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                if(((c)object5) instanceof pc.a) {
                    f f0 = (f)((q8.d)object0).f;
                    if(f0 == null) {
                        f f1 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                        f1.a = ((pc.a)(((c)object5))).c;
                        f1.b = ((pc.a)(((c)object5))).d;
                        ((q8.d)object0).f = f1;
                    }
                    else {
                        f0.a = ((pc.a)(((c)object5))).c;
                        f0.b = ((pc.a)(((c)object5))).d;
                    }
                }
                ((q8.d)object0).e(new m9.k(3, ((Playable)object6)));
                ((MixUpPlaylistTiaraLogHelper)object1).f(((q8.d)object0), ((Playable)object6));
                ((MixUpPlaylistTiaraLogHelper)object1).d(((q8.d)object0), ((Playable)object4));
                LinkedHashMap linkedHashMap0 = (LinkedHashMap)((q8.d)object0).g;
                q8.c c0 = new q8.c();
                String s2 = ((od.a)object2) == null ? null : m.G(((od.a)object2));
                if(s2 != null) {
                    s = s2;
                }
                c0.a.put("Rangecode", s);
                linkedHashMap0.putAll(c0.a);
                return h0;
            }
            default: {
                return wc.w.o(((kotlin.jvm.internal.H)object1), ((kotlin.jvm.internal.H)object6), ((AlbumSongListRes)object5), ((wc.w)object4), ((AlbumContentsListRes)object3), ((PromotionContentsBannerRes)object2), ((d1)object0));
            }
        }
    }
}

