package U8;

import Ac.F;
import Ac.K;
import Ld.p;
import M.v;
import O.j;
import O.w;
import P.i;
import androidx.compose.runtime.b0;
import com.iloen.melon.playback.Playable;
import d9.h;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import m0.b;
import qd.J;
import we.k;

public final class f implements k {
    public final int a;
    public final List b;
    public final k c;
    public final Object d;
    public final boolean e;
    public final int f;
    public final Object g;

    public f(h h0, List list0, J j0, int v, boolean z, k k0) {
        this.a = 2;
        super();
        this.g = h0;
        this.b = list0;
        this.d = j0;
        this.f = v;
        this.e = z;
        this.c = k0;
    }

    public f(List list0, int v, b0 b00, k k0, k k1, boolean z) {
        this.a = 0;
        super();
        this.b = list0;
        this.f = v;
        this.g = b00;
        this.c = k0;
        this.d = k1;
        this.e = z;
    }

    public f(List list0, k k0, k k1, boolean z, v v0, int v1) {
        this.a = 1;
        super();
        this.b = list0;
        this.c = k0;
        this.d = k1;
        this.e = z;
        this.g = v0;
        this.f = v1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                p p0 = new p(20, new F(26), this.b);
                K k0 = new K(this.b, 21);
                b b1 = new b(0xBEF78951, new U8.k(this.b, this.f, ((b0)this.g), this.c, ((k)this.d), this.e), true);
                ((j)(((w)object0))).u(this.b.size(), p0, k0, b1);
                return H.a;
            }
            case 1: {
                q.g(((P.v)object0), "$this$MelonLazyVerticalGrid");
                com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.lambda.15.lambda.14.lambda.13.lambda.12..inlined.itemsIndexed.default.3 drawerPlytListKt$DrawerPlytPlyt$lambda$15$lambda$14$lambda$13$lambda$12$$inlined$itemsIndexed$default$30 = new com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.lambda.15.lambda.14.lambda.13.lambda.12..inlined.itemsIndexed.default.3(this.b);
                b b2 = new b(0x49456F69, new com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.lambda.15.lambda.14.lambda.13.lambda.12..inlined.itemsIndexed.default.4(this.b, this.c, ((k)this.d), this.e, ((v)this.g), this.f), true);
                ((i)(((P.v)object0))).t(this.b.size(), null, null, drawerPlytListKt$DrawerPlytPlyt$lambda$15$lambda$14$lambda$13$lambda$12$$inlined$itemsIndexed$default$30, b2);
                return H.a;
            }
            default: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                Playable playable0 = ((h)this.g).m;
                hd.w w0 = new hd.w(this.b, 11);
                b b0 = new b(0xBEF78951, new qd.H(this.b, ((J)this.d), this.f, (playable0 == null ? -1L : playable0.getDurationLimit()), this.e, this.c), true);
                ((j)(((w)object0))).u(this.b.size(), null, w0, b0);
                return H.a;
            }
        }
    }
}

