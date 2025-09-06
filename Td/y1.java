package td;

import Bd.e;
import F.S;
import F.X;
import F.Y;
import G.f;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.ui.playermusic.PlayerMoreView;
import ie.H;
import m0.b;
import m0.c;
import we.n;

public final class y1 implements n {
    public final int a;
    public final PlayerMoreView b;

    public y1(PlayerMoreView playerMoreView0) {
        this.a = 1;
        super();
        this.b = playerMoreView0;
    }

    public y1(PlayerMoreView playerMoreView0, int v) {
        this.a = 0;
        super();
        this.b = playerMoreView0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        H h0 = H.a;
        PlayerMoreView playerMoreView0 = this.b;
        if(this.a != 0) {
            int v = (int)(((Integer)object1));
            if(((p)(((l)object0))).Q(1 & v, (v & 3) != 2)) {
                boolean z = ((Boolean)((O0)playerMoreView0.D).getValue()).booleanValue();
                X x0 = S.b(f.r(200, 0, null, 6), 2);
                b b0 = c.e(0x66EDF76B, ((p)(((l)object0))), new e(playerMoreView0, 24));
                androidx.compose.animation.b.d(z, null, x0, Y.b, null, b0, ((p)(((l)object0))), 0x30180, 18);
                return h0;
            }
            ((p)(((l)object0))).T();
            return h0;
        }
        ((Integer)object1).getClass();
        playerMoreView0.g(((l)object0), 1);
        return h0;
    }
}

