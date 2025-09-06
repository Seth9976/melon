package com.iloen.melon.player.playlist.drawernew.composable;

import Cc.c1;
import Fc.a;
import Hd.D;
import K.m;
import M.g;
import M.j;
import O.F;
import O.I;
import Q0.k0;
import X0.c;
import X0.i;
import X0.u;
import X0.x;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.V;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import com.iloen.melon.player.playlist.common.b;
import com.iloen.melon.player.playlist.drawernew.model.DrawerAlyac;
import ie.H;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.h;
import r0.n;
import r0.q;
import we.k;
import we.o;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001AK\u0010\f\u001A\u00020\n2\b\b\u0002\u0010\u0001\u001A\u00020\u00002\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00072\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lr0/q;", "modifier", "", "Lcom/iloen/melon/player/playlist/drawernew/model/DrawerAlyac;", "alyacList", "", "selectedAlyacKey", "", "isBottomSheet", "Lkotlin/Function1;", "Lie/H;", "onClickAlyac", "DrawerAlyacList", "(Lr0/q;Ljava/util/List;Ljava/lang/String;ZLwe/k;Landroidx/compose/runtime/l;II)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerAlyacListKt {
    public static final void DrawerAlyacList(@Nullable q q0, @NotNull List list0, @NotNull String s, boolean z, @NotNull k k0, @Nullable l l0, int v, int v1) {
        q q4;
        int v2;
        kotlin.jvm.internal.q.g(list0, "alyacList");
        kotlin.jvm.internal.q.g(s, "selectedAlyacKey");
        kotlin.jvm.internal.q.g(k0, "onClickAlyac");
        ((p)l0).c0(-1999717017);
        if((v1 & 1) == 0) {
            v2 = (v & 6) == 0 ? (((p)l0).g(q0) ? 4 : 2) | v : v;
        }
        else {
            v2 = v | 6;
        }
        if((v & 0x30) == 0) {
            v2 |= (((p)l0).i(list0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (((p)l0).g(s) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v2 |= (((p)l0).h(z) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v2 |= (((p)l0).i(k0) ? 0x4000 : 0x2000);
        }
        int v3 = 0;
        if(((p)l0).Q(v2 & 1, (v2 & 9363) != 9362)) {
            q q1 = (v1 & 1) == 0 ? q0 : n.a;
            F f0 = I.a(0, 0, 3, ((p)l0));
            q q2 = d.h(q1, 42.0f);
            boolean z1 = ((p)l0).i(list0);
            a a0 = ((p)l0).N();
            V v4 = androidx.compose.runtime.k.a;
            if(z1 || a0 == v4) {
                a0 = new a(list0, 6);
                ((p)l0).l0(a0);
            }
            q q3 = X0.n.c(q2, false, a0);
            g g0 = j.h(8.0f);
            h h0 = r0.d.k;
            boolean z2 = ((p)l0).i(list0);
            if((v2 & 0x1C00) == 0x800) {
                v3 = 1;
            }
            D d0 = ((p)l0).N();
            if((z2 | (v2 & 0x380) == 0x100 | ((0xE000 & v2) == 0x4000 ? 1 : 0) | v3) != 0 || d0 == v4) {
                D d1 = new D(list0, s, z, k0, 3);
                ((p)l0).l0(d1);
                d0 = d1;
            }
            c1.q(q3, f0, null, g0, h0, null, false, d0, ((p)l0), 0x36000, 204);
            q4 = q1;
        }
        else {
            ((p)l0).T();
            q4 = q0;
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new b(q4, list0, s, z, k0, v, v1);
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.drawernew.composable.DrawerAlyacListKt.DrawerAlyacList.2.1.1.2.1 implements k {
            public final int a;
            public final boolean b;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerAlyacListKt.DrawerAlyacList.2.1.1.2.1(int v, boolean z) {
                this.a = v;
                this.b = z;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((x)object0));
                return H.a;
            }

            public final void invoke(x x0) {
                kotlin.jvm.internal.q.g(x0, "$this$semantics");
                u.g(x0, new c(this.a, 1, 0, 1));
                u.l(x0, this.b);
                u.k(x0, 3);
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.playlist.drawernew.composable.DrawerAlyacListKt.DrawerAlyacList.lambda.6.lambda.5..inlined.itemsIndexed.default.1 extends r implements k {
            public final we.n f;
            public final List g;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerAlyacListKt.DrawerAlyacList.lambda.6.lambda.5..inlined.itemsIndexed.default.1(we.n n0, List list0) {
                this.f = n0;
                this.g = list0;
                super(1);
            }

            public final Object invoke(int v) {
                Object object0 = this.g.get(v);
                return this.f.invoke(v, object0);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Number)object0).intValue());
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.playlist.drawernew.composable.DrawerAlyacListKt.DrawerAlyacList.lambda.6.lambda.5..inlined.itemsIndexed.default.2 extends r implements k {
            public final List f;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerAlyacListKt.DrawerAlyacList.lambda.6.lambda.5..inlined.itemsIndexed.default.2(List list0) {
                this.f = list0;
                super(1);
            }

            public final Object invoke(int v) {
                this.f.get(v);
                return null;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Number)object0).intValue());
            }
        }


        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0002H\u000B¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Landroidx/compose/foundation/lazy/a;", "", "it", "Lie/H;", "invoke", "(Landroidx/compose/foundation/lazy/a;ILandroidx/compose/runtime/l;I)V", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.playlist.drawernew.composable.DrawerAlyacListKt.DrawerAlyacList.lambda.6.lambda.5..inlined.itemsIndexed.default.3 extends r implements we.p {
            public final List f;
            public final String g;
            public final boolean h;
            public final k i;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerAlyacListKt.DrawerAlyacList.lambda.6.lambda.5..inlined.itemsIndexed.default.3(List list0, String s, boolean z, k k0) {
                this.f = list0;
                this.g = s;
                this.h = z;
                this.i = k0;
                super(4);
            }

            @Override  // we.p
            public Object invoke(Object object0, Object object1, Object object2, Object object3) {
                this.invoke(((androidx.compose.foundation.lazy.a)object0), ((Number)object1).intValue(), ((l)object2), ((Number)object3).intValue());
                return H.a;
            }

            public final void invoke(androidx.compose.foundation.lazy.a a0, int v, l l0, int v1) {
                int v2 = (v1 & 6) == 0 ? v1 | (((p)l0).g(a0) ? 4 : 2) : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((p)l0).e(v) ? 0x20 : 16);
                }
                boolean z = true;
                if(((p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    Object object0 = this.f.get(v);
                    ((p)l0).a0(0x157BF6C1);
                    boolean z1 = kotlin.jvm.internal.q.b(((DrawerAlyac)object0).getKey(), this.g);
                    com.iloen.melon.player.playlist.drawernew.composable.DrawerAlyacListKt.DrawerAlyacList.lambda.6.lambda.5.lambda.4..inlined.noRippleClickable-YQRRFTQ.default.1 drawerAlyacListKt$DrawerAlyacList$lambda$6$lambda$5$lambda$4$$inlined$noRippleClickable-YQRRFTQ$default$10 = new com.iloen.melon.player.playlist.drawernew.composable.DrawerAlyacListKt.DrawerAlyacList.lambda.6.lambda.5.lambda.4..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0, z1, this.i, ((DrawerAlyac)object0));
                    q q0 = r0.a.a(n.a, drawerAlyacListKt$DrawerAlyacList$lambda$6$lambda$5$lambda$4$$inlined$noRippleClickable-YQRRFTQ$default$10);
                    if(((v2 & 0x70 ^ 0x30) <= 0x20 || !((p)l0).e(v)) && (v2 & 0x30) != 0x20) {
                        z = false;
                    }
                    boolean z2 = ((p)l0).h(z1);
                    com.iloen.melon.player.playlist.drawernew.composable.DrawerAlyacListKt.DrawerAlyacList.2.1.1.2.1 drawerAlyacListKt$DrawerAlyacList$2$1$1$2$10 = ((p)l0).N();
                    if(z2 || z || drawerAlyacListKt$DrawerAlyacList$2$1$1$2$10 == androidx.compose.runtime.k.a) {
                        drawerAlyacListKt$DrawerAlyacList$2$1$1$2$10 = new com.iloen.melon.player.playlist.drawernew.composable.DrawerAlyacListKt.DrawerAlyacList.2.1.1.2.1(v, z1);
                        ((p)l0).l0(drawerAlyacListKt$DrawerAlyacList$2$1$1$2$10);
                    }
                    DrawerAlyacKt.DrawerAlyac(X0.n.c(q0, false, drawerAlyacListKt$DrawerAlyacList$2$1$1$2$10), ((DrawerAlyac)object0).getTitle(), z1, this.h, ((p)l0), 0, 0);
                    ((p)l0).p(false);
                    return;
                }
                ((p)l0).T();
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.player.playlist.drawernew.composable.DrawerAlyacListKt.DrawerAlyacList.lambda.6.lambda.5.lambda.4..inlined.noRippleClickable-YQRRFTQ.default.1 implements o {
            public com.iloen.melon.player.playlist.drawernew.composable.DrawerAlyacListKt.DrawerAlyacList.lambda.6.lambda.5.lambda.4..inlined.noRippleClickable-YQRRFTQ.default.1(boolean z, String s, int v, boolean z1, k k0, DrawerAlyac drawerAlyac0) {
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
            }

            public final q invoke(q q0, l l0, int v) {
                kotlin.jvm.internal.q.g(q0, "$this$composed");
                ((p)l0).a0(0x1FF03545);
                w0.h h0 = (w0.h)((p)l0).k(k0.i);
                m m0 = ((p)l0).N();
                if(m0 == androidx.compose.runtime.k.a) {
                    m0 = androidx.appcompat.app.o.d(((p)l0));
                }
                i i0 = new i(this.c);
                com.iloen.melon.player.playlist.drawernew.composable.DrawerAlyacListKt.DrawerAlyacList.lambda.6.lambda.5.lambda.4..inlined.noRippleClickable-YQRRFTQ.default.1.1 drawerAlyacListKt$DrawerAlyacList$lambda$6$lambda$5$lambda$4$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        w0.h.a(this.d);
                        if(!this.e) {
                            this.f.invoke(this.d);
                        }
                    }
                };
                q q1 = androidx.compose.foundation.q.l(q0, m0, null, this.a, this.b, i0, drawerAlyacListKt$DrawerAlyacList$lambda$6$lambda$5$lambda$4$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                ((p)l0).p(false);
                return q1;
            }
        }

    }
}

