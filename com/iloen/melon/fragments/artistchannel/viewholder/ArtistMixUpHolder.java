package com.iloen.melon.fragments.artistchannel.viewholder;

import Cc.N1;
import Cc.e0;
import De.I;
import J8.m;
import M.c;
import M.n0;
import M.p0;
import N0.M;
import P0.h;
import P0.i;
import P0.j;
import P0.k;
import Q0.k0;
import Q0.t0;
import T.e;
import X0.u;
import X0.x;
import Zc.N;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.ComposeView;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import m0.b;
import org.jetbrains.annotations.NotNull;
import r0.n;
import we.a;
import we.o;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 \u00172\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000F\u001A\u00020\r2\u0006\u0010\u000B\u001A\u00020\n2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\fH\u0003¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001D\u0010\u0014\u001A\u00020\r2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMixUpHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/net/v6x/response/ArtistHomeBasicInfoRes$RESPONSE;", "LJ8/m;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "listener", "<init>", "(LJ8/m;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "", "text", "Lkotlin/Function0;", "Lie/H;", "onClick", "MixUpButton", "(Ljava/lang/String;Lwe/a;Landroidx/compose/runtime/l;I)V", "getTitleName", "()Ljava/lang/String;", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "LJ8/m;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistMixUpHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMixUpHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMixUpHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistMixUpHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D003B, viewGroup0, false);  // layout:artist_detail_mix_up
            if(view0 == null) {
                throw new NullPointerException("rootView");
            }
            return new ArtistMixUpHolder(new m(((ComposeView)view0), ((ComposeView)view0)), onViewHolderActionBaseListener0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "ArtistMixUpHolder";
    @NotNull
    private final m bind;

    static {
        ArtistMixUpHolder.Companion = new Companion(null);
        ArtistMixUpHolder.$stable = 8;
    }

    public ArtistMixUpHolder(@NotNull m m0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(m0, "bind");
        q.g(onViewHolderActionBaseListener0, "listener");
        super(m0, onViewHolderActionBaseListener0);
        this.bind = m0;
    }

    private final void MixUpButton(String s, a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0xE1D98181);
        int v1 = (v & 6) == 0 ? v | (p0.g(s) ? 4 : 2) : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(a0) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.a.l(d.t(d.f(n0, 1.0f), 3), 20.0f, 0.0f, 2);
            M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            r0.q q2 = r0.a.a(androidx.compose.foundation.q.f(d.h(d.f(n0, 1.0f), 48.0f), e0.T(p0, 0x7F060145), e.b(4.0f)), new o() {  // color:gray050s
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final r0.q invoke(r0.q q0, l l0, int v) {
                    q.g(q0, "$this$composed");
                    ((p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((p)l0).k(k0.i);
                    K.m m0 = ((p)l0).N();
                    if(m0 == androidx.compose.runtime.k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    X0.i i0 = new X0.i(a0);
                    com.iloen.melon.fragments.artistchannel.viewholder.ArtistMixUpHolder.MixUpButton.lambda.8..inlined.noRippleClickable-YQRRFTQ.default.1.1 artistMixUpHolder$MixUpButton$lambda$8$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(this.$onClick$inlined);
                            this.$onClick$inlined.invoke();
                        }
                    };
                    r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, null, 0, i0, artistMixUpHolder$MixUpButton$lambda$8$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            f f0 = p0.N();
            if(f0 == androidx.compose.runtime.k.a) {
                f0 = new f(2);
                p0.l0(f0);
            }
            r0.q q3 = X0.n.c(q2, false, f0);
            p0 p00 = n0.a(M.j.e, r0.d.k, p0, 54);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q4, h3);
            androidx.compose.foundation.q.c(I.Q(0x7F080154, p0, 6), null, null, null, null, 0.0f, null, p0, 0x30, 0x7C);  // drawable:btn_common_mixup_16
            c.d(p0, d.q(n0, 8.0f));
            N1.b(s, null, 0L, 0.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v1 & 14, 0xC30, 120830);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Ac.e(this, s, a0, v, 7);
        }
    }

    private static final H MixUpButton$lambda$8$lambda$6$lambda$5(x x0) {
        q.g(x0, "$this$semantics");
        u.k(x0, 0);
        return H.a;
    }

    private static final H MixUpButton$lambda$9(ArtistMixUpHolder artistMixUpHolder0, String s, a a0, int v, l l0, int v1) {
        artistMixUpHolder0.MixUpButton(s, a0, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return "";
    }

    @NotNull
    public static final ArtistMixUpHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return ArtistMixUpHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        String s;
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        boolean z = ProtocolUtils.parseBoolean(((RESPONSE)adapterInViewHolder$Row0.getItem()).repSongButton);
        Context context0 = this.getContext();
        if(context0 == null) {
            s = "";
        }
        else {
            s = context0.getString((z ? 0x7F130133 : 0x7F13011A));  // string:artist_detail_representative_song_mix_up "대표곡 믹스업"
            if(s == null) {
                s = "";
            }
        }
        this.bind.b.setViewCompositionStrategy(t0.d);
        b b0 = new b(0x114608F4, new Id.h(this, s, adapterInViewHolder$Row0, 11), true);
        this.bind.b.setContent(b0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private static final H onBindView$lambda$3(ArtistMixUpHolder artistMixUpHolder0, String s, AdapterInViewHolder.Row adapterInViewHolder$Row0, l l0, int v) {
        if(((p)l0).Q(v & 1, (v & 3) != 2)) {
            boolean z = ((p)l0).i(artistMixUpHolder0);
            boolean z1 = ((p)l0).i(adapterInViewHolder$Row0);
            N n0 = ((p)l0).N();
            if(z || z1 || n0 == androidx.compose.runtime.k.a) {
                n0 = new N(7, artistMixUpHolder0, adapterInViewHolder$Row0);
                ((p)l0).l0(n0);
            }
            artistMixUpHolder0.MixUpButton(s, n0, ((p)l0), 0);
            return H.a;
        }
        ((p)l0).T();
        return H.a;
    }

    private static final H onBindView$lambda$3$lambda$2$lambda$1(ArtistMixUpHolder artistMixUpHolder0, AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        p8.f f0 = artistMixUpHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistMixUpHolder0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            f0.d = ActionKind.PlayMusic;
            f0.y = artistMixUpHolder0.getString(0x7F130CD8);  // string:tiara_artist_layer1_artist_info "아티스트 정보"
            f0.F = artistMixUpHolder0.getString(0x7F13080C);  // string:play_mixup "믹스업"
            f0.e = ((RESPONSE)adapterInViewHolder$Row0.getItem()).artistId;
            f0.f = Y.i(ContsTypeCode.ARTIST_MIXUP, "code(...)");
            f0.g = ((RESPONSE)adapterInViewHolder$Row0.getItem()).artistName;
            f0.W = "1000003099";
            f0.a().track();
        }
        artistMixUpHolder0.getOnViewHolderActionListener().onPlayArtistMixUp();
        return H.a;
    }
}

